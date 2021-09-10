import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public class zp extends zs {
   private final boolean b;

   public void a(zw var1, yz var2, List<zx> var3) {
      zp.a[] var4 = zp.a.values();
      int var5 = var4.length;

      for(int var6 = 0; var6 < var5; ++var6) {
         zp.a var7 = var4[var6];
         if (!this.b || var7.g()) {
            var3.add(new zx(this, 1, var7.a()));
         }
      }

   }

   public float i(zx var1) {
      zp.a var2 = zp.a.a(var1);
      return this.b && var2.g() ? var2.f() : var2.d();
   }

   protected void c(zx var1, adm var2, wn var3) {
      zp.a var4 = zp.a.a(var1);
      if (var4 == zp.a.d) {
         var3.c(new pf(pe.u.H, 1200, 3));
         var3.c(new pf(pe.s.H, 300, 2));
         var3.c(new pf(pe.k.H, 300, 1));
      }

      super.c(var1, var2, var3);
   }

   public int h(zx var1) {
      zp.a var2 = zp.a.a(var1);
      return this.b && var2.g() ? var2.e() : var2.c();
   }

   public String j(zx var1) {
      return zp.a.a(var1) == zp.a.d ? abe.m : null;
   }

   public String e_(zx var1) {
      zp.a var2 = zp.a.a(var1);
      return this.a() + "." + var2.b() + "." + (this.b && var2.g() ? "cooked" : "raw");
   }

   public zp(boolean var1) {
      super(0, 0.0F, false);
      this.b = var1;
   }

   public static enum a {
      private final int j;
      private final String g;
      private boolean l = false;
      private static final zp.a[] m = new zp.a[]{a, b, c, d};
      d(3, "pufferfish", 1, 0.1F);

      private static final Map<Integer, zp.a> e = Maps.newHashMap();
      private final float k;
      private final int h;
      private final int f;
      b(1, "salmon", 2, 0.1F, 6, 0.8F),
      a(0, "cod", 2, 0.1F, 5, 0.6F),
      c(2, "clownfish", 1, 0.1F);

      private final float i;

      public int c() {
         return this.h;
      }

      public int a() {
         return this.f;
      }

      public boolean g() {
         return this.l;
      }

      static {
         zp.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            zp.a var3 = var0[var2];
            e.put(var3.a(), var3);
         }

      }

      public static zp.a a(int var0) {
         zp.a var1 = (zp.a)e.get(var0);
         return var1 == null ? a : var1;
      }

      public float f() {
         return this.k;
      }

      public int e() {
         return this.j;
      }

      public String b() {
         return this.g;
      }

      private a(int var3, String var4, int var5, float var6, int var7, float var8) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
         this.j = var7;
         this.k = var8;
         this.l = true;
      }

      public float d() {
         return this.i;
      }

      private a(int var3, String var4, int var5, float var6) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
         this.j = 0;
         this.k = 0.0F;
         this.l = false;
      }

      public static zp.a a(zx var0) {
         return var0.b() instanceof zp ? a(var0.i()) : a;
      }
   }
}
