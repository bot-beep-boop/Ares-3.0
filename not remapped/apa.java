import java.util.Random;

public class apa extends aot {
   private afh a;
   private int b;

   public apa(int var1) {
      this.a = afi.cB;
      this.b = var1;
   }

   public boolean b(adm var1, Random var2, cj var3) {
      while(var1.d(var3) && var3.o() > 2) {
         var3 = var3.b();
      }

      if (var1.p(var3).c() != afi.aJ) {
         return false;
      } else {
         int var4 = var2.nextInt(this.b - 2) + 2;
         byte var5 = 1;

         for(int var6 = var3.n() - var4; var6 <= var3.n() + var4; ++var6) {
            for(int var7 = var3.p() - var4; var7 <= var3.p() + var4; ++var7) {
               int var8 = var6 - var3.n();
               int var9 = var7 - var3.p();
               if (var8 * var8 + var9 * var9 <= var4 * var4) {
                  for(int var10 = var3.o() - var5; var10 <= var3.o() + var5; ++var10) {
                     cj var11 = new cj(var6, var10, var7);
                     afh var12 = var1.p(var11).c();
                     if (var12 == afi.d || var12 == afi.aJ || var12 == afi.aI) {
                        var1.a((cj)var11, (alz)this.a.Q(), 2);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
