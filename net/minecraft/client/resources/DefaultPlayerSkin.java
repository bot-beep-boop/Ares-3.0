package net.minecraft.client.resources;

import java.util.UUID;
import net.minecraft.util.ResourceLocation;

public class DefaultPlayerSkin {
   private static final ResourceLocation TEXTURE_ALEX = new ResourceLocation("textures/entity/alex.png");
   private static final ResourceLocation TEXTURE_STEVE = new ResourceLocation("textures/entity/steve.png");

   private static boolean isSlimSkin(UUID var0) {
      return (var0.hashCode() & 1) == 1;
   }

   public static ResourceLocation getDefaultSkinLegacy() {
      return TEXTURE_STEVE;
   }

   public static String getSkinType(UUID var0) {
      return isSlimSkin(var0) ? "slim" : "default";
   }

   public static ResourceLocation getDefaultSkin(UUID var0) {
      return isSlimSkin(var0) ? TEXTURE_ALEX : TEXTURE_STEVE;
   }
}
