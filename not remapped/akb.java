import java.util.List;
import java.util.Random;

public abstract class akb extends ahh {
   public static final amk b = amk.a("seamless");
   public static final amm<akb.a> N = amm.a("variant", akb.a.class);

   public zw c(adm var1, cj var2) {
      return zw.a((afh)afi.U);
   }

   public akb() {
      super(arm.e);
      alz var1 = this.M.b();
      if (this.l()) {
         var1 = var1.a(b, false);
      } else {
         var1 = var1.a(a, ahh.a.b);
      }

      this.j(var1.a(N, akb.a.a));
      this.a((yz)yz.b);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((akb.a)var1.b(N)).a();
      if (this.l()) {
         if ((Boolean)var1.b(b)) {
            var3 |= 8;
         }
      } else if (var1.b(a) == ahh.a.a) {
         var3 |= 8;
      }

      return var3;
   }

   protected ama e() {
      return this.l() ? new ama(this, new amo[]{b, N}) : new ama(this, new amo[]{a, N});
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a((afh)afi.U);
   }

   public amo<?> n() {
      return N;
   }

   public alz a(int var1) {
      alz var2 = this.Q().a(N, akb.a.a(var1 & 7));
      if (this.l()) {
         var2 = var2.a(b, (var1 & 8) != 0);
      } else {
         var2 = var2.a(a, (var1 & 8) == 0 ? ahh.a.b : ahh.a.a);
      }

      return var2;
   }

   public Object a(zx var1) {
      return akb.a.a(var1.i() & 7);
   }

   public arn g(alz var1) {
      return ((akb.a)var1.b(N)).c();
   }

   public int a(alz var1) {
      return ((akb.a)var1.b(N)).a();
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      if (var1 != zw.a((afh)afi.T)) {
         akb.a[] var4 = akb.a.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            akb.a var7 = var4[var6];
            if (var7 != akb.a.c) {
               var3.add(new zx(var1, 1, var7.a()));
            }
         }

      }
   }

   public String b(int var1) {
      return super.a() + "." + akb.a.a(var1).d();
   }

   public static enum a implements nw {
      private final String m;
      b(1, arn.d, "sandstone", "sand");

      private static final akb.a[] i = new akb.a[values().length];
      private final String l;
      f(5, arn.m, "stone_brick", "smoothStoneBrick"),
      a(0, arn.m, "stone");

      private final arn k;
      private final int j;
      d(3, arn.m, "cobblestone", "cobble"),
      e(4, arn.D, "brick"),
      g(6, arn.K, "nether_brick", "netherBrick"),
      c(2, arn.o, "wood_old", "wood");

      private static final akb.a[] n = new akb.a[]{a, b, c, d, e, f, g, h};
      h(7, arn.p, "quartz");

      public String l() {
         return this.l;
      }

      public int a() {
         return this.j;
      }

      public String d() {
         return this.m;
      }

      static {
         akb.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            akb.a var3 = var0[var2];
            i[var3.a()] = var3;
         }

      }

      public arn c() {
         return this.k;
      }

      private a(int var3, arn var4, String var5, String var6) {
         this.j = var3;
         this.k = var4;
         this.l = var5;
         this.m = var6;
      }

      public static akb.a a(int var0) {
         if (var0 < 0 || var0 >= i.length) {
            var0 = 0;
         }

         return i[var0];
      }

      private a(int var3, arn var4, String var5) {
         this(var3, var4, var5, var5);
      }

      public String toString() {
         return this.l;
      }
   }
}
