public class aar extends zw {
   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var5 == cq.a) {
         return false;
      } else if (!var3.p(var4).c().t().a()) {
         return false;
      } else {
         var4 = var4.a(var5);
         if (!var2.a(var4, var5, var1)) {
            return false;
         } else if (!afi.an.d(var3, var4)) {
            return false;
         } else if (var3.D) {
            return true;
         } else {
            if (var5 == cq.b) {
               int var9 = ns.c((double)((var2.y + 180.0F) * 16.0F / 360.0F) + 0.5D) & 15;
               var3.a((cj)var4, (alz)afi.an.Q().a(ajv.a, var9), 3);
            } else {
               var3.a((cj)var4, (alz)afi.ax.Q().a(akm.a, var5), 3);
            }

            --var1.b;
            akw var10 = var3.s(var4);
            if (var10 instanceof aln && !yo.a(var3, var2, var4, var1)) {
               var2.a((aln)var10);
            }

            return true;
         }
      }
   }

   public aar() {
      this.h = 16;
      this.a(yz.c);
   }
}
