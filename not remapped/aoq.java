import java.util.Random;

public class aoq extends aot {
   public boolean b(adm var1, Random var2, cj var3) {
      afh var4;
      while(((var4 = var1.p(var3).c()).t() == arm.a || var4.t() == arm.j) && var3.o() > 0) {
         var3 = var3.b();
      }

      for(int var5 = 0; var5 < 4; ++var5) {
         cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if (var1.d(var6) && afi.I.f(var1, var6, afi.I.Q())) {
            var1.a((cj)var6, (alz)afi.I.Q(), 2);
         }
      }

      return true;
   }
}
