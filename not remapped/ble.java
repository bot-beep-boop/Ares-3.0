public class ble implements blb<tw> {
   private final bjz a;

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((tw)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void a(tw var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (!var1.ax()) {
         bfl.E();
         this.a.g().c.c(0.0625F);
         float var9 = 0.625F;
         bfl.b(0.0F, -0.34375F, 0.0F);
         bfl.b(180.0F, 0.0F, 1.0F, 0.0F);
         bfl.a(var9, -var9, -var9);
         ave.A().ah().a(var1, new zx(afi.aU, 1), bgr.b.d);
         bfl.F();
      }
   }

   public boolean b() {
      return true;
   }

   public ble(bjz var1) {
      this.a = var1;
   }
}
