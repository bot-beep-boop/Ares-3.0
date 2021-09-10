public class bkq implements blb<vo> {
   private final bis a;

   public void a(vo var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      alz var9 = var1.cm();
      if (var9.c().t() != arm.a) {
         bgd var10 = ave.A().ae();
         bfl.B();
         bfl.E();
         bfl.b(0.0F, 0.6875F, -0.75F);
         bfl.b(20.0F, 1.0F, 0.0F, 0.0F);
         bfl.b(45.0F, 0.0F, 1.0F, 0.0F);
         bfl.b(0.25F, 0.1875F, 0.25F);
         float var11 = 0.5F;
         bfl.a(-var11, -var11, var11);
         int var12 = var1.b(var4);
         int var13 = var12 % 65536;
         int var14 = var12 / 65536;
         bqs.a(bqs.r, (float)var13 / 1.0F, (float)var14 / 1.0F);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         this.a.a((jy)bmh.g);
         var10.a(var9, 1.0F);
         bfl.F();
         bfl.C();
      }
   }

   public boolean b() {
      return false;
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((vo)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public bkq(bis var1) {
      this.a = var1;
   }
}
