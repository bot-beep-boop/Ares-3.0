public class ayp extends ayl {
   private og w;
   private final wm v;
   private static final jy u = new jy("textures/gui/container/brewing_stand.png");

   protected void b(int var1, int var2) {
      String var3 = this.w.f_().c();
      this.q.a(var3, this.f / 2 - this.q.a(var3) / 2, 6, 4210752);
      this.q.a(this.v.f_().c(), 8, this.g - 96 + 2, 4210752);
   }

   public ayp(wm var1, og var2) {
      super(new xm(var1, var2));
      this.v = var1;
      this.w = var2;
   }

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(u);
      int var4 = (this.l - this.f) / 2;
      int var5 = (this.m - this.g) / 2;
      this.b(var4, var5, 0, 0, this.f, this.g);
      int var6 = this.w.a_(0);
      if (var6 > 0) {
         int var7 = (int)(28.0F * (1.0F - (float)var6 / 400.0F));
         if (var7 > 0) {
            this.b(var4 + 97, var5 + 16, 176, 0, 9, var7);
         }

         int var8 = var6 / 2 % 7;
         switch(var8) {
         case 0:
            var7 = 29;
            break;
         case 1:
            var7 = 24;
            break;
         case 2:
            var7 = 20;
            break;
         case 3:
            var7 = 16;
            break;
         case 4:
            var7 = 11;
            break;
         case 5:
            var7 = 6;
            break;
         case 6:
            var7 = 0;
         }

         if (var7 > 0) {
            this.b(var4 + 65, var5 + 14 + 29 - var7, 185, 29 - var7, 12, var7);
         }
      }

   }
}
