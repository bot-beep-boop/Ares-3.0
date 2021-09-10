package net.optifine.shaders;

public interface ICustomTexture {
   void deleteTexture();

   int getTextureId();

   int getTarget();

   int getTextureUnit();
}
