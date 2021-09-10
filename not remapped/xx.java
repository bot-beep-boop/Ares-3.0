public class xx extends xi {
   private og a;
   private tp f;

   public xx(og var1, og var2, tp var3, wn var4) {
      this.a = var2;
      this.f = var3;
      byte var5 = 3;
      var2.b(var4);
      int var6 = (var5 - 4) * 18;
      this.a(new yg(this, var2, 0, 8, 18) {
         final xx a;

         public boolean a(zx var1) {
            return super.a(var1) && var1.b() == zy.aA && !this.e();
         }

         {
            this.a = var1;
         }
      });
      this.a(new yg(this, var2, 1, 8, 36, var3) {
         final xx b;
         final tp a;

         public boolean b() {
            return this.a.cO();
         }

         public boolean a(zx var1) {
            return super.a(var1) && this.a.cO() && tp.a(var1.b());
         }

         {
            this.b = var1;
            this.a = var6;
         }
      });
      int var7;
      int var8;
      if (var3.cw()) {
         for(var7 = 0; var7 < var5; ++var7) {
            for(var8 = 0; var8 < 5; ++var8) {
               this.a(new yg(var2, 2 + var8 + var7 * 5, 80 + var8 * 18, 18 + var7 * 18));
            }
         }
      }

      for(var7 = 0; var7 < 3; ++var7) {
         for(var8 = 0; var8 < 9; ++var8) {
            this.a(new yg(var1, var8 + var7 * 9 + 9, 8 + var8 * 18, 102 + var7 * 18 + var6));
         }
      }

      for(var7 = 0; var7 < 9; ++var7) {
         this.a(new yg(var1, var7, 8 + var7 * 18, 160 + var6));
      }

   }

   public zx b(wn var1, int var2) {
      zx var3 = null;
      yg var4 = (yg)this.c.get(var2);
      if (var4 != null && var4.e()) {
         zx var5 = var4.d();
         var3 = var5.k();
         if (var2 < this.a.o_()) {
            if (!this.a(var5, this.a.o_(), this.c.size(), true)) {
               return null;
            }
         } else if (this.a(1).a(var5) && !this.a(1).e()) {
            if (!this.a(var5, 1, 2, false)) {
               return null;
            }
         } else if (this.a(0).a(var5)) {
            if (!this.a(var5, 0, 1, false)) {
               return null;
            }
         } else if (this.a.o_() <= 2 || !this.a(var5, 2, this.a.o_(), false)) {
            return null;
         }

         if (var5.b == 0) {
            var4.d((zx)null);
         } else {
            var4.f();
         }
      }

      return var3;
   }

   public void b(wn var1) {
      super.b(var1);
      this.a.c(var1);
   }

   public boolean a(wn var1) {
      return this.a.a(var1) && this.f.ai() && this.f.g(var1) < 8.0F;
   }
}
