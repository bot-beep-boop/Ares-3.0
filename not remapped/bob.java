import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import org.apache.commons.lang3.Validate;

public class bob extends bnv<boa> implements JsonSerializer<boa> {
   public JsonElement a(boa var1, Type var2, JsonSerializationContext var3) {
      JsonObject var4 = new JsonObject();
      var4.addProperty("frametime", var1.d());
      if (var1.b() != -1) {
         var4.addProperty("width", var1.b());
      }

      if (var1.a() != -1) {
         var4.addProperty("height", var1.a());
      }

      if (var1.c() > 0) {
         JsonArray var5 = new JsonArray();

         for(int var6 = 0; var6 < var1.c(); ++var6) {
            if (var1.b(var6)) {
               JsonObject var7 = new JsonObject();
               var7.addProperty("index", var1.c(var6));
               var7.addProperty("time", var1.a(var6));
               var5.add(var7);
            } else {
               var5.add(new JsonPrimitive(var1.c(var6)));
            }
         }

         var4.add("frames", var5);
      }

      return var4;
   }

   public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      return this.a(var1, var2, var3);
   }

   public String a() {
      return "animation";
   }

   private bnz a(int var1, JsonElement var2) {
      if (var2.isJsonPrimitive()) {
         return new bnz(ni.f(var2, "frames[" + var1 + "]"));
      } else if (var2.isJsonObject()) {
         JsonObject var3 = ni.l(var2, "frames[" + var1 + "]");
         int var4 = ni.a(var3, "time", -1);
         if (var3.has("time")) {
            Validate.inclusiveBetween(1L, 2147483647L, (long)var4, "Invalid frame time");
         }

         int var5 = ni.m(var3, "index");
         Validate.inclusiveBetween(0L, 2147483647L, (long)var5, "Invalid frame index");
         return new bnz(var5, var4);
      } else {
         return null;
      }
   }

   public boa a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      ArrayList var4 = Lists.newArrayList();
      JsonObject var5 = ni.l(var1, "metadata section");
      int var6 = ni.a(var5, "frametime", 1);
      if (var6 != 1) {
         Validate.inclusiveBetween(1L, 2147483647L, (long)var6, "Invalid default frame time");
      }

      int var8;
      if (var5.has("frames")) {
         try {
            JsonArray var7 = ni.t(var5, "frames");

            for(var8 = 0; var8 < var7.size(); ++var8) {
               JsonElement var9 = var7.get(var8);
               bnz var10 = this.a(var8, var9);
               if (var10 != null) {
                  var4.add(var10);
               }
            }
         } catch (ClassCastException var11) {
            throw new JsonParseException("Invalid animation->frames: expected array, was " + var5.get("frames"), var11);
         }
      }

      int var12 = ni.a(var5, "width", -1);
      var8 = ni.a(var5, "height", -1);
      if (var12 != -1) {
         Validate.inclusiveBetween(1L, 2147483647L, (long)var12, "Invalid width");
      }

      if (var8 != -1) {
         Validate.inclusiveBetween(1L, 2147483647L, (long)var8, "Invalid height");
      }

      boolean var13 = ni.a(var5, "interpolate", false);
      return new boa(var4, var12, var8, var6, var13);
   }

   public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
      return this.a((boa)var1, var2, var3);
   }
}
