public class tu extends tm {
   private int bu;
   private int bo = 0;
   private tu.b bt;
   private tu.c<ua> bm;
   private wn bv;
   private int bp = 0;
   private boolean br = false;
   private int bs = 0;
   private boolean bq = false;

   public void a(boolean var1, tu.b var2) {
      super.i(var1);
      if (!var1) {
         if (this.bt == tu.b.e) {
            this.bt = tu.b.b;
         }
      } else {
         this.b(1.5D * (double)var2.a());
         this.a(this.cm(), this.bB(), ((this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F) * 0.8F);
      }

      this.bq = var1;
   }

   public boolean a(ow var1, float var2) {
      return this.b((ow)var1) ? false : super.a(var1, var2);
   }

   private void a(double var1, double var3) {
      this.y = (float)(ns.b(var3 - this.u, var1 - this.s) * 180.0D / 3.1415927410125732D) - 90.0F;
   }

   private boolean cx() {
      return this.bu == 0;
   }

   public ph a(ph var1) {
      return this.b(var1);
   }

   protected void bq() {
      this.a(new zx(zy.br, 1), 0.0F);
   }

   protected void h() {
      super.h();
      this.ac.a(18, (byte)0);
   }

   public void Y() {
   }

   private void ct() {
      ((tu.e)this.g).a(true);
   }

   private void cw() {
      this.cv();
      this.cu();
   }

   public tu b(ph var1) {
      tu var2 = new tu(this.o);
      if (var1 instanceof tu) {
         var2.r(this.V.nextBoolean() ? this.cn() : ((tu)var1).cn());
      }

      return var2;
   }

   public pu a(ok var1, pu var2) {
      Object var5 = super.a(var1, var2);
      int var3 = this.V.nextInt(6);
      boolean var4 = false;
      if (var5 instanceof tu.d) {
         var3 = ((tu.d)var5).a;
         var4 = true;
      } else {
         var5 = new tu.d(var3);
      }

      this.r(var3);
      if (var4) {
         this.b(-24000);
      }

      return (pu)var5;
   }

   public boolean cl() {
      return this.bq;
   }

   private void cv() {
      this.bs = this.co();
   }

   public float p(float var1) {
      return this.bp == 0 ? 0.0F : ((float)this.bo + var1) / (float)this.bp;
   }

   public int cn() {
      return this.ac.a(18);
   }

   protected float bE() {
      return this.f.a() && this.f.e() > this.t + 0.5D ? 0.5F : this.bt.b();
   }

   public void a(byte var1) {
      if (var1 == 1) {
         this.Z();
         this.bp = 10;
         this.bo = 0;
      } else {
         super.a(var1);
      }

   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("RabbitType", this.cn());
      var1.a("MoreCarrotTicks", this.bu);
   }

   protected String bp() {
      return "mob.rabbit.death";
   }

   static boolean a(tu var0) {
      return var0.cx();
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(10.0D);
      this.a((qb)vy.d).a(0.30000001192092896D);
   }

   public tu(adm var1) {
      super(var1);
      this.bt = tu.b.b;
      this.bu = 0;
      this.bv = null;
      this.a(0.6F, 0.7F);
      this.g = new tu.e(this, this);
      this.f = new tu.f(this);
      ((sv)this.s()).a(true);
      this.h.a(2.5F);
      this.i.a(1, new ra(this));
      this.i.a(1, new tu.g(this, 1.33D));
      this.i.a(2, new sh(this, 1.0D, zy.bR, false));
      this.i.a(2, new sh(this, 1.0D, zy.bW, false));
      this.i.a(2, new sh(this, 1.0D, zw.a((afh)afi.N), false));
      this.i.a(3, new qv(this, 0.8D));
      this.i.a(5, new tu.h(this));
      this.i.a(5, new rz(this, 0.6D));
      this.i.a(11, new ri(this, wn.class, 10.0F));
      this.bm = new tu.c(this, ua.class, 16.0F, 1.33D, 1.33D);
      this.i.a(4, this.bm);
      this.b(0.0D);
   }

   public boolean r(pk var1) {
      if (this.cn() == 99) {
         this.a("mob.attack", 1.0F, (this.V.nextFloat() - this.V.nextFloat()) * 0.2F + 1.0F);
         return var1.a(ow.a((pr)this), 8.0F);
      } else {
         return var1.a(ow.a((pr)this), 3.0F);
      }
   }

   public void b(double var1) {
      this.s().a(var1);
      this.f.a(this.f.d(), this.f.e(), this.f.f(), var1);
   }

   public void E() {
      if (this.f.b() > 0.8D) {
         this.a(tu.b.d);
      } else if (this.bt != tu.b.e) {
         this.a(tu.b.b);
      }

      if (this.bs > 0) {
         --this.bs;
      }

      if (this.bu > 0) {
         this.bu -= this.V.nextInt(3);
         if (this.bu < 0) {
            this.bu = 0;
         }
      }

      if (this.C) {
         if (!this.br) {
            this.a(false, tu.b.a);
            this.cw();
         }

         if (this.cn() == 99 && this.bs == 0) {
            pr var1 = this.u();
            if (var1 != null && this.h(var1) < 16.0D) {
               this.a(var1.s, var1.u);
               this.f.a(var1.s, var1.t, var1.u, this.f.b());
               this.b(tu.b.e);
               this.br = true;
            }
         }

         tu.e var4 = (tu.e)this.g;
         if (!var4.c()) {
            if (this.f.a() && this.bs == 0) {
               asx var2 = this.h.j();
               aui var3 = new aui(this.f.d(), this.f.e(), this.f.f());
               if (var2 != null && var2.e() < var2.d()) {
                  var3 = var2.a((pk)this);
               }

               this.a(var3.a, var3.c);
               this.b(this.bt);
            }
         } else if (!var4.d()) {
            this.ct();
         }
      }

      this.br = this.C;
   }

   private void cu() {
      ((tu.e)this.g).a(false);
   }

   protected String bo() {
      return "mob.rabbit.hurt";
   }

   public int br() {
      return this.cn() == 99 ? 8 : super.br();
   }

   public void a(tu.b var1) {
      this.bt = var1;
   }

   protected void cp() {
      this.o.a(cy.M, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, 0.0D, 0.0D, 0.0D, afh.f(afi.cb.a(7)));
      this.bu = 100;
   }

   public void r(int var1) {
      if (var1 == 99) {
         this.i.a((rd)this.bm);
         this.i.a(4, new tu.a(this));
         this.bi.a(1, new sm(this, false, new Class[0]));
         this.bi.a(2, new sp(this, wn.class, true));
         this.bi.a(2, new sp(this, ua.class, true));
         if (!this.l_()) {
            this.a((String)di.a("entity.KillerBunny.name"));
         }
      }

      this.ac.b(18, (byte)var1);
   }

   public void a(dn var1) {
      super.a(var1);
      this.r(var1.f("RabbitType"));
      this.bu = var1.f("MoreCarrotTicks");
   }

   public void b(tu.b var1) {
      this.a(true, var1);
      this.bp = var1.d();
      this.bo = 0;
   }

   protected int co() {
      return this.bt.c();
   }

   protected String z() {
      return "mob.rabbit.idle";
   }

   protected String cm() {
      return "mob.rabbit.hop";
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(2) + this.V.nextInt(1 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(zy.bs, 1);
      }

      var3 = this.V.nextInt(2);

      for(var4 = 0; var4 < var3; ++var4) {
         if (this.at()) {
            this.a(zy.bp, 1);
         } else {
            this.a(zy.bo, 1);
         }
      }

   }

   public void m() {
      super.m();
      if (this.bo != this.bp) {
         if (this.bo == 0 && !this.o.D) {
            this.o.a((pk)this, (byte)1);
         }

         ++this.bo;
      } else if (this.bp != 0) {
         this.bo = 0;
         this.bp = 0;
      }

   }

   public boolean d(zx var1) {
      return var1 != null && this.a(var1.b());
   }

   private boolean a(zw var1) {
      return var1 == zy.bR || var1 == zy.bW || var1 == zw.a((afh)afi.N);
   }

   public class e extends qo {
      private tu c;
      private boolean d;
      final tu b;

      public void b() {
         if (this.a) {
            this.c.b(tu.b.c);
            this.a = false;
         }

      }

      public boolean c() {
         return this.a;
      }

      public boolean d() {
         return this.d;
      }

      public void a(boolean var1) {
         this.d = var1;
      }

      public e(tu var1, tu var2) {
         super(var2);
         this.b = var1;
         this.d = false;
         this.c = var2;
      }
   }

   static class h extends ro {
      private final tu c;
      private boolean d;
      private boolean e = false;

      public h(tu var1) {
         super(var1, 0.699999988079071D, 16);
         this.c = var1;
      }

      protected boolean a(adm var1, cj var2) {
         afh var3 = var1.p(var2).c();
         if (var3 == afi.ak) {
            var2 = var2.a();
            alz var4 = var1.p(var2);
            var3 = var4.c();
            if (var3 instanceof afq && (Integer)var4.b(afq.a) == 7 && this.d && !this.e) {
               this.e = true;
               return true;
            }
         }

         return false;
      }

      public void e() {
         super.e();
         this.c.p().a((double)this.b.n() + 0.5D, (double)(this.b.o() + 1), (double)this.b.p() + 0.5D, 10.0F, (float)this.c.bQ());
         if (this.f()) {
            adm var1 = this.c.o;
            cj var2 = this.b.a();
            alz var3 = var1.p(var2);
            afh var4 = var3.c();
            if (this.e && var4 instanceof afq && (Integer)var3.b(afq.a) == 7) {
               var1.a((cj)var2, (alz)afi.a.Q(), 2);
               var1.b(var2, true);
               this.c.cp();
            }

            this.e = false;
            this.a = 10;
         }

      }

      public boolean b() {
         return this.e && super.b();
      }

      public void c() {
         super.c();
      }

      public boolean a() {
         if (this.a <= 0) {
            if (!this.c.o.Q().b("mobGriefing")) {
               return false;
            }

            this.e = false;
            this.d = tu.a(this.c);
         }

         return super.a();
      }

      public void d() {
         super.d();
      }
   }

   static enum b {
      a(0.0F, 0.0F, 30, 1),
      d(1.75F, 0.4F, 1, 8);

      private final float g;
      b(0.8F, 0.2F, 20, 10);

      private final int h;
      private static final tu.b[] j = new tu.b[]{a, b, c, d, e};
      e(2.0F, 0.7F, 7, 8);

      private final int i;
      c(1.0F, 0.45F, 14, 14);

      private final float f;

      public float b() {
         return this.g;
      }

      private b(float var3, float var4, int var5, int var6) {
         this.f = var3;
         this.g = var4;
         this.h = var5;
         this.i = var6;
      }

      public int d() {
         return this.i;
      }

      public float a() {
         return this.f;
      }

      public int c() {
         return this.h;
      }
   }

   static class c<T extends pk> extends qs<T> {
      private tu c;

      public void e() {
         super.e();
      }

      public c(tu var1, Class<T> var2, float var3, double var4, double var6) {
         super(var1, var2, var3, var4, var6);
         this.c = var1;
      }
   }

   public static class d implements pu {
      public int a;

      public d(int var1) {
         this.a = var1;
      }
   }

   static class g extends rv {
      private tu b;

      public g(tu var1, double var2) {
         super(var1, var2);
         this.b = var1;
      }

      public void e() {
         super.e();
         this.b.b(this.a);
      }
   }

   static class a extends rl {
      protected double a(pr var1) {
         return (double)(4.0F + var1.J);
      }

      public a(tu var1) {
         super(var1, pr.class, 1.4D, true);
      }
   }

   static class f extends qq {
      private tu g;

      public void c() {
         if (this.g.C && !this.g.cl()) {
            this.g.b(0.0D);
         }

         super.c();
      }

      public f(tu var1) {
         super(var1);
         this.g = var1;
      }
   }
}
