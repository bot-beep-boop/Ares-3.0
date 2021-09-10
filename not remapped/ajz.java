import java.util.List;

public class ajz extends afh {
   public static final amm<ajz.a> a = amm.a("variant", ajz.a.class);
   public static final int P;
   public static final int b;
   public static final int O;
   public static final int N;

   public void a(zw var1, yz var2, List<zx> var3) {
      ajz.a[] var4 = ajz.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ajz.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public int a(alz var1) {
      return ((ajz.a)var1.b(a)).a();
   }

   public alz a(int var1) {
      return this.Q().a(a, ajz.a.a(var1));
   }

   public int c(alz var1) {
      return ((ajz.a)var1.b(a)).a();
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public ajz() {
      super(arm.e);
      this.j(this.M.b().a(a, ajz.a.a));
      this.a(yz.b);
   }

   static {
      b = ajz.a.a.a();
      N = ajz.a.b.a();
      O = ajz.a.c.a();
      P = ajz.a.d.a();
   }

   public static enum a implements nw {
      c(2, "cracked_stonebrick", "cracked");

      private static final ajz.a[] e = new ajz.a[values().length];
      d(3, "chiseled_stonebrick", "chiseled");

      private final String h;
      private final int f;
      b(1, "mossy_stonebrick", "mossy"),
      a(0, "stonebrick", "default");

      private final String g;
      private static final ajz.a[] i = new ajz.a[]{a, b, c, d};

      public String l() {
         return this.g;
      }

      static {
         ajz.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            ajz.a var3 = var0[var2];
            e[var3.a()] = var3;
         }

      }

      public static ajz.a a(int var0) {
         if (var0 < 0 || var0 >= e.length) {
            var0 = 0;
         }

         return e[var0];
      }

      private a(int var3, String var4, String var5) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
      }

      public String toString() {
         return this.g;
      }

      public int a() {
         return this.f;
      }

      public String c() {
         return this.h;
      }
   }
}
