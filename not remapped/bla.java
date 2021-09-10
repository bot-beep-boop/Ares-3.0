public class bla implements blb<tt> {
   private final bbq c = new bbq(0.5F);
   private static final jy a = new jy("textures/entity/pig/pig_saddle.png");
   private final bjs b;

   public void a(pr var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.a((tt)var1, var2, var3, var4, var5, var6, var7, var8);
   }

   public bla(bjs var1) {
      this.b = var1;
   }

   public void a(tt var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      if (var1.cl()) {
         this.b.a((jy)a);
         this.c.a(this.b.b());
         this.c.a(var1, var2, var3, var5, var6, var7, var8);
      }
   }

   public boolean b() {
      return false;
   }
}
