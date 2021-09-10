package net.optifine.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class IteratorCache {
   private static Deque<IteratorCache.IteratorReusable<Object>> dequeIterators = new ArrayDeque();

   private static void finished(IteratorCache.IteratorReusable<Object> var0) {
      synchronized(dequeIterators) {
         if (dequeIterators.size() <= 1000) {
            var0.setList((List)null);
            dequeIterators.addLast(var0);
         }

      }
   }

   public static Iterator<Object> getReadOnly(List var0) {
      synchronized(dequeIterators) {
         Object var2 = (IteratorCache.IteratorReusable)dequeIterators.pollFirst();
         if (var2 == null) {
            var2 = new IteratorCache.IteratorReadOnly();
         }

         ((IteratorCache.IteratorReusable)var2).setList(var0);
         return (Iterator)var2;
      }
   }

   static {
      for(int var0 = 0; var0 < 1000; ++var0) {
         IteratorCache.IteratorReadOnly var1 = new IteratorCache.IteratorReadOnly();
         dequeIterators.add(var1);
      }

   }

   static void access$0(IteratorCache.IteratorReusable var0) {
      finished(var0);
   }

   public interface IteratorReusable<E> extends Iterator<E> {
      void setList(List<E> var1);
   }

   public static class IteratorReadOnly implements IteratorCache.IteratorReusable<Object> {
      private int index;
      private boolean hasNext;
      private List<Object> list;

      public void remove() {
         throw new UnsupportedOperationException("remove");
      }

      public boolean hasNext() {
         if (!this.hasNext) {
            IteratorCache.access$0(this);
            return false;
         } else {
            return this.hasNext;
         }
      }

      public void setList(List<Object> var1) {
         if (this.hasNext) {
            throw new RuntimeException("Iterator still used, oldList: " + this.list + ", newList: " + var1);
         } else {
            this.list = var1;
            this.index = 0;
            this.hasNext = var1 != null && this.index < var1.size();
         }
      }

      public Object next() {
         if (!this.hasNext) {
            return null;
         } else {
            Object var1 = this.list.get(this.index);
            ++this.index;
            this.hasNext = this.index < this.list.size();
            return var1;
         }
      }
   }
}
