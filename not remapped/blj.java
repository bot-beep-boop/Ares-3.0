public class blj implements blb<uk> {
   private final bkj b;
   private final bcl c = new bcl(0.5F);
   private static final jy a = new jy("textures/entity/wither/wither_armor.png");

   public boolean b() {
      return false;
   }

   public void a(uk var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1.cm()) {
         bfl.a(!var1.ax());
         this.b.a((jy)a);
         bfl.n(5890);
         bfl.D();
         float var9 = (float)var1.W + var4;
         float var10 = ns.b(var9 * 0.02F) * 3.0F;
         float var11 = var9 * 0.01F;
         bfl.b(var10, var11, 0.0F);
         bfl.n(5888);
         bfl.l();
         float var12 = 0.5F;
         bfl.c(var12, var12, var12, 1.0F);
         bfl.f();
         bfl.b(1, 1);
         this.c.a(var1, var2, var3, var4);
         this.c.a(this.b.b());
         this.c.a(var1, var2, var3, var5, var6, var7, var8);
         bfl.n(5890);
         bfl.D();
         bfl.n(5888);
         bfl.e();
         bfl.k();
      }
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((uk)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public blj(bkj var1) {
      this.b = var1;
   }
}
