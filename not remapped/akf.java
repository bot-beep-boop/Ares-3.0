import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class akf extends afh {
   public static final aml a = aml.a("facing", new Predicate<cq>() {
      public boolean apply(Object var1) {
         return this.a((cq)var1);
      }

      public boolean a(cq var1) {
         return var1 != cq.a;
      }
   });

   protected boolean f(adm var1, cj var2, alz var3) {
      if (var3.c() == this && this.a(var1, var2, (cq)var3.b(a))) {
         return true;
      } else {
         if (var1.p(var2).c() == this) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         }

         return false;
      }
   }

   public auh a(adm var1, cj var2, aui var3, aui var4) {
      cq var5 = (cq)var1.p(var2).b(a);
      float var6 = 0.15F;
      if (var5 == cq.f) {
         this.a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if (var5 == cq.e) {
         this.a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if (var5 == cq.d) {
         this.a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if (var5 == cq.c) {
         this.a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      } else {
         var6 = 0.1F;
         this.a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
      }

      return super.a(var1, var2, var3, var4);
   }

   private boolean e(adm var1, cj var2) {
      if (adm.a((adq)var1, (cj)var2)) {
         return true;
      } else {
         afh var3 = var1.p(var2).c();
         return var3 instanceof agt || var3 == afi.w || var3 == afi.bZ || var3 == afi.cG;
      }
   }

   public void a(adm var1, cj var2, alz var3, afh var4) {
      this.e(var1, var2, var3);
   }

   public void c(adm var1, cj var2, alz var3) {
      this.f(var1, var2, var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public boolean c() {
      return false;
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      cq var5 = (cq)var3.b(a);
      double var6 = (double)var2.n() + 0.5D;
      double var8 = (double)var2.o() + 0.7D;
      double var10 = (double)var2.p() + 0.5D;
      double var12 = 0.22D;
      double var14 = 0.27D;
      if (var5.k().c()) {
         cq var16 = var5.d();
         var1.a(cy.l, var6 + var14 * (double)var16.g(), var8 + var12, var10 + var14 * (double)var16.i(), 0.0D, 0.0D, 0.0D);
         var1.a(cy.A, var6 + var14 * (double)var16.g(), var8 + var12, var10 + var14 * (double)var16.i(), 0.0D, 0.0D, 0.0D);
      } else {
         var1.a(cy.l, var6, var8, var10, 0.0D, 0.0D, 0.0D);
         var1.a(cy.A, var6, var8, var10, 0.0D, 0.0D, 0.0D);
      }

   }

   public adf m() {
      return adf.c;
   }

   public boolean d() {
      return false;
   }

   protected boolean e(adm var1, cj var2, alz var3) {
      if (!this.f(var1, var2, var3)) {
         return true;
      } else {
         cq var4 = (cq)var3.b(a);
         cq.a var5 = var4.k();
         cq var6 = var4.d();
         boolean var7 = false;
         if (var5.c() && !var1.d(var2.a(var6), true)) {
            var7 = true;
         } else if (var5.b() && !this.e(var1, var2.a(var6))) {
            var7 = true;
         }

         if (var7) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
            return true;
         } else {
            return false;
         }
      }
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      if (this.a(var1, var2, var3)) {
         return this.Q().a(a, var3);
      } else {
         Iterator var9 = cq.c.a.iterator();

         cq var10;
         do {
            if (!var9.hasNext()) {
               return this.Q();
            }

            var10 = (cq)var9.next();
         } while(!var1.d(var2.a(var10.d()), true));

         return this.Q().a(a, var10);
      }
   }

   private boolean a(adm var1, cj var2, cq var3) {
      cj var4 = var2.a(var3.d());
      boolean var5 = var3.k().c();
      return var5 && var1.d(var4, true) || var3.equals(cq.b) && this.e(var1, var4);
   }

   protected akf() {
      super(arm.q);
      this.j(this.M.b().a(a, cq.b));
      this.a(true);
      this.a(yz.c);
   }

   public int c(alz var1) {
      byte var2 = 0;
      int var3;
      switch((cq)var1.b(a)) {
      case f:
         var3 = var2 | 1;
         break;
      case e:
         var3 = var2 | 2;
         break;
      case d:
         var3 = var2 | 3;
         break;
      case c:
         var3 = var2 | 4;
         break;
      case a:
      case b:
      default:
         var3 = var2 | 5;
      }

      return var3;
   }

   public alz a(int var1) {
      alz var2 = this.Q();
      switch(var1) {
      case 1:
         var2 = var2.a(a, cq.f);
         break;
      case 2:
         var2 = var2.a(a, cq.e);
         break;
      case 3:
         var2 = var2.a(a, cq.d);
         break;
      case 4:
         var2 = var2.a(a, cq.c);
         break;
      case 5:
      default:
         var2 = var2.a(a, cq.b);
      }

      return var2;
   }

   public boolean d(adm var1, cj var2) {
      Iterator var3 = a.c().iterator();

      cq var4;
      do {
         if (!var3.hasNext()) {
            return false;
         }

         var4 = (cq)var3.next();
      } while(!this.a(var1, var2, var4));

      return true;
   }

   public aug a(adm var1, cj var2, alz var3) {
      return null;
   }
}
