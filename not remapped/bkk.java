public class bkk extends biv<xd> {
   private static final jy e = new jy("textures/entity/wither/wither.png");
   private static final jy a = new jy("textures/entity/wither/wither_invulnerable.png");
   private final bbz f = new bbz();

   protected jy a(pk var1) {
      return this.a((xd)var1);
   }

   public void a(xd var1, double var2, double var4, double var6, float var8, float var9) {
      bfl.E();
      bfl.p();
      float var10 = this.a(var1.A, var1.y, var9);
      float var11 = var1.B + (var1.z - var1.B) * var9;
      bfl.b((float)var2, (float)var4, (float)var6);
      float var12 = 0.0625F;
      bfl.B();
      bfl.a(-1.0F, -1.0F, 1.0F);
      bfl.d();
      this.c(var1);
      this.f.a(var1, 0.0F, 0.0F, 0.0F, var10, var11, var12);
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }

   protected jy a(xd var1) {
      return var1.l() ? a : e;
   }

   public bkk(biu var1) {
      super(var1);
   }

   private float a(float var1, float var2, float var3) {
      float var4;
      for(var4 = var2 - var1; var4 < -180.0F; var4 += 360.0F) {
      }

      while(var4 >= 180.0F) {
         var4 -= 360.0F;
      }

      return var1 + var3 * var4;
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((xd)var1, var2, var4, var6, var8, var9);
   }
}
