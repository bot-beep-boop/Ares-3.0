public class bdt extends beb {
   float a;

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.f++ >= this.g) {
         this.J();
      }

      this.d(this.v, this.w, this.x);
      if (this.t == this.q) {
         this.v *= 1.1D;
         this.x *= 1.1D;
      }

      this.v *= 0.8600000143051147D;
      this.w *= 0.8600000143051147D;
      this.x *= 0.8600000143051147D;
      if (this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

   }

   protected bdt(adm var1, double var2, double var4, double var6, double var8, double var10, double var12, float var14) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.v *= 0.009999999776482582D;
      this.w *= 0.009999999776482582D;
      this.x *= 0.009999999776482582D;
      this.w += 0.1D;
      this.h *= 0.75F;
      this.h *= var14;
      this.a = this.h;
      this.g = 16;
      this.T = false;
      this.k(80);
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.f + var3) / (float)this.g * 32.0F;
      var9 = ns.a(var9, 0.0F, 1.0F);
      this.h = this.a * var9;
      super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   protected bdt(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      this(var1, var2, var4, var6, var8, var10, var12, 2.0F);
   }

   public static class b implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdt(var2, var3, var5, var7, var9, var11, var13);
      }
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         bdt var16 = new bdt(var2, var3, var5 + 0.5D, var7, var9, var11, var13);
         var16.k(81);
         var16.b(1.0F, 1.0F, 1.0F);
         return var16;
      }
   }
}
