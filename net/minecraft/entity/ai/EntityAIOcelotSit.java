package net.minecraft.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBed;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntityAIOcelotSit extends EntityAIMoveToBlock {
   private final EntityOcelot ocelot;

   public EntityAIOcelotSit(EntityOcelot var1, double var2) {
      super(var1, var2, 8);
      this.ocelot = var1;
   }

   public void resetTask() {
      super.resetTask();
      this.ocelot.setSitting(false);
   }

   protected boolean shouldMoveTo(World var1, BlockPos var2) {
      if (!var1.isAirBlock(var2.up())) {
         return false;
      } else {
         IBlockState var3 = var1.getBlockState(var2);
         Block var4 = var3.getBlock();
         if (var4 == Blocks.chest) {
            TileEntity var5 = var1.getTileEntity(var2);
            if (var5 instanceof TileEntityChest && ((TileEntityChest)var5).numPlayersUsing < 1) {
               return true;
            }
         } else {
            if (var4 == Blocks.lit_furnace) {
               return true;
            }

            if (var4 == Blocks.bed && var3.getValue(BlockBed.PART) != BlockBed.EnumPartType.HEAD) {
               return true;
            }
         }

         return false;
      }
   }

   public void startExecuting() {
      super.startExecuting();
      this.ocelot.getAISit().setSitting(false);
   }

   public boolean continueExecuting() {
      return super.continueExecuting();
   }

   public void updateTask() {
      super.updateTask();
      this.ocelot.getAISit().setSitting(false);
      if (!this.getIsAboveDestination()) {
         this.ocelot.setSitting(false);
      } else if (!this.ocelot.isSitting()) {
         this.ocelot.setSitting(true);
      }

   }

   public boolean shouldExecute() {
      return this.ocelot.isTamed() && !this.ocelot.isSitting() && super.shouldExecute();
   }
}
