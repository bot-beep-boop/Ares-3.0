public class rp extends rd {
   private double c;
   private double d;
   private double b;
   private py a;
   private double e;

   public void c() {
      this.a.s().a(this.b, this.c, this.d, this.e);
   }

   public rp(py var1, double var2) {
      this.a = var1;
      this.e = var2;
      this.a(1);
   }

   public boolean a() {
      if (this.a.cg()) {
         return false;
      } else {
         cj var1 = this.a.ch();
         aui var2 = tc.a(this.a, 16, 7, new aui((double)var1.n(), (double)var1.o(), (double)var1.p()));
         if (var2 == null) {
            return false;
         } else {
            this.b = var2.a;
            this.c = var2.b;
            this.d = var2.c;
            return true;
         }
      }
   }

   public boolean b() {
      return !this.a.s().m();
   }
}
