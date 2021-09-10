public enum zd implements nw {
   d(3, 12, "light_blue", "lightBlue", arn.s, a.j),
   a(0, 15, "white", "white", arn.j, a.p),
   p(15, 0, "black", "black", arn.E, a.a),
   j(9, 6, "cyan", "cyan", arn.y, a.d);

   private final int t;
   private static final zd[] q = new zd[values().length];
   m(12, 3, "brown", "brown", arn.B, a.g),
   n(13, 2, "green", "green", arn.C, a.c);

   private final arn w;
   private final String v;
   private final int s;
   i(8, 7, "silver", "silver", arn.x, a.h),
   g(6, 9, "pink", "pink", arn.v, a.n),
   h(7, 8, "gray", "gray", arn.w, a.i),
   f(5, 10, "lime", "lime", arn.u, a.k);

   private final a x;
   private final String u;
   o(14, 1, "red", "red", arn.D, a.e);

   private static final zd[] r = new zd[values().length];
   e(4, 11, "yellow", "yellow", arn.t, a.o),
   b(1, 14, "orange", "orange", arn.q, a.g);

   private static final zd[] y = new zd[]{a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p};
   c(2, 13, "magenta", "magenta", arn.r, a.l),
   k(10, 5, "purple", "purple", arn.z, a.f),
   l(11, 4, "blue", "blue", arn.A, a.b);

   public static zd b(int var0) {
      if (var0 < 0 || var0 >= q.length) {
         var0 = 0;
      }

      return q[var0];
   }

   static {
      zd[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         zd var3 = var0[var2];
         q[var3.a()] = var3;
         r[var3.b()] = var3;
      }

   }

   public arn e() {
      return this.w;
   }

   public int b() {
      return this.t;
   }

   public String l() {
      return this.u;
   }

   public static zd a(int var0) {
      if (var0 < 0 || var0 >= r.length) {
         var0 = 0;
      }

      return r[var0];
   }

   public String toString() {
      return this.v;
   }

   public String d() {
      return this.v;
   }

   private zd(int var3, int var4, String var5, String var6, arn var7, a var8) {
      this.s = var3;
      this.t = var4;
      this.u = var5;
      this.v = var6;
      this.w = var7;
      this.x = var8;
   }

   public int a() {
      return this.s;
   }
}
