import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class nr implements TypeAdapterFactory {
   private String a(Object var1) {
      return var1 instanceof Enum ? ((Enum)var1).name().toLowerCase(Locale.US) : var1.toString().toLowerCase(Locale.US);
   }

   public <T> TypeAdapter<T> create(Gson var1, TypeToken<T> var2) {
      Class var3 = var2.getRawType();
      if (!var3.isEnum()) {
         return null;
      } else {
         HashMap var4 = Maps.newHashMap();
         Object[] var5 = var3.getEnumConstants();
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            Object var8 = var5[var7];
            var4.put(this.a(var8), var8);
         }

         return new TypeAdapter<T>(this, var4) {
            final Map a;
            final nr b;

            public void write(JsonWriter var1, T var2) throws IOException {
               if (var2 == null) {
                  var1.nullValue();
               } else {
                  var1.value(nr.a(this.b, var2));
               }

            }

            public T read(JsonReader var1) throws IOException {
               if (var1.peek() == JsonToken.NULL) {
                  var1.nextNull();
                  return null;
               } else {
                  return this.a.get(var1.nextString());
               }
            }

            {
               this.b = var1;
               this.a = var2;
            }
         };
      }
   }

   static String a(nr var0, Object var1) {
      return var0.a(var1);
   }
}
