public class ok {
   private final oj a;
   private final float b;

   public float c() {
      if (this.b < 2.0F) {
         return 0.0F;
      } else {
         return this.b > 4.0F ? 1.0F : (this.b - 2.0F) / 2.0F;
      }
   }

   private float a(oj var1, long var2, long var4, float var6) {
      if (var1 == oj.a) {
         return 0.0F;
      } else {
         boolean var7 = var1 == oj.d;
         float var8 = 0.75F;
         float var9 = ns.a(((float)var2 + -72000.0F) / 1440000.0F, 0.0F, 1.0F) * 0.25F;
         var8 += var9;
         float var10 = 0.0F;
         var10 += ns.a((float)var4 / 3600000.0F, 0.0F, 1.0F) * (var7 ? 1.0F : 0.75F);
         var10 += ns.a(var6 * 0.25F, 0.0F, var9);
         if (var1 == oj.b) {
            var10 *= 0.5F;
         }

         var8 += var10;
         return (float)var1.a() * var8;
      }
   }

   public ok(oj var1, long var2, long var4, float var6) {
      this.a = var1;
      this.b = this.a(var1, var2, var4, var6);
   }

   public float b() {
      return this.b;
   }
}
