import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;

public interface auu {
   auu[] i = new auu[]{new aur("killedByTeam.", .a.a), new aur("killedByTeam.", .a.b), new aur("killedByTeam.", .a.c), new aur("killedByTeam.", .a.d), new aur("killedByTeam.", .a.e), new aur("killedByTeam.", .a.f), new aur("killedByTeam.", .a.g), new aur("killedByTeam.", .a.h), new aur("killedByTeam.", .a.i), new aur("killedByTeam.", .a.j), new aur("killedByTeam.", .a.k), new aur("killedByTeam.", .a.l), new aur("killedByTeam.", .a.m), new aur("killedByTeam.", .a.n), new aur("killedByTeam.", .a.o), new aur("killedByTeam.", .a.p)};
   auu g = new aut("health");
   auu e = new aus("playerKillCount");
   auu c = new aus("trigger");
   auu b = new aus("dummy");
   Map<String, auu> a = Maps.newHashMap();
   auu[] h = new auu[]{new aur("teamkill.", .a.a), new aur("teamkill.", .a.b), new aur("teamkill.", .a.c), new aur("teamkill.", .a.d), new aur("teamkill.", .a.e), new aur("teamkill.", .a.f), new aur("teamkill.", .a.g), new aur("teamkill.", .a.h), new aur("teamkill.", .a.i), new aur("teamkill.", .a.j), new aur("teamkill.", .a.k), new aur("teamkill.", .a.l), new aur("teamkill.", .a.m), new aur("teamkill.", .a.n), new aur("teamkill.", .a.o), new aur("teamkill.", .a.p)};
   auu d = new aus("deathCount");
   auu f = new aus("totalKillCount");

   int a(List<wn> var1);

   auu.a c();

   String a();

   boolean b();

   public static enum a {
      private final String d;
      b("hearts");

      private static final Map<String, auu.a> c = Maps.newHashMap();
      a("integer");

      private static final auu.a[] e = new auu.a[]{a, b};

      private a(String var3) {
         this.d = var3;
      }

      public String a() {
         return this.d;
      }

      static {
         auu.a[] var0 = values();
         int var1 = var0.length;

         for(int var2 = 0; var2 < var1; ++var2) {
            auu.a var3 = var0[var2];
            c.put(var3.a(), var3);
         }

      }

      public static auu.a a(String var0) {
         auu.a var1 = (auu.a)c.get(var0);
         return var1 == null ? a : var1;
      }
   }
}
