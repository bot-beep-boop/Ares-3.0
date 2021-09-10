public class bja extends bjo<vr> {
   private static final jy a = new jy("textures/entity/ghast/ghast.png");
   private static final jy e = new jy("textures/entity/ghast/ghast_shooting.png");

   protected void a(vr var1, float var2) {
      float var3 = 1.0F;
      float var4 = (8.0F + var3) / 2.0F;
      float var5 = (8.0F + 1.0F / var3) / 2.0F;
      bfl.a(var5, var4, var5);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
   }

   public bja(biu var1) {
      super(var1, new bbf(), 0.5F);
   }

   protected jy a(pk var1) {
      return this.a((vr)var1);
   }

   protected jy a(vr var1) {
      return var1.n() ? e : a;
   }

   protected void a(pr var1, float var2) {
      this.a((vr)var1, var2);
   }
}
