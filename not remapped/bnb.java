import com.google.common.collect.Lists;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bnb implements bni {
   protected final List<bnk> a = Lists.newArrayList();
   private static final Logger b = LogManager.getLogger();
   private final bny c;

   public Set<String> a() {
      return null;
   }

   public bnh a(jy var1) throws IOException {
      bnk var2 = null;
      jy var3 = c(var1);

      for(int var4 = this.a.size() - 1; var4 >= 0; --var4) {
         bnk var5 = (bnk)this.a.get(var4);
         if (var2 == null && var5.b(var3)) {
            var2 = var5;
         }

         if (var5.b(var1)) {
            InputStream var6 = null;
            if (var2 != null) {
               var6 = this.a(var3, var2);
            }

            return new bno(var5.b(), var1, this.a(var1, var5), var6, this.c);
         }
      }

      throw new FileNotFoundException(var1.toString());
   }

   static Logger b() {
      return b;
   }

   protected InputStream a(jy var1, bnk var2) throws IOException {
      InputStream var3 = var2.a(var1);
      return (InputStream)(b.isDebugEnabled() ? new bnb.a(var3, var1, var2.b()) : var3);
   }

   public bnb(bny var1) {
      this.c = var1;
   }

   static jy c(jy var0) {
      return new jy(var0.b(), var0.a() + ".mcmeta");
   }

   public void a(bnk var1) {
      this.a.add(var1);
   }

   public List<bnh> b(jy var1) throws IOException {
      ArrayList var2 = Lists.newArrayList();
      jy var3 = c(var1);
      Iterator var4 = this.a.iterator();

      while(var4.hasNext()) {
         bnk var5 = (bnk)var4.next();
         if (var5.b(var1)) {
            InputStream var6 = var5.b(var3) ? this.a(var3, var5) : null;
            var2.add(new bno(var5.b(), var1, this.a(var1, var5), var6, this.c));
         }
      }

      if (var2.isEmpty()) {
         throw new FileNotFoundException(var1.toString());
      } else {
         return var2;
      }
   }

   static class a extends InputStream {
      private final InputStream a;
      private final String b;
      private boolean c = false;

      public int read() throws IOException {
         return this.a.read();
      }

      public void close() throws IOException {
         this.a.close();
         this.c = true;
      }

      public a(InputStream var1, jy var2, String var3) {
         this.a = var1;
         ByteArrayOutputStream var4 = new ByteArrayOutputStream();
         (new Exception()).printStackTrace(new PrintStream(var4));
         this.b = "Leaked resource: '" + var2 + "' loaded from pack: '" + var3 + "'\n" + var4.toString();
      }

      protected void finalize() throws Throwable {
         if (!this.c) {
            bnb.b().warn(this.b);
         }

         super.finalize();
      }
   }
}
