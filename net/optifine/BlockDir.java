package net.optifine;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public enum BlockDir {
   NORTH_WEST(EnumFacing.NORTH, EnumFacing.WEST),
   SOUTH_EAST(EnumFacing.SOUTH, EnumFacing.EAST),
   DOWN_SOUTH(EnumFacing.DOWN, EnumFacing.SOUTH);

   private EnumFacing facing1;
   UP_SOUTH(EnumFacing.UP, EnumFacing.SOUTH),
   EAST(EnumFacing.EAST),
   NORTH_EAST(EnumFacing.NORTH, EnumFacing.EAST),
   UP_EAST(EnumFacing.UP, EnumFacing.EAST),
   DOWN_WEST(EnumFacing.DOWN, EnumFacing.WEST),
   DOWN_EAST(EnumFacing.DOWN, EnumFacing.EAST),
   NORTH(EnumFacing.NORTH),
   DOWN(EnumFacing.DOWN),
   UP_WEST(EnumFacing.UP, EnumFacing.WEST),
   SOUTH(EnumFacing.SOUTH),
   UP_NORTH(EnumFacing.UP, EnumFacing.NORTH),
   UP(EnumFacing.UP);

   private EnumFacing facing2;
   SOUTH_WEST(EnumFacing.SOUTH, EnumFacing.WEST);

   private static final BlockDir[] ENUM$VALUES = new BlockDir[]{DOWN, UP, NORTH, SOUTH, WEST, EAST, NORTH_WEST, NORTH_EAST, SOUTH_WEST, SOUTH_EAST, DOWN_NORTH, DOWN_SOUTH, UP_NORTH, UP_SOUTH, DOWN_WEST, DOWN_EAST, UP_WEST, UP_EAST};
   WEST(EnumFacing.WEST),
   DOWN_NORTH(EnumFacing.DOWN, EnumFacing.NORTH);

   public int getOffsetY() {
      int var1 = this.facing1.getFrontOffsetY();
      if (this.facing2 != null) {
         var1 += this.facing2.getFrontOffsetY();
      }

      return var1;
   }

   BlockPos offset(BlockPos var1) {
      var1 = var1.offset(this.facing1, 1);
      if (this.facing2 != null) {
         var1 = var1.offset(this.facing2, 1);
      }

      return var1;
   }

   private BlockDir(EnumFacing var3) {
      this.facing1 = var3;
   }

   public boolean isDouble() {
      return this.facing2 != null;
   }

   public int getOffsetZ() {
      int var1 = this.facing1.getFrontOffsetZ();
      if (this.facing2 != null) {
         var1 += this.facing2.getFrontOffsetZ();
      }

      return var1;
   }

   private BlockDir(EnumFacing var3, EnumFacing var4) {
      this.facing1 = var3;
      this.facing2 = var4;
   }

   public EnumFacing getFacing1() {
      return this.facing1;
   }

   public int getOffsetX() {
      int var1 = this.facing1.getFrontOffsetX();
      if (this.facing2 != null) {
         var1 += this.facing2.getFrontOffsetX();
      }

      return var1;
   }

   public EnumFacing getFacing2() {
      return this.facing2;
   }
}
