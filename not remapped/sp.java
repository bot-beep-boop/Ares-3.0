import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class sp<T extends pr> extends st {
   protected Predicate<? super T> c;
   private final int g;
   protected final Class<T> a;
   protected pr d;
   protected final sp.a b;

   public void c() {
      this.e.d(this.d);
      super.c();
   }

   public sp(py var1, Class<T> var2, boolean var3) {
      this(var1, var2, var3, false);
   }

   public sp(py var1, Class<T> var2, int var3, boolean var4, boolean var5, Predicate<? super T> var6) {
      super(var1, var4, var5);
      this.a = var2;
      this.g = var3;
      this.b = new sp.a(var1);
      this.a(1);
      this.c = new Predicate<T>(this, var6) {
         final Predicate a;
         final sp b;

         public boolean apply(Object var1) {
            return this.a((pr)var1);
         }

         public boolean a(T var1) {
            if (this.a != null && !this.a.apply(var1)) {
               return false;
            } else {
               if (var1 instanceof wn) {
                  double var2 = this.b.f();
                  if (var1.av()) {
                     var2 *= 0.800000011920929D;
                  }

                  if (var1.ax()) {
                     float var4 = ((wn)var1).bY();
                     if (var4 < 0.1F) {
                        var4 = 0.1F;
                     }

                     var2 *= (double)(0.7F * var4);
                  }

                  if ((double)var1.g(this.b.e) > var2) {
                     return false;
                  }
               }

               return this.b.a(var1, false);
            }
         }

         {
            this.b = var1;
            this.a = var2;
         }
      };
   }

   public sp(py var1, Class<T> var2, boolean var3, boolean var4) {
      this(var1, var2, 10, var3, var4, (Predicate)null);
   }

   public boolean a() {
      if (this.g > 0 && this.e.bc().nextInt(this.g) != 0) {
         return false;
      } else {
         double var1 = this.f();
         List var3 = this.e.o.a(this.a, this.e.aR().b(var1, 4.0D, var1), Predicates.and(this.c, po.d));
         Collections.sort(var3, this.b);
         if (var3.isEmpty()) {
            return false;
         } else {
            this.d = (pr)var3.get(0);
            return true;
         }
      }
   }

   public static class a implements Comparator<pk> {
      private final pk a;

      public a(pk var1) {
         this.a = var1;
      }

      public int compare(Object var1, Object var2) {
         return this.a((pk)var1, (pk)var2);
      }

      public int a(pk var1, pk var2) {
         double var3 = this.a.h(var1);
         double var5 = this.a.h(var2);
         if (var3 < var5) {
            return -1;
         } else {
            return var3 > var5 ? 1 : 0;
         }
      }
   }
}
