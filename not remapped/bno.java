import com.google.common.collect.Maps;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;
import org.apache.commons.io.IOUtils;

public class bno implements bnh {
   private boolean g;
   private JsonObject h;
   private final String b;
   private final InputStream d;
   private final bny f;
   private final Map<String, bnw> a = Maps.newHashMap();
   private final jy c;
   private final InputStream e;

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof bno)) {
         return false;
      } else {
         bno var2;
         label38: {
            var2 = (bno)var1;
            if (this.c != null) {
               if (this.c.equals(var2.c)) {
                  break label38;
               }
            } else if (var2.c == null) {
               break label38;
            }

            return false;
         }

         if (this.b != null) {
            if (!this.b.equals(var2.b)) {
               return false;
            }
         } else if (var2.b != null) {
            return false;
         }

         return true;
      }
   }

   public String d() {
      return this.b;
   }

   public InputStream b() {
      return this.d;
   }

   public int hashCode() {
      int var1 = this.b != null ? this.b.hashCode() : 0;
      var1 = 31 * var1 + (this.c != null ? this.c.hashCode() : 0);
      return var1;
   }

   public jy a() {
      return this.c;
   }

   public boolean c() {
      return this.e != null;
   }

   public bno(String var1, jy var2, InputStream var3, InputStream var4, bny var5) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
      this.f = var5;
   }

   public <T extends bnw> T a(String var1) {
      if (!this.c()) {
         return null;
      } else {
         if (this.h == null && !this.g) {
            this.g = true;
            BufferedReader var2 = null;

            try {
               var2 = new BufferedReader(new InputStreamReader(this.e));
               this.h = (new JsonParser()).parse(var2).getAsJsonObject();
            } finally {
               IOUtils.closeQuietly(var2);
            }
         }

         bnw var6 = (bnw)this.a.get(var1);
         if (var6 == null) {
            var6 = this.f.a(var1, this.h);
         }

         return var6;
      }
   }
}
