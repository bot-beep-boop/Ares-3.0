import java.util.List;

public class um extends pr {
   private dc bo;
   private dc bl;
   private dc bn;
   private static final dc e = new dc(-1.0F, 0.0F, -1.0F);
   private final zx[] g;
   private dc bm;
   private dc bp;
   private int bi;
   private boolean h;
   private static final dc a = new dc(0.0F, 0.0F, 0.0F);
   private boolean bj;
   private static final dc c = new dc(-10.0F, 0.0F, -10.0F);
   private long i;
   private static final dc d = new dc(-15.0F, 0.0F, 10.0F);
   private dc bk;
   private static final dc f = new dc(1.0F, 0.0F, 1.0F);
   private static final dc b = new dc(0.0F, 0.0F, 0.0F);

   public dc u() {
      return this.bl;
   }

   private void j(boolean var1) {
      byte var2 = this.ac.a(10);
      if (var1) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.ac.b(10, var2);
   }

   protected void B() {
      this.e(this.h);
   }

   protected void h() {
      super.h();
      this.ac.a(10, (byte)0);
      this.ac.a(11, a);
      this.ac.a(12, b);
      this.ac.a(13, c);
      this.ac.a(14, d);
      this.ac.a(15, e);
      this.ac.a(16, f);
   }

   public void d(dc var1) {
      this.bn = var1;
      this.ac.b(14, var1);
   }

   public dc y() {
      return this.bp;
   }

   public zx[] as() {
      return this.g;
   }

   public boolean q() {
      return (this.ac.a(10) & 4) != 0;
   }

   public void f(dc var1) {
      this.bp = var1;
      this.ac.b(16, var1);
   }

   public float aS() {
      return this.j_() ? this.K * 0.5F : this.K * 0.9F;
   }

   public void g(float var1, float var2) {
      if (!this.p()) {
         super.g(var1, var2);
      }
   }

   protected void s(pk var1) {
   }

   private void a(wn var1, int var2) {
      zx var3 = this.g[var2];
      if (var3 == null || (this.bi & 1 << var2 + 8) == 0) {
         if (var3 != null || (this.bi & 1 << var2 + 16) == 0) {
            int var4 = var1.bi.c;
            zx var5 = var1.bi.a(var4);
            zx var6;
            if (var1.bA.d && (var3 == null || var3.b() == zw.a(afi.a)) && var5 != null) {
               var6 = var5.k();
               var6.b = 1;
               this.c(var2, var6);
            } else if (var5 != null && var5.b > 1) {
               if (var3 == null) {
                  var6 = var5.k();
                  var6.b = 1;
                  this.c(var2, var6);
                  --var5.b;
               }
            } else {
               this.c(var2, var5);
               var1.bi.a(var4, var3);
            }
         }
      }
   }

   public void e(boolean var1) {
      this.h = var1;
      super.e(var1);
   }

   public boolean bM() {
      return super.bM() && !this.p();
   }

   private void A() {
      if (this.o instanceof le) {
         ((le)this.o).a(cy.M, this.s, this.t + (double)this.K / 1.5D, this.u, 10, (double)(this.J / 4.0F), (double)(this.K / 4.0F), (double)(this.J / 4.0F), 0.05D, afh.f(afi.f.Q()));
      }

   }

   public boolean s() {
      return (this.ac.a(10) & 16) != 0;
   }

   protected float h(float var1, float var2) {
      this.aJ = this.A;
      this.aI = this.y;
      return 0.0F;
   }

   public void a(dc var1) {
      this.bk = var1;
      this.ac.b(11, var1);
   }

   public dc w() {
      return this.bn;
   }

   public boolean aW() {
      return this.ax();
   }

   public boolean n() {
      return (this.ac.a(10) & 1) != 0;
   }

   public dc x() {
      return this.bo;
   }

