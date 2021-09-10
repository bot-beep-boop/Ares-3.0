public class xg {
   private int d;
   private float c;
   private float b = 5.0F;
   private int a = 20;
   private int e = 20;

   public void a(zs var1, zx var2) {
      this.a(var1.h(var2), var1.i(var2));
   }

   public void a(dn var1) {
      if (var1.b("foodLevel", 99)) {
         this.a = var1.f("foodLevel");
         this.d = var1.f("foodTickTimer");
         this.b = var1.h("foodSaturationLevel");
         this.c = var1.h("foodExhaustionLevel");
      }

   }

   public void b(dn var1) {
      var1.a("foodLevel", this.a);
      var1.a("foodTickTimer", this.d);
      var1.a("foodSaturationLevel", this.b);
      var1.a("foodExhaustionLevel", this.c);
   }

   public int a() {
      return this.a;
   }

   public void b(float var1) {
      this.b = var1;
   }

   public void a(float var1) {
      this.c = Math.min(this.c + var1, 40.0F);
   }

   public void a(int var1) {
      this.a = var1;
   }

   public void a(wn var1) {
      oj var2 = var1.o.aa();
      this.e = this.a;
      if (this.c > 4.0F) {
         this.c -= 4.0F;
         if (this.b > 0.0F) {
            this.b = Math.max(this.b - 1.0F, 0.0F);
         } else if (var2 != oj.a) {
            this.a = Math.max(this.a - 1, 0);
         }
      }

      if (var1.o.Q().b("naturalRegeneration") && this.a >= 18 && var1.cm()) {
         ++this.d;
         if (this.d >= 80) {
            var1.h(1.0F);
            this.a(3.0F);
            this.d = 0;
         }
      } else if (this.a <= 0) {
         ++this.d;
         if (this.d >= 80) {
            if (var1.bn() > 10.0F || var2 == oj.d || var1.bn() > 1.0F && var2 == oj.c) {
               var1.a(ow.g, 1.0F);
            }

            this.d = 0;
         }
      } else {
         this.d = 0;
      }

   }

   public int b() {
      return this.e;
   }

   public float e() {
      return this.b;
   }

   public boolean c() {
      return this.a < 20;
   }

   public void a(int var1, float var2) {
      this.a = Math.min(var1 + this.a, 20);
      this.b = Math.min(this.b + (float)var1 * var2 * 2.0F, (float)this.a);
   }
}
