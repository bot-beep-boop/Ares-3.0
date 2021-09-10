public class bjj extends biv<up> {
   private bbm e = new bbm();
   private static final jy a = new jy("textures/entity/lead_knot.png");

   public void a(up var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      bfl.p();
      bfl.b((float)var2, (float)var4, (float)var6);
      float var10 = 0.0625F;
      bfl.B();
      bfl.a(-1.0F, -1.0F, 1.0F);
      bfl.d();
      this.c(var1);
      this.e.a(var1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, var10);
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }

   protected jy a(pk var1) {
      return this.a((up)var1);
   }

   protected jy a(up var1) {
      return a;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((up)var1, var2, var4, var6, var8, var9);
   }

   public bjj(biu var1) {
      super(var1);
   }
}
