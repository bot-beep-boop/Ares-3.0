import java.util.Collection;
import java.util.Iterator;
import java.util.UUID;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class vy {
   public static final qb d = (new qj((qb)null, "generic.movementSpeed", 0.699999988079071D, 0.0D, 1024.0D)).a("Movement Speed").a(true);
   public static final qb c = (new qj((qb)null, "generic.knockbackResistance", 0.0D, 0.0D, 1.0D)).a("Knockback Resistance");
   public static final qb b = (new qj((qb)null, "generic.followRange", 32.0D, 0.0D, 2048.0D)).a("Follow Range");
   public static final qb a = (new qj((qb)null, "generic.maxHealth", 20.0D, 0.0D, 1024.0D)).a("Max Health").a(true);
   public static final qb e = new qj((qb)null, "generic.attackDamage", 2.0D, 0.0D, 2048.0D);
   private static final Logger f = LogManager.getLogger();

   public static du a(qf var0) {
      du var1 = new du();
      Iterator var2 = var0.a().iterator();

      while(var2.hasNext()) {
         qc var3 = (qc)var2.next();
         var1.a((eb)a(var3));
      }

      return var1;
   }

   public static qd a(dn var0) {
      UUID var1 = new UUID(var0.g("UUIDMost"), var0.g("UUIDLeast"));

      try {
         return new qd(var1, var0.j("Name"), var0.i("Amount"), var0.f("Operation"));
      } catch (Exception var3) {
         f.warn("Unable to create attribute: " + var3.getMessage());
         return null;
      }
   }

   public static void a(qf var0, du var1) {
      for(int var2 = 0; var2 < var1.c(); ++var2) {
         dn var3 = var1.b(var2);
         qc var4 = var0.a(var3.j("Name"));
         if (var4 != null) {
            a(var4, var3);
         } else {
            f.warn("Ignoring unknown attribute '" + var3.j("Name") + "'");
         }
      }

   }

   private static dn a(qc var0) {
      dn var1 = new dn();
      qb var2 = var0.a();
      var1.a("Name", var2.a());
      var1.a("Base", var0.b());
      Collection var3 = var0.c();
      if (var3 != null && !var3.isEmpty()) {
         du var4 = new du();
         Iterator var5 = var3.iterator();

         while(var5.hasNext()) {
            qd var6 = (qd)var5.next();
            if (var6.e()) {
               var4.a((eb)a(var6));
            }
         }

         var1.a((String)"Modifiers", (eb)var4);
      }

      return var1;
   }

   private static void a(qc var0, dn var1) {
      var0.a(var1.i("Base"));
      if (var1.b("Modifiers", 9)) {
         du var2 = var1.c("Modifiers", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            qd var4 = a(var2.b(var3));
            if (var4 != null) {
               qd var5 = var0.a(var4.a());
               if (var5 != null) {
                  var0.c(var5);
               }

               var0.b(var4);
            }
         }
      }

   }

   private static dn a(qd var0) {
      dn var1 = new dn();
      var1.a("Name", var0.b());
      var1.a("Amount", var0.d());
      var1.a("Operation", var0.c());
      var1.a("UUIDMost", var0.a().getMostSignificantBits());
      var1.a("UUIDLeast", var0.a().getLeastSignificantBits());
      return var1;
   }
}
