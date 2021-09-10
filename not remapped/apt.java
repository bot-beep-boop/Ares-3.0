import java.util.Random;

public class apt extends aoh {
   private static final alz b;
   private static final alz a;

   static {
      a = afi.r.Q().a(ail.b, aio.a.a);
      b = afi.t.Q().a(aik.Q, aio.a.a).a(aik.b, false);
   }

   public apt() {
      super(false);
   }

   private void a(adm var1, cj var2, amk var3) {
      alz var4 = afi.bn.Q().a(var3, true);
      this.a(var1, var2, var4);
      int var5 = 4;

      for(var2 = var2.b(); var1.p(var2).c().t() == arm.a && var5 > 0; --var5) {
         this.a(var1, var2, var4);
         var2 = var2.b();
      }

   }

   public boolean b(adm var1, Random var2, cj var3) {
      int var4;
      for(var4 = var2.nextInt(4) + 5; var1.p(var3.b()).c().t() == arm.h; var3 = var3.b()) {
      }

      boolean var5 = true;
      if (var3.o() >= 1 && var3.o() + var4 + 1 <= 256) {
         int var9;
         int var10;
         for(int var6 = var3.o(); var6 <= var3.o() + 1 + var4; ++var6) {
            byte var7 = 1;
            if (var6 == var3.o()) {
               var7 = 0;
            }

            if (var6 >= var3.o() + 1 + var4 - 2) {
               var7 = 3;
            }

            cj.a var8 = new cj.a();

            for(var9 = var3.n() - var7; var9 <= var3.n() + var7 && var5; ++var9) {
               for(var10 = var3.p() - var7; var10 <= var3.p() + var7 && var5; ++var10) {
                  if (var6 >= 0 && var6 < 256) {
                     afh var11 = var1.p(var8.c(var9, var6, var10)).c();
                     if (var11.t() != arm.a && var11.t() != arm.j) {
                        if (var11 != afi.j && var11 != afi.i) {
                           var5 = false;
                        } else if (var6 > var3.o()) {
                           var5 = false;
                        }
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
            afh var17 = var1.p(var3.b()).c();
            if ((var17 == afi.c || var17 == afi.d) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());

               int var12;
               cj var14;
               int var18;
               int var19;
               int var21;
               for(var18 = var3.o() - 3 + var4; var18 <= var3.o() + var4; ++var18) {
                  var19 = var18 - (var3.o() + var4);
                  var9 = 2 - var19 / 2;

                  for(var10 = var3.n() - var9; var10 <= var3.n() + var9; ++var10) {
                     var21 = var10 - var3.n();

                     for(var12 = var3.p() - var9; var12 <= var3.p() + var9; ++var12) {
                        int var13 = var12 - var3.p();
                        if (Math.abs(var21) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var19 != 0) {
                           var14 = new cj(var10, var18, var12);
                           if (!var1.p(var14).c().o()) {
                              this.a(var1, var14, b);
                           }
                        }
                     }
                  }
               }

               for(var18 = 0; var18 < var4; ++var18) {
                  afh var20 = var1.p(var3.b(var18)).c();
                  if (var20.t() == arm.a || var20.t() == arm.j || var20 == afi.i || var20 == afi.j) {
                     this.a(var1, var3.b(var18), a);
                  }
               }

               for(var18 = var3.o() - 3 + var4; var18 <= var3.o() + var4; ++var18) {
                  var19 = var18 - (var3.o() + var4);
                  var9 = 2 - var19 / 2;
                  cj.a var22 = new cj.a();

                  for(var21 = var3.n() - var9; var21 <= var3.n() + var9; ++var21) {
                     for(var12 = var3.p() - var9; var12 <= var3.p() + var9; ++var12) {
                        var22.c(var21, var18, var12);
                        if (var1.p(var22).c().t() == arm.j) {
                           cj var23 = var22.e();
                           var14 = var22.f();
                           cj var15 = var22.c();
                           cj var16 = var22.d();
                           if (var2.nextInt(4) == 0 && var1.p(var23).c().t() == arm.a) {
                              this.a(var1, var23, akk.N);
                           }

                           if (var2.nextInt(4) == 0 && var1.p(var14).c().t() == arm.a) {
                              this.a(var1, var14, akk.P);
                           }

                           if (var2.nextInt(4) == 0 && var1.p(var15).c().t() == arm.a) {
                              this.a(var1, var15, akk.O);
                           }

                           if (var2.nextInt(4) == 0 && var1.p(var16).c().t() == arm.a) {
                              this.a(var1, var16, akk.b);
                           }
                        }
                     }
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }
}
