import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bme extends bly {
   protected final jy f;
   private static final Logger g = LogManager.getLogger();

   public void a(bni var1) throws IOException {
      this.c();
      InputStream var2 = null;

      try {
         bnh var3 = var1.a(this.f);
         var2 = var3.b();
         BufferedImage var4 = bml.a(var2);
         boolean var5 = false;
         boolean var6 = false;
         if (var3.c()) {
            try {
               bon var7 = (bon)var3.a("texture");
               if (var7 != null) {
                  var5 = var7.a();
                  var6 = var7.b();
               }
            } catch (RuntimeException var11) {
               g.warn("Failed reading metadata of: " + this.f, var11);
            }
         }

         bml.a(this.b(), var4, var5, var6);
      } finally {
         if (var2 != null) {
            var2.close();
         }

      }

   }

   public bme(jy var1) {
      this.f = var1;
   }
}
