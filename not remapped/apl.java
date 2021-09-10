import java.util.Random;

public class apl extends aot {
   public boolean b(adm var1, Random var2, cj var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if (var1.d(var5) && var1.p(var5.b()).c() == afi.c && afi.aU.d(var1, var5)) {
            var1.a((cj)var5, (alz)afi.aU.Q().a(aiv.O, cq.c.a.a(var2)), 2);
         }
      }

      return true;
   }
}
