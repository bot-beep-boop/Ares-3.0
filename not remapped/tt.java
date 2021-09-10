public class tt extends tm {
   private final qw bm;

   public void a(dn var1) {
      super.a(var1);
      this.l(var1.n("Saddle"));
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Saddle", this.cl());
   }

   public void e(float var1, float var2) {
      super.e(var1, var2);
      if (var1 > 5.0F && this.l instanceof wn) {
         ((wn)this.l).b((mw)mr.u);
      }

   }

   protected String z() {
      return "mob.pig.say";
   }

   protected String bo() {
      return "mob.pig.say";
   }

   public boolean d(zx var1) {
      return var1 != null && var1.b() == zy.bR;
   }

   public boolean cl() {
      return (this.ac.a(16) & 1) != 0;
   }

   protected void a(cj var1, afh var2) {
      this.a("mob.pig.step", 0.15F, 1.0F);
   }

   public void a(uv var1) {
      if (!this.o.D && !this.I) {
         vw var2 = new vw(this.o);
         var2.c(0, new zx(zy.B));
         var2.b(this.s, this.t, this.u, this.y, this.z);
         var2.k(this.ce());
         if (this.l_()) {
            var2.a((String)this.aM());
            var2.g(this.aN());
         }

         this.o.d((pk)var2);
         this.J();
      }
   }

   public boolean bW() {
      zx var1 = ((wn)this.l).bA();
      return var1 != null && var1.b() == zy.bY;
   }

   public tt(adm var1) {
      super(var1);
      this.a(0.9F, 0.9F);
      ((sv)this.s()).a(true);
      this.i.a(0, new ra(this));
      this.i.a(1, new rv(this, 1.25D));
      this.i.a(2, this.bm = new qw(this, 0.3F));
      this.i.a(3, new qv(this, 1.0D));
      this.i.a(4, new sh(this, 1.2D, zy.bY, false));
      this.i.a(4, new sh(this, 1.2D, zy.bR, false));
      this.i.a(5, new rc(this, 1.1D));
      this.i.a(6, new rz(this, 1.0D));
      this.i.a(7, new ri(this, wn.class, 6.0F));
      this.i.a(8, new ry(this));
   }

   protected void h() {
      super.h();
      this.ac.a(16, (byte)0);
   }

   public tt b(ph var1) {
      return new tt(this.o);
   }

   protected zw A() {
      return this.at() ? zy.am : zy.al;
   }

   protected String bp() {
      return "mob.pig.death";
   }

   public void l(boolean var1) {
      if (var1) {
         this.ac.b(16, (byte)1);
      } else {
         this.ac.b(16, (byte)0);
      }

   }

   public ph a(ph var1) {
      return this.b(var1);
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(3) + 1 + this.V.nextInt(1 + var2);

      for(int var4 = 0; var4 < var3; ++var4) {
         if (this.at()) {
            this.a(zy.am, 1);
         } else {
            this.a(zy.al, 1);
         }
      }

      if (this.cl()) {
         this.a(zy.aA, 1);
      }

   }

   public boolean a(wn var1) {
      if (super.a(var1)) {
         return true;
      } else if (!this.cl() || this.o.D || this.l != null && this.l != var1) {
         return false;
      } else {
         var1.a((pk)this);
         return true;
      }
   }

   public qw cm() {
      return this.bm;
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(10.0D);
      this.a((qb)vy.d).a(0.25D);
   }
}
