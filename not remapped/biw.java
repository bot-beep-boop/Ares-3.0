public class biw extends biv<pp> {
   private static final jy a = new jy("textures/entity/experience_orb.png");

   public biw(biu var1) {
      super(var1);
      this.c = 0.15F;
      this.d = 0.75F;
   }

   protected jy a(pk var1) {
      return this.a((pp)var1);
   }

   public void a(pp var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      bfl.b((float)var2, (float)var4, (float)var6);
      this.c(var1);
      int var10 = var1.l();
      float var11 = (float)(var10 % 4 * 16) / 64.0F;
      float var12 = (float)(var10 % 4 * 16 + 16) / 64.0F;
      float var13 = (float)(var10 / 4 * 16) / 64.0F;
      float var14 = (float)(var10 / 4 * 16 + 16) / 64.0F;
      float var15 = 1.0F;
      float var16 = 0.5F;
      float var17 = 0.25F;
      int var18 = var1.b(var9);
      int var19 = var18 % 65536;
      int var20 = var18 / 65536;
      bqs.a(bqs.r, (float)var19 / 1.0F, (float)var20 / 1.0F);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      float var26 = 255.0F;
      float var27 = ((float)var1.a + var9) / 2.0F;
      var20 = (int)((ns.a(var27 + 0.0F) + 1.0F) * 0.5F * 255.0F);
      boolean var21 = true;
      int var22 = (int)((ns.a(var27 + 4.1887903F) + 1.0F) * 0.1F * 255.0F);
      bfl.b(180.0F - this.b.e, 0.0F, 1.0F, 0.0F);
      bfl.b(-this.b.f, 1.0F, 0.0F, 0.0F);
      float var23 = 0.3F;
      bfl.a(0.3F, 0.3F, 0.3F);
      bfx var24 = bfx.a();
      bfd var25 = var24.c();
      var25.a(7, bms.l);
      var25.b((double)(0.0F - var16), (double)(0.0F - var17), 0.0D).a((double)var11, (double)var14).b(var20, 255, var22, 128).c(0.0F, 1.0F, 0.0F).d();
      var25.b((double)(var15 - var16), (double)(0.0F - var17), 0.0D).a((double)var12, (double)var14).b(var20, 255, var22, 128).c(0.0F, 1.0F, 0.0F).d();
      var25.b((double)(var15 - var16), (double)(1.0F - var17), 0.0D).a((double)var12, (double)var13).b(var20, 255, var22, 128).c(0.0F, 1.0F, 0.0F).d();
      var25.b((double)(0.0F - var16), (double)(1.0F - var17), 0.0D).a((double)var11, (double)var13).b(var20, 255, var22, 128).c(0.0F, 1.0F, 0.0F).d();
      var24.b();
      bfl.k();
      bfl.C();
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }

   protected jy a(pp var1) {
      return a;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((pp)var1, var2, var4, var6, var8, var9);
   }
}
