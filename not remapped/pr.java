import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

public abstract class pr extends pk {
   protected float aR;
   protected boolean aY;
   public float ba;
   protected float aT;
   public float az;
   private int bj;
   private final Map<Integer, pf> g = Maps.newHashMap();
   public float aG;
   public float aE;
   public float aH;
   private pr bk;
   protected float aU;
   protected double bg;
   public int as;
   private static final UUID a = UUID.fromString("662A6B8D-DA3E-4C1C-8813-96EA6097278D");
   public int au;
   protected int bc;
   public float ay;
   public float aJ;
   protected double bf;
   private float bo;
   public float aM = 0.02F;
   private int bl;
   public float aw;
   protected wn aN;
   public float aK;
   public float aZ;
   protected float aS;
   public float aL;
   private final zx[] h = new zx[5];
   protected int aQ;
   private pr bi;
   protected boolean aP;
   protected double bd;
   public boolean ar;
   protected double be;
   public int av;
   protected int aW;
   protected float bb;
   public int aD = 20;
   protected float aX;
   private static final qd b;
   protected double bh;
   public int at;
   public float aF;
   protected int aO;
   public float aC;
   private boolean i = true;
   private float bm;
   protected float aV;
   private final ov f = new ov(this);
   public int ax;
   private int bn;
   public float aI;
   private qf c;
   public float aB;
   public float aA;

   public abstract zx[] as();

   protected void h() {
      this.ac.a(7, 0);
      this.ac.a(8, (byte)0);
      this.ac.a(9, (byte)0);
      this.ac.a(6, 1.0F);
   }

   protected boolean bD() {
      return this.bn() <= 0.0F;
   }

   public void a(pk var1, int var2) {
      if (!var1.I && !this.o.D) {
         la var3 = ((le)this.o).s();
         if (var1 instanceof uz) {
            var3.a((pk)var1, (ff)(new hy(var1.F(), this.F())));
         }

         if (var1 instanceof wq) {
            var3.a((pk)var1, (ff)(new hy(var1.F(), this.F())));
         }

         if (var1 instanceof pp) {
            var3.a((pk)var1, (ff)(new hy(var1.F(), this.F())));
         }
      }

   }

   protected void bH() {
      this.w += 0.03999999910593033D;
   }

   public qf by() {
      if (this.c == null) {
         this.c = new qi();
      }

      return this.c;
   }

