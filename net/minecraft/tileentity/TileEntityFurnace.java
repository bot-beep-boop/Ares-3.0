package net.minecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.MathHelper;

public class TileEntityFurnace extends TileEntityLockable implements ITickable, ISidedInventory {
   private static final int[] slotsBottom = new int[]{2, 1};
   private ItemStack[] furnaceItemStacks = new ItemStack[3];
   private int totalCookTime;
   private static final int[] slotsSides = new int[]{1};
   private int cookTime;
   private static final int[] slotsTop = new int[1];
   private int currentItemBurnTime;
   private int furnaceBurnTime;
   private String furnaceCustomName;

   public boolean canInsertItem(int var1, ItemStack var2, EnumFacing var3) {
      return this.isItemValidForSlot(var1, var2);
   }

   public int getField(int var1) {
      switch(var1) {
      case 0:
         return this.furnaceBurnTime;
      case 1:
         return this.currentItemBurnTime;
      case 2:
         return this.cookTime;
      case 3:
         return this.totalCookTime;
      default:
         return 0;
      }
   }

   public void smeltItem() {
      if (this.canSmelt()) {
         ItemStack var1 = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks[0]);
         if (this.furnaceItemStacks[2] == null) {
            this.furnaceItemStacks[2] = var1.copy();
         } else if (this.furnaceItemStacks[2].getItem() == var1.getItem()) {
            ++this.furnaceItemStacks[2].stackSize;
         }

         if (this.furnaceItemStacks[0].getItem() == Item.getItemFromBlock(Blocks.sponge) && this.furnaceItemStacks[0].getMetadata() == 1 && this.furnaceItemStacks[1] != null && this.furnaceItemStacks[1].getItem() == Items.bucket) {
            this.furnaceItemStacks[1] = new ItemStack(Items.water_bucket);
         }

         --this.furnaceItemStacks[0].stackSize;
         if (this.furnaceItemStacks[0].stackSize <= 0) {
            this.furnaceItemStacks[0] = null;
         }
      }

   }

   public String getGuiID() {
      return "minecraft:furnace";
   }

   public int getSizeInventory() {
      return this.furnaceItemStacks.length;
   }

   public void setCustomInventoryName(String var1) {
      this.furnaceCustomName = var1;
   }

   public ItemStack getStackInSlot(int var1) {
      return this.furnaceItemStacks[var1];
   }

   public int getFieldCount() {
      return 4;
   }

   public boolean isUseableByPlayer(EntityPlayer var1) {
      if (this.worldObj.getTileEntity(this.pos) != this) {
         return false;
      } else {
         return !(var1.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) > 64.0D);
      }
   }

   public void closeInventory(EntityPlayer var1) {
   }

   public ItemStack decrStackSize(int var1, int var2) {
      if (this.furnaceItemStacks[var1] != null) {
         ItemStack var3;
         if (this.furnaceItemStacks[var1].stackSize <= var2) {
            var3 = this.furnaceItemStacks[var1];
            this.furnaceItemStacks[var1] = null;
            return var3;
         } else {
            var3 = this.furnaceItemStacks[var1].splitStack(var2);
            if (this.furnaceItemStacks[var1].stackSize == 0) {
               this.furnaceItemStacks[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public void clear() {
      for(int var1 = 0; var1 < this.furnaceItemStacks.length; ++var1) {
         this.furnaceItemStacks[var1] = null;
      }

   }

   public static boolean isItemFuel(ItemStack var0) {
      return getItemBurnTime(var0) > 0;
   }

   public void update() {
      boolean var1 = this.isBurning();
      boolean var2 = false;
      if (this.isBurning()) {
         --this.furnaceBurnTime;
      }

      if (!this.worldObj.isRemote) {
         if (!this.isBurning() && (this.furnaceItemStacks[1] == null || this.furnaceItemStacks[0] == null)) {
            if (!this.isBurning() && this.cookTime > 0) {
               this.cookTime = MathHelper.clamp_int(this.cookTime - 2, 0, this.totalCookTime);
            }
         } else {
            if (!this.isBurning() && this.canSmelt()) {
               this.currentItemBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
               if (this.isBurning()) {
                  var2 = true;
                  if (this.furnaceItemStacks[1] != null) {
                     --this.furnaceItemStacks[1].stackSize;
                     if (this.furnaceItemStacks[1].stackSize == 0) {
                        Item var3 = this.furnaceItemStacks[1].getItem().getContainerItem();
                        this.furnaceItemStacks[1] = var3 != null ? new ItemStack(var3) : null;
                     }
                  }
               }
            }

            if (this.isBurning() && this.canSmelt()) {
               ++this.cookTime;
               if (this.cookTime == this.totalCookTime) {
                  this.cookTime = 0;
                  this.totalCookTime = this.getCookTime(this.furnaceItemStacks[0]);
                  this.smeltItem();
                  var2 = true;
               }
            } else {
               this.cookTime = 0;
            }
         }

         if (var1 != this.isBurning()) {
            var2 = true;
            BlockFurnace.setState(this.isBurning(), this.worldObj, this.pos);
         }
      }

      if (var2) {
         this.markDirty();
      }

   }

   public static boolean isBurning(IInventory var0) {
      return var0.getField(0) > 0;
   }

   public static int getItemBurnTime(ItemStack var0) {
      if (var0 == null) {
         return 0;
      } else {
         Item var1 = var0.getItem();
         if (var1 instanceof ItemBlock && Block.getBlockFromItem(var1) != Blocks.air) {
            Block var2 = Block.getBlockFromItem(var1);
            if (var2 == Blocks.wooden_slab) {
               return 150;
            }

            if (var2.getMaterial() == Material.wood) {
               return 300;
            }

            if (var2 == Blocks.coal_block) {
               return 16000;
            }
         }

         if (var1 instanceof ItemTool && ((ItemTool)var1).getToolMaterialName().equals("WOOD")) {
            return 200;
         } else if (var1 instanceof ItemSword && ((ItemSword)var1).getToolMaterialName().equals("WOOD")) {
            return 200;
         } else if (var1 instanceof ItemHoe && ((ItemHoe)var1).getMaterialName().equals("WOOD")) {
            return 200;
         } else if (var1 == Items.stick) {
            return 100;
         } else if (var1 == Items.coal) {
            return 1600;
         } else if (var1 == Items.lava_bucket) {
            return 20000;
         } else if (var1 == Item.getItemFromBlock(Blocks.sapling)) {
            return 100;
         } else {
            return var1 == Items.blaze_rod ? 2400 : 0;
         }
      }
   }

   public String getName() {
      return this.hasCustomName() ? this.furnaceCustomName : "container.furnace";
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
      NBTTagList var2 = var1.getTagList("Items", 10);
      this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

      for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
         NBTTagCompound var4 = var2.getCompoundTagAt(var3);
         byte var5 = var4.getByte("Slot");
         if (var5 >= 0 && var5 < this.furnaceItemStacks.length) {
            this.furnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
         }
      }

      this.furnaceBurnTime = var1.getShort("BurnTime");
      this.cookTime = var1.getShort("CookTime");
      this.totalCookTime = var1.getShort("CookTimeTotal");
      this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);
      if (var1.hasKey("CustomName", 8)) {
         this.furnaceCustomName = var1.getString("CustomName");
      }

   }

   public boolean hasCustomName() {
      return this.furnaceCustomName != null && this.furnaceCustomName.length() > 0;
   }

   public void setInventorySlotContents(int var1, ItemStack var2) {
      boolean var3 = var2 != null && var2.isItemEqual(this.furnaceItemStacks[var1]) && ItemStack.areItemStackTagsEqual(var2, this.furnaceItemStacks[var1]);
      this.furnaceItemStacks[var1] = var2;
      if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
         var2.stackSize = this.getInventoryStackLimit();
      }

      if (var1 == 0 && !var3) {
         this.totalCookTime = this.getCookTime(var2);
         this.cookTime = 0;
         this.markDirty();
      }

   }

   public void setField(int var1, int var2) {
      switch(var1) {
      case 0:
         this.furnaceBurnTime = var2;
         break;
      case 1:
         this.currentItemBurnTime = var2;
         break;
      case 2:
         this.cookTime = var2;
         break;
      case 3:
         this.totalCookTime = var2;
      }

   }

   public int[] getSlotsForFace(EnumFacing var1) {
      if (var1 == EnumFacing.DOWN) {
         return slotsBottom;
      } else {
         return var1 == EnumFacing.UP ? slotsTop : slotsSides;
      }
   }

   public ItemStack removeStackFromSlot(int var1) {
      if (this.furnaceItemStacks[var1] != null) {
         ItemStack var2 = this.furnaceItemStacks[var1];
         this.furnaceItemStacks[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
      var1.setShort("BurnTime", (short)this.furnaceBurnTime);
      var1.setShort("CookTime", (short)this.cookTime);
      var1.setShort("CookTimeTotal", (short)this.totalCookTime);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3) {
         if (this.furnaceItemStacks[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.setByte("Slot", (byte)var3);
            this.furnaceItemStacks[var3].writeToNBT(var4);
            var2.appendTag(var4);
         }
      }

      var1.setTag("Items", var2);
      if (this.hasCustomName()) {
         var1.setString("CustomName", this.furnaceCustomName);
      }

   }

   private boolean canSmelt() {
      if (this.furnaceItemStacks[0] == null) {
         return false;
      } else {
         ItemStack var1 = FurnaceRecipes.instance().getSmeltingResult(this.furnaceItemStacks[0]);
         if (var1 == null) {
            return false;
         } else if (this.furnaceItemStacks[2] == null) {
            return true;
         } else if (!this.furnaceItemStacks[2].isItemEqual(var1)) {
            return false;
         } else if (this.furnaceItemStacks[2].stackSize < this.getInventoryStackLimit() && this.furnaceItemStacks[2].stackSize < this.furnaceItemStacks[2].getMaxStackSize()) {
            return true;
         } else {
            return this.furnaceItemStacks[2].stackSize < var1.getMaxStackSize();
         }
      }
   }

   public boolean canExtractItem(int var1, ItemStack var2, EnumFacing var3) {
      if (var3 == EnumFacing.DOWN && var1 == 1) {
         Item var4 = var2.getItem();
         if (var4 != Items.water_bucket && var4 != Items.bucket) {
            return false;
         }
      }

      return true;
   }

   public boolean isItemValidForSlot(int var1, ItemStack var2) {
      if (var1 == 2) {
         return false;
      } else if (var1 != 1) {
         return true;
      } else {
         return isItemFuel(var2) || SlotFurnaceFuel.isBucket(var2);
      }
   }

   public int getInventoryStackLimit() {
      return 64;
   }

   public Container createContainer(InventoryPlayer var1, EntityPlayer var2) {
      return new ContainerFurnace(var1, this);
   }

   public boolean isBurning() {
      return this.furnaceBurnTime > 0;
   }

   public void openInventory(EntityPlayer var1) {
   }

   public int getCookTime(ItemStack var1) {
      return 200;
   }
}
