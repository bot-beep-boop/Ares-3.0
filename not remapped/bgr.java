import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class bgr {
   public final bgq k;
   public final bgq m;
   public static float j = 0.0F;
   public static float g = 0.0F;
   public static float h = 0.0F;
   public final bgq n;
   public final bgq o;
   public static float b = 0.0F;
   public final bgq l;
   public static float i = 0.0F;
   public static float c = 0.0F;
   public final bgq p;
   public static float f = 0.0F;
   public static float d = 0.0F;
   public static float e = 0.0F;
   public static final bgr a = new bgr();

   public void a(bgr.b var1) {
      bgq var2 = this.b(var1);
      if (var2 != bgq.a) {
         bfl.b(var2.c.x + b, var2.c.y + c, var2.c.z + d);
         bfl.b(var2.b.y + f, 0.0F, 1.0F, 0.0F);
         bfl.b(var2.b.x + e, 1.0F, 0.0F, 0.0F);
         bfl.b(var2.b.z + g, 0.0F, 0.0F, 1.0F);
         bfl.a(var2.d.x + h, var2.d.y + i, var2.d.z + j);
      }

   }

   public bgq b(bgr.b var1) {
      switch(var1) {
      case b:
         return this.k;
      case c:
         return this.l;
      case d:
         return this.m;
      case e:
         return this.n;
      case f:
         return this.o;
      case g:
         return this.p;
      default:
         return bgq.a;
      }
   }

   public bgr(bgq var1, bgq var2, bgq var3, bgq var4, bgq var5, bgq var6) {
      this.k = var1;
      this.l = var2;
      this.m = var3;
      this.n = var4;
      this.o = var5;
      this.p = var6;
   }

   public boolean c(bgr.b var1) {
      return !this.b(var1).equals(bgq.a);
   }

   private bgr() {
      this(bgq.a, bgq.a, bgq.a, bgq.a, bgq.a, bgq.a);
   }

   public bgr(bgr var1) {
      this.k = var1.k;
      this.l = var1.l;
      this.m = var1.m;
      this.n = var1.n;
      this.o = var1.o;
      this.p = var1.p;
   }

   static class a implements JsonDeserializer<bgr> {
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      public bgr a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         bgq var5 = this.a(var3, var4, "thirdperson");
         bgq var6 = this.a(var3, var4, "firstperson");
         bgq var7 = this.a(var3, var4, "head");
         bgq var8 = this.a(var3, var4, "gui");
         bgq var9 = this.a(var3, var4, "ground");
         bgq var10 = this.a(var3, var4, "fixed");
         return new bgr(var5, var6, var7, var8, var9, var10);
      }

      private bgq a(JsonDeserializationContext var1, JsonObject var2, String var3) {
         return var2.has(var3) ? (bgq)var1.deserialize(var2.get(var3), bgq.class) : bgq.a;
      }
   }

   public static enum b {
      g,
      b,
      c,
      e,
      a,
      f;

      private static final bgr.b[] h = new bgr.b[]{a, b, c, d, e, f, g};
      d;
   }
}
