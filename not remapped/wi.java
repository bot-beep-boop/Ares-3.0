import java.util.Iterator;
import java.util.Random;

public class wi extends ph implements acy, wh {
   private ada br;
   private int bv;
   private static final wi.f[][][][] bC;
   private oq bB;
   private int by;
   private String bw;
   private wn bq;
   private int bx;
   private boolean bp;
   private boolean bz;
   tf bm;
   private boolean bA;
   private int bs;
   private boolean bo;
   private int bn;
   private boolean bu;
   private boolean bt;

   public boolean cr() {
      return this.s(1);
   }

   public oq cq() {
      return this.bB;
   }

   private boolean a(zw var1) {
      return var1 == zy.P || var1 == zy.bS || var1 == zy.bR || var1 == zy.O || var1 == zy.N;
   }

   public pu a(ok var1, pu var2) {
      var2 = super.a(var1, var2);
      this.r(this.o.s.nextInt(5));
      this.cv();
      return var2;
   }

   public wi(adm var1, int var2) {
      super(var1);
      this.bB = new oq("Items", false, 8);
      this.r(var2);
      this.a(0.6F, 1.8F);
      ((sv)this.s()).b(true);
      ((sv)this.s()).a(true);
      this.i.a(0, new ra(this));
      this.i.a(1, new qs(this, we.class, 8.0F, 0.6D, 0.6D));
      this.i.a(1, new si(this));
      this.i.a(1, new rj(this));
      this.i.a(2, new rm(this));
      this.i.a(3, new sb(this));
      this.i.a(4, new ru(this, true));
      this.i.a(5, new rp(this, 0.6D));
      this.i.a(6, new rk(this));
      this.i.a(7, new sg(this));
      this.i.a(9, new rg(this, wn.class, 3.0F, 1.0F));
      this.i.a(9, new sj(this));
      this.i.a(9, new rz(this, 0.6D));
      this.i.a(10, new ri(this, ps.class, 8.0F));
      this.j(true);
   }

   protected String bo() {
      return "mob.villager.hit";
   }

   public void a_(zx var1) {
      if (!this.o.D && this.a_ > -this.w() + 20) {
         this.a_ = -this.w();
         if (var1 != null) {
            this.a("mob.villager.yes", this.bB(), this.bC());
         } else {
            this.a("mob.villager.no", this.bB(), this.bC());
         }
      }

   }

   public boolean cb() {
      return false;
   }

   public void l(boolean var1) {
      this.bo = var1;
   }

   protected void h() {
      super.h();
      this.ac.a(16, 0);
   }

   public boolean cu() {
      for(int var1 = 0; var1 < this.bB.o_(); ++var1) {
         zx var2 = this.bB.a(var1);
         if (var2 != null && (var2.b() == zy.N || var2.b() == zy.bS || var2.b() == zy.bR)) {
            return true;
         }
      }

      return false;
   }

   public void m(boolean var1) {
      this.bp = var1;
   }

   protected String z() {
      return this.co() ? "mob.villager.haggle" : "mob.villager.idle";
   }

   public boolean cm() {
      return this.bo;
   }

   public boolean n(boolean var1) {
      if (!this.bu && var1 && this.cr()) {
         boolean var2 = false;

         for(int var3 = 0; var3 < this.bB.o_(); ++var3) {
            zx var4 = this.bB.a(var3);
            if (var4 != null) {
               if (var4.b() == zy.P && var4.b >= 3) {
                  var2 = true;
                  this.bB.a(var3, 3);
               } else if ((var4.b() == zy.bS || var4.b() == zy.bR) && var4.b >= 12) {
                  var2 = true;
                  this.bB.a(var3, 12);
               }
            }

            if (var2) {
               this.o.a((pk)this, (byte)18);
               this.bu = true;
               break;
            }
         }
      }

      return this.bu;
   }

   public float aS() {
      float var1 = 1.62F;
      if (this.j_()) {
         var1 = (float)((double)var1 - 0.81D);
      }

      return var1;
   }

   public void a(uv var1) {
      if (!this.o.D && !this.I) {
         wd var2 = new wd(this.o);
         var2.b(this.s, this.t, this.u, this.y, this.z);
         var2.a(this.o.E(new cj(var2)), (pu)null);
         var2.k(this.ce());
         if (this.l_()) {
            var2.a(this.aM());
            var2.g(this.aN());
         }

         this.o.d((pk)var2);
         this.J();
      }
   }

   public void cp() {
      this.bz = true;
   }

