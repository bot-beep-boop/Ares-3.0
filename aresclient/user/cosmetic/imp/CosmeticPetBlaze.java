package com.aresclient.user.cosmetic.imp;

import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticPetBlaze extends Cosmetic {
   CosmeticPetBlaze.BlazeModel blazemodel;
   public static final ResourceLocation TEXTURE = new ResourceLocation("Ares/blaze.png");

   public CosmeticPetBlaze(RenderPlayer var1) {
      super(var1);
      this.blazemodel = new CosmeticPetBlaze.BlazeModel(var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1 == Minecraft.getMinecraft().thePlayer && ConfigManager.settings.BlazePet == 2) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(TEXTURE);
         if (ConfigManager.settings.Shoulder == 1) {
            GlStateManager.translate(0.7D, -0.6D, 0.0D);
         } else {
            GlStateManager.translate(-0.7D, -0.6D, 0.0D);
         }

         if (var1.isSneaking()) {
            GlStateManager.translate(0.0D, 0.045D, 0.0D);
         }

         this.blazemodel.render(var1, var2, var3, var5, var7, var7, var8 / 4.0F);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   static class BlazeModel extends ModelBase {
      private ModelRenderer[] blazeSticks = new ModelRenderer[12];
      private ModelRenderer blazeHead;

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         super.render(var1, var2, var3, var4, var5, var6, var7);
         this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
         this.blazeHead.render(var7);

         for(int var8 = 0; var8 < this.blazeSticks.length; ++var8) {
            this.blazeSticks[var8].render(var7);
         }

      }

      public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
         float var8 = var3 * 3.1415927F * -0.1F;

         int var9;
         for(var9 = 0; var9 < 4; ++var9) {
            this.blazeSticks[var9].rotationPointY = -2.0F + MathHelper.cos(((float)(var9 * 2) + var3) * 0.25F);
            this.blazeSticks[var9].rotationPointX = MathHelper.cos(var8) * 9.0F;
            this.blazeSticks[var9].rotationPointZ = MathHelper.sin(var8) * 9.0F;
            ++var8;
         }

         var8 = 0.7853982F + var3 * 3.1415927F * 0.03F;

         for(var9 = 4; var9 < 8; ++var9) {
            this.blazeSticks[var9].rotationPointY = 2.0F + MathHelper.cos(((float)(var9 * 2) + var3) * 0.25F);
            this.blazeSticks[var9].rotationPointX = MathHelper.cos(var8) * 7.0F;
            this.blazeSticks[var9].rotationPointZ = MathHelper.sin(var8) * 7.0F;
            ++var8;
         }

         var8 = 0.47123894F + var3 * 3.1415927F * -0.05F;

         for(var9 = 8; var9 < 12; ++var9) {
            this.blazeSticks[var9].rotationPointY = 11.0F + MathHelper.cos(((float)var9 * 1.5F + var3) * 0.5F);
            this.blazeSticks[var9].rotationPointX = MathHelper.cos(var8) * 5.0F;
            this.blazeSticks[var9].rotationPointZ = MathHelper.sin(var8) * 5.0F;
            ++var8;
         }

         this.blazeHead.rotateAngleY = var4 / 57.295776F;
         this.blazeHead.rotateAngleX = var5 / 57.295776F;
      }

      public BlazeModel(RenderPlayer var1) {
         for(int var2 = 0; var2 < this.blazeSticks.length; ++var2) {
            this.blazeSticks[var2] = new ModelRenderer(this, 0, 16);
            this.blazeSticks[var2].addBox(0.0F, 0.0F, 0.0F, 2, 8, 2);
         }

         this.blazeHead = new ModelRenderer(this, 0, 0);
         this.blazeHead.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8);
      }
   }
}
