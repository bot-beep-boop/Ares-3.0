public class uo extends un {
   private float c = 1.0F;

   public uo(adm var1) {
      super(var1);
   }

   public void b(dn var1) {
      if (this.o() != null) {
         var1.a((String)"Item", (eb)this.o().b(new dn()));
         var1.a("ItemRotation", (byte)this.p());
         var1.a("ItemDropChance", this.c);
      }

      super.b(var1);
   }

   public zx o() {
      return this.H().f(8);
   }

   public void a(int var1) {
      this.a(var1, true);
   }

   public int m() {
      return 12;
   }

   public boolean e(wn var1) {
      if (this.o() == null) {
         zx var2 = var1.bA();
         if (var2 != null && !this.o.D) {
            this.a(var2);
            if (!var1.bA.d && --var2.b <= 0) {
               var1.bi.a(var1.bi.c, (zx)null);
            }
         }
      } else if (!this.o.D) {
         this.a(this.p() + 1);
      }

      return true;
   }

   public int p() {
      return this.H().a(9);
   }

   public int q() {
      return this.o() == null ? 0 : this.p() % 8 + 1;
   }

   public void a(pk var1, boolean var2) {
      if (this.o.Q().b("doEntityDrops")) {
         zx var3 = this.o();
         if (var1 instanceof wn) {
            wn var4 = (wn)var1;
            if (var4.bA.d) {
               this.b(var3);
               return;
            }
         }

         if (var2) {
            this.a(new zx(zy.bP), 0.0F);
         }

         if (var3 != null && this.V.nextFloat() < this.c) {
            var3 = var3.k();
            this.b(var3);
            this.a(var3, 0.0F);
         }

      }
   }

   private void a(int var1, boolean var2) {
      this.H().b(9, (byte)(var1 % 8));
      if (var2 && this.a != null) {
         this.o.e(this.a, afi.a);
      }

   }

   public uo(adm var1, cj var2, cq var3) {
      super(var1, var2);
      this.a((cq)var3);
   }

   protected void h() {
      this.H().a(8, 5);
      this.H().a(9, (byte)0);
   }

   private void a(zx var1, boolean var2) {
      if (var1 != null) {
         var1 = var1.k();
         var1.b = 1;
         var1.a(this);
      }

      this.H().b(8, var1);
      this.H().i(8);
      if (var2 && this.a != null) {
         this.o.e(this.a, afi.a);
      }

   }

   private void b(zx var1) {
      if (var1 != null) {
         if (var1.b() == zy.bd) {
            atg var2 = ((aab)var1.b()).a(var1, this.o);
            var2.h.remove("frame-" + this.F());
         }

         var1.a((uo)null);
      }
   }

   public boolean a(double var1) {
      double var3 = 16.0D;
      var3 *= 64.0D * this.j;
      return var1 < var3 * var3;
   }

   public boolean a(ow var1, float var2) {
      if (this.b((ow)var1)) {
         return false;
      } else if (!var1.c() && this.o() != null) {
         if (!this.o.D) {
            this.a(var1.j(), false);
            this.a((zx)null);
         }

         return true;
      } else {
         return super.a(var1, var2);
      }
   }

   public int l() {
      return 12;
   }

   public void b(pk var1) {
      this.a(var1, true);
   }

   public void a(zx var1) {
      this.a(var1, true);
   }

   public void a(dn var1) {
      dn var2 = var1.m("Item");
      if (var2 != null && !var2.c_()) {
         this.a(zx.a(var2), false);
         this.a(var1.d("ItemRotation"), false);
         if (var1.b("ItemDropChance", 99)) {
            this.c = var1.h("ItemDropChance");
         }

         if (var1.c("Direction")) {
            this.a(this.p() * 2, false);
         }
      }

      super.a(var1);
   }

   public float ao() {
      return 0.0F;
   }
}
