public class bdw extends beb {
   private int aA;
   private pk a;
   private int aB;
   private pk az;
   private float aC;
   private biu aD = ave.A().af();

   public int a() {
      return 3;
   }

   public bdw(adm var1, pk var2, pk var3, float var4) {
      super(var1, var2.s, var2.t, var2.u, var2.v, var2.w, var2.x);
      this.a = var2;
      this.az = var3;
      this.aB = 3;
      this.aC = var4;
   }

   public void a(bfd var1, pk var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = ((float)this.aA + var3) / (float)this.aB;
      var9 *= var9;
      double var10 = this.a.s;
      double var12 = this.a.t;
      double var14 = this.a.u;
      double var16 = this.az.P + (this.az.s - this.az.P) * (double)var3;
      double var18 = this.az.Q + (this.az.t - this.az.Q) * (double)var3 + (double)this.aC;
      double var20 = this.az.R + (this.az.u - this.az.R) * (double)var3;
      double var22 = var10 + (var16 - var10) * (double)var9;
      double var24 = var12 + (var18 - var12) * (double)var9;
      double var26 = var14 + (var20 - var14) * (double)var9;
      int var28 = this.b(var3);
      int var29 = var28 % 65536;
      int var30 = var28 / 65536;
      bqs.a(bqs.r, (float)var29 / 1.0F, (float)var30 / 1.0F);
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      var22 -= aw;
      var24 -= ax;
      var26 -= ay;
      this.aD.a(this.a, (double)((float)var22), (double)((float)var24), (double)((float)var26), this.a.y, var3);
   }

   public void t_() {
      ++this.aA;
      if (this.aA == this.aB) {
         this.J();
      }

   }
}
