import java.util.List;

public class akl extends afh {
   public static final amk N = amk.a("east");
   public static final amk P = amk.a("west");
   public static final amk O = amk.a("south");
   public static final amk b = amk.a("north");
   public static final amm<akl.a> Q = amm.a("variant", akl.a.class);
   public static final amk a = amk.a("up");

   public int c(alz var1) {
      return ((akl.a)var1.b(Q)).a();
   }

   public int a(alz var1) {
      return ((akl.a)var1.b(Q)).a();
   }

   public boolean d() {
      return false;
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      akl.a[] var4 = akl.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         akl.a var7 = var4[var6];
         var3.add(new zx(var1, 1, var7.a()));
      }

   }

   public String f() {
      return di.a(this.a() + "." + akl.a.a.c() + ".name");
   }

   public boolean b(adq var1, cj var2) {
      return false;
   }

   protected ama e() {
      return new ama(this, new amo[]{a, b, N, P, O, Q});
   }

   public akl(afh var1) {
      super(var1.J);
      this.j(this.M.b().a(a, false).a(b, false).a(N, false).a(O, false).a(P, false).a(Q, akl.a.a));
      this.c(var1.w);
      this.b(var1.x / 3.0F);
      this.a(var1.H);
      this.a(yz.b);
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return var3 == cq.a ? super.a(var1, var2, var3) : true;
   }

   public alz a(alz var1, adq var2, cj var3) {
      return var1.a(a, !var2.d(var3.a())).a(b, this.e(var2, var3.c())).a(N, this.e(var2, var3.f())).a(O, this.e(var2, var3.d())).a(P, this.e(var2, var3.e()));
   }

   public aug a(adm var1, cj var2, alz var3) {
      this.a(var1, var2);
      this.F = 1.5D;
      return super.a(var1, var2, var3);
   }

   public alz a(int var1) {
      return this.Q().a(Q, akl.a.a(var1));
   }

   public boolean c() {
      return false;
   }

   public void a(adq var1, cj var2) {
      boolean var3 = this.e(var1, var2.c());
      boolean var4 = this.e(var1, var2.d());
      boolean var5 = this.e(var1, var2.e());
      boolean var6 = this.e(var1, var2.f());
      float var7 = 0.25F;
      float var8 = 0.75F;
      float var9 = 0.25F;
      float var10 = 0.75F;
      float var11 = 1.0F;
      if (var3) {
         var9 = 0.0F;
      }

      if (var4) {
         var10 = 1.0F;
      }

      if (var5) {
         var7 = 0.0F;
      }

      if (var6) {
         var8 = 1.0F;
      }

      if (var3 && var4 && !var5 && !var6) {
         var11 = 0.8125F;
         var7 = 0.3125F;
         var8 = 0.6875F;
      } else if (!var3 && !var4 && var5 && var6) {
         var11 = 0.8125F;
         var9 = 0.3125F;
         var10 = 0.6875F;
      }

      this.a(var7, 0.0F, var9, var8, var11, var10);
   }

   public boolean e(adq var1, cj var2) {
      afh var3 = var1.p(var2).c();
      if (var3 == afi.cv) {
         return false;
      } else if (var3 != this && !(var3 instanceof agu)) {
         if (var3.J.k() && var3.d()) {
            return var3.J != arm.C;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   public static enum a implements nw {
      private String f;
      a(0, "cobblestone", "normal");

      private static final akl.a[] c = new akl.a[values().length];
      private final String e;
      private final int d;
      private static final akl.a[] g = new akl.a[]{a, b};
      b(1, "mossy_cobblestone", "mossy");

      public String l() {
         return this.e;
      }

      private a(int var3, String var4, String var5) {
         this.d = var3;
         this.e = var4;
         this.f = var5;
      }

      static {
         akl.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            akl.a var3 = var0[var2];
            c[var3.a()] = var3;
         }

      }

      public static akl.a a(int var0) {
         if (var0 < 0 || var0 >= c.length) {
            var0 = 0;
         }

         return c[var0];
      }

      public int a() {
         return this.d;
      }

      public String c() {
         return this.f;
      }

      public String toString() {
         return this.e;
      }
   }
}
