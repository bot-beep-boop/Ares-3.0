import java.util.Iterator;
import java.util.Random;

public class apv extends aoh {
   private static final alz b;
   private final alz e;
   private final alz f;
   private static final alz a;
   private final boolean d;
   private final int c;

   private void a(adm var1, cj var2, amk var3) {
      this.a(var1, var2, afi.bn.Q().a(var3, true));
   }

   public apv(boolean var1, int var2, alz var3, alz var4, boolean var5) {
      super(var1);
      this.c = var2;
      this.e = var3;
      this.f = var4;
      this.d = var5;
   }

   private void a(adm var1, int var2, cj var3, cq var4) {
      this.a(var1, var3, afi.bN.Q().a(afu.a, var2).a(afu.O, var4));
   }

   private void b(adm var1, cj var2, amk var3) {
      this.a(var1, var2, var3);
      int var4 = 4;

      for(var2 = var2.b(); var1.p(var2).c().t() == arm.a && var4 > 0; --var4) {
         this.a(var1, var2, var3);
         var2 = var2.b();
      }

   }

   static {
      a = afi.r.Q().a(ail.b, aio.a.a);
      b = afi.t.Q().a(aik.Q, aio.a.a).a(ahs.b, false);
   }

   public boolean b(adm var1, Random var2, cj var3) {
      int var4 = var2.nextInt(3) + this.c;
      boolean var5 = true;
      if (var3.o() >= 1 && var3.o() + var4 + 1 <= 256) {
         byte var7;
         int var9;
         int var10;
         for(int var6 = var3.o(); var6 <= var3.o() + 1 + var4; ++var6) {
            var7 = 1;
            if (var6 == var3.o()) {
               var7 = 0;
            }

            if (var6 >= var3.o() + 1 + var4 - 2) {
               var7 = 2;
            }

            cj.a var8 = new cj.a();

            for(var9 = var3.n() - var7; var9 <= var3.n() + var7 && var5; ++var9) {
               for(var10 = var3.p() - var7; var10 <= var3.p() + var7 && var5; ++var10) {
                  if (var6 >= 0 && var6 < 256) {
                     if (!this.a(var1.p(var8.c(var9, var6, var10)).c())) {
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
            if ((var19 == afi.c || var19 == afi.d || var19 == afi.ak) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());
               var7 = 3;
               byte var20 = 0;

               int var11;
               int var13;
               int var14;
               cj var16;
               for(var9 = var3.o() - var7 + var4; var9 <= var3.o() + var4; ++var9) {
                  var10 = var9 - (var3.o() + var4);
                  var11 = var20 + 1 - var10 / 2;

                  for(int var12 = var3.n() - var11; var12 <= var3.n() + var11; ++var12) {
                     var13 = var12 - var3.n();

                     for(var14 = var3.p() - var11; var14 <= var3.p() + var11; ++var14) {
                        int var15 = var14 - var3.p();
                        if (Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) {
                           var16 = new cj(var12, var9, var14);
                           afh var17 = var1.p(var16).c();
                           if (var17.t() == arm.a || var17.t() == arm.j || var17.t() == arm.l) {
                              this.a(var1, var16, this.f);
                           }
                        }
                     }
                  }
               }

               for(var9 = 0; var9 < var4; ++var9) {
                  afh var21 = var1.p(var3.b(var9)).c();
                  if (var21.t() == arm.a || var21.t() == arm.j || var21.t() == arm.l) {
                     this.a(var1, var3.b(var9), this.e);
                     if (this.d && var9 > 0) {
                        if (var2.nextInt(3) > 0 && var1.d(var3.a(-1, var9, 0))) {
                           this.a(var1, var3.a(-1, var9, 0), akk.N);
                        }

                        if (var2.nextInt(3) > 0 && var1.d(var3.a(1, var9, 0))) {
                           this.a(var1, var3.a(1, var9, 0), akk.P);
                        }

                        if (var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, -1))) {
                           this.a(var1, var3.a(0, var9, -1), akk.O);
                        }

                        if (var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, 1))) {
                           this.a(var1, var3.a(0, var9, 1), akk.b);
                        }
                     }
                  }
               }

               if (this.d) {
                  for(var9 = var3.o() - 3 + var4; var9 <= var3.o() + var4; ++var9) {
                     var10 = var9 - (var3.o() + var4);
                     var11 = 2 - var10 / 2;
                     cj.a var24 = new cj.a();

                     for(var13 = var3.n() - var11; var13 <= var3.n() + var11; ++var13) {
                        for(var14 = var3.p() - var11; var14 <= var3.p() + var11; ++var14) {
                           var24.c(var13, var9, var14);
                           if (var1.p(var24).c().t() == arm.j) {
                              cj var26 = var24.e();
                              var16 = var24.f();
                              cj var27 = var24.c();
                              cj var18 = var24.d();
                              if (var2.nextInt(4) == 0 && var1.p(var26).c().t() == arm.a) {
                                 this.b(var1, var26, akk.N);
                              }

                              if (var2.nextInt(4) == 0 && var1.p(var16).c().t() == arm.a) {
                                 this.b(var1, var16, akk.P);
                              }

                              if (var2.nextInt(4) == 0 && var1.p(var27).c().t() == arm.a) {
                                 this.b(var1, var27, akk.O);
                              }

                              if (var2.nextInt(4) == 0 && var1.p(var18).c().t() == arm.a) {
                                 this.b(var1, var18, akk.b);
                              }
                           }
                        }
                     }
                  }

                  if (var2.nextInt(5) == 0 && var4 > 5) {
                     for(var9 = 0; var9 < 2; ++var9) {
                        Iterator var22 = cq.c.a.iterator();

                        while(var22.hasNext()) {
                           cq var23 = (cq)var22.next();
                           if (var2.nextInt(4 - var9) == 0) {
                              cq var25 = var23.d();
                              this.a(var1, var2.nextInt(3), var3.a(var25.g(), var4 - 5 + var9, var25.i()), var23);
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

   public apv(boolean var1) {
      this(var1, 4, a, b, false);
   }
}
