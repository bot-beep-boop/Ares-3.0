import java.util.Random;

public class aho extends afh {
   private final afh b;
   public static final amm<aho.a> a = amm.a("variant", aho.a.class);

   public arn g(alz var1) {
      switch((aho.a)var1.b(a)) {
      case m:
         return arn.e;
      case k:
         return arn.d;
      case j:
         return arn.d;
      default:
         return super.g(var1);
      }
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a(this.b);
   }

   public zw c(adm var1, cj var2) {
      return zw.a(this.b);
   }

   public int a(Random var1) {
      return Math.max(0, var1.nextInt(10) - 7);
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q();
   }

   public alz a(int var1) {
      return this.Q().a(a, aho.a.a(var1));
   }

   public int c(alz var1) {
      return ((aho.a)var1.b(a)).a();
   }

   public aho(arm var1, arn var2, afh var3) {
      super(var1, var2);
      this.j(this.M.b().a(a, aho.a.l));
      this.b = var3;
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public static enum a implements nw {
      g(7, "south_west"),
      b(2, "north"),
      a(1, "north_west"),
      j(10, "stem");

      private static final aho.a[] n = new aho.a[16];
      k(0, "all_inside");

      private final String p;
      f(6, "east"),
      h(8, "south"),
      d(4, "west"),
      e(5, "center"),
      c(3, "north_east"),
      m(15, "all_stem");

      private static final aho.a[] q = new aho.a[]{a, b, c, d, e, f, g, h, i, j, k, l, m};
      l(14, "all_outside");

      private final int o;
      i(9, "south_east");

      static {
         aho.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            aho.a var3 = var0[var2];
            n[var3.a()] = var3;
         }

      }

      public String toString() {
         return this.p;
      }

      public int a() {
         return this.o;
      }

      private a(int var3, String var4) {
         this.o = var3;
         this.p = var4;
      }

      public String l() {
         return this.p;
      }

      public static aho.a a(int var0) {
         if (var0 < 0 || var0 >= n.length) {
            var0 = 0;
         }

         aho.a var1 = n[var0];
         return var1 == null ? n[0] : var1;
      }
   }
}
