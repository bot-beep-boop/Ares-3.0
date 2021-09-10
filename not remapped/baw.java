public class baw extends bbo {
   private bct b;
   private bct[] a = new bct[12];

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      this.b.a(var7);

      for(int var8 = 0; var8 < this.a.length; ++var8) {
         this.a[var8].a(var7);
      }

   }

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      float var8 = var3 * 3.1415927F * -0.1F;

      int var9;
      for(var9 = 0; var9 < 4; ++var9) {
         this.a[var9].d = -2.0F + ns.b(((float)(var9 * 2) + var3) * 0.25F);
         this.a[var9].c = ns.b(var8) * 9.0F;
         this.a[var9].e = ns.a(var8) * 9.0F;
         ++var8;
      }

      var8 = 0.7853982F + var3 * 3.1415927F * 0.03F;

      for(var9 = 4; var9 < 8; ++var9) {
         this.a[var9].d = 2.0F + ns.b(((float)(var9 * 2) + var3) * 0.25F);
         this.a[var9].c = ns.b(var8) * 7.0F;
         this.a[var9].e = ns.a(var8) * 7.0F;
         ++var8;
      }

      var8 = 0.47123894F + var3 * 3.1415927F * -0.05F;

      for(var9 = 8; var9 < 12; ++var9) {
         this.a[var9].d = 11.0F + ns.b(((float)var9 * 1.5F + var3) * 0.5F);
         this.a[var9].c = ns.b(var8) * 5.0F;
         this.a[var9].e = ns.a(var8) * 5.0F;
         ++var8;
      }

      this.b.g = var4 / 57.295776F;
      this.b.f = var5 / 57.295776F;
   }

   public baw() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = new bct(this, 0, 16);
         this.a[var1].a(0.0F, 0.0F, 0.0F, 2, 8, 2);
      }

      this.b = new bct(this, 0, 0);
      this.b.a(-4.0F, -4.0F, -4.0F, 8, 8, 8);
   }
}
