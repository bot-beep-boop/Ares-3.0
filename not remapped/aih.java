import java.util.List;
import java.util.Random;

public abstract class aih extends ahh {
   public static final amk b = amk.a("seamless");
   public static final amm<aih.a> N = amm.a("variant", aih.a.class);

   public alz a(int var1) {
      alz var2 = this.Q().a(N, aih.a.a(var1 & 7));
      if (this.l()) {
         var2 = var2.a(b, (var1 & 8) != 0);
      } else {
         var2 = var2.a(a, (var1 & 8) == 0 ? ahh.a.b : ahh.a.a);
      }

      return var2;
   }

   public amo<?> n() {
      return N;
   }

   public int a(alz var1) {
      return ((aih.a)var1.b(N)).a();
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      if (var1 != zw.a((afh)afi.cO)) {
         aih.a[] var4 = aih.a.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            aih.a var7 = var4[var6];
            var3.add(new zx(var1, 1, var7.a()));
         }

      }
   }

   protected ama e() {
      return this.l() ? new ama(this, new amo[]{b, N}) : new ama(this, new amo[]{a, N});
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a((afh)afi.cP);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3 = var2 | ((aih.a)var1.b(N)).a();
      if (this.l()) {
         if ((Boolean)var1.b(b)) {
            var3 |= 8;
         }
      } else if (var1.b(a) == ahh.a.a) {
         var3 |= 8;
      }

      return var3;
   }

   public Object a(zx var1) {
      return aih.a.a(var1.i() & 7);
   }

   public String f() {
      return di.a(this.a() + ".red_sandstone.name");
   }

   public arn g(alz var1) {
      return ((aih.a)var1.b(N)).c();
   }

   public zw c(adm var1, cj var2) {
      return zw.a((afh)afi.cP);
   }

   public aih() {
      super(arm.e);
      alz var1 = this.M.b();
      if (this.l()) {
         var1 = var1.a(b, false);
      } else {
         var1 = var1.a(a, ahh.a.b);
      }

      this.j(var1.a(N, aih.a.a));
      this.a((yz)yz.b);
   }

   public String b(int var1) {
      return super.a() + "." + aih.a.a(var1).d();
   }

   public static enum a implements nw {
      private final int c;
      private static final aih.a[] f = new aih.a[]{a};
      private static final aih.a[] b = new aih.a[values().length];
      private final arn e;
      a(0, "red_sandstone", ajh.a.b.c());

      private final String d;

      public static aih.a a(int var0) {
         if (var0 < 0 || var0 >= b.length) {
            var0 = 0;
         }

         return b[var0];
      }

      private a(int var3, String var4, arn var5) {
         this.c = var3;
         this.d = var4;
         this.e = var5;
      }

      public int a() {
         return this.c;
      }

      public String d() {
         return this.d;
      }

      public String l() {
         return this.d;
      }

      static {
         aih.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            aih.a var3 = var0[var2];
            b[var3.a()] = var3;
         }

      }

      public arn c() {
         return this.e;
      }

      public String toString() {
         return this.d;
      }
   }
}
