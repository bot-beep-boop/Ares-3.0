public class abk implements abs {
   public boolean a(xp var1, adm var2) {
      int var3 = 0;
      zx var4 = null;

      for(int var5 = 0; var5 < var1.o_(); ++var5) {
         zx var6 = var1.a(var5);
         if (var6 != null) {
            if (var6.b() == zy.bN) {
               if (var4 != null) {
                  return false;
               }

               var4 = var6;
            } else {
               if (var6.b() != zy.bM) {
                  return false;
               }

               ++var3;
            }
         }
      }

      return var4 != null && var3 > 0;
   }

   public zx b() {
      return null;
   }

   public zx a(xp var1) {
      int var2 = 0;
      zx var3 = null;

      for(int var4 = 0; var4 < var1.o_(); ++var4) {
         zx var5 = var1.a(var4);
         if (var5 != null) {
            if (var5.b() == zy.bN) {
               if (var3 != null) {
                  return null;
               }

               var3 = var5;
            } else {
               if (var5.b() != zy.bM) {
                  return null;
               }

               ++var2;
            }
         }
      }

      if (var3 != null && var2 >= 1 && abd.h(var3) < 2) {
         zx var6 = new zx(zy.bN, var2);
         var6.d((dn)var3.o().b());
         var6.o().a("generation", abd.h(var3) + 1);
         if (var3.s()) {
            var6.c(var3.q());
         }

         return var6;
      } else {
         return null;
      }
   }

   public zx[] b(xp var1) {
      zx[] var2 = new zx[var1.o_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         zx var4 = var1.a(var3);
         if (var4 != null && var4.b() instanceof abd) {
            var2[var3] = var4;
            break;
         }
      }

      return var2;
   }

   public int a() {
      return 9;
   }
}
