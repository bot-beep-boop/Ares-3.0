import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;
import org.lwjgl.util.vector.Vector4f;

public class bgo {
   private static final float b = 1.0F / (float)Math.cos(0.7853981852531433D) - 1.0F;
   private static final float a = 1.0F / (float)Math.cos(0.39269909262657166D) - 1.0F;

   public int a(Vector3f var1, cq var2, int var3, bor var4, boolean var5) {
      if (var4 == bor.a) {
         return var3;
      } else {
         this.a(var1, new Vector3f(0.5F, 0.5F, 0.5F), var4.a(), new Vector3f(1.0F, 1.0F, 1.0F));
         return var4.a(var2, var3);
      }
   }

   private float b(cq var1) {
      switch(var1) {
      case a:
         return 0.5F;
      case b:
         return 1.0F;
      case c:
      case d:
         return 0.8F;
      case e:
      case f:
         return 0.6F;
      default:
         return 1.0F;
      }
   }

   public static cq a(int[] var0) {
      Vector3f var1 = new Vector3f(Float.intBitsToFloat(var0[0]), Float.intBitsToFloat(var0[1]), Float.intBitsToFloat(var0[2]));
      Vector3f var2 = new Vector3f(Float.intBitsToFloat(var0[7]), Float.intBitsToFloat(var0[8]), Float.intBitsToFloat(var0[9]));
      Vector3f var3 = new Vector3f(Float.intBitsToFloat(var0[14]), Float.intBitsToFloat(var0[15]), Float.intBitsToFloat(var0[16]));
      Vector3f var4 = new Vector3f();
      Vector3f var5 = new Vector3f();
      Vector3f var6 = new Vector3f();
      Vector3f.sub(var1, var2, var4);
      Vector3f.sub(var3, var2, var5);
      Vector3f.cross(var5, var4, var6);
      float var7 = (float)Math.sqrt((double)(var6.x * var6.x + var6.y * var6.y + var6.z * var6.z));
      var6.x /= var7;
      var6.y /= var7;
      var6.z /= var7;
      cq var8 = null;
      float var9 = 0.0F;
      cq[] var10 = cq.values();
      int var11 = var10.length;

      for(int var12 = 0; var12 < var11; ++var12) {
         cq var13 = var10[var12];
         df var14 = var13.m();
         Vector3f var15 = new Vector3f((float)var14.n(), (float)var14.o(), (float)var14.p());
         float var16 = Vector3f.dot(var6, var15);
         if (var16 >= 0.0F && var16 > var9) {
            var9 = var16;
            var8 = var13;
         }
      }

      if (var8 == null) {
         return cq.b;
      } else {
         return var8;
      }
   }

   public bgg a(Vector3f var1, Vector3f var2, bgi var3, bmi var4, cq var5, bor var6, bgj var7, boolean var8, boolean var9) {
      int[] var10 = this.a(var3, var4, var5, this.a(var1, var2), var6, var7, var8, var9);
      cq var11 = a(var10);
      if (var8) {
         this.a(var10, var11, var3.e, var4);
      }

      if (var7 == null) {
         this.a(var10, var11);
      }

      return new bgg(var10, var3.c, var11);
   }

   private void a(int[] var1, int var2, int var3, Vector3f var4, int var5, bmi var6, bgk var7) {
      int var8 = var2 * 7;
      var1[var8] = Float.floatToRawIntBits(var4.x);
      var1[var8 + 1] = Float.floatToRawIntBits(var4.y);
      var1[var8 + 2] = Float.floatToRawIntBits(var4.z);
      var1[var8 + 3] = var5;
      var1[var8 + 4] = Float.floatToRawIntBits(var6.a((double)var7.a(var3)));
      var1[var8 + 4 + 1] = Float.floatToRawIntBits(var6.b((double)var7.b(var3)));
   }

