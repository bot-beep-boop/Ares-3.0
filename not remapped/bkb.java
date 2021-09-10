public class bkb extends bjo<tx> {
   private static final jy a = new jy("textures/entity/squid.png");

   protected jy a(pk var1) {
      return this.a((tx)var1);
   }

   protected void a(tx var1, float var2, float var3, float var4) {
      float var5 = var1.b + (var1.a - var1.b) * var4;
      float var6 = var1.bk + (var1.c - var1.bk) * var4;
      bfl.b(0.0F, 0.5F, 0.0F);
      bfl.b(180.0F - var3, 0.0F, 1.0F, 0.0F);
      bfl.b(var5, 1.0F, 0.0F, 0.0F);
      bfl.b(var6, 0.0F, 1.0F, 0.0F);
      bfl.b(0.0F, -1.2F, 0.0F);
   }

   protected void a(pr var1, float var2, float var3, float var4) {
      this.a((tx)var1, var2, var3, var4);
   }

   protected jy a(tx var1) {
      return a;
   }

   protected float a(tx var1, float var2) {
      return var1.bo + (var1.bn - var1.bo) * var2;
   }

   public bkb(biu var1, bbo var2, float var3) {
      super(var1, var2, var3);
   }

   protected float b(pr var1, float var2) {
      return this.a((tx)var1, var2);
   }
}
