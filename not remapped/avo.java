import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class avo extends avp {
   private static final jy h = new jy("textures/misc/pumpkinblur.png");
   private static final jy g = new jy("textures/gui/widgets.png");
   private static final jy f = new jy("textures/misc/vignette.png");
   private long E = 0L;
   private final Random i = new Random();
   private long F = 0L;
   private final ave j;
   private final awk m;
   private int r;
   private final awm u;
   private final bjh k;
   private zx s;
   public float a = 1.0F;
   private int C = 0;
   private int p;
   private final avv t;
   private int n;
   private String o = "";
   private int w;
   private boolean q;
   private String y = "";
   private int A;
   private int D = 0;
   private final awh v;
   private int B;
   private final avt l;
   private int z;
   private String x = "";

   public void c() {
      if (this.p > 0) {
         --this.p;
      }

      if (this.w > 0) {
         --this.w;
         if (this.w <= 0) {
            this.x = "";
            this.y = "";
         }
      }

      ++this.n;
      this.m.a();
      if (this.j.h != null) {
         zx var1 = this.j.h.bi.h();
         if (var1 == null) {
            this.r = 0;
         } else if (this.s == null || var1.b() != this.s.b() || !zx.a(var1, this.s) || !var1.e() && var1.i() != this.s.i()) {
            this.r = 40;
         } else if (this.r > 0) {
            --this.r;
         }

         this.s = var1;
      }

   }

   private void a(float var1, avr var2) {
      var1 = 1.0F - var1;
      var1 = ns.a(var1, 0.0F, 1.0F);
      ams var3 = this.j.f.af();
      float var4 = (float)var3.a((pk)this.j.h);
      double var5 = Math.min(var3.o() * (double)var3.p() * 1000.0D, Math.abs(var3.j() - var3.h()));
      double var7 = Math.max((double)var3.q(), var5);
      if ((double)var4 < var7) {
         var4 = 1.0F - (float)((double)var4 / var7);
      } else {
         var4 = 0.0F;
      }

      this.a = (float)((double)this.a + (double)(var1 - this.a) * 0.01D);
      bfl.i();
      bfl.a(false);
      bfl.a(0, 769, 1, 0);
      if (var4 > 0.0F) {
         bfl.c(0.0F, var4, var4, 1.0F);
      } else {
         bfl.c(this.a, this.a, this.a, 1.0F);
      }

      this.j.P().a(f);
      bfx var9 = bfx.a();
      bfd var10 = var9.c();
      var10.a(7, bms.g);
      var10.b(0.0D, (double)var2.b(), -90.0D).a(0.0D, 1.0D).d();
      var10.b((double)var2.a(), (double)var2.b(), -90.0D).a(1.0D, 1.0D).d();
      var10.b((double)var2.a(), 0.0D, -90.0D).a(1.0D, 0.0D).d();
      var10.b(0.0D, 0.0D, -90.0D).a(0.0D, 0.0D).d();
      var9.b();
      bfl.a(true);
      bfl.j();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.a(770, 771, 1, 0);
   }

   public void a(String var1, boolean var2) {
      this.o = var1;
      this.p = 60;
      this.q = var2;
   }

   private void a(int var1, int var2, int var3, float var4, wn var5) {
      zx var6 = var5.bi.a[var1];
      if (var6 != null) {
         float var7 = (float)var6.c - var4;
         if (var7 > 0.0F) {
            bfl.E();
            float var8 = 1.0F + var7 / 5.0F;
            bfl.b((float)(var2 + 8), (float)(var3 + 12), 0.0F);
            bfl.a(1.0F / var8, (var8 + 1.0F) / 2.0F, 1.0F);
            bfl.b((float)(-(var2 + 8)), (float)(-(var3 + 12)), 0.0F);
         }

         this.k.b(var6, var2, var3);
         if (var7 > 0.0F) {
            bfl.F();
         }

         this.k.a(this.j.k, var6, var2, var3);
      }
   }

   public void b(avr var1) {
      this.j.A.a("demo");
      String var2 = "";
      if (this.j.f.K() >= 120500L) {
         var2 = bnq.a("demo.demoExpired");
      } else {
         var2 = bnq.a("demo.remainingTime", nx.a((int)(120500L - this.j.f.K())));
      }

      int var3 = this.f().a(var2);
      this.f().a(var2, (float)(var1.a() - var3 - 10), 5.0F, 16777215);
      this.j.A.b();
   }

   private void d(avr var1) {
      if (this.j.ac() instanceof wn) {
         wn var2 = (wn)this.j.ac();
         int var3 = ns.f(var2.bn());
         boolean var4 = this.F > (long)this.n && (this.F - (long)this.n) / 3L % 2L == 1L;
         if (var3 < this.C && var2.Z > 0) {
            this.E = ave.J();
            this.F = (long)(this.n + 20);
         } else if (var3 > this.C && var2.Z > 0) {
            this.E = ave.J();
            this.F = (long)(this.n + 10);
         }

         if (ave.J() - this.E > 1000L) {
            this.C = var3;
            this.D = var3;
            this.E = ave.J();
         }

         this.C = var3;
         int var5 = this.D;
         this.i.setSeed((long)(this.n * 312871));
         boolean var6 = false;
         xg var7 = var2.cl();
         int var8 = var7.a();
         int var9 = var7.b();
         qc var10 = var2.a((qb)vy.a);
         int var11 = var1.a() / 2 - 91;
         int var12 = var1.a() / 2 + 91;
         int var13 = var1.b() - 39;
         float var14 = (float)var10.e();
         float var15 = var2.bN();
         int var16 = ns.f((var14 + var15) / 2.0F / 10.0F);
         int var17 = Math.max(10 - (var16 - 2), 3);
         int var18 = var13 - (var16 - 1) * var17 - 10;
         float var19 = var15;
         int var20 = var2.br();
         int var21 = -1;
         if (var2.a((pe)pe.l)) {
            var21 = this.n % ns.f(var14 + 5.0F);
         }

         this.j.A.a("armor");

         int var22;
         int var23;
         for(var22 = 0; var22 < 10; ++var22) {
            if (var20 > 0) {
               var23 = var11 + var22 * 8;
               if (var22 * 2 + 1 < var20) {
                  this.b(var23, var18, 34, 9, 9, 9);
               }

               if (var22 * 2 + 1 == var20) {
                  this.b(var23, var18, 25, 9, 9, 9);
               }

               if (var22 * 2 + 1 > var20) {
                  this.b(var23, var18, 16, 9, 9, 9);
               }
            }
         }

         this.j.A.c("health");

         int var25;
         int var26;
         int var27;
         for(var22 = ns.f((var14 + var15) / 2.0F) - 1; var22 >= 0; --var22) {
            var23 = 16;
            if (var2.a((pe)pe.u)) {
               var23 += 36;
            } else if (var2.a((pe)pe.v)) {
               var23 += 72;
            }

            byte var24 = 0;
            if (var4) {
               var24 = 1;
            }

            var25 = ns.f((float)(var22 + 1) / 10.0F) - 1;
            var26 = var11 + var22 % 10 * 8;
            var27 = var13 - var25 * var17;
            if (var3 <= 4) {
               var27 += this.i.nextInt(2);
            }

            if (var22 == var21) {
               var27 -= 2;
            }

            byte var28 = 0;
            if (var2.o.P().t()) {
               var28 = 5;
            }

            this.b(var26, var27, 16 + var24 * 9, 9 * var28, 9, 9);
            if (var4) {
               if (var22 * 2 + 1 < var5) {
                  this.b(var26, var27, var23 + 54, 9 * var28, 9, 9);
               }

               if (var22 * 2 + 1 == var5) {
                  this.b(var26, var27, var23 + 63, 9 * var28, 9, 9);
               }
            }

            if (var19 > 0.0F) {
               if (var19 == var15 && var15 % 2.0F == 1.0F) {
                  this.b(var26, var27, var23 + 153, 9 * var28, 9, 9);
               } else {
                  this.b(var26, var27, var23 + 144, 9 * var28, 9, 9);
               }

               var19 -= 2.0F;
            } else {
               if (var22 * 2 + 1 < var3) {
                  this.b(var26, var27, var23 + 36, 9 * var28, 9, 9);
               }

               if (var22 * 2 + 1 == var3) {
                  this.b(var26, var27, var23 + 45, 9 * var28, 9, 9);
               }
            }
         }

         pk var34 = var2.m;
         int var35;
         if (var34 == null) {
            this.j.A.c("food");

            for(var23 = 0; var23 < 10; ++var23) {
               var35 = var13;
               var25 = 16;
               byte var36 = 0;
               if (var2.a((pe)pe.s)) {
                  var25 += 36;
                  var36 = 13;
               }

               if (var2.cl().e() <= 0.0F && this.n % (var8 * 3 + 1) == 0) {
                  var35 = var13 + (this.i.nextInt(3) - 1);
               }

               if (var6) {
                  var36 = 1;
               }

               var27 = var12 - var23 * 8 - 9;
               this.b(var27, var35, 16 + var36 * 9, 27, 9, 9);
               if (var6) {
                  if (var23 * 2 + 1 < var9) {
                     this.b(var27, var35, var25 + 54, 27, 9, 9);
                  }

                  if (var23 * 2 + 1 == var9) {
                     this.b(var27, var35, var25 + 63, 27, 9, 9);
                  }
               }

               if (var23 * 2 + 1 < var8) {
                  this.b(var27, var35, var25 + 36, 27, 9, 9);
               }

               if (var23 * 2 + 1 == var8) {
                  this.b(var27, var35, var25 + 45, 27, 9, 9);
               }
            }
         } else if (var34 instanceof pr) {
            this.j.A.c("mountHealth");
            pr var37 = (pr)var34;
            var35 = (int)Math.ceil((double)var37.bn());
            float var38 = var37.bu();
            var26 = (int)(var38 + 0.5F) / 2;
            if (var26 > 30) {
               var26 = 30;
            }

            var27 = var13;

            for(int var39 = 0; var26 > 0; var39 += 20) {
               int var29 = Math.min(var26, 10);
               var26 -= var29;

               for(int var30 = 0; var30 < var29; ++var30) {
                  byte var31 = 52;
                  byte var32 = 0;
                  if (var6) {
                     var32 = 1;
                  }

                  int var33 = var12 - var30 * 8 - 9;
                  this.b(var33, var27, var31 + var32 * 9, 9, 9, 9);
                  if (var30 * 2 + 1 + var39 < var35) {
                     this.b(var33, var27, var31 + 36, 9, 9, 9);
                  }

                  if (var30 * 2 + 1 + var39 == var35) {
                     this.b(var33, var27, var31 + 45, 9, 9, 9);
                  }
               }

               var27 -= 10;
            }
         }

         this.j.A.c("air");
         if (var2.a((arm)arm.h)) {
            var23 = this.j.h.az();
            var35 = ns.f((double)(var23 - 2) * 10.0D / 300.0D);
            var25 = ns.f((double)var23 * 10.0D / 300.0D) - var35;

            for(var26 = 0; var26 < var35 + var25; ++var26) {
               if (var26 < var35) {
                  this.b(var12 - var26 * 8 - 9, var18, 16, 18, 9, 9);
               } else {
                  this.b(var12 - var26 * 8 - 9, var18, 25, 18, 9, 9);
               }
            }
         }

         this.j.A.b();
      }
   }

   public awm g() {
      return this.u;
   }

   private void e(avr var1) {
      bfl.i();
      bfl.a(false);
      bfl.a(770, 771, 1, 0);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.c();
      this.j.P().a(h);
      bfx var2 = bfx.a();
      bfd var3 = var2.c();
      var3.a(7, bms.g);
      var3.b(0.0D, (double)var1.b(), -90.0D).a(0.0D, 1.0D).d();
      var3.b((double)var1.a(), (double)var1.b(), -90.0D).a(1.0D, 1.0D).d();
      var3.b((double)var1.a(), 0.0D, -90.0D).a(1.0D, 0.0D).d();
      var3.b(0.0D, 0.0D, -90.0D).a(0.0D, 0.0D).d();
      var2.b();
      bfl.a(true);
      bfl.j();
      bfl.d();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public void a() {
      this.z = 10;
      this.A = 70;
      this.B = 20;
   }

   public void i() {
      this.v.a();
   }

   public avn f() {
      return this.j.k;
   }

   public void a(String var1, String var2, int var3, int var4, int var5) {
      if (var1 == null && var2 == null && var3 < 0 && var4 < 0 && var5 < 0) {
         this.x = "";
         this.y = "";
         this.w = 0;
      } else if (var1 != null) {
         this.x = var1;
         this.w = this.z + this.A + this.B;
      } else if (var2 != null) {
         this.y = var2;
      } else {
         if (var3 >= 0) {
            this.z = var3;
         }

         if (var4 >= 0) {
            this.A = var4;
         }

         if (var5 >= 0) {
            this.B = var5;
         }

         if (this.w > 0) {
            this.w = this.z + this.A + this.B;
         }

      }
   }

   public void a(avr var1, int var2) {
      this.j.A.a("jumpBar");
      this.j.P().a(avp.d);
      float var3 = this.j.h.z();
      short var4 = 182;
      int var5 = (int)(var3 * (float)(var4 + 1));
      int var6 = var1.b() - 32 + 3;
      this.b(var2, var6, 0, 84, var4, 5);
      if (var5 > 0) {
         this.b(var2, var6, 0, 89, var5, 5);
      }

      this.j.A.b();
   }

   public void a(float var1) {
      avr var2 = new avr(this.j);
      int var3 = var2.a();
      int var4 = var2.b();
      this.j.o.j();
      bfl.l();
      if (ave.w()) {
         this.a(this.j.h.c(var1), var2);
      } else {
         bfl.a(770, 771, 1, 0);
      }

      zx var5 = this.j.h.bi.e(3);
      if (this.j.t.aB == 0 && var5 != null && var5.b() == zw.a(afi.aU)) {
         this.e(var2);
      }

      if (!this.j.h.a((pe)pe.k)) {
         float var6 = this.j.h.bI + (this.j.h.bH - this.j.h.bI) * var1;
         if (var6 > 0.0F) {
            this.b(var6, var2);
         }
      }

      if (this.j.c.a()) {
         this.u.a(var2, var1);
      } else {
         this.a(var2, var1);
      }

      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(d);
      bfl.l();
      if (this.b()) {
         bfl.a(775, 769, 1, 0);
         bfl.d();
         this.b(var3 / 2 - 7, var4 / 2 - 7, 0, 0, 16, 16);
      }

      bfl.a(770, 771, 1, 0);
      this.j.A.a("bossHealth");
      this.j();
      this.j.A.b();
      if (this.j.c.b()) {
         this.d(var2);
      }

      bfl.k();
      float var7;
      int var8;
      int var11;
      if (this.j.h.cg() > 0) {
         this.j.A.a("sleep");
         bfl.i();
         bfl.c();
         var11 = this.j.h.cg();
         var7 = (float)var11 / 100.0F;
         if (var7 > 1.0F) {
            var7 = 1.0F - (float)(var11 - 100) / 10.0F;
         }

         var8 = (int)(220.0F * var7) << 24 | 1052704;
         a(0, 0, var3, var4, var8);
         bfl.d();
         bfl.j();
         this.j.A.b();
      }

      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      var11 = var3 / 2 - 91;
      if (this.j.h.y()) {
         this.a(var2, var11);
      } else if (this.j.c.f()) {
         this.b(var2, var11);
      }

      if (this.j.t.D && !this.j.c.a()) {
         this.a(var2);
      } else if (this.j.h.v()) {
         this.u.a(var2);
      }

      if (this.j.t()) {
         this.b(var2);
      }

      if (this.j.t.aC) {
         this.t.a(var2);
      }

      int var9;
      if (this.p > 0) {
         this.j.A.a("overlayMessage");
         var7 = (float)this.p - var1;
         var8 = (int)(var7 * 255.0F / 20.0F);
         if (var8 > 255) {
            var8 = 255;
         }

         if (var8 > 8) {
            bfl.E();
            bfl.b((float)(var3 / 2), (float)(var4 - 68), 0.0F);
            bfl.l();
            bfl.a(770, 771, 1, 0);
            var9 = 16777215;
            if (this.q) {
               var9 = ns.c(var7 / 50.0F, 0.7F, 0.6F) & 16777215;
            }

            this.f().a(this.o, -this.f().a(this.o) / 2, -4, var9 + (var8 << 24 & -16777216));
            bfl.k();
            bfl.F();
         }

         this.j.A.b();
      }

      if (this.w > 0) {
         this.j.A.a("titleAndSubtitle");
         var7 = (float)this.w - var1;
         var8 = 255;
         if (this.w > this.B + this.A) {
            float var13 = (float)(this.z + this.A + this.B) - var7;
            var8 = (int)(var13 * 255.0F / (float)this.z);
         }

         if (this.w <= this.B) {
            var8 = (int)(var7 * 255.0F / (float)this.B);
         }

         var8 = ns.a(var8, 0, 255);
         if (var8 > 8) {
            bfl.E();
            bfl.b((float)(var3 / 2), (float)(var4 / 2), 0.0F);
            bfl.l();
            bfl.a(770, 771, 1, 0);
            bfl.E();
            bfl.a(4.0F, 4.0F, 4.0F);
            var9 = var8 << 24 & -16777216;
            this.f().a(this.x, (float)(-this.f().a(this.x) / 2), -10.0F, 16777215 | var9, true);
            bfl.F();
            bfl.E();
            bfl.a(2.0F, 2.0F, 2.0F);
            this.f().a(this.y, (float)(-this.f().a(this.y) / 2), 5.0F, 16777215 | var9, true);
            bfl.F();
            bfl.k();
            bfl.F();
         }

         this.j.A.b();
      }

      auo var12 = this.j.f.Z();
      auk var16 = null;
      aul var15 = var12.h(this.j.h.e_());
      if (var15 != null) {
         int var10 = var15.l().b();
         if (var10 >= 0) {
            var16 = var12.a(3 + var10);
         }
      }

      auk var14 = var16 != null ? var16 : var12.a(1);
      if (var14 != null) {
         this.a(var14, var2);
      }

      bfl.l();
      bfl.a(770, 771, 1, 0);
      bfl.c();
      bfl.E();
      bfl.b(0.0F, (float)(var4 - 48), 0.0F);
      this.j.A.a("chat");
      this.l.a(this.n);
      this.j.A.b();
      bfl.F();
      var14 = var12.a(0);
      if (!this.j.t.al.d() || this.j.E() && this.j.h.a.d().size() <= 1 && var14 == null) {
         this.v.a(false);
      } else {
         this.v.a(true);
         this.v.a(var3, var12, var14);
      }

      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.f();
      bfl.d();
   }

   public void a(String var1) {
      this.a(bnq.a("record.nowPlaying", var1), true);
   }

   public avt d() {
      return this.l;
   }

   protected void a(avr var1, float var2) {
      if (this.j.ac() instanceof wn) {
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.j.P().a(g);
         wn var3 = (wn)this.j.ac();
         int var4 = var1.a() / 2;
         float var5 = this.e;
         this.e = -90.0F;
         this.b(var4 - 91, var1.b() - 22, 0, 0, 182, 22);
         this.b(var4 - 91 - 1 + var3.bi.c * 20, var1.b() - 22 - 1, 0, 22, 24, 22);
         this.e = var5;
         bfl.B();
         bfl.l();
         bfl.a(770, 771, 1, 0);
         avc.c();

         for(int var6 = 0; var6 < 9; ++var6) {
            int var7 = var1.a() / 2 - 90 + var6 * 20 + 2;
            int var8 = var1.b() - 16 - 3;
            this.a(var6, var7, var8, var2, var3);
         }

         avc.a();
         bfl.C();
         bfl.k();
      }
   }

   private void j() {
      if (bfc.c != null && bfc.b > 0) {
         --bfc.b;
         avn var1 = this.j.k;
         avr var2 = new avr(this.j);
         int var3 = var2.a();
         short var4 = 182;
         int var5 = var3 / 2 - var4 / 2;
         int var6 = (int)(bfc.a * (float)(var4 + 1));
         byte var7 = 12;
         this.b(var5, var7, 0, 74, var4, 5);
         this.b(var5, var7, 0, 74, var4, 5);
         if (var6 > 0) {
            this.b(var5, var7, 0, 79, var6, 5);
         }

         String var8 = bfc.c;
         this.f().a(var8, (float)(var3 / 2 - this.f().a(var8) / 2), (float)(var7 - 10), 16777215);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.j.P().a(d);
      }
   }

   public void c(avr var1) {
      this.m.a(var1.a() - 10, 10);
   }

   public avo(ave var1) {
      this.j = var1;
      this.k = var1.ag();
      this.t = new avv(var1);
      this.u = new awm(var1);
      this.l = new avt(var1);
      this.m = new awk(var1);
      this.v = new awh(var1, this);
      this.a();
   }

   public awh h() {
      return this.v;
   }

   private void b(float var1, avr var2) {
      if (var1 < 1.0F) {
         var1 *= var1;
         var1 *= var1;
         var1 = var1 * 0.8F + 0.2F;
      }

      bfl.c();
      bfl.i();
      bfl.a(false);
      bfl.a(770, 771, 1, 0);
      bfl.c(1.0F, 1.0F, 1.0F, var1);
      this.j.P().a(bmh.g);
      bmi var3 = this.j.ae().a().a(afi.aY.Q());
      float var4 = var3.e();
      float var5 = var3.g();
      float var6 = var3.f();
      float var7 = var3.h();
      bfx var8 = bfx.a();
      bfd var9 = var8.c();
      var9.a(7, bms.g);
      var9.b(0.0D, (double)var2.b(), -90.0D).a((double)var4, (double)var7).d();
      var9.b((double)var2.a(), (double)var2.b(), -90.0D).a((double)var6, (double)var7).d();
      var9.b((double)var2.a(), 0.0D, -90.0D).a((double)var6, (double)var5).d();
      var9.b(0.0D, 0.0D, -90.0D).a((double)var4, (double)var5).d();
      var8.b();
      bfl.a(true);
      bfl.j();
      bfl.d();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public int e() {
      return this.n;
   }

   public void b(avr var1, int var2) {
      this.j.A.a("expBar");
      this.j.P().a(avp.d);
      int var3 = this.j.h.ck();
      int var6;
      if (var3 > 0) {
         short var4 = 182;
         int var5 = (int)(this.j.h.bD * (float)(var4 + 1));
         var6 = var1.b() - 32 + 3;
         this.b(var2, var6, 0, 64, var4, 5);
         if (var5 > 0) {
            this.b(var2, var6, 0, 69, var5, 5);
         }
      }

      this.j.A.b();
      if (this.j.h.bB > 0) {
         this.j.A.a("expLevel");
         int var9 = 8453920;
         String var10 = "" + this.j.h.bB;
         var6 = (var1.a() - this.f().a(var10)) / 2;
         int var7 = var1.b() - 31 - 4;
         boolean var8 = false;
         this.f().a(var10, var6 + 1, var7, 0);
         this.f().a(var10, var6 - 1, var7, 0);
         this.f().a(var10, var6, var7 + 1, 0);
         this.f().a(var10, var6, var7 - 1, 0);
         this.f().a(var10, var6, var7, var9);
         this.j.A.b();
      }

   }

   protected boolean b() {
      if (this.j.t.aC && !this.j.h.cq() && !this.j.t.w) {
         return false;
      } else if (this.j.c.a()) {
         if (this.j.i != null) {
            return true;
         } else {
            if (this.j.s != null && this.j.s.a == auh.a.b) {
               cj var1 = this.j.s.a();
               if (this.j.f.s(var1) instanceof og) {
                  return true;
               }
            }

            return false;
         }
      } else {
         return true;
      }
   }

   public void a(eu var1, boolean var2) {
      this.a(var1.c(), var2);
   }

   public void a(avr var1) {
      this.j.A.a("selectedItemName");
      if (this.r > 0 && this.s != null) {
         String var2 = this.s.q();
         if (this.s.s()) {
            var2 = a.u + var2;
         }

         int var3 = (var1.a() - this.f().a(var2)) / 2;
         int var4 = var1.b() - 59;
         if (!this.j.c.b()) {
            var4 += 14;
         }

         int var5 = (int)((float)this.r * 256.0F / 10.0F);
         if (var5 > 255) {
            var5 = 255;
         }

         if (var5 > 0) {
            bfl.E();
            bfl.l();
            bfl.a(770, 771, 1, 0);
            this.f().a(var2, (float)var3, (float)var4, 16777215 + (var5 << 24));
            bfl.k();
            bfl.F();
         }
      }

      this.j.A.b();
   }

   private void a(auk var1, avr var2) {
      auo var3 = var1.a();
      Collection var4 = var3.i(var1);
      ArrayList var5 = Lists.newArrayList(Iterables.filter(var4, new Predicate<aum>(this) {
         final avo a;

         {
            this.a = var1;
         }

         public boolean a(aum var1) {
            return var1.e() != null && !var1.e().startsWith("#");
         }

         public boolean apply(Object var1) {
            return this.a((aum)var1);
         }
      }));
      ArrayList var21;
      if (var5.size() > 15) {
         var21 = Lists.newArrayList(Iterables.skip(var5, var4.size() - 15));
      } else {
         var21 = var5;
      }

      int var6 = this.f().a(var1.d());

      String var10;
      for(Iterator var7 = var21.iterator(); var7.hasNext(); var6 = Math.max(var6, this.f().a(var10))) {
         aum var8 = (aum)var7.next();
         aul var9 = var3.h(var8.e());
         var10 = aul.a(var9, var8.e()) + ": " + a.m + var8.c();
      }

      int var22 = var21.size() * this.f().a;
      int var23 = var2.b() / 2 + var22 / 3;
      byte var24 = 3;
      int var25 = var2.a() - var6 - var24;
      int var11 = 0;
      Iterator var12 = var21.iterator();

      while(var12.hasNext()) {
         aum var13 = (aum)var12.next();
         ++var11;
         aul var14 = var3.h(var13.e());
         String var15 = aul.a(var14, var13.e());
         String var16 = a.m + "" + var13.c();
         int var18 = var23 - var11 * this.f().a;
         int var19 = var2.a() - var24 + 2;
         a(var25 - 2, var18, var19, var18 + this.f().a, 1342177280);
         this.f().a(var15, var25, var18, 553648127);
         this.f().a(var16, var19 - this.f().a(var16), var18, 553648127);
         if (var11 == var21.size()) {
            String var20 = var1.d();
            a(var25 - 2, var18 - this.f().a - 1, var19, var18 - 1, 1610612736);
            a(var25 - 2, var18 - 1, var19, var18, 1342177280);
            this.f().a(var20, var25 + var6 / 2 - this.f().a(var20) / 2, var18 - this.f().a, 553648127);
         }
      }

   }
}
