public class ber extends beb {
   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.w -= (double)this.i;
      this.d(this.v, this.w, this.x);
      this.v *= 0.9800000190734863D;
      this.w *= 0.9800000190734863D;
      this.x *= 0.9800000190734863D;
      if (this.g-- <= 0) {
         this.J();
      }

      if (this.C) {
         if (Math.random() < 0.5D) {
            this.J();
         }

         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

      cj var1 = new cj(this);
      alz var2 = this.o.p(var1);
      afh var3 = var2.c();
      var3.a((adq)this.o, (cj)var1);
      arm var4 = var2.c().t();
      if (var4.d() || var4.a()) {
         double var5 = 0.0D;
         if (var2.c() instanceof ahv) {
            var5 = (double)(1.0F - ahv.b((Integer)var2.b(ahv.b)));
         } else {
            var5 = var3.E();
         }

         double var7 = (double)ns.c(this.t) + var5;
         if (this.t < var7) {
            this.J();
         }
      }

   }

   protected ber(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.v *= 0.30000001192092896D;
      this.w = Math.random() * 0.20000000298023224D + 0.10000000149011612D;
      this.x *= 0.30000001192092896D;
      this.ar = 1.0F;
      this.as = 1.0F;
      this.at = 1.0F;
      this.k(19 + this.V.nextInt(4));
      this.a(0.01F, 0.01F);
      this.i = 0.06F;
      this.g = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new ber(var2, var3, var5, var7);
      }
   }
}
