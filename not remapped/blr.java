import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.vector.Matrix4f;

public class blr {
   private String c;
   private bfw a;
   private final List<bls> d = Lists.newArrayList();
   private final Map<String, bfw> e = Maps.newHashMap();
   private float j;
   private Matrix4f g;
   private int i;
   private int h;
   private bni b;
   private float k;
   private final List<bfw> f = Lists.newArrayList();

   public void a(bmj var1, jy var2) throws JsonSyntaxException, IOException {
      JsonParser var3 = new JsonParser();
      InputStream var4 = null;

      try {
         bnh var5 = this.b.a(var2);
         var4 = var5.b();
         JsonObject var22 = var3.parse(IOUtils.toString(var4, Charsets.UTF_8)).getAsJsonObject();
         JsonArray var7;
         int var8;
         Iterator var9;
         JsonElement var10;
         kc var12;
         if (ni.d(var22, "targets")) {
            var7 = var22.getAsJsonArray("targets");
            var8 = 0;

            for(var9 = var7.iterator(); var9.hasNext(); ++var8) {
               var10 = (JsonElement)var9.next();

               try {
                  this.a(var10);
               } catch (Exception var19) {
                  var12 = kc.a(var19);
                  var12.a("targets[" + var8 + "]");
                  throw var12;
               }
            }
         }

         if (ni.d(var22, "passes")) {
            var7 = var22.getAsJsonArray("passes");
            var8 = 0;

            for(var9 = var7.iterator(); var9.hasNext(); ++var8) {
               var10 = (JsonElement)var9.next();

               try {
                  this.a(var1, var10);
               } catch (Exception var18) {
                  var12 = kc.a(var18);
                  var12.a("passes[" + var8 + "]");
                  throw var12;
               }
            }
         }
      } catch (Exception var20) {
         kc var6 = kc.a(var20);
         var6.b(var2.a());
         throw var6;
      } finally {
         IOUtils.closeQuietly(var4);
      }

   }

   public void a(float var1) {
      if (var1 < this.k) {
         this.j += 1.0F - this.k;
         this.j += var1;
      } else {
         this.j += var1 - this.k;
      }

      for(this.k = var1; this.j > 20.0F; this.j -= 20.0F) {
      }

      Iterator var2 = this.d.iterator();

      while(var2.hasNext()) {
         bls var3 = (bls)var2.next();
         var3.a(this.j / 20.0F);
      }

   }

   public bfw a(String var1) {
      return (bfw)this.e.get(var1);
   }

   private void a(JsonElement var1) throws kc {
      if (ni.a(var1)) {
         this.a(var1.getAsString(), this.h, this.i);
      } else {
         JsonObject var2 = ni.l(var1, "target");
         String var3 = ni.h(var2, "name");
         int var4 = ni.a(var2, "width", this.h);
         int var5 = ni.a(var2, "height", this.i);
         if (this.e.containsKey(var3)) {
            throw new kc(var3 + " is already defined");
         }

         this.a(var3, var4, var5);
      }

   }

   public blr(bmj var1, bni var2, bfw var3, jy var4) throws JsonSyntaxException, IOException {
      this.b = var2;
      this.a = var3;
      this.j = 0.0F;
      this.k = 0.0F;
      this.h = var3.c;
      this.i = var3.d;
      this.c = var4.toString();
      this.c();
      this.a(var1, var4);
   }

   public bls a(String var1, bfw var2, bfw var3) throws IOException {
      bls var4 = new bls(this.b, var1, var2, var3);
      this.d.add(this.d.size(), var4);
      return var4;
   }

   private void b(JsonElement var1) throws kc {
      JsonObject var2 = ni.l(var1, "uniform");
      String var3 = ni.h(var2, "name");
      blv var4 = ((bls)this.d.get(this.d.size() - 1)).c().a(var3);
      if (var4 == null) {
         throw new kc("Uniform '" + var3 + "' does not exist");
      } else {
         float[] var5 = new float[4];
         int var6 = 0;
         JsonArray var7 = ni.t(var2, "values");

         for(Iterator var8 = var7.iterator(); var8.hasNext(); ++var6) {
            JsonElement var9 = (JsonElement)var8.next();

            try {
               var5[var6] = ni.d(var9, "value");
            } catch (Exception var12) {
               kc var11 = kc.a(var12);
               var11.a("values[" + var6 + "]");
               throw var11;
            }
         }

         switch(var6) {
         case 0:
         default:
            break;
         case 1:
            var4.a(var5[0]);
            break;
         case 2:
            var4.a(var5[0], var5[1]);
            break;
         case 3:
            var4.a(var5[0], var5[1], var5[2]);
            break;
         case 4:
            var4.a(var5[0], var5[1], var5[2], var5[3]);
         }

      }
   }

