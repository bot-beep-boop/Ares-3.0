public class ayv extends ayl {
   private static final jy v = new jy("textures/gui/container/dispenser.png");
   public og u;
   private final wm w;

   public ayv(wm var1, og var2) {
      super(new xr(var1, var2));
      this.w = var1;
      this.u = var2;
   }

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(v);
      int var4 = (this.l - this.f) / 2;
      int var5 = (this.m - this.g) / 2;
      this.b(var4, var5, 0, 0, this.f, this.g);
   }

   protected void b(int var1, int var2) {
      String var3 = this.u.f_().c();
      this.q.a(var3, this.f / 2 - this.q.a(var3) / 2, 6, 4210752);
      this.q.a(this.w.f_().c(), 8, this.g - 96 + 2, 4210752);
   }
}
