import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.List;

public class vt extends vv {
   private float b;
   private float bn;
   private float c;
   private pr bo;
   private boolean bq;
   private int bp;
   private rz br;
   private float bm;
   private float a;

   protected String bp() {
      if (!this.V()) {
         return "mob.guardian.land.death";
      } else {
         return this.cn() ? "mob.guardian.elder.death" : "mob.guardian.death";
      }
   }

   protected String bo() {
      if (!this.V()) {
         return "mob.guardian.land.hit";
      } else {
         return this.cn() ? "mob.guardian.elder.hit" : "mob.guardian.hit";
      }
   }

   public int cm() {
      return this.cn() ? 60 : 80;
   }

   public boolean cp() {
      return this.ac.c(17) != 0;
   }

   protected boolean n_() {
      return true;
   }

   private void l(boolean var1) {
      this.a(2, var1);
   }

   public void m() {
      if (this.o.D) {
         this.b = this.a;
         if (!this.V()) {
            this.c = 2.0F;
            if (this.w > 0.0D && this.bq && !this.R()) {
               this.o.a(this.s, this.t, this.u, "mob.guardian.flop", 1.0F, 1.0F, false);
            }

            this.bq = this.w < 0.0D && this.o.d((new cj(this)).b(), false);
         } else if (this.n()) {
            if (this.c < 0.5F) {
               this.c = 4.0F;
            } else {
               this.c += (0.5F - this.c) * 0.1F;
            }
         } else {
            this.c += (0.125F - this.c) * 0.2F;
         }

         this.a += this.c;
         this.bn = this.bm;
         if (!this.V()) {
            this.bm = this.V.nextFloat();
         } else if (this.n()) {
            this.bm += (0.0F - this.bm) * 0.25F;
         } else {
            this.bm += (1.0F - this.bm) * 0.06F;
         }

         if (this.n() && this.V()) {
            aui var1 = this.d(0.0F);

            for(int var2 = 0; var2 < 2; ++var2) {
               this.o.a(cy.e, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J - var1.a * 1.5D, this.t + this.V.nextDouble() * (double)this.K - var1.b * 1.5D, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J - var1.c * 1.5D, 0.0D, 0.0D, 0.0D);
            }
         }

         if (this.cp()) {
            if (this.bp < this.cm()) {
               ++this.bp;
            }

            pr var14 = this.cq();
            if (var14 != null) {
               this.p().a(var14, 90.0F, 90.0F);
               this.p().a();
               double var15 = (double)this.q(0.0F);
               double var4 = var14.s - this.s;
               double var6 = var14.t + (double)(var14.K * 0.5F) - (this.t + (double)this.aS());
               double var8 = var14.u - this.u;
               double var10 = Math.sqrt(var4 * var4 + var6 * var6 + var8 * var8);
               var4 /= var10;
               var6 /= var10;
               var8 /= var10;
               double var12 = this.V.nextDouble();

               while(var12 < var10) {
                  var12 += 1.8D - var15 + this.V.nextDouble() * (1.7D - var15);
                  this.o.a(cy.e, this.s + var4 * var12, this.t + var6 * var12 + (double)this.aS(), this.u + var8 * var12, 0.0D, 0.0D, 0.0D);
               }
            }
         }
      }

      if (this.Y) {
         this.h(300);
      } else if (this.C) {
         this.w += 0.5D;
         this.v += (double)((this.V.nextFloat() * 2.0F - 1.0F) * 0.4F);
         this.x += (double)((this.V.nextFloat() * 2.0F - 1.0F) * 0.4F);
         this.y = this.V.nextFloat() * 360.0F;
         this.C = false;
         this.ai = true;
      }

      if (this.cp()) {
         this.y = this.aK;
      }

      super.m();
   }

   static void a(vt var0, int var1) {
      var0.b(var1);
   }

   public void i(int var1) {
      super.i(var1);
      if (var1 == 16) {
         if (this.cn() && this.J < 1.0F) {
            this.a(1.9975F, 1.9975F);
         }
      } else if (var1 == 17) {
         this.bp = 0;
         this.bo = null;
      }

   }

   protected String z() {
      if (!this.V()) {
         return "mob.guardian.land.idle";
      } else {
         return this.cn() ? "mob.guardian.elder.idle" : "mob.guardian.idle";
      }
   }

   public vt(adm var1) {
      super(var1);
      this.b_ = 10;
      this.a(0.85F, 0.85F);
      this.i.a(4, new vt.a(this));
      rp var2;
      this.i.a(5, var2 = new rp(this, 1.0D));
      this.i.a(7, this.br = new rz(this, 1.0D, 80));
      this.i.a(8, new ri(this, wn.class, 8.0F));
      this.i.a(8, new ri(this, vt.class, 12.0F, 0.01F));
      this.i.a(9, new ry(this));
      this.br.a(3);
      var2.a(3);
      this.bi.a(1, new sp(this, pr.class, 10, true, false, new vt.b(this)));
      this.f = new vt.c(this);
      this.b = this.a = this.V.nextFloat();
   }

