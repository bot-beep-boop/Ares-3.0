public class bdp extends beb {
   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.f++ >= this.g) {
         this.J();
      }

      this.k(7 - this.f * 8 / this.g);
      this.w += 0.004D;
      this.d(this.v, this.w, this.x);
      this.v *= 0.8999999761581421D;
      this.w *= 0.8999999761581421D;
      this.x *= 0.8999999761581421D;
      if (this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

   }

   protected bdp(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.v = var8 + (Math.random() * 2.0D - 1.0D) * 0.05000000074505806D;
      this.w = var10 + (Math.random() * 2.0D - 1.0D) * 0.05000000074505806D;
      this.x = var12 + (Math.random() * 2.0D - 1.0D) * 0.05000000074505806D;
      this.ar = this.as = this.at = this.V.nextFloat() * 0.3F + 0.7F;
      this.h = this.V.nextFloat() * this.V.nextFloat() * 6.0F + 1.0F;
      this.g = (int)(16.0D / ((double)this.V.nextFloat() * 0.8D + 0.2D)) + 2;
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdp(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
