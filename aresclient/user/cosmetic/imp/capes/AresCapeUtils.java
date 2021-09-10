package com.aresclient.user.cosmetic.imp.capes;

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
import net.optifine.player.CapeImageBuffer;

public class AresCapeUtils {
   private static final Pattern PATTERN_USERNAME = Pattern.compile("[a-zA-Z0-9_]+");

   public static boolean isElytraCape(BufferedImage var0, BufferedImage var1) {
      return var0.getWidth() > var1.getHeight();
   }

   public static void downloadCape(AbstractClientPlayer var0) {
      String var1 = var0.getNameClear();
      String var2 = var0.getUniqueID().toString();
      if (var1 != null && !var1.isEmpty() && !var1.contains("\u0000") && PATTERN_USERNAME.matcher(var1).matches()) {
         String var3 = "http://136.243.26.242/dl/arescapes/" + var2;
         System.out.println(var3);
         ResourceLocation var4 = new ResourceLocation("capeares/" + var1);
         TextureManager var5 = Minecraft.getMinecraft().getTextureManager();
         ITextureObject var6 = var5.getTexture(var4);
         if (var6 != null && var6 instanceof ThreadDownloadImageData) {
            ThreadDownloadImageData var7 = (ThreadDownloadImageData)var6;
            if (var7.imageFound != null) {
               if (var7.imageFound) {
                  var0.setLocationOfAresCape(var4);
                  System.out.println(var4.getResourceDomain());
                  if (var7.getImageBuffer() instanceof CapeImageBuffer) {
                     CapeImageBuffer var10 = (CapeImageBuffer)var7.getImageBuffer();
                     var0.setElytraOfCape(var10.isElytraOfCape());
                  }
               }

               return;
            }
         }

         AresCapeImageBuffer var9 = new AresCapeImageBuffer(var0, var4);
         ThreadDownloadImageData var8 = new ThreadDownloadImageData((File)null, var3, (ResourceLocation)null, var9);
         var8.pipeline = true;
         var5.loadTexture(var4, var8);
      }

   }

   public static void reloadCape(AbstractClientPlayer var0) {
      String var1 = var0.getNameClear();
      ResourceLocation var2 = new ResourceLocation("capeares/" + var1);
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
}
