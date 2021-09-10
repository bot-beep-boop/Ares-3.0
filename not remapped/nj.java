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

public class nj {
   private static final Logger c = LogManager.getLogger();
   public static final ListeningExecutorService a = MoreExecutors.listeningDecorator(Executors.newCachedThreadPool((new ThreadFactoryBuilder()).setDaemon(true).setNameFormat("Downloader %d").build()));
   private static final AtomicInteger b = new AtomicInteger(0);

   public static String a(Map<String, Object> var0) {
      StringBuilder var1 = new StringBuilder();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (var1.length() > 0) {
            var1.append('&');
         }

         try {
            var1.append(URLEncoder.encode((String)var3.getKey(), "UTF-8"));
         } catch (UnsupportedEncodingException var6) {
            var6.printStackTrace();
         }

         if (var3.getValue() != null) {
            var1.append('=');

            try {
               var1.append(URLEncoder.encode(var3.getValue().toString(), "UTF-8"));
            } catch (UnsupportedEncodingException var5) {
               var5.printStackTrace();
            }
         }
      }

      return var1.toString();
   }

   public static String a(URL var0) throws IOException {
      HttpURLConnection var1 = (HttpURLConnection)var0.openConnection();
      var1.setRequestMethod("GET");
      BufferedReader var2 = new BufferedReader(new InputStreamReader(var1.getInputStream()));
      StringBuilder var4 = new StringBuilder();

      String var3;
      while((var3 = var2.readLine()) != null) {
         var4.append(var3);
         var4.append('\r');
      }

      var2.close();
      return var4.toString();
   }

   static Logger b() {
      return c;
   }

   public static ListenableFuture<Object> a(File var0, String var1, Map<String, String> var2, int var3, nu var4, Proxy var5) {
      ListenableFuture var6 = a.submit(new Runnable(var4, var1, var5, var2, var0, var3) {
         final nu a;
         final String b;
         final Proxy c;
         final int f;
         final Map d;
         final File e;

         public void run() {
            HttpURLConnection var1 = null;
            InputStream var2 = null;
            DataOutputStream var3 = null;
            if (this.a != null) {
               this.a.b("Downloading Resource Pack");
               this.a.c("Making Request...");
            }

            try {
               byte[] var4 = new byte[4096];
               URL var18 = new URL(this.b);
               var1 = (HttpURLConnection)var18.openConnection(this.c);
               float var6 = 0.0F;
               float var7 = (float)this.d.entrySet().size();
               Iterator var8 = this.d.entrySet().iterator();

               while(var8.hasNext()) {
                  Entry var9 = (Entry)var8.next();
                  var1.setRequestProperty((String)var9.getKey(), (String)var9.getValue());
                  if (this.a != null) {
                     this.a.a((int)(++var6 / var7 * 100.0F));
                  }
               }

               var2 = var1.getInputStream();
               var7 = (float)var1.getContentLength();
               int var19 = var1.getContentLength();
               if (this.a != null) {
                  this.a.c(String.format("Downloading file (%.2f MB)...", var7 / 1000.0F / 1000.0F));
               }

               if (this.e.exists()) {
                  long var20 = this.e.length();
                  if (var20 == (long)var19) {
                     if (this.a != null) {
                        this.a.a();
                     }

                     return;
                  }

                  nj.b().warn("Deleting " + this.e + " as it does not match what we currently have (" + var19 + " vs our " + var20 + ").");
                  FileUtils.deleteQuietly(this.e);
               } else if (this.e.getParentFile() != null) {
                  this.e.getParentFile().mkdirs();
               }

               var3 = new DataOutputStream(new FileOutputStream(this.e));
               if (this.f > 0 && var7 > (float)this.f) {
                  if (this.a != null) {
                     this.a.a();
                  }

                  throw new IOException("Filesize is bigger than maximum allowed (file is " + var6 + ", limit is " + this.f + ")");
               }

               boolean var21 = false;

               while(true) {
                  int var22;
                  if ((var22 = var2.read(var4)) < 0) {
                     if (this.a != null) {
                        this.a.a();
                     }

                     return;
                  }

                  var6 += (float)var22;
                  if (this.a != null) {
                     this.a.a((int)(var6 / var7 * 100.0F));
                  }

                  if (this.f > 0 && var6 > (float)this.f) {
                     if (this.a != null) {
                        this.a.a();
                     }

                     throw new IOException("Filesize was bigger than maximum allowed (got >= " + var6 + ", limit was " + this.f + ")");
                  }

                  if (Thread.interrupted()) {
                     nj.b().error("INTERRUPTED");
                     if (this.a != null) {
                        this.a.a();
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
                     nj.b().error(IOUtils.toString(var5));
                  } catch (IOException var15) {
                     var15.printStackTrace();
                  }
               }

               if (this.a != null) {
                  this.a.a();
               }

               return;
            } finally {
               IOUtils.closeQuietly(var2);
               IOUtils.closeQuietly(var3);
            }

         }

         {
            this.a = var1;
            this.b = var2;
            this.c = var3;
            this.d = var4;
            this.e = var5;
            this.f = var6;
         }
      });
      return var6;
   }

   public static int a() throws IOException {
      ServerSocket var0 = null;
      boolean var1 = true;

      int var10;
      try {
         var0 = new ServerSocket(0);
         var10 = var0.getLocalPort();
      } finally {
         try {
            if (var0 != null) {
               var0.close();
            }
         } catch (IOException var8) {
         }

      }

      return var10;
   }

   private static String a(URL var0, String var1, boolean var2) {
      try {
         Proxy var3 = MinecraftServer.N() == null ? null : MinecraftServer.N().ay();
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
         StringBuffer var8 = new StringBuffer();

         String var7;
         while((var7 = var6.readLine()) != null) {
            var8.append(var7);
            var8.append('\r');
         }

         var6.close();
         return var8.toString();
      } catch (Exception var9) {
         if (!var2) {
            c.error("Could not post to " + var0, var9);
         }

         return "";
      }
   }

   public static String a(URL var0, Map<String, Object> var1, boolean var2) {
      return a(var0, a(var1), var2);
   }
}
