import com.google.common.collect.Lists;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bmd extends bly {
   private static final Logger g = LogManager.getLogger();
   public final List<String> f;

   public void a(bni var1) throws IOException {
      this.c();
      BufferedImage var2 = null;

      try {
         Iterator var3 = this.f.iterator();

         while(var3.hasNext()) {
            String var4 = (String)var3.next();
            if (var4 != null) {
               InputStream var5 = var1.a(new jy(var4)).b();
               BufferedImage var6 = bml.a(var5);
               if (var2 == null) {
                  var2 = new BufferedImage(var6.getWidth(), var6.getHeight(), 2);
               }

               var2.getGraphics().drawImage(var6, 0, 0, (ImageObserver)null);
            }
         }
      } catch (IOException var7) {
         g.error("Couldn't load layered image", var7);
         return;
      }

      bml.a(this.b(), var2);
   }

   public bmd(String... var1) {
      this.f = Lists.newArrayList(var1);
   }
}
