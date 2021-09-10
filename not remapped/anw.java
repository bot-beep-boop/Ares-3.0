import java.util.List;
import java.util.Random;

public class anw implements amv {
   double[] f;
   private final apd u = new apd();
   private final adm h;
   private final aom z;
   private final boolean i;
   private final aot w;
   private double[] n;
   private final arc q;
   private final aoy y;
   double[] d;
   private final arc s;
   double[] c;
   private double[] l = new double[256];
   private final aoy x;
   private final aox v = new aox();
   public final arc b;
   private double[] k = new double[256];
   double[] e;
   private final Random j;
   private final arc p;
   double[] g;
   private final arc r;
   private final aom A;
   private final aqi B;
   private double[] m = new double[256];
   private final any C;
   private final aow t = new aow();
   private final arc o;
   public final arc a;

   public boolean a(boolean var1, nu var2) {
      return true;
   }

   public boolean a(int var1, int var2) {
      return true;
   }

   public amy a(cj var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }

   public List<ady.c> a(pt var1, cj var2) {
      if (var1 == pt.a) {
         if (this.B.b(var2)) {
            return this.B.b();
         }

         if (this.B.a(this.h, var2) && this.h.p(var2.b()).c() == afi.by) {
            return this.B.b();
         }
      }

      ady var3 = this.h.b(var2);
      return var3.a(var1);
   }

   public void c() {
   }

   public int g() {
      return 0;
   }

   public cj a(adm var1, String var2, cj var3) {
      return null;
   }

   public void a(amv var1, int var2, int var3) {
      agr.N = true;
      cj var4 = new cj(var2 * 16, 0, var3 * 16);
      adg var5 = new adg(var2, var3);
      this.B.a(this.h, this.j, var5);

      int var6;
      for(var6 = 0; var6 < 8; ++var6) {
         this.y.b(this.h, this.j, var4.a(this.j.nextInt(16) + 8, this.j.nextInt(120) + 4, this.j.nextInt(16) + 8));
      }

      for(var6 = 0; var6 < this.j.nextInt(this.j.nextInt(10) + 1) + 1; ++var6) {
         this.t.b(this.h, this.j, var4.a(this.j.nextInt(16) + 8, this.j.nextInt(120) + 4, this.j.nextInt(16) + 8));
      }

      for(var6 = 0; var6 < this.j.nextInt(this.j.nextInt(10) + 1); ++var6) {
         this.u.b(this.h, this.j, var4.a(this.j.nextInt(16) + 8, this.j.nextInt(120) + 4, this.j.nextInt(16) + 8));
      }

      for(var6 = 0; var6 < 10; ++var6) {
         this.v.b(this.h, this.j, var4.a(this.j.nextInt(16) + 8, this.j.nextInt(128), this.j.nextInt(16) + 8));
      }

      if (this.j.nextBoolean()) {
         this.z.b(this.h, this.j, var4.a(this.j.nextInt(16) + 8, this.j.nextInt(128), this.j.nextInt(16) + 8));
      }

      if (this.j.nextBoolean()) {
         this.A.b(this.h, this.j, var4.a(this.j.nextInt(16) + 8, this.j.nextInt(128), this.j.nextInt(16) + 8));
      }

      for(var6 = 0; var6 < 16; ++var6) {
         this.w.b(this.h, this.j, var4.a(this.j.nextInt(16), this.j.nextInt(108) + 10, this.j.nextInt(16)));
      }

      for(var6 = 0; var6 < 16; ++var6) {
         this.x.b(this.h, this.j, var4.a(this.j.nextInt(16), this.j.nextInt(108) + 10, this.j.nextInt(16)));
      }

      agr.N = false;
   }

   public anw(adm var1, boolean var2, long var3) {
      this.w = new apj(afi.co.Q(), 14, amg.a(afi.aV));
      this.x = new aoy(afi.k, true);
      this.y = new aoy(afi.k, false);
      this.z = new aom(afi.P);
      this.A = new aom(afi.Q);
      this.B = new aqi();
      this.C = new anz();
      this.h = var1;
      this.i = var2;
      this.j = new Random(var3);
      this.o = new arc(this.j, 16);
      this.p = new arc(this.j, 16);
      this.q = new arc(this.j, 8);
      this.r = new arc(this.j, 4);
      this.s = new arc(this.j, 4);
      this.a = new arc(this.j, 10);
      this.b = new arc(this.j, 16);
      var1.b(63);
   }

