import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public class aak extends zw {
   private static final Map<String, aak> b = Maps.newHashMap();
   public final String a;

   protected aak(String var1) {
      this.a = var1;
      this.h = 1;
      this.a(yz.f);
      b.put("records." + var1, this);
   }

   public aaj g(zx var1) {
      return aaj.c;
   }

   public static aak b(String var0) {
      return (aak)b.get(var0);
   }

   public boolean a(zx var1, wn var2, adm var3, cj var4, cq var5, float var6, float var7, float var8) {
      alz var9 = var3.p(var4);
      if (var9.c() == afi.aN && !(Boolean)var9.b(ahq.a)) {
         if (var3.D) {
            return true;
         } else {
            ((ahq)afi.aN).a(var3, var4, var9, var1);
            var3.a((wn)null, 1005, var4, zw.b((zw)this));
            --var1.b;
            var2.b(na.X);
            return true;
         }
      } else {
         return false;
      }
   }

   public void a(zx var1, wn var2, List<String> var3, boolean var4) {
      var3.add(this.g());
   }

   public String g() {
      return di.a("item.record." + this.a + ".desc");
   }
}
