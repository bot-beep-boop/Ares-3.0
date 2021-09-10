import java.util.Random;
import org.lwjgl.input.Mouse;

public class aye extends axu implements ayg {
   private boolean F = true;
   protected double u;
   private static final int y;
   protected int f = 256;
   private static final int A;
   protected double s;
   private static final int B;
   protected float r = 1.0F;
   protected int g = 202;
   private static final int z;
   protected int i;
   protected int h;
   protected double w;
   private int D;
   protected double v;
   protected double x;
   protected double t;
   protected axu a;
   private static final jy C;
   private nb E;

   public void a(int var1, int var2, float var3) {
      if (this.F) {
         this.c();
         this.a(this.q, bnq.a("multiplayer.downloadingStats"), this.l / 2, this.m / 2, 16777215);
         this.a(this.q, c_[(int)(ave.J() / 150L % (long)c_.length)], this.l / 2, this.m / 2 + this.q.a * 2, 16777215);
      } else {
         int var4;
         if (Mouse.isButtonDown(0)) {
            var4 = (this.l - this.f) / 2;
            int var5 = (this.m - this.g) / 2;
            int var6 = var4 + 8;
            int var7 = var5 + 17;
            if ((this.D == 0 || this.D == 1) && var1 >= var6 && var1 < var6 + 224 && var2 >= var7 && var2 < var7 + 155) {
               if (this.D == 0) {
                  this.D = 1;
               } else {
                  this.u -= (double)((float)(var1 - this.h) * this.r);
                  this.v -= (double)((float)(var2 - this.i) * this.r);
                  this.w = this.s = this.u;
                  this.x = this.t = this.v;
               }

               this.h = var1;
               this.i = var2;
            }
         } else {
            this.D = 0;
         }

         var4 = Mouse.getDWheel();
         float var11 = this.r;
         if (var4 < 0) {
            this.r += 0.25F;
         } else if (var4 > 0) {
            this.r -= 0.25F;
         }

         this.r = ns.a(this.r, 1.0F, 2.0F);
         if (this.r != var11) {
            float var10000 = var11 - this.r;
            float var12 = var11 * (float)this.f;
            float var8 = var11 * (float)this.g;
            float var9 = this.r * (float)this.f;
            float var10 = this.r * (float)this.g;
            this.u -= (double)((var9 - var12) * 0.5F);
            this.v -= (double)((var10 - var8) * 0.5F);
            this.w = this.s = this.u;
            this.x = this.t = this.v;
         }

         if (this.w < (double)y) {
            this.w = (double)y;
         }

         if (this.x < (double)z) {
            this.x = (double)z;
         }

         if (this.w >= (double)A) {
            this.w = (double)(A - 1);
         }

         if (this.x >= (double)B) {
            this.x = (double)(B - 1);
         }

         this.c();
         this.b(var1, var2, var3);
         bfl.f();
         bfl.i();
         this.f();
         bfl.e();
         bfl.j();
      }

   }

   protected void a(avs var1) {
      if (!this.F) {
         if (var1.k == 1) {
            this.j.a(this.a);
         }

      }
   }

   public boolean d() {
      return !this.F;
   }

   public aye(axu var1, nb var2) {
      this.a = var1;
      this.E = var2;
      short var3 = 141;
      short var4 = 141;
      this.s = this.u = this.w = (double)(mr.f.a * 24 - var3 / 2 - 12);
      this.t = this.v = this.x = (double)(mr.f.b * 24 - var4 / 2);
   }

