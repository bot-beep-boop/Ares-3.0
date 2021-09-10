public class ajn extends ahj {
   public void a(adm var1, cj var2, pk var3, float var4) {
      if (var3.av()) {
         super.a(var1, var2, var3, var4);
      } else {
         var3.e(var4, 0.0F);
      }

   }

   public void a(adm var1, pk var2) {
      if (var2.av()) {
         super.a(var1, var2);
      } else if (var2.w < 0.0D) {
         var2.w = -var2.w;
      }

   }

   public adf m() {
      return adf.d;
   }

   public void a(adm var1, cj var2, pk var3) {
      if (Math.abs(var3.w) < 0.1D && !var3.av()) {
         double var4 = 0.4D + Math.abs(var3.w) * 0.2D;
         var3.v *= var4;
         var3.x *= var4;
      }

      super.a(var1, var2, var3);
   }

   public ajn() {
      super(arm.B, false, arn.c);
      this.a(yz.c);
      this.L = 0.8F;
   }
}
