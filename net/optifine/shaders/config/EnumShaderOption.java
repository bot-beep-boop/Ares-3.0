package net.optifine.shaders.config;

public enum EnumShaderOption {
   private String propertyKey = null;
   TEX_MAG_FIL_S("of.options.shaders.TEX_MAG_FIL_S", "TexMagFilS", "0"),
   NORMAL_MAP("of.options.shaders.NORMAL_MAP", "normalMapEnabled", "true"),
   SPECULAR_MAP("of.options.shaders.SPECULAR_MAP", "specularMapEnabled", "true"),
   TEX_MAG_FIL_B("of.options.shaders.TEX_MAG_FIL_B", "TexMagFilB", "0"),
   SHADOW_CLIP_FRUSTRUM("of.options.shaders.SHADOW_CLIP_FRUSTRUM", "shadowClipFrustrum", "true"),
   OLD_LIGHTING("of.options.shaders.OLD_LIGHTING", "oldLighting", "default"),
   CLOUD_SHADOW("of.options.shaders.CLOUD_SHADOW", "cloudShadow", "true"),
   HAND_DEPTH_MUL("of.options.shaders.HAND_DEPTH_MUL", "handDepthMul", "0.125"),
   SHADER_PACK("of.options.shaders.SHADER_PACK", "shaderPack", "");

   private String resourceKey = null;
   RENDER_RES_MUL("of.options.shaders.RENDER_RES_MUL", "renderResMul", "1.0"),
   ANTIALIASING("of.options.shaders.ANTIALIASING", "antialiasingLevel", "0"),
   SHADOW_RES_MUL("of.options.shaders.SHADOW_RES_MUL", "shadowResMul", "1.0"),
   TEX_MIN_FIL_B("of.options.shaders.TEX_MIN_FIL_B", "TexMinFilB", "0");

   private String valueDefault = null;
   TEX_MAG_FIL_N("of.options.shaders.TEX_MAG_FIL_N", "TexMagFilN", "0"),
   OLD_HAND_LIGHT("of.options.shaders.OLD_HAND_LIGHT", "oldHandLight", "default"),
   TEX_MIN_FIL_S("of.options.shaders.TEX_MIN_FIL_S", "TexMinFilS", "0"),
   TEX_MIN_FIL_N("of.options.shaders.TEX_MIN_FIL_N", "TexMinFilN", "0");

   private static final EnumShaderOption[] ENUM$VALUES = new EnumShaderOption[]{ANTIALIASING, NORMAL_MAP, SPECULAR_MAP, RENDER_RES_MUL, SHADOW_RES_MUL, HAND_DEPTH_MUL, CLOUD_SHADOW, OLD_HAND_LIGHT, OLD_LIGHTING, SHADER_PACK, TWEAK_BLOCK_DAMAGE, SHADOW_CLIP_FRUSTRUM, TEX_MIN_FIL_B, TEX_MIN_FIL_N, TEX_MIN_FIL_S, TEX_MAG_FIL_B, TEX_MAG_FIL_N, TEX_MAG_FIL_S};
   TWEAK_BLOCK_DAMAGE("of.options.shaders.TWEAK_BLOCK_DAMAGE", "tweakBlockDamage", "false");

   public String getResourceKey() {
      return this.resourceKey;
   }

   public String getPropertyKey() {
      return this.propertyKey;
   }

   private EnumShaderOption(String var3, String var4, String var5) {
      this.resourceKey = var3;
      this.propertyKey = var4;
      this.valueDefault = var5;
   }

   public String getValueDefault() {
      return this.valueDefault;
   }
}
