import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class bnc extends bmx implements Closeable {
   private ZipFile c;
   public static final Splitter b = Splitter.on('/').omitEmptyStrings().limit(3);

   public bnc(File var1) {
      super(var1);
   }

   public void close() throws IOException {
      if (this.c != null) {
         this.c.close();
         this.c = null;
      }

   }

   private ZipFile d() throws IOException {
      if (this.c == null) {
         this.c = new ZipFile(this.a);
      }

      return this.c;
   }

   public Set<String> c() {
      ZipFile var1;
      try {
         var1 = this.d();
      } catch (IOException var8) {
         return Collections.emptySet();
      }

      Enumeration var2 = var1.entries();
      HashSet var3 = Sets.newHashSet();

      while(var2.hasMoreElements()) {
         ZipEntry var4 = (ZipEntry)var2.nextElement();
         String var5 = var4.getName();
         if (var5.startsWith("assets/")) {
            ArrayList var6 = Lists.newArrayList(b.split(var5));
            if (var6.size() > 1) {
               String var7 = (String)var6.get(1);
               if (!var7.equals(var7.toLowerCase())) {
                  this.c(var7);
               } else {
                  var3.add(var7);
               }
            }
         }
      }

      return var3;
   }

   protected InputStream a(String var1) throws IOException {
      ZipFile var2 = this.d();
      ZipEntry var3 = var2.getEntry(var1);
      if (var3 == null) {
         throw new bnl(this.a, var1);
      } else {
         return var2.getInputStream(var3);
      }
   }

   public boolean b(String var1) {
      try {
         return this.d().getEntry(var1) != null;
      } catch (IOException var3) {
         return false;
      }
   }

   protected void finalize() throws Throwable {
      this.close();
      super.finalize();
   }
}
