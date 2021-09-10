public class bdm extends beb {
   float a;

   protected bdm(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      this(var1, var2, var4, var6, var8, var10, var12, 1.0F);
   }

   protected bdm(adm var1, double var2, double var4, double var6, double var8, double var10, double var12, float var14) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.v *= 0.10000000149011612D;
      this.w *= 0.10000000149011612D;
      this.x *= 0.10000000149011612D;
      this.v += var8 * 0.4D;
      this.w += var10 * 0.4D;
      this.x += var12 * 0.4D;
      this.ar = this.as = this.at = (float)(Math.random() * 0.30000001192092896D + 0.6000000238418579D);
      this.h *= 0.75F;
      this.h *= var14;
      this.a = this.h;
      this.g = (int)(6.0D / (Math.random() * 0.8D + 0.6D));
      this.g = (int)((float)this.g * var14);
      this.T = false;
      this.k(65);
      this.t_();
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.f++ >= this.g) {
         this.J();
      }

      this.d(this.v, this.w, this.x);
      this.as = (float)((double)this.as * 0.96D);
      this.at = (float)((double)this.at * 0.9D);
      this.v *= 0.699999988079071D;
      this.w *= 0.699999988079071D;
      this.x *= 0.699999988079071D;
      this.w -= 0.019999999552965164D;
      if (this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.f + var3) / (float)this.g * 32.0F;
      var9 = ns.a(var9, 0.0F, 1.0F);
      this.h = this.a * var9;
      super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         bdm var16 = new bdm(var2, var3, var5, var7, var9, var11, var13);
         var16.b(var16.b() * 0.3F, var16.g() * 0.8F, var16.i());
         var16.k();
         return var16;
      }
   }

   public static class b implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdm(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
