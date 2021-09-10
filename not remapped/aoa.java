import java.util.List;
import java.util.Random;

public class aoa implements amv {
   private aqo v;
   private any u;
   double[] d;
   private ant r;
   private arc k;
   private Random h;
   private final boolean n;
   private aqv w;
   private ard l;
   public arc a;
   private arc j;
   private aqf x;
   private aqm y;
   private any z;
   private final float[] q;
   double[] f;
   double[] g;
   public arc c;
   public arc b;
   private final double[] p;
   private afh s;
   private aqk A;
   private arc i;
   private ady[] B;
   private double[] t;
   private adr o;
   double[] e;
   private adm m;

   public void a(int var1, int var2, ans var3) {
      this.B = this.m.v().a((ady[])this.B, var1 * 4 - 2, var2 * 4 - 2, 10, 10);
      this.a(var1 * 4, 0, var2 * 4);

      for(int var4 = 0; var4 < 4; ++var4) {
         int var5 = var4 * 5;
         int var6 = (var4 + 1) * 5;

         for(int var7 = 0; var7 < 4; ++var7) {
            int var8 = (var5 + var7) * 33;
            int var9 = (var5 + var7 + 1) * 33;
            int var10 = (var6 + var7) * 33;
            int var11 = (var6 + var7 + 1) * 33;

            for(int var12 = 0; var12 < 32; ++var12) {
               double var13 = 0.125D;
               double var15 = this.p[var8 + var12];
               double var17 = this.p[var9 + var12];
               double var19 = this.p[var10 + var12];
               double var21 = this.p[var11 + var12];
               double var23 = (this.p[var8 + var12 + 1] - var15) * var13;
               double var25 = (this.p[var9 + var12 + 1] - var17) * var13;
               double var27 = (this.p[var10 + var12 + 1] - var19) * var13;
               double var29 = (this.p[var11 + var12 + 1] - var21) * var13;

               for(int var31 = 0; var31 < 8; ++var31) {
                  double var32 = 0.25D;
                  double var34 = var15;
                  double var36 = var17;
                  double var38 = (var19 - var15) * var32;
                  double var40 = (var21 - var17) * var32;

                  for(int var42 = 0; var42 < 4; ++var42) {
                     double var43 = 0.25D;
                     double var47 = (var36 - var34) * var43;
                     double var45 = var34 - var47;

                     for(int var49 = 0; var49 < 4; ++var49) {
                        if ((var45 += var47) > 0.0D) {
                           var3.a(var4 * 4 + var42, var12 * 8 + var31, var7 * 4 + var49, afi.b.Q());
                        } else if (var12 * 8 + var31 < this.r.q) {
                           var3.a(var4 * 4 + var42, var12 * 8 + var31, var7 * 4 + var49, this.s.Q());
                        }
                     }

                     var34 += var38;
                     var36 += var40;
                  }

                  var15 += var23;
                  var17 += var25;
                  var19 += var27;
                  var21 += var29;
               }
            }
         }
      }

   }

   public aoa(adm var1, long var2, boolean var4, String var5) {
      this.s = afi.j;
      this.t = new double[256];
      this.u = new anx();
      this.v = new aqo();
      this.w = new aqv();
      this.x = new aqf();
      this.y = new aqm();
      this.z = new anr();
      this.A = new aqk();
      this.m = var1;
      this.n = var4;
      this.o = var1.P().u();
      this.h = new Random(var2);
      this.i = new arc(this.h, 16);
      this.j = new arc(this.h, 16);
      this.k = new arc(this.h, 8);
      this.l = new ard(this.h, 4);
      this.a = new arc(this.h, 10);
      this.b = new arc(this.h, 16);
      this.c = new arc(this.h, 8);
      this.p = new double[825];
      this.q = new float[25];

      for(int var6 = -2; var6 <= 2; ++var6) {
         for(int var7 = -2; var7 <= 2; ++var7) {
            float var8 = 10.0F / ns.c((float)(var6 * var6 + var7 * var7) + 0.2F);
            this.q[var6 + 2 + (var7 + 2) * 5] = var8;
         }
      }

      if (var5 != null) {
         this.r = ant.a.a(var5).b();
         this.s = this.r.E ? afi.l : afi.j;
         var1.b(this.r.q);
      }

   }

