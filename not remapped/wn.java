import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;

public abstract class wn extends pr {
   public float bZ;
   public xi bj;
   public double bq;
   public int bB;
   protected int bm;
   private int b;
   public double bs;
   private boolean d;
   public double bu;
   public cj bx;
   private cj e;
   public double bv;
   public ur bG;
   private zx g;
   private int i;
   protected boolean bw;
   protected float bE = 0.1F;
   private int h;
   private cj c;
   public wm bi = new wm(this);
   public double br;
   public float bo;
   private boolean bI = false;
   protected xg bl = new xg();
   public wl bA = new wl();
   public int bC;
   private yd a = new yd();
   public float bz;
   public double bt;
   public float bD;
   public float by;
   private final GameProfile bH;
   public int bp;
   public xi bk;
   private int f;
   public float bn;
   protected float bF = 0.02F;

   protected String bo() {
      return "game.player.hurt";
   }

   public boolean bS() {
      return this.g != null;
   }

   public auo cp() {
      return this.o.Z();
   }

   protected String n(int var1) {
      return var1 > 4 ? "game.player.hurt.fall.big" : "game.player.hurt.fall.small";
   }

   public uz a(zx var1, boolean var2) {
      return this.a(var1, false, false);
   }

   public double am() {
      return -0.35D;
   }

   public void a(adp.a var1) {
   }

   public void a(pr var1) {
      if (var1 instanceof vq) {
         this.b((mw)mr.s);
      }

      pm.a var2 = (pm.a)pm.a.get(pm.a((pk)var1));
      if (var2 != null) {
         this.b(var2.d);
      }

   }

   public void bU() {
      if (this.g != null) {
         this.g.b(this.o, this, this.h);
      }

      this.bV();
   }

   public int bT() {
      return this.bS() ? this.g.l() - this.h : 0;
   }

   public void b(eu var1) {
   }

   protected String P() {
      return "game.player.swim";
   }

   protected void a(uz var1) {
      this.o.d((pk)var1);
   }

   protected void aX() {
      super.aX();
      this.by().b(vy.e).a(1.0D);
      this.a((qb)vy.d).a(0.10000000149011612D);
   }

   public float bY() {
      int var1 = 0;
      zx[] var2 = this.bi.b;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         zx var5 = var2[var4];
         if (var5 != null) {
            ++var1;
         }
      }

