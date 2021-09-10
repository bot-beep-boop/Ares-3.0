import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class bgm {
   private final Map<String, bgm.d> b = Maps.newHashMap();
   static final Gson a = (new GsonBuilder()).registerTypeAdapter(bgm.class, new bgm.a()).registerTypeAdapter(bgm.c.class, new bgm.c.a()).create();

   public bgm(List<bgm> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         bgm var3 = (bgm)var2.next();
         this.b.putAll(var3.b);
      }

   }

   public bgm(Collection<bgm.d> var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         bgm.d var3 = (bgm.d)var2.next();
         this.b.put(bgm.d.a(var3), var3);
      }

   }

   public bgm.d b(String var1) {
      bgm.d var2 = (bgm.d)this.b.get(var1);
      if (var2 == null) {
         throw new bgm.b(this);
      } else {
         return var2;
      }
   }

   public static bgm a(Reader var0) {
      return (bgm)a.fromJson(var0, bgm.class);
   }

   public int hashCode() {
      return this.b.hashCode();
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 instanceof bgm) {
         bgm var2 = (bgm)var1;
         return this.b.equals(var2.b);
      } else {
         return false;
      }
   }

   public static class a implements JsonDeserializer<bgm> {
      protected bgm.d a(JsonDeserializationContext var1, Entry<String, JsonElement> var2) {
         String var3 = (String)var2.getKey();
         ArrayList var4 = Lists.newArrayList();
         JsonElement var5 = (JsonElement)var2.getValue();
         if (var5.isJsonArray()) {
            Iterator var6 = var5.getAsJsonArray().iterator();

            while(var6.hasNext()) {
               JsonElement var7 = (JsonElement)var6.next();
               var4.add((bgm.c)var1.deserialize(var7, bgm.c.class));
            }
         } else {
            var4.add((bgm.c)var1.deserialize(var5, bgm.c.class));
         }

         return new bgm.d(var3, var4);
      }

      protected List<bgm.d> a(JsonDeserializationContext var1, JsonObject var2) {
         JsonObject var3 = ni.s(var2, "variants");
         ArrayList var4 = Lists.newArrayList();
         Iterator var5 = var3.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            var4.add(this.a(var1, var6));
         }

         return var4;
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      public bgm a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         List var5 = this.a(var3, var4);
         return new bgm(var5);
      }
   }

   public static class c {
      private final int d;
      private final boolean c;
      private final bor b;
      private final jy a;

      public bor b() {
         return this.b;
      }

      public jy a() {
         return this.a;
      }

      public c(jy var1, bor var2, boolean var3, int var4) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
         this.d = var4;
      }

      public int hashCode() {
         int var1 = this.a.hashCode();
         var1 = 31 * var1 + (this.b != null ? this.b.hashCode() : 0);
         var1 = 31 * var1 + (this.c ? 1 : 0);
         return var1;
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof bgm.c)) {
            return false;
         } else {
            bgm.c var2 = (bgm.c)var1;
            return this.a.equals(var2.a) && this.b == var2.b && this.c == var2.c;
         }
      }

      public int d() {
         return this.d;
      }

      public boolean c() {
         return this.c;
      }

      public static class a implements JsonDeserializer<bgm.c> {
         protected int c(JsonObject var1) {
            return ni.a(var1, "weight", 1);
         }

         public bgm.c a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            JsonObject var4 = var1.getAsJsonObject();
            String var5 = this.b(var4);
            bor var6 = this.a(var4);
            boolean var7 = this.d(var4);
            int var8 = this.c(var4);
            return new bgm.c(this.a(var5), var6, var7, var8);
         }

         private jy a(String var1) {
            jy var2 = new jy(var1);
            var2 = new jy(var2.b(), "block/" + var2.a());
            return var2;
         }

         private boolean d(JsonObject var1) {
            return ni.a(var1, "uvlock", false);
         }

         protected String b(JsonObject var1) {
            return ni.h(var1, "model");
         }

         public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
            return this.a(var1, var2, var3);
         }

         protected bor a(JsonObject var1) {
            int var2 = ni.a(var1, "x", 0);
            int var3 = ni.a(var1, "y", 0);
            bor var4 = bor.a(var2, var3);
            if (var4 == null) {
               throw new JsonParseException("Invalid BlockModelRotation x: " + var2 + ", y: " + var3);
            } else {
               return var4;
            }
         }
      }
   }

   public static class d {
      private final String a;
      private final List<bgm.c> b;

      public d(String var1, List<bgm.c> var2) {
         this.a = var1;
         this.b = var2;
      }

      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (!(var1 instanceof bgm.d)) {
            return false;
         } else {
            bgm.d var2 = (bgm.d)var1;
            if (!this.a.equals(var2.a)) {
               return false;
            } else {
               return this.b.equals(var2.b);
            }
         }
      }

      public List<bgm.c> b() {
         return this.b;
      }

      public int hashCode() {
         int var1 = this.a.hashCode();
         var1 = 31 * var1 + this.b.hashCode();
         return var1;
      }

      static String a(bgm.d var0) {
         return var0.a;
      }
   }

   public class b extends RuntimeException {
      final bgm a;

      protected b(bgm var1) {
         this.a = var1;
      }
   }
}
