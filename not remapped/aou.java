import java.util.Random;

public class aou extends aot {
   private alz b;
   private agw a;

   public void a(agw var1, agw.a var2) {
      this.a = var1;
      this.b = var1.Q().a(var1.n(), var2);
   }

   public boolean b(adm var1, Random var2, cj var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         cj var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if (var1.d(var5) && (!var1.t.o() || var5.o() < 255) && this.a.f(var1, var5, this.b)) {
            var1.a((cj)var5, (alz)this.b, 2);
         }
      }

      return true;
   }

   public aou(agw var1, agw.a var2) {
      this.a(var1, var2);
   }
}
