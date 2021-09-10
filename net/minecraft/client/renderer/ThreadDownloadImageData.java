package net.minecraft.client.renderer;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.net.Proxy.Type;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.http.HttpPipeline;
import net.optifine.http.HttpRequest;
import net.optifine.http.HttpResponse;
import net.optifine.player.CapeImageBuffer;
import net.optifine.shaders.ShadersTex;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThreadDownloadImageData extends SimpleTexture {
   private BufferedImage bufferedImage;
   private boolean textureUploaded;
   private Thread imageThread;
   private final String imageUrl;
   public boolean pipeline = false;
   public Boolean imageFound = null;
   public boolean notexist = false;
   private final File cacheFile;
   private static final Logger logger = LogManager.getLogger();
   private final IImageBuffer imageBuffer;
   private static final AtomicInteger threadDownloadCounter = new AtomicInteger(0);

   static void access$4(ThreadDownloadImageData var0) {
      var0.loadPipelined();
   }

   public void loadTexture(IResourceManager var1) throws IOException {
      if (this.bufferedImage == null && this.textureLocation != null) {
         super.loadTexture(var1);
      }

      if (this.imageThread == null) {
         if (this.cacheFile != null && this.cacheFile.isFile()) {
            logger.debug("Loading http texture from local cache ({})", new Object[]{this.cacheFile});

            try {
               this.bufferedImage = ImageIO.read(this.cacheFile);
               if (this.imageBuffer != null) {
                  this.setBufferedImage(this.imageBuffer.parseUserSkin(this.bufferedImage));
               }

               this.loadingFinished();
            } catch (IOException var3) {
               this.notexist = true;
               logger.error("Couldn't load skin " + this.cacheFile, var3);
               this.loadTextureFromServer();
            }
         } else {
            this.loadTextureFromServer();
         }
      }

   }

   public int getGlTextureId() {
      this.checkTextureUploaded();
      return super.getGlTextureId();
   }

   private void checkTextureUploaded() {
      if (!this.textureUploaded && this.bufferedImage != null) {
         this.textureUploaded = true;
         if (this.textureLocation != null) {
            this.deleteGlTexture();
         }

         if (Config.isShaders()) {
            ShadersTex.loadSimpleTexture(super.getGlTextureId(), this.bufferedImage, false, false, Config.getResourceManager(), this.textureLocation, this.getMultiTexID());
         } else {
            TextureUtil.uploadTextureImage(super.getGlTextureId(), this.bufferedImage);
         }
      }

   }

   static IImageBuffer access$6(ThreadDownloadImageData var0) {
      return var0.imageBuffer;
   }

   static boolean access$3(ThreadDownloadImageData var0) {
      return var0.shouldPipeline();
   }

   public void setBufferedImage(BufferedImage var1) {
      this.bufferedImage = var1;
      if (this.imageBuffer != null) {
         this.imageBuffer.skinAvailable();
      }

      this.imageFound = this.bufferedImage != null;
   }

   static File access$2(ThreadDownloadImageData var0) {
      return var0.cacheFile;
   }

   static Logger access$0() {
      return logger;
   }

   public ThreadDownloadImageData(File var1, String var2, ResourceLocation var3, IImageBuffer var4) {
      super(var3);
      this.cacheFile = var1;
      this.imageUrl = var2;
      this.imageBuffer = var4;
   }

   public IImageBuffer getImageBuffer() {
      return this.imageBuffer;
   }

   private void loadingFinished() {
      this.imageFound = this.bufferedImage != null;
      if (this.imageBuffer instanceof CapeImageBuffer) {
         CapeImageBuffer var1 = (CapeImageBuffer)this.imageBuffer;
         var1.cleanup();
      }

   }

   static void access$5(ThreadDownloadImageData var0) {
      var0.loadingFinished();
   }

   protected void loadTextureFromServer() {
      this.imageThread = new Thread(this, "Texture Downloader #" + threadDownloadCounter.incrementAndGet()) {
         final ThreadDownloadImageData this$0;

         public void run() {
            HttpURLConnection var1 = null;
            ThreadDownloadImageData.access$0().debug("Downloading http texture from {} to {}", new Object[]{ThreadDownloadImageData.access$1(this.this$0), ThreadDownloadImageData.access$2(this.this$0)});
            if (ThreadDownloadImageData.access$3(this.this$0)) {
               ThreadDownloadImageData.access$4(this.this$0);
            } else {
               try {
                  var1 = (HttpURLConnection)(new URL(ThreadDownloadImageData.access$1(this.this$0))).openConnection(Minecraft.getMinecraft().getProxy());
                  var1.setDoInput(true);
                  var1.setDoOutput(false);
                  var1.connect();
                  if (var1.getResponseCode() / 100 == 2) {
                     BufferedImage var2;
                     if (ThreadDownloadImageData.access$2(this.this$0) != null) {
                        FileUtils.copyInputStreamToFile(var1.getInputStream(), ThreadDownloadImageData.access$2(this.this$0));
                        var2 = ImageIO.read(ThreadDownloadImageData.access$2(this.this$0));
                     } else {
                        var2 = TextureUtil.readBufferedImage(var1.getInputStream());
                     }

                     if (ThreadDownloadImageData.access$6(this.this$0) != null) {
                        var2 = ThreadDownloadImageData.access$6(this.this$0).parseUserSkin(var2);
                     }

                     this.this$0.setBufferedImage(var2);
                     return;
                  }

                  if (var1.getErrorStream() != null) {
                     Config.readAll(var1.getErrorStream());
                  }
               } catch (Exception var6) {
                  ThreadDownloadImageData.access$0().error("Couldn't download http texture: " + var6.getClass().getName() + ": " + var6.getMessage());
                  this.this$0.notexist = true;
                  return;
               } finally {
                  if (var1 != null) {
                     var1.disconnect();
                  }

                  ThreadDownloadImageData.access$5(this.this$0);
               }

            }
         }

         {
            this.this$0 = var1;
         }
      };
      this.imageThread.setDaemon(true);
      this.imageThread.start();
   }

   static String access$1(ThreadDownloadImageData var0) {
      return var0.imageUrl;
   }

   private boolean shouldPipeline() {
      if (!this.pipeline) {
         return false;
      } else {
         Proxy var1 = Minecraft.getMinecraft().getProxy();
         return var1.type() != Type.DIRECT && var1.type() != Type.SOCKS ? false : this.imageUrl.startsWith("http://");
      }
   }

   private void loadPipelined() {
      try {
         try {
            HttpRequest var1 = HttpPipeline.makeRequest(this.imageUrl, Minecraft.getMinecraft().getProxy());
            HttpResponse var2 = HttpPipeline.executeRequest(var1);
            if (var2.getStatus() / 100 != 2) {
               return;
            }

            byte[] var3 = var2.getBody();
            ByteArrayInputStream var4 = new ByteArrayInputStream(var3);
            BufferedImage var5;
            if (this.cacheFile != null) {
               FileUtils.copyInputStreamToFile(var4, this.cacheFile);
               var5 = ImageIO.read(this.cacheFile);
            } else {
               var5 = TextureUtil.readBufferedImage(var4);
            }

            if (this.imageBuffer != null) {
               var5 = this.imageBuffer.parseUserSkin(var5);
            }

            this.setBufferedImage(var5);
         } catch (Exception var9) {
            this.notexist = true;
            logger.error("Couldn't download http texture: " + var9.getClass().getName() + ": " + var9.getMessage());
            return;
         }

         this.loadingFinished();
      } finally {
         this.loadingFinished();
      }
   }
}
