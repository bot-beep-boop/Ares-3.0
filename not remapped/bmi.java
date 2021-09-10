import com.google.common.collect.Lists;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

public class bmi {
   protected List<int[][]> a = Lists.newArrayList();
   protected int f;
   protected int g;
   protected int e;
   private final String j;
   private float n;
   private float m;
   protected boolean c;
   private boa k;
   private float o;
   private static String q = "builtin/compass";
   protected int[][] b;
   protected int d;
   protected int h;
   private static String p = "builtin/clock";
   protected int i;
   private float l;

   public void b(int var1) {
      this.f = var1;
   }

   public int[][] a(int var1) {
      return (int[][])this.a.get(var1);
   }

   public int b() {
      return this.e;
   }

   public float e() {
      return this.l;
   }

   protected static bmi a(jy var0) {
      String var1 = var0.toString();
      if (p.equals(var1)) {
         return new bmo(var1);
      } else {
         return (bmi)(q.equals(var1) ? new bmp(var1) : new bmi(var1));
      }
   }

   public static void a(String var0) {
      p = var0;
   }

   public float h() {
      return this.o;
   }

   public void c(int var1) {
      this.g = var1;
   }

   public String toString() {
      return "TextureAtlasSprite{name='" + this.j + '\'' + ", frameCount=" + this.a.size() + ", rotated=" + this.c + ", x=" + this.d + ", y=" + this.e + ", height=" + this.g + ", width=" + this.f + ", u0=" + this.l + ", u1=" + this.m + ", v0=" + this.n + ", v1=" + this.o + '}';
   }

   public void j() {
      ++this.i;
      if (this.i >= this.k.a(this.h)) {
         int var1 = this.k.c(this.h);
         int var2 = this.k.c() == 0 ? this.a.size() : this.k.c();
         this.h = (this.h + 1) % var2;
         this.i = 0;
         int var3 = this.k.c(this.h);
         if (var1 != var3 && var3 >= 0 && var3 < this.a.size()) {
            bml.a((int[][])this.a.get(var3), this.f, this.g, this.d, this.e, false, false);
         }
      } else if (this.k.e()) {
         this.n();
      }

   }

   private void o() {
      this.k = null;
      this.a((List)Lists.newArrayList());
      this.h = 0;
      this.i = 0;
   }

   private static int[][] a(int[][] var0, int var1, int var2, int var3) {
      int[][] var4 = new int[var0.length][];

      for(int var5 = 0; var5 < var0.length; ++var5) {
         int[] var6 = var0[var5];
         if (var6 != null) {
            var4[var5] = new int[(var1 >> var5) * (var2 >> var5)];
            System.arraycopy(var6, var3 * var4[var5].length, var4[var5], 0, var4[var5].length);
         }
      }

      return var4;
   }

   public void a(List<int[][]> var1) {
      this.a = var1;
   }

   public int d() {
      return this.g;
   }

   public void d(int var1) {
      ArrayList var2 = Lists.newArrayList();

      for(int var3 = 0; var3 < this.a.size(); ++var3) {
         int[][] var4 = (int[][])this.a.get(var3);
         if (var4 != null) {
            try {
               var2.add(bml.a(var1, this.f, var4));
            } catch (Throwable var8) {
               b var6 = b.a(var8, "Generating mipmaps for frame");
               c var7 = var6.a("Frame being iterated");
               var7.a((String)"Frame index", (Object)var3);
               var7.a("Frame sizes", new Callable<String>(this, var4) {
                  final int[][] a;
                  final bmi b;

                  public Object call() throws Exception {
                     return this.a();
                  }

                  {
                     this.b = var1;
                     this.a = var2;
                  }

                  public String a() throws Exception {
                     StringBuilder var1 = new StringBuilder();
                     int[][] var2 = this.a;
                     int var3 = var2.length;

                     for(int var4 = 0; var4 < var3; ++var4) {
                        int[] var5 = var2[var4];
                        if (var1.length() > 0) {
                           var1.append(", ");
                        }

                        var1.append(var5 == null ? "null" : var5.length);
                     }

                     return var1.toString();
                  }
               });
               throw new e(var6);
            }
         }
      }

      this.a((List)var2);
   }

   private void e(int var1) {
      if (this.a.size() <= var1) {
         for(int var2 = this.a.size(); var2 <= var1; ++var2) {
            this.a.add((Object)null);
         }

      }
   }

