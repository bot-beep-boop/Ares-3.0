package net.optifine;

import java.util.Properties;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.config.ConnectedParser;
import net.optifine.config.Matches;
import net.optifine.config.NbtTagValue;
import net.optifine.config.RangeInt;
import net.optifine.config.RangeListInt;
import net.optifine.config.VillagerProfession;
import net.optifine.config.Weather;
import net.optifine.reflect.Reflector;
import net.optifine.util.ArrayUtils;
import net.optifine.util.MathUtils;

public class RandomEntityRule {
   private RangeListInt healthRange = null;
   public int sumAllWeights = 1;
   private int index;
   private EnumDyeColor[] collarColors = null;
   private String pathProps = null;
   private boolean healthPercent = false;
   private Boolean baby = null;
   private int[] textures = null;
   private Weather[] weatherList = null;
   private int[] weights = null;
   private VillagerProfession[] professions = null;
   private ResourceLocation baseResLoc = null;
   private RangeListInt moonPhases = null;
   public int[] sumWeights = null;
   private RangeListInt dayTimes = null;
   private ResourceLocation[] resourceLocations = null;
   private NbtTagValue nbtName = null;
   private RangeListInt heights = null;
   private BiomeGenBase[] biomes = null;

   private RangeListInt parseMinMaxHeight(Properties var1, int var2) {
      String var3 = var1.getProperty("minHeight." + var2);
      String var4 = var1.getProperty("maxHeight." + var2);
      if (var3 == null && var4 == null) {
         return null;
      } else {
         int var5 = 0;
         if (var3 != null) {
            var5 = Config.parseInt(var3, -1);
            if (var5 < 0) {
               Config.warn("Invalid minHeight: " + var3);
               return null;
            }
         }

         int var6 = 256;
         if (var4 != null) {
            var6 = Config.parseInt(var4, -1);
            if (var6 < 0) {
               Config.warn("Invalid maxHeight: " + var4);
               return null;
            }
         }

         if (var6 < 0) {
            Config.warn("Invalid minHeight, maxHeight: " + var3 + ", " + var4);
            return null;
         } else {
            RangeListInt var7 = new RangeListInt();
            var7.addRange(new RangeInt(var5, var6));
            return var7;
         }
      }
   }

   public ResourceLocation getTextureLocation(ResourceLocation var1, int var2) {
      if (this.resourceLocations != null && this.resourceLocations.length != 0) {
         int var3 = 0;
         if (this.weights == null) {
            var3 = var2 % this.resourceLocations.length;
         } else {
            int var4 = var2 % this.sumAllWeights;

            for(int var5 = 0; var5 < this.sumWeights.length; ++var5) {
               if (this.sumWeights[var5] > var4) {
                  var3 = var5;
                  break;
               }
            }
         }

         return this.resourceLocations[var3];
      } else {
         return var1;
      }
   }

   public RandomEntityRule(Properties var1, String var2, ResourceLocation var3, int var4, String var5, ConnectedParser var6) {
      this.pathProps = var2;
      this.baseResLoc = var3;
      this.index = var4;
      this.textures = var6.parseIntList(var5);
      this.weights = var6.parseIntList(var1.getProperty("weights." + var4));
      this.biomes = var6.parseBiomes(var1.getProperty("biomes." + var4));
      this.heights = var6.parseRangeListInt(var1.getProperty("heights." + var4));
      if (this.heights == null) {
         this.heights = this.parseMinMaxHeight(var1, var4);
      }

      String var7 = var1.getProperty("health." + var4);
      if (var7 != null) {
         this.healthPercent = var7.contains("%");
         var7 = var7.replace("%", "");
         this.healthRange = var6.parseRangeListInt(var7);
      }

      this.nbtName = var6.parseNbtTagValue("name", var1.getProperty("name." + var4));
      this.professions = var6.parseProfessions(var1.getProperty("professions." + var4));
      this.collarColors = var6.parseDyeColors(var1.getProperty("collarColors." + var4), "collar color", ConnectedParser.DYE_COLORS_INVALID);
      this.baby = var6.parseBooleanObject(var1.getProperty("baby." + var4));
      this.moonPhases = var6.parseRangeListInt(var1.getProperty("moonPhase." + var4));
      this.dayTimes = var6.parseRangeListInt(var1.getProperty("dayTime." + var4));
      this.weatherList = var6.parseWeather(var1.getProperty("weather." + var4), "weather." + var4, (Weather[])null);
   }

