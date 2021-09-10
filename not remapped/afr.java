import java.util.List;
import java.util.Random;

public class afr extends afh {
   public static final amn a = amn.a("level", 0, 3);

   public zw c(adm var1, cj var2) {
      return zy.bG;
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   public boolean O() {
      return true;
   }

   public afr() {
      super(arm.f, arn.m);
      this.j(this.M.b().a(a, 0));
   }

   public boolean d() {
      return false;
   }

   public void a(adm var1, cj var2, alz var3, int var4) {
      var1.a((cj)var2, (alz)var3.a(a, ns.a(var4, 0, 3)), 2);
      var1.e(var2, this);
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   public boolean c() {
      return false;
   }

   public void j() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         zx var9 = var4.bi.h();
         if (var9 == null) {
            return true;
         } else {
            int var10 = (Integer)var3.b(a);
            zw var11 = var9.b();
            if (var11 == zy.ax) {
               if (var10 < 3) {
                  if (!var4.bA.d) {
                     var4.bi.a(var4.bi.c, new zx(zy.aw));
                  }

                  var4.b(na.I);
                  this.a(var1, var2, var3, 3);
               }

               return true;
            } else {
               zx var13;
               if (var11 == zy.bA) {
                  if (var10 > 0) {
                     if (!var4.bA.d) {
                        var13 = new zx(zy.bz, 1, 0);
                        if (!var4.bi.a(var13)) {
                           var1.d((pk)(new uz(var1, (double)var2.n() + 0.5D, (double)var2.o() + 1.5D, (double)var2.p() + 0.5D, var13)));
                        } else if (var4 instanceof lf) {
                           ((lf)var4).a(var4.bj);
                        }

                        var4.b(na.J);
                        --var9.b;
                        if (var9.b <= 0) {
                           var4.bi.a(var4.bi.c, (zx)null);
                        }
                     }

                     this.a(var1, var2, var3, var10 - 1);
                  }

                  return true;
               } else {
                  if (var10 > 0 && var11 instanceof yj) {
                     yj var12 = (yj)var11;
                     if (var12.x_() == yj.a.a && var12.d_(var9)) {
                        var12.c(var9);
                        this.a(var1, var2, var3, var10 - 1);
                        var4.b(na.K);
                        return true;
                     }
                  }

                  if (var10 > 0 && var11 instanceof ym && aku.c(var9) > 0) {
                     var13 = var9.k();
                     var13.b = 1;
                     aku.e(var13);
                     if (var9.b <= 1 && !var4.bA.d) {
                        var4.bi.a(var4.bi.c, var13);
                     } else {
                        if (!var4.bi.a(var13)) {
                           var1.d((pk)(new uz(var1, (double)var2.n() + 0.5D, (double)var2.o() + 1.5D, (double)var2.p() + 0.5D, var13)));
                        } else if (var4 instanceof lf) {
                           ((lf)var4).a(var4.bj);
                        }

                        var4.b(na.L);
                        if (!var4.bA.d) {
                           --var9.b;
                        }
                     }

                     if (!var4.bA.d) {
                        this.a(var1, var2, var3, var10 - 1);
                     }

                     return true;
                  } else {
                     return false;
                  }
               }
            }
         }
      }
   }

   public void k(adm var1, cj var2) {
      if (var1.s.nextInt(20) == 1) {
         alz var3 = var1.p(var2);
         if ((Integer)var3.b(a) < 3) {
            var1.a((cj)var2, (alz)var3.a(a), 2);
         }

      }
   }

   public int l(adm var1, cj var2) {
      return (Integer)var1.p(var2).b(a);
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.bG;
   }

   public void a(adm var1, cj var2, alz var3, aug var4, List<aug> var5, pk var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.3125F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      float var7 = 0.125F;
      this.a(0.0F, 0.0F, 0.0F, var7, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var7);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(1.0F - var7, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.a(0.0F, 0.0F, 1.0F - var7, 1.0F, 1.0F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      this.j();
   }

   public void a(adm var1, cj var2, alz var3, pk var4) {
      int var5 = (Integer)var3.b(a);
      float var6 = (float)var2.o() + (6.0F + (float)(3 * var5)) / 16.0F;
      if (!var1.D && var4.at() && var5 > 0 && var4.aR().b <= (double)var6) {
         var4.N();
         this.a(var1, var2, var3, var5 - 1);
      }

   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }
}
