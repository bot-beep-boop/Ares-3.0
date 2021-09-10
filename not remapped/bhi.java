public class bhi extends bhd<alu> {
   private final bgd c = ave.A().ae();

   public void a(alu var1, double var2, double var4, double var6, float var8, int var9) {
      cj var10 = var1.v();
      alz var11 = var1.b();
      afh var12 = var11.c();
      if (var12.t() != arm.a && !(var1.a(var8) >= 1.0F)) {
         bfx var13 = bfx.a();
         bfd var14 = var13.c();
         this.a(bmh.g);
         avc.a();
         bfl.b(770, 771);
         bfl.l();
         bfl.p();
         if (ave.x()) {
            bfl.j(7425);
         } else {
            bfl.j(7424);
         }

         var14.a(7, bms.a);
         var14.c((double)((float)var2 - (float)var10.n() + var1.b(var8)), (double)((float)var4 - (float)var10.o() + var1.c(var8)), (double)((float)var6 - (float)var10.p() + var1.d(var8)));
         adm var15 = this.b();
         if (var12 == afi.K && var1.a(var8) < 0.5F) {
            var11 = var11.a(alt.N, true);
            this.c.b().a(var15, this.c.a(var11, var15, var10), (alz)var11, var10, var14, true);
         } else if (var1.g() && !var1.d()) {
            alt.a var16 = var12 == afi.F ? alt.a.b : alt.a.a;
            alz var17 = afi.K.Q().a(alt.b, var16).a(alt.a, var11.b(als.a));
            var17 = var17.a(alt.N, var1.a(var8) >= 0.5F);
            this.c.b().a(var15, this.c.a(var17, var15, var10), (alz)var17, var10, var14, true);
            var14.c((double)((float)var2 - (float)var10.n()), (double)((float)var4 - (float)var10.o()), (double)((float)var6 - (float)var10.p()));
            var11.a(als.b, true);
            this.c.b().a(var15, this.c.a(var11, var15, var10), (alz)var11, var10, var14, true);
         } else {
            this.c.b().a(var15, this.c.a(var11, var15, var10), (alz)var11, var10, var14, false);
         }

         var14.c(0.0D, 0.0D, 0.0D);
         var13.b();
         avc.b();
      }
   }

   public void a(akw var1, double var2, double var4, double var6, float var8, int var9) {
      this.a((alu)var1, var2, var4, var6, var8, var9);
   }
}
