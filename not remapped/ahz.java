import java.util.List;
import java.util.Random;

public class ahz extends afh {
   public static final amm<ahz.a> a = amm.a("variant", ahz.a.class);

   public int a(Random var1) {
      return 0;
   }

   public ahz() {
      super(arm.B);
      this.j(this.M.b().a(a, ahz.a.a));
      this.c(0.0F);
      this.a(yz.c);
   }

   public alz a(int var1) {
      return this.Q().a(a, ahz.a.a(var1));
   }

   public int c(alz var1) {
      return ((ahz.a)var1.b(a)).a();
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      if (!var1.D && var1.Q().b("doTileDrops")) {
         vz var6 = new vz(var1);
         var6.b((double)var2.n() + 0.5D, (double)var2.o(), (double)var2.p() + 0.5D, 0.0F, 0.0F);
         var1.d((pk)var6);
         var6.y();
      }

   }

   public void a(zw var1, yz var2, List<zx> var3) {
      ahz.a[] var4 = ahz.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         ahz.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public static boolean d(alz var0) {
      afh var1 = var0.c();
      return var0 == afi.b.Q().a(ajy.a, ajy.a.a) || var1 == afi.e || var1 == afi.bf;
   }

   public int j(adm var1, cj var2) {
      alz var3 = var1.p(var2);
      return var3.c().c(var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   protected zx i(alz var1) {
      switch((ahz.a)var1.b(a)) {
      case b:
         return new zx(afi.e);
      case c:
         return new zx(afi.bf);
      case d:
         return new zx(afi.bf, 1, ajz.a.b.a());
      case e:
         return new zx(afi.bf, 1, ajz.a.c.a());
      case f:
         return new zx(afi.bf, 1, ajz.a.d.a());
      default:
         return new zx(afi.b);
      }
   }

   public static enum a implements nw {
      private final String j;
      e(4, "cracked_brick", "crackedbrick") {
         public alz d() {
            return afi.bf.Q().a(ajz.a, ajz.a.c);
         }
      };

      private static final ahz.a[] k = new ahz.a[]{a, b, c, d, e, f};
      f(5, "chiseled_brick", "chiseledbrick") {
         public alz d() {
            return afi.bf.Q().a(ajz.a, ajz.a.d);
         }
      };

      private final String i;
      private static final ahz.a[] g = new ahz.a[values().length];
      d(3, "mossy_brick", "mossybrick") {
         public alz d() {
            return afi.bf.Q().a(ajz.a, ajz.a.b);
         }
      },
      c(2, "stone_brick", "brick") {
         public alz d() {
            return afi.bf.Q().a(ajz.a, ajz.a.a);
         }
      },
      b(1, "cobblestone", "cobble") {
         public alz d() {
            return afi.e.Q();
         }
      },
      a(0, "stone") {
         public alz d() {
            return afi.b.Q().a(ajy.a, ajy.a.a);
         }
      };

      private final int h;

      public String c() {
         return this.j;
      }

      private a(int var3, String var4) {
         this(var3, var4, var4);
      }

      public abstract alz d();

      public String l() {
         return this.i;
      }

      static {
         ahz.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            ahz.a var3 = var0[var2];
            g[var3.a()] = var3;
         }

      }

      public static ahz.a a(int var0) {
         if (var0 < 0 || var0 >= g.length) {
            var0 = 0;
         }

         return g[var0];
      }

      private a(int var3, String var4, String var5) {
         this.h = var3;
         this.i = var4;
         this.j = var5;
      }

      public String toString() {
         return this.i;
      }

      a(int var3, String var4, Object var5) {
         this(var3, var4);
      }

      a(int var3, String var4, String var5, Object var6) {
         this(var3, var4, var5);
      }

      public static ahz.a a(alz var0) {
         ahz.a[] var1 = values();
         int var2 = var1.length;

         for(int var3 = 0; var3 < var2; ++var3) {
            ahz.a var4 = var1[var3];
            if (var0 == var4.d()) {
               return var4;
            }
         }

         return a;
      }

      public int a() {
         return this.h;
      }
   }
}
