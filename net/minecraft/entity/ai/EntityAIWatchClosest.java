package net.minecraft.entity.ai;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;

public class EntityAIWatchClosest extends EntityAIBase {
   protected EntityLiving theWatcher;
   private int lookTime;
   protected float maxDistanceForPlayer;
   private float chance;
   protected Class<? extends Entity> watchedClass;
   protected Entity closestEntity;

   public void startExecuting() {
      this.lookTime = 40 + this.theWatcher.getRNG().nextInt(40);
   }

   public boolean continueExecuting() {
      if (!this.closestEntity.isEntityAlive()) {
         return false;
      } else if (this.theWatcher.getDistanceSqToEntity(this.closestEntity) > (double)(this.maxDistanceForPlayer * this.maxDistanceForPlayer)) {
         return false;
      } else {
         return this.lookTime > 0;
      }
   }

   public EntityAIWatchClosest(EntityLiving var1, Class<? extends Entity> var2, float var3) {
      this.theWatcher = var1;
      this.watchedClass = var2;
      this.maxDistanceForPlayer = var3;
      this.chance = 0.02F;
      this.setMutexBits(2);
   }

   public EntityAIWatchClosest(EntityLiving var1, Class<? extends Entity> var2, float var3, float var4) {
      this.theWatcher = var1;
      this.watchedClass = var2;
      this.maxDistanceForPlayer = var3;
      this.chance = var4;
      this.setMutexBits(2);
   }

   public void updateTask() {
      this.theWatcher.getLookHelper().setLookPosition(this.closestEntity.posX, this.closestEntity.posY + (double)this.closestEntity.getEyeHeight(), this.closestEntity.posZ, 10.0F, (float)this.theWatcher.getVerticalFaceSpeed());
      --this.lookTime;
   }

   public void resetTask() {
      this.closestEntity = null;
   }

   public boolean shouldExecute() {
      if (this.theWatcher.getRNG().nextFloat() >= this.chance) {
         return false;
      } else {
         if (this.theWatcher.getAttackTarget() != null) {
            this.closestEntity = this.theWatcher.getAttackTarget();
         }

         if (this.watchedClass == EntityPlayer.class) {
            this.closestEntity = this.theWatcher.worldObj.getClosestPlayerToEntity(this.theWatcher, (double)this.maxDistanceForPlayer);
         } else {
            this.closestEntity = this.theWatcher.worldObj.findNearestEntityWithinAABB(this.watchedClass, this.theWatcher.getEntityBoundingBox().expand((double)this.maxDistanceForPlayer, 3.0D, (double)this.maxDistanceForPlayer), this.theWatcher);
         }

         return this.closestEntity != null;
      }
   }
}
