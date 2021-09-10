import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class bny {
   private Gson c;
   private final db<String, bny.a<? extends bnw>> a = new dd();
   private final GsonBuilder b = new GsonBuilder();

   public bny() {
      this.b.registerTypeHierarchyAdapter(eu.class, new eu.a());
      this.b.registerTypeHierarchyAdapter(ez.class, new ez.a());
      this.b.registerTypeAdapterFactory(new nr());
   }

   private Gson a() {
      if (this.c == null) {
         this.c = this.b.create();
      }

      return this.c;
   }

   public <T extends bnw> T a(String var1, JsonObject var2) {
      if (var1 == null) {
         throw new IllegalArgumentException("Metadata section name cannot be null");
      } else if (!var2.has(var1)) {
         return null;
      } else if (!var2.get(var1).isJsonObject()) {
         throw new IllegalArgumentException("Invalid metadata for '" + var1 + "' - expected object, found " + var2.get(var1));
      } else {
         bny.a var3 = (bny.a)this.a.a(var1);
         if (var3 == null) {
            throw new IllegalArgumentException("Don't know how to handle metadata section '" + var1 + "'");
         } else {
            return (bnw)this.a().fromJson(var2.getAsJsonObject(var1), var3.b);
         }
      }
   }

   public <T extends bnw> void a(bnx<T> var1, Class<T> var2) {
      this.a.a(var1.a(), new bny.a(this, var1, var2));
      this.b.registerTypeAdapter(var2, var1);
      this.c = null;
   }

   class a<T extends bnw> {
      final bny c;
      final Class<T> b;
      final bnx<T> a;

      a(bny var1, bnx var2, Class var3, Object var4) {
         this(var1, var2, var3);
      }

      private a(bny var1, bnx var2, Class var3) {
         this.c = var1;
         this.a = var2;
         this.b = var3;
      }
   }
}
