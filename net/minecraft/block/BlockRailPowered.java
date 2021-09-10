package net.minecraft.block;

import com.google.common.base.Predicate;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class BlockRailPowered extends BlockRailBase {
   private static int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
   public static final PropertyBool POWERED = PropertyBool.create("powered");
   public static final PropertyEnum<BlockRailBase.EnumRailDirection> SHAPE = PropertyEnum.create("shape", BlockRailBase.EnumRailDirection.class, new Predicate<BlockRailBase.EnumRailDirection>() {
      public boolean apply(BlockRailBase.EnumRailDirection var1) {
         return var1 != BlockRailBase.EnumRailDirection.NORTH_EAST && var1 != BlockRailBase.EnumRailDirection.NORTH_WEST && var1 != BlockRailBase.EnumRailDirection.SOUTH_EAST && var1 != BlockRailBase.EnumRailDirection.SOUTH_WEST;
      }

      public boolean apply(Object var1) {
         return this.apply((BlockRailBase.EnumRailDirection)var1);
      }
   });

   protected BlockRailPowered() {
      super(true);
      this.setDefaultState(this.blockState.getBaseState().withProperty(SHAPE, BlockRailBase.EnumRailDirection.NORTH_SOUTH).withProperty(POWERED, false));
   }

   protected void onNeighborChangedInternal(World var1, BlockPos var2, IBlockState var3, Block var4) {
      boolean var5 = (Boolean)var3.getValue(POWERED);
      boolean var6 = var1.isBlockPowered(var2) || this.func_176566_a(var1, var2, var3, true, 0) || this.func_176566_a(var1, var2, var3, false, 0);
      if (var6 != var5) {
         var1.setBlockState(var2, var3.withProperty(POWERED, var6), 3);
         var1.notifyNeighborsOfStateChange(var2.down(), this);
         if (((BlockRailBase.EnumRailDirection)var3.getValue(SHAPE)).isAscending()) {
            var1.notifyNeighborsOfStateChange(var2.up(), this);
         }
      }

   }

   public IProperty<BlockRailBase.EnumRailDirection> getShapeProperty() {
      return SHAPE;
   }

   protected boolean func_176567_a(World var1, BlockPos var2, boolean var3, int var4, BlockRailBase.EnumRailDirection var5) {
      IBlockState var6 = var1.getBlockState(var2);
      if (var6.getBlock() != this) {
         return false;
      } else {
         BlockRailBase.EnumRailDirection var7 = (BlockRailBase.EnumRailDirection)var6.getValue(SHAPE);
         if (var5 != BlockRailBase.EnumRailDirection.EAST_WEST || var7 != BlockRailBase.EnumRailDirection.NORTH_SOUTH && var7 != BlockRailBase.EnumRailDirection.ASCENDING_NORTH && var7 != BlockRailBase.EnumRailDirection.ASCENDING_SOUTH) {
            if (var5 == BlockRailBase.EnumRailDirection.NORTH_SOUTH && (var7 == BlockRailBase.EnumRailDirection.EAST_WEST || var7 == BlockRailBase.EnumRailDirection.ASCENDING_EAST || var7 == BlockRailBase.EnumRailDirection.ASCENDING_WEST)) {
               return false;
            } else if ((Boolean)var6.getValue(POWERED)) {
               return var1.isBlockPowered(var2) ? true : this.func_176566_a(var1, var2, var6, var3, var4 + 1);
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   protected BlockState createBlockState() {
      return new BlockState(this, new IProperty[]{SHAPE, POWERED});
   }

   static int[] $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[BlockRailBase.EnumRailDirection.values().length];

         try {
            var0[BlockRailBase.EnumRailDirection.ASCENDING_EAST.ordinal()] = 3;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[BlockRailBase.EnumRailDirection.ASCENDING_NORTH.ordinal()] = 5;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[BlockRailBase.EnumRailDirection.ASCENDING_SOUTH.ordinal()] = 6;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[BlockRailBase.EnumRailDirection.ASCENDING_WEST.ordinal()] = 4;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[BlockRailBase.EnumRailDirection.EAST_WEST.ordinal()] = 2;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[BlockRailBase.EnumRailDirection.NORTH_EAST.ordinal()] = 10;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[BlockRailBase.EnumRailDirection.NORTH_SOUTH.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[BlockRailBase.EnumRailDirection.NORTH_WEST.ordinal()] = 9;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[BlockRailBase.EnumRailDirection.SOUTH_EAST.ordinal()] = 7;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[BlockRailBase.EnumRailDirection.SOUTH_WEST.ordinal()] = 8;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection = var0;
         return var0;
      }
   }

   public IBlockState getStateFromMeta(int var1) {
      return this.getDefaultState().withProperty(SHAPE, BlockRailBase.EnumRailDirection.byMetadata(var1 & 7)).withProperty(POWERED, (var1 & 8) > 0);
   }

   protected boolean func_176566_a(World var1, BlockPos var2, IBlockState var3, boolean var4, int var5) {
      if (var5 >= 8) {
         return false;
      } else {
         int var6 = var2.getX();
         int var7 = var2.getY();
         int var8 = var2.getZ();
         boolean var9 = true;
         BlockRailBase.EnumRailDirection var10 = (BlockRailBase.EnumRailDirection)var3.getValue(SHAPE);
         switch($SWITCH_TABLE$net$minecraft$block$BlockRailBase$EnumRailDirection()[var10.ordinal()]) {
         case 1:
            if (var4) {
               ++var8;
            } else {
               --var8;
            }
            break;
         case 2:
            if (var4) {
               --var6;
            } else {
               ++var6;
            }
            break;
         case 3:
            if (var4) {
               --var6;
            } else {
               ++var6;
               ++var7;
               var9 = false;
            }

            var10 = BlockRailBase.EnumRailDirection.EAST_WEST;
            break;
         case 4:
            if (var4) {
               --var6;
               ++var7;
               var9 = false;
            } else {
               ++var6;
            }

            var10 = BlockRailBase.EnumRailDirection.EAST_WEST;
            break;
         case 5:
            if (var4) {
               ++var8;
            } else {
               --var8;
               ++var7;
               var9 = false;
            }

            var10 = BlockRailBase.EnumRailDirection.NORTH_SOUTH;
            break;
         case 6:
            if (var4) {
               ++var8;
               ++var7;
               var9 = false;
            } else {
               --var8;
            }

            var10 = BlockRailBase.EnumRailDirection.NORTH_SOUTH;
         }

         if (this.func_176567_a(var1, new BlockPos(var6, var7, var8), var4, var5, var10)) {
            return true;
         } else {
            return var9 && this.func_176567_a(var1, new BlockPos(var6, var7 - 1, var8), var4, var5, var10);
         }
      }
   }

   public int getMetaFromState(IBlockState var1) {
      byte var2 = 0;
      int var3 = var2 | ((BlockRailBase.EnumRailDirection)var1.getValue(SHAPE)).getMetadata();
      if ((Boolean)var1.getValue(POWERED)) {
         var3 |= 8;
      }

      return var3;
   }
}
