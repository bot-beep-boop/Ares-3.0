import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import net.minecraft.server.MinecraftServer;

public abstract class va extends pk implements op {
   private int d;
   private static final int[][][] c = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
   private double g;
   private double i;
   private double at;
   private double e;
   private double as;
   private String b;
   private double h;
   private double f;
   private double ar;
   private boolean a;

   public float p() {
      return this.ac.d(19);
   }

   public boolean l_() {
      return this.b != null;
   }

   public void a(ow var1) {
      this.J();
      if (this.o.Q().b("doEntityDrops")) {
         zx var2 = new zx(zy.az, 1);
         if (this.b != null) {
            var2.c(this.b);
         }

         this.a(var2, 0.0F);
      }

   }

   public void a(double var1, double var3, double var5, float var7, float var8, int var9, boolean var10) {
      this.e = var1;
      this.f = var3;
      this.g = var5;
      this.h = (double)var7;
      this.i = (double)var8;
      this.d = var9 + 2;
      this.v = this.ar;
      this.w = this.as;
      this.x = this.at;
   }

   public eu f_() {
      if (this.l_()) {
         fa var2 = new fa(this.b);
         var2.b().a(this.aQ());
         var2.b().a(this.aK().toString());
         return var2;
      } else {
         fb var1 = new fb(this.e_(), new Object[0]);
         var1.b().a(this.aQ());
         var1.b().a(this.aK().toString());
         return var1;
      }
   }

   public boolean ae() {
      return true;
   }

   public alz u() {
      return afi.a.Q();
   }

   public aui k(double var1, double var3, double var5) {
      int var7 = ns.c(var1);
      int var8 = ns.c(var3);
      int var9 = ns.c(var5);
      if (afe.e(this.o, new cj(var7, var8 - 1, var9))) {
         --var8;
      }

      alz var10 = this.o.p(new cj(var7, var8, var9));
      if (afe.d(var10)) {
         afe.b var11 = (afe.b)var10.b(((afe)var10.c()).n());
         int[][] var12 = c[var11.a()];
         double var13 = 0.0D;
         double var15 = (double)var7 + 0.5D + (double)var12[0][0] * 0.5D;
         double var17 = (double)var8 + 0.0625D + (double)var12[0][1] * 0.5D;
         double var19 = (double)var9 + 0.5D + (double)var12[0][2] * 0.5D;
         double var21 = (double)var7 + 0.5D + (double)var12[1][0] * 0.5D;
         double var23 = (double)var8 + 0.0625D + (double)var12[1][1] * 0.5D;
         double var25 = (double)var9 + 0.5D + (double)var12[1][2] * 0.5D;
         double var27 = var21 - var15;
         double var29 = (var23 - var17) * 2.0D;
         double var31 = var25 - var19;
         if (var27 == 0.0D) {
            var1 = (double)var7 + 0.5D;
            var13 = var5 - (double)var9;
         } else if (var31 == 0.0D) {
            var5 = (double)var9 + 0.5D;
            var13 = var1 - (double)var7;
         } else {
            double var33 = var1 - var15;
            double var35 = var5 - var19;
            var13 = (var33 * var27 + var35 * var31) * 2.0D;
         }

         var1 = var15 + var27 * var13;
         var3 = var17 + var29 * var13;
         var5 = var19 + var31 * var13;
         if (var29 < 0.0D) {
            ++var3;
         }

         if (var29 > 0.0D) {
            var3 += 0.5D;
         }

         return new aui(var1, var3, var5);
      } else {
         return null;
      }
   }

   protected double m() {
      return 0.4D;
   }

   public void a(boolean var1) {
      this.H().b(22, (byte)(var1 ? 1 : 0));
   }

   public void j(int var1) {
      this.ac.b(17, var1);
   }

   public int r() {
      return this.ac.c(18);
   }

