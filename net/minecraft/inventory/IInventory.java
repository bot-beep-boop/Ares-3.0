package net.minecraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IWorldNameable;

public interface IInventory extends IWorldNameable {
   boolean isUseableByPlayer(EntityPlayer var1);

   void clear();

   void markDirty();

   int getFieldCount();

   int getInventoryStackLimit();

   int getSizeInventory();

   void closeInventory(EntityPlayer var1);

   ItemStack decrStackSize(int var1, int var2);

   void setField(int var1, int var2);

   int getField(int var1);

   ItemStack removeStackFromSlot(int var1);

   boolean isItemValidForSlot(int var1, ItemStack var2);

   void openInventory(EntityPlayer var1);

   ItemStack getStackInSlot(int var1);

   void setInventorySlotContents(int var1, ItemStack var2);
}
