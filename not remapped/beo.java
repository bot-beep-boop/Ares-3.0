public class beo extends beb {
   private cj az;
   private alz a;

   protected beo(adm var1, double var2, double var4, double var6, double var8, double var10, double var12, alz var14) {
      super(var1, var2, var4, var6, var8, var10, var12);
      this.a = var14;
      this.a(ave.A().ae().a().a(var14));
      this.i = var14.c().I;
      this.ar = this.as = this.at = 0.6F;
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

   public int b(float var1) {
      int var2 = super.b(var1);
      int var3 = 0;
      if (this.o.e(this.az)) {
         var3 = this.o.b(this.az, 0);
      }

      return var2 == 0 ? var3 : var2;
   }

   public beo l() {
      this.az = new cj(this.s, this.t, this.u);
      afh var1 = this.a.c();
      if (var1 == afi.c) {
         return this;
      } else {
         int var2 = var1.h(this.a);
         this.ar *= (float)(var2 >> 16 & 255) / 255.0F;
         this.as *= (float)(var2 >> 8 & 255) / 255.0F;
         this.at *= (float)(var2 & 255) / 255.0F;
         return this;
      }
   }

   public int a() {
      return 1;
   }

   public beo a(cj var1) {
      this.az = var1;
      if (this.a.c() == afi.c) {
         return this;
      } else {
         int var2 = this.a.c().d((adq)this.o, var1);
         this.ar *= (float)(var2 >> 16 & 255) / 255.0F;
         this.as *= (float)(var2 >> 8 & 255) / 255.0F;
         this.at *= (float)(var2 & 255) / 255.0F;
         return this;
      }
   }

   public static class a implements bed {
      public beb a(int var1, adm var2, double var3, double var5, double var7, double var9, double var11, double var13, int... var15) {
         return (new beo(var2, var3, var5, var7, var9, var11, var13, afh.d(var15[0]))).l();
      }
   }
}
