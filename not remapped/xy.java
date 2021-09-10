public class xy extends xi {
   private final wn h;
   public boolean g;
   public og f = new ye();
   public xp a = new xp(this, 2, 2);

   public void b(wn var1) {
      super.b(var1);

      for(int var2 = 0; var2 < 4; ++var2) {
         zx var3 = this.a.b(var2);
         if (var3 != null) {
            var1.a(var3, false);
         }
      }

      this.f.a(0, (zx)null);
   }

   public xy(wm var1, boolean var2, wn var3) {
      this.g = var2;
      this.h = var3;
      this.a((yg)(new yf(var1.d, this.a, this.f, 0, 144, 36)));

      int var4;
      int var5;
      for(var4 = 0; var4 < 2; ++var4) {
         for(var5 = 0; var5 < 2; ++var5) {
            this.a((yg)(new yg(this.a, var5 + var4 * 2, 88 + var5 * 18, 26 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 4; ++var4) {
         this.a((yg)(new yg(this, var1, var1.o_() - 1 - var4, 8, 8 + var4 * 18, var4) {
            final xy b;
            final int a;

            {
               this.b = var1;
               this.a = var6;
            }

            public boolean a(zx var1) {
               if (var1 == null) {
                  return false;
               } else if (var1.b() instanceof yj) {
                  return ((yj)var1.b()).b == this.a;
               } else if (var1.b() != zw.a(afi.aU) && var1.b() != zy.bX) {
                  return false;
               } else {
                  return this.a == 0;
               }
            }

            public int a() {
               return 1;
            }

            public String c() {
               return yj.a[this.a];
            }
         }));
      }

      for(var4 = 0; var4 < 3; ++var4) {
         for(var5 = 0; var5 < 9; ++var5) {
            this.a((yg)(new yg(var1, var5 + (var4 + 1) * 9, 8 + var5 * 18, 84 + var4 * 18)));
         }
      }

      for(var4 = 0; var4 < 9; ++var4) {
         this.a((yg)(new yg(var1, var4, 8 + var4 * 18, 142)));
      }

      this.a((og)this.a);
   }

   public void a(og var1) {
      this.f.a(0, abt.a().a(this.a, this.h.o));
   }

   public zx b(wn var1, int var2) {
      zx var3 = null;
      yg var4 = (yg)this.c.get(var2);
      if (var4 != null && var4.e()) {
         zx var5 = var4.d();
         var3 = var5.k();
         if (var2 == 0) {
            if (!this.a(var5, 9, 45, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if (var2 >= 1 && var2 < 5) {
            if (!this.a(var5, 9, 45, false)) {
               return null;
            }
         } else if (var2 >= 5 && var2 < 9) {
            if (!this.a(var5, 9, 45, false)) {
               return null;
            }
         } else if (var3.b() instanceof yj && !((yg)this.c.get(5 + ((yj)var3.b()).b)).e()) {
            int var6 = 5 + ((yj)var3.b()).b;
            if (!this.a(var5, var6, var6 + 1, false)) {
               return null;
            }
         } else if (var2 >= 9 && var2 < 36) {
            if (!this.a(var5, 36, 45, false)) {
               return null;
            }
         } else if (var2 >= 36 && var2 < 45) {
            if (!this.a(var5, 9, 36, false)) {
               return null;
            }
         } else if (!this.a(var5, 9, 45, false)) {
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

   public boolean a(wn var1) {
      return true;
   }

   public boolean a(zx var1, yg var2) {
      return var2.d != this.f && super.a(var1, var2);
   }
}
