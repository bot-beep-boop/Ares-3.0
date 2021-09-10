package net.optifine.util;

import net.minecraft.client.renderer.chunk.RenderChunk;
import net.minecraft.util.MathHelper;
import net.minecraft.world.chunk.storage.ExtendedBlockStorage;

public class RenderChunkUtils {
   public static double getRelativeBufferSize(int var0) {
      double var1 = (double)var0 / 4096.0D;
      var1 *= 0.995D;
      double var3 = var1 * 2.0D - 1.0D;
      var3 = MathHelper.clamp_double(var3, -1.0D, 1.0D);
      return (double)MathHelper.sqrt_double(1.0D - var3 * var3);
   }

   public static double getRelativeBufferSize(RenderChunk var0) {
      int var1 = getCountBlocks(var0);
      double var2 = getRelativeBufferSize(var1);
      return var2;
   }

   public static int getCountBlocks(RenderChunk var0) {
      ExtendedBlockStorage[] var1 = var0.getChunk().getBlockStorageArray();
      if (var1 == null) {
         return 0;
      } else {
         int var2 = var0.getPosition().getY() >> 4;
         ExtendedBlockStorage var3 = var1[var2];
         return var3 == null ? 0 : var3.getBlockRefCount();
      }
   }
}
