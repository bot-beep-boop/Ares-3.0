import java.util.Random;

public class aon extends aot {
   public boolean b(adm var1, Random var2, cj var3) {
      for(int var4 = 0; var4 < 10; ++var4) {
         cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if (var1.d(var5)) {
            int var6 = 1 + var2.nextInt(var2.nextInt(3) + 1);

            for(int var7 = 0; var7 < var6; ++var7) {
               if (afi.aK.e(var1, var5)) {
                  var1.a((cj)var5.b(var7), (alz)afi.aK.Q(), 2);
               }
            }
         }
      }

      return true;
   }
}
