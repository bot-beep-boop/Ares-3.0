import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Iterator;
import java.util.List;

public class uk extends vv implements uc, vx {
   private int[] bn = new int[2];
   private float[] b = new float[2];
   private int bp;
   private int[] bo = new int[2];
   private static final Predicate<pk> bq = new Predicate<pk>() {
      public boolean a(pk var1) {
         return var1 instanceof pr && ((pr)var1).bz() != pw.b;
      }

      public boolean apply(Object var1) {
         return this.a((pk)var1);
      }
   };
   private float[] bm = new float[2];
   private float[] c = new float[2];
   private float[] a = new float[2];

   public void a(pk var1) {
      this.m = null;
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(300.0D);
      this.a((qb)vy.d).a(0.6000000238418579D);
      this.a((qb)vy.b).a(40.0D);
   }

   public int s(int var1) {
      return this.ac.c(17 + var1);
   }

   public void aA() {
   }

   public void a(pr var1, float var2) {
      this.a(0, var1);
   }

   public void m() {
      this.w *= 0.6000000238418579D;
      double var4;
      double var6;
      double var8;
      if (!this.o.D && this.s(0) > 0) {
         pk var1 = this.o.a(this.s(0));
         if (var1 != null) {
            if (this.t < var1.t || !this.cm() && this.t < var1.t + 5.0D) {
               if (this.w < 0.0D) {
                  this.w = 0.0D;
               }

               this.w += (0.5D - this.w) * 0.6000000238418579D;
            }

            double var2 = var1.s - this.s;
            var4 = var1.u - this.u;
            var6 = var2 * var2 + var4 * var4;
            if (var6 > 9.0D) {
               var8 = (double)ns.a(var6);
               this.v += (var2 / var8 * 0.5D - this.v) * 0.6000000238418579D;
               this.x += (var4 / var8 * 0.5D - this.x) * 0.6000000238418579D;
            }
         }
      }

      if (this.v * this.v + this.x * this.x > 0.05000000074505806D) {
         this.y = (float)ns.b(this.x, this.v) * 57.295776F - 90.0F;
      }

      super.m();

      int var20;
      for(var20 = 0; var20 < 2; ++var20) {
         this.bm[var20] = this.b[var20];
         this.c[var20] = this.a[var20];
      }

      int var21;
      for(var20 = 0; var20 < 2; ++var20) {
         var21 = this.s(var20 + 1);
         pk var3 = null;
         if (var21 > 0) {
            var3 = this.o.a(var21);
         }

         if (var3 != null) {
            var4 = this.t(var20 + 1);
            var6 = this.u(var20 + 1);
            var8 = this.v(var20 + 1);
            double var10 = var3.s - var4;
            double var12 = var3.t + (double)var3.aS() - var6;
            double var14 = var3.u - var8;
            double var16 = (double)ns.a(var10 * var10 + var14 * var14);
            float var18 = (float)(ns.b(var14, var10) * 180.0D / 3.1415927410125732D) - 90.0F;
            float var19 = (float)(-(ns.b(var12, var16) * 180.0D / 3.1415927410125732D));
            this.a[var20] = this.b(this.a[var20], var19, 40.0F);
            this.b[var20] = this.b(this.b[var20], var18, 10.0F);
         } else {
            this.b[var20] = this.b(this.b[var20], this.aI, 10.0F);
         }
      }

      boolean var22 = this.cm();

      for(var21 = 0; var21 < 3; ++var21) {
         double var23 = this.t(var21);
         double var5 = this.u(var21);
         double var7 = this.v(var21);
         this.o.a(cy.l, var23 + this.V.nextGaussian() * 0.30000001192092896D, var5 + this.V.nextGaussian() * 0.30000001192092896D, var7 + this.V.nextGaussian() * 0.30000001192092896D, 0.0D, 0.0D, 0.0D);
         if (var22 && this.o.s.nextInt(4) == 0) {
            this.o.a(cy.p, var23 + this.V.nextGaussian() * 0.30000001192092896D, var5 + this.V.nextGaussian() * 0.30000001192092896D, var7 + this.V.nextGaussian() * 0.30000001192092896D, 0.699999988079071D, 0.699999988079071D, 0.5D);
         }
      }

      if (this.cl() > 0) {
         for(var21 = 0; var21 < 3; ++var21) {
            this.o.a(cy.p, this.s + this.V.nextGaussian() * 1.0D, this.t + (double)(this.V.nextFloat() * 3.3F), this.u + this.V.nextGaussian() * 1.0D, 0.699999988079071D, 0.699999988079071D, 0.8999999761581421D);
         }
      }

   }

