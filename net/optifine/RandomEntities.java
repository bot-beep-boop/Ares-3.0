package net.optifine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.entity.DataWatcher;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorRaw;
import net.optifine.util.IntegratedServerUtils;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.ResUtils;
import net.optifine.util.StrUtils;

public class RandomEntities {
   private static Map<String, RandomEntityProperties> mapProperties = new HashMap();
   private static final String[] HORSE_TEXTURES_ABBR = (String[])ReflectorRaw.getFieldValue((Object)null, EntityHorse.class, String[].class, 1);
   private static final String[] DEPENDANT_SUFFIXES = new String[]{"_armor", "_eyes", "_exploding", "_shooting", "_fur", "_eyes", "_invulnerable", "_angry", "_tame", "_collar"};
   private static RandomEntity randomEntity = new RandomEntity();
   private static final String[] HORSE_TEXTURES = (String[])ReflectorRaw.getFieldValue((Object)null, EntityHorse.class, String[].class, 0);
   private static boolean working = false;
   private static RandomTileEntity randomTileEntity = new RandomTileEntity();
   private static final String PREFIX_DYNAMIC_TEXTURE_HORSE = "horse/";
   public static final String SUFFIX_PROPERTIES = ".properties";
   public static final String SUFFIX_PNG = ".png";
   private static TileEntityRendererDispatcher tileEntityRendererDispatcher;
   private static RenderGlobal renderGlobal;
   public static final String PREFIX_TEXTURES = "textures/";
   public static final String PREFIX_TEXTURES_ENTITY = "textures/entity/";
   public static final String PREFIX_OPTIFINE_RANDOM = "optifine/random/";
   private static boolean active = false;
   public static final String PREFIX_TEXTURES_PAINTING = "textures/painting/";
   public static final String PREFIX_MCPATCHER_MOB = "mcpatcher/mob/";

   protected static ResourceLocation getLocationIndexed(ResourceLocation var0, int var1) {
      if (var0 == null) {
         return null;
      } else {
         String var2 = var0.getResourcePath();
         int var3 = var2.lastIndexOf(46);
         if (var3 < 0) {
            return null;
         } else {
            String var4 = var2.substring(0, var3);
            String var5 = var2.substring(var3);
            String var6 = var4 + var1 + var5;
            ResourceLocation var7 = new ResourceLocation(var0.getResourceDomain(), var6);
            return var7;
         }
      }
   }

   private static RandomEntityProperties parseProperties(ResourceLocation var0, ResourceLocation var1) {
      try {
         String var2 = var0.getResourcePath();
         dbg(var1.getResourcePath() + ", properties: " + var2);
         InputStream var3 = Config.getResourceStream(var0);
         if (var3 == null) {
            warn("Properties not found: " + var2);
            return null;
         } else {
            PropertiesOrdered var4 = new PropertiesOrdered();
            var4.load(var3);
            var3.close();
            RandomEntityProperties var5 = new RandomEntityProperties(var4, var2, var1);
            return !var5.isValid(var2) ? null : var5;
         }
      } catch (FileNotFoundException var6) {
         warn("File not found: " + var1.getResourcePath());
         return null;
      } catch (IOException var7) {
         var7.printStackTrace();
         return null;
      }
   }

   public static void dbg(String var0) {
      Config.dbg("RandomEntities: " + var0);
   }

   private static ResourceLocation[] getLocationsVariants(ResourceLocation var0, boolean var1) {
      ArrayList var2 = new ArrayList();
      var2.add(var0);
      ResourceLocation var3 = getLocationRandom(var0, var1);
      if (var3 == null) {
         return null;
      } else {
         for(int var4 = 1; var4 < var2.size() + 10; ++var4) {
            int var5 = var4 + 1;
            ResourceLocation var6 = getLocationIndexed(var3, var5);
            if (Config.hasResource(var6)) {
               var2.add(var6);
            }
         }

         if (var2.size() <= 1) {
            return null;
         } else {
            ResourceLocation[] var7 = (ResourceLocation[])var2.toArray(new ResourceLocation[var2.size()]);
            dbg(var0.getResourcePath() + ", variants: " + var7.length);
            return var7;
         }
      }
   }

