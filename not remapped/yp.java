public class yp extends zw {
   private afh a;

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      alz var9 = var3.p(var4);
      afh var10 = var9.c();
      if (var10 == afi.aH && (Integer)var9.b(ajp.a) < 1) {
         var5 = cq.b;
      } else if (!var10.a(var3, var4)) {
         var4 = var4.a(var5);
      }

      if (!var2.a(var4, var5, var1)) {
         return false;
      } else if (var1.b == 0) {
         return false;
      } else {
         if (var3.a(this.a, var4, false, var5, (pk)null, var1)) {
            alz var11 = this.a.a(var3, var4, var5, var6, var7, var8, 0, var2);
            if (var3.a((cj)var4, (alz)var11, 3)) {
               var11 = var3.p(var4);
               if (var11.c() == this.a) {
                  yo.a(var3, var2, var4, var1);
                  var11.c().a(var3, (cj)var4, (alz)var11, (pr)var2, (zx)var1);
               }

               var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
               --var1.b;
               return true;
            }
         }

         return false;
      }
   }

   public yp(afh var1) {
      this.a = var1;
   }
}
