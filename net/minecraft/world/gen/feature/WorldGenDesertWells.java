package net.minecraft.world.gen.feature;

import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.Random;
import net.minecraft.block.BlockSand;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class WorldGenDesertWells extends WorldGenerator {
   private final IBlockState field_175910_d;
   private final IBlockState field_175912_c;
   private static final BlockStateHelper field_175913_a;
   private final IBlockState field_175911_b;

   public boolean generate(World var1, Random var2, BlockPos var3) {
      while(var1.isAirBlock(var3) && var3.getY() > 2) {
         var3 = var3.down();
      }

      if (!field_175913_a.apply(var1.getBlockState(var3))) {
         return false;
      } else {
         int var4;
         int var5;
         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if (var1.isAirBlock(var3.add(var4, -1, var5)) && var1.isAirBlock(var3.add(var4, -2, var5))) {
                  return false;
               }
            }
         }

         for(var4 = -1; var4 <= 0; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               for(int var6 = -2; var6 <= 2; ++var6) {
                  var1.setBlockState(var3.add(var5, var4, var6), this.field_175912_c, 2);
               }
            }
         }

         var1.setBlockState(var3, this.field_175910_d, 2);
         Iterator var8 = EnumFacing.Plane.HORIZONTAL.iterator();

         while(var8.hasNext()) {
            EnumFacing var7 = (EnumFacing)var8.next();
            var1.setBlockState(var3.offset(var7), this.field_175910_d, 2);
         }

         for(var4 = -2; var4 <= 2; ++var4) {
            for(var5 = -2; var5 <= 2; ++var5) {
               if (var4 == -2 || var4 == 2 || var5 == -2 || var5 == 2) {
                  var1.setBlockState(var3.add(var4, 1, var5), this.field_175912_c, 2);
               }
            }
         }

         var1.setBlockState(var3.add(2, 1, 0), this.field_175911_b, 2);
         var1.setBlockState(var3.add(-2, 1, 0), this.field_175911_b, 2);
         var1.setBlockState(var3.add(0, 1, 2), this.field_175911_b, 2);
         var1.setBlockState(var3.add(0, 1, -2), this.field_175911_b, 2);

         for(var4 = -1; var4 <= 1; ++var4) {
            for(var5 = -1; var5 <= 1; ++var5) {
               if (var4 == 0 && var5 == 0) {
                  var1.setBlockState(var3.add(var4, 4, var5), this.field_175912_c, 2);
               } else {
                  var1.setBlockState(var3.add(var4, 4, var5), this.field_175911_b, 2);
               }
            }
         }

         for(var4 = 1; var4 <= 3; ++var4) {
            var1.setBlockState(var3.add(-1, var4, -1), this.field_175912_c, 2);
            var1.setBlockState(var3.add(-1, var4, 1), this.field_175912_c, 2);
            var1.setBlockState(var3.add(1, var4, -1), this.field_175912_c, 2);
            var1.setBlockState(var3.add(1, var4, 1), this.field_175912_c, 2);
         }

         return true;
      }
   }

   static {
      field_175913_a = BlockStateHelper.forBlock(Blocks.sand).where(BlockSand.VARIANT, Predicates.equalTo(BlockSand.EnumType.SAND));
   }

   public WorldGenDesertWells() {
      this.field_175911_b = Blocks.stone_slab.getDefaultState().withProperty(BlockStoneSlab.VARIANT, BlockStoneSlab.EnumType.SAND).withProperty(BlockSlab.HALF, BlockSlab.EnumBlockHalf.BOTTOM);
      this.field_175912_c = Blocks.sandstone.getDefaultState();
      this.field_175910_d = Blocks.flowing_water.getDefaultState();
   }
}