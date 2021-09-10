public class bdy extends beb {
   private float a;

   protected bdy(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.v *= 0.800000011920929D;
      this.w *= 0.800000011920929D;
      this.x *= 0.800000011920929D;
      this.w = (double)(this.V.nextFloat() * 0.4F + 0.05F);
      this.ar = this.as = this.at = 1.0F;
      this.h *= this.V.nextFloat() * 2.0F + 0.2F;
      this.a = this.h;
      this.g = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
      this.T = false;
      this.k(49);
   }

   public float c(float var1) {
      return 1.0F;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.f + var3) / (float)this.g;
      this.h = this.a * (1.0F - var9 * var9);
      super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.f++ >= this.g) {
         this.J();
      }

      float var1 = (float)this.f / (float)this.g;
      if (this.V.nextFloat() > var1) {
         this.o.a(cy.l, this.s, this.t, this.u, this.v, this.w, this.x);
      }

      this.w -= 0.03D;
      this.d(this.v, this.w, this.x);
      this.v *= 0.9990000128746033D;
      this.w *= 0.9990000128746033D;
      this.x *= 0.9990000128746033D;
      if (this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

   }

   public int b(float var1) {
      float var2 = ((float)this.f + var1) / (float)this.g;
      var2 = ns.a(var2, 0.0F, 1.0F);
      int var3 = super.b(var1);
      short var4 = 240;
      int var5 = var3 >> 16 & 255;
      return var4 | var5 << 16;
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdy(var2, var3, var5, var7);
      }
   }
}
