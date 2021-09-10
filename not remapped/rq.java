public class rq extends rd {
   private float g;
   private py a;
   private pr b;
   private double d;
   private double f;
   private double c;
   private double e;

   public void c() {
      this.a.s().a(this.c, this.d, this.e, this.f);
   }

   public boolean b() {
      return !this.a.s().m() && this.b.ai() && this.b.h(this.a) < (double)(this.g * this.g);
   }

   public rq(py var1, double var2, float var4) {
      this.a = var1;
      this.f = var2;
      this.g = var4;
      this.a(1);
   }

   public boolean a() {
      this.b = this.a.u();
      if (this.b == null) {
         return false;
      } else if (this.b.h(this.a) > (double)(this.g * this.g)) {
         return false;
      } else {
         aui var1 = tc.a(this.a, 16, 7, new aui(this.b.s, this.b.t, this.b.u));
         if (var1 == null) {
            return false;
         } else {
            this.c = var1.a;
            this.d = var1.b;
            this.e = var1.c;
            return true;
         }
      }
   }

   public void d() {
      this.b = null;
   }
}
