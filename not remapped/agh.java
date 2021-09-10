import com.google.common.base.Predicate;
import java.util.Random;

public class agh extends afh {
   public static final amm<agh.b> N;
   public static final amk b;
   public static final amm<agh.a> P;
   public static final amk O;
   public static final aml a;

   public static cq f(int var0) {
      return cq.b(var0 & 3).f();
   }

   protected static boolean j(int var0) {
      return (var0 & 16) != 0;
   }

   public adf m() {
      return adf.c;
   }

   protected static boolean i(int var0) {
      return (var0 & 8) != 0;
   }

   public boolean c() {
      return false;
   }

   public alz a(alz var1, adq var2, cj var3) {
      alz var4;
      if (var1.b(P) == agh.a.b) {
         var4 = var2.p(var3.a());
         if (var4.c() == this) {
            var1 = var1.a(N, var4.b(N)).a(O, var4.b(O));
         }
      } else {
         var4 = var2.p(var3.b());
         if (var4.c() == this) {
            var1 = var1.a(a, var4.b(a)).a(b, var4.b(b));
         }
      }

      return var1;
   }

   public zw c(adm var1, cj var2) {
      return this.l();
   }

   private void k(int var1) {
      float var2 = 0.1875F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
      cq var3 = f(var1);
      boolean var4 = g(var1);
      boolean var5 = j(var1);
      if (var4) {
         if (var3 == cq.f) {
            if (!var5) {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            } else {
               this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }
         } else if (var3 == cq.d) {
            if (!var5) {
               this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
         } else if (var3 == cq.e) {
            if (!var5) {
               this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            } else {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }
         } else if (var3 == cq.c) {
            if (!var5) {
               this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            } else {
               this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
         }
      } else if (var3 == cq.f) {
         this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
      } else if (var3 == cq.d) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
      } else if (var3 == cq.e) {
         this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else if (var3 == cq.c) {
         this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
      }

   }

   public aug b(adm var1, cj var2) {
      this.a(var1, var2);
      return super.b(var1, var2);
   }

   protected static int b(int var0) {
      return var0 & 7;
   }

   protected ama e() {
      return new ama(this, new amo[]{P, a, b, N, O});
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (this.J == arm.f) {
         return true;
      } else {
         cj var9 = var3.b(P) == agh.a.b ? var2 : var2.b();
         alz var10 = var2.equals(var9) ? var3 : var1.p(var9);
         if (var10.c() != this) {
            return false;
         } else {
            var3 = var10.a(b);
            var1.a((cj)var9, (alz)var3, 2);
            var1.b(var9, var2);
            var1.a(var4, (Boolean)var3.b(b) ? 1003 : 1006, var2, 0);
            return true;
         }
      }
   }

   public zw a(alz var1, Random var2, int var3) {
      return var1.b(P) == agh.a.a ? null : this.l();
   }

   public boolean d() {
      return false;
   }

   public static boolean f(adq var0, cj var1) {
      return g(e(var0, var1));
   }

   protected agh(arm var1) {
      super(var1);
      this.j(this.M.b().a(a, cq.c).a(b, false).a(N, agh.b.a).a(O, false).a(P, agh.a.b));
   }

   public String f() {
      return di.a((this.a() + ".name").replaceAll("tile", "item"));
   }

   public int k() {
      return 1;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (var3.b(P) == agh.a.a) {
         cj var5 = var2.b();
         alz var6 = var1.p(var5);
         if (var6.c() != this) {
            var1.g(var2);
         } else if (var4 != this) {
            this.a(var1, var5, var6, var4);
         }
      } else {
         boolean var9 = false;
         cj var10 = var2.a();
         alz var7 = var1.p(var10);
         if (var7.c() != this) {
            var1.g(var2);
            var9 = true;
         }

         if (!adm.a((adq)var1, (cj)var2.b())) {
            var1.g(var2);
            var9 = true;
            if (var7.c() == this) {
               var1.g(var10);
            }
         }

         if (var9) {
            if (!var1.D) {
               this.b(var1, var2, var3, 0);
            }
         } else {
            boolean var8 = var1.z(var2) || var1.z(var10);
            if ((var8 || var4.i()) && var4 != this && var8 != (Boolean)var7.b(O)) {
               var1.a((cj)var10, (alz)var7.a(O, var8), 2);
               if (var8 != (Boolean)var3.b(b)) {
                  var1.a((cj)var2, (alz)var3.a(b, var8), 2);
                  var1.b(var2, var2);
                  var1.a((wn)null, var8 ? 1003 : 1006, var2, 0);
               }
            }
         }
      }

   }

   public void a(adq var1, cj var2) {
      this.k(e(var1, var2));
   }

   public auh a(adm var1, cj var2, aui var3, aui var4) {
      this.a(var1, var2);
      return super.a(var1, var2, var3, var4);
   }

   public void a(adm var1, cj var2, boolean var3) {
      alz var4 = var1.p(var2);
      if (var4.c() == this) {
         cj var5 = var4.b(P) == agh.a.b ? var2 : var2.b();
         alz var6 = var2 == var5 ? var4 : var1.p(var5);
         if (var6.c() == this && (Boolean)var6.b(b) != var3) {
            var1.a((cj)var5, (alz)var6.a(b, var3), 2);
            var1.b(var5, var2);
            var1.a((wn)null, var3 ? 1003 : 1006, var2, 0);
         }

      }
   }

   public static cq h(adq var0, cj var1) {
      return f(e(var0, var1));
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3;
      if (var1.b(P) == agh.a.a) {
         var3 = var2 | 8;
         if (var1.b(N) == agh.b.b) {
            var3 |= 1;
         }

         if ((Boolean)var1.b(O)) {
            var3 |= 2;
         }
      } else {
         var3 = var2 | ((cq)var1.b(a)).e().b();
         if ((Boolean)var1.b(b)) {
            var3 |= 4;
         }
      }

      return var3;
   }

   public void a(adm var1, cj var2, alz var3, wn var4) {
      cj var5 = var2.b();
      if (var4.bA.d && var3.b(P) == agh.a.a && var1.p(var5).c() == this) {
         var1.g(var5);
      }

   }

   public boolean d(adm var1, cj var2) {
      if (var2.o() >= 255) {
         return false;
      } else {
         return adm.a((adq)var1, (cj)var2.b()) && super.d(var1, var2) && super.d(var1, var2.a());
      }
   }

   public alz a(int var1) {
      return (var1 & 8) > 0 ? this.Q().a(P, agh.a.a).a(N, (var1 & 1) > 0 ? agh.b.b : agh.b.a).a(O, (var1 & 2) > 0) : this.Q().a(P, agh.a.b).a(a, cq.b(var1 & 3).f()).a(b, (var1 & 4) > 0);
   }

   protected static boolean g(int var0) {
      return (var0 & 4) != 0;
   }

   public static int e(adq var0, cj var1) {
      alz var2 = var0.p(var1);
      int var3 = var2.c().c(var2);
      boolean var4 = i(var3);
      alz var5 = var0.p(var1.b());
      int var6 = var5.c().c(var5);
      int var7 = var4 ? var6 : var3;
      alz var8 = var0.p(var1.a());
      int var9 = var8.c().c(var8);
      int var10 = var4 ? var3 : var9;
      boolean var11 = (var10 & 1) != 0;
      boolean var12 = (var10 & 2) != 0;
      return b(var7) | (var4 ? 8 : 0) | (var11 ? 16 : 0) | (var12 ? 32 : 0);
   }

   private zw l() {
      if (this == afi.aA) {
         return zy.aB;
      } else if (this == afi.ap) {
         return zy.ar;
      } else if (this == afi.aq) {
         return zy.as;
      } else if (this == afi.ar) {
         return zy.at;
      } else if (this == afi.as) {
         return zy.au;
      } else {
         return this == afi.at ? zy.av : zy.aq;
      }
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
      b = amk.a("open");
      N = amm.a("hinge", agh.b.class);
      O = amk.a("powered");
      P = amm.a("half", agh.a.class);
   }

   public boolean b(adq var1, cj var2) {
      return g(e(var1, var2));
   }

   public aug a(adm var1, cj var2, alz var3) {
      this.a(var1, var2);
      return super.a(var1, var2, var3);
   }

   public static enum b implements nw {
      b;

      private static final agh.b[] c = new agh.b[]{a, b};
      a;

      public String toString() {
         return this.l();
      }

      public String l() {
         return this == a ? "left" : "right";
      }
   }

   public static enum a implements nw {
      b,
      a;

      private static final agh.a[] c = new agh.a[]{a, b};

      public String toString() {
         return this.l();
      }

      public String l() {
         return this == a ? "upper" : "lower";
      }
   }
}
