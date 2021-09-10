public class beq extends beb {
   protected beq(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.v *= 0.30000001192092896D;
      this.w = Math.random() * 0.20000000298023224D + 0.10000000149011612D;
      this.x *= 0.30000001192092896D;
      this.ar = 1.0F;
      this.as = 1.0F;
      this.at = 1.0F;
      this.k(19);
      this.a(0.01F, 0.01F);
      this.g = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.i = 0.0F;
      this.v = var8;
      this.w = var10;
      this.x = var12;
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.w -= (double)this.i;
      this.d(this.v, this.w, this.x);
      this.v *= 0.9800000190734863D;
      this.w *= 0.9800000190734863D;
      this.x *= 0.9800000190734863D;
      int var1 = 60 - this.g;
      float var2 = (float)var1 * 0.001F;
      this.a(var2, var2);
      this.k(19 + var1 % 4);
      if (this.g-- <= 0) {
         this.J();
      }

   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new beq(var2, var3, var5, var7, var9, var11, var13);
      }
   }
}
