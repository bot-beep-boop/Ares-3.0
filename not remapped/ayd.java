public class ayd extends avp {
   private ave f;
   private static final jy a = new jy("textures/gui/achievement/achievement_background.png");
   private mq k;
   private long l;
   private bjh m;
   private boolean n;
   private String j;
   private int h;
   private int g;
   private String i;

   public void b() {
      this.k = null;
      this.l = 0L;
   }

   public void a() {
      if (this.k != null && this.l != 0L && ave.A().h != null) {
         double var1 = (double)(ave.J() - this.l) / 3000.0D;
         if (!this.n) {
            if (var1 < 0.0D || var1 > 1.0D) {
               this.l = 0L;
               return;
            }
         } else if (var1 > 0.5D) {
            var1 = 0.5D;
         }

         this.c();
         bfl.i();
         bfl.a(false);
         double var3 = var1 * 2.0D;
         if (var3 > 1.0D) {
            var3 = 2.0D - var3;
         }

         var3 *= 4.0D;
         var3 = 1.0D - var3;
         if (var3 < 0.0D) {
            var3 = 0.0D;
         }

         var3 *= var3;
         var3 *= var3;
         int var5 = this.g - 160;
         int var6 = 0 - (int)(var3 * 36.0D);
         bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
         bfl.w();
         this.f.P().a(a);
         bfl.f();
         this.b(var5, var6, 96, 202, 160, 32);
         if (this.n) {
            this.f.k.a(this.j, var5 + 30, var6 + 7, 120, -1);
         } else {
            this.f.k.a(this.i, var5 + 30, var6 + 7, -256);
            this.f.k.a(this.j, var5 + 30, var6 + 18, -1);
         }

         avc.c();
         bfl.f();
         bfl.B();
         bfl.g();
         bfl.e();
         this.m.b(this.k.d, var5 + 8, var6 + 8);
         bfl.f();
         bfl.a(true);
         bfl.j();
      }
   }

   public void a(mq var1) {
      this.i = bnq.a("achievement.get");
      this.j = var1.e().c();
      this.l = ave.J();
      this.k = var1;
      this.n = false;
   }

   public void b(mq var1) {
      this.i = var1.e().c();
      this.j = var1.f();
      this.l = ave.J() + 2500L;
      this.k = var1;
      this.n = true;
   }

   private void c() {
      bfl.b(0, 0, this.f.d, this.f.e);
      bfl.n(5889);
      bfl.D();
      bfl.n(5888);
      bfl.D();
      this.g = this.f.d;
      this.h = this.f.e;
      avr var1 = new avr(this.f);
      this.g = var1.a();
      this.h = var1.b();
      bfl.m(256);
      bfl.n(5889);
      bfl.D();
      bfl.a(0.0D, (double)this.g, (double)this.h, 0.0D, 1000.0D, 3000.0D);
      bfl.n(5888);
      bfl.D();
      bfl.b(0.0F, 0.0F, -2000.0F);
   }

   public ayd(ave var1) {
      this.f = var1;
      this.m = var1.ag();
   }
}
