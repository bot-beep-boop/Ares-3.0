public class bda {
   private int g;
   private float f;
   private adp.a i;
   private zx d;
   private final bcy b;
   private cj c = new cj(-1, -1, -1);
   private float e;
   private boolean h;
   private final ave a;
   private int j;

   public void a(wn var1, pk var2) {
      this.n();
      this.b.a((ff)(new in(var2, in.a.b)));
      if (this.i != adp.a.e) {
         var1.f(var2);
      }

   }

   public void a(wn var1) {
      this.i.a(var1.bA);
   }

   public boolean a(bew var1, bdb var2, zx var3, cj var4, cq var5, aui var6) {
      this.n();
      float var7 = (float)(var6.a - (double)var4.n());
      float var8 = (float)(var6.b - (double)var4.o());
      float var9 = (float)(var6.c - (double)var4.p());
      boolean var10 = false;
      if (!this.a.f.af().a(var4)) {
         return false;
      } else {
         if (this.i != adp.a.e) {
            alz var11 = var2.p(var4);
            if ((!var1.av() || var1.bA() == null) && var11.c().a(var2, var4, var11, var1, var5, var7, var8, var9)) {
               var10 = true;
            }

            if (!var10 && var3 != null && var3.b() instanceof yo) {
               yo var12 = (yo)var3.b();
               if (!var12.a(var2, var4, var5, var1, var3)) {
                  return false;
               }
            }
         }

         this.b.a((ff)(new ja(var4, var5.a(), var1.bi.h(), var7, var8, var9)));
         if (!var10 && this.i != adp.a.e) {
            if (var3 == null) {
               return false;
            } else if (this.i.d()) {
               int var14 = var3.i();
               int var15 = var3.b;
               boolean var13 = var3.a(var1, var2, var4, var5, var7, var8, var9);
               var3.b(var14);
               var3.b = var15;
               return var13;
            } else {
               return var3.a(var1, var2, var4, var5, var7, var8, var9);
            }
         } else {
            return true;
         }
      }
   }

   public boolean h() {
      return this.i.d();
   }

   public boolean f() {
      return this.i.e();
   }

   public boolean i() {
      return this.i.d();
   }

   public bew a(adm var1, nb var2) {
      return new bew(this.a, var1, this.b, var2);
   }

   public boolean b(cj var1, cq var2) {
      afh var3;
      if (this.i.c()) {
         if (this.i == adp.a.e) {
            return false;
         }

         if (!this.a.h.cn()) {
            var3 = this.a.f.p(var1).c();
            zx var4 = this.a.h.bZ();
            if (var4 == null) {
               return false;
            }

            if (!var4.c(var3)) {
               return false;
            }
         }
      }

      if (!this.a.f.af().a(var1)) {
         return false;
      } else {
         if (this.i.d()) {
            this.b.a((ff)(new ir(ir.a.a, var1, var2)));
            a(this.a, this, var1, var2);
            this.g = 5;
         } else if (!this.h || !this.a(var1)) {
            if (this.h) {
               this.b.a((ff)(new ir(ir.a.b, this.c, var2)));
            }

            this.b.a((ff)(new ir(ir.a.a, var1, var2)));
            var3 = this.a.f.p(var1).c();
            boolean var5 = var3.t() != arm.a;
            if (var5 && this.e == 0.0F) {
               var3.a((adm)this.a.f, (cj)var1, (wn)this.a.h);
            }

            if (var5 && var3.a((wn)this.a.h, (adm)this.a.h.o, (cj)var1) >= 1.0F) {
               this.a(var1, var2);
            } else {
               this.h = true;
               this.c = var1;
               this.d = this.a.h.bA();
               this.e = 0.0F;
               this.f = 0.0F;
               this.a.f.c(this.a.h.F(), this.c, (int)(this.e * 10.0F) - 1);
            }
         }

         return true;
      }
   }

   public boolean g() {
      return !this.i.d();
   }

   public void a(int var1, int var2) {
      this.b.a((ff)(new ij(var1, var2)));
   }

   public float d() {
      return this.i.d() ? 5.0F : 4.5F;
   }

   public boolean a(cj var1, cq var2) {
      if (this.i.c()) {
         if (this.i == adp.a.e) {
            return false;
         }

         if (!this.a.h.cn()) {
            afh var3 = this.a.f.p(var1).c();
            zx var4 = this.a.h.bZ();
            if (var4 == null) {
               return false;
            }

            if (!var4.c(var3)) {
               return false;
            }
         }
      }

      if (this.i.d() && this.a.h.bA() != null && this.a.h.bA().b() instanceof aay) {
         return false;
      } else {
         bdb var8 = this.a.f;
         alz var9 = var8.p(var1);
         afh var5 = var9.c();
         if (var5.t() == arm.a) {
            return false;
         } else {
            var8.b(2001, var1, afh.f(var9));
            boolean var6 = var8.g(var1);
            if (var6) {
               var5.d(var8, var1, var9);
            }

            this.c = new cj(this.c.n(), -1, this.c.p());
            if (!this.i.d()) {
               zx var7 = this.a.h.bZ();
               if (var7 != null) {
                  var7.a(var8, var5, var1, this.a.h);
                  if (var7.b == 0) {
                     this.a.h.ca();
                  }
               }
            }

            return var6;
         }
      }
   }

   public void e() {
      this.n();
      if (this.b.a().g()) {
         this.b.a().a();
      } else {
         this.b.a().l();
      }

   }

   public boolean k() {
      return this.i == adp.a.e;
   }

   public void c(wn var1) {
      this.n();
      this.b.a((ff)(new ir(ir.a.f, cj.a, cq.a)));
      var1.bU();
   }

   public void a(zx var1) {
      if (this.i.d() && var1 != null) {
         this.b.a((ff)(new iw(-1, var1)));
      }

   }

   public boolean b() {
      return this.i.e();
   }

   public void c() {
      if (this.h) {
         this.b.a((ff)(new ir(ir.a.b, this.c, cq.a)));
         this.h = false;
         this.e = 0.0F;
         this.a.f.c(this.a.h.F(), this.c, -1);
      }

   }

   public static void a(ave var0, bda var1, cj var2, cq var3) {
      if (!var0.f.a(var0.h, var2, var3)) {
         var1.a(var2, var3);
      }

   }

   public zx a(int var1, int var2, int var3, int var4, wn var5) {
      short var6 = var5.bk.a(var5.bi);
      zx var7 = var5.bk.a(var2, var3, var4, var5);
      this.b.a((ff)(new ik(var1, var2, var3, var4, var7, var6)));
      return var7;
   }

   public void a(adp.a var1) {
      this.i = var1;
      this.i.a(this.a.h.bA);
   }

   public boolean a() {
      return this.i == adp.a.e;
   }

   public boolean b(wn var1, pk var2) {
      this.n();
      this.b.a((ff)(new in(var2, in.a.a)));
      return this.i != adp.a.e && var1.u(var2);
   }

   public bda(ave var1, bcy var2) {
      this.i = adp.a.b;
      this.a = var1;
      this.b = var2;
   }

   public void b(wn var1) {
      var1.y = -180.0F;
   }

   private void n() {
      int var1 = this.a.h.bi.c;
      if (var1 != this.j) {
         this.j = var1;
         this.b.a((ff)(new iv(this.j)));
      }

   }

   public boolean m() {
      return this.h;
   }

   public boolean a(wn var1, adm var2, zx var3) {
      if (this.i == adp.a.e) {
         return false;
      } else {
         this.n();
         this.b.a((ff)(new ja(var1.bi.h())));
         int var4 = var3.b;
         zx var5 = var3.a(var2, var1);
         if (var5 != var3 || var5 != null && var5.b != var4) {
            var1.bi.a[var1.bi.c] = var5;
            if (var5.b == 0) {
               var1.bi.a[var1.bi.c] = null;
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public boolean a(wn var1, pk var2, auh var3) {
      this.n();
      aui var4 = new aui(var3.c.a - var2.s, var3.c.b - var2.t, var3.c.c - var2.u);
      this.b.a((ff)(new in(var2, var4)));
      return this.i != adp.a.e && var2.a(var1, var4);
   }

   public adp.a l() {
      return this.i;
   }

   public boolean c(cj var1, cq var2) {
      this.n();
      if (this.g > 0) {
         --this.g;
         return true;
      } else if (this.i.d() && this.a.f.af().a(var1)) {
         this.g = 5;
         this.b.a((ff)(new ir(ir.a.a, var1, var2)));
         a(this.a, this, var1, var2);
         return true;
      } else if (this.a(var1)) {
         afh var3 = this.a.f.p(var1).c();
         if (var3.t() == arm.a) {
            this.h = false;
            return false;
         } else {
            this.e += var3.a((wn)this.a.h, (adm)this.a.h.o, (cj)var1);
            if (this.f % 4.0F == 0.0F) {
               this.a.W().a((bpj)(new bpf(new jy(var3.H.c()), (var3.H.d() + 1.0F) / 8.0F, var3.H.e() * 0.5F, (float)var1.n() + 0.5F, (float)var1.o() + 0.5F, (float)var1.p() + 0.5F)));
            }

            ++this.f;
            if (this.e >= 1.0F) {
               this.h = false;
               this.b.a((ff)(new ir(ir.a.c, var1, var2)));
               this.a(var1, var2);
               this.e = 0.0F;
               this.f = 0.0F;
               this.g = 5;
            }

            this.a.f.c(this.a.h.F(), this.c, (int)(this.e * 10.0F) - 1);
            return true;
         }
      } else {
         return this.b(var1, var2);
      }
   }

   public boolean j() {
      return this.a.h.au() && this.a.h.m instanceof tp;
   }

   private boolean a(cj var1) {
      zx var2 = this.a.h.bA();
      boolean var3 = this.d == null && var2 == null;
      if (this.d != null && var2 != null) {
         var3 = var2.b() == this.d.b() && zx.a(var2, this.d) && (var2.e() || var2.i() == this.d.i());
      }

      return var1.equals(this.c) && var3;
   }

   public void a(zx var1, int var2) {
      if (this.i.d()) {
         this.b.a((ff)(new iw(var2, var1)));
      }

   }
}
