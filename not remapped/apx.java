import java.util.Random;

public class apx extends aot {
   public boolean b(adm var1, Random var2, cj var3) {
      for(int var4 = 0; var4 < 10; ++var4) {
         int var5 = var3.n() + var2.nextInt(8) - var2.nextInt(8);
         int var6 = var3.o() + var2.nextInt(4) - var2.nextInt(4);
         int var7 = var3.p() + var2.nextInt(8) - var2.nextInt(8);
         if (var1.d(new cj(var5, var6, var7)) && afi.bx.d(var1, new cj(var5, var6, var7))) {
            var1.a((cj)(new cj(var5, var6, var7)), (alz)afi.bx.Q(), 2);
         }
      }

      return true;
   }
}
