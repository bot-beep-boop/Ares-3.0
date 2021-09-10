package net.minecraft.inventory;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;

public abstract class Container {
   private short transactionID;
   private int dragMode = -1;
   protected List<ICrafting> crafters = Lists.newArrayList();
   public List<ItemStack> inventoryItemStacks = Lists.newArrayList();
   private final Set<Slot> dragSlots = Sets.newHashSet();
   private int dragEvent;
   public List<Slot> inventorySlots = Lists.newArrayList();
   private Set<EntityPlayer> playerList = Sets.newHashSet();
   public int windowId;

   public void detectAndSendChanges() {
      for(int var1 = 0; var1 < this.inventorySlots.size(); ++var1) {
         ItemStack var2 = ((Slot)this.inventorySlots.get(var1)).getStack();
         ItemStack var3 = (ItemStack)this.inventoryItemStacks.get(var1);
         if (!ItemStack.areItemStacksEqual(var3, var2)) {
            var3 = var2 == null ? null : var2.copy();
            this.inventoryItemStacks.set(var1, var3);

            for(int var4 = 0; var4 < this.crafters.size(); ++var4) {
               ((ICrafting)this.crafters.get(var4)).sendSlotContents(this, var1, var3);
            }
         }
      }

   }

   public Slot getSlot(int var1) {
      return (Slot)this.inventorySlots.get(var1);
   }

   public static int extractDragMode(int var0) {
      return var0 >> 2 & 3;
   }

   public abstract boolean canInteractWith(EntityPlayer var1);

   public static int func_94534_d(int var0, int var1) {
      return var0 & 3 | (var1 & 3) << 2;
   }

