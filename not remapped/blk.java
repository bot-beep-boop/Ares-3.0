public class blk implements blb<ua> {
   private static final jy a = new jy("textures/entity/wolf/wolf_collar.png");
   private final bkl b;

   public void a(ua var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1.cl() && !var1.ax()) {
         this.b.a((jy)a);
         zd var9 = zd.b(var1.cw().a());
         float[] var10 = tv.a(var9);
         bfl.c(var10[0], var10[1], var10[2]);
         this.b.b().a(var1, var2, var3, var5, var6, var7, var8);
      }
   }

   public blk(bkl var1) {
      this.b = var1;
   }

   public boolean b() {
      return true;
   }

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((ua)var1, var2, var3, var4, var5, var6, var7, var8);
   }
}
