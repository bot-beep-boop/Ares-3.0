package net.optifine.util;

public class ArrayUtils {
   public static boolean contains(Object[] var0, Object var1) {
      if (var0 == null) {
         return false;
      } else {
         for(int var2 = 0; var2 < var0.length; ++var2) {
            Object var3 = var0[var2];
            if (var3 == var1) {
               return true;
            }
         }

         return false;
      }
   }
}
