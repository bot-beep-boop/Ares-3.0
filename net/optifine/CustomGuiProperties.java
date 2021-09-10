package net.optifine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import net.minecraft.client.gui.GuiEnchantment;
import net.minecraft.client.gui.GuiHopper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiBeacon;
import net.minecraft.client.gui.inventory.GuiBrewingStand;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.client.gui.inventory.GuiDispenser;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityBeacon;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.tileentity.TileEntityDropper;
import net.minecraft.tileentity.TileEntityEnderChest;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.config.ConnectedParser;
import net.optifine.config.Matches;
import net.optifine.config.NbtTagValue;
import net.optifine.config.RangeListInt;
import net.optifine.config.VillagerProfession;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorField;
import net.optifine.util.StrUtils;
import net.optifine.util.TextureUtils;

public class CustomGuiProperties {
   private String fileName = null;
   private Boolean christmas = null;
   private static final ResourceLocation ANVIL_GUI_TEXTURE;
   private static final ResourceLocation HORSE_GUI_TEXTURE;
   private static final ResourceLocation HOPPER_GUI_TEXTURE;
   private NbtTagValue nbtName = null;
   private RangeListInt levels = null;
   private BiomeGenBase[] biomes = null;
   private static final ResourceLocation DISPENSER_GUI_TEXTURE;
   private CustomGuiProperties.EnumVariant[] variants = null;
   private static final ResourceLocation INVENTORY_GUI_TEXTURE;
   private static final ResourceLocation BREWING_STAND_GUI_TEXTURE;
   private static final ResourceLocation SHULKER_BOX_GUI_TEXTURE;
   private Boolean trapped = null;
   private static int[] $SWITCH_TABLE$net$optifine$CustomGuiProperties$EnumContainer;
   private Boolean large = null;
   private static final ResourceLocation FURNACE_GUI_TEXTURE;
   private static final EnumDyeColor[] COLORS_INVALID;
   private static final ResourceLocation ENCHANTMENT_TABLE_GUI_TEXTURE;
   private static final CustomGuiProperties.EnumVariant[] VARIANTS_DISPENSER;
   private Map<ResourceLocation, ResourceLocation> textureLocations = null;
   private String basePath = null;
   private static final ResourceLocation VILLAGER_GUI_TEXTURE;
   private static final CustomGuiProperties.EnumVariant[] VARIANTS_INVALID;
   private EnumDyeColor[] colors = null;
   private CustomGuiProperties.EnumContainer container = null;
   private VillagerProfession[] professions = null;
   private static final CustomGuiProperties.EnumVariant[] VARIANTS_HORSE;
   private static final ResourceLocation BEACON_GUI_TEXTURE;
   private static final ResourceLocation CHEST_GUI_TEXTURE;
   private Boolean ender = null;
   private static final ResourceLocation CRAFTING_TABLE_GUI_TEXTURE;
   private RangeListInt heights = null;

   public ResourceLocation getTextureLocation(ResourceLocation var1) {
      ResourceLocation var2 = (ResourceLocation)this.textureLocations.get(var1);
      return var2 == null ? var1 : var2;
   }

   private boolean matchesVillager(Entity var1, IBlockAccess var2) {
      if (!(var1 instanceof EntityVillager)) {
         return false;
      } else {
         EntityVillager var3 = (EntityVillager)var1;
         if (this.professions != null) {
            int var4 = var3.getProfession();
            int var5 = Reflector.getFieldValueInt(var3, Reflector.EntityVillager_careerId, -1);
            if (var5 < 0) {
               return false;
            }

            boolean var6 = false;

            for(int var7 = 0; var7 < this.professions.length; ++var7) {
               VillagerProfession var8 = this.professions[var7];
               if (var8.matches(var4, var5)) {
                  var6 = true;
                  break;
               }
            }

            if (!var6) {
               return false;
            }
         }

         return true;
      }
   }

   private boolean matchesEnderChest(TileEntityEnderChest var1, BlockPos var2, IBlockAccess var3) {
      return this.matchesChest(false, false, false, true);
   }

   private static CustomGuiProperties.EnumVariant[] getContainerVariants(CustomGuiProperties.EnumContainer var0) {
      if (var0 == CustomGuiProperties.EnumContainer.HORSE) {
         return VARIANTS_HORSE;
      } else {
         return var0 == CustomGuiProperties.EnumContainer.DISPENSER ? VARIANTS_DISPENSER : new CustomGuiProperties.EnumVariant[0];
      }
   }

