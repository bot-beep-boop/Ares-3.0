import com.google.common.base.Charsets;
import com.google.common.collect.Iterators;
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
import com.mojang.authlib.Agent;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.ProfileLookupCallback;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.IOUtils;

public class lt {
   public static final SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss Z");
   private final MinecraftServer f;
   protected final Gson b;
   private final Map<String, lt.a> c = Maps.newHashMap();
   private final LinkedList<GameProfile> e = Lists.newLinkedList();
   private final File g;
   private final Map<UUID, lt.a> d = Maps.newHashMap();
   private static final ParameterizedType h = new ParameterizedType() {
      public Type getRawType() {
         return List.class;
      }

      public Type getOwnerType() {
         return null;
      }

      public Type[] getActualTypeArguments() {
         return new Type[]{lt.a.class};
      }
   };

   public lt(MinecraftServer var1, File var2) {
      this.f = var1;
      this.g = var2;
      GsonBuilder var3 = new GsonBuilder();
      var3.registerTypeHierarchyAdapter(lt.a.class, new lt.b(this));
      this.b = var3.create();
      this.b();
   }

   public GameProfile a(UUID var1) {
      lt.a var2 = (lt.a)this.d.get(var1);
      return var2 == null ? null : var2.a();
   }

   public void a(GameProfile var1) {
      this.a((GameProfile)var1, (Date)null);
   }

   private static GameProfile a(MinecraftServer var0, String var1) {
      GameProfile[] var2 = new GameProfile[1];
      ProfileLookupCallback var3 = new ProfileLookupCallback(var2) {
         final GameProfile[] a;

         {
            this.a = var1;
         }

         public void onProfileLookupFailed(GameProfile var1, Exception var2) {
            this.a[0] = null;
         }

         public void onProfileLookupSucceeded(GameProfile var1) {
            this.a[0] = var1;
         }
      };
      var0.aE().findProfilesByNames(new String[]{var1}, Agent.MINECRAFT, var3);
      if (!var0.af() && var2[0] == null) {
         UUID var4 = wn.a(new GameProfile((UUID)null, var1));
         GameProfile var5 = new GameProfile(var4, var1);
         var3.onProfileLookupSucceeded(var5);
      }

      return var2[0];
   }

   public void c() {
      String var1 = this.b.toJson(this.a(1000));
      BufferedWriter var2 = null;

      try {
         var2 = Files.newWriter(this.g, Charsets.UTF_8);
         var2.write(var1);
         return;
      } catch (FileNotFoundException var8) {
      } catch (IOException var9) {
         return;
      } finally {
         IOUtils.closeQuietly(var2);
      }

   }

   public void b() {
      BufferedReader var1 = null;

      try {
         var1 = Files.newReader(this.g, Charsets.UTF_8);
         List var2 = (List)this.b.fromJson(var1, h);
         this.c.clear();
         this.d.clear();
         this.e.clear();
         Iterator var3 = Lists.reverse(var2).iterator();

         while(var3.hasNext()) {
            lt.a var4 = (lt.a)var3.next();
            if (var4 != null) {
               this.a(var4.a(), var4.b());
            }
         }
      } catch (FileNotFoundException var9) {
      } catch (JsonParseException var10) {
      } finally {
         IOUtils.closeQuietly(var1);
      }

   }

   private List<lt.a> a(int var1) {
      ArrayList var2 = Lists.newArrayList();
      ArrayList var3 = Lists.newArrayList(Iterators.limit(this.e.iterator(), var1));
      Iterator var4 = var3.iterator();

      while(var4.hasNext()) {
         GameProfile var5 = (GameProfile)var4.next();
         lt.a var6 = this.b(var5.getId());
         if (var6 != null) {
            var2.add(var6);
         }
      }

      return var2;
   }

