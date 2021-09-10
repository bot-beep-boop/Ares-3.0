public class bew extends bet {
   private double bL;
   public int e;
   public float h;
   private float bO;
   private float bV;
   private int bU;
   protected int d;
   private int bR;
   public float g;
   public float bI;
   private String bT;
   private boolean bP;
   private double bM;
   private boolean bQ;
   private boolean bS;
   public beu b;
   protected ave c;
   private float bN;
   private final nb bJ;
   public float f;
   public final bcy a;
   public float bH;
   private double bK;
   public float i;

   public void c(pk var1) {
      this.c.j.a(var1, cy.k);
   }

   public void n(float var1) {
      if (this.bS) {
         float var2 = this.bn() - var1;
         if (var2 <= 0.0F) {
            this.i(var1);
            if (var2 < 0.0F) {
               this.Z = this.aD / 2;
            }
         } else {
            this.aX = var2;
            this.i(this.bn());
            this.Z = this.aD;
            this.d(ow.k, var2);
            this.au = this.av = 10;
         }
      } else {
         this.i(var1);
         this.bS = true;
      }

   }

   public void a(ol var1) {
      String var2 = var1.k();
      if ("minecraft:crafting_table".equals(var2)) {
         this.c.a((axu)(new ays(this.bi, this.o)));
      } else if ("minecraft:enchanting_table".equals(var2)) {
         this.c.a((axu)(new ayy(this.bi, this.o, var1)));
      } else if ("minecraft:anvil".equals(var2)) {
         this.c.a((axu)(new aym(this.bi, this.o)));
      }

   }

   public float z() {
      return this.bV;
   }

   public boolean a(int var1, String var2) {
      return var1 <= 0;
   }

   public void a(adc var1) {
      this.c.a((axu)(new ayq(var1)));
   }

   public void a(acy var1) {
      this.c.a((axu)(new azd(this.bi, var1, this.o)));
   }

   public bew(ave var1, adm var2, bcy var3, nb var4) {
      super(var2, var3.e());
      this.a = var3;
      this.bJ = var4;
      this.c = var1;
      this.am = 0;
   }

   public void m() {
      if (this.e > 0) {
         --this.e;
         if (this.e == 0) {
            this.d(false);
         }
      }

      if (this.d > 0) {
         --this.d;
      }

      this.bI = this.bH;
      if (this.ak) {
         if (this.c.m != null && !this.c.m.d()) {
            this.c.a((axu)null);
         }

         if (this.bH == 0.0F) {
            this.c.W().a((bpj)bpf.a(new jy("portal.trigger"), this.V.nextFloat() * 0.4F + 0.8F));
         }

         this.bH += 0.0125F;
         if (this.bH >= 1.0F) {
            this.bH = 1.0F;
         }

         this.ak = false;
      } else if (this.a((pe)pe.k) && this.b((pe)pe.k).b() > 60) {
         this.bH += 0.006666667F;
         if (this.bH > 1.0F) {
            this.bH = 1.0F;
         }
      } else {
         if (this.bH > 0.0F) {
            this.bH -= 0.05F;
         }

         if (this.bH < 0.0F) {
            this.bH = 0.0F;
         }
      }

      if (this.aj > 0) {
         --this.aj;
      }

      boolean var1 = this.b.c;
      boolean var2 = this.b.d;
      float var3 = 0.8F;
      boolean var4 = this.b.b >= var3;
      this.b.a();
      if (this.bS() && !this.au()) {
         beu var10000 = this.b;
         var10000.a *= 0.2F;
         var10000 = this.b;
         var10000.b *= 0.2F;
         this.d = 0;
      }

      this.j(this.s - (double)this.J * 0.35D, this.aR().b + 0.5D, this.u + (double)this.J * 0.35D);
      this.j(this.s - (double)this.J * 0.35D, this.aR().b + 0.5D, this.u - (double)this.J * 0.35D);
      this.j(this.s + (double)this.J * 0.35D, this.aR().b + 0.5D, this.u - (double)this.J * 0.35D);
      this.j(this.s + (double)this.J * 0.35D, this.aR().b + 0.5D, this.u + (double)this.J * 0.35D);
      boolean var5 = (float)this.cl().a() > 6.0F || this.bA.c;
      if (this.C && !var2 && !var4 && this.b.b >= var3 && !this.aw() && var5 && !this.bS() && !this.a((pe)pe.q)) {
         if (this.d <= 0 && !this.c.t.ae.d()) {
            this.d = 7;
         } else {
            this.d(true);
         }
      }

      if (!this.aw() && this.b.b >= var3 && var5 && !this.bS() && !this.a((pe)pe.q) && this.c.t.ae.d()) {
         this.d(true);
      }

      if (this.aw() && (this.b.b < var3 || this.D || !var5)) {
         this.d(false);
      }

      if (this.bA.c) {
         if (this.c.c.k()) {
            if (!this.bA.b) {
               this.bA.b = true;
               this.t();
            }
         } else if (!var1 && this.b.c) {
            if (this.bm == 0) {
               this.bm = 7;
            } else {
               this.bA.b = !this.bA.b;
               this.t();
               this.bm = 0;
            }
         }
      }

      if (this.bA.b && this.A()) {
         if (this.b.d) {
            this.w -= (double)(this.bA.a() * 3.0F);
         }

         if (this.b.c) {
            this.w += (double)(this.bA.a() * 3.0F);
         }
      }

      if (this.y()) {
         if (this.bU < 0) {
            ++this.bU;
            if (this.bU == 0) {
               this.bV = 0.0F;
            }
         }

         if (var1 && !this.b.c) {
            this.bU = -10;
            this.r();
         } else if (!var1 && this.b.c) {
            this.bU = 0;
            this.bV = 0.0F;
         } else if (var1) {
            ++this.bU;
            if (this.bU < 10) {
               this.bV = (float)this.bU * 0.1F;
            } else {
               this.bV = 0.8F + 2.0F / (float)(this.bU - 9) * 0.1F;
            }
         }
      } else {
         this.bV = 0.0F;
      }

      super.m();
      if (this.C && this.bA.b && !this.c.c.k()) {
         this.bA.b = false;
         this.t();
      }

   }

   public void cb() {
      this.a.a((ff)(new ig(ig.a.a)));
   }

   protected boolean j(double var1, double var3, double var5) {
      if (this.T) {
         return false;
      } else {
         cj var7 = new cj(var1, var3, var5);
         double var8 = var1 - (double)var7.n();
         double var10 = var5 - (double)var7.p();
         if (!this.e(var7)) {
            byte var12 = -1;
            double var13 = 9999.0D;
            if (this.e(var7.e()) && var8 < var13) {
               var13 = var8;
               var12 = 0;
            }

            if (this.e(var7.f()) && 1.0D - var8 < var13) {
               var13 = 1.0D - var8;
               var12 = 1;
            }

            if (this.e(var7.c()) && var10 < var13) {
               var13 = var10;
               var12 = 4;
            }

            if (this.e(var7.d()) && 1.0D - var10 < var13) {
               var13 = 1.0D - var10;
               var12 = 5;
            }

            float var15 = 0.1F;
            if (var12 == 0) {
               this.v = (double)(-var15);
            }

            if (var12 == 1) {
               this.v = (double)var15;
            }

            if (var12 == 4) {
               this.x = (double)(-var15);
            }

            if (var12 == 5) {
               this.x = (double)var15;
            }
         }

         return false;
      }
   }

   public void t() {
      this.a.a((ff)(new iq(this.bA)));
   }

   public void a(zx var1) {
      zw var2 = var1.b();
      if (var2 == zy.bM) {
         this.c.a((axu)(new ayo(this, var1, true)));
      }

   }

   public boolean cc() {
      return true;
   }

   public boolean av() {
      boolean var1 = this.b != null ? this.b.d : false;
      return var1 && !this.bw;
   }

   public void t_() {
      if (this.o.e(new cj(this.s, 0.0D, this.u))) {
         super.t_();
         if (this.au()) {
            this.a.a((ff)(new ip.c(this.y, this.z, this.C)));
            this.a.a((ff)(new it(this.aZ, this.ba, this.b.c, this.b.d)));
         } else {
            this.p();
         }

      }
   }

   public void a(tp var1, og var2) {
      this.c.a((axu)(new azb(this.bi, var2, var1)));
   }

   public void a(mw var1, int var2) {
      if (var1 != null) {
         if (var1.f) {
            super.a(var1, var2);
         }

      }
   }

   private boolean e(cj var1) {
      return !this.o.p(var1).c().v() && !this.o.p(var1.a()).c().v();
   }

   protected boolean A() {
      return this.c.ac() == this;
   }

   public void a(String var1, float var2, float var3) {
      this.o.a(this.s, this.t, this.u, var1, var2, var3, false);
   }

   protected void r() {
      this.a.a((ff)(new is(this, is.a.f, (int)(this.z() * 100.0F))));
   }

   public nb x() {
      return this.bJ;
   }

   public void a(float var1, int var2, int var3) {
      this.bD = var1;
      this.bC = var2;
      this.bB = var3;
   }

   public void a(eu var1) {
      this.c.q.d().a(var1);
   }

   public uz a(boolean var1) {
      ir.a var2 = var1 ? ir.a.d : ir.a.e;
      this.a.a((ff)(new ir(var2, cj.a, cq.a)));
      return null;
   }

   public void bK() {
      super.bK();
      if (this.A()) {
         this.aZ = this.b.a;
         this.ba = this.b.b;
         this.aY = this.b.c;
         this.h = this.f;
         this.i = this.g;
         this.g = (float)((double)this.g + (double)(this.z - this.g) * 0.5D);
         this.f = (float)((double)this.f + (double)(this.y - this.f) * 0.5D);
      }

   }

   public boolean y() {
      return this.m != null && this.m instanceof tp && ((tp)this.m).cG();
   }

   protected void a(uz var1) {
   }

   public void bw() {
      super.bw();
      this.a.a((ff)(new iy()));
   }

   public void n() {
      this.a.a((ff)(new il(this.bk.d)));
      this.q();
   }

   public void b(eu var1) {
      this.c.q.d().a(var1);
   }

   public boolean a(ow var1, float var2) {
      return false;
   }

   public void q() {
      this.bi.b((zx)null);
      super.n();
      this.c.a((axu)null);
   }

   public void u() {
      this.a.a((ff)(new is(this, is.a.g)));
   }

   public void b(pk var1) {
      this.c.j.a(var1, cy.j);
   }

   public void d(boolean var1) {
      super.d(var1);
      this.e = var1 ? 600 : 0;
   }

   public cj c() {
      return new cj(this.s + 0.5D, this.t + 0.5D, this.u + 0.5D);
   }

   protected void d(ow var1, float var2) {
      if (!this.b((ow)var1)) {
         this.i(this.bn() - var2);
      }
   }

   public void h(float var1) {
   }

   public void a(og var1) {
      String var2 = var1 instanceof ol ? ((ol)var1).k() : "minecraft:container";
      if ("minecraft:chest".equals(var2)) {
         this.c.a((axu)(new ayr(this.bi, var1)));
      } else if ("minecraft:hopper".equals(var2)) {
         this.c.a((axu)(new aza(this.bi, var1)));
      } else if ("minecraft:furnace".equals(var2)) {
         this.c.a((axu)(new ayz(this.bi, var1)));
      } else if ("minecraft:brewing_stand".equals(var2)) {
         this.c.a((axu)(new ayp(this.bi, var1)));
      } else if ("minecraft:beacon".equals(var2)) {
         this.c.a((axu)(new ayn(this.bi, var1)));
      } else if (!"minecraft:dispenser".equals(var2) && !"minecraft:dropper".equals(var2)) {
         this.c.a((axu)(new ayr(this.bi, var1)));
      } else {
         this.c.a((axu)(new ayv(this.bi, var1)));
      }

   }

   public void p() {
      boolean var1 = this.aw();
      if (var1 != this.bQ) {
         if (var1) {
            this.a.a((ff)(new is(this, is.a.d)));
         } else {
            this.a.a((ff)(new is(this, is.a.e)));
         }

         this.bQ = var1;
      }

      boolean var2 = this.av();
      if (var2 != this.bP) {
         if (var2) {
            this.a.a((ff)(new is(this, is.a.a)));
         } else {
            this.a.a((ff)(new is(this, is.a.b)));
         }

         this.bP = var2;
      }

      if (this.A()) {
         double var3 = this.s - this.bK;
         double var5 = this.aR().b - this.bL;
         double var7 = this.u - this.bM;
         double var9 = (double)(this.y - this.bN);
         double var11 = (double)(this.z - this.bO);
         boolean var13 = var3 * var3 + var5 * var5 + var7 * var7 > 9.0E-4D || this.bR >= 20;
         boolean var14 = var9 != 0.0D || var11 != 0.0D;
         if (this.m == null) {
            if (var13 && var14) {
               this.a.a((ff)(new ip.b(this.s, this.aR().b, this.u, this.y, this.z, this.C)));
            } else if (var13) {
               this.a.a((ff)(new ip.a(this.s, this.aR().b, this.u, this.C)));
            } else if (var14) {
               this.a.a((ff)(new ip.c(this.y, this.z, this.C)));
            } else {
               this.a.a((ff)(new ip(this.C)));
            }
         } else {
            this.a.a((ff)(new ip.b(this.v, -999.0D, this.x, this.y, this.z, this.C)));
            var13 = false;
         }

         ++this.bR;
         if (var13) {
            this.bK = this.s;
            this.bL = this.aR().b;
            this.bM = this.u;
            this.bR = 0;
         }

         if (var14) {
            this.bN = this.y;
            this.bO = this.z;
         }
      }

   }

   public void f(String var1) {
      this.bT = var1;
   }

   public String w() {
      return this.bT;
   }

   public void a(pk var1) {
      super.a(var1);
      if (var1 instanceof va) {
         this.c.W().a((bpj)(new bpe(this, (va)var1)));
      }

   }

   public void a(aln var1) {
      this.c.a((axu)(new aze(var1)));
   }

   public void e(String var1) {
      this.a.a((ff)(new ie(var1)));
   }

   public boolean bM() {
      return true;
   }
}
