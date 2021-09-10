package net.optifine;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import net.minecraft.block.Block;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityFireball;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.src.Config;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.optifine.config.ConnectedParser;
import net.optifine.config.EntityClassLocator;
import net.optifine.config.IObjectLocator;
import net.optifine.config.ItemLocator;
import net.optifine.reflect.ReflectorForge;
import net.optifine.util.PropertiesOrdered;

public class DynamicLights {
   private static DynamicLightsMap mapDynamicLights = new DynamicLightsMap();
   private static final int LIGHT_LEVEL_MAX = 15;
   private static boolean initialized;
   private static final double MAX_DIST_SQ = 56.25D;
   private static final int LIGHT_LEVEL_GLOWSTONE_DUST = 8;
   private static final double MAX_DIST = 7.5D;
   private static long timeUpdateMs = 0L;
   private static final int LIGHT_LEVEL_MAGMA_CUBE_CORE = 13;
   private static final int LIGHT_LEVEL_FIRE = 15;
   private static final int LIGHT_LEVEL_BLAZE = 10;
   private static final int LIGHT_LEVEL_PRISMARINE_CRYSTALS = 8;
   private static Map<Item, Integer> mapItemLightLevels = new HashMap();
   private static final int LIGHT_LEVEL_MAGMA_CUBE = 8;
   private static Map<Class, Integer> mapEntityLightLevels = new HashMap();

   private static void loadModConfiguration(InputStream var0, String var1, String var2) {
      if (var0 != null) {
         try {
            PropertiesOrdered var3 = new PropertiesOrdered();
            var3.load(var0);
            var0.close();
            Config.dbg("DynamicLights: Parsing " + var1);
            ConnectedParser var4 = new ConnectedParser("DynamicLights");
            loadModLightLevels(var3.getProperty("entities"), mapEntityLightLevels, new EntityClassLocator(), var4, var1, var2);
            loadModLightLevels(var3.getProperty("items"), mapItemLightLevels, new ItemLocator(), var4, var1, var2);
         } catch (IOException var5) {
            Config.warn("DynamicLights: Error reading " + var1);
         }
      }

   }

   public static int getCombinedLight(Entity var0, int var1) {
      double var2 = (double)getLightLevel(var0);
      var1 = getCombinedLight(var2, var1);
      return var1;
   }

   private static void updateMapDynamicLights(RenderGlobal var0) {
      WorldClient var1 = var0.getWorld();
      if (var1 != null) {
         Iterator var3 = var1.getLoadedEntityList().iterator();

         while(var3.hasNext()) {
            Entity var2 = (Entity)var3.next();
            int var4 = getLightLevel(var2);
            int var5;
            DynamicLight var6;
            if (var4 > 0) {
               var5 = var2.getEntityId();
               var6 = mapDynamicLights.get(var5);
               if (var6 == null) {
                  var6 = new DynamicLight(var2);
                  mapDynamicLights.put(var5, var6);
               }
            } else {
               var5 = var2.getEntityId();
               var6 = mapDynamicLights.remove(var5);
               if (var6 != null) {
                  var6.updateLitChunks(var0);
               }
            }
         }
      }

   }

   private static void initialize() {
      initialized = true;
      mapEntityLightLevels.clear();
      mapItemLightLevels.clear();
      String[] var0 = ReflectorForge.getForgeModIds();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         String var2 = var0[var1];

         try {
            ResourceLocation var3 = new ResourceLocation(var2, "optifine/dynamic_lights.properties");
            InputStream var4 = Config.getResourceStream(var3);
            loadModConfiguration(var4, var3.toString(), var2);
         } catch (IOException var5) {
         }
      }

      if (mapEntityLightLevels.size() > 0) {
         Config.dbg("DynamicLights entities: " + mapEntityLightLevels.size());
      }

