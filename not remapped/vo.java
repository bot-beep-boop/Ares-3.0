import com.google.common.base.Predicate;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class vo extends vv {
   private static final Set<afh> c;
   private boolean bm;
   private static final qd b;
   private static final UUID a = UUID.fromString("020E0DFB-87AE-4653-9556-831010E291A0");

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else {
         if (var1.j() == null || !(var1.j() instanceof vp)) {
            if (!this.o.D) {
               this.a(true);
            }

            if (var1 instanceof ox && var1.j() instanceof wn) {
               if (var1.j() instanceof lf && ((lf)var1.j()).c.d()) {
                  this.a(false);
               } else {
                  this.bm = true;
               }
            }

            if (var1 instanceof oy) {
               this.bm = false;

               for(int var4 = 0; var4 < 64; ++var4) {
                  if (this.n()) {
                     return true;
                  }
               }

               return false;
            }
         }

         boolean var3 = super.a(var1, var2);
         if (var1.e() && this.V.nextInt(10) != 0) {
            this.n();
         }

         return var3;
      }
   }

   protected zw A() {
      return zy.bu;
   }

   protected String z() {
      return this.co() ? "mob.endermen.scream" : "mob.endermen.idle";
   }

   static {
      b = (new qd(a, "Attacking speed boost", 0.15000000596046448D, 0)).a(false);
      c = Sets.newIdentityHashSet();
      c.add(afi.c);
      c.add(afi.d);
      c.add(afi.m);
      c.add(afi.n);
      c.add(afi.N);
      c.add(afi.O);
      c.add(afi.P);
      c.add(afi.Q);
      c.add(afi.W);
      c.add(afi.aK);
      c.add(afi.aL);
      c.add(afi.aU);
      c.add(afi.bk);
      c.add(afi.bw);
   }

   public void a(boolean var1) {
      this.ac.b(18, (byte)(var1 ? 1 : 0));
   }

   static qd cp() {
      return b;
   }

   static boolean a(vo var0, boolean var1) {
      return var0.bm = var1;
   }

   protected boolean k(double var1, double var3, double var5) {
      double var7 = this.s;
      double var9 = this.t;
      double var11 = this.u;
      this.s = var1;
      this.t = var3;
      this.u = var5;
      boolean var13 = false;
      cj var14 = new cj(this.s, this.t, this.u);
      if (this.o.e(var14)) {
         boolean var15 = false;

         while(!var15 && var14.o() > 0) {
            cj var16 = var14.b();
            afh var17 = this.o.p(var16).c();
            if (var17.t().c()) {
               var15 = true;
            } else {
               --this.t;
               var14 = var16;
            }
         }

         if (var15) {
            super.a(this.s, this.t, this.u);
            if (this.o.a((pk)this, (aug)this.aR()).isEmpty() && !this.o.d(this.aR())) {
               var13 = true;
            }
         }
      }

      if (!var13) {
         this.b(var7, var9, var11);
         return false;
      } else {
         short var28 = 128;

         for(int var29 = 0; var29 < var28; ++var29) {
            double var30 = (double)var29 / ((double)var28 - 1.0D);
            float var19 = (this.V.nextFloat() - 0.5F) * 0.2F;
            float var20 = (this.V.nextFloat() - 0.5F) * 0.2F;
            float var21 = (this.V.nextFloat() - 0.5F) * 0.2F;
            double var22 = var7 + (this.s - var7) * var30 + (this.V.nextDouble() - 0.5D) * (double)this.J * 2.0D;
            double var24 = var9 + (this.t - var9) * var30 + this.V.nextDouble() * (double)this.K;
            double var26 = var11 + (this.u - var11) * var30 + (this.V.nextDouble() - 0.5D) * (double)this.J * 2.0D;
            this.o.a(cy.y, var22, var24, var26, (double)var19, (double)var20, (double)var21);
         }

         this.o.a(var7, var9, var11, "mob.endermen.portal", 1.0F, 1.0F);
         this.a("mob.endermen.portal", 1.0F, 1.0F);
         return true;
      }
   }

   public alz cm() {
      return afh.d(this.ac.b(16) & '\uffff');
   }

   public boolean co() {
      return this.ac.a(18) > 0;
   }

   public vo(adm var1) {
      super(var1);
      this.a(0.6F, 2.9F);
      this.S = 1.0F;
      this.i.a(0, new ra(this));
      this.i.a(2, new rl(this, 1.0D, false));
      this.i.a(7, new rz(this, 1.0D));
      this.i.a(8, new ri(this, wn.class, 8.0F));
      this.i.a(8, new ry(this));
      this.i.a(10, new vo.a(this));
      this.i.a(11, new vo.c(this));
      this.bi.a(1, new sm(this, false, new Class[0]));
      this.bi.a(2, new vo.b(this));
      this.bi.a(3, new sp(this, vp.class, 10, true, false, new Predicate<vp>(this) {
         final vo a;

         public boolean apply(Object var1) {
            return this.a((vp)var1);
         }

         public boolean a(vp var1) {
            return var1.n();
         }

         {
            this.a = var1;
         }
      }));
   }

   public void m() {
      if (this.o.D) {
         for(int var1 = 0; var1 < 2; ++var1) {
            this.o.a(cy.y, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K - 0.25D, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, (this.V.nextDouble() - 0.5D) * 2.0D, -this.V.nextDouble(), (this.V.nextDouble() - 0.5D) * 2.0D);
         }
      }

      this.aY = false;
      super.m();
   }

   protected boolean n() {
      double var1 = this.s + (this.V.nextDouble() - 0.5D) * 64.0D;
      double var3 = this.t + (double)(this.V.nextInt(64) - 32);
      double var5 = this.u + (this.V.nextDouble() - 0.5D) * 64.0D;
      return this.k(var1, var3, var5);
   }

   protected boolean b(pk var1) {
      aui var2 = new aui(this.s - var1.s, this.aR().b + (double)(this.K / 2.0F) - var1.t + (double)var1.aS(), this.u - var1.u);
      var2 = var2.a();
      double var3 = 16.0D;
      double var5 = this.s + (this.V.nextDouble() - 0.5D) * 8.0D - var2.a * var3;
      double var7 = this.t + (double)(this.V.nextInt(16) - 8) - var2.b * var3;
      double var9 = this.u + (this.V.nextDouble() - 0.5D) * 8.0D - var2.c * var3;
      return this.k(var5, var7, var9);
   }

   public float aS() {
      return 2.55F;
   }

   private boolean c(wn var1) {
      zx var2 = var1.bi.b[3];
      if (var2 != null && var2.b() == zw.a(afi.aU)) {
         return false;
      } else {
         aui var3 = var1.d(1.0F).a();
         aui var4 = new aui(this.s - var1.s, this.aR().b + (double)(this.K / 2.0F) - (var1.t + (double)var1.aS()), this.u - var1.u);
         double var5 = var4.b();
         var4 = var4.a();
         double var7 = var3.b(var4);
         return var7 > 1.0D - 0.025D / var5 ? var1.t(this) : false;
      }
   }

   protected void h() {
      super.h();
      this.ac.a(16, new Short((short)0));
      this.ac.a(17, new Byte((byte)0));
      this.ac.a(18, new Byte((byte)0));
   }

   public void b(dn var1) {
      super.b(var1);
      alz var2 = this.cm();
      var1.a("carried", (short)afh.a(var2.c()));
      var1.a("carriedData", (short)var2.c().c(var2));
   }

   static Set cq() {
      return c;
   }

   protected void b(boolean var1, int var2) {
      zw var3 = this.A();
      if (var3 != null) {
         int var4 = this.V.nextInt(2 + var2);

         for(int var5 = 0; var5 < var4; ++var5) {
            this.a(var3, 1);
         }
      }

   }

   static boolean a(vo var0, wn var1) {
      return var0.c(var1);
   }

   public void a(alz var1) {
      this.ac.b(16, (short)(afh.f(var1) & '\uffff'));
   }

   protected String bp() {
      return "mob.endermen.death";
   }

   public void a(dn var1) {
      super.a(var1);
      alz var2;
      if (var1.b("carried", 8)) {
         var2 = afh.b(var1.j("carried")).a(var1.e("carriedData") & '\uffff');
      } else {
         var2 = afh.c(var1.e("carried")).a(var1.e("carriedData") & '\uffff');
      }

      this.a(var2);
   }

   protected void E() {
      if (this.U()) {
         this.a(ow.f, 1.0F);
      }

      if (this.co() && !this.bm && this.V.nextInt(100) == 0) {
         this.a(false);
      }

      if (this.o.w()) {
         float var1 = this.c(1.0F);
         if (var1 > 0.5F && this.o.i(new cj(this)) && this.V.nextFloat() * 30.0F < (var1 - 0.4F) * 2.0F) {
            this.d((pr)null);
            this.a(false);
            this.bm = false;
            this.n();
         }
      }

      super.E();
   }

   protected String bo() {
      return "mob.endermen.hit";
   }

   protected void aX() {
      super.aX();
      this.a((qb)vy.a).a(40.0D);
      this.a((qb)vy.d).a(0.30000001192092896D);
      this.a((qb)vy.e).a(7.0D);
      this.a((qb)vy.b).a(64.0D);
   }

   static class b extends sp {
      private wn g;
      private vo j;
      private int i;
      private int h;

      public void c() {
         this.h = 5;
         this.i = 0;
      }

      public void d() {
         this.g = null;
         this.j.a(false);
         qc var1 = this.j.a((qb)vy.d);
         var1.c(vo.cp());
         super.d();
      }

      public boolean b() {
         if (this.g != null) {
            if (!vo.a(this.j, this.g)) {
               return false;
            } else {
               vo.a(this.j, true);
               this.j.a(this.g, 10.0F, 10.0F);
               return true;
            }
         } else {
            return super.b();
         }
      }

      public boolean a() {
         double var1 = this.f();
         List var3 = this.e.o.a(wn.class, this.e.aR().b(var1, 4.0D, var1), this.c);
         Collections.sort(var3, this.b);
         if (var3.isEmpty()) {
            return false;
         } else {
            this.g = (wn)var3.get(0);
            return true;
         }
      }

      public b(vo var1) {
         super(var1, wn.class, true);
         this.j = var1;
      }

      public void e() {
         if (this.g != null) {
            if (--this.h <= 0) {
               this.d = this.g;
               this.g = null;
               super.c();
               this.j.a("mob.endermen.stare", 1.0F, 1.0F);
               this.j.a(true);
               qc var1 = this.j.a((qb)vy.d);
               var1.b(vo.cp());
            }
         } else {
            if (this.d != null) {
               if (this.d instanceof wn && vo.a(this.j, (wn)this.d)) {
                  if (this.d.h(this.j) < 16.0D) {
                     this.j.n();
                  }

                  this.i = 0;
               } else if (this.d.h(this.j) > 256.0D && this.i++ >= 30 && this.j.b((pk)this.d)) {
                  this.i = 0;
               }
            }

            super.e();
         }

      }
   }

   static class a extends rd {
      private vo a;

      public void e() {
         Random var1 = this.a.bc();
         adm var2 = this.a.o;
         int var3 = ns.c(this.a.s - 1.0D + var1.nextDouble() * 2.0D);
         int var4 = ns.c(this.a.t + var1.nextDouble() * 2.0D);
         int var5 = ns.c(this.a.u - 1.0D + var1.nextDouble() * 2.0D);
         cj var6 = new cj(var3, var4, var5);
         afh var7 = var2.p(var6).c();
         afh var8 = var2.p(var6.b()).c();
         if (this.a(var2, var6, this.a.cm().c(), var7, var8)) {
            var2.a((cj)var6, (alz)this.a.cm(), 3);
            this.a.a(afi.a.Q());
         }

      }

      public a(vo var1) {
         this.a = var1;
      }

      private boolean a(adm var1, cj var2, afh var3, afh var4, afh var5) {
         if (!var3.d(var1, var2)) {
            return false;
         } else if (var4.t() != arm.a) {
            return false;
         } else if (var5.t() == arm.a) {
            return false;
         } else {
            return var5.d();
         }
      }

      public boolean a() {
         if (!this.a.o.Q().b("mobGriefing")) {
            return false;
         } else if (this.a.cm().c().t() == arm.a) {
            return false;
         } else {
            return this.a.bc().nextInt(2000) == 0;
         }
      }
   }

   static class c extends rd {
      private vo a;

      public boolean a() {
         if (!this.a.o.Q().b("mobGriefing")) {
            return false;
         } else if (this.a.cm().c().t() != arm.a) {
            return false;
         } else {
            return this.a.bc().nextInt(20) == 0;
         }
      }

      public c(vo var1) {
         this.a = var1;
      }

      public void e() {
         Random var1 = this.a.bc();
         adm var2 = this.a.o;
         int var3 = ns.c(this.a.s - 2.0D + var1.nextDouble() * 4.0D);
         int var4 = ns.c(this.a.t + var1.nextDouble() * 3.0D);
         int var5 = ns.c(this.a.u - 2.0D + var1.nextDouble() * 4.0D);
         cj var6 = new cj(var3, var4, var5);
         alz var7 = var2.p(var6);
         afh var8 = var7.c();
         if (vo.cq().contains(var8)) {
            this.a.a(var7);
            var2.a(var6, afi.a.Q());
         }

      }
   }
}
