package net.optifine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.config.ConnectedParser;
import net.optifine.config.Matches;
import net.optifine.config.RangeListInt;
import net.optifine.render.Blender;
import net.optifine.util.NumUtils;
import net.optifine.util.SmoothFloat;
import net.optifine.util.TextureUtils;

public class CustomSkyLayer {
   public String source = null;
   private RangeListInt days;
   private int startFadeOut = -1;
   private boolean weatherRain;
   private SmoothFloat smoothPositionBrightness;
   private int blend = 1;
   public RangeListInt heights;
   private boolean weatherThunder;
   private static final String WEATHER_CLEAR = "clear";
   public static final float[] DEFAULT_AXIS = new float[]{1.0F, 0.0F, 0.0F};
   private float speed = 1.0F;
   private boolean weatherClear;
   private int endFadeIn = -1;
   private boolean rotate = false;
   private World lastWorld;
   public BiomeGenBase[] biomes;
   private static final String WEATHER_THUNDER = "thunder";
   private int startFadeIn = -1;
   private int endFadeOut = -1;
   private float transition;
   public int textureId;
   private static final String WEATHER_RAIN = "rain";
   private int daysLoop;
   private float[] axis;

   private int parseTime(String var1) {
      if (var1 == null) {
         return -1;
      } else {
         String[] var2 = Config.tokenize(var1, ":");
         if (var2.length != 2) {
            Config.warn("Invalid time: " + var1);
            return -1;
         } else {
            String var3 = var2[0];
            String var4 = var2[1];
            int var5 = Config.parseInt(var3, -1);
            int var6 = Config.parseInt(var4, -1);
            if (var5 >= 0 && var5 <= 23 && var6 >= 0 && var6 <= 59) {
               var5 -= 6;
               if (var5 < 0) {
                  var5 += 24;
               }

               int var7 = var5 * 1000 + (int)((double)var6 / 60.0D * 1000.0D);
               return var7;
            } else {
               Config.warn("Invalid time: " + var1);
               return -1;
            }
         }
      }
   }

   private boolean parseBoolean(String var1, boolean var2) {
      if (var1 == null) {
         return var2;
      } else if (var1.toLowerCase().equals("true")) {
         return true;
      } else if (var1.toLowerCase().equals("false")) {
         return false;
      } else {
         Config.warn("Unknown boolean: " + var1);
         return var2;
      }
   }

   public CustomSkyLayer(Properties var1, String var2) {
      this.axis = DEFAULT_AXIS;
      this.days = null;
      this.daysLoop = 8;
      this.weatherClear = true;
      this.weatherRain = false;
      this.weatherThunder = false;
      this.biomes = null;
      this.heights = null;
      this.transition = 1.0F;
      this.smoothPositionBrightness = null;
      this.textureId = -1;
      this.lastWorld = null;
      ConnectedParser var3 = new ConnectedParser("CustomSky");
      this.source = var1.getProperty("source", var2);
      this.startFadeIn = this.parseTime(var1.getProperty("startFadeIn"));
      this.endFadeIn = this.parseTime(var1.getProperty("endFadeIn"));
      this.startFadeOut = this.parseTime(var1.getProperty("startFadeOut"));
      this.endFadeOut = this.parseTime(var1.getProperty("endFadeOut"));
      this.blend = Blender.parseBlend(var1.getProperty("blend"));
      this.rotate = this.parseBoolean(var1.getProperty("rotate"), true);
      this.speed = this.parseFloat(var1.getProperty("speed"), 1.0F);
      this.axis = this.parseAxis(var1.getProperty("axis"), DEFAULT_AXIS);
      this.days = var3.parseRangeListInt(var1.getProperty("days"));
      this.daysLoop = var3.parseInt(var1.getProperty("daysLoop"), 8);
      List var4 = this.parseWeatherList(var1.getProperty("weather", "clear"));
      this.weatherClear = var4.contains("clear");
      this.weatherRain = var4.contains("rain");
      this.weatherThunder = var4.contains("thunder");
      this.biomes = var3.parseBiomes(var1.getProperty("biomes"));
      this.heights = var3.parseRangeListInt(var1.getProperty("heights"));
      this.transition = this.parseFloat(var1.getProperty("transition"), 1.0F);
   }

   private List<String> parseWeatherList(String var1) {
      List var2 = Arrays.asList("clear", "rain", "thunder");
      ArrayList var3 = new ArrayList();
      String[] var4 = Config.tokenize(var1, " ");

      for(int var5 = 0; var5 < var4.length; ++var5) {
         String var6 = var4[var5];
         if (!var2.contains(var6)) {
            Config.warn("Unknown weather: " + var6);
         } else {
            var3.add(var6);
         }
      }

      return var3;
   }

