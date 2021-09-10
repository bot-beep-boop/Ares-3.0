public class bkt implements blb<bet> {
   private final bln a;

   public bkt(bln var1) {
      this.a = var1;
   }

   public boolean b() {
      return true;
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((bet)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public void a(bet var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1.e_().equals("deadmau5") && var1.g() && !var1.ax()) {
         this.a.a((jy)var1.i());

         for(int var9 = 0; var9 < 2; ++var9) {
            float var10 = var1.A + (var1.y - var1.A) * var4 - (var1.aJ + (var1.aI - var1.aJ) * var4);
            float var11 = var1.B + (var1.z - var1.B) * var4;
            bfl.E();
            bfl.b(var10, 0.0F, 1.0F, 0.0F);
            bfl.b(var11, 1.0F, 0.0F, 0.0F);
            bfl.b(0.375F * (float)(var9 * 2 - 1), 0.0F, 0.0F);
            bfl.b(0.0F, -0.375F, 0.0F);
            bfl.b(-var11, 1.0F, 0.0F, 0.0F);
            bfl.b(-var10, 0.0F, 1.0F, 0.0F);
            float var12 = 1.3333334F;
            bfl.a(var12, var12, var12);
            this.a.g().b(0.0625F);
            bfl.F();
         }

      }
   }
}
