public class bdr extends beb {
   private float a;

   public float c(float var1) {
      float var2 = ((float)this.f + var1) / (float)this.g;
      var2 = ns.a(var2, 0.0F, 1.0F);
      float var3 = super.c(var1);
      return var3 * var2 + (1.0F - var2);
   }

   public int b(float var1) {
      float var2 = ((float)this.f + var1) / (float)this.g;
      var2 = ns.a(var2, 0.0F, 1.0F);
      int var3 = super.b(var1);
      int var4 = var3 & 255;
      int var5 = var3 >> 16 & 255;
      var4 += (int)(var2 * 15.0F * 16.0F);
      if (var4 > 240) {
         var4 = 240;
      }

      return var4 | var5 << 16;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.f + var3) / (float)this.g;
      this.h = this.a * (1.0F - var9 * var9 * 0.5F);
      super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   protected bdr(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.v = this.v * 0.009999999776482582D + var8;
      this.w = this.w * 0.009999999776482582D + var10;
      this.x = this.x * 0.009999999776482582D + var12;
      this.s += (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.05F);
      this.t += (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.05F);
      this.u += (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.05F);
      this.a = this.h;
      this.ar = this.as = this.at = 1.0F;
      this.g = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
      this.T = true;
      this.k(48);
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.f++ >= this.g) {
         this.J();
      }

      this.d(this.v, this.w, this.x);
      this.v *= 0.9599999785423279D;
      this.w *= 0.9599999785423279D;
      this.x *= 0.9599999785423279D;
      if (this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdr(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
