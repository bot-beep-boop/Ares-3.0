import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.Iterator;

public class amd {
   private final int c;
   private final Predicate<amc>[][][] a;
   private final int d;
   private final int b;

   public int b() {
      return this.c;
   }

   public amd(Predicate<amc>[][][] var1) {
      this.a = var1;
      this.b = var1.length;
      if (this.b > 0) {
         this.c = var1[0].length;
         if (this.c > 0) {
            this.d = var1[0][0].length;
         } else {
            this.d = 0;
         }
      } else {
         this.c = 0;
         this.d = 0;
      }

   }

   public amd.b a(adm var1, cj var2) {
      LoadingCache var3 = a(var1, false);
      int var4 = Math.max(Math.max(this.d, this.c), this.b);
      Iterator var5 = cj.a(var2, var2.a(var4 - 1, var4 - 1, var4 - 1)).iterator();

      while(var5.hasNext()) {
         cj var6 = (cj)var5.next();
         cq[] var7 = cq.values();
         int var8 = var7.length;

         for(int var9 = 0; var9 < var8; ++var9) {
            cq var10 = var7[var9];
            cq[] var11 = cq.values();
            int var12 = var11.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               cq var14 = var11[var13];
               if (var14 != var10 && var14 != var10.d()) {
                  amd.b var15 = this.a(var6, var10, var14, var3);
                  if (var15 != null) {
                     return var15;
                  }
               }
            }
         }
      }

      return null;
   }

   protected static cj a(cj var0, cq var1, cq var2, int var3, int var4, int var5) {
      if (var1 != var2 && var1 != var2.d()) {
         df var6 = new df(var1.g(), var1.h(), var1.i());
         df var7 = new df(var2.g(), var2.h(), var2.i());
         df var8 = var6.d(var7);
         return var0.a(var7.n() * -var4 + var8.n() * var3 + var6.n() * var5, var7.o() * -var4 + var8.o() * var3 + var6.o() * var5, var7.p() * -var4 + var8.p() * var3 + var6.p() * var5);
      } else {
         throw new IllegalArgumentException("Invalid forwards & up combination");
      }
   }

   public static LoadingCache<cj, amc> a(adm var0, boolean var1) {
      return CacheBuilder.newBuilder().build(new amd.a(var0, var1));
   }

   private amd.b a(cj var1, cq var2, cq var3, LoadingCache<cj, amc> var4) {
      for(int var5 = 0; var5 < this.d; ++var5) {
         for(int var6 = 0; var6 < this.c; ++var6) {
            for(int var7 = 0; var7 < this.b; ++var7) {
               if (!this.a[var7][var6][var5].apply(var4.getUnchecked(a(var1, var2, var3, var5, var6, var7)))) {
                  return null;
               }
            }
         }
      }

      return new amd.b(var1, var2, var3, var4, this.d, this.c, this.b);
   }

   public int c() {
      return this.d;
   }

   static class a extends CacheLoader<cj, amc> {
      private final boolean b;
      private final adm a;

      public Object load(Object var1) throws Exception {
         return this.a((cj)var1);
      }

      public amc a(cj var1) throws Exception {
         return new amc(this.a, var1, this.b);
      }

      public a(adm var1, boolean var2) {
         this.a = var1;
         this.b = var2;
      }
   }

   public static class b {
      private final cj a;
      private final cq c;
      private final int g;
      private final cq b;
      private final int f;
      private final int e;
      private final LoadingCache<cj, amc> d;

      public int e() {
         return this.f;
      }

      public cq c() {
         return this.c;
      }

      public String toString() {
         return Objects.toStringHelper(this).add("up", this.c).add("forwards", this.b).add("frontTopLeft", this.a).toString();
      }

      public b(cj var1, cq var2, cq var3, LoadingCache<cj, amc> var4, int var5, int var6, int var7) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
         this.e = var5;
         this.f = var6;
         this.g = var7;
      }

      public int d() {
         return this.e;
      }

      public amc a(int var1, int var2, int var3) {
         return (amc)this.d.getUnchecked(amd.a(this.a, this.b(), this.c(), var1, var2, var3));
      }

      public cj a() {
         return this.a;
      }

      public cq b() {
         return this.b;
      }
   }
}
