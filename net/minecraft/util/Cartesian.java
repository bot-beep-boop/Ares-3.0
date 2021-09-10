package net.minecraft.util;

import com.google.common.base.Function;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Cartesian {
   public static <T> Iterable<T[]> cartesianProduct(Class<T> var0, Iterable<? extends Iterable<? extends T>> var1) {
      return new Cartesian.Product(var0, (Iterable[])toArray(Iterable.class, var1), (Cartesian.Product)null);
   }

   private static <T> Iterable<List<T>> arraysAsLists(Iterable<Object[]> var0) {
      return Iterables.transform(var0, new Cartesian.GetList((Cartesian.GetList)null));
   }

   static Object[] access$0(Class var0, int var1) {
      return createArray(var0, var1);
   }

   public static <T> Iterable<List<T>> cartesianProduct(Iterable<? extends Iterable<? extends T>> var0) {
      return arraysAsLists(cartesianProduct(Object.class, var0));
   }

   private static <T> T[] toArray(Class<? super T> var0, Iterable<? extends T> var1) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Object var3 = (Object)var4.next();
         var2.add(var3);
      }

      return var2.toArray(createArray(var0, var2.size()));
   }

   private static <T> T[] createArray(Class<? super T> var0, int var1) {
      return (Object[])Array.newInstance(var0, var1);
   }

   static class Product<T> implements Iterable<T[]> {
      private final Class<T> clazz;
      private final Iterable<? extends T>[] iterables;

      Product(Class var1, Iterable[] var2, Cartesian.Product var3) {
         this(var1, var2);
      }

      private Product(Class<T> var1, Iterable<? extends T>[] var2) {
         this.clazz = var1;
         this.iterables = var2;
      }

      public Iterator<T[]> iterator() {
         return (Iterator)(this.iterables.length <= 0 ? Collections.singletonList(Cartesian.access$0(this.clazz, 0)).iterator() : new Cartesian.Product.ProductIterator(this.clazz, this.iterables, (Cartesian.Product.ProductIterator)null));
      }

      static class ProductIterator<T> extends UnmodifiableIterator<T[]> {
         private int index;
         private final Iterable<? extends T>[] iterables;
         private final Iterator<? extends T>[] iterators;
         private final T[] results;

         public boolean hasNext() {
            Iterator var1;
            if (this.index == -2) {
               this.index = 0;
               Iterator[] var4;
               int var3 = (var4 = this.iterators).length;

               for(int var2 = 0; var2 < var3; ++var2) {
                  var1 = var4[var2];
                  if (!var1.hasNext()) {
                     this.endOfData();
                     break;
                  }
               }

               return true;
            } else {
               if (this.index >= this.iterators.length) {
                  for(this.index = this.iterators.length - 1; this.index >= 0; --this.index) {
                     var1 = this.iterators[this.index];
                     if (var1.hasNext()) {
                        break;
                     }

                     if (this.index == 0) {
                        this.endOfData();
                        break;
                     }

                     var1 = this.iterables[this.index].iterator();
                     this.iterators[this.index] = var1;
                     if (!var1.hasNext()) {
                        this.endOfData();
                        break;
                     }
                  }
               }

               return this.index >= 0;
            }
         }

         private ProductIterator(Class<T> var1, Iterable<? extends T>[] var2) {
            this.index = -2;
            this.iterables = var2;
            this.iterators = (Iterator[])Cartesian.access$0(Iterator.class, this.iterables.length);

            for(int var3 = 0; var3 < this.iterables.length; ++var3) {
               this.iterators[var3] = var2[var3].iterator();
            }

            this.results = Cartesian.access$0(var1, this.iterators.length);
         }

         public Object next() {
            return this.next();
         }

         private void endOfData() {
            this.index = -1;
            Arrays.fill(this.iterators, (Object)null);
            Arrays.fill(this.results, (Object)null);
         }

         ProductIterator(Class var1, Iterable[] var2, Cartesian.Product.ProductIterator var3) {
            this(var1, var2);
         }

         public T[] next() {
            if (!this.hasNext()) {
               throw new NoSuchElementException();
            } else {
               while(this.index < this.iterators.length) {
                  this.results[this.index] = this.iterators[this.index].next();
                  ++this.index;
               }

               return (Object[])this.results.clone();
            }
         }
      }
   }

   static class GetList<T> implements Function<Object[], List<T>> {
      GetList(Cartesian.GetList var1) {
         this();
      }

      public List<T> apply(Object[] var1) {
         return Arrays.asList(var1);
      }

      public Object apply(Object var1) {
         return this.apply((Object[])var1);
      }

      private GetList() {
      }
   }
}
