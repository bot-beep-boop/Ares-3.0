public class bky implements blb<pr> {
   private final bjl<?> a;

   public boolean b() {
      return false;
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      zx var9 = var1.bA();
      if (var9 != null) {
         bfl.E();
         if (this.a.b().r) {
            float var10 = 0.5F;
            bfl.b(0.0F, 0.625F, 0.0F);
            bfl.b(-20.0F, -1.0F, 0.0F, 0.0F);
            bfl.a(var10, var10, var10);
         }

         ((bbj)this.a.b()).a(0.0625F);
         bfl.b(-0.0625F, 0.4375F, 0.0625F);
         if (var1 instanceof wn && ((wn)var1).bG != null) {
            var9 = new zx(zy.aR, 0);
         }

         zw var13 = var9.b();
         ave var11 = ave.A();
         if (var13 instanceof yo && afh.a(var13).b() == 2) {
            bfl.b(0.0F, 0.1875F, -0.3125F);
            bfl.b(20.0F, 1.0F, 0.0F, 0.0F);
            bfl.b(45.0F, 0.0F, 1.0F, 0.0F);
            float var12 = 0.375F;
            bfl.a(-var12, -var12, var12);
         }

         if (var1.av()) {
            bfl.b(0.0F, 0.203125F, 0.0F);
         }

         var11.ah().a(var1, var9, bgr.b.b);
         bfl.F();
      }
   }

   public bky(bjl<?> var1) {
      this.a = var1;
   }
}
