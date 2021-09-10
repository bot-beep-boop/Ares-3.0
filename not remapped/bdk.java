public class bdk extends beb {
   protected bdk(adm var1, double var2, double var4, double var6, double var8, double var10, double var12, zw var14, int var15) {
      this(var1, var2, var4, var6, var14, var15);
      this.v *= 0.10000000149011612D;
      this.w *= 0.10000000149011612D;
      this.x *= 0.10000000149011612D;
      this.v += var8;
      this.w += var10;
      this.x += var12;
   }

   protected bdk(adm var1, double var2, double var4, double var6, zw var8, int var9) {
      super(var1, var2, var4, var6, 0.0D, 0.0D, 0.0D);
      this.a(ave.A().ag().a().a(var8, var9));
      this.ar = this.as = this.at = 1.0F;
      this.i = afi.aJ.I;
      this.h /= 2.0F;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.b + this.d / 4.0F) / 16.0F;
      float var10 = var9 + 0.015609375F;
      float var11 = ((float)this.c + this.e / 4.0F) / 16.0F;
      float var12 = var11 + 0.015609375F;
      float var13 = 0.1F * this.h;
      if (this.av != null) {
         var9 = this.av.a((double)(this.d / 4.0F * 16.0F));
         var10 = this.av.a((double)((this.d + 1.0F) / 4.0F * 16.0F));
         var11 = this.av.b((double)(this.e / 4.0F * 16.0F));
         var12 = this.av.b((double)((this.e + 1.0F) / 4.0F * 16.0F));
      }

      float var14 = (float)(this.p + (this.s - this.p) * (double)var3 - aw);
      float var15 = (float)(this.q + (this.t - this.q) * (double)var3 - ax);
      float var16 = (float)(this.r + (this.u - this.r) * (double)var3 - ay);
      int var17 = this.b(var3);
      int var18 = var17 >> 16 & '\uffff';
      int var19 = var17 & '\uffff';
      var1.b((double)(var14 - var4 * var13 - var7 * var13), (double)(var15 - var5 * var13), (double)(var16 - var6 * var13 - var8 * var13)).a((double)var9, (double)var12).a(this.ar, this.as, this.at, 1.0F).a(var18, var19).d();
      var1.b((double)(var14 - var4 * var13 + var7 * var13), (double)(var15 + var5 * var13), (double)(var16 - var6 * var13 + var8 * var13)).a((double)var9, (double)var11).a(this.ar, this.as, this.at, 1.0F).a(var18, var19).d();
      var1.b((double)(var14 + var4 * var13 + var7 * var13), (double)(var15 + var5 * var13), (double)(var16 + var6 * var13 + var8 * var13)).a((double)var10, (double)var11).a(this.ar, this.as, this.at, 1.0F).a(var18, var19).d();
      var1.b((double)(var14 + var4 * var13 - var7 * var13), (double)(var15 - var5 * var13), (double)(var16 + var6 * var13 - var8 * var13)).a((double)var10, (double)var12).a(this.ar, this.as, this.at, 1.0F).a(var18, var19).d();
   }

   protected bdk(adm var1, double var2, double var4, double var6, zw var8) {
      this(var1, var2, var4, var6, var8, 0);
   }

   public int a() {
      return 1;
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         int var16 = var15.length > 1 ? var15[1] : 0;
         return new bdk(var2, var3, var5, var7, var9, var11, var13, zw.b(var15[0]), var16);
      }
   }

   public static class b implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdk(var2, var3, var5, var7, zy.aM);
      }
   }

   public static class c implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return new bdk(var2, var3, var5, var7, zy.aD);
      }
   }
}
