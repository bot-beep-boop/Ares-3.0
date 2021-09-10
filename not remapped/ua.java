import com.google.common.base.Predicate;

public class ua extends qa {
   private boolean br;
   private boolean bq;
   private float bo;
   private float bs;
   private float bt;
   private float bp;

   protected void h() {
      super.h();
      this.ac.a(18, new Float(this.bn()));
      this.ac.a(19, new Byte((byte)0));
      this.ac.a(20, new Byte((byte)zd.o.a()));
   }

   public int bQ() {
      return this.cn() ? 20 : super.bQ();
   }

   public void a(dn var1) {
      super.a(var1);
      this.o(var1.n("Angry"));
      if (var1.b("CollarColor", 99)) {
         this.a(zd.a(var1.d("CollarColor")));
      }

   }

   public float cu() {
      if (this.cv()) {
         return 1.5393804F;
      } else {
         return this.cl() ? (0.55F - (20.0F - this.ac.d(18)) * 0.02F) * 3.1415927F : 0.62831855F;
      }
   }

   protected void a(cj var1, afh var2) {
      this.a("mob.wolf.step", 0.15F, 1.0F);
   }

   public boolean cv() {
      return (this.ac.a(16) & 2) != 0;
   }

   public void p(boolean var1) {
      if (var1) {
         this.ac.b(19, (byte)1);
      } else {
         this.ac.b(19, (byte)0);
      }

   }

   public ua b(ph var1) {
      ua var2 = new ua(this.o);
      String var3 = this.b();
      if (var3 != null && var3.trim().length() > 0) {
         var2.b((String)var3);
         var2.m(true);
      }

      return var2;
   }

   protected String bp() {
      return "mob.wolf.death";
   }

   public void a(byte var1) {
      if (var1 == 8) {
         this.br = true;
         this.bs = 0.0F;
         this.bt = 0.0F;
      } else {
         super.a(var1);
      }

   }

   public boolean d(zx var1) {
      if (var1 == null) {
         return false;
      } else {
         return !(var1.b() instanceof zs) ? false : ((zs)var1.b()).g();
      }
   }

   public ph a(ph var1) {
      return this.b(var1);
   }

   public boolean a(tm var1) {
      if (var1 == this) {
         return false;
      } else if (!this.cl()) {
         return false;
      } else if (!(var1 instanceof ua)) {
         return false;
      } else {
         ua var2 = (ua)var1;
         if (!var2.cl()) {
            return false;
         } else if (var2.cn()) {
            return false;
         } else {
            return this.cr() && var2.cr();
         }
      }
   }

   public boolean r(pk var1) {
      boolean var2 = var1.a(ow.a((pr)this), (float)((int)this.a((qb)vy.e).e()));
      if (var2) {
         this.a((pr)this, (pk)var1);
      }

      return var2;
   }

