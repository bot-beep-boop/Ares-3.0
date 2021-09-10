package com.aresclient.user.cosmetic.imp.capes;

import com.aresclient.utils.CapeAnimation;
import com.aresclient.utils.config.ConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class CosmeticOfflineCape implements LayerRenderer<AbstractClientPlayer> {
   private final RenderPlayer playerRenderer;
   static CapeAnimation anim;

   public CosmeticOfflineCape(RenderPlayer var1) {
      this.playerRenderer = var1;
      anim = new CapeAnimation(ConfigManager.settings.capepath, ConfigManager.settings.MaxFrames, 1);
   }

   public void doRenderLayer(EntityLivingBase var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.doRenderLayer((AbstractClientPlayer)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public static void update() {
      anim = new CapeAnimation(ConfigManager.settings.capepath, ConfigManager.settings.MaxFrames, 1);
   }

   public void doRenderLayer(AbstractClientPlayer var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1.hasPlayerInfo() && !var1.isInvisible() && ConfigManager.settings.capemode.equals("offline") && var1 == Minecraft.getMinecraft().thePlayer) {
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         if (!ConfigManager.settings.AnimatedCape) {
            var1.setLocationOfOfflineCape(new ResourceLocation(ConfigManager.settings.capepath));
         } else {
            var1.setLocationOfOfflineCape(anim.getTexture());
            anim.update();
         }

         this.playerRenderer.bindTexture(var1.getlocationOfOfflineCape());
         GlStateManager.pushMatrix();
         GlStateManager.translate(0.0F, 0.0F, 0.125F);
         double var9 = var1.prevChasingPosX + (var1.chasingPosX - var1.prevChasingPosX) * (double)var4 - (var1.prevPosX + (var1.posX - var1.prevPosX) * (double)var4);
         double var11 = var1.prevChasingPosY + (var1.chasingPosY - var1.prevChasingPosY) * (double)var4 - (var1.prevPosY + (var1.posY - var1.prevPosY) * (double)var4);
         double var13 = var1.prevChasingPosZ + (var1.chasingPosZ - var1.prevChasingPosZ) * (double)var4 - (var1.prevPosZ + (var1.posZ - var1.prevPosZ) * (double)var4);
         float var15 = var1.prevRenderYawOffset + (var1.renderYawOffset - var1.prevRenderYawOffset) * var4;
         double var16 = (double)MathHelper.sin(var15 * 3.1415927F / 180.0F);
         double var18 = (double)(-MathHelper.cos(var15 * 3.1415927F / 180.0F));
         float var20 = (float)var11 * 10.0F;
         var20 = MathHelper.clamp_float(var20, -6.0F, 32.0F);
         float var21 = (float)(var9 * var16 + var13 * var18) * 100.0F;
         float var22 = (float)(var9 * var18 - var13 * var16) * 100.0F;
         if (var21 < 0.0F) {
            var21 = 0.0F;
         }

         if (var21 > 165.0F) {
            var21 = 165.0F;
         }

         if (var20 < -5.0F) {
            var20 = -5.0F;
         }

         float var23 = var1.prevCameraYaw + (var1.cameraYaw - var1.prevCameraYaw) * var4;
         var20 += MathHelper.sin((var1.prevDistanceWalkedModified + (var1.distanceWalkedModified - var1.prevDistanceWalkedModified) * var4) * 6.0F) * 32.0F * var23;
         if (var1.isSneaking()) {
            var20 += 25.0F;
            GlStateManager.translate(0.0F, 0.142F, -0.0178F);
         }

         GlStateManager.rotate(6.0F + var21 / 2.0F + var20, 1.0F, 0.0F, 0.0F);
         GlStateManager.rotate(var22 / 2.0F, 0.0F, 0.0F, 1.0F);
         GlStateManager.rotate(-var22 / 2.0F, 0.0F, 1.0F, 0.0F);
         GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
         this.playerRenderer.getMainModel().renderOfflineCape(0.0625F);
         GlStateManager.popMatrix();
      }

   }

   public boolean shouldCombineTextures() {
      return false;
   }
}
