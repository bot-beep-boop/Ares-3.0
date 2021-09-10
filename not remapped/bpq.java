import com.google.common.collect.Lists;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketTimeoutException;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bpq {
   private static final Logger b = LogManager.getLogger();
   private static final AtomicInteger a = new AtomicInteger(0);

   static Logger b() {
      return b;
   }

   static AtomicInteger a() {
      return a;
   }

   public static class a {
      private long c;
      private String b;
      private String a;

      public a(String var1, String var2) {
         this.a = var1;
         this.b = var2;
         this.c = ave.J();
      }

      public String a() {
         return this.a;
      }

      public String b() {
         return this.b;
      }

      public void c() {
         this.c = ave.J();
      }
   }

   public static class b extends Thread {
      private final InetAddress b;
      private final bpq.c a;
      private final MulticastSocket c;

      public void run() {
         byte[] var2 = new byte[1024];

         while(!this.isInterrupted()) {
            DatagramPacket var1 = new DatagramPacket(var2, var2.length);

            try {
               this.c.receive(var1);
            } catch (SocketTimeoutException var5) {
               continue;
            } catch (IOException var6) {
               bpq.b().error("Couldn't ping server", var6);
               break;
            }

            String var3 = new String(var1.getData(), var1.getOffset(), var1.getLength());
            bpq.b().debug(var1.getAddress() + ": " + var3);
            this.a.a(var3, var1.getAddress());
         }

         try {
            this.c.leaveGroup(this.b);
         } catch (IOException var4) {
         }

         this.c.close();
      }

      public b(bpq.c var1) throws IOException {
         super("LanServerDetector #" + bpq.a().incrementAndGet());
         this.a = var1;
         this.setDaemon(true);
         this.c = new MulticastSocket(4445);
         this.b = InetAddress.getByName("224.0.2.60");
         this.c.setSoTimeout(5000);
         this.c.joinGroup(this.b);
      }
   }

   public static class c {
      boolean a;
      private List<bpq.a> b = Lists.newArrayList();

      public synchronized void a(String var1, InetAddress var2) {
         String var3 = bpr.a(var1);
         String var4 = bpr.b(var1);
         if (var4 != null) {
            var4 = var2.getHostAddress() + ":" + var4;
            boolean var5 = false;
            Iterator var6 = this.b.iterator();

            while(var6.hasNext()) {
               bpq.a var7 = (bpq.a)var6.next();
               if (var7.b().equals(var4)) {
                  var7.c();
                  var5 = true;
                  break;
               }
            }

            if (!var5) {
               this.b.add(new bpq.a(var3, var4));
               this.a = true;
            }

         }
      }

      public synchronized boolean a() {
         return this.a;
      }

      public synchronized void b() {
         this.a = false;
      }

      public synchronized List<bpq.a> c() {
         return Collections.unmodifiableList(this.b);
      }
   }
}
