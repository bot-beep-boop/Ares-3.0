import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class blq {
   private final Map<String, Object> f = Maps.newHashMap();
   private final boolean n;
   private final List<Integer> h = Lists.newArrayList();
   private final List<String> r;
   private static final Logger a = LogManager.getLogger();
   private static final blp b = new blp();
   private static blq c = null;
   private final List<Integer> q;
   private static boolean e = true;
   private final List<String> g = Lists.newArrayList();
   private final blo p;
   private final blt t;
   private final List<blv> i = Lists.newArrayList();
   private final String m;
   private final int l;
   private boolean o;
   private final blt s;
   private static int d = -1;
   private final List<Integer> j = Lists.newArrayList();
   private final Map<String, blv> k = Maps.newHashMap();

   public void a() {
      blu.b().a(this);
   }

   public int h() {
      return this.l;
   }

   private void a(JsonElement var1) throws kc {
      JsonObject var2 = ni.l(var1, "sampler");
      String var3 = ni.h(var2, "name");
      if (!ni.a(var2, "file")) {
         this.f.put(var3, (Object)null);
         this.g.add(var3);
      } else {
         this.g.add(var3);
      }
   }

   public void a(String var1, Object var2) {
      if (this.f.containsKey(var1)) {
         this.f.remove(var1);
      }

      this.f.put(var1, var2);
      this.d();
   }

   public void b() {
      bqs.d(0);
      d = -1;
      c = null;
      e = true;

      for(int var1 = 0; var1 < this.h.size(); ++var1) {
         if (this.f.get(this.g.get(var1)) != null) {
            bfl.g(bqs.q + var1);
            bfl.i(0);
         }
      }

   }

   public blv a(String var1) {
      return this.k.containsKey(var1) ? (blv)this.k.get(var1) : null;
   }

   public blt e() {
      return this.s;
   }

   public void d() {
      this.o = true;
   }

   private void b(JsonElement var1) throws kc {
      JsonObject var2 = ni.l(var1, "uniform");
      String var3 = ni.h(var2, "name");
      int var4 = blv.a(ni.h(var2, "type"));
      int var5 = ni.m(var2, "count");
      float[] var6 = new float[Math.max(var5, 16)];
      JsonArray var7 = ni.t(var2, "values");
      if (var7.size() != var5 && var7.size() > 1) {
         throw new kc("Invalid amount of values specified (expected " + var5 + ", found " + var7.size() + ")");
      } else {
         int var8 = 0;

         for(Iterator var9 = var7.iterator(); var9.hasNext(); ++var8) {
            JsonElement var10 = (JsonElement)var9.next();

            try {
               var6[var8] = ni.d(var10, "value");
            } catch (Exception var13) {
               kc var12 = kc.a(var13);
               var12.a("values[" + var8 + "]");
               throw var12;
            }
         }

         if (var5 > 1 && var7.size() == 1) {
            while(var8 < var5) {
               var6[var8] = var6[0];
               ++var8;
            }
         }

         int var14 = var5 > 1 && var5 <= 4 && var4 < 8 ? var5 - 1 : 0;
         blv var15 = new blv(var3, var4 + var14, var5, this);
         if (var4 <= 3) {
            var15.a((int)var6[0], (int)var6[1], (int)var6[2], (int)var6[3]);
         } else if (var4 <= 7) {
            var15.b(var6[0], var6[1], var6[2], var6[3]);
         } else {
            var15.a(var6);
         }

         this.i.add(var15);
      }
   }

   public blv b(String var1) {
      return (blv)(this.k.containsKey(var1) ? (blv)this.k.get(var1) : b);
   }

   public void c() {
      this.o = false;
      c = this;
      this.p.a();
      if (this.l != d) {
         bqs.d(this.l);
         d = this.l;
      }

      if (this.n) {
         bfl.o();
      } else {
         bfl.p();
      }

      for(int var1 = 0; var1 < this.h.size(); ++var1) {
         if (this.f.get(this.g.get(var1)) != null) {
            bfl.g(bqs.q + var1);
            bfl.w();
            Object var2 = this.f.get(this.g.get(var1));
            int var3 = -1;
            if (var2 instanceof bfw) {
               var3 = ((bfw)var2).g;
            } else if (var2 instanceof bmk) {
               var3 = ((bmk)var2).b();
            } else if (var2 instanceof Integer) {
               var3 = (Integer)var2;
            }

            if (var3 != -1) {
               bfl.i(var3);
               bqs.f(bqs.a(this.l, (CharSequence)this.g.get(var1)), var1);
            }
         }
      }

      Iterator var4 = this.i.iterator();

      while(var4.hasNext()) {
         blv var5 = (blv)var4.next();
         var5.b();
      }

   }

   public blt f() {
      return this.t;
   }

   private void i() {
      int var1 = 0;

      String var3;
      int var4;
      for(int var2 = 0; var1 < this.g.size(); ++var2) {
         var3 = (String)this.g.get(var1);
         var4 = bqs.a(this.l, (CharSequence)var3);
         if (var4 == -1) {
            a.warn("Shader " + this.m + "could not find sampler named " + var3 + " in the specified shader program.");
            this.f.remove(var3);
            this.g.remove(var2);
            --var2;
         } else {
            this.h.add(var4);
         }

         ++var1;
      }

      Iterator var5 = this.i.iterator();

      while(var5.hasNext()) {
         blv var6 = (blv)var5.next();
         var3 = var6.a();
         var4 = bqs.a(this.l, (CharSequence)var3);
         if (var4 == -1) {
            a.warn("Could not find uniform named " + var3 + " in the specified" + " shader program.");
         } else {
            this.j.add(var4);
            var6.b(var4);
            this.k.put(var3, var6);
         }
      }

   }

   public blq(bni var1, String var2) throws IOException {
      JsonParser var3 = new JsonParser();
      jy var4 = new jy("shaders/program/" + var2 + ".json");
      this.m = var2;
      InputStream var5 = null;

      try {
         var5 = var1.a(var4).b();
         JsonObject var6 = var3.parse(IOUtils.toString(var5, Charsets.UTF_8)).getAsJsonObject();
         String var7 = ni.h(var6, "vertex");
         String var28 = ni.h(var6, "fragment");
         JsonArray var9 = ni.a(var6, "samplers", (JsonArray)null);
         if (var9 != null) {
            int var10 = 0;

            for(Iterator var11 = var9.iterator(); var11.hasNext(); ++var10) {
               JsonElement var12 = (JsonElement)var11.next();

               try {
                  this.a(var12);
               } catch (Exception var25) {
                  kc var14 = kc.a(var25);
                  var14.a("samplers[" + var10 + "]");
                  throw var14;
               }
            }
         }

         JsonArray var29 = ni.a(var6, "attributes", (JsonArray)null);
         Iterator var32;
         if (var29 != null) {
            int var30 = 0;
            this.q = Lists.newArrayListWithCapacity(var29.size());
            this.r = Lists.newArrayListWithCapacity(var29.size());

            for(var32 = var29.iterator(); var32.hasNext(); ++var30) {
               JsonElement var13 = (JsonElement)var32.next();

               try {
                  this.r.add(ni.a(var13, "attribute"));
               } catch (Exception var24) {
                  kc var15 = kc.a(var24);
                  var15.a("attributes[" + var30 + "]");
                  throw var15;
               }
            }
         } else {
            this.q = null;
            this.r = null;
         }

         JsonArray var31 = ni.a(var6, "uniforms", (JsonArray)null);
         if (var31 != null) {
            int var33 = 0;

            for(Iterator var34 = var31.iterator(); var34.hasNext(); ++var33) {
               JsonElement var36 = (JsonElement)var34.next();

               try {
                  this.b(var36);
               } catch (Exception var23) {
                  kc var16 = kc.a(var23);
                  var16.a("uniforms[" + var33 + "]");
                  throw var16;
               }
            }
         }

         this.p = blo.a(ni.a(var6, "blend", (JsonObject)null));
         this.n = ni.a(var6, "cull", true);
         this.s = blt.a(var1, blt.a.a, var7);
         this.t = blt.a(var1, blt.a.b, var28);
         this.l = blu.b().c();
         blu.b().b(this);
         this.i();
         if (this.r != null) {
            var32 = this.r.iterator();

            while(var32.hasNext()) {
               String var35 = (String)var32.next();
               int var37 = bqs.b(this.l, (CharSequence)var35);
               this.q.add(var37);
            }
         }
      } catch (Exception var26) {
         kc var8 = kc.a(var26);
         var8.b(var4.a());
         throw var8;
      } finally {
         IOUtils.closeQuietly(var5);
      }

      this.d();
   }
}
