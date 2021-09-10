public class wt extends pk {
   private int b;
   private int a;

   public boolean aD() {
      return false;
   }

   public int b(float var1) {
      return super.b(var1);
   }

   public void b(dn var1) {
      var1.a("Life", this.a);
      var1.a("LifeTime", this.b);
      zx var2 = this.ac.f(8);
      if (var2 != null) {
         dn var3 = new dn();
         var2.b(var3);
         var1.a((String)"FireworksItem", (eb)var3);
      }

   }

   public wt(adm var1, double var2, double var4, double var6, zx var8) {
      super(var1);
      this.a = 0;
      this.a(0.25F, 0.25F);
      this.b(var2, var4, var6);
      int var9 = 1;
      if (var8 != null && var8.n()) {
         this.ac.b(8, var8);
         dn var10 = var8.o();
         dn var11 = var10.m("Fireworks");
         if (var11 != null) {
            var9 += var11.d("Flight");
         }
      }

      this.v = this.V.nextGaussian() * 0.001D;
      this.x = this.V.nextGaussian() * 0.001D;
      this.w = 0.05D;
      this.b = 10 * var9 + this.V.nextInt(6) + this.V.nextInt(7);
   }

   public void a(dn var1) {
      this.a = var1.f("Life");
      this.b = var1.f("LifeTime");
      dn var2 = var1.m("FireworksItem");
      if (var2 != null) {
         zx var3 = zx.a(var2);
         if (var3 != null) {
            this.ac.b(8, var3);
         }
      }

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

   public wt(adm var1) {
      super(var1);
      this.a(0.25F, 0.25F);
   }

   public boolean a(double var1) {
      return var1 < 4096.0D;
   }

   public float c(float var1) {
      return super.c(var1);
   }

   protected void h() {
      this.ac.a(8, 5);
   }

   public void a(byte var1) {
      if (var1 == 17 && this.o.D) {
         zx var2 = this.ac.f(8);
         dn var3 = null;
         if (var2 != null && var2.n()) {
            var3 = var2.o().m("Fireworks");
         }

         this.o.a(this.s, this.t, this.u, this.v, this.w, this.x, var3);
      }

      super.a(var1);
   }

   public void t_() {
      this.P = this.s;
      this.Q = this.t;
      this.R = this.u;
      super.t_();
      this.v *= 1.15D;
      this.x *= 1.15D;
      this.w += 0.04D;
      this.d(this.v, this.w, this.x);
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
      if (this.a == 0 && !this.R()) {
         this.o.a((pk)this, "fireworks.launch", 3.0F, 1.0F);
      }

      ++this.a;
      if (this.o.D && this.a % 2 < 2) {
         this.o.a(cy.d, this.s, this.t - 0.3D, this.u, this.V.nextGaussian() * 0.05D, -this.w * 0.5D, this.V.nextGaussian() * 0.05D);
      }

      if (!this.o.D && this.a > this.b) {
         this.o.a((pk)this, (byte)17);
         this.J();
      }

   }
}