   protected boolean mergeItemStack(ItemStack var1, int var2, int var3, boolean var4) {
      boolean var5 = false;
      int var6 = var2;
      if (var4) {
         var6 = var3 - 1;
      }

      Slot var7;
      ItemStack var8;
      if (var1.isStackable()) {
         while(var1.stackSize > 0 && (!var4 && var6 < var3 || var4 && var6 >= var2)) {
            var7 = (Slot)this.inventorySlots.get(var6);
            var8 = var7.getStack();
            if (var8 != null && var8.getItem() == var1.getItem() && (!var1.getHasSubtypes() || var1.getMetadata() == var8.getMetadata()) && ItemStack.areItemStackTagsEqual(var1, var8)) {
               int var9 = var8.stackSize + var1.stackSize;
               if (var9 <= var1.getMaxStackSize()) {
                  var1.stackSize = 0;
                  var8.stackSize = var9;
                  var7.onSlotChanged();
                  var5 = true;
               } else if (var8.stackSize < var1.getMaxStackSize()) {
                  var1.stackSize -= var1.getMaxStackSize() - var8.stackSize;
                  var8.stackSize = var1.getMaxStackSize();
                  var7.onSlotChanged();
                  var5 = true;
               }
            }

            if (var4) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      if (var1.stackSize > 0) {
         if (var4) {
            var6 = var3 - 1;
         } else {
            var6 = var2;
         }

         while(!var4 && var6 < var3 || var4 && var6 >= var2) {
            var7 = (Slot)this.inventorySlots.get(var6);
            var8 = var7.getStack();
            if (var8 == null) {
               var7.putStack(var1.copy());
               var7.onSlotChanged();
               var1.stackSize = 0;
               var5 = true;
               break;
            }

            if (var4) {
               --var6;
            } else {
               ++var6;
            }
         }
      }

      return var5;
   }

   public ItemStack transferStackInSlot(EntityPlayer var1, int var2) {
      Slot var3 = (Slot)this.inventorySlots.get(var2);
      return var3 != null ? var3.getStack() : null;
   }

   public void onCraftGuiOpened(ICrafting var1) {
      if (this.crafters.contains(var1)) {
         throw new IllegalArgumentException("Listener already listening");
      } else {
         this.crafters.add(var1);
         var1.updateCraftingInventory(this, this.getInventory());
         this.detectAndSendChanges();
      }
   }

   public static int getDragEvent(int var0) {
      return var0 & 3;
   }

   public static boolean canAddItemToSlot(Slot var0, ItemStack var1, boolean var2) {
      boolean var3 = var0 == null || !var0.getHasStack();
      if (var0 != null && var0.getHasStack() && var1 != null && var1.isItemEqual(var0.getStack()) && ItemStack.areItemStackTagsEqual(var0.getStack(), var1)) {
         var3 |= var0.getStack().stackSize + (var2 ? 0 : var1.stackSize) <= var1.getMaxStackSize();
      }

      return var3;
   }

   public List<ItemStack> getInventory() {
      ArrayList var1 = Lists.newArrayList();

      for(int var2 = 0; var2 < this.inventorySlots.size(); ++var2) {
         var1.add(((Slot)this.inventorySlots.get(var2)).getStack());
      }

      return var1;
   }

   protected void resetDrag() {
      this.dragEvent = 0;
      this.dragSlots.clear();
   }

   public static int calcRedstone(TileEntity var0) {
      return var0 instanceof IInventory ? calcRedstoneFromInventory((IInventory)var0) : 0;
   }

   public void updateProgressBar(int var1, int var2) {
   }

   public boolean getCanCraft(EntityPlayer var1) {
      return !this.playerList.contains(var1);
   }

   public static boolean isValidDragMode(int var0, EntityPlayer var1) {
      if (var0 == 0) {
         return true;
      } else if (var0 == 1) {
         return true;
      } else {
         return var0 == 2 && var1.capabilities.isCreativeMode;
      }
   }

   public boolean enchantItem(EntityPlayer var1, int var2) {
      return false;
   }

   public static int calcRedstoneFromInventory(IInventory var0) {
      if (var0 == null) {
         return 0;
      } else {
         int var1 = 0;
         float var2 = 0.0F;

         for(int var3 = 0; var3 < var0.getSizeInventory(); ++var3) {
            ItemStack var4 = var0.getStackInSlot(var3);
            if (var4 != null) {
               var2 += (float)var4.stackSize / (float)Math.min(var0.getInventoryStackLimit(), var4.getMaxStackSize());
               ++var1;
            }
         }

         var2 /= (float)var0.getSizeInventory();
         return MathHelper.floor_float(var2 * 14.0F) + (var1 > 0 ? 1 : 0);
      }
   }

   public void onCraftMatrixChanged(IInventory var1) {
      this.detectAndSendChanges();
   }

   public Slot getSlotFromInventory(IInventory var1, int var2) {
      for(int var3 = 0; var3 < this.inventorySlots.size(); ++var3) {
         Slot var4 = (Slot)this.inventorySlots.get(var3);
         if (var4.isHere(var1, var2)) {
            return var4;
         }
      }

      return null;
   }

   protected void retrySlotClick(int var1, int var2, boolean var3, EntityPlayer var4) {
      this.slotClick(var1, var2, 1, var4);
   }

   public boolean canMergeSlot(ItemStack var1, Slot var2) {
      return true;
   }

   public void putStacksInSlots(ItemStack[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.getSlot(var2).putStack(var1[var2]);
      }

   }

   public static void computeStackSize(Set<Slot> var0, int var1, ItemStack var2, int var3) {
      switch(var1) {
      case 0:
         var2.stackSize = MathHelper.floor_float((float)var2.stackSize / (float)var0.size());
         break;
      case 1:
         var2.stackSize = 1;
         break;
      case 2:
         var2.stackSize = var2.getItem().getItemStackLimit();
      }

      var2.stackSize += var3;
   }

   public void setCanCraft(EntityPlayer var1, boolean var2) {
      if (var2) {
         this.playerList.remove(var1);
      } else {
         this.playerList.add(var1);
      }

   }

   public void onContainerClosed(EntityPlayer var1) {
      InventoryPlayer var2 = var1.inventory;
      if (var2.getItemStack() != null) {
         var1.dropPlayerItemWithRandomChoice(var2.getItemStack(), false);
         var2.setItemStack((ItemStack)null);
      }

   }

   public void putStackInSlot(int var1, ItemStack var2) {
      this.getSlot(var1).putStack(var2);
   }

   public boolean canDragIntoSlot(Slot var1) {
      return true;
   }

   public short getNextTransactionID(InventoryPlayer var1) {
      ++this.transactionID;
      return this.transactionID;
   }

   protected Slot addSlotToContainer(Slot var1) {
      var1.slotNumber = this.inventorySlots.size();
      this.inventorySlots.add(var1);
      this.inventoryItemStacks.add((Object)null);
      return var1;
   }

   public ItemStack slotClick(int var1, int var2, int var3, EntityPlayer var4) {
      ItemStack var5 = null;
      InventoryPlayer var6 = var4.inventory;
      int var9;
      ItemStack var17;
      if (var3 == 5) {
         int var7 = this.dragEvent;
         this.dragEvent = getDragEvent(var2);
         if ((var7 != 1 || this.dragEvent != 2) && var7 != this.dragEvent) {
            this.resetDrag();
         } else if (var6.getItemStack() == null) {
            this.resetDrag();
         } else if (this.dragEvent == 0) {
            this.dragMode = extractDragMode(var2);
            if (isValidDragMode(this.dragMode, var4)) {
               this.dragEvent = 1;
               this.dragSlots.clear();
            } else {
               this.resetDrag();
            }
         } else if (this.dragEvent == 1) {
            Slot var8 = (Slot)this.inventorySlots.get(var1);
            if (var8 != null && canAddItemToSlot(var8, var6.getItemStack(), true) && var8.isItemValid(var6.getItemStack()) && var6.getItemStack().stackSize > this.dragSlots.size() && this.canDragIntoSlot(var8)) {
               this.dragSlots.add(var8);
            }
         } else if (this.dragEvent == 2) {
            if (!this.dragSlots.isEmpty()) {
               var17 = var6.getItemStack().copy();
               var9 = var6.getItemStack().stackSize;
               Iterator var11 = this.dragSlots.iterator();

               while(var11.hasNext()) {
                  Slot var10 = (Slot)var11.next();
                  if (var10 != null && canAddItemToSlot(var10, var6.getItemStack(), true) && var10.isItemValid(var6.getItemStack()) && var6.getItemStack().stackSize >= this.dragSlots.size() && this.canDragIntoSlot(var10)) {
                     ItemStack var12 = var17.copy();
                     int var13 = var10.getHasStack() ? var10.getStack().stackSize : 0;
                     computeStackSize(this.dragSlots, this.dragMode, var12, var13);
                     if (var12.stackSize > var12.getMaxStackSize()) {
                        var12.stackSize = var12.getMaxStackSize();
                     }

                     if (var12.stackSize > var10.getItemStackLimit(var12)) {
                        var12.stackSize = var10.getItemStackLimit(var12);
                     }

                     var9 -= var12.stackSize - var13;
                     var10.putStack(var12);
                  }
               }

               var17.stackSize = var9;
               if (var17.stackSize <= 0) {
                  var17 = null;
               }

               var6.setItemStack(var17);
            }

            this.resetDrag();
         } else {
            this.resetDrag();
         }
      } else if (this.dragEvent != 0) {
         this.resetDrag();
      } else {
         Slot var16;
         int var19;
         ItemStack var23;
         if ((var3 == 0 || var3 == 1) && (var2 == 0 || var2 == 1)) {
            if (var1 == -999) {
               if (var6.getItemStack() != null) {
                  if (var2 == 0) {
                     var4.dropPlayerItemWithRandomChoice(var6.getItemStack(), true);
                     var6.setItemStack((ItemStack)null);
                  }

                  if (var2 == 1) {
                     var4.dropPlayerItemWithRandomChoice(var6.getItemStack().splitStack(1), true);
                     if (var6.getItemStack().stackSize == 0) {
                        var6.setItemStack((ItemStack)null);
                     }
                  }
               }
            } else if (var3 == 1) {
               if (var1 < 0) {
                  return null;
               }

               var16 = (Slot)this.inventorySlots.get(var1);
               if (var16 != null && var16.canTakeStack(var4)) {
                  var17 = this.transferStackInSlot(var4, var1);
                  if (var17 != null) {
                     Item var20 = var17.getItem();
                     var5 = var17.copy();
                     if (var16.getStack() != null && var16.getStack().getItem() == var20) {
                        this.retrySlotClick(var1, var2, true, var4);
                     }
                  }
               }
            } else {
               if (var1 < 0) {
                  return null;
               }

               var16 = (Slot)this.inventorySlots.get(var1);
               if (var16 != null) {
                  var17 = var16.getStack();
                  ItemStack var21 = var6.getItemStack();
                  if (var17 != null) {
                     var5 = var17.copy();
                  }

                  if (var17 == null) {
                     if (var21 != null && var16.isItemValid(var21)) {
                        var19 = var2 == 0 ? var21.stackSize : 1;
                        if (var19 > var16.getItemStackLimit(var21)) {
                           var19 = var16.getItemStackLimit(var21);
                        }

                        if (var21.stackSize >= var19) {
                           var16.putStack(var21.splitStack(var19));
                        }

                        if (var21.stackSize == 0) {
                           var6.setItemStack((ItemStack)null);
                        }
                     }
                  } else if (var16.canTakeStack(var4)) {
                     if (var21 == null) {
                        var19 = var2 == 0 ? var17.stackSize : (var17.stackSize + 1) / 2;
                        var23 = var16.decrStackSize(var19);
                        var6.setItemStack(var23);
                        if (var17.stackSize == 0) {
                           var16.putStack((ItemStack)null);
                        }

                        var16.onPickupFromSlot(var4, var6.getItemStack());
                     } else if (var16.isItemValid(var21)) {
                        if (var17.getItem() == var21.getItem() && var17.getMetadata() == var21.getMetadata() && ItemStack.areItemStackTagsEqual(var17, var21)) {
                           var19 = var2 == 0 ? var21.stackSize : 1;
                           if (var19 > var16.getItemStackLimit(var21) - var17.stackSize) {
                              var19 = var16.getItemStackLimit(var21) - var17.stackSize;
                           }

                           if (var19 > var21.getMaxStackSize() - var17.stackSize) {
                              var19 = var21.getMaxStackSize() - var17.stackSize;
                           }

                           var21.splitStack(var19);
                           if (var21.stackSize == 0) {
                              var6.setItemStack((ItemStack)null);
                           }

                           var17.stackSize += var19;
                        } else if (var21.stackSize <= var16.getItemStackLimit(var21)) {
                           var16.putStack(var21);
                           var6.setItemStack(var17);
                        }
                     } else if (var17.getItem() == var21.getItem() && var21.getMaxStackSize() > 1 && (!var17.getHasSubtypes() || var17.getMetadata() == var21.getMetadata()) && ItemStack.areItemStackTagsEqual(var17, var21)) {
                        var19 = var17.stackSize;
                        if (var19 > 0 && var19 + var21.stackSize <= var21.getMaxStackSize()) {
                           var21.stackSize += var19;
                           var17 = var16.decrStackSize(var19);
                           if (var17.stackSize == 0) {
                              var16.putStack((ItemStack)null);
                           }

                           var16.onPickupFromSlot(var4, var6.getItemStack());
                        }
                     }
                  }

                  var16.onSlotChanged();
               }
            }
         } else if (var3 == 2 && var2 >= 0 && var2 < 9) {
            var16 = (Slot)this.inventorySlots.get(var1);
            if (var16.canTakeStack(var4)) {
               var17 = var6.getStackInSlot(var2);
               boolean var18 = var17 == null || var16.inventory == var6 && var16.isItemValid(var17);
               var19 = -1;
               if (!var18) {
                  var19 = var6.getFirstEmptyStack();
                  var18 |= var19 > -1;
               }

               if (var16.getHasStack() && var18) {
                  var23 = var16.getStack();
                  var6.setInventorySlotContents(var2, var23.copy());
                  if ((var16.inventory != var6 || !var16.isItemValid(var17)) && var17 != null) {
                     if (var19 > -1) {
                        var6.addItemStackToInventory(var17);
                        var16.decrStackSize(var23.stackSize);
                        var16.putStack((ItemStack)null);
                        var16.onPickupFromSlot(var4, var23);
                     }
                  } else {
                     var16.decrStackSize(var23.stackSize);
                     var16.putStack(var17);
                     var16.onPickupFromSlot(var4, var23);
                  }
               } else if (!var16.getHasStack() && var17 != null && var16.isItemValid(var17)) {
                  var6.setInventorySlotContents(var2, (ItemStack)null);
                  var16.putStack(var17);
               }
            }
         } else if (var3 == 3 && var4.capabilities.isCreativeMode && var6.getItemStack() == null && var1 >= 0) {
            var16 = (Slot)this.inventorySlots.get(var1);
            if (var16 != null && var16.getHasStack()) {
               var17 = var16.getStack().copy();
               var17.stackSize = var17.getMaxStackSize();
               var6.setItemStack(var17);
            }
         } else if (var3 == 4 && var6.getItemStack() == null && var1 >= 0) {
            var16 = (Slot)this.inventorySlots.get(var1);
            if (var16 != null && var16.getHasStack() && var16.canTakeStack(var4)) {
               var17 = var16.decrStackSize(var2 == 0 ? 1 : var16.getStack().stackSize);
               var16.onPickupFromSlot(var4, var17);
               var4.dropPlayerItemWithRandomChoice(var17, true);
            }
         } else if (var3 == 6 && var1 >= 0) {
            var16 = (Slot)this.inventorySlots.get(var1);
            var17 = var6.getItemStack();
            if (var17 != null && (var16 == null || !var16.getHasStack() || !var16.canTakeStack(var4))) {
               var9 = var2 == 0 ? 0 : this.inventorySlots.size() - 1;
               var19 = var2 == 0 ? 1 : -1;

               for(int var22 = 0; var22 < 2; ++var22) {
                  for(int var24 = var9; var24 >= 0 && var24 < this.inventorySlots.size() && var17.stackSize < var17.getMaxStackSize(); var24 += var19) {
                     Slot var25 = (Slot)this.inventorySlots.get(var24);
                     if (var25.getHasStack() && canAddItemToSlot(var25, var17, true) && var25.canTakeStack(var4) && this.canMergeSlot(var17, var25) && (var22 != 0 || var25.getStack().stackSize != var25.getStack().getMaxStackSize())) {
                        int var14 = Math.min(var17.getMaxStackSize() - var17.stackSize, var25.getStack().stackSize);
                        ItemStack var15 = var25.decrStackSize(var14);
                        var17.stackSize += var14;
                        if (var15.stackSize <= 0) {
                           var25.putStack((ItemStack)null);
                        }

                        var25.onPickupFromSlot(var4, var15);
                     }
                  }
               }
            }

            this.detectAndSendChanges();
         }
      }

      return var5;
   }

   public void removeCraftingFromCrafters(ICrafting var1) {
      this.crafters.remove(var1);
   }
}
