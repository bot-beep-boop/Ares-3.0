public class aza extends ayl {
   private og w;
   private og v;
   private static final jy u = new jy("textures/gui/container/hopper.png");

   public aza(wm var1, og var2) {
      super(new xw(var1, var2, ave.A().h));
      this.v = var1;
      this.w = var2;
      this.p = false;
      this.g = 133;
   }

   protected void b(int var1, int var2) {
      this.q.a(this.w.f_().c(), 8, 6, 4210752);
      this.q.a(this.v.f_().c(), 8, this.g - 96 + 2, 4210752);
   }

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(u);
      int var4 = (this.l - this.f) / 2;
      int var5 = (this.m - this.g) / 2;
      this.b(var4, var5, 0, 0, this.f, this.g);
   }
}
