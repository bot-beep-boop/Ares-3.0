import java.util.List;

public class aiu extends afh {
   public static final int N;
   public static final amm<aiu.a> a = amm.a("variant", aiu.a.class);
   public static final int b;
   public static final int O;

   public String f() {
      return di.a(this.a() + "." + aiu.a.a.c() + ".name");
   }

   public arn g(alz var1) {
      return var1.b(a) == aiu.a.a ? arn.y : arn.G;
   }

   public aiu() {
      super(arm.e);
      this.j(this.M.b().a(a, aiu.a.a));
      this.a(yz.b);
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(var1, 1, b));
      var3.add(new zx(var1, 1, N));
      var3.add(new zx(var1, 1, O));
   }

   public int c(alz var1) {
      return ((aiu.a)var1.b(a)).a();
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public int a(alz var1) {
      return ((aiu.a)var1.b(a)).a();
   }

   static {
      b = aiu.a.a.a();
      N = aiu.a.b.a();
      O = aiu.a.c.a();
   }

   public alz a(int var1) {
      return this.Q().a(a, aiu.a.a(var1));
   }

   public static enum a implements nw {
      private final String f;
      private final String g;
      private final int e;
      b(1, "prismarine_bricks", "bricks");

      private static final aiu.a[] d = new aiu.a[values().length];
      c(2, "dark_prismarine", "dark");

      private static final aiu.a[] h = new aiu.a[]{a, b, c};
      a(0, "prismarine", "rough");

      private a(int var3, String var4, String var5) {
         this.e = var3;
         this.f = var4;
         this.g = var5;
      }

      public String l() {
         return this.f;
      }

      public int a() {
         return this.e;
      }

      static {
         aiu.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            aiu.a var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }

      public String c() {
         return this.g;
      }

      public String toString() {
         return this.f;
      }

      public static aiu.a a(int var0) {
         if (var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }
   }
}
