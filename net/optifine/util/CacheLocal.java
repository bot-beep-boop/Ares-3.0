package net.optifine.util;

public class CacheLocal {
   private int maxZ = 18;
   private int maxX = 18;
   private int offsetZ = 0;
   private int offsetY = 0;
   private int[] lastZs = null;
   private int offsetX = 0;
   private int maxY = 128;
   private int[][][] cache = null;
   private int lastDz = 0;

   public void setOffset(int var1, int var2, int var3) {
      this.offsetX = var1;
      this.offsetY = var2;
      this.offsetZ = var3;
      this.resetCache();
   }

   public CacheLocal(int var1, int var2, int var3) {
      this.maxX = var1;
      this.maxY = var2;
      this.maxZ = var3;
      this.cache = new int[var1][var2][var3];
      this.resetCache();
   }

   public void setLast(int var1) {
      try {
         this.lastZs[this.lastDz] = var1;
      } catch (Exception var3) {
         var3.printStackTrace();
      }

   }

   public int get(int var1, int var2, int var3) {
      try {
         this.lastZs = this.cache[var1 - this.offsetX][var2 - this.offsetY];
         this.lastDz = var3 - this.offsetZ;
         return this.lastZs[this.lastDz];
      } catch (ArrayIndexOutOfBoundsException var5) {
         var5.printStackTrace();
         return -1;
      }
   }

   public void resetCache() {
      for(int var1 = 0; var1 < this.maxX; ++var1) {
         int[][] var2 = this.cache[var1];

         for(int var3 = 0; var3 < this.maxY; ++var3) {
            int[] var4 = var2[var3];

            for(int var5 = 0; var5 < this.maxZ; ++var5) {
               var4[var5] = -1;
            }
         }
      }

   }
}
