package net.optifine;

import java.util.BitSet;
import net.minecraft.src.Config;
import net.optifine.shaders.Shaders;

public class SmartAnimations {
   private static boolean active;
   private static BitSet texturesRendered = new BitSet();
   private static BitSet spritesRendered = new BitSet();

   public static void resetTexturesRendered() {
      texturesRendered.clear();
   }

   public static boolean isActive() {
      return active && !Shaders.isShadowPass;
   }

   public static void spriteRendered(int var0) {
      spritesRendered.set(var0);
   }

   public static void update() {
      active = Config.getGameSettings().ofSmartAnimations;
   }

   public static boolean isTextureRendered(int var0) {
      return var0 < 0 ? false : texturesRendered.get(var0);
   }

   public static void resetSpritesRendered() {
      spritesRendered.clear();
   }

   public static boolean isSpriteRendered(int var0) {
      return spritesRendered.get(var0);
   }

   public static void spritesRendered(BitSet var0) {
      if (var0 != null) {
         spritesRendered.or(var0);
      }

   }

   public static void textureRendered(int var0) {
      if (var0 >= 0) {
         texturesRendered.set(var0);
      }

   }
}
