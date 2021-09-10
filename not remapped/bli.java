public class bli implements blb<wd> {
   private final bki a;

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((wd)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public bli(bki var1) {
      this.a = var1;
   }

   public boolean b() {
      return false;
   }

   public void a(wd var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      zx var9 = var1.bA();
      if (var9 != null) {
         bfl.c(1.0F, 1.0F, 1.0F);
         bfl.E();
         if (this.a.b().r) {
            bfl.b(0.0F, 0.625F, 0.0F);
            bfl.b(-20.0F, -1.0F, 0.0F, 0.0F);
            float var10 = 0.5F;
            bfl.a(var10, var10, var10);
         }

         ((bck)this.a.b()).f.c(0.0625F);
         bfl.b(-0.0625F, 0.53125F, 0.21875F);
         zw var13 = var9.b();
         ave var11 = ave.A();
         float var12;
         if (var13 instanceof yo && var11.ae().a(afh.a(var13), var9.i())) {
            bfl.b(0.0F, 0.0625F, -0.25F);
            bfl.b(30.0F, 1.0F, 0.0F, 0.0F);
            bfl.b(-5.0F, 0.0F, 1.0F, 0.0F);
            var12 = 0.375F;
            bfl.a(var12, -var12, var12);
         } else if (var13 == zy.f) {
            bfl.b(0.0F, 0.125F, -0.125F);
            bfl.b(-45.0F, 0.0F, 1.0F, 0.0F);
            var12 = 0.625F;
            bfl.a(var12, -var12, var12);
            bfl.b(-100.0F, 1.0F, 0.0F, 0.0F);
            bfl.b(-20.0F, 0.0F, 1.0F, 0.0F);
         } else if (var13.w_()) {
            if (var13.e()) {
               bfl.b(180.0F, 0.0F, 0.0F, 1.0F);
               bfl.b(0.0F, -0.0625F, 0.0F);
            }

            this.a.C_();
            bfl.b(0.0625F, -0.125F, 0.0F);
            var12 = 0.625F;
            bfl.a(var12, -var12, var12);
            bfl.b(0.0F, 1.0F, 0.0F, 0.0F);
            bfl.b(0.0F, 0.0F, 1.0F, 0.0F);
         } else {
            bfl.b(0.1875F, 0.1875F, 0.0F);
            var12 = 0.875F;
            bfl.a(var12, var12, var12);
            bfl.b(-20.0F, 0.0F, 0.0F, 1.0F);
            bfl.b(-60.0F, 1.0F, 0.0F, 0.0F);
            bfl.b(-30.0F, 0.0F, 0.0F, 1.0F);
         }

         bfl.b(-15.0F, 1.0F, 0.0F, 0.0F);
         bfl.b(40.0F, 0.0F, 0.0F, 1.0F);
         var11.ah().a(var1, var9, bgr.b.b);
         bfl.F();
      }
   }
}
