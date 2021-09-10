import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

public interface eu extends Iterable<eu> {
   eu f();

   String d();

   String c();

   List<eu> a();

   String e();

   eu a(eu var1);

   ez b();

   eu a(ez var1);

   eu a(String var1);

   public static class a implements JsonDeserializer<eu>, JsonSerializer<eu> {
      private static final Gson a;

      public eu a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         if (var1.isJsonPrimitive()) {
            return new fa(var1.getAsString());
         } else if (!var1.isJsonObject()) {
            if (var1.isJsonArray()) {
               JsonArray var11 = var1.getAsJsonArray();
               eu var15 = null;
               Iterator var14 = var11.iterator();

               while(var14.hasNext()) {
                  JsonElement var17 = (JsonElement)var14.next();
                  eu var18 = this.a((JsonElement)var17, (Type)var17.getClass(), (JsonDeserializationContext)var3);
                  if (var15 == null) {
                     var15 = var18;
                  } else {
                     var15.a(var18);
                  }
               }

               return var15;
            } else {
               throw new JsonParseException("Don't know how to turn " + var1.toString() + " into a Component");
            }
         } else {
            JsonObject var4 = var1.getAsJsonObject();
            Object var5;
            if (var4.has("text")) {
               var5 = new fa(var4.get("text").getAsString());
            } else if (var4.has("translate")) {
               String var12 = var4.get("translate").getAsString();
               if (var4.has("with")) {
                  JsonArray var7 = var4.getAsJsonArray("with");
                  Object[] var8 = new Object[var7.size()];

                  for(int var9 = 0; var9 < var8.length; ++var9) {
                     var8[var9] = this.a(var7.get(var9), var2, var3);
                     if (var8[var9] instanceof fa) {
                        fa var10 = (fa)var8[var9];
                        if (var10.b().g() && var10.a().isEmpty()) {
                           var8[var9] = var10.g();
                        }
                     }
                  }

                  var5 = new fb(var12, var8);
               } else {
                  var5 = new fb(var12, new Object[0]);
               }
            } else if (var4.has("score")) {
               JsonObject var6 = var4.getAsJsonObject("score");
               if (!var6.has("name") || !var6.has("objective")) {
                  throw new JsonParseException("A score component needs a least a name and an objective");
               }

               var5 = new ex(ni.h(var6, "name"), ni.h(var6, "objective"));
               if (var6.has("value")) {
                  ((ex)var5).b(ni.h(var6, "value"));
               }
            } else {
               if (!var4.has("selector")) {
                  throw new JsonParseException("Don't know how to turn " + var1.toString() + " into a Component");
               }

               var5 = new ey(ni.h(var4, "selector"));
            }

            if (var4.has("extra")) {
               JsonArray var13 = var4.getAsJsonArray("extra");
               if (var13.size() <= 0) {
                  throw new JsonParseException("Unexpected empty array of components");
               }

               for(int var16 = 0; var16 < var13.size(); ++var16) {
                  ((eu)var5).a(this.a(var13.get(var16), var2, var3));
               }
            }

            ((eu)var5).a((ez)var3.deserialize(var1, ez.class));
            return (eu)var5;
         }
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      public static eu a(String var0) {
         return (eu)a.fromJson(var0, eu.class);
      }

      public static String a(eu var0) {
         return a.toJson(var0);
      }

      static {
         GsonBuilder var0 = new GsonBuilder();
         var0.registerTypeHierarchyAdapter(eu.class, new eu.a());
         var0.registerTypeHierarchyAdapter(ez.class, new ez.a());
         var0.registerTypeAdapterFactory(new nr());
         a = var0.create();
      }

      private void a(ez var1, JsonObject var2, JsonSerializationContext var3) {
         JsonElement var4 = var3.serialize(var1);
         if (var4.isJsonObject()) {
            JsonObject var5 = (JsonObject)var4;
            Iterator var6 = var5.entrySet().iterator();

            while(var6.hasNext()) {
               Entry var7 = (Entry)var6.next();
               var2.add((String)var7.getKey(), (JsonElement)var7.getValue());
            }
         }

      }

      public JsonElement a(eu var1, Type var2, JsonSerializationContext var3) {
         if (var1 instanceof fa && var1.b().g() && var1.a().isEmpty()) {
            return new JsonPrimitive(((fa)var1).g());
         } else {
            JsonObject var4 = new JsonObject();
            if (!var1.b().g()) {
               this.a(var1.b(), var4, var3);
            }

            if (!var1.a().isEmpty()) {
               JsonArray var5 = new JsonArray();
               Iterator var6 = var1.a().iterator();

               while(var6.hasNext()) {
                  eu var7 = (eu)var6.next();
                  var5.add(this.a((eu)var7, (Type)var7.getClass(), (JsonSerializationContext)var3));
               }

               var4.add("extra", var5);
            }

            if (var1 instanceof fa) {
               var4.addProperty("text", ((fa)var1).g());
            } else if (var1 instanceof fb) {
               fb var11 = (fb)var1;
               var4.addProperty("translate", var11.i());
               if (var11.j() != null && var11.j().length > 0) {
                  JsonArray var14 = new JsonArray();
                  Object[] var16 = var11.j();
                  int var8 = var16.length;

                  for(int var9 = 0; var9 < var8; ++var9) {
                     Object var10 = var16[var9];
                     if (var10 instanceof eu) {
                        var14.add(this.a((eu)((eu)var10), (Type)var10.getClass(), (JsonSerializationContext)var3));
                     } else {
                        var14.add(new JsonPrimitive(String.valueOf(var10)));
                     }
                  }

                  var4.add("with", var14);
               }
            } else if (var1 instanceof ex) {
               ex var12 = (ex)var1;
               JsonObject var15 = new JsonObject();
               var15.addProperty("name", var12.g());
               var15.addProperty("objective", var12.h());
               var15.addProperty("value", var12.e());
               var4.add("score", var15);
            } else {
               if (!(var1 instanceof ey)) {
                  throw new IllegalArgumentException("Don't know how to serialize " + var1 + " as a Component");
               }

               ey var13 = (ey)var1;
               var4.addProperty("selector", var13.g());
            }

            return var4;
         }
      }

      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((eu)var1, var2, var3);
      }
   }
}
