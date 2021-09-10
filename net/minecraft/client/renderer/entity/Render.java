package net.minecraft.client.renderer.entity;

import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ICamera;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.src.Config;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.optifine.entity.model.IEntityRenderer;
import net.optifine.shaders.Shaders;
import org.lwjgl.opengl.GL11;

public abstract class Render<T extends Entity> implements IEntityRenderer {
   protected final RenderManager renderManager;
   protected float shadowOpaque = 1.0F;
   private ResourceLocation locationTextureCustom = null;
   private static final ResourceLocation shadowTextures = new ResourceLocation("textures/misc/shadow.png");
   public float shadowSize;
   private Class entityClass = null;
   ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

   public RenderManager getRenderManager() {
      return this.renderManager;
   }

   public void bindTexture(ResourceLocation var1) {
      this.renderManager.renderEngine.bindTexture(var1);
   }

   private void renderShadowBlock(Block var1, double var2, double var4, double var6, BlockPos var8, float var9, float var10, double var11, double var13, double var15) {
      if (var1.isFullCube()) {
         Tessellator var17 = Tessellator.getInstance();
         WorldRenderer var18 = var17.getWorldRenderer();
         double var19 = ((double)var9 - (var4 - ((double)var8.getY() + var13)) / 2.0D) * 0.5D * (double)this.getWorldFromRenderManager().getLightBrightness(var8);
         if (var19 >= 0.0D) {
            if (var19 > 1.0D) {
               var19 = 1.0D;
            }

            double var21 = (double)var8.getX() + var1.getBlockBoundsMinX() + var11;
            double var23 = (double)var8.getX() + var1.getBlockBoundsMaxX() + var11;
            double var25 = (double)var8.getY() + var1.getBlockBoundsMinY() + var13 + 0.015625D;
            double var27 = (double)var8.getZ() + var1.getBlockBoundsMinZ() + var15;
            double var29 = (double)var8.getZ() + var1.getBlockBoundsMaxZ() + var15;
            float var31 = (float)((var2 - var21) / 2.0D / (double)var10 + 0.5D);
            float var32 = (float)((var2 - var23) / 2.0D / (double)var10 + 0.5D);
            float var33 = (float)((var6 - var27) / 2.0D / (double)var10 + 0.5D);
            float var34 = (float)((var6 - var29) / 2.0D / (double)var10 + 0.5D);
            var18.pos(var21, var25, var27).tex((double)var31, (double)var33).color(1.0F, 1.0F, 1.0F, (float)var19).endVertex();
            var18.pos(var21, var25, var29).tex((double)var31, (double)var34).color(1.0F, 1.0F, 1.0F, (float)var19).endVertex();
            var18.pos(var23, var25, var29).tex((double)var32, (double)var34).color(1.0F, 1.0F, 1.0F, (float)var19).endVertex();
            var18.pos(var23, var25, var27).tex((double)var32, (double)var33).color(1.0F, 1.0F, 1.0F, (float)var19).endVertex();
         }
      }

   }

   public void doRender(T var1, double var2, double var4, double var6, float var8, float var9) {
      this.renderName(var1, var2, var4, var6);
   }

   public boolean isMultipass() {
      return false;
   }

   public void doRenderShadowAndFire(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      if (this.renderManager.options != null) {
         if (this.renderManager.options.entityShadows && this.shadowSize > 0.0F && !var1.isInvisible() && this.renderManager.isRenderShadow()) {
            double var10 = this.renderManager.getDistanceToCamera(var1.posX, var1.posY, var1.posZ);
            float var12 = (float)((1.0D - var10 / 256.0D) * (double)this.shadowOpaque);
            if (var12 > 0.0F) {
               this.renderShadow(var1, var2, var4, var6, var12, var9);
            }
         }

         if (var1.canRenderOnFire() && (!(var1 instanceof EntityPlayer) || !((EntityPlayer)var1).isSpectator())) {
            this.renderEntityOnFire(var1, var2, var4, var6, var9);
         }
      }

   }

   protected boolean canRenderName(T var1) {
      return var1.getAlwaysRenderNameTagForRender() && var1.hasCustomName();
   }