   public void t_() {
      super.t_();
      this.bp = this.bo;
      if (this.cx()) {
         this.bo += (1.0F - this.bo) * 0.4F;
      } else {
         this.bo += (0.0F - this.bo) * 0.4F;
      }

      if (this.U()) {
         this.bq = true;
         this.br = false;
         this.bs = 0.0F;
         this.bt = 0.0F;
      } else if ((this.bq || this.br) && this.br) {
         if (this.bs == 0.0F) {
            this.a("mob.wolf.shake", this.bB(), (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
         }

         this.bt = this.bs;
         this.bs += 0.05F;
         if (this.bt >= 2.0F) {
            this.bq = false;
            this.br = false;
            this.bt = 0.0F;
            this.bs = 0.0F;
         }

         if (this.bs > 0.4F) {
            float var1 = (float)this.aR().b;
            int var2 = (int)(ns.a((this.bs - 0.4F) * 3.1415927F) * 7.0F);

            for(int var3 = 0; var3 < var2; ++var3) {
               float var4 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J * 0.5F;
               float var5 = (this.V.nextFloat() * 2.0F - 1.0F) * this.J * 0.5F;
               this.o.a(cy.f, this.s + (double)var4, (double)(var1 + 0.8F), this.u + (double)var5, this.v, this.w, this.x);
            }
         }
      }

   }

   public void m() {
      super.m();
      if (!this.o.D && this.bq && !this.br && !this.cf() && this.C) {
         this.br = true;
         this.bs = 0.0F;
         this.bt = 0.0F;
         this.o.a((pk)this, (byte)8);
      }

      if (!this.o.D && this.u() == null && this.cv()) {
         this.o(false);
      }

   }

   protected zw A() {
      return zw.b(-1);
   }

   protected String bo() {
      return "mob.wolf.hurt";
   }

   public ua(adm var1) {
      super(var1);
      this.a(0.6F, 0.8F);
      ((sv)this.s()).a(true);
      this.i.a(1, new ra(this));
      this.i.a(2, this.bm);
      this.i.a(3, new rh(this, 0.4F));
      this.i.a(4, new rl(this, 1.0D, true));
      this.i.a(5, new rb(this, 1.0D, 10.0F, 2.0F));
      this.i.a(6, new qv(this, 1.0D));
      this.i.a(7, new rz(this, 1.0D));
      this.i.a(8, new qt(this, 8.0F));
      this.i.a(9, new ri(this, wn.class, 8.0F));
      this.i.a(9, new ry(this));
      this.bi.a(1, new sr(this));
      this.bi.a(2, new ss(this));
      this.bi.a(3, new sm(this, true, new Class[0]));
      this.bi.a(4, new sq(this, tm.class, false, new Predicate<pk>(this) {
         final ua a;

         {
            this.a = var1;
         }

         public boolean apply(Object var1) {
            return this.a((pk)var1);
         }

         public boolean a(pk var1) {
            return var1 instanceof tv || var1 instanceof tu;
         }
      }));
      this.bi.a(5, new sp(this, wa.class, false));
      this.m(false);
   }

   public float q(float var1) {
      return (this.bp + (this.bo - this.bp) * var1) * 0.15F * 3.1415927F;
   }

   public boolean cb() {
      return !this.cv() && super.cb();
   }

   public float i(float var1, float var2) {
      float var3 = (this.bt + (this.bs - this.bt) * var1 + var2) / 1.8F;
      if (var3 < 0.0F) {
         var3 = 0.0F;
      } else if (var3 > 1.0F) {
         var3 = 1.0F;
      }

      return ns.a(var3 * 3.1415927F) * ns.a(var3 * 3.1415927F * 11.0F) * 0.15F * 3.1415927F;
   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else {
         pk var3 = var1.j();
         this.bm.a(false);
         if (var3 != null && !(var3 instanceof wn) && !(var3 instanceof wq)) {
            var2 = (var2 + 1.0F) / 2.0F;
         }

         return super.a(var1, var2);
      }
   }

   public void a(zd var1) {
      this.ac.b(20, (byte)(var1.b() & 15));
   }

   public void o(boolean var1) {
      byte var2 = this.ac.a(16);
      if (var1) {
         this.ac.b(16, (byte)(var2 | 2));
      } else {
         this.ac.b(16, (byte)(var2 & -3));
      }

   }

   public void d(pr var1) {
      super.d(var1);
      if (var1 == null) {
         this.o(false);
      } else if (!this.cl()) {
         this.o(true);
      }

   }

   public boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (this.cl()) {
         if (var2 != null) {
            if (var2.b() instanceof zs) {
               zs var3 = (zs)var2.b();
               if (var3.g() && this.ac.d(18) < 20.0F) {
                  if (!var1.bA.d) {
                     --var2.b;
                  }

                  this.h((float)var3.h(var2));
                  if (var2.b <= 0) {
                     var1.bi.a(var1.bi.c, (zx)null);
                  }

                  return true;
               }
            } else if (var2.b() == zy.aW) {
               zd var4 = zd.a(var2.i());
               if (var4 != this.cw()) {
                  this.a(var4);
                  if (!var1.bA.d && --var2.b <= 0) {
                     var1.bi.a(var1.bi.c, (zx)null);
                  }

                  return true;
               }
            }
         }

         if (this.e(var1) && !this.o.D && !this.d(var2)) {
            this.bm.a(!this.cn());
            this.aY = false;
            this.h.n();
            this.d((pr)null);
         }
      } else if (var2 != null && var2.b() == zy.aX && !this.cv()) {
         if (!var1.bA.d) {
            --var2.b;
         }

         if (var2.b <= 0) {
            var1.bi.a(var1.bi.c, (zx)null);
         }

         if (!this.o.D) {
            if (this.V.nextInt(3) == 0) {
               this.m(true);
               this.h.n();
               this.d((pr)null);
               this.bm.a(true);
               this.i(20.0F);
               this.b((String)var1.aK().toString());
               this.l(true);
               this.o.a((pk)this, (byte)7);
            } else {
               this.l(false);
               this.o.a((pk)this, (byte)6);
            }
         }

         return true;
      }

      return super.a((wn)var1);
   }

   public zd cw() {
      return zd.a(this.ac.a(20) & 15);
   }

   public int bV() {
      return 8;
   }

   protected void E() {
      this.ac.b(18, this.bn());
   }

   protected String z() {
      if (this.cv()) {
         return "mob.wolf.growl";
      } else if (this.V.nextInt(3) == 0) {
         return this.cl() && this.ac.d(18) < 10.0F ? "mob.wolf.whine" : "mob.wolf.panting";
      } else {
         return "mob.wolf.bark";
      }
   }

   public boolean ct() {
      return this.bq;
   }

   public void m(boolean var1) {
      super.m(var1);
      if (var1) {
         this.a((qb)vy.a).a(20.0D);
      } else {
         this.a((qb)vy.a).a(8.0D);
      }

      this.a((qb)vy.e).a(4.0D);
   }

   public float aS() {
      return this.K * 0.8F;
   }

   public boolean a(pr var1, pr var2) {
      if (!(var1 instanceof vn) && !(var1 instanceof vr)) {
         if (var1 instanceof ua) {
            ua var3 = (ua)var1;
            if (var3.cl() && var3.co() == var2) {
               return false;
            }
         }

         if (var1 instanceof wn && var2 instanceof wn && !((wn)var2).a((wn)var1)) {
            return false;
         } else {
            return !(var1 instanceof tp) || !((tp)var1).co();
         }
      } else {
         return false;
      }
   }

   public boolean cx() {
      return this.ac.a(19) == 1;
   }

   protected boolean C() {
      return !this.cl() && this.W > 2400;
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.d).a(0.30000001192092896D);
      if (this.cl()) {
         this.a((qb)vy.a).a(20.0D);
      } else {
         this.a((qb)vy.a).a(8.0D);
      }

      this.by().b(vy.e);
      this.a((qb)vy.e).a(2.0D);
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Angry", this.cv());
      var1.a("CollarColor", (byte)this.cw().b());
   }

   protected float bB() {
      return 0.4F;
   }

   public float p(float var1) {
      return 0.75F + (this.bt + (this.bs - this.bt) * var1) / 2.0F * 0.25F;
   }
}
