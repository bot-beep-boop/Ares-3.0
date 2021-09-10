import com.google.common.base.Predicate;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public enum cq implements nw {
   private final String j;
   b(1, 0, -1, "up", cq.b.a, cq.a.b, new df(0, 1, 0)),
   a(0, 1, -1, "down", cq.b.b, cq.a.b, new df(0, -1, 0)),
   c(2, 3, 2, "north", cq.b.b, cq.a.c, new df(0, 0, -1)),
   d(3, 2, 0, "south", cq.b.a, cq.a.c, new df(0, 0, 1)),
   f(5, 4, 3, "east", cq.b.a, cq.a.a, new df(1, 0, 0)),
   e(4, 5, 1, "west", cq.b.b, cq.a.a, new df(-1, 0, 0));

   private final df m;
   private static final cq[] o = new cq[4];
   private final int h;
   private final int i;
   private final int g;
   private static final cq[] n = new cq[6];
   private static final cq[] q = new cq[]{a, b, c, d, e, f};
   private static final Map<String, cq> p = Maps.newHashMap();
   private final cq.a k;
   private final cq.b l;

   public cq a(cq.a var1) {
      switch(var1) {
      case a:
         if (this != e && this != f) {
            return this.n();
         }

         return this;
      case b:
         if (this != b && this != a) {
            return this.e();
         }

         return this;
      case c:
         if (this != c && this != d) {
            return this.p();
         }

         return this;
      default:
         throw new IllegalStateException("Unable to get CW facing for axis " + var1);
      }
   }

   public cq.b c() {
      return this.l;
   }

   private cq p() {
      switch(this) {
      case f:
         return a;
      case d:
      default:
         throw new IllegalStateException("Unable to get Z-rotated facing of " + this);
      case e:
         return b;
      case b:
         return f;
      case a:
         return e;
      }
   }

   public int b() {
      return this.i;
   }

   public int i() {
      return this.k == cq.a.c ? this.l.a() : 0;
   }

   public cq f() {
      switch(this) {
      case c:
         return e;
      case f:
         return c;
      case d:
         return f;
      case e:
         return d;
      default:
         throw new IllegalStateException("Unable to get CCW facing of " + this);
      }
   }

   private cq n() {
      switch(this) {
      case c:
         return a;
      case f:
      case e:
      default:
         throw new IllegalStateException("Unable to get X-rotated facing of " + this);
      case d:
         return b;
      case b:
         return c;
      case a:
         return d;
      }
   }

   public static cq a(cq.b var0, cq.a var1) {
      cq[] var2 = values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         cq var5 = var2[var4];
         if (var5.c() == var0 && var5.k() == var1) {
            return var5;
         }
      }

      throw new IllegalArgumentException("No such direction: " + var0 + " " + var1);
   }

   public static cq a(double var0) {
      return b(ns.c(var0 / 90.0D + 0.5D) & 3);
   }

   public static cq a(Random var0) {
      return values()[var0.nextInt(values().length)];
   }

   public int a() {
      return this.g;
   }

   public cq e() {
      switch(this) {
      case c:
         return f;
      case f:
         return d;
      case d:
         return e;
      case e:
         return c;
      default:
         throw new IllegalStateException("Unable to get Y-rotated facing of " + this);
      }
   }

   public String j() {
      return this.j;
   }

   public static cq a(int var0) {
      return n[ns.a(var0 % n.length)];
   }

   public df m() {
      return this.m;
   }

   public static cq b(int var0) {
      return o[ns.a(var0 % o.length)];
   }

   public static cq a(float var0, float var1, float var2) {
      cq var3 = c;
      float var4 = Float.MIN_VALUE;
      cq[] var5 = values();
      int var6 = var5.length;

      for(int var7 = 0; var7 < var6; ++var7) {
         cq var8 = var5[var7];
         float var9 = var0 * (float)var8.m.n() + var1 * (float)var8.m.o() + var2 * (float)var8.m.p();
         if (var9 > var4) {
            var4 = var9;
            var3 = var8;
         }
      }

      return var3;
   }

   public cq.a k() {
      return this.k;
   }

   public String l() {
      return this.j;
   }

   public int h() {
      return this.k == cq.a.b ? this.l.a() : 0;
   }

   public int g() {
      return this.k == cq.a.a ? this.l.a() : 0;
   }

   public String toString() {
      return this.j;
   }

   public static cq a(String var0) {
      return var0 == null ? null : (cq)p.get(var0.toLowerCase());
   }

   static {
      cq[] var0 = values();
      int var1 = var0.length;

      for(int var2 = 0; var2 < var1; ++var2) {
         cq var3 = var0[var2];
         n[var3.g] = var3;
         if (var3.k().c()) {
            o[var3.i] = var3;
         }

         p.put(var3.j().toLowerCase(), var3);
      }

   }

   private cq(int var3, int var4, int var5, String var6, cq.b var7, cq.a var8, df var9) {
      this.g = var3;
      this.i = var5;
      this.h = var4;
      this.j = var6;
      this.k = var8;
      this.l = var7;
      this.m = var9;
   }

   public cq d() {
      return a(this.h);
   }

   public static enum c implements Predicate<cq>, Iterable<cq> {
      b,
      a;

      private static final cq.c[] c = new cq.c[]{a, b};

      public boolean a(cq var1) {
         return var1 != null && var1.k().d() == this;
      }

      public Iterator<cq> iterator() {
         return Iterators.forArray(this.a());
      }

      public cq a(Random var1) {
         cq[] var2 = this.a();
         return var2[var1.nextInt(var2.length)];
      }

      public cq[] a() {
         switch(this) {
         case a:
            return new cq[]{cq.c, cq.f, cq.d, cq.e};
         case b:
            return new cq[]{cq.b, cq.a};
         default:
            throw new Error("Someone's been tampering with the universe!");
         }
      }

      public boolean apply(Object var1) {
         return this.a((cq)var1);
      }
   }

   public static enum a implements Predicate<cq>, nw {
      private static final Map<String, cq.a> d = Maps.newHashMap();
      private static final cq.a[] g = new cq.a[]{a, b, c};
      private final cq.c f;
      private final String e;
      c("z", cq.c.a),
      b("y", cq.c.b),
      a("x", cq.c.a);

      public String l() {
         return this.e;
      }

      private a(String var3, cq.c var4) {
         this.e = var3;
         this.f = var4;
      }

      public String a() {
         return this.e;
      }

      public boolean b() {
         return this.f == cq.c.b;
      }

      public String toString() {
         return this.e;
      }

      public boolean apply(Object var1) {
         return this.a((cq)var1);
      }

      static {
         cq.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            cq.a var3 = var0[var2];
            d.put(var3.a().toLowerCase(), var3);
         }

      }

      public static cq.a a(String var0) {
         return var0 == null ? null : (cq.a)d.get(var0.toLowerCase());
      }

      public boolean c() {
         return this.f == cq.c.a;
      }

      public boolean a(cq var1) {
         return var1 != null && var1.k() == this;
      }

      public cq.c d() {
         return this.f;
      }
   }

   public static enum b {
      a(1, "Towards positive");

      private final int c;
      b(-1, "Towards negative");

      private final String d;
      private static final cq.b[] e = new cq.b[]{a, b};

      public int a() {
         return this.c;
      }

      public String toString() {
         return this.d;
      }

      private b(int var3, String var4) {
         this.c = var3;
         this.d = var4;
      }
   }
}
