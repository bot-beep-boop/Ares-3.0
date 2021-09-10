import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class nc extends ForwardingSet<String> implements mz {
   private final Set<String> a = Sets.newHashSet();

   protected Object delegate() {
      return this.delegate();
   }

   public JsonElement a() {
      JsonArray var1 = new JsonArray();
      Iterator var2 = this.iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();
         var1.add(new JsonPrimitive(var3));
      }

      return var1;
   }

   protected Set<String> delegate() {
      return this.a;
   }

   protected Collection delegate() {
      return this.delegate();
   }

   public void a(JsonElement var1) {
      if (var1.isJsonArray()) {
         Iterator var2 = var1.getAsJsonArray().iterator();

         while(var2.hasNext()) {
            JsonElement var3 = (JsonElement)var2.next();
            this.add(var3.getAsString());
         }
      }

   }
}
