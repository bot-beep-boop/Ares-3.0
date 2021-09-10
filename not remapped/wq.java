import java.util.List;

public class wq extends pk implements wv {
   private int e = -1;
   private int ar;
   private int h;
   private int f = -1;
   public pk c;
   public int a;
   public int b;
   private afh g;
   private double at = 2.0D;
   private int as;
   private int au;
   private boolean i;
   private int d = -1;

   public void a(boolean var1) {
      byte var2 = this.ac.a(16);
      if (var1) {
         this.ac.b(16, (byte)(var2 | 1));
      } else {
         this.ac.b(16, (byte)(var2 & -2));
      }

   }

   public wq(adm var1, double var2, double var4, double var6) {
      super(var1);
      this.j = 10.0D;
      this.a(0.5F, 0.5F);
      this.b(var2, var4, var6);
   }

   public void b(double var1) {
      this.at = var1;
   }

   public void a(double var1, double var3, double var5, float var7, float var8, int var9, boolean var10) {
      this.b(var1, var3, var5);
      this.b(var7, var8);
   }

   public float aS() {
      return 0.0F;
   }

   public wq(adm var1, pr var2, float var3) {
      super(var1);
      this.j = 10.0D;
      this.c = var2;
      if (var2 instanceof wn) {
         this.a = 1;
      }

      this.a(0.5F, 0.5F);
      this.b(var2.s, var2.t + (double)var2.aS(), var2.u, var2.y, var2.z);
      this.s -= (double)(ns.b(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.t -= 0.10000000149011612D;
      this.u -= (double)(ns.a(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.b(this.s, this.t, this.u);
      this.v = (double)(-ns.a(this.y / 180.0F * 3.1415927F) * ns.b(this.z / 180.0F * 3.1415927F));
      this.x = (double)(ns.b(this.y / 180.0F * 3.1415927F) * ns.b(this.z / 180.0F * 3.1415927F));
      this.w = (double)(-ns.a(this.z / 180.0F * 3.1415927F));
      this.c(this.v, this.w, this.x, var3 * 1.5F, 1.0F);
   }

   public void i(double var1, double var3, double var5) {
      this.v = var1;
      this.w = var3;
      this.x = var5;
      if (this.B == 0.0F && this.A == 0.0F) {
         float var7 = ns.a(var1 * var1 + var5 * var5);
         this.A = this.y = (float)(ns.b(var1, var5) * 180.0D / 3.1415927410125732D);
         this.B = this.z = (float)(ns.b(var3, (double)var7) * 180.0D / 3.1415927410125732D);
         this.B = this.z;
         this.A = this.y;
         this.b(this.s, this.t, this.u, this.y, this.z);
         this.ar = 0;
      }

   }

   public boolean l() {
      byte var1 = this.ac.a(16);
      return (var1 & 1) != 0;
   }

   public void d(wn var1) {
      if (!this.o.D && this.i && this.b <= 0) {
         boolean var2 = this.a == 1 || this.a == 2 && var1.bA.d;
         if (this.a == 1 && !var1.bi.a(new zx(zy.g, 1))) {
            var2 = false;
         }

         if (var2) {
            this.a("random.pop", 0.2F, ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            var1.a((pk)this, 1);
            this.J();
         }

      }
   }

   protected void h() {
      this.ac.a(16, (byte)0);
   }

   public void c(double var1, double var3, double var5, float var7, float var8) {
      float var9 = ns.a(var1 * var1 + var3 * var3 + var5 * var5);
      var1 /= (double)var9;
      var3 /= (double)var9;
      var5 /= (double)var9;
      var1 += this.V.nextGaussian() * (double)(this.V.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)var8;
      var3 += this.V.nextGaussian() * (double)(this.V.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)var8;
      var5 += this.V.nextGaussian() * (double)(this.V.nextBoolean() ? -1 : 1) * 0.007499999832361937D * (double)var8;
      var1 *= (double)var7;
      var3 *= (double)var7;
      var5 *= (double)var7;
      this.v = var1;
      this.w = var3;
      this.x = var5;
      float var10 = ns.a(var1 * var1 + var5 * var5);
      this.A = this.y = (float)(ns.b(var1, var5) * 180.0D / 3.1415927410125732D);
      this.B = this.z = (float)(ns.b(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.ar = 0;
   }

   public void a(int var1) {
      this.au = var1;
   }

   protected boolean s_() {
      return false;
   }

   public wq(adm var1, pr var2, pr var3, float var4, float var5) {
      super(var1);
      this.j = 10.0D;
      this.c = var2;
      if (var2 instanceof wn) {
         this.a = 1;
      }

      this.t = var2.t + (double)var2.aS() - 0.10000000149011612D;
      double var6 = var3.s - var2.s;
      double var8 = var3.aR().b + (double)(var3.K / 3.0F) - this.t;
      double var10 = var3.u - var2.u;
      double var12 = (double)ns.a(var6 * var6 + var10 * var10);
      if (!(var12 < 1.0E-7D)) {
         float var14 = (float)(ns.b(var10, var6) * 180.0D / 3.1415927410125732D) - 90.0F;
         float var15 = (float)(-(ns.b(var8, var12) * 180.0D / 3.1415927410125732D));
         double var16 = var6 / var12;
         double var18 = var10 / var12;
         this.b(var2.s + var16, this.t, var2.u + var18, var14, var15);
         float var20 = (float)(var12 * 0.20000000298023224D);
         this.c(var6, var8 + (double)var20, var10, var4, var5);
      }
   }

   public wq(adm var1) {
      super(var1);
      this.j = 10.0D;
      this.a(0.5F, 0.5F);
   }

   public void a(dn var1) {
      this.d = var1.e("xTile");
      this.e = var1.e("yTile");
      this.f = var1.e("zTile");
      this.ar = var1.e("life");
      if (var1.b("inTile", 8)) {
         this.g = afh.b(var1.j("inTile"));
      } else {
         this.g = afh.c(var1.d("inTile") & 255);
      }

      this.h = var1.d("inData") & 255;
      this.b = var1.d("shake") & 255;
      this.i = var1.d("inGround") == 1;
      if (var1.b("damage", 99)) {
         this.at = var1.i("damage");
      }

      if (var1.b("pickup", 99)) {
         this.a = var1.d("pickup");
      } else if (var1.b("player", 99)) {
         this.a = var1.n("player") ? 1 : 0;
      }

   }

   public void t_() {
      super.t_();
      if (this.B == 0.0F && this.A == 0.0F) {
         float var1 = ns.a(this.v * this.v + this.x * this.x);
         this.A = this.y = (float)(ns.b(this.v, this.x) * 180.0D / 3.1415927410125732D);
         this.B = this.z = (float)(ns.b(this.w, (double)var1) * 180.0D / 3.1415927410125732D);
      }

      cj var18 = new cj(this.d, this.e, this.f);
      alz var2 = this.o.p(var18);
      afh var3 = var2.c();
      if (var3.t() != arm.a) {
         var3.a((adq)this.o, (cj)var18);
         aug var4 = var3.a(this.o, var18, var2);
         if (var4 != null && var4.a(new aui(this.s, this.t, this.u))) {
            this.i = true;
         }
      }

      if (this.b > 0) {
         --this.b;
      }

      if (this.i) {
         int var20 = var3.c(var2);
         if (var3 == this.g && var20 == this.h) {
            ++this.ar;
            if (this.ar >= 1200) {
               this.J();
            }
         } else {
            this.i = false;
            this.v *= (double)(this.V.nextFloat() * 0.2F);
            this.w *= (double)(this.V.nextFloat() * 0.2F);
            this.x *= (double)(this.V.nextFloat() * 0.2F);
            this.ar = 0;
            this.as = 0;
         }

      } else {
         ++this.as;
         aui var19 = new aui(this.s, this.t, this.u);
         aui var5 = new aui(this.s + this.v, this.t + this.w, this.u + this.x);
         auh var6 = this.o.a(var19, var5, false, true, false);
         var19 = new aui(this.s, this.t, this.u);
         var5 = new aui(this.s + this.v, this.t + this.w, this.u + this.x);
         if (var6 != null) {
            var5 = new aui(var6.c.a, var6.c.b, var6.c.c);
         }

         pk var7 = null;
         List var8 = this.o.b((pk)this, (aug)this.aR().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D));
         double var9 = 0.0D;

         int var11;
         float var13;
         for(var11 = 0; var11 < var8.size(); ++var11) {
            pk var12 = (pk)var8.get(var11);
            if (var12.ad() && (var12 != this.c || this.as >= 5)) {
               var13 = 0.3F;
               aug var14 = var12.aR().b((double)var13, (double)var13, (double)var13);
               auh var15 = var14.a(var19, var5);
               if (var15 != null) {
                  double var16 = var19.g(var15.c);
                  if (var16 < var9 || var9 == 0.0D) {
                     var7 = var12;
                     var9 = var16;
                  }
               }
            }
         }

         if (var7 != null) {
            var6 = new auh(var7);
         }

         if (var6 != null && var6.d != null && var6.d instanceof wn) {
            wn var21 = (wn)var6.d;
            if (var21.bA.a || this.c instanceof wn && !((wn)this.c).a(var21)) {
               var6 = null;
            }
         }

         float var22;
         float var30;
         if (var6 != null) {
            if (var6.d != null) {
               var22 = ns.a(this.v * this.v + this.w * this.w + this.x * this.x);
               int var24 = ns.f((double)var22 * this.at);
               if (this.l()) {
                  var24 += this.V.nextInt(var24 / 2 + 2);
               }

               ow var26;
               if (this.c == null) {
                  var26 = ow.a((wq)this, this);
               } else {
                  var26 = ow.a(this, this.c);
               }

               if (this.at() && !(var6.d instanceof vo)) {
                  var6.d.e(5);
               }

               if (var6.d.a(var26, (float)var24)) {
                  if (var6.d instanceof pr) {
                     pr var28 = (pr)var6.d;
                     if (!this.o.D) {
                        var28.o(var28.bv() + 1);
                     }

                     if (this.au > 0) {
                        var30 = ns.a(this.v * this.v + this.x * this.x);
                        if (var30 > 0.0F) {
                           var6.d.g(this.v * (double)this.au * 0.6000000238418579D / (double)var30, 0.1D, this.x * (double)this.au * 0.6000000238418579D / (double)var30);
                        }
                     }

                     if (this.c instanceof pr) {
                        ack.a(var28, this.c);
                        ack.b((pr)this.c, var28);
                     }

                     if (this.c != null && var6.d != this.c && var6.d instanceof wn && this.c instanceof lf) {
                        ((lf)this.c).a.a((ff)(new gm(6, 0.0F)));
                     }
                  }

                  this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
                  if (!(var6.d instanceof vo)) {
                     this.J();
                  }
               } else {
                  this.v *= -0.10000000149011612D;
                  this.w *= -0.10000000149011612D;
                  this.x *= -0.10000000149011612D;
                  this.y += 180.0F;
                  this.A += 180.0F;
                  this.as = 0;
               }
            } else {
               cj var23 = var6.a();
               this.d = var23.n();
               this.e = var23.o();
               this.f = var23.p();
               alz var25 = this.o.p(var23);
               this.g = var25.c();
               this.h = this.g.c(var25);
               this.v = (double)((float)(var6.c.a - this.s));
               this.w = (double)((float)(var6.c.b - this.t));
               this.x = (double)((float)(var6.c.c - this.u));
               var13 = ns.a(this.v * this.v + this.w * this.w + this.x * this.x);
               this.s -= this.v / (double)var13 * 0.05000000074505806D;
               this.t -= this.w / (double)var13 * 0.05000000074505806D;
               this.u -= this.x / (double)var13 * 0.05000000074505806D;
               this.a("random.bowhit", 1.0F, 1.2F / (this.V.nextFloat() * 0.2F + 0.9F));
               this.i = true;
               this.b = 7;
               this.a(false);
               if (this.g.t() != arm.a) {
                  this.g.a((adm)this.o, var23, (alz)var25, (pk)this);
               }
            }
         }

         if (this.l()) {
            for(var11 = 0; var11 < 4; ++var11) {
               this.o.a(cy.j, this.s + this.v * (double)var11 / 4.0D, this.t + this.w * (double)var11 / 4.0D, this.u + this.x * (double)var11 / 4.0D, -this.v, -this.w + 0.2D, -this.x);
            }
         }

         this.s += this.v;
         this.t += this.w;
         this.u += this.x;
         var22 = ns.a(this.v * this.v + this.x * this.x);
         this.y = (float)(ns.b(this.v, this.x) * 180.0D / 3.1415927410125732D);

         for(this.z = (float)(ns.b(this.w, (double)var22) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
         }

         while(this.z - this.B >= 180.0F) {
            this.B += 360.0F;
         }

         while(this.y - this.A < -180.0F) {
            this.A -= 360.0F;
         }

         while(this.y - this.A >= 180.0F) {
            this.A += 360.0F;
         }

         this.z = this.B + (this.z - this.B) * 0.2F;
         this.y = this.A + (this.y - this.A) * 0.2F;
         float var27 = 0.99F;
         var13 = 0.05F;
         if (this.V()) {
            for(int var29 = 0; var29 < 4; ++var29) {
               var30 = 0.25F;
               this.o.a(cy.e, this.s - this.v * (double)var30, this.t - this.w * (double)var30, this.u - this.x * (double)var30, this.v, this.w, this.x);
            }

            var27 = 0.6F;
         }

         if (this.U()) {
            this.N();
         }

         this.v *= (double)var27;
         this.w *= (double)var27;
         this.x *= (double)var27;
         this.w -= (double)var13;
         this.b(this.s, this.t, this.u);
         this.Q();
      }
   }

   public boolean aD() {
      return false;
   }

   public double j() {
      return this.at;
   }

   public void b(dn var1) {
      var1.a("xTile", (short)this.d);
      var1.a("yTile", (short)this.e);
      var1.a("zTile", (short)this.f);
      var1.a("life", (short)this.ar);
      jy var2 = (jy)afh.c.c(this.g);
      var1.a("inTile", var2 == null ? "" : var2.toString());
      var1.a("inData", (byte)this.h);
      var1.a("shake", (byte)this.b);
      var1.a("inGround", (byte)(this.i ? 1 : 0));
      var1.a("pickup", (byte)this.a);
      var1.a("damage", this.at);
   }
}
