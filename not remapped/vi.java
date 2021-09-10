public class vi extends va {
   private int a = -1;

   public vi(adm var1) {
      super(var1);
   }

   public boolean a(ow var1, float var2) {
      pk var3 = var1.i();
      if (var3 instanceof wq) {
         wq var4 = (wq)var3;
         if (var4.at()) {
            this.b(var4.v * var4.v + var4.w * var4.w + var4.x * var4.x);
         }
      }

      return super.a(var1, var2);
   }

   public void a(int var1, int var2, int var3, boolean var4) {
      if (var4 && this.a < 0) {
         this.j();
      }

   }

   public boolean y() {
      return this.a > -1;
   }

   protected void b(double var1) {
      if (!this.o.D) {
         double var3 = Math.sqrt(var1);
         if (var3 > 5.0D) {
            var3 = 5.0D;
         }

         this.o.a(this, this.s, this.t, this.u, (float)(4.0D + this.V.nextDouble() * 1.5D * var3), true);
         this.J();
      }

   }

   protected void a(dn var1) {
      super.a(var1);
      if (var1.b("TNTFuse", 99)) {
         this.a = var1.f("TNTFuse");
      }

   }

   public boolean a(adi var1, adm var2, cj var3, alz var4, float var5) {
      return !this.y() || !afe.d(var4) && !afe.e(var2, var3.a()) ? super.a(var1, var2, var3, var4, var5) : false;
   }

   public vi(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }

   protected void b(dn var1) {
      super.b(var1);
      var1.a("TNTFuse", this.a);
   }

   public alz u() {
      return afi.W.Q();
   }

   public void j() {
      this.a = 80;
      if (!this.o.D) {
         this.o.a((pk)this, (byte)10);
         if (!this.R()) {
            this.o.a((pk)this, "game.tnt.primed", 1.0F, 1.0F);
         }
      }

   }

   public int l() {
      return this.a;
   }

   public float a(adi var1, adm var2, cj var3, alz var4) {
      return !this.y() || !afe.d(var4) && !afe.e(var2, var3.a()) ? super.a(var1, var2, var3, var4) : 0.0F;
   }

   public void t_() {
      super.t_();
      if (this.a > 0) {
         --this.a;
         this.o.a(cy.l, this.s, this.t + 0.5D, this.u, 0.0D, 0.0D, 0.0D);
      } else if (this.a == 0) {
         this.b(this.v * this.v + this.x * this.x);
      }

      if (this.D) {
         double var1 = this.v * this.v + this.x * this.x;
         if (var1 >= 0.009999999776482582D) {
            this.b(var1);
         }
      }

   }

   public void a(ow var1) {
      super.a(var1);
      double var2 = this.v * this.v + this.x * this.x;
      if (!var1.c() && this.o.Q().b("doEntityDrops")) {
         this.a(new zx(afi.W, 1), 0.0F);
      }

      if (var1.o() || var1.c() || var2 >= 0.009999999776482582D) {
         this.b(var2);
      }

   }

   public void e(float var1, float var2) {
      if (var1 >= 3.0F) {
         float var3 = var1 / 10.0F;
         this.b((double)(var3 * var3));
      }

      super.e(var1, var2);
   }

   public void a(byte var1) {
      if (var1 == 10) {
         this.j();
      } else {
         super.a(var1);
      }

   }

   public va.a s() {
      return va.a.d;
   }
}