   public void renderMultipass(T var1, double var2, double var4, double var6, float var8, float var9) {
   }

   public void setLocationTextureCustom(ResourceLocation var1) {
      this.locationTextureCustom = var1;
   }

   private World getWorldFromRenderManager() {
      return this.renderManager.worldObj;
   }

   protected void renderOffsetLivingLabel(T var1, double var2, double var4, double var6, String var8, float var9, double var10) {
      this.renderLivingLabel(var1, var8, var2, var4, var6, 64);
   }

   public void setEntityClass(Class var1) {
      this.entityClass = var1;
   }

   public boolean shouldRender(T var1, ICamera var2, double var3, double var5, double var7) {
      AxisAlignedBB var9 = var1.getEntityBoundingBox();
      if (var9.hasNaN() || var9.getAverageEdgeLength() == 0.0D) {
         var9 = new AxisAlignedBB(var1.posX - 2.0D, var1.posY - 2.0D, var1.posZ - 2.0D, var1.posX + 2.0D, var1.posY + 2.0D, var1.posZ + 2.0D);
      }

      return var1.isInRangeToRender3d(var3, var5, var7) && (var1.ignoreFrustumCheck || var2.isBoundingBoxInFrustum(var9));
   }

   protected boolean bindEntityTexture(T var1) {
      ResourceLocation var2 = this.getEntityTexture(var1);
      if (this.locationTextureCustom != null) {
         var2 = this.locationTextureCustom;
      }

      if (var2 == null) {
         return false;
      } else {
         this.bindTexture(var2);
         return true;
      }
   }

   protected Render(RenderManager var1) {
      this.renderManager = var1;
   }

