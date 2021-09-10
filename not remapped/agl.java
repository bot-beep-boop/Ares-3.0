import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class agl extends ahv {
   int a;

   private void a(adm var1, cj var2, alz var3, int var4) {
      if (this.h(var1, var2, var3)) {
         if (var3.c() != afi.a) {
            if (this.J == arm.i) {
               this.e(var1, var2);
            } else {
               var3.c().b(var1, var2, var3, 0);
            }
         }

         var1.a((cj)var2, (alz)this.Q().a(b, var4), 3);
      }

   }

   private int a(adm var1, cj var2, int var3, cq var4) {
      int var5 = 1000;
      Iterator var6 = cq.c.a.iterator();

      while(true) {
         cq var7;
         cj var8;
         alz var9;
         do {
            do {
               do {
                  if (!var6.hasNext()) {
                     return var5;
                  }

                  var7 = (cq)var6.next();
               } while(var7 == var4);

               var8 = var2.a(var7);
               var9 = var1.p(var8);
            } while(this.g(var1, var8, var9));
         } while(var9.c().t() == this.J && (Integer)var9.b(b) <= 0);

         if (!this.g(var1, var8.b(), var9)) {
            return var3;
         }

         if (var3 < 4) {
            int var10 = this.a(var1, var8, var3 + 1, var7.d());
            if (var10 < var5) {
               var5 = var10;
            }
         }
      }
   }

   private void f(adm var1, cj var2, alz var3) {
      var1.a((cj)var2, (alz)b(this.J).Q().a(b, var3.b(b)), 2);
   }

   private Set<cq> f(adm var1, cj var2) {
      int var3 = 1000;
      EnumSet var4 = EnumSet.noneOf(cq.class);
      Iterator var5 = cq.c.a.iterator();

      while(true) {
         cq var6;
         cj var7;
         alz var8;
         do {
            do {
               if (!var5.hasNext()) {
                  return var4;
               }

               var6 = (cq)var5.next();
               var7 = var2.a(var6);
               var8 = var1.p(var7);
            } while(this.g(var1, var7, var8));
         } while(var8.c().t() == this.J && (Integer)var8.b(b) <= 0);

         int var9;
         if (this.g(var1, var7.b(), var1.p(var7.b()))) {
            var9 = this.a(var1, var7, 1, var6.d());
         } else {
            var9 = 0;
         }

         if (var9 < var3) {
            var4.clear();
         }

         if (var9 <= var3) {
            var4.add(var6);
            var3 = var9;
         }
      }
   }

   protected int a(adm var1, cj var2, int var3) {
      int var4 = this.e(var1, var2);
      if (var4 < 0) {
         return var3;
      } else {
         if (var4 == 0) {
            ++this.a;
         }

         if (var4 >= 8) {
            var4 = 0;
         }

         return var3 >= 0 && var4 >= var3 ? var3 : var4;
      }
   }

   private boolean g(adm var1, cj var2, alz var3) {
      afh var4 = var1.p(var2).c();
      if (!(var4 instanceof agh) && var4 != afi.an && var4 != afi.au && var4 != afi.aM) {
         return var4.J == arm.E ? true : var4.J.c();
      } else {
         return true;
      }
   }

   private boolean h(adm var1, cj var2, alz var3) {
      arm var4 = var3.c().t();
      return var4 != this.J && var4 != arm.i && !this.g(var1, var2, var3);
   }

   public void c(adm var1, cj var2, alz var3) {
      if (!this.e(var1, var2, var3)) {
         var1.a((cj)var2, (afh)this, this.a(var1));
      }

   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      int var5 = (Integer)var3.b(b);
      byte var6 = 1;
      if (this.J == arm.i && !var1.t.n()) {
         var6 = 2;
      }

      int var7 = this.a(var1);
      int var15;
      if (var5 > 0) {
         int var8 = -100;
         this.a = 0;

         cq var10;
         for(Iterator var9 = cq.c.a.iterator(); var9.hasNext(); var8 = this.a(var1, var2.a(var10), var8)) {
            var10 = (cq)var9.next();
         }

         int var14 = var8 + var6;
         if (var14 >= 8 || var8 < 0) {
            var14 = -1;
         }

         if (this.e(var1, var2.a()) >= 0) {
            var15 = this.e(var1, var2.a());
            if (var15 >= 8) {
               var14 = var15;
            } else {
               var14 = var15 + 8;
            }
         }

         if (this.a >= 2 && this.J == arm.h) {
            alz var16 = var1.p(var2.b());
            if (var16.c().t().a()) {
               var14 = 0;
            } else if (var16.c().t() == this.J && (Integer)var16.b(b) == 0) {
               var14 = 0;
            }
         }

         if (this.J == arm.i && var5 < 8 && var14 < 8 && var14 > var5 && var4.nextInt(4) != 0) {
            var7 *= 4;
         }

         if (var14 == var5) {
            this.f(var1, var2, var3);
         } else {
            var5 = var14;
            if (var14 < 0) {
               var1.g(var2);
            } else {
               var3 = var3.a(b, var14);
               var1.a((cj)var2, (alz)var3, 2);
               var1.a((cj)var2, (afh)this, var7);
               var1.c((cj)var2, (afh)this);
            }
         }
      } else {
         this.f(var1, var2, var3);
      }

      alz var13 = var1.p(var2.b());
      if (this.h(var1, var2.b(), var13)) {
         if (this.J == arm.i && var1.p(var2.b()).c().t() == arm.h) {
            var1.a(var2.b(), afi.b.Q());
            this.e(var1, var2.b());
            return;
         }

         if (var5 >= 8) {
            this.a(var1, var2.b(), var13, var5);
         } else {
            this.a(var1, var2.b(), var13, var5 + 8);
         }
      } else if (var5 >= 0 && (var5 == 0 || this.g(var1, var2.b(), var13))) {
         Set var17 = this.f(var1, var2);
         var15 = var5 + var6;
         if (var5 >= 8) {
            var15 = 1;
         }

         if (var15 >= 8) {
            return;
         }

         Iterator var11 = var17.iterator();

         while(var11.hasNext()) {
            cq var12 = (cq)var11.next();
            this.a(var1, var2.a(var12), var1.p(var2.a(var12)), var15);
         }
      }

   }

   protected agl(arm var1) {
      super(var1);
   }
}
