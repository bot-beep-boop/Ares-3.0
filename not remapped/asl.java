public class asl extends ase {
   public int[] a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.a.a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var6 = asc.a(var3 * var4);

      for(int var7 = 0; var7 < var4; ++var7) {
         for(int var8 = 0; var8 < var3; ++var8) {
            this.a((long)(var8 + var1), (long)(var7 + var2));
            int var9 = var5[var8 + 1 + (var7 + 1) * (var3 + 2)];
            ady var10 = ady.e(var9);
            int var11;
            int var12;
            int var13;
            int var14;
            if (var9 == ady.D.az) {
               var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
               var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
               var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
               var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
               if (var11 != ady.p.az && var12 != ady.p.az && var13 != ady.p.az && var14 != ady.p.az) {
                  var6[var8 + var7 * var3] = var9;
               } else {
                  var6[var8 + var7 * var3] = ady.E.az;
               }
            } else if (var10 != null && var10.l() == aej.class) {
               var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
               var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
               var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
               var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
               if (this.c(var11) && this.c(var12) && this.c(var13) && this.c(var14)) {
                  if (!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
                     var6[var8 + var7 * var3] = var9;
                  } else {
                     var6[var8 + var7 * var3] = ady.F.az;
                  }
               } else {
                  var6[var8 + var7 * var3] = ady.M.az;
               }
            } else if (var9 != ady.s.az && var9 != ady.X.az && var9 != ady.J.az) {
               if (var10 != null && var10.j()) {
                  this.a(var5, var6, var8, var7, var3, var9, ady.P.az);
               } else if (var9 != ady.aa.az && var9 != ady.ab.az) {
                  if (var9 != ady.p.az && var9 != ady.N.az && var9 != ady.w.az && var9 != ady.v.az) {
                     var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                     var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                     var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                     var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                     if (!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
                        var6[var8 + var7 * var3] = var9;
                     } else {
                        var6[var8 + var7 * var3] = ady.F.az;
                     }
                  } else {
                     var6[var8 + var7 * var3] = var9;
                  }
               } else {
                  var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if (!b(var11) && !b(var12) && !b(var13) && !b(var14)) {
                     if (this.d(var11) && this.d(var12) && this.d(var13) && this.d(var14)) {
                        var6[var8 + var7 * var3] = var9;
                     } else {
                        var6[var8 + var7 * var3] = ady.r.az;
                     }
                  } else {
                     var6[var8 + var7 * var3] = var9;
                  }
               }
            } else {
               this.a(var5, var6, var8, var7, var3, var9, ady.O.az);
            }
         }
      }

      return var6;
   }

   private boolean c(int var1) {
      if (ady.e(var1) != null && ady.e(var1).l() == aej.class) {
         return true;
      } else {
         return var1 == ady.M.az || var1 == ady.K.az || var1 == ady.L.az || var1 == ady.t.az || var1 == ady.u.az || b(var1);
      }
   }

   private void a(int[] var1, int[] var2, int var3, int var4, int var5, int var6, int var7) {
      if (b(var6)) {
         var2[var3 + var4 * var5] = var6;
      } else {
         int var8 = var1[var3 + 1 + (var4 + 1 - 1) * (var5 + 2)];
         int var9 = var1[var3 + 1 + 1 + (var4 + 1) * (var5 + 2)];
         int var10 = var1[var3 + 1 - 1 + (var4 + 1) * (var5 + 2)];
         int var11 = var1[var3 + 1 + (var4 + 1 + 1) * (var5 + 2)];
         if (!b(var8) && !b(var9) && !b(var10) && !b(var11)) {
            var2[var3 + var4 * var5] = var6;
         } else {
            var2[var3 + var4 * var5] = var7;
         }

      }
   }

   private boolean d(int var1) {
      return ady.e(var1) instanceof aek;
   }

   public asl(long var1, ase var3) {
      super(var1);
      this.a = var3;
   }
}