   public void a(amv var1, int var2, int var3) {
      agr.N = true;
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      cj var6 = new cj(var4, 0, var5);
      ady var7 = this.m.b(var6.a(16, 0, 16));
      this.h.setSeed(this.m.J());
      long var8 = this.h.nextLong() / 2L * 2L + 1L;
      long var10 = this.h.nextLong() / 2L * 2L + 1L;
      this.h.setSeed((long)var2 * var8 + (long)var3 * var10 ^ this.m.J());
      boolean var12 = false;
      adg var13 = new adg(var2, var3);
      if (this.r.w && this.n) {
         this.x.a(this.m, this.h, var13);
      }

      if (this.r.v && this.n) {
         var12 = this.w.a(this.m, this.h, var13);
      }

      if (this.r.u && this.n) {
         this.v.a(this.m, this.h, var13);
      }

      if (this.r.x && this.n) {
         this.y.a(this.m, this.h, var13);
      }

      if (this.r.y && this.n) {
         this.A.a(this.m, this.h, var13);
      }

      int var14;
      int var15;
      int var16;
      if (var7 != ady.r && var7 != ady.G && this.r.A && !var12 && this.h.nextInt(this.r.B) == 0) {
         var14 = this.h.nextInt(16) + 8;
         var15 = this.h.nextInt(256);
         var16 = this.h.nextInt(16) + 8;
         (new apc(afi.j)).b(this.m, this.h, var6.a(var14, var15, var16));
      }

      if (!var12 && this.h.nextInt(this.r.D / 10) == 0 && this.r.C) {
         var14 = this.h.nextInt(16) + 8;
         var15 = this.h.nextInt(this.h.nextInt(248) + 8);
         var16 = this.h.nextInt(16) + 8;
         if (var15 < this.m.F() || this.h.nextInt(this.r.D / 8) == 0) {
            (new apc(afi.l)).b(this.m, this.h, var6.a(var14, var15, var16));
         }
      }

      if (this.r.s) {
         for(var14 = 0; var14 < this.r.t; ++var14) {
            var15 = this.h.nextInt(16) + 8;
            var16 = this.h.nextInt(256);
            int var17 = this.h.nextInt(16) + 8;
            (new api()).b(this.m, this.h, var6.a(var15, var16, var17));
         }
      }

      var7.a(this.m, this.h, new cj(var4, 0, var5));
      adt.a(this.m, var7, var4 + 8, var5 + 8, 16, 16, this.h);
      var6 = var6.a(8, 0, 8);

      for(var14 = 0; var14 < 16; ++var14) {
         for(var15 = 0; var15 < 16; ++var15) {
            cj var18 = this.m.q(var6.a(var14, 0, var15));
            cj var19 = var18.b();
            if (this.m.v(var19)) {
               this.m.a((cj)var19, (alz)afi.aI.Q(), 2);
            }

            if (this.m.f(var18, true)) {
               this.m.a((cj)var18, (alz)afi.aH.Q(), 2);
            }
         }
      }

      agr.N = false;
   }

   public boolean a(int var1, int var2) {
      return true;
   }

   public boolean e() {
      return true;
   }

   private void a(int var1, int var2, int var3) {
      this.g = this.b.a(this.g, var1, var3, 5, 5, (double)this.r.e, (double)this.r.f, (double)this.r.g);
      float var4 = this.r.a;
      float var5 = this.r.b;
      this.d = this.k.a(this.d, var1, var2, var3, 5, 33, 5, (double)(var4 / this.r.h), (double)(var5 / this.r.i), (double)(var4 / this.r.j));
      this.e = this.i.a(this.e, var1, var2, var3, 5, 33, 5, (double)var4, (double)var5, (double)var4);
      this.f = this.j.a(this.f, var1, var2, var3, 5, 33, 5, (double)var4, (double)var5, (double)var4);
      boolean var37 = false;
      boolean var36 = false;
      int var6 = 0;
      int var7 = 0;

      for(int var8 = 0; var8 < 5; ++var8) {
         for(int var9 = 0; var9 < 5; ++var9) {
            float var10 = 0.0F;
            float var11 = 0.0F;
            float var12 = 0.0F;
            byte var13 = 2;
            ady var14 = this.B[var8 + 2 + (var9 + 2) * 10];

            for(int var15 = -var13; var15 <= var13; ++var15) {
               for(int var16 = -var13; var16 <= var13; ++var16) {
                  ady var17 = this.B[var8 + var15 + 2 + (var9 + var16 + 2) * 10];
                  float var18 = this.r.n + var17.an * this.r.m;
                  float var19 = this.r.p + var17.ao * this.r.o;
                  if (this.o == adr.e && var18 > 0.0F) {
                     var18 = 1.0F + var18 * 2.0F;
                     var19 = 1.0F + var19 * 4.0F;
                  }

                  float var20 = this.q[var15 + 2 + (var16 + 2) * 5] / (var18 + 2.0F);
                  if (var17.an > var14.an) {
                     var20 /= 2.0F;
                  }

                  var10 += var19 * var20;
                  var11 += var18 * var20;
                  var12 += var20;
               }
            }

            var10 /= var12;
            var11 /= var12;
            var10 = var10 * 0.9F + 0.1F;
            var11 = (var11 * 4.0F - 1.0F) / 8.0F;
            double var38 = this.g[var7] / 8000.0D;
            if (var38 < 0.0D) {
               var38 = -var38 * 0.3D;
            }

            var38 = var38 * 3.0D - 2.0D;
            if (var38 < 0.0D) {
               var38 /= 2.0D;
               if (var38 < -1.0D) {
                  var38 = -1.0D;
               }

               var38 /= 1.4D;
               var38 /= 2.0D;
            } else {
               if (var38 > 1.0D) {
                  var38 = 1.0D;
               }

               var38 /= 8.0D;
            }

            ++var7;
            double var39 = (double)var11;
            double var40 = (double)var10;
            var39 += var38 * 0.2D;
            var39 = var39 * (double)this.r.k / 8.0D;
            double var21 = (double)this.r.k + var39 * 4.0D;

            for(int var23 = 0; var23 < 33; ++var23) {
               double var24 = ((double)var23 - var21) * (double)this.r.l * 128.0D / 256.0D / var40;
               if (var24 < 0.0D) {
                  var24 *= 4.0D;
               }

               double var26 = this.e[var6] / (double)this.r.d;
               double var28 = this.f[var6] / (double)this.r.c;
               double var30 = (this.d[var6] / 10.0D + 1.0D) / 2.0D;
               double var32 = ns.b(var26, var28, var30) - var24;
               if (var23 > 29) {
                  double var34 = (double)((float)(var23 - 29) / 3.0F);
                  var32 = var32 * (1.0D - var34) + -10.0D * var34;
               }

               this.p[var6] = var32;
               ++var6;
            }
         }
      }

   }

