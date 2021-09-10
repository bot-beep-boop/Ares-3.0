package net.minecraft.util;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.Iterator;
import java.util.Map;

public class RegistryNamespaced<K, V> extends RegistrySimple<K, V> implements IObjectIntIterable<V> {
   protected final Map<V, K> inverseObjectRegistry;
   protected final ObjectIntIdentityMap<V> underlyingIntegerMap = new ObjectIntIdentityMap();

   public Iterator<V> iterator() {
      return this.underlyingIntegerMap.iterator();
   }

   public boolean containsKey(K var1) {
      return super.containsKey(var1);
   }

   public int getIDForObject(V var1) {
      return this.underlyingIntegerMap.get(var1);
   }

   public RegistryNamespaced() {
      this.inverseObjectRegistry = ((BiMap)this.registryObjects).inverse();
   }

   public V getObject(K var1) {
      return super.getObject(var1);
   }

   public void register(int var1, K var2, V var3) {
      this.underlyingIntegerMap.put(var3, var1);
      this.putObject(var2, var3);
   }

   public V getObjectById(int var1) {
      return this.underlyingIntegerMap.getByValue(var1);
   }

   protected Map<K, V> createUnderlyingMap() {
      return HashBiMap.create();
   }

   public K getNameForObject(V var1) {
      return this.inverseObjectRegistry.get(var1);
   }
}
