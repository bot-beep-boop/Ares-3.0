package net.optifine.shaders;

import java.nio.ByteBuffer;
import net.optifine.texture.InternalFormat;
import net.optifine.texture.PixelFormat;
import net.optifine.texture.PixelType;
import net.optifine.texture.TextureType;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class CustomTextureRaw implements ICustomTexture {
   private int textureId;
   private int textureUnit;
   private static int[] $SWITCH_TABLE$net$optifine$texture$TextureType;
   private TextureType type;

   static int[] $SWITCH_TABLE$net$optifine$texture$TextureType() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$texture$TextureType;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[TextureType.values().length];

         try {
            var0[TextureType.TEXTURE_1D.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[TextureType.TEXTURE_2D.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[TextureType.TEXTURE_3D.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[TextureType.TEXTURE_RECTANGLE.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$texture$TextureType = var0;
         return var0;
      }
   }

   public int getTextureId() {
      return this.textureId;
   }

   public CustomTextureRaw(TextureType var1, InternalFormat var2, int var3, int var4, int var5, PixelFormat var6, PixelType var7, ByteBuffer var8, int var9) {
      this.type = var1;
      this.textureUnit = var9;
      this.textureId = GL11.glGenTextures();
      GL11.glBindTexture(this.getTarget(), this.textureId);
      switch($SWITCH_TABLE$net$optifine$texture$TextureType()[var1.ordinal()]) {
      case 1:
         GL11.glTexImage1D(3552, 0, var2.getId(), var3, 0, var6.getId(), var7.getId(), var8);
         GL11.glTexParameteri(3552, 10242, 33071);
         GL11.glTexParameteri(3552, 10240, 9729);
         GL11.glTexParameteri(3552, 10241, 9729);
         break;
      case 2:
         GL11.glTexImage2D(3553, 0, var2.getId(), var3, var4, 0, var6.getId(), var7.getId(), var8);
         GL11.glTexParameteri(3553, 10242, 33071);
         GL11.glTexParameteri(3553, 10243, 33071);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glTexParameteri(3553, 10241, 9729);
         break;
      case 3:
         GL12.glTexImage3D(32879, 0, var2.getId(), var3, var4, var5, 0, var6.getId(), var7.getId(), var8);
         GL11.glTexParameteri(32879, 10242, 33071);
         GL11.glTexParameteri(32879, 10243, 33071);
         GL11.glTexParameteri(32879, 32882, 33071);
         GL11.glTexParameteri(32879, 10240, 9729);
         GL11.glTexParameteri(32879, 10241, 9729);
         break;
      case 4:
         GL11.glTexImage2D(34037, 0, var2.getId(), var3, var4, 0, var6.getId(), var7.getId(), var8);
         GL11.glTexParameteri(34037, 10242, 33071);
         GL11.glTexParameteri(34037, 10243, 33071);
         GL11.glTexParameteri(34037, 10240, 9729);
         GL11.glTexParameteri(34037, 10241, 9729);
      }

      GL11.glBindTexture(this.getTarget(), 0);
   }

   public void deleteTexture() {
      if (this.textureId > 0) {
         GL11.glDeleteTextures(this.textureId);
         this.textureId = 0;
      }

   }

   public int getTextureUnit() {
      return this.textureUnit;
   }

   public int getTarget() {
      return this.type.getId();
   }
}
