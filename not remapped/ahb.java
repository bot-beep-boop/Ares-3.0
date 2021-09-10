import com.google.common.base.Predicate;
import java.util.Random;

public class ahb extends afc {
   public static final aml a;
   private final boolean b;
   private static boolean N;

   public void c(adm var1, cj var2, alz var3) {
      this.e(var1, var2, var3);
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(a, var8.aP().d());
   }

   public void b(adm var1, cj var2, alz var3) {
      if (!N) {
         akw var4 = var1.s(var2);
         if (var4 instanceof alh) {
            oi.a(var1, (cj)var2, (alh)var4);
            var1.e(var2, this);
         }
      }

      super.b(var1, var2, var3);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      var1.a((cj)var2, (alz)var3.a(a, var4.aP().d()), 2);
      if (var5.s()) {
         akw var6 = var1.s(var2);
         if (var6 instanceof alh) {
            ((alh)var6).a(var5.q());
         }
      }

   }

   public zw c(adm var1, cj var2) {
      return zw.a(afi.al);
   }

   public static void a(boolean var0, adm var1, cj var2) {
      alz var3 = var1.p(var2);
      akw var4 = var1.s(var2);
      N = true;
      if (var0) {
         var1.a((cj)var2, (alz)afi.am.Q().a(a, var3.b(a)), 3);
         var1.a((cj)var2, (alz)afi.am.Q().a(a, var3.b(a)), 3);
      } else {
         var1.a((cj)var2, (alz)afi.al.Q().a(a, var3.b(a)), 3);
         var1.a((cj)var2, (alz)afi.al.Q().a(a, var3.b(a)), 3);
      }

      N = false;
      if (var4 != null) {
         var4.D();
         var1.a(var2, var4);
      }

   }

   private void e(adm var1, cj var2, alz var3) {
      if (!var1.D) {
         afh var4 = var1.p(var2.c()).c();
         afh var5 = var1.p(var2.d()).c();
         afh var6 = var1.p(var2.e()).c();
         afh var7 = var1.p(var2.f()).c();
         cq var8 = (cq)var3.b(a);
         if (var8 == cq.c && var4.o() && !var5.o()) {
            var8 = cq.d;
         } else if (var8 == cq.d && var5.o() && !var4.o()) {
            var8 = cq.c;
         } else if (var8 == cq.e && var6.o() && !var7.o()) {
            var8 = cq.f;
         } else if (var8 == cq.f && var7.o() && !var6.o()) {
            var8 = cq.e;
         }

         var1.a((cj)var2, (alz)var3.a(a, var8), 2);
      }
   }

   public int b() {
      return 3;
   }

   protected ahb(boolean var1) {
      super(arm.e);
      this.j(this.M.b().a(a, cq.c));
      this.b = var1;
   }

   public akw a(adm var1, int var2) {
      return new alh();
   }

   public boolean O() {
      return true;
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a(afi.al);
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         akw var9 = var1.s(var2);
         if (var9 instanceof alh) {
            var4.a((og)((alh)var9));
            var4.b(na.Y);
         }

         return true;
      }
   }

   public int l(adm var1, cj var2) {
      return xi.a(var1.s(var2));
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      if (this.b) {
         cq var5 = (cq)var3.b(a);
         double var6 = (double)var2.n() + 0.5D;
         double var8 = (double)var2.o() + var4.nextDouble() * 6.0D / 16.0D;
         double var10 = (double)var2.p() + 0.5D;
         double var12 = 0.52D;
         double var14 = var4.nextDouble() * 0.6D - 0.3D;
         switch(var5) {
         case e:
            var1.a(cy.l, var6 - var12, var8, var10 + var14, 0.0D, 0.0D, 0.0D);
            var1.a(cy.A, var6 - var12, var8, var10 + var14, 0.0D, 0.0D, 0.0D);
            break;
         case f:
            var1.a(cy.l, var6 + var12, var8, var10 + var14, 0.0D, 0.0D, 0.0D);
            var1.a(cy.A, var6 + var12, var8, var10 + var14, 0.0D, 0.0D, 0.0D);
            break;
         case c:
            var1.a(cy.l, var6 + var14, var8, var10 - var12, 0.0D, 0.0D, 0.0D);
            var1.a(cy.A, var6 + var14, var8, var10 - var12, 0.0D, 0.0D, 0.0D);
            break;
         case d:
            var1.a(cy.l, var6 + var14, var8, var10 + var12, 0.0D, 0.0D, 0.0D);
            var1.a(cy.A, var6 + var14, var8, var10 + var12, 0.0D, 0.0D, 0.0D);
         }

      }
   }

   public alz a(int var1) {
      cq var2 = cq.a(var1);
      if (var2.k() == cq.a.b) {
         var2 = cq.c;
      }

      return this.Q().a(a, var2);
   }

   public alz b(alz var1) {
      return this.Q().a(a, cq.d);
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
   }

   public int c(alz var1) {
      return ((cq)var1.b(a)).a();
   }
}
