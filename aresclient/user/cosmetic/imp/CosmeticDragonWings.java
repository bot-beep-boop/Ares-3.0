package com.aresclient.user.cosmetic.imp;

import com.aresclient.user.cosmetic.Cosmetic;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CosmeticDragonWings extends Cosmetic {
   private ModelRenderer wing;
   private int textureHeight = 32;
   private int textureWidth = 64;
   private ModelRenderer wingTip;
   boolean flying = false;

   public void render(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      GlStateManager.pushMatrix();
      if (ConfigManager.settings.Wings == 2 && var1.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
         GlStateManager.color(1.0F, 1.0F, 1.0F);
         if (var1.isSneaking()) {
            GlStateManager.translate(0.0F, 0.04F, 0.0F);
         }

         float var9 = 100.0F;
         if (!var1.onGround || this.flying) {
            var9 = 10.0F;
            this.flying = true;
         }

         float var10 = var3 + var5 / var9;
         float var11 = var3 + var5 / 100.0F;
         float var12 = var10 * 3.1415927F * 2.0F;
         float var13 = 0.125F - (float)Math.cos((double)var12) * 0.2F;
         float var14 = var11 * 3.1415927F * 2.0F;
         float var15 = 0.125F - (float)Math.cos((double)var14) * 0.2F;
         if (this.flying && (int)(var13 * 100.0F) == (int)(var15 * 100.0F)) {
            this.flying = false;
            var9 = 100.0F;
         }

         GlStateManager.color(255.0F, 255.0F, 255.0F);
         this.playerRenderer.bindTexture(new ResourceLocation("Ares/cosmetic/wings/wings" + ConfigManager.settings.WingsTexture + ".png"));
         GlStateManager.scale(0.13D, 0.13D, 0.13D);
         GlStateManager.translate(0.0D, -0.3D, 1.1D);
         GlStateManager.rotate(50.0F, -50.0F, 0.0F, 0.0F);
         GlStateManager.color(255.0F, 255.0F, 255.0F);
         boolean var16 = false;
         boolean var17 = false;

         for(int var18 = 0; var18 < 2; ++var18) {
            float var19 = var10 * 3.1415927F * 2.0F;
            this.wing.rotateAngleX = 0.125F - (float)Math.cos((double)var19) * 0.2F;
            this.wing.rotateAngleY = 0.25F;
            this.wing.rotateAngleZ = (float)(Math.sin((double)var19) + 1.225D) * 0.3F;
            this.wingTip.rotateAngleZ = -((float)(Math.sin((double)(var19 + 2.0F)) + 0.5D)) * 0.75F;
            this.wing.isHidden = false;
            this.wingTip.isHidden = false;
            GlStateManager.color(255.0F, 255.0F, 255.0F);
            this.wing.render(var8);
            this.wing.isHidden = true;
            this.wingTip.isHidden = true;
            if (var18 == 0) {
               GlStateManager.scale(-1.0F, 1.0F, 1.0F);
            }
         }
      }

      GL11.glColor3f(1.0F, 1.0F, 1.0F);
      GL11.glPopMatrix();
   }

   public CosmeticDragonWings(RenderPlayer var1) {
      super(var1);
      new ModelBiped();
      int var3 = this.textureWidth;
      int var4 = this.textureWidth;
      this.textureWidth = 256;
      this.textureWidth = 256;
      this.wing = new ModelRenderer(var1.mainModel, "wing");
      this.wing.setTextureSize(256, 256);
      this.wing.setRotationPoint(-12.0F, 5.0F, 2.0F);
      this.wing.isHidden = true;
      this.wingTip = new ModelRenderer(var1.mainModel, "wingtip");
      this.wingTip.setTextureSize(256, 256);
      this.wingTip.setRotationPoint(-56.0F, 0.0F, 0.0F);
      this.wingTip.isHidden = true;
      this.wing.setTextureOffset(112, 136).addBox(-56.0F, -4.0F, -4.0F, 56, 8, 8);
      this.wing.setTextureOffset(-56, 88).addBox(-56.0F, 0.0F, 2.0F, 56, 0, 56);
      this.wingTip.setTextureOffset(112, 88).addBox(-56.0F, -2.0F, -2.0F, 56, 4, 4);
      this.wingTip.setTextureOffset(-56, 144).addBox(-56.0F, 0.0F, 2.0F, 56, 0, 56);
      this.wing.addChild(this.wingTip);
      this.textureWidth = var3;
      this.textureWidth = var4;
   }
}