      return (float)var1 / (float)this.bi.b.length;
   }

   public void ak() {
      if (!this.o.D && this.av()) {
         this.a((pk)null);
         this.c(false);
      } else {
         double var1 = this.s;
         double var3 = this.t;
         double var5 = this.u;
         float var7 = this.y;
         float var8 = this.z;
         super.ak();
         this.bn = this.bo;
         this.bo = 0.0F;
         this.l(this.s - var1, this.t - var3, this.u - var5);
         if (this.m instanceof tt) {
            this.z = var8;
            this.y = var7;
            this.aI = ((tt)this.m).aI;
         }

      }
   }

   protected void d(ow var1, float var2) {
      if (!this.b((ow)var1)) {
         if (!var1.e() && this.bW() && var2 > 0.0F) {
            var2 = (1.0F + var2) * 0.5F;
         }

         var2 = this.b(var1, var2);
         var2 = this.c(var1, var2);
         float var3 = var2;
         var2 = Math.max(var2 - this.bN(), 0.0F);
         this.m(this.bN() - (var3 - var2));
         if (var2 != 0.0F) {
            this.a(var1.f());
            float var4 = this.bn();
            this.i(this.bn() - var2);
            this.bs().a(var1, var4, var2);
            if (var2 < 3.4028235E37F) {
               this.a(na.x, Math.round(var2 * 10.0F));
            }

         }
      }
   }

   public void b(pk var1) {
   }

   protected String bp() {
      return "game.player.die";
   }

   public void cb() {
   }

   public void a(boolean var1, boolean var2, boolean var3) {
      this.a(0.6F, 1.8F);
      alz var4 = this.o.p(this.bx);
      if (this.bx != null && var4.c() == afi.C) {
         this.o.a((cj)this.bx, (alz)var4.a(afg.b, false), 4);
         cj var5 = afg.a((adm)this.o, (cj)this.bx, 0);
         if (var5 == null) {
            var5 = this.bx.a();
         }

         this.b((double)((float)var5.n() + 0.5F), (double)((float)var5.o() + 0.1F), (double)((float)var5.p() + 0.5F));
      }

      this.bw = false;
      if (!this.o.D && var2) {
         this.o.d();
      }

      this.b = var1 ? 0 : 100;
      if (var3) {
         this.a(this.bx, false);
      }

   }

   public void a(zx var1, int var2) {
      if (var1 != this.g) {
         this.g = var1;
         this.h = var2;
         if (!this.o.D) {
            this.f(true);
         }

      }
   }

   public zx bQ() {
      return this.g;
   }

   private boolean p() {
      return this.o.p(this.bx).c() == afi.C;
   }

   public boolean u_() {
      return MinecraftServer.N().d[0].Q().b("sendCommandFeedback");
   }

   public void a(mw var1, int var2) {
   }

   public void a(adc var1) {
   }

   protected void s() {
      if (this.g != null) {
         this.b((zx)this.g, 16);
         int var1 = this.g.b;
         zx var2 = this.g.b(this.o, this);
         if (var2 != this.g || var2 != null && var2.b != var1) {
            this.bi.a[this.bi.c] = var2;
            if (var2.b == 0) {
               this.bi.a[this.bi.c] = null;
            }
         }

         this.bV();
      }

   }

   public void a(aln var1) {
   }

   public boolean a(wn var1) {
      auq var2 = this.bO();
      auq var3 = var1.bO();
      if (var2 == null) {
         return true;
      } else {
         return !var2.a(var3) ? true : var2.g();
      }
   }

   public zx p(int var1) {
      return var1 == 0 ? this.bi.h() : this.bi.b[var1 - 1];
   }

   public void a(cj var1, boolean var2) {
      if (var1 != null) {
         this.c = var1;
         this.d = var2;
      } else {
         this.c = null;
         this.d = false;
      }

   }

   public void e(float var1, float var2) {
      if (!this.bA.c) {
         if (var1 >= 2.0F) {
            this.a(na.m, (int)Math.round((double)var1 * 100.0D));
         }

         super.e(var1, var2);
      }
   }

   public float bI() {
      return (float)this.a((qb)vy.d).e();
   }

   public boolean a(wo var1) {
      return (this.H().a(10) & var1.a()) == var1.a();
   }

   public float aS() {
      float var1 = 1.62F;
      if (this.bJ()) {
         var1 = 0.2F;
      }

      if (this.av()) {
         var1 -= 0.08F;
      }

      return var1;
   }

   public int cj() {
      return this.f;
   }

   public uz a(zx var1, boolean var2, boolean var3) {
      if (var1 == null) {
         return null;
      } else if (var1.b == 0) {
         return null;
      } else {
         double var4 = this.t - 0.30000001192092896D + (double)this.aS();
         uz var6 = new uz(this.o, this.s, var4, this.u, var1);
         var6.a(40);
         if (var3) {
            var6.c(this.e_());
         }

         float var7;
         float var8;
         if (var2) {
            var7 = this.V.nextFloat() * 0.5F;
            var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
            var6.v = (double)(-ns.a(var8) * var7);
            var6.x = (double)(ns.b(var8) * var7);
            var6.w = 0.20000000298023224D;
         } else {
            var7 = 0.3F;
            var6.v = (double)(-ns.a(this.y / 180.0F * 3.1415927F) * ns.b(this.z / 180.0F * 3.1415927F) * var7);
            var6.x = (double)(ns.b(this.y / 180.0F * 3.1415927F) * ns.b(this.z / 180.0F * 3.1415927F) * var7);
            var6.w = (double)(-ns.a(this.z / 180.0F * 3.1415927F) * var7 + 0.1F);
            var8 = this.V.nextFloat() * 3.1415927F * 2.0F;
            var7 = 0.02F * this.V.nextFloat();
            var6.v += Math.cos((double)var8) * (double)var7;
            var6.w += (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.1F);
            var6.x += Math.sin((double)var8) * (double)var7;
         }

         this.a(var6);
         if (var3) {
            this.b(na.v);
         }

         return var6;
      }
   }

   public void a(zx var1) {
   }

   public void b(pk var1, int var2) {
      this.s(var2);
      Collection var3 = this.cp().a(auu.f);
      if (var1 instanceof wn) {
         this.b(na.B);
         var3.addAll(this.cp().a(auu.e));
         var3.addAll(this.e(var1));
      } else {
         this.b(na.z);
      }

      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         auk var5 = (auk)var4.next();
         aum var6 = this.cp().c(this.e_(), var5);
         var6.a();
      }

   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else if (this.bA.a && !var1.g()) {
         return false;
      } else {
         this.aQ = 0;
         if (this.bn() <= 0.0F) {
            return false;
         } else {
            if (this.bJ() && !this.o.D) {
               this.a(true, true, false);
            }

            if (var1.r()) {
               if (this.o.aa() == oj.a) {
                  var2 = 0.0F;
               }

               if (this.o.aa() == oj.b) {
                  var2 = var2 / 2.0F + 1.0F;
               }

               if (this.o.aa() == oj.d) {
                  var2 = var2 * 3.0F / 2.0F;
               }
            }

            if (var2 == 0.0F) {
               return false;
            } else {
               pk var3 = var1.j();
               if (var3 instanceof wq && ((wq)var3).c != null) {
                  var3 = ((wq)var3).c;
               }

               return super.a(var1, var2);
            }
         }
      }
   }

   protected void b(zx var1, int var2) {
      if (var1.m() == aba.c) {
         this.a("random.drink", 0.5F, this.o.s.nextFloat() * 0.1F + 0.9F);
      }

      if (var1.m() == aba.b) {
         for(int var3 = 0; var3 < var2; ++var3) {
            aui var4 = new aui(((double)this.V.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D);
            var4 = var4.a(-this.z * 3.1415927F / 180.0F);
            var4 = var4.b(-this.y * 3.1415927F / 180.0F);
            double var5 = (double)(-this.V.nextFloat()) * 0.6D - 0.3D;
            aui var7 = new aui(((double)this.V.nextFloat() - 0.5D) * 0.3D, var5, 0.6D);
            var7 = var7.a(-this.z * 3.1415927F / 180.0F);
            var7 = var7.b(-this.y * 3.1415927F / 180.0F);
            var7 = var7.b(this.s, this.t + (double)this.aS(), this.u);
            if (var1.f()) {
               this.o.a(cy.K, var7.a, var7.b, var7.c, var4.a, var4.b + 0.05D, var4.c, zw.b(var1.b()), var1.i());
            } else {
               this.o.a(cy.K, var7.a, var7.b, var7.c, var4.a, var4.b + 0.05D, var4.c, zw.b(var1.b()));
            }
         }

         this.a("random.eat", 0.5F + 0.5F * (float)this.V.nextInt(2), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
      }

   }

   protected void h() {
      super.h();
      this.ac.a(16, (byte)0);
      this.ac.a(17, 0.0F);
      this.ac.a(18, 0);
      this.ac.a(10, (byte)0);
   }

   public boolean cq() {
      return this.bI;
   }

   public boolean d(int var1, zx var2) {
      if (var1 >= 0 && var1 < this.bi.a.length) {
         this.bi.a(var1, var2);
         return true;
      } else {
         int var3 = var1 - 100;
         int var4;
         if (var3 >= 0 && var3 < this.bi.b.length) {
            var4 = var3 + 1;
            if (var2 != null && var2.b() != null) {
               if (var2.b() instanceof yj) {
                  if (ps.c(var2) != var4) {
                     return false;
                  }
               } else if (var4 != 4 || var2.b() != zy.bX && !(var2.b() instanceof yo)) {
                  return false;
               }
            }

            this.bi.a(var3 + this.bi.a.length, var2);
            return true;
         } else {
            var4 = var1 - 200;
            if (var4 >= 0 && var4 < this.a.o_()) {
               this.a.a(var4, var2);
               return true;
            } else {
               return false;
            }
         }
      }
   }

   public static cj a(adm var0, cj var1, boolean var2) {
      afh var3 = var0.p(var1).c();
      if (var3 != afi.C) {
         if (!var2) {
            return null;
         } else {
            boolean var4 = var3.g();
            boolean var5 = var0.p(var1.a()).c().g();
            return var4 && var5 ? var1 : null;
         }
      } else {
         return afg.a((adm)var0, (cj)var1, 0);
      }
   }

   public boolean aO() {
      return true;
   }

   public void a(acy var1) {
   }

   public void f(pk var1) {
      if (var1.aD()) {
         if (!var1.l(this)) {
            float var2 = (float)this.a((qb)vy.e).e();
            byte var3 = 0;
            float var4 = 0.0F;
            if (var1 instanceof pr) {
               var4 = ack.a(this.bA(), ((pr)var1).bz());
            } else {
               var4 = ack.a(this.bA(), pw.a);
            }

            int var18 = var3 + ack.a((pr)this);
            if (this.aw()) {
               ++var18;
            }

            if (var2 > 0.0F || var4 > 0.0F) {
               boolean var5 = this.O > 0.0F && !this.C && !this.k_() && !this.V() && !this.a((pe)pe.q) && this.m == null && var1 instanceof pr;
               if (var5 && var2 > 0.0F) {
                  var2 *= 1.5F;
               }

               var2 += var4;
               boolean var6 = false;
               int var7 = ack.b((pr)this);
               if (var1 instanceof pr && var7 > 0 && !var1.at()) {
                  var6 = true;
                  var1.e(1);
               }

               double var8 = var1.v;
               double var10 = var1.w;
               double var12 = var1.x;
               boolean var14 = var1.a(ow.a(this), var2);
               if (var14) {
                  if (var18 > 0) {
                     var1.g((double)(-ns.a(this.y * 3.1415927F / 180.0F) * (float)var18 * 0.5F), 0.1D, (double)(ns.b(this.y * 3.1415927F / 180.0F) * (float)var18 * 0.5F));
                     this.v *= 0.6D;
                     this.x *= 0.6D;
                     this.d(false);
                  }

                  if (var1 instanceof lf && var1.G) {
                     ((lf)var1).a.a((ff)(new hm(var1)));
                     var1.G = false;
                     var1.v = var8;
                     var1.w = var10;
                     var1.x = var12;
                  }

                  if (var5) {
                     this.b(var1);
                  }

                  if (var4 > 0.0F) {
                     this.c(var1);
                  }

                  if (var2 >= 18.0F) {
                     this.b((mw)mr.F);
                  }

                  this.p(var1);
                  if (var1 instanceof pr) {
                     ack.a((pr)((pr)var1), (pk)this);
                  }

                  ack.b(this, var1);
                  zx var15 = this.bZ();
                  Object var16 = var1;
                  if (var1 instanceof ue) {
                     ud var17 = ((ue)var1).a;
                     if (var17 instanceof pr) {
                        var16 = (pr)var17;
                     }
                  }

                  if (var15 != null && var16 instanceof pr) {
                     var15.a((pr)var16, this);
                     if (var15.b <= 0) {
                        this.ca();
                     }
                  }

                  if (var1 instanceof pr) {
                     this.a(na.w, Math.round(var2 * 10.0F));
                     if (var7 > 0) {
                        var1.e(var7 * 4);
                     }
                  }

                  this.a(0.3F);
               } else if (var6) {
                  var1.N();
               }
            }

         }
      }
   }

   public void a(byte var1) {
      if (var1 == 9) {
         this.s();
      } else if (var1 == 23) {
         this.bI = false;
      } else if (var1 == 22) {
         this.bI = true;
      } else {
         super.a(var1);
      }

   }

   protected void n() {
      this.bk = this.bj;
   }

   protected int b(wn var1) {
      if (this.o.Q().b("keepInventory")) {
         return 0;
      } else {
         int var2 = this.bB * 7;
         return var2 > 100 ? 100 : var2;
      }
   }

   public abstract boolean v();

   public wn(adm var1, GameProfile var2) {
      super(var1);
      this.aq = a(var2);
      this.bH = var2;
      this.bj = new xy(this.bi, !var1.D, this);
      this.bk = this.bj;
      cj var3 = var1.M();
      this.b((double)var3.n() + 0.5D, (double)(var3.o() + 1), (double)var3.p() + 0.5D, 0.0F, 0.0F);
      this.aV = 180.0F;
      this.X = 20;
   }

   protected void bK() {
      super.bK();
      this.bx();
      this.aK = this.y;
   }

   public void g(float var1, float var2) {
      double var3 = this.s;
      double var5 = this.t;
      double var7 = this.u;
      if (this.bA.b && this.m == null) {
         double var9 = this.w;
         float var11 = this.aM;
         this.aM = this.bA.a() * (float)(this.aw() ? 2 : 1);
         super.g(var1, var2);
         this.w = var9 * 0.6D;
         this.aM = var11;
      } else {
         super.g(var1, var2);
      }

      this.k(this.s - var3, this.t - var5, this.u - var7);
   }

   public void a(int var1) {
      this.bB += var1;
      if (this.bB < 0) {
         this.bB = 0;
         this.bD = 0.0F;
         this.bC = 0;
      }

      if (var1 > 0 && this.bB % 5 == 0 && (float)this.i < (float)this.W - 100.0F) {
         float var2 = this.bB > 30 ? 1.0F : (float)this.bB / 30.0F;
         this.o.a((pk)this, "random.levelup", var2 * 0.75F, 1.0F);
         this.i = this.W;
      }

   }

   public void a(wn var1, boolean var2) {
      if (var2) {
         this.bi.b(var1.bi);
         this.i(var1.bn());
         this.bl = var1.bl;
         this.bB = var1.bB;
         this.bC = var1.bC;
         this.bD = var1.bD;
         this.r(var1.bX());
         this.an = var1.an;
         this.ao = var1.ao;
         this.ap = var1.ap;
      } else if (this.o.Q().b("keepInventory")) {
         this.bi.b(var1.bi);
         this.bB = var1.bB;
         this.bC = var1.bC;
         this.bD = var1.bD;
         this.r(var1.bX());
      }

      this.f = var1.f;
      this.a = var1.a;
      this.H().b(10, var1.H().a(10));
   }

   public void m() {
      if (this.bm > 0) {
         --this.bm;
      }

      if (this.o.aa() == oj.a && this.o.Q().b("naturalRegeneration")) {
         if (this.bn() < this.bu() && this.W % 20 == 0) {
            this.h(1.0F);
         }

         if (this.bl.c() && this.W % 10 == 0) {
            this.bl.a(this.bl.a() + 1);
         }
      }

      this.bi.k();
      this.bn = this.bo;
      super.m();
      qc var1 = this.a((qb)vy.d);
      if (!this.o.D) {
         var1.a((double)this.bA.b());
      }

      this.aM = this.bF;
      if (this.aw()) {
         this.aM = (float)((double)this.aM + (double)this.bF * 0.3D);
      }

      this.k((float)var1.e());
      float var2 = ns.a(this.v * this.v + this.x * this.x);
      float var3 = (float)(Math.atan(-this.w * 0.20000000298023224D) * 15.0D);
      if (var2 > 0.1F) {
         var2 = 0.1F;
      }

      if (!this.C || this.bn() <= 0.0F) {
         var2 = 0.0F;
      }

      if (this.C || this.bn() <= 0.0F) {
         var3 = 0.0F;
      }

      this.bo += (var2 - this.bo) * 0.4F;
      this.aF += (var3 - this.aF) * 0.8F;
      if (this.bn() > 0.0F && !this.v()) {
         aug var4 = null;
         if (this.m != null && !this.m.I) {
            var4 = this.aR().a(this.m.aR()).b(1.0D, 0.0D, 1.0D);
         } else {
            var4 = this.aR().b(1.0D, 0.5D, 1.0D);
         }

         List var5 = this.o.b((pk)this, (aug)var4);

         for(int var6 = 0; var6 < var5.size(); ++var6) {
            pk var7 = (pk)var5.get(var6);
            if (!var7.I) {
               this.d(var7);
            }
         }
      }

   }

   public cj ch() {
      return this.c;
   }

   public zx bA() {
      return this.bi.h();
   }

   public boolean a(on var1) {
      if (var1.a()) {
         return true;
      } else {
         zx var2 = this.bZ();
         return var2 != null && var2.s() ? var2.q().equals(var1.b()) : false;
      }
   }

   public void k(double var1, double var3, double var5) {
      if (this.m == null) {
         int var7;
         if (this.a((arm)arm.h)) {
            var7 = Math.round(ns.a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
            if (var7 > 0) {
               this.a(na.p, var7);
               this.a(0.015F * (float)var7 * 0.01F);
            }
         } else if (this.V()) {
            var7 = Math.round(ns.a(var1 * var1 + var5 * var5) * 100.0F);
            if (var7 > 0) {
               this.a(na.l, var7);
               this.a(0.015F * (float)var7 * 0.01F);
            }
         } else if (this.k_()) {
            if (var3 > 0.0D) {
               this.a(na.n, (int)Math.round(var3 * 100.0D));
            }
         } else if (this.C) {
            var7 = Math.round(ns.a(var1 * var1 + var5 * var5) * 100.0F);
            if (var7 > 0) {
               this.a(na.i, var7);
               if (this.aw()) {
                  this.a(na.k, var7);
                  this.a(0.099999994F * (float)var7 * 0.01F);
               } else {
                  if (this.av()) {
                     this.a(na.j, var7);
                  }

                  this.a(0.01F * (float)var7 * 0.01F);
               }
            }
         } else {
            var7 = Math.round(ns.a(var1 * var1 + var5 * var5) * 100.0F);
            if (var7 > 25) {
               this.a(na.o, var7);
            }
         }

      }
   }

   public boolean bW() {
      return this.bS() && this.g.b().e(this.g) == aba.d;
   }

   public int br() {
      return this.bi.m();
   }

   public eu f_() {
      fa var1 = new fa(aul.a(this.bO(), this.e_()));
      var1.b().a(new et(et.a.e, "/msg " + this.e_() + " "));
      var1.b().a(this.aQ());
      var1.b().a(this.e_());
      return var1;
   }

   public boolean cf() {
      return this.bw && this.b >= 100;
   }

   public static UUID a(GameProfile var0) {
      UUID var1 = var0.getId();
      if (var1 == null) {
         var1 = b(var0.getName());
      }

      return var1;
   }

   public int bX() {
      return this.ac.c(18);
   }

   public boolean cn() {
      return this.bA.e;
   }

   public String e_() {
      return this.bH.getName();
   }

   public void r(int var1) {
      this.ac.b(18, var1);
   }

   public void a(og var1) {
   }

   public float a(afh var1) {
      float var2 = this.bi.a(var1);
      if (var2 > 1.0F) {
         int var3 = ack.c(this);
         zx var4 = this.bi.h();
         if (var3 > 0 && var4 != null) {
            var2 += (float)(var3 * var3 + 1);
         }
      }

      if (this.a((pe)pe.e)) {
         var2 *= 1.0F + (float)(this.b((pe)pe.e).c() + 1) * 0.2F;
      }

      if (this.a((pe)pe.f)) {
         float var5 = 1.0F;
         switch(this.b((pe)pe.f).c()) {
         case 0:
            var5 = 0.3F;
            break;
         case 1:
            var5 = 0.09F;
            break;
         case 2:
            var5 = 0.0027F;
            break;
         case 3:
         default:
            var5 = 8.1E-4F;
         }

         var2 *= var5;
      }

      if (this.a((arm)arm.h) && !ack.j(this)) {
         var2 /= 5.0F;
      }

      if (!this.C) {
         var2 /= 5.0F;
      }

      return var2;
   }

   public boolean cc() {
      return false;
   }

   public void a(dn var1) {
      super.a(var1);
      this.aq = a(this.bH);
      du var2 = var1.c("Inventory", 10);
      this.bi.b(var2);
      this.bi.c = var1.f("SelectedItemSlot");
      this.bw = var1.n("Sleeping");
      this.b = var1.e("SleepTimer");
      this.bD = var1.h("XpP");
      this.bB = var1.f("XpLevel");
      this.bC = var1.f("XpTotal");
      this.f = var1.f("XpSeed");
      if (this.f == 0) {
         this.f = this.V.nextInt();
      }

      this.r(var1.f("Score"));
      if (this.bw) {
         this.bx = new cj(this);
         this.a(true, true, false);
      }

      if (var1.b("SpawnX", 99) && var1.b("SpawnY", 99) && var1.b("SpawnZ", 99)) {
         this.c = new cj(var1.f("SpawnX"), var1.f("SpawnY"), var1.f("SpawnZ"));
         this.d = var1.n("SpawnForced");
      }

      this.bl.a(var1);
      this.bA.b(var1);
      if (var1.b("EnderItems", 9)) {
         du var3 = var1.c("EnderItems", 10);
         this.a.a(var3);
      }

   }

   public void m(float var1) {
      if (var1 < 0.0F) {
         var1 = 0.0F;
      }

      this.H().b(17, var1);
   }

   public xg cl() {
      return this.bl;
   }

   public zx[] as() {
      return this.bi.b;
   }

   protected boolean s_() {
      return !this.bA.b;
   }

   protected void X() {
      if (!this.v()) {
         super.X();
      }

   }

   public void u(int var1) {
      this.s(var1);
      int var2 = Integer.MAX_VALUE - this.bC;
      if (var1 > var2) {
         var1 = var2;
      }

      this.bD += (float)var1 / (float)this.ck();

      for(this.bC += var1; this.bD >= 1.0F; this.bD /= (float)this.ck()) {
         this.bD = (this.bD - 1.0F) * (float)this.ck();
         this.a((int)1);
      }

   }

   public GameProfile cd() {
      return this.bH;
   }

   public boolean aj() {
      return !this.bw && super.aj();
   }

   public int L() {
      return this.bA.a ? 0 : 80;
   }

   private void l(double var1, double var3, double var5) {
      if (this.m != null) {
         int var7 = Math.round(ns.a(var1 * var1 + var3 * var3 + var5 * var5) * 100.0F);
         if (var7 > 0) {
            if (this.m instanceof va) {
               this.a(na.q, var7);
               if (this.e == null) {
                  this.e = new cj(this);
               } else if (this.e.c((double)ns.c(this.s), (double)ns.c(this.t), (double)ns.c(this.u)) >= 1000000.0D) {
                  this.b((mw)mr.q);
               }
            } else if (this.m instanceof ux) {
               this.a(na.r, var7);
            } else if (this.m instanceof tt) {
               this.a(na.s, var7);
            } else if (this.m instanceof tp) {
               this.a(na.t, var7);
            }
         }
      }

   }

   public void s(int var1) {
      int var2 = this.bX();
      this.ac.b(18, var2 + var1);
   }

   public void a(String var1, float var2, float var3) {
      this.o.a(this, var1, var2, var3);
   }

   public void a(float var1) {
      if (!this.bA.a) {
         if (!this.o.D) {
            this.bl.a(var1);
         }

      }
   }

   public yd co() {
      return this.a;
   }

   public int aq() {
      return 10;
   }

   public void c(pk var1) {
   }

   public void bF() {
      super.bF();
      this.b(na.u);
      if (this.aw()) {
         this.a(0.8F);
      } else {
         this.a(0.2F);
      }

   }

   protected boolean bb() {
      return true;
   }

   private void a(cq var1) {
      this.by = 0.0F;
      this.bz = 0.0F;
      switch(var1) {
      case d:
         this.bz = -1.8F;
         break;
      case c:
         this.bz = 1.8F;
         break;
      case e:
         this.by = 1.8F;
         break;
      case f:
         this.by = -1.8F;
      }

   }

   public zx q(int var1) {
      return this.bi.e(var1);
   }

   public void aA() {
      if (!this.bA.b) {
         super.aA();
      }

   }

   private void d(pk var1) {
      var1.d(this);
   }

   public boolean ci() {
      return this.d;
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a((String)"Inventory", (eb)this.bi.a(new du()));
      var1.a("SelectedItemSlot", this.bi.c);
      var1.a("Sleeping", this.bw);
      var1.a("SleepTimer", (short)this.b);
      var1.a("XpP", this.bD);
      var1.a("XpLevel", this.bB);
      var1.a("XpTotal", this.bC);
      var1.a("XpSeed", this.f);
      var1.a("Score", this.bX());
      if (this.c != null) {
         var1.a("SpawnX", this.c.n());
         var1.a("SpawnY", this.c.o());
         var1.a("SpawnZ", this.c.p());
         var1.a("SpawnForced", this.d);
      }

      this.bl.b(var1);
      this.bA.a(var1);
      var1.a((String)"EnderItems", (eb)this.a.h());
      zx var2 = this.bi.h();
      if (var2 != null && var2.b() != null) {
         var1.a((String)"SelectedItem", (eb)var2.b(new dn()));
      }

   }

   public void t_() {
      this.T = this.v();
      if (this.v()) {
         this.C = false;
      }

      if (this.g != null) {
         zx var1 = this.bi.h();
         if (var1 == this.g) {
            if (this.h <= 25 && this.h % 4 == 0) {
               this.b((zx)var1, 5);
            }

            if (--this.h == 0 && !this.o.D) {
               this.s();
            }
         } else {
            this.bV();
         }
      }

      if (this.bp > 0) {
         --this.bp;
      }

      if (this.bJ()) {
         ++this.b;
         if (this.b > 100) {
            this.b = 100;
         }

         if (!this.o.D) {
            if (!this.p()) {
               this.a(true, true, false);
            } else if (this.o.w()) {
               this.a(false, true, true);
            }
         }
      } else if (this.b > 0) {
         ++this.b;
         if (this.b >= 110) {
            this.b = 0;
         }
      }

      super.t_();
      if (!this.o.D && this.bk != null && !this.bk.a(this)) {
         this.n();
         this.bk = this.bj;
      }

      if (this.at() && this.bA.a) {
         this.N();
      }

      this.bq = this.bt;
      this.br = this.bu;
      this.bs = this.bv;
      double var14 = this.s - this.bt;
      double var3 = this.t - this.bu;
      double var5 = this.u - this.bv;
      double var7 = 10.0D;
      if (var14 > var7) {
         this.bq = this.bt = this.s;
      }

      if (var5 > var7) {
         this.bs = this.bv = this.u;
      }

      if (var3 > var7) {
         this.br = this.bu = this.t;
      }

      if (var14 < -var7) {
         this.bq = this.bt = this.s;
      }

      if (var5 < -var7) {
         this.bs = this.bv = this.u;
      }

      if (var3 < -var7) {
         this.br = this.bu = this.t;
      }

      this.bt += var14 * 0.25D;
      this.bv += var5 * 0.25D;
      this.bu += var3 * 0.25D;
      if (this.m == null) {
         this.e = null;
      }

      if (!this.o.D) {
         this.bl.a(this);
         this.b(na.g);
         if (this.ai()) {
            this.b(na.h);
         }
      }

      int var9 = 29999999;
      double var10 = ns.a(this.s, -2.9999999E7D, 2.9999999E7D);
      double var12 = ns.a(this.u, -2.9999999E7D, 2.9999999E7D);
      if (var10 != this.s || var12 != this.u) {
         this.b(var10, this.t, var12);
      }

   }

   public void t() {
   }

   public void c(int var1, zx var2) {
      this.bi.b[var1] = var2;
   }

   protected void j(float var1) {
      this.bi.a(var1);
   }

   public void J() {
      super.J();
      this.bj.b(this);
      if (this.bk != null) {
         this.bk.b(this);
      }

   }

   public auq bO() {
      return this.cp().h(this.e_());
   }

   public wn.a a(cj var1) {
      if (!this.o.D) {
         label86: {
            if (!this.bJ() && this.ai()) {
               if (!this.o.t.d()) {
                  return wn.a.b;
               }

               if (this.o.w()) {
                  return wn.a.c;
               }

               if (!(Math.abs(this.s - (double)var1.n()) > 3.0D) && !(Math.abs(this.t - (double)var1.o()) > 2.0D) && !(Math.abs(this.u - (double)var1.p()) > 3.0D)) {
                  double var2 = 8.0D;
                  double var4 = 5.0D;
                  List var6 = this.o.a(vv.class, new aug((double)var1.n() - var2, (double)var1.o() - var4, (double)var1.p() - var2, (double)var1.n() + var2, (double)var1.o() + var4, (double)var1.p() + var2));
                  if (!var6.isEmpty()) {
                     return wn.a.f;
                  }
                  break label86;
               }

               return wn.a.d;
            }

            return wn.a.e;
         }
      }

      if (this.au()) {
         this.a((pk)null);
      }

      this.a(0.2F, 0.2F);
      if (this.o.e(var1)) {
         cq var7 = (cq)this.o.p(var1).b(age.O);
         float var3 = 0.5F;
         float var8 = 0.5F;
         switch(var7) {
         case d:
            var8 = 0.9F;
            break;
         case c:
            var8 = 0.1F;
            break;
         case e:
            var3 = 0.1F;
            break;
         case f:
            var3 = 0.9F;
         }

         this.a(var7);
         this.b((double)((float)var1.n() + var3), (double)((float)var1.o() + 0.6875F), (double)((float)var1.p() + var8));
      } else {
         this.b((double)((float)var1.n() + 0.5F), (double)((float)var1.o() + 0.6875F), (double)((float)var1.p() + 0.5F));
      }

      this.bw = true;
      this.b = 0;
      this.bx = var1;
      this.v = this.x = this.w = 0.0D;
      if (!this.o.D) {
         this.o.d();
      }

      return wn.a.a;
   }

   public zx bZ() {
      return this.bi.h();
   }

   private Collection<auk> e(pk var1) {
      aul var2 = this.cp().h(this.e_());
      if (var2 != null) {
         int var3 = var2.l().b();
         if (var3 >= 0 && var3 < auu.i.length) {
            Iterator var4 = this.cp().a(auu.i[var3]).iterator();

            while(var4.hasNext()) {
               auk var5 = (auk)var4.next();
               aum var6 = this.cp().c(var1.e_(), var5);
               var6.a();
            }
         }
      }

      aul var7 = this.cp().h(var1.e_());
      if (var7 != null) {
         int var8 = var7.l().b();
         if (var8 >= 0 && var8 < auu.h.length) {
            return this.cp().a(auu.h[var8]);
         }
      }

      return Lists.newArrayList();
   }

   public boolean cm() {
      return this.bn() > 0.0F && this.bn() < this.bu();
   }

   public void b(mw var1) {
      this.a((mw)var1, 1);
   }

   public void a(ow var1) {
      super.a(var1);
      this.a(0.2F, 0.2F);
      this.b(this.s, this.t, this.u);
      this.w = 0.10000000149011612D;
      if (this.e_().equals("Notch")) {
         this.a(new zx(zy.e, 1), true, false);
      }

      if (!this.o.Q().b("keepInventory")) {
         this.bi.n();
      }

      if (var1 != null) {
         this.v = (double)(-ns.b((this.aw + this.y) * 3.1415927F / 180.0F) * 0.1F);
         this.x = (double)(-ns.a((this.aw + this.y) * 3.1415927F / 180.0F) * 0.1F);
      } else {
         this.v = this.x = 0.0D;
      }

      this.b(na.y);
      this.a(na.h);
   }

   public float bN() {
      return this.H().d(17);
   }

   public int ck() {
      if (this.bB >= 30) {
         return 112 + (this.bB - 30) * 9;
      } else {
         return this.bB >= 15 ? 37 + (this.bB - 15) * 5 : 7 + this.bB * 2;
      }
   }

   public boolean u(pk var1) {
      if (this.v()) {
         if (var1 instanceof og) {
            this.a((og)var1);
         }

         return false;
      } else {
         zx var2 = this.bZ();
         zx var3 = var2 != null ? var2.k() : null;
         if (!var1.e(this)) {
            if (var2 != null && var1 instanceof pr) {
               if (this.bA.d) {
                  var2 = var3;
               }

               if (var2.a(this, (pr)var1)) {
                  if (var2.b <= 0 && !this.bA.d) {
                     this.ca();
                  }

                  return true;
               }
            }

            return false;
         } else {
            if (var2 != null && var2 == this.bZ()) {
               if (var2.b <= 0 && !this.bA.d) {
                  this.ca();
               } else if (var2.b < var3.b && this.bA.d) {
                  var2.b = var3.b;
               }
            }

            return true;
         }
      }
   }

   public float ce() {
      if (this.bx != null) {
         cq var1 = (cq)this.o.p(this.bx).b(age.O);
         switch(var1) {
         case d:
            return 90.0F;
         case c:
            return 270.0F;
         case e:
            return 0.0F;
         case f:
            return 180.0F;
         }
      }

      return 0.0F;
   }

   public int cg() {
      return this.b;
   }

   public boolean b(afh var1) {
      return this.bi.b(var1);
   }

   public void bV() {
      this.g = null;
      this.h = 0;
      if (!this.o.D) {
         this.f(false);
      }

   }

   public uz a(boolean var1) {
      return this.a(this.bi.a(this.bi.c, var1 && this.bi.h() != null ? this.bi.h().b : 1), false, true);
   }

   public static UUID b(String var0) {
      return UUID.nameUUIDFromBytes(("OfflinePlayer:" + var0).getBytes(Charsets.UTF_8));
   }

   public boolean bJ() {
      return this.bw;
   }

   public void I() {
      this.a(0.6F, 1.8F);
      super.I();
      this.i(this.bu());
      this.ax = 0;
   }

   public int bR() {
      return this.h;
   }

   public void k(boolean var1) {
      this.bI = var1;
   }

   public boolean a(cj var1, cq var2, zx var3) {
      if (this.bA.e) {
         return true;
      } else if (var3 == null) {
         return false;
      } else {
         cj var4 = var1.a(var2.d());
         afh var5 = this.o.p(var4).c();
         return var3.d(var5) || var3.x();
      }
   }

   public boolean aL() {
      return !this.bA.b;
   }

   protected String aa() {
      return "game.player.swim.splash";
   }

   public void b(int var1) {
      this.bB -= var1;
      if (this.bB < 0) {
         this.bB = 0;
         this.bD = 0.0F;
         this.bC = 0;
      }

      this.f = this.V.nextInt();
   }

   public boolean j(boolean var1) {
      return (var1 || this.bl.c()) && !this.bA.a;
   }

   public boolean f(wn var1) {
      if (!this.ax()) {
         return false;
      } else if (var1.v()) {
         return false;
      } else {
         auq var2 = this.bO();
         return var2 == null || var1 == null || var1.bO() != var2 || !var2.h();
      }
   }

   public void a(tp var1, og var2) {
   }

   protected boolean bD() {
      return this.bn() <= 0.0F || this.bJ();
   }

   public void a(ol var1) {
   }

   public void a(mw var1) {
   }

   public void ca() {
      this.bi.a(this.bi.c, (zx)null);
   }

   public static enum b {
      private static final wn.b[] g = new wn.b[]{a, b, c};
      b(1, "options.chat.visibility.system"),
      c(2, "options.chat.visibility.hidden");

      private final int e;
      a(0, "options.chat.visibility.full");

      private final String f;
      private static final wn.b[] d = new wn.b[values().length];

      public String b() {
         return this.f;
      }

      private b(int var3, String var4) {
         this.e = var3;
         this.f = var4;
      }

      public int a() {
         return this.e;
      }

      static {
         wn.b[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            wn.b var3 = var0[var2];
            d[var3.e] = var3;
         }

      }

      public static wn.b a(int var0) {
         return d[var0 % d.length];
      }
   }

   public static enum a {
      e,
      d,
      c;

      private static final wn.a[] g = new wn.a[]{a, b, c, d, e, f};
      b,
      f,
      a;
   }
}
