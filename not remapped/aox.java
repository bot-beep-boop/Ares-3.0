import java.util.Random;

public class aox extends aot {
   public boolean b(adm var1, Random var2, cj var3) {
      if (!var1.d(var3)) {
         return false;
      } else if (var1.p(var3.a()).c() != afi.aV) {
         return false;
      } else {
         var1.a((cj)var3, (alz)afi.aX.Q(), 2);

         for(int var4 = 0; var4 < 1500; ++var4) {
            cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), -var2.nextInt(12), var2.nextInt(8) - var2.nextInt(8));
            if (var1.p(var5).c().t() == arm.a) {
               int var6 = 0;
               cq[] var7 = cq.values();
               int var8 = var7.length;

               for(int var9 = 0; var9 < var8; ++var9) {
                  cq var10 = var7[var9];
                  if (var1.p(var5.a(var10)).c() == afi.aX) {
                     ++var6;
                  }

                  if (var6 > 1) {
                     break;
                  }
               }

               if (var6 == 1) {
                  var1.a((cj)var5, (alz)afi.aX.Q(), 2);
               }
            }
         }

         return true;
      }
   }
}
