package net.optifine.shaders;

import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureUtil;

public class CustomTexture implements ICustomTexture {
   private ITextureObject texture = null;
   private String path = null;
   private int textureUnit = -1;

   public int getTextureId() {
      return this.texture.getGlTextureId();
   }

   public void deleteTexture() {
      TextureUtil.deleteTexture(this.texture.getGlTextureId());
   }

   public String getPath() {
      return this.path;
   }

   public String toString() {
      return "textureUnit: " + this.textureUnit + ", path: " + this.path + ", glTextureId: " + this.getTextureId();
   }

   public int getTextureUnit() {
      return this.textureUnit;
   }

   public int getTarget() {
      return 3553;
   }

   public CustomTexture(int var1, String var2, ITextureObject var3) {
      this.textureUnit = var1;
      this.path = var2;
      this.texture = var3;
   }

   public ITextureObject getTexture() {
      return this.texture;
   }
}
