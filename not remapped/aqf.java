import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class aqf extends aqq {
   private double d = 0.004D;

   protected aqu b(int var1, int var2) {
      return new aqh(this.c, this.b, var1, var2);
   }

   public aqf() {
   }

   protected boolean a(int var1, int var2) {
      return this.b.nextDouble() < this.d && this.b.nextInt(80) < Math.max(Math.abs(var1), Math.abs(var2));
   }

   public aqf(Map<String, String> var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (((String)var3.getKey()).equals("chance")) {
            this.d = ns.a((String)var3.getValue(), this.d);
         }
      }

   }

   public String a() {
      return "Mineshaft";
   }
}
