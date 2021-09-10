package net.minecraft.enchantment;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;

public class EnchantmentDamage extends Enchantment {
   public final int damageType;
   private static final String[] protectionName = new String[]{"all", "undead", "arthropods"};
   private static final int[] baseEnchantability = new int[]{1, 5, 5};
   private static final int[] thresholdEnchantability = new int[]{20, 20, 20};
   private static final int[] levelEnchantability = new int[]{11, 8, 8};

   public void onEntityDamaged(EntityLivingBase var1, Entity var2, int var3) {
      if (var2 instanceof EntityLivingBase) {
         EntityLivingBase var4 = (EntityLivingBase)var2;
         if (this.damageType == 2 && var4.getCreatureAttribute() == EnumCreatureAttribute.ARTHROPOD) {
            int var5 = 20 + var1.getRNG().nextInt(10 * var3);
            var4.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, var5, 3));
         }
      }

   }

   public EnchantmentDamage(int var1, ResourceLocation var2, int var3, int var4) {
      super(var1, var2, var3, EnumEnchantmentType.WEAPON);
      this.damageType = var4;
   }

   public boolean canApply(ItemStack var1) {
      return var1.getItem() instanceof ItemAxe ? true : super.canApply(var1);
   }

   public boolean canApplyTogether(Enchantment var1) {
      return !(var1 instanceof EnchantmentDamage);
   }

   public int getMaxLevel() {
      return 5;
   }

   public float calcDamageByCreature(int var1, EnumCreatureAttribute var2) {
      if (this.damageType == 0) {
         return (float)var1 * 1.25F;
      } else if (this.damageType == 1 && var2 == EnumCreatureAttribute.UNDEAD) {
         return (float)var1 * 2.5F;
      } else {
         return this.damageType == 2 && var2 == EnumCreatureAttribute.ARTHROPOD ? (float)var1 * 2.5F : 0.0F;
      }
   }

   public int getMaxEnchantability(int var1) {
      return this.getMinEnchantability(var1) + thresholdEnchantability[this.damageType];
   }

   public int getMinEnchantability(int var1) {
      return baseEnchantability[this.damageType] + (var1 - 1) * levelEnchantability[this.damageType];
   }

   public String getName() {
      return "enchantment.damage." + protectionName[this.damageType];
   }
}
