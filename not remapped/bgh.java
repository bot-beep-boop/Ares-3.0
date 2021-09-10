import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.lwjgl.util.vector.Vector3f;

public class bgh {
   public final Vector3f a;
   public final boolean e;
   public final Map<cq, bgi> c;
   public final bgj d;
   public final Vector3f b;

   private float[] a(cq var1) {
      float[] var2;
      switch(var1) {
      case a:
      case b:
         var2 = new float[]{this.a.x, this.a.z, this.b.x, this.b.z};
         break;
      case c:
      case d:
         var2 = new float[]{this.a.x, 16.0F - this.b.y, this.b.x, 16.0F - this.a.y};
         break;
      case e:
      case f:
         var2 = new float[]{this.a.z, 16.0F - this.b.y, this.b.z, 16.0F - this.a.y};
         break;
      default:
         throw new NullPointerException();
      }

      return var2;
   }

   private void a() {
      Iterator var1 = this.c.entrySet().iterator();

      while(var1.hasNext()) {
         Entry var2 = (Entry)var1.next();
         float[] var3 = this.a((cq)var2.getKey());
         ((bgi)var2.getValue()).e.a(var3);
      }

   }

   public bgh(Vector3f var1, Vector3f var2, Map<cq, bgi> var3, bgj var4, boolean var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.a();
   }

   static class a implements JsonDeserializer<bgh> {
      private Vector3f e(JsonObject var1) {
         Vector3f var2 = this.a(var1, "from");
         if (!(var2.x < -16.0F) && !(var2.y < -16.0F) && !(var2.z < -16.0F) && !(var2.x > 32.0F) && !(var2.y > 32.0F) && !(var2.z > 32.0F)) {
            return var2;
         } else {
            throw new JsonParseException("'from' specifier exceeds the allowed boundaries: " + var2);
         }
      }

      private Map<cq, bgi> a(JsonDeserializationContext var1, JsonObject var2) {
         Map var3 = this.b(var1, var2);
         if (var3.isEmpty()) {
            throw new JsonParseException("Expected between 1 and 6 unique faces, got 0");
         } else {
            return var3;
         }
      }

      private Vector3f d(JsonObject var1) {
         Vector3f var2 = this.a(var1, "to");
         if (!(var2.x < -16.0F) && !(var2.y < -16.0F) && !(var2.z < -16.0F) && !(var2.x > 32.0F) && !(var2.y > 32.0F) && !(var2.z > 32.0F)) {
            return var2;
         } else {
            throw new JsonParseException("'to' specifier exceeds the allowed boundaries: " + var2);
         }
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      private cq.a c(JsonObject var1) {
         String var2 = ni.h(var1, "axis");
         cq.a var3 = cq.a.a(var2.toLowerCase());
         if (var3 == null) {
            throw new JsonParseException("Invalid rotation axis: " + var2);
         } else {
            return var3;
         }
      }

      private bgj a(JsonObject var1) {
         bgj var2 = null;
         if (var1.has("rotation")) {
            JsonObject var3 = ni.s(var1, "rotation");
            Vector3f var4 = this.a(var3, "origin");
            var4.scale(0.0625F);
            cq.a var5 = this.c(var3);
            float var6 = this.b(var3);
            boolean var7 = ni.a(var3, "rescale", false);
            var2 = new bgj(var4, var5, var6, var7);
         }

         return var2;
      }

      public bgh a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         Vector3f var5 = this.e(var4);
         Vector3f var6 = this.d(var4);
         bgj var7 = this.a(var4);
         Map var8 = this.a(var3, var4);
         if (var4.has("shade") && !ni.c(var4, "shade")) {
            throw new JsonParseException("Expected shade to be a Boolean");
         } else {
            boolean var9 = ni.a(var4, "shade", true);
            return new bgh(var5, var6, var8, var7, var9);
         }
      }

      private Vector3f a(JsonObject var1, String var2) {
         JsonArray var3 = ni.t(var1, var2);
         if (var3.size() != 3) {
            throw new JsonParseException("Expected 3 " + var2 + " values, found: " + var3.size());
         } else {
            float[] var4 = new float[3];

            for(int var5 = 0; var5 < var4.length; ++var5) {
               var4[var5] = ni.d(var3.get(var5), var2 + "[" + var5 + "]");
            }

            return new Vector3f(var4[0], var4[1], var4[2]);
         }
      }

      private cq a(String var1) {
         cq var2 = cq.a(var1);
         if (var2 == null) {
            throw new JsonParseException("Unknown facing: " + var1);
         } else {
            return var2;
         }
      }

      private Map<cq, bgi> b(JsonDeserializationContext var1, JsonObject var2) {
         EnumMap var3 = Maps.newEnumMap(cq.class);
         JsonObject var4 = ni.s(var2, "faces");
         Iterator var5 = var4.entrySet().iterator();

         while(var5.hasNext()) {
            Entry var6 = (Entry)var5.next();
            cq var7 = this.a((String)var6.getKey());
            var3.put(var7, (bgi)var1.deserialize((JsonElement)var6.getValue(), bgi.class));
         }

         return var3;
      }

      private float b(JsonObject var1) {
         float var2 = ni.k(var1, "angle");
         if (var2 != 0.0F && ns.e(var2) != 22.5F && ns.e(var2) != 45.0F) {
            throw new JsonParseException("Invalid rotation " + var2 + " found, only -45/-22.5/0/22.5/45 allowed");
         } else {
            return var2;
         }
      }
   }
}