   protected float bC() {
      return this.j_() ? (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.5F : (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F;
   }

   protected void aX() {
      this.by().b(vy.a);
      this.by().b(vy.c);
      this.by().b(vy.d);
   }

   protected void O() {
      this.a(ow.j, 4.0F);
   }

   protected float bE() {
      return 0.42F;
   }

   public final void o(int var1) {
      this.ac.b(9, (byte)var1);
   }

   public final int bv() {
      return this.ac.a(9);
   }

   public void t_() {
      super.t_();
      if (!this.o.D) {
         int var1 = this.bv();
         if (var1 > 0) {
            if (this.at <= 0) {
               this.at = 20 * (30 - var1);
            }

            --this.at;
            if (this.at <= 0) {
               this.o(var1 - 1);
            }
         }

         for(int var2 = 0; var2 < 5; ++var2) {
            zx var3 = this.h[var2];
            zx var4 = this.p(var2);
            if (!zx.b(var4, var3)) {
               ((le)this.o).s().a((pk)this, (ff)(new hn(this.F(), var2, var4)));
               if (var3 != null) {
                  this.c.a(var3.B());
               }

               if (var4 != null) {
                  this.c.b(var4.B());
               }

               this.h[var2] = var4 == null ? null : var4.k();
            }
         }

         if (this.W % 20 == 0) {
            this.bs().g();
         }
      }

      this.m();
      double var9 = this.s - this.p;
      double var10 = this.u - this.r;
      float var5 = (float)(var9 * var9 + var10 * var10);
      float var6 = this.aI;
      float var7 = 0.0F;
      this.aR = this.aS;
      float var8 = 0.0F;
      if (var5 > 0.0025000002F) {
         var8 = 1.0F;
         var7 = (float)Math.sqrt((double)var5) * 3.0F;
         var6 = (float)ns.b(var10, var9) * 180.0F / 3.1415927F - 90.0F;
      }

      if (this.az > 0.0F) {
         var6 = this.y;
      }

      if (!this.C) {
         var8 = 0.0F;
      }

      this.aS += (var8 - this.aS) * 0.3F;
      this.o.B.a("headTurn");
      var7 = this.h(var6, var7);
      this.o.B.b();
      this.o.B.a("rangeChecks");

      while(this.y - this.A < -180.0F) {
         this.A -= 360.0F;
      }

      while(this.y - this.A >= 180.0F) {
         this.A += 360.0F;
      }

      while(this.aI - this.aJ < -180.0F) {
         this.aJ -= 360.0F;
      }

      while(this.aI - this.aJ >= 180.0F) {
         this.aJ += 360.0F;
      }

      while(this.z - this.B < -180.0F) {
         this.B -= 360.0F;
      }

      while(this.z - this.B >= 180.0F) {
         this.B += 360.0F;
      }

      while(this.aK - this.aL < -180.0F) {
         this.aL -= 360.0F;
      }

      while(this.aK - this.aL >= 180.0F) {
         this.aL += 360.0F;
      }

      this.o.B.b();
      this.aT += var7;
   }

   public void a(byte var1) {
      String var2;
      if (var1 == 2) {
         this.aB = 1.5F;
         this.Z = this.aD;
         this.au = this.av = 10;
         this.aw = 0.0F;
         var2 = this.bo();
         if (var2 != null) {
            this.a(this.bo(), this.bB(), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
         }

         this.a(ow.k, 0.0F);
      } else if (var1 == 3) {
         var2 = this.bp();
         if (var2 != null) {
            this.a(this.bp(), this.bB(), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
         }

         this.i(0.0F);
         this.a(ow.k);
      } else {
         super.a(var1);
      }

   }

   public void i(boolean var1) {
      this.aY = var1;
   }

   public boolean ad() {
      return !this.I;
   }

   public void h(float var1) {
      float var2 = this.bn();
      if (var2 > 0.0F) {
         this.i(var2 + var1);
      }

   }

   public abstract void c(int var1, zx var2);

   public abstract zx bA();

   protected void aZ() {
      ++this.ax;
      if (this.ax == 20) {
         int var1;
         if (!this.o.D && (this.aO > 0 || this.bb()) && this.ba() && this.o.Q().b("doMobLoot")) {
            var1 = this.b(this.aN);

            while(var1 > 0) {
               int var2 = pp.a(var1);
               var1 -= var2;
               this.o.d((pk)(new pp(this.o, this.s, this.t, this.u, var2)));
            }
         }

         this.J();

         for(var1 = 0; var1 < 20; ++var1) {
            double var8 = this.V.nextGaussian() * 0.02D;
            double var4 = this.V.nextGaussian() * 0.02D;
            double var6 = this.V.nextGaussian() * 0.02D;
            this.o.a(cy.a, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var8, var4, var6);
         }
      }

   }

   public boolean bJ() {
      return false;
   }

   public final float bn() {
      return this.ac.d(6);
   }

   public void p(pk var1) {
      if (var1 instanceof pr) {
         this.bk = (pr)var1;
      } else {
         this.bk = null;
      }

      this.bl = this.W;
   }

   protected float bB() {
      return 1.0F;
   }

   protected void bi() {
      Iterator var1 = this.g.keySet().iterator();

      while(var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         pf var3 = (pf)this.g.get(var2);
         if (!var3.a(this)) {
            if (!this.o.D) {
               var1.remove();
               this.b(var3);
            }
         } else if (var3.b() % 600 == 0) {
            this.a(var3, false);
         }
      }

      if (this.i) {
         if (!this.o.D) {
            this.B();
         }

         this.i = false;
      }

      int var11 = this.ac.c(7);
      boolean var12 = this.ac.a(8) > 0;
      if (var11 > 0) {
         boolean var4 = false;
         if (!this.ax()) {
            var4 = this.V.nextBoolean();
         } else {
            var4 = this.V.nextInt(15) == 0;
         }

         if (var12) {
            var4 &= this.V.nextInt(5) == 0;
         }

         if (var4 && var11 > 0) {
            double var5 = (double)(var11 >> 16 & 255) / 255.0D;
            double var7 = (double)(var11 >> 8 & 255) / 255.0D;
            double var9 = (double)(var11 >> 0 & 255) / 255.0D;
            this.o.a(var12 ? cy.q : cy.p, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, var5, var7, var9);
         }
      }

   }

   public boolean d(pf var1) {
      if (this.bz() == pw.b) {
         int var2 = var1.a();
         if (var2 == pe.l.H || var2 == pe.u.H) {
            return false;
         }
      }

      return true;
   }

   protected void bG() {
      this.w += 0.03999999910593033D;
   }

   public void e(float var1, float var2) {
      super.e(var1, var2);
      pf var3 = this.b(pe.j);
      float var4 = var3 != null ? (float)(var3.c() + 1) : 0.0F;
      int var5 = ns.f((var1 - 3.0F - var4) * var2);
      if (var5 > 0) {
         this.a(this.n(var5), 1.0F, 1.0F);
         this.a(ow.i, (float)var5);
         int var6 = ns.c(this.s);
         int var7 = ns.c(this.t - 0.20000000298023224D);
         int var8 = ns.c(this.u);
         afh var9 = this.o.p(new cj(var6, var7, var8)).c();
         if (var9.t() != arm.a) {
            afh.b var10 = var9.H;
            this.a(var10.c(), var10.d() * 0.5F, var10.e() * 0.75F);
         }
      }

   }

   public boolean t(pk var1) {
      return this.o.a(new aui(this.s, this.t + (double)this.aS(), this.u), new aui(var1.s, var1.t + (double)var1.aS(), var1.u)) == null;
   }

   public void b(pr var1) {
      this.bi = var1;
      this.bj = this.W;
   }

   protected float h(float var1, float var2) {
      float var3 = ns.g(var1 - this.aI);
      this.aI += var3 * 0.3F;
      float var4 = ns.g(this.y - this.aI);
      boolean var5 = var4 < -90.0F || var4 >= 90.0F;
      if (var4 < -75.0F) {
         var4 = -75.0F;
      }

      if (var4 >= 75.0F) {
         var4 = 75.0F;
      }

      this.aI = this.y - var4;
      if (var4 * var4 > 2500.0F) {
         this.aI += var4 * 0.2F;
      }

      if (var5) {
         var2 *= -1.0F;
      }

      return var2;
   }

   protected void ac() {
      this.G = this.V.nextDouble() >= this.a(vy.c).e();
   }

   protected String bo() {
      return "game.neutral.hurt";
   }

   protected void bj() {
      this.ac.b(8, (byte)0);
      this.ac.b(7, 0);
   }

   public void g(float var1, float var2) {
      double var8;
      float var10;
      if (this.bM()) {
         float var5;
         float var6;
         if (this.V() && (!(this instanceof wn) || !((wn)this).bA.b)) {
            var8 = this.t;
            var5 = 0.8F;
            var6 = 0.02F;
            var10 = (float)ack.b((pk)this);
            if (var10 > 3.0F) {
               var10 = 3.0F;
            }

            if (!this.C) {
               var10 *= 0.5F;
            }

            if (var10 > 0.0F) {
               var5 += (0.54600006F - var5) * var10 / 3.0F;
               var6 += (this.bI() * 1.0F - var6) * var10 / 3.0F;
            }

            this.a(var1, var2, var6);
            this.d(this.v, this.w, this.x);
            this.v *= (double)var5;
            this.w *= 0.800000011920929D;
            this.x *= (double)var5;
            this.w -= 0.02D;
            if (this.D && this.c(this.v, this.w + 0.6000000238418579D - this.t + var8, this.x)) {
               this.w = 0.30000001192092896D;
            }
         } else if (this.ab() && (!(this instanceof wn) || !((wn)this).bA.b)) {
            var8 = this.t;
            this.a(var1, var2, 0.02F);
            this.d(this.v, this.w, this.x);
            this.v *= 0.5D;
            this.w *= 0.5D;
            this.x *= 0.5D;
            this.w -= 0.02D;
            if (this.D && this.c(this.v, this.w + 0.6000000238418579D - this.t + var8, this.x)) {
               this.w = 0.30000001192092896D;
            }
         } else {
            float var3 = 0.91F;
            if (this.C) {
               var3 = this.o.p(new cj(ns.c(this.s), ns.c(this.aR().b) - 1, ns.c(this.u))).c().L * 0.91F;
            }

            float var4 = 0.16277136F / (var3 * var3 * var3);
            if (this.C) {
               var5 = this.bI() * var4;
            } else {
               var5 = this.aM;
            }

            this.a(var1, var2, var5);
            var3 = 0.91F;
            if (this.C) {
               var3 = this.o.p(new cj(ns.c(this.s), ns.c(this.aR().b) - 1, ns.c(this.u))).c().L * 0.91F;
            }

            if (this.k_()) {
               var6 = 0.15F;
               this.v = ns.a(this.v, (double)(-var6), (double)var6);
               this.x = ns.a(this.x, (double)(-var6), (double)var6);
               this.O = 0.0F;
               if (this.w < -0.15D) {
                  this.w = -0.15D;
               }

               boolean var7 = this.av() && this instanceof wn;
               if (var7 && this.w < 0.0D) {
                  this.w = 0.0D;
               }
            }

            this.d(this.v, this.w, this.x);
            if (this.D && this.k_()) {
               this.w = 0.2D;
            }

            if (!this.o.D || this.o.e(new cj((int)this.s, 0, (int)this.u)) && this.o.f(new cj((int)this.s, 0, (int)this.u)).o()) {
               this.w -= 0.08D;
            } else if (this.t > 0.0D) {
               this.w = -0.1D;
            } else {
               this.w = 0.0D;
            }

            this.w *= 0.9800000190734863D;
            this.v *= (double)var3;
            this.x *= (double)var3;
         }
      }

      this.aA = this.aB;
      var8 = this.s - this.p;
      double var9 = this.u - this.r;
      var10 = ns.a(var8 * var8 + var9 * var9) * 4.0F;
      if (var10 > 1.0F) {
         var10 = 1.0F;
      }

      this.aB += (var10 - this.aB) * 0.4F;
      this.aC += this.aB;
   }

   public qc a(qb var1) {
      return this.by().a(var1);
   }

   protected void bL() {
      List var1 = this.o.a((pk)this, (aug)this.aR().b(0.20000000298023224D, 0.0D, 0.20000000298023224D), (Predicate)Predicates.and(po.d, new Predicate<pk>(this) {
         final pr a;

         public boolean apply(Object var1) {
            return this.a((pk)var1);
         }

         public boolean a(pk var1) {
            return var1.ae();
         }

         {
            this.a = var1;
         }
      }));
      if (!var1.isEmpty()) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            pk var3 = (pk)var1.get(var2);
            this.s(var3);
         }
      }

   }

   protected float b(ow var1, float var2) {
      if (!var1.e()) {
         int var3 = 25 - this.br();
         float var4 = var2 * (float)var3;
         this.j(var2);
         var2 = var4 / 25.0F;
      }

      return var2;
   }

   public void m(int var1) {
      pf var2 = (pf)this.g.remove(var1);
      if (var2 != null) {
         this.b(var2);
      }

   }

   public void m() {
      if (this.bn > 0) {
         --this.bn;
      }

      if (this.bc > 0) {
         double var1 = this.s + (this.bd - this.s) / (double)this.bc;
         double var3 = this.t + (this.be - this.t) / (double)this.bc;
         double var5 = this.u + (this.bf - this.u) / (double)this.bc;
         double var7 = ns.g(this.bg - (double)this.y);
         this.y = (float)((double)this.y + var7 / (double)this.bc);
         this.z = (float)((double)this.z + (this.bh - (double)this.z) / (double)this.bc);
         --this.bc;
         this.b(var1, var3, var5);
         this.b(this.y, this.z);
      } else if (!this.bM()) {
         this.v *= 0.98D;
         this.w *= 0.98D;
         this.x *= 0.98D;
      }

      if (Math.abs(this.v) < 0.005D) {
         this.v = 0.0D;
      }

      if (Math.abs(this.w) < 0.005D) {
         this.w = 0.0D;
      }

      if (Math.abs(this.x) < 0.005D) {
         this.x = 0.0D;
      }

      this.o.B.a("ai");
      if (this.bD()) {
         this.aY = false;
         this.aZ = 0.0F;
         this.ba = 0.0F;
         this.bb = 0.0F;
      } else if (this.bM()) {
         this.o.B.a("newAi");
         this.bK();
         this.o.B.b();
      }

      this.o.B.b();
      this.o.B.a("jump");
      if (this.aY) {
         if (this.V()) {
            this.bG();
         } else if (this.ab()) {
            this.bH();
         } else if (this.C && this.bn == 0) {
            this.bF();
            this.bn = 10;
         }
      } else {
         this.bn = 0;
      }

      this.o.B.b();
      this.o.B.a("travel");
      this.aZ *= 0.98F;
      this.ba *= 0.98F;
      this.bb *= 0.9F;
      this.g(this.aZ, this.ba);
      this.o.B.b();
      this.o.B.a("push");
      if (!this.o.D) {
         this.bL();
      }

      this.o.B.b();
   }

   protected void a(boolean var1, int var2) {
   }

   public void d(boolean var1) {
      super.d(var1);
      qc var2 = this.a(vy.d);
      if (var2.a(a) != null) {
         var2.c(b);
      }

      if (var1) {
         var2.b(b);
      }

   }

   protected void d(ow var1, float var2) {
      if (!this.b((ow)var1)) {
         var2 = this.b(var1, var2);
         var2 = this.c(var1, var2);
         float var3 = var2;
         var2 = Math.max(var2 - this.bN(), 0.0F);
         this.m(this.bN() - (var3 - var2));
         if (var2 != 0.0F) {
            float var4 = this.bn();
            this.i(var4 - var2);
            this.bs().a(var1, var4, var2);
            this.m(this.bN() - var2);
         }
      }
   }

   public boolean bM() {
      return !this.o.D;
   }

   public pf b(pe var1) {
      return (pf)this.g.get(var1.H);
   }

   protected void a(double var1, boolean var3, afh var4, cj var5) {
      if (!this.V()) {
         this.W();
      }

      if (!this.o.D && this.O > 3.0F && var3) {
         alz var6 = this.o.p(var5);
         afh var7 = var6.c();
         float var8 = (float)ns.f(this.O - 3.0F);
         if (var7.t() != arm.a) {
            double var9 = (double)Math.min(0.2F + var8 / 15.0F, 10.0F);
            if (var9 > 2.5D) {
               var9 = 2.5D;
            }

            int var11 = (int)(150.0D * var9);
            ((le)this.o).a(cy.M, this.s, this.t, this.u, var11, 0.0D, 0.0D, 0.0D, 0.15000000596046448D, afh.f(var6));
         }
      }

      super.a(var1, var3, var4, var5);
   }

   public pr bf() {
      return this.bk;
   }

   public void a(pk var1) {
      if (this.m != null && var1 == null) {
         if (!this.o.D) {
            this.q(this.m);
         }

         if (this.m != null) {
            this.m.l = null;
         }

         this.m = null;
      } else {
         super.a(var1);
      }
   }

   public boolean bm() {
      return this.bz() == pw.b;
   }

   public void a(double var1, double var3, double var5, float var7, float var8, int var9, boolean var10) {
      this.bd = var1;
      this.be = var3;
      this.bf = var5;
      this.bg = (double)var7;
      this.bh = (double)var8;
      this.bc = var9;
   }

   public boolean r(pk var1) {
      this.p(var1);
      return false;
   }

   private int n() {
      if (this.a(pe.e)) {
         return 6 - (1 + this.b(pe.e).c()) * 1;
      } else {
         return this.a(pe.f) ? 6 + (1 + this.b(pe.f).c()) * 2 : 6;
      }
   }

   public void k(float var1) {
      this.bm = var1;
   }

   public float bI() {
      return this.bm;
   }

   public pr bd() {
      return this.bi;
   }

   public boolean c(pr var1) {
      return this.a(var1.bO());
   }

   protected void b(pf var1) {
      this.i = true;
      if (!this.o.D) {
         pe.a[var1.a()].a(this, this.by(), var1.c());
      }

   }

   public void l(int var1) {
      this.g.remove(var1);
   }

   public auq bO() {
      return this.o.Z().h(this.aK().toString());
   }

   public void a(pk var1, float var2, double var3, double var5) {
      if (!(this.V.nextDouble() < this.a(vy.c).e())) {
         this.ai = true;
         float var7 = ns.a(var3 * var3 + var5 * var5);
         float var8 = 0.4F;
         this.v /= 2.0D;
         this.w /= 2.0D;
         this.x /= 2.0D;
         this.v -= var3 / (double)var7 * (double)var8;
         this.w += (double)var8;
         this.x -= var5 / (double)var7 * (double)var8;
         if (this.w > 0.4000000059604645D) {
            this.w = 0.4000000059604645D;
         }

      }
   }

   protected void a(pf var1) {
      this.i = true;
      if (!this.o.D) {
         pe.a[var1.a()].b(this, this.by(), var1.c());
      }

   }

   public Random bc() {
      return this.V;
   }

   public void ak() {
      super.ak();
      this.aR = this.aS;
      this.aS = 0.0F;
      this.O = 0.0F;
   }

   public boolean aO() {
      return false;
   }

   public void ar() {
      this.au = this.av = 10;
      this.aw = 0.0F;
   }

   public boolean ae() {
      return !this.I;
   }

   public void h_() {
   }

   public float l(float var1) {
      float var2 = this.az - this.ay;
      if (var2 < 0.0F) {
         ++var2;
      }

      return this.ay + var2 * var1;
   }

   protected void b(boolean var1, int var2) {
   }

   public boolean k_() {
      int var1 = ns.c(this.s);
      int var2 = ns.c(this.aR().b);
      int var3 = ns.c(this.u);
      afh var4 = this.o.p(new cj(var1, var2, var3)).c();
      return (var4 == afi.au || var4 == afi.bn) && (!(this instanceof wn) || !((wn)this).v());
   }

   public boolean a(pe var1) {
      return this.g.containsKey(var1.H);
   }

   public int bh() {
      return this.aQ;
   }

   protected boolean ba() {
      return !this.j_();
   }

   protected String n(int var1) {
      return var1 > 4 ? "game.neutral.hurt.fall.big" : "game.neutral.hurt.fall.small";
   }

   protected String bp() {
      return "game.neutral.die";
   }

   public void i(float var1) {
      this.ac.b(6, ns.a(var1, 0.0F, this.bu()));
   }

   public void g(float var1) {
      this.aI = var1;
   }

   public void q(pk var1) {
      double var3 = var1.s;
      double var5 = var1.aR().b + (double)var1.K;
      double var7 = var1.u;
      byte var9 = 1;

      for(int var10 = -var9; var10 <= var9; ++var10) {
         for(int var11 = -var9; var11 < var9; ++var11) {
            if (var10 != 0 || var11 != 0) {
               int var12 = (int)(this.s + (double)var10);
               int var13 = (int)(this.u + (double)var11);
               aug var2 = this.aR().c((double)var10, 1.0D, (double)var11);
               if (this.o.a(var2).isEmpty()) {
                  if (adm.a((adq)this.o, (cj)(new cj(var12, (int)this.t, var13)))) {
                     this.a(this.s + (double)var10, this.t + 1.0D, this.u + (double)var11);
                     return;
                  }

                  if (adm.a((adq)this.o, (cj)(new cj(var12, (int)this.t - 1, var13))) || this.o.p(new cj(var12, (int)this.t - 1, var13)).c().t() == arm.h) {
                     var3 = this.s + (double)var10;
                     var5 = this.t + 1.0D;
                     var7 = this.u + (double)var11;
                  }
               }
            }
         }
      }

      this.a(var3, var5, var7);
   }

   public final float bu() {
      return (float)this.a(vy.a).e();
   }

   public float aC() {
      return this.aK;
   }

   protected void B() {
      if (this.g.isEmpty()) {
         this.bj();
         this.e(false);
      } else {
         int var1 = abe.a(this.g.values());
         this.ac.b(8, Byte.valueOf((byte)(abe.b(this.g.values()) ? 1 : 0)));
         this.ac.b(7, var1);
         this.e(this.k(pe.p.H));
      }

   }

   public boolean j_() {
      return false;
   }

   static {
      b = (new qd(a, "Sprinting speed boost", 0.30000001192092896D, 2)).a(false);
   }

   public ov bs() {
      return this.f;
   }

   protected boolean bb() {
      return false;
   }

   public void G() {
      this.a(ow.j, Float.MAX_VALUE);
   }

   public void c(pf var1) {
      if (this.d(var1)) {
         if (this.g.containsKey(var1.a())) {
            ((pf)this.g.get(var1.a())).a(var1);
            this.a((pf)this.g.get(var1.a()), true);
         } else {
            this.g.put(var1.a(), var1);
            this.a(var1);
         }

      }
   }

   protected void a(pf var1, boolean var2) {
      this.i = true;
      if (var2 && !this.o.D) {
         pe.a[var1.a()].a(this, this.by(), var1.c());
         pe.a[var1.a()].b(this, this.by(), var1.c());
      }

   }

   public int br() {
      int var1 = 0;
      zx[] var2 = this.as();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         zx var5 = var2[var4];
         if (var5 != null && var5.b() instanceof yj) {
            int var6 = ((yj)var5.b()).c;
            var1 += var6;
         }
      }

      return var1;
   }

   public void m(float var1) {
      if (var1 < 0.0F) {
         var1 = 0.0F;
      }

      this.bo = var1;
   }

   public int be() {
      return this.bj;
   }

   public void f(float var1) {
      this.aK = var1;
   }

   public boolean a(auq var1) {
      return this.bO() != null ? this.bO().a(var1) : false;
   }

   public aui d(float var1) {
      if (var1 == 1.0F) {
         return this.f(this.z, this.aK);
      } else {
         float var2 = this.B + (this.z - this.B) * var1;
         float var3 = this.aL + (this.aK - this.aL) * var1;
         return this.f(var2, var3);
      }
   }

   public abstract zx p(int var1);

   public float bN() {
      return this.bo;
   }

   protected void bF() {
      this.w = (double)this.bE();
      if (this.a(pe.j)) {
         this.w += (double)((float)(this.b(pe.j).c() + 1) * 0.1F);
      }

      if (this.aw()) {
         float var1 = this.y * 0.017453292F;
         this.v -= (double)(ns.a(var1) * 0.2F);
         this.x += (double)(ns.b(var1) * 0.2F);
      }

      this.ai = true;
   }

   public pr bt() {
      if (this.f.c() != null) {
         return this.f.c();
      } else if (this.aN != null) {
         return this.aN;
      } else {
         return this.bi != null ? this.bi : null;
      }
   }

   protected void bx() {
      int var1 = this.n();
      if (this.ar) {
         ++this.as;
         if (this.as >= var1) {
            this.as = 0;
            this.ar = false;
         }
      } else {
         this.as = 0;
      }

      this.az = (float)this.as / (float)var1;
   }

   public abstract zx q(int var1);

   public void j() {
   }

   protected void bq() {
   }

   protected int b(wn var1) {
      return 0;
   }

   public void bw() {
      if (!this.ar || this.as >= this.n() / 2 || this.as < 0) {
         this.as = -1;
         this.ar = true;
         if (this.o instanceof le) {
            ((le)this.o).s().a((pk)this, (ff)(new fq(this, 0)));
         }
      }

   }

   public void a(dn var1) {
      this.m(var1.h("AbsorptionAmount"));
      if (var1.b("Attributes", 9) && this.o != null && !this.o.D) {
         vy.a(this.by(), var1.c("Attributes", 10));
      }

      if (var1.b("ActiveEffects", 9)) {
         du var2 = var1.c("ActiveEffects", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            dn var4 = var2.b(var3);
            pf var5 = pf.b(var4);
            if (var5 != null) {
               this.g.put(var5.a(), var5);
            }
         }
      }

      if (var1.b("HealF", 99)) {
         this.i(var1.h("HealF"));
      } else {
         eb var6 = var1.a("Health");
         if (var6 == null) {
            this.i(this.bu());
         } else if (var6.a() == 5) {
            this.i(((dr)var6).h());
         } else if (var6.a() == 2) {
            this.i((float)((dz)var6).e());
         }
      }

      this.au = var1.e("HurtTime");
      this.ax = var1.e("DeathTime");
      this.bj = var1.f("HurtByTimestamp");
   }

   public void K() {
      this.ay = this.az;
      super.K();
      this.o.B.a("livingEntityBaseTick");
      boolean var1 = this instanceof wn;
      if (this.ai()) {
         if (this.aj()) {
            this.a(ow.e, 1.0F);
         } else if (var1 && !this.o.af().a(this.aR())) {
            double var2 = this.o.af().a((pk)this) + this.o.af().m();
            if (var2 < 0.0D) {
               this.a(ow.e, (float)Math.max(1, ns.c(-var2 * this.o.af().n())));
            }
         }
      }

      if (this.T() || this.o.D) {
         this.N();
      }

      boolean var7 = var1 && ((wn)this).bA.a;
      if (this.ai()) {
         if (this.a((arm)arm.h)) {
            if (!this.aY() && !this.k(pe.o.H) && !var7) {
               this.h(this.j(this.az()));
               if (this.az() == -20) {
                  this.h(0);

                  for(int var3 = 0; var3 < 8; ++var3) {
                     float var4 = this.V.nextFloat() - this.V.nextFloat();
                     float var5 = this.V.nextFloat() - this.V.nextFloat();
                     float var6 = this.V.nextFloat() - this.V.nextFloat();
                     this.o.a(cy.e, this.s + (double)var4, this.t + (double)var5, this.u + (double)var6, this.v, this.w, this.x);
                  }

                  this.a(ow.f, 2.0F);
               }
            }

            if (!this.o.D && this.au() && this.m instanceof pr) {
               this.a((pk)null);
            }
         } else {
            this.h(300);
         }
      }

      if (this.ai() && this.U()) {
         this.N();
      }

      this.aE = this.aF;
      if (this.au > 0) {
         --this.au;
      }

      if (this.Z > 0 && !(this instanceof lf)) {
         --this.Z;
      }

      if (this.bn() <= 0.0F) {
         this.aZ();
      }

      if (this.aO > 0) {
         --this.aO;
      } else {
         this.aN = null;
      }

      if (this.bk != null && !this.bk.ai()) {
         this.bk = null;
      }

      if (this.bi != null) {
         if (!this.bi.ai()) {
            this.b((pr)null);
         } else if (this.W - this.bj > 100) {
            this.b((pr)null);
         }
      }

      this.bi();
      this.aU = this.aT;
      this.aJ = this.aI;
      this.aL = this.aK;
      this.A = this.y;
      this.B = this.z;
      this.o.B.b();
   }

   public boolean ai() {
      return !this.I && this.bn() > 0.0F;
   }

   public void a(ow var1) {
      pk var2 = var1.j();
      pr var3 = this.bt();
      if (this.aW >= 0 && var3 != null) {
         var3.b(this, this.aW);
      }

      if (var2 != null) {
         var2.a(this);
      }

      this.aP = true;
      this.bs().g();
      if (!this.o.D) {
         int var4 = 0;
         if (var2 instanceof wn) {
            var4 = ack.i((pr)var2);
         }

         if (this.ba() && this.o.Q().b("doMobLoot")) {
            this.b(this.aO > 0, var4);
            this.a(this.aO > 0, var4);
            if (this.aO > 0 && this.V.nextFloat() < 0.025F + (float)var4 * 0.01F) {
               this.bq();
            }
         }
      }

      this.o.a((pk)this, (byte)3);
   }

   public int bg() {
      return this.bl;
   }

   public Collection<pf> bl() {
      return this.g.values();
   }

   public aui ap() {
      return this.d(1.0F);
   }

   protected int j(int var1) {
      int var2 = ack.a((pk)this);
      return var2 > 0 && this.V.nextInt(var2 + 1) > 0 ? var1 : var1 - 1;
   }

   public void b(zx var1) {
      this.a("random.break", 0.8F, 0.8F + this.o.s.nextFloat() * 0.4F);

      for(int var2 = 0; var2 < 5; ++var2) {
         aui var3 = new aui(((double)this.V.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
         var3 = var3.a(-this.z * 3.1415927F / 180.0F);
         var3 = var3.b(-this.y * 3.1415927F / 180.0F);
         double var4 = (double)(-this.V.nextFloat()) * 0.6D - 0.3D;
         aui var6 = new aui(((double)this.V.nextFloat() - 0.5D) * 0.3D, var4, 0.6D);
         var6 = var6.a(-this.z * 3.1415927F / 180.0F);
         var6 = var6.b(-this.y * 3.1415927F / 180.0F);
         var6 = var6.b(this.s, this.t + (double)this.aS(), this.u);
         this.o.a(cy.K, var6.a, var6.b, var6.c, var3.a, var3.b + 0.05D, var3.c, zw.b(var1.b()));
      }

   }

   protected void bK() {
   }

   protected void j(float var1) {
   }

   protected void bP() {
      this.i = true;
   }

   protected float c(ow var1, float var2) {
      if (var1.h()) {
         return var2;
      } else {
         int var3;
         int var4;
         float var5;
         if (this.a(pe.m) && var1 != ow.j) {
            var3 = (this.b(pe.m).c() + 1) * 5;
            var4 = 25 - var3;
            var5 = var2 * (float)var4;
            var2 = var5 / 25.0F;
         }

         if (var2 <= 0.0F) {
            return 0.0F;
         } else {
            var3 = ack.a(this.as(), var1);
            if (var3 > 20) {
               var3 = 20;
            }

            if (var3 > 0 && var3 <= 20) {
               var4 = 25 - var3;
               var5 = var2 * (float)var4;
               var2 = var5 / 25.0F;
            }

            return var2;
         }
      }
   }

   public void b(dn var1) {
      var1.a("HealF", this.bn());
      var1.a("Health", (short)((int)Math.ceil((double)this.bn())));
      var1.a("HurtTime", (short)this.au);
      var1.a("HurtByTimestamp", this.bj);
      var1.a("DeathTime", (short)this.ax);
      var1.a("AbsorptionAmount", this.bN());
      zx[] var2 = this.as();
      int var3 = var2.length;

      int var4;
      zx var5;
      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (var5 != null) {
            this.c.a(var5.B());
         }
      }

      var1.a((String)"Attributes", (eb)vy.a(this.by()));
      var2 = this.as();
      var3 = var2.length;

      for(var4 = 0; var4 < var3; ++var4) {
         var5 = var2[var4];
         if (var5 != null) {
            this.c.b(var5.B());
         }
      }

      if (!this.g.isEmpty()) {
         du var6 = new du();
         Iterator var7 = this.g.values().iterator();

         while(var7.hasNext()) {
            pf var8 = (pf)var7.next();
            var6.a((eb)var8.a(new dn()));
         }

         var1.a((String)"ActiveEffects", (eb)var6);
      }

   }

   protected void s(pk var1) {
      var1.i(this);
   }

   public void bk() {
      Iterator var1 = this.g.keySet().iterator();

      while(var1.hasNext()) {
         Integer var2 = (Integer)var1.next();
         pf var3 = (pf)this.g.get(var2);
         if (!this.o.D) {
            var1.remove();
            this.b(var3);
         }
      }

   }

   public pr(adm var1) {
      super(var1);
      this.aX();
      this.i(this.bu());
      this.k = true;
      this.aH = (float)((Math.random() + 1.0D) * 0.009999999776482582D);
      this.b(this.s, this.t, this.u);
      this.aG = (float)Math.random() * 12398.0F;
      this.y = (float)(Math.random() * 3.1415927410125732D * 2.0D);
      this.aK = this.y;
      this.S = 0.6F;
   }

   public pw bz() {
      return pw.a;
   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else if (this.o.D) {
         return false;
      } else {
         this.aQ = 0;
         if (this.bn() <= 0.0F) {
            return false;
         } else if (var1.o() && this.a(pe.n)) {
            return false;
         } else {
            if ((var1 == ow.n || var1 == ow.o) && this.p(4) != null) {
               this.p(4).a((int)(var2 * 4.0F + this.V.nextFloat() * var2 * 2.0F), this);
               var2 *= 0.75F;
            }

            this.aB = 1.5F;
            boolean var3 = true;
            if ((float)this.Z > (float)this.aD / 2.0F) {
               if (var2 <= this.aX) {
                  return false;
               }

               this.d(var1, var2 - this.aX);
               this.aX = var2;
               var3 = false;
            } else {
               this.aX = var2;
               this.Z = this.aD;
               this.d(var1, var2);
               this.au = this.av = 10;
            }

            this.aw = 0.0F;
            pk var4 = var1.j();
            if (var4 != null) {
               if (var4 instanceof pr) {
                  this.b((pr)var4);
               }

               if (var4 instanceof wn) {
                  this.aO = 100;
                  this.aN = (wn)var4;
               } else if (var4 instanceof ua) {
                  ua var5 = (ua)var4;
                  if (var5.cl()) {
                     this.aO = 100;
                     this.aN = null;
                  }
               }
            }

            if (var3) {
               this.o.a((pk)this, (byte)2);
               if (var1 != ow.f) {
                  this.ac();
               }

               if (var4 != null) {
                  double var9 = var4.s - this.s;

                  double var7;
                  for(var7 = var4.u - this.u; var9 * var9 + var7 * var7 < 1.0E-4D; var7 = (Math.random() - Math.random()) * 0.01D) {
                     var9 = (Math.random() - Math.random()) * 0.01D;
                  }

                  this.aw = (float)(ns.b(var7, var9) * 180.0D / 3.1415927410125732D - (double)this.y);
                  this.a(var4, var2, var9, var7);
               } else {
                  this.aw = (float)((int)(Math.random() * 2.0D) * 180);
               }
            }

            String var10;
            if (this.bn() <= 0.0F) {
               var10 = this.bp();
               if (var3 && var10 != null) {
                  this.a(var10, this.bB(), this.bC());
               }

               this.a(var1);
            } else {
               var10 = this.bo();
               if (var3 && var10 != null) {
                  this.a(var10, this.bB(), this.bC());
               }
            }

            return true;
         }
      }
   }

   public boolean aY() {
      return false;
   }

   public boolean k(int var1) {
      return this.g.containsKey(var1);
   }
}
