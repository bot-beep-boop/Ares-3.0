public class rl extends rd {
   Class<? extends pk> g;
   private double i;
   int c;
   adm a;
   private int h;
   boolean e;
   double d;
   asx f;
   private double k;
   protected py b;
   private double j;

   public rl(py var1, Class<? extends pk> var2, double var3, boolean var5) {
      this(var1, var3, var5);
      this.g = var2;
   }

   public void e() {
      pr var1 = this.b.u();
      this.b.p().a(var1, 30.0F, 30.0F);
      double var2 = this.b.e(var1.s, var1.aR().b, var1.u);
      double var4 = this.a(var1);
      --this.h;
      if ((this.e || this.b.t().a(var1)) && this.h <= 0 && (this.i == 0.0D && this.j == 0.0D && this.k == 0.0D || var1.e(this.i, this.j, this.k) >= 1.0D || this.b.bc().nextFloat() < 0.05F)) {
         this.i = var1.s;
         this.j = var1.aR().b;
         this.k = var1.u;
         this.h = 4 + this.b.bc().nextInt(7);
         if (var2 > 1024.0D) {
            this.h += 10;
         } else if (var2 > 256.0D) {
            this.h += 5;
         }

         if (!this.b.s().a((pk)var1, this.d)) {
            this.h += 15;
         }
      }

      this.c = Math.max(this.c - 1, 0);
      if (var2 <= var4 && this.c <= 0) {
         this.c = 20;
         if (this.b.bA() != null) {
            this.b.bw();
         }

         this.b.r(var1);
      }

   }

   public boolean a() {
      pr var1 = this.b.u();
      if (var1 == null) {
         return false;
      } else if (!var1.ai()) {
         return false;
      } else if (this.g != null && !this.g.isAssignableFrom(var1.getClass())) {
         return false;
      } else {
         this.f = this.b.s().a((pk)var1);
         return this.f != null;
      }
   }

   public rl(py var1, double var2, boolean var4) {
      this.b = var1;
      this.a = var1.o;
      this.d = var2;
      this.e = var4;
      this.a(3);
   }

   protected double a(pr var1) {
      return (double)(this.b.J * 2.0F * this.b.J * 2.0F + var1.J);
   }

   public void d() {
      this.b.s().n();
   }

   public void c() {
      this.b.s().a(this.f, this.d);
      this.h = 0;
   }

   public boolean b() {
      pr var1 = this.b.u();
      if (var1 == null) {
         return false;
      } else if (!var1.ai()) {
         return false;
      } else if (!this.e) {
         return !this.b.s().m();
      } else {
         return this.b.e(new cj(var1));
      }
   }
}
