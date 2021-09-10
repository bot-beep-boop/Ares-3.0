import java.util.Random;

public class apn extends aoh {
   private static final alz b;
   private static final alz a;

   private void b(adm var1, cj var2) {
      if (this.a(var1.p(var2).c())) {
         this.a(var1, var2, a);
      }

   }

   private void a(adm var1, int var2, int var3, int var4) {
      cj var5 = new cj(var2, var3, var4);
      afh var6 = var1.p(var5).c();
      if (var6.t() == arm.a) {
         this.a(var1, var5, b);
      }

   }

   private boolean a(adm var1, cj var2, int var3) {
      int var4 = var2.n();
      int var5 = var2.o();
      int var6 = var2.p();
      cj.a var7 = new cj.a();

      for(int var8 = 0; var8 <= var3 + 1; ++var8) {
         byte var9 = 1;
         if (var8 == 0) {
            var9 = 0;
         }

         if (var8 >= var3 - 1) {
            var9 = 2;
         }

         for(int var10 = -var9; var10 <= var9; ++var10) {
            for(int var11 = -var9; var11 <= var9; ++var11) {
               if (!this.a(var1.p(var7.c(var4 + var10, var5 + var8, var6 + var11)).c())) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   public boolean b(adm var1, Random var2, cj var3) {
      int var4 = var2.nextInt(3) + var2.nextInt(2) + 6;
      int var5 = var3.n();
      int var6 = var3.o();
      int var7 = var3.p();
      if (var6 >= 1 && var6 + var4 + 1 < 256) {
         cj var8 = var3.b();
         afh var9 = var1.p(var8).c();
         if (var9 != afi.c && var9 != afi.d) {
            return false;
         } else if (!this.a(var1, var3, var4)) {
            return false;
         } else {
            this.a(var1, var8);
            this.a(var1, var8.f());
            this.a(var1, var8.d());
            this.a(var1, var8.d().f());
            cq var10 = cq.c.a.a(var2);
            int var11 = var4 - var2.nextInt(4);
            int var12 = 2 - var2.nextInt(3);
            int var13 = var5;
            int var14 = var7;
            int var15 = var6 + var4 - 1;

            int var16;
            int var17;
            for(var16 = 0; var16 < var4; ++var16) {
               if (var16 >= var11 && var12 > 0) {
                  var13 += var10.g();
                  var14 += var10.i();
                  --var12;
               }

               var17 = var6 + var16;
               cj var18 = new cj(var13, var17, var14);
               arm var19 = var1.p(var18).c().t();
               if (var19 == arm.a || var19 == arm.j) {
                  this.b(var1, var18);
                  this.b(var1, var18.f());
                  this.b(var1, var18.d());
                  this.b(var1, var18.f().d());
               }
            }

            for(var16 = -2; var16 <= 0; ++var16) {
               for(var17 = -2; var17 <= 0; ++var17) {
                  byte var21 = -1;
                  this.a(var1, var13 + var16, var15 + var21, var14 + var17);
                  this.a(var1, 1 + var13 - var16, var15 + var21, var14 + var17);
                  this.a(var1, var13 + var16, var15 + var21, 1 + var14 - var17);
                  this.a(var1, 1 + var13 - var16, var15 + var21, 1 + var14 - var17);
                  if ((var16 > -2 || var17 > -1) && (var16 != -1 || var17 != -2)) {
                     byte var22 = 1;
                     this.a(var1, var13 + var16, var15 + var22, var14 + var17);
                     this.a(var1, 1 + var13 - var16, var15 + var22, var14 + var17);
                     this.a(var1, var13 + var16, var15 + var22, 1 + var14 - var17);
                     this.a(var1, 1 + var13 - var16, var15 + var22, 1 + var14 - var17);
                  }
               }
            }

            if (var2.nextBoolean()) {
               this.a(var1, var13, var15 + 2, var14);
               this.a(var1, var13 + 1, var15 + 2, var14);
               this.a(var1, var13 + 1, var15 + 2, var14 + 1);
               this.a(var1, var13, var15 + 2, var14 + 1);
            }

            for(var16 = -3; var16 <= 4; ++var16) {
               for(var17 = -3; var17 <= 4; ++var17) {
                  if ((var16 != -3 || var17 != -3) && (var16 != -3 || var17 != 4) && (var16 != 4 || var17 != -3) && (var16 != 4 || var17 != 4) && (Math.abs(var16) < 3 || Math.abs(var17) < 3)) {
                     this.a(var1, var13 + var16, var15, var14 + var17);
                  }
               }
            }

            for(var16 = -1; var16 <= 2; ++var16) {
               for(var17 = -1; var17 <= 2; ++var17) {
                  if ((var16 < 0 || var16 > 1 || var17 < 0 || var17 > 1) && var2.nextInt(3) <= 0) {
                     int var23 = var2.nextInt(3) + 2;

                     int var24;
                     for(var24 = 0; var24 < var23; ++var24) {
                        this.b(var1, new cj(var5 + var16, var15 - var24 - 1, var7 + var17));
                     }

                     int var20;
                     for(var24 = -1; var24 <= 1; ++var24) {
                        for(var20 = -1; var20 <= 1; ++var20) {
                           this.a(var1, var13 + var16 + var24, var15, var14 + var17 + var20);
                        }
                     }

                     for(var24 = -2; var24 <= 2; ++var24) {
                        for(var20 = -2; var20 <= 2; ++var20) {
                           if (Math.abs(var24) != 2 || Math.abs(var20) != 2) {
                              this.a(var1, var13 + var16 + var24, var15 - 1, var14 + var17 + var20);
                           }
                        }
                     }
                  }
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   static {
      a = afi.s.Q().a(aig.b, aio.a.f);
      b = afi.u.Q().a(aif.Q, aio.a.f).a(ahs.b, false);
   }

   public apn(boolean var1) {
      super(var1);
   }
}
