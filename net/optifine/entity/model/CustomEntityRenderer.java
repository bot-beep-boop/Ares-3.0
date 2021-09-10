package net.optifine.entity.model;

import net.minecraft.util.ResourceLocation;

public class CustomEntityRenderer {
   private String name = null;
   private String basePath = null;
   private ResourceLocation textureLocation = null;
   private CustomModelRenderer[] customModelRenderers = null;
   private float shadowSize = 0.0F;

   public CustomEntityRenderer(String var1, String var2, ResourceLocation var3, CustomModelRenderer[] var4, float var5) {
      this.name = var1;
      this.basePath = var2;
      this.textureLocation = var3;
      this.customModelRenderers = var4;
      this.shadowSize = var5;
   }

   public ResourceLocation getTextureLocation() {
      return this.textureLocation;
   }

   public CustomModelRenderer[] getCustomModelRenderers() {
      return this.customModelRenderers;
   }

   public String getName() {
      return this.name;
   }

   public String getBasePath() {
      return this.basePath;
   }

   public float getShadowSize() {
      return this.shadowSize;
   }
}
