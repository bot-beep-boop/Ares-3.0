import com.google.common.collect.Lists;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bhp implements Runnable {
   private final bfg c;
   private static final Logger a = LogManager.getLogger();
   private final bho b;

   static void a(bhp var0, bhn var1) {
      var0.b(var1);
   }

   protected void a(bhn var1) throws InterruptedException {
      var1.f().lock();

      try {
         if (var1.a() != bhn.a.a) {
            if (!var1.h()) {
               a.warn("Chunk render task was " + var1.a() + " when I expected it to be pending; ignoring task");
            }

            return;
         }

         var1.a(bhn.a.b);
      } finally {
         var1.f().unlock();
      }

      pk var2 = ave.A().ac();
      if (var2 == null) {
         var1.e();
      } else {
         var1.a(this.b());
         float var3 = (float)var2.s;
         float var4 = (float)var2.t + var2.aS();
         float var5 = (float)var2.u;
         bhn.b var6 = var1.g();
         if (var6 == bhn.b.a) {
            var1.b().b(var3, var4, var5, var1);
         } else if (var6 == bhn.b.b) {
            var1.b().a(var3, var4, var5, var1);
         }

         var1.f().lock();

         label247: {
            try {
               if (var1.a() == bhn.a.b) {
                  var1.a(bhn.a.c);
                  break label247;
               }

               if (!var1.h()) {
                  a.warn("Chunk render task was " + var1.a() + " when I expected it to be compiling; aborting task");
               }

               this.b(var1);
            } finally {
               var1.f().unlock();
            }

            return;
         }

         bhq var7 = var1.c();
         ArrayList var8 = Lists.newArrayList();
         if (var6 == bhn.b.a) {
            adf[] var9 = adf.values();
            int var10 = var9.length;

            for(int var11 = 0; var11 < var10; ++var11) {
               adf var12 = var9[var11];
               if (var7.d(var12)) {
                  var8.add(this.b.a(var12, var1.d().a(var12), var1.b(), var7));
               }
            }
         } else if (var6 == bhn.b.b) {
            var8.add(this.b.a(adf.d, var1.d().a(adf.d), var1.b(), var7));
         }

         ListenableFuture var19 = Futures.allAsList(var8);
         var1.a(new Runnable(this, var19) {
            final bhp b;
            final ListenableFuture a;

            {
               this.b = var1;
               this.a = var2;
            }

            public void run() {
               this.a.cancel(false);
            }
         });
         Futures.addCallback(var19, new FutureCallback<List<Object>>(this, var1, var7) {
            final bhq b;
            final bhn a;
            final bhp c;

            public void a(List<Object> var1) {
               bhp.a(this.c, this.a);
               this.a.f().lock();

               try {
                  if (this.a.a() != bhn.a.c) {
                     if (!this.a.h()) {
                        bhp.a().warn("Chunk render task was " + this.a.a() + " when I expected it to be uploading; aborting task");
                     }

                     return;
                  }

                  this.a.a(bhn.a.d);
               } finally {
                  this.a.f().unlock();
               }

               this.a.b().a(this.b);
            }

            {
               this.c = var1;
               this.a = var2;
               this.b = var3;
            }

            public void onFailure(Throwable var1) {
               bhp.a(this.c, this.a);
               if (!(var1 instanceof CancellationException) && !(var1 instanceof InterruptedException)) {
                  ave.A().a(b.a(var1, "Rendering chunk"));
               }

            }

            public void onSuccess(Object var1) {
               this.a((List)var1);
            }
         });
      }
   }

   private bfg b() throws InterruptedException {
      return this.c != null ? this.c : this.b.c();
   }

   public bhp(bho var1) {
      this(var1, (bfg)null);
   }

   private void b(bhn var1) {
      if (this.c == null) {
         this.b.a(var1.d());
      }

   }

   public bhp(bho var1, bfg var2) {
      this.b = var1;
      this.c = var2;
   }

   public void run() {
      while(true) {
         try {
            this.a(this.b.d());
         } catch (InterruptedException var3) {
            a.debug("Stopping due to interrupt");
            return;
         } catch (Throwable var4) {
            b var2 = b.a(var4, "Batching chunks");
            ave.A().a(ave.A().b(var2));
            return;
         }
      }
   }

   static Logger a() {
      return a;
   }
}
