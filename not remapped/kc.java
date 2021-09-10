import com.google.common.collect.Lists;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class kc extends IOException {
   private final List<kc.a> a = Lists.newArrayList();
   private final String b;

   public kc(String var1, Throwable var2) {
      super(var2);
      this.a.add(new kc.a());
      this.b = var1;
   }

   public void b(String var1) {
      kc.a.b((kc.a)this.a.get(0), var1);
      this.a.add(0, new kc.a());
   }

   public String getMessage() {
      return "Invalid " + ((kc.a)this.a.get(this.a.size() - 1)).toString() + ": " + this.b;
   }

   public void a(String var1) {
      kc.a.a((kc.a)this.a.get(0), var1);
   }

   public kc(String var1) {
      this.a.add(new kc.a());
      this.b = var1;
   }

   public static kc a(Exception var0) {
      if (var0 instanceof kc) {
         return (kc)var0;
      } else {
         String var1 = var0.getMessage();
         if (var0 instanceof FileNotFoundException) {
            var1 = "File not found";
         }

         return new kc(var1, var0);
      }
   }

   public static class a {
      private final List<String> b;
      private String a;

      static void a(kc.a var0, String var1) {
         var0.a(var1);
      }

      public String toString() {
         if (this.a != null) {
            return !this.b.isEmpty() ? this.a + " " + this.b() : this.a;
         } else {
            return !this.b.isEmpty() ? "(Unknown file) " + this.b() : "(Unknown file)";
         }
      }

      private a() {
         this.a = null;
         this.b = Lists.newArrayList();
      }

      private void a(String var1) {
         this.b.add(0, var1);
      }

      static String b(kc.a var0, String var1) {
         return var0.a = var1;
      }

      a(Object var1) {
         this();
      }

      public String b() {
         return StringUtils.join(this.b, "->");
      }
   }
}
