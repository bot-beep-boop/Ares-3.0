package net.minecraft.world.gen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import net.minecraft.util.JsonUtils;
import net.minecraft.world.biome.BiomeGenBase;

public class ChunkProviderSettings {
   public final float lowerLimitScale;
   public final float depthNoiseScaleExponent;
   public final boolean useRavines;
   public final int ironSize;
   public final int riverSize;
   public final int biomeSize;
   public final int dioriteMaxHeight;
   public final boolean useDungeons;
   public final int lavaLakeChance;
   public final boolean useWaterLakes;
   public final int andesiteMinHeight;
   public final int goldSize;
   public final int graniteSize;
   public final float upperLimitScale;
   public final int gravelMaxHeight;
   public final boolean useMonuments;
   public final int graniteMaxHeight;
   public final boolean useLavaLakes;
   public final int andesiteCount;
   public final int gravelCount;
   public final int seaLevel;
   public final int dirtCount;
   public final int redstoneCount;
   public final int diamondCount;
   public final float mainNoiseScaleZ;
   public final int dirtSize;
   public final int ironMinHeight;
   public final int dirtMinHeight;
   public final boolean useMineShafts;
   public final float depthNoiseScaleX;
   public final float depthNoiseScaleZ;
   public final boolean useVillages;
   public final int andesiteMaxHeight;
   public final float biomeScaleWeight;
   public final int lapisSize;
   public final int ironCount;
   public final boolean useStrongholds;
   public final int coalSize;
   public final int redstoneMinHeight;
   public final int coalMaxHeight;
   public final int waterLakeChance;
   public final int diamondSize;
   public final int coalCount;
   public final float baseSize;
   public final int coalMinHeight;
   public final float mainNoiseScaleX;
   public final int lapisCenterHeight;
   public final boolean useCaves;
   public final int gravelSize;
   public final float heightScale;
   public final int dioriteCount;
   public final float mainNoiseScaleY;
   public final float coordinateScale;
   public final int goldCount;
   public final int diamondMinHeight;
   public final boolean useTemples;
   public final int goldMaxHeight;
   public final int andesiteSize;
   public final int gravelMinHeight;
   public final int graniteMinHeight;
   public final float biomeDepthOffSet;
   public final float biomeScaleOffset;
   public final int diamondMaxHeight;
   public final int redstoneSize;
   public final int fixedBiome;
   public final int dioriteMinHeight;
   public final int ironMaxHeight;
   public final int dirtMaxHeight;
   public final float biomeDepthWeight;
   public final int dungeonChance;
   public final float stretchY;
   public final int lapisCount;
   public final int lapisSpread;
   public final int graniteCount;
   public final int dioriteSize;
   public final boolean useLavaOceans;
   public final int redstoneMaxHeight;
   public final int goldMinHeight;

   private ChunkProviderSettings(ChunkProviderSettings.Factory var1) {
      this.coordinateScale = var1.coordinateScale;
      this.heightScale = var1.heightScale;
      this.upperLimitScale = var1.upperLimitScale;
      this.lowerLimitScale = var1.lowerLimitScale;
      this.depthNoiseScaleX = var1.depthNoiseScaleX;
      this.depthNoiseScaleZ = var1.depthNoiseScaleZ;
      this.depthNoiseScaleExponent = var1.depthNoiseScaleExponent;
      this.mainNoiseScaleX = var1.mainNoiseScaleX;
      this.mainNoiseScaleY = var1.mainNoiseScaleY;
      this.mainNoiseScaleZ = var1.mainNoiseScaleZ;
      this.baseSize = var1.baseSize;
      this.stretchY = var1.stretchY;
      this.biomeDepthWeight = var1.biomeDepthWeight;
      this.biomeDepthOffSet = var1.biomeDepthOffset;
      this.biomeScaleWeight = var1.biomeScaleWeight;
      this.biomeScaleOffset = var1.biomeScaleOffset;
      this.seaLevel = var1.seaLevel;
      this.useCaves = var1.useCaves;
      this.useDungeons = var1.useDungeons;
      this.dungeonChance = var1.dungeonChance;
      this.useStrongholds = var1.useStrongholds;
      this.useVillages = var1.useVillages;
      this.useMineShafts = var1.useMineShafts;
      this.useTemples = var1.useTemples;
      this.useMonuments = var1.useMonuments;
      this.useRavines = var1.useRavines;
      this.useWaterLakes = var1.useWaterLakes;
      this.waterLakeChance = var1.waterLakeChance;
      this.useLavaLakes = var1.useLavaLakes;
      this.lavaLakeChance = var1.lavaLakeChance;
      this.useLavaOceans = var1.useLavaOceans;
      this.fixedBiome = var1.fixedBiome;
      this.biomeSize = var1.biomeSize;
      this.riverSize = var1.riverSize;
      this.dirtSize = var1.dirtSize;
      this.dirtCount = var1.dirtCount;
      this.dirtMinHeight = var1.dirtMinHeight;
      this.dirtMaxHeight = var1.dirtMaxHeight;
      this.gravelSize = var1.gravelSize;
      this.gravelCount = var1.gravelCount;
      this.gravelMinHeight = var1.gravelMinHeight;
      this.gravelMaxHeight = var1.gravelMaxHeight;
      this.graniteSize = var1.graniteSize;
      this.graniteCount = var1.graniteCount;
      this.graniteMinHeight = var1.graniteMinHeight;
      this.graniteMaxHeight = var1.graniteMaxHeight;
      this.dioriteSize = var1.dioriteSize;
      this.dioriteCount = var1.dioriteCount;
      this.dioriteMinHeight = var1.dioriteMinHeight;
      this.dioriteMaxHeight = var1.dioriteMaxHeight;
      this.andesiteSize = var1.andesiteSize;
      this.andesiteCount = var1.andesiteCount;
      this.andesiteMinHeight = var1.andesiteMinHeight;
      this.andesiteMaxHeight = var1.andesiteMaxHeight;
      this.coalSize = var1.coalSize;
      this.coalCount = var1.coalCount;
      this.coalMinHeight = var1.coalMinHeight;
      this.coalMaxHeight = var1.coalMaxHeight;
      this.ironSize = var1.ironSize;
      this.ironCount = var1.ironCount;
      this.ironMinHeight = var1.ironMinHeight;
      this.ironMaxHeight = var1.ironMaxHeight;
      this.goldSize = var1.goldSize;
      this.goldCount = var1.goldCount;
      this.goldMinHeight = var1.goldMinHeight;
      this.goldMaxHeight = var1.goldMaxHeight;
      this.redstoneSize = var1.redstoneSize;
      this.redstoneCount = var1.redstoneCount;
      this.redstoneMinHeight = var1.redstoneMinHeight;
      this.redstoneMaxHeight = var1.redstoneMaxHeight;
      this.diamondSize = var1.diamondSize;
      this.diamondCount = var1.diamondCount;
      this.diamondMinHeight = var1.diamondMinHeight;
      this.diamondMaxHeight = var1.diamondMaxHeight;
      this.lapisSize = var1.lapisSize;
      this.lapisCount = var1.lapisCount;
      this.lapisCenterHeight = var1.lapisCenterHeight;
      this.lapisSpread = var1.lapisSpread;
   }

