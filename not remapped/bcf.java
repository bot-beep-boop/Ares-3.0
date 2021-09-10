public class bcf extends bbo {
   bct[] b = new bct[8];
   bct a;

   public bcf() {
      byte var1 = -16;
      this.a = new bct(this, 0, 0);
      this.a.a(-6.0F, -8.0F, -6.0F, 12, 16, 12);
      bct var10000 = this.a;
      var10000.d += (float)(24 + var1);

      for(int var2 = 0; var2 < this.b.length; ++var2) {
         this.b[var2] = new bct(this, 48, 0);
         double var3 = (double)var2 * 3.141592653589793D * 2.0D / (double)this.b.length;
         float var5 = (float)Math.cos(var3) * 5.0F;
         float var6 = (float)Math.sin(var3) * 5.0F;
         this.b[var2].a(-1.0F, 0.0F, -1.0F, 2, 18, 2);
         this.b[var2].c = var5;
         this.b[var2].e = var6;
         this.b[var2].d = (float)(31 + var1);
         var3 = (double)var2 * 3.141592653589793D * -2.0D / (double)this.b.length + 1.5707963267948966D;
         this.b[var2].g = (float)var3;
      }

   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      bct[] var8 = this.b;
      int var9 = var8.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         bct var11 = var8[var10];
         var11.f = var3;
      }

   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      this.a.a(var7);

      for(int var8 = 0; var8 < this.b.length; ++var8) {
         this.b[var8].a(var7);
      }

   }
}
