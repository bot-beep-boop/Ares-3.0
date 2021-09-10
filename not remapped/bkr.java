public class bkr implements blb<vn> {
   private final bio b;
   private static final jy a = new jy("textures/entity/creeper/creeper_armor.png");
   private final bbc c = new bbc(2.0F);

   public bkr(bio var1) {
      this.b = var1;
   }

   public boolean b() {
      return false;
   }

   public void a(vn var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1.n()) {
         boolean var9 = var1.ax();
         bfl.a(!var9);
         this.b.a((jy)a);
         bfl.n(5890);
         bfl.D();
         float var10 = (float)var1.W + var4;
         bfl.b(var10 * 0.01F, var10 * 0.01F, 0.0F);
         bfl.n(5888);
         bfl.l();
         float var11 = 0.5F;
         bfl.c(var11, var11, var11, 1.0F);
         bfl.f();
         bfl.b(1, 1);
         this.c.a(this.b.b());
         this.c.a(var1, var2, var3, var5, var6, var7, var8);
         bfl.n(5890);
         bfl.D();
         bfl.n(5888);
         bfl.e();
         bfl.k();
         bfl.a(var9);
      }
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((vn)var1, var2, var3, var4, var5, var6, var7, var8);
   }
}
