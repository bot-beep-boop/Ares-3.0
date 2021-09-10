import java.util.Random;

public class aow extends aot {
   public boolean b(adm var1, Random var2, cj var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if (var1.d(var5) && var1.p(var5.b()).c() == afi.aV) {
            var1.a((cj)var5, (alz)afi.ab.Q(), 2);
         }
      }

      return true;
   }
}
