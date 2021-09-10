package net.minecraft.client.renderer.tileentity;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.optifine.entity.model.IEntityRenderer;

public abstract class TileEntitySpecialRenderer<T extends TileEntity> implements IEntityRenderer {
   protected static final ResourceLocation[] DESTROY_STAGES = new ResourceLocation[]{new ResourceLocation("textures/blocks/destroy_stage_0.png"), new ResourceLocation("textures/blocks/destroy_stage_1.png"), new ResourceLocation("textures/blocks/destroy_stage_2.png"), new ResourceLocation("textures/blocks/destroy_stage_3.png"), new ResourceLocation("textures/blocks/destroy_stage_4.png"), new ResourceLocation("textures/blocks/destroy_stage_5.png"), new ResourceLocation("textures/blocks/destroy_stage_6.png"), new ResourceLocation("textures/blocks/destroy_stage_7.png"), new ResourceLocation("textures/blocks/destroy_stage_8.png"), new ResourceLocation("textures/blocks/destroy_stage_9.png")};
   private Class tileEntityClass = null;
   protected TileEntityRendererDispatcher rendererDispatcher;
   private ResourceLocation locationTextureCustom = null;

   public FontRenderer getFontRenderer() {
      return this.rendererDispatcher.getFontRenderer();
   }

   public Class getEntityClass() {
      return this.tileEntityClass;
   }

   public void setEntityClass(Class var1) {
      this.tileEntityClass = var1;
   }

   public ResourceLocation getLocationTextureCustom() {
      return this.locationTextureCustom;
   }

   public void setRendererDispatcher(TileEntityRendererDispatcher var1) {
      this.rendererDispatcher = var1;
   }

   public abstract void renderTileEntityAt(T var1, double var2, double var4, double var6, float var8, int var9);

   public void setLocationTextureCustom(ResourceLocation var1) {
      this.locationTextureCustom = var1;
   }

   public void renderTileEntityFast(T var1, double var2, double var4, double var6, float var8, int var9, WorldRenderer var10) {
   }

   public boolean forceTileEntityRender() {
      return false;
   }

   protected World getWorld() {
      return this.rendererDispatcher.worldObj;
   }

   protected void bindTexture(ResourceLocation var1) {
      TextureManager var2 = this.rendererDispatcher.renderEngine;
      if (var2 != null) {
         var2.bindTexture(var1);
      }

   }
}
