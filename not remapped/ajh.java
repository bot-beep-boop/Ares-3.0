import java.util.List;

public class ajh extends agr {
   public static final amm<ajh.a> a = amm.a("variant", ajh.a.class);

   public int a(alz var1) {
      return ((ajh.a)var1.b(a)).a();
   }

   public int c(alz var1) {
      return ((ajh.a)var1.b(a)).a();
   }

   public alz a(int var1) {
      return this.Q().a(a, ajh.a.a(var1));
   }

   public ajh() {
      this.j(this.M.b().a(a, ajh.a.a));
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      ajh.a[] var4 = ajh.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ajh.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public arn g(alz var1) {
      return ((ajh.a)var1.b(a)).c();
   }

   public static enum a implements nw {
      a(0, "sand", "default", arn.d);

      private final String g;
      private static final ajh.a[] h = new ajh.a[]{a, b};
      private static final ajh.a[] c = new ajh.a[values().length];
      private final int d;
      private final String e;
      private final arn f;
      b(1, "red_sand", "red", arn.q);

      static {
         ajh.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            ajh.a var3 = var0[var2];
            c[var3.a()] = var3;
         }

      }

      public String toString() {
         return this.e;
      }

      public String d() {
         return this.g;
      }

      public String l() {
         return this.e;
      }

      public arn c() {
         return this.f;
      }

      public int a() {
         return this.d;
      }

      public static ajh.a a(int var0) {
         if (var0 < 0 || var0 >= c.length) {
            var0 = 0;
         }

         return c[var0];
      }

      private a(int var3, String var4, String var5, arn var6) {
         this.d = var3;
         this.e = var4;
         this.f = var6;
         this.g = var5;
      }
   }
}
