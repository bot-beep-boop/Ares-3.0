import com.google.common.collect.AbstractIterator;
import java.util.Iterator;

public class cj extends df {
   public static final cj a = new cj(0, 0, 0);
   private static final int d;
   private static final long h;
   private static final int e;
   private static final long i;
   private static final int g;
   private static final int c = 1 + ns.c(ns.b(30000000));
   private static final long j;
   private static final int f;

   public cj g(int var1) {
      return this.a(cq.f, var1);
   }

   public static Iterable<cj.a> b(cj var0, cj var1) {
      cj var2 = new cj(Math.min(var0.n(), var1.n()), Math.min(var0.o(), var1.o()), Math.min(var0.p(), var1.p()));
      cj var3 = new cj(Math.max(var0.n(), var1.n()), Math.max(var0.o(), var1.o()), Math.max(var0.p(), var1.p()));
      return new Iterable<cj.a>(var2, var3) {
         final cj a;
         final cj b;

         public Iterator<cj.a> iterator() {
            return new AbstractIterator<cj.a>(this) {
               final <undefinedtype> a;
               private cj.a b;

               protected cj.a a() {
                  if (this.b == null) {
                     this.b = new cj.a(this.a.a.n(), this.a.a.o(), this.a.a.p());
                     return this.b;
                  } else if (this.b.equals(this.a.b)) {
                     return (cj.a)this.endOfData();
                  } else {
                     int var1 = this.b.n();
                     int var2 = this.b.o();
                     int var3 = this.b.p();
                     if (var1 < this.a.b.n()) {
                        ++var1;
                     } else if (var2 < this.a.b.o()) {
                        var1 = this.a.a.n();
                        ++var2;
                     } else if (var3 < this.a.b.p()) {
                        var1 = this.a.a.n();
                        var2 = this.a.a.o();
                        ++var3;
                     }

                     cj.a.a(this.b, var1);
                     cj.a.b(this.b, var2);
                     cj.a.c(this.b, var3);
                     return this.b;
                  }
               }

               {
                  this.a = var1;
                  this.b = null;
               }

               protected Object computeNext() {
                  return this.a();
               }
            };
         }

         {
            this.a = var1;
            this.b = var2;
         }
      };
   }

   public long g() {
      return ((long)this.n() & h) << g | ((long)this.o() & i) << f | ((long)this.p() & j) << 0;
   }

   public cj c() {
      return this.d(1);
   }

   public cj e(int var1) {
      return this.a(cq.d, var1);
   }

   public cj b(int var1) {
      return this.a(cq.b, var1);
   }

   public cj a(df var1) {
      return var1.n() == 0 && var1.o() == 0 && var1.p() == 0 ? this : new cj(this.n() + var1.n(), this.o() + var1.o(), this.p() + var1.p());
   }

   public cj f(int var1) {
      return this.a(cq.e, var1);
   }

   public cj(df var1) {
      this(var1.n(), var1.o(), var1.p());
   }

   public cj(aui var1) {
      this(var1.a, var1.b, var1.c);
   }

   public cj c(int var1) {
      return this.a(cq.a, var1);
   }

   public cj a() {
      return this.b(1);
   }

