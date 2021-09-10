package net.minecraft.block;

import java.util.Random;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

public class BlockHugeMushroom extends Block {
   private static int[] $SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType;
   public static final PropertyEnum<BlockHugeMushroom.EnumType> VARIANT = PropertyEnum.create("variant", BlockHugeMushroom.EnumType.class);
   private final Block smallBlock;

   public IBlockState getStateFromMeta(int var1) {
      return this.getDefaultState().withProperty(VARIANT, BlockHugeMushroom.EnumType.byMetadata(var1));
   }

   public int getMetaFromState(IBlockState var1) {
      return ((BlockHugeMushroom.EnumType)var1.getValue(VARIANT)).getMetadata();
   }

   public MapColor getMapColor(IBlockState var1) {
      switch($SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType()[((BlockHugeMushroom.EnumType)var1.getValue(VARIANT)).ordinal()]) {
      case 10:
         return MapColor.sandColor;
      case 11:
         return MapColor.sandColor;
      case 12:
      default:
         return super.getMapColor(var1);
      case 13:
         return MapColor.clothColor;
      }
   }

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{VARIANT});
   }

   static int[] $SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[BlockHugeMushroom.EnumType.values().length];

         try {
            var0[BlockHugeMushroom.EnumType.ALL_INSIDE.ordinal()] = 11;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.ALL_OUTSIDE.ordinal()] = 12;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.ALL_STEM.ordinal()] = 13;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.CENTER.ordinal()] = 5;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.EAST.ordinal()] = 6;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.NORTH.ordinal()] = 2;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.NORTH_EAST.ordinal()] = 3;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.NORTH_WEST.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.SOUTH.ordinal()] = 8;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.SOUTH_EAST.ordinal()] = 9;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.SOUTH_WEST.ordinal()] = 7;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.STEM.ordinal()] = 10;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[BlockHugeMushroom.EnumType.WEST.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$block$BlockHugeMushroom$EnumType = var0;
         return var0;
      }
   }

   public Item getItemDropped(IBlockState var1, Random var2, int var3) {
      return Item.getItemFromBlock(this.smallBlock);
   }

   public int quantityDropped(Random var1) {
      return Math.max(0, var1.nextInt(10) - 7);
   }

   public IBlockState onBlockPlaced(World var1, BlockPos var2, EnumFacing var3, float var4, float var5, float var6, int var7, EntityLivingBase var8) {
      return this.getDefaultState();
   }

   public Item getItem(World var1, BlockPos var2) {
      return Item.getItemFromBlock(this.smallBlock);
   }

   public BlockHugeMushroom(Material var1, MapColor var2, Block var3) {
      super(var1, var2);
      this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockHugeMushroom.EnumType.ALL_OUTSIDE));
      this.smallBlock = var3;
   }

   public static enum EnumType implements IStringSerializable {
      WEST(4, "west"),
      SOUTH_EAST(9, "south_east"),
      NORTH(2, "north"),
      ALL_OUTSIDE(14, "all_outside"),
      SOUTH(8, "south"),
      NORTH_WEST(1, "north_west");

      private static final BlockHugeMushroom.EnumType[] ENUM$VALUES = new BlockHugeMushroom.EnumType[]{NORTH_WEST, NORTH, NORTH_EAST, WEST, CENTER, EAST, SOUTH_WEST, SOUTH, SOUTH_EAST, STEM, ALL_INSIDE, ALL_OUTSIDE, ALL_STEM};
      ALL_INSIDE(0, "all_inside"),
      CENTER(5, "center"),
      ALL_STEM(15, "all_stem");

      private static final BlockHugeMushroom.EnumType[] META_LOOKUP = new BlockHugeMushroom.EnumType[16];
      EAST(6, "east"),
      SOUTH_WEST(7, "south_west");

      private final int meta;
      private final String name;
      STEM(10, "stem"),
      NORTH_EAST(3, "north_east");

      public static BlockHugeMushroom.EnumType byMetadata(int var0) {
         if (var0 < 0 || var0 >= META_LOOKUP.length) {
            var0 = 0;
         }

         BlockHugeMushroom.EnumType var1 = META_LOOKUP[var0];
         return var1 == null ? META_LOOKUP[0] : var1;
      }

      public int getMetadata() {
         return this.meta;
      }

      public String toString() {
         return this.name;
      }

      static {
         BlockHugeMushroom.EnumType[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            BlockHugeMushroom.EnumType var0 = var3[var1];
            META_LOOKUP[var0.getMetadata()] = var0;
         }

      }

      private EnumType(int var3, String var4) {
         this.meta = var3;
         this.name = var4;
      }

      public String getName() {
         return this.name;
      }
   }
}
