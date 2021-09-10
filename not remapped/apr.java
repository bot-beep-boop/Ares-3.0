import java.util.Random;

public class apr extends aot {
   private afh a;

   public apr(afh var1) {
      this.a = var1;
   }

   public boolean b(adm var1, Random var2, cj var3) {
      if (var1.p(var3.a()).c() != afi.b) {
         return false;
      } else if (var1.p(var3.b()).c() != afi.b) {
         return false;
      } else if (var1.p(var3).c().t() != arm.a && var1.p(var3).c() != afi.b) {
         return false;
      } else {
         int var4 = 0;
         if (var1.p(var3.e()).c() == afi.b) {
            ++var4;
         }

         if (var1.p(var3.f()).c() == afi.b) {
            ++var4;
         }

         if (var1.p(var3.c()).c() == afi.b) {
            ++var4;
         }

         if (var1.p(var3.d()).c() == afi.b) {
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

         if (var4 == 3 && var5 == 1) {
            var1.a((cj)var3, (alz)this.a.Q(), 2);
            var1.a(this.a, var3, var2);
         }

         return true;
      }
   }
}
