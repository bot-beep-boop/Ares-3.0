public class bjy extends bjo<wb> {
   private static final jy a = new jy("textures/entity/slime/slime.png");

   public bjy(biu var1, bbo var2, float var3) {
      super(var1, var2, var3);
      this.a((blb)(new bld(this)));
   }

   protected void a(wb var1, float var2) {
      float var3 = (float)var1.cm();
      float var4 = (var1.c + (var1.b - var1.c) * var2) / (var3 * 0.5F + 1.0F);
      float var5 = 1.0F / (var4 + 1.0F);
      bfl.a(var5 * var3, 1.0F / var5 * var3, var5 * var3);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((wb)var1, var2, var4, var6, var8, var9);
   }

   public void a(wb var1, double var2, double var4, double var6, float var8, float var9) {
      this.c = 0.25F * (float)var1.cm();
      super.a((ps)var1, var2, var4, var6, var8, var9);
   }

   protected void a(pr var1, float var2) {
      this.a((wb)var1, var2);
   }

   protected jy a(pk var1) {
      return this.a((wb)var1);
   }

   public void a(ps var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((wb)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(wb var1) {
      return a;
   }

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((wb)var1, var2, var4, var6, var8, var9);
   }
}
