public class aav extends yo {
   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var1.b == 0) {
         return false;
      } else if (!var2.a(var4, var5, var1)) {
         return false;
      } else {
         alz var9 = var3.p(var4);
         afh var10 = var9.c();
         cj var11 = var4;
         if ((var5 != cq.b || var10 != this.a) && !var10.a(var3, var4)) {
            var11 = var4.a(var5);
            var9 = var3.p(var11);
            var10 = var9.c();
         }

         if (var10 == this.a) {
            int var12 = (Integer)var9.b(ajp.a);
            if (var12 <= 7) {
               alz var13 = var9.a(ajp.a, var12 + 1);
               aug var14 = this.a.a(var3, var11, var13);
               if (var14 != null && var3.b(var14) && var3.a((cj)var11, (alz)var13, 2)) {
                  var3.a((double)((float)var11.n() + 0.5F), (double)((float)var11.o() + 0.5F), (double)((float)var11.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
                  --var1.b;
                  return true;
               }
            }
         }

         return super.a(var1, var2, var3, var11, var5, var6, var7, var8);
      }
   }

   public aav(afh var1) {
      super(var1);
      this.d(0);
      this.a(true);
   }

   public int a(int var1) {
      return var1;
   }
}
