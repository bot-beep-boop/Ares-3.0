import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class bgk {
   public final int b;
   public float[] a;

   public float a(int var1) {
      if (this.a == null) {
         throw new NullPointerException("uvs");
      } else {
         int var2 = this.d(var1);
         return var2 != 0 && var2 != 1 ? this.a[2] : this.a[0];
      }
   }

   public int c(int var1) {
      return (var1 + (4 - this.b / 90)) % 4;
   }

   private int d(int var1) {
      return (var1 + this.b / 90) % 4;
   }

   public bgk(float[] var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(float[] var1) {
      if (this.a == null) {
         this.a = var1;
      }

   }

   public float b(int var1) {
      if (this.a == null) {
         throw new NullPointerException("uvs");
      } else {
         int var2 = this.d(var1);
         return var2 != 0 && var2 != 3 ? this.a[3] : this.a[1];
      }
   }

   static class a implements JsonDeserializer<bgk> {
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      protected int a(JsonObject var1) {
         int var2 = ni.a(var1, "rotation", 0);
         if (var2 >= 0 && var2 % 90 == 0 && var2 / 90 <= 3) {
            return var2;
         } else {
            throw new JsonParseException("Invalid rotation " + var2 + " found, only 0/90/180/270 allowed");
         }
      }

      private float[] b(JsonObject var1) {
         if (!var1.has("uv")) {
            return null;
         } else {
            JsonArray var2 = ni.t(var1, "uv");
            if (var2.size() != 4) {
               throw new JsonParseException("Expected 4 uv values, found: " + var2.size());
            } else {
               float[] var3 = new float[4];

               for(int var4 = 0; var4 < var3.length; ++var4) {
                  var3[var4] = ni.d(var2.get(var4), "uv[" + var4 + "]");
               }

               return var3;
            }
         }
      }

      public bgk a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         float[] var5 = this.b(var4);
         int var6 = this.a(var4);
         return new bgk(var5, var6);
      }
   }
}
