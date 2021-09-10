public abstract class vv extends py implements vq {
   protected boolean ba() {
      return true;
   }

   protected String bp() {
      return "game.hostile.die";
   }

   public boolean r(pk var1) {
      float var2 = (float)this.a(vy.e).e();
      int var3 = 0;
      if (var1 instanceof pr) {
         var2 += ack.a(this.bA(), ((pr)var1).bz());
         var3 += ack.a((pr)this);
      }

      boolean var4 = var1.a(ow.a((pr)this), var2);
      if (var4) {
         if (var3 > 0) {
            var1.g((double)(-ns.a(this.y * 3.1415927F / 180.0F) * (float)var3 * 0.5F), 0.1D, (double)(ns.b(this.y * 3.1415927F / 180.0F) * (float)var3 * 0.5F));
            this.v *= 0.6D;
            this.x *= 0.6D;
         }

         int var5 = ack.b((pr)this);
         if (var5 > 0) {
            var1.e(var5 * 4);
         }

         this.a(this, var1);
      }

      return var4;
   }

   protected String n(int var1) {
      return var1 > 4 ? "game.hostile.hurt.fall.big" : "game.hostile.hurt.fall.small";
   }

   public float a(cj var1) {
      return 0.5F - this.o.o(var1);
   }

   public boolean bR() {
      return this.o.aa() != oj.a && this.n_() && super.bR();
   }

   protected String P() {
      return "game.hostile.swim";
   }

   protected String aa() {
      return "game.hostile.swim.splash";
   }

   protected void aX() {
      super.aX();
      this.by().b(vy.e);
   }

   public void m() {
      this.bx();
      float var1 = this.c(1.0F);
      if (var1 > 0.5F) {
         this.aQ += 2;
      }

      super.m();
   }

   public vv(adm var1) {
      super(var1);
      this.b_ = 5;
   }

   protected boolean n_() {
      cj var1 = new cj(this.s, this.aR().b, this.u);
      if (this.o.b(ads.a, var1) > this.V.nextInt(32)) {
         return false;
      } else {
         int var2 = this.o.l(var1);
         if (this.o.R()) {
            int var3 = this.o.ab();
            this.o.c(10);
            var2 = this.o.l(var1);
            this.o.c(var3);
         }

         return var2 <= this.V.nextInt(8);
      }
   }

   public boolean a(ow var1, float var2) {
      if (this.b(var1)) {
         return false;
      } else if (super.a(var1, var2)) {
         pk var3 = var1.j();
         return this.l != var3 && this.m != var3 ? true : true;
      } else {
         return false;
      }
   }

   protected String bo() {
      return "game.hostile.hurt";
   }

   public void t_() {
      super.t_();
      if (!this.o.D && this.o.aa() == oj.a) {
         this.J();
      }

   }
}