   public static Iterable<cj> a(cj var0, cj var1) {
      cj var2 = new cj(Math.min(var0.n(), var1.n()), Math.min(var0.o(), var1.o()), Math.min(var0.p(), var1.p()));
      cj var3 = new cj(Math.max(var0.n(), var1.n()), Math.max(var0.o(), var1.o()), Math.max(var0.p(), var1.p()));
      return new Iterable<cj>(var2, var3) {
         final cj b;
         final cj a;

         public Iterator<cj> iterator() {
            return new AbstractIterator<cj>(this) {
               private cj b;
               final <undefinedtype> a;

               protected Object computeNext() {
                  return this.a();
               }

               {
                  this.a = var1;
                  this.b = null;
               }

               protected cj a() {
                  if (this.b == null) {
                     this.b = this.a.a;
                     return this.b;
                  } else if (this.b.equals(this.a.b)) {
                     return (cj)this.endOfData();
                  } else {
                     int var1 = this.b.n();
                     int var2 = this.b.o();
                     int var3 = this.b.p();
                     if (var1 < this.a.b.n()) {
                        ++var1;
                     } else if (var2 < this.a.b.o()) {
                        var1 = this.a.a.n();
                        ++var2;
                     } else if (var3 < this.a.b.p()) {
                        var1 = this.a.a.n();
                        var2 = this.a.a.o();
                        ++var3;
                     }

                     this.b = new cj(var1, var2, var3);
                     return this.b;
                  }
               }
            };
         }

         {
            this.a = var1;
            this.b = var2;
         }
      };
   }

   public cj f() {
      return this.g(1);
   }

   public cj a(double var1, double var3, double var5) {
      return var1 == 0.0D && var3 == 0.0D && var5 == 0.0D ? this : new cj((double)this.n() + var1, (double)this.o() + var3, (double)this.p() + var5);
   }

   public cj a(int var1, int var2, int var3) {
      return var1 == 0 && var2 == 0 && var3 == 0 ? this : new cj(this.n() + var1, this.o() + var2, this.p() + var3);
   }

   public cj d() {
      return this.e(1);
   }

   static {
      d = c;
      e = 64 - c - d;
      f = 0 + d;
      g = f + e;
      h = (1L << c) - 1L;
      i = (1L << e) - 1L;
      j = (1L << d) - 1L;
   }

   public cj(double var1, double var3, double var5) {
      super(var1, var3, var5);
   }

   public cj a(cq var1, int var2) {
      return var2 == 0 ? this : new cj(this.n() + var1.g() * var2, this.o() + var1.h() * var2, this.p() + var1.i() * var2);
   }

   public cj d(int var1) {
      return this.a(cq.c, var1);
   }

   public cj c(df var1) {
      return new cj(this.o() * var1.p() - this.p() * var1.o(), this.p() * var1.n() - this.n() * var1.p(), this.n() * var1.o() - this.o() * var1.n());
   }

   public df d(df var1) {
      return this.c(var1);
   }

   public cj e() {
      return this.f(1);
   }

   public cj b() {
      return this.c(1);
   }

   public static cj a(long var0) {
      int var2 = (int)(var0 << 64 - g - c >> 64 - c);
      int var3 = (int)(var0 << 64 - f - e >> 64 - e);
      int var4 = (int)(var0 << 64 - d >> 64 - d);
      return new cj(var2, var3, var4);
   }

   public cj b(df var1) {
      return var1.n() == 0 && var1.o() == 0 && var1.p() == 0 ? this : new cj(this.n() - var1.n(), this.o() - var1.o(), this.p() - var1.p());
   }

   public cj(pk var1) {
      this(var1.s, var1.t, var1.u);
   }

   public cj a(cq var1) {
      return this.a(var1, 1);
   }

   public cj(int var1, int var2, int var3) {
      super(var1, var2, var3);
   }

   public static final class a extends cj {
      private int d;
      private int e;
      private int c;

      public df d(df var1) {
         return super.c(var1);
      }

      static int c(cj.a var0, int var1) {
         return var0.e = var1;
      }

      public int o() {
         return this.d;
      }

      static int b(cj.a var0, int var1) {
         return var0.d = var1;
      }

      public a() {
         this(0, 0, 0);
      }

      public cj.a c(int var1, int var2, int var3) {
         this.c = var1;
         this.d = var2;
         this.e = var3;
         return this;
      }

      public a(int var1, int var2, int var3) {
         super(0, 0, 0);
         this.c = var1;
         this.d = var2;
         this.e = var3;
      }

      static int a(cj.a var0, int var1) {
         return var0.c = var1;
      }

      public int p() {
         return this.e;
      }

      public int n() {
         return this.c;
      }
   }
}
