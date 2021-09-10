import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ajr extends afh {
   public static final amk a = amk.a("wet");

   protected ajr() {
      super(arm.m);
      this.j(this.M.b().a(a, false));
      this.a(yz.b);
   }

   public int c(alz var1) {
      return (Boolean)var1.b(a) ? 1 : 0;
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      if ((Boolean)var3.b(a)) {
         cq var5 = cq.a(var4);
         if (var5 != cq.b && !adm.a((adq)var1, (cj)var2.a(var5))) {
            double var6 = (double)var2.n();
            double var8 = (double)var2.o();
            double var10 = (double)var2.p();
            if (var5 == cq.a) {
               var8 -= 0.05D;
               var6 += var4.nextDouble();
               var10 += var4.nextDouble();
            } else {
               var8 += var4.nextDouble() * 0.8D;
               if (var5.k() == cq.a.a) {
                  var10 += var4.nextDouble();
                  if (var5 == cq.f) {
                     ++var6;
                  } else {
                     var6 += 0.05D;
                  }
               } else {
                  var6 += var4.nextDouble();
                  if (var5 == cq.d) {
                     ++var10;
                  } else {
                     var10 += 0.05D;
                  }
               }
            }

            var1.a(cy.s, var6, var8, var10, 0.0D, 0.0D, 0.0D);
         }
      }
   }

   protected void e(adm var1, cj var2, alz var3) {
      if (!(Boolean)var3.b(a) && this.e(var1, var2)) {
         var1.a((cj)var2, (alz)var3.a(a, true), 2);
         var1.b(2001, var2, afh.a((afh)afi.j));
      }

   }

   private boolean e(adm var1, cj var2) {
      LinkedList var3 = Lists.newLinkedList();
      ArrayList var4 = Lists.newArrayList();
      var3.add(new nz(var2, 0));
      int var5 = 0;

      cj var7;
      while(!var3.isEmpty()) {
         nz var6 = (nz)var3.poll();
         var7 = (cj)var6.a();
         int var8 = (Integer)var6.b();
         cq[] var9 = cq.values();
         int var10 = var9.length;

         for(int var11 = 0; var11 < var10; ++var11) {
            cq var12 = var9[var11];
            cj var13 = var7.a(var12);
            if (var1.p(var13).c().t() == arm.h) {
               var1.a((cj)var13, (alz)afi.a.Q(), 2);
               var4.add(var13);
               ++var5;
               if (var8 < 6) {
                  var3.add(new nz(var13, var8 + 1));
               }
            }
         }

         if (var5 > 64) {
            break;
         }
      }

      Iterator var14 = var4.iterator();

      while(var14.hasNext()) {
         var7 = (cj)var14.next();
         var1.c(var7, afi.a);
      }

      return var5 > 0;
   }

   public void a(zw var1, yz var2, List<zx> var3) {
      var3.add(new zx(var1, 1, 0));
      var3.add(new zx(var1, 1, 1));
   }

   public alz a(int var1) {
      return this.Q().a(a, (var1 & 1) == 1);
   }

   public String f() {
      return di.a(this.a() + ".dry.name");
   }

   public void c(adm var1, cj var2, alz var3) {
      this.e(var1, var2, var3);
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      this.e(var1, var2, var3);
      super.a(var1, var2, var3, var4);
   }

   public int a(alz var1) {
      return (Boolean)var1.b(a) ? 1 : 0;
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }
}
