package net.optifine.shaders;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

public class CustomTextureLocation implements ICustomTexture {
   public static final int VARIANT_NORMAL = 1;
   private int variant = 0;
   private int textureUnit = -1;
   public static final int VARIANT_BASE = 0;
   private ITextureObject texture;
   public static final int VARIANT_SPECULAR = 2;
   private ResourceLocation location;

   public ITextureObject getTexture() {
      if (this.texture == null) {
         TextureManager var1 = Minecraft.getMinecraft().getTextureManager();
         this.texture = var1.getTexture(this.location);
         if (this.texture == null) {
            this.texture = new SimpleTexture(this.location);
            var1.loadTexture(this.location, this.texture);
            this.texture = var1.getTexture(this.location);
         }
      }

      return this.texture;
   }

   public void deleteTexture() {
   }

   public CustomTextureLocation(int var1, ResourceLocation var2, int var3) {
      this.textureUnit = var1;
      this.location = var2;
      this.variant = var3;
   }

   public int getTextureUnit() {
      return this.textureUnit;
   }

   public int getTextureId() {
      ITextureObject var1 = this.getTexture();
      if (this.variant != 0 && var1 instanceof AbstractTexture) {
         AbstractTexture var2 = (AbstractTexture)var1;
         MultiTexID var3 = var2.multiTex;
         if (var3 != null) {
            if (this.variant == 1) {
               return var3.norm;
            }

            if (this.variant == 2) {
               return var3.spec;
            }
         }
      }

      return var1.getGlTextureId();
   }

   public int getTarget() {
      return 3553;
   }

   public String toString() {
      return "textureUnit: " + this.textureUnit + ", location: " + this.location + ", glTextureId: " + (this.texture != null ? this.texture.getGlTextureId() : "");
   }
}
