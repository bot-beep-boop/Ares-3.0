import java.util.Random;

public class apq extends aot {
   private afh a;

   public apq(afh var1) {
      this.a = var1;
   }

   public boolean b(adm var1, Random var2, cj var3) {
      if (var1.d(var3) && var1.p(var3.b()).c() == this.a) {
         int var4 = var2.nextInt(32) + 6;
         int var5 = var2.nextInt(4) + 1;
         cj.a var6 = new cj.a();

         int var7;
         int var8;
         int var9;
         int var10;
         for(var7 = var3.n() - var5; var7 <= var3.n() + var5; ++var7) {
            for(var8 = var3.p() - var5; var8 <= var3.p() + var5; ++var8) {
               var9 = var7 - var3.n();
               var10 = var8 - var3.p();
               if (var9 * var9 + var10 * var10 <= var5 * var5 + 1 && var1.p(var6.c(var7, var3.o() - 1, var8)).c() != this.a) {
                  return false;
               }
            }
         }

         for(var7 = var3.o(); var7 < var3.o() + var4 && var7 < 256; ++var7) {
            for(var8 = var3.n() - var5; var8 <= var3.n() + var5; ++var8) {
               for(var9 = var3.p() - var5; var9 <= var3.p() + var5; ++var9) {
                  var10 = var8 - var3.n();
                  int var11 = var9 - var3.p();
                  if (var10 * var10 + var11 * var11 <= var5 * var5 + 1) {
                     var1.a((cj)(new cj(var8, var7, var9)), (alz)afi.Z.Q(), 2);
                  }
               }
            }
         }

         uf var12 = new uf(var1);
         var12.b((double)((float)var3.n() + 0.5F), (double)(var3.o() + var4), (double)((float)var3.p() + 0.5F), var2.nextFloat() * 360.0F, 0.0F);
         var1.d((pk)var12);
         var1.a((cj)var3.b(var4), (alz)afi.h.Q(), 2);
         return true;
      } else {
         return false;
      }
   }
}
