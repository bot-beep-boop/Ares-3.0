public class tn extends tm {
   public float bm;
   public boolean bt;
   public float bo;
   public float bq;
   public float bp;
   public float br = 1.0F;
   public int bs;

   public void al() {
      super.al();
      float var1 = ns.a(this.aI * 3.1415927F / 180.0F);
      float var2 = ns.b(this.aI * 3.1415927F / 180.0F);
      float var3 = 0.1F;
      float var4 = 0.0F;
      this.l.b(this.s + (double)(var3 * var1), this.t + (double)(this.K * 0.5F) + this.l.am() + (double)var4, this.u - (double)(var3 * var2));
      if (this.l instanceof pr) {
         ((pr)this.l).aI = this.aI;
      }

   }

   public ph a(ph var1) {
      return this.b(var1);
   }

   public void l(boolean var1) {
      this.bt = var1;
   }

   protected void a(cj var1, afh var2) {
      this.a("mob.chicken.step", 0.15F, 1.0F);
   }

   public boolean cl() {
      return this.bt;
   }

   public tn b(ph var1) {
      return new tn(this.o);
   }

   public float aS() {
      return this.K;
   }

   protected zw A() {
      return zy.G;
   }

   public boolean d(zx var1) {
      return var1 != null && var1.b() == zy.N;
   }

   protected int b(wn var1) {
      return this.cl() ? 10 : super.b(var1);
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(4.0D);
      this.a((qb)vy.d).a(0.25D);
   }

   protected String z() {
      return "mob.chicken.say";
   }

   protected String bp() {
      return "mob.chicken.hurt";
   }

   public void m() {
      super.m();
      this.bq = this.bm;
      this.bp = this.bo;
      this.bo = (float)((double)this.bo + (double)(this.C ? -1 : 4) * 0.3D);
      this.bo = ns.a(this.bo, 0.0F, 1.0F);
      if (!this.C && this.br < 1.0F) {
         this.br = 1.0F;
      }

      this.br = (float)((double)this.br * 0.9D);
      if (!this.C && this.w < 0.0D) {
         this.w *= 0.6D;
      }

      this.bm += this.br * 2.0F;
      if (!this.o.D && !this.j_() && !this.cl() && --this.bs <= 0) {
         this.a("mob.chicken.plop", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
         this.a(zy.aP, 1);
         this.bs = this.V.nextInt(6000) + 6000;
      }

   }

   public tn(adm var1) {
      super(var1);
      this.a(0.4F, 0.7F);
      this.bs = this.V.nextInt(6000) + 6000;
      this.i.a(0, new ra(this));
      this.i.a(1, new rv(this, 1.4D));
      this.i.a(2, new qv(this, 1.0D));
      this.i.a(3, new sh(this, 1.0D, zy.N, false));
      this.i.a(4, new rc(this, 1.1D));
      this.i.a(5, new rz(this, 1.0D));
      this.i.a(6, new ri(this, wn.class, 6.0F));
      this.i.a(7, new ry(this));
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("IsChickenJockey", this.bt);
      var1.a("EggLayTime", this.bs);
   }

   public void e(float var1, float var2) {
   }

   protected String bo() {
      return "mob.chicken.hurt";
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + this.V.nextInt(1 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         this.a(zy.G, 1);
      }

      if (this.at()) {
         this.a(zy.bl, 1);
      } else {
         this.a(zy.bk, 1);
      }

   }

   protected boolean C() {
      return this.cl() && this.l == null;
   }

   public void a(dn var1) {
      super.a(var1);
      this.bt = var1.n("IsChickenJockey");
      if (var1.c("EggLayTime")) {
         this.bs = var1.f("EggLayTime");
      }

   }
}
