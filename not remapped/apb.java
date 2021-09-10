import java.util.Random;

public class apb extends aot {
   public boolean b(adm var1, Random var2, cj var3) {
      while(var1.d(var3) && var3.o() > 2) {
         var3 = var3.b();
      }

      if (var1.p(var3).c() != afi.aJ) {
         return false;
      } else {
         var3 = var3.b(var2.nextInt(4));
         int var4 = var2.nextInt(4) + 7;
         int var5 = var4 / 4 + var2.nextInt(2);
         if (var5 > 1 && var2.nextInt(60) == 0) {
            var3 = var3.b(10 + var2.nextInt(30));
         }

         int var6;
         int var8;
         for(var6 = 0; var6 < var4; ++var6) {
            float var7 = (1.0F - (float)var6 / (float)var4) * (float)var5;
            var8 = ns.f(var7);

            for(int var9 = -var8; var9 <= var8; ++var9) {
               float var10 = (float)ns.a(var9) - 0.25F;

               for(int var11 = -var8; var11 <= var8; ++var11) {
                  float var12 = (float)ns.a(var11) - 0.25F;
                  if ((var9 == 0 && var11 == 0 || !(var10 * var10 + var12 * var12 > var7 * var7)) && (var9 != -var8 && var9 != var8 && var11 != -var8 && var11 != var8 || !(var2.nextFloat() > 0.75F))) {
                     afh var13 = var1.p(var3.a(var9, var6, var11)).c();
                     if (var13.t() == arm.a || var13 == afi.d || var13 == afi.aJ || var13 == afi.aI) {
                        this.a(var1, var3.a(var9, var6, var11), afi.cB.Q());
                     }

                     if (var6 != 0 && var8 > 1) {
                        var13 = var1.p(var3.a(var9, -var6, var11)).c();
                        if (var13.t() == arm.a || var13 == afi.d || var13 == afi.aJ || var13 == afi.aI) {
                           this.a(var1, var3.a(var9, -var6, var11), afi.cB.Q());
                        }
                     }
                  }
               }
            }
         }

         var6 = var5 - 1;
         if (var6 < 0) {
            var6 = 0;
         } else if (var6 > 1) {
            var6 = 1;
         }

         for(int var14 = -var6; var14 <= var6; ++var14) {
            for(var8 = -var6; var8 <= var6; ++var8) {
               cj var15 = var3.a(var14, -1, var8);
               int var16 = 50;
               if (Math.abs(var14) == 1 && Math.abs(var8) == 1) {
                  var16 = var2.nextInt(5);
               }

               while(var15.o() > 50) {
                  afh var17 = var1.p(var15).c();
                  if (var17.t() != arm.a && var17 != afi.d && var17 != afi.aJ && var17 != afi.aI && var17 != afi.cB) {
                     break;
                  }

                  this.a(var1, var15, afi.cB.Q());
                  var15 = var15.b();
                  --var16;
                  if (var16 <= 0) {
                     var15 = var15.c(var2.nextInt(5) + 1);
                     var16 = var2.nextInt(5);
                  }
               }
            }
         }

         return true;
      }
   }
}
