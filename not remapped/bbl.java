public class bbl extends bbo {
   bct[] a = new bct[8];
   bct b;

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      this.b.a(var7);

      for(int var8 = 0; var8 < this.a.length; ++var8) {
         this.a[var8].a(var7);
      }

   }

   public void a(pr var1, float var2, float var3, float var4) {
      vu var5 = (vu)var1;
      float var6 = var5.c + (var5.b - var5.c) * var4;
      if (var6 < 0.0F) {
         var6 = 0.0F;
      }

      for(int var7 = 0; var7 < this.a.length; ++var7) {
         this.a[var7].d = (float)(-(4 - var7)) * var6 * 1.7F;
      }

   }

   public bbl() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         byte var2 = 0;
         int var3 = var1;
         if (var1 == 2) {
            var2 = 24;
            var3 = 10;
         } else if (var1 == 3) {
            var2 = 24;
            var3 = 19;
         }

         this.a[var1] = new bct(this, var2, var3);
         this.a[var1].a(-4.0F, (float)(16 + var1), -4.0F, 8, 1, 8);
      }

      this.b = new bct(this, 0, 16);
      this.b.a(-2.0F, 18.0F, -2.0F, 4, 4, 4);
   }
}
