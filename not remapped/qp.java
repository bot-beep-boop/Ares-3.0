public class qp {
   private double e;
   private float b;
   private double f;
   private boolean d;
   private double g;
   private float c;
   private ps a;

   public void a() {
      this.a.z = 0.0F;
      if (this.d) {
         this.d = false;
         double var1 = this.e - this.a.s;
         double var3 = this.f - (this.a.t + (double)this.a.aS());
         double var5 = this.g - this.a.u;
         double var7 = (double)ns.a(var1 * var1 + var5 * var5);
         float var9 = (float)(ns.b(var5, var1) * 180.0D / 3.1415927410125732D) - 90.0F;
         float var10 = (float)(-(ns.b(var3, var7) * 180.0D / 3.1415927410125732D));
         this.a.z = this.a(this.a.z, var10, this.c);
         this.a.aK = this.a(this.a.aK, var9, this.b);
      } else {
         this.a.aK = this.a(this.a.aK, this.a.aI, 10.0F);
      }

      float var11 = ns.g(this.a.aK - this.a.aI);
      if (!this.a.s().m()) {
         if (var11 < -75.0F) {
            this.a.aK = this.a.aI - 75.0F;
         }

         if (var11 > 75.0F) {
            this.a.aK = this.a.aI + 75.0F;
         }
      }

   }

   public double e() {
      return this.e;
   }

   private float a(float var1, float var2, float var3) {
      float var4 = ns.g(var2 - var1);
      if (var4 > var3) {
         var4 = var3;
      }

      if (var4 < -var3) {
         var4 = -var3;
      }

      return var1 + var4;
   }

   public qp(ps var1) {
      this.a = var1;
   }

   public double g() {
      return this.g;
   }

   public boolean b() {
      return this.d;
   }

   public void a(double var1, double var3, double var5, float var7, float var8) {
      this.e = var1;
      this.f = var3;
      this.g = var5;
      this.b = var7;
      this.c = var8;
      this.d = true;
   }

   public void a(pk var1, float var2, float var3) {
      this.e = var1.s;
      if (var1 instanceof pr) {
         this.f = var1.t + (double)var1.aS();
      } else {
         this.f = (var1.aR().b + var1.aR().e) / 2.0D;
      }

      this.g = var1.u;
      this.b = var2;
      this.c = var3;
      this.d = true;
   }

   public double f() {
      return this.f;
   }
}
