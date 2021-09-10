public class bef extends beb {
   private float a;
   private double az;
   private double aB;
   private double aA;

   public int b(float var1) {
      int var2 = super.b(var1);
      float var3 = (float)this.f / (float)this.g;
      var3 *= var3;
      var3 *= var3;
      int var4 = var2 & 255;
      int var5 = var2 >> 16 & 255;
      var5 += (int)(var3 * 15.0F * 16.0F);
      if (var5 > 240) {
         var5 = 240;
      }

      return var4 | var5 << 16;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.f + var3) / (float)this.g;
      var9 = 1.0F - var9;
      var9 *= var9;
      var9 = 1.0F - var9;
      this.h = this.a * var9;
      super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public float c(float var1) {
      float var2 = super.c(var1);
      float var3 = (float)this.f / (float)this.g;
      var3 = var3 * var3 * var3 * var3;
      return var2 * (1.0F - var3) + var3;
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      float var1 = (float)this.f / (float)this.g;
      float var2 = var1;
      var1 = -var1 + var1 * var1 * 2.0F;
      var1 = 1.0F - var1;
      this.s = this.az + this.v * (double)var1;
      this.t = this.aA + this.w * (double)var1 + (double)(1.0F - var2);
      this.u = this.aB + this.x * (double)var1;
      if (this.f++ >= this.g) {
         this.J();
      }

   }

   protected bef(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.v = var8;
      this.w = var10;
      this.x = var12;
      this.az = this.s = var2;
      this.aA = this.t = var4;
      this.aB = this.u = var6;
      float var14 = this.V.nextFloat() * 0.6F + 0.4F;
      this.a = this.h = this.V.nextFloat() * 0.2F + 0.5F;
      this.ar = this.as = this.at = 1.0F * var14;
      this.as *= 0.3F;
      this.ar *= 0.9F;
      this.g = (int)(Math.random() * 10.0D) + 40;
      this.T = true;
      this.k((int)(Math.random() * 8.0D));
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bef(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
