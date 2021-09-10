import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.IntBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class avj {
   private static final Logger a = LogManager.getLogger();
   private static final DateFormat b = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");
   private static int[] d;
   private static IntBuffer c;

   private static File a(File var0) {
      String var2 = b.format(new Date()).toString();
      int var3 = 1;

      while(true) {
         File var1 = new File(var0, var2 + (var3 == 1 ? "" : "_" + var3) + ".png");
         if (!var1.exists()) {
            return var1;
         }

         ++var3;
      }
   }

   public static eu a(File var0, int var1, int var2, bfw var3) {
      return a(var0, (String)null, var1, var2, var3);
   }

   public static eu a(File var0, String var1, int var2, int var3, bfw var4) {
      try {
         File var5 = new File(var0, "screenshots");
         var5.mkdir();
         if (bqs.i()) {
            var2 = var4.a;
            var3 = var4.b;
         }

         int var6 = var2 * var3;
         if (c == null || c.capacity() < var6) {
            c = BufferUtils.createIntBuffer(var6);
            d = new int[var6];
         }

         GL11.glPixelStorei(3333, 1);
         GL11.glPixelStorei(3317, 1);
         c.clear();
         if (bqs.i()) {
            bfl.i(var4.g);
            GL11.glGetTexImage(3553, 0, 32993, 33639, c);
         } else {
            GL11.glReadPixels(0, 0, var2, var3, 32993, 33639, c);
         }

         c.get(d);
         bml.a(d, var2, var3);
         BufferedImage var7 = null;
         if (bqs.i()) {
            var7 = new BufferedImage(var4.c, var4.d, 1);
            int var8 = var4.b - var4.d;

            for(int var9 = var8; var9 < var4.b; ++var9) {
               for(int var10 = 0; var10 < var4.c; ++var10) {
                  var7.setRGB(var10, var9 - var8, d[var9 * var4.a + var10]);
               }
            }
         } else {
            var7 = new BufferedImage(var2, var3, 1);
            var7.setRGB(0, 0, var2, var3, d, 0, var2);
         }

         File var12;
         if (var1 == null) {
            var12 = a(var5);
         } else {
            var12 = new File(var5, var1);
         }

         ImageIO.write(var7, "png", var12);
         fa var13 = new fa(var12.getName());
         var13.b().a(new et(et.a.b, var12.getAbsolutePath()));
         var13.b().d(true);
         return new fb("screenshot.success", new Object[]{var13});
      } catch (Exception var11) {
         a.warn("Couldn't save screenshot", var11);
         return new fb("screenshot.failure", new Object[]{var11.getMessage()});
      }
   }
}
