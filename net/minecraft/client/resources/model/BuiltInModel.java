package net.minecraft.client.resources.model;

import java.util.List;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;

public class BuiltInModel implements IBakedModel {
   private ItemCameraTransforms cameraTransforms;

   public boolean isGui3d() {
      return true;
   }

   public List<BakedQuad> getGeneralQuads() {
      return null;
   }

   public TextureAtlasSprite getParticleTexture() {
      return null;
   }

   public BuiltInModel(ItemCameraTransforms var1) {
      this.cameraTransforms = var1;
   }

   public boolean isAmbientOcclusion() {
      return false;
   }

   public ItemCameraTransforms getItemCameraTransforms() {
      return this.cameraTransforms;
   }

   public boolean isBuiltInRenderer() {
      return true;
   }

   public List<BakedQuad> getFaceQuads(EnumFacing var1) {
      return null;
   }
}
