public class bel extends beb {
   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.d(this.v, this.w, this.x);
      if (this.o.p(new cj(this)).c().t() != arm.h) {
         this.J();
      }

      if (this.g-- <= 0) {
         this.J();
      }

   }

   protected bel(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4 - 0.125D, var6, var8, var10, var12);
      this.ar = 0.4F;
      this.as = 0.4F;
      this.at = 0.7F;
      this.k(0);
      this.a(0.01F, 0.01F);
      this.h *= this.V.nextFloat() * 0.6F + 0.2F;
      this.v = var8 * 0.0D;
      this.w = var10 * 0.0D;
      this.x = var12 * 0.0D;
      this.g = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bel(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
