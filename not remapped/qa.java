import java.util.UUID;

public abstract class qa extends tm implements px {
   protected se bm = new se(this);

   public void a(dn var1) {
      super.a(var1);
      String var2 = "";
      if (var1.b("OwnerUUID", 8)) {
         var2 = var1.j("OwnerUUID");
      } else {
         String var3 = var1.j("Owner");
         var2 = lw.a(var3);
      }

      if (var2.length() > 0) {
         this.b(var2);
         this.m(true);
      }

      this.bm.a(var1.n("Sitting"));
      this.n(var1.n("Sitting"));
   }

   public void b(String var1) {
      this.ac.b(17, var1);
   }

   public String b() {
      return this.ac.e(17);
   }

   public void a(byte var1) {
      if (var1 == 7) {
         this.l(true);
      } else if (var1 == 6) {
         this.l(false);
      } else {
         super.a(var1);
      }

   }

   public void b(dn var1) {
      super.b(var1);
      if (this.b() == null) {
         var1.a("OwnerUUID", "");
      } else {
         var1.a("OwnerUUID", this.b());
      }

      var1.a("Sitting", this.cn());
   }

   public void n(boolean var1) {
      byte var2 = this.ac.a(16);
      if (var1) {
         this.ac.b(16, (byte)(var2 | 1));
      } else {
         this.ac.b(16, (byte)(var2 & -2));
      }

   }

   public qa(adm var1) {
      super(var1);
      this.cm();
   }

   public void a(ow var1) {
      if (!this.o.D && this.o.Q().b("showDeathMessages") && this.l_() && this.co() instanceof lf) {
         ((lf)this.co()).a(this.bs().b());
      }

      super.a((ow)var1);
   }

   public boolean cl() {
      return (this.ac.a(16) & 4) != 0;
   }

   public auq bO() {
      if (this.cl()) {
         pr var1 = this.co();
         if (var1 != null) {
            return var1.bO();
         }
      }

      return super.bO();
   }

   public boolean a(pr var1, pr var2) {
      return true;
   }

   public boolean e(pr var1) {
      return var1 == this.co();
   }

   protected void l(boolean var1) {
      cy var2 = cy.I;
      if (!var1) {
         var2 = cy.l;
      }

      for(int var3 = 0; var3 < 7; ++var3) {
         double var4 = this.V.nextGaussian() * 0.02D;
         double var6 = this.V.nextGaussian() * 0.02D;
         double var8 = this.V.nextGaussian() * 0.02D;
         this.o.a(var2, this.s + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, this.t + 0.5D + (double)(this.V.nextFloat() * this.K), this.u + (double)(this.V.nextFloat() * this.J * 2.0F) - (double)this.J, var4, var6, var8);
      }

   }

   public boolean c(pr var1) {
      if (this.cl()) {
         pr var2 = this.co();
         if (var1 == var2) {
            return true;
         }

         if (var2 != null) {
            return var2.c(var1);
         }
      }

      return super.c(var1);
   }

   public pr co() {
      try {
         UUID var1 = UUID.fromString(this.b());
         return var1 == null ? null : this.o.b(var1);
      } catch (IllegalArgumentException var2) {
         return null;
      }
   }

   protected void cm() {
   }

   protected void h() {
      super.h();
      this.ac.a(16, (byte)0);
      this.ac.a(17, "");
   }

   public void m(boolean var1) {
      byte var2 = this.ac.a(16);
      if (var1) {
         this.ac.b(16, (byte)(var2 | 4));
      } else {
         this.ac.b(16, (byte)(var2 & -5));
      }

      this.cm();
   }

   public pk m_() {
      return this.co();
   }

   public boolean cn() {
      return (this.ac.a(16) & 1) != 0;
   }

   public se cp() {
      return this.bm;
   }
}
