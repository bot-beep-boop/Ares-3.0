package com.aresclient.user.cosmetic.imp;

import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticBandana extends Cosmetic {
   private ModelRenderer band1;
   private ModelRenderer band3;
   private ModelRenderer band4;
   private ModelRenderer band2;

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (ConfigManager.settings.Bandana == 2) {
         GlStateManager.pushMatrix();
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/bandana/bandana" + ConfigManager.settings.BandanaTexture + ".png"));
         this.band1.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.band1.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.band1.rotationPointX = 0.0F;
         this.band1.rotationPointY = 0.0F;
         this.band1.render(var8);
         this.band2.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.band2.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.band2.rotationPointX = 0.0F;
         this.band2.rotationPointY = 0.0F;
         this.band2.render(var8);
         this.band3.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.band3.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.band3.rotationPointX = 0.0F;
         this.band3.rotationPointY = 0.0F;
         this.band3.render(var8);
         this.band4.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.band4.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.band4.rotationPointX = 0.0F;
         this.band4.rotationPointY = 0.0F;
         this.band4.render(var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   public CosmeticBandana(RenderPlayer var1) {
      super(var1);
      ModelBiped var2 = new ModelBiped();
      this.band1 = new ModelRenderer(var2, 0, 0);
      this.band1.addBox(-4.5F, -7.0F, -4.7F, 9, 2, 1);
      this.band2 = new ModelRenderer(var2, 0, 0);
      this.band2.addBox(3.5F, -7.0F, -3.5F, 1, 2, 8);
      this.band3 = new ModelRenderer(var2, 0, 0);
      this.band3.addBox(-4.5F, -7.0F, -3.5F, 1, 2, 8);
      this.band4 = new ModelRenderer(var2, 0, 0);
      this.band4.addBox(-4.5F, -7.0F, 4.0F, 9, 2, 1);
   }
}