   public boolean a(wn var1, aui var2) {
      if (this.s()) {
         return false;
      } else if (!this.o.D && !var1.v()) {
         byte var3 = 0;
         zx var4 = var1.bZ();
         boolean var5 = var4 != null;
         if (var5 && var4.b() instanceof yj) {
            yj var6 = (yj)var4.b();
            if (var6.b == 3) {
               var3 = 1;
            } else if (var6.b == 2) {
               var3 = 2;
            } else if (var6.b == 1) {
               var3 = 3;
            } else if (var6.b == 0) {
               var3 = 4;
            }
         }

         if (var5 && (var4.b() == zy.bX || var4.b() == zw.a(afi.aU))) {
            var3 = 4;
         }

         double var19 = 0.1D;
         double var8 = 0.9D;
         double var10 = 0.4D;
         double var12 = 1.6D;
         byte var14 = 0;
         boolean var15 = this.n();
         double var16 = var15 ? var2.b * 2.0D : var2.b;
         if (var16 >= 0.1D && var16 < 0.1D + (var15 ? 0.8D : 0.45D) && this.g[1] != null) {
            var14 = 1;
         } else if (var16 >= 0.9D + (var15 ? 0.3D : 0.0D) && var16 < 0.9D + (var15 ? 1.0D : 0.7D) && this.g[3] != null) {
            var14 = 3;
         } else if (var16 >= 0.4D && var16 < 0.4D + (var15 ? 1.0D : 0.8D) && this.g[2] != null) {
            var14 = 2;
         } else if (var16 >= 1.6D && this.g[4] != null) {
            var14 = 4;
         }

         boolean var18 = this.g[var14] != null;
         if ((this.bi & 1 << var14) != 0 || (this.bi & 1 << var3) != 0) {
            var14 = var3;
            if ((this.bi & 1 << var3) != 0) {
               if ((this.bi & 1) != 0) {
                  return true;
               }

               var14 = 0;
            }
         }

         if (var5 && var3 == 0 && !this.q()) {
            return true;
         } else {
            if (var5) {
               this.a(var1, var3);
            } else if (var18) {
               this.a(var1, var14);
            }

            return true;
         }
      } else {
         return true;
      }
   }

   public boolean ae() {
      return false;
   }

   public um(adm var1) {
      super(var1);
      this.g = new zx[5];
      this.bk = a;
      this.bl = b;
      this.bm = c;
      this.bn = d;
      this.bo = e;
      this.bp = f;
      this.b(true);
      this.T = this.p();
      this.a(0.5F, 1.975F);
   }

   public void e(dc var1) {
      this.bo = var1;
      this.ac.b(15, var1);
   }

   private void a(boolean var1) {
      double var2 = this.s;
      double var4 = this.t;
      double var6 = this.u;
      if (var1) {
         this.a(0.5F, 1.975F);
      } else {
         this.a(0.0F, 0.0F);
      }

      this.b(var2, var4, var6);
   }

   public boolean a(double var1) {
      double var3 = this.aR().a() * 4.0D;
      if (Double.isNaN(var3) || var3 == 0.0D) {
         var3 = 4.0D;
      }

      var3 *= 64.0D;
      return var1 < var3 * var3;
   }

   public void G() {
      this.J();
   }

   private void h(dn var1) {
      du var2 = var1.c("Head", 5);
      if (var2.c() > 0) {
         this.a(new dc(var2));
      } else {
         this.a(a);
      }

      du var3 = var1.c("Body", 5);
      if (var3.c() > 0) {
         this.b(new dc(var3));
      } else {
         this.b(b);
      }

      du var4 = var1.c("LeftArm", 5);
      if (var4.c() > 0) {
         this.c(new dc(var4));
      } else {
         this.c(c);
      }

      du var5 = var1.c("RightArm", 5);
      if (var5.c() > 0) {
         this.d(new dc(var5));
      } else {
         this.d(d);
      }

      du var6 = var1.c("LeftLeg", 5);
      if (var6.c() > 0) {
         this.e(new dc(var6));
      } else {
         this.e(e);
      }

      du var7 = var1.c("RightLeg", 5);
      if (var7.c() > 0) {
         this.f(new dc(var7));
      } else {
         this.f(f);
      }

   }

