public class yn extends zw {
   public yn() {
      this.a(yz.c);
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var3.D) {
         return true;
      } else if (var5 != cq.b) {
         return false;
      } else {
         alz var9 = var3.p(var4);
         afh var10 = var9.c();
         boolean var11 = var10.a(var3, var4);
         if (!var11) {
            var4 = var4.a();
         }

         int var12 = ns.c((double)(var2.y * 4.0F / 360.0F) + 0.5D) & 3;
         cq var13 = cq.b(var12);
         cj var14 = var4.a(var13);
         if (var2.a(var4, var5, var1) && var2.a(var14, var5, var1)) {
            boolean var15 = var3.p(var14).c().a(var3, var14);
            boolean var16 = var11 || var3.d(var4);
            boolean var17 = var15 || var3.d(var14);
            if (var16 && var17 && adm.a((adq)var3, (cj)var4.b()) && adm.a((adq)var3, (cj)var14.b())) {
               alz var18 = afi.C.Q().a(afg.b, false).a(afg.O, var13).a(afg.a, afg.a.b);
               if (var3.a((cj)var4, (alz)var18, 3)) {
                  alz var19 = var18.a(afg.a, afg.a.a);
                  var3.a((cj)var14, (alz)var19, 3);
               }

               --var1.b;
               return true;
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }
}
