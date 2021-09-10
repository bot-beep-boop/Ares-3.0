import java.util.Random;

public class apw extends aot {
   public boolean b(adm var1, Random var2, cj var3) {
      for(; var3.o() < 128; var3 = var3.a()) {
         if (var1.d(var3)) {
            cq[] var4 = cq.c.a.a();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               cq var7 = var4[var6];
               if (afi.bn.b(var1, var3, var7)) {
                  alz var8 = afi.bn.Q().a(akk.b, var7 == cq.c).a(akk.N, var7 == cq.f).a(akk.O, var7 == cq.d).a(akk.P, var7 == cq.e);
                  var1.a((cj)var3, (alz)var8, 2);
                  break;
               }
            }
         } else {
            var3 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         }
      }

      return true;
   }
}
