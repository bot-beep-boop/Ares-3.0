public class abv implements abs {
   private final int a;
   private boolean e;
   private final zx d;
   private final zx[] c;
   private final int b;

   public int a() {
      return this.a * this.b;
   }

   public zx[] b(xp var1) {
      zx[] var2 = new zx[var1.o_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         zx var4 = var1.a(var3);
         if (var4 != null && var4.b().r()) {
            var2[var3] = new zx(var4.b().q());
         }
      }

      return var2;
   }

   public zx a(xp var1) {
      zx var2 = this.b().k();
      if (this.e) {
         for(int var3 = 0; var3 < var1.o_(); ++var3) {
            zx var4 = var1.a(var3);
            if (var4 != null && var4.n()) {
               var2.d((dn)var4.o().b());
            }
         }
      }

      return var2;
   }

   public boolean a(xp var1, adm var2) {
      for(int var3 = 0; var3 <= 3 - this.a; ++var3) {
         for(int var4 = 0; var4 <= 3 - this.b; ++var4) {
            if (this.a(var1, var3, var4, true)) {
               return true;
            }

            if (this.a(var1, var3, var4, false)) {
               return true;
            }
         }
      }

      return false;
   }

   public zx b() {
      return this.d;
   }

   public abv(int var1, int var2, zx[] var3, zx var4) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
   }

   private boolean a(xp var1, int var2, int var3, boolean var4) {
      for(int var5 = 0; var5 < 3; ++var5) {
         for(int var6 = 0; var6 < 3; ++var6) {
            int var7 = var5 - var2;
            int var8 = var6 - var3;
            zx var9 = null;
            if (var7 >= 0 && var8 >= 0 && var7 < this.a && var8 < this.b) {
               if (var4) {
                  var9 = this.c[this.a - var7 - 1 + var8 * this.a];
               } else {
                  var9 = this.c[var7 + var8 * this.a];
               }
            }

            zx var10 = var1.c(var5, var6);
            if (var10 != null || var9 != null) {
               if (var10 == null && var9 != null || var10 != null && var9 == null) {
                  return false;
               }

               if (var9.b() != var10.b()) {
                  return false;
               }

               if (var9.i() != 32767 && var9.i() != var10.i()) {
                  return false;
               }
            }
         }
      }

      return true;
   }
}
