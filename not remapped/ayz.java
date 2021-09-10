public class ayz extends ayl {
   private final wm v;
   private og w;
   private static final jy u = new jy("textures/gui/container/furnace.png");

   protected void b(int var1, int var2) {
      String var3 = this.w.f_().c();
      this.q.a(var3, this.f / 2 - this.q.a(var3) / 2, 6, 4210752);
      this.q.a(this.v.f_().c(), 8, this.g - 96 + 2, 4210752);
   }

   private int i(int var1) {
      int var2 = this.w.a_(1);
      if (var2 == 0) {
         var2 = 200;
      }

      return this.w.a_(0) * var1 / var2;
   }

   public ayz(wm var1, og var2) {
      super(new xu(var1, var2));
      this.v = var1;
      this.w = var2;
   }

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(u);
      int var4 = (this.l - this.f) / 2;
      int var5 = (this.m - this.g) / 2;
      this.b(var4, var5, 0, 0, this.f, this.g);
      int var6;
      if (alh.a(this.w)) {
         var6 = this.i(13);
         this.b(var4 + 56, var5 + 36 + 12 - var6, 176, 12 - var6, 14, var6 + 1);
      }

      var6 = this.h(24);
      this.b(var4 + 79, var5 + 34, 176, 14, var6 + 1, 16);
   }

   private int h(int var1) {
      int var2 = this.w.a_(2);
      int var3 = this.w.a_(3);
      return var3 != 0 && var2 != 0 ? var2 * var1 / var3 : 0;
   }
}
