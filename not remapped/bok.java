import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class bok extends bnv<boj> implements JsonSerializer<boj> {
   public JsonElement a(boj var1, Type var2, JsonSerializationContext var3) {
      JsonObject var4 = new JsonObject();
      var4.addProperty("pack_format", var1.b());
      var4.add("description", var3.serialize(var1.a()));
      return var4;
   }

   public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      return this.a(var1, var2, var3);
   }

   public boj a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      JsonObject var4 = var1.getAsJsonObject();
      eu var5 = (eu)var3.deserialize(var4.get("description"), eu.class);
      if (var5 == null) {
         throw new JsonParseException("Invalid/missing description!");
      } else {
         int var6 = ni.m(var4, "pack_format");
         return new boj(var5, var6);
      }
   }

   public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
      return this.a((boj)var1, var2, var3);
   }

   public String a() {
      return "pack";
   }
}