   public static void entityUnloaded(Entity var0, World var1) {
   }

   private static String getPathBase(String var0) {
      if (var0.startsWith("optifine/random/")) {
         return StrUtils.replacePrefix(var0, "optifine/random/", "textures/");
      } else {
         return var0.startsWith("mcpatcher/mob/") ? StrUtils.replacePrefix(var0, "mcpatcher/mob/", "textures/entity/") : null;
      }
   }

   private static RandomEntityProperties makeProperties(ResourceLocation var0, boolean var1) {
      String var2 = var0.getResourcePath();
      ResourceLocation var3 = getLocationProperties(var0, var1);
      if (var3 != null) {
         RandomEntityProperties var4 = parseProperties(var3, var0);
         if (var4 != null) {
            return var4;
         }
      }

      ResourceLocation[] var5 = getLocationsVariants(var0, var1);
      return var5 == null ? null : new RandomEntityProperties(var2, var5);
   }

   protected static ResourceLocation getLocationRandom(ResourceLocation var0, boolean var1) {
      String var2 = var0.getResourceDomain();
      String var3 = var0.getResourcePath();
      String var4 = "textures/";
      String var5 = "optifine/random/";
      if (var1) {
         var4 = "textures/entity/";
         var5 = "mcpatcher/mob/";
      }

      if (!var3.startsWith(var4)) {
         return null;
      } else {
         String var6 = StrUtils.replacePrefix(var3, var4, var5);
         return new ResourceLocation(var2, var6);
      }
   }

   private static String getHorseTexturePath(String var0, int var1) {
      if (HORSE_TEXTURES != null && HORSE_TEXTURES_ABBR != null) {
         for(int var2 = 0; var2 < HORSE_TEXTURES_ABBR.length; ++var2) {
            String var3 = HORSE_TEXTURES_ABBR[var2];
            if (var0.startsWith(var3, var1)) {
               return HORSE_TEXTURES[var2];
            }
         }

         return var0;
      } else {
         return var0;
      }
   }

   public static void update() {
      mapProperties.clear();
      active = false;
      if (Config.isRandomEntities()) {
         initialize();
      }

   }

   public static void warn(String var0) {
      Config.warn("RandomEntities: " + var0);
   }

   public static void worldChanged(World var0, World var1) {
      if (var1 != null) {
         List var2 = var1.getLoadedEntityList();

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            Entity var4 = (Entity)var2.get(var3);
            entityLoaded(var4, var1);
         }
      }

