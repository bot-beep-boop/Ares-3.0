public class ann extends anm {
   public String k() {
      return "Nether";
   }

   public aui b(float var1, float var2) {
      return new aui(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
   }

   protected void a() {
      float var1 = 0.1F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   public float a(long var1, float var3) {
      return 0.5F;
   }

   public boolean b(int var1, int var2) {
      return true;
   }

   public void b() {
      this.c = new aef(ady.x, 0.0F);
      this.d = true;
      this.e = true;
      this.g = -1;
   }

   public ams r() {
      return new ams(this) {
         final ann a;

         public double g() {
            return super.g() / 8.0D;
         }

         {
            this.a = var1;
         }

         public double f() {
            return super.f() / 8.0D;
         }
      };
   }

   public boolean a(int var1, int var2) {
      return false;
   }

   public boolean d() {
      return false;
   }

   public amv c() {
      return new anw(this.b, this.b.P().s(), this.b.J());
   }

   public boolean e() {
      return false;
   }

   public String l() {
      return "_nether";
   }
}