   private void a(cy var1) {
      for(int var2 = 0; var2 < 5; ++var2) {
         double var3 = this.V.nextGaussian() * 0.02D;
         double var5 = this.V.nextGaussian() * 0.02D;
         double var7 = this.V.nextGaussian() * 0.02D;
         this.o.a(var1, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 1.0D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var3, var5, var7);
      }

   }

   protected void a(uz var1) {
      zx var2 = var1.l();
      zw var3 = var2.b();
      if (this.a(var3)) {
         zx var4 = this.bB.a(var2);
         if (var4 == null) {
            var1.J();
         } else {
            var2.b = var4.b;
         }
      }

   }

   public void b(pr var1) {
      super.b(var1);
      if (this.bm != null && var1 != null) {
         this.bm.a(var1);
         if (var1 instanceof wn) {
            byte var2 = -1;
            if (this.j_()) {
               var2 = -3;
            }

            this.bm.a(var1.e_(), var2);
            if (this.ai()) {
               this.o.a((pk)this, (byte)13);
            }
         }
      }

   }

   protected void n() {
      if (this.cl() == 0) {
         this.i.a(8, new rf(this, 0.6D));
      }

      super.n();
   }

   public int cl() {
      return Math.max(this.ac.c(16) % 5, 0);
   }

   public void a(acz var1) {
      var1.g();
      this.a_ = -this.w();
      this.a("mob.villager.yes", this.bB(), this.bC());
      int var2 = 3 + this.V.nextInt(4);
      if (var1.e() == 1 || this.V.nextInt(5) == 0) {
         this.bs = 40;
         this.bt = true;
         this.bu = true;
         if (this.bq != null) {
            this.bw = this.bq.e_();
         } else {
            this.bw = null;
         }

         var2 += 5;
      }

      if (var1.a().b() == zy.bO) {
         this.bv += var1.a().b;
      }

      if (var1.j()) {
         this.o.d((pk)(new pp(this.o, this.s, this.t + 0.5D, this.u, var2)));
      }

   }

   public void a(byte var1) {
      if (var1 == 12) {
         this.a(cy.I);
      } else if (var1 == 13) {
         this.a(cy.u);
      } else if (var1 == 14) {
         this.a(cy.v);
      } else {
         super.a(var1);
      }

   }

   public void a(ow var1) {
      if (this.bm != null) {
         pk var2 = var1.j();
         if (var2 != null) {
            if (var2 instanceof wn) {
               this.bm.a(var2.e_(), -2);
            } else if (var2 instanceof vq) {
               this.bm.h();
            }
         } else {
            wn var3 = this.o.a(this, 16.0D);
            if (var3 != null) {
               this.bm.h();
            }
         }
      }

      super.a((ow)var1);
   }

   public boolean ct() {
      boolean var1 = this.cl() == 0;
      if (var1) {
         return !this.s(5);
      } else {
         return !this.s(1);
      }
   }

   protected boolean C() {
      return false;
   }

