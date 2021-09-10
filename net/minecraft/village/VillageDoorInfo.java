package net.minecraft.village;

import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class VillageDoorInfo {
   private boolean isDetachedFromVillageFlag;
   private int lastActivityTimestamp;
   private final EnumFacing insideDirection;
   private final BlockPos insideBlock;
   private int doorOpeningRestrictionCounter;
   private final BlockPos doorBlockPos;

   public BlockPos getDoorBlockPos() {
      return this.doorBlockPos;
   }

   public BlockPos getInsideBlockPos() {
      return this.insideBlock;
   }

   public VillageDoorInfo(BlockPos var1, int var2, int var3, int var4) {
      this(var1, getFaceDirection(var2, var3), var4);
   }

   public int getDistanceToDoorBlockSq(BlockPos var1) {
      return (int)var1.distanceSq(this.getDoorBlockPos());
   }

   public void incrementDoorOpeningRestrictionCounter() {
      ++this.doorOpeningRestrictionCounter;
   }

   public VillageDoorInfo(BlockPos var1, EnumFacing var2, int var3) {
      this.doorBlockPos = var1;
      this.insideDirection = var2;
      this.insideBlock = var1.offset(var2, 2);
      this.lastActivityTimestamp = var3;
   }

   public void resetDoorOpeningRestrictionCounter() {
      this.doorOpeningRestrictionCounter = 0;
   }

   public int getDistanceToInsideBlockSq(BlockPos var1) {
      return (int)this.insideBlock.distanceSq(var1);
   }

   private static EnumFacing getFaceDirection(int var0, int var1) {
      if (var0 < 0) {
         return EnumFacing.WEST;
      } else if (var0 > 0) {
         return EnumFacing.EAST;
      } else {
         return var1 < 0 ? EnumFacing.NORTH : EnumFacing.SOUTH;
      }
   }

   public int getDistanceSquared(int var1, int var2, int var3) {
      return (int)this.doorBlockPos.distanceSq((double)var1, (double)var2, (double)var3);
   }

   public int getInsideOffsetZ() {
      return this.insideDirection.getFrontOffsetZ() * 2;
   }

   public int getInsideOffsetX() {
      return this.insideDirection.getFrontOffsetX() * 2;
   }

   public boolean func_179850_c(BlockPos var1) {
      int var2 = var1.getX() - this.doorBlockPos.getX();
      int var3 = var1.getZ() - this.doorBlockPos.getY();
      return var2 * this.insideDirection.getFrontOffsetX() + var3 * this.insideDirection.getFrontOffsetZ() >= 0;
   }

   public boolean getIsDetachedFromVillageFlag() {
      return this.isDetachedFromVillageFlag;
   }

   public void func_179849_a(int var1) {
      this.lastActivityTimestamp = var1;
   }

   public int getDoorOpeningRestrictionCounter() {
      return this.doorOpeningRestrictionCounter;
   }

   public void setIsDetachedFromVillageFlag(boolean var1) {
      this.isDetachedFromVillageFlag = var1;
   }

   public int getInsidePosY() {
      return this.lastActivityTimestamp;
   }
}