   public GameProfile a(String var1) {
      String var2 = var1.toLowerCase(Locale.ROOT);
      lt.a var3 = (lt.a)this.c.get(var2);
      if (var3 != null && (new Date()).getTime() >= lt.a.a(var3).getTime()) {
         this.d.remove(var3.a().getId());
         this.c.remove(var3.a().getName().toLowerCase(Locale.ROOT));
         this.e.remove(var3.a());
         var3 = null;
      }

      GameProfile var4;
      if (var3 != null) {
         var4 = var3.a();
         this.e.remove(var4);
         this.e.addFirst(var4);
      } else {
         var4 = a(this.f, var2);
         if (var4 != null) {
            this.a(var4);
            var3 = (lt.a)this.c.get(var2);
         }
      }

      this.c();
      return var3 == null ? null : var3.a();
   }

   public String[] a() {
      ArrayList var1 = Lists.newArrayList(this.c.keySet());
      return (String[])var1.toArray(new String[var1.size()]);
   }

   private lt.a b(UUID var1) {
      lt.a var2 = (lt.a)this.d.get(var1);
      if (var2 != null) {
         GameProfile var3 = var2.a();
         this.e.remove(var3);
         this.e.addFirst(var3);
      }

      return var2;
   }

   private void a(GameProfile var1, Date var2) {
      UUID var3 = var1.getId();
      if (var2 == null) {
         Calendar var4 = Calendar.getInstance();
         var4.setTime(new Date());
         var4.add(2, 1);
         var2 = var4.getTime();
      }

      String var7 = var1.getName().toLowerCase(Locale.ROOT);
      lt.a var5 = new lt.a(this, var1, var2);
      if (this.d.containsKey(var3)) {
         lt.a var6 = (lt.a)this.d.get(var3);
         this.c.remove(var6.a().getName().toLowerCase(Locale.ROOT));
         this.e.remove(var1);
      }

      this.c.put(var1.getName().toLowerCase(Locale.ROOT), var5);
      this.d.put(var3, var5);
      this.e.addFirst(var1);
      this.c();
   }

   class b implements JsonDeserializer<lt.a>, JsonSerializer<lt.a> {
      final lt a;

      public JsonElement a(lt.a var1, Type var2, JsonSerializationContext var3) {
         JsonObject var4 = new JsonObject();
         var4.addProperty("name", var1.a().getName());
         UUID var5 = var1.a().getId();
         var4.addProperty("uuid", var5 == null ? "" : var5.toString());
         var4.addProperty("expiresOn", lt.a.format(var1.b()));
         return var4;
      }

      private b(lt var1) {
         this.a = var1;
      }

      public JsonElement serialize(Object var1, Type var2, JsonSerializationContext var3) {
         return this.a((lt.a)var1, var2, var3);
      }

      b(lt var1, Object var2) {
         this(var1);
      }

      public lt.a a(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         if (var1.isJsonObject()) {
            JsonObject var4 = var1.getAsJsonObject();
            JsonElement var5 = var4.get("name");
            JsonElement var6 = var4.get("uuid");
            JsonElement var7 = var4.get("expiresOn");
            if (var5 != null && var6 != null) {
               String var8 = var6.getAsString();
               String var9 = var5.getAsString();
               Date var10 = null;
               if (var7 != null) {
                  try {
                     var10 = lt.a.parse(var7.getAsString());
                  } catch (ParseException var14) {
                     var10 = null;
                  }
               }

               if (var9 != null && var8 != null) {
                  UUID var11;
                  try {
                     var11 = UUID.fromString(var8);
                  } catch (Throwable var13) {
                     return null;
                  }

                  lt.a var12 = this.a.new a(this.a, new GameProfile(var11, var9), var10);
                  return var12;
               } else {
                  return null;
               }
            } else {
               return null;
            }
         } else {
            return null;
         }
      }

      public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3) throws JsonParseException {
         return this.a(var1, var2, var3);
      }
   }

   class a {
      final lt a;
      private final Date c;
      private final GameProfile b;

      private a(lt var1, GameProfile var2, Date var3) {
         this.a = var1;
         this.b = var2;
         this.c = var3;
      }

      public GameProfile a() {
         return this.b;
      }

      a(lt var1, GameProfile var2, Date var3, Object var4) {
         this(var1, var2, var3);
      }

      public Date b() {
         return this.c;
      }

      static Date a(lt.a var0) {
         return var0.c;
      }
   }
}
