public class bdj extends beb {
   protected bdj(adm var1, double var2, double var4, double var6, zw var8) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.a(ave.A().ag().a().a(var8));
      this.ar = this.as = this.at = 1.0F;
      this.v = this.w = this.x = 0.0D;
      this.i = 0.0F;
      this.g = 80;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = this.av.e();
      float var10 = this.av.f();
      float var11 = this.av.g();
      float var12 = this.av.h();
      float var13 = 0.5F;
      float var14 = (float)(this.p + (this.s - this.p) * (double)var3 - aw);
      float var15 = (float)(this.q + (this.t - this.q) * (double)var3 - ax);
      float var16 = (float)(this.r + (this.u - this.r) * (double)var3 - ay);
      int var17 = this.b(var3);
      int var18 = var17 >> 16 & '\uffff';
      int var19 = var17 & '\uffff';
      var1.b((double)(var14 - var4 * 0.5F - var7 * 0.5F), (double)(var15 - var5 * 0.5F), (double)(var16 - var6 * 0.5F - var8 * 0.5F)).a((double)var10, (double)var12).a(this.ar, this.as, this.at, 1.0F).a(var18, var19).d();
      var1.b((double)(var14 - var4 * 0.5F + var7 * 0.5F), (double)(var15 + var5 * 0.5F), (double)(var16 - var6 * 0.5F + var8 * 0.5F)).a((double)var10, (double)var11).a(this.ar, this.as, this.at, 1.0F).a(var18, var19).d();
      var1.b((double)(var14 + var4 * 0.5F + var7 * 0.5F), (double)(var15 + var5 * 0.5F), (double)(var16 + var6 * 0.5F + var8 * 0.5F)).a((double)var9, (double)var11).a(this.ar, this.as, this.at, 1.0F).a(var18, var19).d();
      var1.b((double)(var14 + var4 * 0.5F - var7 * 0.5F), (double)(var15 - var5 * 0.5F), (double)(var16 + var6 * 0.5F - var8 * 0.5F)).a((double)var9, (double)var12).a(this.ar, this.as, this.at, 1.0F).a(var18, var19).d();
   }

   public int a() {
      return 1;
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdj(var2, var3, var5, var7, zw.a(afi.cv));
      }
   }
}
