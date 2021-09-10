public class ry extends rd {
   private ps a;
   private double b;
   private double c;
   private int d;

   public void e() {
      --this.d;
      this.a.p().a(this.a.s + this.b, this.a.t + (double)this.a.aS(), this.a.u + this.c, 10.0F, (float)this.a.bQ());
   }

   public void c() {
      double var1 = 6.283185307179586D * this.a.bc().nextDouble();
      this.b = Math.cos(var1);
      this.c = Math.sin(var1);
      this.d = 20 + this.a.bc().nextInt(20);
   }

   public boolean a() {
      return this.a.bc().nextFloat() < 0.02F;
   }

   public boolean b() {
      return this.d >= 0;
   }

   public ry(ps var1) {
      this.a = var1;
      this.a(3);
   }
}