   private CustomGuiProperties.EnumVariant getHorseVariant(EntityHorse var1) {
      int var2 = var1.getHorseType();
      switch(var2) {
      case 0:
         return CustomGuiProperties.EnumVariant.HORSE;
      case 1:
         return CustomGuiProperties.EnumVariant.DONKEY;
      case 2:
         return CustomGuiProperties.EnumVariant.MULE;
      default:
         return null;
      }
   }

   private static void warn(String var0) {
      Config.warn("[CustomGuis] " + var0);
   }

   private static IWorldNameable getWorldNameable(GuiScreen var0, ReflectorField var1) {
      Object var2 = Reflector.getFieldValue(var0, var1);
      return !(var2 instanceof IWorldNameable) ? null : (IWorldNameable)var2;
   }

   private boolean matchesGeneral(CustomGuiProperties.EnumContainer var1, BlockPos var2, IBlockAccess var3) {
      if (this.container != var1) {
         return false;
      } else {
         if (this.biomes != null) {
            BiomeGenBase var4 = var3.getBiomeGenForCoords(var2);
            if (!Matches.biome(var4, this.biomes)) {
               return false;
            }
         }

         return this.heights == null || this.heights.isInRange(var2.getY());
      }
   }

   public boolean matchesEntity(CustomGuiProperties.EnumContainer var1, Entity var2, IBlockAccess var3) {
      if (!this.matchesGeneral(var1, var2.getPosition(), var3)) {
         return false;
      } else {
         if (this.nbtName != null) {
            String var4 = var2.getName();
            if (!this.nbtName.matchesValue(var4)) {
               return false;
            }
         }

         switch($SWITCH_TABLE$net$optifine$CustomGuiProperties$EnumContainer()[var1.ordinal()]) {
         case 10:
            return this.matchesHorse(var2, var3);
         case 11:
            return this.matchesVillager(var2, var3);
         default:
            return true;
         }
      }
   }

   static {
      VARIANTS_HORSE = new CustomGuiProperties.EnumVariant[]{CustomGuiProperties.EnumVariant.HORSE, CustomGuiProperties.EnumVariant.DONKEY, CustomGuiProperties.EnumVariant.MULE, CustomGuiProperties.EnumVariant.LLAMA};
      VARIANTS_DISPENSER = new CustomGuiProperties.EnumVariant[]{CustomGuiProperties.EnumVariant.DISPENSER, CustomGuiProperties.EnumVariant.DROPPER};
      VARIANTS_INVALID = new CustomGuiProperties.EnumVariant[0];
      COLORS_INVALID = new EnumDyeColor[0];
      ANVIL_GUI_TEXTURE = new ResourceLocation("textures/gui/container/anvil.png");
      BEACON_GUI_TEXTURE = new ResourceLocation("textures/gui/container/beacon.png");
      BREWING_STAND_GUI_TEXTURE = new ResourceLocation("textures/gui/container/brewing_stand.png");
      CHEST_GUI_TEXTURE = new ResourceLocation("textures/gui/container/generic_54.png");
      CRAFTING_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/crafting_table.png");
      HORSE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/horse.png");
      DISPENSER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/dispenser.png");
      ENCHANTMENT_TABLE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/enchanting_table.png");
      FURNACE_GUI_TEXTURE = new ResourceLocation("textures/gui/container/furnace.png");
      HOPPER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/hopper.png");
      INVENTORY_GUI_TEXTURE = new ResourceLocation("textures/gui/container/inventory.png");
      SHULKER_BOX_GUI_TEXTURE = new ResourceLocation("textures/gui/container/shulker_box.png");
      VILLAGER_GUI_TEXTURE = new ResourceLocation("textures/gui/container/villager.png");
   }

