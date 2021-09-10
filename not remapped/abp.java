public class abp implements abs {
   public zx a(xp var1) {
      int var2 = 0;
      zx var3 = null;

      for(int var4 = 0; var4 < var1.o_(); ++var4) {
         zx var5 = var1.a(var4);
         if (var5 != null) {
            if (var5.b() == zy.bd) {
               if (var3 != null) {
                  return null;
               }

               var3 = var5;
            } else {
               if (var5.b() != zy.bV) {
                  return null;
               }

               ++var2;
            }
         }
      }

      if (var3 != null && var2 >= 1) {
         zx var6 = new zx(zy.bd, var2 + 1, var3.i());
         if (var3.s()) {
            var6.c(var3.q());
         }

         return var6;
      } else {
         return null;
      }
   }

   public int a() {
      return 9;
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

   public zx b() {
      return null;
   }

   public boolean a(xp var1, adm var2) {
      int var3 = 0;
      zx var4 = null;

      for(int var5 = 0; var5 < var1.o_(); ++var5) {
         zx var6 = var1.a(var5);
         if (var6 != null) {
            if (var6.b() == zy.bd) {
               if (var4 != null) {
                  return false;
               }

               var4 = var6;
            } else {
               if (var6.b() != zy.bV) {
                  return false;
               }

               ++var3;
            }
         }
      }

      return var4 != null && var3 > 0;
   }
}
