import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class auo {
   private final Map<String, auk> a = Maps.newHashMap();
   private final Map<String, Map<auk, aum>> c = Maps.newHashMap();
   private final Map<String, aul> f = Maps.newHashMap();
   private final Map<auu, List<auk>> b = Maps.newHashMap();
   private final Map<String, aul> e = Maps.newHashMap();
   private static String[] g = null;
   private final auk[] d = new auk[19];

   public void b(auk var1) {
   }

   public Collection<auk> c() {
      return this.a.values();
   }

   public boolean f(String var1) {
      aul var2 = this.h(var1);
      if (var2 != null) {
         this.a(var1, var2);
         return true;
      } else {
         return false;
      }
   }

   public aul d(String var1) {
      return (aul)this.e.get(var1);
   }

   public void a(int var1, auk var2) {
      this.d[var1] = var2;
   }

   public Collection<String> d() {
      return this.c.keySet();
   }

   public void c(aul var1) {
   }

   public void a(String var1) {
   }

   public void a(pk var1) {
      if (var1 != null && !(var1 instanceof wn) && !var1.ai()) {
         String var2 = var1.aK().toString();
         this.d(var2, (auk)null);
         this.f(var2);
      }
   }

   public auk a(String var1, auu var2) {
      if (var1.length() > 16) {
         throw new IllegalArgumentException("The objective name '" + var1 + "' is too long!");
      } else {
         auk var3 = this.b(var1);
         if (var3 != null) {
            throw new IllegalArgumentException("An objective with the name '" + var1 + "' already exists!");
         } else {
            var3 = new auk(this, var1, var2);
            Object var4 = (List)this.b.get(var2);
            if (var4 == null) {
               var4 = Lists.newArrayList();
               this.b.put(var2, var4);
            }

            ((List)var4).add(var3);
            this.a.put(var1, var3);
            this.a(var3);
            return var3;
         }
      }
   }

   public boolean b(String var1, auk var2) {
      Map var3 = (Map)this.c.get(var1);
      if (var3 == null) {
         return false;
      } else {
         aum var4 = (aum)var3.get(var2);
         return var4 != null;
      }
   }

   public void d(String var1, auk var2) {
      Map var3;
      if (var2 == null) {
         var3 = (Map)this.c.remove(var1);
         if (var3 != null) {
            this.a(var1);
         }
      } else {
         var3 = (Map)this.c.get(var1);
         if (var3 != null) {
            aum var4 = (aum)var3.remove(var2);
            if (var3.size() < 1) {
               Map var5 = (Map)this.c.remove(var1);
               if (var5 != null) {
                  this.a(var1);
               }
            } else if (var4 != null) {
               this.a(var1, var2);
            }
         }
      }

   }

   public void a(String var1, aul var2) {
      if (this.h(var1) != var2) {
         throw new IllegalStateException("Player is either on another team or not on any team. Cannot remove from team '" + var2.b() + "'.");
      } else {
         this.f.remove(var1);
         var2.d().remove(var1);
      }
   }

   public aul h(String var1) {
      return (aul)this.f.get(var1);
   }

   public Collection<aum> i(auk var1) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.c.values().iterator();

      while(var3.hasNext()) {
         Map var4 = (Map)var3.next();
         aum var5 = (aum)var4.get(var1);
         if (var5 != null) {
            var2.add(var5);
         }
      }

      Collections.sort(var2, aum.a);
      return var2;
   }

   public void a(aum var1) {
   }

   public void d(aul var1) {
      this.e.remove(var1.b());
      Iterator var2 = var1.d().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         this.f.remove(var3);
      }

      this.c(var1);
   }

   public void a(auk var1) {
   }

   public boolean a(String var1, String var2) {
      if (var1.length() > 40) {
         throw new IllegalArgumentException("The player name '" + var1 + "' is too long!");
      } else if (!this.e.containsKey(var2)) {
         return false;
      } else {
         aul var3 = this.d(var2);
         if (this.h(var1) != null) {
            this.f(var1);
         }

         this.f.put(var1, var3);
         var3.d().add(var1);
         return true;
      }
   }

   public auk a(int var1) {
      return this.d[var1];
   }

   public auk b(String var1) {
      return (auk)this.a.get(var1);
   }

   public void c(auk var1) {
   }

   public aum c(String var1, auk var2) {
      if (var1.length() > 40) {
         throw new IllegalArgumentException("The player name '" + var1 + "' is too long!");
      } else {
         Object var3 = (Map)this.c.get(var1);
         if (var3 == null) {
            var3 = Maps.newHashMap();
            this.c.put(var1, var3);
         }

         aum var4 = (aum)((Map)var3).get(var2);
         if (var4 == null) {
            var4 = new aum(this, var2, var1);
            ((Map)var3).put(var2, var4);
         }

         return var4;
      }
   }

   public static String[] h() {
      if (g == null) {
         g = new String[19];

         for(int var0 = 0; var0 < 19; ++var0) {
            g[var0] = b(var0);
         }
      }

      return g;
   }

   public void a(aul var1) {
   }

   public Map<auk, aum> c(String var1) {
      Object var2 = (Map)this.c.get(var1);
      if (var2 == null) {
         var2 = Maps.newHashMap();
      }

      return (Map)var2;
   }

   public Collection<auk> a(auu var1) {
      Collection var2 = (Collection)this.b.get(var1);
      return var2 == null ? Lists.newArrayList() : Lists.newArrayList(var2);
   }

   public static String b(int var0) {
      switch(var0) {
      case 0:
         return "list";
      case 1:
         return "sidebar";
      case 2:
         return "belowName";
      default:
         if (var0 >= 3 && var0 <= 18) {
            a var1 = a.a(var0 - 3);
            if (var1 != null && var1 != a.v) {
               return "sidebar.team." + var1.e();
            }
         }

         return null;
      }
   }

   public Collection<aum> e() {
      Collection var1 = this.c.values();
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Map var4 = (Map)var3.next();
         var2.addAll(var4.values());
      }

      return var2;
   }

   public aul e(String var1) {
      if (var1.length() > 16) {
         throw new IllegalArgumentException("The team name '" + var1 + "' is too long!");
      } else {
         aul var2 = this.d(var1);
         if (var2 != null) {
            throw new IllegalArgumentException("A team with the name '" + var1 + "' already exists!");
         } else {
            var2 = new aul(this, var1);
            this.e.put(var1, var2);
            this.a(var2);
            return var2;
         }
      }
   }

   public static int i(String var0) {
      if (var0.equalsIgnoreCase("list")) {
         return 0;
      } else if (var0.equalsIgnoreCase("sidebar")) {
         return 1;
      } else if (var0.equalsIgnoreCase("belowName")) {
         return 2;
      } else {
         if (var0.startsWith("sidebar.team.")) {
            String var1 = var0.substring("sidebar.team.".length());
            a var2 = a.b(var1);
            if (var2 != null && var2.b() >= 0) {
               return var2.b() + 3;
            }
         }

         return -1;
      }
   }

   public void b(aul var1) {
   }

   public Collection<aul> g() {
      return this.e.values();
   }

   public void a(String var1, auk var2) {
   }

   public Collection<String> f() {
      return this.e.keySet();
   }

   public void k(auk var1) {
      this.a.remove(var1.b());

      for(int var2 = 0; var2 < 19; ++var2) {
         if (this.a(var2) == var1) {
            this.a(var2, (auk)null);
         }
      }

      List var5 = (List)this.b.get(var1.c());
      if (var5 != null) {
         var5.remove(var1);
      }

      Iterator var3 = this.c.values().iterator();

      while(var3.hasNext()) {
         Map var4 = (Map)var3.next();
         var4.remove(var1);
      }

      this.c(var1);
   }
}
