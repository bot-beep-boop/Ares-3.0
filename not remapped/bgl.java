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
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bgl {
   private final boolean h;
   private bgr j;
   static final Gson a = (new GsonBuilder()).registerTypeAdapter(bgl.class, new bgl.b()).registerTypeAdapter(bgh.class, new bgh.a()).registerTypeAdapter(bgi.class, new bgi.a()).registerTypeAdapter(bgk.class, new bgk.a()).registerTypeAdapter(bgq.class, new bgq.a()).registerTypeAdapter(bgr.class, new bgr.a()).create();
   private final List<bgh> g;
   private final boolean i;
   protected bgl d;
   protected final Map<String, String> c;
   public String b;
   private static final Logger f = LogManager.getLogger();
   protected jy e;

   protected bgl(jy var1, Map<String, String> var2, boolean var3, boolean var4, bgr var5) {
      this(var1, Collections.emptyList(), var2, var3, var4, var5);
   }

   private boolean h() {
      return this.d != null;
   }

   public List<bgh> a() {
      return this.h() ? this.d.a() : this.g;
   }

   public bgl f() {
      return this.h() ? this.d.f() : this;
   }

   public boolean b() {
      return this.h() ? this.d.b() : this.i;
   }

   public void a(Map<jy, bgl> var1) {
      if (this.e != null) {
         this.d = (bgl)var1.get(this.e);
      }

   }

   private bgq a(bgr.b var1) {
      return this.d != null && !this.j.c(var1) ? this.d.a(var1) : this.j.b(var1);
   }

   private boolean d(String var1) {
      return var1.charAt(0) == '#';
   }

   public boolean b(String var1) {
      return !"missingno".equals(this.c(var1));
   }

   public boolean d() {
      return this.e == null || this.d != null && this.d.d();
   }

   public static bgl a(String var0) {
      return a((Reader)(new StringReader(var0)));
   }

   private bgl(jy var1, List<bgh> var2, Map<String, String> var3, boolean var4, boolean var5, bgr var6) {
      this.b = "";
      this.g = var2;
      this.i = var4;
      this.h = var5;
      this.c = var3;
      this.e = var1;
      this.j = var6;
   }

   public static void b(Map<jy, bgl> var0) {
      Iterator var1 = var0.values().iterator();

      while(var1.hasNext()) {
         bgl var2 = (bgl)var1.next();

         try {
            bgl var3 = var2.d;

            for(bgl var4 = var3.d; var3 != var4; var4 = var4.d.d) {
               var3 = var3.d;
            }

            throw new bgl.c();
         } catch (NullPointerException var5) {
         }
      }

   }

   public String c(String var1) {
      if (!this.d(var1)) {
         var1 = '#' + var1;
      }

      return this.a(var1, new bgl.a(this));
   }

   public jy e() {
      return this.e;
   }

   public static bgl a(Reader var0) {
      return (bgl)a.fromJson(var0, bgl.class);
   }

   public boolean c() {
      return this.h;
   }

   public bgr g() {
      bgq var1 = this.a(bgr.b.b);
      bgq var2 = this.a(bgr.b.c);
      bgq var3 = this.a(bgr.b.d);
      bgq var4 = this.a(bgr.b.e);
      bgq var5 = this.a(bgr.b.f);
      bgq var6 = this.a(bgr.b.g);
      return new bgr(var1, var2, var3, var4, var5, var6);
   }

   protected bgl(List<bgh> var1, Map<String, String> var2, boolean var3, boolean var4, bgr var5) {
      this((jy)null, var1, var2, var3, var4, var5);
   }

   private String a(String var1, bgl.a var2) {
      if (this.d(var1)) {
         if (this == var2.b) {
            f.warn("Unable to resolve texture due to upward reference: " + var1 + " in " + this.b);
            return "missingno";
         } else {
            String var3 = (String)this.c.get(var1.substring(1));
            if (var3 == null && this.h()) {
               var3 = this.d.a(var1, var2);
            }

            var2.b = this;
            if (var3 != null && this.d(var3)) {
               var3 = var2.a.a(var3, var2);
            }

            return var3 != null && !this.d(var3) ? var3 : "missingno";
         }
      } else {
         return var1;
      }
   }

   public static class b implements JsonDeserializer<bgl> {
      private Map<String, String> b(JsonObject var1) {
         HashMap var2 = Maps.newHashMap();
         if (var1.has("textures")) {
            JsonObject var3 = var1.getAsJsonObject("textures");
            Iterator var4 = var3.entrySet().iterator();

            while(var4.hasNext()) {
               Entry var5 = (Entry)var4.next();
               var2.put(var5.getKey(), ((JsonElement)var5.getValue()).getAsString());
            }
         }

         return var2;
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }

      private String c(JsonObject var1) {
         return ni.a(var1, "parent", "");
      }

      protected List<bgh> a(JsonDeserializationContext var1, JsonObject var2) {
         ArrayList var3 = Lists.newArrayList();
         if (var2.has("elements")) {
            Iterator var4 = ni.t(var2, "elements").iterator();

            while(var4.hasNext()) {
               JsonElement var5 = (JsonElement)var4.next();
               var3.add((bgh)var1.deserialize(var5, bgh.class));
            }
         }

         return var3;
      }

      public bgl a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         JsonObject var4 = var1.getAsJsonObject();
         List var5 = this.a(var3, var4);
         String var6 = this.c(var4);
         boolean var7 = StringUtils.isEmpty(var6);
         boolean var8 = var5.isEmpty();
         if (var8 && var7) {
            throw new JsonParseException("BlockModel requires either elements or parent, found neither");
         } else if (!var7 && !var8) {
            throw new JsonParseException("BlockModel requires either elements or parent, found both");
         } else {
            Map var9 = this.b(var4);
            boolean var10 = this.a(var4);
            bgr var11 = bgr.a;
            if (var4.has("display")) {
               JsonObject var12 = ni.s(var4, "display");
               var11 = (bgr)var3.deserialize(var12, bgr.class);
            }

            return var8 ? new bgl(new jy(var6), var9, var10, true, var11) : new bgl(var5, var9, var10, true, var11);
         }
      }

      protected boolean a(JsonObject var1) {
         return ni.a(var1, "ambientocclusion", true);
      }
   }

   static final class a {
      public final bgl a;
      public bgl b;

      a(bgl var1, Object var2) {
         this(var1);
      }

      private a(bgl var1) {
         this.a = var1;
      }
   }

   public static class c extends RuntimeException {
   }
}
