public class rz extends rd {
   private double c;
   private py a;
   private int f;
   private double e;
   private double d;
   private double b;
   private boolean g;

   public boolean b() {
      return !this.a.s().m();
   }

   public rz(py var1, double var2) {
      this(var1, var2, 120);
   }

   public rz(py var1, double var2, int var4) {
      this.a = var1;
      this.e = var2;
      this.f = var4;
      this.a(1);
   }

   public void b(int var1) {
      this.f = var1;
   }

   public void c() {
      this.a.s().a(this.b, this.c, this.d, this.e);
   }

   public boolean a() {
      if (!this.g) {
         if (this.a.bh() >= 100) {
            return false;
         }

         if (this.a.bc().nextInt(this.f) != 0) {
            return false;
         }
      }

      aui var1 = tc.a(this.a, 10, 7);
      if (var1 == null) {
         return false;
      } else {
         this.b = var1.a;
         this.c = var1.b;
         this.d = var1.c;
         this.g = false;
         return true;
      }
   }

   public void f() {
      this.g = true;
   }
}
