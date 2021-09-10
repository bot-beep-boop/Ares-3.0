public class bio extends bjo<vn> {
   private static final jy a = new jy("textures/entity/creeper/creeper.png");

   protected jy a(vn var1) {
      return a;
   }

   protected void a(pr var1, float var2) {
      this.a((vn)var1, var2);
   }

   protected int a(pr var1, float var2, float var3) {
      return this.a((vn)var1, var2, var3);
   }

   protected jy a(pk var1) {
      return this.a((vn)var1);
   }

   protected void a(vn var1, float var2) {
      float var3 = var1.a(var2);
      float var4 = 1.0F + ns.a(var3 * 100.0F) * var3 * 0.01F;
      var3 = ns.a(var3, 0.0F, 1.0F);
      var3 *= var3;
      var3 *= var3;
      float var5 = (1.0F + var3 * 0.4F) * var4;
      float var6 = (1.0F + var3 * 0.1F) / var4;
      bfl.a(var5, var6, var5);
   }

   public bio(biu var1) {
      super(var1, new bbc(), 0.5F);
      this.a((blb)(new bkr(this)));
   }

   protected int a(vn var1, float var2, float var3) {
      float var4 = var1.a(var3);
      if ((int)(var4 * 10.0F) % 2 == 0) {
         return 0;
      } else {
         int var5 = (int)(var4 * 0.2F * 255.0F);
         var5 = ns.a(var5, 0, 255);
         return var5 << 24 | 16777215;
      }
   }
}
