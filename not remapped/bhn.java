import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class bhn {
   private bhq f;
   private final bht a;
   private boolean h;
   private final ReentrantLock b = new ReentrantLock();
   private bhn.a g;
   private final bhn.b d;
   private final List<Runnable> c = Lists.newArrayList();
   private bfg e;

   public bhn.a a() {
      return this.g;
   }

   public void a(Runnable var1) {
      this.b.lock();

      try {
         this.c.add(var1);
         if (this.h) {
            var1.run();
         }
      } finally {
         this.b.unlock();
      }

   }

   public void e() {
      this.b.lock();

      try {
         if (this.d == bhn.b.a && this.g != bhn.a.d) {
            this.a.a(true);
         }

         this.h = true;
         this.g = bhn.a.d;
         Iterator var1 = this.c.iterator();

         while(var1.hasNext()) {
            Runnable var2 = (Runnable)var1.next();
            var2.run();
         }
      } finally {
         this.b.unlock();
      }

   }

   public boolean h() {
      return this.h;
   }

   public ReentrantLock f() {
      return this.b;
   }

   public void a(bhn.a var1) {
      this.b.lock();

      try {
         this.g = var1;
      } finally {
         this.b.unlock();
      }

   }

   public bhn(bht var1, bhn.b var2) {
      this.g = bhn.a.a;
      this.a = var1;
      this.d = var2;
   }

   public void a(bfg var1) {
      this.e = var1;
   }

   public bhn.b g() {
      return this.d;
   }

   public void a(bhq var1) {
      this.f = var1;
   }

   public bfg d() {
      return this.e;
   }

   public bhq c() {
      return this.f;
   }

   public bht b() {
      return this.a;
   }

   public static enum b {
      private static final bhn.b[] c = new bhn.b[]{a, b};
      a,
      b;
   }

   public static enum a {
      c,
      a,
      d;

      private static final bhn.a[] e = new bhn.a[]{a, b, c, d};
      b;
   }
}
