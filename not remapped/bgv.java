import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class bgv {
   private Map<afh, bgy> a = Maps.newIdentityHashMap();
   private Set<afh> b = Sets.newIdentityHashSet();

   public Map<alz, bov> a() {
      IdentityHashMap var1 = Maps.newIdentityHashMap();
      Iterator var2 = afh.c.iterator();

      while(var2.hasNext()) {
         afh var3 = (afh)var2.next();
         if (!this.b.contains(var3)) {
            var1.putAll(((bgy)Objects.firstNonNull(this.a.get(var3), new bgw())).a(var3));
         }
      }

      return var1;
   }

   public void a(afh... var1) {
      Collections.addAll(this.b, var1);
   }

   public void a(afh var1, bgy var2) {
      this.a.put(var1, var2);
   }
}
