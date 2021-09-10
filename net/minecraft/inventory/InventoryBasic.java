package net.minecraft.inventory;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public class InventoryBasic implements IInventory {
   private String inventoryTitle;
   private ItemStack[] inventoryContents;
   private boolean hasCustomName;
   private int slotsCount;
   private List<IInvBasic> changeListeners;

   public void closeInventory(EntityPlayer var1) {
   }

   public boolean isItemValidForSlot(int var1, ItemStack var2) {
      return true;
   }

   public void setField(int var1, int var2) {
   }

   public String getName() {
      return this.inventoryTitle;
   }

   public boolean hasCustomName() {
      return this.hasCustomName;
   }

   public int getInventoryStackLimit() {
      return 64;
   }

   public boolean isUseableByPlayer(EntityPlayer var1) {
      return true;
   }

   public void setCustomName(String var1) {
      this.hasCustomName = true;
      this.inventoryTitle = var1;
   }

   public void setInventorySlotContents(int var1, ItemStack var2) {
      this.inventoryContents[var1] = var2;
      if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
         var2.stackSize = this.getInventoryStackLimit();
      }

      this.markDirty();
   }

   public void addInventoryChangeListener(IInvBasic var1) {
      if (this.changeListeners == null) {
         this.changeListeners = Lists.newArrayList();
      }

      this.changeListeners.add(var1);
   }

   public InventoryBasic(IChatComponent var1, int var2) {
      this(var1.getUnformattedText(), true, var2);
   }

   public ItemStack func_174894_a(ItemStack var1) {
      ItemStack var2 = var1.copy();

      for(int var3 = 0; var3 < this.slotsCount; ++var3) {
         ItemStack var4 = this.getStackInSlot(var3);
         if (var4 == null) {
            this.setInventorySlotContents(var3, var2);
            this.markDirty();
            return null;
         }

         if (ItemStack.areItemsEqual(var4, var2)) {
            int var5 = Math.min(this.getInventoryStackLimit(), var4.getMaxStackSize());
            int var6 = Math.min(var2.stackSize, var5 - var4.stackSize);
            if (var6 > 0) {
               var4.stackSize += var6;
               var2.stackSize -= var6;
               if (var2.stackSize <= 0) {
                  this.markDirty();
                  return null;
               }
            }
         }
      }

      if (var2.stackSize != var1.stackSize) {
         this.markDirty();
      }

      return var2;
   }

   public void markDirty() {
      if (this.changeListeners != null) {
         for(int var1 = 0; var1 < this.changeListeners.size(); ++var1) {
            ((IInvBasic)this.changeListeners.get(var1)).onInventoryChanged(this);
         }
      }

   }

   public int getSizeInventory() {
      return this.slotsCount;
   }

   public ItemStack removeStackFromSlot(int var1) {
      if (this.inventoryContents[var1] != null) {
         ItemStack var2 = this.inventoryContents[var1];
         this.inventoryContents[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public int getFieldCount() {
      return 0;
   }

   public void openInventory(EntityPlayer var1) {
   }

   public ItemStack decrStackSize(int var1, int var2) {
      if (this.inventoryContents[var1] != null) {
         ItemStack var3;
         if (this.inventoryContents[var1].stackSize <= var2) {
            var3 = this.inventoryContents[var1];
            this.inventoryContents[var1] = null;
            this.markDirty();
            return var3;
         } else {
            var3 = this.inventoryContents[var1].splitStack(var2);
            if (this.inventoryContents[var1].stackSize == 0) {
               this.inventoryContents[var1] = null;
            }

            this.markDirty();
            return var3;
         }
      } else {
         return null;
      }
   }

   public ItemStack getStackInSlot(int var1) {
      return var1 >= 0 && var1 < this.inventoryContents.length ? this.inventoryContents[var1] : null;
   }

   public void removeInventoryChangeListener(IInvBasic var1) {
      this.changeListeners.remove(var1);
   }

   public void clear() {
      for(int var1 = 0; var1 < this.inventoryContents.length; ++var1) {
         this.inventoryContents[var1] = null;
      }

   }

   public InventoryBasic(String var1, boolean var2, int var3) {
      this.inventoryTitle = var1;
      this.hasCustomName = var2;
      this.slotsCount = var3;
      this.inventoryContents = new ItemStack[var3];
   }

   public int getField(int var1) {
      return 0;
   }

   public IChatComponent getDisplayName() {
      return (IChatComponent)(this.hasCustomName() ? new ChatComponentText(this.getName()) : new ChatComponentTranslation(this.getName(), new Object[0]));
   }
}
