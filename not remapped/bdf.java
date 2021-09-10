import com.google.common.collect.Lists;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bdf {
   private final ave b;
   private final List<bde> c = Lists.newArrayList();
   private static final Logger a = LogManager.getLogger();

   public void a(int var1, bde var2) {
      this.c.set(var1, var2);
   }

   public void b(int var1) {
      this.c.remove(var1);
   }

   public bde a(int var1) {
      return (bde)this.c.get(var1);
   }

   public void a() {
      try {
         this.c.clear();
         dn var1 = dx.a(new File(this.b.v, "servers.dat"));
         if (var1 == null) {
            return;
         }

         du var2 = var1.c("servers", 10);

         for(int var3 = 0; var3 < var2.c(); ++var3) {
            this.c.add(bde.a(var2.b(var3)));
         }
      } catch (Exception var4) {
         a.error("Couldn't load server list", var4);
      }

   }

   public void a(int var1, int var2) {
      bde var3 = this.a(var1);
      this.c.set(var1, this.a(var2));
      this.c.set(var2, var3);
      this.b();
   }

   public int c() {
      return this.c.size();
   }

   public void a(bde var1) {
      this.c.add(var1);
   }

   public static void b(bde var0) {
      bdf var1 = new bdf(ave.A());
      var1.a();

      for(int var2 = 0; var2 < var1.c(); ++var2) {
         bde var3 = var1.a(var2);
         if (var3.a.equals(var0.a) && var3.b.equals(var0.b)) {
            var1.a(var2, var0);
            break;
         }
      }

      var1.b();
   }

   public bdf(ave var1) {
      this.b = var1;
      this.a();
   }

   public void b() {
      try {
         du var1 = new du();
         Iterator var2 = this.c.iterator();

         while(var2.hasNext()) {
            bde var3 = (bde)var2.next();
            var1.a((eb)var3.a());
         }

         dn var5 = new dn();
         var5.a((String)"servers", (eb)var1);
         dx.a(var5, new File(this.b.v, "servers.dat"));
      } catch (Exception var4) {
         a.error("Couldn't save server list", var4);
      }

   }
}
