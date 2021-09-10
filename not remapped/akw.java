import com.google.common.collect.Maps;
import java.util.Map;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class akw {
   protected afh e;
   private static Map<String, Class<? extends akw>> f = Maps.newHashMap();
   protected adm b;
   protected cj c;
   private int h;
   private static Map<Class<? extends akw>, String> g = Maps.newHashMap();
   private static final Logger a = LogManager.getLogger();
   protected boolean d;

   public void a(c var1) {
      var1.a("Name", new Callable<String>(this) {
         final akw a;

         public Object call() throws Exception {
            return this.a();
         }

         public String a() throws Exception {
            return (String)akw.G().get(this.a.getClass()) + " // " + this.a.getClass().getCanonicalName();
         }

         {
            this.a = var1;
         }
      });
      if (this.b != null) {
         c.a(var1, this.c, this.w(), this.u());
         var1.a("Actual block type", new Callable<String>(this) {
            final akw a;

            public String a() throws Exception {
               int var1 = afh.a(this.a.b.p(this.a.c).c());

               try {
                  return String.format("ID #%d (%s // %s)", var1, afh.c(var1).a(), afh.c(var1).getClass().getCanonicalName());
               } catch (Throwable var3) {
                  return "ID #" + var1;
               }
            }

            public Object call() throws Exception {
               return this.a();
            }

            {
               this.a = var1;
            }
         });
         var1.a("Actual block data value", new Callable<String>(this) {
            final akw a;

            public String a() throws Exception {
               alz var1 = this.a.b.p(this.a.c);
               int var2 = var1.c().c(var1);
               if (var2 < 0) {
                  return "Unknown? (Got " + var2 + ")";
               } else {
                  String var3 = String.format("%4s", Integer.toBinaryString(var2)).replace(" ", "0");
                  return String.format("%1$d / 0x%1$X / 0b%2$s", var2, var3);
               }
            }

            public Object call() throws Exception {
               return this.a();
            }

            {
               this.a = var1;
            }
         });
      }
   }

   public ff y_() {
      return null;
   }

   public boolean c(int var1, int var2) {
      return false;
   }

   public adm z() {
      return this.b;
   }

   public boolean t() {
      return this.b != null;
   }

   public void y() {
      this.d = true;
   }

   public boolean F() {
      return false;
   }

   public static akw c(dn var0) {
      akw var1 = null;

      try {
         Class var2 = (Class)f.get(var0.j("id"));
         if (var2 != null) {
            var1 = (akw)var2.newInstance();
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }

      if (var1 != null) {
         var1.a(var0);
      } else {
         a.warn("Skipping BlockEntity with id " + var0.j("id"));
      }

      return var1;
   }

   static {
      a(alh.class, "Furnace");
      a(aky.class, "Chest");
      a(alf.class, "EnderChest");
      a(ahq.a.class, "RecordPlayer");
      a(alc.class, "Trap");
      a(ald.class, "Dropper");
      a(aln.class, "Sign");
      a(all.class, "MobSpawner");
      a(alm.class, "Music");
      a(alu.class, "Piston");
      a(akx.class, "Cauldron");
      a(ale.class, "EnchantTable");
      a(alp.class, "Airportal");
      a(akz.class, "Control");
      a(akv.class, "Beacon");
      a(alo.class, "Skull");
      a(alb.class, "DLDetector");
      a(alj.class, "Hopper");
      a(ala.class, "Comparator");
      a(alg.class, "FlowerPot");
      a(aku.class, "Banner");
   }

   public akw() {
      this.c = cj.a;
      this.h = -1;
   }

   public void a(adm var1) {
      this.b = var1;
   }

   public void E() {
      this.e = null;
      this.h = -1;
   }

   public double a(double var1, double var3, double var5) {
      double var7 = (double)this.c.n() + 0.5D - var1;
      double var9 = (double)this.c.o() + 0.5D - var3;
      double var11 = (double)this.c.p() + 0.5D - var5;
      return var7 * var7 + var9 * var9 + var11 * var11;
   }

   public int u() {
      if (this.h == -1) {
         alz var1 = this.b.p(this.c);
         this.h = var1.c().c(var1);
      }

      return this.h;
   }

   public void p_() {
      if (this.b != null) {
         alz var1 = this.b.p(this.c);
         this.h = var1.c().c(var1);
         this.b.b(this.c, this);
         if (this.w() != afi.a) {
            this.b.e(this.c, this.w());
         }
      }

   }

   public boolean x() {
      return this.d;
   }

   public double s() {
      return 4096.0D;
   }

   public afh w() {
      if (this.e == null) {
         this.e = this.b.p(this.c).c();
      }

      return this.e;
   }

   public cj v() {
      return this.c;
   }

   static Map G() {
      return g;
   }

   public void b(dn var1) {
      String var2 = (String)g.get(this.getClass());
      if (var2 == null) {
         throw new RuntimeException(this.getClass() + " is missing a mapping! This is a bug!");
      } else {
         var1.a("id", var2);
         var1.a("x", this.c.n());
         var1.a("y", this.c.o());
         var1.a("z", this.c.p());
      }
   }

   public void a(dn var1) {
      this.c = new cj(var1.f("x"), var1.f("y"), var1.f("z"));
   }

   public void a(cj var1) {
      this.c = var1;
   }

   private static void a(Class<? extends akw> var0, String var1) {
      if (f.containsKey(var1)) {
         throw new IllegalArgumentException("Duplicate id: " + var1);
      } else {
         f.put(var1, var0);
         g.put(var0, var1);
      }
   }

   public void D() {
      this.d = false;
   }
}