   ChunkProviderSettings(ChunkProviderSettings.Factory var1, ChunkProviderSettings var2) {
      this(var1);
   }

   public static class Factory {
      public int redstoneMaxHeight = 16;
      public float lowerLimitScale = 512.0F;
      public int gravelCount = 8;
      public int redstoneCount = 8;
      public boolean useCaves = true;
      public int seaLevel = 63;
      public boolean useMineShafts = true;
      public boolean useMonuments = true;
      public int diamondMinHeight = 0;
      public int redstoneMinHeight = 0;
      public boolean useLavaOceans = false;
      public int lapisCenterHeight = 16;
      public int ironCount = 20;
      public int dirtMaxHeight = 256;
      public int dioriteMinHeight = 0;
      public float biomeDepthOffset = 0.0F;
      public int coalCount = 20;
      public int fixedBiome = -1;
      public int goldSize = 9;
      public int waterLakeChance = 4;
      public float mainNoiseScaleX = 80.0F;
      public int gravelMaxHeight = 256;
      public float depthNoiseScaleX = 200.0F;
      public int ironSize = 9;
      public float biomeScaleWeight = 1.0F;
      public int andesiteCount = 10;
      public int dirtSize = 33;
      public int lavaLakeChance = 80;
      public int lapisSpread = 16;
      public int diamondSize = 8;
      public int coalMinHeight = 0;
      public float heightScale = 684.412F;
      public int gravelSize = 33;
      public int gravelMinHeight = 0;
      public boolean useStrongholds = true;
      public int diamondCount = 1;
      public float mainNoiseScaleZ = 80.0F;
      public int dioriteCount = 10;
      public int dirtMinHeight = 0;
      public int goldMaxHeight = 32;
      public float coordinateScale = 684.412F;
      public boolean useLavaLakes = true;
      public int dioriteSize = 33;
      public int goldCount = 2;
      public int diamondMaxHeight = 16;
      public int dungeonChance = 8;
      public int ironMaxHeight = 64;
      public boolean useTemples = true;
      public int lapisSize = 7;
      public boolean useVillages = true;
      public int coalMaxHeight = 128;
      public int andesiteSize = 33;
      public int ironMinHeight = 0;
      public float biomeDepthWeight = 1.0F;
      public int graniteMaxHeight = 80;
      public int dirtCount = 10;
      public int dioriteMaxHeight = 80;
      public float mainNoiseScaleY = 160.0F;
      public boolean useRavines = true;
      public int goldMinHeight = 0;
      public float depthNoiseScaleExponent = 0.5F;
      public float depthNoiseScaleZ = 200.0F;
      public int graniteMinHeight = 0;
      public int coalSize = 17;
      public float upperLimitScale = 512.0F;
      public float baseSize = 8.5F;
      public float biomeScaleOffset = 0.0F;
      public int andesiteMaxHeight = 80;
      static final Gson JSON_ADAPTER = (new GsonBuilder()).registerTypeAdapter(ChunkProviderSettings.Factory.class, new ChunkProviderSettings.Serializer()).create();
      public int riverSize = 4;
      public float stretchY = 12.0F;
      public int andesiteMinHeight = 0;
      public int redstoneSize = 8;
      public int biomeSize = 4;
      public int graniteCount = 10;
      public int graniteSize = 33;
      public boolean useWaterLakes = true;
      public int lapisCount = 1;
      public boolean useDungeons = true;

      public Factory() {
         this.func_177863_a();
      }

