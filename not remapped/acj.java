public enum acj {
   f,
   g,
   h,
   i,
   c,
   e,
   j,
   a,
   k;

   private static final acj[] l = new acj[]{a, b, c, d, e, f, g, h, i, j, k};
   b,
   d;

   public boolean a(zw var1) {
      if (this == a) {
         return true;
      } else if (this == j && var1.m()) {
         return true;
      } else if (var1 instanceof yj) {
         if (this == b) {
            return true;
         } else {
            yj var2 = (yj)var1;
            if (var2.b == 0) {
               return this == f;
            } else if (var2.b == 2) {
               return this == d;
            } else if (var2.b == 1) {
               return this == e;
            } else if (var2.b == 3) {
               return this == c;
            } else {
               return false;
            }
         }
      } else if (var1 instanceof aay) {
         return this == g;
      } else if (var1 instanceof za) {
         return this == h;
      } else if (var1 instanceof yt) {
         return this == k;
      } else if (var1 instanceof zq) {
         return this == i;
      } else {
         return false;
      }
   }
}
