public class tw extends tq implements vx {
   protected zw A() {
      return zy.aD;
   }

   public float aS() {
      return 1.7F;
   }

   public tw(adm var1) {
      super(var1);
      this.a(0.7F, 1.9F);
      ((sv)this.s()).a(true);
      this.i.a(1, new sa(this, 1.25D, 20, 10.0F));
      this.i.a(2, new rz(this, 1.0D));
      this.i.a(3, new ri(this, wn.class, 6.0F));
      this.i.a(4, new ry(this));
      this.bi.a(1, new sp(this, ps.class, 10, true, false, vq.d));
   }

   protected void aX() {
      super.aX();
      this.a(vy.a).a(4.0D);
      this.a(vy.d).a(0.20000000298023224D);
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(16);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(zy.aD, 1);
      }

   }

   public void m() {
      super.m();
      if (!this.o.D) {
         int var1 = ns.c(this.s);
         int var2 = ns.c(this.t);
         int var3 = ns.c(this.u);
         if (this.U()) {
            this.a(ow.f, 1.0F);
         }

         if (this.o.b(new cj(var1, 0, var3)).a(new cj(var1, var2, var3)) > 1.0F) {
            this.a(ow.c, 1.0F);
         }

         for(int var4 = 0; var4 < 4; ++var4) {
            var1 = ns.c(this.s + (double)((float)(var4 % 2 * 2 - 1) * 0.25F));
            var2 = ns.c(this.t);
            var3 = ns.c(this.u + (double)((float)(var4 / 2 % 2 * 2 - 1) * 0.25F));
            cj var5 = new cj(var1, var2, var3);
            if (this.o.p(var5).c().t() == arm.a && this.o.b(new cj(var1, 0, var3)).a(var5) < 0.8F && afi.aH.d(this.o, var5)) {
               this.o.a(var5, afi.aH.Q());
            }
         }
      }

   }

   public void a(pr var1, float var2) {
      wx var3 = new wx(this.o, this);
      double var4 = var1.t + (double)var1.aS() - 1.100000023841858D;
      double var6 = var1.s - this.s;
      double var8 = var4 - var3.t;
      double var10 = var1.u - this.u;
      float var12 = ns.a(var6 * var6 + var10 * var10) * 0.2F;
      var3.c(var6, var8 + (double)var12, var10, 1.6F, 12.0F);
      this.a("random.bow", 1.0F, 1.0F / (this.bc().nextFloat() * 0.4F + 0.8F));
      this.o.d((pk)var3);
   }
}
