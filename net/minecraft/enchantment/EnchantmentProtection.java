package net.minecraft.enchantment;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class EnchantmentProtection extends Enchantment {
   private static final int[] baseEnchantability = new int[]{1, 10, 5, 5, 3};
   private static final String[] protectionName = new String[]{"all", "fire", "fall", "explosion", "projectile"};
   public final int protectionType;
   private static final int[] thresholdEnchantability = new int[]{20, 12, 10, 12, 15};
   private static final int[] levelEnchantability = new int[]{11, 8, 6, 8, 6};

   public int getMaxEnchantability(int var1) {
      return this.getMinEnchantability(var1) + thresholdEnchantability[this.protectionType];
   }

   public int getMinEnchantability(int var1) {
      return baseEnchantability[this.protectionType] + (var1 - 1) * levelEnchantability[this.protectionType];
   }

   public static int getFireTimeForEntity(Entity var0, int var1) {
      int var2 = EnchantmentHelper.getMaxEnchantmentLevel(Enchantment.fireProtection.effectId, var0.getInventory());
      if (var2 > 0) {
         var1 -= MathHelper.floor_float((float)var1 * (float)var2 * 0.15F);
      }

      return var1;
   }

   public String getName() {
      return "enchantment.protect." + protectionName[this.protectionType];
   }

   public int calcModifierDamage(int var1, DamageSource var2) {
      if (var2.canHarmInCreative()) {
         return 0;
      } else {
         float var3 = (float)(6 + var1 * var1) / 3.0F;
         if (this.protectionType == 0) {
            return MathHelper.floor_float(var3 * 0.75F);
         } else if (this.protectionType == 1 && var2.isFireDamage()) {
            return MathHelper.floor_float(var3 * 1.25F);
         } else if (this.protectionType == 2 && var2 == DamageSource.fall) {
            return MathHelper.floor_float(var3 * 2.5F);
         } else if (this.protectionType == 3 && var2.isExplosion()) {
            return MathHelper.floor_float(var3 * 1.5F);
         } else {
            return this.protectionType == 4 && var2.isProjectile() ? MathHelper.floor_float(var3 * 1.5F) : 0;
         }
      }
   }

   public int getMaxLevel() {
      return 4;
   }

   public EnchantmentProtection(int var1, ResourceLocation var2, int var3, int var4) {
      super(var1, var2, var3, EnumEnchantmentType.ARMOR);
      this.protectionType = var4;
      if (var4 == 2) {
         this.type = EnumEnchantmentType.ARMOR_FEET;
      }

   }

   public static double func_92092_a(Entity var0, double var1) {
      int var3 = EnchantmentHelper.getMaxEnchantmentLevel(Enchantment.blastProtection.effectId, var0.getInventory());
      if (var3 > 0) {
         var1 -= (double)MathHelper.floor_double(var1 * (double)((float)var3 * 0.15F));
      }

      return var1;
   }

   public boolean canApplyTogether(Enchantment var1) {
      if (var1 instanceof EnchantmentProtection) {
         EnchantmentProtection var2 = (EnchantmentProtection)var1;
         if (var2.protectionType == this.protectionType) {
            return false;
         } else {
            return this.protectionType == 2 || var2.protectionType == 2;
         }
      } else {
         return super.canApplyTogether(var1);
      }
   }
}
