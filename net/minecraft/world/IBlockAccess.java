package net.minecraft.world;

import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.biome.BiomeGenBase;

public interface IBlockAccess {
   WorldType getWorldType();

   TileEntity getTileEntity(BlockPos var1);

   BiomeGenBase getBiomeGenForCoords(BlockPos var1);

   IBlockState getBlockState(BlockPos var1);

   boolean extendedLevelsInChunkCache();

   int getCombinedLight(BlockPos var1, int var2);

   int getStrongPower(BlockPos var1, EnumFacing var2);

   boolean isAirBlock(BlockPos var1);
}
