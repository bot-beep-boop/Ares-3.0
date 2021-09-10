import java.util.List;
import java.util.Random;

public class akc extends afm implements afj {
   public static final amm<akc.a> a = amm.a("type", akc.a.class);

   public boolean a(adm var1, Random var2, cj var3, alz var4) {
      return true;
   }

   public boolean a(adm var1, cj var2, alz var3, boolean var4) {
      return var3.b(a) != akc.a.a;
   }

   public boolean a(adm var1, cj var2) {
      return true;
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      for(int var4 = 1; var4 < 3; ++var4) {
         var3.add(new zx(var1, 1, var4));
      }

   }

   public int c(alz var1) {
      return ((akc.a)var1.b(a)).a();
   }

   public zw a(alz var1, Random var2, int var3) {
      return var2.nextInt(8) == 0 ? zy.N : null;
   }

   public int H() {
      return adl.a(0.5D, 1.0D);
   }

   public afh.a R() {
      return afh.a.c;
   }

   public void b(adm var1, Random var2, cj var3, alz var4) {
      agi.b var5 = agi.b.c;
      if (var4.b(a) == akc.a.c) {
         var5 = agi.b.d;
      }

      if (afi.cF.d(var1, var3)) {
         afi.cF.a(var1, var3, var5, 2);
      }

   }

   public alz a(int var1) {
      return this.Q().a(a, akc.a.a(var1));
   }

   public int j(adm var1, cj var2) {
      alz var3 = var1.p(var2);
      return var3.c().c(var3);
   }

   public boolean f(adm var1, cj var2, alz var3) {
      return this.c(var1.p(var2.b()).c());
   }

   protected akc() {
      super(arm.l);
      this.j(this.M.b().a(a, akc.a.a));
      float var1 = 0.4F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.8F, 0.5F + var1);
   }

   public int a(adq var1, cj var2, int var3) {
      return var1.b(var2).b(var2);
   }

   public int a(int var1, Random var2) {
      return 1 + var2.nextInt(var1 * 2 + 1);
   }

   public void a(adm var1, wn var2, cj var3, alz var4, akw var5) {
      if (!var1.D && var2.bZ() != null && var2.bZ().b() == zy.be) {
         var2.b(na.ab[afh.a((afh)this)]);
         a(var1, var3, new zx(afi.H, 1, ((akc.a)var4.b(a)).a()));
      } else {
         super.a(var1, var2, var3, var4, var5);
      }

   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public int h(alz var1) {
      if (var1.c() != this) {
         return super.h(var1);
      } else {
         akc.a var2 = (akc.a)var1.b(a);
         return var2 == akc.a.a ? 16777215 : adl.a(0.5D, 1.0D);
      }
   }

   public static enum a implements nw {
      private final String f;
      b(1, "tall_grass");

      private static final akc.a[] g = new akc.a[]{a, b, c};
      private static final akc.a[] d = new akc.a[values().length];
      a(0, "dead_bush"),
      c(2, "fern");

      private final int e;

      static {
         akc.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            akc.a var3 = var0[var2];
            d[var3.a()] = var3;
         }

      }

      public String toString() {
         return this.f;
      }

      public int a() {
         return this.e;
      }

      public static akc.a a(int var0) {
         if (var0 < 0 || var0 >= d.length) {
            var0 = 0;
         }

         return d[var0];
      }

      private a(int var3, String var4) {
         this.e = var3;
         this.f = var4;
      }

      public String l() {
         return this.f;
      }
   }
}
