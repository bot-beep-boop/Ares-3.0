import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class mv extends nb {
   private boolean g = false;
   private final File d;
   private final MinecraftServer c;
   private final Set<mw> e = Sets.newHashSet();
   private static final Logger b = LogManager.getLogger();
   private int f = -300;

   public void d() {
      Iterator var1 = this.a.keySet().iterator();

      while(var1.hasNext()) {
         mw var2 = (mw)var1.next();
         this.e.add(var2);
      }

   }

   public boolean e() {
      return this.g;
   }

   public void b(lf var1) {
      HashMap var2 = Maps.newHashMap();
      Iterator var3 = mr.e.iterator();

      while(var3.hasNext()) {
         mq var4 = (mq)var3.next();
         if (this.a((mq)var4)) {
            var2.put(var4, this.a((mw)var4));
            this.e.remove(var4);
         }
      }

      var1.a.a((ff)(new fr(var2)));
   }

   public void b() {
      try {
         FileUtils.writeStringToFile(this.d, a(this.a));
      } catch (IOException var2) {
         b.error("Couldn't save stats", var2);
      }

   }

   public Map<mw, my> a(String var1) {
      JsonElement var2 = (new JsonParser()).parse(var1);
      if (!var2.isJsonObject()) {
         return Maps.newHashMap();
      } else {
         JsonObject var3 = var2.getAsJsonObject();
         HashMap var4 = Maps.newHashMap();
         Iterator var5 = var3.entrySet().iterator();

         while(true) {
            while(var5.hasNext()) {
               Entry var6 = (Entry)var5.next();
               mw var7 = na.a((String)var6.getKey());
               if (var7 != null) {
                  my var8 = new my();
                  if (((JsonElement)var6.getValue()).isJsonPrimitive() && ((JsonElement)var6.getValue()).getAsJsonPrimitive().isNumber()) {
                     var8.a(((JsonElement)var6.getValue()).getAsInt());
                  } else if (((JsonElement)var6.getValue()).isJsonObject()) {
                     JsonObject var9 = ((JsonElement)var6.getValue()).getAsJsonObject();
                     if (var9.has("value") && var9.get("value").isJsonPrimitive() && var9.get("value").getAsJsonPrimitive().isNumber()) {
                        var8.a(var9.getAsJsonPrimitive("value").getAsInt());
                     }

                     if (var9.has("progress") && var7.l() != null) {
                        try {
                           Constructor var10 = var7.l().getConstructor();
                           mz var11 = (mz)var10.newInstance();
                           var11.a(var9.get("progress"));
                           var8.a(var11);
                        } catch (Throwable var12) {
                           b.warn("Invalid statistic progress in " + this.d, var12);
                        }
                     }
                  }

                  var4.put(var7, var8);
               } else {
                  b.warn("Invalid statistic in " + this.d + ": Don't know what " + (String)var6.getKey() + " is");
               }
            }

            return var4;
         }
      }
   }

   public void a() {
      if (this.d.isFile()) {
         try {
            this.a.clear();
            this.a.putAll(this.a(FileUtils.readFileToString(this.d)));
         } catch (IOException var2) {
            b.error("Couldn't read statistics file " + this.d, var2);
         } catch (JsonParseException var3) {
            b.error("Couldn't parse statistics file " + this.d, var3);
         }
      }

   }

   public mv(MinecraftServer var1, File var2) {
      this.c = var1;
      this.d = var2;
   }

   public void a(wn var1, mw var2, int var3) {
      int var4 = var2.d() ? this.a((mw)var2) : 0;
      super.a(var1, var2, var3);
      this.e.add(var2);
      if (var2.d() && var4 == 0 && var3 > 0) {
         this.g = true;
         if (this.c.aB()) {
            this.c.ap().a((eu)(new fb("chat.type.achievement", new Object[]{var1.f_(), var2.j()})));
         }
      }

      if (var2.d() && var4 > 0 && var3 == 0) {
         this.g = true;
         if (this.c.aB()) {
            this.c.ap().a((eu)(new fb("chat.type.achievement.taken", new Object[]{var1.f_(), var2.j()})));
         }
      }

   }

   public static String a(Map<mw, my> var0) {
      JsonObject var1 = new JsonObject();
      Iterator var2 = var0.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         if (((my)var3.getValue()).b() != null) {
            JsonObject var4 = new JsonObject();
            var4.addProperty("value", ((my)var3.getValue()).a());

            try {
               var4.add("progress", ((my)var3.getValue()).b().a());
            } catch (Throwable var6) {
               b.warn("Couldn't save statistic " + ((mw)var3.getKey()).e() + ": error serializing progress", var6);
            }

            var1.add(((mw)var3.getKey()).e, var4);
         } else {
            var1.addProperty(((mw)var3.getKey()).e, ((my)var3.getValue()).a());
         }
      }

      return var1.toString();
   }

   public Set<mw> c() {
      HashSet var1 = Sets.newHashSet(this.e);
      this.e.clear();
      this.g = false;
      return var1;
   }

   public void a(lf var1) {
      int var2 = this.c.at();
      HashMap var3 = Maps.newHashMap();
      if (this.g || var2 - this.f > 300) {
         this.f = var2;
         Iterator var4 = this.c().iterator();

         while(var4.hasNext()) {
            mw var5 = (mw)var4.next();
            var3.put(var5, this.a((mw)var5));
         }
      }

      var1.a.a((ff)(new fr(var3)));
   }
}
