import java.util.List;

public class aiw extends afh {
   public static final amm<aiw.a> a = amm.a("variant", aiw.a.class);

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public int c(alz var1) {
      return ((aiw.a)var1.b(a)).a();
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      if (var7 == aiw.a.c.a()) {
         switch(var3.k()) {
         case c:
            return this.Q().a(a, aiw.a.e);
         case a:
            return this.Q().a(a, aiw.a.d);
         case b:
         default:
            return this.Q().a(a, aiw.a.c);
         }
      } else {
         return var7 == aiw.a.b.a() ? this.Q().a(a, aiw.a.b) : this.Q().a(a, aiw.a.a);
      }
   }

   public aiw() {
      super(arm.e);
      this.j(this.M.b().a(a, aiw.a.a));
      this.a(yz.b);
   }

   protected zx i(alz var1) {
      aiw.a var2 = (aiw.a)var1.b(a);
      return var2 != aiw.a.d && var2 != aiw.a.e ? super.i(var1) : new zx(zw.a((afh)this), 1, aiw.a.c.a());
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(var1, 1, aiw.a.a.a()));
      var3.add(new zx(var1, 1, aiw.a.b.a()));
      var3.add(new zx(var1, 1, aiw.a.c.a()));
   }

   public arn g(alz var1) {
      return arn.p;
   }

   public int a(alz var1) {
      aiw.a var2 = (aiw.a)var1.b(a);
      return var2 != aiw.a.d && var2 != aiw.a.e ? var2.a() : aiw.a.c.a();
   }

   public alz a(int var1) {
      return this.Q().a(a, aiw.a.a(var1));
   }

   public static enum a implements nw {
      private final String h;
      private final int g;
      private static final aiw.a[] j = new aiw.a[]{a, b, c, d, e};
      c(2, "lines_y", "lines"),
      d(3, "lines_x", "lines"),
      a(0, "default", "default");

      private static final aiw.a[] f = new aiw.a[values().length];
      b(1, "chiseled", "chiseled");

      private final String i;
      e(4, "lines_z", "lines");

      public static aiw.a a(int var0) {
         if (var0 < 0 || var0 >= f.length) {
            var0 = 0;
         }

         return f[var0];
      }

      static {
         aiw.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            aiw.a var3 = var0[var2];
            f[var3.a()] = var3;
         }

      }

      public String l() {
         return this.h;
      }

      private a(int var3, String var4, String var5) {
         this.g = var3;
         this.h = var4;
         this.i = var5;
      }

      public String toString() {
         return this.i;
      }

      public int a() {
         return this.g;
      }
   }
}