   static {
      bC = new wi.f[][][][]{{{{new wi.a(zy.O, new wi.g(18, 22)), new wi.a(zy.bS, new wi.g(15, 19)), new wi.a(zy.bR, new wi.g(15, 19)), new wi.e(zy.P, new wi.g(-4, -2))}, {new wi.a(zw.a(afi.aU), new wi.g(8, 13)), new wi.e(zy.ca, new wi.g(-3, -2))}, {new wi.a(zw.a(afi.bk), new wi.g(7, 12)), new wi.e(zy.e, new wi.g(-5, -7))}, {new wi.e(zy.bc, new wi.g(-6, -10)), new wi.e(zy.aZ, new wi.g(1, 1))}}, {{new wi.a(zy.F, new wi.g(15, 20)), new wi.a(zy.h, new wi.g(16, 24)), new wi.d(zy.aU, new wi.g(6, 6), zy.aV, new wi.g(6, 6))}, {new wi.c(zy.aR, new wi.g(7, 8))}}, {{new wi.a(zw.a(afi.L), new wi.g(16, 22)), new wi.e(zy.be, new wi.g(3, 4))}, {new wi.e(new zx(zw.a(afi.L), 1, 0), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 1), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 2), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 3), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 4), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 5), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 6), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 7), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 8), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 9), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 10), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 11), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 12), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 13), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 14), new wi.g(1, 2)), new wi.e(new zx(zw.a(afi.L), 1, 15), new wi.g(1, 2))}}, {{new wi.a(zy.F, new wi.g(15, 20)), new wi.e(zy.g, new wi.g(-12, -8))}, {new wi.e(zy.f, new wi.g(2, 3)), new wi.d(zw.a(afi.n), new wi.g(10, 10), zy.ak, new wi.g(6, 10))}}}, {{{new wi.a(zy.aK, new wi.g(24, 36)), new wi.b()}, {new wi.a(zy.aL, new wi.g(8, 10)), new wi.e(zy.aQ, new wi.g(10, 12)), new wi.e(zw.a(afi.X), new wi.g(3, 4))}, {new wi.a(zy.bN, new wi.g(2, 2)), new wi.e(zy.aS, new wi.g(10, 12)), new wi.e(zw.a(afi.w), new wi.g(-5, -3))}, {new wi.b()}, {new wi.b()}, {new wi.e(zy.co, new wi.g(20, 22))}}}, {{{new wi.a(zy.bt, new wi.g(36, 40)), new wi.a(zy.k, new wi.g(8, 10))}, {new wi.e(zy.aC, new wi.g(-4, -1)), new wi.e(new zx(zy.aW, 1, zd.l.b()), new wi.g(-2, -1))}, {new wi.e(zy.bH, new wi.g(7, 11)), new wi.e(zw.a(afi.aX), new wi.g(-3, -1))}, {new wi.e(zy.bK, new wi.g(3, 11))}}}, {{{new wi.a(zy.h, new wi.g(16, 24)), new wi.e(zy.Y, new wi.g(4, 6))}, {new wi.a(zy.j, new wi.g(7, 9)), new wi.e(zy.Z, new wi.g(10, 14))}, {new wi.a(zy.i, new wi.g(3, 4)), new wi.c(zy.ad, new wi.g(16, 19))}, {new wi.e(zy.X, new wi.g(5, 7)), new wi.e(zy.W, new wi.g(9, 11)), new wi.e(zy.U, new wi.g(5, 7)), new wi.e(zy.V, new wi.g(11, 15))}}, {{new wi.a(zy.h, new wi.g(16, 24)), new wi.e(zy.c, new wi.g(6, 8))}, {new wi.a(zy.j, new wi.g(7, 9)), new wi.c(zy.l, new wi.g(9, 10))}, {new wi.a(zy.i, new wi.g(3, 4)), new wi.c(zy.u, new wi.g(12, 15)), new wi.c(zy.x, new wi.g(9, 12))}}, {{new wi.a(zy.h, new wi.g(16, 24)), new wi.c(zy.a, new wi.g(5, 7))}, {new wi.a(zy.j, new wi.g(7, 9)), new wi.c(zy.b, new wi.g(9, 11))}, {new wi.a(zy.i, new wi.g(3, 4)), new wi.c(zy.w, new wi.g(12, 15))}}}, {{{new wi.a(zy.al, new wi.g(14, 18)), new wi.a(zy.bk, new wi.g(14, 18))}, {new wi.a(zy.h, new wi.g(16, 24)), new wi.e(zy.am, new wi.g(-7, -5)), new wi.e(zy.bl, new wi.g(-8, -6))}}, {{new wi.a(zy.aF, new wi.g(9, 12)), new wi.e(zy.S, new wi.g(2, 4))}, {new wi.c(zy.R, new wi.g(7, 12))}, {new wi.e(zy.aA, new wi.g(8, 10))}}}};
   }

   public void a(dn var1) {
      super.a(var1);
      this.r(var1.f("Profession"));
      this.bv = var1.f("Riches");
      this.bx = var1.f("Career");
      this.by = var1.f("CareerLevel");
      this.bu = var1.n("Willing");
      if (var1.b("Offers", 10)) {
         dn var2 = var1.m("Offers");
         this.br = new ada(var2);
      }

      du var5 = var1.c("Inventory", 10);

      for(int var3 = 0; var3 < var5.c(); ++var3) {
         zx var4 = zx.a(var5.b(var3));
         if (var4 != null) {
            this.bB.a(var4);
         }
      }

      this.j(true);
      this.cv();
   }

   public wn v_() {
      return this.bq;
   }

   public ph a(ph var1) {
      return this.b(var1);
   }

   public void r(int var1) {
      this.ac.b(16, var1);
   }

   public boolean cs() {
      return this.s(2);
   }

   public void a_(wn var1) {
      this.bq = var1;
   }

   public eu f_() {
      String var1 = this.aM();
      if (var1 != null && var1.length() > 0) {
         fa var4 = new fa(var1);
         var4.b().a(this.aQ());
         var4.b().a(this.aK().toString());
         return var4;
      } else {
         if (this.br == null) {
            this.cw();
         }

         String var2 = null;
         switch(this.cl()) {
         case 0:
            if (this.bx == 1) {
               var2 = "farmer";
            } else if (this.bx == 2) {
               var2 = "fisherman";
            } else if (this.bx == 3) {
               var2 = "shepherd";
            } else if (this.bx == 4) {
               var2 = "fletcher";
            }
            break;
         case 1:
            var2 = "librarian";
            break;
         case 2:
            var2 = "cleric";
            break;
         case 3:
            if (this.bx == 1) {
               var2 = "armor";
            } else if (this.bx == 2) {
               var2 = "weapon";
            } else if (this.bx == 3) {
               var2 = "tool";
            }
            break;
         case 4:
            if (this.bx == 1) {
               var2 = "butcher";
            } else if (this.bx == 2) {
               var2 = "leather";
            }
         }

         if (var2 != null) {
            fb var3 = new fb("entity.Villager." + var2, new Object[0]);
            var3.b().a(this.aQ());
            var3.b().a(this.aK().toString());
            return var3;
         } else {
            return super.f_();
         }
      }
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.d).a(0.5D);
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Profession", this.cl());
      var1.a("Riches", this.bv);
      var1.a("Career", this.bx);
      var1.a("CareerLevel", this.by);
      var1.a("Willing", this.bu);
      if (this.br != null) {
         var1.a((String)"Offers", (eb)this.br.a());
      }

      du var2 = new du();

      for(int var3 = 0; var3 < this.bB.o_(); ++var3) {
         zx var4 = this.bB.a(var3);
         if (var4 != null) {
            var2.a((eb)var4.b(new dn()));
         }
      }

      var1.a((String)"Inventory", (eb)var2);
   }

   private void cv() {
      if (!this.bA) {
         this.bA = true;
         if (this.j_()) {
            this.i.a(8, new rw(this, 0.32D));
         } else if (this.cl() == 0) {
            this.i.a(6, new rf(this, 0.6D));
         }

      }
   }

   public void a(ada var1) {
   }

   public wi(adm var1) {
      this(var1, 0);
   }

   public wi b(ph var1) {
      wi var2 = new wi(this.o);
      var2.a(this.o.E(new cj(var2)), (pu)null);
      return var2;
   }

   public boolean co() {
      return this.bq != null;
   }

   public boolean a(wn var1) {
      zx var2 = var1.bi.h();
      boolean var3 = var2 != null && var2.b() == zy.bJ;
      if (!var3 && this.ai() && !this.co() && !this.j_()) {
         if (!this.o.D && (this.br == null || this.br.size() > 0)) {
            this.a_(var1);
            var1.a((acy)this);
         }

         var1.b(na.F);
         return true;
      } else {
         return super.a(var1);
      }
   }

   protected String bp() {
      return "mob.villager.death";
   }

   public void o(boolean var1) {
      this.bu = var1;
   }

   public boolean cn() {
      return this.bp;
   }

   protected void E() {
      if (--this.bn <= 0) {
         cj var1 = new cj(this);
         this.o.ae().a(var1);
         this.bn = 70 + this.V.nextInt(50);
         this.bm = this.o.ae().a(var1, 32);
         if (this.bm == null) {
            this.cj();
         } else {
            cj var2 = this.bm.a();
            this.a(var2, (int)((float)this.bm.b() * 1.0F));
            if (this.bz) {
               this.bz = false;
               this.bm.b(5);
            }
         }
      }

      if (!this.co() && this.bs > 0) {
         --this.bs;
         if (this.bs <= 0) {
            if (this.bt) {
               Iterator var3 = this.br.iterator();

               while(var3.hasNext()) {
                  acz var4 = (acz)var3.next();
                  if (var4.h()) {
                     var4.a(this.V.nextInt(6) + this.V.nextInt(6) + 2);
                  }
               }

               this.cw();
               this.bt = false;
               if (this.bm != null && this.bw != null) {
                  this.o.a((pk)this, (byte)14);
                  this.bm.a(this.bw, 1);
               }
            }

            this.c(new pf(pe.l.H, 200, 0));
         }
      }

      super.E();
   }

   public ada b_(wn var1) {
      if (this.br == null) {
         this.cw();
      }

      return this.br;
   }

   public boolean d(int var1, zx var2) {
      if (super.d(var1, var2)) {
         return true;
      } else {
         int var3 = var1 - 300;
         if (var3 >= 0 && var3 < this.bB.o_()) {
            this.bB.a(var3, var2);
            return true;
         } else {
            return false;
         }
      }
   }

   private boolean s(int var1) {
      boolean var2 = this.cl() == 0;

      for(int var3 = 0; var3 < this.bB.o_(); ++var3) {
         zx var4 = this.bB.a(var3);
         if (var4 != null) {
            if (var4.b() == zy.P && var4.b >= 3 * var1 || var4.b() == zy.bS && var4.b >= 12 * var1 || var4.b() == zy.bR && var4.b >= 12 * var1) {
               return true;
            }

            if (var2 && var4.b() == zy.O && var4.b >= 9 * var1) {
               return true;
            }
         }
      }

      return false;
   }

   private void cw() {
      wi.f[][][] var1 = bC[this.cl()];
      if (this.bx != 0 && this.by != 0) {
         ++this.by;
      } else {
         this.bx = this.V.nextInt(var1.length) + 1;
         this.by = 1;
      }

      if (this.br == null) {
         this.br = new ada();
      }

      int var2 = this.bx - 1;
      int var3 = this.by - 1;
      wi.f[][] var4 = var1[var2];
      if (var3 >= 0 && var3 < var4.length) {
         wi.f[] var5 = var4[var3];
         wi.f[] var6 = var5;
         int var7 = var5.length;

         for(int var8 = 0; var8 < var7; ++var8) {
            wi.f var9 = var6[var8];
            var9.a(this.br, this.V);
         }
      }

   }

   static class d implements wi.f {
      public zx c;
      public wi.g b;
      public zx a;
      public wi.g d;

      public d(zw var1, wi.g var2, zw var3, wi.g var4) {
         this.a = new zx(var1);
         this.b = var2;
         this.c = new zx(var3);
         this.d = var4;
      }

      public void a(ada var1, Random var2) {
         int var3 = 1;
         if (this.b != null) {
            var3 = this.b.a(var2);
         }

         int var4 = 1;
         if (this.d != null) {
            var4 = this.d.a(var2);
         }

         var1.add(new acz(new zx(this.a.b(), var3, this.a.i()), new zx(zy.bO), new zx(this.c.b(), var4, this.c.i())));
      }
   }

   static class g extends nz<Integer, Integer> {
      public g(int var1, int var2) {
         super(var1, var2);
      }

      public int a(Random var1) {
         return (Integer)this.a() >= (Integer)this.b() ? (Integer)this.a() : (Integer)this.a() + var1.nextInt((Integer)this.b() - (Integer)this.a() + 1);
      }
   }

   static class b implements wi.f {
      public void a(ada var1, Random var2) {
         aci var3 = aci.b[var2.nextInt(aci.b.length)];
         int var4 = ns.a(var2, var3.e(), var3.b());
         zx var5 = zy.cd.a(new acl(var3, var4));
         int var6 = 2 + var2.nextInt(5 + var4 * 10) + 3 * var4;
         if (var6 > 64) {
            var6 = 64;
         }

         var1.add(new acz(new zx(zy.aL), new zx(zy.bO, var6), var5));
      }

      public b() {
      }
   }

   interface f {
      void a(ada var1, Random var2);
   }

   static class a implements wi.f {
      public wi.g b;
      public zw a;

      public a(zw var1, wi.g var2) {
         this.a = var1;
         this.b = var2;
      }

      public void a(ada var1, Random var2) {
         int var3 = 1;
         if (this.b != null) {
            var3 = this.b.a(var2);
         }

         var1.add(new acz(new zx(this.a, var3, 0), zy.bO));
      }
   }

   static class c implements wi.f {
      public wi.g b;
      public zx a;

      public c(zw var1, wi.g var2) {
         this.a = new zx(var1);
         this.b = var2;
      }

      public void a(ada var1, Random var2) {
         int var3 = 1;
         if (this.b != null) {
            var3 = this.b.a(var2);
         }

         zx var4 = new zx(zy.bO, var3, 0);
         zx var5 = new zx(this.a.b(), 1, this.a.i());
         var5 = ack.a(var2, var5, 5 + var2.nextInt(15));
         var1.add(new acz(var4, var5));
      }
   }

   static class e implements wi.f {
      public wi.g b;
      public zx a;

      public void a(ada var1, Random var2) {
         int var3 = 1;
         if (this.b != null) {
            var3 = this.b.a(var2);
         }

         zx var4;
         zx var5;
         if (var3 < 0) {
            var4 = new zx(zy.bO, 1, 0);
            var5 = new zx(this.a.b(), -var3, this.a.i());
         } else {
            var4 = new zx(zy.bO, var3, 0);
            var5 = new zx(this.a.b(), 1, this.a.i());
         }

         var1.add(new acz(var4, var5));
      }

      public e(zx var1, wi.g var2) {
         this.a = var1;
         this.b = var2;
      }

      public e(zw var1, wi.g var2) {
         this.a = new zx(var1);
         this.b = var2;
      }
   }
}
