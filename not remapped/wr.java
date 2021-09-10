public class wr extends pk {
   private boolean e;
   private int d;
   private double a;
   private double c;
   private double b;

   public void t_() {
      this.P = this.s;
      this.Q = this.t;
      this.R = this.u;
      super.t_();
      this.s += this.v;
      this.t += this.w;
      this.u += this.x;
      float var1 = ns.a(this.v * this.v + this.x * this.x);
      this.y = (float)(ns.b(this.v, this.x) * 180.0D / 3.1415927410125732D);

      for(this.z = (float)(ns.b(this.w, (double)var1) * 180.0D / 3.1415927410125732D); this.z - this.B < -180.0F; this.B -= 360.0F) {
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
      if (!this.o.D) {
         double var2 = this.a - this.s;
         double var4 = this.c - this.u;
         float var6 = (float)Math.sqrt(var2 * var2 + var4 * var4);
         float var7 = (float)ns.b(var4, var2);
         double var8 = (double)var1 + (double)(var6 - var1) * 0.0025D;
         if (var6 < 1.0F) {
            var8 *= 0.8D;
            this.w *= 0.8D;
         }

         this.v = Math.cos((double)var7) * var8;
         this.x = Math.sin((double)var7) * var8;
         if (this.t < this.b) {
            this.w += (1.0D - this.w) * 0.014999999664723873D;
         } else {
            this.w += (-1.0D - this.w) * 0.014999999664723873D;
         }
      }

      float var10 = 0.25F;
      if (this.V()) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.o.a(cy.e, this.s - this.v * (double)var10, this.t - this.w * (double)var10, this.u - this.x * (double)var10, this.v, this.w, this.x);
         }
      } else {
         this.o.a(cy.y, this.s - this.v * (double)var10 + this.V.nextDouble() * 0.6D - 0.3D, this.t - this.w * (double)var10 - 0.5D, this.u - this.x * (double)var10 + this.V.nextDouble() * 0.6D - 0.3D, this.v, this.w, this.x);
      }

      if (!this.o.D) {
         this.b(this.s, this.t, this.u);
         ++this.d;
         if (this.d > 80 && !this.o.D) {
            this.J();
            if (this.e) {
               this.o.d((pk)(new uz(this.o, this.s, this.t, this.u, new zx(zy.bH))));
            } else {
               this.o.b(2003, new cj(this), 0);
            }
         }
      }

   }

   public void a(cj var1) {
      double var2 = (double)var1.n();
      int var4 = var1.o();
      double var5 = (double)var1.p();
      double var7 = var2 - this.s;
      double var9 = var5 - this.u;
      float var11 = ns.a(var7 * var7 + var9 * var9);
      if (var11 > 12.0F) {
         this.a = this.s + var7 / (double)var11 * 12.0D;
         this.c = this.u + var9 / (double)var11 * 12.0D;
         this.b = this.t + 8.0D;
      } else {
         this.a = var2;
         this.b = (double)var4;
         this.c = var5;
      }

      this.d = 0;
      this.e = this.V.nextInt(5) > 0;
   }

   public wr(adm var1) {
      super(var1);
      this.a(0.25F, 0.25F);
   }

   public int b(float var1) {
      return 15728880;
   }

   public float c(float var1) {
      return 1.0F;
   }

   public void i(double var1, double var3, double var5) {
      this.v = var1;
      this.w = var3;
      this.x = var5;
      if (this.B == 0.0F && this.A == 0.0F) {
         float var7 = ns.a(var1 * var1 + var5 * var5);
         this.A = this.y = (float)(ns.b(var1, var5) * 180.0D / 3.1415927410125732D);
         this.B = this.z = (float)(ns.b(var3, (double)var7) * 180.0D / 3.1415927410125732D);
      }

   }

   protected void h() {
   }

   public boolean aD() {
      return false;
   }

   public void a(dn var1) {
   }

   public wr(adm var1, double var2, double var4, double var6) {
      super(var1);
      this.d = 0;
      this.a(0.25F, 0.25F);
      this.b(var2, var4, var6);
   }

   public void b(dn var1) {
   }

   public boolean a(double var1) {
      double var3 = this.aR().a() * 4.0D;
      if (Double.isNaN(var3)) {
         var3 = 4.0D;
      }

      var3 *= 64.0D;
      return var1 < var3 * var3;
   }
}
