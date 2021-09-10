package net.minecraft.block.state;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class BlockPistonStructureHelper {
   private final List<BlockPos> toDestroy = Lists.newArrayList();
   private final World world;
   private final EnumFacing moveDirection;
   private final BlockPos blockToMove;
   private final List<BlockPos> toMove = Lists.newArrayList();
   private final BlockPos pistonPos;

   public List<BlockPos> getBlocksToDestroy() {
      return this.toDestroy;
   }

   public BlockPistonStructureHelper(World var1, BlockPos var2, EnumFacing var3, boolean var4) {
      this.world = var1;
      this.pistonPos = var2;
      if (var4) {
         this.moveDirection = var3;
         this.blockToMove = var2.offset(var3);
      } else {
         this.moveDirection = var3.getOpposite();
         this.blockToMove = var2.offset(var3, 2);
      }

   }

   public List<BlockPos> getBlocksToMove() {
      return this.toMove;
   }

   private boolean func_177251_a(BlockPos var1) {
      Block var2 = this.world.getBlockState(var1).getBlock();
      if (var2.getMaterial() == Material.air) {
         return true;
      } else if (!BlockPistonBase.canPush(var2, this.world, var1, this.moveDirection, false)) {
         return true;
      } else if (var1.equals(this.pistonPos)) {
         return true;
      } else if (this.toMove.contains(var1)) {
         return true;
      } else {
         int var3 = 1;
         if (var3 + this.toMove.size() > 12) {
            return false;
         } else {
            while(var2 == Blocks.slime_block) {
               BlockPos var4 = var1.offset(this.moveDirection.getOpposite(), var3);
               var2 = this.world.getBlockState(var4).getBlock();
               if (var2.getMaterial() == Material.air || !BlockPistonBase.canPush(var2, this.world, var4, this.moveDirection, false) || var4.equals(this.pistonPos)) {
                  break;
               }

               ++var3;
               if (var3 + this.toMove.size() > 12) {
                  return false;
               }
            }

            int var10 = 0;

            int var5;
            for(var5 = var3 - 1; var5 >= 0; --var5) {
               this.toMove.add(var1.offset(this.moveDirection.getOpposite(), var5));
               ++var10;
            }

            var5 = 1;

            while(true) {
               BlockPos var6 = var1.offset(this.moveDirection, var5);
               int var7 = this.toMove.indexOf(var6);
               if (var7 > -1) {
                  this.func_177255_a(var10, var7);

                  for(int var8 = 0; var8 <= var7 + var10; ++var8) {
                     BlockPos var9 = (BlockPos)this.toMove.get(var8);
                     if (this.world.getBlockState(var9).getBlock() == Blocks.slime_block && !this.func_177250_b(var9)) {
                        return false;
                     }
                  }

                  return true;
               }

               var2 = this.world.getBlockState(var6).getBlock();
               if (var2.getMaterial() == Material.air) {
                  return true;
               }

               if (!BlockPistonBase.canPush(var2, this.world, var6, this.moveDirection, true) || var6.equals(this.pistonPos)) {
                  return false;
               }

               if (var2.getMobilityFlag() == 1) {
                  this.toDestroy.add(var6);
                  return true;
               }

               if (this.toMove.size() >= 12) {
                  return false;
               }

               this.toMove.add(var6);
               ++var10;
               ++var5;
            }
         }
      }
   }

   private boolean func_177250_b(BlockPos var1) {
      EnumFacing[] var5;
      int var4 = (var5 = EnumFacing.values()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         EnumFacing var2 = var5[var3];
         if (var2.getAxis() != this.moveDirection.getAxis() && !this.func_177251_a(var1.offset(var2))) {
            return false;
         }
      }

      return true;
   }

   private void func_177255_a(int var1, int var2) {
      ArrayList var3 = Lists.newArrayList();
      ArrayList var4 = Lists.newArrayList();
      ArrayList var5 = Lists.newArrayList();
      var3.addAll(this.toMove.subList(0, var2));
      var4.addAll(this.toMove.subList(this.toMove.size() - var1, this.toMove.size()));
      var5.addAll(this.toMove.subList(var2, this.toMove.size() - var1));
      this.toMove.clear();
      this.toMove.addAll(var3);
      this.toMove.addAll(var4);
      this.toMove.addAll(var5);
   }

   public boolean canMove() {
      this.toMove.clear();
      this.toDestroy.clear();
      Block var1 = this.world.getBlockState(this.blockToMove).getBlock();
      if (!BlockPistonBase.canPush(var1, this.world, this.blockToMove, this.moveDirection, false)) {
         if (var1.getMobilityFlag() != 1) {
            return false;
         } else {
            this.toDestroy.add(this.blockToMove);
            return true;
         }
      } else if (!this.func_177251_a(this.blockToMove)) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.toMove.size(); ++var2) {
            BlockPos var3 = (BlockPos)this.toMove.get(var2);
            if (this.world.getBlockState(var3).getBlock() == Blocks.slime_block && !this.func_177250_b(var3)) {
               return false;
            }
         }

         return true;
      }
   }
}
