import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class mb<K, V extends ma<K>> {
   private boolean e = true;
   private static final ParameterizedType f = new ParameterizedType() {
      public Type getOwnerType() {
         return null;
      }

      public Type[] getActualTypeArguments() {
         return new Type[]{ma.class};
      }

      public Type getRawType() {
         return List.class;
      }
   };
   private final Map<String, V> d = Maps.newHashMap();
   protected static final Logger a = LogManager.getLogger();
   protected final Gson b;
   private final File c;

   private void h() {
      ArrayList var1 = Lists.newArrayList();
      Iterator var2 = this.d.values().iterator();

      while(var2.hasNext()) {
         ma var3 = (ma)var2.next();
         if (var3.e()) {
            var1.add(var3.f());
         }
      }

      var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var4 = var2.next();
         this.d.remove(var4);
      }

   }

   protected Map<String, V> e() {
      return this.d;
   }

   protected boolean d(K var1) {
      return this.d.containsKey(this.a(var1));
   }

   public boolean b() {
      return this.e;
   }

   public void a(boolean var1) {
      this.e = var1;
   }

   public void f() throws IOException {
      Collection var1 = this.d.values();
      String var2 = this.b.toJson(var1);
      BufferedWriter var3 = null;

      try {
         var3 = Files.newWriter(this.c, Charsets.UTF_8);
         var3.write(var2);
      } finally {
         IOUtils.closeQuietly(var3);
      }

   }

   public void a(V var1) {
      this.d.put(this.a(var1.f()), var1);

      try {
         this.f();
      } catch (IOException var3) {
         a.warn("Could not save the list after adding a user.", var3);
      }

   }

   public mb(File var1) {
      this.c = var1;
      GsonBuilder var2 = (new GsonBuilder()).setPrettyPrinting();
      var2.registerTypeHierarchyAdapter(ma.class, new mb.a(this));
      this.b = var2.create();
   }

   protected ma<K> a(JsonObject var1) {
      return new ma((Object)null, var1);
   }

   public V b(K var1) {
      this.h();
      return (ma)this.d.get(this.a(var1));
   }

   protected String a(K var1) {
      return var1.toString();
   }

   public String[] a() {
      return (String[])this.d.keySet().toArray(new String[this.d.size()]);
   }

   public void c(K var1) {
      this.d.remove(this.a(var1));

      try {
         this.f();
      } catch (IOException var3) {
         a.warn("Could not save the list after removing a user.", var3);
      }

   }

   class a implements JsonDeserializer<ma<K>>, JsonSerializer<ma<K>> {
      final mb a;

      a(mb var1, Object var2) {
         this(var1);
      }

      private a(mb var1) {
         this.a = var1;
      }

      public JsonElement a(ma<K> var1, Type var2, JsonSerializationContext var3) {
         JsonObject var4 = new JsonObject();
         var1.a(var4);
         return var4;
      }

      public ma<K> a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         if (var1.isJsonObject()) {
            JsonObject var4 = var1.getAsJsonObject();
            ma var5 = this.a.a(var4);
            return var5;
         } else {
            return null;
         }
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((ma)var1, var2, var3);
      }
   }
}
