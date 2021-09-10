public class qt extends rd {
   private float d;
   private adm c;
   private int e;
   private ua a;
   private wn b;

   public void e() {
      this.a.p().a(this.b.s, this.b.t + (double)this.b.aS(), this.b.u, 10.0F, (float)this.a.bQ());
      --this.e;
   }

   public qt(ua var1, float var2) {
      this.a = var1;
      this.c = var1.o;
      this.d = var2;
      this.a(2);
   }

   public boolean a() {
      this.b = this.c.a(this.a, (double)this.d);
      return this.b == null ? false : this.a(this.b);
   }

   private boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (var2 == null) {
         return false;
      } else {
         return !this.a.cl() && var2.b() == zy.aX ? true : this.a.d(var2);
      }
   }

   public void d() {
      this.a.p(false);
      this.b = null;
   }

   public boolean b() {
      if (!this.b.ai()) {
         return false;
      } else if (this.a.h(this.b) > (double)(this.d * this.d)) {
         return false;
      } else {
         return this.e > 0 && this.a(this.b);
      }
   }

   public void c() {
      this.a.p(true);
      this.e = 40 + this.a.bc().nextInt(40);
   }
}
