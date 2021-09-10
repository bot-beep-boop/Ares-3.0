package net.minecraft.world;

import net.minecraft.inventory.IInventory;

public interface ILockableContainer extends IInventory, IInteractionObject {
   void setLockCode(LockCode var1);

   boolean isLocked();

   LockCode getLockCode();
}
