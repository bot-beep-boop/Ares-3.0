import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Random;

public class agv extends afh {
   public static final amk N = amk.a("alt");
   public static final amk Q = amk.a("south");
   public static final amn S = amn.a("upper", 0, 2);
   private final Map<afh, Integer> U = Maps.newIdentityHashMap();
   public static final amk O = amk.a("north");
   public static final amk R = amk.a("west");
   public static final amn a = amn.a("age", 0, 15);
   private final Map<afh, Integer> T = Maps.newIdentityHashMap();
   public static final amk b = amk.a("flip");
   public static final amk P = amk.a("east");

   protected agv() {
      super(arm.o);
      this.j(this.M.b().a(a, 0).a(b, false).a(N, false).a(O, false).a(P, false).a(Q, false).a(R, false).a(S, 0));
      this.a(true);
   }

   public void c(adm var1, cj var2, alz var3) {
      if (var1.t.q() > 0 || !afi.aY.e(var1, var2)) {
         if (!adm.a((adq)var1, (cj)var2.b()) && !this.f(var1, var2)) {
            var1.g(var2);
         } else {
            var1.a((cj)var2, (afh)this, this.a(var1) + var1.s.nextInt(10));
         }
      }
   }

   public alz a(int var1) {
      return this.Q().a(a, var1);
   }

   private int d(afh var1) {
      Integer var2 = (Integer)this.T.get(var1);
      return var2 == null ? 0 : var2;
   }

   public arn g(alz var1) {
      return arn.f;
   }

   public boolean N() {
      return false;
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      if (var4.nextInt(24) == 0) {
         var1.a((double)((float)var2.n() + 0.5F), (double)((float)var2.o() + 0.5F), (double)((float)var2.p() + 0.5F), "fire.fire", 1.0F + var4.nextFloat(), var4.nextFloat() * 0.7F + 0.3F, false);
      }

      int var5;
      double var6;
      double var8;
      double var10;
      if (!adm.a((adq)var1, (cj)var2.b()) && !afi.ab.e((adq)var1, var2.b())) {
         if (afi.ab.e((adq)var1, var2.e())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)var2.n() + var4.nextDouble() * 0.10000000149011612D;
               var8 = (double)var2.o() + var4.nextDouble();
               var10 = (double)var2.p() + var4.nextDouble();
               var1.a(cy.m, var6, var8, var10, 0.0D, 0.0D, 0.0D);
            }
         }

