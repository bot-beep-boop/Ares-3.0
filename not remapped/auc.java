import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;

public class auc implements Runnable {
   private long d;
   private List<aud> b = Collections.synchronizedList(Lists.newArrayList());
   private long c;
   private static final auc a = new auc();
   private boolean e;

   public void a(aud var1) {
      if (!this.b.contains(var1)) {
         ++this.c;
         this.b.add(var1);
      }
   }

   public static auc a() {
      return a;
   }

   private void c() {
      for(int var1 = 0; var1 < this.b.size(); ++var1) {
         aud var2 = (aud)this.b.get(var1);
         boolean var3 = var2.c();
         if (!var3) {
            this.b.remove(var1--);
            ++this.d;
         }

         try {
            Thread.sleep(this.e ? 0L : 10L);
         } catch (InterruptedException var6) {
            var6.printStackTrace();
         }
      }

      if (this.b.isEmpty()) {
         try {
            Thread.sleep(25L);
         } catch (InterruptedException var5) {
            var5.printStackTrace();
         }
      }

   }

   public void run() {
      while(true) {
         this.c();
      }
   }

   private auc() {
      Thread var1 = new Thread(this, "File IO Thread");
      var1.setPriority(1);
      var1.start();
   }

   public void b() throws InterruptedException {
      this.e = true;

      while(this.c != this.d) {
         Thread.sleep(10L);
      }

      this.e = false;
   }
}
