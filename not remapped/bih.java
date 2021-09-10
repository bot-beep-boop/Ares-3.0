import org.lwjgl.opengl.GL11;

public class bih extends biv<wq> {
   private static final jy a = new jy("textures/entity/arrow.png");

   public bih(biu var1) {
      super(var1);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((wq)var1, var2, var4, var6, var8, var9);
   }

   protected jy a(wq var1) {
      return a;
   }

   public void a(wq var1, double var2, double var4, double var6, float var8, float var9) {
      this.c(var1);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      bfl.E();
      bfl.b((float)var2, (float)var4, (float)var6);
      bfl.b(var1.A + (var1.y - var1.A) * var9 - 90.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(var1.B + (var1.z - var1.B) * var9, 0.0F, 0.0F, 1.0F);
      bfx var10 = bfx.a();
      bfd var11 = var10.c();
      byte var12 = 0;
      float var13 = 0.0F;
      float var14 = 0.5F;
      float var15 = (float)(0 + var12 * 10) / 32.0F;
      float var16 = (float)(5 + var12 * 10) / 32.0F;
      float var17 = 0.0F;
      float var18 = 0.15625F;
      float var19 = (float)(5 + var12 * 10) / 32.0F;
      float var20 = (float)(10 + var12 * 10) / 32.0F;
      float var21 = 0.05625F;
      bfl.B();
      float var22 = (float)var1.b - var9;
      if (var22 > 0.0F) {
         float var23 = -ns.a(var22 * 3.0F) * var22;
         bfl.b(var23, 0.0F, 0.0F, 1.0F);
      }

      bfl.b(45.0F, 1.0F, 0.0F, 0.0F);
      bfl.a(var21, var21, var21);
      bfl.b(-4.0F, 0.0F, 0.0F);
      GL11.glNormal3f(var21, 0.0F, 0.0F);
      var11.a(7, bms.g);
      var11.b(-7.0D, -2.0D, -2.0D).a((double)var17, (double)var19).d();
      var11.b(-7.0D, -2.0D, 2.0D).a((double)var18, (double)var19).d();
      var11.b(-7.0D, 2.0D, 2.0D).a((double)var18, (double)var20).d();
      var11.b(-7.0D, 2.0D, -2.0D).a((double)var17, (double)var20).d();
      var10.b();
      GL11.glNormal3f(-var21, 0.0F, 0.0F);
      var11.a(7, bms.g);
      var11.b(-7.0D, 2.0D, -2.0D).a((double)var17, (double)var19).d();
      var11.b(-7.0D, 2.0D, 2.0D).a((double)var18, (double)var19).d();
      var11.b(-7.0D, -2.0D, 2.0D).a((double)var18, (double)var20).d();
      var11.b(-7.0D, -2.0D, -2.0D).a((double)var17, (double)var20).d();
      var10.b();

      for(int var24 = 0; var24 < 4; ++var24) {
         bfl.b(90.0F, 1.0F, 0.0F, 0.0F);
         GL11.glNormal3f(0.0F, 0.0F, var21);
         var11.a(7, bms.g);
         var11.b(-8.0D, -2.0D, 0.0D).a((double)var13, (double)var15).d();
         var11.b(8.0D, -2.0D, 0.0D).a((double)var14, (double)var15).d();
         var11.b(8.0D, 2.0D, 0.0D).a((double)var14, (double)var16).d();
         var11.b(-8.0D, 2.0D, 0.0D).a((double)var13, (double)var16).d();
         var10.b();
      }

      bfl.C();
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }

   protected jy a(pk var1) {
      return this.a((wq)var1);
   }
}
