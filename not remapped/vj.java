public class vj extends pk {
   public int a;
   private pr b;

   protected boolean s_() {
      return false;
   }

   public vj(adm var1, double var2, double var4, double var6, pr var8) {
      this(var1);
      this.b(var2, var4, var6);
      float var9 = (float)(Math.random() * 3.1415927410125732D * 2.0D);
      this.v = (double)(-((float)Math.sin((double)var9)) * 0.02F);
      this.w = 0.20000000298023224D;
      this.x = (double)(-((float)Math.cos((double)var9)) * 0.02F);
      this.a = 80;
      this.p = var2;
      this.q = var4;
      this.r = var6;
      this.b = var8;
   }

   public float aS() {
      return 0.0F;
   }

   public void t_() {
      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.w -= 0.03999999910593033D;
      this.d(this.v, this.w, this.x);
      this.v *= 0.9800000190734863D;
      this.w *= 0.9800000190734863D;
      this.x *= 0.9800000190734863D;
      if (this.C) {
         this.v *= 0.699999988079071D;
         this.x *= 0.699999988079071D;
         this.w *= -0.5D;
      }

      if (this.a-- <= 0) {
         this.J();
         if (!this.o.D) {
            this.l();
         }
      } else {
         this.W();
         this.o.a(cy.l, this.s, this.t + 0.5D, this.u, 0.0D, 0.0D, 0.0D);
      }

   }

   protected void b(dn var1) {
      var1.a("Fuse", (byte)this.a);
   }

   protected void a(dn var1) {
      this.a = var1.d("Fuse");
   }

   public boolean ad() {
      return !this.I;
   }

   public pr j() {
      return this.b;
   }

   protected void h() {
   }

   private void l() {
      float var1 = 4.0F;
      this.o.a(this, this.s, this.t + (double)(this.K / 16.0F), this.u, var1, true);
   }

   public vj(adm var1) {
      super(var1);
      this.k = true;
      this.a(0.98F, 0.98F);
   }
}
