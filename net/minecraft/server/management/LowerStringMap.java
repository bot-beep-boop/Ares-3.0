package net.minecraft.server.management;

import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class LowerStringMap<V> implements Map<String, V> {
   private final Map<String, V> internalMap = Maps.newLinkedHashMap();

   public int size() {
      return this.internalMap.size();
   }

   public boolean containsValue(Object var1) {
      return this.internalMap.containsKey(var1);
   }

   public Collection<V> values() {
      return this.internalMap.values();
   }

   public Set<String> keySet() {
      return this.internalMap.keySet();
   }

   public V get(Object var1) {
      return this.internalMap.get(var1.toString().toLowerCase());
   }

   public V put(String var1, V var2) {
      return this.internalMap.put(var1.toLowerCase(), var2);
   }

   public boolean isEmpty() {
      return this.internalMap.isEmpty();
   }

   public Set<Entry<String, V>> entrySet() {
      return this.internalMap.entrySet();
   }

   public void clear() {
      this.internalMap.clear();
   }

   public Object put(Object var1, Object var2) {
      return this.put((String)var1, (Object)var2);
   }

   public V remove(Object var1) {
      return this.internalMap.remove(var1.toString().toLowerCase());
   }

   public boolean containsKey(Object var1) {
      return this.internalMap.containsKey(var1.toString().toLowerCase());
   }

   public void putAll(Map<? extends String, ? extends V> var1) {
      Iterator var3 = var1.entrySet().iterator();

      while(var3.hasNext()) {
         Entry var2 = (Entry)var3.next();
         this.put((String)var2.getKey(), var2.getValue());
      }

   }
}
