import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Map;

public abstract class auq {
   public abstract String b();

   public abstract boolean h();

   public abstract String d(String var1);

   public abstract Collection<String> d();

   public abstract auq.a i();

   public abstract boolean g();

   public boolean a(auq var1) {
      if (var1 == null) {
         return false;
      } else {
         return this == var1;
      }
   }

   public abstract auq.a j();

   public static enum a {
      private static Map<String, auq.a> g = Maps.newHashMap();
      private static final auq.a[] h = new auq.a[]{a, b, c, d};
      c("hideForOtherTeams", 2),
      a("always", 0);

      public final int f;
      d("hideForOwnTeam", 3);

      public final String e;
      b("never", 1);

      public static auq.a a(String var0) {
         return (auq.a)g.get(var0);
      }

      private a(String var3, int var4) {
         this.e = var3;
         this.f = var4;
      }

      public static String[] a() {
         return (String[])g.keySet().toArray(new String[g.size()]);
      }

      static {
         auq.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            auq.a var3 = var0[var2];
            g.put(var3.e, var3);
         }

      }
   }
}
