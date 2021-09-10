import java.util.List;
import java.util.Random;

public class ajy extends afh {
   public static final amm<ajy.a> a = amm.a("variant", ajy.a.class);

   public zw a(alz var1, Random var2, int var3) {
      return var1.b(a) == ajy.a.a ? zw.a(afi.e) : zw.a(afi.b);
   }

   public alz a(int var1) {
      return this.Q().a(a, ajy.a.a(var1));
   }

   public String f() {
      return di.a(this.a() + "." + ajy.a.a.d() + ".name");
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      ajy.a[] var4 = ajy.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ajy.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public int c(alz var1) {
      return ((ajy.a)var1.b(a)).a();
   }

   public ajy() {
      super(arm.e);
      this.j(this.M.b().a(a, ajy.a.a));
      this.a(yz.b);
   }

   public int a(alz var1) {
      return ((ajy.a)var1.b(a)).a();
   }

   public arn g(alz var1) {
      return ((ajy.a)var1.b(a)).c();
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public static enum a implements nw {
      e(4, arn.p, "smooth_diorite", "dioriteSmooth"),
      c(2, arn.l, "smooth_granite", "graniteSmooth"),
      g(6, arn.m, "smooth_andesite", "andesiteSmooth");

      private static final ajy.a[] h = new ajy.a[values().length];
      a(0, arn.m, "stone");

      private final arn l;
      private final String j;
      d(3, arn.p, "diorite");

      private final int i;
      private static final ajy.a[] m = new ajy.a[]{a, b, c, d, e, f, g};
      b(1, arn.l, "granite");

      private final String k;
      f(5, arn.m, "andesite");

      public static ajy.a a(int var0) {
         if (var0 < 0 || var0 >= h.length) {
            var0 = 0;
         }

         return h[var0];
      }

      private a(int var3, arn var4, String var5) {
         this(var3, var4, var5, var5);
      }

      public String l() {
         return this.j;
      }

      public arn c() {
         return this.l;
      }

      public String d() {
         return this.k;
      }

      static {
         ajy.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            ajy.a var3 = var0[var2];
            h[var3.a()] = var3;
         }

      }

      public String toString() {
         return this.j;
      }

      public int a() {
         return this.i;
      }

      private a(int var3, arn var4, String var5, String var6) {
         this.i = var3;
         this.j = var5;
         this.k = var6;
         this.l = var4;
      }
   }
}