   private void l(boolean var1) {
      byte var2 = this.ac.a(10);
      if (var1) {
         var2 = (byte)(var2 | 4);
      } else {
         var2 &= -5;
      }

      this.ac.b(10, var2);
   }

   private void n(boolean var1) {
      byte var2 = this.ac.a(10);
      if (var1) {
         var2 = (byte)(var2 | 16);
      } else {
         var2 &= -17;
      }

      this.ac.b(10, var2);
   }

   public boolean j_() {
      return this.n();
   }

   public void t_() {
      super.t_();
      dc var1 = this.ac.h(11);
      if (!this.bk.equals(var1)) {
         this.a(var1);
      }

      dc var2 = this.ac.h(12);
      if (!this.bl.equals(var2)) {
         this.b(var2);
      }

      dc var3 = this.ac.h(13);
      if (!this.bm.equals(var3)) {
         this.c(var3);
      }

      dc var4 = this.ac.h(14);
      if (!this.bn.equals(var4)) {
         this.d(var4);
      }

      dc var5 = this.ac.h(15);
      if (!this.bo.equals(var5)) {
         this.e(var5);
      }

      dc var6 = this.ac.h(16);
      if (!this.bp.equals(var6)) {
         this.f(var6);
      }

      boolean var7 = this.s();
      if (!this.bj && var7) {
         this.a(false);
      } else {
         if (!this.bj || var7) {
            return;
         }

         this.a(true);
      }

      this.bj = var7;
   }

   private void m(boolean var1) {
      byte var2 = this.ac.a(10);
      if (var1) {
         var2 = (byte)(var2 | 8);
      } else {
         var2 &= -9;
      }

      this.ac.b(10, var2);
   }

   public boolean p() {
      return (this.ac.a(10) & 2) != 0;
   }

   public boolean a(ow var1, float var2) {
      if (this.o.D) {
         return false;
      } else if (ow.j.equals(var1)) {
         this.J();
         return false;
      } else if (!this.b((ow)var1) && !this.h && !this.s()) {
         if (var1.c()) {
            this.D();
            this.J();
            return false;
         } else if (ow.a.equals(var1)) {
            if (!this.at()) {
               this.e(5);
            } else {
               this.a(0.15F);
            }

            return false;
         } else if (ow.c.equals(var1) && this.bn() > 0.5F) {
            this.a(4.0F);
            return false;
         } else {
            boolean var3 = "arrow".equals(var1.p());
            boolean var4 = "player".equals(var1.p());
            if (!var4 && !var3) {
               return false;
            } else {
               if (var1.i() instanceof wq) {
                  var1.i().J();
               }

               if (var1.j() instanceof wn && !((wn)var1.j()).bA.e) {
                  return false;
               } else if (var1.u()) {
                  this.A();
                  this.J();
                  return false;
               } else {
                  long var5 = this.o.K();
                  if (var5 - this.i > 5L && !var3) {
                     this.i = var5;
                  } else {
                     this.C();
                     this.A();
                     this.J();
                  }

                  return false;
               }
            }
         }
      } else {
         return false;
      }
   }

   public zx q(int var1) {
      return this.g[var1 + 1];
   }