   protected void b(int var1, int var2, float var3) {
      int var4 = ns.c(this.s + (this.u - this.s) * (double)var3);
      int var5 = ns.c(this.t + (this.v - this.t) * (double)var3);
      if (var4 < y) {
         var4 = y;
      }

      if (var5 < z) {
         var5 = z;
      }

      if (var4 >= A) {
         var4 = A - 1;
      }

      if (var5 >= B) {
         var5 = B - 1;
      }

      int var6 = (this.l - this.f) / 2;
      int var7 = (this.m - this.g) / 2;
      int var8 = var6 + 16;
      int var9 = var7 + 17;
      this.e = 0.0F;
      bfl.c(518);
      bfl.E();
      bfl.b((float)var8, (float)var9, -200.0F);
      bfl.a(1.0F / this.r, 1.0F / this.r, 0.0F);
      bfl.w();
      bfl.f();
      bfl.B();
      bfl.g();
      int var10 = var4 + 288 >> 4;
      int var11 = var5 + 288 >> 4;
      int var12 = (var4 + 288) % 16;
      int var13 = (var5 + 288) % 16;
      boolean var14 = true;
      boolean var15 = true;
      boolean var16 = true;
      boolean var17 = true;
      boolean var18 = true;
      Random var19 = new Random();
      float var20 = 16.0F / this.r;
      float var21 = 16.0F / this.r;

      int var22;
      float var23;
      int var24;
      int var25;
      for(var22 = 0; (float)var22 * var20 - (float)var13 < 155.0F; ++var22) {
         var23 = 0.6F - (float)(var11 + var22) / 25.0F * 0.3F;
         bfl.c(var23, var23, var23, 1.0F);

         for(var24 = 0; (float)var24 * var21 - (float)var12 < 224.0F; ++var24) {
            var19.setSeed((long)(this.j.L().b().hashCode() + var10 + var24 + (var11 + var22) * 16));
            var25 = var19.nextInt(1 + var11 + var22) + (var11 + var22) / 2;
            bmi var26 = this.a((afh)afi.m);
            if (var25 <= 37 && var11 + var22 != 35) {
               if (var25 == 22) {
                  if (var19.nextInt(2) == 0) {
                     var26 = this.a(afi.ag);
                  } else {
                     var26 = this.a(afi.aC);
                  }
               } else if (var25 == 10) {
                  var26 = this.a(afi.p);
               } else if (var25 == 8) {
                  var26 = this.a(afi.q);
               } else if (var25 > 4) {
                  var26 = this.a(afi.b);
               } else if (var25 > 0) {
                  var26 = this.a(afi.d);
               }
            } else {
               afh var27 = afi.h;
               var26 = this.a(var27);
            }

            this.j.P().a(bmh.g);
            this.a(var24 * 16 - var12, var22 * 16 - var13, var26, 16, 16);
         }
      }

      bfl.j();
      bfl.c(515);
      this.j.P().a(C);

      int var30;
      int var31;
      int var37;
      for(var22 = 0; var22 < mr.e.size(); ++var22) {
         mq var34 = (mq)mr.e.get(var22);
         if (var34.c != null) {
            var24 = var34.a * 24 - var4 + 11;
            var25 = var34.b * 24 - var5 + 11;
            int var39 = var34.c.a * 24 - var4 + 11;
            var37 = var34.c.b * 24 - var5 + 11;
            boolean var28 = this.E.a(var34);
            boolean var29 = this.E.b(var34);
            var30 = this.E.c(var34);
            if (var30 <= 4) {
               var31 = -16777216;
               if (var28) {
                  var31 = -6250336;
               } else if (var29) {
                  var31 = -16711936;
               }

               this.a(var24, var39, var25, var31);
               this.b(var39, var25, var37, var31);
               if (var24 > var39) {
                  this.b(var24 - 11 - 7, var25 - 5, 114, 234, 7, 11);
               } else if (var24 < var39) {
                  this.b(var24 + 11, var25 - 5, 107, 234, 7, 11);
               } else if (var25 > var37) {
                  this.b(var24 - 5, var25 - 11 - 7, 96, 234, 11, 7);
               } else if (var25 < var37) {
                  this.b(var24 - 5, var25 + 11, 96, 241, 11, 7);
               }
            }
         }
      }

      mq var33 = null;
      var23 = (float)(var1 - var8) * this.r;
      float var35 = (float)(var2 - var9) * this.r;
      avc.c();
      bfl.f();
      bfl.B();
      bfl.g();

      int var38;
      int var41;
      for(var25 = 0; var25 < mr.e.size(); ++var25) {
         mq var40 = (mq)mr.e.get(var25);
         var37 = var40.a * 24 - var4;
         var38 = var40.b * 24 - var5;
         if (var37 >= -24 && var38 >= -24 && (float)var37 <= 224.0F * this.r && (float)var38 <= 155.0F * this.r) {
            var41 = this.E.c(var40);
            float var43;
            if (this.E.a(var40)) {
               var43 = 0.75F;
               bfl.c(var43, var43, var43, 1.0F);
            } else if (this.E.b(var40)) {
               var43 = 1.0F;
               bfl.c(var43, var43, var43, 1.0F);
            } else if (var41 < 3) {
               var43 = 0.3F;
               bfl.c(var43, var43, var43, 1.0F);
            } else if (var41 == 3) {
               var43 = 0.2F;
               bfl.c(var43, var43, var43, 1.0F);
            } else {
               if (var41 != 4) {
                  continue;
               }

               var43 = 0.1F;
               bfl.c(var43, var43, var43, 1.0F);
            }

            this.j.P().a(C);
            if (var40.g()) {
               this.b(var37 - 2, var38 - 2, 26, 202, 26, 26);
            } else {
               this.b(var37 - 2, var38 - 2, 0, 202, 26, 26);
            }

            if (!this.E.b(var40)) {
               var43 = 0.1F;
               bfl.c(var43, var43, var43, 1.0F);
               this.k.a(false);
            }

            bfl.e();
            bfl.o();
            this.k.b(var40.d, var37 + 3, var38 + 3);
            bfl.b(770, 771);
            bfl.f();
            if (!this.E.b(var40)) {
               this.k.a(true);
            }

            bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
            if (var23 >= (float)var37 && var23 <= (float)(var37 + 22) && var35 >= (float)var38 && var35 <= (float)(var38 + 22)) {
               var33 = var40;
            }
         }
      }

      bfl.i();
      bfl.l();
      bfl.F();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(C);
      this.b(var6, var7, 0, 0, this.f, this.g);
      this.e = 0.0F;
      bfl.c(515);
      bfl.i();
      bfl.w();
      super.a(var1, var2, var3);
      if (var33 != null) {
         String var36 = var33.e().c();
         String var42 = var33.f();
         var37 = var1 + 12;
         var38 = var2 - 4;
         var41 = this.E.c(var33);
         if (this.E.b(var33)) {
            var30 = Math.max(this.q.a(var36), 120);
            var31 = this.q.b(var42, var30);
            if (this.E.a(var33)) {
               var31 += 12;
            }

            this.a(var37 - 3, var38 - 3, var37 + var30 + 3, var38 + var31 + 3 + 12, -1073741824, -1073741824);
            this.q.a(var42, var37, var38 + 12, var30, -6250336);
            if (this.E.a(var33)) {
               this.q.a(bnq.a("achievement.taken"), (float)var37, (float)(var38 + var31 + 4), -7302913);
            }
         } else {
            int var32;
            String var44;
            if (var41 == 3) {
               var36 = bnq.a("achievement.unknown");
               var30 = Math.max(this.q.a(var36), 120);
               var44 = (new fb("achievement.requires", new Object[]{var33.c.e()})).c();
               var32 = this.q.b(var44, var30);
               this.a(var37 - 3, var38 - 3, var37 + var30 + 3, var38 + var32 + 12 + 3, -1073741824, -1073741824);
               this.q.a(var44, var37, var38 + 12, var30, -9416624);
            } else if (var41 < 3) {
               var30 = Math.max(this.q.a(var36), 120);
               var44 = (new fb("achievement.requires", new Object[]{var33.c.e()})).c();
               var32 = this.q.b(var44, var30);
               this.a(var37 - 3, var38 - 3, var37 + var30 + 3, var38 + var32 + 12 + 3, -1073741824, -1073741824);
               this.q.a(var44, var37, var38 + 12, var30, -9416624);
            } else {
               var36 = null;
            }
         }

         if (var36 != null) {
            this.q.a(var36, (float)var37, (float)var38, this.E.b(var33) ? (var33.g() ? -128 : -1) : (var33.g() ? -8355776 : -8355712));
         }
      }

      bfl.j();
      bfl.e();
      avc.a();
   }

