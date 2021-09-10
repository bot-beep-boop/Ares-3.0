import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.InputStream;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class dj {
   private static final Pattern a = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
   private static dj c = new dj();
   private long e;
   private final Map<String, String> d = Maps.newHashMap();
   private static final Splitter b = Splitter.on('=').limit(2);

   public synchronized String a(String var1, Object... var2) {
      String var3 = this.c(var1);

      try {
         return String.format(var3, var2);
      } catch (IllegalFormatException var5) {
         return "Format error: " + var3;
      }
   }

   private String c(String var1) {
      String var2 = (String)this.d.get(var1);
      return var2 == null ? var1 : var2;
   }

   public dj() {
      try {
         InputStream var1 = dj.class.getResourceAsStream("/assets/minecraft/lang/en_US.lang");
         Iterator var2 = IOUtils.readLines(var1, Charsets.UTF_8).iterator();

         while(var2.hasNext()) {
            String var3 = (String)var2.next();
            if (!var3.isEmpty() && var3.charAt(0) != '#') {
               String[] var4 = (String[])Iterables.toArray(b.split(var3), String.class);
               if (var4 != null && var4.length == 2) {
                  String var5 = var4[0];
                  String var6 = a.matcher(var4[1]).replaceAll("%$1s");
                  this.d.put(var5, var6);
               }
            }
         }

         this.e = System.currentTimeMillis();
      } catch (IOException var7) {
      }

   }

   public long c() {
      return this.e;
   }

   public synchronized boolean b(String var1) {
      return this.d.containsKey(var1);
   }

   static dj a() {
      return c;
   }

   public static synchronized void a(Map<String, String> var0) {
      c.d.clear();
      c.d.putAll(var0);
      c.e = System.currentTimeMillis();
   }

   public synchronized String a(String var1) {
      return this.c(var1);
   }
}
