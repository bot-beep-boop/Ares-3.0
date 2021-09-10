import java.util.Random;

public class aja extends afh {
   private final boolean a;

   public aja(boolean var1) {
      super(arm.e);
      if (var1) {
         this.a(true);
      }

      this.a = var1;
   }

   public int a(adm var1) {
      return 30;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      if (this == afi.aD) {
         var1.a(var2, afi.aC.Q());
      }

   }

   public int a(Random var1) {
      return 4 + var1.nextInt(2);
   }

   private void e(adm var1, cj var2) {
      this.f(var1, var2);
      if (this == afi.aC) {
         var1.a(var2, afi.aD.Q());
      }

   }

   public void a(adm var1, cj var2, pk var3) {
      this.e(var1, var2);
      super.a(var1, var2, var3);
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      if (this.a) {
         this.f(var1, var2);
      }

   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      this.e(var1, var2);
      return super.a(var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public zw a(alz var1, Random var2, int var3) {
      return zy.aC;
   }

   public void a(adm var1, cj var2, alz var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if (this.a(var3, var1.s, var5) != zw.a((afh)this)) {
         int var6 = 1 + var1.s.nextInt(5);
         this.b(var1, var2, var6);
      }

   }

   public int a(int var1, Random var2) {
      return this.a(var2) + var2.nextInt(var1 + 1);
   }

   public void a(adm var1, cj var2, wn var3) {
      this.e(var1, var2);
      super.a(var1, var2, var3);
   }

   private void f(adm var1, cj var2) {
      Random var3 = var1.s;
      double var4 = 0.0625D;

      for(int var6 = 0; var6 < 6; ++var6) {
         double var7 = (double)((float)var2.n() + var3.nextFloat());
         double var9 = (double)((float)var2.o() + var3.nextFloat());
         double var11 = (double)((float)var2.p() + var3.nextFloat());
         if (var6 == 0 && !var1.p(var2.a()).c().c()) {
            var9 = (double)var2.o() + var4 + 1.0D;
         }

         if (var6 == 1 && !var1.p(var2.b()).c().c()) {
            var9 = (double)var2.o() - var4;
         }

         if (var6 == 2 && !var1.p(var2.d()).c().c()) {
            var11 = (double)var2.p() + var4 + 1.0D;
         }

         if (var6 == 3 && !var1.p(var2.c()).c().c()) {
            var11 = (double)var2.p() - var4;
         }

         if (var6 == 4 && !var1.p(var2.f()).c().c()) {
            var7 = (double)var2.n() + var4 + 1.0D;
         }

         if (var6 == 5 && !var1.p(var2.e()).c().c()) {
            var7 = (double)var2.n() - var4;
         }

         if (var7 < (double)var2.n() || var7 > (double)(var2.n() + 1) || var9 < 0.0D || var9 > (double)(var2.o() + 1) || var11 < (double)var2.p() || var11 > (double)(var2.p() + 1)) {
            var1.a(cy.E, var7, var9, var11, 0.0D, 0.0D, 0.0D);
         }
      }

   }

   protected zx i(alz var1) {
      return new zx(afi.aC);
   }
}
