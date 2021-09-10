import java.util.Random;

public class apk extends aoh {
   private static final alz b;
   private static final alz a;

   public boolean b(adm var1, Random var2, cj var3) {
      int var4 = var2.nextInt(5) + 7;
      int var5 = var4 - var2.nextInt(2) - 3;
      int var6 = var4 - var5;
      int var7 = 1 + var2.nextInt(var6 + 1);
      boolean var8 = true;
      if (var3.o() >= 1 && var3.o() + var4 + 1 <= 256) {
         int var12;
         int var13;
         int var18;
         for(int var9 = var3.o(); var9 <= var3.o() + 1 + var4 && var8; ++var9) {
            boolean var10 = true;
            if (var9 - var3.o() < var5) {
               var18 = 0;
            } else {
               var18 = var7;
            }

            cj.a var11 = new cj.a();

            for(var12 = var3.n() - var18; var12 <= var3.n() + var18 && var8; ++var12) {
               for(var13 = var3.p() - var18; var13 <= var3.p() + var18 && var8; ++var13) {
                  if (var9 >= 0 && var9 < 256) {
                     if (!this.a(var1.p(var11.c(var12, var9, var13)).c())) {
                        var8 = false;
                     }
                  } else {
                     var8 = false;
                  }
               }
            }
         }

         if (!var8) {
            return false;
         } else {
            afh var17 = var1.p(var3.b()).c();
            if ((var17 == afi.c || var17 == afi.d) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());
               var18 = 0;

               int var19;
               for(var19 = var3.o() + var4; var19 >= var3.o() + var5; --var19) {
                  for(var12 = var3.n() - var18; var12 <= var3.n() + var18; ++var12) {
                     var13 = var12 - var3.n();

                     for(int var14 = var3.p() - var18; var14 <= var3.p() + var18; ++var14) {
                        int var15 = var14 - var3.p();
                        if (Math.abs(var13) != var18 || Math.abs(var15) != var18 || var18 <= 0) {
                           cj var16 = new cj(var12, var19, var14);
                           if (!var1.p(var16).c().o()) {
                              this.a(var1, var16, b);
                           }
                        }
                     }
                  }

                  if (var18 >= 1 && var19 == var3.o() + var5 + 1) {
                     --var18;
                  } else if (var18 < var7) {
                     ++var18;
                  }
               }

               for(var19 = 0; var19 < var4 - 1; ++var19) {
                  afh var20 = var1.p(var3.b(var19)).c();
                  if (var20.t() == arm.a || var20.t() == arm.j) {
                     this.a(var1, var3.b(var19), a);
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

   static {
      a = afi.r.Q().a(ail.b, aio.a.b);
      b = afi.t.Q().a(aik.Q, aio.a.b).a(ahs.b, false);
   }

   public apk() {
      super(false);
   }
}
