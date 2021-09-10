public class aal extends zw {
   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      boolean var9 = var3.p(var4).c().a(var3, var4);
      cj var10 = var9 ? var4 : var4.a(var5);
      if (!var2.a(var10, var5, var1)) {
         return false;
      } else {
         afh var11 = var3.p(var10).c();
         if (!var3.a(var11, var10, false, var5, (pk)null, var1)) {
            return false;
         } else if (afi.af.d(var3, var10)) {
            --var1.b;
            var3.a(var10, afi.af.Q());
            return true;
         } else {
            return false;
         }
      }
   }

   public aal() {
      this.a(yz.d);
   }
}
