package com.aresclient.user.cosmetic.imp;

import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticHalo extends Cosmetic {
   private ModelRenderer band4;
   private ModelRenderer band2;
   private ModelRenderer band1;
   private ModelRenderer band3;

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (ConfigManager.settings.Halo == 2) {
         GlStateManager.pushMatrix();
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/halo/halo" + ConfigManager.settings.HaloTexture + ".png"));
         this.band1.rotateAngleX = 0.0F;
         this.band1.rotateAngleY = 0.0F;
         this.band1.rotationPointX = 0.0F;
         this.band1.rotationPointY = 0.0F;
         this.band1.render(var8);
         this.band2.rotateAngleX = 0.0F;
         this.band2.rotateAngleY = 0.0F;
         this.band2.rotationPointX = 0.0F;
         this.band2.rotationPointY = 0.0F;
         this.band2.render(var8);
         this.band3.rotateAngleX = 0.0F;
         this.band3.rotateAngleY = 0.0F;
         this.band3.rotationPointX = 0.0F;
         this.band3.rotationPointY = 0.0F;
         this.band3.render(var8);
         this.band4.rotateAngleX = 0.0F;
         this.band4.rotateAngleY = 0.0F;
         this.band4.rotationPointX = 0.0F;
         this.band4.rotationPointY = 0.0F;
         this.band4.render(var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }

   public CosmeticHalo(RenderPlayer var1) {
      super(var1);
      this.band1 = new ModelRenderer(this.playerModel, 0, 0);
      this.band1.addBox(-3.5F, -13.0F, -4.0F, 7, 1, 1);
      this.band2 = new ModelRenderer(this.playerModel, 0, 0);
      this.band2.addBox(3.0F, -13.0F, -3.5F, 1, 1, 7);
      this.band3 = new ModelRenderer(this.playerModel, 0, 0);
      this.band3.addBox(-4.0F, -13.0F, -3.5F, 1, 1, 7);
      this.band4 = new ModelRenderer(this.playerModel, 0, 0);
      this.band4.addBox(-3.5F, -13.0F, 3.0F, 7, 1, 1);
   }
}