   private void a(int[] var1, cq var2) {
      int[] var3 = new int[var1.length];
      System.arraycopy(var1, 0, var3, 0, var1.length);
      float[] var4 = new float[cq.values().length];
      var4[bfj.a.f] = 999.0F;
      var4[bfj.a.e] = 999.0F;
      var4[bfj.a.d] = 999.0F;
      var4[bfj.a.c] = -999.0F;
      var4[bfj.a.b] = -999.0F;
      var4[bfj.a.a] = -999.0F;

      int var6;
      float var9;
      for(int var5 = 0; var5 < 4; ++var5) {
         var6 = 7 * var5;
         float var7 = Float.intBitsToFloat(var3[var6]);
         float var8 = Float.intBitsToFloat(var3[var6 + 1]);
         var9 = Float.intBitsToFloat(var3[var6 + 2]);
         if (var7 < var4[bfj.a.f]) {
            var4[bfj.a.f] = var7;
         }

         if (var8 < var4[bfj.a.e]) {
            var4[bfj.a.e] = var8;
         }

         if (var9 < var4[bfj.a.d]) {
            var4[bfj.a.d] = var9;
         }

         if (var7 > var4[bfj.a.c]) {
            var4[bfj.a.c] = var7;
         }

         if (var8 > var4[bfj.a.b]) {
            var4[bfj.a.b] = var8;
         }

         if (var9 > var4[bfj.a.a]) {
            var4[bfj.a.a] = var9;
         }
      }

      bfj var17 = bfj.a(var2);

      for(var6 = 0; var6 < 4; ++var6) {
         int var18 = 7 * var6;
         bfj.b var19 = var17.a(var6);
         var9 = var4[var19.a];
         float var10 = var4[var19.b];
         float var11 = var4[var19.c];
         var1[var18] = Float.floatToRawIntBits(var9);
         var1[var18 + 1] = Float.floatToRawIntBits(var10);
         var1[var18 + 2] = Float.floatToRawIntBits(var11);

         for(int var12 = 0; var12 < 4; ++var12) {
            int var13 = 7 * var12;
            float var14 = Float.intBitsToFloat(var3[var13]);
            float var15 = Float.intBitsToFloat(var3[var13 + 1]);
            float var16 = Float.intBitsToFloat(var3[var13 + 2]);
            if (ns.a(var9, var14) && ns.a(var10, var15) && ns.a(var11, var16)) {
               var1[var18 + 4] = var3[var13 + 4];
               var1[var18 + 4 + 1] = var3[var13 + 4 + 1];
            }
         }
      }

   }

   private int a(cq var1) {
      float var2 = this.b(var1);
      int var3 = ns.a((int)(var2 * 255.0F), 0, 255);
      return -16777216 | var3 << 16 | var3 << 8 | var3;
   }

   private float[] a(Vector3f var1, Vector3f var2) {
      float[] var3 = new float[cq.values().length];
      var3[bfj.a.f] = var1.x / 16.0F;
      var3[bfj.a.e] = var1.y / 16.0F;
      var3[bfj.a.d] = var1.z / 16.0F;
      var3[bfj.a.c] = var2.x / 16.0F;
      var3[bfj.a.b] = var2.y / 16.0F;
      var3[bfj.a.a] = var2.z / 16.0F;
      return var3;
   }

   private void a(int[] var1, int var2, cq var3, bgi var4, float[] var5, bmi var6, bor var7, bgj var8, boolean var9, boolean var10) {
      cq var11 = var7.a(var3);
      int var12 = var10 ? this.a(var11) : -1;
      bfj.b var13 = bfj.a(var3).a(var2);
      Vector3f var14 = new Vector3f(var5[var13.a], var5[var13.b], var5[var13.c]);
      this.a(var14, var8);
      int var15 = this.a(var14, var3, var2, var7, var9);
      this.a(var1, var15, var2, var14, var12, var6, var4.e);
   }