      public void func_177863_a() {
         this.coordinateScale = 684.412F;
         this.heightScale = 684.412F;
         this.upperLimitScale = 512.0F;
         this.lowerLimitScale = 512.0F;
         this.depthNoiseScaleX = 200.0F;
         this.depthNoiseScaleZ = 200.0F;
         this.depthNoiseScaleExponent = 0.5F;
         this.mainNoiseScaleX = 80.0F;
         this.mainNoiseScaleY = 160.0F;
         this.mainNoiseScaleZ = 80.0F;
         this.baseSize = 8.5F;
         this.stretchY = 12.0F;
         this.biomeDepthWeight = 1.0F;
         this.biomeDepthOffset = 0.0F;
         this.biomeScaleWeight = 1.0F;
         this.biomeScaleOffset = 0.0F;
         this.seaLevel = 63;
         this.useCaves = true;
         this.useDungeons = true;
         this.dungeonChance = 8;
         this.useStrongholds = true;
         this.useVillages = true;
         this.useMineShafts = true;
         this.useTemples = true;
         this.useMonuments = true;
         this.useRavines = true;
         this.useWaterLakes = true;
         this.waterLakeChance = 4;
         this.useLavaLakes = true;
         this.lavaLakeChance = 80;
         this.useLavaOceans = false;
         this.fixedBiome = -1;
         this.biomeSize = 4;
         this.riverSize = 4;
         this.dirtSize = 33;
         this.dirtCount = 10;
         this.dirtMinHeight = 0;
         this.dirtMaxHeight = 256;
         this.gravelSize = 33;
         this.gravelCount = 8;
         this.gravelMinHeight = 0;
         this.gravelMaxHeight = 256;
         this.graniteSize = 33;
         this.graniteCount = 10;
         this.graniteMinHeight = 0;
         this.graniteMaxHeight = 80;
         this.dioriteSize = 33;
         this.dioriteCount = 10;
         this.dioriteMinHeight = 0;
         this.dioriteMaxHeight = 80;
         this.andesiteSize = 33;
         this.andesiteCount = 10;
         this.andesiteMinHeight = 0;
         this.andesiteMaxHeight = 80;
         this.coalSize = 17;
         this.coalCount = 20;
         this.coalMinHeight = 0;
         this.coalMaxHeight = 128;
         this.ironSize = 9;
         this.ironCount = 20;
         this.ironMinHeight = 0;
         this.ironMaxHeight = 64;
         this.goldSize = 9;
         this.goldCount = 2;
         this.goldMinHeight = 0;
         this.goldMaxHeight = 32;
         this.redstoneSize = 8;
         this.redstoneCount = 8;
         this.redstoneMinHeight = 0;
         this.redstoneMaxHeight = 16;
         this.diamondSize = 8;
         this.diamondCount = 1;
         this.diamondMinHeight = 0;
         this.diamondMaxHeight = 16;
         this.lapisSize = 7;
         this.lapisCount = 1;
         this.lapisCenterHeight = 16;
         this.lapisSpread = 16;
      }

      public static ChunkProviderSettings.Factory jsonToFactory(String var0) {
         if (var0.length() == 0) {
            return new ChunkProviderSettings.Factory();
         } else {
            try {
               return (ChunkProviderSettings.Factory)JSON_ADAPTER.fromJson(var0, ChunkProviderSettings.Factory.class);
            } catch (Exception var2) {
               return new ChunkProviderSettings.Factory();
            }
         }
      }

