import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class blu {
   private static final Logger a = LogManager.getLogger();
   private static blu b;

   public int c() throws kc {
      int var1 = bqs.d();
      if (var1 <= 0) {
         throw new kc("Could not create shader program (returned program ID " + var1 + ")");
      } else {
         return var1;
      }
   }

   public static blu b() {
      return b;
   }

   public static void a() {
      b = new blu();
   }

   public void b(blq var1) throws IOException {
      var1.f().a(var1);
      var1.e().a(var1);
      bqs.f(var1.h());
      int var2 = bqs.a(var1.h(), bqs.m);
      if (var2 == 0) {
         a.warn("Error encountered when linking program containing VS " + var1.e().a() + " and FS " + var1.f().a() + ". Log output:");
         a.warn(bqs.e(var1.h(), 32768));
      }

   }

   public void a(blq var1) {
      var1.f().b(var1);
      var1.e().b(var1);
      bqs.e(var1.h());
   }

   private blu() {
   }
}
