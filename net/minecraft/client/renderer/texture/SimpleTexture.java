package net.minecraft.client.renderer.texture;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.EmissiveTextures;
import net.optifine.shaders.ShadersTex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SimpleTexture extends AbstractTexture {
   public ResourceLocation locationEmissive;
   private static final Logger logger = LogManager.getLogger();
   public boolean isEmissive;
   protected final ResourceLocation textureLocation;

   public SimpleTexture(ResourceLocation var1) {
      this.textureLocation = var1;
   }

   public void loadTexture(IResourceManager var1) throws IOException {
      this.deleteGlTexture();
      InputStream var2 = null;

      try {
         IResource var3 = var1.getResource(this.textureLocation);
         var2 = var3.getInputStream();
         BufferedImage var4 = TextureUtil.readBufferedImage(var2);
         boolean var5 = false;
         boolean var6 = false;
         if (var3.hasMetadata()) {
            try {
               TextureMetadataSection var7 = (TextureMetadataSection)var3.getMetadata("texture");
               if (var7 != null) {
                  var5 = var7.getTextureBlur();
                  var6 = var7.getTextureClamp();
               }
            } catch (RuntimeException var11) {
               logger.warn("Failed reading metadata of: " + this.textureLocation, var11);
            }
         }

         if (Config.isShaders()) {
            ShadersTex.loadSimpleTexture(this.getGlTextureId(), var4, var5, var6, var1, this.textureLocation, this.getMultiTexID());
         } else {
            TextureUtil.uploadTextureImageAllocate(this.getGlTextureId(), var4, var5, var6);
         }

         if (EmissiveTextures.isActive()) {
            EmissiveTextures.loadTexture(this.textureLocation, this);
         }
      } finally {
         if (var2 != null) {
            var2.close();
         }

      }

   }
}
