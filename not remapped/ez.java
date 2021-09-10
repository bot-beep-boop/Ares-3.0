import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class ez {
   private Boolean c;
   private Boolean f;
   private ew i;
   private et h;
   private Boolean e;
   private String j;
   private Boolean g;
   private Boolean d;
   private .a b;
   private ez a;
   private static final ez k = new ez() {
      public ez b(Boolean var1) {
         throw new UnsupportedOperationException();
      }

      public et h() {
         return null;
      }

      public boolean c() {
         return false;
      }

      public ez a(ew var1) {
         throw new UnsupportedOperationException();
      }

      public boolean b() {
         return false;
      }

      public String k() {
         return "";
      }

      public ez a(Boolean var1) {
         throw new UnsupportedOperationException();
      }

      public boolean e() {
         return false;
      }

      public ez a(et var1) {
         throw new UnsupportedOperationException();
      }

      public boolean d() {
         return false;
      }

      public ew i() {
         return null;
      }

      public boolean f() {
         return false;
      }

      public ez a(ez var1) {
         throw new UnsupportedOperationException();
      }

      public ez n() {
         return this;
      }

      public ez a(.a var1) {
         throw new UnsupportedOperationException();
      }

      public String j() {
         return null;
      }

      public ez d(Boolean var1) {
         throw new UnsupportedOperationException();
      }

      public ez c(Boolean var1) {
         throw new UnsupportedOperationException();
      }

      public .a a() {
         return null;
      }

      public ez m() {
         return this;
      }

      public String toString() {
         return "Style.ROOT";
      }

      public ez e(Boolean var1) {
         throw new UnsupportedOperationException();
      }
   };

   public ez a(ez var1) {
      this.a = var1;
      return this;
   }

   public ez a(Boolean var1) {
      this.c = var1;
      return this;
   }

   static Boolean b(ez var0, Boolean var1) {
      return var0.d = var1;
   }

   public boolean e() {
      return this.e == null ? this.o().e() : this.e;
   }

   public ew i() {
      return this.i == null ? this.o().i() : this.i;
   }

   static Boolean a(ez var0, Boolean var1) {
      return var0.c = var1;
   }

   static Boolean d(ez var0, Boolean var1) {
      return var0.f = var1;
   }

   public et h() {
      return this.h == null ? this.o().h() : this.h;
   }

   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (!(var1 instanceof ez)) {
         return false;
      } else {
         ez var2 = (ez)var1;
         boolean var10000;
         if (this.b() == var2.b() && this.a() == var2.a() && this.c() == var2.c() && this.f() == var2.f() && this.d() == var2.d() && this.e() == var2.e()) {
            label83: {
               if (this.h() != null) {
                  if (!this.h().equals(var2.h())) {
                     break label83;
                  }
               } else if (var2.h() != null) {
                  break label83;
               }

               if (this.i() != null) {
                  if (!this.i().equals(var2.i())) {
                     break label83;
                  }
               } else if (var2.i() != null) {
                  break label83;
               }

               if (this.j() != null) {
                  if (!this.j().equals(var2.j())) {
                     break label83;
                  }
               } else if (var2.j() != null) {
                  break label83;
               }

               var10000 = true;
               return var10000;
            }
         }

         var10000 = false;
         return var10000;
      }
   }

   public ez a(String var1) {
      this.j = var1;
      return this;
   }

   static et i(ez var0) {
      return var0.h;
   }

   public String k() {
      if (this.g()) {
         return this.a != null ? this.a.k() : "";
      } else {
         StringBuilder var1 = new StringBuilder();
         if (this.a() != null) {
            var1.append(this.a());
         }

         if (this.b()) {
            var1.append(.a.r);
         }

         if (this.c()) {
            var1.append(.a.u);
         }

         if (this.e()) {
            var1.append(.a.t);
         }

         if (this.f()) {
            var1.append(.a.q);
         }

         if (this.d()) {
            var1.append(.a.s);
         }

         return var1.toString();
      }
   }

   public ez e(Boolean var1) {
      this.g = var1;
      return this;
   }

   static Boolean b(ez var0) {
      return var0.c;
   }

   public boolean d() {
      return this.f == null ? this.o().d() : this.f;
   }

   static String a(ez var0, String var1) {
      return var0.j = var1;
   }

   public ez a(.a var1) {
      this.b = var1;
      return this;
   }

   public ez d(Boolean var1) {
      this.e = var1;
      return this;
   }

   public ez m() {
      ez var1 = new ez();
      var1.c = this.c;
      var1.d = this.d;
      var1.f = this.f;
      var1.e = this.e;
      var1.g = this.g;
      var1.b = this.b;
      var1.h = this.h;
      var1.i = this.i;
      var1.a = this.a;
      var1.j = this.j;
      return var1;
   }

   public String j() {
      return this.j == null ? this.o().j() : this.j;
   }

   public int hashCode() {
      int var1 = this.b.hashCode();
      var1 = 31 * var1 + this.c.hashCode();
      var1 = 31 * var1 + this.d.hashCode();
      var1 = 31 * var1 + this.e.hashCode();
      var1 = 31 * var1 + this.f.hashCode();
      var1 = 31 * var1 + this.g.hashCode();
      var1 = 31 * var1 + this.h.hashCode();
      var1 = 31 * var1 + this.i.hashCode();
      var1 = 31 * var1 + this.j.hashCode();
      return var1;
   }

   static Boolean c(ez var0, Boolean var1) {
      return var0.e = var1;
   }

   public ez c(Boolean var1) {
      this.f = var1;
      return this;
   }

   static Boolean e(ez var0) {
      return var0.f;
   }

   static .a g(ez var0) {
      return var0.b;
   }

   static Boolean d(ez var0) {
      return var0.e;
   }

   static .a a(ez var0, .a var1) {
      return var0.b = var1;
   }

   public ez a(ew var1) {
      this.i = var1;
      return this;
   }

   public String toString() {
      return "Style{hasParent=" + (this.a != null) + ", color=" + this.b + ", bold=" + this.c + ", italic=" + this.d + ", underlined=" + this.e + ", obfuscated=" + this.g + ", clickEvent=" + this.h() + ", hoverEvent=" + this.i() + ", insertion=" + this.j() + '}';
   }

   static String h(ez var0) {
      return var0.j;
   }

   public ez n() {
      ez var1 = new ez();
      var1.a(this.b());
      var1.b(this.c());
      var1.c(this.d());
      var1.d(this.e());
      var1.e(this.f());
      var1.a(this.a());
      var1.a(this.h());
      var1.a(this.i());
      var1.a(this.j());
      return var1;
   }

   static ew j(ez var0) {
      return var0.i;
   }

   static Boolean f(ez var0) {
      return var0.g;
   }

   static et a(ez var0, et var1) {
      return var0.h = var1;
   }

   static Boolean c(ez var0) {
      return var0.d;
   }

   public .a a() {
      return this.b == null ? this.o().a() : this.b;
   }

   static ew a(ez var0, ew var1) {
      return var0.i = var1;
   }

   public ez b(Boolean var1) {
      this.d = var1;
      return this;
   }

   public boolean f() {
      return this.g == null ? this.o().f() : this.g;
   }

   public boolean g() {
      return this.c == null && this.d == null && this.f == null && this.e == null && this.g == null && this.b == null && this.h == null && this.i == null;
   }

   public ez a(et var1) {
      this.h = var1;
      return this;
   }

   public boolean b() {
      return this.c == null ? this.o().b() : this.c;
   }

   static Boolean e(ez var0, Boolean var1) {
      return var0.g = var1;
   }

   public boolean c() {
      return this.d == null ? this.o().c() : this.d;
   }

   private ez o() {
      return this.a == null ? k : this.a;
   }

   public static class a implements JsonDeserializer<ez>, JsonSerializer<ez> {
      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      public JsonElement a(ez var1, Type var2, JsonSerializationContext var3) {
         if (var1.g()) {
            return null;
         } else {
            JsonObject var4 = new JsonObject();
            if (ez.b(var1) != null) {
               var4.addProperty("bold", ez.b(var1));
            }

            if (ez.c(var1) != null) {
               var4.addProperty("italic", ez.c(var1));
            }

            if (ez.d(var1) != null) {
               var4.addProperty("underlined", ez.d(var1));
            }

            if (ez.e(var1) != null) {
               var4.addProperty("strikethrough", ez.e(var1));
            }

            if (ez.f(var1) != null) {
               var4.addProperty("obfuscated", ez.f(var1));
            }

            if (ez.g(var1) != null) {
               var4.add("color", var3.serialize(ez.g(var1)));
            }

            if (ez.h(var1) != null) {
               var4.add("insertion", var3.serialize(ez.h(var1)));
            }

            JsonObject var5;
            if (ez.i(var1) != null) {
               var5 = new JsonObject();
               var5.addProperty("action", ez.i(var1).a().b());
               var5.addProperty("value", ez.i(var1).b());
               var4.add("clickEvent", var5);
            }

            if (ez.j(var1) != null) {
               var5 = new JsonObject();
               var5.addProperty("action", ez.j(var1).a().b());
               var5.add("value", var3.serialize(ez.j(var1).b()));
               var4.add("hoverEvent", var5);
            }

            return var4;
         }
      }

      public ez a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         if (var1.isJsonObject()) {
            ez var4 = new ez();
            JsonObject var5 = var1.getAsJsonObject();
            if (var5 == null) {
               return null;
            } else {
               if (var5.has("bold")) {
                  ez.a(var4, var5.get("bold").getAsBoolean());
               }

               if (var5.has("italic")) {
                  ez.b(var4, var5.get("italic").getAsBoolean());
               }

               if (var5.has("underlined")) {
                  ez.c(var4, var5.get("underlined").getAsBoolean());
               }

               if (var5.has("strikethrough")) {
                  ez.d(var4, var5.get("strikethrough").getAsBoolean());
               }

               if (var5.has("obfuscated")) {
                  ez.e(var4, var5.get("obfuscated").getAsBoolean());
               }

               if (var5.has("color")) {
                  ez.a(var4, (.a)var3.deserialize(var5.get("color"), .a.class));
               }

               if (var5.has("insertion")) {
                  ez.a(var4, var5.get("insertion").getAsString());
               }

               JsonObject var6;
               JsonPrimitive var7;
               if (var5.has("clickEvent")) {
                  var6 = var5.getAsJsonObject("clickEvent");
                  if (var6 != null) {
                     var7 = var6.getAsJsonPrimitive("action");
                     et.a var8 = var7 == null ? null : et.a.a(var7.getAsString());
                     JsonPrimitive var9 = var6.getAsJsonPrimitive("value");
                     String var10 = var9 == null ? null : var9.getAsString();
                     if (var8 != null && var10 != null && var8.a()) {
                        ez.a(var4, new et(var8, var10));
                     }
                  }
               }

               if (var5.has("hoverEvent")) {
                  var6 = var5.getAsJsonObject("hoverEvent");
                  if (var6 != null) {
                     var7 = var6.getAsJsonPrimitive("action");
                     ew.a var11 = var7 == null ? null : ew.a.a(var7.getAsString());
                     eu var12 = (eu)var3.deserialize(var6.get("value"), eu.class);
                     if (var11 != null && var12 != null && var11.a()) {
                        ez.a(var4, new ew(var11, var12));
                     }
                  }
               }

               return var4;
            }
         } else {
            return null;
         }
      }

      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((ez)var1, var2, var3);
      }
   }
}
