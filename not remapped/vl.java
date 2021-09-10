public class vl extends vv {
   private float a = 0.5F;
   private int b;

   public void m() {
      if (!this.C && this.w < 0.0D) {
         this.w *= 0.6D;
      }

      if (this.o.D) {
         if (this.V.nextInt(24) == 0 && !this.R()) {
            this.o.a(this.s + 0.5D, this.t + 0.5D, this.u + 0.5D, "fire.fire", 1.0F + this.V.nextFloat(), this.V.nextFloat() * 0.7F + 0.3F, false);
         }

         for(int var1 = 0; var1 < 2; ++var1) {
            this.o.a(cy.m, this.s + (this.V.nextDouble() - 0.5D) * (double)this.J, this.t + this.V.nextDouble() * (double)this.K, this.u + (this.V.nextDouble() - 0.5D) * (double)this.J, 0.0D, 0.0D, 0.0D);
         }
      }

      super.m();
   }

   protected void E() {
      if (this.U()) {
         this.a(ow.f, 1.0F);
      }

      --this.b;
      if (this.b <= 0) {
         this.b = 100;
         this.a = 0.5F + (float)this.V.nextGaussian() * 3.0F;
      }

      pr var1 = this.u();
      if (var1 != null && var1.t + (double)var1.aS() > this.t + (double)this.aS() + (double)this.a) {
         this.w += (0.30000001192092896D - this.w) * 0.30000001192092896D;
         this.ai = true;
      }

      super.E();
   }

   public int b(float var1) {
      return 15728880;
   }

   public void e(float var1, float var2) {
   }

   protected zw A() {
      return zy.bv;
   }

   protected boolean n_() {
      return true;
   }

   protected void aX() {
      super.aX();
      this.a(vy.e).a(6.0D);
      this.a(vy.d).a(0.23000000417232513D);
      this.a(vy.b).a(48.0D);
   }

   public boolean n() {
      return (this.ac.a(16) & 1) != 0;
   }

   public vl(adm var1) {
      super(var1);
      this.ab = true;
      this.b_ = 10;
      this.i.a(4, new vl.a(this));
      this.i.a(5, new rp(this, 1.0D));
      this.i.a(7, new rz(this, 1.0D));
      this.i.a(8, new ri(this, wn.class, 8.0F));
      this.i.a(8, new ry(this));
      this.bi.a(1, new sm(this, true, new Class[0]));
      this.bi.a(2, new sp(this, wn.class, true));
   }

   protected String bp() {
      return "mob.blaze.death";
   }

   protected String z() {
      return "mob.blaze.breathe";
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

   public float c(float var1) {
      return 1.0F;
   }

   public boolean at() {
      return this.n();
   }

   protected String bo() {
      return "mob.blaze.hit";
   }

   protected void h() {
      super.h();
      this.ac.a(16, new Byte((byte)0));
   }

   protected void b(boolean var1, int var2) {
      if (var1) {
         int var3 = this.V.nextInt(2 + var2);

         for(int var4 = 0; var4 < var3; ++var4) {
            this.a(zy.bv, 1);
         }
      }

   }

   static class a extends rd {
      private int c;
      private vl a;
      private int b;

      public a(vl var1) {
         this.a = var1;
         this.a(3);
      }

      public void e() {
         --this.c;
         pr var1 = this.a.u();
         double var2 = this.a.h(var1);
         if (var2 < 4.0D) {
            if (this.c <= 0) {
               this.c = 20;
               this.a.r(var1);
            }

            this.a.q().a(var1.s, var1.t, var1.u, 1.0D);
         } else if (var2 < 256.0D) {
            double var4 = var1.s - this.a.s;
            double var6 = var1.aR().b + (double)(var1.K / 2.0F) - (this.a.t + (double)(this.a.K / 2.0F));
            double var8 = var1.u - this.a.u;
            if (this.c <= 0) {
               ++this.b;
               if (this.b == 1) {
                  this.c = 60;
                  this.a.a(true);
               } else if (this.b <= 4) {
                  this.c = 6;
               } else {
                  this.c = 100;
                  this.b = 0;
                  this.a.a(false);
               }

               if (this.b > 1) {
                  float var10 = ns.c(ns.a(var2)) * 0.5F;
                  this.a.o.a((wn)null, 1009, new cj((int)this.a.s, (int)this.a.t, (int)this.a.u), 0);

                  for(int var11 = 0; var11 < 1; ++var11) {
                     ww var12 = new ww(this.a.o, this.a, var4 + this.a.bc().nextGaussian() * (double)var10, var6, var8 + this.a.bc().nextGaussian() * (double)var10);
                     var12.t = this.a.t + (double)(this.a.K / 2.0F) + 0.5D;
                     this.a.o.d((pk)var12);
                  }
               }
            }

            this.a.p().a(var1, 10.0F, 10.0F);
         } else {
            this.a.s().n();
            this.a.q().a(var1.s, var1.t, var1.u, 1.0D);
         }

         super.e();
      }

      public void d() {
         this.a.a(false);
      }

      public void c() {
         this.b = 0;
      }

      public boolean a() {
         pr var1 = this.a.u();
         return var1 != null && var1.ai();
      }
   }
}