   private float parseFloat(String var1, float var2) {
      if (var1 == null) {
         return var2;
      } else {
         float var3 = Config.parseFloat(var1, Float.MIN_VALUE);
         if (var3 == Float.MIN_VALUE) {
            Config.warn("Invalid value: " + var1);
            return var2;
         } else {
            return var3;
         }
      }
   }

   private float getWeatherBrightness(float var1, float var2) {
      float var3 = 1.0F - var1;
      float var4 = var1 - var2;
      float var5 = 0.0F;
      if (this.weatherClear) {
         var5 += var3;
      }

      if (this.weatherRain) {
         var5 += var4;
      }

      if (this.weatherThunder) {
         var5 += var2;
      }

      var5 = NumUtils.limit(var5, 0.0F, 1.0F);
      return var5;
   }

   private void renderSide(Tessellator var1, int var2) {
      WorldRenderer var3 = var1.getWorldRenderer();
      double var4 = (double)(var2 % 3) / 3.0D;
      double var6 = (double)(var2 / 3) / 2.0D;
      var3.begin(7, DefaultVertexFormats.POSITION_TEX);
      var3.pos(-100.0D, -100.0D, -100.0D).tex(var4, var6).endVertex();
      var3.pos(-100.0D, -100.0D, 100.0D).tex(var4, var6 + 0.5D).endVertex();
      var3.pos(100.0D, -100.0D, 100.0D).tex(var4 + 0.3333333333333333D, var6 + 0.5D).endVertex();
      var3.pos(100.0D, -100.0D, -100.0D).tex(var4 + 0.3333333333333333D, var6).endVertex();
      var1.draw();
   }

   private float[] parseAxis(String var1, float[] var2) {
      if (var1 == null) {
         return var2;
      } else {
         String[] var3 = Config.tokenize(var1, " ");
         if (var3.length != 3) {
            Config.warn("Invalid axis: " + var1);
            return var2;
         } else {
            float[] var4 = new float[3];

            for(int var5 = 0; var5 < var3.length; ++var5) {
               var4[var5] = Config.parseFloat(var3[var5], Float.MIN_VALUE);
               if (var4[var5] == Float.MIN_VALUE) {
                  Config.warn("Invalid axis: " + var1);
                  return var2;
               }

               if (var4[var5] < -1.0F || var4[var5] > 1.0F) {
                  Config.warn("Invalid axis values: " + var1);
                  return var2;
               }
            }

            float var9 = var4[0];
            float var6 = var4[1];
            float var7 = var4[2];
            if (var9 * var9 + var6 * var6 + var7 * var7 < 1.0E-5F) {
               Config.warn("Invalid axis values: " + var1);
               return var2;
            } else {
               float[] var8 = new float[]{var7, var6, -var9};
               return var8;
            }
         }
      }
   }

   public boolean isValid(String var1) {
      if (this.source == null) {
         Config.warn("No source texture: " + var1);
         return false;
      } else {
         this.source = TextureUtils.fixResourcePath(this.source, TextureUtils.getBasePath(var1));
         if (this.startFadeIn >= 0 && this.endFadeIn >= 0 && this.endFadeOut >= 0) {
            int var2 = this.normalizeTime(this.endFadeIn - this.startFadeIn);
            if (this.startFadeOut < 0) {
               this.startFadeOut = this.normalizeTime(this.endFadeOut - var2);
               if (this.timeBetween(this.startFadeOut, this.startFadeIn, this.endFadeIn)) {
                  this.startFadeOut = this.endFadeIn;
               }
            }

            int var3 = this.normalizeTime(this.startFadeOut - this.endFadeIn);
            int var4 = this.normalizeTime(this.endFadeOut - this.startFadeOut);
            int var5 = this.normalizeTime(this.startFadeIn - this.endFadeOut);
            int var6 = var2 + var3 + var4 + var5;
            if (var6 != 24000) {
               Config.warn("Invalid fadeIn/fadeOut times, sum is not 24h: " + var6);
               return false;
            } else if (this.speed < 0.0F) {
               Config.warn("Invalid speed: " + this.speed);
               return false;
            } else if (this.daysLoop <= 0) {
               Config.warn("Invalid daysLoop: " + this.daysLoop);
               return false;
            } else {
               return true;
            }
         } else {
            Config.warn("Invalid times, required are: startFadeIn, endFadeIn and endFadeOut.");
            return false;
         }
      }
   }

   public boolean isActive(World var1, int var2) {
      if (var1 != this.lastWorld) {
         this.lastWorld = var1;
         this.smoothPositionBrightness = null;
      }

      if (this.timeBetween(var2, this.endFadeOut, this.startFadeIn)) {
         return false;
      } else {
         if (this.days != null) {
            long var3 = var1.getWorldTime();

            long var5;
            for(var5 = var3 - (long)this.startFadeIn; var5 < 0L; var5 += (long)(24000 * this.daysLoop)) {
            }

            int var7 = (int)(var5 / 24000L);
            int var8 = var7 % this.daysLoop;
            if (!this.days.isInRange(var8)) {
               return false;
            }
         }

         return true;
      }
   }

