public class sh extends rd {
   private zw k;
   private double g;
   private boolean l;
   private wn h;
   private boolean m;
   private double b;
   private boolean j;
   private double e;
   private int i;
   private double d;
   private double f;
   private double c;
   private py a;

   public sh(py var1, double var2, zw var4, boolean var5) {
      this.a = var1;
      this.b = var2;
      this.k = var4;
      this.l = var5;
      this.a(3);
      if (!(var1.s() instanceof sv)) {
         throw new IllegalArgumentException("Unsupported mob type for TemptGoal");
      }
   }

   public boolean f() {
      return this.j;
   }

   public void d() {
      this.h = null;
      this.a.s().n();
      this.i = 100;
      this.j = false;
      ((sv)this.a.s()).a(this.m);
   }

   public boolean a() {
      if (this.i > 0) {
         --this.i;
         return false;
      } else {
         this.h = this.a.o.a(this.a, 10.0D);
         if (this.h == null) {
            return false;
         } else {
            zx var1 = this.h.bZ();
            if (var1 == null) {
               return false;
            } else {
               return var1.b() == this.k;
            }
         }
      }
   }

   public void e() {
      this.a.p().a(this.h, 30.0F, (float)this.a.bQ());
      if (this.a.h(this.h) < 6.25D) {
         this.a.s().n();
      } else {
         this.a.s().a((pk)this.h, this.b);
      }

   }

   public boolean b() {
      if (this.l) {
         if (this.a.h(this.h) < 36.0D) {
            if (this.h.e(this.c, this.d, this.e) > 0.010000000000000002D) {
               return false;
            }

            if (Math.abs((double)this.h.z - this.f) > 5.0D || Math.abs((double)this.h.y - this.g) > 5.0D) {
               return false;
            }
         } else {
            this.c = this.h.s;
            this.d = this.h.t;
            this.e = this.h.u;
         }

         this.f = (double)this.h.z;
         this.g = (double)this.h.y;
      }

      return this.a();
   }

   public void c() {
      this.c = this.h.s;
      this.d = this.h.t;
      this.e = this.h.u;
      this.j = true;
      this.m = ((sv)this.a.s()).e();
      ((sv)this.a.s()).a(false);
   }
}
