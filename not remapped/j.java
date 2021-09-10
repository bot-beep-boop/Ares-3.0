import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class j implements l {
   private final Set<k> c = Sets.newHashSet();
   private final Map<String, k> b = Maps.newHashMap();
   private static final Logger a = LogManager.getLogger();

   public List<k> a(m var1) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.c.iterator();

      while(var3.hasNext()) {
         k var4 = (k)var3.next();
         if (var4.a(var1)) {
            var2.add(var4);
         }
      }

      return var2;
   }

   public Map<String, k> a() {
      return this.b;
   }

   protected boolean a(m var1, String[] var2, k var3, String var4) {
      fb var6;
      try {
         var3.a(var1, var2);
         return true;
      } catch (cf var7) {
         var6 = new fb("commands.generic.usage", new Object[]{new fb(var7.getMessage(), var7.a())});
         var6.b().a(a.m);
         var1.a(var6);
      } catch (bz var8) {
         var6 = new fb(var8.getMessage(), var8.a());
         var6.b().a(a.m);
         var1.a(var6);
      } catch (Throwable var9) {
         var6 = new fb("commands.generic.exception", new Object[0]);
         var6.b().a(a.m);
         var1.a(var6);
         a.warn("Couldn't process command: '" + var4 + "'");
      }

      return false;
   }

   public k a(k var1) {
      this.b.put(var1.c(), var1);
      this.c.add(var1);
      Iterator var2 = var1.b().iterator();

      while(true) {
         String var3;
         k var4;
         do {
            if (!var2.hasNext()) {
               return var1;
            }

            var3 = (String)var2.next();
            var4 = (k)this.b.get(var3);
         } while(var4 != null && var4.c().equals(var3));

         this.b.put(var3, var1);
      }
   }

   public int a(m var1, String var2) {
      var2 = var2.trim();
      if (var2.startsWith("/")) {
         var2 = var2.substring(1);
      }

      String[] var3 = var2.split(" ");
      String var4 = var3[0];
      var3 = a(var3);
      k var5 = (k)this.b.get(var4);
      int var6 = this.a(var5, var3);
      int var7 = 0;
      fb var8;
      if (var5 == null) {
         var8 = new fb("commands.generic.notFound", new Object[0]);
         var8.b().a(a.m);
         var1.a(var8);
      } else if (var5.a(var1)) {
         if (var6 > -1) {
            List var12 = o.b(var1, var3[var6], pk.class);
            String var9 = var3[var6];
            var1.a(n.a.c, var12.size());
            Iterator var10 = var12.iterator();

            while(var10.hasNext()) {
               pk var11 = (pk)var10.next();
               var3[var6] = var11.aK().toString();
               if (this.a(var1, var3, var5, var2)) {
                  ++var7;
               }
            }

            var3[var6] = var9;
         } else {
            var1.a(n.a.c, 1);
            if (this.a(var1, var3, var5, var2)) {
               ++var7;
            }
         }
      } else {
         var8 = new fb("commands.generic.permission", new Object[0]);
         var8.b().a(a.m);
         var1.a(var8);
      }

      var1.a(n.a.a, var7);
      return var7;
   }

   private static String[] a(String[] var0) {
      String[] var1 = new String[var0.length - 1];
      System.arraycopy(var0, 1, var1, 0, var0.length - 1);
      return var1;
   }

   public List<String> a(m var1, String var2, cj var3) {
      String[] var4 = var2.split(" ", -1);
      String var5 = var4[0];
      if (var4.length == 1) {
         ArrayList var9 = Lists.newArrayList();
         Iterator var7 = this.b.entrySet().iterator();

         while(var7.hasNext()) {
            Entry var8 = (Entry)var7.next();
            if (i.a(var5, (String)var8.getKey()) && ((k)var8.getValue()).a(var1)) {
               var9.add(var8.getKey());
            }
         }

         return var9;
      } else {
         if (var4.length > 1) {
            k var6 = (k)this.b.get(var5);
            if (var6 != null && var6.a(var1)) {
               return var6.a(var1, a(var4), var3);
            }
         }

         return null;
      }
   }

   private int a(k var1, String[] var2) {
      if (var1 == null) {
         return -1;
      } else {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            if (var1.b(var2, var3) && o.a(var2[var3])) {
               return var3;
            }
         }

         return -1;
      }
   }
}
