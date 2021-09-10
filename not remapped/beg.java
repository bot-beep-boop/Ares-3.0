public class beg extends beb {
   float a;

   protected beg(adm var1, double var2, double var4, double var6, float var8, float var9, float var10) {
      this(var1, var2, var4, var6, 1.0F, var8, var9, var10);
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.f + var3) / (float)this.g * 32.0F;
      var9 = ns.a(var9, 0.0F, 1.0F);
      this.h = this.a * var9;
      super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   protected beg(adm var1, double var2, double var4, double var6, float var8, float var9, float var10, float var11) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.v *= 0.10000000149011612D;
      this.w *= 0.10000000149011612D;
      this.x *= 0.10000000149011612D;
      if (var9 == 0.0F) {
         var9 = 1.0F;
      }

      float var12 = (float)Math.random() * 0.4F + 0.6F;
      this.ar = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * var9 * var12;
      this.as = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * var10 * var12;
      this.at = ((float)(Math.random() * 0.20000000298023224D) + 0.8F) * var11 * var12;
      this.h *= 0.75F;
      this.h *= var8;
      this.a = this.h;
      this.g = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.g = (int)((float)this.g * var8);
      this.T = false;
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      if (this.f++ >= this.g) {
         this.J();
      }

      this.k(7 - this.f * 8 / this.g);
      this.d(this.v, this.w, this.x);
      if (this.t == this.q) {
         this.v *= 1.1D;
         this.x *= 1.1D;
      }

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
         return new beg(var2, var3, var5, var7, (float)var9, (float)var11, (float)var13);
      }
   }
}
