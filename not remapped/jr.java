import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;

public class jr implements ff<jp> {
   private static final Gson a = (new GsonBuilder()).registerTypeAdapter(js.c.class, new js.c.a()).registerTypeAdapter(js.a.class, new js.a.a()).registerTypeAdapter(js.class, new js.b()).registerTypeHierarchyAdapter(eu.class, new eu.a()).registerTypeHierarchyAdapter(ez.class, new ez.a()).registerTypeAdapterFactory(new nr()).create();
   private js b;

   public jr() {
   }

   public void a(em var1) throws IOException {
      this.b = (js)a.fromJson(var1.c(32767), js.class);
   }

   public jr(js var1) {
      this.b = var1;
   }

   public void b(em var1) throws IOException {
      var1.a(a.toJson(this.b));
   }

   public void a(jp var1) {
      var1.a(this);
   }

   public js a() {
      return this.b;
   }

   public void a(ep var1) {
      this.a((jp)var1);
   }
}
