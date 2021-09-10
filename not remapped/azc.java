public class azc extends ayw {
   private float v;
   private float u;

   public azc(wn var1) {
      super(var1.bj);
      this.p = true;
   }

   public void b() {
      this.n.clear();
      if (this.j.c.h()) {
         this.j.a((axu)(new ayu(this.j.h)));
      } else {
         super.b();
      }

   }

   public static void a(int var0, int var1, int var2, float var3, float var4, pr var5) {
      bfl.g();
      bfl.E();
      bfl.b((float)var0, (float)var1, 50.0F);
      bfl.a((float)(-var2), (float)var2, (float)var2);
      bfl.b(180.0F, 0.0F, 0.0F, 1.0F);
      float var6 = var5.aI;
      float var7 = var5.y;
      float var8 = var5.z;
      float var9 = var5.aL;
      float var10 = var5.aK;
      bfl.b(135.0F, 0.0F, 1.0F, 0.0F);
      avc.b();
      bfl.b(-135.0F, 0.0F, 1.0F, 0.0F);
      bfl.b(-((float)Math.atan((double)(var4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      var5.aI = (float)Math.atan((double)(var3 / 40.0F)) * 20.0F;
      var5.y = (float)Math.atan((double)(var3 / 40.0F)) * 40.0F;
      var5.z = -((float)Math.atan((double)(var4 / 40.0F))) * 20.0F;
      var5.aK = var5.y;
      var5.aL = var5.y;
      bfl.b(0.0F, 0.0F, 0.0F);
      biu var11 = ave.A().af();
      var11.a(180.0F);
      var11.a(false);
      var11.a(var5, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      var11.a(true);
      var5.aI = var6;
      var5.y = var7;
      var5.z = var8;
      var5.aL = var9;
      var5.aK = var10;
      bfl.F();
      avc.a();
      bfl.C();
      bfl.g(bqs.r);
      bfl.x();
      bfl.g(bqs.q);
   }

   public void e() {
      if (this.j.c.h()) {
         this.j.a((axu)(new ayu(this.j.h)));
      }

      this.a();
   }

   protected void b(int var1, int var2) {
      this.q.a(bnq.a("container.crafting"), 86, 16, 4210752);
   }

   protected void a(avs var1) {
      if (var1.k == 0) {
         this.j.a((axu)(new aye(this, this.j.h.x())));
      }

      if (var1.k == 1) {
         this.j.a((axu)(new ayf(this, this.j.h.x())));
      }

   }

   protected void a(float var1, int var2, int var3) {
      bfl.c(1.0F, 1.0F, 1.0F, 1.0F);
      this.j.P().a(a);
      int var4 = this.i;
      int var5 = this.r;
      this.b(var4, var5, 0, 0, this.f, this.g);
      a(var4 + 51, var5 + 75, 30, (float)(var4 + 51) - this.u, (float)(var5 + 75 - 50) - this.v, this.j.h);
   }

   public void a(int var1, int var2, float var3) {
      super.a(var1, var2, var3);
      this.u = (float)var1;
      this.v = (float)var2;
   }
}
