package net.optifine.override;

import java.util.Arrays;
import net.minecraft.block.state.IBlockState;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.optifine.DynamicLights;
import net.optifine.reflect.Reflector;
import net.optifine.util.ArrayCache;

public class ChunkCacheOF implements IBlockAccess {
   private final ChunkCache chunkCache;
   private static final ArrayCache cacheCombinedLights;
   private final int posX;
   private final int arraySize;
   private int[] combinedLights;
   private static final ArrayCache cacheBlockStates;
   private final boolean dynamicLights = Config.isDynamicLights();
   private final int posZ;
   private final int sizeZ;
   private IBlockState[] blockStates;
   private final int sizeXY;
   private final int sizeX;
   private final int posY;
   private final int sizeY;

   public int getCombinedLight(BlockPos var1, int var2) {
      int var3 = this.getPositionIndex(var1);
      if (var3 >= 0 && var3 < this.arraySize && this.combinedLights != null) {
         int var4 = this.combinedLights[var3];
         if (var4 == -1) {
            var4 = this.getCombinedLightRaw(var1, var2);
            this.combinedLights[var3] = var4;
         }

         return var4;
      } else {
         return this.getCombinedLightRaw(var1, var2);
      }
   }

   public boolean isAirBlock(BlockPos var1) {
      return this.chunkCache.isAirBlock(var1);
   }

   public void renderStart() {
      if (this.combinedLights == null) {
         this.combinedLights = (int[])cacheCombinedLights.allocate(this.arraySize);
      }

      Arrays.fill(this.combinedLights, -1);
      if (this.blockStates == null) {
         this.blockStates = (IBlockState[])cacheBlockStates.allocate(this.arraySize);
      }

      Arrays.fill(this.blockStates, (Object)null);
   }

   public void renderFinish() {
      cacheCombinedLights.free(this.combinedLights);
      this.combinedLights = null;
      cacheBlockStates.free(this.blockStates);
      this.blockStates = null;
   }

   private int getCombinedLightRaw(BlockPos var1, int var2) {
      int var3 = this.chunkCache.getCombinedLight(var1, var2);
      if (this.dynamicLights && !this.getBlockState(var1).getBlock().isOpaqueCube()) {
         var3 = DynamicLights.getCombinedLight(var1, var3);
      }

      return var3;
   }

   public TileEntity getTileEntity(BlockPos var1) {
      return this.chunkCache.getTileEntity(var1);
   }

   static {
      cacheCombinedLights = new ArrayCache(Integer.TYPE, 16);
      cacheBlockStates = new ArrayCache(IBlockState.class, 16);
   }

   public WorldType getWorldType() {
      return this.chunkCache.getWorldType();
   }

   private int getPositionIndex(BlockPos var1) {
      int var2 = var1.getX() - this.posX;
      if (var2 >= 0 && var2 < this.sizeX) {
         int var3 = var1.getY() - this.posY;
         if (var3 >= 0 && var3 < this.sizeY) {
            int var4 = var1.getZ() - this.posZ;
            return var4 >= 0 && var4 < this.sizeZ ? var4 * this.sizeXY + var3 * this.sizeX + var2 : -1;
         } else {
            return -1;
         }
      } else {
         return -1;
      }
   }

   public ChunkCacheOF(ChunkCache var1, BlockPos var2, BlockPos var3, int var4) {
      this.chunkCache = var1;
      int var5 = var2.getX() - var4 >> 4;
      int var6 = var2.getY() - var4 >> 4;
      int var7 = var2.getZ() - var4 >> 4;
      int var8 = var3.getX() + var4 >> 4;
      int var9 = var3.getY() + var4 >> 4;
      int var10 = var3.getZ() + var4 >> 4;
      this.sizeX = var8 - var5 + 1 << 4;
      this.sizeY = var9 - var6 + 1 << 4;
      this.sizeZ = var10 - var7 + 1 << 4;
      this.sizeXY = this.sizeX * this.sizeY;
      this.arraySize = this.sizeX * this.sizeY * this.sizeZ;
      this.posX = var5 << 4;
      this.posY = var6 << 4;
      this.posZ = var7 << 4;
   }

   public IBlockState getBlockState(BlockPos var1) {
      int var2 = this.getPositionIndex(var1);
      if (var2 >= 0 && var2 < this.arraySize && this.blockStates != null) {
         IBlockState var3 = this.blockStates[var2];
         if (var3 == null) {
            var3 = this.chunkCache.getBlockState(var1);
            this.blockStates[var2] = var3;
         }

         return var3;
      } else {
         return this.chunkCache.getBlockState(var1);
      }
   }

   public BiomeGenBase getBiomeGenForCoords(BlockPos var1) {
      return this.chunkCache.getBiomeGenForCoords(var1);
   }

   public boolean extendedLevelsInChunkCache() {
      return this.chunkCache.extendedLevelsInChunkCache();
   }

   public int getStrongPower(BlockPos var1, EnumFacing var2) {
      return this.chunkCache.getStrongPower(var1, var2);
   }

   public boolean isSideSolid(BlockPos var1, EnumFacing var2, boolean var3) {
      return Reflector.callBoolean(this.chunkCache, Reflector.ForgeChunkCache_isSideSolid, var1, var2, var3);
   }
}
