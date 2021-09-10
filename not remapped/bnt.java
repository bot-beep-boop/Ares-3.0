import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.io.InputStream;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

public class bnt {
   private static final Pattern c = Pattern.compile("%(\\d+\\$)?[\\d\\.]*[df]");
   Map<String, String> a = Maps.newHashMap();
   private boolean d;
   private static final Splitter b = Splitter.on('=').limit(2);

   private void a(InputStream var1) throws IOException {
      Iterator var2 = IOUtils.readLines(var1, Charsets.UTF_8).iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         if (!var3.isEmpty() && var3.charAt(0) != '#') {
            String[] var4 = (String[])Iterables.toArray(b.split(var3), String.class);
            if (var4 != null && var4.length == 2) {
               String var5 = var4[0];
               String var6 = c.matcher(var4[1]).replaceAll("%$1s");
               this.a.put(var5, var6);
            }
         }
      }

   }

   public synchronized void a(bni var1, List<String> var2) {
      this.a.clear();
      Iterator var3 = var2.iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         String var5 = String.format("lang/%s.lang", var4);
         Iterator var6 = var1.a().iterator();

         while(var6.hasNext()) {
            String var7 = (String)var6.next();

            try {
               this.a(var1.b(new jy(var7, var5)));
            } catch (IOException var9) {
            }
         }
      }

      this.b();
   }

   private String b(String var1) {
      String var2 = (String)this.a.get(var1);
      return var2 == null ? var1 : var2;
   }

   public String a(String var1, Object[] var2) {
      String var3 = this.b(var1);

      try {
         return String.format(var3, var2);
      } catch (IllegalFormatException var5) {
         return "Format error: " + var3;
      }
   }

   private void a(List<bnh> var1) throws IOException {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         bnh var3 = (bnh)var2.next();
         InputStream var4 = var3.b();

         try {
            this.a(var4);
         } finally {
            IOUtils.closeQuietly(var4);
         }
      }

   }

   public boolean a() {
      return this.d;
   }

   private void b() {
      this.d = false;
      int var1 = 0;
      int var2 = 0;
      Iterator var3 = this.a.values().iterator();

      while(var3.hasNext()) {
         String var4 = (String)var3.next();
         int var5 = var4.length();
         var2 += var5;

         for(int var6 = 0; var6 < var5; ++var6) {
            if (var4.charAt(var6) >= 256) {
               ++var1;
            }
         }
      }

      float var7 = (float)var1 / (float)var2;
      this.d = (double)var7 > 0.1D;
   }
}
