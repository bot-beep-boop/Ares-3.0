public class bkf extends biv<vj> {
   protected jy a(pk var1) {
      return this.a((vj)var1);
   }

   protected jy a(vj var1) {
      return bmh.g;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((vj)var1, var2, var4, var6, var8, var9);
   }

   public bkf(biu var1) {
      super(var1);
      this.c = 0.5F;
   }

   public void a(vj var1, double var2, double var4, double var6, float var8, float var9) {
      bgd var10 = ave.A().ae();
      bfl.E();
      bfl.b((float)var2, (float)var4 + 0.5F, (float)var6);
      float var11;
      if ((float)var1.a - var9 + 1.0F < 10.0F) {
         var11 = 1.0F - ((float)var1.a - var9 + 1.0F) / 10.0F;
         var11 = ns.a(var11, 0.0F, 1.0F);
         var11 *= var11;
         var11 *= var11;
         float var12 = 1.0F + var11 * 0.3F;
         bfl.a(var12, var12, var12);
      }

      var11 = (1.0F - ((float)var1.a - var9 + 1.0F) / 100.0F) * 0.8F;
      this.c(var1);
      bfl.b(-0.5F, -0.5F, 0.5F);
      var10.a(afi.W.Q(), var1.c(var9));
      bfl.b(0.0F, 0.0F, 1.0F);
      if (var1.a / 5 % 2 == 0) {
         bfl.x();
         bfl.f();
         bfl.l();
         bfl.b(770, 772);
         bfl.c(1.0F, 1.0F, 1.0F, var11);
         bfl.a(-3.0F, -3.0F);
         bfl.q();
         var10.a(afi.W.Q(), 1.0F);
         bfl.a(0.0F, 0.0F);
         bfl.r();
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.k();
         bfl.e();
         bfl.w();
      }

      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }
}
