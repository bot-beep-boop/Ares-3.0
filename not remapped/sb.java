public class sb extends rd {
   private py a;
   private te b;

   public void e() {
      this.b.b();
   }

   public sb(py var1) {
      this.a = var1;
      if (!(var1.s() instanceof sv)) {
         throw new IllegalArgumentException("Unsupported mob type for RestrictOpenDoorGoal");
      }
   }

   public void d() {
      ((sv)this.a.s()).b(true);
      ((sv)this.a.s()).c(true);
      this.b = null;
   }

   public boolean a() {
      if (this.a.o.w()) {
         return false;
      } else {
         cj var1 = new cj(this.a);
         tf var2 = this.a.o.ae().a(var1, 16);
         if (var2 == null) {
            return false;
         } else {
            this.b = var2.b(var1);
            if (this.b == null) {
               return false;
            } else {
               return (double)this.b.b(var1) < 2.25D;
            }
         }
      }
   }

   public void c() {
      ((sv)this.a.s()).b(false);
      ((sv)this.a.s()).c(false);
   }

   public boolean b() {
      if (this.a.o.w()) {
         return false;
      } else {
         return !this.b.i() && this.b.c(new cj(this.a));
      }
   }
}
