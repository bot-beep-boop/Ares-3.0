public class lg {
   private boolean h;
   private int k;
   private int g;
   private cj i;
   private int j;
   private cj f;
   private adp.a c;
   private boolean d;
   private int e;
   public adm a;
   public lf b;

   public void a() {
      ++this.g;
      float var3;
      int var4;
      if (this.h) {
         int var1 = this.g - this.j;
         afh var2 = this.a.p(this.i).c();
         if (var2.t() == arm.a) {
            this.h = false;
         } else {
            var3 = var2.a((wn)this.b, (adm)this.b.o, (cj)this.i) * (float)(var1 + 1);
            var4 = (int)(var3 * 10.0F);
            if (var4 != this.k) {
               this.a.c(this.b.F(), this.i, var4);
               this.k = var4;
            }

            if (var3 >= 1.0F) {
               this.h = false;
               this.b(this.i);
            }
         }
      } else if (this.d) {
         afh var5 = this.a.p(this.f).c();
         if (var5.t() == arm.a) {
            this.a.c(this.b.F(), this.f, -1);
            this.k = -1;
            this.d = false;
         } else {
            int var6 = this.g - this.e;
            var3 = var5.a((wn)this.b, (adm)this.b.o, (cj)this.i) * (float)(var6 + 1);
            var4 = (int)(var3 * 10.0F);
            if (var4 != this.k) {
               this.a.c(this.b.F(), this.f, var4);
               this.k = var4;
            }
         }
      }

   }

   public adp.a b() {
      return this.c;
   }

   public boolean a(wn var1, adm var2, zx var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (this.c == adp.a.e) {
         akw var13 = var2.s(var4);
         if (var13 instanceof oo) {
            afh var14 = var2.p(var4).c();
            oo var15 = (oo)var13;
            if (var15 instanceof aky && var14 instanceof afs) {
               var15 = ((afs)var14).f(var2, var4);
            }

            if (var15 != null) {
               var1.a((og)var15);
               return true;
            }
         } else if (var13 instanceof og) {
            var1.a((og)var13);
            return true;
         }

         return false;
      } else {
         if (!var1.av() || var1.bA() == null) {
            alz var9 = var2.p(var4);
            if (var9.c().a(var2, var4, var9, var1, var5, var6, var7, var8)) {
               return true;
            }
         }

         if (var3 == null) {
            return false;
         } else if (this.d()) {
            int var12 = var3.i();
            int var10 = var3.b;
            boolean var11 = var3.a(var1, var2, var4, var5, var6, var7, var8);
            var3.b(var12);
            var3.b = var10;
            return var11;
         } else {
            return var3.a(var1, var2, var4, var5, var6, var7, var8);
         }
      }
   }

   public boolean c() {
      return this.c.e();
   }

   public void a(cj var1, cq var2) {
      if (this.d()) {
         if (!this.a.a((wn)null, (cj)var1, (cq)var2)) {
            this.b(var1);
         }

      } else {
         afh var3 = this.a.p(var1).c();
         if (this.c.c()) {
            if (this.c == adp.a.e) {
               return;
            }

            if (!this.b.cn()) {
               zx var4 = this.b.bZ();
               if (var4 == null) {
                  return;
               }

               if (!var4.c(var3)) {
                  return;
               }
            }
         }

         this.a.a((wn)null, (cj)var1, (cq)var2);
         this.e = this.g;
         float var6 = 1.0F;
         if (var3.t() != arm.a) {
            var3.a((adm)this.a, (cj)var1, (wn)this.b);
            var6 = var3.a((wn)this.b, (adm)this.b.o, (cj)var1);
         }

         if (var3.t() != arm.a && var6 >= 1.0F) {
            this.b(var1);
         } else {
            this.d = true;
            this.f = var1;
            int var5 = (int)(var6 * 10.0F);
            this.a.c(this.b.F(), var1, var5);
            this.k = var5;
         }

      }
   }

   public boolean b(cj var1) {
      if (this.c.d() && this.b.bA() != null && this.b.bA().b() instanceof aay) {
         return false;
      } else {
         alz var2 = this.a.p(var1);
         akw var3 = this.a.s(var1);
         if (this.c.c()) {
            if (this.c == adp.a.e) {
               return false;
            }

            if (!this.b.cn()) {
               zx var4 = this.b.bZ();
               if (var4 == null) {
                  return false;
               }

               if (!var4.c(var2.c())) {
                  return false;
               }
            }
         }

         this.a.a(this.b, 2001, var1, afh.f(var2));
         boolean var7 = this.c(var1);
         if (this.d()) {
            this.b.a.a((ff)(new fv(this.a, var1)));
         } else {
            zx var5 = this.b.bZ();
            boolean var6 = this.b.b((afh)var2.c());
            if (var5 != null) {
               var5.a(this.a, var2.c(), var1, this.b);
               if (var5.b == 0) {
                  this.b.ca();
               }
            }

            if (var7 && var6) {
               var2.c().a(this.a, (wn)this.b, (cj)var1, (alz)var2, (akw)var3);
            }
         }

         return var7;
      }
   }

   public boolean d() {
      return this.c.d();
   }

   private boolean c(cj var1) {
      alz var2 = this.a.p(var1);
      var2.c().a((adm)this.a, var1, (alz)var2, (wn)this.b);
      boolean var3 = this.a.g(var1);
      if (var3) {
         var2.c().d(this.a, var1, var2);
      }

      return var3;
   }

   public void a(cj var1) {
      if (var1.equals(this.f)) {
         int var2 = this.g - this.e;
         afh var3 = this.a.p(var1).c();
         if (var3.t() != arm.a) {
            float var4 = var3.a((wn)this.b, (adm)this.b.o, (cj)var1) * (float)(var2 + 1);
            if (var4 >= 0.7F) {
               this.d = false;
               this.a.c(this.b.F(), var1, -1);
               this.b(var1);
            } else if (!this.h) {
               this.d = false;
               this.h = true;
               this.i = var1;
               this.j = this.e;
            }
         }
      }

   }

   public void e() {
      this.d = false;
      this.a.c(this.b.F(), this.f, -1);
   }

   public lg(adm var1) {
      this.c = adp.a.a;
      this.f = cj.a;
      this.i = cj.a;
      this.k = -1;
      this.a = var1;
   }

   public void a(adp.a var1) {
      this.c = var1;
      var1.a(this.b.bA);
      this.b.t();
      this.b.b.ap().a((ff)(new gz(gz.a.b, new lf[]{this.b})));
   }

   public void a(le var1) {
      this.a = var1;
   }

   public boolean a(wn var1, adm var2, zx var3) {
      if (this.c == adp.a.e) {
         return false;
      } else {
         int var4 = var3.b;
         int var5 = var3.i();
         zx var6 = var3.a(var2, var1);
         if (var6 == var3 && (var6 == null || var6.b == var4 && var6.l() <= 0 && var6.i() == var5)) {
            return false;
         } else {
            var1.bi.a[var1.bi.c] = var6;
            if (this.d()) {
               var6.b = var4;
               if (var6.e()) {
                  var6.b(var5);
               }
            }

            if (var6.b == 0) {
               var1.bi.a[var1.bi.c] = null;
            }

            if (!var1.bS()) {
               ((lf)var1).a(var1.bj);
            }

            return true;
         }
      }
   }

   public void b(adp.a var1) {
      if (this.c == adp.a.a) {
         this.c = var1;
      }

      this.a(this.c);
   }
}
