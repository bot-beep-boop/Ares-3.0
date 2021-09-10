import java.util.Iterator;
import java.util.List;

public class zz extends zw {
   public static boolean a(wn var0, adm var1, cj var2) {
      up var3 = up.b(var1, var2);
      boolean var4 = false;
      double var5 = 7.0D;
      int var7 = var2.n();
      int var8 = var2.o();
      int var9 = var2.p();
      List var10 = var1.a(ps.class, new aug((double)var7 - var5, (double)var8 - var5, (double)var9 - var5, (double)var7 + var5, (double)var8 + var5, (double)var9 + var5));
      Iterator var11 = var10.iterator();

      while(var11.hasNext()) {
         ps var12 = (ps)var11.next();
         if (var12.cc() && var12.cd() == var0) {
            if (var3 == null) {
               var3 = up.a(var1, var2);
            }

            var12.a(var3, true);
            var4 = true;
         }
      }

      return var4;
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      afh var9 = var3.p(var4).c();
      if (var9 instanceof agt) {
         if (var3.D) {
            return true;
         } else {
            a(var2, var3, var4);
            return true;
         }
      } else {
         return false;
      }
   }

   public zz() {
      this.a(yz.i);
   }
}
