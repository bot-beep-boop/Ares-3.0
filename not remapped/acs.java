import java.util.Random;

public class acs extends aci {
   public static boolean a(int var0, Random var1) {
      if (var0 <= 0) {
         return false;
      } else {
         return var1.nextFloat() < 0.15F * (float)var0;
      }
   }

   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public acs(int var1, jy var2, int var3) {
      super(var1, var2, var3, acj.e);
      this.c("thorns");
   }

   public boolean a(zx var1) {
      return var1.b() instanceof yj ? true : super.a(var1);
   }

   public void b(pr var1, pk var2, int var3) {
      Random var4 = var1.bc();
      zx var5 = ack.a(aci.j, var1);
      if (a(var3, var4)) {
         if (var2 != null) {
            var2.a(ow.a((pk)var1), (float)b(var3, var4));
            var2.a("damage.thorns", 0.5F, 1.0F);
         }

         if (var5 != null) {
            var5.a(3, (pr)var1);
         }
      } else if (var5 != null) {
         var5.a(1, (pr)var1);
      }

   }

   public int a(int var1) {
      return 10 + 20 * (var1 - 1);
   }

   public int b() {
      return 3;
   }

   public static int b(int var0, Random var1) {
      return var0 > 10 ? var0 - 10 : 1 + var1.nextInt(4);
   }
}
