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

public class CosmeticWitchHat extends Cosmetic {
   private ModelRenderer witchHat;
   private static final ResourceLocation witchTextures = new ResourceLocation("Ares/cosmetic/witch.png");

   public CosmeticWitchHat(RenderPlayer var1) {
      super(var1);
      ModelBiped var2 = new ModelBiped();
      this.witchHat = (new ModelRenderer(var2)).setTextureSize(40, 34);
      this.witchHat.setRotationPoint(-5.0F, -10.03125F, -5.0F);
      this.witchHat.setTextureOffset(0, 0).addBox(0.0F, 0.0F, 0.0F, 10, 2, 10);
      ModelRenderer var3 = (new ModelRenderer(var2)).setTextureSize(40, 34);
      var3.setRotationPoint(1.75F, -4.0F, 2.0F);
      var3.setTextureOffset(0, 12).addBox(0.0F, 0.0F, 0.0F, 7, 4, 7);
      var3.rotateAngleX = -0.05235988F;
      var3.rotateAngleZ = 0.02617994F;
      this.witchHat.addChild(var3);
      ModelRenderer var4 = (new ModelRenderer(var2)).setTextureSize(40, 34);
      var4.setRotationPoint(1.75F, -4.0F, 2.0F);
      var4.setTextureOffset(0, 23).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
      var4.rotateAngleX = -0.10471976F;
      var4.rotateAngleZ = 0.05235988F;
      var3.addChild(var4);
      ModelRenderer var5 = (new ModelRenderer(var2)).setTextureSize(40, 34);
      var5.setRotationPoint(1.75F, -2.0F, 2.0F);
      var5.setTextureOffset(0, 31).addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
      var5.rotateAngleX = -0.20943952F;
      var5.rotateAngleZ = 0.10471976F;
      var4.addChild(var5);
      this.witchHat.isHidden = true;
   }

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (ConfigManager.settings.WitchHat == 2) {
         GlStateManager.pushMatrix();
         float var9 = 0.995F;
         GlStateManager.scale(var9, var9, var9);
         this.playerRenderer.bindTexture(witchTextures);
         if (var1.isSneaking()) {
            GL11.glTranslated(0.0D, 0.325D, 0.0D);
         }

         GlStateManager.rotate(var6, 0.0F, 1.0F, 0.0F);
         GlStateManager.rotate(var7, 1.0F, 0.0F, 0.0F);
         this.witchHat.isHidden = false;
         this.witchHat.render(var8);
         this.witchHat.isHidden = true;
         GlStateManager.popMatrix();
      }

   }
}
