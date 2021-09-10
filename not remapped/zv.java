public class zv extends zw {
   protected zw.a a;

   public String g() {
      return this.a.toString();
   }

   public zv(zw.a var1) {
      this.a = var1;
      this.h = 1;
      this.d(var1.a());
      this.a(yz.i);
   }

   protected boolean a(zx var1, wn var2, adm var3, cj var4, alz var5) {
      var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), var5.c().H.c(), (var5.c().H.d() + 1.0F) / 2.0F, var5.c().H.e() * 0.8F);
      if (var3.D) {
         return true;
      } else {
         var3.a(var4, var5);
         var1.a(1, (pr)var2);
         return true;
      }
   }

   public boolean w_() {
      return true;
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else {
         alz var9 = var3.p(var4);
         afh var10 = var9.c();
         if (var5 != cq.a && var3.p(var4.a()).c().t() == arm.a) {
            if (var10 == afi.c) {
               return this.a(var1, var2, var3, var4, afi.ak.Q());
            }

            if (var10 == afi.d) {
               switch((agf.a)var9.b(agf.a)) {
               case a:
                  return this.a(var1, var2, var3, var4, afi.ak.Q());
               case b:
                  return this.a(var1, var2, var3, var4, afi.d.Q().a(agf.a, agf.a.a));
               }
            }
         }

         return false;
      }
   }
}
