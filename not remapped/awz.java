import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class awz extends axu {
   private ek g;
   private boolean h;
   private static final Logger f = LogManager.getLogger();
   private static final AtomicInteger a = new AtomicInteger(0);
   private final axu i;

   static axu c(awz var0) {
      return var0.i;
   }

   static Logger a() {
      return f;
   }

   public awz(axu var1, ave var2, String var3, int var4) {
      this.j = var2;
      this.i = var1;
      var2.a((bdb)null);
      this.a(var3, var4);
   }

   private void a(String var1, int var2) {
      f.info("Connecting to " + var1 + ", " + var2);
      (new Thread(this, "Server Connector #" + a.incrementAndGet(), var1, var2) {
         final String a;
         final int b;
         final awz c;

         {
            this.c = var1;
            this.a = var3;
            this.b = var4;
         }

         public void run() {
            InetAddress var1 = null;

            try {
               if (awz.a(this.c)) {
                  return;
               }

               var1 = InetAddress.getByName(this.a);
               awz.a(this.c, ek.a(var1, this.b, this.c.j.t.f()));
               awz.b(this.c).a((ep)(new bcx(awz.b(this.c), this.c.j, awz.c(this.c))));
               awz.b(this.c).a((ff)(new jc(47, this.a, this.b, el.d)));
               awz.b(this.c).a((ff)(new jl(this.c.j.L().e())));
            } catch (UnknownHostException var5) {
               if (awz.a(this.c)) {
                  return;
               }

               awz.a().error("Couldn't connect to server", var5);
               this.c.j.a((axu)(new axh(awz.c(this.c), "connect.failed", new fb("disconnect.genericReason", new Object[]{"Unknown host"}))));
            } catch (Exception var6) {
               if (awz.a(this.c)) {
                  return;
               }

               awz.a().error("Couldn't connect to server", var6);
               String var3 = var6.toString();
               if (var1 != null) {
                  String var4 = var1.toString() + ":" + this.b;
                  var3 = var3.replaceAll(var4, "");
               }

               this.c.j.a((axu)(new axh(awz.c(this.c), "connect.failed", new fb("disconnect.genericReason", new Object[]{var3}))));
            }

         }
      }).start();
   }

   public awz(axu var1, ave var2, bde var3) {
      this.j = var2;
      this.i = var1;
      bdd var4 = bdd.a(var3.b);
      var2.a((bdb)null);
      var2.a(var3);
      this.a(var4.a(), var4.b());
   }

   public void b() {
      this.n.clear();
      this.n.add(new avs(0, this.l / 2 - 100, this.m / 4 + 120 + 12, bnq.a("gui.cancel")));
   }

   protected void a(char var1, int var2) {
   }

   static boolean a(awz var0) {
      return var0.h;
   }

   protected void a(avs var1) {
      if (var1.k == 0) {
         this.h = true;
         if (this.g != null) {
            this.g.a((eu)(new fa("Aborted")));
         }

         this.j.a(this.i);
      }

   }

   static ek b(awz var0) {
      return var0.g;
   }

   static ek a(awz var0, ek var1) {
      return var0.g = var1;
   }

   public void e() {
      if (this.g != null) {
         if (this.g.g()) {
            this.g.a();
         } else {
            this.g.l();
         }
      }

   }

   public void a(int var1, int var2, float var3) {
      this.c();
      if (this.g == null) {
         this.a(this.q, bnq.a("connect.connecting"), this.l / 2, this.m / 2 - 50, 16777215);
      } else {
         this.a(this.q, bnq.a("connect.authorizing"), this.l / 2, this.m / 2 - 50, 16777215);
      }

      super.a(var1, var2, var3);
   }
}