   private void a(Vector3f var1, bgj var2) {
      if (var2 != null) {
         Matrix4f var3 = this.a();
         Vector3f var4 = new Vector3f(0.0F, 0.0F, 0.0F);
         switch(var2.b) {
         case a:
            Matrix4f.rotate(var2.c * 0.017453292F, new Vector3f(1.0F, 0.0F, 0.0F), var3, var3);
            var4.set(0.0F, 1.0F, 1.0F);
            break;
         case b:
            Matrix4f.rotate(var2.c * 0.017453292F, new Vector3f(0.0F, 1.0F, 0.0F), var3, var3);
            var4.set(1.0F, 0.0F, 1.0F);
            break;
         case c:
            Matrix4f.rotate(var2.c * 0.017453292F, new Vector3f(0.0F, 0.0F, 1.0F), var3, var3);
            var4.set(1.0F, 1.0F, 0.0F);
         }

         if (var2.d) {
            if (Math.abs(var2.c) == 22.5F) {
               var4.scale(a);
            } else {
               var4.scale(b);
            }

            Vector3f.add(var4, new Vector3f(1.0F, 1.0F, 1.0F), var4);
         } else {
            var4.set(1.0F, 1.0F, 1.0F);
         }

         this.a(var1, new Vector3f(var2.a), var3, var4);
      }
   }

   private void a(Vector3f var1, Vector3f var2, Matrix4f var3, Vector3f var4) {
      Vector4f var5 = new Vector4f(var1.x - var2.x, var1.y - var2.y, var1.z - var2.z, 1.0F);
      Matrix4f.transform(var3, var5, var5);
      var5.x *= var4.x;
      var5.y *= var4.y;
      var5.z *= var4.z;
      var1.set(var5.x + var2.x, var5.y + var2.y, var5.z + var2.z);
   }

   public void a(int[] var1, cq var2, bgk var3, bmi var4) {
      for(int var5 = 0; var5 < 4; ++var5) {
         this.a(var5, var1, var2, var3, var4);
      }

   }

   private void a(int var1, int[] var2, cq var3, bgk var4, bmi var5) {
      int var6 = 7 * var1;
      float var7 = Float.intBitsToFloat(var2[var6]);
      float var8 = Float.intBitsToFloat(var2[var6 + 1]);
      float var9 = Float.intBitsToFloat(var2[var6 + 2]);
      if (var7 < -0.1F || var7 >= 1.1F) {
         var7 -= (float)ns.d(var7);
      }

      if (var8 < -0.1F || var8 >= 1.1F) {
         var8 -= (float)ns.d(var8);
      }

      if (var9 < -0.1F || var9 >= 1.1F) {
         var9 -= (float)ns.d(var9);
      }

      float var10 = 0.0F;
      float var11 = 0.0F;
      switch(var3) {
      case a:
         var10 = var7 * 16.0F;
         var11 = (1.0F - var9) * 16.0F;
         break;
      case b:
         var10 = var7 * 16.0F;
         var11 = var9 * 16.0F;
         break;
      case c:
         var10 = (1.0F - var7) * 16.0F;
         var11 = (1.0F - var8) * 16.0F;
         break;
      case d:
         var10 = var7 * 16.0F;
         var11 = (1.0F - var8) * 16.0F;
         break;
      case e:
         var10 = var9 * 16.0F;
         var11 = (1.0F - var8) * 16.0F;
         break;
      case f:
         var10 = (1.0F - var9) * 16.0F;
         var11 = (1.0F - var8) * 16.0F;
      }

      int var12 = var4.c(var1) * 7;
      var2[var12 + 4] = Float.floatToRawIntBits(var5.a((double)var10));
      var2[var12 + 4 + 1] = Float.floatToRawIntBits(var5.b((double)var11));
   }

   private int[] a(bgi var1, bmi var2, cq var3, float[] var4, bor var5, bgj var6, boolean var7, boolean var8) {
      int[] var9 = new int[28];

      for(int var10 = 0; var10 < 4; ++var10) {
         this.a(var9, var10, var3, var1, var4, var2, var5, var6, var7, var8);
      }

      return var9;
   }

   private Matrix4f a() {
      Matrix4f var1 = new Matrix4f();
      var1.setIdentity();
      return var1;
   }
}
