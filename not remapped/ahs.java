import java.util.Random;

public abstract class ahs extends akg {
   public static final amk b = amk.a("check_decay");
   protected int O;
   int[] N;
   protected boolean P;
   public static final amk a = amk.a("decayable");

   protected void a(adm var1, cj var2, alz var3, int var4) {
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      if (var1.C(var2.a()) && !adm.a((adq)var1, (cj)var2.b()) && var4.nextInt(15) == 1) {
         double var5 = (double)((float)var2.n() + var4.nextFloat());
         double var7 = (double)var2.o() - 0.05D;
         double var9 = (double)((float)var2.p() + var4.nextFloat());
         var1.a(cy.s, var5, var7, var9, 0.0D, 0.0D, 0.0D);
      }

   }

   protected int d(alz var1) {
      return 20;
   }

   public adf m() {
      return this.P ? adf.b : adf.a;
   }

   public int H() {
      return adj.a(0.5D, 1.0D);
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (!var1.D) {
         if ((Boolean)var3.b(b) && (Boolean)var3.b(a)) {
            byte var5 = 4;
            int var6 = var5 + 1;
            int var7 = var2.n();
            int var8 = var2.o();
            int var9 = var2.p();
            byte var10 = 32;
            int var11 = var10 * var10;
            int var12 = var10 / 2;
            if (this.N == null) {
               this.N = new int[var10 * var10 * var10];
            }

            if (var1.a(new cj(var7 - var6, var8 - var6, var9 - var6), new cj(var7 + var6, var8 + var6, var9 + var6))) {
               cj.a var13 = new cj.a();
               int var14 = -var5;

               label149:
               while(true) {
                  int var15;
                  int var16;
                  if (var14 > var5) {
                     var14 = 1;

                     while(true) {
                        if (var14 > 4) {
                           break label149;
                        }

                        for(var15 = -var5; var15 <= var5; ++var15) {
                           for(var16 = -var5; var16 <= var5; ++var16) {
                              for(int var19 = -var5; var19 <= var5; ++var19) {
                                 if (this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + var19 + var12] == var14 - 1) {
                                    if (this.N[(var15 + var12 - 1) * var11 + (var16 + var12) * var10 + var19 + var12] == -2) {
                                       this.N[(var15 + var12 - 1) * var11 + (var16 + var12) * var10 + var19 + var12] = var14;
                                    }

                                    if (this.N[(var15 + var12 + 1) * var11 + (var16 + var12) * var10 + var19 + var12] == -2) {
                                       this.N[(var15 + var12 + 1) * var11 + (var16 + var12) * var10 + var19 + var12] = var14;
                                    }

                                    if (this.N[(var15 + var12) * var11 + (var16 + var12 - 1) * var10 + var19 + var12] == -2) {
                                       this.N[(var15 + var12) * var11 + (var16 + var12 - 1) * var10 + var19 + var12] = var14;
                                    }

                                    if (this.N[(var15 + var12) * var11 + (var16 + var12 + 1) * var10 + var19 + var12] == -2) {
                                       this.N[(var15 + var12) * var11 + (var16 + var12 + 1) * var10 + var19 + var12] = var14;
                                    }

                                    if (this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + (var19 + var12 - 1)] == -2) {
                                       this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + (var19 + var12 - 1)] = var14;
                                    }

                                    if (this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + var19 + var12 + 1] == -2) {
                                       this.N[(var15 + var12) * var11 + (var16 + var12) * var10 + var19 + var12 + 1] = var14;
                                    }
                                 }
                              }
                           }
                        }

                        ++var14;
                     }
                  }

                  for(var15 = -var5; var15 <= var5; ++var15) {
                     for(var16 = -var5; var16 <= var5; ++var16) {
                        afh var17 = var1.p(var13.c(var7 + var14, var8 + var15, var9 + var16)).c();
                        if (var17 != afi.r && var17 != afi.s) {
                           if (var17.t() == arm.j) {
                              this.N[(var14 + var12) * var11 + (var15 + var12) * var10 + var16 + var12] = -2;
                           } else {
                              this.N[(var14 + var12) * var11 + (var15 + var12) * var10 + var16 + var12] = -1;
                           }
                        } else {
                           this.N[(var14 + var12) * var11 + (var15 + var12) * var10 + var16 + var12] = 0;
                        }
                     }
                  }

                  ++var14;
               }
            }

            int var18 = this.N[var12 * var11 + var12 * var10 + var12];
            if (var18 >= 0) {
               var1.a((cj)var2, (alz)var3.a(b, false), 4);
            } else {
               this.e(var1, var2);
            }
         }

      }
   }

   public int a(adq var1, cj var2, int var3) {
      return aea.b(var1, var2);
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      if (!var1.D) {
         int var6 = this.d(var3);
         if (var5 > 0) {
            var6 -= 2 << var5;
            if (var6 < 10) {
               var6 = 10;
            }
         }

         if (var1.s.nextInt(var6) == 0) {
            zw var7 = this.a(var3, var1.s, var5);
            a(var1, var2, new zx(var7, 1, this.a(var3)));
         }

         var6 = 200;
         if (var5 > 0) {
            var6 -= 10 << var5;
            if (var6 < 40) {
               var6 = 40;
            }
         }

         this.a(var1, var2, var3, var6);
      }

   }

   public ahs() {
      super(arm.j, false);
      this.a(true);
      this.a(yz.c);
      this.c(0.2F);
      this.e(1);
      this.a(h);
   }

   public boolean w() {
      return false;
   }

   public void b(adm var1, cj var2, alz var3) {
      byte var4 = 1;
      int var5 = var4 + 1;
      int var6 = var2.n();
      int var7 = var2.o();
      int var8 = var2.p();
      if (var1.a(new cj(var6 - var5, var7 - var5, var8 - var5), new cj(var6 + var5, var7 + var5, var8 + var5))) {
         for(int var9 = -var4; var9 <= var4; ++var9) {
            for(int var10 = -var4; var10 <= var4; ++var10) {
               for(int var11 = -var4; var11 <= var4; ++var11) {
                  cj var12 = var2.a(var9, var10, var11);
                  alz var13 = var1.p(var12);
                  if (var13.c().t() == arm.j && !(Boolean)var13.b(b)) {
                     var1.a((cj)var12, (alz)var13.a(b, true), 4);
                  }
               }
            }
         }
      }

   }

   private void e(adm var1, cj var2) {
      this.b(var1, var2, var1.p(var2), 0);
      var1.g(var2);
   }

   public int h(alz var1) {
      return adj.c();
   }

   public abstract aio.a b(int var1);

   public zw a(alz var1, Random var2, int var3) {
      return zw.a(afi.g);
   }

   public boolean c() {
      return !this.R;
   }

   public int a(Random var1) {
      return var1.nextInt(20) == 0 ? 1 : 0;
   }

   public void b(boolean var1) {
      this.P = var1;
      this.R = var1;
      this.O = var1 ? 0 : 1;
   }
}
