package net.minecraft.client.resources.model;

import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourceManagerReloadListener;
import net.minecraft.util.IRegistry;

public class ModelManager implements IResourceManagerReloadListener {
   private IBakedModel defaultModel;
   private final TextureMap texMap;
   private IRegistry<ModelResourceLocation, IBakedModel> modelRegistry;
   private final BlockModelShapes modelProvider;

   public BlockModelShapes getBlockModelShapes() {
      return this.modelProvider;
   }

   public IBakedModel getModel(ModelResourceLocation var1) {
      if (var1 == null) {
         return this.defaultModel;
      } else {
         IBakedModel var2 = (IBakedModel)this.modelRegistry.getObject(var1);
         return var2 == null ? this.defaultModel : var2;
      }
   }

   public void onResourceManagerReload(IResourceManager var1) {
      ModelBakery var2 = new ModelBakery(var1, this.texMap, this.modelProvider);
      this.modelRegistry = var2.setupModelRegistry();
      this.defaultModel = (IBakedModel)this.modelRegistry.getObject(ModelBakery.MODEL_MISSING);
      this.modelProvider.reloadModels();
   }

   public IBakedModel getMissingModel() {
      return this.defaultModel;
   }

   public TextureMap getTextureMap() {
      return this.texMap;
   }

   public ModelManager(TextureMap var1) {
      this.texMap = var1;
      this.modelProvider = new BlockModelShapes(this);
   }
}
