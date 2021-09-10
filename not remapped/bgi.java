import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class bgi {
   public static final cq a = null;
   public final int c;
   public final bgk e;
   public final cq b;
   public final String d;

   public bgi(cq var1, int var2, String var3, bgk var4) {
      this.b = var1;
      this.c = var2;
      this.d = var3;
      this.e = var4;
   }

   static class a implements JsonDeserializer<bgi> {
      private cq c(JsonObject var1) {
         String var2 = ni.a(var1, "cullface", "");
         return cq.a(var2);
      }

      public bgi a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         cq var5 = this.c(var4);
         int var6 = this.a(var4);
         String var7 = this.b(var4);
         bgk var8 = (bgk)var3.deserialize(var4, bgk.class);
         return new bgi(var5, var6, var7, var8);
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      protected int a(JsonObject var1) {
         return ni.a(var1, "tintindex", -1);
      }

      private String b(JsonObject var1) {
         return ni.h(var1, "texture");
      }
   }
}
