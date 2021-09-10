public class biq extends biv<uf> {
   private bbo e = new bcp(0.0F, true);
   private static final jy a = new jy("textures/entity/endercrystal/endercrystal.png");

   protected jy a(uf var1) {
      return a;
   }

   public biq(biu var1) {
      super(var1);
      this.c = 0.5F;
   }

   protected jy a(pk var1) {
      return this.a((uf)var1);
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((uf)var1, var2, var4, var6, var8, var9);
   }

   public void a(uf var1, double var2, double var4, double var6, float var8, float var9) {
      float var10 = (float)var1.a + var9;
      bfl.E();
      bfl.b((float)var2, (float)var4, (float)var6);
      this.a((jy)a);
      float var11 = ns.a(var10 * 0.2F) / 2.0F + 0.5F;
      var11 += var11 * var11;
      this.e.a(var1, 0.0F, var10 * 3.0F, var11 * 0.2F, 0.0F, 0.0F, 0.0625F);
      bfl.F();
      super.a(var1, var2, var4, var6, var8, var9);
   }
}
