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

public class CosmeticBunnyEars extends Cosmetic {
   private ModelRenderer ear2;
   private ModelRenderer ear1;

   public CosmeticBunnyEars(RenderPlayer var1) {
      super(var1);
      new ModelBiped();
      this.ear1 = new ModelRenderer(this.playerModel, 0, 0);
      this.ear1.addBox(-2.5F, -12.0F, -3.5F, 2, 8, 2);
      this.ear2 = new ModelRenderer(this.playerModel, 0, 0);
      this.ear2.addBox(0.5F, -12.0F, -3.5F, 2, 8, 2);
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (ConfigManager.settings.BunnyEars == 2) {
         GlStateManager.pushMatrix();
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.225D, 0.0D);
         }

         this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/BunnyEars/BunnyEars" + ConfigManager.settings.BunnyEarsTexture + ".png"));
         char var9 = '\uf0f0';
         int var10 = var9 % 65536;
         int var11 = var9 / 65536;
         GlStateManager.color(1.0F, 1.0F, 1.0F, 0.3F);
         this.ear1.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.ear1.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.ear1.rotationPointX = 0.0F;
         this.ear1.rotationPointY = 0.0F;
         this.ear1.render(var8);
         this.ear2.rotateAngleX = this.playerModel.bipedHead.rotateAngleX;
         this.ear2.rotateAngleY = this.playerModel.bipedHead.rotateAngleY;
         this.ear2.rotationPointX = 0.0F;
         this.ear2.rotationPointY = 0.0F;
         this.ear2.render(var8);
         GL11.glColor3f(1.0F, 1.0F, 1.0F);
         GL11.glPopMatrix();
      }

   }
}
