import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ajd extends akf {
   private final boolean N;
   private static Map<adm, List<ajd.a>> b = Maps.newHashMap();

   public boolean i() {
      return true;
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      if (this.N) {
         double var5 = (double)var2.n() + 0.5D + (var4.nextDouble() - 0.5D) * 0.2D;
         double var7 = (double)var2.o() + 0.7D + (var4.nextDouble() - 0.5D) * 0.2D;
         double var9 = (double)var2.p() + 0.5D + (var4.nextDouble() - 0.5D) * 0.2D;
         cq var11 = (cq)var3.b(a);
         if (var11.k().c()) {
            cq var12 = var11.d();
            double var13 = 0.27D;
            var5 += 0.27D * (double)var12.g();
            var7 += 0.22D;
            var9 += 0.27D * (double)var12.i();
         }

         var1.a(cy.E, var5, var7, var9, 0.0D, 0.0D, 0.0D);
      }
   }

   public void a(adm var1, cj var2, alz var3, Random var4) {
   }

   public int b(adq var1, cj var2, alz var3, cq var4) {
      return var4 == cq.a ? this.a(var1, var2, var3, var4) : 0;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      boolean var5 = this.g(var1, var2, var3);
      List var6 = (List)b.get(var1);

      while(var6 != null && !var6.isEmpty() && var1.K() - ((ajd.a)var6.get(0)).b > 60L) {
         var6.remove(0);
      }

      if (this.N) {
         if (var5) {
            var1.a((cj)var2, (alz)afi.aE.Q().a(a, var3.b(a)), 3);
            if (this.a(var1, var2, true)) {
               var1.a((double)((float)var2.n() + 0.5F), (double)((float)var2.o() + 0.5F), (double)((float)var2.p() + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.s.nextFloat() - var1.s.nextFloat()) * 0.8F);

               for(int var7 = 0; var7 < 5; ++var7) {
                  double var8 = (double)var2.n() + var4.nextDouble() * 0.6D + 0.2D;
                  double var10 = (double)var2.o() + var4.nextDouble() * 0.6D + 0.2D;
                  double var12 = (double)var2.p() + var4.nextDouble() * 0.6D + 0.2D;
                  var1.a(cy.l, var8, var10, var12, 0.0D, 0.0D, 0.0D);
               }

               var1.a((cj)var2, (afh)var1.p(var2).c(), 160);
            }
         }
      } else if (!var5 && !this.a(var1, var2, false)) {
         var1.a((cj)var2, (alz)afi.aF.Q().a(a, var3.b(a)), 3);
      }

   }

   public zw c(adm var1, cj var2) {
      return zw.a(afi.aF);
   }

   private boolean g(adm var1, cj var2, alz var3) {
      cq var4 = ((cq)var3.b(a)).d();
      return var1.b(var2.a(var4), var4);
   }

   public int a(adq var1, cj var2, alz var3, cq var4) {
      return this.N && var3.b(a) != var4 ? 15 : 0;
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a(afi.aF);
   }

   protected ajd(boolean var1) {
      this.N = var1;
      this.a(true);
      this.a((yz)null);
   }

   private boolean a(adm var1, cj var2, boolean var3) {
      if (!b.containsKey(var1)) {
         b.put(var1, Lists.newArrayList());
      }

      List var4 = (List)b.get(var1);
      if (var3) {
         var4.add(new ajd.a(var2, var1.K()));
      }

      int var5 = 0;

      for(int var6 = 0; var6 < var4.size(); ++var6) {
         ajd.a var7 = (ajd.a)var4.get(var6);
         if (var7.a.equals(var2)) {
            ++var5;
            if (var5 >= 8) {
               return true;
            }
         }
      }

      return false;
   }

   public int a(adm var1) {
      return 2;
   }

   public boolean b(afh var1) {
      return var1 == afi.aE || var1 == afi.aF;
   }

   public void b(adm var1, cj var2, alz var3) {
      if (this.N) {
         cq[] var4 = cq.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            cq var7 = var4[var6];
            var1.c((cj)var2.a(var7), (afh)this);
         }
      }

   }

   public void c(adm var1, cj var2, alz var3) {
      if (this.N) {
         cq[] var4 = cq.values();
         int var5 = var4.length;

         for(int var6 = 0; var6 < var5; ++var6) {
            cq var7 = var4[var6];
            var1.c((cj)var2.a(var7), (afh)this);
         }
      }

   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      if (!this.e(var1, var2, var3)) {
         if (this.N == this.g(var1, var2, var3)) {
            var1.a((cj)var2, (afh)this, this.a(var1));
         }

      }
   }

   static class a {
      cj a;
      long b;

      public a(cj var1, long var2) {
         this.a = var1;
         this.b = var2;
      }
   }
}
