import java.util.List;
import java.util.Random;

public class aob implements amv {
   private arc i;
   private double[] m;
   public arc b;
   double[] d;
   private arc k;
   double[] f;
   private Random h;
   private arc j;
   double[] e;
   double[] c;
   double[] g;
   private adm l;
   private ady[] n;
   public arc a;

   public boolean e() {
      return true;
   }

   public boolean d() {
      return false;
   }

   public cj a(adm var1, String var2, cj var3) {
      return null;
   }

   public void a(amv var1, int var2, int var3) {
      agr.N = true;
      cj var4 = new cj(var2 * 16, 0, var3 * 16);
      this.l.b(var4.a(16, 0, 16)).a(this.l, this.l.s, var4);
      agr.N = false;
   }

   private double[] a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      this.f = this.a.a(this.f, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
      this.g = this.b.a(this.g, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
      var8 *= 2.0D;
      this.c = this.k.a(this.c, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.d = this.i.a(this.d, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      this.e = this.j.a(this.e, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      int var12 = 0;

      for(int var13 = 0; var13 < var5; ++var13) {
         for(int var14 = 0; var14 < var7; ++var14) {
            float var15 = (float)(var13 + var2) / 1.0F;
            float var16 = (float)(var14 + var4) / 1.0F;
            float var17 = 100.0F - ns.c(var15 * var15 + var16 * var16) * 8.0F;
            if (var17 > 80.0F) {
               var17 = 80.0F;
            }

            if (var17 < -100.0F) {
               var17 = -100.0F;
            }

            for(int var18 = 0; var18 < var6; ++var18) {
               double var19 = 0.0D;
               double var21 = this.d[var12] / 512.0D;
               double var23 = this.e[var12] / 512.0D;
               double var25 = (this.c[var12] / 10.0D + 1.0D) / 2.0D;
               if (var25 < 0.0D) {
                  var19 = var21;
               } else if (var25 > 1.0D) {
                  var19 = var23;
               } else {
                  var19 = var21 + (var23 - var21) * var25;
               }

               var19 -= 8.0D;
               var19 += (double)var17;
               byte var27 = 2;
               double var28;
               if (var18 > var6 / 2 - var27) {
                  var28 = (double)((float)(var18 - (var6 / 2 - var27)) / 64.0F);
                  var28 = ns.a(var28, 0.0D, 1.0D);
                  var19 = var19 * (1.0D - var28) + -3000.0D * var28;
               }

               var27 = 8;
               if (var18 < var27) {
                  var28 = (double)((float)(var27 - var18) / ((float)var27 - 1.0F));
                  var19 = var19 * (1.0D - var28) + -30.0D * var28;
               }

               var1[var12] = var19;
               ++var12;
            }
         }
      }

      return var1;
   }

   public boolean a(amv var1, amy var2, int var3, int var4) {
      return false;
   }

   public void a(ans var1) {
      for(int var2 = 0; var2 < 16; ++var2) {
         for(int var3 = 0; var3 < 16; ++var3) {
            byte var4 = 1;
            int var5 = -1;
            alz var6 = afi.bH.Q();
            alz var7 = afi.bH.Q();

            for(int var8 = 127; var8 >= 0; --var8) {
               alz var9 = var1.a(var2, var8, var3);
               if (var9.c().t() == arm.a) {
                  var5 = -1;
               } else if (var9.c() == afi.b) {
                  if (var5 == -1) {
                     if (var4 <= 0) {
                        var6 = afi.a.Q();
                        var7 = afi.bH.Q();
                     }

                     var5 = var4;
                     if (var8 >= 0) {
                        var1.a(var2, var8, var3, var6);
                     } else {
                        var1.a(var2, var8, var3, var7);
                     }
                  } else if (var5 > 0) {
                     --var5;
                     var1.a(var2, var8, var3, var7);
                  }
               }
            }
         }
      }

   }

   public void a(amy var1, int var2, int var3) {
   }

   public String f() {
      return "RandomLevelSource";
   }

   public boolean a(boolean var1, nu var2) {
      return true;
   }

   public amy a(cj var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }

   public aob(adm var1, long var2) {
      this.l = var1;
      this.h = new Random(var2);
      this.i = new arc(this.h, 16);
      this.j = new arc(this.h, 16);
      this.k = new arc(this.h, 8);
      this.a = new arc(this.h, 10);
      this.b = new arc(this.h, 16);
   }

   public List<ady.c> a(pt var1, cj var2) {
      return this.l.b(var2).a(var1);
   }

   public amy d(int var1, int var2) {
      this.h.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      ans var3 = new ans();
      this.n = this.l.v().b(this.n, var1 * 16, var2 * 16, 16, 16);
      this.a(var1, var2, var3);
      this.a(var3);
      amy var4 = new amy(this.l, var3, var1, var2);
      byte[] var5 = var4.k();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.n[var6].az;
      }

      var4.b();
      return var4;
   }

   public int g() {
      return 0;
   }

   public void c() {
   }

   public void a(int var1, int var2, ans var3) {
      byte var4 = 2;
      int var5 = var4 + 1;
      byte var6 = 33;
      int var7 = var4 + 1;
      this.m = this.a(this.m, var1 * var4, 0, var2 * var4, var5, var6, var7);

      for(int var8 = 0; var8 < var4; ++var8) {
         for(int var9 = 0; var9 < var4; ++var9) {
            for(int var10 = 0; var10 < 32; ++var10) {
               double var11 = 0.25D;
               double var13 = this.m[(var8 * var7 + var9) * var6 + var10];
               double var15 = this.m[(var8 * var7 + var9 + 1) * var6 + var10];
               double var17 = this.m[((var8 + 1) * var7 + var9) * var6 + var10];
               double var19 = this.m[((var8 + 1) * var7 + var9 + 1) * var6 + var10];
               double var21 = (this.m[(var8 * var7 + var9) * var6 + var10 + 1] - var13) * var11;
               double var23 = (this.m[(var8 * var7 + var9 + 1) * var6 + var10 + 1] - var15) * var11;
               double var25 = (this.m[((var8 + 1) * var7 + var9) * var6 + var10 + 1] - var17) * var11;
               double var27 = (this.m[((var8 + 1) * var7 + var9 + 1) * var6 + var10 + 1] - var19) * var11;

               for(int var29 = 0; var29 < 4; ++var29) {
                  double var30 = 0.125D;
                  double var32 = var13;
                  double var34 = var15;
                  double var36 = (var17 - var13) * var30;
                  double var38 = (var19 - var15) * var30;

                  for(int var40 = 0; var40 < 8; ++var40) {
                     double var41 = 0.125D;
                     double var43 = var32;
                     double var45 = (var34 - var32) * var41;

                     for(int var47 = 0; var47 < 8; ++var47) {
                        alz var48 = null;
                        if (var43 > 0.0D) {
                           var48 = afi.bH.Q();
                        }

                        int var49 = var40 + var8 * 8;
                        int var50 = var29 + var10 * 4;
                        int var51 = var47 + var9 * 8;
                        var3.a(var49, var50, var51, var48);
                        var43 += var45;
                     }

                     var32 += var36;
                     var34 += var38;
                  }

                  var13 += var21;
                  var15 += var23;
                  var17 += var25;
                  var19 += var27;
               }
            }
         }
      }

   }

   public boolean a(int var1, int var2) {
      return true;
   }
}
