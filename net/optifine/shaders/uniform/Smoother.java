package net.optifine.shaders.uniform;

import java.util.HashMap;
import java.util.Map;
import net.optifine.util.CounterInt;
import net.optifine.util.SmoothFloat;

public class Smoother {
   private static Map<Integer, SmoothFloat> mapSmoothValues = new HashMap();
   private static CounterInt counterIds = new CounterInt(1);

   public static float getSmoothValue(int var0, float var1, float var2, float var3) {
      synchronized(mapSmoothValues) {
         Integer var5 = var0;
         SmoothFloat var6 = (SmoothFloat)mapSmoothValues.get(var5);
         if (var6 == null) {
            var6 = new SmoothFloat(var1, var2, var3);
            mapSmoothValues.put(var5, var6);
         }

         float var7 = var6.getSmoothValue(var1, var2, var3);
         return var7;
      }
   }

   public static int getNextId() {
      synchronized(counterIds) {
         return counterIds.nextValue();
      }
   }

   public static void resetValues() {
      synchronized(mapSmoothValues) {
         mapSmoothValues.clear();
      }
   }
}
