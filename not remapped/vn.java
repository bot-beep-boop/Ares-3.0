public class vn extends vv {
   private int bn = 0;
   private int bm = 3;
   private int b;
   private int c = 30;
   private int a;

   public void a(int var1) {
      this.ac.b(16, (byte)var1);
   }

   public void t_() {
      if (this.ai()) {
         this.a = this.b;
         if (this.cn()) {
            this.a(1);
         }

         int var1 = this.cm();
         if (var1 > 0 && this.b == 0) {
            this.a("creeper.primed", 1.0F, 0.5F);
         }

         this.b += var1;
         if (this.b < 0) {
            this.b = 0;
         }

         if (this.b >= this.c) {
            this.b = this.c;
            this.cr();
         }
      }

      super.t_();
   }

   protected String bo() {
      return "mob.creeper.say";
   }

   public int cm() {
      return this.ac.a(16);
   }

   public void e(float var1, float var2) {
      super.e(var1, var2);
      this.b = (int)((float)this.b + var1 * 1.5F);
      if (this.b > this.c - 5) {
         this.b = this.c - 5;
      }

   }

   public boolean n() {
      return this.ac.a(17) == 1;
   }

   protected boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (var2 != null && var2.b() == zy.d) {
         this.o.a(this.s + 0.5D, this.t + 0.5D, this.u + 0.5D, "fire.ignite", 1.0F, this.V.nextFloat() * 0.4F + 0.8F);
         var1.bw();
         if (!this.o.D) {
            this.co();
            var2.a(1, (pr)var1);
            return true;
         }
      }

      return super.a(var1);
   }

   public void a(dn var1) {
      super.a(var1);
      this.ac.b(17, (byte)(var1.n("powered") ? 1 : 0));
      if (var1.b("Fuse", 99)) {
         this.c = var1.e("Fuse");
      }

      if (var1.b("ExplosionRadius", 99)) {
         this.bm = var1.d("ExplosionRadius");
      }

      if (var1.n("ignited")) {
         this.co();
      }

   }

   protected void h() {
      super.h();
      this.ac.a(16, -1);
      this.ac.a(17, (byte)0);
      this.ac.a(18, (byte)0);
   }

   public float a(float var1) {
      return ((float)this.a + (float)(this.b - this.a) * var1) / (float)(this.c - 2);
   }

   public void cq() {
      ++this.bn;
   }

   public vn(adm var1) {
      super(var1);
      this.i.a(1, new ra(this));
      this.i.a(2, new sf(this));
      this.i.a(3, new qs(this, ts.class, 6.0F, 1.0D, 1.2D));
      this.i.a(4, new rl(this, 1.0D, false));
      this.i.a(5, new rz(this, 0.8D));
      this.i.a(6, new ri(this, wn.class, 8.0F));
      this.i.a(6, new ry(this));
      this.bi.a(1, new sp(this, wn.class, true));
      this.bi.a(2, new sm(this, false, new Class[0]));
   }

   public boolean cp() {
      return this.bn < 1 && this.o.Q().b("doMobLoot");
   }

   protected String bp() {
      return "mob.creeper.death";
   }

   public boolean r(pk var1) {
      return true;
   }

   private void cr() {
      if (!this.o.D) {
         boolean var1 = this.o.Q().b("mobGriefing");
         float var2 = this.n() ? 2.0F : 1.0F;
         this.o.a(this, this.s, this.t, this.u, (float)this.bm * var2, var1);
         this.J();
      }

   }

   protected zw A() {
      return zy.H;
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.d).a(0.25D);
   }

   public void b(dn var1) {
      super.b(var1);
      if (this.ac.a(17) == 1) {
         var1.a("powered", true);
      }

      var1.a("Fuse", (short)this.c);
      var1.a("ExplosionRadius", (byte)this.bm);
      var1.a("ignited", this.cn());
   }

   public void a(uv var1) {
      super.a(var1);
      this.ac.b(17, (byte)1);
   }

   public void co() {
      this.ac.b(18, (byte)1);
   }

   public boolean cn() {
      return this.ac.a(18) != 0;
   }

   public int aE() {
      return this.u() == null ? 3 : 3 + (int)(this.bn() - 1.0F);
   }

   public void a(ow var1) {
      super.a(var1);
      if (var1.j() instanceof wa) {
         int var2 = zw.b(zy.cq);
         int var3 = zw.b(zy.cB);
         int var4 = var2 + this.V.nextInt(var3 - var2 + 1);
         this.a(zw.b(var4), 1);
      } else if (var1.j() instanceof vn && var1.j() != this && ((vn)var1.j()).n() && ((vn)var1.j()).cp()) {
         ((vn)var1.j()).cq();
         this.a(new zx(zy.bX, 1, 4), 0.0F);
      }

   }
}
