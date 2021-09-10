package net.minecraft.util;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;

public class ObjectIntIdentityMap<T> implements IObjectIntIterable<T> {
   private final List<T> objectList = Lists.newArrayList();
   private final IdentityHashMap<T, Integer> identityMap = new IdentityHashMap(512);

   public final T getByValue(int var1) {
      return var1 >= 0 && var1 < this.objectList.size() ? this.objectList.get(var1) : null;
   }

   public void put(T var1, int var2) {
      this.identityMap.put(var1, var2);

      while(this.objectList.size() <= var2) {
         this.objectList.add((Object)null);
      }

      this.objectList.set(var2, var1);
   }

   public Iterator<T> iterator() {
      return Iterators.filter(this.objectList.iterator(), Predicates.notNull());
   }

   public int get(T var1) {
      Integer var2 = (Integer)this.identityMap.get(var1);
      return var2 == null ? -1 : var2;
   }
}
