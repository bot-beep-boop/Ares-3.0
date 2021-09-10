package net.optifine.util;

import net.minecraft.util.MathHelper;

public class MathUtils {
   private static final float[] ASIN_TABLE = new float[65536];
   public static final float PI2 = 6.2831855F;
   public static final float PId2 = 1.5707964F;
   public static final float PI = 3.1415927F;

   public static int roundDownToPowerOfTwo(int var0) {
      int var1 = MathHelper.roundUpToPowerOfTwo(var0);
      return var0 == var1 ? var1 : var1 / 2;
   }

   public static float toDeg(float var0) {
      return var0 * 180.0F / MathHelper.PI;
   }

   static {
      int var0;
      for(var0 = 0; var0 < 65536; ++var0) {
         ASIN_TABLE[var0] = (float)Math.asin((double)var0 / 32767.5D - 1.0D);
      }

      for(var0 = -1; var0 < 2; ++var0) {
         ASIN_TABLE[(int)(((double)var0 + 1.0D) * 32767.5D) & '\uffff'] = (float)Math.asin((double)var0);
      }

   }

   public static float toRad(float var0) {
      return var0 / 180.0F * MathHelper.PI;
   }

   public static int getSum(int[] var0) {
      if (var0.length <= 0) {
         return 0;
      } else {
         int var1 = 0;

         for(int var2 = 0; var2 < var0.length; ++var2) {
            int var3 = var0[var2];
            var1 += var3;
         }

         return var1;
      }
   }

   public static float acos(float var0) {
      return 1.5707964F - ASIN_TABLE[(int)((double)(var0 + 1.0F) * 32767.5D) & '\uffff'];
   }

   public static float asin(float var0) {
      return ASIN_TABLE[(int)((double)(var0 + 1.0F) * 32767.5D) & '\uffff'];
   }

   public static boolean equalsDelta(float var0, float var1, float var2) {
      return Math.abs(var0 - var1) <= var2;
   }

   public static int getAverage(int[] var0) {
      if (var0.length <= 0) {
         return 0;
      } else {
         int var1 = getSum(var0);
         int var2 = var1 / var0.length;
         return var2;
      }
   }

   public static float roundToFloat(double var0) {
      return (float)((double)Math.round(var0 * 1.0E8D) / 1.0E8D);
   }
}
