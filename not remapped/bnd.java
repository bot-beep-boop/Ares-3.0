import com.google.common.collect.Sets;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import org.apache.commons.io.filefilter.DirectoryFileFilter;

public class bnd extends bmx {
   public bnd(File var1) {
      super(var1);
   }

   protected boolean b(String var1) {
      return (new File(this.a, var1)).isFile();
   }

   protected InputStream a(String var1) throws IOException {
      return new BufferedInputStream(new FileInputStream(new File(this.a, var1)));
   }

   public Set<String> c() {
      HashSet var1 = Sets.newHashSet();
      File var2 = new File(this.a, "assets/");
      if (var2.isDirectory()) {
         File[] var3 = var2.listFiles(DirectoryFileFilter.DIRECTORY);
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            File var6 = var3[var5];
            String var7 = a(var2, var6);
            if (!var7.equals(var7.toLowerCase())) {
               this.c(var7);
            } else {
               var1.add(var7.substring(0, var7.length() - 1));
            }
         }
      }

      return var1;
   }
}
