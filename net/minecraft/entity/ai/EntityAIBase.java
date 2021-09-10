package net.minecraft.entity.ai;

public abstract class EntityAIBase {
   private int mutexBits;

   public int getMutexBits() {
      return this.mutexBits;
   }

   public boolean isInterruptible() {
      return true;
   }

   public void setMutexBits(int var1) {
      this.mutexBits = var1;
   }

   public boolean continueExecuting() {
      return this.shouldExecute();
   }

   public void resetTask() {
   }

   public abstract boolean shouldExecute();

   public void startExecuting() {
   }

   public void updateTask() {
   }
}
