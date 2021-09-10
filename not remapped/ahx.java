import java.util.Random;

public class ahx extends afh {
   protected ahx() {
      super(arm.C, arn.u);
      this.a(yz.b);
   }

   public int a(Random var1) {
      return 3 + var1.nextInt(5);
   }

   public int a(int var1, Random var2) {
      return Math.min(9, this.a(var2) + var2.nextInt(1 + var1));
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.bf;
   }
}
