public class asj extends ase {
   public int[] a(int var1, int var2, int var3, int var4) {
      int var5 = var1 - 1;
      int var6 = var2 - 1;
      int var7 = var3 + 2;
      int var8 = var4 + 2;
      int[] var9 = this.a.a(var5, var6, var7, var8);
      int[] var10 = asc.a(var3 * var4);

      for(int var11 = 0; var11 < var4; ++var11) {
         for(int var12 = 0; var12 < var3; ++var12) {
            int var13 = this.c(var9[var12 + (var11 + 1) * var7]);
            int var14 = this.c(var9[var12 + 2 + (var11 + 1) * var7]);
            int var15 = this.c(var9[var12 + 1 + var11 * var7]);
            int var16 = this.c(var9[var12 + 1 + (var11 + 2) * var7]);
            int var17 = this.c(var9[var12 + 1 + (var11 + 1) * var7]);
            if (var17 == var13 && var17 == var15 && var17 == var14 && var17 == var16) {
               var10[var12 + var11 * var3] = -1;
            } else {
               var10[var12 + var11 * var3] = ady.w.az;
            }
         }
      }

      return var10;
   }

   public asj(long var1, ase var3) {
      super(var1);
      super.a = var3;
   }

   private int c(int var1) {
      return var1 >= 2 ? 2 + (var1 & 1) : var1;
   }
}