   public void a(amy var1, int var2, int var3) {
      this.B.a(this, this.h, var2, var3, (ans)null);
   }

   public boolean a(amv var1, amy var2, int var3, int var4) {
      return false;
   }

   public amy d(int var1, int var2) {
      this.j.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      ans var3 = new ans();
      this.a(var1, var2, var3);
      this.b(var1, var2, var3);
      this.C.a(this, this.h, var1, var2, var3);
      if (this.i) {
         this.B.a(this, this.h, var1, var2, var3);
      }

      amy var4 = new amy(this.h, var3, var1, var2);
      ady[] var5 = this.h.v().b((ady[])null, var1 * 16, var2 * 16, 16, 16);
      byte[] var6 = var4.k();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)var5[var7].az;
      }

      var4.l();
      return var4;
   }

   public void a(int var1, int var2, ans var3) {
      byte var4 = 4;
      int var5 = this.h.F() / 2 + 1;
      int var6 = var4 + 1;
      byte var7 = 17;
      int var8 = var4 + 1;
      this.n = this.a(this.n, var1 * var4, 0, var2 * var4, var6, var7, var8);

      for(int var9 = 0; var9 < var4; ++var9) {
         for(int var10 = 0; var10 < var4; ++var10) {
            for(int var11 = 0; var11 < 16; ++var11) {
               double var12 = 0.125D;
               double var14 = this.n[(var9 * var8 + var10) * var7 + var11];
               double var16 = this.n[(var9 * var8 + var10 + 1) * var7 + var11];
               double var18 = this.n[((var9 + 1) * var8 + var10) * var7 + var11];
               double var20 = this.n[((var9 + 1) * var8 + var10 + 1) * var7 + var11];
               double var22 = (this.n[(var9 * var8 + var10) * var7 + var11 + 1] - var14) * var12;
               double var24 = (this.n[(var9 * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
               double var26 = (this.n[((var9 + 1) * var8 + var10) * var7 + var11 + 1] - var18) * var12;
               double var28 = (this.n[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

               for(int var30 = 0; var30 < 8; ++var30) {
                  double var31 = 0.25D;
                  double var33 = var14;
                  double var35 = var16;
                  double var37 = (var18 - var14) * var31;
                  double var39 = (var20 - var16) * var31;

                  for(int var41 = 0; var41 < 4; ++var41) {
                     double var42 = 0.25D;
                     double var44 = var33;
                     double var46 = (var35 - var33) * var42;

                     for(int var48 = 0; var48 < 4; ++var48) {
                        alz var49 = null;
                        if (var11 * 8 + var30 < var5) {
                           var49 = afi.l.Q();
                        }

                        if (var44 > 0.0D) {
                           var49 = afi.aV.Q();
                        }

                        int var50 = var41 + var9 * 4;
                        int var51 = var30 + var11 * 8;
                        int var52 = var48 + var10 * 4;
                        var3.a(var50, var51, var52, var49);
                        var44 += var46;
                     }

                     var33 += var37;
                     var35 += var39;
                  }

                  var14 += var22;
                  var16 += var24;
                  var18 += var26;
                  var20 += var28;
               }
            }
         }
      }

   }

   public String f() {
      return "HellRandomLevelSource";
   }

   private double[] a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 2053.236D;
      this.f = this.a.a(this.f, var2, var3, var4, var5, 1, var7, 1.0D, 0.0D, 1.0D);
      this.g = this.b.a(this.g, var2, var3, var4, var5, 1, var7, 100.0D, 0.0D, 100.0D);
      this.c = this.q.a(this.c, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 60.0D, var8 / 80.0D);
      this.d = this.o.a(this.d, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      this.e = this.p.a(this.e, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      int var12 = 0;
      double[] var13 = new double[var6];

      int var14;
      for(var14 = 0; var14 < var6; ++var14) {
         var13[var14] = Math.cos((double)var14 * 3.141592653589793D * 6.0D / (double)var6) * 2.0D;
         double var15 = (double)var14;
         if (var14 > var6 / 2) {
            var15 = (double)(var6 - 1 - var14);
         }

         if (var15 < 4.0D) {
            var15 = 4.0D - var15;
            var13[var14] -= var15 * var15 * var15 * 10.0D;
         }
      }

      for(var14 = 0; var14 < var5; ++var14) {
         for(int var31 = 0; var31 < var7; ++var31) {
            double var16 = 0.0D;

            for(int var18 = 0; var18 < var6; ++var18) {
               double var19 = 0.0D;
               double var21 = var13[var18];
               double var23 = this.d[var12] / 512.0D;
               double var25 = this.e[var12] / 512.0D;
               double var27 = (this.c[var12] / 10.0D + 1.0D) / 2.0D;
               if (var27 < 0.0D) {
                  var19 = var23;
               } else if (var27 > 1.0D) {
                  var19 = var25;
               } else {
                  var19 = var23 + (var25 - var23) * var27;
               }

               var19 -= var21;
               double var29;
               if (var18 > var6 - 4) {
                  var29 = (double)((float)(var18 - (var6 - 4)) / 3.0F);
                  var19 = var19 * (1.0D - var29) + -10.0D * var29;
               }

               if ((double)var18 < var16) {
                  var29 = (var16 - (double)var18) / 4.0D;
                  var29 = ns.a(var29, 0.0D, 1.0D);
                  var19 = var19 * (1.0D - var29) + -10.0D * var29;
               }

               var1[var12] = var19;
               ++var12;
            }
         }
      }

      return var1;
   }

   public boolean d() {
      return false;
   }

   public boolean e() {
      return true;
   }

   public void b(int var1, int var2, ans var3) {
      int var4 = this.h.F() + 1;
      double var5 = 0.03125D;
      this.k = this.r.a(this.k, var1 * 16, var2 * 16, 0, 16, 16, 1, var5, var5, 1.0D);
      this.l = this.r.a(this.l, var1 * 16, 109, var2 * 16, 16, 1, 16, var5, 1.0D, var5);
      this.m = this.s.a(this.m, var1 * 16, var2 * 16, 0, 16, 16, 1, var5 * 2.0D, var5 * 2.0D, var5 * 2.0D);

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            boolean var9 = this.k[var7 + var8 * 16] + this.j.nextDouble() * 0.2D > 0.0D;
            boolean var10 = this.l[var7 + var8 * 16] + this.j.nextDouble() * 0.2D > 0.0D;
            int var11 = (int)(this.m[var7 + var8 * 16] / 3.0D + 3.0D + this.j.nextDouble() * 0.25D);
            int var12 = -1;
            alz var13 = afi.aV.Q();
            alz var14 = afi.aV.Q();

            for(int var15 = 127; var15 >= 0; --var15) {
               if (var15 < 127 - this.j.nextInt(5) && var15 > this.j.nextInt(5)) {
                  alz var16 = var3.a(var8, var15, var7);
                  if (var16.c() != null && var16.c().t() != arm.a) {
                     if (var16.c() == afi.aV) {
                        if (var12 == -1) {
                           if (var11 <= 0) {
                              var13 = null;
                              var14 = afi.aV.Q();
                           } else if (var15 >= var4 - 4 && var15 <= var4 + 1) {
                              var13 = afi.aV.Q();
                              var14 = afi.aV.Q();
                              if (var10) {
                                 var13 = afi.n.Q();
                                 var14 = afi.aV.Q();
                              }

                              if (var9) {
                                 var13 = afi.aW.Q();
                                 var14 = afi.aW.Q();
                              }
                           }

                           if (var15 < var4 && (var13 == null || var13.c().t() == arm.a)) {
                              var13 = afi.l.Q();
                           }

                           var12 = var11;
                           if (var15 >= var4 - 1) {
                              var3.a(var8, var15, var7, var13);
                           } else {
                              var3.a(var8, var15, var7, var14);
                           }
                        } else if (var12 > 0) {
                           --var12;
                           var3.a(var8, var15, var7, var14);
                        }
                     }
                  } else {
                     var12 = -1;
                  }
               } else {
                  var3.a(var8, var15, var7, afi.h.Q());
               }
            }
         }
      }

   }
}
