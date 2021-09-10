package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.village.Village;
import net.minecraft.village.VillageDoorInfo;

public class EntityAIRestrictOpenDoor extends EntityAIBase {
   private EntityCreature entityObj;
   private VillageDoorInfo frontDoor;

   public boolean shouldExecute() {
      if (this.entityObj.worldObj.isDaytime()) {
         return false;
      } else {
         BlockPos var1 = new BlockPos(this.entityObj);
         Village var2 = this.entityObj.worldObj.getVillageCollection().getNearestVillage(var1, 16);
         if (var2 == null) {
            return false;
         } else {
            this.frontDoor = var2.getNearestDoor(var1);
            if (this.frontDoor == null) {
               return false;
            } else {
               return (double)this.frontDoor.getDistanceToInsideBlockSq(var1) < 2.25D;
            }
         }
      }
   }

   public void resetTask() {
      ((PathNavigateGround)this.entityObj.getNavigator()).setBreakDoors(true);
      ((PathNavigateGround)this.entityObj.getNavigator()).setEnterDoors(true);
      this.frontDoor = null;
   }

   public boolean continueExecuting() {
      if (this.entityObj.worldObj.isDaytime()) {
         return false;
      } else {
         return !this.frontDoor.getIsDetachedFromVillageFlag() && this.frontDoor.func_179850_c(new BlockPos(this.entityObj));
      }
   }

   public EntityAIRestrictOpenDoor(EntityCreature var1) {
      this.entityObj = var1;
      if (!(var1.getNavigator() instanceof PathNavigateGround)) {
         throw new IllegalArgumentException("Unsupported mob type for RestrictOpenDoorGoal");
      }
   }

   public void startExecuting() {
      ((PathNavigateGround)this.entityObj.getNavigator()).setBreakDoors(false);
      ((PathNavigateGround)this.entityObj.getNavigator()).setEnterDoors(false);
   }

   public void updateTask() {
      this.frontDoor.incrementDoorOpeningRestrictionCounter();
   }
}
