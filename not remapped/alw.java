import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class alw {
   private final adm a;
   private final cq d;
   private final cj b;
   private final List<cj> f = Lists.newArrayList();
   private final List<cj> e = Lists.newArrayList();
   private final cj c;

   private boolean b(cj var1) {
      cq[] var2 = cq.values();
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         cq var5 = var2[var4];
         if (var5.k() != this.d.k() && !this.a(var1.a(var5))) {
            return false;
         }
      }

      return true;
   }

   public alw(adm var1, cj var2, cq var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      if (var4) {
         this.d = var3;
         this.c = var2.a(var3);
      } else {
         this.d = var3.d();
         this.c = var2.a(var3, 2);
      }

   }

   public boolean a() {
      this.e.clear();
      this.f.clear();
      afh var1 = this.a.p(this.c).c();
      if (!als.a(var1, this.a, this.c, this.d, false)) {
         if (var1.k() != 1) {
            return false;
         } else {
            this.f.add(this.c);
            return true;
         }
      } else if (!this.a(this.c)) {
         return false;
      } else {
         for(int var2 = 0; var2 < this.e.size(); ++var2) {
            cj var3 = (cj)this.e.get(var2);
            if (this.a.p(var3).c() == afi.cE && !this.b(var3)) {
               return false;
            }
         }

         return true;
      }
   }

   private boolean a(cj var1) {
      afh var2 = this.a.p(var1).c();
      if (var2.t() == arm.a) {
         return true;
      } else if (!als.a(var2, this.a, var1, this.d, false)) {
         return true;
      } else if (var1.equals(this.b)) {
         return true;
      } else if (this.e.contains(var1)) {
         return true;
      } else {
         int var3 = 1;
         if (var3 + this.e.size() > 12) {
            return false;
         } else {
            while(var2 == afi.cE) {
               cj var4 = var1.a(this.d.d(), var3);
               var2 = this.a.p(var4).c();
               if (var2.t() == arm.a || !als.a(var2, this.a, var4, this.d, false) || var4.equals(this.b)) {
                  break;
               }

               ++var3;
               if (var3 + this.e.size() > 12) {
                  return false;
               }
            }

            int var10 = 0;

            int var5;
            for(var5 = var3 - 1; var5 >= 0; --var5) {
               this.e.add(var1.a(this.d.d(), var5));
               ++var10;
            }

            var5 = 1;

            while(true) {
               cj var6 = var1.a(this.d, var5);
               int var7 = this.e.indexOf(var6);
               if (var7 > -1) {
                  this.a(var10, var7);

                  for(int var8 = 0; var8 <= var7 + var10; ++var8) {
                     cj var9 = (cj)this.e.get(var8);
                     if (this.a.p(var9).c() == afi.cE && !this.b(var9)) {
                        return false;
                     }
                  }

                  return true;
               }

               var2 = this.a.p(var6).c();
               if (var2.t() == arm.a) {
                  return true;
               }

               if (!als.a(var2, this.a, var6, this.d, true) || var6.equals(this.b)) {
                  return false;
               }

               if (var2.k() == 1) {
                  this.f.add(var6);
                  return true;
               }

               if (this.e.size() >= 12) {
                  return false;
               }

               this.e.add(var6);
               ++var10;
               ++var5;
            }
         }
      }
   }

   public List<cj> d() {
      return this.f;
   }

   private void a(int var1, int var2) {
      ArrayList var3 = Lists.newArrayList();
      ArrayList var4 = Lists.newArrayList();
      ArrayList var5 = Lists.newArrayList();
      var3.addAll(this.e.subList(0, var2));
      var4.addAll(this.e.subList(this.e.size() - var1, this.e.size()));
      var5.addAll(this.e.subList(var2, this.e.size() - var1));
      this.e.clear();
      this.e.addAll(var3);
      this.e.addAll(var4);
      this.e.addAll(var5);
   }

   public List<cj> c() {
      return this.e;
   }
}
