import com.google.common.base.Predicate;

public class ts extends qa {
   private sh bp;
   private qs<wn> bo;

   public void r(int var1) {
      this.ac.b(18, (byte)var1);
   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else {
         this.bm.a(false);
         return super.a(var1, var2);
      }
   }

   public boolean d(zx var1) {
      return var1 != null && var1.b() == zy.aU;
   }

   protected String z() {
      if (this.cl()) {
         if (this.cr()) {
            return "mob.cat.purr";
         } else {
            return this.V.nextInt(4) == 0 ? "mob.cat.purreow" : "mob.cat.meow";
         }
      } else {
         return "";
      }
   }

   protected boolean C() {
      return !this.cl() && this.W > 2400;
   }

   public boolean a(tm var1) {
      if (var1 == this) {
         return false;
      } else if (!this.cl()) {
         return false;
      } else if (!(var1 instanceof ts)) {
         return false;
      } else {
         ts var2 = (ts)var1;
         if (!var2.cl()) {
            return false;
         } else {
            return this.cr() && var2.cr();
         }
      }
   }

   public void E() {
      if (this.q().a()) {
         double var1 = this.q().b();
         if (var1 == 0.6D) {
            this.c(true);
            this.d(false);
         } else if (var1 == 1.33D) {
            this.c(false);
            this.d(true);
         } else {
            this.c(false);
            this.d(false);
         }
      } else {
         this.c(false);
         this.d(false);
      }

   }

   public int ct() {
      return this.ac.a(18);
   }

   public boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (this.cl()) {
         if (this.e(var1) && !this.o.D && !this.d(var2)) {
            this.bm.a(!this.cn());
         }
      } else if (this.bp.f() && var2 != null && var2.b() == zy.aU && var1.h(this) < 9.0D) {
         if (!var1.bA.d) {
            --var2.b;
         }

         if (var2.b <= 0) {
            var1.bi.a(var1.bi.c, (zx)null);
         }

         if (!this.o.D) {
            if (this.V.nextInt(3) == 0) {
               this.m(true);
               this.r(1 + this.o.s.nextInt(3));
               this.b((String)var1.aK().toString());
               this.l(true);
               this.bm.a(true);
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

   public ts b(ph var1) {
      ts var2 = new ts(this.o);
      if (this.cl()) {
         var2.b((String)this.b());
         var2.m(true);
         var2.r(this.ct());
      }

      return var2;
   }

   public void a(dn var1) {
      super.a(var1);
      this.r(var1.f("CatType"));
   }

   protected String bp() {
      return "mob.cat.hitt";
   }

   public boolean bS() {
      if (this.o.a((aug)this.aR(), (pk)this) && this.o.a((pk)this, (aug)this.aR()).isEmpty() && !this.o.d(this.aR())) {
         cj var1 = new cj(this.s, this.aR().b, this.u);
         if (var1.o() < this.o.F()) {
            return false;
         }

         afh var2 = this.o.p(var1.b()).c();
         if (var2 == afi.c || var2.t() == arm.j) {
            return true;
         }
      }

      return false;
   }

   public boolean r(pk var1) {
      return var1.a(ow.a((pr)this), 3.0F);
   }

   protected void cm() {
      if (this.bo == null) {
         this.bo = new qs(this, wn.class, 16.0F, 0.8D, 1.33D);
      }

      this.i.a((rd)this.bo);
      if (!this.cl()) {
         this.i.a(4, this.bo);
      }

   }

   protected void h() {
      super.h();
      this.ac.a(18, (byte)0);
   }

   protected String bo() {
      return "mob.cat.hitt";
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(10.0D);
      this.a((qb)vy.d).a(0.30000001192092896D);
   }

   protected float bB() {
      return 0.4F;
   }

   public pu a(ok var1, pu var2) {
      var2 = super.a(var1, var2);
      if (this.o.s.nextInt(7) == 0) {
         for(int var3 = 0; var3 < 2; ++var3) {
            ts var4 = new ts(this.o);
            var4.b(this.s, this.t, this.u, this.y, 0.0F);
            var4.b(-24000);
            this.o.d((pk)var4);
         }
      }

      return var2;
   }

   public ts(adm var1) {
      super(var1);
      this.a(0.6F, 0.7F);
      ((sv)this.s()).a(true);
      this.i.a(1, new ra(this));
      this.i.a(2, this.bm);
      this.i.a(3, this.bp = new sh(this, 0.6D, zy.aU, true));
      this.i.a(5, new rb(this, 1.0D, 10.0F, 5.0F));
      this.i.a(6, new rs(this, 0.8D));
      this.i.a(7, new rh(this, 0.3F));
      this.i.a(8, new rr(this));
      this.i.a(9, new qv(this, 0.8D));
      this.i.a(10, new rz(this, 0.8D));
      this.i.a(11, new ri(this, wn.class, 10.0F));
      this.bi.a(1, new sq(this, tn.class, false, (Predicate)null));
   }

   public boolean bR() {
      return this.o.s.nextInt(3) != 0;
   }

   protected zw A() {
      return zy.aF;
   }

   public ph a(ph var1) {
      return this.b(var1);
   }

   public void m(boolean var1) {
      super.m(var1);
   }

   public String e_() {
      if (this.l_()) {
         return this.aM();
      } else {
         return this.cl() ? di.a("entity.Cat.name") : super.e_();
      }
   }

   protected void b(boolean var1, int var2) {
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("CatType", this.ct());
   }

   public void e(float var1, float var2) {
   }
}
