package net.minecraft.client.renderer;

import java.util.ArrayDeque;
import java.util.Arrays;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.Vec3i;
import net.minecraft.world.ChunkCache;
import net.minecraft.world.World;
import net.minecraft.world.chunk.Chunk;
import net.optifine.DynamicLights;

public class RegionRenderCache extends ChunkCache {
   private static final IBlockState DEFAULT_STATE;
   private int[] combinedLights;
   private static ArrayDeque<int[]> cacheLights;
   private IBlockState[] blockStates;
   private final BlockPos position;
   private static int maxCacheSize;
   private static ArrayDeque<IBlockState[]> cacheStates;

   public int getCombinedLight(BlockPos var1, int var2) {
      int var3 = this.getPositionIndex(var1);
      int var4 = this.combinedLights[var3];
      if (var4 == -1) {
         var4 = super.getCombinedLight(var1, var2);
         if (Config.isDynamicLights() && !this.getBlockState(var1).getBlock().isOpaqueCube()) {
            var4 = DynamicLights.getCombinedLight(var1, var4);
         }

         this.combinedLights[var3] = var4;
      }

      return var4;
   }

   private int getPositionIndex(BlockPos var1) {
      int var2 = var1.getX() - this.position.getX();
      int var3 = var1.getY() - this.position.getY();
      int var4 = var1.getZ() - this.position.getZ();
      return var2 * 400 + var4 * 20 + var3;
   }

   public static void freeLights(int[] var0) {
      synchronized(cacheLights) {
         if (cacheLights.size() < maxCacheSize) {
            cacheLights.add(var0);
         }

      }
   }

   private static int[] allocateLights(int var0) {
      synchronized(cacheLights) {
         int[] var2 = (int[])cacheLights.pollLast();
         if (var2 == null || var2.length < var0) {
            var2 = new int[var0];
         }

         return var2;
      }
   }

   public void freeBuffers() {
      freeLights(this.combinedLights);
      freeStates(this.blockStates);
   }

   public static void freeStates(IBlockState[] var0) {
      synchronized(cacheStates) {
         if (cacheStates.size() < maxCacheSize) {
            cacheStates.add(var0);
         }

      }
   }

   public TileEntity getTileEntity(BlockPos var1) {
      int var2 = (var1.getX() >> 4) - this.chunkX;
      int var3 = (var1.getZ() >> 4) - this.chunkZ;
      return this.chunkArray[var2][var3].getTileEntity(var1, Chunk.EnumCreateEntityType.QUEUED);
   }

   static {
      DEFAULT_STATE = Blocks.air.getDefaultState();
      cacheLights = new ArrayDeque();
      cacheStates = new ArrayDeque();
      maxCacheSize = Config.limit(Runtime.getRuntime().availableProcessors(), 1, 32);
   }

   private static IBlockState[] allocateStates(int var0) {
      synchronized(cacheStates) {
         IBlockState[] var2 = (IBlockState[])cacheStates.pollLast();
         if (var2 != null && var2.length >= var0) {
            Arrays.fill(var2, (Object)null);
         } else {
            var2 = new IBlockState[var0];
         }

         return var2;
      }
   }

   public IBlockState getBlockState(BlockPos var1) {
      int var2 = this.getPositionIndex(var1);
      IBlockState var3 = this.blockStates[var2];
      if (var3 == null) {
         var3 = this.getBlockStateRaw(var1);
         this.blockStates[var2] = var3;
      }

      return var3;
   }

   public RegionRenderCache(World var1, BlockPos var2, BlockPos var3, int var4) {
      super(var1, var2, var3, var4);
      this.position = var2.subtract(new Vec3i(var4, var4, var4));
      boolean var5 = true;
      this.combinedLights = allocateLights(8000);
      Arrays.fill(this.combinedLights, -1);
      this.blockStates = allocateStates(8000);
   }

   private IBlockState getBlockStateRaw(BlockPos var1) {
      return super.getBlockState(var1);
   }
}
