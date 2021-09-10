public class zr extends zw {
   public zr() {
      this.h = 1;
      this.d(64);
      this.a(yz.i);
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      var4 = var4.a(var5);
      if (!var2.a(var4, var5, var1)) {
         return false;
      } else {
         if (var3.p(var4).c().t() == arm.a) {
            var3.a((double)var4.n() + 0.5D, (double)var4.o() + 0.5D, (double)var4.p() + 0.5D, "fire.ignite", 1.0F, g.nextFloat() * 0.4F + 0.8F);
            var3.a(var4, afi.ab.Q());
         }

         var1.a(1, (pr)var2);
         return true;
      }
   }
}
