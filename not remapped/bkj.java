public class bkj extends bjo<uk> {
   private static final jy a = new jy("textures/entity/wither/wither_invulnerable.png");
   private static final jy e = new jy("textures/entity/wither/wither.png");

   protected jy a(pk var1) {
      return this.a((uk)var1);
   }

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((uk)var1, var2, var4, var6, var8, var9);
   }

   public void a(ps var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((uk)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(uk var1) {
      int var2 = var1.cl();
      return var2 > 0 && (var2 > 80 || var2 / 5 % 2 != 1) ? a : e;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((uk)var1, var2, var4, var6, var8, var9);
   }

   protected void a(uk var1, float var2) {
      float var3 = 2.0F;
      int var4 = var1.cl();
      if (var4 > 0) {
         var3 -= ((float)var4 - var2) / 220.0F * 0.5F;
      }

      bfl.a(var3, var3, var3);
   }

   public void a(uk var1, double var2, double var4, double var6, float var8, float var9) {
      bfc.a(var1, true);
      super.a((ps)var1, var2, var4, var6, var8, var9);
   }

   public bkj(biu var1) {
      super(var1, new bcl(0.0F), 1.0F);
      this.a((blb)(new blj(this)));
   }

   protected void a(pr var1, float var2) {
      this.a((uk)var1, var2);
   }
}
