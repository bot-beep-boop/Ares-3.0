package net.optifine.util;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class ArrayCache {
   private int maxCacheSize = 0;
   private ArrayDeque cache = new ArrayDeque();
   private Class elementClass = null;

   public synchronized void free(Object var1) {
      if (var1 != null) {
         Class var2 = var1.getClass();
         if (var2.getComponentType() != this.elementClass) {
            throw new IllegalArgumentException("Wrong component type");
         }

         if (this.cache.size() < this.maxCacheSize) {
            this.cache.add(var1);
         }
      }

   }

   public synchronized Object allocate(int var1) {
      Object var2 = this.cache.pollLast();
      if (var2 == null || Array.getLength(var2) < var1) {
         var2 = Array.newInstance(this.elementClass, var1);
      }

      return var2;
   }

   public ArrayCache(Class var1, int var2) {
      this.elementClass = var1;
      this.maxCacheSize = var2;
   }
}
