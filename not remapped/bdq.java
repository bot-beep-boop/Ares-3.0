public class bdq {
   public static class b extends beb {
      private float aD;
      private boolean az;
      private final bec aB;
      private boolean aA;
      private float aC;
      private int a = 160;
      private boolean aF;
      private float aE;

      public void t_() {
         this.p = this.s;
         this.q = this.t;
         this.r = this.u;
         if (this.f++ >= this.g) {
            this.J();
         }

         if (this.f > this.g / 2) {
            this.i(1.0F - ((float)this.f - (float)(this.g / 2)) / (float)this.g);
            if (this.aF) {
               this.ar += (this.aC - this.ar) * 0.2F;
               this.as += (this.aD - this.as) * 0.2F;
               this.at += (this.aE - this.at) * 0.2F;
            }
         }

         this.k(this.a + (7 - this.f * 8 / this.g));
         this.w -= 0.004D;
         this.d(this.v, this.w, this.x);
         this.v *= 0.9100000262260437D;
         this.w *= 0.9100000262260437D;
         this.x *= 0.9100000262260437D;
         if (this.C) {
            this.v *= 0.699999988079071D;
            this.x *= 0.699999988079071D;
         }

         if (this.az && this.f < this.g / 2 && (this.f + this.g) % 2 == 0) {
            bdq.b var1 = new bdq.b(this.o, this.s, this.t, this.u, 0.0D, 0.0D, 0.0D, this.aB);
            var1.i(0.99F);
            var1.b(this.ar, this.as, this.at);
            var1.f = var1.g / 2;
            if (this.aF) {
               var1.aF = true;
               var1.aC = this.aC;
               var1.aD = this.aD;
               var1.aE = this.aE;
            }

            var1.aA = this.aA;
            this.aB.a((beb)var1);
         }

      }

      public int b(float var1) {
         return 15728880;
      }

      public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
         if (!this.aA || this.f < this.g / 3 || (this.f + this.g) / 3 % 2 == 0) {
            super.a(var1, var2, var3, var4, var5, var6, var7, var8);
         }

      }

      public float c(float var1) {
         return 1.0F;
      }

      public void a(boolean var1) {
         this.az = var1;
      }

      public void b(int var1) {
         this.aC = (float)((var1 & 16711680) >> 16) / 255.0F;
         this.aD = (float)((var1 & '\uff00') >> 8) / 255.0F;
         this.aE = (float)((var1 & 255) >> 0) / 255.0F;
         this.aF = true;
      }

      public void i(boolean var1) {
         this.aA = var1;
      }

      public void a(int var1) {
         float var2 = (float)((var1 & 16711680) >> 16) / 255.0F;
         float var3 = (float)((var1 & '\uff00') >> 8) / 255.0F;
         float var4 = (float)((var1 & 255) >> 0) / 255.0F;
         float var5 = 1.0F;
         this.b(var2 * var5, var3 * var5, var4 * var5);
      }

      public boolean ae() {
         return false;
      }

      public aug S() {
         return null;
      }

      public b(adm var1, double var2, double var4, double var6, double var8, double var10, double var12, bec var14) {
         super(var1, var2, var4, var6);
         this.v = var8;
         this.w = var10;
         this.x = var12;
         this.aB = var14;
         this.h *= 0.75F;
         this.g = 48 + this.V.nextInt(12);
         this.T = false;
      }
   }

   public static class c extends beb {
      private du aB;
      private final bec aA;
      private int az;
      boolean a;

      public c(adm var1, double var2, double var4, double var6, double var8, double var10, double var12, bec var14, dn var15) {
         super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
         this.v = var8;
         this.w = var10;
         this.x = var12;
         this.aA = var14;
         this.g = 8;
         if (var15 != null) {
            this.aB = var15.c("Explosions", 10);
            if (this.aB.c() == 0) {
               this.aB = null;
            } else {
               this.g = this.aB.c() * 2 - 1;

               for(int var16 = 0; var16 < this.aB.c(); ++var16) {
                  dn var17 = this.aB.b(var16);
                  if (var17.n("Flicker")) {
                     this.a = true;
                     this.g += 15;
                     break;
                  }
               }
            }
         }

      }

      public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      }

      private boolean l() {
         ave var1 = ave.A();
         return var1 == null || var1.ac() == null || !(var1.ac().e(this.s, this.t, this.u) < 256.0D);
      }

      private void a(double var1, int var3, int[] var4, int[] var5, boolean var6, boolean var7) {
         double var8 = this.s;
         double var10 = this.t;
         double var12 = this.u;

         for(int var14 = -var3; var14 <= var3; ++var14) {
            for(int var15 = -var3; var15 <= var3; ++var15) {
               for(int var16 = -var3; var16 <= var3; ++var16) {
                  double var17 = (double)var15 + (this.V.nextDouble() - this.V.nextDouble()) * 0.5D;
                  double var19 = (double)var14 + (this.V.nextDouble() - this.V.nextDouble()) * 0.5D;
                  double var21 = (double)var16 + (this.V.nextDouble() - this.V.nextDouble()) * 0.5D;
                  double var23 = (double)ns.a(var17 * var17 + var19 * var19 + var21 * var21) / var1 + this.V.nextGaussian() * 0.05D;
                  this.a(var8, var10, var12, var17 / var23, var19 / var23, var21 / var23, var4, var5, var6, var7);
                  if (var14 != -var3 && var14 != var3 && var15 != -var3 && var15 != var3) {
                     var16 += var3 * 2 - 1;
                  }
               }
            }
         }

      }

      public void t_() {
         boolean var1;
         if (this.az == 0 && this.aB != null) {
            var1 = this.l();
            boolean var2 = false;
            if (this.aB.c() >= 3) {
               var2 = true;
            } else {
               for(int var3 = 0; var3 < this.aB.c(); ++var3) {
                  dn var4 = this.aB.b(var3);
                  if (var4.d("Type") == 1) {
                     var2 = true;
                     break;
                  }
               }
            }

            String var15 = "fireworks." + (var2 ? "largeBlast" : "blast") + (var1 ? "_far" : "");
            this.o.a(this.s, this.t, this.u, var15, 20.0F, 0.95F + this.V.nextFloat() * 0.1F, true);
         }

         if (this.az % 2 == 0 && this.aB != null && this.az / 2 < this.aB.c()) {
            int var13 = this.az / 2;
            dn var14 = this.aB.b(var13);
            byte var17 = var14.d("Type");
            boolean var18 = var14.n("Trail");
            boolean var5 = var14.n("Flicker");
            int[] var6 = var14.l("Colors");
            int[] var7 = var14.l("FadeColors");
            if (var6.length == 0) {
               var6 = new int[]{ze.a[0]};
            }

            if (var17 == 1) {
               this.a(0.5D, 4, var6, var7, var18, var5);
            } else if (var17 == 2) {
               this.a(0.5D, new double[][]{{0.0D, 1.0D}, {0.3455D, 0.309D}, {0.9511D, 0.309D}, {0.3795918367346939D, -0.12653061224489795D}, {0.6122448979591837D, -0.8040816326530612D}, {0.0D, -0.35918367346938773D}}, var6, var7, var18, var5, false);
            } else if (var17 == 3) {
               this.a(0.5D, new double[][]{{0.0D, 0.2D}, {0.2D, 0.2D}, {0.2D, 0.6D}, {0.6D, 0.6D}, {0.6D, 0.2D}, {0.2D, 0.2D}, {0.2D, 0.0D}, {0.4D, 0.0D}, {0.4D, -0.6D}, {0.2D, -0.6D}, {0.2D, -0.4D}, {0.0D, -0.4D}}, var6, var7, var18, var5, true);
            } else if (var17 == 4) {
               this.a(var6, var7, var18, var5);
            } else {
               this.a(0.25D, 2, var6, var7, var18, var5);
            }

            int var8 = var6[0];
            float var9 = (float)((var8 & 16711680) >> 16) / 255.0F;
            float var10 = (float)((var8 & '\uff00') >> 8) / 255.0F;
            float var11 = (float)((var8 & 255) >> 0) / 255.0F;
            bdq.a var12 = new bdq.a(this.o, this.s, this.t, this.u);
            var12.b(var9, var10, var11);
            this.aA.a((beb)var12);
         }

         ++this.az;
         if (this.az > this.g) {
            if (this.a) {
               var1 = this.l();
               String var16 = "fireworks." + (var1 ? "twinkle_far" : "twinkle");
               this.o.a(this.s, this.t, this.u, var16, 20.0F, 0.9F + this.V.nextFloat() * 0.15F, true);
            }

            this.J();
         }

      }

      private void a(double var1, double[][] var3, int[] var4, int[] var5, boolean var6, boolean var7, boolean var8) {
         double var9 = var3[0][0];
         double var11 = var3[0][1];
         this.a(this.s, this.t, this.u, var9 * var1, var11 * var1, 0.0D, var4, var5, var6, var7);
         float var13 = this.V.nextFloat() * 3.1415927F;
         double var14 = var8 ? 0.034D : 0.34D;

         for(int var16 = 0; var16 < 3; ++var16) {
            double var17 = (double)var13 + (double)((float)var16 * 3.1415927F) * var14;
            double var19 = var9;
            double var21 = var11;

            for(int var23 = 1; var23 < var3.length; ++var23) {
               double var24 = var3[var23][0];
               double var26 = var3[var23][1];

               for(double var28 = 0.25D; var28 <= 1.0D; var28 += 0.25D) {
                  double var30 = (var19 + (var24 - var19) * var28) * var1;
                  double var32 = (var21 + (var26 - var21) * var28) * var1;
                  double var34 = var30 * Math.sin(var17);
                  var30 *= Math.cos(var17);

                  for(double var36 = -1.0D; var36 <= 1.0D; var36 += 2.0D) {
                     this.a(this.s, this.t, this.u, var30 * var36, var32, var34 * var36, var4, var5, var6, var7);
                  }
               }

               var19 = var24;
               var21 = var26;
            }
         }

      }

      private void a(double var1, double var3, double var5, double var7, double var9, double var11, int[] var13, int[] var14, boolean var15, boolean var16) {
         bdq.b var17 = new bdq.b(this.o, var1, var3, var5, var7, var9, var11, this.aA);
         var17.i(0.99F);
         var17.a(var15);
         var17.i(var16);
         int var18 = this.V.nextInt(var13.length);
         var17.a(var13[var18]);
         if (var14 != null && var14.length > 0) {
            var17.b(var14[this.V.nextInt(var14.length)]);
         }

         this.aA.a((beb)var17);
      }

      public int a() {
         return 0;
      }

      private void a(int[] var1, int[] var2, boolean var3, boolean var4) {
         double var5 = this.V.nextGaussian() * 0.05D;
         double var7 = this.V.nextGaussian() * 0.05D;

         for(int var9 = 0; var9 < 70; ++var9) {
            double var10 = this.v * 0.5D + this.V.nextGaussian() * 0.15D + var5;
            double var12 = this.x * 0.5D + this.V.nextGaussian() * 0.15D + var7;
            double var14 = this.w * 0.5D + this.V.nextDouble() * 0.5D;
            this.a(this.s, this.t, this.u, var10, var14, var12, var1, var2, var3, var4);
         }

      }
   }

   public static class d implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         bdq.b var16 = new bdq.b(var2, var3, var5, var7, var9, var11, var13, ave.A().j);
         var16.i(0.99F);
         return var16;
      }
   }

   public static class a extends beb {
      public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
         float var9 = 0.25F;
         float var10 = 0.5F;
         float var11 = 0.125F;
         float var12 = 0.375F;
         float var13 = 7.1F * ns.a(((float)this.f + var3 - 1.0F) * 0.25F * 3.1415927F);
         this.au = 0.6F - ((float)this.f + var3 - 1.0F) * 0.25F * 0.5F;
         float var14 = (float)(this.p + (this.s - this.p) * (double)var3 - aw);
         float var15 = (float)(this.q + (this.t - this.q) * (double)var3 - ax);
         float var16 = (float)(this.r + (this.u - this.r) * (double)var3 - ay);
         int var17 = this.b(var3);
         int var18 = var17 >> 16 & '\uffff';
         int var19 = var17 & '\uffff';
         var1.b((double)(var14 - var4 * var13 - var7 * var13), (double)(var15 - var5 * var13), (double)(var16 - var6 * var13 - var8 * var13)).a(0.5D, 0.375D).a(this.ar, this.as, this.at, this.au).a(var18, var19).d();
         var1.b((double)(var14 - var4 * var13 + var7 * var13), (double)(var15 + var5 * var13), (double)(var16 - var6 * var13 + var8 * var13)).a(0.5D, 0.125D).a(this.ar, this.as, this.at, this.au).a(var18, var19).d();
         var1.b((double)(var14 + var4 * var13 + var7 * var13), (double)(var15 + var5 * var13), (double)(var16 + var6 * var13 + var8 * var13)).a(0.25D, 0.125D).a(this.ar, this.as, this.at, this.au).a(var18, var19).d();
         var1.b((double)(var14 + var4 * var13 - var7 * var13), (double)(var15 - var5 * var13), (double)(var16 + var6 * var13 - var8 * var13)).a(0.25D, 0.375D).a(this.ar, this.as, this.at, this.au).a(var18, var19).d();
      }

      protected a(adm var1, double var2, double var4, double var6) {
         super(var1, var2, var4, var6);
         this.g = 4;
      }
   }
}