   static rz a(vt var0) {
      return var0.br;
   }

   private boolean a(int var1) {
      return (this.ac.c(16) & var1) != 0;
   }

   public boolean n() {
      return this.a(2);
   }

   private void b(int var1) {
      this.ac.b(17, var1);
   }

   protected sw b(adm var1) {
      return new sy(this, var1);
   }

   public boolean bR() {
      return (this.V.nextInt(20) == 0 || !this.o.j(new cj(this))) && super.bR();
   }

   public boolean cn() {
      return this.a(4);
   }

   public boolean bS() {
      return this.o.a((aug)this.aR(), (pk)this) && this.o.a((pk)this, (aug)this.aR()).isEmpty();
   }

   public float q(float var1) {
      return ((float)this.bp + var1) / (float)this.cm();
   }

   public boolean a(ow var1, float var2) {
      if (!this.n() && !var1.s() && var1.i() instanceof pr) {
         pr var3 = (pr)var1.i();
         if (!var1.c()) {
            var3.a(ow.a((pk)this), 2.0F);
            var3.a("damage.thorns", 0.5F, 1.0F);
         }
      }

      this.br.f();
      return super.a(var1, var2);
   }

   private void a(int var1, boolean var2) {
      int var3 = this.ac.c(16);
      if (var2) {
         this.ac.b(16, var3 | var1);
      } else {
         this.ac.b(16, var3 & ~var1);
      }

   }

   public void co() {
      this.a(true);
      this.bn = this.bm = 1.0F;
   }

   public void a(boolean var1) {
      this.a(4, var1);
      if (var1) {
         this.a(1.9975F, 1.9975F);
         this.a((qb)vy.d).a(0.30000001192092896D);
         this.a((qb)vy.e).a(8.0D);
         this.a((qb)vy.a).a(80.0D);
         this.bX();
         this.br.b(400);
      }

   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Elder", this.cn());
   }

