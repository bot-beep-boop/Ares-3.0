import java.lang.reflect.Array;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class np<T> {
   private int e;
   private final Class<? extends T> b;
   private final ReadWriteLock c = new ReentrantReadWriteLock();
   private int d;
   private final T[] a;

   public T a(T var1) {
      this.c.writeLock().lock();
      this.a[this.e] = var1;
      this.e = (this.e + 1) % this.b();
      if (this.d < this.b()) {
         ++this.d;
      }

      this.c.writeLock().unlock();
      return var1;
   }

   public int b() {
      this.c.readLock().lock();
      int var1 = this.a.length;
      this.c.readLock().unlock();
      return var1;
   }

   public np(Class<? extends T> var1, int var2) {
      this.b = var1;
      this.a = (Object[])((Object[])Array.newInstance(var1, var2));
   }

   public T[] c() {
      Object[] var1 = (Object[])((Object[])Array.newInstance(this.b, this.d));
      this.c.readLock().lock();

      for(int var2 = 0; var2 < this.d; ++var2) {
         int var3 = (this.e - this.d + var2) % this.b();
         if (var3 < 0) {
            var3 += this.b();
         }

         var1[var2] = this.a[var3];
      }

      this.c.readLock().unlock();
      return var1;
   }
}
