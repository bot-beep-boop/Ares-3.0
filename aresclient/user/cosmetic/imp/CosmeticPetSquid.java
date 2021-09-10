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
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticPetSquid extends Cosmetic {
   CosmeticPetSquid.SquidModel squidmodel;
   public static final ResourceLocation TEXTURE = new ResourceLocation("Ares/squid.png");

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1 == Minecraft.getMinecraft().thePlayer && ConfigManager.settings.SquidPet == 2) {
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

         this.squidmodel.render(var1, var2, var3, var5, var7, var7, var8 / 4.0F);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   public CosmeticPetSquid(RenderPlayer var1) {
      super(var1);
      this.squidmodel = new CosmeticPetSquid.SquidModel(var1);
   }

   static class SquidModel extends ModelBase {
      private final ModelRenderer[] squidTentacles = new ModelRenderer[8];
      private final ModelRenderer squidBody;

      public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
         ModelRenderer[] var11;
         int var10 = (var11 = this.squidTentacles).length;

         for(int var9 = 0; var9 < var10; ++var9) {
            ModelRenderer var8 = var11[var9];
            var8.rotateAngleX = var2;
         }

      }

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         super.render(var1, var2, var3, var4, var5, var6, var7);
         this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
         this.squidBody.render(var7);

         for(int var8 = 0; var8 < this.squidTentacles.length; ++var8) {
            this.squidTentacles[var8].render(var7);
         }

      }

      public SquidModel(RenderPlayer var1) {
         byte var2 = -16;
         this.squidBody = new ModelRenderer(this, 0, 0);
         this.squidBody.addBox(-6.0F, -8.0F, -6.0F, 12, 16, 12);
         ModelRenderer var10000 = this.squidBody;
         var10000.rotationPointY += (float)(24 + var2);

         for(int var3 = 0; var3 < this.squidTentacles.length; ++var3) {
            this.squidTentacles[var3] = new ModelRenderer(this, 48, 0);
            double var4 = (double)var3 * 3.141592653589793D * 2.0D / (double)this.squidTentacles.length;
            float var6 = (float)Math.cos(var4) * 5.0F;
            float var7 = (float)Math.sin(var4) * 5.0F;
            this.squidTentacles[var3].addBox(-1.0F, 0.0F, -1.0F, 2, 18, 2);
            this.squidTentacles[var3].rotationPointX = var6;
            this.squidTentacles[var3].rotationPointZ = var7;
            this.squidTentacles[var3].rotationPointY = (float)(31 + var2);
            var4 = (double)var3 * 3.141592653589793D * -2.0D / (double)this.squidTentacles.length + 1.5707963267948966D;
            this.squidTentacles[var3].rotateAngleY = (float)var4;
         }

      }
   }
}
