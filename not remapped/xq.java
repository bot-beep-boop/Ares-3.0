public class xq extends xi {
   private cj h;
   public og f = new ye();
   public xp a = new xp(this, 3, 3);
   private adm g;

   public zx b(wn var1, int var2) {
      zx var3 = null;
      yg var4 = (yg)this.c.get(var2);
      if (var4 != null && var4.e()) {
         zx var5 = var4.d();
         var3 = var5.k();
         if (var2 == 0) {
            if (!this.a(var5, 10, 46, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if (var2 >= 10 && var2 < 37) {
            if (!this.a(var5, 37, 46, false)) {
               return null;
            }
         } else if (var2 >= 37 && var2 < 46) {
            if (!this.a(var5, 10, 37, false)) {
               return null;
            }
         } else if (!this.a(var5, 10, 46, false)) {
            return null;
         }

         if (var5.b == 0) {
            var4.d((zx)null);
         } else {
            var4.f();
         }

         if (var5.b == var3.b) {
            return null;
         }

         var4.a(var1, var5);
      }

      return var3;
   }

   public void a(og var1) {
      this.f.a(0, abt.a().a(this.a, this.g));
   }

   public boolean a(zx var1, yg var2) {
      return var2.d != this.f && super.a(var1, var2);
   }

   public boolean a(wn var1) {
      if (this.g.p(this.h).c() != afi.ai) {
         return false;
      } else {
         return !(var1.e((double)this.h.n() + 0.5D, (double)this.h.o() + 0.5D, (double)this.h.p() + 0.5D) > 64.0D);
      }
   }

   public void b(wn var1) {
      super.b(var1);
      if (!this.g.D) {
         for(int var2 = 0; var2 < 9; ++var2) {
            zx var3 = this.a.b(var2);
            if (var3 != null) {
               var1.a(var3, false);
            }
         }

      }
   }

   public xq(wm var1, adm var2, cj var3) {
      this.g = var2;
      this.h = var3;
      this.a((yg)(new yf(var1.d, this.a, this.f, 0, 124, 35)));

      int var4;
      int var5;
      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 3; ++var5) {
            this.a((yg)(new yg(this.a, var5 + var4 * 3, 30 + var5 * 18, 17 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.a((yg)(new yg(var1, var5 + var4 * 9 + 9, 8 + var5 * 18, 84 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.a((yg)(new yg(var1, var4, 8 + var4 * 18, 142)));
      }

      this.a((og)this.a);
   }
}
