package net.minecraft.client.gui;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;

public class Gui {
   public static final ResourceLocation statIcons = new ResourceLocation("textures/gui/container/stats_icons.png");
   public static final ResourceLocation optionsBackground = new ResourceLocation("textures/gui/options_background.png");
   protected static float zLevel;
   public static final ResourceLocation icons = new ResourceLocation("textures/gui/icons.png");

   public static void drawRect(int var0, int var1, int var2, int var3, int var4) {
      int var5;
      if (var0 < var2) {
         var5 = var0;
         var0 = var2;
         var2 = var5;
      }

      if (var1 < var3) {
         var5 = var1;
         var1 = var3;
         var3 = var5;
      }

      float var11 = (float)(var4 >> 24 & 255) / 255.0F;
      float var6 = (float)(var4 >> 16 & 255) / 255.0F;
      float var7 = (float)(var4 >> 8 & 255) / 255.0F;
      float var8 = (float)(var4 & 255) / 255.0F;
      Tessellator var9 = Tessellator.getInstance();
      WorldRenderer var10 = var9.getWorldRenderer();
      GlStateManager.enableBlend();
      GlStateManager.disableTexture2D();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.color(var6, var7, var8, var11);
      var10.begin(7, DefaultVertexFormats.POSITION);
      var10.pos((double)var0, (double)var3, 0.0D).endVertex();
      var10.pos((double)var2, (double)var3, 0.0D).endVertex();
      var10.pos((double)var2, (double)var1, 0.0D).endVertex();
      var10.pos((double)var0, (double)var1, 0.0D).endVertex();
      var9.draw();
      GlStateManager.enableTexture2D();
      GlStateManager.disableBlend();
   }

   public static void drawModalRectWithCustomSizedTexture(int var0, int var1, float var2, float var3, int var4, int var5, float var6, float var7) {
      float var8 = 1.0F / var6;
      float var9 = 1.0F / var7;
      Tessellator var10 = Tessellator.getInstance();
      WorldRenderer var11 = var10.getWorldRenderer();
      var11.begin(7, DefaultVertexFormats.POSITION_TEX);
      var11.pos((double)var0, (double)(var1 + var5), 0.0D).tex((double)(var2 * var8), (double)((var3 + (float)var5) * var9)).endVertex();
      var11.pos((double)(var0 + var4), (double)(var1 + var5), 0.0D).tex((double)((var2 + (float)var4) * var8), (double)((var3 + (float)var5) * var9)).endVertex();
      var11.pos((double)(var0 + var4), (double)var1, 0.0D).tex((double)((var2 + (float)var4) * var8), (double)(var3 * var9)).endVertex();
      var11.pos((double)var0, (double)var1, 0.0D).tex((double)(var2 * var8), (double)(var3 * var9)).endVertex();
      var10.draw();
   }

   public static void drawScaledCustomSizeModalRect(int var0, int var1, float var2, float var3, int var4, int var5, int var6, int var7, float var8, float var9) {
      float var10 = 1.0F / var8;
      float var11 = 1.0F / var9;
      Tessellator var12 = Tessellator.getInstance();
      WorldRenderer var13 = var12.getWorldRenderer();
      var13.begin(7, DefaultVertexFormats.POSITION_TEX);
      var13.pos((double)var0, (double)(var1 + var7), 0.0D).tex((double)(var2 * var10), (double)((var3 + (float)var5) * var11)).endVertex();
      var13.pos((double)(var0 + var6), (double)(var1 + var7), 0.0D).tex((double)((var2 + (float)var4) * var10), (double)((var3 + (float)var5) * var11)).endVertex();
      var13.pos((double)(var0 + var6), (double)var1, 0.0D).tex((double)((var2 + (float)var4) * var10), (double)(var3 * var11)).endVertex();
      var13.pos((double)var0, (double)var1, 0.0D).tex((double)(var2 * var10), (double)(var3 * var11)).endVertex();
      var12.draw();
   }

   public static void drawTexturedModalRect(int var0, int var1, int var2, int var3, int var4, int var5) {
      float var6 = 0.00390625F;
      float var7 = 0.00390625F;
      Tessellator var8 = Tessellator.getInstance();
      WorldRenderer var9 = var8.getWorldRenderer();
      var9.begin(7, DefaultVertexFormats.POSITION_TEX);
      var9.pos((double)var0, (double)(var1 + var5), (double)zLevel).tex((double)((float)var2 * var6), (double)((float)(var3 + var5) * var7)).endVertex();
      var9.pos((double)(var0 + var4), (double)(var1 + var5), (double)zLevel).tex((double)((float)(var2 + var4) * var6), (double)((float)(var3 + var5) * var7)).endVertex();
      var9.pos((double)(var0 + var4), (double)var1, (double)zLevel).tex((double)((float)(var2 + var4) * var6), (double)((float)var3 * var7)).endVertex();
      var9.pos((double)var0, (double)var1, (double)zLevel).tex((double)((float)var2 * var6), (double)((float)var3 * var7)).endVertex();
      var8.draw();
   }

