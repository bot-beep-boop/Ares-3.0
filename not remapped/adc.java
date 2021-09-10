import io.netty.buffer.ByteBuf;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;
import net.minecraft.server.MinecraftServer;

public abstract class adc implements m {
   private static final SimpleDateFormat a = new SimpleDateFormat("HH:mm:ss");
   private int b;
   private boolean c = true;
   private String e = "";
   private String f = "@";
   private eu d = null;
   private final n g = new n();

   public String l() {
      return this.e;
   }

   public abstract void h();

   public boolean m() {
      return this.c;
   }

   public int j() {
      return this.b;
   }

   public void b(eu var1) {
      this.d = var1;
   }

   public void b(dn var1) {
      this.e = var1.j("Command");
      this.b = var1.f("SuccessCount");
      if (var1.b("CustomName", 8)) {
         this.f = var1.j("CustomName");
      }

      if (var1.b("TrackOutput", 1)) {
         this.c = var1.n("TrackOutput");
      }

      if (var1.b("LastOutput", 8) && this.c) {
         this.d = eu.a.a(var1.j("LastOutput"));
      }

      this.g.a(var1);
   }

   public void a(eu var1) {
      if (this.c && this.e() != null && !this.e().D) {
         this.d = (new fa("[" + a.format(new Date()) + "] ")).a(var1);
         this.h();
      }

   }

   public void a(n.a var1, int var2) {
      this.g.a(this, var1, var2);
   }

   public boolean u_() {
      MinecraftServer var1 = MinecraftServer.N();
      return var1 == null || !var1.O() || var1.d[0].Q().b("commandBlockOutput");
   }

   public n n() {
      return this.g;
   }

   public void a(adm var1) {
      if (var1.D) {
         this.b = 0;
      }

      MinecraftServer var2 = MinecraftServer.N();
      if (var2 != null && var2.O() && var2.al()) {
         l var3 = var2.P();

         try {
            this.d = null;
            this.b = var3.a(this, this.e);
         } catch (Throwable var7) {
            b var5 = b.a(var7, "Executing command block");
            c var6 = var5.a("Command to be executed");
            var6.a("Command", new Callable<String>(this) {
               final adc a;

               public Object call() throws Exception {
                  return this.a();
               }

               public String a() throws Exception {
                  return this.a.l();
               }

               {
                  this.a = var1;
               }
            });
            var6.a("Name", new Callable<String>(this) {
               final adc a;

               {
                  this.a = var1;
               }

               public Object call() throws Exception {
                  return this.a();
               }

               public String a() throws Exception {
                  return this.a.e_();
               }
            });
            throw new e(var5);
         }
      } else {
         this.b = 0;
      }

   }

   public boolean a(int var1, String var2) {
      return var1 <= 2;
   }

   public void b(String var1) {
      this.f = var1;
   }

   public String e_() {
      return this.f;
   }

   public void a(String var1) {
      this.e = var1;
      this.b = 0;
   }

   public eu f_() {
      return new fa(this.e_());
   }

   public void a(dn var1) {
      var1.a("Command", this.e);
      var1.a("SuccessCount", this.b);
      var1.a("CustomName", this.f);
      var1.a("TrackOutput", this.c);
      if (this.d != null && this.c) {
         var1.a("LastOutput", eu.a.a(this.d));
      }

      this.g.b(var1);
   }

   public boolean a(wn var1) {
      if (!var1.bA.d) {
         return false;
      } else {
         if (var1.e().D) {
            var1.a(this);
         }

         return true;
      }
   }

   public abstract int i();

   public void a(boolean var1) {
      this.c = var1;
   }

   public abstract void a(ByteBuf var1);

   public eu k() {
      return this.d;
   }
}
