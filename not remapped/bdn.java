public class bdn extends beb {
   private int az;
   private arm a;

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.a == arm.h) {
         this.ar = 0.2F;
         this.as = 0.3F;
         this.at = 1.0F;
      } else {
         this.ar = 1.0F;
         this.as = 16.0F / (float)(40 - this.az + 16);
         this.at = 4.0F / (float)(40 - this.az + 8);
      }

      this.w -= (double)this.i;
      if (this.az-- > 0) {
         this.v *= 0.02D;
         this.w *= 0.02D;
         this.x *= 0.02D;
         this.k(113);
      } else {
         this.k(112);
      }

      this.d(this.v, this.w, this.x);
      this.v *= 0.9800000190734863D;
      this.w *= 0.9800000190734863D;
      this.x *= 0.9800000190734863D;
      if (this.g-- <= 0) {
         this.J();
      }

      if (this.C) {
         if (this.a == arm.h) {
            this.J();
            this.o.a(cy.f, this.s, this.t, this.u, 0.0D, 0.0D, 0.0D);
         } else {
            this.k(114);
         }

         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

      cj var1 = new cj(this);
      alz var2 = this.o.p(var1);
      arm var3 = var2.c().t();
      if (var3.d() || var3.a()) {
         double var4 = 0.0D;
         if (var2.c() instanceof ahv) {
            var4 = (double)ahv.b((Integer)var2.b(ahv.b));
         }

         double var6 = (double)(ns.c(this.t) + 1) - var4;
         if (this.t < var6) {
            this.J();
         }
      }

   }

   public float c(float var1) {
      return this.a == arm.h ? super.c(var1) : 1.0F;
   }

   public int b(float var1) {
      return this.a == arm.h ? super.b(var1) : 257;
   }

   protected bdn(adm var1, double var2, double var4, double var6, arm var8) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.v = this.w = this.x = 0.0D;
      if (var8 == arm.h) {
         this.ar = 0.0F;
         this.as = 0.0F;
         this.at = 1.0F;
      } else {
         this.ar = 1.0F;
         this.as = 0.0F;
         this.at = 0.0F;
      }

      this.k(113);
      this.a(0.01F, 0.01F);
      this.i = 0.06F;
      this.a = var8;
      this.az = 40;
      this.g = (int)(64.0D / (Math.random() * 0.8D + 0.2D));
      this.v = this.w = this.x = 0.0D;
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdn(var2, var3, var5, var7, arm.i);
      }
   }

   public static class b implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdn(var2, var3, var5, var7, arm.h);
      }
   }
}
