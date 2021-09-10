public class ys extends zw {
   public ys() {
      this.a(yz.k);
   }

   public zx a(zx var1, adm var2, wn var3) {
      auh var4 = this.a(var2, var3, true);
      if (var4 == null) {
         return var1;
      } else {
         if (var4.a == auh.a.b) {
            cj var5 = var4.a();
            if (!var2.a(var3, var5)) {
               return var1;
            }

            if (!var3.a(var5.a(var4.b), var4.b, var1)) {
               return var1;
            }

            if (var2.p(var5).c().t() == arm.h) {
               --var1.b;
               var3.b(na.ad[zw.b((zw)this)]);
               if (var1.b <= 0) {
                  return new zx(zy.bz);
               }

               if (!var3.bi.a(new zx(zy.bz))) {
                  var3.a(new zx(zy.bz, 1, 0), false);
               }
            }
         }

         return var1;
      }
   }
}
