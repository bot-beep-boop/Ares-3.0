public class rr extends rd {
   int d;
   ps b;
   adm a;
   pr c;

   public void e() {
      this.b.p().a(this.c, 30.0F, 30.0F);
      double var1 = (double)(this.b.J * 2.0F * this.b.J * 2.0F);
      double var3 = this.b.e(this.c.s, this.c.aR().b, this.c.u);
      double var5 = 0.8D;
      if (var3 > var1 && var3 < 16.0D) {
         var5 = 1.33D;
      } else if (var3 < 225.0D) {
         var5 = 0.6D;
      }

      this.b.s().a((pk)this.c, var5);
      this.d = Math.max(this.d - 1, 0);
      if (!(var3 > var1)) {
         if (this.d <= 0) {
            this.d = 20;
            this.b.r(this.c);
         }
      }
   }

   public boolean a() {
      pr var1 = this.b.u();
      if (var1 == null) {
         return false;
      } else {
         this.c = var1;
         return true;
      }
   }

   public rr(ps var1) {
      this.b = var1;
      this.a = var1.o;
      this.a(3);
   }

   public boolean b() {
      if (!this.c.ai()) {
         return false;
      } else if (this.b.h(this.c) > 225.0D) {
         return false;
      } else {
         return !this.b.s().m() || this.a();
      }
   }

   public void d() {
      this.c = null;
      this.b.s().n();
   }
}
