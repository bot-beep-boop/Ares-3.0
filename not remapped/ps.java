import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public abstract class ps extends pr {
   protected float[] bj = new float[5];
   private dn bq;
   private pk bp;
   private boolean bn;
   public int a_;
   private pr c;
   protected sw h;
   private boolean bm;
   private qp a;
   protected qo g;
   protected int b_;
   protected final re bi;
   protected final re i;
   private boolean bo;
   protected qq f;
   private qm b;
   private ta bk;
   private zx[] bl = new zx[5];

   public void v() {
   }

   public int aE() {
      if (this.u() == null) {
         return 3;
      } else {
         int var1 = (int)(this.bn() - this.bu() * 0.33F);
         var1 -= (3 - this.o.aa().a()) * 4;
         if (var1 < 0) {
            var1 = 0;
         }

         return var1 + 3;
      }
   }

   public boolean d(int var1, zx var2) {
      int var3;
      if (var1 == 99) {
         var3 = 0;
      } else {
         var3 = var1 - 100 + 1;
         if (var3 < 0 || var3 >= this.bl.length) {
            return false;
         }
      }

      if (var2 != null && c(var2) != var3 && (var3 != 4 || !(var2.b() instanceof yo))) {
         return false;
      } else {
         this.c(var3, var2);
         return true;
      }
   }

   protected int b(wn var1) {
      if (this.b_ > 0) {
         int var2 = this.b_;
         zx[] var3 = this.as();

         for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var3[var4] != null && this.bj[var4] <= 1.0F) {
               var2 += 1 + this.V.nextInt(3);
            }
         }

         return var2;
      } else {
         return this.b_;
      }
   }

   protected void E() {
   }

   protected zw A() {
      return null;
   }

   public void a(pk var1, float var2, float var3) {
      double var4 = var1.s - this.s;
      double var8 = var1.u - this.u;
      double var6;
      if (var1 instanceof pr) {
         pr var10 = (pr)var1;
         var6 = var10.t + (double)var10.aS() - (this.t + (double)this.aS());
      } else {
         var6 = (var1.aR().b + var1.aR().e) / 2.0D - (this.t + (double)this.aS());
      }

      double var14 = (double)ns.a(var4 * var4 + var8 * var8);
      float var12 = (float)(ns.b(var8, var4) * 180.0D / 3.1415927410125732D) - 90.0F;
      float var13 = (float)(-(ns.b(var6, var14) * 180.0D / 3.1415927410125732D));
      this.z = this.b(this.z, var13, var3);
      this.y = this.b(this.y, var12, var2);
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("CanPickUpLoot", this.bY());
      var1.a("PersistenceRequired", this.bn);
      du var2 = new du();

      dn var4;
      for(int var3 = 0; var3 < this.bl.length; ++var3) {
         var4 = new dn();
         if (this.bl[var3] != null) {
            this.bl[var3].b(var4);
         }

         var2.a((eb)var4);
      }

      var1.a((String)"Equipment", (eb)var2);
      du var6 = new du();

      for(int var7 = 0; var7 < this.bj.length; ++var7) {
         var6.a((eb)(new dr(this.bj[var7])));
      }

      var1.a((String)"DropChances", (eb)var6);
      var1.a("Leashed", this.bo);
      if (this.bp != null) {
         var4 = new dn();
         if (this.bp instanceof pr) {
            var4.a("UUIDMost", this.bp.aK().getMostSignificantBits());
            var4.a("UUIDLeast", this.bp.aK().getLeastSignificantBits());
         } else if (this.bp instanceof un) {
            cj var5 = ((un)this.bp).n();
            var4.a("X", var5.n());
            var4.a("Y", var5.o());
            var4.a("Z", var5.p());
         }

         var1.a((String)"Leash", (eb)var4);
      }

      if (this.ce()) {
         var1.a("NoAI", this.ce());
      }

   }

   protected void D() {
      if (this.bn) {
         this.aQ = 0;
      } else {
         wn var1 = this.o.a(this, -1.0D);
         if (var1 != null) {
            double var2 = var1.s - this.s;
            double var4 = var1.t - this.t;
            double var6 = var1.u - this.u;
            double var8 = var2 * var2 + var4 * var4 + var6 * var6;
            if (this.C() && var8 > 16384.0D) {
               this.J();
            }

            if (this.aQ > 600 && this.V.nextInt(800) == 0 && var8 > 1024.0D && this.C()) {
               this.J();
            } else if (var8 < 1024.0D) {
               this.aQ = 0;
            }
         }

      }
   }

   protected boolean C() {
      return true;
   }

   public void y() {
      if (this.o.D) {
         for(int var1 = 0; var1 < 20; ++var1) {
            double var2 = this.V.nextGaussian() * 0.02D;
            double var4 = this.V.nextGaussian() * 0.02D;
            double var6 = this.V.nextGaussian() * 0.02D;
            double var8 = 10.0D;
            this.o.a(cy.a, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J - var2 * var8, this.t + (double)(this.V.nextFloat() * this.K) - var4 * var8, this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J - var6 * var8, var2, var4, var6);
         }
      } else {
         this.o.a((pk)this, (byte)20);
      }

   }

   protected void a(uz var1) {
      zx var2 = var1.l();
      int var3 = c(var2);
      if (var3 > -1) {
         boolean var4 = true;
         zx var5 = this.p(var3);
         if (var5 != null) {
            if (var3 == 0) {
               if (var2.b() instanceof aay && !(var5.b() instanceof aay)) {
                  var4 = true;
               } else if (var2.b() instanceof aay && var5.b() instanceof aay) {
                  aay var8 = (aay)var2.b();
                  aay var10 = (aay)var5.b();
                  if (var8.g() != var10.g()) {
                     var4 = var8.g() > var10.g();
                  } else {
                     var4 = var2.i() > var5.i() || var2.n() && !var5.n();
                  }
               } else if (var2.b() instanceof yt && var5.b() instanceof yt) {
                  var4 = var2.n() && !var5.n();
               } else {
                  var4 = false;
               }
            } else if (var2.b() instanceof yj && !(var5.b() instanceof yj)) {
               var4 = true;
            } else if (var2.b() instanceof yj && var5.b() instanceof yj) {
               yj var6 = (yj)var2.b();
               yj var7 = (yj)var5.b();
               if (var6.c != var7.c) {
                  var4 = var6.c > var7.c;
               } else {
                  var4 = var2.i() > var5.i() || var2.n() && !var5.n();
               }
            } else {
               var4 = false;
            }
         }

         if (var4 && this.a(var2)) {
            if (var5 != null && this.V.nextFloat() - 0.1F < this.bj[var3]) {
               this.a(var5, 0.0F);
            }

            if (var2.b() == zy.i && var1.n() != null) {
               wn var9 = this.o.a(var1.n());
               if (var9 != null) {
                  var9.b((mw)mr.x);
               }
            }

            this.c(var3, var2);
            this.bj[var3] = 2.0F;
            this.bn = true;
            this.a(var1, 1);
            var1.J();
         }
      }

   }

   public static zw a(int var0, int var1) {
      switch(var0) {
      case 4:
         if (var1 == 0) {
            return zy.Q;
         } else if (var1 == 1) {
            return zy.ag;
         } else if (var1 == 2) {
            return zy.U;
         } else if (var1 == 3) {
            return zy.Y;
         } else if (var1 == 4) {
            return zy.ac;
         }
      case 3:
         if (var1 == 0) {
            return zy.R;
         } else if (var1 == 1) {
            return zy.ah;
         } else if (var1 == 2) {
            return zy.V;
         } else if (var1 == 3) {
            return zy.Z;
         } else if (var1 == 4) {
            return zy.ad;
         }
      case 2:
         if (var1 == 0) {
            return zy.S;
         } else if (var1 == 1) {
            return zy.ai;
         } else if (var1 == 2) {
            return zy.W;
         } else if (var1 == 3) {
            return zy.aa;
         } else if (var1 == 4) {
            return zy.ae;
         }
      case 1:
         if (var1 == 0) {
            return zy.T;
         } else if (var1 == 1) {
            return zy.aj;
         } else if (var1 == 2) {
            return zy.X;
         } else if (var1 == 3) {
            return zy.ab;
         } else if (var1 == 4) {
            return zy.af;
         }
      default:
         return null;
      }
   }

   public pu a(ok var1, pu var2) {
      this.a((qb)vy.b).b(new qd("Random spawn bonus", this.V.nextGaussian() * 0.05D, 1));
      return var2;
   }

   public boolean cc() {
      return this.bo;
   }

   public boolean bM() {
      return super.bM() && !this.ce();
   }

   public zx q(int var1) {
      return this.bl[var1 + 1];
   }

   public ta t() {
      return this.bk;
   }

   public pr u() {
      return this.c;
   }

   public ps(adm var1) {
      super(var1);
      this.i = new re(var1 != null && var1.B != null ? var1.B : null);
      this.bi = new re(var1 != null && var1.B != null ? var1.B : null);
      this.a = new qp(this);
      this.f = new qq(this);
      this.g = new qo(this);
      this.b = new qm(this);
      this.h = this.b(var1);
      this.bk = new ta(this);

      for(int var2 = 0; var2 < this.bj.length; ++var2) {
         this.bj[var2] = 0.085F;
      }

   }

   private float b(float var1, float var2, float var3) {
      float var4 = ns.g(var2 - var1);
      if (var4 > var3) {
         var4 = var3;
      }

      if (var4 < -var3) {
         var4 = -var3;
      }

      return var1 + var4;
   }

   public void a(byte var1) {
      if (var1 == 20) {
         this.y();
      } else {
         super.a(var1);
      }

   }

   public void c(int var1, zx var2) {
      this.bl[var1] = var2;
   }

   public int w() {
      return 80;
   }

   protected void ca() {
      if (this.bq != null) {
         this.n();
      }

      if (this.bo) {
         if (!this.ai()) {
            this.a(true, true);
         }

         if (this.bp == null || this.bp.I) {
            this.a(true, true);
         }
      }
   }

   public int bQ() {
      return 40;
   }

   public boolean cb() {
      return !this.cc() && !(this instanceof vq);
   }

   protected void h() {
      super.h();
      this.ac.a(15, (byte)0);
   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.b("CanPickUpLoot", 1)) {
         this.j(var1.n("CanPickUpLoot"));
      }

      this.bn = var1.n("PersistenceRequired");
      du var2;
      int var3;
      if (var1.b("Equipment", 9)) {
         var2 = var1.c("Equipment", 10);

         for(var3 = 0; var3 < this.bl.length; ++var3) {
            this.bl[var3] = zx.a(var2.b(var3));
         }
      }

      if (var1.b("DropChances", 9)) {
         var2 = var1.c("DropChances", 5);

         for(var3 = 0; var3 < var2.c(); ++var3) {
            this.bj[var3] = var2.e(var3);
         }
      }

      this.bo = var1.n("Leashed");
      if (this.bo && var1.b("Leash", 10)) {
         this.bq = var1.m("Leash");
      }

      this.k(var1.n("NoAI"));
   }

   public qo r() {
      return this.g;
   }

   public final boolean e(wn var1) {
      if (this.cc() && this.cd() == var1) {
         this.a(true, !var1.bA.d);
         return true;
      } else {
         zx var2 = var1.bi.h();
         if (var2 != null && var2.b() == zy.cn && this.cb()) {
            if (!(this instanceof qa) || !((qa)this).cl()) {
               this.a(var1, true);
               --var2.b;
               return true;
            }

            if (((qa)this).e(var1)) {
               this.a(var1, true);
               --var2.b;
               return true;
            }
         }

         return this.a(var1) ? true : super.e(var1);
      }
   }

   public void k(float var1) {
      super.k(var1);
      this.n(var1);
   }

   public void K() {
      super.K();
      this.o.B.a("mobBaseTick");
      if (this.ai() && this.V.nextInt(1000) < this.a_++) {
         this.a_ = -this.w();
         this.x();
      }

      this.o.B.b();
   }

   private void n() {
      if (this.bo && this.bq != null) {
         if (this.bq.b("UUIDMost", 4) && this.bq.b("UUIDLeast", 4)) {
            UUID var5 = new UUID(this.bq.g("UUIDMost"), this.bq.g("UUIDLeast"));
            List var6 = this.o.a(pr.class, this.aR().b(10.0D, 10.0D, 10.0D));
            Iterator var3 = var6.iterator();

            while(var3.hasNext()) {
               pr var4 = (pr)var3.next();
               if (var4.aK().equals(var5)) {
                  this.bp = var4;
                  break;
               }
            }
         } else if (this.bq.b("X", 99) && this.bq.b("Y", 99) && this.bq.b("Z", 99)) {
            cj var1 = new cj(this.bq.f("X"), this.bq.f("Y"), this.bq.f("Z"));
            up var2 = up.b(this.o, var1);
            if (var2 == null) {
               var2 = up.a(this.o, var1);
            }

            this.bp = var2;
         } else {
            this.a(false, true);
         }
      }

      this.bq = null;
   }

   public float bT() {
      return 1.0F;
   }

   protected sw b(adm var1) {
      return new sv(this, var1);
   }

   protected void b(boolean var1, int var2) {
      zw var3 = this.A();
      if (var3 != null) {
         int var4 = this.V.nextInt(3);
         if (var2 > 0) {
            var4 += this.V.nextInt(var2 + 1);
         }

         for(int var5 = 0; var5 < var4; ++var5) {
            this.a(var3, 1);
         }
      }

   }

   protected String z() {
      return null;
   }

   public qq q() {
      return this.f;
   }

   protected void a(boolean var1, int var2) {
      for(int var3 = 0; var3 < this.as().length; ++var3) {
         zx var4 = this.p(var3);
         boolean var5 = this.bj[var3] > 1.0F;
         if (var4 != null && (var1 || var5) && this.V.nextFloat() - (float)var2 * 0.01F < this.bj[var3]) {
            if (!var5 && var4.e()) {
               int var6 = Math.max(var4.j() - 25, 1);
               int var7 = var4.j() - this.V.nextInt(this.V.nextInt(var6) + 1);
               if (var7 > var6) {
                  var7 = var6;
               }

               if (var7 < 1) {
                  var7 = 1;
               }

               var4.b(var7);
            }

            this.a(var4, 0.0F);
         }
      }

   }

   public void t_() {
      super.t_();
      if (!this.o.D) {
         this.ca();
      }

   }

   public sw s() {
      return this.h;
   }

   public void d(pr var1) {
      this.c = var1;
   }

   public zx bA() {
      return this.bl[0];
   }

   public void a(boolean var1, boolean var2) {
      if (this.bo) {
         this.bo = false;
         this.bp = null;
         if (!this.o.D && var2) {
            this.a(zy.cn, 1);
         }

         if (!this.o.D && var1 && this.o instanceof le) {
            ((le)this.o).s().a((pk)this, (ff)(new hl(1, this, (pk)null)));
         }
      }

   }

   public boolean bR() {
      return true;
   }

   public void j(boolean var1) {
      this.bm = var1;
   }

   public boolean bY() {
      return this.bm;
   }

   protected final void bK() {
      ++this.aQ;
      this.o.B.a("checkDespawn");
      this.D();
      this.o.B.b();
      this.o.B.a("sensing");
      this.bk.a();
      this.o.B.b();
      this.o.B.a("targetSelector");
      this.bi.a();
      this.o.B.b();
      this.o.B.a("goalSelector");
      this.i.a();
      this.o.B.b();
      this.o.B.a("navigation");
      this.h.k();
      this.o.B.b();
      this.o.B.a("mob tick");
      this.E();
      this.o.B.b();
      this.o.B.a("controls");
      this.o.B.a("move");
      this.f.c();
      this.o.B.c("look");
      this.a.a();
      this.o.B.c("jump");
      this.g.b();
      this.o.B.b();
      this.o.B.b();
   }

   public void n(float var1) {
      this.ba = var1;
   }

   public boolean bW() {
      return false;
   }

   protected boolean a(wn var1) {
      return false;
   }

   public void bX() {
      this.bn = true;
   }

   public int bV() {
      return 4;
   }

   public pk cd() {
      return this.bp;
   }

   public zx[] as() {
      return this.bl;
   }

   public zx p(int var1) {
      return this.bl[var1];
   }

   public boolean ce() {
      return this.ac.a(15) != 0;
   }

   public qp p() {
      return this.a;
   }

   protected float h(float var1, float var2) {
      this.b.a();
      return var2;
   }

   public void k(boolean var1) {
      this.ac.b(15, Byte.valueOf((byte)(var1 ? 1 : 0)));
   }

   public void a(int var1, float var2) {
      this.bj[var1] = var2;
   }

   public void a(pk var1, boolean var2) {
      this.bo = true;
      this.bp = var1;
      if (!this.o.D && var2 && this.o instanceof le) {
         ((le)this.o).s().a((pk)this, (ff)(new hl(1, this, this.bp)));
      }

   }

   protected void a(ok var1) {
      if (this.V.nextFloat() < 0.15F * var1.c()) {
         int var2 = this.V.nextInt(2);
         float var3 = this.o.aa() == oj.d ? 0.1F : 0.25F;
         if (this.V.nextFloat() < 0.095F) {
            ++var2;
         }

         if (this.V.nextFloat() < 0.095F) {
            ++var2;
         }

         if (this.V.nextFloat() < 0.095F) {
            ++var2;
         }

         for(int var4 = 3; var4 >= 0; --var4) {
            zx var5 = this.q(var4);
            if (var4 < 3 && this.V.nextFloat() < var3) {
               break;
            }

            if (var5 == null) {
               zw var6 = a(var4 + 1, var2);
               if (var6 != null) {
                  this.c(var4 + 1, new zx(var6));
               }
            }
         }
      }

   }

   public void x() {
      String var1 = this.z();
      if (var1 != null) {
         this.a(var1, this.bB(), this.bC());
      }

   }

   protected void aX() {
      super.aX();
      this.by().b(vy.b).a(16.0D);
   }

   public boolean bZ() {
      return this.bn;
   }

   protected boolean a(zx var1) {
      return true;
   }

   public static int c(zx var0) {
      if (var0.b() != zw.a(afi.aU) && var0.b() != zy.bX) {
         if (var0.b() instanceof yj) {
            switch(((yj)var0.b()).b) {
            case 0:
               return 4;
            case 1:
               return 3;
            case 2:
               return 2;
            case 3:
               return 1;
            }
         }

         return 0;
      } else {
         return 4;
      }
   }

   public boolean bS() {
      return this.o.a((aug)this.aR(), (pk)this) && this.o.a((pk)this, (aug)this.aR()).isEmpty() && !this.o.d(this.aR());
   }

   protected void b(ok var1) {
      float var2 = var1.c();
      if (this.bA() != null && this.V.nextFloat() < 0.25F * var2) {
         ack.a(this.V, this.bA(), (int)(5.0F + var2 * (float)this.V.nextInt(18)));
      }

      for(int var3 = 0; var3 < 4; ++var3) {
         zx var4 = this.q(var3);
         if (var4 != null && this.V.nextFloat() < 0.5F * var2) {
            ack.a(this.V, var4, (int)(5.0F + var2 * (float)this.V.nextInt(18)));
         }
      }

   }

   public void m() {
      super.m();
      this.o.B.a("looting");
      if (!this.o.D && this.bY() && !this.aP && this.o.Q().b("mobGriefing")) {
         List var1 = this.o.a(uz.class, this.aR().b(1.0D, 0.0D, 1.0D));
         Iterator var2 = var1.iterator();

         while(var2.hasNext()) {
            uz var3 = (uz)var2.next();
            if (!var3.I && var3.l() != null && !var3.s()) {
               this.a(var3);
            }
         }
      }

      this.o.B.b();
   }

   public boolean a(Class<? extends pr> var1) {
      return var1 != vr.class;
   }

   public static enum a {
      a,
      c,
      b;

      private static final ps.a[] d = new ps.a[]{a, b, c};
   }
}
