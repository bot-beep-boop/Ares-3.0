public class bkv implements blb<ug> {
   private static final jy a = new jy("textures/entity/enderdragon/dragon_eyes.png");
   private final bir b;

   public void a(ug var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.b.a((jy)a);
      bfl.l();
      bfl.c();
      bfl.b(1, 1);
      bfl.f();
      bfl.c(514);
      char var9 = '\uf0f0';
      int var10 = var9 % 65536;
      int var11 = var9 / 65536;
      bqs.a(bqs.r, (float)var10 / 1.0F, (float)var11 / 1.0F);
      bfl.e();
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.b.b().a(var1, var2, var3, var5, var6, var7, var8);
      this.b.a(var1, var4);
      bfl.k();
      bfl.d();
      bfl.c(515);
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((ug)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public boolean b() {
      return false;
   }

   public bkv(bir var1) {
      this.b = var1;
   }
}
