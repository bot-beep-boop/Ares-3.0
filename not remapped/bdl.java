public class bdl extends beb {
   protected bdl(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.ar = 1.0F;
      this.as = 1.0F;
      this.at = 1.0F;
      this.k(32);
      this.a(0.02F, 0.02F);
      this.h *= this.V.nextFloat() * 0.6F + 0.2F;
      this.v = var8 * 0.20000000298023224D + (Math.random() * 2.0D - 1.0D) * 0.019999999552965164D;
      this.w = var10 * 0.20000000298023224D + (Math.random() * 2.0D - 1.0D) * 0.019999999552965164D;
      this.x = var12 * 0.20000000298023224D + (Math.random() * 2.0D - 1.0D) * 0.019999999552965164D;
      this.g = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.w += 0.002D;
      this.d(this.v, this.w, this.x);
      this.v *= 0.8500000238418579D;
      this.w *= 0.8500000238418579D;
      this.x *= 0.8500000238418579D;
      if (this.o.p(new cj(this)).c().t() != arm.h) {
         this.J();
      }

      if (this.g-- <= 0) {
         this.J();
      }

   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdl(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
