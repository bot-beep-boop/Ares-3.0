public enum bfj {
   private static final bfj[] g = new bfj[6];
   b(new bfj.b[]{new bfj.b(bfj.a.f, bfj.a.b, bfj.a.d), new bfj.b(bfj.a.f, bfj.a.b, bfj.a.a), new bfj.b(bfj.a.c, bfj.a.b, bfj.a.a), new bfj.b(bfj.a.c, bfj.a.b, bfj.a.d)}),
   d(new bfj.b[]{new bfj.b(bfj.a.f, bfj.a.b, bfj.a.a), new bfj.b(bfj.a.f, bfj.a.e, bfj.a.a), new bfj.b(bfj.a.c, bfj.a.e, bfj.a.a), new bfj.b(bfj.a.c, bfj.a.b, bfj.a.a)}),
   e(new bfj.b[]{new bfj.b(bfj.a.f, bfj.a.b, bfj.a.d), new bfj.b(bfj.a.f, bfj.a.e, bfj.a.d), new bfj.b(bfj.a.f, bfj.a.e, bfj.a.a), new bfj.b(bfj.a.f, bfj.a.b, bfj.a.a)});

   private final bfj.b[] h;
   a(new bfj.b[]{new bfj.b(bfj.a.f, bfj.a.e, bfj.a.a), new bfj.b(bfj.a.f, bfj.a.e, bfj.a.d), new bfj.b(bfj.a.c, bfj.a.e, bfj.a.d), new bfj.b(bfj.a.c, bfj.a.e, bfj.a.a)}),
   c(new bfj.b[]{new bfj.b(bfj.a.c, bfj.a.b, bfj.a.d), new bfj.b(bfj.a.c, bfj.a.e, bfj.a.d), new bfj.b(bfj.a.f, bfj.a.e, bfj.a.d), new bfj.b(bfj.a.f, bfj.a.b, bfj.a.d)});

   private static final bfj[] i = new bfj[]{a, b, c, d, e, f};
   f(new bfj.b[]{new bfj.b(bfj.a.c, bfj.a.b, bfj.a.a), new bfj.b(bfj.a.c, bfj.a.e, bfj.a.a), new bfj.b(bfj.a.c, bfj.a.e, bfj.a.d), new bfj.b(bfj.a.c, bfj.a.b, bfj.a.d)});

   private bfj(bfj.b... var3) {
      this.h = var3;
   }

   static {
      g[bfj.a.e] = a;
      g[bfj.a.b] = b;
      g[bfj.a.d] = c;
      g[bfj.a.a] = d;
      g[bfj.a.f] = e;
      g[bfj.a.c] = f;
   }

   public static bfj a(cq var0) {
      return g[var0.a()];
   }

   public bfj.b a(int var1) {
      return this.h[var1];
   }

   public static final class a {
      public static final int d;
      public static final int f;
      public static final int b;
      public static final int c;
      public static final int e;
      public static final int a;

      static {
         a = cq.d.a();
         b = cq.b.a();
         c = cq.f.a();
         d = cq.c.a();
         e = cq.a.a();
         f = cq.e.a();
      }
   }

   public static class b {
      public final int a;
      public final int c;
      public final int b;

      b(int var1, int var2, int var3, Object var4) {
         this(var1, var2, var3);
      }

      private b(int var1, int var2, int var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }
   }
}