      if (mapItemLightLevels.size() > 0) {
         Config.dbg("DynamicLights items: " + mapItemLightLevels.size());
      }

   }

   public static double getLightLevel(BlockPos var0) {
      double var1 = 0.0D;
      synchronized(mapDynamicLights) {
         List var4 = mapDynamicLights.valueList();
         int var5 = 0;

         while(true) {
            if (var5 >= var4.size()) {
               break;
            }

            DynamicLight var6 = (DynamicLight)var4.get(var5);
            int var7 = var6.getLastLightLevel();
            if (var7 > 0) {
               double var8 = var6.getLastPosX();
               double var10 = var6.getLastPosY();
               double var12 = var6.getLastPosZ();
               double var14 = (double)var0.getX() - var8;
               double var16 = (double)var0.getY() - var10;
               double var18 = (double)var0.getZ() - var12;
               double var20 = var14 * var14 + var16 * var16 + var18 * var18;
               if (var6.isUnderwater() && !Config.isClearWater()) {
                  var7 = Config.limit(var7 - 2, 0, 15);
                  var20 *= 2.0D;
               }

               if (!(var20 > 56.25D)) {
                  double var22 = Math.sqrt(var20);
                  double var24 = 1.0D - var22 / 7.5D;
                  double var26 = var24 * (double)var7;
                  if (var26 > var1) {
                     var1 = var26;
                  }
               }
            }

            ++var5;
         }
      }

      double var3 = Config.limit(var1, 0.0D, 15.0D);
      return var3;
   }

   public static int getCombinedLight(BlockPos var0, int var1) {
      double var2 = getLightLevel(var0);
      var1 = getCombinedLight(var2, var1);
      return var1;
   }

   public static void update(RenderGlobal var0) {
      long var1 = System.currentTimeMillis();
      if (var1 >= timeUpdateMs + 50L) {
         timeUpdateMs = var1;
         if (!initialized) {
            initialize();
         }

         synchronized(mapDynamicLights) {
            updateMapDynamicLights(var0);
            if (mapDynamicLights.size() > 0) {
               List var4 = mapDynamicLights.valueList();

               for(int var5 = 0; var5 < var4.size(); ++var5) {
                  DynamicLight var6 = (DynamicLight)var4.get(var5);
                  var6.update(var0);
               }
            }
         }
      }

   }

   public static int getLightLevel(Entity var0) {
      if (var0 == Config.getMinecraft().getRenderViewEntity() && !Config.isDynamicHandLight()) {
         return 0;
      } else {
         if (var0 instanceof EntityPlayer) {
            EntityPlayer var1 = (EntityPlayer)var0;
            if (var1.isSpectator()) {
               return 0;
            }
         }

         if (var0.isBurning()) {
            return 15;
         } else {
            if (!mapEntityLightLevels.isEmpty()) {
               Integer var6 = (Integer)mapEntityLightLevels.get(var0.getClass());
               if (var6 != null) {
                  return var6;
               }
            }

            if (var0 instanceof EntityFireball) {
               return 15;
            } else if (var0 instanceof EntityTNTPrimed) {
               return 15;
            } else if (var0 instanceof EntityBlaze) {
               EntityBlaze var11 = (EntityBlaze)var0;
               return var11.func_70845_n() ? 15 : 10;
            } else if (var0 instanceof EntityMagmaCube) {
               EntityMagmaCube var10 = (EntityMagmaCube)var0;
               return (double)var10.squishFactor > 0.6D ? 13 : 8;
            } else {
               if (var0 instanceof EntityCreeper) {
                  EntityCreeper var7 = (EntityCreeper)var0;
                  if ((double)var7.getCreeperFlashIntensity(0.0F) > 0.001D) {
                     return 15;
                  }
               }

               ItemStack var2;
               if (var0 instanceof EntityLivingBase) {
                  EntityLivingBase var9 = (EntityLivingBase)var0;
                  var2 = var9.getHeldItem();
                  int var3 = getLightLevel(var2);
                  ItemStack var4 = var9.getEquipmentInSlot(4);
                  int var5 = getLightLevel(var4);
                  return Math.max(var3, var5);
               } else if (var0 instanceof EntityItem) {
                  EntityItem var8 = (EntityItem)var0;
                  var2 = getItemStack(var8);
                  return getLightLevel(var2);
               } else {
                  return 0;
               }
            }
         }
      }
   }

   public static int getCount() {
      synchronized(mapDynamicLights) {
         return mapDynamicLights.size();
      }
   }

   public static void entityAdded(Entity var0, RenderGlobal var1) {
   }

   public static int getLightLevel(ItemStack var0) {
      if (var0 == null) {
         return 0;
      } else {
         Item var1 = var0.getItem();
         if (var1 instanceof ItemBlock) {
            ItemBlock var2 = (ItemBlock)var1;
            Block var3 = var2.getBlock();
            if (var3 != null) {
               return var3.getLightValue();
            }
         }

         if (var1 == Items.lava_bucket) {
            return Blocks.lava.getLightValue();
         } else if (var1 != Items.blaze_rod && var1 != Items.blaze_powder) {
            if (var1 == Items.glowstone_dust) {
               return 8;
            } else if (var1 == Items.prismarine_crystals) {
               return 8;
            } else if (var1 == Items.magma_cream) {
               return 8;
            } else if (var1 == Items.nether_star) {
               return Blocks.beacon.getLightValue() / 2;
            } else {
               if (!mapItemLightLevels.isEmpty()) {
                  Integer var4 = (Integer)mapItemLightLevels.get(var1);
                  if (var4 != null) {
                     return var4;
                  }
               }

               return 0;
            }
         } else {
            return 10;
         }
      }
   }

   public static int getCombinedLight(double var0, int var2) {
      if (var0 > 0.0D) {
         int var3 = (int)(var0 * 16.0D);
         int var4 = var2 & 255;
         if (var3 > var4) {
            var2 &= -256;
            var2 |= var3;
         }
      }

      return var2;
   }

   public static ItemStack getItemStack(EntityItem var0) {
      ItemStack var1 = var0.getDataWatcher().getWatchableObjectItemStack(10);
      return var1;
   }

   private static void loadModLightLevels(String var0, Map var1, IObjectLocator var2, ConnectedParser var3, String var4, String var5) {
      if (var0 != null) {
         String[] var6 = Config.tokenize(var0, " ");

         for(int var7 = 0; var7 < var6.length; ++var7) {
            String var8 = var6[var7];
            String[] var9 = Config.tokenize(var8, ":");
            if (var9.length != 2) {
               var3.warn("Invalid entry: " + var8 + ", in:" + var4);
            } else {
               String var10 = var9[0];
               String var11 = var9[1];
               String var12 = var5 + ":" + var10;
               ResourceLocation var13 = new ResourceLocation(var12);
               Object var14 = var2.getObject(var13);
               if (var14 == null) {
                  var3.warn("Object not found: " + var12);
               } else {
                  int var15 = var3.parseInt(var11, -1);
                  if (var15 >= 0 && var15 <= 15) {
                     var1.put(var14, new Integer(var15));
                  } else {
                     var3.warn("Invalid light level: " + var8);
                  }
               }
            }
         }
      }

   }

   public static void clear() {
      synchronized(mapDynamicLights) {
         mapDynamicLights.clear();
      }
   }

   public static void entityRemoved(Entity var0, RenderGlobal var1) {
      synchronized(mapDynamicLights) {
         DynamicLight var3 = mapDynamicLights.remove(var0.getEntityId());
         if (var3 != null) {
            var3.updateLitChunks(var1);
         }

      }
   }

   public static void removeLights(RenderGlobal var0) {
      synchronized(mapDynamicLights) {
         List var2 = mapDynamicLights.valueList();

         for(int var3 = 0; var3 < var2.size(); ++var3) {
            DynamicLight var4 = (DynamicLight)var2.get(var3);
            var4.updateLitChunks(var0);
         }

         mapDynamicLights.clear();
      }
   }
}
