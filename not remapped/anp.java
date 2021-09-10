public class anp extends anm {
   public boolean e() {
      return false;
   }

   public aui b(float var1, float var2) {
      int var3 = 10518688;
      float var4 = ns.b(var1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
      var4 = ns.a(var4, 0.0F, 1.0F);
      float var5 = (float)(var3 >> 16 & 255) / 255.0F;
      float var6 = (float)(var3 >> 8 & 255) / 255.0F;
      float var7 = (float)(var3 & 255) / 255.0F;
      var5 *= var4 * 0.0F + 0.15F;
      var6 *= var4 * 0.0F + 0.15F;
      var7 *= var4 * 0.0F + 0.15F;
      return new aui((double)var5, (double)var6, (double)var7);
   }

   public boolean g() {
      return false;
   }

   public cj h() {
      return new cj(100, 50, 0);
   }

   public amv c() {
      return new aob(this.b, this.b.J());
   }

   public void b() {
      this.c = new aef(ady.y, 0.0F);
      this.g = 1;
      this.e = true;
   }

   public int i() {
      return 50;
   }

   public float a(long var1, float var3) {
      return 0.0F;
   }

   public String l() {
      return "_end";
   }

   public boolean a(int var1, int var2) {
      return this.b.c(new cj(var1, 0, var2)).t().c();
   }

   public String k() {
      return "The End";
   }

   public float f() {
      return 8.0F;
   }

   public boolean d() {
      return false;
   }

   public boolean b(int var1, int var2) {
      return true;
   }

   public float[] a(float var1, float var2) {
      return null;
   }
}
