import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bmc extends bly {
   private final List<zd> i;
   private final jy g;
   private static final Logger f = LogManager.getLogger();
   private final List<String> h;

   public void a(bni var1) throws IOException {
      this.c();

      BufferedImage var2;
      try {
         BufferedImage var3 = bml.a(var1.a(this.g).b());
         int var4 = var3.getType();
         if (var4 == 0) {
            var4 = 6;
         }

         var2 = new BufferedImage(var3.getWidth(), var3.getHeight(), var4);
         Graphics var5 = var2.getGraphics();
         var5.drawImage(var3, 0, 0, (ImageObserver)null);

         for(int var6 = 0; var6 < 17 && var6 < this.h.size() && var6 < this.i.size(); ++var6) {
            String var7 = (String)this.h.get(var6);
            arn var8 = ((zd)this.i.get(var6)).e();
            if (var7 != null) {
               InputStream var9 = var1.a(new jy(var7)).b();
               BufferedImage var10 = bml.a(var9);
               if (var10.getWidth() == var2.getWidth() && var10.getHeight() == var2.getHeight() && var10.getType() == 6) {
                  for(int var11 = 0; var11 < var10.getHeight(); ++var11) {
                     for(int var12 = 0; var12 < var10.getWidth(); ++var12) {
                        int var13 = var10.getRGB(var12, var11);
                        if ((var13 & -16777216) != 0) {
                           int var14 = (var13 & 16711680) << 8 & -16777216;
                           int var15 = var3.getRGB(var12, var11);
                           int var16 = ns.d(var15, var8.L) & 16777215;
                           var10.setRGB(var12, var11, var14 | var16);
                        }
                     }
                  }

                  var2.getGraphics().drawImage(var10, 0, 0, (ImageObserver)null);
               }
            }
         }
      } catch (IOException var17) {
         f.error("Couldn't load layered image", var17);
         return;
      }

      bml.a(this.b(), var2);
   }

   public bmc(jy var1, List<String> var2, List<zd> var3) {
      this.g = var1;
      this.h = var2;
      this.i = var3;
   }
}