   public uk(adm var1) {
      super(var1);
      this.i(this.bu());
      this.a(0.9F, 3.5F);
      this.ab = true;
      ((sv)this.s()).d(true);
      this.i.a(0, new ra(this));
      this.i.a(2, new sa(this, 1.0D, 40, 20.0F));
      this.i.a(5, new rz(this, 1.0D));
      this.i.a(6, new ri(this, wn.class, 8.0F));
      this.i.a(7, new ry(this));
      this.bi.a(1, new sm(this, false, new Class[0]));
      this.bi.a(2, new sp(this, ps.class, 0, false, false, bq));
      this.b_ = 50;
   }

   public int cl() {
      return this.ac.c(20);
   }

   public static boolean a(afh var0) {
      return var0 != afi.h && var0 != afi.bF && var0 != afi.bG && var0 != afi.bX && var0 != afi.cv;
   }

   public void a(dn var1) {
      super.a(var1);
      this.r(var1.f("Invul"));
   }

   protected String bo() {
      return "mob.wither.hurt";
   }

   public void r(int var1) {
      this.ac.b(20, var1);
   }

   public boolean a(ow var1, float var2) {
      if (this.b(var1)) {
         return false;
      } else if (var1 != ow.f && !(var1.j() instanceof uk)) {
         if (this.cl() > 0 && var1 != ow.j) {
            return false;
         } else {
            pk var3;
            if (this.cm()) {
               var3 = var1.i();
               if (var3 instanceof wq) {
                  return false;
               }
            }

            var3 = var1.j();
            if (var3 != null && !(var3 instanceof wn) && var3 instanceof pr && ((pr)var3).bz() == this.bz()) {
               return false;
            } else {
               if (this.bp <= 0) {
                  this.bp = 20;
               }

               for(int var4 = 0; var4 < this.bo.length; ++var4) {
                  int[] var10000 = this.bo;
                  var10000[var4] += 3;
               }

               return super.a(var1, var2);
            }
         }
      } else {
         return false;
      }
   }

   private double v(int var1) {
      if (var1 <= 0) {
         return this.u;
      } else {
         float var2 = (this.aI + (float)(180 * (var1 - 1))) / 180.0F * 3.1415927F;
         float var3 = ns.a(var2);
         return this.u + (double)var3 * 1.3D;
      }
   }

   protected String bp() {
      return "mob.wither.death";
   }

   public float b(int var1) {
      return this.a[var1];
   }

   protected String z() {
      return "mob.wither.idle";
   }

   private void a(int var1, pr var2) {
      this.a(var1, var2.s, var2.t + (double)var2.aS() * 0.5D, var2.u, var1 == 0 && this.V.nextFloat() < 0.001F);
   }

   public void e(float var1, float var2) {
   }

   private double t(int var1) {
      if (var1 <= 0) {
         return this.s;
      } else {
         float var2 = (this.aI + (float)(180 * (var1 - 1))) / 180.0F * 3.1415927F;
         float var3 = ns.b(var2);
         return this.s + (double)var3 * 1.3D;
      }
   }

