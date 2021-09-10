package net.minecraft.client.renderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import org.apache.commons.io.FileUtils;

public class CapeThreadDownload extends SimpleTexture {
   private Thread imageThread;
   public boolean pipeline = false;
   public Boolean imageFound = null;
   private CapeCallback callBack;
   private final String imageUrl;
   private boolean textureUploaded;
   private static final AtomicInteger threadDownloadCounter = new AtomicInteger(0);
   private final File cacheFile;
   private ResourceLocation resourceLocation;
   private BufferedImage bufferedImage;
   private static final String __OBFID = "CL_00001049";
   private final IImageBuffer imageBuffer;

   public void setBufferedImage(BufferedImage var1) {
      this.bufferedImage = var1;
      if (this.imageBuffer != null) {
         this.imageBuffer.skinAvailable();
      }

      this.imageFound = this.bufferedImage != null;
   }

   public int getGlTextureId() {
      this.checkTextureUploaded();
      return super.getGlTextureId();
   }

   static String access$0(CapeThreadDownload var0) {
      return var0.imageUrl;
   }

   static File access$1(CapeThreadDownload var0) {
      return var0.cacheFile;
   }

   static CapeCallback access$3(CapeThreadDownload var0) {
      return var0.callBack;
   }

   static IImageBuffer access$5(CapeThreadDownload var0) {
      return var0.imageBuffer;
   }

   private void checkTextureUploaded() {
      if (!this.textureUploaded && this.bufferedImage != null) {
         this.textureUploaded = true;
         if (this.textureLocation != null) {
            this.deleteGlTexture();
         }

         TextureUtil.uploadTextureImage(super.getGlTextureId(), this.bufferedImage);
      }

   }

   public void loadTexture(IResourceManager var1) throws IOException {
      if (this.bufferedImage == null && this.textureLocation != null) {
         super.loadTexture(var1);
      }

      if (this.imageThread == null) {
         if (this.cacheFile != null && this.cacheFile.isFile()) {
            try {
               this.bufferedImage = ImageIO.read(this.cacheFile);
               if (this.imageBuffer != null) {
                  this.setBufferedImage(this.imageBuffer.parseUserSkin(this.bufferedImage));
               }

               this.imageFound = this.bufferedImage != null;
            } catch (IOException var3) {
               this.loadTextureFromServer();
            }
         } else {
            this.loadTextureFromServer();
         }
      }

   }

   public CapeThreadDownload(File var1, String var2, ResourceLocation var3, IImageBuffer var4, CapeCallback var5) {
      super((ResourceLocation)null);
      this.cacheFile = var1;
      this.imageUrl = var2;
      this.imageBuffer = var4;
      this.callBack = var5;
      this.resourceLocation = var3;
   }

   protected void loadTextureFromServer() {
      this.imageThread = new Thread(this, "Texture Downloader #" + threadDownloadCounter.incrementAndGet()) {
         private static final String __OBFID = "CL_00001050";
         final CapeThreadDownload this$0;

         {
            this.this$0 = var1;
         }

         public void run() {
            HttpURLConnection var1 = null;
            System.out.println("Downloading http texture from " + CapeThreadDownload.access$0(this.this$0) + " to " + CapeThreadDownload.access$1(this.this$0));

            try {
               var1 = (HttpURLConnection)(new URL(CapeThreadDownload.access$0(this.this$0))).openConnection(Minecraft.getMinecraft().getProxy());
               var1.setDoInput(true);
               var1.setDoOutput(false);
               var1.connect();
               if (var1.getResponseCode() / 100 == 2) {
                  BufferedImage var2;
                  if (CapeThreadDownload.access$1(this.this$0) != null) {
                     FileUtils.copyInputStreamToFile(var1.getInputStream(), CapeThreadDownload.access$1(this.this$0));
                     var2 = ImageIO.read(CapeThreadDownload.access$1(this.this$0));
                  } else {
                     var2 = TextureUtil.readBufferedImage(var1.getInputStream());
                  }

                  if (CapeThreadDownload.access$5(this.this$0) != null) {
                     var2 = CapeThreadDownload.access$5(this.this$0).parseUserSkin(var2);
                  }

                  this.this$0.setBufferedImage(var2);
               } else if (var1.getErrorStream() != null) {
                  System.out.println(var1.getErrorStream().toString());
               }
            } catch (Exception var6) {
               System.out.println("Couldn't download http texture: " + var6.getClass().getName() + ": " + var6.getMessage());
            } finally {
               if (var1 != null) {
                  var1.disconnect();
               }

               this.this$0.imageFound = CapeThreadDownload.access$2(this.this$0) != null;
               if (this.this$0.imageFound) {
                  CapeThreadDownload.access$3(this.this$0).done();
               } else {
                  CapeThreadDownload.access$3(this.this$0).failed("Texture not found");
                  Minecraft.getMinecraft().getTextureManager().mapTextureObjects.remove(CapeThreadDownload.access$4(this.this$0));
               }

            }

         }
      };
      this.imageThread.start();
   }

   static BufferedImage access$2(CapeThreadDownload var0) {
      return var0.bufferedImage;
   }

   static ResourceLocation access$4(CapeThreadDownload var0) {
      return var0.resourceLocation;
   }
}
