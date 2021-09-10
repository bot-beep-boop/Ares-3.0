public class abq extends abv {
   public boolean a(xp var1, adm var2) {
      if (!super.a(var1, var2)) {
         return false;
      } else {
         zx var3 = null;

         for(int var4 = 0; var4 < var1.o_() && var3 == null; ++var4) {
            zx var5 = var1.a(var4);
            if (var5 != null && var5.b() == zy.bd) {
               var3 = var5;
            }
         }

         if (var3 == null) {
            return false;
         } else {
            atg var6 = zy.bd.a(var3, var2);
            if (var6 == null) {
               return false;
            } else {
               return var6.e < 4;
            }
         }
      }
   }

   public abq() {
      super(3, 3, new zx[]{new zx(zy.aK), new zx(zy.aK), new zx(zy.aK), new zx(zy.aK), new zx(zy.bd, 0, 32767), new zx(zy.aK), new zx(zy.aK), new zx(zy.aK), new zx(zy.aK)}, new zx(zy.bV, 0, 0));
   }

   public zx a(xp var1) {
      zx var2 = null;

      for(int var3 = 0; var3 < var1.o_() && var2 == null; ++var3) {
         zx var4 = var1.a(var3);
         if (var4 != null && var4.b() == zy.bd) {
            var2 = var4;
         }
      }

      var2 = var2.k();
      var2.b = 1;
      if (var2.o() == null) {
         var2.d(new dn());
      }

      var2.o().a("map_is_scaling", true);
      return var2;
   }
}
