import java.util.Random;

public class agj extends afh {
   public void a(adm var1, cj var2, alz var3, afh var4) {
      var1.a((cj)var2, (afh)this, this.a(var1));
   }

   public void a(adm var1, cj var2, wn var3) {
      this.f(var1, var2);
   }

   public boolean c() {
      return false;
   }

   public int a(adm var1) {
      return 5;
   }

   public agj() {
      super(arm.D, arn.E);
      this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 1.0F, 0.9375F);
   }

   public boolean a(adq var1, cj var2, cq var3) {
      return true;
   }

   public void b(adm var1, cj var2, alz var3, Random var4) {
      this.e(var1, var2);
   }

   private void e(adm var1, cj var2) {
      if (agr.e(var1, var2.b()) && var2.o() >= 0) {
         byte var3 = 32;
         if (!agr.N && var1.a(var2.a(-var3, -var3, -var3), var2.a(var3, var3, var3))) {
            var1.d((pk)(new uy(var1, (double)((float)var2.n() + 0.5F), (double)var2.o(), (double)((float)var2.p() + 0.5F), this.Q())));
         } else {
            var1.g(var2);

            cj var4;
            for(var4 = var2; agr.e(var1, var4) && var4.o() > 0; var4 = var4.b()) {
            }

            if (var4.o() > 0) {
               var1.a((cj)var4, (alz)this.Q(), 2);
            }
         }

      }
   }

   public boolean d() {
      return false;
   }

   private void f(adm var1, cj var2) {
      alz var3 = var1.p(var2);
      if (var3.c() == this) {
         for(int var4 = 0; var4 < 1000; ++var4) {
            cj var5 = var2.a(var1.s.nextInt(16) - var1.s.nextInt(16), var1.s.nextInt(8) - var1.s.nextInt(8), var1.s.nextInt(16) - var1.s.nextInt(16));
            if (var1.p(var5).c().J == arm.a) {
               if (var1.D) {
                  for(int var6 = 0; var6 < 128; ++var6) {
                     double var7 = var1.s.nextDouble();
                     float var9 = (var1.s.nextFloat() - 0.5F) * 0.2F;
                     float var10 = (var1.s.nextFloat() - 0.5F) * 0.2F;
                     float var11 = (var1.s.nextFloat() - 0.5F) * 0.2F;
                     double var12 = (double)var5.n() + (double)(var2.n() - var5.n()) * var7 + (var1.s.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     double var14 = (double)var5.o() + (double)(var2.o() - var5.o()) * var7 + var1.s.nextDouble() * 1.0D - 0.5D;
                     double var16 = (double)var5.p() + (double)(var2.p() - var5.p()) * var7 + (var1.s.nextDouble() - 0.5D) * 1.0D + 0.5D;
                     var1.a(cy.y, var12, var14, var16, (double)var9, (double)var10, (double)var11);
                  }
               } else {
                  var1.a((cj)var5, (alz)var3, 2);
                  var1.g(var2);
               }

               return;
            }
         }

      }
   }

   public void c(adm var1, cj var2, alz var3) {
      var1.a((cj)var2, (afh)this, this.a(var1));
   }

   public zw c(adm var1, cj var2) {
      return null;
   }

   public boolean a(adm var1, cj var2, alz var3, wn var4, cq var5, float var6, float var7, float var8) {
      this.f(var1, var2);
      return true;
   }
}
