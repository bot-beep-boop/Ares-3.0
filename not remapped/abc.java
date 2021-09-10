public class abc extends zw {
   public abc() {
      this.c(1);
   }

   public zx a(zx var1, adm var2, wn var3) {
      var3.a(var1);
      var3.b(na.ad[zw.b((zw)this)]);
      return var1;
   }

   public static boolean b(dn var0) {
      if (var0 == null) {
         return false;
      } else if (!var0.b("pages", 9)) {
         return false;
      } else {
         du var1 = var0.c("pages", 8);

         for(int var2 = 0; var2 < var1.c(); ++var2) {
            String var3 = var1.f(var2);
            if (var3 == null) {
               return false;
            }

            if (var3.length() > 32767) {
               return false;
            }
         }

         return true;
      }
   }
}
