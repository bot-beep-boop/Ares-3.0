package net.minecraft.util;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.optifine.util.IteratorCache;

public class ClassInheritanceMultiMap<T> extends AbstractSet<T> {
   private final Class<T> baseClass;
   public boolean empty;
   private final Set<Class<?>> knownKeys = Sets.newIdentityHashSet();
   private final List<T> values = Lists.newArrayList();
   private final Map<Class<?>, List<T>> map = Maps.newHashMap();
   private static final Set<Class<?>> field_181158_a = Collections.newSetFromMap(new ConcurrentHashMap());

   protected Class<?> initializeClassLookup(Class<?> var1) {
      if (this.baseClass.isAssignableFrom(var1)) {
         if (!this.knownKeys.contains(var1)) {
            this.createLookup(var1);
         }

         return var1;
      } else {
         throw new IllegalArgumentException("Don't know how to search for " + var1);
      }
   }

   public boolean add(T var1) {
      Iterator var3 = this.knownKeys.iterator();

      while(var3.hasNext()) {
         Class var2 = (Class)var3.next();
         if (var2.isAssignableFrom(var1.getClass())) {
            this.addForClass(var1, var2);
         }
      }

      this.empty = this.values.size() == 0;
      return true;
   }

   public boolean remove(Object var1) {
      Object var2 = var1;
      boolean var3 = false;
      Iterator var5 = this.knownKeys.iterator();

      while(var5.hasNext()) {
         Class var4 = (Class)var5.next();
         if (var4.isAssignableFrom(var2.getClass())) {
            List var6 = (List)this.map.get(var4);
            if (var6 != null && var6.remove(var2)) {
               var3 = true;
            }
         }
      }

      this.empty = this.values.size() == 0;
      return var3;
   }

   public ClassInheritanceMultiMap(Class<T> var1) {
      this.baseClass = var1;
      this.knownKeys.add(var1);
      this.map.put(var1, this.values);
      Iterator var3 = field_181158_a.iterator();

      while(var3.hasNext()) {
         Class var2 = (Class)var3.next();
         this.createLookup(var2);
      }

      this.empty = this.values.size() == 0;
   }

   private void addForClass(T var1, Class<?> var2) {
      List var3 = (List)this.map.get(var2);
      if (var3 == null) {
         this.map.put(var2, Lists.newArrayList(new Object[]{var1}));
      } else {
         var3.add(var1);
      }

      this.empty = this.values.size() == 0;
   }

   public <S> Iterable<S> getByClass(Class<S> var1) {
      return new Iterable<S>(this, var1) {
         private final Class val$clazz;
         final ClassInheritanceMultiMap this$0;

         public Iterator<S> iterator() {
            List var1 = (List)ClassInheritanceMultiMap.access$0(this.this$0).get(this.this$0.initializeClassLookup(this.val$clazz));
            if (var1 == null) {
               return Iterators.emptyIterator();
            } else {
               Iterator var2 = var1.iterator();
               return Iterators.filter(var2, this.val$clazz);
            }
         }

         {
            this.this$0 = var1;
            this.val$clazz = var2;
         }
      };
   }

   public boolean isEmpty() {
      return this.empty;
   }

   public int size() {
      return this.values.size();
   }

   public boolean contains(Object var1) {
      return Iterators.contains(this.getByClass(var1.getClass()).iterator(), var1);
   }

   public Iterator<T> iterator() {
      return (Iterator)(this.values.isEmpty() ? Iterators.emptyIterator() : IteratorCache.getReadOnly(this.values));
   }

   static Map access$0(ClassInheritanceMultiMap var0) {
      return var0.map;
   }

   protected void createLookup(Class<?> var1) {
      field_181158_a.add(var1);
      int var2 = this.values.size();

      for(int var3 = 0; var3 < var2; ++var3) {
         Object var4 = this.values.get(var3);
         if (var1.isAssignableFrom(var4.getClass())) {
            this.addForClass(var4, var1);
         }
      }

      this.knownKeys.add(var1);
   }
}
