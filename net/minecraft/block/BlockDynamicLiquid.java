package net.minecraft.block;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockDynamicLiquid extends BlockLiquid {
   int adjacentSourceBlocks;

   protected int checkAdjacentBlock(World var1, BlockPos var2, int var3) {
      int var4 = this.getLevel(var1, var2);
      if (var4 < 0) {
         return var3;
      } else {
         if (var4 == 0) {
            ++this.adjacentSourceBlocks;
         }

         if (var4 >= 8) {
            var4 = 0;
         }

         return var3 >= 0 && var4 >= var3 ? var3 : var4;
      }
   }

   private Set<EnumFacing> getPossibleFlowDirections(World var1, BlockPos var2) {
      int var3 = 1000;
      EnumSet var4 = EnumSet.noneOf(EnumFacing.class);
      Iterator var6 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(true) {
         EnumFacing var5;
         BlockPos var7;
         IBlockState var8;
         do {
            do {
               if (!var6.hasNext()) {
                  return var4;
               }

               var5 = (EnumFacing)var6.next();
               var7 = var2.offset(var5);
               var8 = var1.getBlockState(var7);
            } while(this.isBlocked(var1, var7, var8));
         } while(var8.getBlock().getMaterial() == this.blockMaterial && (Integer)var8.getValue(LEVEL) <= 0);

         int var9;
         if (this.isBlocked(var1, var7.down(), var1.getBlockState(var7.down()))) {
            var9 = this.func_176374_a(var1, var7, 1, var5.getOpposite());
         } else {
            var9 = 0;
         }

         if (var9 < var3) {
            var4.clear();
         }

         if (var9 <= var3) {
            var4.add(var5);
            var3 = var9;
         }
      }
   }

   protected BlockDynamicLiquid(Material var1) {
      super(var1);
   }

   private int func_176374_a(World var1, BlockPos var2, int var3, EnumFacing var4) {
      int var5 = 1000;
      Iterator var7 = EnumFacing.Plane.HORIZONTAL.iterator();

      while(true) {
         EnumFacing var6;
         BlockPos var8;
         IBlockState var9;
         do {
            do {
               do {
                  if (!var7.hasNext()) {
                     return var5;
                  }

                  var6 = (EnumFacing)var7.next();
               } while(var6 == var4);

               var8 = var2.offset(var6);
               var9 = var1.getBlockState(var8);
            } while(this.isBlocked(var1, var8, var9));
         } while(var9.getBlock().getMaterial() == this.blockMaterial && (Integer)var9.getValue(LEVEL) <= 0);

         if (!this.isBlocked(var1, var8.down(), var9)) {
            return var3;
         }

         if (var3 < 4) {
            int var10 = this.func_176374_a(var1, var8, var3 + 1, var6.getOpposite());
            if (var10 < var5) {
               var5 = var10;
            }
         }
      }
   }

   private boolean canFlowInto(World var1, BlockPos var2, IBlockState var3) {
      Material var4 = var3.getBlock().getMaterial();
      return var4 != this.blockMaterial && var4 != Material.lava && !this.isBlocked(var1, var2, var3);
   }

   private boolean isBlocked(World var1, BlockPos var2, IBlockState var3) {
      Block var4 = var1.getBlockState(var2).getBlock();
      if (!(var4 instanceof BlockDoor) && var4 != Blocks.standing_sign && var4 != Blocks.ladder && var4 != Blocks.reeds) {
         return var4.blockMaterial == Material.portal ? true : var4.blockMaterial.blocksMovement();
      } else {
         return true;
      }
   }

   private void tryFlowInto(World var1, BlockPos var2, IBlockState var3, int var4) {
      if (this.canFlowInto(var1, var2, var3)) {
         if (var3.getBlock() != Blocks.air) {
            if (this.blockMaterial == Material.lava) {
               this.triggerMixEffects(var1, var2);
            } else {
               var3.getBlock().dropBlockAsItem(var1, var2, var3, 0);
            }
         }

         var1.setBlockState(var2, this.getDefaultState().withProperty(LEVEL, var4), 3);
      }

   }

   private void placeStaticBlock(World var1, BlockPos var2, IBlockState var3) {
      var1.setBlockState(var2, getStaticBlock(this.blockMaterial).getDefaultState().withProperty(LEVEL, (Integer)var3.getValue(LEVEL)), 2);
   }

   public void onBlockAdded(World var1, BlockPos var2, IBlockState var3) {
      if (!this.checkForMixing(var1, var2, var3)) {
         var1.scheduleUpdate(var2, this, this.tickRate(var1));
      }

   }

   public void updateTick(World var1, BlockPos var2, IBlockState var3, Random var4) {
      int var5 = (Integer)var3.getValue(LEVEL);
      byte var6 = 1;
      if (this.blockMaterial == Material.lava && !var1.provider.doesWaterVaporize()) {
         var6 = 2;
      }

      int var7 = this.tickRate(var1);
      int var15;
      if (var5 > 0) {
         int var8 = -100;
         this.adjacentSourceBlocks = 0;

         EnumFacing var9;
         for(Iterator var10 = EnumFacing.Plane.HORIZONTAL.iterator(); var10.hasNext(); var8 = this.checkAdjacentBlock(var1, var2.offset(var9), var8)) {
            var9 = (EnumFacing)var10.next();
         }

         int var14 = var8 + var6;
         if (var14 >= 8 || var8 < 0) {
            var14 = -1;
         }

         if (this.getLevel(var1, var2.up()) >= 0) {
            var15 = this.getLevel(var1, var2.up());
            if (var15 >= 8) {
               var14 = var15;
            } else {
               var14 = var15 + 8;
            }
         }

         if (this.adjacentSourceBlocks >= 2 && this.blockMaterial == Material.water) {
            IBlockState var16 = var1.getBlockState(var2.down());
            if (var16.getBlock().getMaterial().isSolid()) {
               var14 = 0;
            } else if (var16.getBlock().getMaterial() == this.blockMaterial && (Integer)var16.getValue(LEVEL) == 0) {
               var14 = 0;
            }
         }

         if (this.blockMaterial == Material.lava && var5 < 8 && var14 < 8 && var14 > var5 && var4.nextInt(4) != 0) {
            var7 *= 4;
         }

         if (var14 == var5) {
            this.placeStaticBlock(var1, var2, var3);
         } else {
            var5 = var14;
            if (var14 < 0) {
               var1.setBlockToAir(var2);
            } else {
               var3 = var3.withProperty(LEVEL, var14);
               var1.setBlockState(var2, var3, 2);
               var1.scheduleUpdate(var2, this, var7);
               var1.notifyNeighborsOfStateChange(var2, this);
            }
         }
      } else {
         this.placeStaticBlock(var1, var2, var3);
      }

      IBlockState var13 = var1.getBlockState(var2.down());
      if (this.canFlowInto(var1, var2.down(), var13)) {
         if (this.blockMaterial == Material.lava && var1.getBlockState(var2.down()).getBlock().getMaterial() == Material.water) {
            var1.setBlockState(var2.down(), Blocks.stone.getDefaultState());
            this.triggerMixEffects(var1, var2.down());
            return;
         }

         if (var5 >= 8) {
            this.tryFlowInto(var1, var2.down(), var13, var5);
         } else {
            this.tryFlowInto(var1, var2.down(), var13, var5 + 8);
         }
      } else if (var5 >= 0 && (var5 == 0 || this.isBlocked(var1, var2.down(), var13))) {
         Set var17 = this.getPossibleFlowDirections(var1, var2);
         var15 = var5 + var6;
         if (var5 >= 8) {
            var15 = 1;
         }

         if (var15 >= 8) {
            return;
         }

         Iterator var12 = var17.iterator();

         while(var12.hasNext()) {
            EnumFacing var11 = (EnumFacing)var12.next();
            this.tryFlowInto(var1, var2.offset(var11), var1.getBlockState(var2.offset(var11)), var15);
         }
      }

   }
}
