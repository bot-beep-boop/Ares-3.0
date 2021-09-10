public class zh extends yy {
   protected zh() {
      this.a(yz.f);
   }

   public zx a(zx var1, adm var2, wn var3) {
      zx var4 = new zx(zy.bd, 1, var2.b("map"));
      String var5 = "map_" + var4.i();
      atg var6 = new atg(var5);
      var2.a((String)var5, (ate)var6);
      var6.e = 0;
      var6.a(var3.s, var3.u, var6.e);
      var6.d = (byte)var2.t.q();
      var6.c();
      --var1.b;
      if (var1.b <= 0) {
         return var4;
      } else {
         if (!var3.bi.a(var4.k())) {
            var3.a(var4, false);
         }

         var3.b(na.ad[zw.b((zw)this)]);
         return var1;
      }
   }
}