   public CustomGuiProperties(Properties var1, String var2) {
      ConnectedParser var3 = new ConnectedParser("CustomGuis");
      this.fileName = var3.parseName(var2);
      this.basePath = var3.parseBasePath(var2);
      this.container = (CustomGuiProperties.EnumContainer)var3.parseEnum(var1.getProperty("container"), CustomGuiProperties.EnumContainer.values(), "container");
      this.textureLocations = parseTextureLocations(var1, "texture", this.container, "textures/gui/", this.basePath);
      this.nbtName = var3.parseNbtTagValue("name", var1.getProperty("name"));
      this.biomes = var3.parseBiomes(var1.getProperty("biomes"));
      this.heights = var3.parseRangeListInt(var1.getProperty("heights"));
      this.large = var3.parseBooleanObject(var1.getProperty("large"));
      this.trapped = var3.parseBooleanObject(var1.getProperty("trapped"));
      this.christmas = var3.parseBooleanObject(var1.getProperty("christmas"));
      this.ender = var3.parseBooleanObject(var1.getProperty("ender"));
      this.levels = var3.parseRangeListInt(var1.getProperty("levels"));
      this.professions = var3.parseProfessions(var1.getProperty("professions"));
      CustomGuiProperties.EnumVariant[] var4 = getContainerVariants(this.container);
      this.variants = (CustomGuiProperties.EnumVariant[])var3.parseEnums(var1.getProperty("variants"), var4, "variants", VARIANTS_INVALID);
      this.colors = parseEnumDyeColors(var1.getProperty("colors"));
   }

   public boolean matchesPos(CustomGuiProperties.EnumContainer var1, BlockPos var2, IBlockAccess var3, GuiScreen var4) {
      if (!this.matchesGeneral(var1, var2, var3)) {
         return false;
      } else {
         if (this.nbtName != null) {
            String var5 = getName(var4);
            if (!this.nbtName.matchesValue(var5)) {
               return false;
            }
         }

         switch($SWITCH_TABLE$net$optifine$CustomGuiProperties$EnumContainer()[var1.ordinal()]) {
         case 2:
            return this.matchesBeacon(var2, var3);
         case 3:
         case 5:
         default:
            return true;
         case 4:
            return this.matchesChest(var2, var3);
         case 6:
            return this.matchesDispenser(var2, var3);
         }
      }
   }

   public String toString() {
      return "name: " + this.fileName + ", container: " + this.container + ", textures: " + this.textureLocations;
   }

   private static ResourceLocation parseTextureLocation(String var0, String var1) {
      if (var0 == null) {
         return null;
      } else {
         var0 = var0.trim();
         String var2 = TextureUtils.fixResourcePath(var0, var1);
         if (!var2.endsWith(".png")) {
            var2 = var2 + ".png";
         }

         return new ResourceLocation(var1 + "/" + var2);
      }
   }

   public static String getName(GuiScreen var0) {
      IWorldNameable var1 = getWorldNameable(var0);
      return var1 == null ? null : var1.getDisplayName().getUnformattedText();
   }

   public CustomGuiProperties.EnumContainer getContainer() {
      return this.container;
   }

   public boolean isValid(String var1) {
      if (this.fileName != null && this.fileName.length() > 0) {
         if (this.basePath == null) {
            warn("No base path found: " + var1);
            return false;
         } else if (this.container == null) {
            warn("No container found: " + var1);
            return false;
         } else if (this.textureLocations.isEmpty()) {
            warn("No texture found: " + var1);
            return false;
         } else if (this.professions == ConnectedParser.PROFESSIONS_INVALID) {
            warn("Invalid professions or careers: " + var1);
            return false;
         } else if (this.variants == VARIANTS_INVALID) {
            warn("Invalid variants: " + var1);
            return false;
         } else if (this.colors == COLORS_INVALID) {
            warn("Invalid colors: " + var1);
            return false;
         } else {
            return true;
         }
      } else {
         warn("No name found: " + var1);
         return false;
      }
   }

   private static ResourceLocation getGuiTextureLocation(CustomGuiProperties.EnumContainer var0) {
      switch($SWITCH_TABLE$net$optifine$CustomGuiProperties$EnumContainer()[var0.ordinal()]) {
      case 1:
         return ANVIL_GUI_TEXTURE;
      case 2:
         return BEACON_GUI_TEXTURE;
      case 3:
         return BREWING_STAND_GUI_TEXTURE;
      case 4:
         return CHEST_GUI_TEXTURE;
      case 5:
         return CRAFTING_TABLE_GUI_TEXTURE;
      case 6:
         return DISPENSER_GUI_TEXTURE;
      case 7:
         return ENCHANTMENT_TABLE_GUI_TEXTURE;
      case 8:
         return FURNACE_GUI_TEXTURE;
      case 9:
         return HOPPER_GUI_TEXTURE;
      case 10:
         return HORSE_GUI_TEXTURE;
      case 11:
         return VILLAGER_GUI_TEXTURE;
      case 12:
         return SHULKER_BOX_GUI_TEXTURE;
      case 13:
         return null;
      case 14:
         return INVENTORY_GUI_TEXTURE;
      default:
         return null;
      }
   }

