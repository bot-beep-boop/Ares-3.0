public class ri extends rd {
   private int e;
   protected pk b;
   protected Class<? extends pk> d;
   private float f;
   protected ps a;
   protected float c;

   public boolean b() {
      if (!this.b.ai()) {
         return false;
      } else if (this.a.h(this.b) > (double)(this.c * this.c)) {
         return false;
      } else {
         return this.e > 0;
      }
   }

   public ri(ps var1, Class<? extends pk> var2, float var3) {
      this.a = var1;
      this.d = var2;
      this.c = var3;
      this.f = 0.02F;
      this.a(2);
   }

   public void e() {
      this.a.p().a(this.b.s, this.b.t + (double)this.b.aS(), this.b.u, 10.0F, (float)this.a.bQ());
      --this.e;
   }

   public boolean a() {
      if (this.a.bc().nextFloat() >= this.f) {
         return false;
      } else {
         if (this.a.u() != null) {
            this.b = this.a.u();
         }

         if (this.d == wn.class) {
            this.b = this.a.o.a(this.a, (double)this.c);
         } else {
            this.b = this.a.o.a((Class)this.d, (aug)this.a.aR().b((double)this.c, 3.0D, (double)this.c), (pk)this.a);
         }

         return this.b != null;
      }
   }

   public void c() {
      this.e = 40 + this.a.bc().nextInt(40);
   }

   public ri(ps var1, Class<? extends pk> var2, float var3, float var4) {
      this.a = var1;
      this.d = var2;
      this.c = var3;
      this.f = var4;
      this.a(2);
   }

   public void d() {
      this.b = null;
   }
}
