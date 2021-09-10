package com.aresclient.user.cosmetic.imp;

import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticPetSlime extends Cosmetic {
   CosmeticPetSlime.BlazeModel blazemodel;
   public static final ResourceLocation TEXTURE = new ResourceLocation("Ares/slime.png");

   public CosmeticPetSlime(RenderPlayer var1) {
      super(var1);
      this.blazemodel = new CosmeticPetSlime.BlazeModel(var1);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
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

      this.blazemodel.render(var1, var2, var3, var5, var7, var7, var8);
      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   static class BlazeModel extends ModelBase {
      ModelRenderer slimeRightEye;
      ModelRenderer slimeBodies = new ModelRenderer(this, 0, 100);
      ModelRenderer slimeMouth;
      ModelRenderer slimeLeftEye;

      public BlazeModel(RenderPlayer var1) {
         this.slimeBodies.addBox(-4.0F, 16.0F, -4.0F, 8, 8, 8);
         this.slimeBodies = new ModelRenderer(this, 0, 100);
         this.slimeBodies.addBox(-3.0F, 17.0F, -3.0F, 6, 6, 6);
         this.slimeRightEye = new ModelRenderer(this, 32, 0);
         this.slimeRightEye.addBox(-3.25F, 18.0F, -3.5F, 2, 2, 2);
         this.slimeLeftEye = new ModelRenderer(this, 32, 4);
         this.slimeLeftEye.addBox(1.25F, 18.0F, -3.5F, 2, 2, 2);
         this.slimeMouth = new ModelRenderer(this, 32, 8);
         this.slimeMouth.addBox(0.0F, 21.0F, -3.5F, 1, 1, 1);
      }

      public void render(Entity var1, float var2, float var3, float var4, float var5, float var6, float var7) {
         this.setRotationAngles(var2, var3, var4, var5, var6, var7, var1);
         this.slimeBodies.render(var7);
         if (this.slimeRightEye != null) {
            this.slimeRightEye.render(var7);
            this.slimeLeftEye.render(var7);
            this.slimeMouth.render(var7);
         }

      }
   }
}
