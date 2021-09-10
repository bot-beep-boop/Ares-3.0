import java.util.Random;

public class wc extends vv {
   public double an() {
      return (double)(this.K * 0.5F);
   }

   protected zw A() {
      return zy.F;
   }

   public pu a(ok var1, pu var2) {
      Object var4 = super.a(var1, var2);
      if (this.o.s.nextInt(100) == 0) {
         wa var3 = new wa(this.o);
         var3.b(this.s, this.t, this.u, this.y, 0.0F);
         var3.a((ok)var1, (pu)null);
         this.o.d((pk)var3);
         var3.a((pk)this);
      }

      if (var4 == null) {
         var4 = new wc.b();
         if (this.o.aa() == oj.d && this.o.s.nextFloat() < 0.1F * var1.c()) {
            ((wc.b)var4).a(this.o.s);
         }
      }

      if (var4 instanceof wc.b) {
         int var5 = ((wc.b)var4).a;
         if (var5 > 0 && pe.a[var5] != null) {
            this.c(new pf(var5, Integer.MAX_VALUE));
         }
      }

      return (pu)var4;
   }

   protected String bp() {
      return "mob.spider.death";
   }

   protected void h() {
      super.h();
      this.ac.a(16, new Byte((byte)0));
   }

   public void t_() {
      super.t_();
      if (!this.o.D) {
         this.a(this.D);
      }

   }

   public float aS() {
      return 0.65F;
   }

   public wc(adm var1) {
      super(var1);
      this.a(1.4F, 0.9F);
      this.i.a(1, new ra(this));
      this.i.a(3, new rh(this, 0.4F));
      this.i.a(4, new wc.a(this, wn.class));
      this.i.a(4, new wc.a(this, ty.class));
      this.i.a(5, new rz(this, 0.8D));
      this.i.a(6, new ri(this, wn.class, 8.0F));
      this.i.a(6, new ry(this));
      this.bi.a(1, new sm(this, false, new Class[0]));
      this.bi.a(2, new wc.c(this, wn.class));
      this.bi.a(3, new wc.c(this, ty.class));
   }

   public boolean d(pf var1) {
      return var1.a() == pe.u.H ? false : super.d(var1);
   }

   protected void aX() {
      super.aX();
      this.a(vy.a).a(16.0D);
      this.a(vy.d).a(0.30000001192092896D);
   }

   protected String z() {
      return "mob.spider.say";
   }

   protected void b(boolean var1, int var2) {
      super.b(var1, var2);
      if (var1 && (this.V.nextInt(3) == 0 || this.V.nextInt(1 + var2) > 0)) {
         this.a(zy.bB, 1);
      }

   }

   protected String bo() {
      return "mob.spider.say";
   }

   public boolean n() {
      return (this.ac.a(16) & 1) != 0;
   }

   public boolean k_() {
      return this.n();
   }

   public pw bz() {
      return pw.c;
   }

   public void a(boolean var1) {
      byte var2 = this.ac.a(16);
      if (var1) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.ac.b(16, var2);
   }

   protected sw b(adm var1) {
      return new sx(this, var1);
   }

   public void aA() {
   }

   protected void a(cj var1, afh var2) {
      this.a("mob.spider.step", 0.15F, 1.0F);
   }

   public static class b implements pu {
      public int a;

      public void a(Random var1) {
         int var2 = var1.nextInt(5);
         if (var2 <= 1) {
            this.a = pe.c.H;
         } else if (var2 <= 2) {
            this.a = pe.g.H;
         } else if (var2 <= 3) {
            this.a = pe.l.H;
         } else if (var2 <= 4) {
            this.a = pe.p.H;
         }

      }
   }

   static class c<T extends pr> extends sp {
      public boolean a() {
         float var1 = this.e.c(1.0F);
         return var1 >= 0.5F ? false : super.a();
      }

      public c(wc var1, Class<T> var2) {
         super(var1, var2, true);
      }
   }

   static class a extends rl {
      public a(wc var1, Class<? extends pk> var2) {
         super(var1, var2, 1.0D, true);
      }

      public boolean b() {
         float var1 = this.b.c(1.0F);
         if (var1 >= 0.5F && this.b.bc().nextInt(100) == 0) {
            this.b.d((pr)null);
            return false;
         } else {
            return super.b();
         }
      }

      protected double a(pr var1) {
         return (double)(4.0F + var1.J);
      }
   }
}
