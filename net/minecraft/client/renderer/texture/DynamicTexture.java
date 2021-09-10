package net.minecraft.client.renderer.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import net.minecraft.client.resources.IResourceManager;

public class DynamicTexture extends AbstractTexture {
   private final int width;
   private final int height;
   private final int[] dynamicTextureData;

   public int[] getTextureData() {
      return this.dynamicTextureData;
   }

   public void updateDynamicTexture() {
      TextureUtil.uploadTexture(this.getGlTextureId(), this.dynamicTextureData, this.width, this.height);
   }

   public void loadTexture(IResourceManager var1) throws IOException {
   }

   public DynamicTexture(int var1, int var2) {
      this.width = var1;
      this.height = var2;
      this.dynamicTextureData = new int[var1 * var2];
      TextureUtil.allocateTexture(this.getGlTextureId(), var1, var2);
   }

   public DynamicTexture(BufferedImage var1) {
      this(var1.getWidth(), var1.getHeight());
      var1.getRGB(0, 0, var1.getWidth(), var1.getHeight(), this.dynamicTextureData, 0, var1.getWidth());
      this.updateDynamicTexture();
   }
}
