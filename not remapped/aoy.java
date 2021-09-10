import java.util.Random;

public class aoy extends aot {
   private final boolean b;
   private final afh a;

   public aoy(afh var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public boolean b(adm var1, Random var2, cj var3) {
      if (var1.p(var3.a()).c() != afi.aV) {
         return false;
      } else if (var1.p(var3).c().t() != arm.a && var1.p(var3).c() != afi.aV) {
         return false;
      } else {
         int var4 = 0;
         if (var1.p(var3.e()).c() == afi.aV) {
            ++var4;
         }

         if (var1.p(var3.f()).c() == afi.aV) {
            ++var4;
         }

         if (var1.p(var3.c()).c() == afi.aV) {
            ++var4;
         }

         if (var1.p(var3.d()).c() == afi.aV) {
            ++var4;
         }

         if (var1.p(var3.b()).c() == afi.aV) {
            ++var4;
         }

         int var5 = 0;
         if (var1.d(var3.e())) {
            ++var5;
         }

         if (var1.d(var3.f())) {
            ++var5;
         }

         if (var1.d(var3.c())) {
            ++var5;
         }

         if (var1.d(var3.d())) {
            ++var5;
         }

         if (var1.d(var3.b())) {
            ++var5;
         }

         if (!this.b && var4 == 4 && var5 == 1 || var4 == 5) {
            var1.a((cj)var3, (alz)this.a.Q(), 2);
            var1.a(this.a, var3, var2);
         }

         return true;
      }
   }
}
