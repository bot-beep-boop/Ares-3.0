import java.util.Random;

public class tc {
   private static aui a = new aui(0.0D, 0.0D, 0.0D);

   public static aui a(py var0, int var1, int var2) {
      return c(var0, var1, var2, (aui)null);
   }

   public static aui b(py var0, int var1, int var2, aui var3) {
      a = (new aui(var0.s, var0.t, var0.u)).d(var3);
      return c(var0, var1, var2, a);
   }

   public static aui a(py var0, int var1, int var2, aui var3) {
      a = var3.a(var0.s, var0.t, var0.u);
      return c(var0, var1, var2, a);
   }

   private static aui c(py var0, int var1, int var2, aui var3) {
      Random var4 = var0.bc();
      boolean var5 = false;
      int var6 = 0;
      int var7 = 0;
      int var8 = 0;
      float var9 = -99999.0F;
      boolean var10;
      if (var0.ck()) {
         double var11 = var0.ch().c((double)ns.c(var0.s), (double)ns.c(var0.t), (double)ns.c(var0.u)) + 4.0D;
         double var13 = (double)(var0.ci() + (float)var1);
         var10 = var11 < var13 * var13;
      } else {
         var10 = false;
      }

      for(int var17 = 0; var17 < 10; ++var17) {
         int var12 = var4.nextInt(2 * var1 + 1) - var1;
         int var18 = var4.nextInt(2 * var2 + 1) - var2;
         int var14 = var4.nextInt(2 * var1 + 1) - var1;
         if (var3 == null || !((double)var12 * var3.a + (double)var14 * var3.c < 0.0D)) {
            cj var15;
            if (var0.ck() && var1 > 1) {
               var15 = var0.ch();
               if (var0.s > (double)var15.n()) {
                  var12 -= var4.nextInt(var1 / 2);
               } else {
                  var12 += var4.nextInt(var1 / 2);
               }

               if (var0.u > (double)var15.p()) {
                  var14 -= var4.nextInt(var1 / 2);
               } else {
                  var14 += var4.nextInt(var1 / 2);
               }
            }

            var12 += ns.c(var0.s);
            var18 += ns.c(var0.t);
            var14 += ns.c(var0.u);
            var15 = new cj(var12, var18, var14);
            if (!var10 || var0.e(var15)) {
               float var16 = var0.a(var15);
               if (var16 > var9) {
                  var9 = var16;
                  var6 = var12;
                  var7 = var18;
                  var8 = var14;
                  var5 = true;
               }
            }
         }
      }

      if (var5) {
         return new aui((double)var6, (double)var7, (double)var8);
      } else {
         return null;
      }
   }
}