   public amy a(cj var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }

   public void a(amy var1, int var2, int var3) {
      if (this.r.w && this.n) {
         this.x.a(this, this.m, var2, var3, (ans)null);
      }

      if (this.r.v && this.n) {
         this.w.a(this, this.m, var2, var3, (ans)null);
      }

      if (this.r.u && this.n) {
         this.v.a(this, this.m, var2, var3, (ans)null);
      }

      if (this.r.x && this.n) {
         this.y.a(this, this.m, var2, var3, (ans)null);
      }

      if (this.r.y && this.n) {
         this.A.a(this, this.m, var2, var3, (ans)null);
      }

   }

   public boolean a(boolean var1, nu var2) {
      return true;
   }

   public cj a(adm var1, String var2, cj var3) {
      return "Stronghold".equals(var2) && this.v != null ? this.v.b(var1, var3) : null;
   }

   public void a(int var1, int var2, ans var3, ady[] var4) {
      double var5 = 0.03125D;
      this.t = this.l.a(this.t, (double)(var1 * 16), (double)(var2 * 16), 16, 16, var5 * 2.0D, var5 * 2.0D, 1.0D);

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            ady var9 = var4[var8 + var7 * 16];
            var9.a(this.m, this.h, var3, var1 * 16 + var7, var2 * 16 + var8, this.t[var8 + var7 * 16]);
         }
      }

   }

   public boolean a(amv var1, amy var2, int var3, int var4) {
      boolean var5 = false;
      if (this.r.y && this.n && var2.w() < 3600L) {
         var5 |= this.A.a(this.m, this.h, new adg(var3, var4));
      }

      return var5;
   }

   public List<ady.c> a(pt var1, cj var2) {
      ady var3 = this.m.b(var2);
      if (this.n) {
         if (var1 == pt.a && this.y.a(var2)) {
            return this.y.b();
         }

         if (var1 == pt.a && this.r.y && this.A.a(this.m, var2)) {
            return this.A.b();
         }
      }

      return var3.a(var1);
   }

   public boolean d() {
      return false;
   }

   public void c() {
   }

   public int g() {
      return 0;
   }

   public amy d(int var1, int var2) {
      this.h.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      ans var3 = new ans();
      this.a(var1, var2, var3);
      this.B = this.m.v().b(this.B, var1 * 16, var2 * 16, 16, 16);
      this.a(var1, var2, var3, this.B);
      if (this.r.r) {
         this.u.a(this, this.m, var1, var2, var3);
      }

      if (this.r.z) {
         this.z.a(this, this.m, var1, var2, var3);
      }

      if (this.r.w && this.n) {
         this.x.a(this, this.m, var1, var2, var3);
      }

      if (this.r.v && this.n) {
         this.w.a(this, this.m, var1, var2, var3);
      }

      if (this.r.u && this.n) {
         this.v.a(this, this.m, var1, var2, var3);
      }

      if (this.r.x && this.n) {
         this.y.a(this, this.m, var1, var2, var3);
      }

      if (this.r.y && this.n) {
         this.A.a(this, this.m, var1, var2, var3);
      }

      amy var4 = new amy(this.m, var3, var1, var2);
      byte[] var5 = var4.k();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.B[var6].az;
      }

      var4.b();
      return var4;
   }

   public String f() {
      return "RandomLevelSource";
   }
}
