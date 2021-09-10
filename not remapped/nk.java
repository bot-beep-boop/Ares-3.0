import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class nk<V> implements Map<String, V> {
   private final Map<String, V> a = Maps.newLinkedHashMap();

   public Set<String> keySet() {
      return this.a.keySet();
   }

   public void clear() {
      this.a.clear();
   }

   public Set<Entry<String, V>> entrySet() {
      return this.a.entrySet();
   }

   public Collection<V> values() {
      return this.a.values();
   }

   public Object put(Object var1, Object var2) {
      return this.a((String)var1, var2);
   }

   public boolean containsKey(Object var1) {
      return this.a.containsKey(var1.toString().toLowerCase());
   }

   public V remove(Object var1) {
      return this.a.remove(var1.toString().toLowerCase());
   }

   public void putAll(Map<? extends String, ? extends V> var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.a((String)var3.getKey(), var3.getValue());
      }

   }

   public boolean isEmpty() {
      return this.a.isEmpty();
   }

   public V a(String var1, V var2) {
      return this.a.put(var1.toLowerCase(), var2);
   }

   public V get(Object var1) {
      return this.a.get(var1.toString().toLowerCase());
   }

   public int size() {
      return this.a.size();
   }

   public boolean containsValue(Object var1) {
      return this.a.containsKey(var1);
   }
}