   private int normalizeTime(int var1) {
      while(var1 >= 24000) {
         var1 -= 24000;
      }

      while(var1 < 0) {
         var1 += 24000;
      }

      return var1;
   }

   public String toString() {
      return this.source + ", " + this.startFadeIn + "-" + this.endFadeIn + " " + this.startFadeOut + "-" + this.endFadeOut;
   }

   private float getPositionBrightness(World var1) {
      if (this.biomes == null && this.heights == null) {
         return 1.0F;
      } else {
         float var2 = this.getPositionBrightnessRaw(var1);
         if (this.smoothPositionBrightness == null) {
            this.smoothPositionBrightness = new SmoothFloat(var2, this.transition);
         }

         var2 = this.smoothPositionBrightness.getSmoothValue(var2);
         return var2;
      }
   }

   private boolean timeBetween(int var1, int var2, int var3) {
      if (var2 <= var3) {
         return var1 >= var2 && var1 <= var3;
      } else {
         return var1 >= var2 || var1 <= var3;
      }
   }

   private float getPositionBrightnessRaw(World var1) {
      Entity var2 = Minecraft.getMinecraft().getRenderViewEntity();
      if (var2 == null) {
         return 0.0F;
      } else {
         BlockPos var3 = var2.getPosition();
         if (this.biomes != null) {
            BiomeGenBase var4 = var1.getBiomeGenForCoords(var3);
            if (var4 == null) {
               return 0.0F;
            }

            if (!Matches.biome(var4, this.biomes)) {
               return 0.0F;
            }
         }

         return this.heights != null && !this.heights.isInRange(var3.getY()) ? 0.0F : 1.0F;
      }
   }

   private float getFadeBrightness(int var1) {
      int var2;
      int var3;
      if (this.timeBetween(var1, this.startFadeIn, this.endFadeIn)) {
         var2 = this.normalizeTime(this.endFadeIn - this.startFadeIn);
         var3 = this.normalizeTime(var1 - this.startFadeIn);
         return (float)var3 / (float)var2;
      } else if (this.timeBetween(var1, this.endFadeIn, this.startFadeOut)) {
         return 1.0F;
      } else if (this.timeBetween(var1, this.startFadeOut, this.endFadeOut)) {
         var2 = this.normalizeTime(this.endFadeOut - this.startFadeOut);
         var3 = this.normalizeTime(var1 - this.startFadeOut);
         return 1.0F - (float)var3 / (float)var2;
      } else {
         return 0.0F;
      }
   }

   public void render(World var1, int var2, float var3, float var4, float var5) {
      float var6 = this.getPositionBrightness(var1);
      float var7 = this.getWeatherBrightness(var4, var5);
      float var8 = this.getFadeBrightness(var2);
      float var9 = var6 * var7 * var8;
      var9 = Config.limit(var9, 0.0F, 1.0F);
      if (!(var9 < 1.0E-4F)) {
         GlStateManager.bindTexture(this.textureId);
         Blender.setupBlend(this.blend, var9);
         GlStateManager.pushMatrix();
         if (this.rotate) {
            float var10 = 0.0F;
            if (this.speed != (float)Math.round(this.speed)) {
               long var11 = (var1.getWorldTime() + 18000L) / 24000L;
               double var13 = (double)(this.speed % 1.0F);
               double var15 = (double)var11 * var13;
               var10 = (float)(var15 % 1.0D);
            }

            GlStateManager.rotate(360.0F * (var10 + var3 * this.speed), this.axis[0], this.axis[1], this.axis[2]);
         }

         Tessellator var17 = Tessellator.getInstance();
         GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
         GlStateManager.rotate(-90.0F, 0.0F, 0.0F, 1.0F);
         this.renderSide(var17, 4);
         GlStateManager.pushMatrix();
         GlStateManager.rotate(90.0F, 1.0F, 0.0F, 0.0F);
         this.renderSide(var17, 1);
         GlStateManager.popMatrix();
         GlStateManager.pushMatrix();
         GlStateManager.rotate(-90.0F, 1.0F, 0.0F, 0.0F);
         this.renderSide(var17, 0);
         GlStateManager.popMatrix();
         GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
         this.renderSide(var17, 5);
         GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
         this.renderSide(var17, 2);
         GlStateManager.rotate(90.0F, 0.0F, 0.0F, 1.0F);
         this.renderSide(var17, 3);
         GlStateManager.popMatrix();
      }

   }
}
