import java.util.Random;

public class aoj extends aoh {
   private static final alz a;
   private boolean c;
   private static final alz b;

   public boolean b(adm var1, Random var2, cj var3) {
      int var4 = var2.nextInt(3) + 5;
      if (this.c) {
         var4 += var2.nextInt(7);
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
            afh var16 = var1.p(var3.b()).c();
            if ((var16 == afi.c || var16 == afi.d || var16 == afi.ak) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());

               int var17;
               for(var17 = var3.o() - 3 + var4; var17 <= var3.o() + var4; ++var17) {
                  int var18 = var17 - (var3.o() + var4);
                  var9 = 1 - var18 / 2;

                  for(var10 = var3.n() - var9; var10 <= var3.n() + var9; ++var10) {
                     int var11 = var10 - var3.n();

                     for(int var12 = var3.p() - var9; var12 <= var3.p() + var9; ++var12) {
                        int var13 = var12 - var3.p();
                        if (Math.abs(var11) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var18 != 0) {
                           cj var14 = new cj(var10, var17, var12);
                           afh var15 = var1.p(var14).c();
                           if (var15.t() == arm.a || var15.t() == arm.j) {
                              this.a(var1, var14, b);
                           }
                        }
                     }
                  }
               }

               for(var17 = 0; var17 < var4; ++var17) {
                  afh var19 = var1.p(var3.b(var17)).c();
                  if (var19.t() == arm.a || var19.t() == arm.j) {
                     this.a(var1, var3.b(var17), a);
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

   public aoj(boolean var1, boolean var2) {
      super(var1);
      this.c = var2;
   }

   static {
      a = afi.r.Q().a(ail.b, aio.a.c);
      b = afi.t.Q().a(aik.Q, aio.a.c).a(aik.b, false);
   }
}
