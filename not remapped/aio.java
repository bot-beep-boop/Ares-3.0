import java.util.List;

public class aio extends afh {
   public static final amm<aio.a> a = amm.a("variant", aio.a.class);

   public arn g(alz var1) {
      return ((aio.a)var1.b(a)).c();
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public alz a(int var1) {
      return this.Q().a(a, aio.a.a(var1));
   }

   public int a(alz var1) {
      return ((aio.a)var1.b(a)).a();
   }

   public int c(alz var1) {
      return ((aio.a)var1.b(a)).a();
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      aio.a[] var4 = aio.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         aio.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public aio() {
      super(arm.d);
      this.j(this.M.b().a(a, aio.a.a));
      this.a(yz.b);
   }

   public static enum a implements nw {
      private final String j;
      f(5, "dark_oak", "big_oak", arn.B);

      private final arn k;
      private static final aio.a[] g = new aio.a[values().length];
      private final int h;
      a(0, "oak", arn.o),
      d(3, "jungle", arn.l),
      c(2, "birch", arn.d),
      e(4, "acacia", arn.q);

      private final String i;
      private static final aio.a[] l = new aio.a[]{a, b, c, d, e, f};
      b(1, "spruce", arn.J);

      public int a() {
         return this.h;
      }

      private a(int var3, String var4, arn var5) {
         this(var3, var4, var4, var5);
      }

      public String l() {
         return this.i;
      }

      public String d() {
         return this.j;
      }

      public arn c() {
         return this.k;
      }

      public static aio.a a(int var0) {
         if (var0 < 0 || var0 >= g.length) {
            var0 = 0;
         }

         return g[var0];
      }

      private a(int var3, String var4, String var5, arn var6) {
         this.h = var3;
         this.i = var4;
         this.j = var5;
         this.k = var6;
      }

      public String toString() {
         return this.i;
      }

      static {
         aio.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            aio.a var3 = var0[var2];
            g[var3.a()] = var3;
         }

      }
   }
}
