package net.minecraft.client.renderer.entity;

import com.aresclient.utils.config.ConfigManager;
import java.awt.Color;
import java.text.DecimalFormat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class RenderTNTPrimed extends Render<EntityTNTPrimed> {
   public void renderTag(RenderTNTPrimed var1, EntityTNTPrimed var2, double var3, double var5, double var7, float var9) {
      if (var2.fuse >= 1) {
         double var10 = var2.getDistanceSqToEntity(var1.getRenderManager().livingPlayer);
         if (var10 <= 4096.0D) {
            float var12 = ((float)var2.fuse - var9) / 20.0F;
            String var13 = (new DecimalFormat("0.00")).format((double)var12);
            FontRenderer var14 = var1.getFontRendererFromRenderManager();
            float var15 = 1.6F;
            float var16 = 0.016666668F * var15;
            GlStateManager.pushMatrix();
            GlStateManager.translate((float)var3 + 0.0F, (float)var5 + var2.height + 0.5F, (float)var7);
            GL11.glNormal3f(0.0F, 1.0F, 0.0F);
            GlStateManager.rotate(-var1.getRenderManager().playerViewY, 0.0F, 1.0F, 0.0F);
            byte var17 = 1;
            if (Minecraft.getMinecraft() != null && Minecraft.getMinecraft().gameSettings != null && Minecraft.getMinecraft().gameSettings.thirdPersonView == 2) {
               var17 = -1;
            }

            GlStateManager.rotate(var1.getRenderManager().playerViewX * (float)var17, 1.0F, 0.0F, 0.0F);
            GlStateManager.scale(-var16, -var16, var16);
            GlStateManager.disableLighting();
            GlStateManager.depthMask(false);
            GlStateManager.disableDepth();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
            Tessellator var18 = Tessellator.getInstance();
            WorldRenderer var19 = var18.getWorldRenderer();
            byte var20 = 0;
            int var21 = var14.getStringWidth(var13) / 2;
            float var22 = Math.min((float)var2.fuse / 80.0F, 1.0F);
            Color var23 = new Color(1.0F - var22, var22, 0.0F);
            GlStateManager.enableDepth();
            GlStateManager.depthMask(true);
            GlStateManager.disableTexture2D();
            var19.begin(7, DefaultVertexFormats.POSITION_COLOR);
            var19.pos((double)(-var21 - 1), (double)(-1 + var20), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
            var19.pos((double)(-var21 - 1), (double)(8 + var20), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
            var19.pos((double)(var21 + 1), (double)(8 + var20), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
            var19.pos((double)(var21 + 1), (double)(-1 + var20), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
            var18.draw();
            GlStateManager.enableTexture2D();
            var14.drawString(var13, -var14.getStringWidth(var13) / 2, var20, var23.getRGB());
            GlStateManager.enableLighting();
            GlStateManager.disableBlend();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            GlStateManager.popMatrix();
         }
      }

   }

   protected ResourceLocation getEntityTexture(Entity var1) {
      return this.getEntityTexture((EntityTNTPrimed)var1);
   }

   public void doRender(EntityTNTPrimed var1, double var2, double var4, double var6, float var8, float var9) {
      BlockRendererDispatcher var10 = Minecraft.getMinecraft().getBlockRendererDispatcher();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var2, (float)var4 + 0.5F, (float)var6);
      float var11;
      if ((float)var1.fuse - var9 + 1.0F < 10.0F) {
         var11 = 1.0F - ((float)var1.fuse - var9 + 1.0F) / 10.0F;
         var11 = MathHelper.clamp_float(var11, 0.0F, 1.0F);
         var11 *= var11;
         var11 *= var11;
         float var12 = 1.0F + var11 * 0.3F;
         GlStateManager.scale(var12, var12, var12);
      }

      var11 = (1.0F - ((float)var1.fuse - var9 + 1.0F) / 100.0F) * 0.8F;
      this.bindEntityTexture(var1);
      GlStateManager.translate(-0.5F, -0.5F, 0.5F);
      var10.renderBlockBrightness(Blocks.tnt.getDefaultState(), var1.getBrightness(var9));
      GlStateManager.translate(0.0F, 0.0F, 1.0F);
      if (var1.fuse / 5 % 2 == 0) {
         GlStateManager.disableTexture2D();
         GlStateManager.disableLighting();
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(770, 772);
         GlStateManager.color(1.0F, 1.0F, 1.0F, var11);
         GlStateManager.doPolygonOffset(-3.0F, -3.0F);
         GlStateManager.enablePolygonOffset();
         var10.renderBlockBrightness(Blocks.tnt.getDefaultState(), 1.0F);
         GlStateManager.doPolygonOffset(0.0F, 0.0F);
         GlStateManager.disablePolygonOffset();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.disableBlend();
         GlStateManager.enableLighting();
         GlStateManager.enableTexture2D();
      }

      GlStateManager.popMatrix();
      if (ConfigManager.settings.TntTimer == 2) {
         this.renderTag(this, var1, var2, var4, var6, var9);
      }

      super.doRender(var1, var2, var4, var6, var8, var9);
   }

   public RenderTNTPrimed(RenderManager var1) {
      super(var1);
      this.shadowSize = 0.5F;
   }

   public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      this.doRender((EntityTNTPrimed)var1, var2, var4, var6, var8, var9);
   }

   protected ResourceLocation getEntityTexture(EntityTNTPrimed var1) {
      return TextureMap.locationBlocksTexture;
   }
}
