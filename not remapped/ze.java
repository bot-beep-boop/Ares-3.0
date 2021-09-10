import java.util.List;

public class ze extends zw {
   public static final int[] a = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};

   public static boolean a(zx var0, adm var1, cj var2) {
      alz var3 = var1.p(var2);
      if (var3.c() instanceof afj) {
         afj var4 = (afj)var3.c();
         if (var4.a(var1, var2, var3, var1.D)) {
            if (!var1.D) {
               if (var4.a(var1, var1.s, var2, var3)) {
                  var4.b(var1, var1.s, var2, var3);
               }

               --var0.b;
            }

            return true;
         }
      }

      return false;
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      for(int var4 = 0; var4 < 16; ++var4) {
         var3.add(new zx(var1, 1, var4));
      }

   }

   public boolean a(zx var1, wn var2, pr var3) {
      if (var3 instanceof tv) {
         tv var4 = (tv)var3;
         zd var5 = zd.a(var1.i());
         if (!var4.cm() && var4.cl() != var5) {
            var4.b(var5);
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else {
         zd var9 = zd.a(var1.i());
         if (var9 == zd.a) {
            if (a(var1, var3, var4)) {
               if (!var3.D) {
                  var3.b(2005, var4, 0);
               }

               return true;
            }
         } else if (var9 == zd.m) {
            alz var10 = var3.p(var4);
            afh var11 = var10.c();
            if (var11 == afi.r && var10.b(aio.a) == aio.a.d) {
               if (var5 == cq.a) {
                  return false;
               }

               if (var5 == cq.b) {
                  return false;
               }

               var4 = var4.a(var5);
               if (var3.d(var4)) {
                  alz var12 = afi.bN.a(var3, var4, var5, var6, var7, var8, 0, var2);
                  var3.a((cj)var4, (alz)var12, 2);
                  if (!var2.bA.d) {
                     --var1.b;
                  }
               }

               return true;
            }
         }

         return false;
      }
   }

   public String e_(zx var1) {
      int var2 = var1.i();
      return super.a() + "." + zd.a(var2).d();
   }

   public static void a(adm var0, cj var1, int var2) {
      if (var2 == 0) {
         var2 = 15;
      }

      afh var3 = var0.p(var1).c();
      if (var3.t() != arm.a) {
         var3.a((adq)var0, (cj)var1);

         for(int var4 = 0; var4 < var2; ++var4) {
            double var5 = g.nextGaussian() * 0.02D;
            double var7 = g.nextGaussian() * 0.02D;
            double var9 = g.nextGaussian() * 0.02D;
            var0.a(cy.v, (double)((float)var1.n() + g.nextFloat()), (double)var1.o() + (double)g.nextFloat() * var3.E(), (double)((float)var1.p() + g.nextFloat()), var5, var7, var9);
         }

      }
   }

   public ze() {
      this.a(true);
      this.d(0);
      this.a(yz.l);
   }
}
