public class xm extends xi {
   private final yg f;
   private og a;
   private int g;

   public void b(int var1, int var2) {
      this.a.b(var1, var2);
   }

   public boolean a(wn var1) {
      return this.a.a(var1);
   }

   public void b() {
      super.b();

      for(int var1 = 0; var1 < this.e.size(); ++var1) {
         xn var2 = (xn)this.e.get(var1);
         if (this.g != this.a.a_(0)) {
            var2.a(this, 0, this.a.a_(0));
         }
      }

      this.g = this.a.a_(0);
   }

   public void a(xn var1) {
      super.a(var1);
      var1.a(this, (og)this.a);
   }

   public xm(wm var1, og var2) {
      this.a = var2;
      this.a((yg)(new xm.b(var1.d, var2, 0, 56, 46)));
      this.a((yg)(new xm.b(var1.d, var2, 1, 79, 53)));
      this.a((yg)(new xm.b(var1.d, var2, 2, 102, 46)));
      this.f = this.a((yg)(new xm.a(this, var2, 3, 79, 17)));

      int var3;
      for(var3 = 0; var3 < 3; ++var3) {
         for(int var4 = 0; var4 < 9; ++var4) {
            this.a((yg)(new yg(var1, var4 + var3 * 9 + 9, 8 + var4 * 18, 84 + var3 * 18)));
         }
      }

      for(var3 = 0; var3 < 9; ++var3) {
         this.a((yg)(new yg(var1, var3, 8 + var3 * 18, 142)));
      }

   }

   public zx b(wn var1, int var2) {
      zx var3 = null;
      yg var4 = (yg)this.c.get(var2);
      if (var4 != null && var4.e()) {
         zx var5 = var4.d();
         var3 = var5.k();
         if ((var2 < 0 || var2 > 2) && var2 != 3) {
            if (!this.f.e() && this.f.a(var5)) {
               if (!this.a(var5, 3, 4, false)) {
                  return null;
               }
            } else if (xm.b.b_(var3)) {
               if (!this.a(var5, 0, 3, false)) {
                  return null;
               }
            } else if (var2 >= 4 && var2 < 31) {
               if (!this.a(var5, 31, 40, false)) {
                  return null;
               }
            } else if (var2 >= 31 && var2 < 40) {
               if (!this.a(var5, 4, 31, false)) {
                  return null;
               }
            } else if (!this.a(var5, 4, 40, false)) {
               return null;
            }
         } else {
            if (!this.a(var5, 4, 40, true)) {
               return null;
            }

            var4.a(var5, var3);
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

   class a extends yg {
      final xm a;

      public int a() {
         return 64;
      }

      public boolean a(zx var1) {
         return var1 != null ? var1.b().l(var1) : false;
      }

      public a(xm var1, og var2, int var3, int var4, int var5) {
         super(var2, var3, var4, var5);
         this.a = var1;
      }
   }

   static class b extends yg {
      private wn a;

      public int a() {
         return 1;
      }

      public void a(wn var1, zx var2) {
         if (var2.b() == zy.bz && var2.i() > 0) {
            this.a.b((mw)mr.B);
         }

         super.a(var1, var2);
      }

      public boolean a(zx var1) {
         return b_(var1);
      }

      public static boolean b_(zx var0) {
         return var0 != null && (var0.b() == zy.bz || var0.b() == zy.bA);
      }

      public b(wn var1, og var2, int var3, int var4, int var5) {
         super(var2, var3, var4, var5);
         this.a = var1;
      }
   }
}
