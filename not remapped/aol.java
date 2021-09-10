import java.util.List;
import java.util.Random;

public class aol extends aot {
   private final int b;
   private final List<ob> a;

   public aol(List<ob> var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean b(adm var1, Random var2, cj var3) {
      afh var4;
      while(((var4 = var1.p(var3).c()).t() == arm.a || var4.t() == arm.j) && var3.o() > 1) {
         var3 = var3.b();
      }

      if (var3.o() < 1) {
         return false;
      } else {
         var3 = var3.a();

         for(int var5 = 0; var5 < 4; ++var5) {
            cj var6 = var3.a(var2.nextInt(4) - var2.nextInt(4), var2.nextInt(3) - var2.nextInt(3), var2.nextInt(4) - var2.nextInt(4));
            if (var1.d(var6) && adm.a((adq)var1, (cj)var6.b())) {
               var1.a((cj)var6, (alz)afi.ae.Q(), 2);
               akw var7 = var1.s(var6);
               if (var7 instanceof aky) {
                  ob.a(var2, this.a, (og)((aky)var7), this.b);
               }

               cj var8 = var6.f();
               cj var9 = var6.e();
               cj var10 = var6.c();
               cj var11 = var6.d();
               if (var1.d(var9) && adm.a((adq)var1, (cj)var9.b())) {
                  var1.a((cj)var9, (alz)afi.aa.Q(), 2);
               }

               if (var1.d(var8) && adm.a((adq)var1, (cj)var8.b())) {
                  var1.a((cj)var8, (alz)afi.aa.Q(), 2);
               }

               if (var1.d(var10) && adm.a((adq)var1, (cj)var10.b())) {
                  var1.a((cj)var10, (alz)afi.aa.Q(), 2);
               }

               if (var1.d(var11) && adm.a((adq)var1, (cj)var11.b())) {
                  var1.a((cj)var11, (alz)afi.aa.Q(), 2);
               }

               return true;
            }
         }

         return false;
      }
   }
}
