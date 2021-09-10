import java.util.Random;

public class vr extends pq implements vq {
   private int a = 1;

   public void a(boolean var1) {
      this.ac.b(16, Byte.valueOf((byte)(var1 ? 1 : 0)));
   }

   public boolean n() {
      return this.ac.a(16) != 0;
   }

   public float aS() {
      return 2.6F;
   }

   protected String z() {
      return "mob.ghast.moan";
   }

   public int bV() {
      return 1;
   }

   protected String bo() {
      return "mob.ghast.scream";
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("ExplosionPower", this.a);
   }

   protected zw A() {
      return zy.H;
   }

   protected String bp() {
      return "mob.ghast.death";
   }

   protected float bB() {
      return 10.0F;
   }

   protected void h() {
      super.h();
      this.ac.a(16, (byte)0);
   }

   public boolean a(ow var1, float var2) {
      if (this.b(var1)) {
         return false;
      } else if ("fireball".equals(var1.p()) && var1.j() instanceof wn) {
         super.a(var1, 1000.0F);
         ((wn)var1.j()).b((mw)mr.z);
         return true;
      } else {
         return super.a(var1, var2);
      }
   }

   public int cf() {
      return this.a;
   }

   public void t_() {
      super.t_();
      if (!this.o.D && this.o.aa() == oj.a) {
         this.J();
      }

   }

   protected void aX() {
      super.aX();
      this.a(vy.a).a(10.0D);
      this.a(vy.b).a(100.0D);
   }

   public boolean bR() {
      return this.V.nextInt(20) == 0 && super.bR() && this.o.aa() != oj.a;
   }

   protected void b(boolean var1, int var2) {
      int var3 = this.V.nextInt(2) + this.V.nextInt(1 + var2);

      int var4;
      for(var4 = 0; var4 < var3; ++var4) {
         this.a(zy.bw, 1);
      }

      var3 = this.V.nextInt(3) + this.V.nextInt(1 + var2);

      for(var4 = 0; var4 < var3; ++var4) {
         this.a(zy.H, 1);
      }

   }

   public vr(adm var1) {
      super(var1);
      this.a(4.0F, 4.0F);
      this.ab = true;
      this.b_ = 5;
      this.f = new vr.b(this);
      this.i.a(5, new vr.d(this));
      this.i.a(7, new vr.a(this));
      this.i.a(7, new vr.c(this));
      this.bi.a(1, new so(this));
   }

   public void a(dn var1) {
      super.a(var1);
      if (var1.b("ExplosionPower", 99)) {
         this.a = var1.f("ExplosionPower");
      }

   }

   static class c extends rd {
      private vr b;
      public int a;

      public boolean a() {
         return this.b.u() != null;
      }

      public void c() {
         this.a = 0;
      }

      public c(vr var1) {
         this.b = var1;
      }

      public void e() {
         pr var1 = this.b.u();
         double var2 = 64.0D;
         if (var1.h(this.b) < var2 * var2 && this.b.t(var1)) {
            adm var4 = this.b.o;
            ++this.a;
            if (this.a == 10) {
               var4.a((wn)null, 1007, new cj(this.b), 0);
            }

            if (this.a == 20) {
               double var5 = 4.0D;
               aui var7 = this.b.d(1.0F);
               double var8 = var1.s - (this.b.s + var7.a * var5);
               double var10 = var1.aR().b + (double)(var1.K / 2.0F) - (0.5D + this.b.t + (double)(this.b.K / 2.0F));
               double var12 = var1.u - (this.b.u + var7.c * var5);
               var4.a((wn)null, 1008, new cj(this.b), 0);
               wu var14 = new wu(var4, this.b, var8, var10, var12);
               var14.e = this.b.cf();
               var14.s = this.b.s + var7.a * var5;
               var14.t = this.b.t + (double)(this.b.K / 2.0F) + 0.5D;
               var14.u = this.b.u + var7.c * var5;
               var4.d((pk)var14);
               this.a = -40;
            }
         } else if (this.a > 0) {
            --this.a;
         }

         this.b.a(this.a > 10);
      }

      public void d() {
         this.b.a(false);
      }
   }

   static class b extends qq {
      private vr g;
      private int h;

      private boolean b(double var1, double var3, double var5, double var7) {
         double var9 = (var1 - this.g.s) / var7;
         double var11 = (var3 - this.g.t) / var7;
         double var13 = (var5 - this.g.u) / var7;
         aug var15 = this.g.aR();

         for(int var16 = 1; (double)var16 < var7; ++var16) {
            var15 = var15.c(var9, var11, var13);
            if (!this.g.o.a((pk)this.g, (aug)var15).isEmpty()) {
               return false;
            }
         }

         return true;
      }

      public b(vr var1) {
         super(var1);
         this.g = var1;
      }

      public void c() {
         if (this.f) {
            double var1 = this.b - this.g.s;
            double var3 = this.c - this.g.t;
            double var5 = this.d - this.g.u;
            double var7 = var1 * var1 + var3 * var3 + var5 * var5;
            if (this.h-- <= 0) {
               this.h += this.g.bc().nextInt(5) + 2;
               var7 = (double)ns.a(var7);
               if (this.b(this.b, this.c, this.d, var7)) {
                  vr var10000 = this.g;
                  var10000.v += var1 / var7 * 0.1D;
                  var10000 = this.g;
                  var10000.w += var3 / var7 * 0.1D;
                  var10000 = this.g;
                  var10000.x += var5 / var7 * 0.1D;
               } else {
                  this.f = false;
               }
            }

         }
      }
   }

   static class a extends rd {
      private vr a;

      public void e() {
         if (this.a.u() == null) {
            this.a.aI = this.a.y = -((float)ns.b(this.a.v, this.a.x)) * 180.0F / 3.1415927F;
         } else {
            pr var1 = this.a.u();
            double var2 = 64.0D;
            if (var1.h(this.a) < var2 * var2) {
               double var4 = var1.s - this.a.s;
               double var6 = var1.u - this.a.u;
               this.a.aI = this.a.y = -((float)ns.b(var4, var6)) * 180.0F / 3.1415927F;
            }
         }

      }

      public a(vr var1) {
         this.a = var1;
         this.a(2);
      }

      public boolean a() {
         return true;
      }
   }

   static class d extends rd {
      private vr a;

      public boolean a() {
         qq var1 = this.a.q();
         if (!var1.a()) {
            return true;
         } else {
            double var2 = var1.d() - this.a.s;
            double var4 = var1.e() - this.a.t;
            double var6 = var1.f() - this.a.u;
            double var8 = var2 * var2 + var4 * var4 + var6 * var6;
            return var8 < 1.0D || var8 > 3600.0D;
         }
      }

      public boolean b() {
         return false;
      }

      public d(vr var1) {
         this.a = var1;
         this.a(1);
      }

      public void c() {
         Random var1 = this.a.bc();
         double var2 = this.a.s + (double)((var1.nextFloat() * 2.0F - 1.0F) * 16.0F);
         double var4 = this.a.t + (double)((var1.nextFloat() * 2.0F - 1.0F) * 16.0F);
         double var6 = this.a.u + (double)((var1.nextFloat() * 2.0F - 1.0F) * 16.0F);
         this.a.q().a(var2, var4, var6, 1.0D);
      }
   }
}
