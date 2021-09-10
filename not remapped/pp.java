public class pp extends pk {
   private int e;
   public int c;
   public int b;
   private int g;
   public int a;
   private wn f;
   private int d = 5;

   protected boolean s_() {
      return false;
   }

   public boolean a(ow var1, float var2) {
      if (this.b(var1)) {
         return false;
      } else {
         this.ac();
         this.d = (int)((float)this.d - var2);
         if (this.d <= 0) {
            this.J();
         }

         return false;
      }
   }

   public void d(wn var1) {
      if (!this.o.D) {
         if (this.c == 0 && var1.bp == 0) {
            var1.bp = 2;
            this.o.a((pk)var1, "random.orb", 0.1F, 0.5F * ((this.V.nextFloat() - this.V.nextFloat()) * 0.7F + 1.8F));
            var1.a((pk)this, 1);
            var1.u(this.e);
            this.J();
         }

      }
   }

   public pp(adm var1, double var2, double var4, double var6, int var8) {
      super(var1);
      this.a(0.5F, 0.5F);
      this.b(var2, var4, var6);
      this.y = (float)(Math.random() * 360.0D);
      this.v = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.w = (double)((float)(Math.random() * 0.2D) * 2.0F);
      this.x = (double)((float)(Math.random() * 0.20000000298023224D - 0.10000000149011612D) * 2.0F);
      this.e = var8;
   }

   public void t_() {
      super.t_();
      if (this.c > 0) {
         --this.c;
      }

      this.p = this.s;
      this.q = this.t;
      this.r = this.u;
      this.w -= 0.029999999329447746D;
      if (this.o.p(new cj(this)).c().t() == arm.i) {
         this.w = 0.20000000298023224D;
         this.v = (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
         this.x = (double)((this.V.nextFloat() - this.V.nextFloat()) * 0.2F);
         this.a("random.fizz", 0.4F, 2.0F + this.V.nextFloat() * 0.4F);
      }

      this.j(this.s, (this.aR().b + this.aR().e) / 2.0D, this.u);
      double var1 = 8.0D;
      if (this.g < this.a - 20 + this.F() % 100) {
         if (this.f == null || this.f.h(this) > var1 * var1) {
            this.f = this.o.a(this, var1);
         }

         this.g = this.a;
      }

      if (this.f != null && this.f.v()) {
         this.f = null;
      }

      if (this.f != null) {
         double var3 = (this.f.s - this.s) / var1;
         double var5 = (this.f.t + (double)this.f.aS() - this.t) / var1;
         double var7 = (this.f.u - this.u) / var1;
         double var9 = Math.sqrt(var3 * var3 + var5 * var5 + var7 * var7);
         double var11 = 1.0D - var9;
         if (var11 > 0.0D) {
            var11 *= var11;
            this.v += var3 / var9 * var11 * 0.1D;
            this.w += var5 / var9 * var11 * 0.1D;
            this.x += var7 / var9 * var11 * 0.1D;
         }
      }

      this.d(this.v, this.w, this.x);
      float var13 = 0.98F;
      if (this.C) {
         var13 = this.o.p(new cj(ns.c(this.s), ns.c(this.aR().b) - 1, ns.c(this.u))).c().L * 0.98F;
      }

      this.v *= (double)var13;
      this.w *= 0.9800000190734863D;
      this.x *= (double)var13;
      if (this.C) {
         this.w *= -0.8999999761581421D;
      }

      ++this.a;
      ++this.b;
      if (this.b >= 6000) {
         this.J();
      }

   }

   public boolean W() {
      return this.o.a((aug)this.aR(), (arm)arm.h, (pk)this);
   }

   public int j() {
      return this.e;
   }

   public void b(dn var1) {
      var1.a("Health", (short)((byte)this.d));
      var1.a("Age", (short)this.b);
      var1.a("Value", (short)this.e);
   }

   protected void h() {
   }

   public int b(float var1) {
      float var2 = 0.5F;
      var2 = ns.a(var2, 0.0F, 1.0F);
      int var3 = super.b(var1);
      int var4 = var3 & 255;
      int var5 = var3 >> 16 & 255;
      var4 += (int)(var2 * 15.0F * 16.0F);
      if (var4 > 240) {
         var4 = 240;
      }

      return var4 | var5 << 16;
   }

   public static int a(int var0) {
      if (var0 >= 2477) {
         return 2477;
      } else if (var0 >= 1237) {
         return 1237;
      } else if (var0 >= 617) {
         return 617;
      } else if (var0 >= 307) {
         return 307;
      } else if (var0 >= 149) {
         return 149;
      } else if (var0 >= 73) {
         return 73;
      } else if (var0 >= 37) {
         return 37;
      } else if (var0 >= 17) {
         return 17;
      } else if (var0 >= 7) {
         return 7;
      } else {
         return var0 >= 3 ? 3 : 1;
      }
   }

   public pp(adm var1) {
      super(var1);
      this.a(0.25F, 0.25F);
   }

   public int l() {
      if (this.e >= 2477) {
         return 10;
      } else if (this.e >= 1237) {
         return 9;
      } else if (this.e >= 617) {
         return 8;
      } else if (this.e >= 307) {
         return 7;
      } else if (this.e >= 149) {
         return 6;
      } else if (this.e >= 73) {
         return 5;
      } else if (this.e >= 37) {
         return 4;
      } else if (this.e >= 17) {
         return 3;
      } else if (this.e >= 7) {
         return 2;
      } else {
         return this.e >= 3 ? 1 : 0;
      }
   }

   public void a(dn var1) {
      this.d = var1.e("Health") & 255;
      this.b = var1.e("Age");
      this.e = var1.e("Value");
   }

   public boolean aD() {
      return false;
   }

   protected void f(int var1) {
      this.a(ow.a, (float)var1);
   }
}
