import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import net.minecraft.client.ClientBrandRetriever;
import net.minecraft.server.MinecraftServer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bpo extends MinecraftServer {
   private bpr p;
   private final adp m;
   private boolean n;
   private final ave l;
   private boolean o;
   private static final Logger k = LogManager.getLogger();

   public File y() {
      return this.l.v;
   }

   public void a(or var1) {
      super.a(var1);
      var1.a("snooper_partner", this.l.I().f());
   }

   public boolean al() {
      return true;
   }

   protected void a(b var1) {
      this.l.a(var1);
   }

   protected void A() {
      boolean var1 = this.n;
      this.n = ave.A().u() != null && ave.A().V();
      if (!var1 && this.n) {
         k.info("Saving and pausing game...");
         this.ap().j();
         this.a(false);
      }

      if (this.n) {
         synchronized(this.j) {
            while(!this.j.isEmpty()) {
               g.a((FutureTask)this.j.poll(), k);
            }
         }
      } else {
         super.A();
         if (this.l.t.c != this.ap().s()) {
            k.info("Changing view distance to {}, from {}", new Object[]{this.l.t.c, this.ap().s()});
            this.ap().a(this.l.t.c);
         }

         if (this.l.f != null) {
            ato var2 = this.d[0].P();
            ato var3 = this.l.f.P();
            if (!var2.z() && var3.y() != var2.y()) {
               k.info("Changing difficulty to {}, from {}", new Object[]{var3.y(), var2.y()});
               this.a(var3.y());
            } else if (var3.z() && !var2.z()) {
               k.info("Locking difficulty to {}", new Object[]{var3.y()});
               le[] var4 = this.d;
               int var5 = var4.length;

               for(int var6 = 0; var6 < var5; ++var6) {
                  le var7 = var4[var6];
                  if (var7 != null) {
                     var7.P().e(true);
                  }
               }
            }
         }
      }

   }

   public boolean ae() {
      return false;
   }

   public int p() {
      return 4;
   }

   public b b(b var1) {
      var1 = super.b(var1);
      var1.g().a("Type", new Callable<String>(this) {
         final bpo a;

         {
            this.a = var1;
         }

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return "Integrated Server (map_client.txt)";
         }
      });
      var1.g().a("Is Modded", new Callable<String>(this) {
         final bpo a;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            String var1 = ClientBrandRetriever.getClientModName();
            if (!var1.equals("vanilla")) {
               return "Definitely; Client brand changed to '" + var1 + "'";
            } else {
               var1 = this.a.getServerModName();
               if (!var1.equals("vanilla")) {
                  return "Definitely; Server brand changed to '" + var1 + "'";
               } else {
                  return ave.class.getSigners() == null ? "Very likely; Jar signature invalidated" : "Probably not. Jar signature remains and both client + server brands are untouched.";
               }
            }
         }

         {
            this.a = var1;
         }
      });
      return var1;
   }

   protected bd h() {
      return new bpp();
   }

   public boolean b() {
      return this.o;
   }

   public boolean ad() {
      return ave.A().ad();
   }

   public boolean l() {
      return false;
   }

   public void a(oj var1) {
      super.a(var1);
      if (this.l.f != null) {
         this.l.f.P().a(var1);
      }

   }

   public void t() {
      super.t();
      if (this.p != null) {
         this.p.interrupt();
         this.p = null;
      }

   }

   public boolean r() {
      return true;
   }

   public void w() {
      Futures.getUnchecked(this.a((Runnable)(new Runnable(this) {
         final bpo a;

         {
            this.a = var1;
         }

         public void run() {
            ArrayList var1 = Lists.newArrayList(this.a.ap().v());
            Iterator var2 = var1.iterator();

            while(var2.hasNext()) {
               lf var3 = (lf)var2.next();
               this.a.ap().e(var3);
            }

         }
      })));
      super.w();
      if (this.p != null) {
         this.p.interrupt();
         this.p = null;
      }

   }

   public void a(adp.a var1) {
      this.ap().a(var1);
   }

   protected boolean i() throws IOException {
      k.info("Starting integrated minecraft server version 1.8.9");
      this.d(true);
      this.e(true);
      this.f(true);
      this.g(true);
      this.h(true);
      k.info("Generating keypair");
      this.a((KeyPair)ng.b());
      this.a(this.U(), this.V(), this.m.d(), this.m.h(), this.m.j());
      this.l(this.S() + " - " + this.d[0].P().k());
      return true;
   }

   public adp.a m() {
      return this.m.e();
   }

   public String a(adp.a var1, boolean var2) {
      try {
         int var3 = -1;

         try {
            var3 = nj.a();
         } catch (IOException var5) {
         }

         if (var3 <= 0) {
            var3 = 25564;
         }

         this.aq().a((InetAddress)null, var3);
         k.info("Started on " + var3);
         this.o = true;
         this.p = new bpr(this.am(), var3 + "");
         this.p.start();
         this.ap().a(var1);
         this.ap().c(var2);
         return var3 + "";
      } catch (IOException var6) {
         return null;
      }
   }

   public bpo(ave var1) {
      super(var1.O(), new File(var1.v, a.getName()));
      this.l = var1;
      this.m = null;
   }

   public boolean o() {
      return this.m.f();
   }

   public void a() {
      this.x();
   }

   public oj n() {
      return this.l.f.P().y();
   }

   public boolean q() {
      return true;
   }

   public boolean ai() {
      return false;
   }

   protected void a(String var1, String var2, long var3, adr var5, String var6) {
      this.a((String)var1);
      this.d = new le[3];
      this.i = new long[this.d.length][100];
      atp var7 = this.Y().a(var1, true);
      this.a(this.U(), var7);
      ato var8 = var7.d();
      if (var8 == null) {
         var8 = new ato(this.m, var2);
      } else {
         var8.a(var2);
      }

      for(int var9 = 0; var9 < this.d.length; ++var9) {
         byte var10 = 0;
         if (var9 == 1) {
            var10 = -1;
         }

         if (var9 == 2) {
            var10 = 1;
         }

         if (var9 == 0) {
            if (this.X()) {
               this.d[var9] = (le)(new kx(this, var7, var8, var10, this.c)).b();
            } else {
               this.d[var9] = (le)(new le(this, var7, var8, var10, this.c)).b();
            }

            this.d[var9].a(this.m);
         } else {
            this.d[var9] = (le)(new kz(this, var7, var10, this.d[0], this.c)).b();
         }

         this.d[var9].a((ado)(new lb(this, this.d[var9])));
      }

      this.ap().a(this.d);
      if (this.d[0].P().y() == null) {
         this.a(this.l.t.az);
      }

      this.k();
   }

   public bpo(ave var1, String var2, String var3, adp var4) {
      super(new File(var1.v, "saves"), var1.O(), new File(var1.v, a.getName()));
      this.i(var1.L().c());
      this.j(var2);
      this.k(var3);
      this.b(var1.t());
      this.c(var4.c());
      this.c(256);
      this.a((lx)(new bpn(this)));
      this.l = var1;
      this.m = this.X() ? kx.a : var4;
   }
}
