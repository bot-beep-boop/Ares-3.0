package net.minecraft.item;

import net.minecraft.util.EnumChatFormatting;

public enum EnumRarity {
   public final EnumChatFormatting rarityColor;
   public final String rarityName;
   EPIC(EnumChatFormatting.LIGHT_PURPLE, "Epic"),
   RARE(EnumChatFormatting.AQUA, "Rare"),
   UNCOMMON(EnumChatFormatting.YELLOW, "Uncommon");

   private static final EnumRarity[] ENUM$VALUES = new EnumRarity[]{COMMON, UNCOMMON, RARE, EPIC};
   COMMON(EnumChatFormatting.WHITE, "Common");

   private EnumRarity(EnumChatFormatting var3, String var4) {
      this.rarityColor = var3;
      this.rarityName = var4;
   }
}