   protected void bL() {
      List var1 = this.o.b((pk)this, (aug)this.aR());
      if (var1 != null && !var1.isEmpty()) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            pk var3 = (pk)var1.get(var2);
            if (var3 instanceof va && ((va)var3).s() == va.a.a && this.h(var3) <= 0.2D) {
               var3.i(this);
            }
         }
      }

   }

   public boolean r() {
      return (this.ac.a(10) & 8) != 0;
   }

   public void b(dn var1) {
      super.b(var1);
      du var2 = new du();

      for(int var3 = 0; var3 < this.g.length; ++var3) {
         dn var4 = new dn();
         if (this.g[var3] != null) {
            this.g[var3].b(var4);
         }

         var2.a((eb)var4);
      }

      var1.a((String)"Equipment", (eb)var2);
      if (this.aN() && (this.aM() == null || this.aM().length() == 0)) {
         var1.a("CustomNameVisible", this.aN());
      }

      var1.a("Invisible", this.ax());
      var1.a("Small", this.n());
      var1.a("ShowArms", this.q());
      var1.a("DisabledSlots", this.bi);
      var1.a("NoGravity", this.p());
      var1.a("NoBasePlate", this.r());
      if (this.s()) {
         var1.a("Marker", this.s());
      }

      var1.a((String)"Pose", (eb)this.z());
   }

   private void C() {
      afh.a(this.o, new cj(this), new zx(zy.cj));
      this.D();
   }

   private dn z() {
      dn var1 = new dn();
      if (!a.equals(this.bk)) {
         var1.a((String)"Head", (eb)this.bk.a());
      }

      if (!b.equals(this.bl)) {
         var1.a((String)"Body", (eb)this.bl.a());
      }

      if (!c.equals(this.bm)) {
         var1.a((String)"LeftArm", (eb)this.bm.a());
      }

      if (!d.equals(this.bn)) {
         var1.a((String)"RightArm", (eb)this.bn.a());
      }

      if (!e.equals(this.bo)) {
         var1.a((String)"LeftLeg", (eb)this.bo.a());
      }

      if (!f.equals(this.bp)) {
         var1.a((String)"RightLeg", (eb)this.bp.a());
      }

      return var1;
   }

   private void a(float var1) {
      float var2 = this.bn();
      var2 -= var1;
      if (var2 <= 0.5F) {
         this.D();
         this.J();
      } else {
         this.i(var2);
      }

   }

   private void k(boolean var1) {
      byte var2 = this.ac.a(10);
      if (var1) {
         var2 = (byte)(var2 | 2);
      } else {
         var2 &= -3;
      }

      this.ac.b(10, var2);
   }

   public boolean d(int var1, zx var2) {
      int var3;
      if (var1 == 99) {
         var3 = 0;
      } else {
         var3 = var1 - 100 + 1;
         if (var3 < 0 || var3 >= this.g.length) {
            return false;
         }
      }

      if (var2 != null && ps.c(var2) != var3 && (var3 != 4 || !(var2.b() instanceof yo))) {
         return false;
      } else {
         this.c(var3, var2);
         return true;
      }
   }

   public dc v() {
      return this.bm;
   }

   public void b(dc var1) {
      this.bl = var1;
      this.ac.b(12, var1);
   }

   private void D() {
      for(int var1 = 0; var1 < this.g.length; ++var1) {
         if (this.g[var1] != null && this.g[var1].b > 0) {
            if (this.g[var1] != null) {
               afh.a(this.o, (new cj(this)).a(), this.g[var1]);
            }

            this.g[var1] = null;
         }
      }

   }

   public zx bA() {
      return this.g[0];
   }

   public void c(int var1, zx var2) {
      this.g[var1] = var2;
   }

   public dc t() {
      return this.bk;
   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.b("Equipment", 9)) {
         du var2 = var1.c("Equipment", 10);

         for(int var3 = 0; var3 < this.g.length; ++var3) {
            this.g[var3] = zx.a(var2.b(var3));
         }
      }

      this.e(var1.n("Invisible"));
      this.j(var1.n("Small"));
      this.l(var1.n("ShowArms"));
      this.bi = var1.f("DisabledSlots");
      this.k(var1.n("NoGravity"));
      this.m(var1.n("NoBasePlate"));
      this.n(var1.n("Marker"));
      this.bj = !this.s();
      this.T = this.p();
      dn var4 = var1.m("Pose");
      this.h(var4);
   }

   public zx p(int var1) {
      return this.g[var1];
   }

   public boolean ad() {
      return super.ad() && !this.s();
   }

   public void c(dc var1) {
      this.bm = var1;
      this.ac.b(13, var1);
   }

   public um(adm var1, double var2, double var4, double var6) {
      this(var1);
      this.b(var2, var4, var6);
   }
}