   public void a(BufferedImage[] var1, boa var2) throws IOException {
      this.o();
      int var3 = var1[0].getWidth();
      int var4 = var1[0].getHeight();
      this.f = var3;
      this.g = var4;
      int[][] var5 = new int[var1.length][];

      int var6;
      for(var6 = 0; var6 < var1.length; ++var6) {
         BufferedImage var7 = var1[var6];
         if (var7 != null) {
            if (var6 > 0 && (var7.getWidth() != var3 >> var6 || var7.getHeight() != var4 >> var6)) {
               throw new RuntimeException(String.format("Unable to load miplevel: %d, image is size: %dx%d, expected %dx%d", var6, var7.getWidth(), var7.getHeight(), var3 >> var6, var4 >> var6));
            }

            var5[var6] = new int[var7.getWidth() * var7.getHeight()];
            var7.getRGB(0, 0, var7.getWidth(), var7.getHeight(), var5[var6], 0, var7.getWidth());
         }
      }

      if (var2 == null) {
         if (var4 != var3) {
            throw new RuntimeException("broken aspect ratio and not an animation");
         }

         this.a.add(var5);
      } else {
         var6 = var4 / var3;
         int var11 = var3;
         int var8 = var3;
         this.g = this.f;
         int var10;
         if (var2.c() > 0) {
            Iterator var9 = var2.f().iterator();

            while(var9.hasNext()) {
               var10 = (Integer)var9.next();
               if (var10 >= var6) {
                  throw new RuntimeException("invalid frameindex " + var10);
               }

               this.e(var10);
               this.a.set(var10, a(var5, var11, var8, var10));
            }

            this.k = var2;
         } else {
            ArrayList var12 = Lists.newArrayList();

            for(var10 = 0; var10 < var6; ++var10) {
               this.a.add(a(var5, var11, var8, var10));
               var12.add(new bnz(var10, -1));
            }

            this.k = new boa(var12, this.f, this.g, var2.d(), var2.e());
         }
      }

   }

   public int a() {
      return this.d;
   }

   public void a(bmi var1) {
      this.d = var1.d;
      this.e = var1.e;
      this.f = var1.f;
      this.g = var1.g;
      this.c = var1.c;
      this.l = var1.l;
      this.m = var1.m;
      this.n = var1.n;
      this.o = var1.o;
   }

   protected bmi(String var1) {
      this.j = var1;
   }

   public String i() {
      return this.j;
   }

   public boolean m() {
      return this.k != null;
   }

   public float f() {
      return this.m;
   }

   public float b(double var1) {
      float var3 = this.o - this.n;
      return this.n + var3 * ((float)var1 / 16.0F);
   }

   public int k() {
      return this.a.size();
   }

   private void n() {
      double var1 = 1.0D - (double)this.i / (double)this.k.a(this.h);
      int var3 = this.k.c(this.h);
      int var4 = this.k.c() == 0 ? this.a.size() : this.k.c();
      int var5 = this.k.c((this.h + 1) % var4);
      if (var3 != var5 && var5 >= 0 && var5 < this.a.size()) {
         int[][] var6 = (int[][])this.a.get(var3);
         int[][] var7 = (int[][])this.a.get(var5);
         if (this.b == null || this.b.length != var6.length) {
            this.b = new int[var6.length][];
         }

         for(int var8 = 0; var8 < var6.length; ++var8) {
            if (this.b[var8] == null) {
               this.b[var8] = new int[var6[var8].length];
            }

            if (var8 < var7.length && var7[var8].length == var6[var8].length) {
               for(int var9 = 0; var9 < var6[var8].length; ++var9) {
                  int var10 = var6[var8][var9];
                  int var11 = var7[var8][var9];
                  int var12 = (int)((double)((var10 & 16711680) >> 16) * var1 + (double)((var11 & 16711680) >> 16) * (1.0D - var1));
                  int var13 = (int)((double)((var10 & '\uff00') >> 8) * var1 + (double)((var11 & '\uff00') >> 8) * (1.0D - var1));
                  int var14 = (int)((double)(var10 & 255) * var1 + (double)(var11 & 255) * (1.0D - var1));
                  this.b[var8][var9] = var10 & -16777216 | var12 << 16 | var13 << 8 | var14;
               }
            }
         }

         bml.a(this.b, this.f, this.g, this.d, this.e, false, false);
      }

   }

   public float a(double var1) {
      float var3 = this.m - this.l;
      return this.l + var3 * (float)var1 / 16.0F;
   }

   public int c() {
      return this.f;
   }

   public static void b(String var0) {
      q = var0;
   }

   public void a(int var1, int var2, int var3, int var4, boolean var5) {
      this.d = var3;
      this.e = var4;
      this.c = var5;
      float var6 = (float)(0.009999999776482582D / (double)var1);
      float var7 = (float)(0.009999999776482582D / (double)var2);
      this.l = (float)var3 / (float)((double)var1) + var6;
      this.m = (float)(var3 + this.f) / (float)((double)var1) - var6;
      this.n = (float)var4 / (float)var2 + var7;
      this.o = (float)(var4 + this.g) / (float)var2 - var7;
   }

   public void l() {
      this.a.clear();
   }

   public float g() {
      return this.n;
   }
}
