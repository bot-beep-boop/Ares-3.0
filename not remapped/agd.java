import java.util.Random;

public abstract class agd extends age {
   protected final boolean N;

   public void a(adm var1, cj var2, alz var3, Random var4) {
   }

   protected int c(adq var1, cj var2, cq var3) {
      alz var4 = var1.p(var2);
      afh var5 = var4.c();
      if (this.c(var5)) {
         return var5 == afi.af ? (Integer)var4.b(ajb.P) : var1.a(var2, var3);
      } else {
         return 0;
      }
   }

   protected abstract alz k(alz var1);

   protected int m(alz var1) {
      return this.d(var1);
   }

   public adf m() {
      return adf.c;
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (this.e(var1, var2)) {
         this.g(var1, var2, var3);
      } else {
         this.b(var1, var2, var3, 0);
         var1.g(var2);
         cq[] var5 = cq.values();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            cq var8 = var5[var7];
            var1.c((cj)var2.a(var8), (afh)this);
         }

      }
   }

   protected abstract alz e(alz var1);

   protected agd(boolean var1) {
      super(arm.q);
      this.N = var1;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.125F, 1.0F);
   }

   public boolean e(adm var1, cj var2) {
      return adm.a((adq)var1, (cj)var2.b());
   }

   public boolean i() {
      return true;
   }

   protected int a(adq var1, cj var2, alz var3) {
      return 15;
   }

   protected abstract int d(alz var1);

   protected boolean e(adm var1, cj var2, alz var3) {
      return this.f(var1, var2, var3) > 0;
   }

   public boolean d() {
      return false;
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(O, var8.aP().d());
   }

   public boolean c() {
      return false;
   }

   public boolean b(afh var1) {
      return this.e(var1);
   }

   public boolean d(adm var1, cj var2) {
      return adm.a((adq)var1, (cj)var2.b()) ? super.d(var1, var2) : false;
   }

   public boolean i(adm var1, cj var2, alz var3) {
      cq var4 = ((cq)var3.b(O)).d();
      cj var5 = var2.a(var4);
      if (d(var1.p(var5).c())) {
         return var1.p(var5).b(O) != var4;
      } else {
         return false;
      }
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      if (!this.l(var3)) {
         return 0;
      } else {
         return var3.b(O) == var4 ? this.a(var1, var2, var3) : 0;
      }
   }

   protected int f(adm var1, cj var2, alz var3) {
      cq var4 = (cq)var3.b(O);
      cj var5 = var2.a(var4);
      int var6 = var1.c(var5, var4);
      if (var6 >= 15) {
         return var6;
      } else {
         alz var7 = var1.p(var5);
         return Math.max(var6, var7.c() == afi.af ? (Integer)var7.b(ajb.P) : 0);
      }
   }

   public static boolean d(afh var0) {
      return afi.bb.e(var0) || afi.cj.e(var0);
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return var3.k() != cq.a.b;
   }

   protected void h(adm var1, cj var2, alz var3) {
      cq var4 = (cq)var3.b(O);
      cj var5 = var2.a(var4.d());
      var1.d(var5, this);
      var1.a((cj)var5, (afh)this, (cq)var4);
   }

   protected void g(adm var1, cj var2, alz var3) {
      if (!this.b(var1, var2, var3)) {
         boolean var4 = this.e(var1, var2, var3);
         if ((this.N && !var4 || !this.N && var4) && !var1.a((cj)var2, (afh)this)) {
            byte var5 = -1;
            if (this.i(var1, var2, var3)) {
               var5 = -3;
            } else if (this.N) {
               var5 = -2;
            }

            var1.a(var2, this, this.d(var3), var5);
         }

      }
   }

   public int b(adq var1, cj var2, alz var3, cq var4) {
      return this.a(var1, var2, var3, var4);
   }

   protected boolean l(alz var1) {
      return this.N;
   }

   protected boolean c(afh var1) {
      return var1.i();
   }

   public void d(adm var1, cj var2, alz var3) {
      if (this.N) {
         cq[] var4 = cq.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            cq var7 = var4[var6];
            var1.c((cj)var2.a(var7), (afh)this);
         }
      }

      super.d(var1, var2, var3);
   }

   public boolean b(adq var1, cj var2, alz var3) {
      return false;
   }

   public boolean e(afh var1) {
      return var1 == this.e(this.Q()).c() || var1 == this.k(this.Q()).c();
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!this.b(var1, var2, var3)) {
         boolean var5 = this.e(var1, var2, var3);
         if (this.N && !var5) {
            var1.a((cj)var2, (alz)this.k(var3), 2);
         } else if (!this.N) {
            var1.a((cj)var2, (alz)this.e(var3), 2);
            if (!var5) {
               var1.a(var2, this.e(var3).c(), this.m(var3), -1);
            }
         }

      }
   }

   public void c(adm var1, cj var2, alz var3) {
      this.h(var1, var2, var3);
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      if (this.e(var1, var2, var3)) {
         var1.a((cj)var2, (afh)this, 1);
      }

   }

   protected int c(adq var1, cj var2, alz var3) {
      cq var4 = (cq)var3.b(O);
      cq var5 = var4.e();
      cq var6 = var4.f();
      return Math.max(this.c(var1, var2.a(var5), var5), this.c(var1, var2.a(var6), var6));
   }
}
