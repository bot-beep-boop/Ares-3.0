public class bki extends bjo<wd> {
   private static final jy a = new jy("textures/entity/witch.png");

   protected void a(wd var1, float var2) {
      float var3 = 0.9375F;
      bfl.a(var3, var3, var3);
   }

   public void a(ps var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((wd)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(wd var1) {
      return a;
   }

   public void a(wd var1, double var2, double var4, double var6, float var8, float var9) {
      ((bck)this.f).g = var1.bA() != null;
      super.a((ps)var1, var2, var4, var6, var8, var9);
   }

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((wd)var1, var2, var4, var6, var8, var9);
   }

   protected void a(pr var1, float var2) {
      this.a((wd)var1, var2);
   }

   public bki(biu var1) {
      super(var1, new bck(0.0F), 0.5F);
      this.a((blb)(new bli(this)));
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((wd)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(pk var1) {
      return this.a((wd)var1);
   }

   public void C_() {
      bfl.b(0.0F, 0.1875F, 0.0F);
   }
}
