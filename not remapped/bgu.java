import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class bgu implements bgy {
   protected Map<alz, bov> b = Maps.newLinkedHashMap();

   public String a(Map<amo, Comparable> var1) {
      StringBuilder var2 = new StringBuilder();
      Iterator var3 = var1.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         if (var2.length() != 0) {
            var2.append(",");
         }

         amo var5 = (amo)var4.getKey();
         Comparable var6 = (Comparable)var4.getValue();
         var2.append(var5.a());
         var2.append("=");
         var2.append(var5.a(var6));
      }

      if (var2.length() == 0) {
         var2.append("normal");
      }

      return var2.toString();
   }

   public Map<alz, bov> a(afh var1) {
      Iterator var2 = var1.P().a().iterator();

      while(var2.hasNext()) {
         alz var3 = (alz)var2.next();
         this.b.put(var3, this.a(var3));
      }

      return this.b;
   }

   protected abstract bov a(alz var1);
}
