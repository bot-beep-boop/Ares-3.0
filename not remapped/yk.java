import java.util.List;
import java.util.Random;

public class yk extends zw {
   public yk() {
      this.a(yz.c);
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (var5 == cq.a) {
         return false;
      } else {
         boolean var9 = var3.p(var4).c().a(var3, var4);
         cj var10 = var9 ? var4 : var4.a(var5);
         if (!var2.a(var10, var5, var1)) {
            return false;
         } else {
            cj var11 = var10.a();
            boolean var12 = !var3.d(var10) && !var3.p(var10).c().a(var3, var10);
            var12 |= !var3.d(var11) && !var3.p(var11).c().a(var3, var11);
            if (var12) {
               return false;
            } else {
               double var13 = (double)var10.n();
               double var15 = (double)var10.o();
               double var17 = (double)var10.p();
               List var19 = var3.b((pk)null, (aug)aug.a(var13, var15, var17, var13 + 1.0D, var15 + 2.0D, var17 + 1.0D));
               if (var19.size() > 0) {
                  return false;
               } else {
                  if (!var3.D) {
                     var3.g(var10);
                     var3.g(var11);
                     um var20 = new um(var3, var13 + 0.5D, var15, var17 + 0.5D);
                     float var21 = (float)ns.d((ns.g(var2.y - 180.0F) + 22.5F) / 45.0F) * 45.0F;
                     var20.b(var13 + 0.5D, var15, var17 + 0.5D, var21, 0.0F);
                     this.a(var20, var3.s);
                     dn var22 = var1.o();
                     if (var22 != null && var22.b("EntityTag", 10)) {
                        dn var23 = new dn();
                        var20.d(var23);
                        var23.a(var22.m("EntityTag"));
                        var20.f(var23);
                     }

                     var3.d((pk)var20);
                  }

                  --var1.b;
                  return true;
               }
            }
         }
      }
   }

   private void a(um var1, Random var2) {
      dc var3 = var1.t();
      float var5 = var2.nextFloat() * 5.0F;
      float var6 = var2.nextFloat() * 20.0F - 10.0F;
      dc var4 = new dc(var3.b() + var5, var3.c() + var6, var3.d());
      var1.a(var4);
      var3 = var1.u();
      var5 = var2.nextFloat() * 10.0F - 5.0F;
      var4 = new dc(var3.b(), var3.c() + var5, var3.d());
      var1.b(var4);
   }
}
