import java.util.Random;

public class bbf extends bbo {
   bct[] b = new bct[9];
   bct a;

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      for(int var8 = 0; var8 < this.b.length; ++var8) {
         this.b[var8].f = 0.2F * ns.a(var3 * 0.3F + (float)var8) + 0.4F;
      }

   }

   public bbf() {
      byte var1 = -16;
      this.a = new bct(this, 0, 0);
      this.a.a(-8.0F, -8.0F, -8.0F, 16, 16, 16);
      bct var10000 = this.a;
      var10000.d += (float)(24 + var1);
      Random var2 = new Random(1660L);

      for(int var3 = 0; var3 < this.b.length; ++var3) {
         this.b[var3] = new bct(this, 0, 0);
         float var4 = (((float)(var3 % 3) - (float)(var3 / 3 % 2) * 0.5F + 0.25F) / 2.0F * 2.0F - 1.0F) * 5.0F;
         float var5 = ((float)(var3 / 3) / 2.0F * 2.0F - 1.0F) * 5.0F;
         int var6 = var2.nextInt(7) + 8;
         this.b[var3].a(-1.0F, 0.0F, -1.0F, 2, var6, 2);
         this.b[var3].c = var4;
         this.b[var3].e = var5;
         this.b[var3].d = (float)(31 + var1);
      }

   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      bfl.E();
      bfl.b(0.0F, 0.6F, 0.0F);
      this.a.a(var7);
      bct[] var8 = this.b;
      int var9 = var8.length;

      for(int var10 = 0; var10 < var9; ++var10) {
         bct var11 = var8[var10];
         var11.a(var7);
      }

      bfl.F();
   }
}