      public int hashCode() {
         int var1 = this.coordinateScale != 0.0F ? Float.floatToIntBits(this.coordinateScale) : 0;
         var1 = 31 * var1 + (this.heightScale != 0.0F ? Float.floatToIntBits(this.heightScale) : 0);
         var1 = 31 * var1 + (this.upperLimitScale != 0.0F ? Float.floatToIntBits(this.upperLimitScale) : 0);
         var1 = 31 * var1 + (this.lowerLimitScale != 0.0F ? Float.floatToIntBits(this.lowerLimitScale) : 0);
         var1 = 31 * var1 + (this.depthNoiseScaleX != 0.0F ? Float.floatToIntBits(this.depthNoiseScaleX) : 0);
         var1 = 31 * var1 + (this.depthNoiseScaleZ != 0.0F ? Float.floatToIntBits(this.depthNoiseScaleZ) : 0);
         var1 = 31 * var1 + (this.depthNoiseScaleExponent != 0.0F ? Float.floatToIntBits(this.depthNoiseScaleExponent) : 0);
         var1 = 31 * var1 + (this.mainNoiseScaleX != 0.0F ? Float.floatToIntBits(this.mainNoiseScaleX) : 0);
         var1 = 31 * var1 + (this.mainNoiseScaleY != 0.0F ? Float.floatToIntBits(this.mainNoiseScaleY) : 0);
         var1 = 31 * var1 + (this.mainNoiseScaleZ != 0.0F ? Float.floatToIntBits(this.mainNoiseScaleZ) : 0);
         var1 = 31 * var1 + (this.baseSize != 0.0F ? Float.floatToIntBits(this.baseSize) : 0);
         var1 = 31 * var1 + (this.stretchY != 0.0F ? Float.floatToIntBits(this.stretchY) : 0);
         var1 = 31 * var1 + (this.biomeDepthWeight != 0.0F ? Float.floatToIntBits(this.biomeDepthWeight) : 0);
         var1 = 31 * var1 + (this.biomeDepthOffset != 0.0F ? Float.floatToIntBits(this.biomeDepthOffset) : 0);
         var1 = 31 * var1 + (this.biomeScaleWeight != 0.0F ? Float.floatToIntBits(this.biomeScaleWeight) : 0);
         var1 = 31 * var1 + (this.biomeScaleOffset != 0.0F ? Float.floatToIntBits(this.biomeScaleOffset) : 0);
         var1 = 31 * var1 + this.seaLevel;
         var1 = 31 * var1 + (this.useCaves ? 1 : 0);
         var1 = 31 * var1 + (this.useDungeons ? 1 : 0);
         var1 = 31 * var1 + this.dungeonChance;
         var1 = 31 * var1 + (this.useStrongholds ? 1 : 0);
         var1 = 31 * var1 + (this.useVillages ? 1 : 0);
         var1 = 31 * var1 + (this.useMineShafts ? 1 : 0);
         var1 = 31 * var1 + (this.useTemples ? 1 : 0);
         var1 = 31 * var1 + (this.useMonuments ? 1 : 0);
         var1 = 31 * var1 + (this.useRavines ? 1 : 0);
         var1 = 31 * var1 + (this.useWaterLakes ? 1 : 0);
         var1 = 31 * var1 + this.waterLakeChance;
         var1 = 31 * var1 + (this.useLavaLakes ? 1 : 0);
         var1 = 31 * var1 + this.lavaLakeChance;
         var1 = 31 * var1 + (this.useLavaOceans ? 1 : 0);
         var1 = 31 * var1 + this.fixedBiome;
         var1 = 31 * var1 + this.biomeSize;
         var1 = 31 * var1 + this.riverSize;
         var1 = 31 * var1 + this.dirtSize;
         var1 = 31 * var1 + this.dirtCount;
         var1 = 31 * var1 + this.dirtMinHeight;
         var1 = 31 * var1 + this.dirtMaxHeight;
         var1 = 31 * var1 + this.gravelSize;
         var1 = 31 * var1 + this.gravelCount;
         var1 = 31 * var1 + this.gravelMinHeight;
         var1 = 31 * var1 + this.gravelMaxHeight;
         var1 = 31 * var1 + this.graniteSize;
         var1 = 31 * var1 + this.graniteCount;
         var1 = 31 * var1 + this.graniteMinHeight;
         var1 = 31 * var1 + this.graniteMaxHeight;
         var1 = 31 * var1 + this.dioriteSize;
         var1 = 31 * var1 + this.dioriteCount;
         var1 = 31 * var1 + this.dioriteMinHeight;
         var1 = 31 * var1 + this.dioriteMaxHeight;
         var1 = 31 * var1 + this.andesiteSize;
         var1 = 31 * var1 + this.andesiteCount;
         var1 = 31 * var1 + this.andesiteMinHeight;
         var1 = 31 * var1 + this.andesiteMaxHeight;
         var1 = 31 * var1 + this.coalSize;
         var1 = 31 * var1 + this.coalCount;
         var1 = 31 * var1 + this.coalMinHeight;
         var1 = 31 * var1 + this.coalMaxHeight;
         var1 = 31 * var1 + this.ironSize;
         var1 = 31 * var1 + this.ironCount;
         var1 = 31 * var1 + this.ironMinHeight;
         var1 = 31 * var1 + this.ironMaxHeight;
         var1 = 31 * var1 + this.goldSize;
         var1 = 31 * var1 + this.goldCount;
         var1 = 31 * var1 + this.goldMinHeight;
         var1 = 31 * var1 + this.goldMaxHeight;
         var1 = 31 * var1 + this.redstoneSize;
         var1 = 31 * var1 + this.redstoneCount;
         var1 = 31 * var1 + this.redstoneMinHeight;
         var1 = 31 * var1 + this.redstoneMaxHeight;
         var1 = 31 * var1 + this.diamondSize;
         var1 = 31 * var1 + this.diamondCount;
         var1 = 31 * var1 + this.diamondMinHeight;
         var1 = 31 * var1 + this.diamondMaxHeight;
         var1 = 31 * var1 + this.lapisSize;
         var1 = 31 * var1 + this.lapisCount;
         var1 = 31 * var1 + this.lapisCenterHeight;
         var1 = 31 * var1 + this.lapisSpread;
         return var1;
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (var1 != null && this.getClass() == var1.getClass()) {
            ChunkProviderSettings.Factory var2 = (ChunkProviderSettings.Factory)var1;
            if (this.andesiteCount != var2.andesiteCount) {
               return false;
            } else if (this.andesiteMaxHeight != var2.andesiteMaxHeight) {
               return false;
            } else if (this.andesiteMinHeight != var2.andesiteMinHeight) {
               return false;
            } else if (this.andesiteSize != var2.andesiteSize) {
               return false;
            } else if (Float.compare(var2.baseSize, this.baseSize) != 0) {
               return false;
            } else if (Float.compare(var2.biomeDepthOffset, this.biomeDepthOffset) != 0) {
               return false;
            } else if (Float.compare(var2.biomeDepthWeight, this.biomeDepthWeight) != 0) {
               return false;
            } else if (Float.compare(var2.biomeScaleOffset, this.biomeScaleOffset) != 0) {
               return false;
            } else if (Float.compare(var2.biomeScaleWeight, this.biomeScaleWeight) != 0) {
               return false;
            } else if (this.biomeSize != var2.biomeSize) {
               return false;
            } else if (this.coalCount != var2.coalCount) {
               return false;
            } else if (this.coalMaxHeight != var2.coalMaxHeight) {
               return false;
            } else if (this.coalMinHeight != var2.coalMinHeight) {
               return false;
            } else if (this.coalSize != var2.coalSize) {
               return false;
            } else if (Float.compare(var2.coordinateScale, this.coordinateScale) != 0) {
               return false;
            } else if (Float.compare(var2.depthNoiseScaleExponent, this.depthNoiseScaleExponent) != 0) {
               return false;
            } else if (Float.compare(var2.depthNoiseScaleX, this.depthNoiseScaleX) != 0) {
               return false;
            } else if (Float.compare(var2.depthNoiseScaleZ, this.depthNoiseScaleZ) != 0) {
               return false;
            } else if (this.diamondCount != var2.diamondCount) {
               return false;
            } else if (this.diamondMaxHeight != var2.diamondMaxHeight) {
               return false;
            } else if (this.diamondMinHeight != var2.diamondMinHeight) {
               return false;
            } else if (this.diamondSize != var2.diamondSize) {
               return false;
            } else if (this.dioriteCount != var2.dioriteCount) {
               return false;
            } else if (this.dioriteMaxHeight != var2.dioriteMaxHeight) {
               return false;
            } else if (this.dioriteMinHeight != var2.dioriteMinHeight) {
               return false;
            } else if (this.dioriteSize != var2.dioriteSize) {
               return false;
            } else if (this.dirtCount != var2.dirtCount) {
               return false;
            } else if (this.dirtMaxHeight != var2.dirtMaxHeight) {
               return false;
            } else if (this.dirtMinHeight != var2.dirtMinHeight) {
               return false;
            } else if (this.dirtSize != var2.dirtSize) {
               return false;
            } else if (this.dungeonChance != var2.dungeonChance) {
               return false;
            } else if (this.fixedBiome != var2.fixedBiome) {
               return false;
            } else if (this.goldCount != var2.goldCount) {
               return false;
            } else if (this.goldMaxHeight != var2.goldMaxHeight) {
               return false;
            } else if (this.goldMinHeight != var2.goldMinHeight) {
               return false;
            } else if (this.goldSize != var2.goldSize) {
               return false;
            } else if (this.graniteCount != var2.graniteCount) {
               return false;
            } else if (this.graniteMaxHeight != var2.graniteMaxHeight) {
               return false;
            } else if (this.graniteMinHeight != var2.graniteMinHeight) {
               return false;
            } else if (this.graniteSize != var2.graniteSize) {
               return false;
            } else if (this.gravelCount != var2.gravelCount) {
               return false;
            } else if (this.gravelMaxHeight != var2.gravelMaxHeight) {
               return false;
            } else if (this.gravelMinHeight != var2.gravelMinHeight) {
               return false;
            } else if (this.gravelSize != var2.gravelSize) {
               return false;
            } else if (Float.compare(var2.heightScale, this.heightScale) != 0) {
               return false;
            } else if (this.ironCount != var2.ironCount) {
               return false;
            } else if (this.ironMaxHeight != var2.ironMaxHeight) {
               return false;
            } else if (this.ironMinHeight != var2.ironMinHeight) {
               return false;
            } else if (this.ironSize != var2.ironSize) {
               return false;
            } else if (this.lapisCenterHeight != var2.lapisCenterHeight) {
               return false;
            } else if (this.lapisCount != var2.lapisCount) {
               return false;
            } else if (this.lapisSize != var2.lapisSize) {
               return false;
            } else if (this.lapisSpread != var2.lapisSpread) {
               return false;
            } else if (this.lavaLakeChance != var2.lavaLakeChance) {
               return false;
            } else if (Float.compare(var2.lowerLimitScale, this.lowerLimitScale) != 0) {
               return false;
            } else if (Float.compare(var2.mainNoiseScaleX, this.mainNoiseScaleX) != 0) {
               return false;
            } else if (Float.compare(var2.mainNoiseScaleY, this.mainNoiseScaleY) != 0) {
               return false;
            } else if (Float.compare(var2.mainNoiseScaleZ, this.mainNoiseScaleZ) != 0) {
               return false;
            } else if (this.redstoneCount != var2.redstoneCount) {
               return false;
            } else if (this.redstoneMaxHeight != var2.redstoneMaxHeight) {
               return false;
            } else if (this.redstoneMinHeight != var2.redstoneMinHeight) {
               return false;
            } else if (this.redstoneSize != var2.redstoneSize) {
               return false;
            } else if (this.riverSize != var2.riverSize) {
               return false;
            } else if (this.seaLevel != var2.seaLevel) {
               return false;
            } else if (Float.compare(var2.stretchY, this.stretchY) != 0) {
               return false;
            } else if (Float.compare(var2.upperLimitScale, this.upperLimitScale) != 0) {
               return false;
            } else if (this.useCaves != var2.useCaves) {
               return false;
            } else if (this.useDungeons != var2.useDungeons) {
               return false;
            } else if (this.useLavaLakes != var2.useLavaLakes) {
               return false;
            } else if (this.useLavaOceans != var2.useLavaOceans) {
               return false;
            } else if (this.useMineShafts != var2.useMineShafts) {
               return false;
            } else if (this.useRavines != var2.useRavines) {
               return false;
            } else if (this.useStrongholds != var2.useStrongholds) {
               return false;
            } else if (this.useTemples != var2.useTemples) {
               return false;
            } else if (this.useMonuments != var2.useMonuments) {
               return false;
            } else if (this.useVillages != var2.useVillages) {
               return false;
            } else if (this.useWaterLakes != var2.useWaterLakes) {
               return false;
            } else {
               return this.waterLakeChance == var2.waterLakeChance;
            }
         } else {
            return false;
         }
      }

