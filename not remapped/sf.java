public class sf extends rd {
   vn a;
   pr b;

   public boolean a() {
      pr var1 = this.a.u();
      return this.a.cm() > 0 || var1 != null && this.a.h(var1) < 9.0D;
   }

   public void d() {
      this.b = null;
   }

   public void c() {
      this.a.s().n();
      this.b = this.a.u();
   }

   public void e() {
      if (this.b == null) {
         this.a.a(-1);
      } else if (this.a.h(this.b) > 49.0D) {
         this.a.a(-1);
      } else if (!this.a.t().a(this.b)) {
         this.a.a(-1);
      } else {
         this.a.a(1);
      }
   }

   public sf(vn var1) {
      this.a = var1;
      this.a(1);
   }
}
