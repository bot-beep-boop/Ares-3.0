import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public abstract class qf {
   protected final Map<qb, qc> a = Maps.newHashMap();
   protected final Map<String, qc> b = new nk();
   protected final Multimap<qb, qb> c = HashMultimap.create();

   public void a(qc var1) {
   }

   public void b(Multimap<String, qd> var1) {
      Iterator var2 = var1.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         qc var4 = this.a((String)var3.getKey());
         if (var4 != null) {
            var4.c((qd)var3.getValue());
            var4.b((qd)var3.getValue());
         }
      }

   }

   public Collection<qc> a() {
      return this.b.values();
   }

   public void a(Multimap<String, qd> var1) {
      Iterator var2 = var1.entries().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         qc var4 = this.a((String)var3.getKey());
         if (var4 != null) {
            var4.c((qd)var3.getValue());
         }
      }

   }

   protected abstract qc c(qb var1);

   public qc a(qb var1) {
      return (qc)this.a.get(var1);
   }

   public qc a(String var1) {
      return (qc)this.b.get(var1);
   }

   public qc b(qb var1) {
      if (this.b.containsKey(var1.a())) {
         throw new IllegalArgumentException("Attribute is already registered!");
      } else {
         qc var2 = this.c(var1);
         this.b.put(var1.a(), var2);
         this.a.put(var1, var2);

         for(qb var3 = var1.d(); var3 != null; var3 = var3.d()) {
            this.c.put(var3, var1);
         }

         return var2;
      }
   }
}
