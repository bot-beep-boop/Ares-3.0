import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bpz implements km, bnj {
   private static final Logger b = LogManager.getLogger();
   private static final Gson c = (new GsonBuilder()).registerTypeAdapter(bph.class, new bpi()).create();
   public static final bpw a = new bpw(new jy("meta:missing_sound"), 0.0D, 0.0D, false);
   private static final ParameterizedType d = new ParameterizedType() {
      public Type getRawType() {
         return Map.class;
      }

      public Type[] getActualTypeArguments() {
         return new Type[]{String.class, bph.class};
      }

      public Type getOwnerType() {
         return null;
      }
   };
   private final bni g;
   private final bpx f;
   private final bqa e = new bqa();

   public void c() {
      this.f.d();
   }

   public void a(bni var1) {
      this.f.a();
      this.e.a();
      Iterator var2 = var1.a().iterator();

      while(var2.hasNext()) {
         String var3 = (String)var2.next();

         try {
            List var4 = var1.b(new jy(var3, "sounds.json"));
            Iterator var5 = var4.iterator();

            while(var5.hasNext()) {
               bnh var6 = (bnh)var5.next();

               try {
                  Map var7 = this.a(var6.b());
                  Iterator var8 = var7.entrySet().iterator();

                  while(var8.hasNext()) {
                     Entry var9 = (Entry)var8.next();
                     this.a(new jy(var3, (String)var9.getKey()), (bph)var9.getValue());
                  }
               } catch (RuntimeException var10) {
                  b.warn("Invalid sounds.json", var10);
               }
            }
         } catch (IOException var11) {
         }
      }

   }

   public void e() {
      this.f.f();
   }

   protected Map<String, bph> a(InputStream var1) {
      Map var2;
      try {
         var2 = (Map)c.fromJson(new InputStreamReader(var1), d);
      } finally {
         IOUtils.closeQuietly(var1);
      }

      return var2;
   }

   public void a(wn var1, float var2) {
      this.f.a(var1, var2);
   }

   public void a(bpg var1, float var2) {
      if (var1 == bpg.a && var2 <= 0.0F) {
         this.b();
      }

      this.f.a(var1, var2);
   }

   public bpy a(jy var1) {
      return (bpy)this.e.a(var1);
   }

   public void a(bpj var1, int var2) {
      this.f.a(var1, var2);
   }

   public bpy a(bpg... var1) {
      ArrayList var2 = Lists.newArrayList();
      Iterator var3 = this.e.c().iterator();

      while(var3.hasNext()) {
         jy var4 = (jy)var3.next();
         bpy var5 = (bpy)this.e.a(var4);
         if (ArrayUtils.contains(var1, var5.d())) {
            var2.add(var5);
         }
      }

      if (var2.isEmpty()) {
         return null;
      } else {
         return (bpy)var2.get((new Random()).nextInt(var2.size()));
      }
   }

   public void b() {
      this.f.c();
   }

   public bpz(bni var1, avh var2) {
      this.g = var1;
      this.f = new bpx(this, var2);
   }

   public boolean c(bpj var1) {
      return this.f.a(var1);
   }

   public void a(bpj var1) {
      this.f.c(var1);
   }

   private void a(jy var1, bph var2) {
      boolean var4 = !this.e.d(var1);
      bpy var3;
      if (!var4 && !var2.b()) {
         var3 = (bpy)this.e.a(var1);
      } else {
         if (!var4) {
            b.debug("Replaced sound event location {}", new Object[]{var1});
         }

         var3 = new bpy(var1, 1.0D, 1.0D, var2.c());
         this.e.a(var3);
      }

      Iterator var5 = var2.a().iterator();

      while(var5.hasNext()) {
         bph.a var6 = (bph.a)var5.next();
         String var7 = var6.a();
         jy var8 = new jy(var7);
         String var9 = var7.contains(":") ? var8.b() : var1.b();
         Object var10;
         switch(var6.e()) {
         case a:
            jy var11 = new jy(var9, "sounds/" + var8.a() + ".ogg");
            InputStream var12 = null;

            try {
               var12 = this.g.a(var11).b();
            } catch (FileNotFoundException var18) {
               b.warn("File {} does not exist, cannot add it to event {}", new Object[]{var11, var1});
               continue;
            } catch (IOException var19) {
               b.warn("Could not load sound file " + var11 + ", cannot add it to event " + var1, var19);
               continue;
            } finally {
               IOUtils.closeQuietly(var12);
            }

            var10 = new bqc(new bpw(var11, (double)var6.c(), (double)var6.b(), var6.f()), var6.d());
            break;
         case b:
            var10 = new bqb<bpw>(this, var9, var6) {
               final String b;
               final bpz d;
               final jy a;
               final bph.a c;

               {
                  this.d = var1;
                  this.b = var2;
                  this.c = var3;
                  this.a = new jy(this.b, this.c.a());
               }

               public int a() {
                  bpy var1 = (bpy)bpz.a(this.d).a(this.a);
                  return var1 == null ? 0 : var1.a();
               }

               public Object g() {
                  return this.b();
               }

               public bpw b() {
                  bpy var1 = (bpy)bpz.a(this.d).a(this.a);
                  return var1 == null ? bpz.a : var1.b();
               }
            };
            break;
         default:
            throw new IllegalStateException("IN YOU FACE");
         }

         var3.a((bqb)var10);
      }

   }

   static bqa a(bpz var0) {
      return var0.e;
   }

   public void b(bpj var1) {
      this.f.b(var1);
   }

   public void d() {
      this.f.b();
   }

   public void a() {
      this.f.e();
   }
}
