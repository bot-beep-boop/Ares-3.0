import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class we extends vv {
   private boolean bo = false;
   private final qu bm = new qu(this);
   private int bn;
   protected static final qb a = (new qj((qb)null, "zombie.spawnReinforcements", 0.0D, 0.0D, 1.0D)).a("Spawn Reinforcements Chance");
   private static final UUID b = UUID.fromString("B9766B59-9566-4402-BC1F-2EE2A276D836");
   private float bq;
   private static final qd c;
   private float bp = -1.0F;

   public double am() {
      return this.j_() ? 0.0D : -0.35D;
   }

   public we(adm var1) {
      super(var1);
      ((sv)this.s()).b(true);
      this.i.a(0, new ra(this));
      this.i.a(2, new rl(this, wn.class, 1.0D, false));
      this.i.a(5, new rp(this, 1.0D));
      this.i.a(7, new rz(this, 1.0D));
      this.i.a(8, new ri(this, wn.class, 8.0F));
      this.i.a(8, new ry(this));
      this.n();
      this.a(0.6F, 1.95F);
   }

   public boolean a(ow var1, float var2) {
      if (super.a(var1, var2)) {
         pr var3 = this.u();
         if (var3 == null && var1.j() instanceof pr) {
            var3 = (pr)var1.j();
         }

         if (var3 != null && this.o.aa() == oj.d && (double)this.V.nextFloat() < this.a((qb)a).e()) {
            int var4 = ns.c(this.s);
            int var5 = ns.c(this.t);
            int var6 = ns.c(this.u);
            we var7 = new we(this.o);

            for(int var8 = 0; var8 < 50; ++var8) {
               int var9 = var4 + ns.a((Random)this.V, 7, 40) * ns.a((Random)this.V, -1, 1);
               int var10 = var5 + ns.a((Random)this.V, 7, 40) * ns.a((Random)this.V, -1, 1);
               int var11 = var6 + ns.a((Random)this.V, 7, 40) * ns.a((Random)this.V, -1, 1);
               if (adm.a((adq)this.o, (cj)(new cj(var9, var10 - 1, var11))) && this.o.l(new cj(var9, var10, var11)) < 10) {
                  var7.b((double)var9, (double)var10, (double)var11);
                  if (!this.o.b((double)var9, (double)var10, (double)var11, 7.0D) && this.o.a((aug)var7.aR(), (pk)var7) && this.o.a((pk)var7, (aug)var7.aR()).isEmpty() && !this.o.d(var7.aR())) {
                     this.o.d((pk)var7);
                     var7.d(var3);
                     var7.a((ok)this.o.E(new cj(var7)), (pu)null);
                     this.a((qb)a).b(new qd("Zombie reinforcement caller charge", -0.05000000074505806D, 0));
                     var7.a((qb)a).b(new qd("Zombie reinforcement callee charge", -0.05000000074505806D, 0));
                     break;
                  }
               }
            }
         }

         return true;
      } else {
         return false;
      }
   }

   static {
      c = new qd(b, "Baby speed boost", 0.5D, 1);
   }

   protected boolean a(zx var1) {
      return var1.b() == zy.aP && this.j_() && this.au() ? false : super.a(var1);
   }

   protected boolean C() {
      return !this.cp();
   }

   protected String bp() {
      return "mob.zombie.death";
   }

   public boolean co() {
      return this.H().a(13) == 1;
   }

   public boolean cp() {
      return this.H().a(14) == 1;
   }

   protected void a(cj var1, afh var2) {
      this.a("mob.zombie.step", 0.15F, 1.0F);
   }

   public pu a(ok var1, pu var2) {
      Object var7 = super.a(var1, var2);
      float var3 = var1.c();
      this.j(this.V.nextFloat() < 0.55F * var3);
      if (var7 == null) {
         var7 = new we.a(this, this.o.s.nextFloat() < 0.05F, this.o.s.nextFloat() < 0.05F);
      }

      if (var7 instanceof we.a) {
         we.a var4 = (we.a)var7;
         if (var4.b) {
            this.m(true);
         }

         if (var4.a) {
            this.l(true);
            if ((double)this.o.s.nextFloat() < 0.05D) {
               List var5 = this.o.a(tn.class, this.aR().b(5.0D, 3.0D, 5.0D), po.b);
               if (!var5.isEmpty()) {
                  tn var6 = (tn)var5.get(0);
                  var6.l(true);
                  this.a((pk)var6);
               }
            } else if ((double)this.o.s.nextFloat() < 0.05D) {
               tn var10 = new tn(this.o);
               var10.b(this.s, this.t, this.u, this.y, 0.0F);
               var10.a(var1, (pu)null);
               var10.l(true);
               this.o.d((pk)var10);
               this.a((pk)var10);
            }
         }
      }

      this.a(this.V.nextFloat() < var3 * 0.1F);
      this.a(var1);
      this.b((ok)var1);
      if (this.p(4) == null) {
         Calendar var8 = this.o.Y();
         if (var8.get(2) + 1 == 10 && var8.get(5) == 31 && this.V.nextFloat() < 0.25F) {
            this.c(4, new zx(this.V.nextFloat() < 0.1F ? afi.aZ : afi.aU));
            this.bj[4] = 0.0F;
         }
      }

      this.a((qb)vy.c).b(new qd("Random spawn bonus", this.V.nextDouble() * 0.05000000074505806D, 0));
      double var9 = this.V.nextDouble() * 1.5D * (double)var3;
      if (var9 > 1.0D) {
         this.a((qb)vy.b).b(new qd("Random zombie-spawn bonus", var9, 2));
      }

      if (this.V.nextFloat() < var3 * 0.05F) {
         this.a((qb)a).b(new qd("Leader zombie bonus", this.V.nextDouble() * 0.25D + 0.5D, 0));
         this.a((qb)vy.a).b(new qd("Leader zombie bonus", this.V.nextDouble() * 3.0D + 1.0D, 2));
         this.a(true);
      }

      return (pu)var7;
   }

   protected void a(ok var1) {
      super.a(var1);
      if (this.V.nextFloat() < (this.o.aa() == oj.d ? 0.05F : 0.01F)) {
         int var2 = this.V.nextInt(3);
         if (var2 == 0) {
            this.c(0, new zx(zy.l));
         } else {
            this.c(0, new zx(zy.a));
         }
      }

   }

   protected String z() {
      return "mob.zombie.say";
   }

   public void m() {
      if (this.o.w() && !this.o.D && !this.j_()) {
         float var1 = this.c(1.0F);
         cj var2 = new cj(this.s, (double)Math.round(this.t), this.u);
         if (var1 > 0.5F && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F && this.o.i(var2)) {
            boolean var3 = true;
            zx var4 = this.p(4);
            if (var4 != null) {
               if (var4.e()) {
                  var4.b(var4.h() + this.V.nextInt(2));
                  if (var4.h() >= var4.j()) {
                     this.b((zx)var4);
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

      if (this.au() && this.u() != null && this.m instanceof tn) {
         ((ps)this.m).s().a(this.s().j(), 1.5D);
      }

      super.m();
   }

   public void m(boolean var1) {
      this.H().b(13, (byte)(var1 ? 1 : 0));
   }

   protected String bo() {
      return "mob.zombie.hurt";
   }

   public void a(byte var1) {
      if (var1 == 16) {
         if (!this.R()) {
            this.o.a(this.s + 0.5D, this.t + 0.5D, this.u + 0.5D, "mob.zombie.remedy", 1.0F + this.V.nextFloat(), this.V.nextFloat() * 0.7F + 0.3F, false);
         }
      } else {
         super.a(var1);
      }

   }

   protected final void a(float var1, float var2) {
      boolean var3 = this.bp > 0.0F && this.bq > 0.0F;
      this.bp = var1;
      this.bq = var2;
      if (!var3) {
         this.a(1.0F);
      }

   }

   protected zw A() {
      return zy.bt;
   }

   public void b(dn var1) {
      super.b(var1);
      if (this.j_()) {
         var1.a("IsBaby", true);
      }

      if (this.co()) {
         var1.a("IsVillager", true);
      }

      var1.a("ConversionTime", this.cp() ? this.bn : -1);
      var1.a("CanBreakDoors", this.cn());
   }

   protected void bq() {
      switch(this.V.nextInt(3)) {
      case 0:
         this.a(zy.j, 1);
         break;
      case 1:
         this.a(zy.bR, 1);
         break;
      case 2:
         this.a(zy.bS, 1);
      }

   }

   protected int b(wn var1) {
      if (this.j_()) {
         this.b_ = (int)((float)this.b_ * 2.5F);
      }

      return super.b(var1);
   }

   protected void a(int var1) {
      this.bn = var1;
      this.H().b(14, (byte)1);
      this.m(pe.t.H);
      this.c(new pf(pe.g.H, var1, Math.min(this.o.aa().a() - 1, 0)));
      this.o.a((pk)this, (byte)16);
   }

   public void n(boolean var1) {
      this.a(var1 ? 0.5F : 1.0F);
   }

   public float aS() {
      float var1 = 1.74F;
      if (this.j_()) {
         var1 = (float)((double)var1 - 0.81D);
      }

      return var1;
   }

   public boolean j_() {
      return this.H().a(12) == 1;
   }

   public void a(ow var1) {
      super.a(var1);
      if (var1.j() instanceof vn && !(this instanceof vw) && ((vn)var1.j()).n() && ((vn)var1.j()).cp()) {
         ((vn)var1.j()).cq();
         this.a(new zx(zy.bX, 1, 2), 0.0F);
      }

   }

   public boolean r(pk var1) {
      boolean var2 = super.r(var1);
      if (var2) {
         int var3 = this.o.aa().a();
         if (this.bA() == null && this.at() && this.V.nextFloat() < (float)var3 * 0.3F) {
            var1.e(2 * var3);
         }
      }

      return var2;
   }

   protected void h() {
      super.h();
      this.H().a(12, (byte)0);
      this.H().a(13, (byte)0);
      this.H().a(14, (byte)0);
   }

   public void a(pr var1) {
      super.a(var1);
      if ((this.o.aa() == oj.c || this.o.aa() == oj.d) && var1 instanceof wi) {
         if (this.o.aa() != oj.d && this.V.nextBoolean()) {
            return;
         }

         ps var2 = (ps)var1;
         we var3 = new we(this.o);
         var3.m(var1);
         this.o.e((pk)var1);
         var3.a((ok)this.o.E(new cj(var3)), (pu)null);
         var3.m(true);
         if (var1.j_()) {
            var3.l(true);
         }

         var3.k(var2.ce());
         if (var2.l_()) {
            var3.a((String)var2.aM());
            var3.g(var2.aN());
         }

         this.o.d((pk)var3);
         this.o.a((wn)null, 1016, new cj((int)this.s, (int)this.t, (int)this.u), 0);
      }

   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.n("IsBaby")) {
         this.l(true);
      }

      if (var1.n("IsVillager")) {
         this.m(true);
      }

      if (var1.b("ConversionTime", 99) && var1.f("ConversionTime") > -1) {
         this.a(var1.f("ConversionTime"));
      }

      this.a(var1.n("CanBreakDoors"));
   }

   protected void cq() {
      wi var1 = new wi(this.o);
      var1.m(this);
      var1.a(this.o.E(new cj(var1)), (pu)null);
      var1.cp();
      if (this.j_()) {
         var1.b(-24000);
      }

      this.o.e((pk)this);
      var1.k(this.ce());
      if (this.l_()) {
         var1.a((String)this.aM());
         var1.g(this.aN());
      }

      this.o.d((pk)var1);
      var1.c(new pf(pe.k.H, 200, 0));
      this.o.a((wn)null, 1017, new cj((int)this.s, (int)this.t, (int)this.u), 0);
   }

   protected final void a(float var1) {
      super.a(this.bp * var1, this.bq * var1);
   }

   public void a(boolean var1) {
      if (this.bo != var1) {
         this.bo = var1;
         if (var1) {
            this.i.a(1, this.bm);
         } else {
            this.i.a((rd)this.bm);
         }
      }

   }

   public pw bz() {
      return pw.b;
   }

   public void l(boolean var1) {
      this.H().b(12, (byte)(var1 ? 1 : 0));
      if (this.o != null && !this.o.D) {
         qc var2 = this.a((qb)vy.d);
         var2.c(c);
         if (var1) {
            var2.b(c);
         }
      }

      this.n(var1);
   }

   public boolean a(wn var1) {
      zx var2 = var1.bZ();
      if (var2 != null && var2.b() == zy.ao && var2.i() == 0 && this.co() && this.a((pe)pe.t)) {
         if (!var1.bA.d) {
            --var2.b;
         }

         if (var2.b <= 0) {
            var1.bi.a(var1.bi.c, (zx)null);
         }

         if (!this.o.D) {
            this.a(this.V.nextInt(2401) + 3600);
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean cn() {
      return this.bo;
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.b).a(35.0D);
      this.a((qb)vy.d).a(0.23000000417232513D);
      this.a((qb)vy.e).a(3.0D);
      this.by().b(a).a(this.V.nextDouble() * 0.10000000149011612D);
   }

   public void t_() {
      if (!this.o.D && this.cp()) {
         int var1 = this.cr();
         this.bn -= var1;
         if (this.bn <= 0) {
            this.cq();
         }
      }

      super.t_();
   }

   public int br() {
      int var1 = super.br() + 2;
      if (var1 > 20) {
         var1 = 20;
      }

      return var1;
   }

   protected void n() {
      this.i.a(4, new rl(this, wi.class, 1.0D, true));
      this.i.a(4, new rl(this, ty.class, 1.0D, true));
      this.i.a(6, new rn(this, 1.0D, false));
      this.bi.a(1, new sm(this, true, new Class[]{vw.class}));
      this.bi.a(2, new sp(this, wn.class, true));
      this.bi.a(2, new sp(this, wi.class, false));
      this.bi.a(2, new sp(this, ty.class, true));
   }

   protected int cr() {
      int var1 = 1;
      if (this.V.nextFloat() < 0.01F) {
         int var2 = 0;
         cj.a var3 = new cj.a();

         for(int var4 = (int)this.s - 4; var4 < (int)this.s + 4 && var2 < 14; ++var4) {
            for(int var5 = (int)this.t - 4; var5 < (int)this.t + 4 && var2 < 14; ++var5) {
               for(int var6 = (int)this.u - 4; var6 < (int)this.u + 4 && var2 < 14; ++var6) {
                  afh var7 = this.o.p(var3.c(var4, var5, var6)).c();
                  if (var7 == afi.bi || var7 == afi.C) {
                     if (this.V.nextFloat() < 0.3F) {
                        ++var1;
                     }

                     ++var2;
                  }
               }
            }
         }
      }

      return var1;
   }

   class a implements pu {
      public boolean a;
      public boolean b;
      final we c;

      a(we var1, boolean var2, boolean var3, Object var4) {
         this(var1, var2, var3);
      }

      private a(we var1, boolean var2, boolean var3) {
         this.c = var1;
         this.a = false;
         this.b = false;
         this.a = var2;
         this.b = var3;
      }
   }
}
