package net.minecraft.world.border;

public enum EnumBorderStatus {
   private final int id;
   GROWING(4259712),
   SHRINKING(16724016),
   STATIONARY(2138367);

   private static final EnumBorderStatus[] ENUM$VALUES = new EnumBorderStatus[]{GROWING, SHRINKING, STATIONARY};

   private EnumBorderStatus(int var3) {
      this.id = var3;
   }

   public int getID() {
      return this.id;
   }
}
