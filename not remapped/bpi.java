import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import org.apache.commons.lang3.Validate;

public class bpi implements JsonDeserializer<bph> {
   public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      return this.a(var1, var2, var3);
   }

   public bph a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
      JsonObject var4 = ni.l(var1, "entry");
      bph var5 = new bph();
      var5.a(ni.a(var4, "replace", false));
      bpg var6 = bpg.a(ni.a(var4, "category", bpg.a.a()));
      var5.a(var6);
      Validate.notNull(var6, "Invalid category", new Object[0]);
      if (var4.has("sounds")) {
         JsonArray var7 = ni.t(var4, "sounds");

         for(int var8 = 0; var8 < var7.size(); ++var8) {
            JsonElement var9 = var7.get(var8);
            bph.a var10 = new bph.a();
            if (ni.a(var9)) {
               var10.a(ni.a(var9, "sound"));
            } else {
               JsonObject var11 = ni.l(var9, "sound");
               var10.a(ni.h(var11, "name"));
               if (var11.has("type")) {
                  bph.a.a var12 = bph.a.a.a(ni.h(var11, "type"));
                  Validate.notNull(var12, "Invalid type", new Object[0]);
                  var10.a(var12);
               }

               float var13;
               if (var11.has("volume")) {
                  var13 = ni.k(var11, "volume");
                  Validate.isTrue(var13 > 0.0F, "Invalid volume", new Object[0]);
                  var10.a(var13);
               }

               if (var11.has("pitch")) {
                  var13 = ni.k(var11, "pitch");
                  Validate.isTrue(var13 > 0.0F, "Invalid pitch", new Object[0]);
                  var10.b(var13);
               }

               if (var11.has("weight")) {
                  int var14 = ni.m(var11, "weight");
                  Validate.isTrue(var14 > 0, "Invalid weight", new Object[0]);
                  var10.a(var14);
               }

               if (var11.has("stream")) {
                  var10.a(ni.i(var11, "stream"));
               }
            }

            var5.a().add(var10);
         }
      }

      return var5;
   }
}
