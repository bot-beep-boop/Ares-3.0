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

public class CosmeticPetBat extends Cosmetic {
   CosmeticPetBat.BatModel batmodel;
   public static final ResourceLocation TEXTURE = new ResourceLocation("Ares/bat.png");

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1 == Minecraft.getMinecraft().thePlayer && ConfigManager.settings.BatPet == 2) {
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

         this.batmodel.render(var1, var2, var3, var5, var7, var7, var8 / 4.0F);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   public CosmeticPetBat(RenderPlayer var1) {
      super(var1);
      this.batmodel = new CosmeticPetBat.BatModel(var1);
   }

   static class BatModel extends ModelBase {
      private ModelRenderer batHead;
      private ModelRenderer batRightWing;
      private ModelRenderer batOuterLeftWing;
      private ModelRenderer batBody;
      private ModelRenderer batOuterRightWing;
      private ModelRenderer batLeftWing;

      public BatModel(RenderPlayer var1) {
         this.textureWidth = 64;
         this.textureHeight = 64;
         this.batHead = new ModelRenderer(this, 0, 0);
         this.batHead.addBox(-3.0F, -3.0F, -3.0F, 6, 6, 6);
         ModelRenderer var2 = new ModelRenderer(this, 24, 0);
         var2.addBox(-4.0F, -6.0F, -2.0F, 3, 4, 1);
         this.batHead.addChild(var2);
         ModelRenderer var3 = new ModelRenderer(this, 24, 0);
         var3.mirror = true;
         var3.addBox(1.0F, -6.0F, -2.0F, 3, 4, 1);
         this.batHead.addChild(var3);
         this.batBody = new ModelRenderer(this, 0, 16);
         this.batBody.addBox(-3.0F, 4.0F, -3.0F, 6, 12, 6);
         this.batBody.setTextureOffset(0, 34).addBox(-5.0F, 16.0F, 0.0F, 10, 6, 1);
         this.batRightWing = new ModelRenderer(this, 42, 0);
         this.batRightWing.addBox(-12.0F, 1.0F, 1.5F, 10, 16, 1);
         this.batOuterRightWing = new ModelRenderer(this, 24, 16);
         this.batOuterRightWing.setRotationPoint(-12.0F, 1.0F, 1.5F);
         this.batOuterRightWing.addBox(-8.0F, 1.0F, 0.0F, 8, 12, 1);
         this.batLeftWing = new ModelRenderer(this, 42, 0);
         this.batLeftWing.mirror = true;
         this.batLeftWing.addBox(2.0F, 1.0F, 1.5F, 10, 16, 1);
         this.batOuterLeftWing = new ModelRenderer(this, 24, 16);
         this.batOuterLeftWing.mirror = true;
         this.batOuterLeftWing.setRotationPoint(12.0F, 1.0F, 1.5F);
         this.batOuterLeftWing.addBox(0.0F, 1.0F, 0.0F, 8, 12, 1);
         this.batBody.addChild(this.batRightWing);
         this.batBody.addChild(this.batLeftWing);
         this.batRightWing.addChild(this.batOuterRightWing);
         this.batLeftWing.addChild(this.batOuterLeftWing);
      }

      public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
         float var8 = 57.295776F;
         this.batHead.rotateAngleX = var5 / 57.295776F;
         this.batHead.rotateAngleY = var4 / 57.295776F;
         this.batHead.rotateAngleZ = 0.0F;
         this.batHead.setRotationPoint(0.0F, 0.0F, 0.0F);
         this.batRightWing.setRotationPoint(0.0F, 0.0F, 0.0F);
         this.batLeftWing.setRotationPoint(0.0F, 0.0F, 0.0F);
         this.batBody.rotateAngleX = 0.7853982F + MathHelper.cos(var3 * 0.1F) * 0.15F;
         this.batBody.rotateAngleY = 0.0F;
         this.batRightWing.rotateAngleY = MathHelper.cos(var3 * 1.3F) * 3.1415927F * 0.25F;
         this.batLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY;
         this.batOuterRightWing.rotateAngleY = this.batRightWing.rotateAngleY * 0.5F;
         this.batOuterLeftWing.rotateAngleY = -this.batRightWing.rotateAngleY * 0.5F;
      }

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         super.render(var1, var2, var3, var4, var5, var6, var7);
         this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
         this.batHead.render(var7);
         this.batBody.render(var7);
      }
   }
}
