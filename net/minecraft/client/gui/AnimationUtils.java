package net.minecraft.client.gui;

class AnimationUtils {
   public static double animate(double var0, double var2, double var4) {
      boolean var6 = var0 > var2;
      if (var4 < 0.0D) {
         var4 = 0.0D;
      } else if (var4 > 1.0D) {
         var4 = 1.0D;
      }

      double var7 = Math.max(var0, var2) - Math.min(var0, var2);
      double var9 = var7 * var4;
      if (var9 < 0.1D) {
         var9 = 0.1D;
      }

      if (var6) {
         var2 += var9;
      } else {
         var2 -= var9;
      }

      return var2;
   }
}
