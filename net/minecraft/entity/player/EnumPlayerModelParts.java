package net.minecraft.entity.player;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;

public enum EnumPlayerModelParts {
   LEFT_SLEEVE(2, "left_sleeve"),
   JACKET(1, "jacket"),
   RIGHT_PANTS_LEG(5, "right_pants_leg");

   private final int partId;
   CAPE(0, "cape"),
   ARESCAPE(7, "ares_cape"),
   HAT(6, "hat");

   private final int partMask;
   private final IChatComponent field_179339_k;
   private final String partName;
   RIGHT_SLEEVE(3, "right_sleeve"),
   LEFT_PANTS_LEG(4, "left_pants_leg");

   private static final EnumPlayerModelParts[] ENUM$VALUES = new EnumPlayerModelParts[]{CAPE, JACKET, LEFT_SLEEVE, RIGHT_SLEEVE, LEFT_PANTS_LEG, RIGHT_PANTS_LEG, HAT, ARESCAPE};

   public String getPartName() {
      return this.partName;
   }

   public IChatComponent func_179326_d() {
      return this.field_179339_k;
   }

   public int getPartMask() {
      return this.partMask;
   }

   public int getPartId() {
      return this.partId;
   }

   private EnumPlayerModelParts(int var3, String var4) {
      this.partId = var3;
      this.partMask = 1 << var3;
      this.partName = var4;
      this.field_179339_k = new ChatComponentTranslation("options.modelPart." + var4, new Object[0]);
   }
}
