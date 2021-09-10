package net.optifine.shaders.config;

public class RenderScale {
   private float offsetY = 0.0F;
   private float scale = 1.0F;
   private float offsetX = 0.0F;

   public float getOffsetY() {
      return this.offsetY;
   }

   public String toString() {
      return this.scale + ", " + this.offsetX + ", " + this.offsetY;
   }

   public float getOffsetX() {
      return this.offsetX;
   }

   public RenderScale(float var1, float var2, float var3) {
      this.scale = var1;
      this.offsetX = var2;
      this.offsetY = var3;
   }

   public float getScale() {
      return this.scale;
   }
}
