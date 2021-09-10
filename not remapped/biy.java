public class biy extends biv<ws> {
   private float a;

   public biy(biu var1, float var2) {
      super(var1);
      this.a = var2;
   }

   public void a(ws var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      this.c(var1);
      bfl.b((float)var2, (float)var4, (float)var6);
      bfl.B();
      bfl.a(this.a, this.a, this.a);
      bmi var10 = ave.A().ag().a().a(zy.bL);
      bfx var11 = bfx.a();
      bfd var12 = var11.c();
      float var13 = var10.e();
      float var14 = var10.f();
      float var15 = var10.g();
      float var16 = var10.h();
      float var17 = 1.0F;
      float var18 = 0.5F;
      float var19 = 0.25F;
      bfl.b(180.0F - this.b.e, 0.0F, 1.0F, 0.0F);
      bfl.b(-this.b.f, 1.0F, 0.0F, 0.0F);
      var12.a(7, bms.j);
      var12.b(-0.5D, -0.25D, 0.0D).a((double)var13, (double)var16).c(0.0F, 1.0F, 0.0F).d();
      var12.b(0.5D, -0.25D, 0.0D).a((double)var14, (double)var16).c(0.0F, 1.0F, 0.0F).d();
      var12.b(0.5D, 0.75D, 0.0D).a((double)var14, (double)var15).c(0.0F, 1.0F, 0.0F).d();
      var12.b(-0.5D, 0.75D, 0.0D).a((double)var13, (double)var15).c(0.0F, 1.0F, 0.0F).d();
      var11.b();
      bfl.C();
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }

   protected jy a(ws var1) {
      return bmh.g;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ws)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(pk var1) {
      return this.a((ws)var1);
   }
}
