package net.minecraft.tileentity;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.block.BlockFlower;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class TileEntityBanner extends TileEntity {
   private List<TileEntityBanner.EnumBannerPattern> patternList;
   private String patternResourceLocation;
   private NBTTagList patterns;
   private List<EnumDyeColor> colorList;
   private boolean field_175119_g;
   private int baseColor;

   public static void removeBannerData(ItemStack var0) {
      NBTTagCompound var1 = var0.getSubCompound("BlockEntityTag", false);
      if (var1 != null && var1.hasKey("Patterns", 9)) {
         NBTTagList var2 = var1.getTagList("Patterns", 10);
         if (var2.tagCount() > 0) {
            var2.removeTag(var2.tagCount() - 1);
            if (var2.hasNoTags()) {
               var0.getTagCompound().removeTag("BlockEntityTag");
               if (var0.getTagCompound().hasNoTags()) {
                  var0.setTagCompound((NBTTagCompound)null);
               }
            }
         }
      }

   }

   public String getPatternResourceLocation() {
      this.initializeBannerData();
      return this.patternResourceLocation;
   }

   public List<EnumDyeColor> getColorList() {
      this.initializeBannerData();
      return this.colorList;
   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
      setBaseColorAndPatterns(var1, this.baseColor, this.patterns);
   }

   public Packet getDescriptionPacket() {
      NBTTagCompound var1 = new NBTTagCompound();
      this.writeToNBT(var1);
      return new S35PacketUpdateTileEntity(this.pos, 6, var1);
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
      this.baseColor = var1.getInteger("Base");
      this.patterns = var1.getTagList("Patterns", 10);
      this.patternList = null;
      this.colorList = null;
      this.patternResourceLocation = null;
      this.field_175119_g = true;
   }

   public void setItemValues(ItemStack var1) {
      this.patterns = null;
      if (var1.hasTagCompound() && var1.getTagCompound().hasKey("BlockEntityTag", 10)) {
         NBTTagCompound var2 = var1.getTagCompound().getCompoundTag("BlockEntityTag");
         if (var2.hasKey("Patterns")) {
            this.patterns = (NBTTagList)var2.getTagList("Patterns", 10).copy();
         }

         if (var2.hasKey("Base", 99)) {
            this.baseColor = var2.getInteger("Base");
         } else {
            this.baseColor = var1.getMetadata() & 15;
         }
      } else {
         this.baseColor = var1.getMetadata() & 15;
      }

      this.patternList = null;
      this.colorList = null;
      this.patternResourceLocation = "";
      this.field_175119_g = true;
   }

   public int getBaseColor() {
      return this.baseColor;
   }

   public static int getPatterns(ItemStack var0) {
      NBTTagCompound var1 = var0.getSubCompound("BlockEntityTag", false);
      return var1 != null && var1.hasKey("Patterns") ? var1.getTagList("Patterns", 10).tagCount() : 0;
   }

   public NBTTagList getPatterns() {
      return this.patterns;
   }

   public static int getBaseColor(ItemStack var0) {
      NBTTagCompound var1 = var0.getSubCompound("BlockEntityTag", false);
      return var1 != null && var1.hasKey("Base") ? var1.getInteger("Base") : var0.getMetadata();
   }

   public List<TileEntityBanner.EnumBannerPattern> getPatternList() {
      this.initializeBannerData();
      return this.patternList;
   }

   private void initializeBannerData() {
      if (this.patternList == null || this.colorList == null || this.patternResourceLocation == null) {
         if (!this.field_175119_g) {
            this.patternResourceLocation = "";
         } else {
            this.patternList = Lists.newArrayList();
            this.colorList = Lists.newArrayList();
            this.patternList.add(TileEntityBanner.EnumBannerPattern.BASE);
            this.colorList.add(EnumDyeColor.byDyeDamage(this.baseColor));
            this.patternResourceLocation = "b" + this.baseColor;
            if (this.patterns != null) {
               for(int var1 = 0; var1 < this.patterns.tagCount(); ++var1) {
                  NBTTagCompound var2 = this.patterns.getCompoundTagAt(var1);
                  TileEntityBanner.EnumBannerPattern var3 = TileEntityBanner.EnumBannerPattern.getPatternByID(var2.getString("Pattern"));
                  if (var3 != null) {
                     this.patternList.add(var3);
                     int var4 = var2.getInteger("Color");
                     this.colorList.add(EnumDyeColor.byDyeDamage(var4));
                     this.patternResourceLocation = this.patternResourceLocation + var3.getPatternID() + var4;
                  }
               }
            }
         }
      }

   }

   public static void setBaseColorAndPatterns(NBTTagCompound var0, int var1, NBTTagList var2) {
      var0.setInteger("Base", var1);
      if (var2 != null) {
         var0.setTag("Patterns", var2);
      }

   }

   public static enum EnumBannerPattern {
      DIAGONAL_LEFT_MIRROR("diagonal_up_left", "lud", "   ", "#  ", "## "),
      TRIANGLE_TOP("triangle_top", "tt", "# #", " # ", "   "),
      SQUARE_TOP_RIGHT("square_top_right", "tr", "  #", "   ", "   "),
      DIAGONAL_RIGHT("diagonal_up_right", "rd", "   ", "  #", " ##"),
      STRIPE_BOTTOM("stripe_bottom", "bs", "   ", "   ", "###");

      private String patternName;
      HALF_VERTICAL("half_vertical", "vh", "## ", "## ", "## "),
      SKULL("skull", "sku", new ItemStack(Items.skull, 1, 1));

      private ItemStack patternCraftingStack;
      TRIANGLE_BOTTOM("triangle_bottom", "bt", "   ", " # ", "# #"),
      BASE("base", "b"),
      STRIPE_CENTER("stripe_center", "cs", " # ", " # ", " # "),
      STRIPE_MIDDLE("stripe_middle", "ms", "   ", "###", "   "),
      SQUARE_BOTTOM_LEFT("square_bottom_left", "bl", "   ", "   ", "#  "),
      STRIPE_SMALL("small_stripes", "ss", "# #", "# #", "   ");

      private String[] craftingLayers;
      CREEPER("creeper", "cre", new ItemStack(Items.skull, 1, 4)),
      BRICKS("bricks", "bri", new ItemStack(Blocks.brick_block)),
      SQUARE_BOTTOM_RIGHT("square_bottom_right", "br", "   ", "   ", "  #"),
      STRIPE_RIGHT("stripe_right", "rs", "  #", "  #", "  #"),
      FLOWER("flower", "flo", new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.OXEYE_DAISY.getMeta())),
      HALF_HORIZONTAL_MIRROR("half_horizontal_bottom", "hhb", "   ", "###", "###"),
      STRIPE_TOP("stripe_top", "ts", "###", "   ", "   "),
      CROSS("cross", "cr", "# #", " # ", "# #"),
      GRADIENT("gradient", "gra", "# #", " # ", " # "),
      STRIPE_DOWNLEFT("stripe_downleft", "dls", "  #", " # ", "#  "),
      SQUARE_TOP_LEFT("square_top_left", "tl", "#  ", "   ", "   "),
      MOJANG("mojang", "moj", new ItemStack(Items.golden_apple, 1, 1)),
      TRIANGLES_BOTTOM("triangles_bottom", "bts", "   ", "# #", " # "),
      RHOMBUS_MIDDLE("rhombus", "mr", " # ", "# #", " # "),
      STRIPE_LEFT("stripe_left", "ls", "#  ", "#  ", "#  "),
      TRIANGLES_TOP("triangles_top", "tts", " # ", "# #", "   "),
      STRAIGHT_CROSS("straight_cross", "sc", " # ", "###", " # "),
      DIAGONAL_RIGHT_MIRROR("diagonal_right", "rud", " ##", "  #", "   "),
      DIAGONAL_LEFT("diagonal_left", "ld", "## ", "#  ", "   "),
      STRIPE_DOWNRIGHT("stripe_downright", "drs", "#  ", " # ", "  #"),
      BORDER("border", "bo", "###", "# #", "###"),
      CIRCLE_MIDDLE("circle", "mc", "   ", " # ", "   ");

      private static final TileEntityBanner.EnumBannerPattern[] ENUM$VALUES = new TileEntityBanner.EnumBannerPattern[]{BASE, SQUARE_BOTTOM_LEFT, SQUARE_BOTTOM_RIGHT, SQUARE_TOP_LEFT, SQUARE_TOP_RIGHT, STRIPE_BOTTOM, STRIPE_TOP, STRIPE_LEFT, STRIPE_RIGHT, STRIPE_CENTER, STRIPE_MIDDLE, STRIPE_DOWNRIGHT, STRIPE_DOWNLEFT, STRIPE_SMALL, CROSS, STRAIGHT_CROSS, TRIANGLE_BOTTOM, TRIANGLE_TOP, TRIANGLES_BOTTOM, TRIANGLES_TOP, DIAGONAL_LEFT, DIAGONAL_RIGHT, DIAGONAL_LEFT_MIRROR, DIAGONAL_RIGHT_MIRROR, CIRCLE_MIDDLE, RHOMBUS_MIDDLE, HALF_VERTICAL, HALF_HORIZONTAL, HALF_VERTICAL_MIRROR, HALF_HORIZONTAL_MIRROR, BORDER, CURLY_BORDER, CREEPER, GRADIENT, GRADIENT_UP, BRICKS, SKULL, FLOWER, MOJANG};
      CURLY_BORDER("curly_border", "cbo", new ItemStack(Blocks.vine));

      private String patternID;
      GRADIENT_UP("gradient_up", "gru", " # ", " # ", "# #"),
      HALF_HORIZONTAL("half_horizontal", "hh", "###", "###", "   "),
      HALF_VERTICAL_MIRROR("half_vertical_right", "vhr", " ##", " ##", " ##");

      public boolean hasValidCrafting() {
         return this.patternCraftingStack != null || this.craftingLayers[0] != null;
      }

      public String getPatternID() {
         return this.patternID;
      }

      private EnumBannerPattern(String var3, String var4, String var5, String var6, String var7) {
         this(var3, var4);
         this.craftingLayers[0] = var5;
         this.craftingLayers[1] = var6;
         this.craftingLayers[2] = var7;
      }

      public String getPatternName() {
         return this.patternName;
      }

      public ItemStack getCraftingStack() {
         return this.patternCraftingStack;
      }

      public boolean hasCraftingStack() {
         return this.patternCraftingStack != null;
      }

      private EnumBannerPattern(String var3, String var4) {
         this.craftingLayers = new String[3];
         this.patternName = var3;
         this.patternID = var4;
      }

      public static TileEntityBanner.EnumBannerPattern getPatternByID(String var0) {
         TileEntityBanner.EnumBannerPattern[] var4;
         int var3 = (var4 = values()).length;

         for(int var2 = 0; var2 < var3; ++var2) {
            TileEntityBanner.EnumBannerPattern var1 = var4[var2];
            if (var1.patternID.equals(var0)) {
               return var1;
            }
         }

         return null;
      }

      public String[] getCraftingLayers() {
         return this.craftingLayers;
      }

      private EnumBannerPattern(String var3, String var4, ItemStack var5) {
         this(var3, var4);
         this.patternCraftingStack = var5;
      }
   }
}