      public String toString() {
         return JSON_ADAPTER.toJson(this);
      }

      public ChunkProviderSettings func_177864_b() {
         return new ChunkProviderSettings(this, (ChunkProviderSettings)null);
      }
   }

   public static class Serializer implements JsonDeserializer<ChunkProviderSettings.Factory>, JsonSerializer<ChunkProviderSettings.Factory> {
      public ChunkProviderSettings.Factory deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         ChunkProviderSettings.Factory var5 = new ChunkProviderSettings.Factory();

         try {
            var5.coordinateScale = JsonUtils.getFloat(var4, "coordinateScale", var5.coordinateScale);
            var5.heightScale = JsonUtils.getFloat(var4, "heightScale", var5.heightScale);
            var5.lowerLimitScale = JsonUtils.getFloat(var4, "lowerLimitScale", var5.lowerLimitScale);
            var5.upperLimitScale = JsonUtils.getFloat(var4, "upperLimitScale", var5.upperLimitScale);
            var5.depthNoiseScaleX = JsonUtils.getFloat(var4, "depthNoiseScaleX", var5.depthNoiseScaleX);
            var5.depthNoiseScaleZ = JsonUtils.getFloat(var4, "depthNoiseScaleZ", var5.depthNoiseScaleZ);
            var5.depthNoiseScaleExponent = JsonUtils.getFloat(var4, "depthNoiseScaleExponent", var5.depthNoiseScaleExponent);
            var5.mainNoiseScaleX = JsonUtils.getFloat(var4, "mainNoiseScaleX", var5.mainNoiseScaleX);
            var5.mainNoiseScaleY = JsonUtils.getFloat(var4, "mainNoiseScaleY", var5.mainNoiseScaleY);
            var5.mainNoiseScaleZ = JsonUtils.getFloat(var4, "mainNoiseScaleZ", var5.mainNoiseScaleZ);
            var5.baseSize = JsonUtils.getFloat(var4, "baseSize", var5.baseSize);
            var5.stretchY = JsonUtils.getFloat(var4, "stretchY", var5.stretchY);
            var5.biomeDepthWeight = JsonUtils.getFloat(var4, "biomeDepthWeight", var5.biomeDepthWeight);
            var5.biomeDepthOffset = JsonUtils.getFloat(var4, "biomeDepthOffset", var5.biomeDepthOffset);
            var5.biomeScaleWeight = JsonUtils.getFloat(var4, "biomeScaleWeight", var5.biomeScaleWeight);
            var5.biomeScaleOffset = JsonUtils.getFloat(var4, "biomeScaleOffset", var5.biomeScaleOffset);
            var5.seaLevel = JsonUtils.getInt(var4, "seaLevel", var5.seaLevel);
            var5.useCaves = JsonUtils.getBoolean(var4, "useCaves", var5.useCaves);
            var5.useDungeons = JsonUtils.getBoolean(var4, "useDungeons", var5.useDungeons);
            var5.dungeonChance = JsonUtils.getInt(var4, "dungeonChance", var5.dungeonChance);
            var5.useStrongholds = JsonUtils.getBoolean(var4, "useStrongholds", var5.useStrongholds);
            var5.useVillages = JsonUtils.getBoolean(var4, "useVillages", var5.useVillages);
            var5.useMineShafts = JsonUtils.getBoolean(var4, "useMineShafts", var5.useMineShafts);
            var5.useTemples = JsonUtils.getBoolean(var4, "useTemples", var5.useTemples);
            var5.useMonuments = JsonUtils.getBoolean(var4, "useMonuments", var5.useMonuments);
            var5.useRavines = JsonUtils.getBoolean(var4, "useRavines", var5.useRavines);
            var5.useWaterLakes = JsonUtils.getBoolean(var4, "useWaterLakes", var5.useWaterLakes);
            var5.waterLakeChance = JsonUtils.getInt(var4, "waterLakeChance", var5.waterLakeChance);
            var5.useLavaLakes = JsonUtils.getBoolean(var4, "useLavaLakes", var5.useLavaLakes);
            var5.lavaLakeChance = JsonUtils.getInt(var4, "lavaLakeChance", var5.lavaLakeChance);
            var5.useLavaOceans = JsonUtils.getBoolean(var4, "useLavaOceans", var5.useLavaOceans);
            var5.fixedBiome = JsonUtils.getInt(var4, "fixedBiome", var5.fixedBiome);
            if (var5.fixedBiome < 38 && var5.fixedBiome >= -1) {
               if (var5.fixedBiome >= BiomeGenBase.hell.biomeID) {
                  var5.fixedBiome += 2;
               }
            } else {
               var5.fixedBiome = -1;
            }

            var5.biomeSize = JsonUtils.getInt(var4, "biomeSize", var5.biomeSize);
            var5.riverSize = JsonUtils.getInt(var4, "riverSize", var5.riverSize);
            var5.dirtSize = JsonUtils.getInt(var4, "dirtSize", var5.dirtSize);
            var5.dirtCount = JsonUtils.getInt(var4, "dirtCount", var5.dirtCount);
            var5.dirtMinHeight = JsonUtils.getInt(var4, "dirtMinHeight", var5.dirtMinHeight);
            var5.dirtMaxHeight = JsonUtils.getInt(var4, "dirtMaxHeight", var5.dirtMaxHeight);
            var5.gravelSize = JsonUtils.getInt(var4, "gravelSize", var5.gravelSize);
            var5.gravelCount = JsonUtils.getInt(var4, "gravelCount", var5.gravelCount);
            var5.gravelMinHeight = JsonUtils.getInt(var4, "gravelMinHeight", var5.gravelMinHeight);
            var5.gravelMaxHeight = JsonUtils.getInt(var4, "gravelMaxHeight", var5.gravelMaxHeight);
            var5.graniteSize = JsonUtils.getInt(var4, "graniteSize", var5.graniteSize);
            var5.graniteCount = JsonUtils.getInt(var4, "graniteCount", var5.graniteCount);
            var5.graniteMinHeight = JsonUtils.getInt(var4, "graniteMinHeight", var5.graniteMinHeight);
            var5.graniteMaxHeight = JsonUtils.getInt(var4, "graniteMaxHeight", var5.graniteMaxHeight);
            var5.dioriteSize = JsonUtils.getInt(var4, "dioriteSize", var5.dioriteSize);
            var5.dioriteCount = JsonUtils.getInt(var4, "dioriteCount", var5.dioriteCount);
            var5.dioriteMinHeight = JsonUtils.getInt(var4, "dioriteMinHeight", var5.dioriteMinHeight);
            var5.dioriteMaxHeight = JsonUtils.getInt(var4, "dioriteMaxHeight", var5.dioriteMaxHeight);
            var5.andesiteSize = JsonUtils.getInt(var4, "andesiteSize", var5.andesiteSize);
            var5.andesiteCount = JsonUtils.getInt(var4, "andesiteCount", var5.andesiteCount);
            var5.andesiteMinHeight = JsonUtils.getInt(var4, "andesiteMinHeight", var5.andesiteMinHeight);
            var5.andesiteMaxHeight = JsonUtils.getInt(var4, "andesiteMaxHeight", var5.andesiteMaxHeight);
            var5.coalSize = JsonUtils.getInt(var4, "coalSize", var5.coalSize);
            var5.coalCount = JsonUtils.getInt(var4, "coalCount", var5.coalCount);
            var5.coalMinHeight = JsonUtils.getInt(var4, "coalMinHeight", var5.coalMinHeight);
            var5.coalMaxHeight = JsonUtils.getInt(var4, "coalMaxHeight", var5.coalMaxHeight);
            var5.ironSize = JsonUtils.getInt(var4, "ironSize", var5.ironSize);
            var5.ironCount = JsonUtils.getInt(var4, "ironCount", var5.ironCount);
            var5.ironMinHeight = JsonUtils.getInt(var4, "ironMinHeight", var5.ironMinHeight);
            var5.ironMaxHeight = JsonUtils.getInt(var4, "ironMaxHeight", var5.ironMaxHeight);
            var5.goldSize = JsonUtils.getInt(var4, "goldSize", var5.goldSize);
            var5.goldCount = JsonUtils.getInt(var4, "goldCount", var5.goldCount);
            var5.goldMinHeight = JsonUtils.getInt(var4, "goldMinHeight", var5.goldMinHeight);
            var5.goldMaxHeight = JsonUtils.getInt(var4, "goldMaxHeight", var5.goldMaxHeight);
            var5.redstoneSize = JsonUtils.getInt(var4, "redstoneSize", var5.redstoneSize);
            var5.redstoneCount = JsonUtils.getInt(var4, "redstoneCount", var5.redstoneCount);
            var5.redstoneMinHeight = JsonUtils.getInt(var4, "redstoneMinHeight", var5.redstoneMinHeight);
            var5.redstoneMaxHeight = JsonUtils.getInt(var4, "redstoneMaxHeight", var5.redstoneMaxHeight);
            var5.diamondSize = JsonUtils.getInt(var4, "diamondSize", var5.diamondSize);
            var5.diamondCount = JsonUtils.getInt(var4, "diamondCount", var5.diamondCount);
            var5.diamondMinHeight = JsonUtils.getInt(var4, "diamondMinHeight", var5.diamondMinHeight);
            var5.diamondMaxHeight = JsonUtils.getInt(var4, "diamondMaxHeight", var5.diamondMaxHeight);
            var5.lapisSize = JsonUtils.getInt(var4, "lapisSize", var5.lapisSize);
            var5.lapisCount = JsonUtils.getInt(var4, "lapisCount", var5.lapisCount);
            var5.lapisCenterHeight = JsonUtils.getInt(var4, "lapisCenterHeight", var5.lapisCenterHeight);
            var5.lapisSpread = JsonUtils.getInt(var4, "lapisSpread", var5.lapisSpread);
         } catch (Exception var7) {
         }

