import java.util.List;

public abstract class ws extends pk {
   public double c;
   private boolean i;
   private int ar;
   public double b;
   private afh h;
   private int g = -1;
   public pr a;
   public double d;
   private int e = -1;
   private int as;
   private int f = -1;

   public boolean a(double var1) {
      double var3 = this.aR().a() * 4.0D;
      if (Double.isNaN(var3)) {
         var3 = 4.0D;
      }

      var3 *= 64.0D;
      return var1 < var3 * var3;
   }

   protected abstract void a(auh var1);

   public ws(adm var1) {
      super(var1);
      this.a(1.0F, 1.0F);
   }

   public boolean ad() {
      return true;
   }

   public void b(dn var1) {
      var1.a("xTile", (short)this.e);
      var1.a("yTile", (short)this.f);
      var1.a("zTile", (short)this.g);
      jy var2 = (jy)afh.c.c(this.h);
      var1.a("inTile", var2 == null ? "" : var2.toString());
      var1.a("inGround", (byte)(this.i ? 1 : 0));
      var1.a((String)"direction", (eb)this.a((double[])(new double[]{this.v, this.w, this.x})));
   }

   public ws(adm var1, double var2, double var4, double var6, double var8, double var10, double var12) {
      super(var1);
      this.a(1.0F, 1.0F);
      this.b(var2, var4, var6, this.y, this.z);
      this.b(var2, var4, var6);
      double var14 = (double)ns.a(var8 * var8 + var10 * var10 + var12 * var12);
      this.b = var8 / var14 * 0.1D;
      this.c = var10 / var14 * 0.1D;
      this.d = var12 / var14 * 0.1D;
   }

   protected void h() {
   }

   public int b(float var1) {
      return 15728880;
   }

   public void a(dn var1) {
      this.e = var1.e("xTile");
      this.f = var1.e("yTile");
      this.g = var1.e("zTile");
      if (var1.b("inTile", 8)) {
         this.h = afh.b(var1.j("inTile"));
      } else {
         this.h = afh.c(var1.d("inTile") & 255);
      }

      this.i = var1.d("inGround") == 1;
      if (var1.b("direction", 9)) {
         du var2 = var1.c("direction", 6);
         this.v = var2.d(0);
         this.w = var2.d(1);
         this.x = var2.d(2);
      } else {
         this.J();
      }

   }

   public void t_() {
      if (this.o.D || (this.a == null || !this.a.I) && this.o.e(new cj(this))) {
         super.t_();
         this.e(1);
         if (this.i) {
            if (this.o.p(new cj(this.e, this.f, this.g)).c() == this.h) {
               ++this.ar;
               if (this.ar == 600) {
                  this.J();
               }

               return;
            }

            this.i = false;
            this.v *= (double)(this.V.nextFloat() * 0.2F);
            this.w *= (double)(this.V.nextFloat() * 0.2F);
            this.x *= (double)(this.V.nextFloat() * 0.2F);
            this.ar = 0;
            this.as = 0;
         } else {
            ++this.as;
         }

         aui var1 = new aui(this.s, this.t, this.u);
         aui var2 = new aui(this.s + this.v, this.t + this.w, this.u + this.x);
         auh var3 = this.o.a(var1, var2);
         var1 = new aui(this.s, this.t, this.u);
         var2 = new aui(this.s + this.v, this.t + this.w, this.u + this.x);
         if (var3 != null) {
            var2 = new aui(var3.c.a, var3.c.b, var3.c.c);
         }

         pk var4 = null;
         List var5 = this.o.b((pk)this, (aug)this.aR().a(this.v, this.w, this.x).b(1.0D, 1.0D, 1.0D));
         double var6 = 0.0D;

         for(int var8 = 0; var8 < var5.size(); ++var8) {
            pk var9 = (pk)var5.get(var8);
            if (var9.ad() && (!var9.k(this.a) || this.as >= 25)) {
               float var10 = 0.3F;
               aug var11 = var9.aR().b((double)var10, (double)var10, (double)var10);
               auh var12 = var11.a(var1, var2);
               if (var12 != null) {
                  double var13 = var1.g(var12.c);
                  if (var13 < var6 || var6 == 0.0D) {
                     var4 = var9;
                     var6 = var13;
                  }
               }
            }
         }

         if (var4 != null) {
            var3 = new auh(var4);
         }

         if (var3 != null) {
            this.a(var3);
         }

         this.s += this.v;
         this.t += this.w;
         this.u += this.x;
         float var15 = ns.a(this.v * this.v + this.x * this.x);
         this.y = (float)(ns.b(this.x, this.v) * 180.0D / 3.1415927410125732D) + 90.0F;

         for(this.z = (float)(ns.b((double)var15, this.w) * 180.0D / 3.1415927410125732D) - 90.0F; this.z - this.B < -180.0F; this.B -= 360.0F) {
         }

         while(this.z - this.B >= 180.0F) {
            this.B += 360.0F;
         }

         while(this.y - this.A < -180.0F) {
            this.A -= 360.0F;
         }

         while(this.y - this.A >= 180.0F) {
            this.A += 360.0F;
         }

         this.z = this.B + (this.z - this.B) * 0.2F;
         this.y = this.A + (this.y - this.A) * 0.2F;
         float var16 = this.j();
         if (this.V()) {
            for(int var17 = 0; var17 < 4; ++var17) {
               float var18 = 0.25F;
               this.o.a(cy.e, this.s - this.v * (double)var18, this.t - this.w * (double)var18, this.u - this.x * (double)var18, this.v, this.w, this.x);
            }

            var16 = 0.8F;
         }

         this.v += this.b;
         this.w += this.c;
         this.x += this.d;
         this.v *= (double)var16;
         this.w *= (double)var16;
         this.x *= (double)var16;
         this.o.a(cy.l, this.s, this.t + 0.5D, this.u, 0.0D, 0.0D, 0.0D);
         this.b(this.s, this.t, this.u);
      } else {
         this.J();
      }
   }

   public ws(adm var1, pr var2, double var3, double var5, double var7) {
      super(var1);
      this.a = var2;
      this.a(1.0F, 1.0F);
      this.b(var2.s, var2.t, var2.u, var2.y, var2.z);
      this.b(this.s, this.t, this.u);
      this.v = this.w = this.x = 0.0D;
      var3 += this.V.nextGaussian() * 0.4D;
      var5 += this.V.nextGaussian() * 0.4D;
      var7 += this.V.nextGaussian() * 0.4D;
      double var9 = (double)ns.a(var3 * var3 + var5 * var5 + var7 * var7);
      this.b = var3 / var9 * 0.1D;
      this.c = var5 / var9 * 0.1D;
      this.d = var7 / var9 * 0.1D;
   }

   public float c(float var1) {
      return 1.0F;
   }

   public boolean a(ow var1, float var2) {
      if (this.b(var1)) {
         return false;
      } else {
         this.ac();
         if (var1.j() != null) {
            aui var3 = var1.j().ap();
            if (var3 != null) {
               this.v = var3.a;
               this.w = var3.b;
               this.x = var3.c;
               this.b = this.v * 0.1D;
               this.c = this.w * 0.1D;
               this.d = this.x * 0.1D;
            }

            if (var1.j() instanceof pr) {
               this.a = (pr)var1.j();
            }

            return true;
         } else {
            return false;
         }
      }
   }

   public float ao() {
      return 1.0F;
   }

   protected float j() {
      return 0.95F;
   }
}
