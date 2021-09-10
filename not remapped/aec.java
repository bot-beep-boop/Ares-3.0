import com.google.common.collect.Lists;
import java.util.List;
import java.util.Random;

public class aec {
   private adz d;
   private List<ady> e;
   private String f;
   private ase b;
   private ase c;

   public aec(adm var1) {
      this(var1.J(), var1.P().u(), var1.P().B());
   }

   public aec(long var1, adr var3, String var4) {
      this();
      this.f = var4;
      ase[] var5 = ase.a(var1, var3, var4);
      this.b = var5[0];
      this.c = var5[1];
   }

   public ady a(cj var1, ady var2) {
      return this.d.a(var1.n(), var1.p(), var2);
   }

   public ady[] b(ady[] var1, int var2, int var3, int var4, int var5) {
      return this.a(var1, var2, var3, var4, var5, true);
   }

   public ady[] a(ady[] var1, int var2, int var3, int var4, int var5, boolean var6) {
      asc.a();
      if (var1 == null || var1.length < var4 * var5) {
         var1 = new ady[var4 * var5];
      }

      if (var6 && var4 == 16 && var5 == 16 && (var2 & 15) == 0 && (var3 & 15) == 0) {
         ady[] var9 = this.d.c(var2, var3);
         System.arraycopy(var9, 0, var1, 0, var4 * var5);
         return var1;
      } else {
         int[] var7 = this.c.a(var2, var3, var4, var5);

         for(int var8 = 0; var8 < var4 * var5; ++var8) {
            var1[var8] = ady.a(var7[var8], ady.ad);
         }

         return var1;
      }
   }

   protected aec() {
      this.d = new adz(this);
      this.f = "";
      this.e = Lists.newArrayList();
      this.e.add(ady.t);
      this.e.add(ady.q);
      this.e.add(ady.u);
      this.e.add(ady.I);
      this.e.add(ady.H);
      this.e.add(ady.K);
      this.e.add(ady.L);
   }

   public boolean a(int var1, int var2, int var3, List<ady> var4) {
      asc.a();
      int var5 = var1 - var3 >> 2;
      int var6 = var2 - var3 >> 2;
      int var7 = var1 + var3 >> 2;
      int var8 = var2 + var3 >> 2;
      int var9 = var7 - var5 + 1;
      int var10 = var8 - var6 + 1;
      int[] var11 = this.b.a(var5, var6, var9, var10);

      try {
         for(int var12 = 0; var12 < var9 * var10; ++var12) {
            ady var16 = ady.e(var11[var12]);
            if (!var4.contains(var16)) {
               return false;
            }
         }

         return true;
      } catch (Throwable var15) {
         b var13 = b.a(var15, "Invalid Biome id");
         c var14 = var13.a("Layer");
         var14.a((String)"Layer", (Object)this.b.toString());
         var14.a((String)"x", (Object)var1);
         var14.a((String)"z", (Object)var2);
         var14.a((String)"radius", (Object)var3);
         var14.a((String)"allowed", (Object)var4);
         throw new e(var13);
      }
   }

   public float a(float var1, int var2) {
      return var1;
   }

   public List<ady> a() {
      return this.e;
   }

   public void b() {
      this.d.a();
   }

   public ady[] a(ady[] var1, int var2, int var3, int var4, int var5) {
      asc.a();
      if (var1 == null || var1.length < var4 * var5) {
         var1 = new ady[var4 * var5];
      }

      int[] var6 = this.b.a(var2, var3, var4, var5);

      try {
         for(int var7 = 0; var7 < var4 * var5; ++var7) {
            var1[var7] = ady.a(var6[var7], ady.ad);
         }

         return var1;
      } catch (Throwable var10) {
         b var8 = b.a(var10, "Invalid Biome id");
         c var9 = var8.a("RawBiomeBlock");
         var9.a((String)"biomes[] size", (Object)var1.length);
         var9.a((String)"x", (Object)var2);
         var9.a((String)"z", (Object)var3);
         var9.a((String)"w", (Object)var4);
         var9.a((String)"h", (Object)var5);
         throw new e(var8);
      }
   }

   public float[] a(float[] var1, int var2, int var3, int var4, int var5) {
      asc.a();
      if (var1 == null || var1.length < var4 * var5) {
         var1 = new float[var4 * var5];
      }

      int[] var6 = this.c.a(var2, var3, var4, var5);

      for(int var7 = 0; var7 < var4 * var5; ++var7) {
         try {
            float var8 = (float)ady.a(var6[var7], ady.ad).h() / 65536.0F;
            if (var8 > 1.0F) {
               var8 = 1.0F;
            }

            var1[var7] = var8;
         } catch (Throwable var11) {
            b var9 = b.a(var11, "Invalid Biome id");
            c var10 = var9.a("DownfallBlock");
            var10.a((String)"biome id", (Object)var7);
            var10.a((String)"downfalls[] size", (Object)var1.length);
            var10.a((String)"x", (Object)var2);
            var10.a((String)"z", (Object)var3);
            var10.a((String)"w", (Object)var4);
            var10.a((String)"h", (Object)var5);
            throw new e(var9);
         }
      }

      return var1;
   }

   public ady a(cj var1) {
      return this.a(var1, (ady)null);
   }

   public cj a(int var1, int var2, int var3, List<ady> var4, Random var5) {
      asc.a();
      int var6 = var1 - var3 >> 2;
      int var7 = var2 - var3 >> 2;
      int var8 = var1 + var3 >> 2;
      int var9 = var2 + var3 >> 2;
      int var10 = var8 - var6 + 1;
      int var11 = var9 - var7 + 1;
      int[] var12 = this.b.a(var6, var7, var10, var11);
      cj var13 = null;
      int var14 = 0;

      for(int var15 = 0; var15 < var10 * var11; ++var15) {
         int var16 = var6 + var15 % var10 << 2;
         int var17 = var7 + var15 / var10 << 2;
         ady var18 = ady.e(var12[var15]);
         if (var4.contains(var18) && (var13 == null || var5.nextInt(var14 + 1) == 0)) {
            var13 = new cj(var16, 0, var17);
            ++var14;
         }
      }

      return var13;
   }
}