   public static void renderOffsetAABB(AxisAlignedBB var0, double var1, double var3, double var5) {
      GlStateManager.disableTexture2D();
      Tessellator var7 = Tessellator.getInstance();
      WorldRenderer var8 = var7.getWorldRenderer();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      var8.setTranslation(var1, var3, var5);
      var8.begin(7, DefaultVertexFormats.POSITION_NORMAL);
      var8.pos(var0.minX, var0.maxY, var0.minZ).normal(0.0F, 0.0F, -1.0F).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.minZ).normal(0.0F, 0.0F, -1.0F).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.minZ).normal(0.0F, 0.0F, -1.0F).endVertex();
      var8.pos(var0.minX, var0.minY, var0.minZ).normal(0.0F, 0.0F, -1.0F).endVertex();
      var8.pos(var0.minX, var0.minY, var0.maxZ).normal(0.0F, 0.0F, 1.0F).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.maxZ).normal(0.0F, 0.0F, 1.0F).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.maxZ).normal(0.0F, 0.0F, 1.0F).endVertex();
      var8.pos(var0.minX, var0.maxY, var0.maxZ).normal(0.0F, 0.0F, 1.0F).endVertex();
      var8.pos(var0.minX, var0.minY, var0.minZ).normal(0.0F, -1.0F, 0.0F).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.minZ).normal(0.0F, -1.0F, 0.0F).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.maxZ).normal(0.0F, -1.0F, 0.0F).endVertex();
      var8.pos(var0.minX, var0.minY, var0.maxZ).normal(0.0F, -1.0F, 0.0F).endVertex();
      var8.pos(var0.minX, var0.maxY, var0.maxZ).normal(0.0F, 1.0F, 0.0F).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.maxZ).normal(0.0F, 1.0F, 0.0F).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.minZ).normal(0.0F, 1.0F, 0.0F).endVertex();
      var8.pos(var0.minX, var0.maxY, var0.minZ).normal(0.0F, 1.0F, 0.0F).endVertex();
      var8.pos(var0.minX, var0.minY, var0.maxZ).normal(-1.0F, 0.0F, 0.0F).endVertex();
      var8.pos(var0.minX, var0.maxY, var0.maxZ).normal(-1.0F, 0.0F, 0.0F).endVertex();
      var8.pos(var0.minX, var0.maxY, var0.minZ).normal(-1.0F, 0.0F, 0.0F).endVertex();
      var8.pos(var0.minX, var0.minY, var0.minZ).normal(-1.0F, 0.0F, 0.0F).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.minZ).normal(1.0F, 0.0F, 0.0F).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.minZ).normal(1.0F, 0.0F, 0.0F).endVertex();
      var8.pos(var0.maxX, var0.maxY, var0.maxZ).normal(1.0F, 0.0F, 0.0F).endVertex();
      var8.pos(var0.maxX, var0.minY, var0.maxZ).normal(1.0F, 0.0F, 0.0F).endVertex();
      var7.draw();
      var8.setTranslation(0.0D, 0.0D, 0.0D);
      GlStateManager.enableTexture2D();
   }

   public ResourceLocation getLocationTextureCustom() {
      return this.locationTextureCustom;
   }

   public static void setModelBipedMain(RenderBiped var0, ModelBiped var1) {
      var0.modelBipedMain = var1;
   }

   private void renderEntityOnFire(Entity var1, double var2, double var4, double var6, float var8) {
      GlStateManager.disableLighting();
      TextureMap var9 = Minecraft.getMinecraft().getTextureMapBlocks();
      TextureAtlasSprite var10 = var9.getAtlasSprite("minecraft:blocks/fire_layer_0");
      TextureAtlasSprite var11 = var9.getAtlasSprite("minecraft:blocks/fire_layer_1");
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var2, (float)var4, (float)var6);
      float var12 = var1.width * 1.4F;
      GlStateManager.scale(var12, var12, var12);
      Tessellator var13 = Tessellator.getInstance();
      WorldRenderer var14 = var13.getWorldRenderer();
      float var15 = 0.5F;
      float var16 = 0.0F;
      float var17 = var1.height / var12;
      float var18 = (float)(var1.posY - var1.getEntityBoundingBox().minY);
      GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
      GlStateManager.translate(0.0F, 0.0F, -0.3F + (float)((int)var17) * 0.02F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      float var19 = 0.0F;
      int var20 = 0;
      boolean var21 = Config.isMultiTexture();
      if (var21) {
         var14.setBlockLayer(EnumWorldBlockLayer.SOLID);
      }

      var14.begin(7, DefaultVertexFormats.POSITION_TEX);

      while(var17 > 0.0F) {
         TextureAtlasSprite var22 = var20 % 2 == 0 ? var10 : var11;
         var14.setSprite(var22);
         this.bindTexture(TextureMap.locationBlocksTexture);
         float var23 = var22.getMinU();
         float var24 = var22.getMinV();
         float var25 = var22.getMaxU();
         float var26 = var22.getMaxV();
         if (var20 / 2 % 2 == 0) {
            float var27 = var25;
            var25 = var23;
            var23 = var27;
         }

         var14.pos((double)(var15 - var16), (double)(0.0F - var18), (double)var19).tex((double)var25, (double)var26).endVertex();
         var14.pos((double)(-var15 - var16), (double)(0.0F - var18), (double)var19).tex((double)var23, (double)var26).endVertex();
         var14.pos((double)(-var15 - var16), (double)(1.4F - var18), (double)var19).tex((double)var23, (double)var24).endVertex();
         var14.pos((double)(var15 - var16), (double)(1.4F - var18), (double)var19).tex((double)var25, (double)var24).endVertex();
         var17 -= 0.45F;
         var18 -= 0.45F;
         var15 *= 0.9F;
         var19 += 0.03F;
         ++var20;
      }

      var13.draw();
      if (var21) {
         var14.setBlockLayer((EnumWorldBlockLayer)null);
         GlStateManager.bindCurrentTexture();
      }

      GlStateManager.popMatrix();
      GlStateManager.enableLighting();
   }

   protected void renderLivingLabel(T var1, String var2, double var3, double var5, double var7, int var9) {
      double var10 = var1.getDistanceSqToEntity(this.renderManager.livingPlayer);
      if (var10 <= (double)(var9 * var9)) {
         FontRenderer var12 = this.getFontRendererFromRenderManager();
         float var13 = 1.6F;
         float var14 = 0.016666668F * var13;
         GlStateManager.pushMatrix();
         GlStateManager.translate((float)var3 + 0.0F, (float)var5 + var1.height + 0.5F, (float)var7);
         GL11.glNormal3f(0.0F, 1.0F, 0.0F);
         GlStateManager.rotate(-this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
         GlStateManager.rotate(this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
         GlStateManager.scale(-var14, -var14, var14);
         GlStateManager.disableLighting();
         GlStateManager.depthMask(false);
         GlStateManager.disableDepth();
         GlStateManager.enableBlend();
         GlStateManager.tryBlendFuncSeparate(770, 771, 1, 0);
         Tessellator var15 = Tessellator.getInstance();
         WorldRenderer var16 = var15.getWorldRenderer();
         byte var17 = 0;
         int var18 = var12.getStringWidth(var2) / 2;
         GlStateManager.disableTexture2D();
         var16.begin(7, DefaultVertexFormats.POSITION_COLOR);
         var16.pos((double)(-var18 - 1), (double)(-1 + var17), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
         var16.pos((double)(-var18 - 1), (double)(8 + var17), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
         var16.pos((double)(var18 + 1), (double)(8 + var17), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
         var16.pos((double)(var18 + 1), (double)(-1 + var17), 0.0D).color(0.0F, 0.0F, 0.0F, 0.25F).endVertex();
         var15.draw();
         GlStateManager.enableTexture2D();
         var12.drawString(var2, -var12.getStringWidth(var2) / 2, var17, 553648127);
         GlStateManager.enableDepth();
         GlStateManager.depthMask(true);
         var12.drawString(var2, -var12.getStringWidth(var2) / 2, var17, -1);
         GlStateManager.enableLighting();
         GlStateManager.disableBlend();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.popMatrix();
      }

   }

   public FontRenderer getFontRendererFromRenderManager() {
      return this.renderManager.getFontRenderer();
   }

   protected abstract ResourceLocation getEntityTexture(T var1);

   public Class getEntityClass() {
      return this.entityClass;
   }

   private void renderShadow(Entity var1, double var2, double var4, double var6, float var8, float var9) {
      if (!Config.isShaders() || !Shaders.shouldSkipDefaultShadow) {
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(770, 771);
         this.renderManager.renderEngine.bindTexture(shadowTextures);
         World var10 = this.getWorldFromRenderManager();
         GlStateManager.depthMask(false);
         float var11 = this.shadowSize;
         if (var1 instanceof EntityLiving) {
            EntityLiving var12 = (EntityLiving)var1;
            var11 *= var12.getRenderSizeModifier();
            if (var12.isChild()) {
               var11 *= 0.5F;
            }
         }

         double var35 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * (double)var9;
         double var14 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * (double)var9;
         double var16 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * (double)var9;
         int var18 = MathHelper.floor_double(var35 - (double)var11);
         int var19 = MathHelper.floor_double(var35 + (double)var11);
         int var20 = MathHelper.floor_double(var14 - (double)var11);
         int var21 = MathHelper.floor_double(var14);
         int var22 = MathHelper.floor_double(var16 - (double)var11);
         int var23 = MathHelper.floor_double(var16 + (double)var11);
         double var24 = var2 - var35;
         double var26 = var4 - var14;
         double var28 = var6 - var16;
         Tessellator var30 = Tessellator.getInstance();
         WorldRenderer var31 = var30.getWorldRenderer();
         var31.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR);
         Iterator var33 = BlockPos.getAllInBoxMutable(new BlockPos(var18, var20, var22), new BlockPos(var19, var21, var23)).iterator();

         while(var33.hasNext()) {
            BlockPos var32 = (BlockPos)var33.next();
            Block var34 = var10.getBlockState(var32.down()).getBlock();
            if (var34.getRenderType() != -1 && var10.getLightFromNeighbors(var32) > 3) {
               this.renderShadowBlock(var34, var2, var4, var6, var32, var8, var11, var24, var26, var28);
            }
         }

         var30.draw();
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.disableBlend();
         GlStateManager.depthMask(true);
      }

   }

   protected void renderName(T var1, double var2, double var4, double var6) {
      if (this.canRenderName(var1)) {
         this.renderLivingLabel(var1, var1.getDisplayName().getFormattedText(), var2, var4, var6, 64);
      }

   }
}
