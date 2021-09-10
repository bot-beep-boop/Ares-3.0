import java.util.Random;

public class agg extends afc {
   public static final aml a = aml.a("facing");
   protected Random O = new Random();
   public static final amk b = amk.a("triggered");
   public static final cp<zw, cr> N = new cp(new cn());

   public void b(adm var1, cj var2, alz var3) {
      akw var4 = var1.s(var2);
      if (var4 instanceof alc) {
         oi.a(var1, (cj)var2, (alc)var4);
         var1.e(var2, this);
      }

      super.b(var1, var2, var3);
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(a, als.a(var1, var2, var8)).a(b, false);
   }

   protected agg() {
      super(arm.e);
      this.j(this.M.b().a(a, cq.c).a(b, false));
      this.a((yz)yz.d);
   }

   public akw a(adm var1, int var2) {
      return new alc();
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         this.f(var1, var2);
      }

   }

   public void c(adm var1, cj var2, alz var3) {
      super.c(var1, var2, var3);
      this.e(var1, var2, var3);
   }

   public static cq b(int var0) {
      return cq.a(var0 & 7);
   }

   public int b() {
      return 3;
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         akw var9 = var1.s(var2);
         if (var9 instanceof alc) {
            var4.a((og)((alc)var9));
            if (var9 instanceof ald) {
               var4.b(na.O);
            } else {
               var4.b(na.Q);
            }
         }

         return true;
      }
   }

   protected cr a(zx var1) {
      return (cr)N.a(var1 == null ? null : var1.b());
   }

   private void e(adm var1, cj var2, alz var3) {
      if (!var1.D) {
         cq var4 = (cq)var3.b(a);
         boolean var5 = var1.p(var2.c()).c().o();
         boolean var6 = var1.p(var2.d()).c().o();
         if (var4 == cq.c && var5 && !var6) {
            var4 = cq.d;
         } else if (var4 == cq.d && var6 && !var5) {
            var4 = cq.c;
         } else {
            boolean var7 = var1.p(var2.e()).c().o();
            boolean var8 = var1.p(var2.f()).c().o();
            if (var4 == cq.e && var7 && !var8) {
               var4 = cq.f;
            } else if (var4 == cq.f && var8 && !var7) {
               var4 = cq.e;
            }
         }

         var1.a((cj)var2, (alz)var3.a(a, var4).a(b, false), 2);
      }
   }

   protected void f(adm var1, cj var2) {
      cl var3 = new cl(var1, var2);
      alc var4 = (alc)var3.h();
      if (var4 != null) {
         int var5 = var4.m();
         if (var5 < 0) {
            var1.b(1001, var2, 0);
         } else {
            zx var6 = var4.a(var5);
            cr var7 = this.a(var6);
            if (var7 != cr.a) {
               zx var8 = var7.a(var3, var6);
               var4.a(var5, var8.b <= 0 ? null : var8);
            }

         }
      }
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      boolean var5 = var1.z(var2) || var1.z(var2.a());
      boolean var6 = (Boolean)var3.b(b);
      if (var5 && !var6) {
         var1.a((cj)var2, (afh)this, this.a(var1));
         var1.a((cj)var2, (alz)var3.a(b, true), 4);
      } else if (!var5 && var6) {
         var1.a((cj)var2, (alz)var3.a(b, false), 4);
      }

   }

   public alz a(int var1) {
      return this.Q().a(a, b(var1)).a(b, (var1 & 8) > 0);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((cq)var1.b(a)).a();
      if ((Boolean)var1.b(b)) {
         var3 |= 8;
      }

      return var3;
   }

   public boolean O() {
      return true;
   }

   public int a(adm var1) {
      return 4;
   }

   public alz b(alz var1) {
      return this.Q().a(a, cq.d);
   }

   public static cz a(ck var0) {
      cq var1 = b(var0.f());
      double var2 = var0.a() + 0.7D * (double)var1.g();
      double var4 = var0.b() + 0.7D * (double)var1.h();
      double var6 = var0.c() + 0.7D * (double)var1.i();
      return new da(var2, var4, var6);
   }

   public int l(adm var1, cj var2) {
      return xi.a(var1.s(var2));
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      var1.a((cj)var2, (alz)var3.a(a, als.a(var1, var2, var4)), 2);
      if (var5.s()) {
         akw var6 = var1.s(var2);
         if (var6 instanceof alc) {
            ((alc)var6).a(var5.q());
         }
      }

   }
}