      randomEntity.setEntity((Entity)null);
      randomTileEntity.setTileEntity((TileEntity)null);
   }

   private static ResourceLocation getLocationProperties(ResourceLocation var0, boolean var1) {
      ResourceLocation var2 = getLocationRandom(var0, var1);
      if (var2 == null) {
         return null;
      } else {
         String var3 = var2.getResourceDomain();
         String var4 = var2.getResourcePath();
         String var5 = StrUtils.removeSuffix(var4, ".png");
         String var6 = var5 + ".properties";
         ResourceLocation var7 = new ResourceLocation(var3, var6);
         if (Config.hasResource(var7)) {
            return var7;
         } else {
            String var8 = getParentTexturePath(var5);
            if (var8 == null) {
               return null;
            } else {
               ResourceLocation var9 = new ResourceLocation(var3, var8 + ".properties");
               return Config.hasResource(var9) ? var9 : null;
            }
         }
      }
   }

   public static ResourceLocation getTextureLocation(ResourceLocation var0) {
      if (!active) {
         return var0;
      } else if (working) {
         return var0;
      } else {
         ResourceLocation var7;
         try {
            working = true;
            IRandomEntity var2 = getRandomEntityRendered();
            if (var2 == null) {
               working = false;
               return var0;
            }

            String var3 = var0.getResourcePath();
            if (var3.startsWith("horse/")) {
               var3 = getHorseTexturePath(var3, "horse/".length());
            }

            if (!var3.startsWith("textures/entity/") && !var3.startsWith("textures/painting/")) {
               var7 = var0;
               return var7;
            }

            RandomEntityProperties var4 = (RandomEntityProperties)mapProperties.get(var3);
            if (var4 != null) {
               ResourceLocation var5 = var4.getTextureLocation(var0, var2);
               var7 = var5;
               return var7;
            }

            var7 = var0;
         } finally {
            working = false;
         }

         return var7;
      }
   }

   private static IRandomEntity getRandomEntityRendered() {
      if (renderGlobal.renderedEntity != null) {
         randomEntity.setEntity(renderGlobal.renderedEntity);
         return randomEntity;
      } else {
         if (tileEntityRendererDispatcher.tileEntityRendered != null) {
            TileEntity var0 = tileEntityRendererDispatcher.tileEntityRendered;
            if (var0.getWorld() != null) {
               randomTileEntity.setTileEntity(var0);
               return randomTileEntity;
            }
         }

         return null;
      }
   }

   private static void initialize() {
      renderGlobal = Config.getRenderGlobal();
      tileEntityRendererDispatcher = TileEntityRendererDispatcher.instance;
      String[] var0 = new String[]{"optifine/random/", "mcpatcher/mob/"};
      String[] var1 = new String[]{".png", ".properties"};
      String[] var2 = ResUtils.collectFiles(var0, var1);
      HashSet var3 = new HashSet();

      for(int var4 = 0; var4 < var2.length; ++var4) {
         String var5 = var2[var4];
         var5 = StrUtils.removeSuffix(var5, var1);
         var5 = StrUtils.trimTrailing(var5, "0123456789");
         var5 = var5 + ".png";
         String var6 = getPathBase(var5);
         if (!var3.contains(var6)) {
            var3.add(var6);
            ResourceLocation var7 = new ResourceLocation(var6);
            if (Config.hasResource(var7)) {
               RandomEntityProperties var8 = (RandomEntityProperties)mapProperties.get(var6);
               if (var8 == null) {
                  var8 = makeProperties(var7, false);
                  if (var8 == null) {
                     var8 = makeProperties(var7, true);
                  }

                  if (var8 != null) {
                     mapProperties.put(var6, var8);
                  }
               }
            }
         }
      }

      active = !mapProperties.isEmpty();
   }

   public static void entityLoaded(Entity var0, World var1) {
      if (var1 != null) {
         DataWatcher var2 = var0.getDataWatcher();
         var2.spawnPosition = var0.getPosition();
         var2.spawnBiome = var1.getBiomeGenForCoords(var2.spawnPosition);
         UUID var3 = var0.getUniqueID();
         if (var0 instanceof EntityVillager) {
            updateEntityVillager(var3, (EntityVillager)var0);
         }
      }

   }

   private static String getParentTexturePath(String var0) {
      for(int var1 = 0; var1 < DEPENDANT_SUFFIXES.length; ++var1) {
         String var2 = DEPENDANT_SUFFIXES[var1];
         if (var0.endsWith(var2)) {
            String var3 = StrUtils.removeSuffix(var0, var2);
            return var3;
         }
      }

      return null;
   }

   private static void updateEntityVillager(UUID var0, EntityVillager var1) {
      Entity var2 = IntegratedServerUtils.getEntity(var0);
      if (var2 instanceof EntityVillager) {
         EntityVillager var3 = (EntityVillager)var2;
         int var4 = var3.getProfession();
         var1.setProfession(var4);
         int var5 = Reflector.getFieldValueInt(var3, Reflector.EntityVillager_careerId, 0);
         Reflector.setFieldValueInt(var1, Reflector.EntityVillager_careerId, var5);
         int var6 = Reflector.getFieldValueInt(var3, Reflector.EntityVillager_careerLevel, 0);
         Reflector.setFieldValueInt(var1, Reflector.EntityVillager_careerLevel, var6);
      }

   }
}
