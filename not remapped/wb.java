public class wb extends ps implements vq {
   public float a;
   private boolean bk;
   public float c;
   public float b;

   public void i(int var1) {
      if (var1 == 16) {
         int var2 = this.cm();
         this.a(0.51000005F * (float)var2, 0.51000005F * (float)var2);
         this.y = this.aK;
         this.aI = this.aK;
         if (this.V() && this.V.nextInt(20) == 0) {
            this.X();
         }
      }

      super.i(var1);
   }

   public boolean bR() {
      cj var1 = new cj(ns.c(this.s), 0, ns.c(this.u));
      amy var2 = this.o.f(var1);
      if (this.o.P().u() == adr.c && this.V.nextInt(4) != 1) {
         return false;
      } else {
         if (this.o.aa() != oj.a) {
            ady var3 = this.o.b(var1);
            if (var3 == ady.v && this.t > 50.0D && this.t < 70.0D && this.V.nextFloat() < 0.5F && this.V.nextFloat() < this.o.y() && this.o.l(new cj(this)) <= this.V.nextInt(8)) {
               return super.bR();
            }

            if (this.V.nextInt(10) == 0 && var2.a(987234911L).nextInt(10) == 0 && this.t < 40.0D) {
               return super.bR();
            }
         }

         return false;
      }
   }

   protected wb cf() {
      return new wb(this.o);
   }

   protected void e(pr var1) {
      int var2 = this.cm();
      if (this.t(var1) && this.h(var1) < 0.6D * (double)var2 * 0.6D * (double)var2 && var1.a(ow.a((pr)this), (float)this.cj())) {
         this.a("mob.attack", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
         this.a(this, var1);
      }

   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("Size", this.cm() - 1);
      var1.a("wasOnGround", this.bk);
   }

   protected String ck() {
      return "mob.slime." + (this.cm() > 1 ? "big" : "small");
   }

   protected void ch() {
      this.a *= 0.6F;
   }

   protected cy n() {
      return cy.H;
   }

   public void J() {
      int var1 = this.cm();
      if (!this.o.D && var1 > 1 && this.bn() <= 0.0F) {
         int var2 = 2 + this.V.nextInt(3);

         for(int var3 = 0; var3 < var2; ++var3) {
            float var4 = ((float)(var3 % 2) - 0.5F) * (float)var1 / 4.0F;
            float var5 = ((float)(var3 / 2) - 0.5F) * (float)var1 / 4.0F;
            wb var6 = this.cf();
            if (this.l_()) {
               var6.a(this.aM());
            }

            if (this.bZ()) {
               var6.bX();
            }

            var6.a(var1 / 2);
            var6.b(this.s + (double)var4, this.t + 0.5D, this.u + (double)var5, this.V.nextFloat() * 360.0F, 0.0F);
            this.o.d((pk)var6);
         }
      }

      super.J();
   }

   protected void h() {
      super.h();
      this.ac.a(16, (byte)1);
   }

   public int cm() {
      return this.ac.a(16);
   }

   public void i(pk var1) {
      super.i(var1);
      if (var1 instanceof ty && this.ci()) {
         this.e((pr)var1);
      }

   }

   protected String bo() {
      return "mob.slime." + (this.cm() > 1 ? "big" : "small");
   }

   protected boolean ci() {
      return this.cm() > 1;
   }

   public float aS() {
      return 0.625F * this.K;
   }

   protected int cg() {
      return this.V.nextInt(20) + 10;
   }

   public void t_() {
      if (!this.o.D && this.o.aa() == oj.a && this.cm() > 0) {
         this.I = true;
      }

      this.b += (this.a - this.b) * 0.5F;
      this.c = this.b;
      super.t_();
      if (this.C && !this.bk) {
         int var1 = this.cm();

         for(int var2 = 0; var2 < var1 * 8; ++var2) {
            float var3 = this.V.nextFloat() * 3.1415927F * 2.0F;
            float var4 = this.V.nextFloat() * 0.5F + 0.5F;
            float var5 = ns.a(var3) * (float)var1 * 0.5F * var4;
            float var6 = ns.b(var3) * (float)var1 * 0.5F * var4;
            adm var10000 = this.o;
            cy var10001 = this.n();
            double var10002 = this.s + (double)var5;
            double var10004 = this.u + (double)var6;
            var10000.a(var10001, var10002, this.aR().b, var10004, 0.0D, 0.0D, 0.0D);
         }

         if (this.cl()) {
            this.a(this.ck(), this.bB(), ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F) / 0.8F);
         }

         this.a = -0.5F;
      } else if (!this.C && this.bk) {
         this.a = 1.0F;
      }

      this.bk = this.C;
      this.ch();
   }

   protected boolean cn() {
      return this.cm() > 0;
   }

   public pu a(ok var1, pu var2) {
      int var3 = this.V.nextInt(3);
      if (var3 < 2 && this.V.nextFloat() < 0.5F * var1.c()) {
         ++var3;
      }

      int var4 = 1 << var3;
      this.a(var4);
      return super.a(var1, var2);
   }

   public wb(adm var1) {
      super(var1);
      this.f = new wb.d(this);
      this.i.a(1, new wb.b(this));
      this.i.a(2, new wb.a(this));
      this.i.a(3, new wb.e(this));
      this.i.a(5, new wb.c(this));
      this.bi.a(1, new so(this));
      this.bi.a(3, new sn(this, ty.class));
   }

   protected boolean cl() {
      return this.cm() > 2;
   }

   public void d(wn var1) {
      if (this.ci()) {
         this.e(var1);
      }

   }

   protected void a(int var1) {
      this.ac.b(16, (byte)var1);
      this.a(0.51000005F * (float)var1, 0.51000005F * (float)var1);
      this.b(this.s, this.t, this.u);
      this.a(vy.a).a((double)(var1 * var1));
      this.a(vy.d).a((double)(0.2F + 0.1F * (float)var1));
      this.i(this.bu());
      this.b_ = var1;
   }

   protected zw A() {
      return this.cm() == 1 ? zy.aM : null;
   }

   protected String bp() {
      return "mob.slime." + (this.cm() > 1 ? "big" : "small");
   }

   protected void bF() {
      this.w = 0.41999998688697815D;
      this.ai = true;
   }

   protected float bB() {
      return 0.4F * (float)this.cm();
   }

   protected int cj() {
      return this.cm();
   }

   public int bQ() {
      return 0;
   }

   public void a(dn var1) {
      super.a(var1);
      int var2 = var1.f("Size");
      if (var2 < 0) {
         var2 = 0;
      }

      this.a(var2 + 1);
      this.bk = var1.n("wasOnGround");
   }

   static class a extends rd {
      private int b;
      private wb a;

      public boolean a() {
         pr var1 = this.a.u();
         if (var1 == null) {
            return false;
         } else if (!var1.ai()) {
            return false;
         } else {
            return !(var1 instanceof wn) || !((wn)var1).bA.a;
         }
      }

      public a(wb var1) {
         this.a = var1;
         this.a(2);
      }

      public void e() {
         this.a.a(this.a.u(), 10.0F, 10.0F);
         ((wb.d)this.a.q()).a(this.a.y, this.a.ci());
      }

      public void c() {
         this.b = 300;
         super.c();
      }

      public boolean b() {
         pr var1 = this.a.u();
         if (var1 == null) {
            return false;
         } else if (!var1.ai()) {
            return false;
         } else if (var1 instanceof wn && ((wn)var1).bA.a) {
            return false;
         } else {
            return --this.b > 0;
         }
      }
   }

   static class e extends rd {
      private wb a;
      private float b;
      private int c;

      public boolean a() {
         return this.a.u() == null && (this.a.C || this.a.V() || this.a.ab());
      }

      public void e() {
         if (--this.c <= 0) {
            this.c = 40 + this.a.bc().nextInt(60);
            this.b = (float)this.a.bc().nextInt(360);
         }

         ((wb.d)this.a.q()).a(this.b, false);
      }

      public e(wb var1) {
         this.a = var1;
         this.a(2);
      }
   }

   static class c extends rd {
      private wb a;

      public boolean a() {
         return true;
      }

      public void e() {
         ((wb.d)this.a.q()).a(1.0D);
      }

      public c(wb var1) {
         this.a = var1;
         this.a(5);
      }
   }

   static class b extends rd {
      private wb a;

      public void e() {
         if (this.a.bc().nextFloat() < 0.8F) {
            this.a.r().a();
         }

         ((wb.d)this.a.q()).a(1.2D);
      }

      public b(wb var1) {
         this.a = var1;
         this.a(5);
         ((sv)var1.s()).d(true);
      }

      public boolean a() {
         return this.a.V() || this.a.ab();
      }
   }

   static class d extends qq {
      private wb i;
      private int h;
      private boolean j;
      private float g;

      public void a(double var1) {
         this.e = var1;
         this.f = true;
      }

      public d(wb var1) {
         super(var1);
         this.i = var1;
      }

      public void c() {
         this.a.y = this.a(this.a.y, this.g, 30.0F);
         this.a.aK = this.a.y;
         this.a.aI = this.a.y;
         if (!this.f) {
            this.a.n(0.0F);
         } else {
            this.f = false;
            if (this.a.C) {
               this.a.k((float)(this.e * this.a.a((qb)vy.d).e()));
               if (this.h-- <= 0) {
                  this.h = this.i.cg();
                  if (this.j) {
                     this.h /= 3;
                  }

                  this.i.r().a();
                  if (this.i.cn()) {
                     this.i.a(this.i.ck(), this.i.bB(), ((this.i.bc().nextFloat() - this.i.bc().nextFloat()) * 0.2F + 1.0F) * 0.8F);
                  }
               } else {
                  this.i.aZ = this.i.ba = 0.0F;
                  this.a.k(0.0F);
               }
            } else {
               this.a.k((float)(this.e * this.a.a((qb)vy.d).e()));
            }

         }
      }

      public void a(float var1, boolean var2) {
         this.g = var1;
         this.j = var2;
      }
   }
}
