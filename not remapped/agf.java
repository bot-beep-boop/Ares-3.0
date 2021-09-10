import java.util.List;

public class agf extends afh {
   public static final amm<agf.a> a = amm.a("variant", agf.a.class);
   public static final amk b = amk.a("snowy");

   public alz a(alz var1, adq var2, cj var3) {
      if (var1.b(a) == agf.a.c) {
         afh var4 = var2.p(var3.a()).c();
         var1 = var1.a(b, var4 == afi.aJ || var4 == afi.aH);
      }

      return var1;
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(this, 1, agf.a.a.a()));
      var3.add(new zx(this, 1, agf.a.b.a()));
      var3.add(new zx(this, 1, agf.a.c.a()));
   }

   public int a(alz var1) {
      agf.a var2 = (agf.a)var1.b(a);
      if (var2 == agf.a.c) {
         var2 = agf.a.a;
      }

      return var2.a();
   }

   public arn g(alz var1) {
      return ((agf.a)var1.b(a)).d();
   }

   public alz a(int var1) {
      return this.Q().a(a, agf.a.a(var1));
   }

   public int c(alz var1) {
      return ((agf.a)var1.b(a)).a();
   }

   protected agf() {
      super(arm.c);
      this.j(this.M.b().a(a, agf.a.a).a(b, false));
      this.a(yz.b);
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b});
   }

   public int j(adm var1, cj var2) {
      alz var3 = var1.p(var2);
      return var3.c() != this ? 0 : ((agf.a)var3.b(a)).a();
   }

   public static enum a implements nw {
      private final arn h;
      private final String g;
      private static final agf.a[] d = new agf.a[values().length];
      private final int e;
      a(0, "dirt", "default", arn.l),
      b(1, "coarse_dirt", "coarse", arn.l);

      private final String f;
      c(2, "podzol", arn.J);

      private static final agf.a[] i = new agf.a[]{a, b, c};

      public String c() {
         return this.g;
      }

      private a(int var3, String var4, arn var5) {
         this(var3, var4, var4, var5);
      }

      public String l() {
         return this.f;
      }

      static {
         agf.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            agf.a var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }

      public int a() {
         return this.e;
      }

      public String toString() {
         return this.f;
      }

      public arn d() {
         return this.h;
      }

      private a(int var3, String var4, String var5, arn var6) {
         this.e = var3;
         this.f = var4;
         this.g = var5;
         this.h = var6;
      }

      public static agf.a a(int var0) {
         if (var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }
   }
}
