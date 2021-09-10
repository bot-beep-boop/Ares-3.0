public class azb extends ayl {
   private static final jy u = new jy("textures/gui/container/horse.png");
   private tp x;
   private og v;
   private float y;
   private og w;
   private float z;

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(u);
      int var4 = (this.l - this.f) / 2;
      int var5 = (this.m - this.g) / 2;
      this.b(var4, var5, 0, 0, this.f, this.g);
      if (this.x.cw()) {
         this.b(var4 + 79, var5 + 17, 0, this.g, 90, 54);
      }

      if (this.x.cO()) {
         this.b(var4 + 7, var5 + 35, 0, this.g + 54, 18, 18);
      }

      azc.a(var4 + 51, var5 + 60, 17, (float)(var4 + 51) - this.y, (float)(var5 + 75 - 50) - this.z, this.x);
   }

   public azb(og var1, og var2, tp var3) {
      super(new xx(var1, var2, var3, ave.A().h));
      this.v = var1;
      this.w = var2;
      this.x = var3;
      this.p = false;
   }

   protected void b(int var1, int var2) {
      this.q.a(this.w.f_().c(), 8, 6, 4210752);
      this.q.a(this.v.f_().c(), 8, this.g - 96 + 2, 4210752);
   }

   public void a(int var1, int var2, float var3) {
      this.y = (float)var1;
      this.z = (float)var2;
      super.a(var1, var2, var3);
   }
}
