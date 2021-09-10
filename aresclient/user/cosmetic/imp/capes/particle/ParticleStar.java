package com.aresclient.user.cosmetic.imp.capes.particle;

import java.beans.ConstructorProperties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ParticleStar {
   private double y;
   private long timestampSpawned;
   private double x;
   private static final long FADE_TIME = 250000L;

   @ConstructorProperties({"x", "y", "timestampSpawned"})
   public ParticleStar(double var1, double var3, long var5) {
      this.x = var1;
      this.y = var3;
      this.timestampSpawned = var5;
   }

   public boolean isFadedOut() {
      return System.currentTimeMillis() - this.timestampSpawned > 2500L;
   }

   public void render() {
      double var1 = (double)(this.timestampSpawned - System.currentTimeMillis()) / 30000.0D;
      double var3 = var1 / 2.0D;
      GL11.glColor4f(255.0F, 255.0F, 255.0F, 255.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("Ares/Capes/Star/star.png"));
      this.drawTexture(this.x - var3, this.y - var3, 0.0D, 0.0D, 255.0D, 255.0D, var1, var1, 1.2F);
   }

   private void drawUVTexture(double var1, double var3, double var5, double var7, double var9, double var11) {
      float var13 = 0.00390625F;
      float var14 = 0.00390625F;
      byte var15 = 25;
      Tessellator var16 = Tessellator.getInstance();
      WorldRenderer var17 = var16.getWorldRenderer();
      var17.begin(7, DefaultVertexFormats.POSITION_TEX_NORMAL);
      var17.pos(var1 + 0.0D, var3 + var11, (double)var15).tex((double)((float)(var5 + 0.0D) * 0.00390625F), (double)((float)(var7 + var11) * 0.00390625F)).endVertex();
      var17.pos(var1 + var9, var3 + var11, (double)var15).tex((double)((float)(var5 + var9) * 0.00390625F), (double)((float)(var7 + var11) * 0.00390625F)).endVertex();
      var17.pos(var1 + var9, var3 + 0.0D, (double)var15).tex((double)((float)(var5 + var9) * 0.00390625F), (double)((float)(var7 + 0.0D) * 0.00390625F)).endVertex();
      var17.pos(var1 + 0.0D, var3 + 0.0D, (double)var15).tex((double)((float)(var5 + 0.0D) * 0.00390625F), (double)((float)(var7 + 0.0D) * 0.00390625F)).endVertex();
      var16.draw();
   }

   public void drawTexture(double var1, double var3, double var5, double var7, double var9, double var11, double var13, double var15, float var17) {
      GL11.glPushMatrix();
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      double var18 = var13 / var9;
      double var20 = var15 / var11;
      GL11.glScaled(var18, var20, 0.0D);
      this.drawUVTexture(var1 / var18, var3 / var20, var5, var7, var1 / var18 + var9 - var1 / var18, var3 / var20 + var11 - var3 / var20);
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }
}