   public int br() {
      return 4;
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

   public int b(float var1) {
      return 15728880;
   }

   public boolean cm() {
      return this.bn() <= this.bu() / 2.0F;
   }

   private void a(int var1, double var2, double var4, double var6, boolean var8) {
      this.o.a((wn)null, 1014, new cj(this), 0);
      double var9 = this.t(var1);
      double var11 = this.u(var1);
      double var13 = this.v(var1);
      double var15 = var2 - var9;
      double var17 = var4 - var11;
      double var19 = var6 - var13;
      xd var21 = new xd(this.o, this, var15, var17, var19);
      if (var8) {
         var21.a(true);
      }

      var21.t = var11;
      var21.s = var9;
      var21.u = var13;
      this.o.d((pk)var21);
   }

   protected void h() {
      super.h();
      this.ac.a(17, new Integer(0));
      this.ac.a(18, new Integer(0));
      this.ac.a(19, new Integer(0));
      this.ac.a(20, new Integer(0));
   }

   public pw bz() {
      return pw.b;
   }

   public void c(pf var1) {
   }

   public void b(int var1, int var2) {
      this.ac.b(17 + var1, var2);
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Invul", this.cl());
   }

   protected void D() {
      this.aQ = 0;
   }

   public float a(int var1) {
      return this.b[var1];
   }

   public void n() {
      this.r(220);
      this.i(this.bu() / 3.0F);
   }

   private double u(int var1) {
      return var1 <= 0 ? this.t + 3.0D : this.t + 2.2D;
   }

   protected void E() {
      int var1;
      if (this.cl() > 0) {
         var1 = this.cl() - 1;
         if (var1 <= 0) {
            this.o.a(this, this.s, this.t + (double)this.aS(), this.u, 7.0F, false, this.o.Q().b("mobGriefing"));
            this.o.a(1013, new cj(this), 0);
         }

         this.r(var1);
         if (this.W % 10 == 0) {
            this.h(10.0F);
         }

      } else {
         super.E();

         int var13;
         for(var1 = 1; var1 < 3; ++var1) {
            if (this.W >= this.bn[var1 - 1]) {
               this.bn[var1 - 1] = this.W + 10 + this.V.nextInt(10);
               if (this.o.aa() == oj.c || this.o.aa() == oj.d) {
                  int[] var10000 = this.bo;
                  int var10001 = var1 - 1;
                  int var10003 = var10000[var1 - 1];
                  var10000[var10001] = var10000[var1 - 1] + 1;
                  if (var10003 > 15) {
                     float var2 = 10.0F;
                     float var3 = 5.0F;
                     double var4 = ns.a(this.V, this.s - (double)var2, this.s + (double)var2);
                     double var6 = ns.a(this.V, this.t - (double)var3, this.t + (double)var3);
                     double var8 = ns.a(this.V, this.u - (double)var2, this.u + (double)var2);
                     this.a(var1 + 1, var4, var6, var8, true);
                     this.bo[var1 - 1] = 0;
                  }
               }

               var13 = this.s(var1);
               if (var13 > 0) {
                  pk var15 = this.o.a(var13);
                  if (var15 != null && var15.ai() && !(this.h(var15) > 900.0D) && this.t(var15)) {
                     if (var15 instanceof wn && ((wn)var15).bA.a) {
                        this.b(var1, 0);
                     } else {
                        this.a(var1 + 1, (pr)var15);
                        this.bn[var1 - 1] = this.W + 40 + this.V.nextInt(20);
                        this.bo[var1 - 1] = 0;
                     }
                  } else {
                     this.b(var1, 0);
                  }
               } else {
                  List var14 = this.o.a(pr.class, this.aR().b(20.0D, 8.0D, 20.0D), Predicates.and(bq, po.d));

                  for(int var17 = 0; var17 < 10 && !var14.isEmpty(); ++var17) {
                     pr var5 = (pr)var14.get(this.V.nextInt(var14.size()));
                     if (var5 != this && var5.ai() && this.t(var5)) {
                        if (var5 instanceof wn) {
                           if (!((wn)var5).bA.a) {
                              this.b(var1, var5.F());
                           }
                        } else {
                           this.b(var1, var5.F());
                        }
                        break;
                     }

                     var14.remove(var5);
                  }
               }
            }
         }

         if (this.u() != null) {
            this.b(0, this.u().F());
         } else {
            this.b(0, 0);
         }

         if (this.bp > 0) {
            --this.bp;
            if (this.bp == 0 && this.o.Q().b("mobGriefing")) {
               var1 = ns.c(this.t);
               var13 = ns.c(this.s);
               int var16 = ns.c(this.u);
               boolean var18 = false;

               for(int var19 = -1; var19 <= 1; ++var19) {
                  for(int var20 = -1; var20 <= 1; ++var20) {
                     for(int var7 = 0; var7 <= 3; ++var7) {
                        int var21 = var13 + var19;
                        int var9 = var1 + var7;
                        int var10 = var16 + var20;
                        cj var11 = new cj(var21, var9, var10);
                        afh var12 = this.o.p(var11).c();
                        if (var12.t() != arm.a && a(var12)) {
                           var18 = this.o.b(var11, true) || var18;
                        }
                     }
                  }
               }

               if (var18) {
                  this.o.a((wn)null, 1012, new cj(this), 0);
               }
            }
         }

         if (this.W % 20 == 0) {
            this.h(1.0F);
         }

      }
   }

   protected void b(boolean var1, int var2) {
      uz var3 = this.a(zy.bZ, 1);
      if (var3 != null) {
         var3.u();
      }

      if (!this.o.D) {
         Iterator var4 = this.o.a(wn.class, this.aR().b(50.0D, 100.0D, 50.0D)).iterator();

         while(var4.hasNext()) {
            wn var5 = (wn)var4.next();
            var5.b((mw)mr.J);
         }
      }

   }
}
