package net.minecraft.client.shader;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.util.JsonBlendingMode;
import net.minecraft.client.util.JsonException;
import net.minecraft.util.JsonUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShaderManager {
   private final Map<String, Object> shaderSamplers;
   private static final Logger logger = LogManager.getLogger();
   private static ShaderManager staticShaderManager = null;
   private final ShaderLoader vertexShaderLoader;
   private final List<Integer> attribLocations;
   private final List<Integer> shaderUniformLocations;
   private final List<String> samplerNames;
   private final List<Integer> shaderSamplerLocations;
   private final List<String> attributes;
   private static final ShaderDefault defaultShaderUniform = new ShaderDefault();
   private static boolean field_148000_e = true;
   private final Map<String, ShaderUniform> mappedShaderUniforms;
   private final JsonBlendingMode field_148016_p;
   private final ShaderLoader fragmentShaderLoader;
   private final boolean useFaceCulling;
   private final List<ShaderUniform> shaderUniforms;
   private final String programFilename;
   private boolean isDirty;
   private final int program;
   private static int currentProgram = -1;

   public void addSamplerTexture(String var1, Object var2) {
      if (this.shaderSamplers.containsKey(var1)) {
         this.shaderSamplers.remove(var1);
      }

      this.shaderSamplers.put(var1, var2);
      this.markDirty();
   }

   private void parseSampler(JsonElement var1) throws JsonException {
      JsonObject var2 = JsonUtils.getJsonObject(var1, "sampler");
      String var3 = JsonUtils.getString(var2, "name");
      if (!JsonUtils.isString(var2, "file")) {
         this.shaderSamplers.put(var3, (Object)null);
         this.samplerNames.add(var3);
      } else {
         this.samplerNames.add(var3);
      }

   }

   public void markDirty() {
      this.isDirty = true;
   }

   public void endShader() {
      OpenGlHelper.glUseProgram(0);
      currentProgram = -1;
      staticShaderManager = null;
      field_148000_e = true;

      for(int var1 = 0; var1 < this.shaderSamplerLocations.size(); ++var1) {
         if (this.shaderSamplers.get(this.samplerNames.get(var1)) != null) {
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + var1);
            GlStateManager.bindTexture(0);
         }
      }

   }

   public void useShader() {
      this.isDirty = false;
      staticShaderManager = this;
      this.field_148016_p.func_148109_a();
      if (this.program != currentProgram) {
         OpenGlHelper.glUseProgram(this.program);
         currentProgram = this.program;
      }

      if (this.useFaceCulling) {
         GlStateManager.enableCull();
      } else {
         GlStateManager.disableCull();
      }

      for(int var1 = 0; var1 < this.shaderSamplerLocations.size(); ++var1) {
         if (this.shaderSamplers.get(this.samplerNames.get(var1)) != null) {
            GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit + var1);
            GlStateManager.enableTexture2D();
            Object var2 = this.shaderSamplers.get(this.samplerNames.get(var1));
            int var3 = -1;
            if (var2 instanceof Framebuffer) {
               var3 = ((Framebuffer)var2).framebufferTexture;
            } else if (var2 instanceof ITextureObject) {
               var3 = ((ITextureObject)var2).getGlTextureId();
            } else if (var2 instanceof Integer) {
               var3 = (Integer)var2;
            }

            if (var3 != -1) {
               GlStateManager.bindTexture(var3);
               OpenGlHelper.glUniform1i(OpenGlHelper.glGetUniformLocation(this.program, (CharSequence)this.samplerNames.get(var1)), var1);
            }
         }
      }

      Iterator var5 = this.shaderUniforms.iterator();

      while(var5.hasNext()) {
         ShaderUniform var4 = (ShaderUniform)var5.next();
         var4.upload();
      }

   }

   private void setupUniforms() {
      int var1 = 0;

      for(int var2 = 0; var1 < this.samplerNames.size(); ++var2) {
         String var3 = (String)this.samplerNames.get(var1);
         int var4 = OpenGlHelper.glGetUniformLocation(this.program, var3);
         if (var4 == -1) {
            logger.warn("Shader " + this.programFilename + "could not find sampler named " + var3 + " in the specified shader program.");
            this.shaderSamplers.remove(var3);
            this.samplerNames.remove(var2);
            --var2;
         } else {
            this.shaderSamplerLocations.add(var4);
         }

         ++var1;
      }

      Iterator var6 = this.shaderUniforms.iterator();

      while(var6.hasNext()) {
         ShaderUniform var7 = (ShaderUniform)var6.next();
         String var8 = var7.getShaderName();
         int var5 = OpenGlHelper.glGetUniformLocation(this.program, var8);
         if (var5 == -1) {
            logger.warn("Could not find uniform named " + var8 + " in the specified" + " shader program.");
         } else {
            this.shaderUniformLocations.add(var5);
            var7.setUniformLocation(var5);
            this.mappedShaderUniforms.put(var8, var7);
         }
      }

   }

   public ShaderLoader getFragmentShaderLoader() {
      return this.fragmentShaderLoader;
   }

   public ShaderLoader getVertexShaderLoader() {
      return this.vertexShaderLoader;
   }

   public ShaderUniform getShaderUniform(String var1) {
      return this.mappedShaderUniforms.containsKey(var1) ? (ShaderUniform)this.mappedShaderUniforms.get(var1) : null;
   }

   public void deleteShader() {
      ShaderLinkHelper.getStaticShaderLinkHelper().deleteShader(this);
   }

   private void parseUniform(JsonElement var1) throws JsonException {
      JsonObject var2 = JsonUtils.getJsonObject(var1, "uniform");
      String var3 = JsonUtils.getString(var2, "name");
      int var4 = ShaderUniform.parseType(JsonUtils.getString(var2, "type"));
      int var5 = JsonUtils.getInt(var2, "count");
      float[] var6 = new float[Math.max(var5, 16)];
      JsonArray var7 = JsonUtils.getJsonArray(var2, "values");
      if (var7.size() != var5 && var7.size() > 1) {
         throw new JsonException("Invalid amount of values specified (expected " + var5 + ", found " + var7.size() + ")");
      } else {
         int var8 = 0;

         for(Iterator var10 = var7.iterator(); var10.hasNext(); ++var8) {
            JsonElement var9 = (JsonElement)var10.next();

            try {
               var6[var8] = JsonUtils.getFloat(var9, "value");
            } catch (Exception var13) {
               JsonException var12 = JsonException.func_151379_a(var13);
               var12.func_151380_a("values[" + var8 + "]");
               throw var12;
            }
         }

         if (var5 > 1 && var7.size() == 1) {
            while(var8 < var5) {
               var6[var8] = var6[0];
               ++var8;
            }
         }

         int var14 = var5 > 1 && var5 <= 4 && var4 < 8 ? var5 - 1 : 0;
         ShaderUniform var15 = new ShaderUniform(var3, var4 + var14, var5, this);
         if (var4 <= 3) {
            var15.set((int)var6[0], (int)var6[1], (int)var6[2], (int)var6[3]);
         } else if (var4 <= 7) {
            var15.func_148092_b(var6[0], var6[1], var6[2], var6[3]);
         } else {
            var15.set(var6);
         }

         this.shaderUniforms.add(var15);
      }
   }

   public ShaderUniform getShaderUniformOrDefault(String var1) {
      return (ShaderUniform)(this.mappedShaderUniforms.containsKey(var1) ? (ShaderUniform)this.mappedShaderUniforms.get(var1) : defaultShaderUniform);
   }

   public ShaderManager(IResourceManager param1, String param2) throws IOException, JsonException {
      // $FF: Couldn't be decompiled
   }

   public int getProgram() {
      return this.program;
   }
}
