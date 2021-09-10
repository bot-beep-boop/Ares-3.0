public class yv extends zw {
   private afh a;

   private zx a(zx var1, wn var2, zw var3) {
      if (var2.bA.d) {
         return var1;
      } else if (--var1.b <= 0) {
         return new zx(var3);
      } else {
         if (!var2.bi.a(new zx(var3))) {
            var2.a(new zx(var3, 1, 0), false);
         }

         return var1;
      }
   }

   public yv(afh var1) {
      this.h = 1;
      this.a = var1;
      this.a(yz.f);
   }

   public boolean a(adm var1, cj var2) {
      if (this.a == afi.a) {
         return false;
      } else {
         arm var3 = var1.p(var2).c().t();
         boolean var4 = !var3.a();
         if (!var1.d(var2) && !var4) {
            return false;
         } else {
            if (var1.t.n() && this.a == afi.i) {
               int var5 = var2.n();
               int var6 = var2.o();
               int var7 = var2.p();
               var1.a((double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), (double)((float)var7 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

               for(int var8 = 0; var8 < 8; ++var8) {
                  var1.a(cy.m, (double)var5 + Math.random(), (double)var6 + Math.random(), (double)var7 + Math.random(), 0.0D, 0.0D, 0.0D);
               }
            } else {
               if (!var1.D && var4 && !var3.d()) {
                  var1.b(var2, true);
               }

               var1.a((cj)var2, (alz)this.a.Q(), 3);
            }

            return true;
         }
      }
   }

   public zx a(zx var1, adm var2, wn var3) {
      boolean var4 = this.a == afi.a;
      auh var5 = this.a(var2, var3, var4);
      if (var5 == null) {
         return var1;
      } else {
         if (var5.a == auh.a.b) {
            cj var6 = var5.a();
            if (!var2.a(var3, var6)) {
               return var1;
            }

            if (var4) {
               if (!var3.a(var6.a(var5.b), var5.b, var1)) {
                  return var1;
               }

               alz var7 = var2.p(var6);
               arm var8 = var7.c().t();
               if (var8 == arm.h && (Integer)var7.b(ahv.b) == 0) {
                  var2.g(var6);
                  var3.b(na.ad[zw.b((zw)this)]);
                  return this.a(var1, var3, zy.ax);
               }

               if (var8 == arm.i && (Integer)var7.b(ahv.b) == 0) {
                  var2.g(var6);
                  var3.b(na.ad[zw.b((zw)this)]);
                  return this.a(var1, var3, zy.ay);
               }
            } else {
               if (this.a == afi.a) {
                  return new zx(zy.aw);
               }

               cj var9 = var6.a(var5.b);
               if (!var3.a(var9, var5.b, var1)) {
                  return var1;
               }

               if (this.a(var2, var9) && !var3.bA.d) {
                  var3.b(na.ad[zw.b((zw)this)]);
                  return new zx(zy.aw);
               }
            }
         }

         return var1;
      }
   }
}
