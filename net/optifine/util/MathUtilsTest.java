package net.optifine.util;

import net.minecraft.util.MathHelper;

public class MathUtilsTest {
   private static int[] $SWITCH_TABLE$net$optifine$util$MathUtilsTest$OPER;

   public static void main(String[] var0) throws Exception {
      MathUtilsTest.OPER[] var1 = MathUtilsTest.OPER.values();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         MathUtilsTest.OPER var3 = var1[var2];
         dbg("******** " + var3 + " ***********");
         test(var3, false);
      }

   }

   static int[] $SWITCH_TABLE$net$optifine$util$MathUtilsTest$OPER() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$util$MathUtilsTest$OPER;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[MathUtilsTest.OPER.values().length];

         try {
            var0[MathUtilsTest.OPER.ACOS.ordinal()] = 4;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[MathUtilsTest.OPER.ASIN.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[MathUtilsTest.OPER.COS.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[MathUtilsTest.OPER.SIN.ordinal()] = 1;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$util$MathUtilsTest$OPER = var0;
         return var0;
      }
   }

   public static void dbg(String var0) {
      System.out.println(var0);
   }

   private static void test(MathUtilsTest.OPER var0, boolean var1) {
      MathHelper.fastMath = var1;
      double var2;
      double var4;
      switch($SWITCH_TABLE$net$optifine$util$MathUtilsTest$OPER()[var0.ordinal()]) {
      case 1:
      case 2:
         var2 = (double)(-MathHelper.PI);
         var4 = (double)MathHelper.PI;
         break;
      case 3:
      case 4:
         var2 = -1.0D;
         var4 = 1.0D;
         break;
      default:
         return;
      }

      byte var6 = 10;

      for(int var7 = 0; var7 <= var6; ++var7) {
         double var8 = var2 + (double)var7 * (var4 - var2) / (double)var6;
         float var10;
         float var11;
         switch($SWITCH_TABLE$net$optifine$util$MathUtilsTest$OPER()[var0.ordinal()]) {
         case 1:
            var10 = (float)Math.sin(var8);
            var11 = MathHelper.sin((float)var8);
            break;
         case 2:
            var10 = (float)Math.cos(var8);
            var11 = MathHelper.cos((float)var8);
            break;
         case 3:
            var10 = (float)Math.asin(var8);
            var11 = MathUtils.asin((float)var8);
            break;
         case 4:
            var10 = (float)Math.acos(var8);
            var11 = MathUtils.acos((float)var8);
            break;
         default:
            return;
         }

         dbg(String.format("%.2f, Math: %f, Helper: %f, diff: %f", var8, var10, var11, Math.abs(var10 - var11)));
      }

   }

   private static enum OPER {
      ASIN,
      ACOS,
      COS;

      private static final MathUtilsTest.OPER[] ENUM$VALUES = new MathUtilsTest.OPER[]{SIN, COS, ASIN, ACOS};
      SIN;
   }
}
