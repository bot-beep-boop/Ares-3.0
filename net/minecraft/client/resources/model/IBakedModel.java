package net.minecraft.client.resources.model;

import java.util.List;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;

public interface IBakedModel {
   List<BakedQuad> getGeneralQuads();

   ItemCameraTransforms getItemCameraTransforms();

   TextureAtlasSprite getParticleTexture();

   boolean isGui3d();

   boolean isAmbientOcclusion();

   List<BakedQuad> getFaceQuads(EnumFacing var1);

   boolean isBuiltInRenderer();
}
