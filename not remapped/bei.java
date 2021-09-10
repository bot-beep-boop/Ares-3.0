public class bei extends beb {
   float a;

   protected bei(adm var1, double var2, double var4, double var6, double var8, double var10, double var12, float var14) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.v *= 0.10000000149011612D;
      this.w *= 0.10000000149011612D;
      this.x *= 0.10000000149011612D;
      this.v += var8;
      this.w += var10;
      this.x += var12;
      this.ar = this.as = this.at = 1.0F - (float)(Math.random() * 0.30000001192092896D);
      this.h *= 0.75F;
      this.h *= var14;
      this.a = this.h;
      this.g = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.g = (int)((float)this.g * var14);
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
      this.w -= 0.03D;
      this.d(this.v, this.w, this.x);
      this.v *= 0.9900000095367432D;
      this.w *= 0.9900000095367432D;
      this.x *= 0.9900000095367432D;
      if (this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
      }

   }

   protected bei(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      this(var1, var2, var4, var6, var8, var10, var12, 1.0F);
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.f + var3) / (float)this.g * 32.0F;
      var9 = ns.a(var9, 0.0F, 1.0F);
      this.h = this.a * var9;
      super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bei(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
