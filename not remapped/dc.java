public class dc {
   protected final float b;
   protected final float a;
   protected final float c;

   public du a() {
      du var1 = new du();
      var1.a((eb)(new dr(this.a)));
      var1.a((eb)(new dr(this.b)));
      var1.a((eb)(new dr(this.c)));
      return var1;
   }

   public float c() {
      return this.b;
   }

   public float d() {
      return this.c;
   }

   public float b() {
      return this.a;
   }

   public dc(float var1, float var2, float var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof dc)) {
         return false;
      } else {
         dc var2 = (dc)var1;
         return this.a == var2.a && this.b == var2.b && this.c == var2.c;
      }
   }

   public dc(du var1) {
      this.a = var1.e(0);
      this.b = var1.e(1);
      this.c = var1.e(2);
   }
}
