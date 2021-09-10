import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bns implements bnj {
   private String d;
   protected static final bnt a = new bnt();
   private Map<String, bnr> e = Maps.newHashMap();
   private final bny c;
   private static final Logger b = LogManager.getLogger();

   public SortedSet<bnr> d() {
      return Sets.newTreeSet(this.e.values());
   }

   public bnr c() {
      return this.e.containsKey(this.d) ? (bnr)this.e.get(this.d) : (bnr)this.e.get("en_US");
   }

   public boolean a() {
      return a.a();
   }

   public bns(bny var1, String var2) {
      this.c = var1;
      this.d = var2;
      bnq.a(a);
   }

   public void a(List<bnk> var1) {
      this.e.clear();
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         bnk var3 = (bnk)var2.next();

         try {
            bog var4 = (bog)var3.a(this.c, "language");
            if (var4 != null) {
               Iterator var5 = var4.a().iterator();

               while(var5.hasNext()) {
                  bnr var6 = (bnr)var5.next();
                  if (!this.e.containsKey(var6.a())) {
                     this.e.put(var6.a(), var6);
                  }
               }
            }
         } catch (RuntimeException var7) {
            b.warn("Unable to parse metadata section of resourcepack: " + var3.b(), var7);
         } catch (IOException var8) {
            b.warn("Unable to parse metadata section of resourcepack: " + var3.b(), var8);
         }
      }

   }

   public void a(bnr var1) {
      this.d = var1.a();
   }

   public boolean b() {
      return this.c() != null && this.c().b();
   }

   public void a(bni var1) {
      ArrayList var2 = Lists.newArrayList(new String[]{"en_US"});
      if (!"en_US".equals(this.d)) {
         var2.add(this.d);
      }

      a.a((bni)var1, (List)var2);
      dj.a(a.a);
   }
}
