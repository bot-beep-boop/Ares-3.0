public class xl extends xi {
   private og a;
   private final xl.a f;

   public xl(og var1, og var2) {
      this.a = var2;
      this.a((yg)(this.f = new xl.a(this, var2, 0, 136, 110)));
      byte var3 = 36;
      short var4 = 137;

      int var5;
      for(var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 9; ++var6) {
            this.a((yg)(new yg(var1, var6 + var5 * 9 + 9, var3 + var6 * 18, var4 + var5 * 18)));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.a((yg)(new yg(var1, var5, var3 + var5 * 18, 58 + var4)));
      }

   }

   public zx b(wn var1, int var2) {
      zx var3 = null;
      yg var4 = (yg)this.c.get(var2);
      if (var4 != null && var4.e()) {
         zx var5 = var4.d();
         var3 = var5.k();
         if (var2 == 0) {
            if (!this.a(var5, 1, 37, true)) {
               return null;
            }

            var4.a(var5, var3);
         } else if (!this.f.e() && this.f.a(var5) && var5.b == 1) {
            if (!this.a(var5, 0, 1, false)) {
               return null;
            }
         } else if (var2 >= 1 && var2 < 28) {
            if (!this.a(var5, 28, 37, false)) {
               return null;
            }
         } else if (var2 >= 28 && var2 < 37) {
            if (!this.a(var5, 1, 28, false)) {
               return null;
            }
         } else if (!this.a(var5, 1, 37, false)) {
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

   public og e() {
      return this.a;
   }

   public void b(int var1, int var2) {
      this.a.b(var1, var2);
   }

   public void b(wn var1) {
      super.b(var1);
      if (var1 != null && !var1.o.D) {
         zx var2 = this.f.a(this.f.a());
         if (var2 != null) {
            var1.a(var2, false);
         }

      }
   }

   public boolean a(wn var1) {
      return this.a.a(var1);
   }

   public void a(xn var1) {
      super.a(var1);
      var1.a(this, (og)this.a);
   }

   class a extends yg {
      final xl a;

      public int a() {
         return 1;
      }

      public boolean a(zx var1) {
         if (var1 == null) {
            return false;
         } else {
            return var1.b() == zy.bO || var1.b() == zy.i || var1.b() == zy.k || var1.b() == zy.j;
         }
      }

      public a(xl var1, og var2, int var3, int var4, int var5) {
         super(var2, var3, var4, var5);
         this.a = var1;
      }
   }
}
