package net.minecraft.client.model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;

public class ModelPlayer extends ModelBiped {
   public ModelRenderer bipedRightArmwear;
   private ModelRenderer aresCape;
   public ModelRenderer bipedBodyWear;
   private ModelRenderer offlineCape;
   private ModelRenderer OptifineCape;
   private ModelRenderer bipedCape;
   public ModelRenderer bipedRightLegwear;
   public ModelRenderer bipedLeftLegwear;
   private ModelRenderer bipedDeadmau5Head;
   public ModelRenderer bipedLeftArmwear;
   private boolean smallArms;

   public void renderOptifineCape(float var1) {
      this.OptifineCape.render(var1);
   }

   public void renderAresCape(float var1) {
      this.aresCape.render(var1);
   }

   public void renderOfflineCape(float var1) {
      this.offlineCape.render(var1);
   }

   public ModelPlayer(float var1, boolean var2) {
      super(var1, 0.0F, 64, 64);
      this.smallArms = var2;
      this.bipedDeadmau5Head = new ModelRenderer(this, 24, 0);
      this.bipedDeadmau5Head.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, var1);
      this.bipedCape = new ModelRenderer(this, 0, 0);
      this.bipedCape.setTextureSize(64, 32);
      this.bipedCape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, var1);
      this.aresCape = new ModelRenderer(this, 0, 0);
      this.aresCape.setTextureSize(22, 17);
      this.aresCape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, var1);
      this.offlineCape = new ModelRenderer(this, 0, 0);
      this.offlineCape.setTextureSize(22, 17);
      this.offlineCape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, var1);
      this.OptifineCape = new ModelRenderer(this, 0, 0);
      this.OptifineCape.setTextureSize(64, 32);
      this.OptifineCape.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, var1);
      if (var2) {
         this.bipedLeftArm = new ModelRenderer(this, 32, 48);
         this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, var1);
         this.bipedLeftArm.setRotationPoint(5.0F, 2.5F, 0.0F);
         this.bipedRightArm = new ModelRenderer(this, 40, 16);
         this.bipedRightArm.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, var1);
         this.bipedRightArm.setRotationPoint(-5.0F, 2.5F, 0.0F);
         this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
         this.bipedLeftArmwear.addBox(-1.0F, -2.0F, -2.0F, 3, 12, 4, var1 + 0.25F);
         this.bipedLeftArmwear.setRotationPoint(5.0F, 2.5F, 0.0F);
         this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
         this.bipedRightArmwear.addBox(-2.0F, -2.0F, -2.0F, 3, 12, 4, var1 + 0.25F);
         this.bipedRightArmwear.setRotationPoint(-5.0F, 2.5F, 10.0F);
      } else {
         this.bipedLeftArm = new ModelRenderer(this, 32, 48);
         this.bipedLeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, var1);
         this.bipedLeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
         this.bipedLeftArmwear = new ModelRenderer(this, 48, 48);
         this.bipedLeftArmwear.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, var1 + 0.25F);
         this.bipedLeftArmwear.setRotationPoint(5.0F, 2.0F, 0.0F);
         this.bipedRightArmwear = new ModelRenderer(this, 40, 32);
         this.bipedRightArmwear.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, var1 + 0.25F);
         this.bipedRightArmwear.setRotationPoint(-5.0F, 2.0F, 10.0F);
      }

      this.bipedLeftLeg = new ModelRenderer(this, 16, 48);
      this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1);
      this.bipedLeftLeg.setRotationPoint(1.9F, 12.0F, 0.0F);
      this.bipedLeftLegwear = new ModelRenderer(this, 0, 48);
      this.bipedLeftLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1 + 0.25F);
      this.bipedLeftLegwear.setRotationPoint(1.9F, 12.0F, 0.0F);
      this.bipedRightLegwear = new ModelRenderer(this, 0, 32);
      this.bipedRightLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, var1 + 0.25F);
      this.bipedRightLegwear.setRotationPoint(-1.9F, 12.0F, 0.0F);
      this.bipedBodyWear = new ModelRenderer(this, 16, 32);
      this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, var1 + 0.25F);
      this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
   }

   public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      super.render(var1, var2, var3, var4, var5, var6, var7);
      GlStateManager.pushMatrix();
      if (this.isChild) {
         float var8 = 2.0F;
         GlStateManager.scale(1.0F / var8, 1.0F / var8, 1.0F / var8);
         GlStateManager.translate(0.0F, 24.0F * var7, 0.0F);
         this.bipedLeftLegwear.render(var7);
         this.bipedRightLegwear.render(var7);
         this.bipedLeftArmwear.render(var7);
         this.bipedRightArmwear.render(var7);
         this.bipedBodyWear.render(var7);
      } else {
         if (var1.isSneaking()) {
            GlStateManager.translate(0.0F, 0.2F, 0.0F);
         }

         this.bipedLeftLegwear.render(var7);
         this.bipedRightLegwear.render(var7);
         this.bipedLeftArmwear.render(var7);
         this.bipedRightArmwear.render(var7);
         this.bipedBodyWear.render(var7);
      }

      GlStateManager.popMatrix();
   }

   public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6, Entity var7) {
      super.setRotationAngles(var1, var2, var3, var4, var5, var6, var7);
      copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
      copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
      copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
      copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
      copyModelAngles(this.bipedBody, this.bipedBodyWear);
   }

   public void renderCape(float var1) {
      this.bipedCape.render(var1);
   }

   public void renderRightArm() {
      this.bipedRightArm.render(0.0625F);
      this.bipedRightArmwear.render(0.0625F);
   }

   public void renderDeadmau5Head(float var1) {
      copyModelAngles(this.bipedHead, this.bipedDeadmau5Head);
      this.bipedDeadmau5Head.rotationPointX = 0.0F;
      this.bipedDeadmau5Head.rotationPointY = 0.0F;
      this.bipedDeadmau5Head.render(var1);
   }

   public void renderLeftArm() {
      this.bipedLeftArm.render(0.0625F);
      this.bipedLeftArmwear.render(0.0625F);
   }

   public void postRenderArm(float var1) {
      if (this.smallArms) {
         ++this.bipedRightArm.rotationPointX;
         this.bipedRightArm.postRender(var1);
         --this.bipedRightArm.rotationPointX;
      } else {
         this.bipedRightArm.postRender(var1);
      }

   }

   public void setInvisible(boolean var1) {
      super.setInvisible(var1);
      this.bipedLeftArmwear.showModel = var1;
      this.bipedRightArmwear.showModel = var1;
      this.bipedLeftLegwear.showModel = var1;
      this.bipedRightLegwear.showModel = var1;
      this.bipedBodyWear.showModel = var1;
      this.bipedCape.showModel = var1;
      this.aresCape.showModel = var1;
      this.offlineCape.showModel = var1;
      this.OptifineCape.showModel = var1;
      this.bipedDeadmau5Head.showModel = var1;
   }
}
