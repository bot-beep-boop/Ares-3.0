import java.util.List;

public class aji extends afh {
   public static final amm<aji.a> a = amm.a("type", aji.a.class);

   public aji() {
      super(arm.e);
      this.j(this.M.b().a(a, aji.a.a));
      this.a(yz.b);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      aji.a[] var4 = aji.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         aji.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public arn g(alz var1) {
      return arn.d;
   }

   public alz a(int var1) {
      return this.Q().a(a, aji.a.a(var1));
   }

   public int c(alz var1) {
      return ((aji.a)var1.b(a)).a();
   }

   public int a(alz var1) {
      return ((aji.a)var1.b(a)).a();
   }

   public static enum a implements nw {
      private final String f;
      a(0, "sandstone", "default");

      private final String g;
      private static final aji.a[] h = new aji.a[]{a, b, c};
      private final int e;
      c(2, "smooth_sandstone", "smooth");

      private static final aji.a[] d = new aji.a[values().length];
      b(1, "chiseled_sandstone", "chiseled");

      public static aji.a a(int var0) {
         if (var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }

      public int a() {
         return this.e;
      }

      static {
         aji.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            aji.a var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }

      public String l() {
         return this.f;
      }

      private a(int var3, String var4, String var5) {
         this.e = var3;
         this.f = var4;
         this.g = var5;
      }

      public String c() {
         return this.g;
      }

      public String toString() {
         return this.f;
      }
   }
}
