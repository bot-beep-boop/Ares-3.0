public class bke extends bjm<vi> {
   protected void a(vi var1, float var2, alz var3) {
      int var4 = var1.l();
      if (var4 > -1 && (float)var4 - var2 + 1.0F < 10.0F) {
         float var5 = 1.0F - ((float)var4 - var2 + 1.0F) / 10.0F;
         var5 = ns.a(var5, 0.0F, 1.0F);
         var5 *= var5;
         var5 *= var5;
         float var6 = 1.0F + var5 * 0.3F;
         bfl.a(var6, var6, var6);
      }

      super.a(var1, var2, var3);
      if (var4 > -1 && var4 / 5 % 2 == 0) {
         bgd var7 = ave.A().ae();
         bfl.x();
         bfl.f();
         bfl.l();
         bfl.b(770, 772);
         bfl.c(1.0F, 1.0F, 1.0F, (1.0F - ((float)var4 - var2 + 1.0F) / 100.0F) * 0.8F);
         bfl.E();
         var7.a(afi.W.Q(), 1.0F);
         bfl.F();
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.k();
         bfl.e();
         bfl.w();
      }

   }

   public bke(biu var1) {
      super(var1);
   }

   protected void a(va var1, float var2, alz var3) {
      this.a((vi)var1, var2, var3);
   }
}
