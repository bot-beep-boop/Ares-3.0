import java.util.Arrays;
import java.util.Random;

public class aek extends ady {
   private ard aF;
   private boolean aJ;
   private long aE;
   private ard aG;
   private ard aH;
   private alz[] aD;
   private boolean aI;

   public int b(cj var1) {
      return 9470285;
   }

   private alz a(int var1, int var2, int var3) {
      int var4 = (int)Math.round(this.aH.a((double)var1 * 1.0D / 512.0D, (double)var1 * 1.0D / 512.0D) * 2.0D);
      return this.aD[(var2 + var4 + 64) % 64];
   }

   public int c(cj var1) {
      return 10387789;
   }

   public aek(int var1, boolean var2, boolean var3) {
      super(var1);
      this.aI = var2;
      this.aJ = var3;
      this.b();
      this.a(2.0F, 0.0F);
      this.au.clear();
      this.ak = afi.m.Q().a(ajh.a, ajh.a.b);
      this.al = afi.cu.Q();
      this.as.A = -999;
      this.as.D = 20;
      this.as.F = 3;
      this.as.G = 5;
      this.as.B = 0;
      this.au.clear();
      if (var3) {
         this.as.A = 5;
      }

   }

   public aoh a(Random var1) {
      return this.aA;
   }

   public void a(adm var1, Random var2, ans var3, int var4, int var5, double var6) {
      if (this.aD == null || this.aE != var1.J()) {
         this.a(var1.J());
      }

      if (this.aF == null || this.aG == null || this.aE != var1.J()) {
         Random var8 = new Random(this.aE);
         this.aF = new ard(var8, 4);
         this.aG = new ard(var8, 1);
      }

      this.aE = var1.J();
      double var22 = 0.0D;
      int var10;
      int var11;
      if (this.aI) {
         var10 = (var4 & -16) + (var5 & 15);
         var11 = (var5 & -16) + (var4 & 15);
         double var12 = Math.min(Math.abs(var6), this.aF.a((double)var10 * 0.25D, (double)var11 * 0.25D));
         if (var12 > 0.0D) {
            double var14 = 0.001953125D;
            double var16 = Math.abs(this.aG.a((double)var10 * var14, (double)var11 * var14));
            var22 = var12 * var12 * 2.5D;
            double var18 = Math.ceil(var16 * 50.0D) + 14.0D;
            if (var22 > var18) {
               var22 = var18;
            }

            var22 += 64.0D;
         }
      }

      var10 = var4 & 15;
      var11 = var5 & 15;
      int var23 = var1.F();
      alz var13 = afi.cu.Q();
      alz var24 = this.al;
      int var15 = (int)(var6 / 3.0D + 3.0D + var2.nextDouble() * 0.25D);
      boolean var25 = Math.cos(var6 / 3.0D * 3.141592653589793D) > 0.0D;
      int var17 = -1;
      boolean var26 = false;

      for(int var19 = 255; var19 >= 0; --var19) {
         if (var3.a(var11, var19, var10).c().t() == arm.a && var19 < (int)var22) {
            var3.a(var11, var19, var10, afi.b.Q());
         }

         if (var19 <= var2.nextInt(5)) {
            var3.a(var11, var19, var10, afi.h.Q());
         } else {
            alz var20 = var3.a(var11, var19, var10);
            if (var20.c().t() == arm.a) {
               var17 = -1;
            } else if (var20.c() == afi.b) {
               alz var21;
               if (var17 == -1) {
                  var26 = false;
                  if (var15 <= 0) {
                     var13 = null;
                     var24 = afi.b.Q();
                  } else if (var19 >= var23 - 4 && var19 <= var23 + 1) {
                     var13 = afi.cu.Q();
                     var24 = this.al;
                  }

                  if (var19 < var23 && (var13 == null || var13.c().t() == arm.a)) {
                     var13 = afi.j.Q();
                  }

                  var17 = var15 + Math.max(0, var19 - var23);
                  if (var19 < var23 - 1) {
                     var3.a(var11, var19, var10, var24);
                     if (var24.c() == afi.cu) {
                        var3.a(var11, var19, var10, var24.c().Q().a(afv.a, zd.b));
                     }
                  } else if (this.aJ && var19 > 86 + var15 * 2) {
                     if (var25) {
                        var3.a(var11, var19, var10, afi.d.Q().a(agf.a, agf.a.b));
                     } else {
                        var3.a(var11, var19, var10, afi.c.Q());
                     }
                  } else if (var19 <= var23 + 3 + var15) {
                     var3.a(var11, var19, var10, this.ak);
                     var26 = true;
                  } else {
                     if (var19 >= 64 && var19 <= 127) {
                        if (var25) {
                           var21 = afi.cz.Q();
                        } else {
                           var21 = this.a(var4, var19, var5);
                        }
                     } else {
                        var21 = afi.cu.Q().a(afv.a, zd.b);
                     }

                     var3.a(var11, var19, var10, var21);
                  }
               } else if (var17 > 0) {
                  --var17;
                  if (var26) {
                     var3.a(var11, var19, var10, afi.cu.Q().a(afv.a, zd.b));
                  } else {
                     var21 = this.a(var4, var19, var5);
                     var3.a(var11, var19, var10, var21);
                  }
               }
            }
         }
      }

   }

