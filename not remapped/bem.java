public class bem extends beb {
   protected bem(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      float var14 = this.V.nextFloat() * 0.1F + 0.2F;
      this.ar = var14;
      this.as = var14;
      this.at = var14;
      this.k(0);
      this.a(0.02F, 0.02F);
      this.h *= this.V.nextFloat() * 0.6F + 0.5F;
      this.v *= 0.019999999552965164D;
      this.w *= 0.019999999552965164D;
      this.x *= 0.019999999552965164D;
      this.g = (int)(20.0D / (Math.random() * 0.8D + 0.2D));
      this.T = true;
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.d(this.v, this.w, this.x);
      this.v *= 0.99D;
      this.w *= 0.99D;
      this.x *= 0.99D;
      if (this.g-- <= 0) {
         this.J();
      }

   }

   public static class b implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bem(var2, var3, var5, var7, var9, var11, var13);
      }
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         bem var16 = new bem(var2, var3, var5, var7, var9, var11, var13);
         var16.k(82);
         var16.b(1.0F, 1.0F, 1.0F);
         return var16;
      }
   }
}
