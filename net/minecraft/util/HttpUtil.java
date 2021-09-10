package net.minecraft.util;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.ServerSocket;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpUtil {
   public static final ListeningExecutorService field_180193_a = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool((new ThreadFactoryBuilder()).setDaemon(true).setNameFormat("Downloader %d").build()));
   private static final Logger logger = LogManager.getLogger();
   private static final AtomicInteger downloadThreadsStarted = new AtomicInteger(0);

   private static String post(URL var0, String var1, boolean var2) {
      try {
         Proxy var3 = MinecraftServer.getServer() == null ? null : MinecraftServer.getServer().getServerProxy();
         if (var3 == null) {
            var3 = Proxy.NO_PROXY;
         }

         HttpURLConnection var4 = (HttpURLConnection)var0.openConnection(var3);
         var4.setRequestMethod("POST");
         var4.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
         var4.setRequestProperty("Content-Length", "" + var1.getBytes().length);
         var4.setRequestProperty("Content-Language", "en-US");
         var4.setUseCaches(false);
         var4.setDoInput(true);
         var4.setDoOutput(true);
         DataOutputStream var5 = new DataOutputStream(var4.getOutputStream());
         var5.writeBytes(var1);
         var5.flush();
         var5.close();
         BufferedReader var6 = new BufferedReader(new InputStreamReader(var4.getInputStream()));
         StringBuffer var7 = new StringBuffer();

         String var8;
         while((var8 = var6.readLine()) != null) {
            var7.append(var8);
            var7.append('\r');
         }

         var6.close();
         return var7.toString();
      } catch (Exception var9) {
         if (!var2) {
            logger.error("Could not post to " + var0, var9);
         }

         return "";
      }
   }

   public static String get(URL var0) throws IOException {
      HttpURLConnection var1 = (HttpURLConnection)var0.openConnection();
      var1.setRequestMethod("GET");
      BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.getInputStream()));
      StringBuilder var3 = new StringBuilder();

      String var4;
      while((var4 = var2.readLine()) != null) {
         var3.append(var4);
         var3.append('\r');
      }

      var2.close();
      return var3.toString();
   }

   public static int getSuitableLanPort() throws IOException {
      ServerSocket var0 = null;
      boolean var1 = true;

      int var9;
      try {
         var0 = new ServerSocket(0);
         var9 = var0.getLocalPort();
      } finally {
         try {
            if (var0 != null) {
               var0.close();
            }
         } catch (IOException var7) {
         }

      }

      return var9;
   }

   static Logger access$0() {
      return logger;
   }

   public static String postMap(URL var0, Map<String, Object> var1, boolean var2) {
      return post(var0, buildPostString(var1), var2);
   }

   public static String buildPostString(Map<String, Object> var0) {
      StringBuilder var1 = new StringBuilder();
      Iterator var3 = var0.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var2 = (Entry)var3.next();
         if (var1.length() > 0) {
            var1.append('&');
         }

         try {
            var1.append(URLEncoder.encode((String)var2.getKey(), "UTF-8"));
         } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
         }

         if (var2.getValue() != null) {
            var1.append('=');

            try {
               var1.append(URLEncoder.encode(var2.getValue().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
               var5.printStackTrace();
            }
         }
      }

      return var1.toString();
   }

   public static ListenableFuture<Object> downloadResourcePack(File var0, String var1, Map<String, String> var2, int var3, IProgressUpdate var4, Proxy var5) {
      ListenableFuture var6 = field_180193_a.submit(new Runnable(var4, var1, var5, var2, var0, var3) {
         private final String val$packUrl;
         private final Proxy val$p_180192_5_;
         private final File val$saveFile;
         private final int val$maxSize;
         private final IProgressUpdate val$p_180192_4_;
         private final Map val$p_180192_2_;

         public void run() {
            HttpURLConnection var1 = null;
            InputStream var2 = null;
            DataOutputStream var3 = null;
            if (this.val$p_180192_4_ != null) {
               this.val$p_180192_4_.resetProgressAndMessage("Downloading Resource Pack");
               this.val$p_180192_4_.displayLoadingString("Making Request...");
            }

            try {
               byte[] var4 = new byte[4096];
               URL var18 = new URL(this.val$packUrl);
               var1 = (HttpURLConnection)var18.openConnection(this.val$p_180192_5_);
               float var6 = 0.0F;
               float var7 = (float)this.val$p_180192_2_.entrySet().size();
               Iterator var9 = this.val$p_180192_2_.entrySet().iterator();

               while(var9.hasNext()) {
                  Entry var8 = (Entry)var9.next();
                  var1.setRequestProperty((String)var8.getKey(), (String)var8.getValue());
                  if (this.val$p_180192_4_ != null) {
                     this.val$p_180192_4_.setLoadingProgress((int)(++var6 / var7 * 100.0F));
                  }
               }

               var2 = var1.getInputStream();
               var7 = (float)var1.getContentLength();
               int var19 = var1.getContentLength();
               if (this.val$p_180192_4_ != null) {
                  this.val$p_180192_4_.displayLoadingString(String.format("Downloading file (%.2f MB)...", var7 / 1000.0F / 1000.0F));
               }

               if (this.val$saveFile.exists()) {
                  long var20 = this.val$saveFile.length();
                  if (var20 == (long)var19) {
                     if (this.val$p_180192_4_ != null) {
                        this.val$p_180192_4_.setDoneWorking();
                     }

                     return;
                  }

                  HttpUtil.access$0().warn("Deleting " + this.val$saveFile + " as it does not match what we currently have (" + var19 + " vs our " + var20 + ").");
                  FileUtils.deleteQuietly(this.val$saveFile);
               } else if (this.val$saveFile.getParentFile() != null) {
                  this.val$saveFile.getParentFile().mkdirs();
               }

               var3 = new DataOutputStream(new FileOutputStream(this.val$saveFile));
               if (this.val$maxSize > 0 && var7 > (float)this.val$maxSize) {
                  if (this.val$p_180192_4_ != null) {
                     this.val$p_180192_4_.setDoneWorking();
                  }

                  throw new IOException("Filesize is bigger than maximum allowed (file is " + var6 + ", limit is " + this.val$maxSize + ")");
               }

               boolean var21 = false;

               while(true) {
                  int var22;
                  if ((var22 = var2.read(var4)) < 0) {
                     if (this.val$p_180192_4_ != null) {
                        this.val$p_180192_4_.setDoneWorking();
                        return;
                     }

                     return;
                  }

                  var6 += (float)var22;
                  if (this.val$p_180192_4_ != null) {
                     this.val$p_180192_4_.setLoadingProgress((int)(var6 / var7 * 100.0F));
                  }

                  if (this.val$maxSize > 0 && var6 > (float)this.val$maxSize) {
                     if (this.val$p_180192_4_ != null) {
                        this.val$p_180192_4_.setDoneWorking();
                     }

                     throw new IOException("Filesize was bigger than maximum allowed (got >= " + var6 + ", limit was " + this.val$maxSize + ")");
                  }

                  if (Thread.interrupted()) {
                     HttpUtil.access$0().error("INTERRUPTED");
                     if (this.val$p_180192_4_ != null) {
                        this.val$p_180192_4_.setDoneWorking();
                     }
                     break;
                  }

                  var3.write(var4, 0, var22);
               }
            } catch (Throwable var16) {
               var16.printStackTrace();
               if (var1 != null) {
                  InputStream var5 = var1.getErrorStream();

                  try {
                     HttpUtil.access$0().error(IOUtils.toString(var5));
                  } catch (IOException var15) {
                     var15.printStackTrace();
                  }
               }

               if (this.val$p_180192_4_ != null) {
                  this.val$p_180192_4_.setDoneWorking();
                  return;
               }

               return;
            } finally {
               IOUtils.closeQuietly(var2);
               IOUtils.closeQuietly(var3);
            }

         }

         {
            this.val$p_180192_4_ = var1;
            this.val$packUrl = var2;
            this.val$p_180192_5_ = var3;
            this.val$p_180192_2_ = var4;
            this.val$saveFile = var5;
            this.val$maxSize = var6;
         }
      });
      return var6;
   }
}
