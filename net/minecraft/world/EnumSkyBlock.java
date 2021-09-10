package net.minecraft.world;

public enum EnumSkyBlock {
   BLOCK(0),
   SKY(15);

   private static final EnumSkyBlock[] ENUM$VALUES = new EnumSkyBlock[]{SKY, BLOCK};
   public final int defaultLightValue;

   private EnumSkyBlock(int var3) {
      this.defaultLightValue = var3;
   }
}
