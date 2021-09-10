import java.util.Random;

public class acg extends aci {
   public int b(int var1) {
      return super.a(var1) + 50;
   }

   public int b() {
      return 3;
   }

   public boolean a(zx var1) {
      return var1.e() ? true : super.a(var1);
   }

   public static boolean a(zx var0, int var1, Random var2) {
      if (var0.b() instanceof yj && var2.nextFloat() < 0.6F) {
         return false;
      } else {
         return var2.nextInt(var1 + 1) > 0;
      }
   }

   public int a(int var1) {
      return 5 + (var1 - 1) * 8;
   }

   protected acg(int var1, jy var2, int var3) {
      super(var1, var2, var3, acj.j);
      this.c("durability");
   }
}