   public void t_() {
      if (this.q() > 0) {
         this.j(this.q() - 1);
      }

      if (this.p() > 0.0F) {
         this.a(this.p() - 1.0F);
      }

      if (this.t < -64.0D) {
         this.O();
      }

      int var2;
      if (!this.o.D && this.o instanceof le) {
         this.o.B.a("portal");
         MinecraftServer var1 = ((le)this.o).r();
         var2 = this.L();
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

      if (this.o.D) {
         if (this.d > 0) {
            double var15 = this.s + (this.e - this.s) / (double)this.d;
            double var17 = this.t + (this.f - this.t) / (double)this.d;
            double var18 = this.u + (this.g - this.u) / (double)this.d;
            double var7 = ns.g(this.h - (double)this.y);
            this.y = (float)((double)this.y + var7 / (double)this.d);
            this.z = (float)((double)this.z + (this.i - (double)this.z) / (double)this.d);
            --this.d;
            this.b(var15, var17, var18);
            this.b(this.y, this.z);
         } else {
            this.b(this.s, this.t, this.u);
            this.b(this.y, this.z);
         }

      } else {
         this.p = this.s;
         this.q = this.t;
         this.r = this.u;
         this.w -= 0.03999999910593033D;
         int var14 = ns.c(this.s);
         var2 = ns.c(this.t);
         int var16 = ns.c(this.u);
         if (afe.e(this.o, new cj(var14, var2 - 1, var16))) {
            --var2;
         }

         cj var4 = new cj(var14, var2, var16);
         alz var5 = this.o.p(var4);
         if (afe.d(var5)) {
            this.a(var4, var5);
            if (var5.c() == afi.cs) {
               this.a(var14, var2, var16, (Boolean)var5.b(ais.N));
            }
         } else {
            this.n();
         }

         this.Q();
         this.z = 0.0F;
         double var6 = this.p - this.s;
         double var8 = this.r - this.u;
         if (var6 * var6 + var8 * var8 > 0.001D) {
            this.y = (float)(ns.b(var8, var6) * 180.0D / 3.141592653589793D);
            if (this.a) {
               this.y += 180.0F;
            }
         }

         double var10 = (double)ns.g(this.y - this.A);
         if (var10 < -170.0D || var10 >= 170.0D) {
            this.y += 180.0F;
            this.a = !this.a;
         }

         this.b(this.y, this.z);
         Iterator var12 = this.o.b((pk)this, (aug)this.aR().b(0.20000000298023224D, 0.0D, 0.20000000298023224D)).iterator();

         while(var12.hasNext()) {
            pk var13 = (pk)var12.next();
            if (var13 != this.l && var13.ae() && var13 instanceof va) {
               var13.i(this);
            }
         }

         if (this.l != null && this.l.I) {
            if (this.l.m == this) {
               this.l.m = null;
            }

            this.l = null;
         }

         this.W();
      }
   }

   protected boolean s_() {
      return false;
   }

   public boolean ad() {
      return !this.I;
   }

   public abstract va.a s();

   public void a(String var1) {
      this.b = var1;
   }

   public void J() {
      super.J();
   }

   protected void n() {
      double var1 = this.m();
      this.v = ns.a(this.v, -var1, var1);
      this.x = ns.a(this.x, -var1, var1);
      if (this.C) {
         this.v *= 0.5D;
         this.w *= 0.5D;
         this.x *= 0.5D;
      }

      this.d(this.v, this.w, this.x);
      if (!this.C) {
         this.v *= 0.949999988079071D;
         this.w *= 0.949999988079071D;
         this.x *= 0.949999988079071D;
      }

   }

   public va(adm var1) {
      super(var1);
      this.k = true;
      this.a(0.98F, 0.7F);
   }

   public static va a(adm var0, double var1, double var3, double var5, va.a var7) {
      switch(var7) {
      case b:
         return new vb(var0, var1, var3, var5);
      case c:
         return new ve(var0, var1, var3, var5);
      case d:
         return new vi(var0, var1, var3, var5);
      case e:
         return new vh(var0, var1, var3, var5);
      case f:
         return new vf(var0, var1, var3, var5);
      case g:
         return new vc(var0, var1, var3, var5);
      default:
         return new vg(var0, var1, var3, var5);
      }
   }

   public void ar() {
      this.k(-this.r());
      this.j(10);
      this.a(this.p() + this.p() * 10.0F);
   }

   public boolean x() {
      return this.H().a(22) == 1;
   }

   protected void b(dn var1) {
      if (this.x()) {
         var1.a("CustomDisplayTile", true);
         alz var2 = this.t();
         jy var3 = (jy)afh.c.c(var2.c());
         var1.a("DisplayTile", var3 == null ? "" : var3.toString());
         var1.a("DisplayData", var2.c().c(var2));
         var1.a("DisplayOffset", this.v());
      }

      if (this.b != null && this.b.length() > 0) {
         var1.a("CustomName", this.b);
      }

   }

   protected void o() {
      if (this.l != null) {
         this.v *= 0.996999979019165D;
         this.w *= 0.0D;
         this.x *= 0.996999979019165D;
      } else {
         this.v *= 0.9599999785423279D;
         this.w *= 0.0D;
         this.x *= 0.9599999785423279D;
      }

   }

   protected void a(dn var1) {
      if (var1.n("CustomDisplayTile")) {
         int var2 = var1.f("DisplayData");
         afh var3;
         if (var1.b("DisplayTile", 8)) {
            var3 = afh.b(var1.j("DisplayTile"));
            if (var3 == null) {
               this.a(afi.a.Q());
            } else {
               this.a(var3.a(var2));
            }
         } else {
            var3 = afh.c(var1.f("DisplayTile"));
            if (var3 == null) {
               this.a(afi.a.Q());
            } else {
               this.a(var3.a(var2));
            }
         }

         this.l(var1.f("DisplayOffset"));
      }

      if (var1.b("CustomName", 8) && var1.j("CustomName").length() > 0) {
         this.b = var1.j("CustomName");
      }

   }

   public void i(double var1, double var3, double var5) {
      this.ar = this.v = var1;
      this.as = this.w = var3;
      this.at = this.x = var5;
   }

   public int q() {
      return this.ac.c(17);
   }

   public void l(int var1) {
      this.H().b(21, var1);
      this.a(true);
   }

   protected void a(cj var1, alz var2) {
      this.O = 0.0F;
      aui var3 = this.k(this.s, this.t, this.u);
      this.t = (double)var1.o();
      boolean var4 = false;
      boolean var5 = false;
      afe var6 = (afe)var2.c();
      if (var6 == afi.D) {
         var4 = (Boolean)var2.b(ais.N);
         var5 = !var4;
      }

      double var7 = 0.0078125D;
      afe.b var9 = (afe.b)var2.b(var6.n());
      switch(var9) {
      case c:
         this.v -= 0.0078125D;
         ++this.t;
         break;
      case d:
         this.v += 0.0078125D;
         ++this.t;
         break;
      case e:
         this.x += 0.0078125D;
         ++this.t;
         break;
      case f:
         this.x -= 0.0078125D;
         ++this.t;
      }

      int[][] var10 = c[var9.a()];
      double var11 = (double)(var10[1][0] - var10[0][0]);
      double var13 = (double)(var10[1][2] - var10[0][2]);
      double var15 = Math.sqrt(var11 * var11 + var13 * var13);
      double var17 = this.v * var11 + this.x * var13;
      if (var17 < 0.0D) {
         var11 = -var11;
         var13 = -var13;
      }

      double var19 = Math.sqrt(this.v * this.v + this.x * this.x);
      if (var19 > 2.0D) {
         var19 = 2.0D;
      }

      this.v = var19 * var11 / var15;
      this.x = var19 * var13 / var15;
      double var21;
      double var23;
      double var25;
      double var27;
      if (this.l instanceof pr) {
         var21 = (double)((pr)this.l).ba;
         if (var21 > 0.0D) {
            var23 = -Math.sin((double)(this.l.y * 3.1415927F / 180.0F));
            var25 = Math.cos((double)(this.l.y * 3.1415927F / 180.0F));
            var27 = this.v * this.v + this.x * this.x;
            if (var27 < 0.01D) {
               this.v += var23 * 0.1D;
               this.x += var25 * 0.1D;
               var5 = false;
            }
         }
      }

      if (var5) {
         var21 = Math.sqrt(this.v * this.v + this.x * this.x);
         if (var21 < 0.03D) {
            this.v *= 0.0D;
            this.w *= 0.0D;
            this.x *= 0.0D;
         } else {
            this.v *= 0.5D;
            this.w *= 0.0D;
            this.x *= 0.5D;
         }
      }

      var21 = 0.0D;
      var23 = (double)var1.n() + 0.5D + (double)var10[0][0] * 0.5D;
      var25 = (double)var1.p() + 0.5D + (double)var10[0][2] * 0.5D;
      var27 = (double)var1.n() + 0.5D + (double)var10[1][0] * 0.5D;
      double var29 = (double)var1.p() + 0.5D + (double)var10[1][2] * 0.5D;
      var11 = var27 - var23;
      var13 = var29 - var25;
      double var31;
      double var33;
      if (var11 == 0.0D) {
         this.s = (double)var1.n() + 0.5D;
         var21 = this.u - (double)var1.p();
      } else if (var13 == 0.0D) {
         this.u = (double)var1.p() + 0.5D;
         var21 = this.s - (double)var1.n();
      } else {
         var31 = this.s - var23;
         var33 = this.u - var25;
         var21 = (var31 * var11 + var33 * var13) * 2.0D;
      }

      this.s = var23 + var11 * var21;
      this.u = var25 + var13 * var21;
      this.b(this.s, this.t, this.u);
      var31 = this.v;
      var33 = this.x;
      if (this.l != null) {
         var31 *= 0.75D;
         var33 *= 0.75D;
      }

      double var35 = this.m();
      var31 = ns.a(var31, -var35, var35);
      var33 = ns.a(var33, -var35, var35);
      this.d(var31, 0.0D, var33);
      if (var10[0][1] != 0 && ns.c(this.s) - var1.n() == var10[0][0] && ns.c(this.u) - var1.p() == var10[0][2]) {
         this.b(this.s, this.t + (double)var10[0][1], this.u);
      } else if (var10[1][1] != 0 && ns.c(this.s) - var1.n() == var10[1][0] && ns.c(this.u) - var1.p() == var10[1][2]) {
         this.b(this.s, this.t + (double)var10[1][1], this.u);
      }

      this.o();
      aui var37 = this.k(this.s, this.t, this.u);
      if (var37 != null && var3 != null) {
         double var38 = (var3.b - var37.b) * 0.05D;
         var19 = Math.sqrt(this.v * this.v + this.x * this.x);
         if (var19 > 0.0D) {
            this.v = this.v / var19 * (var19 + var38);
            this.x = this.x / var19 * (var19 + var38);
         }

         this.b(this.s, var37.b, this.u);
      }

      int var44 = ns.c(this.s);
      int var39 = ns.c(this.u);
      if (var44 != var1.n() || var39 != var1.p()) {
         var19 = Math.sqrt(this.v * this.v + this.x * this.x);
         this.v = var19 * (double)(var44 - var1.n());
         this.x = var19 * (double)(var39 - var1.p());
      }

      if (var4) {
         double var40 = Math.sqrt(this.v * this.v + this.x * this.x);
         if (var40 > 0.01D) {
            double var42 = 0.06D;
            this.v += this.v / var40 * var42;
            this.x += this.x / var40 * var42;
         } else if (var9 == afe.b.b) {
            if (this.o.p(var1.e()).c().v()) {
               this.v = 0.02D;
            } else if (this.o.p(var1.f()).c().v()) {
               this.v = -0.02D;
            }
         } else if (var9 == afe.b.a) {
            if (this.o.p(var1.c()).c().v()) {
               this.x = 0.02D;
            } else if (this.o.p(var1.d()).c().v()) {
               this.x = -0.02D;
            }
         }
      }

   }

   public aug j(pk var1) {
      return var1.ae() ? var1.aR() : null;
   }

   public alz t() {
      return !this.x() ? this.u() : afh.d(this.H().c(20));
   }

   public void a(int var1, int var2, int var3, boolean var4) {
   }

   public void a(float var1) {
      this.ac.b(19, var1);
   }

   public void k(int var1) {
      this.ac.b(18, var1);
   }

   public double an() {
      return 0.0D;
   }

   protected void h() {
      this.ac.a(17, new Integer(0));
      this.ac.a(18, new Integer(1));
      this.ac.a(19, new Float(0.0F));
      this.ac.a(20, new Integer(0));
      this.ac.a(21, new Integer(6));
      this.ac.a(22, (byte)0);
   }

   public va(adm var1, double var2, double var4, double var6) {
      this(var1);
      this.b(var2, var4, var6);
      this.v = 0.0D;
      this.w = 0.0D;
      this.x = 0.0D;
      this.p = var2;
      this.q = var4;
      this.r = var6;
   }

   public aui a(double var1, double var3, double var5, double var7) {
      int var9 = ns.c(var1);
      int var10 = ns.c(var3);
      int var11 = ns.c(var5);
      if (afe.e(this.o, new cj(var9, var10 - 1, var11))) {
         --var10;
      }

      alz var12 = this.o.p(new cj(var9, var10, var11));
      if (afe.d(var12)) {
         afe.b var13 = (afe.b)var12.b(((afe)var12.c()).n());
         var3 = (double)var10;
         if (var13.c()) {
            var3 = (double)(var10 + 1);
         }

         int[][] var14 = c[var13.a()];
         double var15 = (double)(var14[1][0] - var14[0][0]);
         double var17 = (double)(var14[1][2] - var14[0][2]);
         double var19 = Math.sqrt(var15 * var15 + var17 * var17);
         var15 /= var19;
         var17 /= var19;
         var1 += var15 * var7;
         var5 += var17 * var7;
         if (var14[0][1] != 0 && ns.c(var1) - var9 == var14[0][0] && ns.c(var5) - var11 == var14[0][2]) {
            var3 += (double)var14[0][1];
         } else if (var14[1][1] != 0 && ns.c(var1) - var9 == var14[1][0] && ns.c(var5) - var11 == var14[1][2]) {
            var3 += (double)var14[1][1];
         }

         return this.k(var1, var3, var5);
      } else {
         return null;
      }
   }

   public int w() {
      return 6;
   }

   public void b(double var1, double var3, double var5) {
      this.s = var1;
      this.t = var3;
      this.u = var5;
      float var7 = this.J / 2.0F;
      float var8 = this.K;
      this.a((aug)(new aug(var1 - (double)var7, var3, var5 - (double)var7, var1 + (double)var7, var3 + (double)var8, var5 + (double)var7)));
   }

   public boolean a(ow var1, float var2) {
      if (!this.o.D && !this.I) {
         if (this.b(var1)) {
            return false;
         } else {
            this.k(-this.r());
            this.j(10);
            this.ac();
            this.a(this.p() + var2 * 10.0F);
            boolean var3 = var1.j() instanceof wn && ((wn)var1.j()).bA.d;
            if (var3 || this.p() > 40.0F) {
               if (this.l != null) {
                  this.l.a((pk)null);
               }

               if (var3 && !this.l_()) {
                  this.J();
               } else {
                  this.a(var1);
               }
            }

            return true;
         }
      } else {
         return true;
      }
   }

   public void i(pk var1) {
      if (!this.o.D) {
         if (!var1.T && !this.T) {
            if (var1 != this.l) {
               if (var1 instanceof pr && !(var1 instanceof wn) && !(var1 instanceof ty) && this.s() == va.a.a && this.v * this.v + this.x * this.x > 0.01D && this.l == null && var1.m == null) {
                  var1.a((pk)this);
               }

               double var2 = var1.s - this.s;
               double var4 = var1.u - this.u;
               double var6 = var2 * var2 + var4 * var4;
               if (var6 >= 9.999999747378752E-5D) {
                  var6 = (double)ns.a(var6);
                  var2 /= var6;
                  var4 /= var6;
                  double var8 = 1.0D / var6;
                  if (var8 > 1.0D) {
                     var8 = 1.0D;
                  }

                  var2 *= var8;
                  var4 *= var8;
                  var2 *= 0.10000000149011612D;
                  var4 *= 0.10000000149011612D;
                  var2 *= (double)(1.0F - this.U);
                  var4 *= (double)(1.0F - this.U);
                  var2 *= 0.5D;
                  var4 *= 0.5D;
                  if (var1 instanceof va) {
                     double var10 = var1.s - this.s;
                     double var12 = var1.u - this.u;
                     aui var14 = (new aui(var10, 0.0D, var12)).a();
                     aui var15 = (new aui((double)ns.b(this.y * 3.1415927F / 180.0F), 0.0D, (double)ns.a(this.y * 3.1415927F / 180.0F))).a();
                     double var16 = Math.abs(var14.b(var15));
                     if (var16 < 0.800000011920929D) {
                        return;
                     }

                     double var18 = var1.v + this.v;
                     double var20 = var1.x + this.x;
                     if (((va)var1).s() == va.a.c && this.s() != va.a.c) {
                        this.v *= 0.20000000298023224D;
                        this.x *= 0.20000000298023224D;
                        this.g(var1.v - var2, 0.0D, var1.x - var4);
                        var1.v *= 0.949999988079071D;
                        var1.x *= 0.949999988079071D;
                     } else if (((va)var1).s() != va.a.c && this.s() == va.a.c) {
                        var1.v *= 0.20000000298023224D;
                        var1.x *= 0.20000000298023224D;
                        var1.g(this.v + var2, 0.0D, this.x + var4);
                        this.v *= 0.949999988079071D;
                        this.x *= 0.949999988079071D;
                     } else {
                        var18 /= 2.0D;
                        var20 /= 2.0D;
                        this.v *= 0.20000000298023224D;
                        this.x *= 0.20000000298023224D;
                        this.g(var18 - var2, 0.0D, var20 - var4);
                        var1.v *= 0.20000000298023224D;
                        var1.x *= 0.20000000298023224D;
                        var1.g(var18 + var2, 0.0D, var20 + var4);
                     }
                  } else {
                     this.g(-var2, 0.0D, -var4);
                     var1.g(var2 / 4.0D, 0.0D, var4 / 4.0D);
                  }
               }

            }
         }
      }
   }

   public String aM() {
      return this.b;
   }

   public aug S() {
      return null;
   }

   public void a(alz var1) {
      this.H().b(20, afh.f(var1));
      this.a(true);
   }

   public int v() {
      return !this.x() ? this.w() : this.H().c(21);
   }

   public String e_() {
      return this.b != null ? this.b : super.e_();
   }

   public static enum a {
      private final int i;
      private final String j;
      b(1, "MinecartChest");

      private static final va.a[] k = new va.a[]{a, b, c, d, e, f, g};
      e(4, "MinecartSpawner"),
      d(3, "MinecartTNT"),
      c(2, "MinecartFurnace"),
      a(0, "MinecartRideable"),
      g(6, "MinecartCommandBlock"),
      f(5, "MinecartHopper");

      private static final Map<Integer, va.a> h = Maps.newHashMap();

      public static va.a a(int var0) {
         va.a var1 = (va.a)h.get(var0);
         return var1 == null ? a : var1;
      }

      static {
         va.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            va.a var3 = var0[var2];
            h.put(var3.a(), var3);
         }

      }

      public String b() {
         return this.j;
      }

      public int a() {
         return this.i;
      }

      private a(int var3, String var4) {
         this.i = var3;
         this.j = var4;
      }
   }
}
