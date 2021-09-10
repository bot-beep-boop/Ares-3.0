import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bmj implements bmm, bnj {
   private final Map<jy, bmk> b = Maps.newHashMap();
   private final List<bmm> c = Lists.newArrayList();
   private static final Logger a = LogManager.getLogger();
   private final Map<String, Integer> d = Maps.newHashMap();
   private bni e;

   public bmj(bni var1) {
      this.e = var1;
   }

   public bmk b(jy var1) {
      return (bmk)this.b.get(var1);
   }

   public boolean a(jy var1, bmk var2) {
      boolean var3 = true;

      try {
         ((bmk)var2).a(this.e);
      } catch (IOException var8) {
         a.warn("Failed to load texture: " + var1, var8);
         var2 = bml.a;
         this.b.put(var1, var2);
         var3 = false;
      } catch (Throwable var9) {
         b var5 = b.a(var9, "Registering texture");
         c var6 = var5.a("Resource location being registered");
         var6.a((String)"Resource location", (Object)var1);
         var6.a("Texture object class", new Callable<String>(this, (bmk)var2) {
            final bmj b;
            final bmk a;

            public Object call() throws Exception {
               return this.a();
            }

            public String a() throws Exception {
               return this.a.getClass().getName();
            }

            {
               this.b = var1;
               this.a = var2;
            }
         });
         throw new e(var5);
      }

      this.b.put(var1, var2);
      return var3;
   }

   public jy a(String var1, blz var2) {
      Integer var3 = (Integer)this.d.get(var1);
      if (var3 == null) {
         var3 = 1;
      } else {
         var3 = var3 + 1;
      }

      this.d.put(var1, var3);
      jy var4 = new jy(String.format("dynamic/%s_%d", var1, var3));
      this.a((jy)var4, (bmk)var2);
      return var4;
   }

   public void a(bni var1) {
      Iterator var2 = this.b.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.a((jy)var3.getKey(), (bmk)var3.getValue());
      }

   }

   public void e() {
      Iterator var1 = this.c.iterator();

      while(var1.hasNext()) {
         bmm var2 = (bmm)var1.next();
         var2.e();
      }

   }

   public void a(jy var1) {
      Object var2 = (bmk)this.b.get(var1);
      if (var2 == null) {
         var2 = new bme(var1);
         this.a((jy)var1, (bmk)var2);
      }

      bml.b(((bmk)var2).b());
   }

   public boolean a(jy var1, bmn var2) {
      if (this.a((jy)var1, (bmk)var2)) {
         this.c.add(var2);
         return true;
      } else {
         return false;
      }
   }

   public void c(jy var1) {
      bmk var2 = this.b(var1);
      if (var2 != null) {
         bml.a(var2.b());
      }

   }
}
