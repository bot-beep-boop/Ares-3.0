import java.util.Random;

public class aoz extends aot {
   private afh a;

   public aoz() {
      super(false);
   }

   public boolean b(adm var1, Random var2, cj var3) {
      if (this.a == null) {
         this.a = var2.nextBoolean() ? afi.bg : afi.bh;
      }

      int var4 = var2.nextInt(3) + 4;
      boolean var5 = true;
      if (var3.o() >= 1 && var3.o() + var4 + 1 < 256) {
         int var9;
         int var10;
         for(int var6 = var3.o(); var6 <= var3.o() + 1 + var4; ++var6) {
            byte var7 = 3;
            if (var6 <= var3.o() + 3) {
               var7 = 0;
            }

            cj.a var8 = new cj.a();

            for(var9 = var3.n() - var7; var9 <= var3.n() + var7 && var5; ++var9) {
               for(var10 = var3.p() - var7; var10 <= var3.p() + var7 && var5; ++var10) {
                  if (var6 >= 0 && var6 < 256) {
                     afh var11 = var1.p(var8.c(var9, var6, var10)).c();
                     if (var11.t() != arm.a && var11.t() != arm.j) {
                        var5 = false;
                     }
                  } else {
                     var5 = false;
                  }
               }
            }
         }

         if (!var5) {
            return false;
         } else {
            afh var19 = var1.p(var3.b()).c();
            if (var19 != afi.d && var19 != afi.c && var19 != afi.bw) {
               return false;
            } else {
               int var20 = var3.o() + var4;
               if (this.a == afi.bh) {
                  var20 = var3.o() + var4 - 3;
               }

               int var21;
               for(var21 = var20; var21 <= var3.o() + var4; ++var21) {
                  var9 = 1;
                  if (var21 < var3.o() + var4) {
                     ++var9;
                  }

                  if (this.a == afi.bg) {
                     var9 = 3;
                  }

                  var10 = var3.n() - var9;
                  int var23 = var3.n() + var9;
                  int var12 = var3.p() - var9;
                  int var13 = var3.p() + var9;

                  for(int var14 = var10; var14 <= var23; ++var14) {
                     for(int var15 = var12; var15 <= var13; ++var15) {
                        int var16 = 5;
                        if (var14 == var10) {
                           --var16;
                        } else if (var14 == var23) {
                           ++var16;
                        }

                        if (var15 == var12) {
                           var16 -= 3;
                        } else if (var15 == var13) {
                           var16 += 3;
                        }

                        aho.a var17 = aho.a.a(var16);
                        if (this.a == afi.bg || var21 < var3.o() + var4) {
                           if ((var14 == var10 || var14 == var23) && (var15 == var12 || var15 == var13)) {
                              continue;
                           }

                           if (var14 == var3.n() - (var9 - 1) && var15 == var12) {
                              var17 = aho.a.a;
                           }

                           if (var14 == var10 && var15 == var3.p() - (var9 - 1)) {
                              var17 = aho.a.a;
                           }

                           if (var14 == var3.n() + (var9 - 1) && var15 == var12) {
                              var17 = aho.a.c;
                           }

                           if (var14 == var23 && var15 == var3.p() - (var9 - 1)) {
                              var17 = aho.a.c;
                           }

                           if (var14 == var3.n() - (var9 - 1) && var15 == var13) {
                              var17 = aho.a.g;
                           }

                           if (var14 == var10 && var15 == var3.p() + (var9 - 1)) {
                              var17 = aho.a.g;
                           }

                           if (var14 == var3.n() + (var9 - 1) && var15 == var13) {
                              var17 = aho.a.i;
                           }

                           if (var14 == var23 && var15 == var3.p() + (var9 - 1)) {
                              var17 = aho.a.i;
                           }
                        }

                        if (var17 == aho.a.e && var21 < var3.o() + var4) {
                           var17 = aho.a.k;
                        }

                        if (var3.o() >= var3.o() + var4 - 1 || var17 != aho.a.k) {
                           cj var18 = new cj(var14, var21, var15);
                           if (!var1.p(var18).c().o()) {
                              this.a(var1, var18, this.a.Q().a(aho.a, var17));
                           }
                        }
                     }
                  }
               }

               for(var21 = 0; var21 < var4; ++var21) {
                  afh var22 = var1.p(var3.b(var21)).c();
                  if (!var22.o()) {
                     this.a(var1, var3.b(var21), this.a.Q().a(aho.a, aho.a.j));
                  }
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }

   public aoz(afh var1) {
      super(true);
      this.a = var1;
   }
}
