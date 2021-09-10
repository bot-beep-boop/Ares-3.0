package net.minecraft.enchantment;

import net.minecraft.util.ResourceLocation;

public class EnchantmentKnockback extends Enchantment {
   public int getMinEnchantability(int var1) {
      return 5 + 20 * (var1 - 1);
   }

   public int getMaxLevel() {
      return 2;
   }

   protected EnchantmentKnockback(int var1, ResourceLocation var2, int var3) {
      super(var1, var2, var3, EnumEnchantmentType.WEAPON);
      this.setName("knockback");
   }

   public int getMaxEnchantability(int var1) {
      return super.getMinEnchantability(var1) + 50;
   }
}
