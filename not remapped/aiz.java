import java.util.List;

public class aiz extends afh {
   public static final amm<aiz.a> a = amm.a("type", aiz.a.class);

   public aiz() {
      super(arm.e, ajh.a.b.c());
      this.j(this.M.b().a(a, aiz.a.a));
      this.a(yz.b);
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      aiz.a[] var4 = aiz.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         aiz.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public int a(alz var1) {
      return ((aiz.a)var1.b(a)).a();
   }

   public int c(alz var1) {
      return ((aiz.a)var1.b(a)).a();
   }

   public alz a(int var1) {
      return this.Q().a(a, aiz.a.a(var1));
   }

   public static enum a implements nw {
      private static final aiz.a[] h = new aiz.a[]{a, b, c};
      c(2, "smooth_red_sandstone", "smooth");

      private final int e;
      private final String f;
      private final String g;
      a(0, "red_sandstone", "default"),
      b(1, "chiseled_red_sandstone", "chiseled");

      private static final aiz.a[] d = new aiz.a[values().length];

      public String toString() {
         return this.f;
      }

      public String c() {
         return this.g;
      }

      public String l() {
         return this.f;
      }

      public int a() {
         return this.e;
      }

      static {
         aiz.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            aiz.a var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }

      public static aiz.a a(int var0) {
         if (var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }

      private a(int var3, String var4, String var5) {
         this.e = var3;
         this.f = var4;
         this.g = var5;
      }
   }
}
