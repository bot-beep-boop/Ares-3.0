import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bmf {
   private final int g;
   private final int i;
   private final int a;
   private final Set<bmf.a> b = Sets.newHashSetWithExpectedSize(256);
   private int e;
   private final boolean h;
   private int d;
   private final List<bmf.b> c = Lists.newArrayListWithCapacity(256);
   private final int f;

   public int b() {
      return this.e;
   }

   public void a(bmi var1) {
      bmf.a var2 = new bmf.a(var1, this.a);
      if (this.i > 0) {
         var2.a(this.i);
      }

      this.b.add(var2);
   }

   public bmf(int var1, int var2, boolean var3, int var4, int var5) {
      this.a = var5;
      this.f = var1;
      this.g = var2;
      this.h = var3;
      this.i = var4;
   }

   public int a() {
      return this.d;
   }

   static int a(int var0, int var1) {
      return b(var0, var1);
   }

   private boolean a(bmf.a var1) {
      for(int var2 = 0; var2 < this.c.size(); ++var2) {
         if (((bmf.b)this.c.get(var2)).a(var1)) {
            return true;
         }

         var1.d();
         if (((bmf.b)this.c.get(var2)).a(var1)) {
            return true;
         }

         var1.d();
      }

      return this.b(var1);
   }

   public void c() {
      bmf.a[] var1 = (bmf.a[])this.b.toArray(new bmf.a[this.b.size()]);
      Arrays.sort(var1);
      bmf.a[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         bmf.a var5 = var2[var4];
         if (!this.a(var5)) {
            String var6 = String.format("Unable to fit: %s - size: %dx%d - Maybe try a lowerresolution resourcepack?", var5.a().i(), var5.a().c(), var5.a().d());
            throw new bmg(var5, var6);
         }
      }

      if (this.h) {
         this.d = ns.b(this.d);
         this.e = ns.b(this.e);
      }

   }

   private boolean b(bmf.a var1) {
      int var2 = Math.min(var1.b(), var1.c());
      boolean var3 = this.d == 0 && this.e == 0;
      boolean var4;
      int var5;
      if (this.h) {
         var5 = ns.b(this.d);
         int var6 = ns.b(this.e);
         int var7 = ns.b(this.d + var2);
         int var8 = ns.b(this.e + var2);
         boolean var9 = var7 <= this.f;
         boolean var10 = var8 <= this.g;
         if (!var9 && !var10) {
            return false;
         }

         boolean var11 = var5 != var7;
         boolean var12 = var6 != var8;
         if (var11 ^ var12) {
            var4 = !var11;
         } else {
            var4 = var9 && var5 <= var6;
         }
      } else {
         boolean var13 = this.d + var2 <= this.f;
         boolean var14 = this.e + var2 <= this.g;
         if (!var13 && !var14) {
            return false;
         }

         var4 = var13 && (var3 || this.d <= this.e);
      }

      var5 = Math.max(var1.b(), var1.c());
      if (ns.b((var4 ? this.e : this.d) + var5) > (var4 ? this.g : this.f)) {
         return false;
      } else {
         bmf.b var15;
         if (var4) {
            if (var1.b() > var1.c()) {
               var1.d();
            }

            if (this.e == 0) {
               this.e = var1.c();
            }

            var15 = new bmf.b(this.d, 0, var1.b(), this.e);
            this.d += var1.b();
         } else {
            var15 = new bmf.b(0, this.e, this.d, var1.c());
            this.e += var1.c();
         }

         var15.a(var1);
         this.c.add(var15);
         return true;
      }
   }

   public List<bmi> d() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.c.iterator();

      while(var2.hasNext()) {
         bmf.b var3 = (bmf.b)var2.next();
         var3.a((List)var1);
      }

      ArrayList var7 = Lists.newArrayList();
      Iterator var8 = var1.iterator();

      while(var8.hasNext()) {
         bmf.b var4 = (bmf.b)var8.next();
         bmf.a var5 = var4.a();
         bmi var6 = var5.a();
         var6.a(this.d, this.e, var4.b(), var4.c(), var5.e());
         var7.add(var6);
      }

      return var7;
   }

   private static int b(int var0, int var1) {
      return (var0 >> var1) + ((var0 & (1 << var1) - 1) == 0 ? 0 : 1) << var1;
   }

   public static class a implements Comparable<bmf.a> {
      private final bmi a;
      private final int d;
      private final int b;
      private boolean e;
      private float f = 1.0F;
      private final int c;

      public void d() {
         this.e = !this.e;
      }

      public void a(int var1) {
         if (this.b > var1 && this.c > var1) {
            this.f = (float)var1 / (float)Math.min(this.b, this.c);
         }
      }

      public a(bmi var1, int var2) {
         this.a = var1;
         this.b = var1.c();
         this.c = var1.d();
         this.d = var2;
         this.e = bmf.a(this.c, var2) > bmf.a(this.b, var2);
      }

      public int compareTo(Object var1) {
         return this.a((bmf.a)var1);
      }

      public int b() {
         return this.e ? bmf.a((int)((float)this.c * this.f), this.d) : bmf.a((int)((float)this.b * this.f), this.d);
      }

      public boolean e() {
         return this.e;
      }

      public String toString() {
         return "Holder{width=" + this.b + ", height=" + this.c + '}';
      }

      public int c() {
         return this.e ? bmf.a((int)((float)this.b * this.f), this.d) : bmf.a((int)((float)this.c * this.f), this.d);
      }

      public int a(bmf.a var1) {
         int var2;
         if (this.c() == var1.c()) {
            if (this.b() == var1.b()) {
               if (this.a.i() == null) {
                  return var1.a.i() == null ? 0 : -1;
               }

               return this.a.i().compareTo(var1.a.i());
            }

            var2 = this.b() < var1.b() ? 1 : -1;
         } else {
            var2 = this.c() < var1.c() ? 1 : -1;
         }

         return var2;
      }

      public bmi a() {
         return this.a;
      }
   }

   public static class b {
      private final int d;
      private final int c;
      private bmf.a f;
      private List<bmf.b> e;
      private final int b;
      private final int a;

      public bmf.a a() {
         return this.f;
      }

      public int c() {
         return this.b;
      }

      public boolean a(bmf.a var1) {
         if (this.f != null) {
            return false;
         } else {
            int var2 = var1.b();
            int var3 = var1.c();
            if (var2 <= this.c && var3 <= this.d) {
               if (var2 == this.c && var3 == this.d) {
                  this.f = var1;
                  return true;
               } else {
                  if (this.e == null) {
                     this.e = Lists.newArrayListWithCapacity(1);
                     this.e.add(new bmf.b(this.a, this.b, var2, var3));
                     int var4 = this.c - var2;
                     int var5 = this.d - var3;
                     if (var5 > 0 && var4 > 0) {
                        int var6 = Math.max(this.d, var4);
                        int var7 = Math.max(this.c, var5);
                        if (var6 >= var7) {
                           this.e.add(new bmf.b(this.a, this.b + var3, var2, var5));
                           this.e.add(new bmf.b(this.a + var2, this.b, var4, this.d));
                        } else {
                           this.e.add(new bmf.b(this.a + var2, this.b, var4, var3));
                           this.e.add(new bmf.b(this.a, this.b + var3, this.c, var5));
                        }
                     } else if (var4 == 0) {
                        this.e.add(new bmf.b(this.a, this.b + var3, var2, var5));
                     } else if (var5 == 0) {
                        this.e.add(new bmf.b(this.a + var2, this.b, var4, var3));
                     }
                  }

                  Iterator var8 = this.e.iterator();

                  bmf.b var9;
                  do {
                     if (!var8.hasNext()) {
                        return false;
                     }

                     var9 = (bmf.b)var8.next();
                  } while(!var9.a(var1));

                  return true;
               }
            } else {
               return false;
            }
         }
      }

      public void a(List<bmf.b> var1) {
         if (this.f != null) {
            var1.add(this);
         } else if (this.e != null) {
            Iterator var2 = this.e.iterator();

            while(var2.hasNext()) {
               bmf.b var3 = (bmf.b)var2.next();
               var3.a(var1);
            }
         }

      }

      public int b() {
         return this.a;
      }

      public b(int var1, int var2, int var3, int var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      public String toString() {
         return "Slot{originX=" + this.a + ", originY=" + this.b + ", width=" + this.c + ", height=" + this.d + ", texture=" + this.f + ", subSlots=" + this.e + '}';
      }
   }
}
