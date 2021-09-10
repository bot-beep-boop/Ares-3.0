import java.util.List;
import java.util.Random;

public class agi extends afm implements afj {
   public static final amm<cq> N;
   public static final amm<agi.b> a = amm.a("variant", agi.b.class);
   public static final amm<agi.a> b = amm.a("half", agi.a.class);

   public int c(alz var1) {
      return var1.b(b) == agi.a.a ? 8 | ((cq)var1.b(N)).b() : ((agi.b)var1.b(a)).a();
   }

   public boolean d(adm var1, cj var2) {
      return super.d(var1, var2) && var1.d(var2.a());
   }

   public agi.b e(adq var1, cj var2) {
      alz var3 = var1.p(var2);
      if (var3.c() == this) {
         var3 = this.a(var3, var1, var2);
         return (agi.b)var3.b(a);
      } else {
         return agi.b.d;
      }
   }

   public afh.a R() {
      return afh.a.b;
   }

   public boolean f(adm var1, cj var2, alz var3) {
      if (var3.b(b) == agi.a.a) {
         return var1.p(var2.b()).c() == this;
      } else {
         alz var4 = var1.p(var2.a());
         return var4.c() == this && super.f(var1, var2, var4);
      }
   }

   public int j(adm var1, cj var2) {
      return this.e(var1, var2).a();
   }

   public void b(adm var1, Random var2, cj var3, alz var4) {
      a((adm)var1, (cj)var3, (zx)(new zx(this, 1, this.e(var1, var3).a())));
   }

   protected ama e() {
      return new ama(this, new amo[]{b, a, N});
   }

   static {
      N = age.O;
   }

   public boolean a(adm var1, cj var2) {
      alz var3 = var1.p(var2);
      if (var3.c() != this) {
         return true;
      } else {
         agi.b var4 = (agi.b)this.a((alz)var3, (adq)var1, (cj)var2).b(a);
         return var4 == agi.b.d || var4 == agi.b.c;
      }
   }

   public alz a(alz var1, adq var2, cj var3) {
      if (var1.b(b) == agi.a.a) {
         alz var4 = var2.p(var3.b());
         if (var4.c() == this) {
            var1 = var1.a(a, var4.b(a));
         }
      }

      return var1;
   }

   public boolean a(adm var1, cj var2, alz var3, boolean var4) {
      agi.b var5 = this.e(var1, var2);
      return var5 != agi.b.c && var5 != agi.b.d;
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      var1.a((cj)var2.a(), (alz)this.Q().a(b, agi.a.a), 2);
   }

