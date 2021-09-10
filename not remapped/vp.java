public class vp extends vv {
   private int a = 0;
   private boolean b = false;

   public boolean n() {
      return this.b;
   }

   public void m() {
      super.m();
      if (this.o.D) {
         for(int var1 = 0; var1 < 2; ++var1) {
            this.o.a(cy.y, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, (this.V.nextDouble() - 0.5D) * 2.0D, -this.V.nextDouble(), (this.V.nextDouble() - 0.5D) * 2.0D);
         }
      } else {
         if (!this.bZ()) {
            ++this.a;
         }

         if (this.a >= 2400) {
            this.J();
         }
      }

   }

   public void a(dn var1) {
      super.a(var1);
      this.a = var1.f("Lifetime");
      this.b = var1.n("PlayerSpawned");
   }

   protected String z() {
      return "mob.silverfish.say";
   }

   public boolean bR() {
      if (super.bR()) {
         wn var1 = this.o.a(this, 5.0D);
         return var1 == null;
      } else {
         return false;
      }
   }

   protected String bo() {
      return "mob.silverfish.hit";
   }

   public void a(boolean var1) {
      this.b = var1;
   }

   public void t_() {
      this.aI = this.y;
      super.t_();
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Lifetime", this.a);
      var1.a("PlayerSpawned", this.b);
   }

   protected boolean s_() {
      return false;
   }

   public pw bz() {
      return pw.c;
   }

   protected void aX() {
      super.aX();
      this.a(vy.a).a(8.0D);
      this.a(vy.d).a(0.25D);
      this.a(vy.e).a(2.0D);
   }

   protected boolean n_() {
      return true;
   }

   protected zw A() {
      return null;
   }

   public float aS() {
      return 0.1F;
   }

   protected String bp() {
      return "mob.silverfish.kill";
   }

   public vp(adm var1) {
      super(var1);
      this.b_ = 3;
      this.a(0.4F, 0.3F);
      this.i.a(1, new ra(this));
      this.i.a(2, new rl(this, wn.class, 1.0D, false));
      this.i.a(3, new rz(this, 1.0D));
      this.i.a(7, new ri(this, wn.class, 8.0F));
      this.i.a(8, new ry(this));
      this.bi.a(1, new sm(this, true, new Class[0]));
      this.bi.a(2, new sp(this, wn.class, true));
   }

   protected void a(cj var1, afh var2) {
      this.a("mob.silverfish.step", 0.15F, 1.0F);
   }
}
