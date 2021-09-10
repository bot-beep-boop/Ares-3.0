package com.aresclient.user.cosmetic.imp;

import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.utils.config.ConfigManager;
import java.util.Random;
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

public class CosmeticPetGhast extends Cosmetic {
   public static final ResourceLocation TEXTURE = new ResourceLocation("Ares/ghast.png");
   CosmeticPetGhast.GhastModel ghastmodel;

   public CosmeticPetGhast(RenderPlayer var1) {
      super(var1);
      this.ghastmodel = new CosmeticPetGhast.GhastModel(var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1 == Minecraft.getMinecraft().thePlayer && ConfigManager.settings.GhastPet == 2) {
         GlStateManager.pushMatrix();
         this.playerRenderer.bindTexture(TEXTURE);
         if (ConfigManager.settings.Shoulder == 1) {
            GlStateManager.translate(0.7D, -1.0D, 0.0D);
         } else {
            GlStateManager.translate(-0.7D, -1.0D, 0.0D);
         }

         if (var1.isSneaking()) {
            GlStateManager.translate(0.0D, 0.045D, 0.0D);
         }

         this.ghastmodel.render(var1, var2, var3, var5, var7, var7, var8 / 4.0F);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   static class GhastModel extends ModelBase {
      ModelRenderer[] tentacles = new ModelRenderer[9];
      ModelRenderer body;

      public GhastModel(RenderPlayer var1) {
         byte var2 = -16;
         this.body = new ModelRenderer(this, 0, 0);
         this.body.addBox(-8.0F, -8.0F, -8.0F, 16, 16, 16);
         ModelRenderer var10000 = this.body;
         var10000.rotationPointY += (float)(24 + var2);
         Random var3 = new Random(1660L);

         for(int var4 = 0; var4 < this.tentacles.length; ++var4) {
            this.tentacles[var4] = new ModelRenderer(this, 0, 0);
            float var5 = (((float)(var4 % 3) - (float)(var4 / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 5.0F;
            float var6 = ((float)(var4 / 3) / 2.0F * 2.0F - 1.0F) * 5.0F;
            int var7 = var3.nextInt(7) + 8;
            this.tentacles[var4].addBox(-1.0F, 0.0F, -1.0F, 2, var7, 2);
            this.tentacles[var4].rotationPointX = var5;
            this.tentacles[var4].rotationPointZ = var6;
            this.tentacles[var4].rotationPointY = (float)(31 + var2);
         }

      }

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         super.render(var1, var2, var3, var4, var5, var6, var7);
         this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
         GlStateManager.pushMatrix();
         GlStateManager.translate(0.0F, 0.6F, 0.0F);
         this.body.render(var7);
         ModelRenderer[] var11;
         int var10 = (var11 = this.tentacles).length;

         for(int var9 = 0; var9 < var10; ++var9) {
            ModelRenderer var8 = var11[var9];
            var8.render(var7);
         }

         GlStateManager.popMatrix();
      }

      public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
         for(int var8 = 0; var8 < this.tentacles.length; ++var8) {
            this.tentacles[var8].rotateAngleX = 0.2F * MathHelper.sin(var3 * 0.3F + (float)var8) + 0.4F;
         }

      }
   }
}
