public class rm extends rd {
   private te b;
   private int c = -1;
   private py a;
   private int d = -1;

   public void d() {
      this.c = this.b.e().n();
      this.d = this.b.e().p();
      this.b = null;
   }

   public rm(py var1) {
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      cj var1 = new cj(this.a);
      if ((!this.a.o.w() || this.a.o.S() && !this.a.o.b(var1).e()) && !this.a.o.t.o()) {
         if (this.a.bc().nextInt(50) != 0) {
            return false;
         } else if (this.c != -1 && this.a.e((double)this.c, this.a.t, (double)this.d) < 4.0D) {
            return false;
         } else {
            tf var2 = this.a.o.ae().a(var1, 14);
            if (var2 == null) {
               return false;
            } else {
               this.b = var2.c(var1);
               return this.b != null;
            }
         }
      } else {
         return false;
      }
   }

   public boolean b() {
      return !this.a.s().m();
   }

   public void c() {
      this.c = -1;
      cj var1 = this.b.e();
      int var2 = var1.n();
      int var3 = var1.o();
      int var4 = var1.p();
      if (this.a.b(var1) > 256.0D) {
         aui var5 = tc.a(this.a, 14, 3, new aui((double)var2 + 0.5D, (double)var3, (double)var4 + 0.5D));
         if (var5 != null) {
            this.a.s().a(var5.a, var5.b, var5.c, 1.0D);
         }
      } else {
         this.a.s().a((double)var2 + 0.5D, (double)var3, (double)var4 + 0.5D, 1.0D);
      }

   }
}
