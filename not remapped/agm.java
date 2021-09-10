import java.util.Random;

public class agm extends afc {
   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      if (var1.D) {
         return true;
      } else {
         akw var9 = var1.s(var2);
         if (var9 instanceof ale) {
            var4.a((ol)((ale)var9));
         }

         return true;
      }
   }

   public akw a(adm var1, int var2) {
      return new ale();
   }

   public void a(adm var1, cj var2, alz var3, pr var4, zx var5) {
      super.a(var1, var2, var3, var4, var5);
      if (var5.s()) {
         akw var6 = var1.s(var2);
         if (var6 instanceof ale) {
            ((ale)var6).a(var5.q());
         }
      }

   }

   public int b() {
      return 3;
   }

   public void c(adm var1, cj var2, alz var3, Random var4) {
      super.c(var1, var2, var3, var4);

      for(int var5 = -2; var5 <= 2; ++var5) {
         for(int var6 = -2; var6 <= 2; ++var6) {
            if (var5 > -2 && var5 < 2 && var6 == -1) {
               var6 = 2;
            }

            if (var4.nextInt(16) == 0) {
               for(int var7 = 0; var7 <= 1; ++var7) {
                  cj var8 = var2.a(var5, var7, var6);
                  if (var1.p(var8).c() == afi.X) {
                     if (!var1.d(var2.a(var5 / 2, 0, var6 / 2))) {
                        break;
                     }

                     var1.a(cy.z, (double)var2.n() + 0.5D, (double)var2.o() + 2.0D, (double)var2.p() + 0.5D, (double)((float)var5 + var4.nextFloat()) - 0.5D, (double)((float)var7 - var4.nextFloat() - 1.0F), (double)((float)var6 + var4.nextFloat()) - 0.5D);
                  }
               }
            }
         }
      }

   }

   protected agm() {
      super(arm.e, arn.D);
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
      this.e(0);
      this.a(yz.c);
   }

   public boolean d() {
      return false;
   }

   public boolean c() {
      return false;
   }
}
