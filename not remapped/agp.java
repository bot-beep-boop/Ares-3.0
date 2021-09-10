import com.google.common.base.Predicate;
import java.util.Random;

public class agp extends afc {
   public static final aml a;

   public akw a(adm var1, int var2) {
      return new alf();
   }

   static {
      a = aml.a("facing", (Predicate)cq.c.a);
   }

   protected ama e() {
      return new ama(this, new amo[]{a});
   }

   protected boolean I() {
      return true;
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      var1.a((cj)var2, (alz)var3.a(a, var4.aP().d()), 2);
   }

   public alz a(adm var1, cj var2, cq var3, float var4, float var5, float var6, int var7, pr var8) {
      return this.Q().a(a, var8.aP().d());
   }

   public zw a(alz var1, Random var2, int var3) {
      return zw.a(afi.Z);
   }

   public boolean c() {
      return false;
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      yd var9 = var4.co();
      akw var10 = var1.s(var2);
      if (var9 != null && var10 instanceof alf) {
         if (var1.p(var2.a()).c().v()) {
            return true;
         } else if (var1.D) {
            return true;
         } else {
            var9.a((alf)var10);
            var4.a((og)var9);
            var4.b(na.V);
            return true;
         }
      } else {
         return true;
      }
   }

   public int c(alz var1) {
      return ((cq)var1.b(a)).a();
   }

   public int b() {
      return 2;
   }

   public boolean d() {
      return false;
   }

   protected agp() {
      super(arm.e);
      this.j(this.M.b().a(a, cq.c));
      this.a(yz.c);
      this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      for(int var5 = 0; var5 < 3; ++var5) {
         int var6 = var4.nextInt(2) * 2 - 1;
         int var7 = var4.nextInt(2) * 2 - 1;
         double var8 = (double)var2.n() + 0.5D + 0.25D * (double)var6;
         double var10 = (double)((float)var2.o() + var4.nextFloat());
         double var12 = (double)var2.p() + 0.5D + 0.25D * (double)var7;
         double var14 = (double)(var4.nextFloat() * (float)var6);
         double var16 = ((double)var4.nextFloat() - 0.5D) * 0.125D;
         double var18 = (double)(var4.nextFloat() * (float)var7);
         var1.a(cy.y, var8, var10, var12, var14, var16, var18);
      }

   }

   public int a(Random var1) {
      return 8;
   }

   public alz a(int var1) {
      cq var2 = cq.a(var1);
      if (var2.k() == cq.a.b) {
         var2 = cq.c;
      }

      return this.Q().a(a, var2);
   }
}
