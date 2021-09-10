package net.minecraft.tileentity;

import java.util.Iterator;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.BlockHopper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerHopper;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class TileEntityHopper extends TileEntityLockable implements ITickable, IHopper {
   private String customName;
   private ItemStack[] inventory = new ItemStack[5];
   private int transferCooldown = -1;

   public boolean hasCustomName() {
      return this.customName != null && this.customName.length() > 0;
   }

   public double getXPos() {
      return (double)this.pos.getX() + 0.5D;
   }

   public boolean updateHopper() {
      if (this.worldObj != null && !this.worldObj.isRemote) {
         if (!this.isOnTransferCooldown() && BlockHopper.isEnabled(this.getBlockMetadata())) {
            boolean var1 = false;
            if (!this.isEmpty()) {
               var1 = this.transferItemsOut();
            }

            if (!this.isFull()) {
               var1 = captureDroppedItems(this) || var1;
            }

            if (var1) {
               this.setTransferCooldown(8);
               this.markDirty();
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public void setInventorySlotContents(int var1, ItemStack var2) {
      this.inventory[var1] = var2;
      if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
         var2.stackSize = this.getInventoryStackLimit();
      }

   }

   private boolean isFull() {
      ItemStack[] var4;
      int var3 = (var4 = this.inventory).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         ItemStack var1 = var4[var2];
         if (var1 == null || var1.stackSize != var1.getMaxStackSize()) {
            return false;
         }
      }

      return true;
   }

   private static ItemStack insertStack(IInventory var0, ItemStack var1, int var2, EnumFacing var3) {
      ItemStack var4 = var0.getStackInSlot(var2);
      if (canInsertItemInSlot(var0, var1, var2, var3)) {
         boolean var5 = false;
         if (var4 == null) {
            var0.setInventorySlotContents(var2, var1);
            var1 = null;
            var5 = true;
         } else if (canCombine(var4, var1)) {
            int var6 = var1.getMaxStackSize() - var4.stackSize;
            int var7 = Math.min(var1.stackSize, var6);
            var1.stackSize -= var7;
            var4.stackSize += var7;
            var5 = var7 > 0;
         }

         if (var5) {
            if (var0 instanceof TileEntityHopper) {
               TileEntityHopper var8 = (TileEntityHopper)var0;
               if (var8.mayTransfer()) {
                  var8.setTransferCooldown(8);
               }

               var0.markDirty();
            }

            var0.markDirty();
         }
      }

      return var1;
   }

   private static boolean canInsertItemInSlot(IInventory var0, ItemStack var1, int var2, EnumFacing var3) {
      if (!var0.isItemValidForSlot(var2, var1)) {
         return false;
      } else {
         return !(var0 instanceof ISidedInventory) || ((ISidedInventory)var0).canInsertItem(var2, var1, var3);
      }
   }

   public int getSizeInventory() {
      return this.inventory.length;
   }

   public void setField(int var1, int var2) {
   }

   private boolean transferItemsOut() {
      IInventory var1 = this.getInventoryForHopperTransfer();
      if (var1 == null) {
         return false;
      } else {
         EnumFacing var2 = BlockHopper.getFacing(this.getBlockMetadata()).getOpposite();
         if (this.isInventoryFull(var1, var2)) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.getSizeInventory(); ++var3) {
               if (this.getStackInSlot(var3) != null) {
                  ItemStack var4 = this.getStackInSlot(var3).copy();
                  ItemStack var5 = putStackInInventoryAllSlots(var1, this.decrStackSize(var3, 1), var2);
                  if (var5 == null || var5.stackSize == 0) {
                     var1.markDirty();
                     return true;
                  }

                  this.setInventorySlotContents(var3, var4);
               }
            }

            return false;
         }
      }
   }

   public int getFieldCount() {
      return 0;
   }

   private static boolean canExtractItemFromSlot(IInventory var0, ItemStack var1, int var2, EnumFacing var3) {
      return !(var0 instanceof ISidedInventory) || ((ISidedInventory)var0).canExtractItem(var2, var1, var3);
   }

   public void setCustomName(String var1) {
      this.customName = var1;
   }

   public void update() {
      if (this.worldObj != null && !this.worldObj.isRemote) {
         --this.transferCooldown;
         if (!this.isOnTransferCooldown()) {
            this.setTransferCooldown(0);
            this.updateHopper();
         }
      }

   }

   public void clear() {
      for(int var1 = 0; var1 < this.inventory.length; ++var1) {
         this.inventory[var1] = null;
      }

   }

   public void closeInventory(EntityPlayer var1) {
   }

   private boolean isInventoryFull(IInventory var1, EnumFacing var2) {
      if (var1 instanceof ISidedInventory) {
         ISidedInventory var7 = (ISidedInventory)var1;
         int[] var8 = var7.getSlotsForFace(var2);

         for(int var9 = 0; var9 < var8.length; ++var9) {
            ItemStack var6 = var7.getStackInSlot(var8[var9]);
            if (var6 == null || var6.stackSize != var6.getMaxStackSize()) {
               return false;
            }
         }
      } else {
         int var3 = var1.getSizeInventory();

         for(int var4 = 0; var4 < var3; ++var4) {
            ItemStack var5 = var1.getStackInSlot(var4);
            if (var5 == null || var5.stackSize != var5.getMaxStackSize()) {
               return false;
            }
         }
      }

      return true;
   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.inventory.length; ++var3) {
         if (this.inventory[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.setByte("Slot", (byte)var3);
            this.inventory[var3].writeToNBT(var4);
            var2.appendTag(var4);
         }
      }

      var1.setTag("Items", var2);
      var1.setInteger("TransferCooldown", this.transferCooldown);
      if (this.hasCustomName()) {
         var1.setString("CustomName", this.customName);
      }

   }

   public int getField(int var1) {
      return 0;
   }

   private static boolean canCombine(ItemStack var0, ItemStack var1) {
      if (var0.getItem() != var1.getItem()) {
         return false;
      } else if (var0.getMetadata() != var1.getMetadata()) {
         return false;
      } else {
         return var0.stackSize > var0.getMaxStackSize() ? false : ItemStack.areItemStackTagsEqual(var0, var1);
      }
   }

   private static boolean pullItemFromSlot(IHopper var0, IInventory var1, int var2, EnumFacing var3) {
      ItemStack var4 = var1.getStackInSlot(var2);
      if (var4 != null && canExtractItemFromSlot(var1, var4, var2, var3)) {
         ItemStack var5 = var4.copy();
         ItemStack var6 = putStackInInventoryAllSlots(var0, var1.decrStackSize(var2, 1), (EnumFacing)null);
         if (var6 == null || var6.stackSize == 0) {
            var1.markDirty();
            return true;
         }

         var1.setInventorySlotContents(var2, var5);
      }

      return false;
   }

   public Container createContainer(InventoryPlayer var1, EntityPlayer var2) {
      return new ContainerHopper(var1, this, var2);
   }

   public double getZPos() {
      return (double)this.pos.getZ() + 0.5D;
   }

   private IInventory getInventoryForHopperTransfer() {
      EnumFacing var1 = BlockHopper.getFacing(this.getBlockMetadata());
      return getInventoryAtPosition(this.getWorld(), (double)(this.pos.getX() + var1.getFrontOffsetX()), (double)(this.pos.getY() + var1.getFrontOffsetY()), (double)(this.pos.getZ() + var1.getFrontOffsetZ()));
   }

   private boolean isEmpty() {
      ItemStack[] var4;
      int var3 = (var4 = this.inventory).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         ItemStack var1 = var4[var2];
         if (var1 != null) {
            return false;
         }
      }

      return true;
   }

   public boolean isOnTransferCooldown() {
      return this.transferCooldown > 0;
   }

   public ItemStack removeStackFromSlot(int var1) {
      if (this.inventory[var1] != null) {
         ItemStack var2 = this.inventory[var1];
         this.inventory[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public String getGuiID() {
      return "minecraft:hopper";
   }

   public static IInventory getHopperInventory(IHopper var0) {
      return getInventoryAtPosition(var0.getWorld(), var0.getXPos(), var0.getYPos() + 1.0D, var0.getZPos());
   }

   public static IInventory getInventoryAtPosition(World var0, double var1, double var3, double var5) {
      Object var7 = null;
      int var8 = MathHelper.floor_double(var1);
      int var9 = MathHelper.floor_double(var3);
      int var10 = MathHelper.floor_double(var5);
      BlockPos var11 = new BlockPos(var8, var9, var10);
      Block var12 = var0.getBlockState(var11).getBlock();
      if (var12.hasTileEntity()) {
         TileEntity var13 = var0.getTileEntity(var11);
         if (var13 instanceof IInventory) {
            var7 = (IInventory)var13;
            if (var7 instanceof TileEntityChest && var12 instanceof BlockChest) {
               var7 = ((BlockChest)var12).getLockableContainer(var0, var11);
            }
         }
      }

      if (var7 == null) {
         List var14 = var0.getEntitiesInAABBexcluding((Entity)null, new AxisAlignedBB(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D), EntitySelectors.selectInventories);
         if (var14.size() > 0) {
            var7 = (IInventory)var14.get(var0.rand.nextInt(var14.size()));
         }
      }

      return (IInventory)var7;
   }

   public void markDirty() {
      super.markDirty();
   }

   public static List<EntityItem> func_181556_a(World var0, double var1, double var3, double var5) {
      return var0.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(var1 - 0.5D, var3 - 0.5D, var5 - 0.5D, var1 + 0.5D, var3 + 0.5D, var5 + 0.5D), EntitySelectors.selectAnything);
   }

   public ItemStack getStackInSlot(int var1) {
      return this.inventory[var1];
   }

   public boolean isItemValidForSlot(int var1, ItemStack var2) {
      return true;
   }

   public String getName() {
      return this.hasCustomName() ? this.customName : "container.hopper";
   }

   public void openInventory(EntityPlayer var1) {
   }

   public void setTransferCooldown(int var1) {
      this.transferCooldown = var1;
   }

   public boolean isUseableByPlayer(EntityPlayer var1) {
      if (this.worldObj.getTileEntity(this.pos) != this) {
         return false;
      } else {
         return !(var1.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) > 64.0D);
      }
   }

   public ItemStack decrStackSize(int var1, int var2) {
      if (this.inventory[var1] != null) {
         ItemStack var3;
         if (this.inventory[var1].stackSize <= var2) {
            var3 = this.inventory[var1];
            this.inventory[var1] = null;
            return var3;
         } else {
            var3 = this.inventory[var1].splitStack(var2);
            if (this.inventory[var1].stackSize == 0) {
               this.inventory[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public int getInventoryStackLimit() {
      return 64;
   }

   public double getYPos() {
      return (double)this.pos.getY() + 0.5D;
   }

   private static boolean isInventoryEmpty(IInventory var0, EnumFacing var1) {
      if (var0 instanceof ISidedInventory) {
         ISidedInventory var2 = (ISidedInventory)var0;
         int[] var3 = var2.getSlotsForFace(var1);

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var2.getStackInSlot(var3[var4]) != null) {
               return false;
            }
         }
      } else {
         int var5 = var0.getSizeInventory();

         for(int var6 = 0; var6 < var5; ++var6) {
            if (var0.getStackInSlot(var6) != null) {
               return false;
            }
         }
      }

      return true;
   }

   public boolean mayTransfer() {
      return this.transferCooldown <= 1;
   }

   public static boolean captureDroppedItems(IHopper var0) {
      IInventory var1 = getHopperInventory(var0);
      if (var1 != null) {
         EnumFacing var2 = EnumFacing.DOWN;
         if (isInventoryEmpty(var1, var2)) {
            return false;
         }

         if (var1 instanceof ISidedInventory) {
            ISidedInventory var3 = (ISidedInventory)var1;
            int[] var4 = var3.getSlotsForFace(var2);

            for(int var5 = 0; var5 < var4.length; ++var5) {
               if (pullItemFromSlot(var0, var1, var4[var5], var2)) {
                  return true;
               }
            }
         } else {
            int var7 = var1.getSizeInventory();

            for(int var9 = 0; var9 < var7; ++var9) {
               if (pullItemFromSlot(var0, var1, var9, var2)) {
                  return true;
               }
            }
         }
      } else {
         Iterator var8 = func_181556_a(var0.getWorld(), var0.getXPos(), var0.getYPos() + 1.0D, var0.getZPos()).iterator();

         while(var8.hasNext()) {
            EntityItem var6 = (EntityItem)var8.next();
            if (putDropInInventoryAllSlots(var0, var6)) {
               return true;
            }
         }
      }

      return false;
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
      NBTTagList var2 = var1.getTagList("Items", 10);
      this.inventory = new ItemStack[this.getSizeInventory()];
      if (var1.hasKey("CustomName", 8)) {
         this.customName = var1.getString("CustomName");
      }

      this.transferCooldown = var1.getInteger("TransferCooldown");

      for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
         NBTTagCompound var4 = var2.getCompoundTagAt(var3);
         byte var5 = var4.getByte("Slot");
         if (var5 >= 0 && var5 < this.inventory.length) {
            this.inventory[var5] = ItemStack.loadItemStackFromNBT(var4);
         }
      }

   }

   public static ItemStack putStackInInventoryAllSlots(IInventory var0, ItemStack var1, EnumFacing var2) {
      if (var0 instanceof ISidedInventory && var2 != null) {
         ISidedInventory var6 = (ISidedInventory)var0;
         int[] var7 = var6.getSlotsForFace(var2);

         for(int var5 = 0; var5 < var7.length && var1 != null && var1.stackSize > 0; ++var5) {
            var1 = insertStack(var0, var1, var7[var5], var2);
         }
      } else {
         int var3 = var0.getSizeInventory();

         for(int var4 = 0; var4 < var3 && var1 != null && var1.stackSize > 0; ++var4) {
            var1 = insertStack(var0, var1, var4, var2);
         }
      }

      if (var1 != null && var1.stackSize == 0) {
         var1 = null;
      }

      return var1;
   }

   public static boolean putDropInInventoryAllSlots(IInventory var0, EntityItem var1) {
      boolean var2 = false;
      if (var1 == null) {
         return false;
      } else {
         ItemStack var3 = var1.getEntityItem().copy();
         ItemStack var4 = putStackInInventoryAllSlots(var0, var3, (EnumFacing)null);
         if (var4 != null && var4.stackSize != 0) {
            var1.setEntityItemStack(var4);
         } else {
            var2 = true;
            var1.setDead();
         }

         return var2;
      }
   }
}
