import com.google.common.collect.Maps;
import java.util.Map;

public class nb {
   protected final Map<mw, my> a = Maps.newConcurrentMap();

   public int c(mq var1) {
      if (this.a(var1)) {
         return 0;
      } else {
         int var2 = 0;

         for(mq var3 = var1.c; var3 != null && !this.a(var3); ++var2) {
            var3 = var3.c;
         }

         return var2;
      }
   }

   public boolean a(mq var1) {
      return this.a((mw)var1) > 0;
   }

   public void b(wn var1, mw var2, int var3) {
      if (!var2.d() || this.b((mq)var2)) {
         this.a(var1, var2, this.a(var2) + var3);
      }
   }

   public <T extends mz> T a(mw var1, T var2) {
      my var3 = (my)this.a.get(var1);
      if (var3 == null) {
         var3 = new my();
         this.a.put(var1, var3);
      }

      var3.a(var2);
      return var2;
   }

   public boolean b(mq var1) {
      return var1.c == null || this.a(var1.c);
   }

   public void a(wn var1, mw var2, int var3) {
      my var4 = (my)this.a.get(var2);
      if (var4 == null) {
         var4 = new my();
         this.a.put(var2, var4);
      }

      var4.a(var3);
   }

   public int a(mw var1) {
      my var2 = (my)this.a.get(var1);
      return var2 == null ? 0 : var2.a();
   }

   public <T extends mz> T b(mw var1) {
      my var2 = (my)this.a.get(var1);
      return var2 != null ? var2.b() : null;
   }
}
