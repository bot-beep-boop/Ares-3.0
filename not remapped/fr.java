import com.google.common.collect.Maps;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class fr implements ff<fj> {
   private Map<mw, Integer> a;

   public fr() {
   }

   public void a(em var1) throws IOException {
      int var2 = var1.e();
      this.a = Maps.newHashMap();

      for(int var3 = 0; var3 < var2; ++var3) {
         mw var4 = na.a(var1.c(32767));
         int var5 = var1.e();
         if (var4 != null) {
            this.a.put(var4, var5);
         }
      }

   }

   public void a(fj var1) {
      var1.a(this);
   }

   public void b(em var1) throws IOException {
      var1.b(this.a.size());
      Iterator var2 = this.a.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.a(((mw)var3.getKey()).e);
         var1.b((Integer)var3.getValue());
      }

   }

   public fr(Map<mw, Integer> var1) {
      this.a = var1;
   }

   public void a(ep var1) {
      this.a((fj)var1);
   }

   public Map<mw, Integer> a() {
      return this.a;
   }
}
