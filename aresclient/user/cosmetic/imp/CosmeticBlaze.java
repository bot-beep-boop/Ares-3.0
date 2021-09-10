package com.aresclient.user.cosmetic.imp;

import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticBlaze extends Cosmetic {
   private ModelRenderer[] blazeSticks = new ModelRenderer[12];

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (ConfigManager.settings.Blaze == 2) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/blaze/blaze" + ConfigManager.settings.BlazeTexture + ".png"));
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         this.setRotationAngles(var5);
         ModelRenderer[] var12;
         int var11 = (var12 = this.blazeSticks).length;

         for(int var10 = 0; var10 < var11; ++var10) {
            ModelRenderer var9 = var12[var10];
            var9.render(var8);
         }

         GlStateManager.popMatrix();
      }

   }

   public void setRotationAngles(float var1) {
      float var2 = var1 * 3.1415927F * -0.1F;

      int var3;
      for(var3 = 0; var3 < 4; ++var3) {
         this.blazeSticks[var3].rotationPointY = -2.0F + MathHelper.cos(((float)(var3 * 2) + var1) * 0.25F);
         this.blazeSticks[var3].rotationPointX = MathHelper.cos(var2) * 9.0F;
         this.blazeSticks[var3].rotationPointZ = MathHelper.sin(var2) * 9.0F;
         ++var2;
      }

      var2 = 0.7853982F + var1 * 3.1415927F * 0.03F;

      for(var3 = 4; var3 < 8; ++var3) {
         this.blazeSticks[var3].rotationPointY = 2.0F + MathHelper.cos(((float)(var3 * 2) + var1) * 0.25F);
         this.blazeSticks[var3].rotationPointX = MathHelper.cos(var2) * 7.0F;
         this.blazeSticks[var3].rotationPointZ = MathHelper.sin(var2) * 7.0F;
         ++var2;
      }

      var2 = 0.47123894F + var1 * 3.1415927F * -0.05F;

      for(var3 = 8; var3 < 12; ++var3) {
         this.blazeSticks[var3].rotationPointY = 11.0F + MathHelper.cos(((float)var3 * 1.5F + var1) * 0.5F);
         this.blazeSticks[var3].rotationPointX = MathHelper.cos(var2) * 5.0F;
         this.blazeSticks[var3].rotationPointZ = MathHelper.sin(var2) * 5.0F;
         ++var2;
      }

   }

   public CosmeticBlaze(RenderPlayer var1) {
      super(var1);

      for(int var2 = 0; var2 < this.blazeSticks.length; ++var2) {
         (this.blazeSticks[var2] = new ModelRenderer(this.playerModel, 0, 16)).addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
      }

   }
}
