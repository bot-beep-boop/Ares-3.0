public class bkg extends bjo<ty> {
   private static final jy a = new jy("textures/entity/iron_golem.png");

   protected jy a(ty var1) {
      return a;
   }

   protected void a(pr var1, float var2, float var3, float var4) {
      this.a((ty)var1, var2, var3, var4);
   }

   protected jy a(pk var1) {
      return this.a((ty)var1);
   }

   public bkg(biu var1) {
      super(var1, new bch(), 0.5F);
      this.a((blb)(new blh(this)));
   }

   protected void a(ty var1, float var2, float var3, float var4) {
      super.a(var1, var2, var3, var4);
      if (!((double)var1.aB < 0.01D)) {
         float var5 = 13.0F;
         float var6 = var1.aC - var1.aB * (1.0F - var4) + 6.0F;
         float var7 = (Math.abs(var6 % var5 - var5 * 0.5F) - var5 * 0.25F) / (var5 * 0.25F);
         bfl.b(6.5F * var7, 0.0F, 0.0F, 1.0F);
      }
   }
}
