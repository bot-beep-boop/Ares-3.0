public class asu {
   private int b;
   private asv[] a = new asv[1024];

   private void b(int var1) {
      asv var2 = this.a[var1];
      float var3 = var2.g;

      while(true) {
         int var4 = 1 + (var1 << 1);
         int var5 = var4 + 1;
         if (var4 >= this.b) {
            break;
         }

         asv var6 = this.a[var4];
         float var7 = var6.g;
         asv var8;
         float var9;
         if (var5 >= this.b) {
            var8 = null;
            var9 = Float.POSITIVE_INFINITY;
         } else {
            var8 = this.a[var5];
            var9 = var8.g;
         }

         if (var7 < var9) {
            if (!(var7 < var3)) {
               break;
            }

            this.a[var1] = var6;
            var6.d = var1;
            var1 = var4;
         } else {
            if (!(var9 < var3)) {
               break;
            }

            this.a[var1] = var8;
            var8.d = var1;
            var1 = var5;
         }
      }

      this.a[var1] = var2;
      var2.d = var1;
   }

   public void a(asv var1, float var2) {
      float var3 = var1.g;
      var1.g = var2;
      if (var2 < var3) {
         this.a(var1.d);
      } else {
         this.b(var1.d);
      }

   }

   public boolean e() {
      return this.b == 0;
   }

   public asv c() {
      asv var1 = this.a[0];
      this.a[0] = this.a[--this.b];
      this.a[this.b] = null;
      if (this.b > 0) {
         this.b(0);
      }

      var1.d = -1;
      return var1;
   }

   public asv a(asv var1) {
      if (var1.d >= 0) {
         throw new IllegalStateException("OW KNOWS!");
      } else {
         if (this.b == this.a.length) {
            asv[] var2 = new asv[this.b << 1];
            System.arraycopy(this.a, 0, var2, 0, this.b);
            this.a = var2;
         }

         this.a[this.b] = var1;
         var1.d = this.b;
         this.a(this.b++);
         return var1;
      }
   }

   private void a(int var1) {
      asv var2 = this.a[var1];

      int var4;
      for(float var3 = var2.g; var1 > 0; var1 = var4) {
         var4 = var1 - 1 >> 1;
         asv var5 = this.a[var4];
         if (!(var3 < var5.g)) {
            break;
         }

         this.a[var1] = var5;
         var5.d = var1;
      }

      this.a[var1] = var2;
      var2.d = var1;
   }

   public void a() {
      this.b = 0;
   }
}
