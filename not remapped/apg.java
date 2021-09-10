import java.util.Random;

public abstract class apg extends aoh {
   protected final alz c;
   protected final int a;
   protected int d;
   protected final alz b;

   protected void a(adm var1, cj var2, int var3) {
      int var4 = var3 * var3;

      for(int var5 = -var3; var5 <= var3 + 1; ++var5) {
         for(int var6 = -var3; var6 <= var3 + 1; ++var6) {
            int var7 = var5 - 1;
            int var8 = var6 - 1;
            if (var5 * var5 + var6 * var6 <= var4 || var7 * var7 + var8 * var8 <= var4 || var5 * var5 + var8 * var8 <= var4 || var7 * var7 + var6 * var6 <= var4) {
               cj var9 = var2.a(var5, 0, var6);
               arm var10 = var1.p(var9).c().t();
               if (var10 == arm.a || var10 == arm.j) {
                  this.a(var1, var9, this.c);
               }
            }
         }
      }

   }

   protected boolean a(adm var1, Random var2, cj var3, int var4) {
      return this.c(var1, var3, var4) && this.a(var3, var1);
   }

   private boolean c(adm var1, cj var2, int var3) {
      boolean var4 = true;
      if (var2.o() >= 1 && var2.o() + var3 + 1 <= 256) {
         for(int var5 = 0; var5 <= 1 + var3; ++var5) {
            byte var6 = 2;
            if (var5 == 0) {
               var6 = 1;
            } else if (var5 >= 1 + var3 - 2) {
               var6 = 2;
            }

            for(int var7 = -var6; var7 <= var6 && var4; ++var7) {
               for(int var8 = -var6; var8 <= var6 && var4; ++var8) {
                  if (var2.o() + var5 < 0 || var2.o() + var5 >= 256 || !this.a(var1.p(var2.a(var7, var5, var8)).c())) {
                     var4 = false;
                  }
               }
            }
         }

         return var4;
      } else {
         return false;
      }
   }

   protected int a(Random var1) {
      int var2 = var1.nextInt(3) + this.a;
      if (this.d > 1) {
         var2 += var1.nextInt(this.d);
      }

      return var2;
   }

   public apg(boolean var1, int var2, int var3, alz var4, alz var5) {
      super(var1);
      this.a = var2;
      this.d = var3;
      this.b = var4;
      this.c = var5;
   }

   protected void b(adm var1, cj var2, int var3) {
      int var4 = var3 * var3;

      for(int var5 = -var3; var5 <= var3; ++var5) {
         for(int var6 = -var3; var6 <= var3; ++var6) {
            if (var5 * var5 + var6 * var6 <= var4) {
               cj var7 = var2.a(var5, 0, var6);
               arm var8 = var1.p(var7).c().t();
               if (var8 == arm.a || var8 == arm.j) {
                  this.a(var1, var7, this.c);
               }
            }
         }
      }

   }

   private boolean a(cj var1, adm var2) {
      cj var3 = var1.b();
      afh var4 = var2.p(var3).c();
      if ((var4 == afi.c || var4 == afi.d) && var1.o() >= 2) {
         this.a(var2, var3);
         this.a(var2, var3.f());
         this.a(var2, var3.d());
         this.a(var2, var3.d().f());
         return true;
      } else {
         return false;
      }
   }
}
