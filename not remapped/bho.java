import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.opengl.GL11;

public class bho {
   private final BlockingQueue<bhn> d = Queues.newArrayBlockingQueue(100);
   private final bhp i;
   private final Queue<ListenableFutureTask<?>> h = Queues.newArrayDeque();
   private final List<bhp> c = Lists.newArrayList();
   private static final Logger a = LogManager.getLogger();
   private static final ThreadFactory b = (new ThreadFactoryBuilder()).setNameFormat("Chunk Batcher %d").setDaemon(true).build();
   private final bfe f = new bfe();
   private final bfz g = new bfz();
   private final BlockingQueue<bfg> e = Queues.newArrayBlockingQueue(5);

   public ListenableFuture<Object> a(adf var1, bfd var2, bht var3, bhq var4) {
      if (ave.A().aJ()) {
         if (bqs.f()) {
            this.a(var2, var3.b(var1.ordinal()));
         } else {
            this.a(var2, ((bhs)var3).a(var1, var4), var3);
         }

         var2.c(0.0D, 0.0D, 0.0D);
         return Futures.immediateFuture((Object)null);
      } else {
         ListenableFutureTask var5 = ListenableFutureTask.create(new Runnable(this, var1, var2, var3, var4) {
            final adf a;
            final bhq d;
            final bht c;
            final bho e;
            final bfd b;

            {
               this.e = var1;
               this.a = var2;
               this.b = var3;
               this.c = var4;
               this.d = var5;
            }

            public void run() {
               this.e.a(this.a, this.b, this.c, this.d);
            }
         }, (Object)null);
         synchronized(this.h) {
            this.h.add(var5);
            return var5;
         }
      }
   }

   public bfg c() throws InterruptedException {
      return (bfg)this.e.take();
   }

   private void a(bfd var1, int var2, bht var3) {
      GL11.glNewList(var2, 4864);
      bfl.E();
      var3.f();
      this.f.a(var1);
      bfl.F();
      GL11.glEndList();
   }

   public bhn d() throws InterruptedException {
      return (bhn)this.d.take();
   }

   public boolean c(bht var1) {
      var1.c().lock();

      boolean var3;
      try {
         bhn var2 = var1.e();
         if (var2 != null) {
            var2.a(new Runnable(this, var2) {
               final bho b;
               final bhn a;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public void run() {
                  bho.a(this.b).remove(this.a);
               }
            });
            var3 = this.d.offer(var2);
            return var3;
         }

         var3 = true;
      } finally {
         var1.c().unlock();
      }

      return var3;
   }

   public boolean a(bht var1) {
      var1.c().lock();

      boolean var4;
      try {
         bhn var2 = var1.d();
         var2.a(new Runnable(this, var2) {
            final bho b;
            final bhn a;

            {
               this.b = var1;
               this.a = var2;
            }

            public void run() {
               bho.a(this.b).remove(this.a);
            }
         });
         boolean var3 = this.d.offer(var2);
         if (!var3) {
            var2.e();
         }

         var4 = var3;
      } finally {
         var1.c().unlock();
      }

      return var4;
   }

   public String a() {
      return String.format("pC: %03d, pU: %1d, aB: %1d", this.d.size(), this.h.size(), this.e.size());
   }

   public bho() {
      int var1;
      for(var1 = 0; var1 < 2; ++var1) {
         bhp var2 = new bhp(this);
         Thread var3 = b.newThread(var2);
         var3.start();
         this.c.add(var2);
      }

      for(var1 = 0; var1 < 5; ++var1) {
         this.e.add(new bfg());
      }

      this.i = new bhp(this, new bfg());
   }

   public boolean a(long var1) {
      boolean var3 = false;

      long var5;
      do {
         boolean var4 = false;
         synchronized(this.h) {
            if (!this.h.isEmpty()) {
               ((ListenableFutureTask)this.h.poll()).run();
               var4 = true;
               var3 = true;
            }
         }

         if (var1 == 0L || !var4) {
            break;
         }

         var5 = var1 - System.nanoTime();
      } while(var5 >= 0L);

      return var3;
   }

   public void b() {
      this.e();

      while(this.a(0L)) {
      }

      ArrayList var1 = Lists.newArrayList();

      while(var1.size() != 5) {
         try {
            var1.add(this.c());
         } catch (InterruptedException var3) {
         }
      }

      this.e.addAll(var1);
   }

   public boolean b(bht var1) {
      var1.c().lock();

      boolean var3;
      try {
         bhn var2 = var1.d();

         try {
            this.i.a(var2);
         } catch (InterruptedException var7) {
         }

         var3 = true;
      } finally {
         var1.c().unlock();
      }

      return var3;
   }

   public void a(bfg var1) {
      this.e.add(var1);
   }

   private void a(bfd var1, bmt var2) {
      this.g.a(var2);
      this.g.a(var1);
   }

   static BlockingQueue a(bho var0) {
      return var0.d;
   }

   public void e() {
      while(!this.d.isEmpty()) {
         bhn var1 = (bhn)this.d.poll();
         if (var1 != null) {
            var1.e();
         }
      }

   }
}
