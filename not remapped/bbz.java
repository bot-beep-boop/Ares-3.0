public class bbz extends bbo {
   public bct a;

   public void a(float var1, float var2, float var3, float var4, float var5, float var6, pk var7) {
      super.a(var1, var2, var3, var4, var5, var6, var7);
      this.a.g = var4 / 57.295776F;
      this.a.f = var5 / 57.295776F;
   }

   public void a(pk var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      this.a(var2, var3, var4, var5, var6, var7, var1);
      this.a.a(var7);
   }

   public bbz() {
      this(0, 35, 64, 64);
   }

   public bbz(int var1, int var2, int var3, int var4) {
      this.t = var3;
      this.u = var4;
      this.a = new bct(this, var1, var2);
      this.a.a(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
      this.a.a(0.0F, 0.0F, 0.0F);
   }
}
