import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class bfo {
   private final Map<Integer, bov> a = Maps.newHashMap();
   private final Map<zw, bfp> c = Maps.newHashMap();
   private final Map<Integer, boq> b = Maps.newHashMap();
   private final bou d;

   public bmi a(zw var1) {
      return this.a(var1, 0);
   }

   public void b() {
      this.b.clear();
      Iterator var1 = this.a.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         this.b.put(var2.getKey(), this.d.a((bov)var2.getValue()));
      }

   }

   protected boq b(zw var1, int var2) {
      return (boq)this.b.get(this.c(var1, var2));
   }

   public bfo(bou var1) {
      this.d = var1;
   }

   public bou a() {
      return this.d;
   }

   private int c(zw var1, int var2) {
      return zw.b(var1) << 16 | var2;
   }

   public bmi a(zw var1, int var2) {
      return this.a(new zx(var1, 1, var2)).e();
   }

   public void a(zw var1, int var2, bov var3) {
      this.a.put(this.c(var1, var2), var3);
      this.b.put(this.c(var1, var2), this.d.a(var3));
   }

   public boq a(zx var1) {
      zw var2 = var1.b();
      boq var3 = this.b(var2, this.b(var1));
      if (var3 == null) {
         bfp var4 = (bfp)this.c.get(var2);
         if (var4 != null) {
            var3 = this.d.a(var4.a(var1));
         }
      }

      if (var3 == null) {
         var3 = this.d.a();
      }

      return var3;
   }

   protected int b(zx var1) {
      return var1.e() ? 0 : var1.i();
   }

   public void a(zw var1, bfp var2) {
      this.c.put(var1, var2);
   }
}
