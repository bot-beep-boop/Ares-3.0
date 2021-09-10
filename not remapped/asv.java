public class asv {
   public final int a;
   private final int j;
   float e;
   float g;
   asv h;
   public boolean i;
   int d = -1;
   public final int b;
   public final int c;
   float f;

   public static int a(int var0, int var1, int var2) {
      return var1 & 255 | (var0 & 32767) << 8 | (var2 & 32767) << 24 | (var0 < 0 ? Integer.MIN_VALUE : 0) | (var2 < 0 ? '耀' : 0);
   }

   public boolean equals(Object var1) {
      if (!(var1 instanceof asv)) {
         return false;
      } else {
         asv var2 = (asv)var1;
         return this.j == var2.j && this.a == var2.a && this.b == var2.b && this.c == var2.c;
      }
   }

   public int hashCode() {
      return this.j;
   }

   public float a(asv var1) {
      float var2 = (float)(var1.a - this.a);
      float var3 = (float)(var1.b - this.b);
      float var4 = (float)(var1.c - this.c);
      return ns.c(var2 * var2 + var3 * var3 + var4 * var4);
   }

   public float b(asv var1) {
      float var2 = (float)(var1.a - this.a);
      float var3 = (float)(var1.b - this.b);
      float var4 = (float)(var1.c - this.c);
      return var2 * var2 + var3 * var3 + var4 * var4;
   }

   public String toString() {
      return this.a + ", " + this.b + ", " + this.c;
   }

   public asv(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.j = a(var1, var2, var3);
   }

   public boolean a() {
      return this.d >= 0;
   }
}
