public class bik extends biv<ux> {
   protected bbo a = new bax();
   private static final jy e = new jy("textures/entity/boat.png");

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ux)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(pk var1) {
      return this.a((ux)var1);
   }

   public bik(biu var1) {
      super(var1);
      this.c = 0.5F;
   }

   public void a(ux var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      bfl.b((float)var2, (float)var4 + 0.25F, (float)var6);
      bfl.b(180.0F - var8, 0.0F, 1.0F, 0.0F);
      float var10 = (float)var1.l() - var9;
      float var11 = var1.j() - var9;
      if (var11 < 0.0F) {
         var11 = 0.0F;
      }

      if (var10 > 0.0F) {
         bfl.b(ns.a(var10) * var10 * var11 / 10.0F * (float)var1.m(), 1.0F, 0.0F, 0.0F);
      }

      float var12 = 0.75F;
      bfl.a(var12, var12, var12);
      bfl.a(1.0F / var12, 1.0F / var12, 1.0F / var12);
      this.c(var1);
      bfl.a(-1.0F, -1.0F, 1.0F);
      this.a.a(var1, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }

   protected jy a(ux var1) {
      return e;
   }
}
