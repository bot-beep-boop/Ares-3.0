import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class bmh extends bly implements bmn {
   public static final jy g = new jy("textures/atlas/blocks.png");
   private final bmi o;
   private final bmb m;
   private final String l;
   public static final jy f = new jy("missingno");
   private final Map<String, bmi> k;
   private int n;
   private final List<bmi> i;
   private static final Logger h = LogManager.getLogger();
   private final Map<String, bmi> j;

   public bmh(String var1, bmb var2) {
      this.i = Lists.newArrayList();
      this.j = Maps.newHashMap();
      this.k = Maps.newHashMap();
      this.o = new bmi("missingno");
      this.l = var1;
      this.m = var2;
   }

   public void d() {
      bml.b(this.b());
      Iterator var1 = this.i.iterator();

      while(var1.hasNext()) {
         bmi var2 = (bmi)var1.next();
         var2.j();
      }

   }

   public bmh(String var1) {
      this(var1, (bmb)null);
   }

   public bmi f() {
      return this.o;
   }

   public void a(bni var1, bmb var2) {
      this.j.clear();
      var2.a(this);
      this.g();
      this.c();
      this.b(var1);
   }

   private jy a(jy var1, int var2) {
      return var2 == 0 ? new jy(var1.b(), String.format("%s/%s%s", this.l, var1.a(), ".png")) : new jy(var1.b(), String.format("%s/mipmaps/%s.%d%s", this.l, var1.a(), var2, ".png"));
   }

   public void b(bni var1) {
      int var2 = ave.C();
      bmf var3 = new bmf(var2, var2, true, 0, this.n);
      this.k.clear();
      this.i.clear();
      int var4 = Integer.MAX_VALUE;
      int var5 = 1 << this.n;
      Iterator var6 = this.j.entrySet().iterator();

      while(var6.hasNext()) {
         Entry var7 = (Entry)var6.next();
         bmi var8 = (bmi)var7.getValue();
         jy var9 = new jy(var8.i());
         jy var10 = this.a(var9, 0);

         try {
            bnh var11 = var1.a(var10);
            BufferedImage[] var12 = new BufferedImage[1 + this.n];
            var12[0] = bml.a(var11.b());
            bon var13 = (bon)var11.a("texture");
            if (var13 != null) {
               List var14 = var13.c();
               int var16;
               if (!var14.isEmpty()) {
                  int var15 = var12[0].getWidth();
                  var16 = var12[0].getHeight();
                  if (ns.b(var15) != var15 || ns.b(var16) != var16) {
                     throw new RuntimeException("Unable to load extra miplevels, source-texture is not power of two");
                  }
               }

               Iterator var39 = var14.iterator();

               while(var39.hasNext()) {
                  var16 = (Integer)var39.next();
                  if (var16 > 0 && var16 < var12.length - 1 && var12[var16] == null) {
                     jy var17 = this.a(var9, var16);

                     try {
                        var12[var16] = bml.a(var1.a(var17).b());
                     } catch (IOException var22) {
                        h.error("Unable to load miplevel {} from: {}", new Object[]{var16, var17, var22});
                     }
                  }
               }
            }

            boa var37 = (boa)var11.a("animation");
            var8.a(var12, var37);
         } catch (RuntimeException var23) {
            h.error("Unable to parse metadata from " + var10, var23);
            continue;
         } catch (IOException var24) {
            h.error("Using missing texture, unable to load " + var10, var24);
            continue;
         }

         var4 = Math.min(var4, Math.min(var8.c(), var8.d()));
         int var32 = Math.min(Integer.lowestOneBit(var8.c()), Integer.lowestOneBit(var8.d()));
         if (var32 < var5) {
            h.warn("Texture {} with size {}x{} limits mip level from {} to {}", new Object[]{var10, var8.c(), var8.d(), ns.c(var5), ns.c(var32)});
            var5 = var32;
         }

         var3.a(var8);
      }

      int var25 = Math.min(var4, var5);
      int var26 = ns.c(var25);
      if (var26 < this.n) {
         h.warn("{}: dropping miplevel from {} to {}, because of minimum power of two: {}", new Object[]{this.l, this.n, var26, var25});
         this.n = var26;
      }

      Iterator var27 = this.j.values().iterator();

      while(var27.hasNext()) {
         bmi var29 = (bmi)var27.next();

         try {
            var29.d(this.n);
         } catch (Throwable var21) {
            b var33 = b.a(var21, "Applying mipmap");
            c var35 = var33.a("Sprite being mipmapped");
            var35.a("Sprite name", new Callable<String>(this, var29) {
               final bmi a;
               final bmh b;

               public String a() throws Exception {
                  return this.a.i();
               }

               {
                  this.b = var1;
                  this.a = var2;
               }

               public Object call() throws Exception {
                  return this.a();
               }
            });
            var35.a("Sprite size", new Callable<String>(this, var29) {
               final bmh b;
               final bmi a;

               {
                  this.b = var1;
                  this.a = var2;
               }

               public String a() throws Exception {
                  return this.a.c() + " x " + this.a.d();
               }

               public Object call() throws Exception {
                  return this.a();
               }
            });
            var35.a("Sprite frames", new Callable<String>(this, var29) {
               final bmi a;
               final bmh b;

               public Object call() throws Exception {
                  return this.a();
               }

               {
                  this.b = var1;
                  this.a = var2;
               }

               public String a() throws Exception {
                  return this.a.k() + " frames";
               }
            });
            var35.a((String)"Mipmap levels", (Object)this.n);
            throw new e(var33);
         }
      }

      this.o.d(this.n);
      var3.a(this.o);

      try {
         var3.c();
      } catch (bmg var20) {
         throw var20;
      }

      h.info("Created: {}x{} {}-atlas", new Object[]{var3.a(), var3.b(), this.l});
      bml.a(this.b(), this.n, var3.a(), var3.b());
      HashMap var28 = Maps.newHashMap(this.j);
      Iterator var30 = var3.d().iterator();

      bmi var31;
      while(var30.hasNext()) {
         var31 = (bmi)var30.next();
         String var34 = var31.i();
         var28.remove(var34);
         this.k.put(var34, var31);

         try {
            bml.a(var31.a(0), var31.c(), var31.d(), var31.a(), var31.b(), false, false);
         } catch (Throwable var19) {
            b var36 = b.a(var19, "Stitching texture atlas");
            c var38 = var36.a("Texture being stitched together");
            var38.a((String)"Atlas path", (Object)this.l);
            var38.a((String)"Sprite", (Object)var31);
            throw new e(var36);
         }

         if (var31.m()) {
            this.i.add(var31);
         }
      }

      var30 = var28.values().iterator();

      while(var30.hasNext()) {
         var31 = (bmi)var30.next();
         var31.a(this.o);
      }

   }

   public void a(int var1) {
      this.n = var1;
   }

   public void e() {
      this.d();
   }

   public bmi a(String var1) {
      bmi var2 = (bmi)this.k.get(var1);
      if (var2 == null) {
         var2 = this.o;
      }

      return var2;
   }

   private void g() {
      int[] var1 = bml.b;
      this.o.b(16);
      this.o.c(16);
      int[][] var2 = new int[this.n + 1][];
      var2[0] = var1;
      this.o.a((List)Lists.newArrayList(new int[][][]{var2}));
   }

   public bmi a(jy var1) {
      if (var1 == null) {
         throw new IllegalArgumentException("Location cannot be null!");
      } else {
         bmi var2 = (bmi)this.j.get(var1);
         if (var2 == null) {
            var2 = bmi.a(var1);
            this.j.put(var1.toString(), var2);
         }

         return var2;
      }
   }

   public void a(bni var1) throws IOException {
      if (this.m != null) {
         this.a(var1, this.m);
      }

   }
}