   public boolean matches(IRandomEntity var1) {
      if (this.biomes != null && !Matches.biome(var1.getSpawnBiome(), this.biomes)) {
         return false;
      } else {
         if (this.heights != null) {
            BlockPos var2 = var1.getSpawnPosition();
            if (var2 != null && !this.heights.isInRange(var2.getY())) {
               return false;
            }
         }

         int var3;
         if (this.healthRange != null) {
            int var10 = var1.getHealth();
            if (this.healthPercent) {
               var3 = var1.getMaxHealth();
               if (var3 > 0) {
                  var10 = (int)((double)(var10 * 100) / (double)var3);
               }
            }

            if (!this.healthRange.isInRange(var10)) {
               return false;
            }
         }

         if (this.nbtName != null) {
            String var11 = var1.getName();
            if (!this.nbtName.matchesValue(var11)) {
               return false;
            }
         }

         Entity var12;
         RandomEntity var13;
         if (this.professions != null && var1 instanceof RandomEntity) {
            var13 = (RandomEntity)var1;
            var12 = var13.getEntity();
            if (var12 instanceof EntityVillager) {
               EntityVillager var4 = (EntityVillager)var12;
               int var5 = var4.getProfession();
               int var6 = Reflector.getFieldValueInt(var4, Reflector.EntityVillager_careerId, -1);
               if (var5 < 0 || var6 < 0) {
                  return false;
               }

               boolean var7 = false;

               for(int var8 = 0; var8 < this.professions.length; ++var8) {
                  VillagerProfession var9 = this.professions[var8];
                  if (var9.matches(var5, var6)) {
                     var7 = true;
                     break;
                  }
               }

               if (!var7) {
                  return false;
               }
            }
         }

         if (this.collarColors != null && var1 instanceof RandomEntity) {
            var13 = (RandomEntity)var1;
            var12 = var13.getEntity();
            if (var12 instanceof EntityWolf) {
               EntityWolf var14 = (EntityWolf)var12;
               if (!var14.isTamed()) {
                  return false;
               }

               EnumDyeColor var18 = var14.getCollarColor();
               if (!Config.equalsOne(var18, this.collarColors)) {
                  return false;
               }
            }
         }

         if (this.baby != null && var1 instanceof RandomEntity) {
            var13 = (RandomEntity)var1;
            var12 = var13.getEntity();
            if (var12 instanceof EntityLiving) {
               EntityLiving var15 = (EntityLiving)var12;
               if (var15.isChild() != this.baby) {
                  return false;
               }
            }
         }

         WorldClient var16;
         if (this.moonPhases != null) {
            var16 = Config.getMinecraft().theWorld;
            if (var16 != null) {
               var3 = var16.getMoonPhase();
               if (!this.moonPhases.isInRange(var3)) {
                  return false;
               }
            }
         }

         if (this.dayTimes != null) {
            var16 = Config.getMinecraft().theWorld;
            if (var16 != null) {
               var3 = (int)var16.getWorldInfo().getWorldTime();
               if (!this.dayTimes.isInRange(var3)) {
                  return false;
               }
            }
         }

         if (this.weatherList != null) {
            var16 = Config.getMinecraft().theWorld;
            if (var16 != null) {
               Weather var17 = Weather.getWeather(var16, 0.0F);
               if (!ArrayUtils.contains(this.weatherList, var17)) {
                  return false;
               }
            }
         }

         return true;
      }
   }

   public boolean isValid(String var1) {
      if (this.textures != null && this.textures.length != 0) {
         if (this.resourceLocations != null) {
            return true;
         } else {
            this.resourceLocations = new ResourceLocation[this.textures.length];
            boolean var2 = this.pathProps.startsWith("mcpatcher/mob/");
            ResourceLocation var3 = RandomEntities.getLocationRandom(this.baseResLoc, var2);
            if (var3 == null) {
               Config.warn("Invalid path: " + this.baseResLoc.getResourcePath());
               return false;
            } else {
               int var4;
               int var5;
               for(var4 = 0; var4 < this.resourceLocations.length; ++var4) {
                  var5 = this.textures[var4];
                  if (var5 <= 1) {
                     this.resourceLocations[var4] = this.baseResLoc;
                  } else {
                     ResourceLocation var6 = RandomEntities.getLocationIndexed(var3, var5);
                     if (var6 == null) {
                        Config.warn("Invalid path: " + this.baseResLoc.getResourcePath());
                        return false;
                     }

                     if (!Config.hasResource(var6)) {
                        Config.warn("Texture not found: " + var6.getResourcePath());
                        return false;
                     }

                     this.resourceLocations[var4] = var6;
                  }
               }

               if (this.weights != null) {
                  int[] var7;
                  if (this.weights.length > this.resourceLocations.length) {
                     Config.warn("More weights defined than skins, trimming weights: " + var1);
                     var7 = new int[this.resourceLocations.length];
                     System.arraycopy(this.weights, 0, var7, 0, var7.length);
                     this.weights = var7;
                  }

                  if (this.weights.length < this.resourceLocations.length) {
                     Config.warn("Less weights defined than skins, expanding weights: " + var1);
                     var7 = new int[this.resourceLocations.length];
                     System.arraycopy(this.weights, 0, var7, 0, this.weights.length);
                     var5 = MathUtils.getAverage(this.weights);

                     for(int var8 = this.weights.length; var8 < var7.length; ++var8) {
                        var7[var8] = var5;
                     }

                     this.weights = var7;
                  }

                  this.sumWeights = new int[this.weights.length];
                  var4 = 0;

                  for(var5 = 0; var5 < this.weights.length; ++var5) {
                     if (this.weights[var5] < 0) {
                        Config.warn("Invalid weight: " + this.weights[var5]);
                        return false;
                     }

                     var4 += this.weights[var5];
                     this.sumWeights[var5] = var4;
                  }

                  this.sumAllWeights = var4;
                  if (this.sumAllWeights <= 0) {
                     Config.warn("Invalid sum of all weights: " + var4);
                     this.sumAllWeights = 1;
                  }
               }

               if (this.professions == ConnectedParser.PROFESSIONS_INVALID) {
                  Config.warn("Invalid professions or careers: " + var1);
                  return false;
               } else if (this.collarColors == ConnectedParser.DYE_COLORS_INVALID) {
                  Config.warn("Invalid collar colors: " + var1);
                  return false;
               } else {
                  return true;
               }
            }
         }
      } else {
         Config.warn("Invalid skins for rule: " + this.index);
         return false;
      }
   }
}
