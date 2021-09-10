import java.util.Calendar;

public class wa extends vv implements vx {
   private rl b = new rl(this, wn.class, 1.2D, false);
   private sa a = new sa(this, 1.0D, 20, 60, 15.0F);

   protected String bo() {
      return "mob.skeleton.hurt";
   }

   protected void h() {
      super.h();
      this.ac.a(13, new Byte((byte)0));
   }

   public void m() {
      if (this.o.w() && !this.o.D) {
         float var1 = this.c(1.0F);
         cj var2 = new cj(this.s, (double)Math.round(this.t), this.u);
         if (var1 > 0.5F && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.o.i(var2)) {
            boolean var3 = true;
            zx var4 = this.p(4);
            if (var4 != null) {
               if (var4.e()) {
                  var4.b(var4.h() + this.V.nextInt(2));
                  if (var4.h() >= var4.j()) {
                     this.b(var4);
                     this.c(4, (zx)null);
                  }
               }

               var3 = false;
            }

            if (var3) {
               this.e(8);
            }
         }
      }

      if (this.o.D && this.cm() == 1) {
         this.a(0.72F, 2.535F);
      }

      super.m();
   }

   public void c(int var1, zx var2) {
      super.c(var1, var2);
      if (!this.o.D && var1 == 0) {
         this.n();
      }

   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.d).a(0.25D);
   }

   public void ak() {
      super.ak();
      if (this.m instanceof py) {
         py var1 = (py)this.m;
         this.aI = var1.aI;
      }

   }

   protected void a(cj var1, afh var2) {
      this.a("mob.skeleton.step", 0.15F, 1.0F);
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("SkeletonType", (byte)this.cm());
   }

   public pu a(ok var1, pu var2) {
      var2 = super.a(var1, var2);
      if (this.o.t instanceof ann && this.bc().nextInt(5) > 0) {
         this.i.a(4, this.b);
         this.a(1);
         this.c(0, new zx(zy.q));
         this.a((qb)vy.e).a(4.0D);
      } else {
         this.i.a(4, this.a);
         this.a(var1);
         this.b(var1);
      }

      this.j(this.V.nextFloat() < 0.55F * var1.c());
      if (this.p(4) == null) {
         Calendar var3 = this.o.Y();
         if (var3.get(2) + 1 == 10 && var3.get(5) == 31 && this.V.nextFloat() < 0.25F) {
            this.c(4, new zx(this.V.nextFloat() < 0.1F ? afi.aZ : afi.aU));
            this.bj[4] = 0.0F;
         }
      }

      return var2;
   }

   public double am() {
      return this.j_() ? 0.0D : -0.35D;
   }

   public void a(int var1) {
      this.ac.b(13, (byte)var1);
      this.ab = var1 == 1;
      if (var1 == 1) {
         this.a(0.72F, 2.535F);
      } else {
         this.a(0.6F, 1.95F);
      }

   }

   protected void bq() {
      if (this.cm() == 1) {
         this.a(new zx(zy.bX, 1, 1), 0.0F);
      }

   }

   public void n() {
      this.i.a((rd)this.b);
      this.i.a((rd)this.a);
      zx var1 = this.bA();
      if (var1 != null && var1.b() == zy.f) {
         this.i.a(4, this.a);
      } else {
         this.i.a(4, this.b);
      }

   }

   protected String bp() {
      return "mob.skeleton.death";
   }

   protected void a(ok var1) {
      super.a(var1);
      this.c(0, new zx(zy.f));
   }

   public pw bz() {
      return pw.b;
   }

   public wa(adm var1) {
      super(var1);
      this.i.a(1, new ra(this));
      this.i.a(2, new sc(this));
      this.i.a(3, new qz(this, 1.0D));
      this.i.a(3, new qs(this, ua.class, 6.0F, 1.0D, 1.2D));
      this.i.a(4, new rz(this, 1.0D));
      this.i.a(6, new ri(this, wn.class, 8.0F));
      this.i.a(6, new ry(this));
      this.bi.a(1, new sm(this, false, new Class[0]));
      this.bi.a(2, new sp(this, wn.class, true));
      this.bi.a(3, new sp(this, ty.class, true));
      if (var1 != null && !var1.D) {
         this.n();
      }

   }

   public void a(pr var1, float var2) {
      wq var3 = new wq(this.o, this, var1, 1.6F, (float)(14 - this.o.aa().a() * 4));
      int var4 = ack.a(aci.v.B, this.bA());
      int var5 = ack.a(aci.w.B, this.bA());
      var3.b((double)(var2 * 2.0F) + this.V.nextGaussian() * 0.25D + (double)((float)this.o.aa().a() * 0.11F));
      if (var4 > 0) {
         var3.b(var3.j() + (double)var4 * 0.5D + 0.5D);
      }

      if (var5 > 0) {
         var3.a(var5);
      }

      if (ack.a(aci.x.B, this.bA()) > 0 || this.cm() == 1) {
         var3.e(100);
      }

      this.a("random.bow", 1.0F, 1.0F / (this.bc().nextFloat() * 0.4F + 0.8F));
      this.o.d((pk)var3);
   }

   public boolean r(pk var1) {
      if (super.r(var1)) {
         if (this.cm() == 1 && var1 instanceof pr) {
            ((pr)var1).c(new pf(pe.v.H, 200));
         }

         return true;
      } else {
         return false;
      }
   }

   protected String z() {
      return "mob.skeleton.say";
   }

   public void a(ow var1) {
      super.a(var1);
      if (var1.i() instanceof wq && var1.j() instanceof wn) {
         wn var2 = (wn)var1.j();
         double var3 = var2.s - this.s;
         double var5 = var2.u - this.u;
         if (var3 * var3 + var5 * var5 >= 2500.0D) {
            var2.b((mw)mr.v);
         }
      } else if (var1.j() instanceof vn && ((vn)var1.j()).n() && ((vn)var1.j()).cp()) {
         ((vn)var1.j()).cq();
         this.a(new zx(zy.bX, 1, this.cm() == 1 ? 1 : 0), 0.0F);
      }

   }

   public float aS() {
      return this.cm() == 1 ? super.aS() : 1.74F;
   }

   protected zw A() {
      return zy.g;
   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.b("SkeletonType", 99)) {
         byte var2 = var1.d("SkeletonType");
         this.a(var2);
      }

      this.n();
   }

   protected void b(boolean var1, int var2) {
      int var3;
      int var4;
      if (this.cm() == 1) {
         var3 = this.V.nextInt(3 + var2) - 1;

         for(var4 = 0; var4 < var3; ++var4) {
            this.a(zy.h, 1);
         }
      } else {
         var3 = this.V.nextInt(3 + var2);

         for(var4 = 0; var4 < var3; ++var4) {
            this.a(zy.g, 1);
         }
      }

      var3 = this.V.nextInt(3 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(zy.aX, 1);
      }

   }

   public int cm() {
      return this.ac.a(13);
   }
}
