import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public abstract class pk implements m {
   public float B;
   public float U;
   protected int al;
   public boolean E;
   protected boolean ak;
   public int af;
   public double q;
   public float S;
   public boolean ai;
   public adm o;
   public double v;
   public int Z;
   protected pz ac;
   public double s;
   public double p;
   protected Random V;
   public double t;
   public double r;
   private aug f;
   public float K;
   private boolean g;
   public int am;
   public boolean n;
   public boolean T;
   public double w;
   public float A;
   public pk l;
   public double P;
   public boolean I;
   private int h;
   public boolean G;
   public int W;
   private double ar;
   private int c;
   public boolean C;
   public int aj;
   public float y;
   public float M;
   public double Q;
   private final n au;
   private static final aug a = new aug(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
   public float N;
   public boolean ad;
   protected boolean aa;
   public boolean ah;
   public boolean D;
   private static int b;
   public int bY;
   public pk m;
   public int X;
   public int ag;
   protected aui ao;
   public double u;
   public float O;
   public float J;
   protected cq ap;
   protected boolean ab;
   public double R;
   private boolean at;
   public int bW;
   protected UUID aq;
   private double as;
   public int ae;
   public float L;
   public double j;
   public float z;
   public double x;
   public int bX;
   private int i;
   protected boolean Y;
   protected cj an;
   public boolean k;
   protected boolean H;
   public boolean F;

   public aui e(float var1) {
      if (var1 == 1.0F) {
         return new aui(this.s, this.t + (double)this.aS(), this.u);
      } else {
         double var2 = this.p + (this.s - this.p) * (double)var1;
         double var4 = this.q + (this.t - this.q) * (double)var1 + (double)this.aS();
         double var6 = this.r + (this.u - this.r) * (double)var1;
         return new aui(var2, var4, var6);
      }
   }

   public uz a(zx var1, float var2) {
      if (var1.b != 0 && var1.b() != null) {
         uz var3 = new uz(this.o, this.s, this.t + (double)var2, this.u, var1);
         var3.p();
         this.o.d((pk)var3);
         return var3;
      } else {
         return null;
      }
   }

   public boolean a(wn var1, aui var2) {
      return false;
   }

   public boolean b(ow var1) {
      return this.at && var1 != ow.j && !var1.u();
   }

   public void Y() {
      if (this.aw() && !this.V()) {
         this.Z();
      }

   }

   public boolean ai() {
      return !this.I;
   }

   public double am() {
      return 0.0D;
   }

   public double b(cj var1) {
      return var1.c(this.s, this.t, this.u);
   }

   public void G() {
      this.J();
   }

   public void f(dn var1) {
      try {
         du var2 = var1.c("Pos", 6);
         du var6 = var1.c("Motion", 6);
         du var7 = var1.c("Rotation", 5);
         this.v = var6.d(0);
         this.w = var6.d(1);
         this.x = var6.d(2);
         if (Math.abs(this.v) > 10.0D) {
            this.v = 0.0D;
         }

         if (Math.abs(this.w) > 10.0D) {
            this.w = 0.0D;
         }

         if (Math.abs(this.x) > 10.0D) {
            this.x = 0.0D;
         }

         this.p = this.P = this.s = var2.d(0);
         this.q = this.Q = this.t = var2.d(1);
         this.r = this.R = this.u = var2.d(2);
         this.A = this.y = var7.e(0);
         this.B = this.z = var7.e(1);
         this.f(this.y);
         this.g(this.y);
         this.O = var1.h("FallDistance");
         this.i = var1.e("Fire");
         this.h(var1.e("Air"));
         this.C = var1.n("OnGround");
         this.am = var1.f("Dimension");
         this.at = var1.n("Invulnerable");
         this.aj = var1.f("PortalCooldown");
         if (var1.b("UUIDMost", 4) && var1.b("UUIDLeast", 4)) {
            this.aq = new UUID(var1.g("UUIDMost"), var1.g("UUIDLeast"));
         } else if (var1.b("UUID", 8)) {
            this.aq = UUID.fromString(var1.j("UUID"));
         }

         this.b(this.s, this.t, this.u);
         this.b(this.y, this.z);
         if (var1.b("CustomName", 8) && var1.j("CustomName").length() > 0) {
            this.a(var1.j("CustomName"));
         }

         this.g(var1.n("CustomNameVisible"));
         this.au.a(var1);
         this.b(var1.n("Silent"));
         this.a(var1);
         if (this.af()) {
            this.b(this.s, this.t, this.u);
         }

      } catch (Throwable var5) {
         b var3 = b.a(var5, "Loading entity NBT");
         c var4 = var3.a("Entity being loaded");
         this.a(var4);
         throw new e(var3);
      }
   }

   public void a(String var1) {
      this.ac.b(2, var1);
   }

   public void b(pk var1, int var2) {
   }

   public double f(double var1, double var3, double var5) {
      double var7 = this.s - var1;
      double var9 = this.t - var3;
      double var11 = this.u - var5;
      return (double)ns.a(var7 * var7 + var9 * var9 + var11 * var11);
   }

   public void a(c var1) {
      var1.a("Entity Type", new Callable<String>(this) {
         final pk a;

         {
            this.a = var1;
         }

         public String a() throws Exception {
            return pm.b(this.a) + " (" + this.a.getClass().getCanonicalName() + ")";
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a((String)"Entity ID", (Object)this.c);
      var1.a("Entity Name", new Callable<String>(this) {
         final pk a;

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return this.a.e_();
         }
      });
      var1.a((String)"Entity's Exact location", (Object)String.format("%.2f, %.2f, %.2f", this.s, this.t, this.u));
      var1.a((String)"Entity's Block location", (Object)c.a((double)ns.c(this.s), (double)ns.c(this.t), (double)ns.c(this.u)));
      var1.a((String)"Entity's Momentum", (Object)String.format("%.2f, %.2f, %.2f", this.v, this.w, this.x));
      var1.a("Entity's Rider", new Callable<String>(this) {
         final pk a;

         public String a() throws Exception {
            return this.a.l.toString();
         }

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
      var1.a("Entity's Vehicle", new Callable<String>(this) {
         final pk a;

         {
            this.a = var1;
         }

         public String a() throws Exception {
            return this.a.m.toString();
         }

         public Object call() throws Exception {
            return this.a();
         }
      });
   }

   public void a(byte var1) {
   }

   public boolean aI() {
      return false;
   }

   public boolean av() {
      return this.g(1);
   }

   public int L() {
      return 0;
   }

   public boolean f(wn var1) {
      return var1.v() ? false : this.ax();
   }

   public zx[] as() {
      return null;
   }

   public void e(dn var1) {
      try {
         var1.a((String)"Pos", (eb)this.a(this.s, this.t, this.u));
         var1.a((String)"Motion", (eb)this.a(this.v, this.w, this.x));
         var1.a((String)"Rotation", (eb)this.a(this.y, this.z));
         var1.a("FallDistance", this.O);
         var1.a("Fire", (short)this.i);
         var1.a("Air", (short)this.az());
         var1.a("OnGround", this.C);
         var1.a("Dimension", this.am);
         var1.a("Invulnerable", this.at);
         var1.a("PortalCooldown", this.aj);
         var1.a("UUIDMost", this.aK().getMostSignificantBits());
         var1.a("UUIDLeast", this.aK().getLeastSignificantBits());
         if (this.aM() != null && this.aM().length() > 0) {
            var1.a("CustomName", this.aM());
            var1.a("CustomNameVisible", this.aN());
         }

         this.au.b(var1);
         if (this.R()) {
            var1.a("Silent", this.R());
         }

         this.b(var1);
         if (this.m != null) {
            dn var2 = new dn();
            if (this.m.c(var2)) {
               var1.a((String)"Riding", (eb)var2);
            }
         }

      } catch (Throwable var5) {
         b var3 = b.a(var5, "Saving entity NBT");
         c var4 = var3.a("Entity being saved");
         this.a(var4);
         throw new e(var3);
      }
   }

   private void m() {
      this.s = (this.aR().a + this.aR().d) / 2.0D;
      this.t = this.aR().b;
      this.u = (this.aR().c + this.aR().f) / 2.0D;
   }

   public UUID aK() {
      return this.aq;
   }

   public cq aH() {
      return this.ap;
   }

   public void al() {
      if (this.l != null) {
         this.l.b(this.s, this.t + this.an() + this.l.am(), this.u);
      }
   }

   protected String P() {
      return "game.neutral.swim";
   }

   public void g(boolean var1) {
      this.ac.b(3, Byte.valueOf((byte)(var1 ? 1 : 0)));
   }

   public int b(float var1) {
      cj var2 = new cj(this.s, this.t + (double)this.aS(), this.u);
      return this.o.e(var2) ? this.o.b(var2, 0) : 0;
   }

   public boolean c(dn var1) {
      String var2 = this.ag();
      if (!this.I && var2 != null) {
         var1.a("id", var2);
         this.e(var1);
         return true;
      } else {
         return false;
      }
   }

   public pk(adm var1) {
      this.c = b++;
      this.j = 1.0D;
      this.f = a;
      this.J = 0.6F;
      this.K = 1.8F;
      this.h = 1;
      this.V = new Random();
      this.X = 1;
      this.aa = true;
      this.aq = ns.a(this.V);
      this.au = new n();
      this.o = var1;
      this.b(0.0D, 0.0D, 0.0D);
      if (var1 != null) {
         this.am = var1.t.q();
      }

      this.ac = new pz(this);
      this.ac.a(0, (byte)0);
      this.ac.a(1, (short)300);
      this.ac.a(3, (byte)0);
      this.ac.a(2, "");
      this.ac.a(4, (byte)0);
      this.h();
   }

   public cj c() {
      return new cj(this.s, this.t + 0.5D, this.u);
   }

   public aug S() {
      return null;
   }

   public void h(int var1) {
      this.ac.b(1, (short)var1);
   }

   public uz a(zw var1, int var2) {
      return this.a(var1, var2, 0.0F);
   }

   public void ar() {
   }

   public void c(float var1, float var2) {
      float var3 = this.z;
      float var4 = this.y;
      this.y = (float)((double)this.y + (double)var1 * 0.15D);
      this.z = (float)((double)this.z - (double)var2 * 0.15D);
      this.z = ns.a(this.z, -90.0F, 90.0F);
      this.B += this.z - var3;
      this.A += this.y - var4;
   }

   public void c(int var1) {
      if (!this.o.D && !this.I) {
         this.o.B.a("changeDimension");
         MinecraftServer var2 = MinecraftServer.N();
         int var3 = this.am;
         le var4 = var2.a(var3);
         le var5 = var2.a(var1);
         this.am = var1;
         if (var3 == 1 && var1 == 1) {
            var5 = var2.a(0);
            this.am = 0;
         }

         this.o.e(this);
         this.I = false;
         this.o.B.a("reposition");
         var2.ap().a(this, var3, var4, var5);
         this.o.B.c("reloading");
         pk var6 = pm.a((String)pm.b(this), (adm)var5);
         if (var6 != null) {
            var6.n(this);
            if (var3 == 1 && var1 == 1) {
               cj var7 = this.o.r(var5.M());
               var6.a(var7, var6.y, var6.z);
            }

            var5.d(var6);
         }

         this.I = true;
         this.o.B.b();
         var4.j();
         var5.j();
         this.o.B.b();
      }
   }

   public boolean h(double var1, double var3, double var5) {
      double var7 = this.s - var1;
      double var9 = this.t - var3;
      double var11 = this.u - var5;
      double var13 = var7 * var7 + var9 * var9 + var11 * var11;
      return this.a(var13);
   }

   protected abstract void h();

   public void a(adm var1) {
      this.o = var1;
   }

   public void K() {
      this.o.B.a("entityBaseTick");
      if (this.m != null && this.m.I) {
         this.m = null;
      }

      this.L = this.M;
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.B = this.z;
      this.A = this.y;
      if (!this.o.D && this.o instanceof le) {
         this.o.B.a("portal");
         MinecraftServer var1 = ((le)this.o).r();
         int var2 = this.L();
         if (this.ak) {
            if (var1.C()) {
               if (this.m == null && this.al++ >= var2) {
                  this.al = var2;
                  this.aj = this.aq();
                  byte var3;
                  if (this.o.t.q() == -1) {
                     var3 = 0;
                  } else {
                     var3 = -1;
                  }

                  this.c(var3);
               }

               this.ak = false;
            }
         } else {
            if (this.al > 0) {
               this.al -= 4;
            }

            if (this.al < 0) {
               this.al = 0;
            }
         }

         if (this.aj > 0) {
            --this.aj;
         }

         this.o.B.b();
      }

      this.Y();
      this.W();
      if (this.o.D) {
         this.i = 0;
      } else if (this.i > 0) {
         if (this.ab) {
            this.i -= 4;
            if (this.i < 0) {
               this.i = 0;
            }
         } else {
            if (this.i % 20 == 0) {
               this.a(ow.c, 1.0F);
            }

            --this.i;
         }
      }

      if (this.ab()) {
         this.M();
         this.O *= 0.5F;
      }

      if (this.t < -64.0D) {
         this.O();
      }

      if (!this.o.D) {
         this.b(0, this.i > 0);
      }

      this.aa = false;
      this.o.B.b();
   }

   public void a(double var1, double var3, double var5, float var7, float var8, int var9, boolean var10) {
      this.b(var1, var3, var5);
      this.b(var7, var8);
      List var11 = this.o.a(this, this.aR().d(0.03125D, 0.0D, 0.03125D));
      if (!var11.isEmpty()) {
         double var12 = 0.0D;
         Iterator var14 = var11.iterator();

         while(var14.hasNext()) {
            aug var15 = (aug)var14.next();
            if (var15.e > var12) {
               var12 = var15.e;
            }
         }

         var3 += var12 - this.aR().b;
         this.b(var1, var3, var5);
      }

   }

   protected String aa() {
      return "game.neutral.swim.splash";
   }

   public aui aG() {
      return this.ao;
   }

   public void a(n.a var1, int var2) {
      this.au.a(this, var1, var2);
   }

   public boolean d(dn var1) {
      String var2 = this.ag();
      if (!this.I && var2 != null && this.l == null) {
         var1.a("id", var2);
         this.e(var1);
         return true;
      } else {
         return false;
      }
   }

   protected void Z() {
      int var1 = ns.c(this.s);
      int var2 = ns.c(this.t - 0.20000000298023224D);
      int var3 = ns.c(this.u);
      cj var4 = new cj(var1, var2, var3);
      alz var5 = this.o.p(var4);
      afh var6 = var5.c();
      if (var6.b() != -1) {
         this.o.a(cy.L, this.s + ((double)this.V.nextFloat() - 0.5D) * (double)this.J, this.aR().b + 0.1D, this.u + ((double)this.V.nextFloat() - 0.5D) * (double)this.J, -this.v * 4.0D, 1.5D, -this.x * 4.0D, afh.f(var5));
      }

   }

   public void d(int var1) {
      this.c = var1;
   }

   public void n(pk var1) {
      dn var2 = new dn();
      var1.e(var2);
      this.f(var2);
      this.aj = var1.aj;
      this.an = var1.an;
      this.ao = var1.ao;
      this.ap = var1.ap;
   }

   public boolean aw() {
      return this.g(3);
   }

   public boolean a(int var1, String var2) {
      return true;
   }

   public void a(String var1, float var2, float var3) {
      if (!this.R()) {
         this.o.a(this, var1, var2, var3);
      }

   }

   public int F() {
      return this.c;
   }

   public void a(pk var1) {
      this.ar = 0.0D;
      this.as = 0.0D;
      if (var1 == null) {
         if (this.m != null) {
            this.b(this.m.s, this.m.aR().b + (double)this.m.K, this.m.u, this.y, this.z);
            this.m.l = null;
         }

         this.m = null;
      } else {
         if (this.m != null) {
            this.m.l = null;
         }

         if (var1 != null) {
            for(pk var2 = var1.m; var2 != null; var2 = var2.m) {
               if (var2 == this) {
                  return;
               }
            }
         }

         this.m = var1;
         var1.l = this;
      }
   }

   public void d(wn var1) {
   }

   public void i(int var1) {
   }

   public int aq() {
      return 300;
   }

   protected void Q() {
      cj var1 = new cj(this.aR().a + 0.001D, this.aR().b + 0.001D, this.aR().c + 0.001D);
      cj var2 = new cj(this.aR().d - 0.001D, this.aR().e - 0.001D, this.aR().f - 0.001D);
      if (this.o.a(var1, var2)) {
         for(int var3 = var1.n(); var3 <= var2.n(); ++var3) {
            for(int var4 = var1.o(); var4 <= var2.o(); ++var4) {
               for(int var5 = var1.p(); var5 <= var2.p(); ++var5) {
                  cj var6 = new cj(var3, var4, var5);
                  alz var7 = this.o.p(var6);

                  try {
                     var7.c().a(this.o, var6, var7, this);
                  } catch (Throwable var11) {
                     b var9 = b.a(var11, "Colliding entity with block");
                     c var10 = var9.a("Block being collided with");
                     c.a(var10, var6, var7);
                     throw new e(var9);
                  }
               }
            }
         }
      }

   }

   public void a(float var1, float var2, float var3) {
      float var4 = var1 * var1 + var2 * var2;
      if (!(var4 < 1.0E-4F)) {
         var4 = ns.c(var4);
         if (var4 < 1.0F) {
            var4 = 1.0F;
         }

         var4 = var3 / var4;
         var1 *= var4;
         var2 *= var4;
         float var5 = ns.a(this.y * 3.1415927F / 180.0F);
         float var6 = ns.b(this.y * 3.1415927F / 180.0F);
         this.v += (double)(var1 * var6 - var2 * var5);
         this.x += (double)(var2 * var6 + var1 * var5);
      }
   }

   public void h(boolean var1) {
      this.g = var1;
   }

   protected du a(double... var1) {
      du var2 = new du();
      double[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         var2.a((eb)(new dp(var6)));
      }

      return var2;
   }

   protected void M() {
      if (!this.ab) {
         this.a(ow.d, 4.0F);
         this.e(15);
      }
   }

   public boolean ab() {
      return this.o.a(this.aR().b(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), arm.i);
   }

   public boolean a(lf var1) {
      return true;
   }

   public boolean aJ() {
      return this.at();
   }

   public int aE() {
      return 3;
   }

   protected void I() {
      if (this.o != null) {
         while(this.t > 0.0D && this.t < 256.0D) {
            this.b(this.s, this.t, this.u);
            if (this.o.a(this, this.aR()).isEmpty()) {
               break;
            }

            ++this.t;
         }

         this.v = this.w = this.x = 0.0D;
         this.z = 0.0F;
      }
   }

   public cq aP() {
      return cq.b(ns.c((double)(this.y * 4.0F / 360.0F) + 0.5D) & 3);
   }

   public String e_() {
      if (this.l_()) {
         return this.aM();
      } else {
         String var1 = pm.b(this);
         if (var1 == null) {
            var1 = "generic";
         }

         return di.a("entity." + var1 + ".name");
      }
   }

   public void aA() {
      this.H = true;
      this.O = 0.0F;
   }

   public uz a(zw var1, int var2, float var3) {
      return this.a(new zx(var1, var2, 0), var3);
   }

   public void i(pk var1) {
      if (var1.l != this && var1.m != this) {
         if (!var1.T && !this.T) {
            double var2 = var1.s - this.s;
            double var4 = var1.u - this.u;
            double var6 = ns.a(var2, var4);
            if (var6 >= 0.009999999776482582D) {
               var6 = (double)ns.a(var6);
               var2 /= var6;
               var4 /= var6;
               double var8 = 1.0D / var6;
               if (var8 > 1.0D) {
                  var8 = 1.0D;
               }

               var2 *= var8;
               var4 *= var8;
               var2 *= 0.05000000074505806D;
               var4 *= 0.05000000074505806D;
               var2 *= (double)(1.0F - this.U);
               var4 *= (double)(1.0F - this.U);
               if (this.l == null) {
                  this.g(-var2, 0.0D, -var4);
               }

               if (var1.l == null) {
                  var1.g(var2, 0.0D, var4);
               }
            }

         }
      }
   }

   public void d(cj var1) {
      if (this.aj > 0) {
         this.aj = this.aq();
      } else {
         if (!this.o.D && !var1.equals(this.an)) {
            this.an = var1;
            amd.b var2 = afi.aY.f(this.o, var1);
            double var3 = var2.b().k() == cq.a.a ? (double)var2.a().p() : (double)var2.a().n();
            double var5 = var2.b().k() == cq.a.a ? this.u : this.s;
            var5 = Math.abs(ns.c(var5 - (double)(var2.b().e().c() == cq.b.b ? 1 : 0), var3, var3 - (double)var2.d()));
            double var7 = ns.c(this.t - 1.0D, (double)var2.a().o(), (double)(var2.a().o() - var2.e()));
            this.ao = new aui(var5, var7, 0.0D);
            this.ap = var2.b();
         }

         this.ak = true;
      }
   }

   public void e(boolean var1) {
      this.b(5, var1);
   }

   public boolean d(int var1, zx var2) {
      return false;
   }

   public boolean au() {
      return this.m != null;
   }

   public void c(int var1, zx var2) {
   }

   public boolean e(wn var1) {
      return false;
   }

   public aug j(pk var1) {
      return null;
   }

   protected void a(pr var1, pk var2) {
      if (var2 instanceof pr) {
         ack.a((pr)((pr)var2), (pk)var1);
      }

      ack.b(var1, var2);
   }

   public aug aR() {
      return this.f;
   }

   public void o(pk var1) {
      this.au.a(var1.aU());
   }

   public double e(double var1, double var3, double var5) {
      double var7 = this.s - var1;
      double var9 = this.t - var3;
      double var11 = this.u - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   protected void b(int var1, boolean var2) {
      byte var3 = this.ac.a(0);
      if (var2) {
         this.ac.b(0, (byte)(var3 | 1 << var1));
      } else {
         this.ac.b(0, (byte)(var3 & ~(1 << var1)));
      }

   }

   protected void b(float var1, float var2) {
      this.y = var1 % 360.0F;
      this.z = var2 % 360.0F;
   }

   public pk f() {
      return this;
   }

   public void b(boolean var1) {
      this.ac.b(4, Byte.valueOf((byte)(var1 ? 1 : 0)));
   }

   public void a(pr var1) {
   }

   public boolean aL() {
      return true;
   }

   public eu f_() {
      fa var1 = new fa(this.e_());
      var1.b().a(this.aQ());
      var1.b().a(this.aK().toString());
      return var1;
   }

   public float ao() {
      return 0.1F;
   }

   public void a(cj var1, float var2, float var3) {
      this.b((double)var1.n() + 0.5D, (double)var1.o(), (double)var1.p() + 0.5D, var2, var3);
   }

   public boolean l(pk var1) {
      return false;
   }

   public boolean a(double var1) {
      double var3 = this.aR().a();
      if (Double.isNaN(var3)) {
         var3 = 1.0D;
      }

      var3 *= 64.0D * this.j;
      return var1 < var3 * var3;
   }

   protected final aui f(float var1, float var2) {
      float var3 = ns.b(-var2 * 0.017453292F - 3.1415927F);
      float var4 = ns.a(-var2 * 0.017453292F - 3.1415927F);
      float var5 = -ns.b(-var1 * 0.017453292F);
      float var6 = ns.a(-var1 * 0.017453292F);
      return new aui((double)(var4 * var5), (double)var6, (double)(var3 * var5));
   }

   public void e(int var1) {
      int var2 = var1 * 20;
      var2 = acr.a(this, var2);
      if (this.i < var2) {
         this.i = var2;
      }

   }

   protected void X() {
      float var1 = ns.a(this.v * this.v * 0.20000000298023224D + this.w * this.w + this.x * this.x * 0.20000000298023224D) * 0.2F;
      if (var1 > 1.0F) {
         var1 = 1.0F;
      }

      this.a(this.aa(), var1, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
      float var2 = (float)ns.c(this.aR().b);

      int var3;
      float var4;
      float var5;
      for(var3 = 0; (float)var3 < 1.0F + this.J * 20.0F; ++var3) {
         var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
         var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
         this.o.a(cy.e, this.s + (double)var4, (double)(var2 + 1.0F), this.u + (double)var5, this.v, this.w - (double)(this.V.nextFloat() * 0.2F), this.x);
      }

      for(var3 = 0; (float)var3 < 1.0F + this.J * 20.0F; ++var3) {
         var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
         var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J;
         this.o.a(cy.f, this.s + (double)var4, (double)(var2 + 1.0F), this.u + (double)var5, this.v, this.w, this.x);
      }

   }

   public float g(pk var1) {
      float var2 = (float)(this.s - var1.s);
      float var3 = (float)(this.t - var1.t);
      float var4 = (float)(this.u - var1.u);
      return ns.c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public void d(boolean var1) {
      this.b(3, var1);
   }

   public void a(double var1, double var3, double var5, float var7, float var8) {
      this.p = this.s = var1;
      this.q = this.t = var3;
      this.r = this.u = var5;
      this.A = this.y = var7;
      this.B = this.z = var8;
      double var9 = (double)(this.A - var7);
      if (var9 < -180.0D) {
         this.A += 360.0F;
      }

      if (var9 >= 180.0D) {
         this.A -= 360.0F;
      }

      this.b(this.s, this.t, this.u);
      this.b(var7, var8);
   }

   protected abstract void b(dn var1);

   public boolean W() {
      if (this.o.a(this.aR().b(0.0D, -0.4000000059604645D, 0.0D).d(0.001D, 0.001D, 0.001D), arm.h, this)) {
         if (!this.Y && !this.aa) {
            this.X();
         }

         this.O = 0.0F;
         this.Y = true;
         this.i = 0;
      } else {
         this.Y = false;
      }

      return this.Y;
   }

   protected boolean g(int var1) {
      return (this.ac.a(0) & 1 << var1) != 0;
   }

   public boolean aD() {
      return true;
   }

   public void f(float var1) {
   }

   public void g(dn var1) {
   }

   public void a(eu var1) {
   }

   public void t_() {
      this.K();
   }

   private boolean b(aug var1) {
      return this.o.a(this, var1).isEmpty() && !this.o.d(var1);
   }

   public boolean equals(Object var1) {
      if (var1 instanceof pk) {
         return ((pk)var1).c == this.c;
      } else {
         return false;
      }
   }

   public void a(uv var1) {
      this.a(ow.b, 5.0F);
      ++this.i;
      if (this.i == 0) {
         this.e(8);
      }

   }

   protected final String ag() {
      return pm.b(this);
   }

   public float a(adi var1, adm var2, cj var3, alz var4) {
      return var4.c().a(this);
   }

   protected void a(double var1, boolean var3, afh var4, cj var5) {
      if (var3) {
         if (this.O > 0.0F) {
            if (var4 != null) {
               var4.a(this.o, var5, this, this.O);
            } else {
               this.e(this.O, 1.0F);
            }

            this.O = 0.0F;
         }
      } else if (var1 < 0.0D) {
         this.O = (float)((double)this.O - var1);
      }

   }

   public adm e() {
      return this.o;
   }

   protected void a(float var1, float var2) {
      if (var1 != this.J || var2 != this.K) {
         float var3 = this.J;
         this.J = var1;
         this.K = var2;
         this.a(new aug(this.aR().a, this.aR().b, this.aR().c, this.aR().a + (double)this.J, this.aR().b + (double)this.K, this.aR().c + (double)this.J));
         if (this.J > var3 && !this.aa && !this.o.D) {
            this.d((double)(var3 - this.J), 0.0D, (double)(var3 - this.J));
         }
      }

   }

   protected ew aQ() {
      dn var1 = new dn();
      String var2 = pm.b(this);
      var1.a("id", this.aK().toString());
      if (var2 != null) {
         var1.a("type", var2);
      }

      var1.a("name", this.e_());
      return new ew(ew.a.d, new fa(var1.toString()));
   }

   public void g(float var1) {
   }

   public boolean ax() {
      return this.g(5);
   }

   public double an() {
      return (double)this.K * 0.75D;
   }

   public final boolean T() {
      return this.ab;
   }

   protected boolean j(double var1, double var3, double var5) {
      cj var7 = new cj(var1, var3, var5);
      double var8 = var1 - (double)var7.n();
      double var10 = var3 - (double)var7.o();
      double var12 = var5 - (double)var7.p();
      List var14 = this.o.a(this.aR());
      if (var14.isEmpty() && !this.o.u(var7)) {
         return false;
      } else {
         byte var15 = 3;
         double var16 = 9999.0D;
         if (!this.o.u(var7.e()) && var8 < var16) {
            var16 = var8;
            var15 = 0;
         }

         if (!this.o.u(var7.f()) && 1.0D - var8 < var16) {
            var16 = 1.0D - var8;
            var15 = 1;
         }

         if (!this.o.u(var7.a()) && 1.0D - var10 < var16) {
            var16 = 1.0D - var10;
            var15 = 3;
         }

         if (!this.o.u(var7.c()) && var12 < var16) {
            var16 = var12;
            var15 = 4;
         }

         if (!this.o.u(var7.d()) && 1.0D - var12 < var16) {
            var16 = 1.0D - var12;
            var15 = 5;
         }

         float var18 = this.V.nextFloat() * 0.2F + 0.1F;
         if (var15 == 0) {
            this.v = (double)(-var18);
         }

         if (var15 == 1) {
            this.v = (double)var18;
         }

         if (var15 == 3) {
            this.w = (double)var18;
         }

         if (var15 == 4) {
            this.x = (double)(-var18);
         }

         if (var15 == 5) {
            this.x = (double)var18;
         }

         return true;
      }
   }

   public void a(double var1, double var3, double var5) {
      this.b(var1, var3, var5, this.y, this.z);
   }

   public boolean l_() {
      return this.ac.e(2).length() > 0;
   }

   protected void f(int var1) {
      if (!this.ab) {
         this.a(ow.a, (float)var1);
      }

   }

   public boolean aW() {
      return false;
   }

   public void g(double var1, double var3, double var5) {
      this.v += var1;
      this.w += var3;
      this.x += var5;
      this.ai = true;
   }

   public boolean U() {
      return this.Y || this.o.C(new cj(this.s, this.t, this.u)) || this.o.C(new cj(this.s, this.t + (double)this.K, this.u));
   }

   public boolean a(ow var1, float var2) {
      if (this.b(var1)) {
         return false;
      } else {
         this.ac();
         return false;
      }
   }

   public void J() {
      this.I = true;
   }

   protected boolean af() {
      return true;
   }

   public void N() {
      this.i = 0;
   }

   public boolean aO() {
      return this.aN();
   }

   public boolean c(double var1, double var3, double var5) {
      aug var7 = this.aR().c(var1, var3, var5);
      return this.b(var7);
   }

   public int az() {
      return this.ac.b(1);
   }

   public double c(cj var1) {
      return var1.d(this.s, this.t, this.u);
   }

   protected void ac() {
      this.G = true;
   }

   public void ah() {
   }

   public void b(double var1, double var3, double var5) {
      this.s = var1;
      this.t = var3;
      this.u = var5;
      float var7 = this.J / 2.0F;
      float var8 = this.K;
      this.a(new aug(var1 - (double)var7, var3, var5 - (double)var7, var1 + (double)var7, var3 + (double)var8, var5 + (double)var7));
   }

   public boolean ay() {
      return this.g(4);
   }

   public void b(double var1, double var3, double var5, float var7, float var8) {
      this.P = this.p = this.s = var1;
      this.Q = this.q = this.t = var3;
      this.R = this.r = this.u = var5;
      this.y = var7;
      this.z = var8;
      this.b(this.s, this.t, this.u);
   }

   public float c(float var1) {
      cj var2 = new cj(this.s, this.t + (double)this.aS(), this.u);
      return this.o.e(var2) ? this.o.o(var2) : 0.0F;
   }

   public void a(aug var1) {
      this.f = var1;
   }

   protected du a(float... var1) {
      du var2 = new du();
      float[] var3 = var1;
      int var4 = var1.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         float var6 = var3[var5];
         var2.a((eb)(new dr(var6)));
      }

      return var2;
   }

   public boolean aj() {
      if (this.T) {
         return false;
      } else {
         cj.a var1 = new cj.a(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);

         for(int var2 = 0; var2 < 8; ++var2) {
            int var3 = ns.c(this.t + (double)(((float)((var2 >> 0) % 2) - 0.5F) * 0.1F) + (double)this.aS());
            int var4 = ns.c(this.s + (double)(((float)((var2 >> 1) % 2) - 0.5F) * this.J * 0.8F));
            int var5 = ns.c(this.u + (double)(((float)((var2 >> 2) % 2) - 0.5F) * this.J * 0.8F));
            if (var1.n() != var4 || var1.o() != var3 || var1.p() != var5) {
               var1.c(var4, var3, var5);
               if (this.o.p(var1).c().w()) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   protected boolean s_() {
      return true;
   }

   public boolean a(arm var1) {
      double var2 = this.t + (double)this.aS();
      cj var4 = new cj(this.s, var2, this.u);
      alz var5 = this.o.p(var4);
      afh var6 = var5.c();
      if (var6.t() == var1) {
         float var7 = ahv.b(var5.c().c(var5)) - 0.11111111F;
         float var8 = (float)(var4.o() + 1) - var7;
         boolean var9 = var2 < (double)var8;
         return !var9 && this instanceof wn ? false : var9;
      } else {
         return false;
      }
   }

   protected abstract void a(dn var1);

   public aui d() {
      return new aui(this.s, this.t, this.u);
   }

   public void i(double var1, double var3, double var5) {
      this.v = var1;
      this.w = var3;
      this.x = var5;
   }

   public n aU() {
      return this.au;
   }

   public boolean ae() {
      return false;
   }

   public void d(double var1, double var3, double var5) {
      if (this.T) {
         this.a(this.aR().c(var1, var3, var5));
         this.m();
      } else {
         this.o.B.a("move");
         double var7 = this.s;
         double var9 = this.t;
         double var11 = this.u;
         if (this.H) {
            this.H = false;
            var1 *= 0.25D;
            var3 *= 0.05000000074505806D;
            var5 *= 0.25D;
            this.v = 0.0D;
            this.w = 0.0D;
            this.x = 0.0D;
         }

         double var13 = var1;
         double var15 = var3;
         double var17 = var5;
         boolean var19 = this.C && this.av() && this instanceof wn;
         if (var19) {
            double var20;
            for(var20 = 0.05D; var1 != 0.0D && this.o.a(this, this.aR().c(var1, -1.0D, 0.0D)).isEmpty(); var13 = var1) {
               if (var1 < var20 && var1 >= -var20) {
                  var1 = 0.0D;
               } else if (var1 > 0.0D) {
                  var1 -= var20;
               } else {
                  var1 += var20;
               }
            }

            for(; var5 != 0.0D && this.o.a(this, this.aR().c(0.0D, -1.0D, var5)).isEmpty(); var17 = var5) {
               if (var5 < var20 && var5 >= -var20) {
                  var5 = 0.0D;
               } else if (var5 > 0.0D) {
                  var5 -= var20;
               } else {
                  var5 += var20;
               }
            }

            for(; var1 != 0.0D && var5 != 0.0D && this.o.a(this, this.aR().c(var1, -1.0D, var5)).isEmpty(); var17 = var5) {
               if (var1 < var20 && var1 >= -var20) {
                  var1 = 0.0D;
               } else if (var1 > 0.0D) {
                  var1 -= var20;
               } else {
                  var1 += var20;
               }

               var13 = var1;
               if (var5 < var20 && var5 >= -var20) {
                  var5 = 0.0D;
               } else if (var5 > 0.0D) {
                  var5 -= var20;
               } else {
                  var5 += var20;
               }
            }
         }

         List var53 = this.o.a(this, this.aR().a(var1, var3, var5));
         aug var21 = this.aR();

         aug var23;
         for(Iterator var22 = var53.iterator(); var22.hasNext(); var3 = var23.b(this.aR(), var3)) {
            var23 = (aug)var22.next();
         }

         this.a(this.aR().c(0.0D, var3, 0.0D));
         boolean var54 = this.C || var15 != var3 && var15 < 0.0D;

         aug var24;
         Iterator var55;
         for(var55 = var53.iterator(); var55.hasNext(); var1 = var24.a(this.aR(), var1)) {
            var24 = (aug)var55.next();
         }

         this.a(this.aR().c(var1, 0.0D, 0.0D));

         for(var55 = var53.iterator(); var55.hasNext(); var5 = var24.c(this.aR(), var5)) {
            var24 = (aug)var55.next();
         }

         this.a(this.aR().c(0.0D, 0.0D, var5));
         if (this.S > 0.0F && var54 && (var13 != var1 || var17 != var5)) {
            double var56 = var1;
            double var25 = var3;
            double var27 = var5;
            aug var29 = this.aR();
            this.a(var21);
            var3 = (double)this.S;
            List var30 = this.o.a(this, this.aR().a(var13, var3, var17));
            aug var31 = this.aR();
            aug var32 = var31.a(var13, 0.0D, var17);
            double var33 = var3;

            aug var36;
            for(Iterator var35 = var30.iterator(); var35.hasNext(); var33 = var36.b(var32, var33)) {
               var36 = (aug)var35.next();
            }

            var31 = var31.c(0.0D, var33, 0.0D);
            double var67 = var13;

            aug var38;
            for(Iterator var37 = var30.iterator(); var37.hasNext(); var67 = var38.a(var31, var67)) {
               var38 = (aug)var37.next();
            }

            var31 = var31.c(var67, 0.0D, 0.0D);
            double var68 = var17;

            aug var40;
            for(Iterator var39 = var30.iterator(); var39.hasNext(); var68 = var40.c(var31, var68)) {
               var40 = (aug)var39.next();
            }

            var31 = var31.c(0.0D, 0.0D, var68);
            aug var69 = this.aR();
            double var70 = var3;

            aug var43;
            for(Iterator var42 = var30.iterator(); var42.hasNext(); var70 = var43.b(var69, var70)) {
               var43 = (aug)var42.next();
            }

            var69 = var69.c(0.0D, var70, 0.0D);
            double var71 = var13;

            aug var45;
            for(Iterator var44 = var30.iterator(); var44.hasNext(); var71 = var45.a(var69, var71)) {
               var45 = (aug)var44.next();
            }

            var69 = var69.c(var71, 0.0D, 0.0D);
            double var72 = var17;

            aug var47;
            for(Iterator var46 = var30.iterator(); var46.hasNext(); var72 = var47.c(var69, var72)) {
               var47 = (aug)var46.next();
            }

            var69 = var69.c(0.0D, 0.0D, var72);
            double var73 = var67 * var67 + var68 * var68;
            double var48 = var71 * var71 + var72 * var72;
            if (var73 > var48) {
               var1 = var67;
               var5 = var68;
               var3 = -var33;
               this.a(var31);
            } else {
               var1 = var71;
               var5 = var72;
               var3 = -var70;
               this.a(var69);
            }

            aug var51;
            for(Iterator var50 = var30.iterator(); var50.hasNext(); var3 = var51.b(this.aR(), var3)) {
               var51 = (aug)var50.next();
            }

            this.a(this.aR().c(0.0D, var3, 0.0D));
            if (var56 * var56 + var27 * var27 >= var1 * var1 + var5 * var5) {
               var1 = var56;
               var3 = var25;
               var5 = var27;
               this.a(var29);
            }
         }

         this.o.B.b();
         this.o.B.a("rest");
         this.m();
         this.D = var13 != var1 || var17 != var5;
         this.E = var15 != var3;
         this.C = this.E && var15 < 0.0D;
         this.F = this.D || this.E;
         int var57 = ns.c(this.s);
         int var58 = ns.c(this.t - 0.20000000298023224D);
         int var59 = ns.c(this.u);
         cj var26 = new cj(var57, var58, var59);
         afh var60 = this.o.p(var26).c();
         if (var60.t() == arm.a) {
            afh var28 = this.o.p(var26.b()).c();
            if (var28 instanceof agt || var28 instanceof akl || var28 instanceof agu) {
               var60 = var28;
               var26 = var26.b();
            }
         }

         this.a(var3, this.C, var60, var26);
         if (var13 != var1) {
            this.v = 0.0D;
         }

         if (var17 != var5) {
            this.x = 0.0D;
         }

         if (var15 != var3) {
            var60.a(this.o, this);
         }

         if (this.s_() && !var19 && this.m == null) {
            double var61 = this.s - var7;
            double var64 = this.t - var9;
            double var66 = this.u - var11;
            if (var60 != afi.au) {
               var64 = 0.0D;
            }

            if (var60 != null && this.C) {
               var60.a(this.o, var26, this);
            }

            this.M = (float)((double)this.M + (double)ns.a(var61 * var61 + var66 * var66) * 0.6D);
            this.N = (float)((double)this.N + (double)ns.a(var61 * var61 + var64 * var64 + var66 * var66) * 0.6D);
            if (this.N > (float)this.h && var60.t() != arm.a) {
               this.h = (int)this.N + 1;
               if (this.V()) {
                  float var34 = ns.a(this.v * this.v * 0.20000000298023224D + this.w * this.w + this.x * this.x * 0.20000000298023224D) * 0.35F;
                  if (var34 > 1.0F) {
                     var34 = 1.0F;
                  }

                  this.a(this.P(), var34, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
               }

               this.a(var26, var60);
            }
         }

         try {
            this.Q();
         } catch (Throwable var52) {
            b var63 = b.a(var52, "Checking entity block collision");
            c var65 = var63.a("Entity being checked for collision");
            this.a(var65);
            throw new e(var63);
         }

         boolean var62 = this.U();
         if (this.o.e(this.aR().d(0.001D, 0.001D, 0.001D))) {
            this.f(1);
            if (!var62) {
               ++this.i;
               if (this.i == 0) {
                  this.e(8);
               }
            }
         } else if (this.i <= 0) {
            this.i = -this.X;
         }

         if (var62 && this.i > 0) {
            this.a("random.fizz", 0.7F, 1.6F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
            this.i = -this.X;
         }

         this.o.B.b();
      }
   }

   protected void a(cj var1, afh var2) {
      afh.b var3 = var2.H;
      if (this.o.p(var1.a()).c() == afi.aH) {
         var3 = afi.aH.H;
         this.a(var3.c(), var3.d() * 0.15F, var3.e());
      } else if (!var2.t().d()) {
         this.a(var3.c(), var3.d() * 0.15F, var3.e());
      }

   }

   public boolean V() {
      return this.Y;
   }

   public boolean aN() {
      return this.ac.a(3) == 1;
   }

   public aui d(float var1) {
      if (var1 == 1.0F) {
         return this.f(this.z, this.y);
      } else {
         float var2 = this.B + (this.z - this.B) * var1;
         float var3 = this.A + (this.y - this.A) * var1;
         return this.f(var2, var3);
      }
   }

   public boolean R() {
      return this.ac.a(4) == 1;
   }

   public void c(boolean var1) {
      this.b(1, var1);
   }

   protected void O() {
      this.J();
   }

   public float aS() {
      return this.K * 0.85F;
   }

   public aui ap() {
      return null;
   }

   public String toString() {
      return String.format("%s['%s'/%d, l='%s', x=%.2f, y=%.2f, z=%.2f]", this.getClass().getSimpleName(), this.e_(), this.c, this.o == null ? "~NULL~" : this.o.P().k(), this.s, this.t, this.u);
   }

   public void ak() {
      if (this.m.I) {
         this.m = null;
      } else {
         this.v = 0.0D;
         this.w = 0.0D;
         this.x = 0.0D;
         this.t_();
         if (this.m != null) {
            this.m.al();
            this.as += (double)(this.m.y - this.m.A);

            for(this.ar += (double)(this.m.z - this.m.B); this.as >= 180.0D; this.as -= 360.0D) {
            }

            while(this.as < -180.0D) {
               this.as += 360.0D;
            }

            while(this.ar >= 180.0D) {
               this.ar -= 360.0D;
            }

            while(this.ar < -180.0D) {
               this.ar += 360.0D;
            }

            double var1 = this.as * 0.5D;
            double var3 = this.ar * 0.5D;
            float var5 = 10.0F;
            if (var1 > (double)var5) {
               var1 = (double)var5;
            }

            if (var1 < (double)(-var5)) {
               var1 = (double)(-var5);
            }

            if (var3 > (double)var5) {
               var3 = (double)var5;
            }

            if (var3 < (double)(-var5)) {
               var3 = (double)(-var5);
            }

            this.as -= var1;
            this.ar -= var3;
         }
      }
   }

   public double h(pk var1) {
      double var2 = this.s - var1.s;
      double var4 = this.t - var1.t;
      double var6 = this.u - var1.u;
      return var2 * var2 + var4 * var4 + var6 * var6;
   }

   public boolean k(pk var1) {
      return this == var1;
   }

   public String aM() {
      return this.ac.e(2);
   }

   public void f(boolean var1) {
      this.b(4, var1);
   }

   public boolean u_() {
      return false;
   }

   public boolean at() {
      boolean var1 = this.o != null && this.o.D;
      return !this.ab && (this.i > 0 || var1 && this.g(0));
   }

   public boolean ad() {
      return false;
   }

   public boolean a(adi var1, adm var2, cj var3, alz var4, float var5) {
      return true;
   }

   public dn aV() {
      return null;
   }

   public auh a(double var1, float var3) {
      aui var4 = this.e(var3);
      aui var5 = this.d(var3);
      aui var6 = var4.b(var5.a * var1, var5.b * var1, var5.c * var1);
      return this.o.a(var4, var6, false, false, true);
   }

   public pz H() {
      return this.ac;
   }

   public void m(pk var1) {
      this.b(var1.s, var1.t, var1.u, var1.y, var1.z);
   }

   public pk[] aB() {
      return null;
   }

   public boolean aT() {
      return this.g;
   }

   public int hashCode() {
      return this.c;
   }

   public void e(float var1, float var2) {
      if (this.l != null) {
         this.l.e(var1, var2);
      }

   }

   public float aC() {
      return 0.0F;
   }
}
