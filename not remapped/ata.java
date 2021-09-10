public class ata extends asw {
   private boolean g;
   private boolean h;
   private boolean i;
   private boolean f;
   private boolean j;

   public void b(boolean var1) {
      this.g = var1;
   }

   private asv a(pk var1, int var2, int var3, int var4, int var5) {
      asv var6 = null;
      int var7 = this.a(var1, var2, var3, var4);
      if (var7 == 2) {
         return this.a(var2, var3, var4);
      } else {
         if (var7 == 1) {
            var6 = this.a(var2, var3, var4);
         }

         if (var6 == null && var5 > 0 && var7 != -3 && var7 != -4 && this.a(var1, var2, var3 + var5, var4) == 1) {
            var6 = this.a(var2, var3 + var5, var4);
            var3 += var5;
         }

         if (var6 != null) {
            int var8 = 0;

            int var9;
            for(var9 = 0; var3 > 0; var6 = this.a(var2, var3, var4)) {
               var9 = this.a(var1, var2, var3 - 1, var4);
               if (this.h && var9 == -1) {
                  return null;
               }

               if (var9 != 1) {
                  break;
               }

               if (var8++ >= var1.aE()) {
                  return null;
               }

               --var3;
               if (var3 <= 0) {
                  return null;
               }
            }

            if (var9 == -2) {
               return null;
            }
         }

         return var6;
      }
   }

   public static int a(adq var0, pk var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, boolean var9, boolean var10) {
      boolean var11 = false;
      cj var12 = new cj(var1);
      cj.a var13 = new cj.a();

      for(int var14 = var2; var14 < var2 + var5; ++var14) {
         for(int var15 = var3; var15 < var3 + var6; ++var15) {
            for(int var16 = var4; var16 < var4 + var7; ++var16) {
               var13.c(var14, var15, var16);
               afh var17 = var0.p(var13).c();
               if (var17.t() != arm.a) {
                  if (var17 != afi.bd && var17 != afi.cw) {
                     if (var17 != afi.i && var17 != afi.j) {
                        if (!var10 && var17 instanceof agh && var17.t() == arm.d) {
                           return 0;
                        }
                     } else {
                        if (var8) {
                           return -1;
                        }

                        var11 = true;
                     }
                  } else {
                     var11 = true;
                  }

                  if (var1.o.p(var13).c() instanceof afe) {
                     if (!(var1.o.p(var12).c() instanceof afe) && !(var1.o.p(var12.b()).c() instanceof afe)) {
                        return -3;
                     }
                  } else if (!var17.b((adq)var0, var13) && (!var9 || !(var17 instanceof agh) || var17.t() != arm.d)) {
                     if (!(var17 instanceof agt) && !(var17 instanceof agu) && !(var17 instanceof akl)) {
                        if (var17 != afi.bd && var17 != afi.cw) {
                           arm var18 = var17.t();
                           if (var18 != arm.i) {
                              return 0;
                           }

                           if (!var1.ab()) {
                              return -2;
                           }
                           continue;
                        }

                        return -4;
                     }

                     return -3;
                  }
               }
            }
         }
      }

      return var11 ? 2 : 1;
   }

   public boolean e() {
      return this.h;
   }

   public void c(boolean var1) {
      this.h = var1;
   }

   public asv a(pk var1, double var2, double var4, double var6) {
      return this.a(ns.c(var2 - (double)(var1.J / 2.0F)), ns.c(var4), ns.c(var6 - (double)(var1.J / 2.0F)));
   }

   public void d(boolean var1) {
      this.i = var1;
   }

   public boolean d() {
      return this.i;
   }

   public int a(asv[] var1, pk var2, asv var3, asv var4, float var5) {
      int var6 = 0;
      byte var7 = 0;
      if (this.a(var2, var3.a, var3.b + 1, var3.c) == 1) {
         var7 = 1;
      }

      asv var8 = this.a(var2, var3.a, var3.b, var3.c + 1, var7);
      asv var9 = this.a(var2, var3.a - 1, var3.b, var3.c, var7);
      asv var10 = this.a(var2, var3.a + 1, var3.b, var3.c, var7);
      asv var11 = this.a(var2, var3.a, var3.b, var3.c - 1, var7);
      if (var8 != null && !var8.i && var8.a(var4) < var5) {
         var1[var6++] = var8;
      }

      if (var9 != null && !var9.i && var9.a(var4) < var5) {
         var1[var6++] = var9;
      }

      if (var10 != null && !var10.i && var10.a(var4) < var5) {
         var1[var6++] = var10;
      }

      if (var11 != null && !var11.i && var11.a(var4) < var5) {
         var1[var6++] = var11;
      }

      return var6;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public boolean b() {
      return this.f;
   }

   private int a(pk var1, int var2, int var3, int var4) {
      return a(this.a, var1, var2, var3, var4, this.c, this.d, this.e, this.h, this.g, this.f);
   }

   public asv a(pk var1) {
      int var2;
      if (this.i && var1.V()) {
         var2 = (int)var1.aR().b;
         cj.a var3 = new cj.a(ns.c(var1.s), var2, ns.c(var1.u));

         for(afh var4 = this.a.p(var3).c(); var4 == afi.i || var4 == afi.j; var4 = this.a.p(var3).c()) {
            ++var2;
            var3.c(ns.c(var1.s), var2, ns.c(var1.u));
         }

         this.h = false;
      } else {
         var2 = ns.c(var1.aR().b + 0.5D);
      }

      return this.a(ns.c(var1.aR().a), var2, ns.c(var1.aR().c));
   }

   public void a() {
      super.a();
      this.h = this.j;
   }

   public void a(adq var1, pk var2) {
      super.a(var1, var2);
      this.j = this.h;
   }
}
