import java.util.Random;

public class aos extends aot {
   private agi.b a;

   public void a(agi.b var1) {
      this.a = var1;
   }

   public boolean b(adm var1, Random var2, cj var3) {
      boolean var4 = false;

      for(int var5 = 0; var5 < 64; ++var5) {
         cj var6 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if (var1.d(var6) && (!var1.t.o() || var6.o() < 254) && afi.cF.d(var1, var6)) {
            afi.cF.a(var1, var6, this.a, 2);
            var4 = true;
         }
      }

      return var4;
   }
}
