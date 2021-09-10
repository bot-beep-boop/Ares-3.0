package net.optifine.shaders.uniform;

import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.shaders.Shaders;

public enum ShaderParameterFloat {
   ASPECT_RATIO(Shaders.uniform_aspectRatio),
   IS_EYE_IN_WATER(Shaders.uniform_isEyeInWater);

   private String[] indexNames1;
   NIGHT_VISION(Shaders.uniform_nightVision),
   GBUFFER_PROJECTION(Shaders.uniform_gbufferProjection, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   SKY_COLOR(Shaders.uniform_skyColor, new String[]{"r", "g", "b"}),
   SCREEN_BRIGHTNESS(Shaders.uniform_screenBrightness),
   CAMERA_POSITION(Shaders.uniform_cameraPosition, new String[]{"x", "y", "z"}),
   SHADOW_LIGHT_POSITION(Shaders.uniform_shadowLightPosition, new String[]{"x", "y", "z"}),
   BIOME("biome"),
   HELD_BLOCK_LIGHT_VALUE2(Shaders.uniform_heldBlockLightValue2),
   NEAR(Shaders.uniform_near),
   HIDE_GUI(Shaders.uniform_hideGUI);

   private static final ShaderParameterFloat[] ENUM$VALUES = new ShaderParameterFloat[]{BIOME, TEMPERATURE, RAINFALL, HELD_ITEM_ID, HELD_BLOCK_LIGHT_VALUE, HELD_ITEM_ID2, HELD_BLOCK_LIGHT_VALUE2, WORLD_TIME, WORLD_DAY, MOON_PHASE, FRAME_COUNTER, FRAME_TIME, FRAME_TIME_COUNTER, SUN_ANGLE, SHADOW_ANGLE, RAIN_STRENGTH, ASPECT_RATIO, VIEW_WIDTH, VIEW_HEIGHT, NEAR, FAR, WETNESS, EYE_ALTITUDE, EYE_BRIGHTNESS, TERRAIN_TEXTURE_SIZE, TERRRAIN_ICON_SIZE, IS_EYE_IN_WATER, NIGHT_VISION, BLINDNESS, SCREEN_BRIGHTNESS, HIDE_GUI, CENTER_DEPT_SMOOTH, ATLAS_SIZE, CAMERA_POSITION, PREVIOUS_CAMERA_POSITION, SUN_POSITION, MOON_POSITION, SHADOW_LIGHT_POSITION, UP_POSITION, SKY_COLOR, GBUFFER_PROJECTION, GBUFFER_PROJECTION_INVERSE, GBUFFER_PREVIOUS_PROJECTION, GBUFFER_MODEL_VIEW, GBUFFER_MODEL_VIEW_INVERSE, GBUFFER_PREVIOUS_MODEL_VIEW, SHADOW_PROJECTION, SHADOW_PROJECTION_INVERSE, SHADOW_MODEL_VIEW, SHADOW_MODEL_VIEW_INVERSE};
   MOON_PHASE(Shaders.uniform_moonPhase),
   FAR(Shaders.uniform_far),
   FRAME_TIME_COUNTER(Shaders.uniform_frameTimeCounter),
   VIEW_HEIGHT(Shaders.uniform_viewHeight),
   GBUFFER_PREVIOUS_PROJECTION(Shaders.uniform_gbufferPreviousProjection, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   PREVIOUS_CAMERA_POSITION(Shaders.uniform_previousCameraPosition, new String[]{"x", "y", "z"}),
   GBUFFER_PREVIOUS_MODEL_VIEW(Shaders.uniform_gbufferPreviousModelView, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   HELD_ITEM_ID(Shaders.uniform_heldItemId);

   private String name;
   WORLD_DAY(Shaders.uniform_worldDay),
   FRAME_TIME(Shaders.uniform_frameTime),
   SHADOW_PROJECTION(Shaders.uniform_shadowProjection, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   WETNESS(Shaders.uniform_wetness),
   HELD_BLOCK_LIGHT_VALUE(Shaders.uniform_heldBlockLightValue),
   RAIN_STRENGTH(Shaders.uniform_rainStrength),
   SHADOW_MODEL_VIEW(Shaders.uniform_shadowModelView, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   GBUFFER_PROJECTION_INVERSE(Shaders.uniform_gbufferProjectionInverse, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   WORLD_TIME(Shaders.uniform_worldTime),
   HELD_ITEM_ID2(Shaders.uniform_heldItemId2),
   TERRRAIN_ICON_SIZE(Shaders.uniform_terrainIconSize),
   CENTER_DEPT_SMOOTH(Shaders.uniform_centerDepthSmooth),
   ATLAS_SIZE(Shaders.uniform_atlasSize, new String[]{"x", "y"}),
   SHADOW_PROJECTION_INVERSE(Shaders.uniform_shadowProjectionInverse, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"});

   private static int[] $SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterFloat;
   private ShaderUniformBase uniform;
   SHADOW_ANGLE(Shaders.uniform_shadowAngle),
   GBUFFER_MODEL_VIEW(Shaders.uniform_gbufferModelView, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   SUN_POSITION(Shaders.uniform_sunPosition, new String[]{"x", "y", "z"}),
   RAINFALL("rainfall"),
   SUN_ANGLE(Shaders.uniform_sunAngle),
   TERRAIN_TEXTURE_SIZE(Shaders.uniform_terrainTextureSize, new String[]{"x", "y"}),
   VIEW_WIDTH(Shaders.uniform_viewWidth),
   BLINDNESS(Shaders.uniform_blindness),
   GBUFFER_MODEL_VIEW_INVERSE(Shaders.uniform_gbufferModelViewInverse, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"}),
   EYE_BRIGHTNESS(Shaders.uniform_eyeBrightness, new String[]{"x", "y"}),
   SHADOW_MODEL_VIEW_INVERSE(Shaders.uniform_shadowModelViewInverse, new String[]{"0", "1", "2", "3"}, new String[]{"0", "1", "2", "3"});

   private String[] indexNames2;
   UP_POSITION(Shaders.uniform_upPosition, new String[]{"x", "y", "z"}),
   MOON_POSITION(Shaders.uniform_moonPosition, new String[]{"x", "y", "z"}),
   TEMPERATURE("temperature"),
   EYE_ALTITUDE(Shaders.uniform_eyeAltitude),
   FRAME_COUNTER(Shaders.uniform_frameCounter);

   public String getName() {
      return this.name;
   }

   public String[] getIndexNames1() {
      return this.indexNames1;
   }

   public String[] getIndexNames2() {
      return this.indexNames2;
   }

   private ShaderParameterFloat(ShaderUniformBase var3) {
      this.name = var3.getName();
      this.uniform = var3;
      if (!instanceOf(var3, ShaderUniform1f.class, ShaderUniform1i.class)) {
         throw new IllegalArgumentException("Invalid uniform type for enum: " + this + ", uniform: " + var3.getClass().getName());
      }
   }

   private ShaderParameterFloat(ShaderUniformBase var3, String[] var4, String[] var5) {
      this.name = var3.getName();
      this.uniform = var3;
      this.indexNames1 = var4;
      this.indexNames2 = var5;
      if (!instanceOf(var3, ShaderUniformM4.class)) {
         throw new IllegalArgumentException("Invalid uniform type for enum: " + this + ", uniform: " + var3.getClass().getName());
      }
   }

   private static boolean instanceOf(Object var0, Class... var1) {
      if (var0 == null) {
         return false;
      } else {
         Class var2 = var0.getClass();

         for(int var3 = 0; var3 < var1.length; ++var3) {
            Class var4 = var1[var3];
            if (var4.isAssignableFrom(var2)) {
               return true;
            }
         }

         return false;
      }
   }

   private ShaderParameterFloat(ShaderUniformBase var3, String[] var4) {
      this.name = var3.getName();
      this.uniform = var3;
      this.indexNames1 = var4;
      if (!instanceOf(var3, ShaderUniform2i.class, ShaderUniform2f.class, ShaderUniform3f.class, ShaderUniform4f.class)) {
         throw new IllegalArgumentException("Invalid uniform type for enum: " + this + ", uniform: " + var3.getClass().getName());
      }
   }

   static int[] $SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterFloat() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterFloat;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[values().length];

         try {
            var0[ASPECT_RATIO.ordinal()] = 17;
         } catch (NoSuchFieldError var50) {
         }

         try {
            var0[ATLAS_SIZE.ordinal()] = 33;
         } catch (NoSuchFieldError var49) {
         }

         try {
            var0[BIOME.ordinal()] = 1;
         } catch (NoSuchFieldError var48) {
         }

         try {
            var0[BLINDNESS.ordinal()] = 29;
         } catch (NoSuchFieldError var47) {
         }

         try {
            var0[CAMERA_POSITION.ordinal()] = 34;
         } catch (NoSuchFieldError var46) {
         }

         try {
            var0[CENTER_DEPT_SMOOTH.ordinal()] = 32;
         } catch (NoSuchFieldError var45) {
         }

         try {
            var0[EYE_ALTITUDE.ordinal()] = 23;
         } catch (NoSuchFieldError var44) {
         }

         try {
            var0[EYE_BRIGHTNESS.ordinal()] = 24;
         } catch (NoSuchFieldError var43) {
         }

         try {
            var0[FAR.ordinal()] = 21;
         } catch (NoSuchFieldError var42) {
         }

         try {
            var0[FRAME_COUNTER.ordinal()] = 11;
         } catch (NoSuchFieldError var41) {
         }

         try {
            var0[FRAME_TIME.ordinal()] = 12;
         } catch (NoSuchFieldError var40) {
         }

         try {
            var0[FRAME_TIME_COUNTER.ordinal()] = 13;
         } catch (NoSuchFieldError var39) {
         }

         try {
            var0[GBUFFER_MODEL_VIEW.ordinal()] = 44;
         } catch (NoSuchFieldError var38) {
         }

         try {
            var0[GBUFFER_MODEL_VIEW_INVERSE.ordinal()] = 45;
         } catch (NoSuchFieldError var37) {
         }

         try {
            var0[GBUFFER_PREVIOUS_MODEL_VIEW.ordinal()] = 46;
         } catch (NoSuchFieldError var36) {
         }

         try {
            var0[GBUFFER_PREVIOUS_PROJECTION.ordinal()] = 43;
         } catch (NoSuchFieldError var35) {
         }

         try {
            var0[GBUFFER_PROJECTION.ordinal()] = 41;
         } catch (NoSuchFieldError var34) {
         }

         try {
            var0[GBUFFER_PROJECTION_INVERSE.ordinal()] = 42;
         } catch (NoSuchFieldError var33) {
         }

         try {
            var0[HELD_BLOCK_LIGHT_VALUE.ordinal()] = 5;
         } catch (NoSuchFieldError var32) {
         }

         try {
            var0[HELD_BLOCK_LIGHT_VALUE2.ordinal()] = 7;
         } catch (NoSuchFieldError var31) {
         }

         try {
            var0[HELD_ITEM_ID.ordinal()] = 4;
         } catch (NoSuchFieldError var30) {
         }

         try {
            var0[HELD_ITEM_ID2.ordinal()] = 6;
         } catch (NoSuchFieldError var29) {
         }

         try {
            var0[HIDE_GUI.ordinal()] = 31;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[IS_EYE_IN_WATER.ordinal()] = 27;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[MOON_PHASE.ordinal()] = 10;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[MOON_POSITION.ordinal()] = 37;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[NEAR.ordinal()] = 20;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[NIGHT_VISION.ordinal()] = 28;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[PREVIOUS_CAMERA_POSITION.ordinal()] = 35;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[RAINFALL.ordinal()] = 3;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[RAIN_STRENGTH.ordinal()] = 16;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[SCREEN_BRIGHTNESS.ordinal()] = 30;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[SHADOW_ANGLE.ordinal()] = 15;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[SHADOW_LIGHT_POSITION.ordinal()] = 38;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[SHADOW_MODEL_VIEW.ordinal()] = 49;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[SHADOW_MODEL_VIEW_INVERSE.ordinal()] = 50;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[SHADOW_PROJECTION.ordinal()] = 47;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[SHADOW_PROJECTION_INVERSE.ordinal()] = 48;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[SKY_COLOR.ordinal()] = 40;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[SUN_ANGLE.ordinal()] = 14;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[SUN_POSITION.ordinal()] = 36;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[TEMPERATURE.ordinal()] = 2;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[TERRAIN_TEXTURE_SIZE.ordinal()] = 25;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[TERRRAIN_ICON_SIZE.ordinal()] = 26;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[UP_POSITION.ordinal()] = 39;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[VIEW_HEIGHT.ordinal()] = 19;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[VIEW_WIDTH.ordinal()] = 18;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[WETNESS.ordinal()] = 22;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[WORLD_DAY.ordinal()] = 9;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[WORLD_TIME.ordinal()] = 8;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterFloat = var0;
         return var0;
      }
   }

   public ShaderUniformBase getUniform() {
      return this.uniform;
   }

   public float eval(int var1, int var2) {
      if (this.indexNames1 != null && (var1 < 0 || var1 > this.indexNames1.length)) {
         Config.warn("Invalid index1, parameter: " + this + ", index: " + var1);
         return 0.0F;
      } else if (this.indexNames2 == null || var2 >= 0 && var2 <= this.indexNames2.length) {
         switch($SWITCH_TABLE$net$optifine$shaders$uniform$ShaderParameterFloat()[this.ordinal()]) {
         case 1:
            BlockPos var3 = Shaders.getCameraPosition();
            BiomeGenBase var4 = Shaders.getCurrentWorld().getBiomeGenForCoords(var3);
            return (float)var4.biomeID;
         case 2:
            BlockPos var5 = Shaders.getCameraPosition();
            BiomeGenBase var6 = Shaders.getCurrentWorld().getBiomeGenForCoords(var5);
            return var6 != null ? var6.getFloatTemperature(var5) : 0.0F;
         case 3:
            BlockPos var7 = Shaders.getCameraPosition();
            BiomeGenBase var8 = Shaders.getCurrentWorld().getBiomeGenForCoords(var7);
            return var8 != null ? var8.getFloatRainfall() : 0.0F;
         default:
            if (this.uniform instanceof ShaderUniform1f) {
               return ((ShaderUniform1f)this.uniform).getValue();
            } else if (this.uniform instanceof ShaderUniform1i) {
               return (float)((ShaderUniform1i)this.uniform).getValue();
            } else if (this.uniform instanceof ShaderUniform2i) {
               return (float)((ShaderUniform2i)this.uniform).getValue()[var1];
            } else if (this.uniform instanceof ShaderUniform2f) {
               return ((ShaderUniform2f)this.uniform).getValue()[var1];
            } else if (this.uniform instanceof ShaderUniform3f) {
               return ((ShaderUniform3f)this.uniform).getValue()[var1];
            } else if (this.uniform instanceof ShaderUniform4f) {
               return ((ShaderUniform4f)this.uniform).getValue()[var1];
            } else if (this.uniform instanceof ShaderUniformM4) {
               return ((ShaderUniformM4)this.uniform).getValue(var1, var2);
            } else {
               throw new IllegalArgumentException("Unknown uniform type: " + this);
            }
         }
      } else {
         Config.warn("Invalid index2, parameter: " + this + ", index: " + var2);
         return 0.0F;
      }
   }

   private ShaderParameterFloat(String var3) {
      this.name = var3;
   }
}
