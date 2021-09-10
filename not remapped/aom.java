import java.util.Random;

public class aom extends aot {
   private afm a;

   public boolean b(adm var1, Random var2, cj var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if (var1.d(var5) && (!var1.t.o() || var5.o() < 255) && this.a.f(var1, var5, this.a.Q())) {
            var1.a((cj)var5, (alz)this.a.Q(), 2);
         }
      }

      return true;
   }

   public aom(afm var1) {
      this.a = var1;
   }
}
