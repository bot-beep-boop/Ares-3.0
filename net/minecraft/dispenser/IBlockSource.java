package net.minecraft.dispenser;

import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;

public interface IBlockSource extends ILocatableSource {
   BlockPos getBlockPos();

   double getZ();

   <T extends TileEntity> T getBlockTileEntity();

   double getX();

   int getBlockMetadata();

   double getY();
}