   public void a(adq var1, cj var2) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
   }

   public int a(alz var1) {
      return var1.b(b) != agi.a.a && var1.b(a) != agi.b.c ? ((agi.b)var1.b(a)).a() : 0;
   }

   public int a(adq var1, cj var2, int var3) {
      agi.b var4 = this.e(var1, var2);
      return var4 != agi.b.c && var4 != agi.b.d ? 16777215 : aea.a(var1, var2);
   }

   public boolean a(adm var1, Random var2, cj var3, alz var4) {
      return true;
   }

   private boolean b(adm var1, cj var2, alz var3, wn var4) {
      agi.b var5 = (agi.b)var3.b(a);
      if (var5 != agi.b.d && var5 != agi.b.c) {
         return false;
      } else {
         var4.b(na.ab[afh.a((afh)this)]);
         int var6 = (var5 == agi.b.c ? akc.a.b : akc.a.c).a();
         a((adm)var1, (cj)var2, (zx)(new zx(afi.H, 2, var6)));
         return true;
      }
   }

   public agi() {
      super(arm.l);
      this.j(this.M.b().a(a, agi.b.a).a(b, agi.a.b).a(N, cq.c));
      this.c(0.0F);
      this.a(h);
      this.c("doublePlant");
   }

   public void a(adm var1, cj var2, agi.b var3, int var4) {
      var1.a(var2, this.Q().a(b, agi.a.b).a(a, var3), var4);
      var1.a(var2.a(), this.Q().a(b, agi.a.a), var4);
   }

   public void a(adm var1, wn var2, cj var3, alz var4, akw var5) {
      if (var1.D || var2.bZ() == null || var2.bZ().b() != zy.be || var4.b(b) != agi.a.b || !this.b(var1, var3, var4, var2)) {
         super.a(var1, var2, var3, var4, var5);
      }
   }

   public zw a(alz var1, Random var2, int var3) {
      if (var1.b(b) == agi.a.a) {
         return null;
      } else {
         agi.b var4 = (agi.b)var1.b(a);
         if (var4 == agi.b.d) {
            return null;
         } else if (var4 == agi.b.c) {
            return var2.nextInt(8) == 0 ? zy.N : null;
         } else {
            return zw.a((afh)this);
         }
      }
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      agi.b[] var4 = agi.b.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         agi.b var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public alz a(int var1) {
      return (var1 & 8) > 0 ? this.Q().a(b, agi.a.a) : this.Q().a(b, agi.a.b).a(a, agi.b.a(var1 & 7));
   }

   protected void e(adm var1, cj var2, alz var3) {
      if (!this.f(var1, var2, var3)) {
         boolean var4 = var3.b(b) == agi.a.a;
         cj var5 = var4 ? var2 : var2.a();
         cj var6 = var4 ? var2.b() : var2;
         Object var7 = var4 ? this : var1.p(var5).c();
         Object var8 = var4 ? var1.p(var6).c() : this;
         if (var7 == this) {
            var1.a((cj)var5, (alz)afi.a.Q(), 2);
         }

         if (var8 == this) {
            var1.a((cj)var6, (alz)afi.a.Q(), 3);
            if (!var4) {
               this.b(var1, var6, var3, 0);
            }
         }

      }
   }

   public void a(adm var1, cj var2, alz var3, wn var4) {
      if (var3.b(b) == agi.a.a) {
         if (var1.p(var2.b()).c() == this) {
            if (!var4.bA.d) {
               alz var5 = var1.p(var2.b());
               agi.b var6 = (agi.b)var5.b(a);
               if (var6 != agi.b.d && var6 != agi.b.c) {
                  var1.b(var2.b(), true);
               } else if (!var1.D) {
                  if (var4.bZ() != null && var4.bZ().b() == zy.be) {
                     this.b(var1, var2, var5, var4);
                     var1.g(var2.b());
                  } else {
                     var1.b(var2.b(), true);
                  }
               } else {
                  var1.g(var2.b());
               }
            } else {
               var1.g(var2.b());
            }
         }
      } else if (var4.bA.d && var1.p(var2.a()).c() == this) {
         var1.a((cj)var2.a(), (alz)afi.a.Q(), 2);
      }

      super.a(var1, var2, var3, var4);
   }

   public static enum a implements nw {
      private static final agi.a[] c = new agi.a[]{a, b};
      b,
      a;

      public String l() {
         return this == a ? "upper" : "lower";
      }

      public String toString() {
         return this.l();
      }
   }

   public static enum b implements nw {
      d(3, "double_fern", "fern");

      private static final agi.b[] g = new agi.b[values().length];
      private final String i;
      private static final agi.b[] k = new agi.b[]{a, b, c, d, e, f};
      private final String j;
      e(4, "double_rose", "rose"),
      c(2, "double_grass", "grass");

      private final int h;
      b(1, "syringa"),
      f(5, "paeonia"),
      a(0, "sunflower");

      public String c() {
         return this.j;
      }

      public static agi.b a(int var0) {
         if (var0 < 0 || var0 >= g.length) {
            var0 = 0;
         }

         return g[var0];
      }

      public String l() {
         return this.i;
      }

      public String toString() {
         return this.i;
      }

      static {
         agi.b[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            agi.b var3 = var0[var2];
            g[var3.a()] = var3;
         }

      }

      public int a() {
         return this.h;
      }

      private b(int var3, String var4) {
         this(var3, var4, var4);
      }

      private b(int var3, String var4, String var5) {
         this.h = var3;
         this.i = var4;
         this.j = var5;
      }
   }
}
