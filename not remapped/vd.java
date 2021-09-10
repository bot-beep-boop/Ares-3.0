public abstract class vd extends va implements oo {
   private zx[] a = new zx[36];
   private boolean b = true;

   public int q_() {
      return 64;
   }

   public boolean b(int var1, zx var2) {
      return true;
   }

   public void a(on var1) {
   }

   public void c(int var1) {
      this.b = false;
      super.c(var1);
   }

   protected void a(dn var1) {
      super.a(var1);
      du var2 = var1.c("Items", 10);
      this.a = new zx[this.o_()];

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         dn var4 = var2.b(var3);
         int var5 = var4.d("Slot") & 255;
         if (var5 >= 0 && var5 < this.a.length) {
            this.a[var5] = zx.a(var4);
         }
      }

   }

   public vd(adm var1) {
      super(var1);
   }

   public int a_(int var1) {
      return 0;
   }

   public void c(wn var1) {
   }

   public zx a(int var1) {
      return this.a[var1];
   }

   public boolean e(wn var1) {
      if (!this.o.D) {
         var1.a((og)this);
      }

      return true;
   }

   protected void o() {
      int var1 = 15 - xi.b((og)this);
      float var2 = 0.98F + (float)var1 * 0.001F;
      this.v *= (double)var2;
      this.w *= 0.0D;
      this.x *= (double)var2;
   }

   public void J() {
      if (this.b) {
         oi.a(this.o, (pk)this, this);
      }

      super.J();
   }

   public on i() {
      return on.a;
   }

   protected void b(dn var1) {
      super.b(var1);
      du var2 = new du();

      for(int var3 = 0; var3 < this.a.length; ++var3) {
         if (this.a[var3] != null) {
            dn var4 = new dn();
            var4.a("Slot", (byte)var3);
            this.a[var3].b(var4);
            var2.a((eb)var4);
         }
      }

      var1.a((String)"Items", (eb)var2);
   }

   public void a(ow var1) {
      super.a(var1);
      if (this.o.Q().b("doEntityDrops")) {
         oi.a(this.o, (pk)this, this);
      }

   }

   public boolean a(wn var1) {
      if (this.I) {
         return false;
      } else {
         return !(var1.h(this) > 64.0D);
      }
   }

   public void b(int var1, int var2) {
   }

   public boolean r_() {
      return false;
   }

   public String e_() {
      return this.l_() ? this.aM() : "container.minecart";
   }

   public int g() {
      return 0;
   }

   public void b(wn var1) {
   }

   public zx b(int var1) {
      if (this.a[var1] != null) {
         zx var2 = this.a[var1];
         this.a[var1] = null;
         return var2;
      } else {
         return null;
      }
   }

   public void a(int var1, zx var2) {
      this.a[var1] = var2;
      if (var2 != null && var2.b > this.q_()) {
         var2.b = this.q_();
      }

   }

   public void p_() {
   }

   public zx a(int var1, int var2) {
      if (this.a[var1] != null) {
         zx var3;
         if (this.a[var1].b <= var2) {
            var3 = this.a[var1];
            this.a[var1] = null;
            return var3;
         } else {
            var3 = this.a[var1].a(var2);
            if (this.a[var1].b == 0) {
               this.a[var1] = null;
            }

            return var3;
         }
      } else {
         return null;
      }
   }

   public void l() {
      for(int var1 = 0; var1 < this.a.length; ++var1) {
         this.a[var1] = null;
      }

   }

   public vd(adm var1, double var2, double var4, double var6) {
      super(var1, var2, var4, var6);
   }
}
