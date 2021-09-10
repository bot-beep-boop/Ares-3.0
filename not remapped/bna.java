import com.google.common.collect.ImmutableSet;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Set;

public class bna implements bnk {
   public static final Set<String> a = ImmutableSet.of("minecraft", "realms");
   private final Map<String, File> b;

   public InputStream c(jy var1) throws FileNotFoundException {
      File var2 = (File)this.b.get(var1.toString());
      return var2 != null && var2.isFile() ? new FileInputStream(var2) : null;
   }

   private InputStream d(jy var1) {
      return bna.class.getResourceAsStream("/assets/" + var1.b() + "/" + var1.a());
   }

   public InputStream a(jy var1) throws IOException {
      InputStream var2 = this.d(var1);
      if (var2 != null) {
         return var2;
      } else {
         InputStream var3 = this.c(var1);
         if (var3 != null) {
            return var3;
         } else {
            throw new FileNotFoundException(var1.a());
         }
      }
   }

   public Set<String> c() {
      return a;
   }

   public boolean b(jy var1) {
      return this.d(var1) != null || this.b.containsKey(var1.toString());
   }

   public bna(Map<String, File> var1) {
      this.b = var1;
   }

   public <T extends bnw> T a(bny var1, String var2) throws IOException {
      try {
         FileInputStream var3 = new FileInputStream((File)this.b.get("pack.mcmeta"));
         return bmx.a(var1, var3, var2);
      } catch (RuntimeException var4) {
         return null;
      } catch (FileNotFoundException var5) {
         return null;
      }
   }

   public String b() {
      return "Default";
   }

   public BufferedImage a() throws IOException {
      return bml.a(bna.class.getResourceAsStream("/" + (new jy("pack.png")).a()));
   }
}
