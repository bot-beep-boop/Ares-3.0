import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class amh implements Predicate<alz> {
   private final Map<amo, Predicate> b = Maps.newHashMap();
   private final ama a;

   private amh(ama var1) {
      this.a = var1;
   }

   public boolean a(alz var1) {
      if (var1 != null && var1.c().equals(this.a.c())) {
         Iterator var2 = this.b.entrySet().iterator();

         Entry var3;
         Comparable var4;
         do {
            if (!var2.hasNext()) {
               return true;
            }

            var3 = (Entry)var2.next();
            var4 = var1.b((amo)var3.getKey());
         } while(((Predicate)var3.getValue()).apply(var4));

         return false;
      } else {
         return false;
      }
   }

   public static amh a(afh var0) {
      return new amh(var0.P());
   }

   public boolean apply(Object var1) {
      return this.a((alz)var1);
   }

   public <V extends Comparable<V>> amh a(amo<V> var1, Predicate<? extends V> var2) {
      if (!this.a.d().contains(var1)) {
         throw new IllegalArgumentException(this.a + " cannot support property " + var1);
      } else {
         this.b.put(var1, var2);
         return this;
      }
   }
}
