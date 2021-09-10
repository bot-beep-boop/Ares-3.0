package net.optifine.config;

import net.minecraft.world.World;

public enum Weather {
   RAIN;

   private static final Weather[] ENUM$VALUES = new Weather[]{CLEAR, RAIN, THUNDER};
   THUNDER,
   CLEAR;

   public static Weather getWeather(World var0, float var1) {
      float var2 = var0.getThunderStrength(var1);
      if (var2 > 0.5F) {
         return THUNDER;
      } else {
         float var3 = var0.getRainStrength(var1);
         return var3 > 0.5F ? RAIN : CLEAR;
      }
   }
}
