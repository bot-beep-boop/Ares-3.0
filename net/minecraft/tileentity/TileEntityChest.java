package net.minecraft.tileentity;

import java.util.Iterator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerChest;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryLargeChest;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;

public class TileEntityChest extends TileEntityLockable implements IInventory, ITickable {
   public float prevLidAngle;
   public TileEntityChest adjacentChestZNeg;
   public boolean adjacentChestChecked;
   public TileEntityChest adjacentChestZPos;
   public int numPlayersUsing;
   private String customName;
   private int cachedChestType;
   private ItemStack[] chestContents = new ItemStack[27];
   public float lidAngle;
   public TileEntityChest adjacentChestXPos;
   private int ticksSinceSync;
   public TileEntityChest adjacentChestXNeg;
   private static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;

   public void closeInventory(EntityPlayer var1) {
      if (!var1.isSpectator() && this.getBlockType() instanceof BlockChest) {
         --this.numPlayersUsing;
         this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
         this.worldObj.notifyNeighborsOfStateChange(this.pos, this.getBlockType());
         this.worldObj.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType());
      }

   }

   public TileEntityChest(int var1) {
      this.cachedChestType = var1;
   }

   public String getGuiID() {
      return "minecraft:chest";
   }

   public void setField(int var1, int var2) {
   }

   protected TileEntityChest getAdjacentChest(EnumFacing var1) {
      BlockPos var2 = this.pos.offset(var1);
      if (this.isChestAt(var2)) {
         TileEntity var3 = this.worldObj.getTileEntity(var2);
         if (var3 instanceof TileEntityChest) {
            TileEntityChest var4 = (TileEntityChest)var3;
            var4.func_174910_a(this, var1.getOpposite());
            return var4;
         }
      }

      return null;
   }

   public TileEntityChest() {
      this.cachedChestType = -1;
   }

   public boolean receiveClientEvent(int var1, int var2) {
      if (var1 == 1) {
         this.numPlayersUsing = var2;
         return true;
      } else {
         return super.receiveClientEvent(var1, var2);
      }
   }

   public void checkForAdjacentChests() {
      if (!this.adjacentChestChecked) {
         this.adjacentChestChecked = true;
         this.adjacentChestXNeg = this.getAdjacentChest(EnumFacing.WEST);
         this.adjacentChestXPos = this.getAdjacentChest(EnumFacing.EAST);
         this.adjacentChestZNeg = this.getAdjacentChest(EnumFacing.NORTH);
         this.adjacentChestZPos = this.getAdjacentChest(EnumFacing.SOUTH);
      }

   }

   public int getField(int var1) {
      return 0;
   }

   public ItemStack removeStackFromSlot(int var1) {
      if (this.chestContents[var1] != null) {
         ItemStack var2 = this.chestContents[var1];
         this.chestContents[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void readFromNBT(NBTTagCompound var1) {
      super.readFromNBT(var1);
      NBTTagList var2 = var1.getTagList("Items", 10);
      this.chestContents = new ItemStack[this.getSizeInventory()];
      if (var1.hasKey("CustomName", 8)) {
         this.customName = var1.getString("CustomName");
      }

      for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
         NBTTagCompound var4 = var2.getCompoundTagAt(var3);
         int var5 = var4.getByte("Slot") & 255;
         if (var5 >= 0 && var5 < this.chestContents.length) {
            this.chestContents[var5] = ItemStack.loadItemStackFromNBT(var4);
         }
      }

   }

   public void writeToNBT(NBTTagCompound var1) {
      super.writeToNBT(var1);
      NBTTagList var2 = new NBTTagList();

      for(int var3 = 0; var3 < this.chestContents.length; ++var3) {
         if (this.chestContents[var3] != null) {
            NBTTagCompound var4 = new NBTTagCompound();
            var4.setByte("Slot", (byte)var3);
            this.chestContents[var3].writeToNBT(var4);
            var2.appendTag(var4);
         }
      }

      var1.setTag("Items", var2);
      if (this.hasCustomName()) {
         var1.setString("CustomName", this.customName);
      }

   }

   public int getSizeInventory() {
      return 27;
   }

   public void updateContainingBlockInfo() {
      super.updateContainingBlockInfo();
      this.adjacentChestChecked = false;
   }

   private boolean isChestAt(BlockPos var1) {
      if (this.worldObj == null) {
         return false;
      } else {
         Block var2 = this.worldObj.getBlockState(var1).getBlock();
         return var2 instanceof BlockChest && ((BlockChest)var2).chestType == this.getChestType();
      }
   }

   static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$util$EnumFacing;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[EnumFacing.values().length];

         try {
            var0[EnumFacing.DOWN.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[EnumFacing.EAST.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[EnumFacing.NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[EnumFacing.SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[EnumFacing.UP.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[EnumFacing.WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$util$EnumFacing = var0;
         return var0;
      }
   }

   public void invalidate() {
      super.invalidate();
      this.updateContainingBlockInfo();
      this.checkForAdjacentChests();
   }

   public void setCustomName(String var1) {
      this.customName = var1;
   }

   private void func_174910_a(TileEntityChest var1, EnumFacing var2) {
      if (var1.isInvalid()) {
         this.adjacentChestChecked = false;
      } else if (this.adjacentChestChecked) {
         switch($SWITCH_TABLE$net$minecraft$util$EnumFacing()[var2.ordinal()]) {
         case 3:
            if (this.adjacentChestZNeg != var1) {
               this.adjacentChestChecked = false;
            }
            break;
         case 4:
            if (this.adjacentChestZPos != var1) {
               this.adjacentChestChecked = false;
            }
            break;
         case 5:
            if (this.adjacentChestXNeg != var1) {
               this.adjacentChestChecked = false;
            }
            break;
         case 6:
            if (this.adjacentChestXPos != var1) {
               this.adjacentChestChecked = false;
            }
         }
      }

   }

   public void openInventory(EntityPlayer var1) {
      if (!var1.isSpectator()) {
         if (this.numPlayersUsing < 0) {
            this.numPlayersUsing = 0;
         }

         ++this.numPlayersUsing;
         this.worldObj.addBlockEvent(this.pos, this.getBlockType(), 1, this.numPlayersUsing);
         this.worldObj.notifyNeighborsOfStateChange(this.pos, this.getBlockType());
         this.worldObj.notifyNeighborsOfStateChange(this.pos.down(), this.getBlockType());
      }

   }

   public boolean isUseableByPlayer(EntityPlayer var1) {
      if (this.worldObj.getTileEntity(this.pos) != this) {
         return false;
      } else {
         return !(var1.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) > 64.0D);
      }
   }

   public boolean isItemValidForSlot(int var1, ItemStack var2) {
      return true;
   }

   public void clear() {
      for(int var1 = 0; var1 < this.chestContents.length; ++var1) {
         this.chestContents[var1] = null;
      }

   }

   public int getFieldCount() {
      return 0;
   }

   public String getName() {
      return this.hasCustomName() ? this.customName : "container.chest";
   }

   public void update() {
      this.checkForAdjacentChests();
      int var1 = this.pos.getX();
      int var2 = this.pos.getY();
      int var3 = this.pos.getZ();
      ++this.ticksSinceSync;
      float var4;
      if (!this.worldObj.isRemote && this.numPlayersUsing != 0 && (this.ticksSinceSync + var1 + var2 + var3) % 200 == 0) {
         this.numPlayersUsing = 0;
         var4 = 5.0F;
         Iterator var6 = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB((double)((float)var1 - var4), (double)((float)var2 - var4), (double)((float)var3 - var4), (double)((float)(var1 + 1) + var4), (double)((float)(var2 + 1) + var4), (double)((float)(var3 + 1) + var4))).iterator();

         label126:
         while(true) {
            IInventory var7;
            do {
               EntityPlayer var5;
               do {
                  if (!var6.hasNext()) {
                     break label126;
                  }

                  var5 = (EntityPlayer)var6.next();
               } while(!(var5.openContainer instanceof ContainerChest));

               var7 = ((ContainerChest)var5.openContainer).getLowerChestInventory();
            } while(var7 != this && (!(var7 instanceof InventoryLargeChest) || !((InventoryLargeChest)var7).isPartOfLargeChest(this)));

            ++this.numPlayersUsing;
         }
      }

      this.prevLidAngle = this.lidAngle;
      var4 = 0.1F;
      double var14;
      if (this.numPlayersUsing > 0 && this.lidAngle == 0.0F && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
         double var11 = (double)var1 + 0.5D;
         var14 = (double)var3 + 0.5D;
         if (this.adjacentChestZPos != null) {
            var14 += 0.5D;
         }

         if (this.adjacentChestXPos != null) {
            var11 += 0.5D;
         }

         this.worldObj.playSoundEffect(var11, (double)var2 + 0.5D, var14, "random.chestopen", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
      }

      if (this.numPlayersUsing == 0 && this.lidAngle > 0.0F || this.numPlayersUsing > 0 && this.lidAngle < 1.0F) {
         float var12 = this.lidAngle;
         if (this.numPlayersUsing > 0) {
            this.lidAngle += var4;
         } else {
            this.lidAngle -= var4;
         }

         if (this.lidAngle > 1.0F) {
            this.lidAngle = 1.0F;
         }

         float var13 = 0.5F;
         if (this.lidAngle < var13 && var12 >= var13 && this.adjacentChestZNeg == null && this.adjacentChestXNeg == null) {
            var14 = (double)var1 + 0.5D;
            double var9 = (double)var3 + 0.5D;
            if (this.adjacentChestZPos != null) {
               var9 += 0.5D;
            }

            if (this.adjacentChestXPos != null) {
               var14 += 0.5D;
            }

            this.worldObj.playSoundEffect(var14, (double)var2 + 0.5D, var9, "random.chestclosed", 0.5F, this.worldObj.rand.nextFloat() * 0.1F + 0.9F);
         }

         if (this.lidAngle < 0.0F) {
            this.lidAngle = 0.0F;
         }
      }

   }

   public boolean hasCustomName() {
      return this.customName != null && this.customName.length() > 0;
   }

   public Container createContainer(InventoryPlayer var1, EntityPlayer var2) {
      return new ContainerChest(var1, this, var2);
   }

   public void setInventorySlotContents(int var1, ItemStack var2) {
      this.chestContents[var1] = var2;
      if (var2 != null && var2.stackSize > this.getInventoryStackLimit()) {
         var2.stackSize = this.getInventoryStackLimit();
      }

      this.markDirty();
   }

   public int getInventoryStackLimit() {
      return 64;
   }

   public int getChestType() {
      if (this.cachedChestType == -1) {
         if (this.worldObj == null || !(this.getBlockType() instanceof BlockChest)) {
            return 0;
         }

         this.cachedChestType = ((BlockChest)this.getBlockType()).chestType;
      }

      return this.cachedChestType;
   }

   public ItemStack getStackInSlot(int var1) {
      return this.chestContents[var1];
   }

   public ItemStack decrStackSize(int var1, int var2) {
      if (this.chestContents[var1] != null) {
         ItemStack var3;
         if (this.chestContents[var1].stackSize <= var2) {
            var3 = this.chestContents[var1];
            this.chestContents[var1] = null;
            this.markDirty();
            return var3;
         } else {
            var3 = this.chestContents[var1].splitStack(var2);
            if (this.chestContents[var1].stackSize == 0) {
               this.chestContents[var1] = null;
            }

            this.markDirty();
            return var3;
         }
      } else {
         return null;
      }
   }
}