   protected void a(char var1, int var2) {
      if (var2 == this.j.t.af.i()) {
         this.j.a((axu)null);
         this.j.n();
      } else {
         super.a(var1, var2);
      }

   }

   protected void f() {
      int var1 = (this.l - this.f) / 2;
      int var2 = (this.m - this.g) / 2;
      this.q.a(bnq.a("gui.achievements"), var1 + 15, var2 + 5, 4210752);
   }

   public void e() {
      if (!this.F) {
         this.s = this.u;
         this.t = this.v;
         double var1 = this.w - this.u;
         double var3 = this.x - this.v;
         if (var1 * var1 + var3 * var3 < 4.0D) {
            this.u += var1;
            this.v += var3;
         } else {
            this.u += var1 * 0.85D;
            this.v += var3 * 0.85D;
         }

      }
   }

   private bmi a(afh var1) {
      return ave.A().ae().a().a(var1.Q());
   }

   public void b() {
      this.j.u().a((ff)(new ig(ig.a.b)));
      this.n.clear();
      this.n.add(new awe(1, this.l / 2 + 24, this.m / 2 + 74, 80, 20, bnq.a("gui.done")));
   }

   static {
      y = mr.a * 24 - 112;
      z = mr.b * 24 - 112;
      A = mr.c * 24 - 77;
      B = mr.d * 24 - 77;
      C = new jy("textures/gui/achievement/achievement_background.png");
   }

   public void a() {
      if (this.F) {
         this.F = false;
      }

   }
}
