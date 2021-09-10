public class arv extends ase {
   private boolean b(int var1, int var2) {
      if (a(var1, var2)) {
         return true;
      } else {
         ady var3 = ady.e(var1);
         ady var4 = ady.e(var2);
         if (var3 != null && var4 != null) {
            ady.b var5 = var3.m();
            ady.b var6 = var4.m();
            return var5 == var6 || var5 == ady.b.c || var6 == ady.b.c;
         } else {
            return false;
         }
      }
   }

   private boolean a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if (!a(var6, var7)) {
         return false;
      } else {
         int var9 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
         int var10 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
         int var11 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
         int var12 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
         if (this.b(var9, var7) && this.b(var10, var7) && this.b(var11, var7) && this.b(var12, var7)) {
            var2[var3 + var4 * var5] = var6;
         } else {
            var2[var3 + var4 * var5] = var8;
         }

         return true;
      }
   }

   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var6 = asc.a(var3 * var4);

      for(int var7 = 0; var7 < var4; ++var7) {
         for(int var8 = 0; var8 < var3; ++var8) {
            this.a((long)(var8 + var1), (long)(var7 + var2));
            int var9 = var5[var8 + 1 + (var7 + 1) * (var3 + 2)];
            if (!this.a(var5, var6, var8, var7, var3, var9, ady.s.az, ady.J.az) && !this.b(var5, var6, var8, var7, var3, var9, ady.ab.az, ady.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, ady.ac.az, ady.aa.az) && !this.b(var5, var6, var8, var7, var3, var9, ady.V.az, ady.u.az)) {
               int var10;
               int var11;
               int var12;
               int var13;
               if (var9 == ady.r.az) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if (var10 != ady.B.az && var11 != ady.B.az && var12 != ady.B.az && var13 != ady.B.az) {
                     var6[var8 + var7 * var3] = var9;
                  } else {
                     var6[var8 + var7 * var3] = ady.X.az;
                  }
               } else if (var9 == ady.v.az) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if (var10 != ady.r.az && var11 != ady.r.az && var12 != ady.r.az && var13 != ady.r.az && var10 != ady.T.az && var11 != ady.T.az && var12 != ady.T.az && var13 != ady.T.az && var10 != ady.B.az && var11 != ady.B.az && var12 != ady.B.az && var13 != ady.B.az) {
                     if (var10 != ady.K.az && var13 != ady.K.az && var11 != ady.K.az && var12 != ady.K.az) {
                        var6[var8 + var7 * var3] = var9;
                     } else {
                        var6[var8 + var7 * var3] = ady.M.az;
                     }
                  } else {
                     var6[var8 + var7 * var3] = ady.q.az;
                  }
               } else {
                  var6[var8 + var7 * var3] = var9;
               }
            }
         }
      }

      return var6;
   }

   public arv(long var1, ase var3) {
      super(var1);
      this.a = var3;
   }

   private boolean b(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      if (var6 != var7) {
         return false;
      } else {
         int var9 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
         int var10 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
         int var11 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
         int var12 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
         if (a(var9, var7) && a(var10, var7) && a(var11, var7) && a(var12, var7)) {
            var2[var3 + var4 * var5] = var6;
         } else {
            var2[var3 + var4 * var5] = var8;
         }

         return true;
      }
   }
}