   public void a(adm var1, Random var2, cj var3) {
      super.a(var1, var2, var3);
   }

   private void a(long var1) {
      this.aD = new alz[64];
      Arrays.fill(this.aD, afi.cz.Q());
      Random var3 = new Random(var1);
      this.aH = new ard(var3, 1);

      int var4;
      for(var4 = 0; var4 < 64; ++var4) {
         var4 += var3.nextInt(5) + 1;
         if (var4 < 64) {
            this.aD[var4] = afi.cu.Q().a(afv.a, zd.b);
         }
      }

      var4 = var3.nextInt(4) + 2;

      int var5;
      int var6;
      int var7;
      int var8;
      for(var5 = 0; var5 < var4; ++var5) {
         var6 = var3.nextInt(3) + 1;
         var7 = var3.nextInt(64);

         for(var8 = 0; var7 + var8 < 64 && var8 < var6; ++var8) {
            this.aD[var7 + var8] = afi.cu.Q().a(afv.a, zd.e);
         }
      }

      var5 = var3.nextInt(4) + 2;

      int var9;
      for(var6 = 0; var6 < var5; ++var6) {
         var7 = var3.nextInt(3) + 2;
         var8 = var3.nextInt(64);

         for(var9 = 0; var8 + var9 < 64 && var9 < var7; ++var9) {
            this.aD[var8 + var9] = afi.cu.Q().a(afv.a, zd.m);
         }
      }

      var6 = var3.nextInt(4) + 2;

      for(var7 = 0; var7 < var6; ++var7) {
         var8 = var3.nextInt(3) + 1;
         var9 = var3.nextInt(64);

         for(int var10 = 0; var9 + var10 < 64 && var10 < var8; ++var10) {
            this.aD[var9 + var10] = afi.cu.Q().a(afv.a, zd.o);
         }
      }

      var7 = var3.nextInt(3) + 3;
      var8 = 0;

      for(var9 = 0; var9 < var7; ++var9) {
         byte var12 = 1;
         var8 += var3.nextInt(16) + 4;

         for(int var11 = 0; var8 + var11 < 64 && var11 < var12; ++var11) {
            this.aD[var8 + var11] = afi.cu.Q().a(afv.a, zd.a);
            if (var8 + var11 > 1 && var3.nextBoolean()) {
               this.aD[var8 + var11 - 1] = afi.cu.Q().a(afv.a, zd.i);
            }

            if (var8 + var11 < 63 && var3.nextBoolean()) {
               this.aD[var8 + var11 + 1] = afi.cu.Q().a(afv.a, zd.i);
            }
         }
      }

   }

   protected ady d(int var1) {
      boolean var2 = this.az == ady.aa.az;
      aek var3 = new aek(var1, var2, this.aJ);
      if (!var2) {
         var3.a(g);
         var3.a(this.ah + " M");
      } else {
         var3.a(this.ah + " (Bryce)");
      }

      var3.a(this.ai, true);
      return var3;
   }
}
