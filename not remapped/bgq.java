import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import org.lwjgl.util.vector.Vector3f;

public class bgq {
   public static final bgq a = new bgq(new Vector3f(), new Vector3f(), new Vector3f(1.0F, 1.0F, 1.0F));
   public final Vector3f b;
   public final Vector3f d;
   public final Vector3f c;

   public bgq(Vector3f var1, Vector3f var2, Vector3f var3) {
      this.b = new Vector3f(var1);
      this.c = new Vector3f(var2);
      this.d = new Vector3f(var3);
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (this.getClass() != var1.getClass()) {
         return false;
      } else {
         bgq var2 = (bgq)var1;
         if (!this.b.equals(var2.b)) {
            return false;
         } else if (!this.d.equals(var2.d)) {
            return false;
         } else {
            return this.c.equals(var2.c);
         }
      }
   }

   public int hashCode() {
      int var1 = this.b.hashCode();
      var1 = 31 * var1 + this.c.hashCode();
      var1 = 31 * var1 + this.d.hashCode();
      return var1;
   }

   static class a implements JsonDeserializer<bgq> {
      private static final Vector3f a = new Vector3f(0.0F, 0.0F, 0.0F);
      private static final Vector3f b = new Vector3f(0.0F, 0.0F, 0.0F);
      private static final Vector3f c = new Vector3f(1.0F, 1.0F, 1.0F);

      private Vector3f a(JsonObject var1, String var2, Vector3f var3) {
         if (!var1.has(var2)) {
            return var3;
         } else {
            JsonArray var4 = ni.t(var1, var2);
            if (var4.size() != 3) {
               throw new JsonParseException("Expected 3 " + var2 + " values, found: " + var4.size());
            } else {
               float[] var5 = new float[3];

               for(int var6 = 0; var6 < var5.length; ++var6) {
                  var5[var6] = ni.d(var4.get(var6), var2 + "[" + var6 + "]");
               }

               return new Vector3f(var5[0], var5[1], var5[2]);
            }
         }
      }

      public bgq a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         Vector3f var5 = this.a(var4, "rotation", a);
         Vector3f var6 = this.a(var4, "translation", b);
         var6.scale(0.0625F);
         var6.x = ns.a(var6.x, -1.5F, 1.5F);
         var6.y = ns.a(var6.y, -1.5F, 1.5F);
         var6.z = ns.a(var6.z, -1.5F, 1.5F);
         Vector3f var7 = this.a(var4, "scale", c);
         var7.x = ns.a(var7.x, -4.0F, 4.0F);
         var7.y = ns.a(var7.y, -4.0F, 4.0F);
         var7.z = ns.a(var7.z, -4.0F, 4.0F);
         return new bgq(var5, var6, var7);
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }
   }
}
