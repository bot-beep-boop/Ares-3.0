import java.util.Random;

public class ape extends apg {
   public boolean b(adm var1, Random var2, cj var3) {
      int var4 = this.a(var2);
      if (!this.a(var1, var2, var3, var4)) {
         return false;
      } else {
         this.c(var1, var3.b(var4), 2);

         for(int var5 = var3.o() + var4 - 2 - var2.nextInt(4); var5 > var3.o() + var4 / 2; var5 -= 2 + var2.nextInt(4)) {
            float var6 = var2.nextFloat() * 3.1415927F * 2.0F;
            int var7 = var3.n() + (int)(0.5F + ns.b(var6) * 4.0F);
            int var8 = var3.p() + (int)(0.5F + ns.a(var6) * 4.0F);

            int var9;
            for(var9 = 0; var9 < 5; ++var9) {
               var7 = var3.n() + (int)(1.5F + ns.b(var6) * (float)var9);
               var8 = var3.p() + (int)(1.5F + ns.a(var6) * (float)var9);
               this.a(var1, new cj(var7, var5 - 3 + var9 / 2, var8), this.b);
            }

            var9 = 1 + var2.nextInt(2);
            int var10 = var5;

            for(int var11 = var5 - var9; var11 <= var10; ++var11) {
               int var12 = var11 - var10;
               this.b(var1, new cj(var7, var11, var8), 1 - var12);
            }
         }

         for(int var13 = 0; var13 < var4; ++var13) {
            cj var14 = var3.b(var13);
            if (this.a(var1.p(var14).c())) {
               this.a(var1, var14, this.b);
               if (var13 > 0) {
                  this.a(var1, var2, var14.e(), akk.N);
                  this.a(var1, var2, var14.c(), akk.O);
               }
            }

            if (var13 < var4 - 1) {
               cj var15 = var14.f();
               if (this.a(var1.p(var15).c())) {
                  this.a(var1, var15, this.b);
                  if (var13 > 0) {
                     this.a(var1, var2, var15.f(), akk.P);
                     this.a(var1, var2, var15.c(), akk.O);
                  }
               }

               cj var16 = var14.d().f();
               if (this.a(var1.p(var16).c())) {
                  this.a(var1, var16, this.b);
                  if (var13 > 0) {
                     this.a(var1, var2, var16.f(), akk.P);
                     this.a(var1, var2, var16.d(), akk.b);
                  }
               }

               cj var17 = var14.d();
               if (this.a(var1.p(var17).c())) {
                  this.a(var1, var17, this.b);
                  if (var13 > 0) {
                     this.a(var1, var2, var17.e(), akk.N);
                     this.a(var1, var2, var17.d(), akk.b);
                  }
               }
            }
         }

         return true;
      }
   }

   private void c(adm var1, cj var2, int var3) {
      byte var4 = 2;

      for(int var5 = -var4; var5 <= 0; ++var5) {
         this.a(var1, var2.b(var5), var3 + 1 - var5);
      }

   }

   public ape(boolean var1, int var2, int var3, alz var4, alz var5) {
      super(var1, var2, var3, var4, var5);
   }

   private void a(adm var1, Random var2, cj var3, amk var4) {
      if (var2.nextInt(3) > 0 && var1.d(var3)) {
         this.a(var1, var3, afi.bn.Q().a(var4, true));
      }

   }
}
