package net.minecraft.entity.ai;

import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import net.minecraft.entity.EntityCreature;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.village.Village;
import net.minecraft.village.VillageDoorInfo;

public class EntityAIMoveThroughVillage extends EntityAIBase {
   private double movementSpeed;
   private List<VillageDoorInfo> doorList = Lists.newArrayList();
   private boolean isNocturnal;
   private VillageDoorInfo doorInfo;
   private EntityCreature theEntity;
   private PathEntity entityPathNavigate;

   private void resizeDoorList() {
      if (this.doorList.size() > 15) {
         this.doorList.remove(0);
      }

   }

   private boolean doesDoorListContain(VillageDoorInfo var1) {
      Iterator var3 = this.doorList.iterator();

      while(var3.hasNext()) {
         VillageDoorInfo var2 = (VillageDoorInfo)var3.next();
         if (var1.getDoorBlockPos().equals(var2.getDoorBlockPos())) {
            return true;
         }
      }

      return false;
   }

   public boolean continueExecuting() {
      if (this.theEntity.getNavigator().noPath()) {
         return false;
      } else {
         float var1 = this.theEntity.width + 4.0F;
         return this.theEntity.getDistanceSq(this.doorInfo.getDoorBlockPos()) > (double)(var1 * var1);
      }
   }

   public boolean shouldExecute() {
      this.resizeDoorList();
      if (this.isNocturnal && this.theEntity.worldObj.isDaytime()) {
         return false;
      } else {
         Village var1 = this.theEntity.worldObj.getVillageCollection().getNearestVillage(new BlockPos(this.theEntity), 0);
         if (var1 == null) {
            return false;
         } else {
            this.doorInfo = this.findNearestDoor(var1);
            if (this.doorInfo == null) {
               return false;
            } else {
               PathNavigateGround var2 = (PathNavigateGround)this.theEntity.getNavigator();
               boolean var3 = var2.getEnterDoors();
               var2.setBreakDoors(false);
               this.entityPathNavigate = var2.getPathToPos(this.doorInfo.getDoorBlockPos());
               var2.setBreakDoors(var3);
               if (this.entityPathNavigate != null) {
                  return true;
               } else {
                  Vec3 var4 = RandomPositionGenerator.findRandomTargetBlockTowards(this.theEntity, 10, 7, new Vec3((double)this.doorInfo.getDoorBlockPos().getX(), (double)this.doorInfo.getDoorBlockPos().getY(), (double)this.doorInfo.getDoorBlockPos().getZ()));
                  if (var4 == null) {
                     return false;
                  } else {
                     var2.setBreakDoors(false);
                     this.entityPathNavigate = this.theEntity.getNavigator().getPathToXYZ(var4.xCoord, var4.yCoord, var4.zCoord);
                     var2.setBreakDoors(var3);
                     return this.entityPathNavigate != null;
                  }
               }
            }
         }
      }
   }

   private VillageDoorInfo findNearestDoor(Village var1) {
      VillageDoorInfo var2 = null;
      int var3 = Integer.MAX_VALUE;
      Iterator var5 = var1.getVillageDoorInfoList().iterator();

      while(var5.hasNext()) {
         VillageDoorInfo var4 = (VillageDoorInfo)var5.next();
         int var6 = var4.getDistanceSquared(MathHelper.floor_double(this.theEntity.posX), MathHelper.floor_double(this.theEntity.posY), MathHelper.floor_double(this.theEntity.posZ));
         if (var6 < var3 && !this.doesDoorListContain(var4)) {
            var2 = var4;
            var3 = var6;
         }
      }

      return var2;
   }

   public EntityAIMoveThroughVillage(EntityCreature var1, double var2, boolean var4) {
      this.theEntity = var1;
      this.movementSpeed = var2;
      this.isNocturnal = var4;
      this.setMutexBits(1);
      if (!(var1.getNavigator() instanceof PathNavigateGround)) {
         throw new IllegalArgumentException("Unsupported mob for MoveThroughVillageGoal");
      }
   }

   public void resetTask() {
      if (this.theEntity.getNavigator().noPath() || this.theEntity.getDistanceSq(this.doorInfo.getDoorBlockPos()) < 16.0D) {
         this.doorList.add(this.doorInfo);
      }

   }

   public void startExecuting() {
      this.theEntity.getNavigator().setPath(this.entityPathNavigate, this.movementSpeed);
   }
}
