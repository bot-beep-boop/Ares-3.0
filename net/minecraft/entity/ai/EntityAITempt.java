package net.minecraft.entity.ai;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;

public class EntityAITempt extends EntityAIBase {
   private double yaw;
   private double targetY;
   private double pitch;
   private double targetZ;
   private double targetX;
   private boolean scaredByPlayerMovement;
   private boolean isRunning;
   private double speed;
   private EntityCreature temptedEntity;
   private int delayTemptCounter;
   private EntityPlayer temptingPlayer;
   private boolean avoidWater;
   private Item temptItem;

   public void resetTask() {
      this.temptingPlayer = null;
      this.temptedEntity.getNavigator().clearPathEntity();
      this.delayTemptCounter = 100;
      this.isRunning = false;
      ((PathNavigateGround)this.temptedEntity.getNavigator()).setAvoidsWater(this.avoidWater);
   }

   public void startExecuting() {
      this.targetX = this.temptingPlayer.posX;
      this.targetY = this.temptingPlayer.posY;
      this.targetZ = this.temptingPlayer.posZ;
      this.isRunning = true;
      this.avoidWater = ((PathNavigateGround)this.temptedEntity.getNavigator()).getAvoidsWater();
      ((PathNavigateGround)this.temptedEntity.getNavigator()).setAvoidsWater(false);
   }

   public boolean continueExecuting() {
      if (this.scaredByPlayerMovement) {
         if (this.temptedEntity.getDistanceSqToEntity(this.temptingPlayer) < 36.0D) {
            if (this.temptingPlayer.getDistanceSq(this.targetX, this.targetY, this.targetZ) > 0.010000000000000002D) {
               return false;
            }

            if (Math.abs((double)this.temptingPlayer.rotationPitch - this.pitch) > 5.0D || Math.abs((double)this.temptingPlayer.rotationYaw - this.yaw) > 5.0D) {
               return false;
            }
         } else {
            this.targetX = this.temptingPlayer.posX;
            this.targetY = this.temptingPlayer.posY;
            this.targetZ = this.temptingPlayer.posZ;
         }

         this.pitch = (double)this.temptingPlayer.rotationPitch;
         this.yaw = (double)this.temptingPlayer.rotationYaw;
      }

      return this.shouldExecute();
   }

   public void updateTask() {
      this.temptedEntity.getLookHelper().setLookPositionWithEntity(this.temptingPlayer, 30.0F, (float)this.temptedEntity.getVerticalFaceSpeed());
      if (this.temptedEntity.getDistanceSqToEntity(this.temptingPlayer) < 6.25D) {
         this.temptedEntity.getNavigator().clearPathEntity();
      } else {
         this.temptedEntity.getNavigator().tryMoveToEntityLiving(this.temptingPlayer, this.speed);
      }

   }

   public boolean isRunning() {
      return this.isRunning;
   }

   public EntityAITempt(EntityCreature var1, double var2, Item var4, boolean var5) {
      this.temptedEntity = var1;
      this.speed = var2;
      this.temptItem = var4;
      this.scaredByPlayerMovement = var5;
      this.setMutexBits(3);
      if (!(var1.getNavigator() instanceof PathNavigateGround)) {
         throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
      }
   }

   public boolean shouldExecute() {
      if (this.delayTemptCounter > 0) {
         --this.delayTemptCounter;
         return false;
      } else {
         this.temptingPlayer = this.temptedEntity.worldObj.getClosestPlayerToEntity(this.temptedEntity, 10.0D);
         if (this.temptingPlayer == null) {
            return false;
         } else {
            ItemStack var1 = this.temptingPlayer.getCurrentEquippedItem();
            if (var1 == null) {
               return false;
            } else {
               return var1.getItem() == this.temptItem;
            }
         }
      }
   }
}
