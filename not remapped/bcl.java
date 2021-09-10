public class bcl extends bbo {
   private bct[] b;
   private bct[] a;

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      float var8 = ns.b(var3 * 0.1F);
      this.a[1].f = (0.065F + 0.05F * var8) * 3.1415927F;
      this.a[2].a(-2.0F, 6.9F + ns.b(this.a[1].f) * 10.0F, -0.5F + ns.a(this.a[1].f) * 10.0F);
      this.a[2].f = (0.265F + 0.1F * var8) * 3.1415927F;
      this.b[0].g = var4 / 57.295776F;
      this.b[0].f = var5 / 57.295776F;
   }

   public bcl(float var1) {
      this.t = 64;
      this.u = 64;
      this.a = new bct[3];
      this.a[0] = new bct(this, 0, 16);
      this.a[0].a(-10.0F, 3.9F, -0.5F, 20, 3, 3, var1);
      this.a[1] = (new bct(this)).b(this.t, this.u);
      this.a[1].a(-2.0F, 6.9F, -0.5F);
      this.a[1].a(0, 22).a(0.0F, 0.0F, 0.0F, 3, 10, 3, var1);
      this.a[1].a(24, 22).a(-4.0F, 1.5F, 0.5F, 11, 2, 2, var1);
      this.a[1].a(24, 22).a(-4.0F, 4.0F, 0.5F, 11, 2, 2, var1);
      this.a[1].a(24, 22).a(-4.0F, 6.5F, 0.5F, 11, 2, 2, var1);
      this.a[2] = new bct(this, 12, 22);
      this.a[2].a(0.0F, 0.0F, 0.0F, 3, 6, 3, var1);
      this.b = new bct[3];
      this.b[0] = new bct(this, 0, 0);
      this.b[0].a(-4.0F, -4.0F, -4.0F, 8, 8, 8, var1);
      this.b[1] = new bct(this, 32, 0);
      this.b[1].a(-4.0F, -4.0F, -4.0F, 6, 6, 6, var1);
      this.b[1].c = -8.0F;
      this.b[1].d = 4.0F;
      this.b[2] = new bct(this, 32, 0);
      this.b[2].a(-4.0F, -4.0F, -4.0F, 6, 6, 6, var1);
      this.b[2].c = 10.0F;
      this.b[2].d = 4.0F;
   }

   public void a(pr var1, float var2, float var3, float var4) {
      uk var5 = (uk)var1;

      for(int var6 = 1; var6 < 3; ++var6) {
         this.b[var6].g = (var5.a(var6 - 1) - var1.aI) / 57.295776F;
         this.b[var6].f = var5.b(var6 - 1) / 57.295776F;
      }

   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      bct[] var8 = this.b;
      int var9 = var8.length;

      int var10;
      bct var11;
      for(var10 = 0; var10 < var9; ++var10) {
         var11 = var8[var10];
         var11.a(var7);
      }

      var8 = this.a;
      var9 = var8.length;

      for(var10 = 0; var10 < var9; ++var10) {
         var11 = var8[var10];
         var11.a(var7);
      }

   }
}