   private bfw b(String var1) {
      if (var1 == null) {
         return null;
      } else {
         return var1.equals("minecraft:main") ? this.a : (bfw)this.e.get(var1);
      }
   }

   private void c() {
      this.g = new Matrix4f();
      this.g.setIdentity();
      this.g.m00 = 2.0F / (float)this.a.a;
      this.g.m11 = 2.0F / (float)(-this.a.b);
      this.g.m22 = -0.0020001999F;
      this.g.m33 = 1.0F;
      this.g.m03 = -1.0F;
      this.g.m13 = 1.0F;
      this.g.m23 = -1.0001999F;
   }

   public void a() {
      Iterator var1 = this.e.values().iterator();

      while(var1.hasNext()) {
         bfw var2 = (bfw)var1.next();
         var2.a();
      }

      var1 = this.d.iterator();

      while(var1.hasNext()) {
         bls var3 = (bls)var1.next();
         var3.b();
      }

      this.d.clear();
   }

   private void a(bmj var1, JsonElement var2) throws IOException {
      JsonObject var3 = ni.l(var2, "pass");
      String var4 = ni.h(var3, "name");
      String var5 = ni.h(var3, "intarget");
      String var6 = ni.h(var3, "outtarget");
      bfw var7 = this.b(var5);
      bfw var8 = this.b(var6);
      if (var7 == null) {
         throw new kc("Input target '" + var5 + "' does not exist");
      } else if (var8 == null) {
         throw new kc("Output target '" + var6 + "' does not exist");
      } else {
         bls var9 = this.a(var4, var7, var8);
         JsonArray var10 = ni.a(var3, "auxtargets", (JsonArray)null);
         if (var10 != null) {
            int var11 = 0;

            for(Iterator var12 = var10.iterator(); var12.hasNext(); ++var11) {
               JsonElement var13 = (JsonElement)var12.next();

               try {
                  JsonObject var14 = ni.l(var13, "auxtarget");
                  String var30 = ni.h(var14, "name");
                  String var16 = ni.h(var14, "id");
                  bfw var17 = this.b(var16);
                  if (var17 == null) {
                     jy var18 = new jy("textures/effect/" + var16 + ".png");

                     try {
                        this.b.a(var18);
                     } catch (FileNotFoundException var24) {
                        throw new kc("Render target or texture '" + var16 + "' does not exist");
                     }

                     var1.a(var18);
                     bmk var19 = var1.b(var18);
                     int var20 = ni.m(var14, "width");
                     int var21 = ni.m(var14, "height");
                     boolean var22 = ni.i(var14, "bilinear");
                     if (var22) {
                        GL11.glTexParameteri(3553, 10241, 9729);
                        GL11.glTexParameteri(3553, 10240, 9729);
                     } else {
                        GL11.glTexParameteri(3553, 10241, 9728);
                        GL11.glTexParameteri(3553, 10240, 9728);
                     }

                     var9.a(var30, var19.b(), var20, var21);
                  } else {
                     var9.a(var30, var17, var17.a, var17.b);
                  }
               } catch (Exception var25) {
                  kc var15 = kc.a(var25);
                  var15.a("auxtargets[" + var11 + "]");
                  throw var15;
               }
            }
         }

         JsonArray var26 = ni.a(var3, "uniforms", (JsonArray)null);
         if (var26 != null) {
            int var27 = 0;

            for(Iterator var28 = var26.iterator(); var28.hasNext(); ++var27) {
               JsonElement var29 = (JsonElement)var28.next();

               try {
                  this.b(var29);
               } catch (Exception var23) {
                  kc var31 = kc.a(var23);
                  var31.a("uniforms[" + var27 + "]");
                  throw var31;
               }
            }
         }

      }
   }

   public void a(String var1, int var2, int var3) {
      bfw var4 = new bfw(var2, var3, true);
      var4.a(0.0F, 0.0F, 0.0F, 0.0F);
      this.e.put(var1, var4);
      if (var2 == this.h && var3 == this.i) {
         this.f.add(var4);
      }

   }

   public void a(int var1, int var2) {
      this.h = this.a.a;
      this.i = this.a.b;
      this.c();
      Iterator var3 = this.d.iterator();

      while(var3.hasNext()) {
         bls var4 = (bls)var3.next();
         var4.a(this.g);
      }

      var3 = this.f.iterator();

      while(var3.hasNext()) {
         bfw var5 = (bfw)var3.next();
         var5.a(var1, var2);
      }

   }

   public final String b() {
      return this.c;
   }
}
