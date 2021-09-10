import java.util.Random;

public class apm extends aot {
   public boolean b(adm var1, Random var2, cj var3) {
      for(int var4 = 0; var4 < 20; ++var4) {
         cj var5 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         if (var1.d(var5)) {
            cj var6 = var5.b();
            if (var1.p(var6.e()).c().t() == arm.h || var1.p(var6.f()).c().t() == arm.h || var1.p(var6.c()).c().t() == arm.h || var1.p(var6.d()).c().t() == arm.h) {
               int var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

               for(int var8 = 0; var8 < var7; ++var8) {
                  if (afi.aM.e(var1, var5)) {
                     var1.a((cj)var5.b(var8), (alz)afi.aM.Q(), 2);
                  }
               }
            }
         }
      }

      return true;
   }
}
