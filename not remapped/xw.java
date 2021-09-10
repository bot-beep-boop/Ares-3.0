public class xw extends xi {
   private final og a;

   public boolean a(wn var1) {
      return this.a.a(var1);
   }

   public xw(wm var1, og var2, wn var3) {
      this.a = var2;
      var2.b(var3);
      byte var4 = 51;

      int var5;
      for(var5 = 0; var5 < var2.o_(); ++var5) {
         this.a(new yg(var2, var5, 44 + var5 * 18, 20));
      }

      for(var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 9; ++var6) {
            this.a(new yg(var1, var6 + var5 * 9 + 9, 8 + var6 * 18, var5 * 18 + var4));
         }
      }

      for(var5 = 0; var5 < 9; ++var5) {
         this.a(new yg(var1, var5, 8 + var5 * 18, 58 + var4));
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
         } else if (!this.a(var5, 0, this.a.o_(), false)) {
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
}