         if (afi.ab.e((adq)var1, var2.f())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)(var2.n() + 1) - var4.nextDouble() * 0.10000000149011612D;
               var8 = (double)var2.o() + var4.nextDouble();
               var10 = (double)var2.p() + var4.nextDouble();
               var1.a(cy.m, var6, var8, var10, 0.0D, 0.0D, 0.0D);
            }
         }

         if (afi.ab.e((adq)var1, var2.c())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)var2.n() + var4.nextDouble();
               var8 = (double)var2.o() + var4.nextDouble();
               var10 = (double)var2.p() + var4.nextDouble() * 0.10000000149011612D;
               var1.a(cy.m, var6, var8, var10, 0.0D, 0.0D, 0.0D);
            }
         }

         if (afi.ab.e((adq)var1, var2.d())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)var2.n() + var4.nextDouble();
               var8 = (double)var2.o() + var4.nextDouble();
               var10 = (double)(var2.p() + 1) - var4.nextDouble() * 0.10000000149011612D;
               var1.a(cy.m, var6, var8, var10, 0.0D, 0.0D, 0.0D);
            }
         }

         if (afi.ab.e((adq)var1, var2.a())) {
            for(var5 = 0; var5 < 2; ++var5) {
               var6 = (double)var2.n() + var4.nextDouble();
               var8 = (double)(var2.o() + 1) - var4.nextDouble() * 0.10000000149011612D;
               var10 = (double)var2.p() + var4.nextDouble();
               var1.a(cy.m, var6, var8, var10, 0.0D, 0.0D, 0.0D);
            }
         }
      } else {
         for(var5 = 0; var5 < 3; ++var5) {
            var6 = (double)var2.n() + var4.nextDouble();
            var8 = (double)var2.o() + var4.nextDouble() * 0.5D + 0.5D;
            var10 = (double)var2.p() + var4.nextDouble();
            var1.a(cy.m, var6, var8, var10, 0.0D, 0.0D, 0.0D);
         }
      }

   }

   public boolean A() {
      return false;
   }

   public boolean c() {
      return false;
   }

   public alz a(alz var1, adq var2, cj var3) {
      int var4 = var3.n();
      int var5 = var3.o();
      int var6 = var3.p();
      if (!adm.a(var2, var3.b()) && !afi.ab.e(var2, var3.b())) {
         boolean var7 = (var4 + var5 + var6 & 1) == 1;
         boolean var8 = (var4 / 2 + var5 / 2 + var6 / 2 & 1) == 1;
         int var9 = 0;
         if (this.e(var2, var3.a())) {
            var9 = var7 ? 1 : 2;
         }

         return var1.a(O, this.e(var2, var3.c())).a(P, this.e(var2, var3.f())).a(Q, this.e(var2, var3.d())).a(R, this.e(var2, var3.e())).a(S, var9).a(b, var8).a(N, var7);
      } else {
         return this.Q();
      }
   }

   public static void l() {
      afi.ab.a(afi.f, 5, 20);
      afi.ab.a(afi.bL, 5, 20);
      afi.ab.a(afi.bM, 5, 20);
      afi.ab.a(afi.bo, 5, 20);
      afi.ab.a(afi.bp, 5, 20);
      afi.ab.a(afi.bq, 5, 20);
      afi.ab.a(afi.br, 5, 20);
      afi.ab.a(afi.bs, 5, 20);
      afi.ab.a(afi.bt, 5, 20);
      afi.ab.a(afi.aO, 5, 20);
      afi.ab.a(afi.aP, 5, 20);
      afi.ab.a(afi.aQ, 5, 20);
      afi.ab.a(afi.aR, 5, 20);
      afi.ab.a(afi.aS, 5, 20);
      afi.ab.a(afi.aT, 5, 20);
      afi.ab.a(afi.ad, 5, 20);
      afi.ab.a(afi.bV, 5, 20);
      afi.ab.a(afi.bU, 5, 20);
      afi.ab.a(afi.bW, 5, 20);
      afi.ab.a(afi.r, 5, 5);
      afi.ab.a(afi.s, 5, 5);
      afi.ab.a(afi.t, 30, 60);
      afi.ab.a(afi.u, 30, 60);
      afi.ab.a(afi.X, 30, 20);
      afi.ab.a(afi.W, 15, 100);
      afi.ab.a(afi.H, 60, 100);
      afi.ab.a(afi.cF, 60, 100);
      afi.ab.a(afi.N, 60, 100);
      afi.ab.a(afi.O, 60, 100);
      afi.ab.a(afi.I, 60, 100);
      afi.ab.a(afi.L, 30, 60);
      afi.ab.a(afi.bn, 15, 100);
      afi.ab.a(afi.cA, 5, 5);
      afi.ab.a(afi.cx, 60, 20);
      afi.ab.a(afi.cy, 60, 20);
   }

   private void a(adm var1, cj var2, int var3, Random var4, int var5) {
      int var6 = this.c(var1.p(var2).c());
      if (var4.nextInt(var3) < var6) {
         alz var7 = var1.p(var2);
         if (var4.nextInt(var5 + 10) < 5 && !var1.C(var2)) {
            int var8 = var5 + var4.nextInt(5) / 4;
            if (var8 > 15) {
               var8 = 15;
            }

            var1.a((cj)var2, (alz)this.Q().a(a, var8), 3);
         } else {
            var1.g(var2);
         }

         if (var7.c() == afi.W) {
            afi.W.d(var1, var2, var7.a(ake.a, true));
         }
      }

   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (var1.Q().b("doFireTick")) {
         if (!this.d(var1, var2)) {
            var1.g(var2);
         }

         afh var5 = var1.p(var2.b()).c();
         boolean var6 = var5 == afi.aV;
         if (var1.t instanceof anp && var5 == afi.h) {
            var6 = true;
         }

         if (!var6 && var1.S() && this.e(var1, var2)) {
            var1.g(var2);
         } else {
            int var7 = (Integer)var3.b(a);
            if (var7 < 15) {
               var3 = var3.a(a, var7 + var4.nextInt(3) / 2);
               var1.a((cj)var2, (alz)var3, 4);
            }

            var1.a((cj)var2, (afh)this, this.a(var1) + var4.nextInt(10));
            if (!var6) {
               if (!this.f(var1, var2)) {
                  if (!adm.a((adq)var1, (cj)var2.b()) || var7 > 3) {
                     var1.g(var2);
                  }

                  return;
               }

               if (!this.e((adq)var1, var2.b()) && var7 == 15 && var4.nextInt(4) == 0) {
                  var1.g(var2);
                  return;
               }
            }

            boolean var8 = var1.D(var2);
            byte var9 = 0;
            if (var8) {
               var9 = -50;
            }

            this.a(var1, var2.f(), 300 + var9, var4, var7);
            this.a(var1, var2.e(), 300 + var9, var4, var7);
            this.a(var1, var2.b(), 250 + var9, var4, var7);
            this.a(var1, var2.a(), 250 + var9, var4, var7);
            this.a(var1, var2.c(), 300 + var9, var4, var7);
            this.a(var1, var2.d(), 300 + var9, var4, var7);

            for(int var10 = -1; var10 <= 1; ++var10) {
               for(int var11 = -1; var11 <= 1; ++var11) {
                  for(int var12 = -1; var12 <= 4; ++var12) {
                     if (var10 != 0 || var12 != 0 || var11 != 0) {
                        int var13 = 100;
                        if (var12 > 1) {
                           var13 += (var12 - 1) * 100;
                        }

                        cj var14 = var2.a(var10, var12, var11);
                        int var15 = this.m(var1, var14);
                        if (var15 > 0) {
                           int var16 = (var15 + 40 + var1.aa().a() * 7) / (var7 + 30);
                           if (var8) {
                              var16 /= 2;
                           }

                           if (var16 > 0 && var4.nextInt(var13) <= var16 && (!var1.S() || !this.e(var1, var14))) {
                              int var17 = var7 + var4.nextInt(5) / 4;
                              if (var17 > 15) {
                                 var17 = 15;
                              }

                              var1.a((cj)var14, (alz)var3.a(a, var17), 3);
                           }
                        }
                     }
                  }
               }
            }

         }
      }
   }

   private boolean f(adm var1, cj var2) {
      cq[] var3 = cq.values();
      int var4 = var3.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         cq var6 = var3[var5];
         if (this.e((adq)var1, var2.a(var6))) {
            return true;
         }
      }

      return false;
   }

   private int m(adm var1, cj var2) {
      if (!var1.d(var2)) {
         return 0;
      } else {
         int var3 = 0;
         cq[] var4 = cq.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            cq var7 = var4[var6];
            var3 = Math.max(this.d(var1.p(var2.a(var7)).c()), var3);
         }

         return var3;
      }
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }

   public int a(Random var1) {
      return 0;
   }

   public int a(adm var1) {
      return 30;
   }

   public boolean d() {
      return false;
   }

   public void a(afh var1, int var2, int var3) {
      this.T.put(var1, var2);
      this.U.put(var1, var3);
   }

   public adf m() {
      return adf.c;
   }

   private int c(afh var1) {
      Integer var2 = (Integer)this.U.get(var1);
      return var2 == null ? 0 : var2;
   }

   public boolean e(adq var1, cj var2) {
      return this.d(var1.p(var2).c()) > 0;
   }

   protected boolean e(adm var1, cj var2) {
      return var1.C(var2) || var1.C(var2.e()) || var1.C(var2.f()) || var1.C(var2.c()) || var1.C(var2.d());
   }

   public boolean d(adm var1, cj var2) {
      return adm.a((adq)var1, (cj)var2.b()) || this.f(var1, var2);
   }

   public int c(alz var1) {
      return (Integer)var1.b(a);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, O, P, Q, R, S, b, N});
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!adm.a((adq)var1, (cj)var2.b()) && !this.f(var1, var2)) {
         var1.g(var2);
      }

   }
}
