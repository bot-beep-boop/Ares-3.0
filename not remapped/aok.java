import java.util.Iterator;
import java.util.Random;

public class aok extends aot {
   private final int b;
   private final afh a;

   public aok(afh var1, int var2) {
      super(false);
      this.a = var1;
      this.b = var2;
   }

   public boolean b(adm var1, Random var2, cj var3) {
      while(true) {
         label66: {
            if (var3.o() > 3) {
               if (var1.d(var3.b())) {
                  break label66;
               }

               afh var4 = var1.p(var3.b()).c();
               if (var4 != afi.c && var4 != afi.d && var4 != afi.b) {
                  break label66;
               }
            }

            if (var3.o() <= 3) {
               return false;
            }

            int var12 = this.b;

            for(int var5 = 0; var12 >= 0 && var5 < 3; ++var5) {
               int var6 = var12 + var2.nextInt(2);
               int var7 = var12 + var2.nextInt(2);
               int var8 = var12 + var2.nextInt(2);
               float var9 = (float)(var6 + var7 + var8) * 0.333F + 0.5F;
               Iterator var10 = cj.a(var3.a(-var6, -var7, -var8), var3.a(var6, var7, var8)).iterator();

               while(var10.hasNext()) {
                  cj var11 = (cj)var10.next();
                  if (var11.i(var3) <= (double)(var9 * var9)) {
                     var1.a((cj)var11, (alz)this.a.Q(), 4);
                  }
               }

               var3 = var3.a(-(var12 + 1) + var2.nextInt(2 + var12 * 2), 0 - var2.nextInt(2), -(var12 + 1) + var2.nextInt(2 + var12 * 2));
            }

            return true;
         }

         var3 = var3.b();
      }
   }
}
