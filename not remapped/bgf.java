import java.util.BitSet;
import java.util.Iterator;
import java.util.List;

public class bgf {
   private void a(adq var1, afh var2, cj var3, bfd var4, List<bgg> var5, float[] var6, BitSet var7, bgf.b var8) {
      double var9 = (double)var3.n();
      double var11 = (double)var3.o();
      double var13 = (double)var3.p();
      afh.a var15 = var2.R();
      if (var15 != afh.a.a) {
         long var16 = ns.a((df)var3);
         var9 += ((double)((float)(var16 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
         var13 += ((double)((float)(var16 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
         if (var15 == afh.a.c) {
            var11 += ((double)((float)(var16 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
         }
      }

      for(Iterator var22 = var5.iterator(); var22.hasNext(); var4.a(var9, var11, var13)) {
         bgg var17 = (bgg)var22.next();
         this.a(var2, var17.a(), var17.d(), var6, var7);
         var8.a(var1, var2, var3, var17.d(), var6, var7);
         var4.a(var17.a());
         var4.a(bgf.b.a(var8)[0], bgf.b.a(var8)[1], bgf.b.a(var8)[2], bgf.b.a(var8)[3]);
         if (var17.b()) {
            int var18 = var2.a(var1, var3, var17.c());
            if (bfk.a) {
               var18 = bml.c(var18);
            }

            float var19 = (float)(var18 >> 16 & 255) / 255.0F;
            float var20 = (float)(var18 >> 8 & 255) / 255.0F;
            float var21 = (float)(var18 & 255) / 255.0F;
            var4.a(bgf.b.b(var8)[0] * var19, bgf.b.b(var8)[0] * var20, bgf.b.b(var8)[0] * var21, 4);
            var4.a(bgf.b.b(var8)[1] * var19, bgf.b.b(var8)[1] * var20, bgf.b.b(var8)[1] * var21, 3);
            var4.a(bgf.b.b(var8)[2] * var19, bgf.b.b(var8)[2] * var20, bgf.b.b(var8)[2] * var21, 2);
            var4.a(bgf.b.b(var8)[3] * var19, bgf.b.b(var8)[3] * var20, bgf.b.b(var8)[3] * var21, 1);
         } else {
            var4.a(bgf.b.b(var8)[0], bgf.b.b(var8)[0], bgf.b.b(var8)[0], 4);
            var4.a(bgf.b.b(var8)[1], bgf.b.b(var8)[1], bgf.b.b(var8)[1], 3);
            var4.a(bgf.b.b(var8)[2], bgf.b.b(var8)[2], bgf.b.b(var8)[2], 2);
            var4.a(bgf.b.b(var8)[3], bgf.b.b(var8)[3], bgf.b.b(var8)[3], 1);
         }
      }

   }

   public boolean b(adq var1, boq var2, afh var3, cj var4, bfd var5, boolean var6) {
      boolean var7 = false;
      BitSet var8 = new BitSet(3);
      cq[] var9 = cq.values();
      int var10 = var9.length;

      for(int var11 = 0; var11 < var10; ++var11) {
         cq var12 = var9[var11];
         List var13 = var2.a(var12);
         if (!var13.isEmpty()) {
            cj var14 = var4.a(var12);
            if (!var6 || var3.a(var1, var14, var12)) {
               int var15 = var3.c(var1, var14);
               this.a(var1, var3, var4, var12, var15, false, var5, var13, var8);
               var7 = true;
            }
         }
      }

      List var16 = var2.a();
      if (var16.size() > 0) {
         this.a(var1, var3, var4, (cq)null, -1, true, var5, var16, var8);
         var7 = true;
      }

      return var7;
   }

   public void a(boq var1, float var2, float var3, float var4, float var5) {
      cq[] var6 = cq.values();
      int var7 = var6.length;

      for(int var8 = 0; var8 < var7; ++var8) {
         cq var9 = var6[var8];
         this.a(var2, var3, var4, var5, var1.a(var9));
      }

      this.a(var2, var3, var4, var5, var1.a());
   }

   public boolean a(adq var1, boq var2, afh var3, cj var4, bfd var5, boolean var6) {
      boolean var7 = false;
      float[] var8 = new float[cq.values().length * 2];
      BitSet var9 = new BitSet(3);
      bgf.b var10 = new bgf.b(this);
      cq[] var11 = cq.values();
      int var12 = var11.length;

      for(int var13 = 0; var13 < var12; ++var13) {
         cq var14 = var11[var13];
         List var15 = var2.a(var14);
         if (!var15.isEmpty()) {
            cj var16 = var4.a(var14);
            if (!var6 || var3.a(var1, var16, var14)) {
               this.a(var1, var3, var4, var5, var15, var8, var9, var10);
               var7 = true;
            }
         }
      }

      List var17 = var2.a();
      if (var17.size() > 0) {
         this.a(var1, var3, var4, var5, var17, var8, var9, var10);
         var7 = true;
      }

      return var7;
   }

   private void a(afh var1, int[] var2, cq var3, float[] var4, BitSet var5) {
      float var6 = 32.0F;
      float var7 = 32.0F;
      float var8 = 32.0F;
      float var9 = -32.0F;
      float var10 = -32.0F;
      float var11 = -32.0F;

      float var13;
      for(int var12 = 0; var12 < 4; ++var12) {
         var13 = Float.intBitsToFloat(var2[var12 * 7]);
         float var14 = Float.intBitsToFloat(var2[var12 * 7 + 1]);
         float var15 = Float.intBitsToFloat(var2[var12 * 7 + 2]);
         var6 = Math.min(var6, var13);
         var7 = Math.min(var7, var14);
         var8 = Math.min(var8, var15);
         var9 = Math.max(var9, var13);
         var10 = Math.max(var10, var14);
         var11 = Math.max(var11, var15);
      }

      if (var4 != null) {
         var4[cq.e.a()] = var6;
         var4[cq.f.a()] = var9;
         var4[cq.a.a()] = var7;
         var4[cq.b.a()] = var10;
         var4[cq.c.a()] = var8;
         var4[cq.d.a()] = var11;
         var4[cq.e.a() + cq.values().length] = 1.0F - var6;
         var4[cq.f.a() + cq.values().length] = 1.0F - var9;
         var4[cq.a.a() + cq.values().length] = 1.0F - var7;
         var4[cq.b.a() + cq.values().length] = 1.0F - var10;
         var4[cq.c.a() + cq.values().length] = 1.0F - var8;
         var4[cq.d.a() + cq.values().length] = 1.0F - var11;
      }

      float var16 = 1.0E-4F;
      var13 = 0.9999F;
      switch(var3) {
      case a:
         var5.set(1, var6 >= 1.0E-4F || var8 >= 1.0E-4F || var9 <= 0.9999F || var11 <= 0.9999F);
         var5.set(0, (var7 < 1.0E-4F || var1.d()) && var7 == var10);
         break;
      case b:
         var5.set(1, var6 >= 1.0E-4F || var8 >= 1.0E-4F || var9 <= 0.9999F || var11 <= 0.9999F);
         var5.set(0, (var10 > 0.9999F || var1.d()) && var7 == var10);
         break;
      case c:
         var5.set(1, var6 >= 1.0E-4F || var7 >= 1.0E-4F || var9 <= 0.9999F || var10 <= 0.9999F);
         var5.set(0, (var8 < 1.0E-4F || var1.d()) && var8 == var11);
         break;
      case d:
         var5.set(1, var6 >= 1.0E-4F || var7 >= 1.0E-4F || var9 <= 0.9999F || var10 <= 0.9999F);
         var5.set(0, (var11 > 0.9999F || var1.d()) && var8 == var11);
         break;
      case e:
         var5.set(1, var7 >= 1.0E-4F || var8 >= 1.0E-4F || var10 <= 0.9999F || var11 <= 0.9999F);
         var5.set(0, (var6 < 1.0E-4F || var1.d()) && var6 == var9);
         break;
      case f:
         var5.set(1, var7 >= 1.0E-4F || var8 >= 1.0E-4F || var10 <= 0.9999F || var11 <= 0.9999F);
         var5.set(0, (var9 > 0.9999F || var1.d()) && var6 == var9);
      }

   }

   private void a(float var1, float var2, float var3, float var4, List<bgg> var5) {
      bfx var6 = bfx.a();
      bfd var7 = var6.c();
      Iterator var8 = var5.iterator();

      while(var8.hasNext()) {
         bgg var9 = (bgg)var8.next();
         var7.a(7, bms.b);
         var7.a(var9.a());
         if (var9.b()) {
            var7.d(var2 * var1, var3 * var1, var4 * var1);
         } else {
            var7.d(var1, var1, var1);
         }

         df var10 = var9.d().m();
         var7.b((float)var10.n(), (float)var10.o(), (float)var10.p());
         var6.b();
      }

   }

   public void a(boq var1, alz var2, float var3, boolean var4) {
      afh var5 = var2.c();
      var5.j();
      bfl.b(90.0F, 0.0F, 1.0F, 0.0F);
      int var6 = var5.h(var5.b(var2));
      if (bfk.a) {
         var6 = bml.c(var6);
      }

      float var7 = (float)(var6 >> 16 & 255) / 255.0F;
      float var8 = (float)(var6 >> 8 & 255) / 255.0F;
      float var9 = (float)(var6 & 255) / 255.0F;
      if (!var4) {
         bfl.c(var3, var3, var3, 1.0F);
      }

      this.a(var1, var3, var7, var8, var9);
   }

   private void a(adq var1, afh var2, cj var3, cq var4, int var5, boolean var6, bfd var7, List<bgg> var8, BitSet var9) {
      double var10 = (double)var3.n();
      double var12 = (double)var3.o();
      double var14 = (double)var3.p();
      afh.a var16 = var2.R();
      if (var16 != afh.a.a) {
         int var17 = var3.n();
         int var18 = var3.p();
         long var19 = (long)(var17 * 3129871) ^ (long)var18 * 116129781L;
         var19 = var19 * var19 * 42317861L + var19 * 11L;
         var10 += ((double)((float)(var19 >> 16 & 15L) / 15.0F) - 0.5D) * 0.5D;
         var14 += ((double)((float)(var19 >> 24 & 15L) / 15.0F) - 0.5D) * 0.5D;
         if (var16 == afh.a.c) {
            var12 += ((double)((float)(var19 >> 20 & 15L) / 15.0F) - 1.0D) * 0.2D;
         }
      }

      for(Iterator var23 = var8.iterator(); var23.hasNext(); var7.a(var10, var12, var14)) {
         bgg var24 = (bgg)var23.next();
         if (var6) {
            this.a((afh)var2, (int[])var24.a(), (cq)var24.d(), (float[])null, (BitSet)var9);
            var5 = var9.get(0) ? var2.c(var1, var3.a(var24.d())) : var2.c(var1, var3);
         }

         var7.a(var24.a());
         var7.a(var5, var5, var5, var5);
         if (var24.b()) {
            int var25 = var2.a(var1, var3, var24.c());
            if (bfk.a) {
               var25 = bml.c(var25);
            }

            float var20 = (float)(var25 >> 16 & 255) / 255.0F;
            float var21 = (float)(var25 >> 8 & 255) / 255.0F;
            float var22 = (float)(var25 & 255) / 255.0F;
            var7.a(var20, var21, var22, 4);
            var7.a(var20, var21, var22, 3);
            var7.a(var20, var21, var22, 2);
            var7.a(var20, var21, var22, 1);
         }
      }

   }

   public boolean a(adq var1, boq var2, alz var3, cj var4, bfd var5, boolean var6) {
      boolean var7 = ave.x() && var3.c().r() == 0 && var2.b();

      try {
         afh var8 = var3.c();
         return var7 ? this.a(var1, var2, var8, var4, var5, var6) : this.b(var1, var2, var8, var4, var5, var6);
      } catch (Throwable var11) {
         .b var9 = .b.a(var11, "Tesselating block model");
         .c var10 = var9.a("Block model being tesselated");
         .c.a(var10, var4, var3);
         var10.a((String)"Using AO", (Object)var7);
         throw new e(var9);
      }
   }

   public boolean a(adq var1, boq var2, alz var3, cj var4, bfd var5) {
      afh var6 = var3.c();
      var6.a(var1, var4);
      return this.a(var1, var2, var3, var4, var5, true);
   }

   public static enum d {
      private static final bgf.d[] n = new bgf.d[]{a, b, c, d, e, f, g, h, i, j, k, l};
      f(cq.f, false),
      c(cq.c, false),
      k(cq.e, true),
      e(cq.e, false),
      a(cq.a, false),
      b(cq.b, false),
      l(cq.f, true);

      protected final int m;
      h(cq.b, true),
      i(cq.c, true),
      d(cq.d, false),
      j(cq.d, true),
      g(cq.a, true);

      private d(cq var3, boolean var4) {
         this.m = var3.a() + (var4 ? cq.values().length : 0);
      }
   }

   public static enum a {
      protected final bgf.d[] l;
      d(new cq[]{cq.e, cq.f, cq.a, cq.b}, 0.8F, true, new bgf.d[]{bgf.d.b, bgf.d.k, bgf.d.h, bgf.d.k, bgf.d.h, bgf.d.e, bgf.d.b, bgf.d.e}, new bgf.d[]{bgf.d.a, bgf.d.k, bgf.d.g, bgf.d.k, bgf.d.g, bgf.d.e, bgf.d.a, bgf.d.e}, new bgf.d[]{bgf.d.a, bgf.d.l, bgf.d.g, bgf.d.l, bgf.d.g, bgf.d.f, bgf.d.a, bgf.d.f}, new bgf.d[]{bgf.d.b, bgf.d.l, bgf.d.h, bgf.d.l, bgf.d.h, bgf.d.f, bgf.d.b, bgf.d.f});

      private static final bgf.a[] o = new bgf.a[]{a, b, c, d, e, f};
      c(new cq[]{cq.b, cq.a, cq.f, cq.e}, 0.8F, true, new bgf.d[]{bgf.d.b, bgf.d.k, bgf.d.b, bgf.d.e, bgf.d.h, bgf.d.e, bgf.d.h, bgf.d.k}, new bgf.d[]{bgf.d.b, bgf.d.l, bgf.d.b, bgf.d.f, bgf.d.h, bgf.d.f, bgf.d.h, bgf.d.l}, new bgf.d[]{bgf.d.a, bgf.d.l, bgf.d.a, bgf.d.f, bgf.d.g, bgf.d.f, bgf.d.g, bgf.d.l}, new bgf.d[]{bgf.d.a, bgf.d.k, bgf.d.a, bgf.d.e, bgf.d.g, bgf.d.e, bgf.d.g, bgf.d.k}),
      f(new cq[]{cq.a, cq.b, cq.c, cq.d}, 0.6F, true, new bgf.d[]{bgf.d.g, bgf.d.d, bgf.d.g, bgf.d.j, bgf.d.a, bgf.d.j, bgf.d.a, bgf.d.d}, new bgf.d[]{bgf.d.g, bgf.d.c, bgf.d.g, bgf.d.i, bgf.d.a, bgf.d.i, bgf.d.a, bgf.d.c}, new bgf.d[]{bgf.d.h, bgf.d.c, bgf.d.h, bgf.d.i, bgf.d.b, bgf.d.i, bgf.d.b, bgf.d.c}, new bgf.d[]{bgf.d.h, bgf.d.d, bgf.d.h, bgf.d.j, bgf.d.b, bgf.d.j, bgf.d.b, bgf.d.d});

      protected final cq[] g;
      private static final bgf.a[] n = new bgf.a[6];
      protected final bgf.d[] m;
      protected final bgf.d[] k;
      protected final float h;
      protected final boolean i;
      protected final bgf.d[] j;
      e(new cq[]{cq.b, cq.a, cq.c, cq.d}, 0.6F, true, new bgf.d[]{bgf.d.b, bgf.d.d, bgf.d.b, bgf.d.j, bgf.d.h, bgf.d.j, bgf.d.h, bgf.d.d}, new bgf.d[]{bgf.d.b, bgf.d.c, bgf.d.b, bgf.d.i, bgf.d.h, bgf.d.i, bgf.d.h, bgf.d.c}, new bgf.d[]{bgf.d.a, bgf.d.c, bgf.d.a, bgf.d.i, bgf.d.g, bgf.d.i, bgf.d.g, bgf.d.c}, new bgf.d[]{bgf.d.a, bgf.d.d, bgf.d.a, bgf.d.j, bgf.d.g, bgf.d.j, bgf.d.g, bgf.d.d}),
      b(new cq[]{cq.f, cq.e, cq.c, cq.d}, 1.0F, false, new bgf.d[0], new bgf.d[0], new bgf.d[0], new bgf.d[0]),
      a(new cq[]{cq.e, cq.f, cq.c, cq.d}, 0.5F, false, new bgf.d[0], new bgf.d[0], new bgf.d[0], new bgf.d[0]);

      private a(cq[] var3, float var4, boolean var5, bgf.d[] var6, bgf.d[] var7, bgf.d[] var8, bgf.d[] var9) {
         this.g = var3;
         this.h = var4;
         this.i = var5;
         this.j = var6;
         this.k = var7;
         this.l = var8;
         this.m = var9;
      }

      public static bgf.a a(cq var0) {
         return n[var0.a()];
      }

      static {
         n[cq.a.a()] = a;
         n[cq.b.a()] = b;
         n[cq.c.a()] = c;
         n[cq.d.a()] = d;
         n[cq.e.a()] = e;
         n[cq.f.a()] = f;
      }
   }

   static enum c {
      c(3, 0, 1, 2);

      private final int h;
      private static final bgf.c[] k = new bgf.c[6];
      b(2, 3, 0, 1);

      private final int j;
      private final int g;
      f(1, 2, 3, 0);

      private static final bgf.c[] l = new bgf.c[]{a, b, c, d, e, f};
      d(0, 1, 2, 3),
      e(3, 0, 1, 2),
      a(0, 1, 2, 3);

      private final int i;

      static int c(bgf.c var0) {
         return var0.i;
      }

      static int b(bgf.c var0) {
         return var0.h;
      }

      static {
         k[cq.a.a()] = a;
         k[cq.b.a()] = b;
         k[cq.c.a()] = c;
         k[cq.d.a()] = d;
         k[cq.e.a()] = e;
         k[cq.f.a()] = f;
      }

      private c(int var3, int var4, int var5, int var6) {
         this.g = var3;
         this.h = var4;
         this.i = var5;
         this.j = var6;
      }

      static int d(bgf.c var0) {
         return var0.j;
      }

      static int a(bgf.c var0) {
         return var0.g;
      }

      public static bgf.c a(cq var0) {
         return k[var0.a()];
      }
   }

   class b {
      private final int[] c;
      private final float[] b;
      final bgf a;

      public b(bgf var1) {
         this.a = var1;
         this.b = new float[4];
         this.c = new int[4];
      }

      static float[] b(bgf.b var0) {
         return var0.b;
      }

      static int[] a(bgf.b var0) {
         return var0.c;
      }

      private int a(int var1, int var2, int var3, int var4, float var5, float var6, float var7, float var8) {
         int var9 = (int)((float)(var1 >> 16 & 255) * var5 + (float)(var2 >> 16 & 255) * var6 + (float)(var3 >> 16 & 255) * var7 + (float)(var4 >> 16 & 255) * var8) & 255;
         int var10 = (int)((float)(var1 & 255) * var5 + (float)(var2 & 255) * var6 + (float)(var3 & 255) * var7 + (float)(var4 & 255) * var8) & 255;
         return var9 << 16 | var10;
      }

      private int a(int var1, int var2, int var3, int var4) {
         if (var1 == 0) {
            var1 = var4;
         }

         if (var2 == 0) {
            var2 = var4;
         }

         if (var3 == 0) {
            var3 = var4;
         }

         return var1 + var2 + var3 + var4 >> 2 & 16711935;
      }

      public void a(adq var1, afh var2, cj var3, cq var4, float[] var5, BitSet var6) {
         cj var7 = var6.get(0) ? var3.a(var4) : var3;
         bgf.a var8 = bgf.a.a(var4);
         cj var9 = var7.a(var8.g[0]);
         cj var10 = var7.a(var8.g[1]);
         cj var11 = var7.a(var8.g[2]);
         cj var12 = var7.a(var8.g[3]);
         int var13 = var2.c(var1, var9);
         int var14 = var2.c(var1, var10);
         int var15 = var2.c(var1, var11);
         int var16 = var2.c(var1, var12);
         float var17 = var1.p(var9).c().h();
         float var18 = var1.p(var10).c().h();
         float var19 = var1.p(var11).c().h();
         float var20 = var1.p(var12).c().h();
         boolean var21 = var1.p(var9.a(var4)).c().q();
         boolean var22 = var1.p(var10.a(var4)).c().q();
         boolean var23 = var1.p(var11.a(var4)).c().q();
         boolean var24 = var1.p(var12.a(var4)).c().q();
         float var25;
         int var29;
         cj var33;
         if (!var23 && !var21) {
            var25 = var17;
            var29 = var13;
         } else {
            var33 = var9.a(var8.g[2]);
            var25 = var1.p(var33).c().h();
            var29 = var2.c(var1, var33);
         }

         float var26;
         int var30;
         if (!var24 && !var21) {
            var26 = var17;
            var30 = var13;
         } else {
            var33 = var9.a(var8.g[3]);
            var26 = var1.p(var33).c().h();
            var30 = var2.c(var1, var33);
         }

         float var27;
         int var31;
         if (!var23 && !var22) {
            var27 = var18;
            var31 = var14;
         } else {
            var33 = var10.a(var8.g[2]);
            var27 = var1.p(var33).c().h();
            var31 = var2.c(var1, var33);
         }

         float var28;
         int var32;
         if (!var24 && !var22) {
            var28 = var18;
            var32 = var14;
         } else {
            var33 = var10.a(var8.g[3]);
            var28 = var1.p(var33).c().h();
            var32 = var2.c(var1, var33);
         }

         int var60 = var2.c(var1, var3);
         if (var6.get(0) || !var1.p(var3.a(var4)).c().c()) {
            var60 = var2.c(var1, var3.a(var4));
         }

         float var34 = var6.get(0) ? var1.p(var7).c().h() : var1.p(var3).c().h();
         bgf.c var35 = bgf.c.a(var4);
         float var36;
         float var37;
         float var38;
         float var39;
         if (var6.get(1) && var8.i) {
            var36 = (var20 + var17 + var26 + var34) * 0.25F;
            var37 = (var19 + var17 + var25 + var34) * 0.25F;
            var38 = (var19 + var18 + var27 + var34) * 0.25F;
            var39 = (var20 + var18 + var28 + var34) * 0.25F;
            float var40 = var5[var8.j[0].m] * var5[var8.j[1].m];
            float var41 = var5[var8.j[2].m] * var5[var8.j[3].m];
            float var42 = var5[var8.j[4].m] * var5[var8.j[5].m];
            float var43 = var5[var8.j[6].m] * var5[var8.j[7].m];
            float var44 = var5[var8.k[0].m] * var5[var8.k[1].m];
            float var45 = var5[var8.k[2].m] * var5[var8.k[3].m];
            float var46 = var5[var8.k[4].m] * var5[var8.k[5].m];
            float var47 = var5[var8.k[6].m] * var5[var8.k[7].m];
            float var48 = var5[var8.l[0].m] * var5[var8.l[1].m];
            float var49 = var5[var8.l[2].m] * var5[var8.l[3].m];
            float var50 = var5[var8.l[4].m] * var5[var8.l[5].m];
            float var51 = var5[var8.l[6].m] * var5[var8.l[7].m];
            float var52 = var5[var8.m[0].m] * var5[var8.m[1].m];
            float var53 = var5[var8.m[2].m] * var5[var8.m[3].m];
            float var54 = var5[var8.m[4].m] * var5[var8.m[5].m];
            float var55 = var5[var8.m[6].m] * var5[var8.m[7].m];
            this.b[bgf.c.a(var35)] = var36 * var40 + var37 * var41 + var38 * var42 + var39 * var43;
            this.b[bgf.c.b(var35)] = var36 * var44 + var37 * var45 + var38 * var46 + var39 * var47;
            this.b[bgf.c.c(var35)] = var36 * var48 + var37 * var49 + var38 * var50 + var39 * var51;
            this.b[bgf.c.d(var35)] = var36 * var52 + var37 * var53 + var38 * var54 + var39 * var55;
            int var56 = this.a(var16, var13, var30, var60);
            int var57 = this.a(var15, var13, var29, var60);
            int var58 = this.a(var15, var14, var31, var60);
            int var59 = this.a(var16, var14, var32, var60);
            this.c[bgf.c.a(var35)] = this.a(var56, var57, var58, var59, var40, var41, var42, var43);
            this.c[bgf.c.b(var35)] = this.a(var56, var57, var58, var59, var44, var45, var46, var47);
            this.c[bgf.c.c(var35)] = this.a(var56, var57, var58, var59, var48, var49, var50, var51);
            this.c[bgf.c.d(var35)] = this.a(var56, var57, var58, var59, var52, var53, var54, var55);
         } else {
            var36 = (var20 + var17 + var26 + var34) * 0.25F;
            var37 = (var19 + var17 + var25 + var34) * 0.25F;
            var38 = (var19 + var18 + var27 + var34) * 0.25F;
            var39 = (var20 + var18 + var28 + var34) * 0.25F;
            this.c[bgf.c.a(var35)] = this.a(var16, var13, var30, var60);
            this.c[bgf.c.b(var35)] = this.a(var15, var13, var29, var60);
            this.c[bgf.c.c(var35)] = this.a(var15, var14, var31, var60);
            this.c[bgf.c.d(var35)] = this.a(var16, var14, var32, var60);
            this.b[bgf.c.a(var35)] = var36;
            this.b[bgf.c.b(var35)] = var37;
            this.b[bgf.c.c(var35)] = var38;
            this.b[bgf.c.d(var35)] = var39;
         }

      }
   }
}
