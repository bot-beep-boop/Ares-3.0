import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ur extends pk {
   private boolean as;
   private double aB;
   public wn b;
   private double aC;
   private float ay;
   private double aA;
   private double aE;
   private int h;
   private static final List<us> e;
   private int ax;
   private int at;
   private double aD;
   public pk c;
   private double aH;
   private static final List<us> d;
   private int aw;
   private int au;
   private int i;
   private double aG;
   private afh ar;
   public int a;
   private double aF;
   private int g;
   private int az;
   private static final List<us> f;
   private int av;

   private zx m() {
      float var1 = this.o.s.nextFloat();
      int var2 = ack.g(this.b);
      int var3 = ack.h(this.b);
      float var4 = 0.1F - (float)var2 * 0.025F - (float)var3 * 0.01F;
      float var5 = 0.05F + (float)var2 * 0.01F - (float)var3 * 0.01F;
      var4 = ns.a(var4, 0.0F, 1.0F);
      var5 = ns.a(var5, 0.0F, 1.0F);
      if (var1 < var4) {
         this.b.b(na.D);
         return ((us)oa.a(this.V, d)).a(this.V);
      } else {
         var1 -= var4;
         if (var1 < var5) {
            this.b.b(na.E);
            return ((us)oa.a(this.V, e)).a(this.V);
         } else {
            float var10000 = var1 - var5;
            this.b.b(na.C);
            return ((us)oa.a(this.V, f)).a(this.V);
         }
      }
   }

   public void a(dn var1) {
      this.g = var1.e("xTile");
      this.h = var1.e("yTile");
      this.i = var1.e("zTile");
      if (var1.b("inTile", 8)) {
         this.ar = afh.b(var1.j("inTile"));
      } else {
         this.ar = afh.c(var1.d("inTile") & 255);
      }

      this.a = var1.d("shake") & 255;
      this.as = var1.d("inGround") == 1;
   }

   public void J() {
      super.J();
      if (this.b != null) {
         this.b.bG = null;
      }

   }

   protected void h() {
   }

   public void c(double var1, double var3, double var5, float var7, float var8) {
      float var9 = ns.a(var1 * var1 + var3 * var3 + var5 * var5);
      var1 /= (double)var9;
      var3 /= (double)var9;
      var5 /= (double)var9;
      var1 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var3 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var5 += this.V.nextGaussian() * 0.007499999832361937D * (double)var8;
      var1 *= (double)var7;
      var3 *= (double)var7;
      var5 *= (double)var7;
      this.v = var1;
      this.w = var3;
      this.x = var5;
      float var10 = ns.a(var1 * var1 + var5 * var5);
      this.A = this.y = (float)(ns.b(var1, var5) * 180.0D / 3.1415927410125732D);
      this.B = this.z = (float)(ns.b(var3, (double)var10) * 180.0D / 3.1415927410125732D);
      this.at = 0;
   }

   public boolean a(double var1) {
      double var3 = this.aR().a() * 4.0D;
      if (Double.isNaN(var3)) {
         var3 = 4.0D;
      }

      var3 *= 64.0D;
      return var1 < var3 * var3;
   }

   public ur(adm var1, wn var2) {
      super(var1);
      this.g = -1;
      this.h = -1;
      this.i = -1;
      this.ah = true;
      this.b = var2;
      this.b.bG = this;
      this.a(0.25F, 0.25F);
      this.b(var2.s, var2.t + (double)var2.aS(), var2.u, var2.y, var2.z);
      this.s -= (double)(ns.b(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.t -= 0.10000000149011612D;
      this.u -= (double)(ns.a(this.y / 180.0F * 3.1415927F) * 0.16F);
      this.b(this.s, this.t, this.u);
      float var3 = 0.4F;
      this.v = (double)(-ns.a(this.y / 180.0F * 3.1415927F) * ns.b(this.z / 180.0F * 3.1415927F) * var3);
      this.x = (double)(ns.b(this.y / 180.0F * 3.1415927F) * ns.b(this.z / 180.0F * 3.1415927F) * var3);
      this.w = (double)(-ns.a(this.z / 180.0F * 3.1415927F) * var3);
      this.c(this.v, this.w, this.x, 1.5F, 1.0F);
   }

   public void i(double var1, double var3, double var5) {
      this.aF = this.v = var1;
      this.aG = this.w = var3;
      this.aH = this.x = var5;
   }

   public static List<us> j() {
      return f;
   }

   public void b(dn var1) {
      var1.a("xTile", (short)this.g);
      var1.a("yTile", (short)this.h);
      var1.a("zTile", (short)this.i);
      jy var2 = (jy)afh.c.c(this.ar);
      var1.a("inTile", var2 == null ? "" : var2.toString());
      var1.a("shake", (byte)this.a);
      var1.a("inGround", (byte)(this.as ? 1 : 0));
   }

   public void t_() {
      super.t_();
      if (this.az > 0) {
         double var29 = this.s + (this.aA - this.s) / (double)this.az;
         double var30 = this.t + (this.aB - this.t) / (double)this.az;
         double var31 = this.u + (this.aC - this.u) / (double)this.az;
         double var7 = ns.g(this.aD - (double)this.y);
         this.y = (float)((double)this.y + var7 / (double)this.az);
         this.z = (float)((double)this.z + (this.aE - (double)this.z) / (double)this.az);
         --this.az;
         this.b(var29, var30, var31);
         this.b(this.y, this.z);
      } else {
         if (!this.o.D) {
            zx var1 = this.b.bZ();
            if (this.b.I || !this.b.ai() || var1 == null || var1.b() != zy.aR || this.h(this.b) > 1024.0D) {
               this.J();
               this.b.bG = null;
               return;
            }

            if (this.c != null) {
               if (!this.c.I) {
                  this.s = this.c.s;
                  double var10002 = (double)this.c.K;
                  this.t = this.c.aR().b + var10002 * 0.8D;
                  this.u = this.c.u;
                  return;
               }

               this.c = null;
            }
         }

         if (this.a > 0) {
            --this.a;
         }

         if (this.as) {
            if (this.o.p(new cj(this.g, this.h, this.i)).c() == this.ar) {
               ++this.at;
               if (this.at == 1200) {
                  this.J();
               }

               return;
            }

            this.as = false;
            this.v *= (double)(this.V.nextFloat() * 0.2F);
            this.w *= (double)(this.V.nextFloat() * 0.2F);
            this.x *= (double)(this.V.nextFloat() * 0.2F);
            this.at = 0;
            this.au = 0;
         } else {
            ++this.au;
         }

         aui var28 = new aui(this.s, this.t, this.u);
         aui var2 = new aui(this.s + this.v, this.t + this.w, this.u + this.x);
         auh var3 = this.o.a(var28, var2);
         var28 = new aui(this.s, this.t, this.u);
         var2 = new aui(this.s + this.v, this.t + this.w, this.u + this.x);
         if (var3 != null) {
            var2 = new aui(var3.c.a, var3.c.b, var3.c.c);
         }

         pk var4 = null;
         List var5 = this.o.b((pk)this, (aug)this.aR().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         double var13;
         for(int var8 = 0; var8 < var5.size(); ++var8) {
            pk var9 = (pk)var5.get(var8);
            if (var9.ad() && (var9 != this.b || this.au >= 5)) {
               float var10 = 0.3F;
               aug var11 = var9.aR().b((double)var10, (double)var10, (double)var10);
               auh var12 = var11.a(var28, var2);
               if (var12 != null) {
                  var13 = var28.g(var12.c);
                  if (var13 < var6 || var6 == 0.0D) {
                     var4 = var9;
                     var6 = var13;
                  }
               }
            }
         }

         if (var4 != null) {
            var3 = new auh(var4);
         }

         if (var3 != null) {
            if (var3.d != null) {
               if (var3.d.a(ow.a((pk)this, this.b), 0.0F)) {
                  this.c = var3.d;
               }
            } else {
               this.as = true;
            }
         }

         if (!this.as) {
            this.d(this.v, this.w, this.x);
            float var32 = ns.a(this.v * this.v + this.x * this.x);
            this.y = (float)(ns.b(this.v, this.x) * 180.0D / 3.1415927410125732D);

            for(this.z = (float)(ns.b(this.w, (double)var32) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
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
            float var33 = 0.92F;
            if (this.C || this.D) {
               var33 = 0.5F;
            }

            byte var34 = 5;
            double var35 = 0.0D;

            double var19;
            for(int var36 = 0; var36 < var34; ++var36) {
               aug var14 = this.aR();
               double var15 = var14.e - var14.b;
               double var17 = var14.b + var15 * (double)var36 / (double)var34;
               var19 = var14.b + var15 * (double)(var36 + 1) / (double)var34;
               aug var21 = new aug(var14.a, var17, var14.c, var14.d, var19, var14.f);
               if (this.o.b(var21, arm.h)) {
                  var35 += 1.0D / (double)var34;
               }
            }

            if (!this.o.D && var35 > 0.0D) {
               le var37 = (le)this.o;
               int var38 = 1;
               cj var39 = (new cj(this)).a();
               if (this.V.nextFloat() < 0.25F && this.o.C(var39)) {
                  var38 = 2;
               }

               if (this.V.nextFloat() < 0.5F && !this.o.i(var39)) {
                  --var38;
               }

               if (this.av > 0) {
                  --this.av;
                  if (this.av <= 0) {
                     this.aw = 0;
                     this.ax = 0;
                  }
               } else {
                  float var16;
                  float var18;
                  double var23;
                  afh var25;
                  float var40;
                  double var41;
                  if (this.ax > 0) {
                     this.ax -= var38;
                     if (this.ax <= 0) {
                        this.w -= 0.20000000298023224D;
                        this.a("random.splash", 0.25F, 1.0F + (this.V.nextFloat() - this.V.nextFloat()) * 0.4F);
                        var16 = (float)ns.c(this.aR().b);
                        var37.a(cy.e, this.s, (double)(var16 + 1.0F), this.u, (int)(1.0F + this.J * 20.0F), (double)this.J, 0.0D, (double)this.J, 0.20000000298023224D);
                        var37.a(cy.g, this.s, (double)(var16 + 1.0F), this.u, (int)(1.0F + this.J * 20.0F), (double)this.J, 0.0D, (double)this.J, 0.20000000298023224D);
                        this.av = ns.a((Random)this.V, 10, 30);
                     } else {
                        this.ay = (float)((double)this.ay + this.V.nextGaussian() * 4.0D);
                        var16 = this.ay * 0.017453292F;
                        var40 = ns.a(var16);
                        var18 = ns.b(var16);
                        var19 = this.s + (double)(var40 * (float)this.ax * 0.1F);
                        var41 = (double)((float)ns.c(this.aR().b) + 1.0F);
                        var23 = this.u + (double)(var18 * (float)this.ax * 0.1F);
                        var25 = var37.p(new cj((int)var19, (int)var41 - 1, (int)var23)).c();
                        if (var25 == afi.j || var25 == afi.i) {
                           if (this.V.nextFloat() < 0.15F) {
                              var37.a(cy.e, var19, var41 - 0.10000000149011612D, var23, 1, (double)var40, 0.1D, (double)var18, 0.0D);
                           }

                           float var26 = var40 * 0.04F;
                           float var27 = var18 * 0.04F;
                           var37.a(cy.g, var19, var41, var23, 0, (double)var27, 0.01D, (double)(-var26), 1.0D);
                           var37.a(cy.g, var19, var41, var23, 0, (double)(-var27), 0.01D, (double)var26, 1.0D);
                        }
                     }
                  } else if (this.aw > 0) {
                     this.aw -= var38;
                     var16 = 0.15F;
                     if (this.aw < 20) {
                        var16 = (float)((double)var16 + (double)(20 - this.aw) * 0.05D);
                     } else if (this.aw < 40) {
                        var16 = (float)((double)var16 + (double)(40 - this.aw) * 0.02D);
                     } else if (this.aw < 60) {
                        var16 = (float)((double)var16 + (double)(60 - this.aw) * 0.01D);
                     }

                     if (this.V.nextFloat() < var16) {
                        var40 = ns.a(this.V, 0.0F, 360.0F) * 0.017453292F;
                        var18 = ns.a(this.V, 25.0F, 60.0F);
                        var19 = this.s + (double)(ns.a(var40) * var18 * 0.1F);
                        var41 = (double)((float)ns.c(this.aR().b) + 1.0F);
                        var23 = this.u + (double)(ns.b(var40) * var18 * 0.1F);
                        var25 = var37.p(new cj((int)var19, (int)var41 - 1, (int)var23)).c();
                        if (var25 == afi.j || var25 == afi.i) {
                           var37.a(cy.f, var19, var41, var23, 2 + this.V.nextInt(2), 0.10000000149011612D, 0.0D, 0.10000000149011612D, 0.0D);
                        }
                     }

                     if (this.aw <= 0) {
                        this.ay = ns.a(this.V, 0.0F, 360.0F);
                        this.ax = ns.a((Random)this.V, 20, 80);
                     }
                  } else {
                     this.aw = ns.a((Random)this.V, 100, 900);
                     this.aw -= ack.h(this.b) * 20 * 5;
                  }
               }

               if (this.av > 0) {
                  this.w -= (double)(this.V.nextFloat() * this.V.nextFloat() * this.V.nextFloat()) * 0.2D;
               }
            }

            var13 = var35 * 2.0D - 1.0D;
            this.w += 0.03999999910593033D * var13;
            if (var35 > 0.0D) {
               var33 = (float)((double)var33 * 0.9D);
               this.w *= 0.8D;
            }

            this.v *= (double)var33;
            this.w *= (double)var33;
            this.x *= (double)var33;
            this.b(this.s, this.t, this.u);
         }
      }
   }

   public void a(double var1, double var3, double var5, float var7, float var8, int var9, boolean var10) {
      this.aA = var1;
      this.aB = var3;
      this.aC = var5;
      this.aD = (double)var7;
      this.aE = (double)var8;
      this.az = var9;
      this.v = this.aF;
      this.w = this.aG;
      this.x = this.aH;
   }

   public ur(adm var1) {
      super(var1);
      this.g = -1;
      this.h = -1;
      this.i = -1;
      this.a(0.25F, 0.25F);
      this.ah = true;
   }

   public int l() {
      if (this.o.D) {
         return 0;
      } else {
         byte var1 = 0;
         if (this.c != null) {
            double var2 = this.b.s - this.s;
            double var4 = this.b.t - this.t;
            double var6 = this.b.u - this.u;
            double var8 = (double)ns.a(var2 * var2 + var4 * var4 + var6 * var6);
            double var10 = 0.1D;
            pk var10000 = this.c;
            var10000.v += var2 * var10;
            var10000 = this.c;
            var10000.w += var4 * var10 + (double)ns.a(var8) * 0.08D;
            var10000 = this.c;
            var10000.x += var6 * var10;
            var1 = 3;
         } else if (this.av > 0) {
            uz var13 = new uz(this.o, this.s, this.t, this.u, this.m());
            double var3 = this.b.s - this.s;
            double var5 = this.b.t - this.t;
            double var7 = this.b.u - this.u;
            double var9 = (double)ns.a(var3 * var3 + var5 * var5 + var7 * var7);
            double var11 = 0.1D;
            var13.v = var3 * var11;
            var13.w = var5 * var11 + (double)ns.a(var9) * 0.08D;
            var13.x = var7 * var11;
            this.o.d((pk)var13);
            this.b.o.d((pk)(new pp(this.b.o, this.b.s, this.b.t + 0.5D, this.b.u + 0.5D, this.V.nextInt(6) + 1)));
            var1 = 1;
         }

         if (this.as) {
            var1 = 2;
         }

         this.J();
         this.b.bG = null;
         return var1;
      }
   }

   public ur(adm var1, double var2, double var4, double var6, wn var8) {
      this(var1);
      this.b(var2, var4, var6);
      this.ah = true;
      this.b = var8;
      var8.bG = this;
   }

   static {
      d = Arrays.asList((new us(new zx(zy.T), 10)).a(0.9F), new us(new zx(zy.aF), 10), new us(new zx(zy.aX), 10), new us(new zx(zy.bz), 10), new us(new zx(zy.F), 5), (new us(new zx(zy.aR), 2)).a(0.9F), new us(new zx(zy.z), 10), new us(new zx(zy.y), 5), new us(new zx(zy.aW, 10, zd.p.b()), 1), new us(new zx(afi.bR), 10), new us(new zx(zy.bt), 10));
      e = Arrays.asList(new us(new zx(afi.bx), 1), new us(new zx(zy.co), 1), new us(new zx(zy.aA), 1), (new us(new zx(zy.f), 1)).a(0.25F).a(), (new us(new zx(zy.aR), 1)).a(0.25F).a(), (new us(new zx(zy.aL), 1)).a());
      f = Arrays.asList(new us(new zx(zy.aU, 1, zp.a.a.a()), 60), new us(new zx(zy.aU, 1, zp.a.b.a()), 25), new us(new zx(zy.aU, 1, zp.a.c.a()), 2), new us(new zx(zy.aU, 1, zp.a.d.a()), 13));
   }
}
