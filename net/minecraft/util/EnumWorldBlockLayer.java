package net.minecraft.util;

public enum EnumWorldBlockLayer {
   CUTOUT("Cutout");

   private final String layerName;
   CUTOUT_MIPPED("Mipped Cutout");

   private static final EnumWorldBlockLayer[] ENUM$VALUES = new EnumWorldBlockLayer[]{SOLID, CUTOUT_MIPPED, CUTOUT, TRANSLUCENT};
   SOLID("Solid"),
   TRANSLUCENT("Translucent");

   public String toString() {
      return this.layerName;
   }

   private EnumWorldBlockLayer(String var3) {
      this.layerName = var3;
   }
}
