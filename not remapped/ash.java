public class ash extends ase {
   public ash(long var1, ase var3) {
      super(var1);
      this.a = var3;
   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int var5 = var1 - 1;
      int var6 = var2 - 1;
      int var7 = var3 + 2;
      int var8 = var4 + 2;
      int[] var9 = this.a.a(var5, var6, var7, var8);
      int[] var10 = asc.a(var3 * var4);

      for(int var11 = 0; var11 < var4; ++var11) {
         for(int var12 = 0; var12 < var3; ++var12) {
            int var13 = var9[var12 + 1 + (var11 + 1 - 1) * (var3 + 2)];
            int var14 = var9[var12 + 1 + 1 + (var11 + 1) * (var3 + 2)];
            int var15 = var9[var12 + 1 - 1 + (var11 + 1) * (var3 + 2)];
            int var16 = var9[var12 + 1 + (var11 + 1 + 1) * (var3 + 2)];
            int var17 = var9[var12 + 1 + (var11 + 1) * var7];
            var10[var12 + var11 * var3] = var17;
            this.a((long)(var12 + var1), (long)(var11 + var2));
            if (var17 == 0 && var13 == 0 && var14 == 0 && var15 == 0 && var16 == 0 && this.a(2) == 0) {
               var10[var12 + var11 * var3] = 1;
            }
         }
      }

      return var10;
   }
}