   private boolean matchesDispenser(BlockPos var1, IBlockAccess var2) {
      TileEntity var3 = var2.getTileEntity(var1);
      if (!(var3 instanceof TileEntityDispenser)) {
         return false;
      } else {
         TileEntityDispenser var4 = (TileEntityDispenser)var3;
         if (this.variants != null) {
            CustomGuiProperties.EnumVariant var5 = this.getDispenserVariant(var4);
            if (!Config.equalsOne(var5, this.variants)) {
               return false;
            }
         }

         return true;
      }
   }

   private static IWorldNameable getWorldNameable(GuiScreen var0) {
      if (var0 instanceof GuiBeacon) {
         return getWorldNameable(var0, Reflector.GuiBeacon_tileBeacon);
      } else if (var0 instanceof GuiBrewingStand) {
         return getWorldNameable(var0, Reflector.GuiBrewingStand_tileBrewingStand);
      } else if (var0 instanceof GuiChest) {
         return getWorldNameable(var0, Reflector.GuiChest_lowerChestInventory);
      } else if (var0 instanceof GuiDispenser) {
         return ((GuiDispenser)var0).dispenserInventory;
      } else if (var0 instanceof GuiEnchantment) {
         return getWorldNameable(var0, Reflector.GuiEnchantment_nameable);
      } else if (var0 instanceof GuiFurnace) {
         return getWorldNameable(var0, Reflector.GuiFurnace_tileFurnace);
      } else {
         return var0 instanceof GuiHopper ? getWorldNameable(var0, Reflector.GuiHopper_hopperInventory) : null;
      }
   }

   static int[] $SWITCH_TABLE$net$optifine$CustomGuiProperties$EnumContainer() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$CustomGuiProperties$EnumContainer;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[CustomGuiProperties.EnumContainer.values().length];

