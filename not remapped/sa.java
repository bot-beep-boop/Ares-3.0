public class sa extends rd {
   private pr c;
   private int f;
   private int h;
   private double e;
   private float j;
   private int d;
   private int g;
   private final vx b;
   private float i;
   private final ps a;

   public void d() {
      this.c = null;
      this.f = 0;
      this.d = -1;
   }

   public boolean b() {
      return this.a() || !this.a.s().m();
   }

   public sa(vx var1, double var2, int var4, float var5) {
      this(var1, var2, var4, var4, var5);
   }

   public sa(vx var1, double var2, int var4, int var5, float var6) {
      this.d = -1;
      if (!(var1 instanceof pr)) {
         throw new IllegalArgumentException("ArrowAttackGoal requires Mob implements RangedAttackMob");
      } else {
         this.b = var1;
         this.a = (ps)var1;
         this.e = var2;
         this.g = var4;
         this.h = var5;
         this.i = var6;
         this.j = var6 * var6;
         this.a(3);
      }
   }

   public boolean a() {
      pr var1 = this.a.u();
      if (var1 == null) {
         return false;
      } else {
         this.c = var1;
         return true;
      }
   }

   public void e() {
      double var1 = this.a.e(this.c.s, this.c.aR().b, this.c.u);
      boolean var3 = this.a.t().a(this.c);
      if (var3) {
         ++this.f;
      } else {
         this.f = 0;
      }

      if (!(var1 > (double)this.j) && this.f >= 20) {
         this.a.s().n();
      } else {
         this.a.s().a((pk)this.c, this.e);
      }

      this.a.p().a(this.c, 30.0F, 30.0F);
      float var4;
      if (--this.d == 0) {
         if (var1 > (double)this.j || !var3) {
            return;
         }

         var4 = ns.a(var1) / this.i;
         float var5 = ns.a(var4, 0.1F, 1.0F);
         this.b.a(this.c, var5);
         this.d = ns.d(var4 * (float)(this.h - this.g) + (float)this.g);
      } else if (this.d < 0) {
         var4 = ns.a(var1) / this.i;
         this.d = ns.d(var4 * (float)(this.h - this.g) + (float)this.g);
      }

   }
}