   public void drawTexturedModalRect(float var1, float var2, int var3, int var4, int var5, int var6) {
      float var7 = 0.00390625F;
      float var8 = 0.00390625F;
      Tessellator var9 = Tessellator.getInstance();
      WorldRenderer var10 = var9.getWorldRenderer();
      var10.begin(7, DefaultVertexFormats.POSITION_TEX);
      var10.pos((double)(var1 + 0.0F), (double)(var2 + (float)var6), (double)zLevel).tex((double)((float)var3 * var7), (double)((float)(var4 + var6) * var8)).endVertex();
      var10.pos((double)(var1 + (float)var5), (double)(var2 + (float)var6), (double)zLevel).tex((double)((float)(var3 + var5) * var7), (double)((float)(var4 + var6) * var8)).endVertex();
      var10.pos((double)(var1 + (float)var5), (double)(var2 + 0.0F), (double)zLevel).tex((double)((float)(var3 + var5) * var7), (double)((float)var4 * var8)).endVertex();
      var10.pos((double)(var1 + 0.0F), (double)(var2 + 0.0F), (double)zLevel).tex((double)((float)var3 * var7), (double)((float)var4 * var8)).endVertex();
      var9.draw();
   }

   public void drawTexturedModalRect(int var1, int var2, TextureAtlasSprite var3, int var4, int var5) {
      Tessellator var6 = Tessellator.getInstance();
      WorldRenderer var7 = var6.getWorldRenderer();
      var7.begin(7, DefaultVertexFormats.POSITION_TEX);
      var7.pos((double)var1, (double)(var2 + var5), (double)zLevel).tex((double)var3.getMinU(), (double)var3.getMaxV()).endVertex();
      var7.pos((double)(var1 + var4), (double)(var2 + var5), (double)zLevel).tex((double)var3.getMaxU(), (double)var3.getMaxV()).endVertex();
      var7.pos((double)(var1 + var4), (double)var2, (double)zLevel).tex((double)var3.getMaxU(), (double)var3.getMinV()).endVertex();
      var7.pos((double)var1, (double)var2, (double)zLevel).tex((double)var3.getMinU(), (double)var3.getMinV()).endVertex();
      var6.draw();
   }

   protected void drawGradientRect(int var1, int var2, int var3, int var4, int var5, int var6) {
      float var7 = (float)(var5 >> 24 & 255) / 255.0F;
      float var8 = (float)(var5 >> 16 & 255) / 255.0F;
      float var9 = (float)(var5 >> 8 & 255) / 255.0F;
      float var10 = (float)(var5 & 255) / 255.0F;
      float var11 = (float)(var6 >> 24 & 255) / 255.0F;
      float var12 = (float)(var6 >> 16 & 255) / 255.0F;
      float var13 = (float)(var6 >> 8 & 255) / 255.0F;
      float var14 = (float)(var6 & 255) / 255.0F;
      GlStateManager.disableTexture2D();
      GlStateManager.enableBlend();
      GlStateManager.disableAlpha();
      GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
      GlStateManager.shadeModel(7425);
      Tessellator var15 = Tessellator.getInstance();
      WorldRenderer var16 = var15.getWorldRenderer();
      var16.begin(7, DefaultVertexFormats.POSITION_COLOR);
      var16.pos((double)var3, (double)var2, (double)zLevel).color(var8, var9, var10, var7).endVertex();
      var16.pos((double)var1, (double)var2, (double)zLevel).color(var8, var9, var10, var7).endVertex();
      var16.pos((double)var1, (double)var4, (double)zLevel).color(var12, var13, var14, var11).endVertex();
      var16.pos((double)var3, (double)var4, (double)zLevel).color(var12, var13, var14, var11).endVertex();
      var15.draw();
      GlStateManager.shadeModel(7424);
      GlStateManager.disableBlend();
      GlStateManager.enableAlpha();
      GlStateManager.enableTexture2D();
   }

   public void drawVerticalLine(int var1, int var2, int var3, int var4) {
      if (var3 < var2) {
         int var5 = var2;
         var2 = var3;
         var3 = var5;
      }

      drawRect(var1, var2 + 1, var1 + 1, var3, var4);
   }

   public void drawHorizontalLine(int var1, int var2, int var3, int var4) {
      if (var2 < var1) {
         int var5 = var1;
         var1 = var2;
         var2 = var5;
      }

      drawRect(var1, var3, var2 + 1, var3 + 1, var4);
   }

   public void drawCenteredString(FontRenderer var1, String var2, int var3, int var4, int var5) {
      var1.drawStringWithShadow(var2, (float)(var3 - var1.getStringWidth(var2) / 2), (float)var4, var5);
   }

   public void drawString(FontRenderer var1, String var2, int var3, int var4, int var5) {
      var1.drawStringWithShadow(var2, (float)var3, (float)var4, var5);
   }
}
