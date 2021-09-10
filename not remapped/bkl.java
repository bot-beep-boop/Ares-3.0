public class bkl extends bjo<ua> {
   private static final jy j = new jy("textures/entity/wolf/wolf_angry.png");
   private static final jy a = new jy("textures/entity/wolf/wolf.png");
   private static final jy e = new jy("textures/entity/wolf/wolf_tame.png");

   public void a(pr var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ua)var1, var2, var4, var6, var8, var9);
   }

   public void a(ua var1, double var2, double var4, double var6, float var8, float var9) {
      if (var1.ct()) {
         float var10 = var1.c(var9) * var1.p(var9);
         bfl.c(var10, var10, var10);
      }

      super.a((ps)var1, var2, var4, var6, var8, var9);
   }

   protected float a(ua var1, float var2) {
      return var1.cu();
   }

   protected jy a(ua var1) {
      if (var1.cl()) {
         return e;
      } else {
         return var1.cv() ? j : a;
      }
   }

   public void a(pk var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ua)var1, var2, var4, var6, var8, var9);
   }

   protected float b(pr var1, float var2) {
      return this.a((ua)var1, var2);
   }

   protected jy a(pk var1) {
      return this.a((ua)var1);
   }

   public bkl(biu var1, bbo var2, float var3) {
      super(var1, var2, var3);
      this.a((blb)(new blk(this)));
   }

   public void a(ps var1, double var2, double var4, double var6, float var8, float var9) {
      this.a((ua)var1, var2, var4, var6, var8, var9);
   }
}
