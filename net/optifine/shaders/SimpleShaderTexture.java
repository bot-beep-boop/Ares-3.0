package net.optifine.shaders;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.client.resources.data.AnimationMetadataSectionSerializer;
import net.minecraft.client.resources.data.FontMetadataSection;
import net.minecraft.client.resources.data.FontMetadataSectionSerializer;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.client.resources.data.LanguageMetadataSectionSerializer;
import net.minecraft.client.resources.data.PackMetadataSection;
import net.minecraft.client.resources.data.PackMetadataSectionSerializer;
import net.minecraft.client.resources.data.TextureMetadataSection;
import net.minecraft.client.resources.data.TextureMetadataSectionSerializer;
import org.apache.commons.io.IOUtils;

public class SimpleShaderTexture extends AbstractTexture {
   private String texturePath;
   private static final IMetadataSerializer METADATA_SERIALIZER = makeMetadataSerializer();

   private TextureMetadataSection loadTextureMetadataSection() {
      String var1 = this.texturePath + ".mcmeta";
      String var2 = "texture";
      InputStream var3 = Shaders.getShaderPackResourceStream(var1);
      if (var3 != null) {
         IMetadataSerializer var4 = METADATA_SERIALIZER;
         BufferedReader var5 = new BufferedReader(new InputStreamReader(var3));

         try {
            TextureMetadataSection var6;
            TextureMetadataSection var10;
            try {
               JsonObject var7 = (new JsonParser()).parse(var5).getAsJsonObject();
               TextureMetadataSection var8 = (TextureMetadataSection)var4.parseMetadataSection(var2, var7);
               if (var8 == null) {
                  var10 = new TextureMetadataSection(false, false, new ArrayList());
                  return var10;
               }

               var6 = var8;
            } catch (RuntimeException var13) {
               SMCLog.warning("Error reading metadata: " + var1);
               SMCLog.warning(var13.getClass().getName() + ": " + var13.getMessage());
               var10 = new TextureMetadataSection(false, false, new ArrayList());
               return var10;
            }

            IOUtils.closeQuietly(var5);
            IOUtils.closeQuietly(var3);
            return var6;
         } finally {
            IOUtils.closeQuietly(var5);
            IOUtils.closeQuietly(var3);
         }
      } else {
         return new TextureMetadataSection(false, false, new ArrayList());
      }
   }

   private static IMetadataSerializer makeMetadataSerializer() {
      IMetadataSerializer var0 = new IMetadataSerializer();
      var0.registerMetadataSectionType(new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
      var0.registerMetadataSectionType(new FontMetadataSectionSerializer(), FontMetadataSection.class);
      var0.registerMetadataSectionType(new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
      var0.registerMetadataSectionType(new PackMetadataSectionSerializer(), PackMetadataSection.class);
      var0.registerMetadataSectionType(new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
      return var0;
   }

   public void loadTexture(IResourceManager var1) throws IOException {
      this.deleteGlTexture();
      InputStream var2 = Shaders.getShaderPackResourceStream(this.texturePath);
      if (var2 == null) {
         throw new FileNotFoundException("Shader texture not found: " + this.texturePath);
      } else {
         try {
            BufferedImage var3 = TextureUtil.readBufferedImage(var2);
            TextureMetadataSection var4 = this.loadTextureMetadataSection();
            TextureUtil.uploadTextureImageAllocate(this.getGlTextureId(), var3, var4.getTextureBlur(), var4.getTextureClamp());
            IOUtils.closeQuietly(var2);
         } finally {
            IOUtils.closeQuietly(var2);
         }
      }
   }

   public SimpleShaderTexture(String var1) {
      this.texturePath = var1;
   }
}