   protected void bq() {
      zx var1 = ((us)oa.a(this.V, ur.j())).a(this.V);
      this.a(var1, 1.0F);
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.e).a(6.0D);
      this.a((qb)vy.d).a(0.5D);
      this.a((qb)vy.b).a(16.0D);
      this.a((qb)vy.a).a(30.0D);
   }

   public void g(float var1, float var2) {
      if (this.bM()) {
         if (this.V()) {
            this.a(var1, var2, 0.1F);
            this.d(this.v, this.w, this.x);
            this.v *= 0.8999999761581421D;
            this.w *= 0.8999999761581421D;
            this.x *= 0.8999999761581421D;
            if (!this.n() && this.u() == null) {
               this.w -= 0.005D;
            }
         } else {
            super.g(var1, var2);
         }
      } else {
         super.g(var1, var2);
      }

   }

   public float a(cj var1) {
      return this.o.p(var1).c().t() == arm.h ? 10.0F + this.o.o(var1) - 0.5F : super.a(var1);
   }

   public int bQ() {
      return 180;
   }

   public int w() {
      return 160;
   }

   public float a(float var1) {
      return this.b + (this.a - this.b) * var1;
   }

   public pr cq() {
      if (!this.cp()) {
         return null;
      } else if (this.o.D) {
         if (this.bo != null) {
            return this.bo;
         } else {
            pk var1 = this.o.a(this.ac.c(17));
            if (var1 instanceof pr) {
               this.bo = (pr)var1;
               return this.bo;
            } else {
               return null;
            }
         }
      } else {
         return this.u();
      }
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + this.V.nextInt(var2 + 1);
      if (var3 > 0) {
         this.a(new zx(zy.cC, var3, 0), 1.0F);
      }

      if (this.V.nextInt(3 + var2) > 1) {
         this.a(new zx(zy.aU, 1, zp.a.a.a()), 1.0F);
      } else if (this.V.nextInt(3 + var2) > 1) {
         this.a(new zx(zy.cD, 1, 0), 1.0F);
      }

      if (var1 && this.cn()) {
         this.a(new zx(afi.v, 1, 1), 1.0F);
      }

   }

   static void a(vt var0, boolean var1) {
      var0.l(var1);
   }

   public float aS() {
      return this.K * 0.5F;
   }

   protected void h() {
      super.h();
      this.ac.a(16, 0);
      this.ac.a(17, 0);
   }

   public float p(float var1) {
      return this.bn + (this.bm - this.bn) * var1;
   }

   public void a(dn var1) {
      super.a(var1);
      this.a(var1.n("Elder"));
   }

   protected void E() {
      super.E();
      if (this.cn()) {
         boolean var1 = true;
         boolean var2 = true;
         boolean var3 = true;
         boolean var4 = true;
         if ((this.W + this.F()) % 1200 == 0) {
            pe var5 = pe.f;
            List var6 = this.o.b(lf.class, new Predicate<lf>(this) {
               final vt a;

               {
                  this.a = var1;
               }

               public boolean a(lf var1) {
                  return this.a.h(var1) < 2500.0D && var1.c.c();
               }

               public boolean apply(Object var1) {
                  return this.a((lf)var1);
               }
            });
            Iterator var7 = var6.iterator();

            label44:
            while(true) {
               lf var8;
               do {
                  if (!var7.hasNext()) {
                     break label44;
                  }

                  var8 = (lf)var7.next();
               } while(var8.a((pe)var5) && var8.b((pe)var5).c() >= 2 && var8.b((pe)var5).b() >= 1200);

               var8.a.a((ff)(new gm(10, 0.0F)));
               var8.c(new pf(var5.H, 6000, 2));
            }
         }

         if (!this.ck()) {
            this.a(new cj(this), 16);
         }
      }

   }

   protected boolean s_() {
      return false;
   }

   static class c extends qq {
      private vt g;

      public void c() {
         if (this.f && !this.g.s().m()) {
            double var1 = this.b - this.g.s;
            double var3 = this.c - this.g.t;
            double var5 = this.d - this.g.u;
            double var7 = var1 * var1 + var3 * var3 + var5 * var5;
            var7 = (double)ns.a(var7);
            var3 /= var7;
            float var9 = (float)(ns.b(var5, var1) * 180.0D / 3.1415927410125732D) - 90.0F;
            this.g.y = this.a(this.g.y, var9, 30.0F);
            this.g.aI = this.g.y;
            float var10 = (float)(this.e * this.g.a((qb)vy.d).e());
            this.g.k(this.g.bI() + (var10 - this.g.bI()) * 0.125F);
            double var11 = Math.sin((double)(this.g.W + this.g.F()) * 0.5D) * 0.05D;
            double var13 = Math.cos((double)(this.g.y * 3.1415927F / 180.0F));
            double var15 = Math.sin((double)(this.g.y * 3.1415927F / 180.0F));
            vt var10000 = this.g;
            var10000.v += var11 * var13;
            var10000 = this.g;
            var10000.x += var11 * var15;
            var11 = Math.sin((double)(this.g.W + this.g.F()) * 0.75D) * 0.05D;
            var10000 = this.g;
            var10000.w += var11 * (var15 + var13) * 0.25D;
            var10000 = this.g;
            var10000.w += (double)this.g.bI() * var3 * 0.1D;
            qp var17 = this.g.p();
            double var18 = this.g.s + var1 / var7 * 2.0D;
            double var20 = (double)this.g.aS() + this.g.t + var3 / var7 * 1.0D;
            double var22 = this.g.u + var5 / var7 * 2.0D;
            double var24 = var17.e();
            double var26 = var17.f();
            double var28 = var17.g();
            if (!var17.b()) {
               var24 = var18;
               var26 = var20;
               var28 = var22;
            }

            this.g.p().a(var24 + (var18 - var24) * 0.125D, var26 + (var20 - var26) * 0.125D, var28 + (var22 - var28) * 0.125D, 10.0F, 40.0F);
            vt.a(this.g, true);
         } else {
            this.g.k(0.0F);
            vt.a(this.g, false);
         }
      }

      public c(vt var1) {
         super(var1);
         this.g = var1;
      }
   }

   static class a extends rd {
      private vt a;
      private int b;

      public void d() {
         vt.a(this.a, 0);
         this.a.d((pr)null);
         vt.a(this.a).f();
      }

      public a(vt var1) {
         this.a = var1;
         this.a(3);
      }

      public void c() {
         this.b = -10;
         this.a.s().n();
         this.a.p().a(this.a.u(), 90.0F, 90.0F);
         this.a.ai = true;
      }

      public boolean b() {
         return super.b() && (this.a.cn() || this.a.h(this.a.u()) > 9.0D);
      }

      public void e() {
         pr var1 = this.a.u();
         this.a.s().n();
         this.a.p().a(var1, 90.0F, 90.0F);
         if (!this.a.t(var1)) {
            this.a.d((pr)null);
         } else {
            ++this.b;
            if (this.b == 0) {
               vt.a(this.a, this.a.u().F());
               this.a.o.a((pk)this.a, (byte)21);
            } else if (this.b >= this.a.cm()) {
               float var2 = 1.0F;
               if (this.a.o.aa() == oj.d) {
                  var2 += 2.0F;
               }

               if (this.a.cn()) {
                  var2 += 2.0F;
               }

               var1.a(ow.b(this.a, this.a), var2);
               var1.a(ow.a((pr)this.a), (float)this.a.a((qb)vy.e).e());
               this.a.d((pr)null);
            } else if (this.b >= 60 && this.b % 20 == 0) {
            }

            super.e();
         }
      }

      public boolean a() {
         pr var1 = this.a.u();
         return var1 != null && var1.ai();
      }
   }

   static class b implements Predicate<pr> {
      private vt a;

      public b(vt var1) {
         this.a = var1;
      }

      public boolean a(pr var1) {
         return (var1 instanceof wn || var1 instanceof tx) && var1.h(this.a) > 9.0D;
      }

      public boolean apply(Object var1) {
         return this.a((pr)var1);
      }
   }
}
