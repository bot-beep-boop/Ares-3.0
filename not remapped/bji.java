public class bji extends bjo<vu> {
   private static final jy a = new jy("textures/entity/slime/magmacube.png");

   protected jy a(vu var1) {
      return a;
   }

   protected jy a(pk var1) {
      return this.a((vu)var1);
   }

   public bji(biu var1) {
      super(var1, new bbl(), 0.25F);
   }

   protected void a(vu var1, float var2) {
      int var3 = var1.cm();
      float var4 = (var1.c + (var1.b - var1.c) * var2) / ((float)var3 * 0.5F + 1.0F);
      float var5 = 1.0F / (var4 + 1.0F);
      float var6 = (float)var3;
      bfl.a(var5 * var6, 1.0F / var5 * var6, var5 * var6);
   }

   protected void a(pr var1, float var2) {
      this.a((vu)var1, var2);
   }
}
