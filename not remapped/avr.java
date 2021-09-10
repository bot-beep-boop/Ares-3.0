public class avr {
   private int d;
   private final double b;
   private int c;
   private int e;
   private final double a;

   public int b() {
      return this.d;
   }

   public int a() {
      return this.c;
   }

   public double c() {
      return this.a;
   }

   public double d() {
      return this.b;
   }

   public avr(ave var1) {
      this.c = var1.d;
      this.d = var1.e;
      this.e = 1;
      boolean var2 = var1.d();
      int var3 = var1.t.aL;
      if (var3 == 0) {
         var3 = 1000;
      }

      while(this.e < var3 && this.c / (this.e + 1) >= 320 && this.d / (this.e + 1) >= 240) {
         ++this.e;
      }

      if (var2 && this.e % 2 != 0 && this.e != 1) {
         --this.e;
      }

      this.a = (double)this.c / (double)this.e;
      this.b = (double)this.d / (double)this.e;
      this.c = ns.f(this.a);
      this.d = ns.f(this.b);
   }

   public int e() {
      return this.e;
   }
}
