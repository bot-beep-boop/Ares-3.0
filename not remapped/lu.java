import com.google.gson.JsonObject;
import java.io.File;
import java.net.SocketAddress;

public class lu extends mb<String, lv> {
   private String c(SocketAddress var1) {
      String var2 = var1.toString();
      if (var2.contains("/")) {
         var2 = var2.substring(var2.indexOf(47) + 1);
      }

      if (var2.contains(":")) {
         var2 = var2.substring(0, var2.indexOf(58));
      }

      return var2;
   }

   public boolean a(SocketAddress var1) {
      String var2 = this.c(var1);
      return this.d(var2);
   }

   public lv b(SocketAddress var1) {
      String var2 = this.c(var1);
      return (lv)this.b(var2);
   }

   public lu(File var1) {
      super(var1);
   }

   protected ma<String> a(JsonObject var1) {
      return new lv(var1);
   }
}
