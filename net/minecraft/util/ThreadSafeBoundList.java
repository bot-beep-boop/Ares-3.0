package net.minecraft.util;

import java.lang.reflect.Array;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadSafeBoundList<T> {
   private int field_152762_d;
   private final T[] field_152759_a;
   private final Class<? extends T> field_152760_b;
   private int field_152763_e;
   private final ReadWriteLock field_152761_c = new ReentrantReadWriteLock();

   public T[] func_152756_c() {
      Object[] var1 = (Object[])Array.newInstance(this.field_152760_b, this.field_152762_d);
      this.field_152761_c.readLock().lock();

      for(int var2 = 0; var2 < this.field_152762_d; ++var2) {
         int var3 = (this.field_152763_e - this.field_152762_d + var2) % this.func_152758_b();
         if (var3 < 0) {
            var3 += this.func_152758_b();
         }

         var1[var2] = this.field_152759_a[var3];
      }

      this.field_152761_c.readLock().unlock();
      return var1;
   }

   public int func_152758_b() {
      this.field_152761_c.readLock().lock();
      int var1 = this.field_152759_a.length;
      this.field_152761_c.readLock().unlock();
      return var1;
   }

   public ThreadSafeBoundList(Class<? extends T> var1, int var2) {
      this.field_152760_b = var1;
      this.field_152759_a = (Object[])Array.newInstance(var1, var2);
   }

   public T func_152757_a(T var1) {
      this.field_152761_c.writeLock().lock();
      this.field_152759_a[this.field_152763_e] = var1;
      this.field_152763_e = (this.field_152763_e + 1) % this.func_152758_b();
      if (this.field_152762_d < this.func_152758_b()) {
         ++this.field_152762_d;
      }

      this.field_152761_c.writeLock().unlock();
      return var1;
   }
}
