import com.google.common.collect.Maps;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.Map.Entry;

public class or {
   private final String c = UUID.randomUUID().toString();
   private final os e;
   private boolean i;
   private final Timer f = new Timer("Snooper Timer", true);
   private final URL d;
   private final Map<String, Object> b = Maps.newHashMap();
   private final long h;
   private final Map<String, Object> a = Maps.newHashMap();
   private int j;
   private final Object g = new Object();

   public void a(String var1, Object var2) {
      synchronized(this.g) {
         this.b.put(var1, var2);
      }
   }

   public or(String var1, os var2, long var3) {
      try {
         this.d = new URL("http://snoop.minecraft.net/" + var1 + "?version=" + 2);
      } catch (MalformedURLException var6) {
         throw new IllegalArgumentException();
      }

      this.e = var2;
      this.h = var3;
   }

   static URL h(or var0) {
      return var0.d;
   }

   public long g() {
      return this.h;
   }

   static int d(or var0) {
      return var0.j;
   }

   public void e() {
      this.f.cancel();
   }

   public Map<String, String> c() {
      LinkedHashMap var1 = Maps.newLinkedHashMap();
      synchronized(this.g) {
         this.b();
         Iterator var3 = this.a.entrySet().iterator();

         Entry var4;
         while(var3.hasNext()) {
            var4 = (Entry)var3.next();
            var1.put(var4.getKey(), var4.getValue().toString());
         }

         var3 = this.b.entrySet().iterator();

         while(var3.hasNext()) {
            var4 = (Entry)var3.next();
            var1.put(var4.getKey(), var4.getValue().toString());
         }

         return var1;
      }
   }

   static Map c(or var0) {
      return var0.b;
   }

   static String g(or var0) {
      return var0.c;
   }

   static Map e(or var0) {
      return var0.a;
   }

   public String f() {
      return this.c;
   }

   public boolean d() {
      return this.i;
   }

   static os a(or var0) {
      return var0.e;
   }

   static int f(or var0) {
      return var0.j++;
   }

   public void a() {
      if (!this.i) {
         this.i = true;
         this.h();
         this.f.schedule(new TimerTask(this) {
            final or a;

            public void run() {
               if (or.a(this.a).ad()) {
                  HashMap var1;
                  synchronized(or.b(this.a)) {
                     var1 = Maps.newHashMap(or.c(this.a));
                     if (or.d(this.a) == 0) {
                        var1.putAll(or.e(this.a));
                     }

                     var1.put("snooper_count", or.f(this.a));
                     var1.put("snooper_token", or.g(this.a));
                  }

                  nj.a(or.h(this.a), (Map)var1, true);
               }
            }

            {
               this.a = var1;
            }
         }, 0L, 900000L);
      }
   }

   private void h() {
      this.i();
      this.a("snooper_token", this.c);
      this.b("snooper_token", this.c);
      this.b("os_name", System.getProperty("os.name"));
      this.b("os_version", System.getProperty("os.version"));
      this.b("os_architecture", System.getProperty("os.arch"));
      this.b("java_version", System.getProperty("java.version"));
      this.a("version", "1.8.9");
      this.e.b(this);
   }

   public void b() {
      this.b("memory_total", Runtime.getRuntime().totalMemory());
      this.b("memory_max", Runtime.getRuntime().maxMemory());
      this.b("memory_free", Runtime.getRuntime().freeMemory());
      this.b("cpu_cores", Runtime.getRuntime().availableProcessors());
      this.e.a(this);
   }

   public void b(String var1, Object var2) {
      synchronized(this.g) {
         this.a.put(var1, var2);
      }
   }

   static Object b(or var0) {
      return var0.g;
   }

   private void i() {
      RuntimeMXBean var1 = ManagementFactory.getRuntimeMXBean();
      List var2 = var1.getInputArguments();
      int var3 = 0;
      Iterator var4 = var2.iterator();

      while(var4.hasNext()) {
         String var5 = (String)var4.next();
         if (var5.startsWith("-X")) {
            this.a("jvm_arg[" + var3++ + "]", var5);
         }
      }

      this.a("jvm_args", var3);
   }
}
