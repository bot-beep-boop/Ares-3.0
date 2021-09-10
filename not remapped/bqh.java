import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import java.util.Map;

public class bqh {
   private Map<String, String> d;
   private String c;
   private final String b;
   private static final Gson a = new Gson();

   public String toString() {
      return Objects.toStringHelper(this).add("name", this.b).add("description", this.c).add("data", this.b()).toString();
   }

   public bqh(String var1) {
      this(var1, (String)null);
   }

   public String b() {
      return this.d != null && !this.d.isEmpty() ? a.toJson(this.d) : null;
   }

   public void a(String var1) {
      this.c = var1;
   }

   public void a(String var1, String var2) {
      if (this.d == null) {
         this.d = Maps.newHashMap();
      }

      if (this.d.size() > 50) {
         throw new IllegalArgumentException("Metadata payload is full, cannot add more to it!");
      } else if (var1 == null) {
         throw new IllegalArgumentException("Metadata payload key cannot be null!");
      } else if (var1.length() > 255) {
         throw new IllegalArgumentException("Metadata payload key is too long!");
      } else if (var2 == null) {
         throw new IllegalArgumentException("Metadata payload value cannot be null!");
      } else if (var2.length() > 255) {
         throw new IllegalArgumentException("Metadata payload value is too long!");
      } else {
         this.d.put(var1, var2);
      }
   }

   public bqh(String var1, String var2) {
      this.b = var1;
      this.c = var2;
   }

   public String c() {
      return this.b;
   }

   public String a() {
      return this.c == null ? this.b : this.c;
   }
}
