public class bhg extends bhd<alf> {
   private static final jy c = new jy("textures/entity/chest/ender.png");
   private baz d = new baz();

   public void a(alf var1, double var2, double var4, double var6, float var8, int var9) {
      int var10 = 0;
      if (var1.t()) {
         var10 = var1.u();
      }

      if (var9 >= 0) {
         this.a(a[var9]);
         bfl.n(5890);
         bfl.E();
         bfl.a(4.0F, 4.0F, 1.0F);
         bfl.b(0.0625F, 0.0625F, 0.0625F);
         bfl.n(5888);
      } else {
         this.a(c);
      }

      bfl.E();
      bfl.B();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.b((float)var2, (float)var4 + 1.0F, (float)var6 + 1.0F);
      bfl.a(1.0F, -1.0F, -1.0F);
      bfl.b(0.5F, 0.5F, 0.5F);
      short var11 = 0;
      if (var10 == 2) {
         var11 = 180;
      }

      if (var10 == 3) {
         var11 = 0;
      }

      if (var10 == 4) {
         var11 = 90;
      }

      if (var10 == 5) {
         var11 = -90;
      }

      bfl.b((float)var11, 0.0F, 1.0F, 0.0F);
      bfl.b(-0.5F, -0.5F, -0.5F);
      float var12 = var1.f + (var1.a - var1.f) * var8;
      var12 = 1.0F - var12;
      var12 = 1.0F - var12 * var12 * var12;
      this.d.a.f = -(var12 * 3.1415927F / 2.0F);
      this.d.a();
      bfl.C();
      bfl.F();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      if (var9 >= 0) {
         bfl.n(5890);
         bfl.F();
         bfl.n(5888);
      }

   }

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      this.a((alf)var1, var2, var4, var6, var8, var9);
   }
}
