import java.awt.image.BufferedImage;
import java.io.IOException;

public class blz extends bly {
   private final int h;
   private final int g;
   private final int[] f;

   public void a(bni var1) throws IOException {
   }

   public void d() {
      bml.a(this.b(), this.f, this.g, this.h);
   }

   public blz(BufferedImage var1) {
      this(var1.getWidth(), var1.getHeight());
      var1.getRGB(0, 0, var1.getWidth(), var1.getHeight(), this.f, 0, var1.getWidth());
      this.d();
   }

   public int[] e() {
      return this.f;
   }

   public blz(int var1, int var2) {
      this.g = var1;
      this.h = var2;
      this.f = new int[var1 * var2];
      bml.a(this.b(), var1, var2);
   }
}
