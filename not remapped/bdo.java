public class bdo extends beb {
   private double az;
   private double aB;
   private double aA;
   private float a;

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

   protected bdo(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.v = var8;
      this.w = var10;
      this.x = var12;
      this.az = var2;
      this.aA = var4;
      this.aB = var6;
      this.s = this.p = var2 + var8;
      this.t = this.q = var4 + var10;
      this.u = this.r = var6 + var12;
      float var14 = this.V.nextFloat() * 0.6F + 0.4F;
      this.a = this.h = this.V.nextFloat() * 0.5F + 0.2F;
      this.ar = this.as = this.at = 1.0F * var14;
      this.as *= 0.9F;
      this.ar *= 0.9F;
      this.g = (int)(Math.random() * 10.0D) + 30;
      this.T = true;
      this.k((int)(Math.random() * 26.0D + 1.0D + 224.0D));
   }

   public float c(float var1) {
      float var2 = super.c(var1);
      float var3 = (float)this.f / (float)this.g;
      var3 *= var3;
      var3 *= var3;
      return var2 * (1.0F - var3) + var3;
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      float var1 = (float)this.f / (float)this.g;
      var1 = 1.0F - var1;
      float var2 = 1.0F - var1;
      var2 *= var2;
      var2 *= var2;
      this.s = this.az + this.v * (double)var1;
      this.t = this.aA + this.w * (double)var1 - (double)(var2 * 1.2F);
      this.u = this.aB + this.x * (double)var1;
      if (this.f++ >= this.g) {
         this.J();
      }

   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdo(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
