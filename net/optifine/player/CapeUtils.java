package net.optifine.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;

public class CapeUtils {
   private static final Pattern PATTERN_USERNAME = Pattern.compile("[a-zA-Z0-9_]+");

   public static void reloadCape(AbstractClientPlayer var0) {
      String var1 = var0.getNameClear();
      ResourceLocation var2 = new ResourceLocation("capeof/" + var1);
      TextureManager var3 = Config.getTextureManager();
      ITextureObject var4 = var3.getTexture(var2);
      if (var4 instanceof SimpleTexture) {
         SimpleTexture var5 = (SimpleTexture)var4;
         var5.deleteGlTexture();
         var3.deleteTexture(var2);
      }

      var0.setLocationOfCape((ResourceLocation)null);
      var0.setElytraOfCape(false);
      downloadCape(var0);
   }

   public static BufferedImage parseCape(BufferedImage var0) {
      int var1 = 64;
      int var2 = 32;
      int var3 = var0.getWidth();

      for(int var4 = var0.getHeight(); var1 < var3 || var2 < var4; var2 *= 2) {
         var1 *= 2;
      }

      BufferedImage var6 = new BufferedImage(var1, var2, 2);
      Graphics var5 = var6.getGraphics();
      var5.drawImage(var0, 0, 0, (ImageObserver)null);
      var5.dispose();
      return var6;
   }

   public static boolean isElytraCape(BufferedImage var0, BufferedImage var1) {
      return var0.getWidth() > var1.getHeight();
   }

   public static void downloadCape(AbstractClientPlayer var0) {
      String var1 = var0.getNameClear();
      if (var1 != null && !var1.isEmpty() && !var1.contains("\u0000") && PATTERN_USERNAME.matcher(var1).matches()) {
         String var2 = "http://s.optifine.net/capes/" + var1 + ".png";
         ResourceLocation var3 = new ResourceLocation("capeof/" + var1);
         TextureManager var4 = Minecraft.getMinecraft().getTextureManager();
         ITextureObject var5 = var4.getTexture(var3);
         if (var5 != null && var5 instanceof ThreadDownloadImageData) {
            ThreadDownloadImageData var6 = (ThreadDownloadImageData)var5;
            if (var6.imageFound != null) {
               if (var6.imageFound) {
                  var0.setLocationOfOptifineCape(var3);
                  if (var6.getImageBuffer() instanceof CapeImageBuffer) {
                     CapeImageBuffer var9 = (CapeImageBuffer)var6.getImageBuffer();
                     var0.setElytraOfCape(var9.isElytraOfCape());
                  }
               }

               return;
            }
         }

         CapeImageBuffer var8 = new CapeImageBuffer(var0, var3);
         ThreadDownloadImageData var7 = new ThreadDownloadImageData((File)null, var2, (ResourceLocation)null, var8);
         var7.pipeline = true;
         var4.loadTexture(var3, var7);
      }

   }
}
