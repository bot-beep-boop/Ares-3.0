import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bma extends bme {
   private boolean n;
   private final String j;
   private final bfm k;
   private Thread m;
   private BufferedImage l;
   private static final Logger g = LogManager.getLogger();
   private final File i;
   private static final AtomicInteger h = new AtomicInteger(0);

   static bfm c(bma var0) {
      return var0.k;
   }

   private void g() {
      if (!this.n) {
         if (this.l != null) {
            if (this.f != null) {
               this.c();
            }

            bml.a(super.b(), this.l);
            this.n = true;
         }

      }
   }

   static File b(bma var0) {
      return var0.i;
   }

   static String a(bma var0) {
      return var0.j;
   }

   public bma(File var1, String var2, jy var3, bfm var4) {
      super(var3);
      this.i = var1;
      this.j = var2;
      this.k = var4;
   }

   public void a(bni var1) throws IOException {
      if (this.l == null && this.f != null) {
         super.a(var1);
      }

      if (this.m == null) {
         if (this.i != null && this.i.isFile()) {
            g.debug("Loading http texture from local cache ({})", new Object[]{this.i});

            try {
               this.l = ImageIO.read(this.i);
               if (this.k != null) {
                  this.a(this.k.a(this.l));
               }
            } catch (IOException var3) {
               g.error("Couldn't load skin " + this.i, var3);
               this.d();
            }
         } else {
            this.d();
         }
      }

   }

   public int b() {
      this.g();
      return super.b();
   }

   static Logger f() {
      return g;
   }

   public void a(BufferedImage var1) {
      this.l = var1;
      if (this.k != null) {
         this.k.a();
      }

   }

   protected void d() {
      this.m = new Thread(this, "Texture Downloader #" + h.incrementAndGet()) {
         final bma a;

         {
            this.a = var1;
         }

         public void run() {
            HttpURLConnection var1 = null;
            bma.f().debug("Downloading http texture from {} to {}", new Object[]{bma.a(this.a), bma.b(this.a)});

            try {
               var1 = (HttpURLConnection)(new URL(bma.a(this.a))).openConnection(ave.A().O());
               var1.setDoInput(true);
               var1.setDoOutput(false);
               var1.connect();
               if (var1.getResponseCode() / 100 == 2) {
                  BufferedImage var2;
                  if (bma.b(this.a) != null) {
                     FileUtils.copyInputStreamToFile(var1.getInputStream(), bma.b(this.a));
                     var2 = ImageIO.read(bma.b(this.a));
                  } else {
                     var2 = bml.a(var1.getInputStream());
                  }

                  if (bma.c(this.a) != null) {
                     var2 = bma.c(this.a).a(var2);
                  }

                  this.a.a(var2);
                  return;
               }
            } catch (Exception var6) {
               bma.f().error("Couldn't download http texture", var6);
               return;
            } finally {
               if (var1 != null) {
                  var1.disconnect();
               }

            }

         }
      };
      this.m.setDaemon(true);
      this.m.start();
   }
}
