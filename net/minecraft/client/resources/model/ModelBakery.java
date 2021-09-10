package net.minecraft.client.resources.model;

import com.google.common.base.Charsets;
import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.BlockPart;
import net.minecraft.client.renderer.block.model.BlockPartFace;
import net.minecraft.client.renderer.block.model.FaceBakery;
import net.minecraft.client.renderer.block.model.ItemModelGenerator;
import net.minecraft.client.renderer.block.model.ModelBlock;
import net.minecraft.client.renderer.block.model.ModelBlockDefinition;
import net.minecraft.client.renderer.texture.IIconCreator;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IRegistry;
import net.minecraft.util.RegistrySimple;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ITransformation;
import net.minecraftforge.client.model.TRSRTransformation;
import net.minecraftforge.fml.common.registry.RegistryDelegate;
import net.optifine.CustomItems;
import net.optifine.reflect.Reflector;
import net.optifine.util.StrUtils;
import net.optifine.util.TextureUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModelBakery {
   private RegistrySimple<ModelResourceLocation, IBakedModel> bakedRegistry = new RegistrySimple();
   private static final ModelBlock MODEL_CLOCK = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
   private Map<String, ResourceLocation> itemLocations = Maps.newLinkedHashMap();
   private final Map<ModelResourceLocation, ModelBlockDefinition.Variants> variants = Maps.newLinkedHashMap();
   private final ItemModelGenerator itemModelGenerator = new ItemModelGenerator();
   private static final Map<String, String> BUILT_IN_MODELS = Maps.newHashMap();
   private static final ModelBlock MODEL_ENTITY = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
   private static final Joiner JOINER = Joiner.on(" -> ");
   protected static final ModelResourceLocation MODEL_MISSING = new ModelResourceLocation("builtin/missing", "missing");
   private static Map<RegistryDelegate<Item>, Set<String>> customVariantNames = Maps.newHashMap();
   private final IResourceManager resourceManager;
   private final Map<ResourceLocation, ModelBlock> models = Maps.newLinkedHashMap();
   private final Map<ResourceLocation, TextureAtlasSprite> sprites = Maps.newHashMap();
   private final FaceBakery faceBakery = new FaceBakery();
   private static final ModelBlock MODEL_GENERATED = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");
   private final TextureMap textureMap;
   private static final Set<ResourceLocation> LOCATIONS_BUILTIN_TEXTURES = Sets.newHashSet(new ResourceLocation[]{new ResourceLocation("blocks/water_flow"), new ResourceLocation("blocks/water_still"), new ResourceLocation("blocks/lava_flow"), new ResourceLocation("blocks/lava_still"), new ResourceLocation("blocks/destroy_stage_0"), new ResourceLocation("blocks/destroy_stage_1"), new ResourceLocation("blocks/destroy_stage_2"), new ResourceLocation("blocks/destroy_stage_3"), new ResourceLocation("blocks/destroy_stage_4"), new ResourceLocation("blocks/destroy_stage_5"), new ResourceLocation("blocks/destroy_stage_6"), new ResourceLocation("blocks/destroy_stage_7"), new ResourceLocation("blocks/destroy_stage_8"), new ResourceLocation("blocks/destroy_stage_9"), new ResourceLocation("items/empty_armor_slot_helmet"), new ResourceLocation("items/empty_armor_slot_chestplate"), new ResourceLocation("items/empty_armor_slot_leggings"), new ResourceLocation("items/empty_armor_slot_boots")});
   private final Map<ResourceLocation, ModelBlockDefinition> blockDefinitions = Maps.newHashMap();
   private final BlockModelShapes blockModelShapes;
   private Map<Item, List<String>> variantNames = Maps.newIdentityHashMap();
   private static final Logger LOGGER = LogManager.getLogger();
   private static final ModelBlock MODEL_COMPASS = ModelBlock.deserialize("{\"elements\":[{  \"from\": [0, 0, 0],   \"to\": [16, 16, 16],   \"faces\": {       \"down\": {\"uv\": [0, 0, 16, 16], \"texture\":\"\"}   }}]}");

   private Set<ResourceLocation> getItemsTextureLocations() {
      HashSet var1 = Sets.newHashSet();
      Iterator var3 = this.itemLocations.values().iterator();

      while(true) {
         while(true) {
            ModelBlock var4;
            do {
               if (!var3.hasNext()) {
                  return var1;
               }

               ResourceLocation var2 = (ResourceLocation)var3.next();
               var4 = (ModelBlock)this.models.get(var2);
            } while(var4 == null);

            var1.add(new ResourceLocation(var4.resolveTextureName("particle")));
            Iterator var6;
            ResourceLocation var11;
            if (this.hasItemModel(var4)) {
               for(var6 = ItemModelGenerator.LAYERS.iterator(); var6.hasNext(); var1.add(var11)) {
                  String var10 = (String)var6.next();
                  var11 = new ResourceLocation(var4.resolveTextureName(var10));
                  if (var4.getRootModel() == MODEL_COMPASS && !TextureMap.LOCATION_MISSING_TEXTURE.equals(var11)) {
                     TextureAtlasSprite.setLocationNameCompass(var11.toString());
                  } else if (var4.getRootModel() == MODEL_CLOCK && !TextureMap.LOCATION_MISSING_TEXTURE.equals(var11)) {
                     TextureAtlasSprite.setLocationNameClock(var11.toString());
                  }
               }
            } else if (!this.isCustomRenderer(var4)) {
               var6 = var4.getElements().iterator();

               while(var6.hasNext()) {
                  BlockPart var5 = (BlockPart)var6.next();
                  Iterator var8 = var5.mapFaces.values().iterator();

                  while(var8.hasNext()) {
                     BlockPartFace var7 = (BlockPartFace)var8.next();
                     ResourceLocation var9 = new ResourceLocation(var4.resolveTextureName(var7.texture));
                     var1.add(var9);
                  }
               }
            }
         }
      }
   }

   private void loadItemModels() {
      this.registerVariantNames();
      Iterator var2 = Item.itemRegistry.iterator();

      while(var2.hasNext()) {
         Item var1 = (Item)var2.next();
         Iterator var4 = this.getVariantNames(var1).iterator();

         while(var4.hasNext()) {
            String var3 = (String)var4.next();
            ResourceLocation var5 = this.getItemLocation(var3);
            this.itemLocations.put(var3, var5);
            if (this.models.get(var5) == null) {
               try {
                  ModelBlock var6 = this.loadModel(var5);
                  this.models.put(var5, var6);
               } catch (Exception var7) {
                  LOGGER.warn("Unable to load item model: '" + var5 + "' for item: '" + Item.itemRegistry.getNameForObject(var1) + "'", var7);
               }
            }
         }
      }

   }

   private void registerVariantNames() {
      this.variantNames.clear();
      this.variantNames.put(Item.getItemFromBlock(Blocks.stone), Lists.newArrayList(new String[]{"stone", "granite", "granite_smooth", "diorite", "diorite_smooth", "andesite", "andesite_smooth"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.dirt), Lists.newArrayList(new String[]{"dirt", "coarse_dirt", "podzol"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.planks), Lists.newArrayList(new String[]{"oak_planks", "spruce_planks", "birch_planks", "jungle_planks", "acacia_planks", "dark_oak_planks"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.sapling), Lists.newArrayList(new String[]{"oak_sapling", "spruce_sapling", "birch_sapling", "jungle_sapling", "acacia_sapling", "dark_oak_sapling"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.sand), Lists.newArrayList(new String[]{"sand", "red_sand"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.log), Lists.newArrayList(new String[]{"oak_log", "spruce_log", "birch_log", "jungle_log"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.leaves), Lists.newArrayList(new String[]{"oak_leaves", "spruce_leaves", "birch_leaves", "jungle_leaves"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.sponge), Lists.newArrayList(new String[]{"sponge", "sponge_wet"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.sandstone), Lists.newArrayList(new String[]{"sandstone", "chiseled_sandstone", "smooth_sandstone"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.red_sandstone), Lists.newArrayList(new String[]{"red_sandstone", "chiseled_red_sandstone", "smooth_red_sandstone"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.tallgrass), Lists.newArrayList(new String[]{"dead_bush", "tall_grass", "fern"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.deadbush), Lists.newArrayList(new String[]{"dead_bush"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.wool), Lists.newArrayList(new String[]{"black_wool", "red_wool", "green_wool", "brown_wool", "blue_wool", "purple_wool", "cyan_wool", "silver_wool", "gray_wool", "pink_wool", "lime_wool", "yellow_wool", "light_blue_wool", "magenta_wool", "orange_wool", "white_wool"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.yellow_flower), Lists.newArrayList(new String[]{"dandelion"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.red_flower), Lists.newArrayList(new String[]{"poppy", "blue_orchid", "allium", "houstonia", "red_tulip", "orange_tulip", "white_tulip", "pink_tulip", "oxeye_daisy"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.stone_slab), Lists.newArrayList(new String[]{"stone_slab", "sandstone_slab", "cobblestone_slab", "brick_slab", "stone_brick_slab", "nether_brick_slab", "quartz_slab"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.stone_slab2), Lists.newArrayList(new String[]{"red_sandstone_slab"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.stained_glass), Lists.newArrayList(new String[]{"black_stained_glass", "red_stained_glass", "green_stained_glass", "brown_stained_glass", "blue_stained_glass", "purple_stained_glass", "cyan_stained_glass", "silver_stained_glass", "gray_stained_glass", "pink_stained_glass", "lime_stained_glass", "yellow_stained_glass", "light_blue_stained_glass", "magenta_stained_glass", "orange_stained_glass", "white_stained_glass"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.monster_egg), Lists.newArrayList(new String[]{"stone_monster_egg", "cobblestone_monster_egg", "stone_brick_monster_egg", "mossy_brick_monster_egg", "cracked_brick_monster_egg", "chiseled_brick_monster_egg"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.stonebrick), Lists.newArrayList(new String[]{"stonebrick", "mossy_stonebrick", "cracked_stonebrick", "chiseled_stonebrick"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.wooden_slab), Lists.newArrayList(new String[]{"oak_slab", "spruce_slab", "birch_slab", "jungle_slab", "acacia_slab", "dark_oak_slab"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.cobblestone_wall), Lists.newArrayList(new String[]{"cobblestone_wall", "mossy_cobblestone_wall"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.anvil), Lists.newArrayList(new String[]{"anvil_intact", "anvil_slightly_damaged", "anvil_very_damaged"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.quartz_block), Lists.newArrayList(new String[]{"quartz_block", "chiseled_quartz_block", "quartz_column"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.stained_hardened_clay), Lists.newArrayList(new String[]{"black_stained_hardened_clay", "red_stained_hardened_clay", "green_stained_hardened_clay", "brown_stained_hardened_clay", "blue_stained_hardened_clay", "purple_stained_hardened_clay", "cyan_stained_hardened_clay", "silver_stained_hardened_clay", "gray_stained_hardened_clay", "pink_stained_hardened_clay", "lime_stained_hardened_clay", "yellow_stained_hardened_clay", "light_blue_stained_hardened_clay", "magenta_stained_hardened_clay", "orange_stained_hardened_clay", "white_stained_hardened_clay"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.stained_glass_pane), Lists.newArrayList(new String[]{"black_stained_glass_pane", "red_stained_glass_pane", "green_stained_glass_pane", "brown_stained_glass_pane", "blue_stained_glass_pane", "purple_stained_glass_pane", "cyan_stained_glass_pane", "silver_stained_glass_pane", "gray_stained_glass_pane", "pink_stained_glass_pane", "lime_stained_glass_pane", "yellow_stained_glass_pane", "light_blue_stained_glass_pane", "magenta_stained_glass_pane", "orange_stained_glass_pane", "white_stained_glass_pane"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.leaves2), Lists.newArrayList(new String[]{"acacia_leaves", "dark_oak_leaves"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.log2), Lists.newArrayList(new String[]{"acacia_log", "dark_oak_log"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.prismarine), Lists.newArrayList(new String[]{"prismarine", "prismarine_bricks", "dark_prismarine"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.carpet), Lists.newArrayList(new String[]{"black_carpet", "red_carpet", "green_carpet", "brown_carpet", "blue_carpet", "purple_carpet", "cyan_carpet", "silver_carpet", "gray_carpet", "pink_carpet", "lime_carpet", "yellow_carpet", "light_blue_carpet", "magenta_carpet", "orange_carpet", "white_carpet"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.double_plant), Lists.newArrayList(new String[]{"sunflower", "syringa", "double_grass", "double_fern", "double_rose", "paeonia"}));
      this.variantNames.put(Items.bow, Lists.newArrayList(new String[]{"bow", "bow_pulling_0", "bow_pulling_1", "bow_pulling_2"}));
      this.variantNames.put(Items.coal, Lists.newArrayList(new String[]{"coal", "charcoal"}));
      this.variantNames.put(Items.fishing_rod, Lists.newArrayList(new String[]{"fishing_rod", "fishing_rod_cast"}));
      this.variantNames.put(Items.fish, Lists.newArrayList(new String[]{"cod", "salmon", "clownfish", "pufferfish"}));
      this.variantNames.put(Items.cooked_fish, Lists.newArrayList(new String[]{"cooked_cod", "cooked_salmon"}));
      this.variantNames.put(Items.dye, Lists.newArrayList(new String[]{"dye_black", "dye_red", "dye_green", "dye_brown", "dye_blue", "dye_purple", "dye_cyan", "dye_silver", "dye_gray", "dye_pink", "dye_lime", "dye_yellow", "dye_light_blue", "dye_magenta", "dye_orange", "dye_white"}));
      this.variantNames.put(Items.potionitem, Lists.newArrayList(new String[]{"bottle_drinkable", "bottle_splash"}));
      this.variantNames.put(Items.skull, Lists.newArrayList(new String[]{"skull_skeleton", "skull_wither", "skull_zombie", "skull_char", "skull_creeper"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.oak_fence_gate), Lists.newArrayList(new String[]{"oak_fence_gate"}));
      this.variantNames.put(Item.getItemFromBlock(Blocks.oak_fence), Lists.newArrayList(new String[]{"oak_fence"}));
      this.variantNames.put(Items.oak_door, Lists.newArrayList(new String[]{"oak_door"}));
      Iterator var2 = customVariantNames.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var1 = (Entry)var2.next();
         this.variantNames.put((Item)((RegistryDelegate)var1.getKey()).get(), Lists.newArrayList(((Set)var1.getValue()).iterator()));
      }

      CustomItems.update();
      CustomItems.loadModels(this);
   }

   private void bakeItemModels() {
      Iterator var2 = this.itemLocations.values().iterator();

      while(var2.hasNext()) {
         ResourceLocation var1 = (ResourceLocation)var2.next();
         ModelBlock var3 = (ModelBlock)this.models.get(var1);
         if (this.hasItemModel(var3)) {
            ModelBlock var4 = this.makeItemModel(var3);
            if (var4 != null) {
               var4.name = var1.toString();
            }

            this.models.put(var1, var4);
         } else if (this.isCustomRenderer(var3)) {
            this.models.put(var1, var3);
         }
      }

      var2 = this.sprites.values().iterator();

      while(var2.hasNext()) {
         TextureAtlasSprite var5 = (TextureAtlasSprite)var2.next();
         if (!var5.hasAnimationMetadata()) {
            var5.clearFramesTextureData();
         }
      }

   }

   /** @deprecated */
   @Deprecated
   public static void addVariantName(Item var0, String... var1) {
      RegistryDelegate var2 = (RegistryDelegate)Reflector.getFieldValue(var0, Reflector.ForgeItem_delegate);
      if (customVariantNames.containsKey(var2)) {
         ((Set)customVariantNames.get(var2)).addAll(Lists.newArrayList(var1));
      } else {
         customVariantNames.put(var2, Sets.newHashSet(var1));
      }

   }

   private List<String> getVariantNames(Item var1) {
      List var2 = (List)this.variantNames.get(var1);
      if (var2 == null) {
         var2 = Collections.singletonList(((ResourceLocation)Item.itemRegistry.getNameForObject(var1)).toString());
      }

      return var2;
   }

   private Set<ResourceLocation> getTextureLocations(ModelBlock var1) {
      HashSet var2 = Sets.newHashSet();
      Iterator var4 = var1.getElements().iterator();

      while(var4.hasNext()) {
         BlockPart var3 = (BlockPart)var4.next();
         Iterator var6 = var3.mapFaces.values().iterator();

         while(var6.hasNext()) {
            BlockPartFace var5 = (BlockPartFace)var6.next();
            ResourceLocation var7 = new ResourceLocation(var1.resolveTextureName(var5.texture));
            var2.add(var7);
         }
      }

      var2.add(new ResourceLocation(var1.resolveTextureName("particle")));
      return var2;
   }

   private ResourceLocation getModelLocation(ResourceLocation var1) {
      ResourceLocation var2 = var1;
      String var3 = var1.getResourcePath();
      if (!var3.startsWith("mcpatcher") && !var3.startsWith("optifine")) {
         return new ResourceLocation(var1.getResourceDomain(), "models/" + var1.getResourcePath() + ".json");
      } else {
         if (!var3.endsWith(".json")) {
            var2 = new ResourceLocation(var1.getResourceDomain(), var3 + ".json");
         }

         return var2;
      }
   }

   public void loadItemModel(String var1, ResourceLocation var2, ResourceLocation var3) {
      this.itemLocations.put(var1, var2);
      if (this.models.get(var2) == null) {
         try {
            ModelBlock var4 = this.loadModel(var2);
            this.models.put(var2, var4);
         } catch (Exception var5) {
            LOGGER.warn("Unable to load item model: '{}' for item: '{}'", new Object[]{var2, var3});
            LOGGER.warn(var5.getClass().getName() + ": " + var5.getMessage());
         }
      }

   }

   public ModelBlock getModelBlock(ResourceLocation var1) {
      ModelBlock var2 = (ModelBlock)this.models.get(var1);
      return var2;
   }

   private ModelBlockDefinition getModelBlockDefinition(ResourceLocation var1) {
      ResourceLocation var2 = this.getBlockStateLocation(var1);
      ModelBlockDefinition var3 = (ModelBlockDefinition)this.blockDefinitions.get(var2);
      if (var3 == null) {
         ArrayList var4 = Lists.newArrayList();

         try {
            Iterator var6 = this.resourceManager.getAllResources(var2).iterator();

            while(var6.hasNext()) {
               IResource var5 = (IResource)var6.next();
               InputStream var7 = null;

               try {
                  var7 = var5.getInputStream();
                  ModelBlockDefinition var8 = ModelBlockDefinition.parseFromReader(new InputStreamReader(var7, Charsets.UTF_8));
                  var4.add(var8);
               } catch (Exception var13) {
                  throw new RuntimeException("Encountered an exception when loading model definition of '" + var1 + "' from: '" + var5.getResourceLocation() + "' in resourcepack: '" + var5.getResourcePackName() + "'", var13);
               } finally {
                  IOUtils.closeQuietly(var7);
               }
            }
         } catch (IOException var15) {
            throw new RuntimeException("Encountered an exception when loading model definition of model " + var2.toString(), var15);
         }

         var3 = new ModelBlockDefinition(var4);
         this.blockDefinitions.put(var2, var3);
      }

      return var3;
   }

   private Set<ResourceLocation> getVariantsTextureLocations() {
      HashSet var1 = Sets.newHashSet();
      ArrayList var2 = Lists.newArrayList(this.variants.keySet());
      Collections.sort(var2, new Comparator<ModelResourceLocation>(this) {
         final ModelBakery this$0;

         public int compare(ModelResourceLocation var1, ModelResourceLocation var2) {
            return var1.toString().compareTo(var2.toString());
         }

         {
            this.this$0 = var1;
         }

         public int compare(Object var1, Object var2) {
            return this.compare((ModelResourceLocation)var1, (ModelResourceLocation)var2);
         }
      });
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         ModelResourceLocation var3 = (ModelResourceLocation)var4.next();
         ModelBlockDefinition.Variants var5 = (ModelBlockDefinition.Variants)this.variants.get(var3);
         Iterator var7 = var5.getVariants().iterator();

         while(var7.hasNext()) {
            ModelBlockDefinition.Variant var6 = (ModelBlockDefinition.Variant)var7.next();
            ModelBlock var8 = (ModelBlock)this.models.get(var6.getModelLocation());
            if (var8 == null) {
               LOGGER.warn("Missing model for: " + var3);
            } else {
               var1.addAll(this.getTextureLocations(var8));
            }
         }
      }

      var1.addAll(LOCATIONS_BUILTIN_TEXTURES);
      return var1;
   }

   private void loadModelsCheck() {
      this.loadModels();
      Iterator var2 = this.models.values().iterator();

      while(var2.hasNext()) {
         ModelBlock var1 = (ModelBlock)var2.next();
         var1.getParentFromMap(this.models);
      }

      ModelBlock.checkModelHierarchy(this.models);
   }

   private void loadSprites() {
      Set var1 = this.getVariantsTextureLocations();
      var1.addAll(this.getItemsTextureLocations());
      var1.remove(TextureMap.LOCATION_MISSING_TEXTURE);
      IIconCreator var2 = new IIconCreator(this, var1) {
         private final Set val$set;
         final ModelBakery this$0;

         public void registerSprites(TextureMap var1) {
            Iterator var3 = this.val$set.iterator();

            while(var3.hasNext()) {
               ResourceLocation var2 = (ResourceLocation)var3.next();
               TextureAtlasSprite var4 = var1.registerSprite(var2);
               ModelBakery.access$0(this.this$0).put(var2, var4);
            }

         }

         {
            this.this$0 = var1;
            this.val$set = var2;
         }
      };
      this.textureMap.loadSprites(this.resourceManager, var2);
      this.sprites.put(new ResourceLocation("missingno"), this.textureMap.getMissingSprite());
   }

   private ModelBlock loadModel(ResourceLocation var1) throws IOException {
      String var2 = var1.getResourcePath();
      if ("builtin/generated".equals(var2)) {
         return MODEL_GENERATED;
      } else if ("builtin/compass".equals(var2)) {
         return MODEL_COMPASS;
      } else if ("builtin/clock".equals(var2)) {
         return MODEL_CLOCK;
      } else if ("builtin/entity".equals(var2)) {
         return MODEL_ENTITY;
      } else {
         Object var3;
         if (var2.startsWith("builtin/")) {
            String var4 = var2.substring("builtin/".length());
            String var5 = (String)BUILT_IN_MODELS.get(var4);
            if (var5 == null) {
               throw new FileNotFoundException(var1.toString());
            }

            var3 = new StringReader(var5);
         } else {
            var1 = this.getModelLocation(var1);
            IResource var10 = this.resourceManager.getResource(var1);
            var3 = new InputStreamReader(var10.getInputStream(), Charsets.UTF_8);
         }

         try {
            ModelBlock var11 = ModelBlock.deserialize((Reader)var3);
            var11.name = var1.toString();
            String var6 = TextureUtils.getBasePath(var1.getResourcePath());
            fixModelLocations(var11, var6);
            ((Reader)var3).close();
            return var11;
         } finally {
            ((Reader)var3).close();
         }
      }
   }

   protected IBakedModel bakeModel(ModelBlock var1, ITransformation var2, boolean var3) {
      TextureAtlasSprite var4 = (TextureAtlasSprite)this.sprites.get(new ResourceLocation(var1.resolveTextureName("particle")));
      SimpleBakedModel.Builder var5 = (new SimpleBakedModel.Builder(var1)).setTexture(var4);
      Iterator var7 = var1.getElements().iterator();

      label43:
      while(var7.hasNext()) {
         BlockPart var6 = (BlockPart)var7.next();
         Iterator var9 = var6.mapFaces.keySet().iterator();

         while(true) {
            while(true) {
               if (!var9.hasNext()) {
                  continue label43;
               }

               EnumFacing var8 = (EnumFacing)var9.next();
               BlockPartFace var10 = (BlockPartFace)var6.mapFaces.get(var8);
               TextureAtlasSprite var11 = (TextureAtlasSprite)this.sprites.get(new ResourceLocation(var1.resolveTextureName(var10.texture)));
               boolean var12 = true;
               if (Reflector.ForgeHooksClient.exists()) {
                  var12 = TRSRTransformation.isInteger(var2.getMatrix());
               }

               if (var10.cullFace != null && var12) {
                  var5.addFaceQuad(var2.rotate(var10.cullFace), this.makeBakedQuad(var6, var10, var11, var8, var2, var3));
               } else {
                  var5.addGeneralQuad(this.makeBakedQuad(var6, var10, var11, var8, var2, var3));
               }
            }
         }
      }

      return var5.makeBakedModel();
   }

   static Map access$0(ModelBakery var0) {
      return var0.sprites;
   }

   public static <T extends ResourceLocation> void registerItemVariants(Item var0, T... var1) {
      RegistryDelegate var2 = (RegistryDelegate)Reflector.getFieldValue(var0, Reflector.ForgeItem_delegate);
      if (!customVariantNames.containsKey(var2)) {
         customVariantNames.put(var2, Sets.newHashSet());
      }

      ResourceLocation[] var6 = var1;
      int var5 = var1.length;

      for(int var4 = 0; var4 < var5; ++var4) {
         ResourceLocation var3 = var6[var4];
         ((Set)customVariantNames.get(var2)).add(var3.toString());
      }

   }

   protected BakedQuad makeBakedQuad(BlockPart var1, BlockPartFace var2, TextureAtlasSprite var3, EnumFacing var4, ITransformation var5, boolean var6) {
      return this.faceBakery.makeBakedQuad(var1.positionFrom, var1.positionTo, var2, var3, var4, var5, var1.partRotation, var6, var1.shade);
   }

   private static String fixResourcePath(String var0, String var1) {
      var0 = TextureUtils.fixResourcePath(var0, var1);
      var0 = StrUtils.removeSuffix(var0, ".json");
      var0 = StrUtils.removeSuffix(var0, ".png");
      return var0;
   }

   public static void fixModelLocations(ModelBlock var0, String var1) {
      ResourceLocation var2 = fixModelLocation(var0.getParentLocation(), var1);
      if (var2 != var0.getParentLocation()) {
         Reflector.setFieldValue(var0, Reflector.ModelBlock_parentLocation, var2);
      }

      Map var3 = (Map)Reflector.getFieldValue(var0, Reflector.ModelBlock_textures);
      if (var3 != null) {
         Iterator var5 = var3.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var4 = (Entry)var5.next();
            String var6 = (String)var4.getValue();
            String var7 = fixResourcePath(var6, var1);
            if (var7 != var6) {
               var4.setValue(var7);
            }
         }
      }

   }

   private void loadVariantModels() {
      Iterator var2 = this.variants.keySet().iterator();

      while(var2.hasNext()) {
         ModelResourceLocation var1 = (ModelResourceLocation)var2.next();
         Iterator var4 = ((ModelBlockDefinition.Variants)this.variants.get(var1)).getVariants().iterator();

         while(var4.hasNext()) {
            ModelBlockDefinition.Variant var3 = (ModelBlockDefinition.Variant)var4.next();
            ResourceLocation var5 = var3.getModelLocation();
            if (this.models.get(var5) == null) {
               try {
                  ModelBlock var6 = this.loadModel(var5);
                  this.models.put(var5, var6);
               } catch (Exception var7) {
                  LOGGER.warn("Unable to load block model: '" + var5 + "' for variant: '" + var1 + "'", var7);
               }
            }
         }
      }

   }

   private boolean hasItemModel(ModelBlock var1) {
      if (var1 == null) {
         return false;
      } else {
         ModelBlock var2 = var1.getRootModel();
         return var2 == MODEL_GENERATED || var2 == MODEL_COMPASS || var2 == MODEL_CLOCK;
      }
   }

   private void loadVariants(Collection<ModelResourceLocation> var1) {
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         ModelResourceLocation var2 = (ModelResourceLocation)var3.next();

         try {
            ModelBlockDefinition var4 = this.getModelBlockDefinition(var2);

            try {
               this.registerVariant(var4, var2);
            } catch (Exception var6) {
               LOGGER.warn("Unable to load variant: " + var2.getVariant() + " from " + var2, var6);
            }
         } catch (Exception var7) {
            LOGGER.warn("Unable to load definition " + var2, var7);
         }
      }

   }

   private boolean isCustomRenderer(ModelBlock var1) {
      if (var1 == null) {
         return false;
      } else {
         ModelBlock var2 = var1.getRootModel();
         return var2 == MODEL_ENTITY;
      }
   }

   private void loadModels() {
      ArrayDeque var1 = Queues.newArrayDeque();
      HashSet var2 = Sets.newHashSet();
      Iterator var4 = this.models.keySet().iterator();

      ResourceLocation var3;
      ResourceLocation var5;
      while(var4.hasNext()) {
         var3 = (ResourceLocation)var4.next();
         var2.add(var3);
         var5 = ((ModelBlock)this.models.get(var3)).getParentLocation();
         if (var5 != null) {
            var1.add(var5);
         }
      }

      while(!var1.isEmpty()) {
         var3 = (ResourceLocation)var1.pop();

         try {
            if (this.models.get(var3) != null) {
               continue;
            }

            ModelBlock var7 = this.loadModel(var3);
            this.models.put(var3, var7);
            var5 = var7.getParentLocation();
            if (var5 != null && !var2.contains(var5)) {
               var1.add(var5);
            }
         } catch (Exception var6) {
            LOGGER.warn("In parent chain: " + JOINER.join(this.getParentPath(var3)) + "; unable to load model: '" + var3 + "'");
         }

         var2.add(var3);
      }

   }

   private ResourceLocation getBlockStateLocation(ResourceLocation var1) {
      return new ResourceLocation(var1.getResourceDomain(), "blockstates/" + var1.getResourcePath() + ".json");
   }

   private ModelBlock makeItemModel(ModelBlock var1) {
      return this.itemModelGenerator.makeItemModel(this.textureMap, var1);
   }

   public IBakedModel bakeModel(ModelBlock var1, ModelRotation var2, boolean var3) {
      return this.bakeModel(var1, (ITransformation)var2, var3);
   }

   public ModelBakery(IResourceManager var1, TextureMap var2, BlockModelShapes var3) {
      this.resourceManager = var1;
      this.textureMap = var2;
      this.blockModelShapes = var3;
   }

   private List<ResourceLocation> getParentPath(ResourceLocation var1) {
      ArrayList var2 = Lists.newArrayList(new ResourceLocation[]{var1});
      ResourceLocation var3 = var1;

      while((var3 = this.getParentLocation(var3)) != null) {
         var2.add(0, var3);
      }

      return var2;
   }

   private ResourceLocation getItemLocation(String var1) {
      ResourceLocation var2 = new ResourceLocation(var1);
      if (Reflector.ForgeHooksClient.exists()) {
         var2 = new ResourceLocation(var1.replaceAll("#.*", ""));
      }

      return new ResourceLocation(var2.getResourceDomain(), "item/" + var2.getResourcePath());
   }

   private BakedQuad makeBakedQuad(BlockPart var1, BlockPartFace var2, TextureAtlasSprite var3, EnumFacing var4, ModelRotation var5, boolean var6) {
      return Reflector.ForgeHooksClient.exists() ? this.makeBakedQuad(var1, var2, var3, var4, var5, var6) : this.faceBakery.makeBakedQuad(var1.positionFrom, var1.positionTo, var2, var3, var4, var5, var1.partRotation, var6, var1.shade);
   }

   private ResourceLocation getParentLocation(ResourceLocation var1) {
      Iterator var3 = this.models.entrySet().iterator();

      Entry var2;
      ModelBlock var4;
      do {
         if (!var3.hasNext()) {
            return null;
         }

         var2 = (Entry)var3.next();
         var4 = (ModelBlock)var2.getValue();
      } while(var4 == null || !var1.equals(var4.getParentLocation()));

      return (ResourceLocation)var2.getKey();
   }

   private void loadVariantItemModels() {
      this.loadVariants(this.blockModelShapes.getBlockStateMapper().putAllStateModelLocations().values());
      this.variants.put(MODEL_MISSING, new ModelBlockDefinition.Variants(MODEL_MISSING.getVariant(), Lists.newArrayList(new ModelBlockDefinition.Variant[]{new ModelBlockDefinition.Variant(new ResourceLocation(MODEL_MISSING.getResourcePath()), ModelRotation.X0_Y0, false, 1)})));
      ResourceLocation var1 = new ResourceLocation("item_frame");
      ModelBlockDefinition var2 = this.getModelBlockDefinition(var1);
      this.registerVariant(var2, new ModelResourceLocation(var1, "normal"));
      this.registerVariant(var2, new ModelResourceLocation(var1, "map"));
      this.loadVariantModels();
      this.loadItemModels();
   }

   private void bakeBlockModels() {
      Iterator var2 = this.variants.keySet().iterator();

      while(var2.hasNext()) {
         ModelResourceLocation var1 = (ModelResourceLocation)var2.next();
         WeightedBakedModel.Builder var3 = new WeightedBakedModel.Builder();
         int var4 = 0;
         Iterator var6 = ((ModelBlockDefinition.Variants)this.variants.get(var1)).getVariants().iterator();

         while(true) {
            while(var6.hasNext()) {
               ModelBlockDefinition.Variant var5 = (ModelBlockDefinition.Variant)var6.next();
               ModelBlock var7 = (ModelBlock)this.models.get(var5.getModelLocation());
               if (var7 != null && var7.isResolved()) {
                  ++var4;
                  var3.add(this.bakeModel(var7, var5.getRotation(), var5.isUvLocked()), var5.getWeight());
               } else {
                  LOGGER.warn("Missing model for: " + var1);
               }
            }

            if (var4 == 0) {
               LOGGER.warn("No weighted models for: " + var1);
            } else if (var4 == 1) {
               this.bakedRegistry.putObject(var1, var3.first());
            } else {
               this.bakedRegistry.putObject(var1, var3.build());
            }
            break;
         }
      }

      var2 = this.itemLocations.entrySet().iterator();

      while(true) {
         while(var2.hasNext()) {
            Entry var8 = (Entry)var2.next();
            ResourceLocation var9 = (ResourceLocation)var8.getValue();
            ModelResourceLocation var10 = new ModelResourceLocation((String)var8.getKey(), "inventory");
            if (Reflector.ModelLoader_getInventoryVariant.exists()) {
               var10 = (ModelResourceLocation)Reflector.call(Reflector.ModelLoader_getInventoryVariant, var8.getKey());
            }

            ModelBlock var11 = (ModelBlock)this.models.get(var9);
            if (var11 != null && var11.isResolved()) {
               if (this.isCustomRenderer(var11)) {
                  this.bakedRegistry.putObject(var10, new BuiltInModel(var11.getAllTransforms()));
               } else {
                  this.bakedRegistry.putObject(var10, this.bakeModel(var11, ModelRotation.X0_Y0, false));
               }
            } else {
               LOGGER.warn("Missing model for: " + var9);
            }
         }

         return;
      }
   }

   public static ResourceLocation fixModelLocation(ResourceLocation var0, String var1) {
      if (var0 != null && var1 != null) {
         if (!var0.getResourceDomain().equals("minecraft")) {
            return var0;
         } else {
            String var2 = var0.getResourcePath();
            String var3 = fixResourcePath(var2, var1);
            if (var3 != var2) {
               var0 = new ResourceLocation(var0.getResourceDomain(), var3);
            }

            return var0;
         }
      } else {
         return var0;
      }
   }

   private void registerVariant(ModelBlockDefinition var1, ModelResourceLocation var2) {
      this.variants.put(var2, var1.getVariants(var2.getVariant()));
   }

   static {
      BUILT_IN_MODELS.put("missing", "{ \"textures\": {   \"particle\": \"missingno\",   \"missingno\": \"missingno\"}, \"elements\": [ {     \"from\": [ 0, 0, 0 ],     \"to\": [ 16, 16, 16 ],     \"faces\": {         \"down\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"down\", \"texture\": \"#missingno\" },         \"up\":    { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"up\", \"texture\": \"#missingno\" },         \"north\": { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"north\", \"texture\": \"#missingno\" },         \"south\": { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"south\", \"texture\": \"#missingno\" },         \"west\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"west\", \"texture\": \"#missingno\" },         \"east\":  { \"uv\": [ 0, 0, 16, 16 ], \"cullface\": \"east\", \"texture\": \"#missingno\" }    }}]}");
      MODEL_GENERATED.name = "generation marker";
      MODEL_COMPASS.name = "compass generation marker";
      MODEL_CLOCK.name = "class generation marker";
      MODEL_ENTITY.name = "block entity marker";
   }

   public IRegistry<ModelResourceLocation, IBakedModel> setupModelRegistry() {
      this.loadVariantItemModels();
      this.loadModelsCheck();
      this.loadSprites();
      this.bakeItemModels();
      this.bakeBlockModels();
      return this.bakedRegistry;
   }
}
