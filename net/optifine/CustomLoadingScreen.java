package net.optifine;

import java.util.Properties;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;

public class CustomLoadingScreen {
   private int scale = 2;
   private static final int SCALE_MODE_FULL = 1;
   private static final int SCALE_MODE_STRETCH = 2;
   private boolean center;
   private ResourceLocation locationTexture;
   private int scaleMode = 0;
   private static final int SCALE_DEFAULT = 2;
   private static final int SCALE_MODE_FIXED = 0;

   private static int parseScale(String var0, int var1) {
      if (var0 == null) {
         return var1;
      } else {
         var0 = var0.trim();
         int var2 = Config.parseInt(var0, -1);
         if (var2 < 1) {
            CustomLoadingScreens.warn("Invalid scale: " + var0);
            return var1;
         } else {
            return var2;
         }
      }
   }

   public static CustomLoadingScreen parseScreen(String var0, int var1, Properties var2) {
      ResourceLocation var3 = new ResourceLocation(var0);
      int var4 = parseScaleMode(getProperty("scaleMode", var1, var2));
      int var5 = var4 == 0 ? 2 : 1;
      int var6 = parseScale(getProperty("scale", var1, var2), var5);
      boolean var7 = Config.parseBoolean(getProperty("center", var1, var2), false);
      CustomLoadingScreen var8 = new CustomLoadingScreen(var3, var4, var6, var7);
      return var8;
   }

   private static int parseScaleMode(String var0) {
      if (var0 == null) {
         return 0;
      } else {
         var0 = var0.toLowerCase().trim();
         if (var0.equals("fixed")) {
            return 0;
         } else if (var0.equals("full")) {
            return 1;
         } else if (var0.equals("stretch")) {
            return 2;
         } else {
            CustomLoadingScreens.warn("Invalid scale mode: " + var0);
            return 0;
         }
      }
   }

   public void drawBackground(int var1, int var2) {
      GlStateManager.disableLighting();
      GlStateManager.disableFog();
      Tessellator var3 = Tessellator.getInstance();
      WorldRenderer var4 = var3.getWorldRenderer();
      Config.getTextureManager().bindTexture(this.locationTexture);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      double var5 = (double)(16 * this.scale);
      double var7 = (double)var1 / var5;
      double var9 = (double)var2 / var5;
      double var11 = 0.0D;
      double var13 = 0.0D;
      if (this.center) {
         var11 = (var5 - (double)var1) / (var5 * 2.0D);
         var13 = (var5 - (double)var2) / (var5 * 2.0D);
      }

      switch(this.scaleMode) {
      case 1:
         var5 = (double)Math.max(var1, var2);
         var7 = (double)(this.scale * var1) / var5;
         var9 = (double)(this.scale * var2) / var5;
         if (this.center) {
            var11 = (double)this.scale * (var5 - (double)var1) / (var5 * 2.0D);
            var13 = (double)this.scale * (var5 - (double)var2) / (var5 * 2.0D);
         }
         break;
      case 2:
         var7 = (double)this.scale;
         var9 = (double)this.scale;
         var11 = 0.0D;
         var13 = 0.0D;
      }

      var4.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
      var4.pos(0.0D, (double)var2, 0.0D).tex(var11, var13 + var9).color(255, 255, 255, 255).endVertex();
      var4.pos((double)var1, (double)var2, 0.0D).tex(var11 + var7, var13 + var9).color(255, 255, 255, 255).endVertex();
      var4.pos((double)var1, 0.0D, 0.0D).tex(var11 + var7, var13).color(255, 255, 255, 255).endVertex();
      var4.pos(0.0D, 0.0D, 0.0D).tex(var11, var13).color(255, 255, 255, 255).endVertex();
      var3.draw();
   }

   public CustomLoadingScreen(ResourceLocation var1, int var2, int var3, boolean var4) {
      this.locationTexture = var1;
      this.scaleMode = var2;
      this.scale = var3;
      this.center = var4;
   }

   private static String getProperty(String var0, int var1, Properties var2) {
      if (var2 == null) {
         return null;
      } else {
         String var3 = var2.getProperty("dim" + var1 + "." + var0);
         if (var3 != null) {
            return var3;
         } else {
            var3 = var2.getProperty(var0);
            return var3;
         }
      }
   }
}
