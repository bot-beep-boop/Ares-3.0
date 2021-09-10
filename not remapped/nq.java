public class nq<V> {
   private int c;
   private final float e = 0.75F;
   private transient int f;
   private int d = 3072;
   private transient int b;
   private transient nq.a<V>[] a = new nq.a[4096];

   private void a(nq.a<V>[] var1) {
      nq.a[] var2 = this.a;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         nq.a var5 = var2[var4];
         if (var5 != null) {
            var2[var4] = null;

            nq.a var6;
            do {
               var6 = var5.c;
               int var7 = a(var5.d, var3 - 1);
               var5.c = var1[var7];
               var1[var7] = var5;
               var5 = var6;
            } while(var6 != null);
         }
      }

   }

   public nq() {
      this.c = this.a.length - 1;
   }

   public V a(long var1) {
      int var3 = g(var1);

      for(nq.a var4 = this.a[a(var3, this.c)]; var4 != null; var4 = var4.c) {
         if (var4.a == var1) {
            return var4.b;
         }
      }

      return null;
   }

   public int a() {
      return this.b;
   }

   private static int a(int var0) {
      var0 ^= var0 >>> 20 ^ var0 >>> 12;
      return var0 ^ var0 >>> 7 ^ var0 >>> 4;
   }

   private void a(int var1, long var2, V var4, int var5) {
      nq.a var6 = this.a[var5];
      this.a[var5] = new nq.a(var1, var2, var4, var6);
      if (this.b++ >= this.d) {
         this.b(2 * this.a.length);
      }

   }

   public V d(long var1) {
      nq.a var3 = this.e(var1);
      return var3 == null ? null : var3.b;
   }

   private void b(int var1) {
      nq.a[] var2 = this.a;
      int var3 = var2.length;
      if (var3 == 1073741824) {
         this.d = Integer.MAX_VALUE;
      } else {
         nq.a[] var4 = new nq.a[var1];
         this.a(var4);
         this.a = var4;
         this.c = this.a.length - 1;
         this.d = (int)((float)var1 * this.e);
      }
   }

   final nq.a<V> c(long var1) {
      int var3 = g(var1);

      for(nq.a var4 = this.a[a(var3, this.c)]; var4 != null; var4 = var4.c) {
         if (var4.a == var1) {
            return var4;
         }
      }

      return null;
   }

   final nq.a<V> e(long var1) {
      int var3 = g(var1);
      int var4 = a(var3, this.c);
      nq.a var5 = this.a[var4];

      nq.a var6;
      nq.a var7;
      for(var6 = var5; var6 != null; var6 = var7) {
         var7 = var6.c;
         if (var6.a == var1) {
            ++this.f;
            --this.b;
            if (var5 == var6) {
               this.a[var4] = var7;
            } else {
               var5.c = var7;
            }

            return var6;
         }

         var5 = var6;
      }

      return var6;
   }

   private static int a(int var0, int var1) {
      return var0 & var1;
   }

   public void a(long var1, V var3) {
      int var4 = g(var1);
      int var5 = a(var4, this.c);

      for(nq.a var6 = this.a[var5]; var6 != null; var6 = var6.c) {
         if (var6.a == var1) {
            var6.b = var3;
            return;
         }
      }

      ++this.f;
      this.a(var4, var1, var3, var5);
   }

   public boolean b(long var1) {
      return this.c(var1) != null;
   }

   private static int g(long var0) {
      return a((int)(var0 ^ var0 >>> 32));
   }

   static int f(long var0) {
      return g(var0);
   }

   static class a<V> {
      final long a;
      final int d;
      V b;
      nq.a<V> c;

      a(int var1, long var2, V var4, nq.a<V> var5) {
         this.b = var4;
         this.c = var5;
         this.a = var2;
         this.d = var1;
      }

      public final String toString() {
         return this.a() + "=" + this.b();
      }

      public final V b() {
         return this.b;
      }

      public final boolean equals(Object var1) {
         if (!(var1 instanceof nq.a)) {
            return false;
         } else {
            nq.a var2 = (nq.a)var1;
            Long var3 = this.a();
            Long var4 = var2.a();
            if (var3 == var4 || var3 != null && var3.equals(var4)) {
               Object var5 = this.b();
               Object var6 = var2.b();
               if (var5 == var6 || var5 != null && var5.equals(var6)) {
                  return true;
               }
            }

            return false;
         }
      }

      public final int hashCode() {
         return nq.f(this.a);
      }

      public final long a() {
         return this.a;
      }
   }
}
