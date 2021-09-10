public class nm<V> {
   private int c = 12;
   private transient int b;
   private transient nm.a<V>[] a = new nm.a[16];
   private final float d = 0.75F;

   private void a(nm.a<V>[] var1) {
      nm.a[] var2 = this.a;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         nm.a var5 = var2[var4];
         if (var5 != null) {
            var2[var4] = null;

            nm.a var6;
            do {
               var6 = var5.c;
               int var7 = a(var5.d, var3);
               var5.c = var1[var7];
               var1[var7] = var5;
               var5 = var6;
            } while(var6 != null);
         }
      }

   }

   private static int a(int var0, int var1) {
      return var0 & var1 - 1;
   }

   final nm.a<V> e(int var1) {
      int var2 = g(var1);
      int var3 = a(var2, this.a.length);
      nm.a var4 = this.a[var3];

      nm.a var5;
      nm.a var6;
      for(var5 = var4; var5 != null; var5 = var6) {
         var6 = var5.c;
         if (var5.a == var1) {
            --this.b;
            if (var4 == var5) {
               this.a[var3] = var6;
            } else {
               var4.c = var6;
            }

            return var5;
         }

         var4 = var5;
      }

      return var5;
   }

   public void c() {
      nm.a[] var1 = this.a;

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = null;
      }

      this.b = 0;
   }

   public void a(int var1, V var2) {
      int var3 = g(var1);
      int var4 = a(var3, this.a.length);

      for(nm.a var5 = this.a[var4]; var5 != null; var5 = var5.c) {
         if (var5.a == var1) {
            var5.b = var2;
            return;
         }
      }

      this.a(var3, var1, var2, var4);
   }

   public V d(int var1) {
      nm.a var2 = this.e(var1);
      return var2 == null ? null : var2.b;
   }

   public boolean b(int var1) {
      return this.c(var1) != null;
   }

   private void h(int var1) {
      nm.a[] var2 = this.a;
      int var3 = var2.length;
      if (var3 == 1073741824) {
         this.c = Integer.MAX_VALUE;
      } else {
         nm.a[] var4 = new nm.a[var1];
         this.a(var4);
         this.a = var4;
         this.c = (int)((float)var1 * this.d);
      }
   }

   private void a(int var1, int var2, V var3, int var4) {
      nm.a var5 = this.a[var4];
      this.a[var4] = new nm.a(var1, var2, var3, var5);
      if (this.b++ >= this.c) {
         this.h(2 * this.a.length);
      }

   }

   final nm.a<V> c(int var1) {
      int var2 = g(var1);

      for(nm.a var3 = this.a[a(var2, this.a.length)]; var3 != null; var3 = var3.c) {
         if (var3.a == var1) {
            return var3;
         }
      }

      return null;
   }

   static int f(int var0) {
      return g(var0);
   }

   public V a(int var1) {
      int var2 = g(var1);

      for(nm.a var3 = this.a[a(var2, this.a.length)]; var3 != null; var3 = var3.c) {
         if (var3.a == var1) {
            return var3.b;
         }
      }

      return null;
   }

   private static int g(int var0) {
      var0 ^= var0 >>> 20 ^ var0 >>> 12;
      return var0 ^ var0 >>> 7 ^ var0 >>> 4;
   }

   static class a<V> {
      final int d;
      final int a;
      nm.a<V> c;
      V b;

      public final String toString() {
         return this.a() + "=" + this.b();
      }

      public final V b() {
         return this.b;
      }

      public final int hashCode() {
         return nm.f(this.a);
      }

      a(int var1, int var2, V var3, nm.a<V> var4) {
         this.b = var3;
         this.c = var4;
         this.a = var2;
         this.d = var1;
      }

      public final boolean equals(Object var1) {
         if (!(var1 instanceof nm.a)) {
            return false;
         } else {
            nm.a var2 = (nm.a)var1;
            Integer var3 = this.a();
            Integer var4 = var2.a();
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

      public final int a() {
         return this.a;
      }
   }
}