         return var5;
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.deserialize(var1, var2, var3);
      }

      public JsonElement serialize(ChunkProviderSettings.Factory var1, Type var2, JsonSerializationContext var3) {
         JsonObject var4 = new JsonObject();
         var4.addProperty("coordinateScale", var1.coordinateScale);
         var4.addProperty("heightScale", var1.heightScale);
         var4.addProperty("lowerLimitScale", var1.lowerLimitScale);
         var4.addProperty("upperLimitScale", var1.upperLimitScale);
         var4.addProperty("depthNoiseScaleX", var1.depthNoiseScaleX);
         var4.addProperty("depthNoiseScaleZ", var1.depthNoiseScaleZ);
         var4.addProperty("depthNoiseScaleExponent", var1.depthNoiseScaleExponent);
         var4.addProperty("mainNoiseScaleX", var1.mainNoiseScaleX);
         var4.addProperty("mainNoiseScaleY", var1.mainNoiseScaleY);
         var4.addProperty("mainNoiseScaleZ", var1.mainNoiseScaleZ);
         var4.addProperty("baseSize", var1.baseSize);
         var4.addProperty("stretchY", var1.stretchY);
         var4.addProperty("biomeDepthWeight", var1.biomeDepthWeight);
         var4.addProperty("biomeDepthOffset", var1.biomeDepthOffset);
         var4.addProperty("biomeScaleWeight", var1.biomeScaleWeight);
         var4.addProperty("biomeScaleOffset", var1.biomeScaleOffset);
         var4.addProperty("seaLevel", var1.seaLevel);
         var4.addProperty("useCaves", var1.useCaves);
         var4.addProperty("useDungeons", var1.useDungeons);
         var4.addProperty("dungeonChance", var1.dungeonChance);
         var4.addProperty("useStrongholds", var1.useStrongholds);
         var4.addProperty("useVillages", var1.useVillages);
         var4.addProperty("useMineShafts", var1.useMineShafts);
         var4.addProperty("useTemples", var1.useTemples);
         var4.addProperty("useMonuments", var1.useMonuments);
         var4.addProperty("useRavines", var1.useRavines);
         var4.addProperty("useWaterLakes", var1.useWaterLakes);
         var4.addProperty("waterLakeChance", var1.waterLakeChance);
         var4.addProperty("useLavaLakes", var1.useLavaLakes);
         var4.addProperty("lavaLakeChance", var1.lavaLakeChance);
         var4.addProperty("useLavaOceans", var1.useLavaOceans);
         var4.addProperty("fixedBiome", var1.fixedBiome);
         var4.addProperty("biomeSize", var1.biomeSize);
         var4.addProperty("riverSize", var1.riverSize);
         var4.addProperty("dirtSize", var1.dirtSize);
         var4.addProperty("dirtCount", var1.dirtCount);
         var4.addProperty("dirtMinHeight", var1.dirtMinHeight);
         var4.addProperty("dirtMaxHeight", var1.dirtMaxHeight);
         var4.addProperty("gravelSize", var1.gravelSize);
         var4.addProperty("gravelCount", var1.gravelCount);
         var4.addProperty("gravelMinHeight", var1.gravelMinHeight);
         var4.addProperty("gravelMaxHeight", var1.gravelMaxHeight);
         var4.addProperty("graniteSize", var1.graniteSize);
         var4.addProperty("graniteCount", var1.graniteCount);
         var4.addProperty("graniteMinHeight", var1.graniteMinHeight);
         var4.addProperty("graniteMaxHeight", var1.graniteMaxHeight);
         var4.addProperty("dioriteSize", var1.dioriteSize);
         var4.addProperty("dioriteCount", var1.dioriteCount);
         var4.addProperty("dioriteMinHeight", var1.dioriteMinHeight);
         var4.addProperty("dioriteMaxHeight", var1.dioriteMaxHeight);
         var4.addProperty("andesiteSize", var1.andesiteSize);
         var4.addProperty("andesiteCount", var1.andesiteCount);
         var4.addProperty("andesiteMinHeight", var1.andesiteMinHeight);
         var4.addProperty("andesiteMaxHeight", var1.andesiteMaxHeight);
         var4.addProperty("coalSize", var1.coalSize);
         var4.addProperty("coalCount", var1.coalCount);
         var4.addProperty("coalMinHeight", var1.coalMinHeight);
         var4.addProperty("coalMaxHeight", var1.coalMaxHeight);
         var4.addProperty("ironSize", var1.ironSize);
         var4.addProperty("ironCount", var1.ironCount);
         var4.addProperty("ironMinHeight", var1.ironMinHeight);
         var4.addProperty("ironMaxHeight", var1.ironMaxHeight);
         var4.addProperty("goldSize", var1.goldSize);
         var4.addProperty("goldCount", var1.goldCount);
         var4.addProperty("goldMinHeight", var1.goldMinHeight);
         var4.addProperty("goldMaxHeight", var1.goldMaxHeight);
         var4.addProperty("redstoneSize", var1.redstoneSize);
         var4.addProperty("redstoneCount", var1.redstoneCount);
         var4.addProperty("redstoneMinHeight", var1.redstoneMinHeight);
         var4.addProperty("redstoneMaxHeight", var1.redstoneMaxHeight);
         var4.addProperty("diamondSize", var1.diamondSize);
         var4.addProperty("diamondCount", var1.diamondCount);
         var4.addProperty("diamondMinHeight", var1.diamondMinHeight);
         var4.addProperty("diamondMaxHeight", var1.diamondMaxHeight);
         var4.addProperty("lapisSize", var1.lapisSize);
         var4.addProperty("lapisCount", var1.lapisCount);
         var4.addProperty("lapisCenterHeight", var1.lapisCenterHeight);
         var4.addProperty("lapisSpread", var1.lapisSpread);
         return var4;
      }

      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.serialize((ChunkProviderSettings.Factory)var1, var2, var3);
      }
   }
}
