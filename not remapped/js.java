import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.GameProfile;
import java.lang.reflect.Type;
import java.util.UUID;

public class js {
   private js.c c;
   private String d;
   private eu a;
   private js.a b;

   public js.a b() {
      return this.b;
   }

   public void a(String var1) {
      this.d = var1;
   }

   public eu a() {
      return this.a;
   }

   public void a(js.a var1) {
      this.b = var1;
   }

   public String d() {
      return this.d;
   }

   public void a(eu var1) {
      this.a = var1;
   }

   public js.c c() {
      return this.c;
   }

   public void a(js.c var1) {
      this.c = var1;
   }

   public static class c {
      private final int b;
      private final String a;

      public int b() {
         return this.b;
      }

      public c(String var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public String a() {
         return this.a;
      }

      public static class a implements JsonDeserializer<js.c>, JsonSerializer<js.c> {
         public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            return this.a(var1, var2, var3);
         }

         public js.c a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            JsonObject var4 = ni.l(var1, "version");
            return new js.c(ni.h(var4, "name"), ni.m(var4, "protocol"));
         }

         public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
            return this.a((js.c)var1, var2, var3);
         }

         public JsonElement a(js.c var1, Type var2, JsonSerializationContext var3) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("name", var1.a());
            var4.addProperty("protocol", var1.b());
            return var4;
         }
      }
   }

   public static class b implements JsonDeserializer<js>, JsonSerializer<js> {
      public JsonElement a(js var1, Type var2, JsonSerializationContext var3) {
         JsonObject var4 = new JsonObject();
         if (var1.a() != null) {
            var4.add("description", var3.serialize(var1.a()));
         }

         if (var1.b() != null) {
            var4.add("players", var3.serialize(var1.b()));
         }

         if (var1.c() != null) {
            var4.add("version", var3.serialize(var1.c()));
         }

         if (var1.d() != null) {
            var4.addProperty("favicon", var1.d());
         }

         return var4;
      }

      public js a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = ni.l(var1, "status");
         js var5 = new js();
         if (var4.has("description")) {
            var5.a((eu)var3.deserialize(var4.get("description"), eu.class));
         }

         if (var4.has("players")) {
            var5.a((js.a)var3.deserialize(var4.get("players"), js.a.class));
         }

         if (var4.has("version")) {
            var5.a((js.c)var3.deserialize(var4.get("version"), js.c.class));
         }

         if (var4.has("favicon")) {
            var5.a(ni.h(var4, "favicon"));
         }

         return var5;
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((js)var1, var2, var3);
      }
   }

   public static class a {
      private final int b;
      private final int a;
      private GameProfile[] c;

      public a(int var1, int var2) {
         this.a = var1;
         this.b = var2;
      }

      public int b() {
         return this.b;
      }

      public void a(GameProfile[] var1) {
         this.c = var1;
      }

      public int a() {
         return this.a;
      }

      public GameProfile[] c() {
         return this.c;
      }

      public static class a implements JsonDeserializer<js.a>, JsonSerializer<js.a> {
         public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
            return this.a((js.a)var1, var2, var3);
         }

         public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            return this.a(var1, var2, var3);
         }

         public js.a a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            JsonObject var4 = ni.l(var1, "players");
            js.a var5 = new js.a(ni.m(var4, "max"), ni.m(var4, "online"));
            if (ni.d(var4, "sample")) {
               JsonArray var6 = ni.t(var4, "sample");
               if (var6.size() > 0) {
                  GameProfile[] var7 = new GameProfile[var6.size()];

                  for(int var8 = 0; var8 < var7.length; ++var8) {
                     JsonObject var9 = ni.l(var6.get(var8), "player[" + var8 + "]");
                     String var10 = ni.h(var9, "id");
                     var7[var8] = new GameProfile(UUID.fromString(var10), ni.h(var9, "name"));
                  }

                  var5.a(var7);
               }
            }

            return var5;
         }

         public JsonElement a(js.a var1, Type var2, JsonSerializationContext var3) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("max", var1.a());
            var4.addProperty("online", var1.b());
            if (var1.c() != null && var1.c().length > 0) {
               JsonArray var5 = new JsonArray();

               for(int var6 = 0; var6 < var1.c().length; ++var6) {
                  JsonObject var7 = new JsonObject();
                  UUID var8 = var1.c()[var6].getId();
                  var7.addProperty("id", var8 == null ? "" : var8.toString());
                  var7.addProperty("name", var1.c()[var6].getName());
                  var5.add(var7);
               }

               var4.add("sample", var5);
            }

            return var4;
         }
      }
   }
}
