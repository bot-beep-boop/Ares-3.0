import com.google.gson.JsonObject;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ls<T> extends ma<T> {
   protected final Date d;
   protected final Date b;
   public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
   protected final String e;
   protected final String c;

   public String d() {
      return this.e;
   }

   protected void a(JsonObject var1) {
      var1.addProperty("created", a.format(this.b));
      var1.addProperty("source", this.c);
      var1.addProperty("expires", this.d == null ? "forever" : a.format(this.d));
      var1.addProperty("reason", this.e);
   }

   boolean e() {
      return this.d == null ? false : this.d.before(new Date());
   }

   protected ls(T var1, JsonObject var2) {
      super(var1, var2);

      Date var3;
      try {
         var3 = var2.has("created") ? a.parse(var2.get("created").getAsString()) : new Date();
      } catch (ParseException var7) {
         var3 = new Date();
      }

      this.b = var3;
      this.c = var2.has("source") ? var2.get("source").getAsString() : "(Unknown)";

      Date var4;
      try {
         var4 = var2.has("expires") ? a.parse(var2.get("expires").getAsString()) : null;
      } catch (ParseException var6) {
         var4 = null;
      }

      this.d = var4;
      this.e = var2.has("reason") ? var2.get("reason").getAsString() : "Banned by an operator.";
   }

   public ls(T var1, Date var2, String var3, Date var4, String var5) {
      super(var1);
      this.b = var2 == null ? new Date() : var2;
      this.c = var3 == null ? "(Unknown)" : var3;
      this.d = var4;
      this.e = var5 == null ? "Banned by an operator." : var5;
   }

   public Date c() {
      return this.d;
   }
}
