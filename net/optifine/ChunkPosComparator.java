package net.optifine;

import java.util.Comparator;
import net.minecraft.util.MathHelper;
import net.minecraft.world.ChunkCoordIntPair;

public class ChunkPosComparator implements Comparator<ChunkCoordIntPair> {
   private double pitchNorm;
   private double yawRad;
   private int chunkPosZ;
   private int chunkPosX;

   private int getDistSq(ChunkCoordIntPair var1) {
      int var2 = var1.chunkXPos - this.chunkPosX;
      int var3 = var1.chunkZPos - this.chunkPosZ;
      int var4 = var2 * var2 + var3 * var3;
      double var5 = MathHelper.atan2((double)var3, (double)var2);
      double var7 = Math.abs(var5 - this.yawRad);
      if (var7 > 3.141592653589793D) {
         var7 = 6.283185307179586D - var7;
      }

      var4 = (int)((double)var4 * 1000.0D * this.pitchNorm * var7 * var7);
      return var4;
   }

   public ChunkPosComparator(int var1, int var2, double var3, double var5) {
      this.chunkPosX = var1;
      this.chunkPosZ = var2;
      this.yawRad = var3;
      this.pitchNorm = 1.0D - MathHelper.clamp_double(Math.abs(var5) / 1.5707963267948966D, 0.0D, 1.0D);
   }

   public int compare(ChunkCoordIntPair var1, ChunkCoordIntPair var2) {
      int var3 = this.getDistSq(var1);
      int var4 = this.getDistSq(var2);
      return var3 - var4;
   }

   public int compare(Object var1, Object var2) {
      return this.compare((ChunkCoordIntPair)var1, (ChunkCoordIntPair)var2);
   }
}
