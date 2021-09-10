public abstract class tm extends ph implements pi {
   private wn bo;
   private int bm;
   protected afh bn;

   public void a(dn var1) {
      super.a(var1);
      this.bm = var1.f("InLove");
   }

   protected void E() {
      if (this.l() != 0) {
         this.bm = 0;
      }

      super.E();
   }

   public boolean a(tm var1) {
      if (var1 == this) {
         return false;
      } else if (var1.getClass() != this.getClass()) {
         return false;
      } else {
         return this.cr() && var1.cr();
      }
   }

   public boolean a(wn var1) {
      zx var2 = var1.bi.h();
      if (var2 != null) {
         if (this.d(var2) && this.l() == 0 && this.bm <= 0) {
            this.a(var1, var2);
            this.c(var1);
            return true;
         }

         if (this.j_() && this.d(var2)) {
            this.a(var1, var2);
            this.a((int)((float)(-this.l() / 20) * 0.1F), true);
            return true;
         }
      }

      return super.a(var1);
   }

   public void cs() {
      this.bm = 0;
   }

   protected void a(wn var1, zx var2) {
      if (!var1.bA.d) {
         --var2.b;
         if (var2.b <= 0) {
            var1.bi.a(var1.bi.c, (zx)null);
         }
      }

   }

   public tm(adm var1) {
      super(var1);
      this.bn = afi.c;
   }

   public void b(dn var1) {
      super.b(var1);
      var1.a("InLove", this.bm);
   }

   public boolean bR() {
      int var1 = ns.c(this.s);
      int var2 = ns.c(this.aR().b);
      int var3 = ns.c(this.u);
      cj var4 = new cj(var1, var2, var3);
      return this.o.p(var4.b()).c() == this.bn && this.o.k(var4) > 8 && super.bR();
   }

   public boolean d(zx var1) {
      if (var1 == null) {
         return false;
      } else {
         return var1.b() == zy.O;
      }
   }

   public int w() {
      return 120;
   }

   protected boolean C() {
      return false;
   }

   public void a(byte var1) {
      if (var1 == 18) {
         for(int var2 = 0; var2 < 7; ++var2) {
            double var3 = this.V.nextGaussian() * 0.02D;
            double var5 = this.V.nextGaussian() * 0.02D;
            double var7 = this.V.nextGaussian() * 0.02D;
            this.o.a(cy.I, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var3, var5, var7);
         }
      } else {
         super.a(var1);
      }

   }

   public boolean cr() {
      return this.bm > 0;
   }

   public void c(wn var1) {
      this.bm = 600;
      this.bo = var1;
      this.o.a((pk)this, (byte)18);
   }

   public float a(cj var1) {
      return this.o.p(var1.b()).c() == afi.c ? 10.0F : this.o.o(var1) - 0.5F;
   }

   public void m() {
      super.m();
      if (this.l() != 0) {
         this.bm = 0;
      }

      if (this.bm > 0) {
         --this.bm;
         if (this.bm % 10 == 0) {
            double var1 = this.V.nextGaussian() * 0.02D;
            double var3 = this.V.nextGaussian() * 0.02D;
            double var5 = this.V.nextGaussian() * 0.02D;
            this.o.a(cy.I, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var1, var3, var5);
         }
      }

   }

   protected int b(wn var1) {
      return 1 + this.o.s.nextInt(3);
   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else {
         this.bm = 0;
         return super.a(var1, var2);
      }
   }

   public wn cq() {
      return this.bo;
   }
}