         try {
            var0[CustomGuiProperties.EnumContainer.ANVIL.ordinal()] = 1;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.BEACON.ordinal()] = 2;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.BREWING_STAND.ordinal()] = 3;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.CHEST.ordinal()] = 4;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.CRAFTING.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.CREATIVE.ordinal()] = 13;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.DISPENSER.ordinal()] = 6;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.ENCHANTMENT.ordinal()] = 7;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.FURNACE.ordinal()] = 8;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.HOPPER.ordinal()] = 9;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.HORSE.ordinal()] = 10;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.INVENTORY.ordinal()] = 14;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.SHULKER_BOX.ordinal()] = 12;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[CustomGuiProperties.EnumContainer.VILLAGER.ordinal()] = 11;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$CustomGuiProperties$EnumContainer = var0;
         return var0;
      }
   }

   private CustomGuiProperties.EnumVariant getDispenserVariant(TileEntityDispenser var1) {
      return var1 instanceof TileEntityDropper ? CustomGuiProperties.EnumVariant.DROPPER : CustomGuiProperties.EnumVariant.DISPENSER;
   }

   private static EnumDyeColor parseEnumDyeColor(String var0) {
      if (var0 == null) {
         return null;
      } else {
         EnumDyeColor[] var1 = EnumDyeColor.values();

         for(int var2 = 0; var2 < var1.length; ++var2) {
            EnumDyeColor var3 = var1[var2];
            if (var3.getName().equals(var0)) {
               return var3;
            }

            if (var3.getUnlocalizedName().equals(var0)) {
               return var3;
            }
         }

         return null;
      }
   }

   private boolean matchesHorse(Entity var1, IBlockAccess var2) {
      if (!(var1 instanceof EntityHorse)) {
         return false;
      } else {
         EntityHorse var3 = (EntityHorse)var1;
         if (this.variants != null) {
            CustomGuiProperties.EnumVariant var4 = this.getHorseVariant(var3);
            if (!Config.equalsOne(var4, this.variants)) {
               return false;
            }
         }

         return true;
      }
   }

   private static Map<ResourceLocation, ResourceLocation> parseTextureLocations(Properties var0, String var1, CustomGuiProperties.EnumContainer var2, String var3, String var4) {
      HashMap var5 = new HashMap();
      String var6 = var0.getProperty(var1);
      if (var6 != null) {
         ResourceLocation var7 = getGuiTextureLocation(var2);
         ResourceLocation var8 = parseTextureLocation(var6, var4);
         if (var7 != null && var8 != null) {
            var5.put(var7, var8);
         }
      }

      String var16 = var1 + ".";
      Iterator var9 = var0.keySet().iterator();

      while(var9.hasNext()) {
         Object var17 = var9.next();
         String var10 = (String)var17;
         if (var10.startsWith(var16)) {
            String var11 = var10.substring(var16.length());
            var11 = var11.replace('\\', '/');
            var11 = StrUtils.removePrefixSuffix(var11, "/", ".png");
            String var12 = var3 + var11 + ".png";
            String var13 = var0.getProperty(var10);
            ResourceLocation var14 = new ResourceLocation(var12);
            ResourceLocation var15 = parseTextureLocation(var13, var4);
            var5.put(var14, var15);
         }
      }

      return var5;
   }

   private boolean matchesChest(TileEntityChest var1, BlockPos var2, IBlockAccess var3) {
      boolean var4 = var1.adjacentChestXNeg != null || var1.adjacentChestXPos != null || var1.adjacentChestZNeg != null || var1.adjacentChestZPos != null;
      boolean var5 = var1.getChestType() == 1;
      boolean var6 = CustomGuis.isChristmas;
      boolean var7 = false;
      return this.matchesChest(var4, var5, var6, var7);
   }

   private boolean matchesChest(BlockPos var1, IBlockAccess var2) {
      TileEntity var3 = var2.getTileEntity(var1);
      if (var3 instanceof TileEntityChest) {
         TileEntityChest var5 = (TileEntityChest)var3;
         return this.matchesChest(var5, var1, var2);
      } else if (var3 instanceof TileEntityEnderChest) {
         TileEntityEnderChest var4 = (TileEntityEnderChest)var3;
         return this.matchesEnderChest(var4, var1, var2);
      } else {
         return false;
      }
   }

   private boolean matchesChest(boolean var1, boolean var2, boolean var3, boolean var4) {
      if (this.large != null && this.large != var1) {
         return false;
      } else if (this.trapped != null && this.trapped != var2) {
         return false;
      } else if (this.christmas != null && this.christmas != var3) {
         return false;
      } else {
         return this.ender == null || this.ender == var4;
      }
   }

   private static EnumDyeColor[] parseEnumDyeColors(String var0) {
      if (var0 == null) {
         return null;
      } else {
         var0 = var0.toLowerCase();
         String[] var1 = Config.tokenize(var0, " ");
         EnumDyeColor[] var2 = new EnumDyeColor[var1.length];

         for(int var3 = 0; var3 < var1.length; ++var3) {
            String var4 = var1[var3];
            EnumDyeColor var5 = parseEnumDyeColor(var4);
            if (var5 == null) {
               warn("Invalid color: " + var4);
               return COLORS_INVALID;
            }

            var2[var3] = var5;
         }

         return var2;
      }
   }

   private boolean matchesBeacon(BlockPos var1, IBlockAccess var2) {
      TileEntity var3 = var2.getTileEntity(var1);
      if (!(var3 instanceof TileEntityBeacon)) {
         return false;
      } else {
         TileEntityBeacon var4 = (TileEntityBeacon)var3;
         if (this.levels != null) {
            NBTTagCompound var5 = new NBTTagCompound();
            var4.writeToNBT(var5);
            int var6 = var5.getInteger("Levels");
            if (!this.levels.isInRange(var6)) {
               return false;
            }
         }

         return true;
      }
   }

   public static enum EnumContainer {
      ENCHANTMENT,
      CRAFTING,
      BREWING_STAND,
      CREATIVE,
      HOPPER;

      private static final CustomGuiProperties.EnumContainer[] ENUM$VALUES = new CustomGuiProperties.EnumContainer[]{ANVIL, BEACON, BREWING_STAND, CHEST, CRAFTING, DISPENSER, ENCHANTMENT, FURNACE, HOPPER, HORSE, VILLAGER, SHULKER_BOX, CREATIVE, INVENTORY};
      INVENTORY,
      ANVIL;

      public static final CustomGuiProperties.EnumContainer[] VALUES = values();
      FURNACE,
      VILLAGER,
      DISPENSER,
      BEACON,
      HORSE,
      SHULKER_BOX,
      CHEST;
   }

   private static enum EnumVariant {
      HORSE,
      DONKEY,
      DROPPER,
      MULE,
      DISPENSER;

      private static final CustomGuiProperties.EnumVariant[] ENUM$VALUES = new CustomGuiProperties.EnumVariant[]{HORSE, DONKEY, MULE, LLAMA, DISPENSER, DROPPER};
      LLAMA;
   }
}
