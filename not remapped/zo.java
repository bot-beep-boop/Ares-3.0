import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

public class zo extends zw {
   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      if (!var3.D) {
         wt var9 = new wt(var3, (double)((float)var4.n() + var6), (double)((float)var4.o() + var7), (double)((float)var4.p() + var8), var1);
         var3.d((pk)var9);
         if (!var2.bA.d) {
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }

   public void a(zx var1, wn var2, List<String> var3, boolean var4) {
      if (var1.n()) {
         dn var5 = var1.o().m("Fireworks");
         if (var5 != null) {
            if (var5.b("Flight", 99)) {
               var3.add(di.a("item.fireworks.flight") + " " + var5.d("Flight"));
            }

            du var6 = var5.c("Explosions", 10);
            if (var6 != null && var6.c() > 0) {
               for(int var7 = 0; var7 < var6.c(); ++var7) {
                  dn var8 = var6.b(var7);
                  ArrayList var9 = Lists.newArrayList();
                  zn.a((dn)var8, (List)var9);
                  if (var9.size() > 0) {
                     for(int var10 = 1; var10 < var9.size(); ++var10) {
                        var9.set(var10, "  " + (String)var9.get(var10));
                     }

                     var3.addAll(var9);
                  }
               }
            }

         }
      }
   }
}
