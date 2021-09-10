import com.google.common.collect.Maps;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class aqr {
   private static Map<String, Class<? extends aqt>> d = Maps.newHashMap();
   private static final Logger a = LogManager.getLogger();
   private static Map<Class<? extends aqu>, String> c = Maps.newHashMap();
   private static Map<String, Class<? extends aqu>> b = Maps.newHashMap();
   private static Map<Class<? extends aqt>, String> e = Maps.newHashMap();

   static void a(Class<? extends aqt> var0, String var1) {
      d.put(var1, var0);
      e.put(var0, var1);
   }

   public static String a(aqu var0) {
      return (String)c.get(var0.getClass());
   }

   static {
      b(aqh.class, "Mineshaft");
      b(aqv.a.class, "Village");
      b(aqi.a.class, "Fortress");
      b(aqo.a.class, "Stronghold");
      b(aqm.a.class, "Temple");
      b(aqk.a.class, "Monument");
      aqg.a();
      aqw.a();
      aqj.a();
      aqp.a();
      aqn.a();
      aql.a();
   }

   public static aqu a(dn var0, adm var1) {
      aqu var2 = null;

      try {
         Class var3 = (Class)b.get(var0.j("id"));
         if (var3 != null) {
            var2 = (aqu)var3.newInstance();
         }
      } catch (Exception var4) {
         a.warn("Failed Start with id " + var0.j("id"));
         var4.printStackTrace();
      }

      if (var2 != null) {
         var2.a(var1, var0);
      } else {
         a.warn("Skipping Structure with id " + var0.j("id"));
      }

      return var2;
   }

   public static String a(aqt var0) {
      return (String)e.get(var0.getClass());
   }

   private static void b(Class<? extends aqu> var0, String var1) {
      b.put(var1, var0);
      c.put(var0, var1);
   }

   public static aqt b(dn var0, adm var1) {
      aqt var2 = null;

      try {
         Class var3 = (Class)d.get(var0.j("id"));
         if (var3 != null) {
            var2 = (aqt)var3.newInstance();
         }
      } catch (Exception var4) {
         a.warn("Failed Piece with id " + var0.j("id"));
         var4.printStackTrace();
      }

      if (var2 != null) {
         var2.a(var1, var0);
      } else {
         a.warn("Skipping Piece with id " + var0.j("id"));
      }

      return var2;
   }
}
