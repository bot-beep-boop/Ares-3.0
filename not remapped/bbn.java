public class bbn extends bbo {
   public bct[] a = new bct[7];

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a[5].d = 4.0F - var4;

      for(int var8 = 0; var8 < 6; ++var8) {
         this.a[var8].a(var7);
      }

   }

   public bbn() {
      this.a[0] = new bct(this, 0, 10);
      this.a[1] = new bct(this, 0, 0);
      this.a[2] = new bct(this, 0, 0);
      this.a[3] = new bct(this, 0, 0);
      this.a[4] = new bct(this, 0, 0);
      this.a[5] = new bct(this, 44, 10);
      byte var1 = 20;
      byte var2 = 8;
      byte var3 = 16;
      byte var4 = 4;
      this.a[0].a((float)(-var1 / 2), (float)(-var3 / 2), -1.0F, var1, var3, 2, 0.0F);
      this.a[0].a(0.0F, (float)var4, 0.0F);
      this.a[5].a((float)(-var1 / 2 + 1), (float)(-var3 / 2 + 1), -1.0F, var1 - 2, var3 - 2, 1, 0.0F);
      this.a[5].a(0.0F, (float)var4, 0.0F);
      this.a[1].a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.a[1].a((float)(-var1 / 2 + 1), (float)var4, 0.0F);
      this.a[2].a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.a[2].a((float)(var1 / 2 - 1), (float)var4, 0.0F);
      this.a[3].a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.a[3].a(0.0F, (float)var4, (float)(-var3 / 2 + 1));
      this.a[4].a((float)(-var1 / 2 + 2), (float)(-var2 - 1), -1.0F, var1 - 4, var2, 2, 0.0F);
      this.a[4].a(0.0F, (float)var4, (float)(var3 / 2 - 1));
      this.a[0].f = 1.5707964F;
      this.a[1].g = 4.712389F;
      this.a[2].g = 1.5707964F;
      this.a[3].g = 3.1415927F;
      this.a[5].f = -1.5707964F;
   }
}
