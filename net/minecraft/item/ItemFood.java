package net.minecraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.world.World;

public class ItemFood extends Item {
   private int potionAmplifier;
   private int potionId;
   private int potionDuration;
   private final boolean isWolfsFavoriteMeat;
   private boolean alwaysEdible;
   private float potionEffectProbability;
   private final float saturationModifier;
   public final int itemUseDuration;
   private final int healAmount;

   public ItemStack onItemUseFinish(ItemStack var1, World var2, EntityPlayer var3) {
      --var1.stackSize;
      var3.getFoodStats().addStats(this, var1);
      var2.playSoundAtEntity(var3, "random.burp", 0.5F, var2.rand.nextFloat() * 0.1F + 0.9F);
      this.onFoodEaten(var1, var2, var3);
      var3.triggerAchievement(StatList.objectUseStats[Item.getIdFromItem(this)]);
      return var1;
   }

   public EnumAction getItemUseAction(ItemStack var1) {
      return EnumAction.EAT;
   }

   public ItemFood setAlwaysEdible() {
      this.alwaysEdible = true;
      return this;
   }

   public int getHealAmount(ItemStack var1) {
      return this.healAmount;
   }

   public ItemFood(int var1, boolean var2) {
      this(var1, 0.6F, var2);
   }

   public ItemFood setPotionEffect(int var1, int var2, int var3, float var4) {
      this.potionId = var1;
      this.potionDuration = var2;
      this.potionAmplifier = var3;
      this.potionEffectProbability = var4;
      return this;
   }

   public ItemFood(int var1, float var2, boolean var3) {
      this.itemUseDuration = 32;
      this.healAmount = var1;
      this.isWolfsFavoriteMeat = var3;
      this.saturationModifier = var2;
      this.setCreativeTab(CreativeTabs.tabFood);
   }

   public float getSaturationModifier(ItemStack var1) {
      return this.saturationModifier;
   }

   protected void onFoodEaten(ItemStack var1, World var2, EntityPlayer var3) {
      if (!var2.isRemote && this.potionId > 0 && var2.rand.nextFloat() < this.potionEffectProbability) {
         var3.addPotionEffect(new PotionEffect(this.potionId, this.potionDuration * 20, this.potionAmplifier));
      }

   }

   public boolean isWolfsFavoriteMeat() {
      return this.isWolfsFavoriteMeat;
   }

   public ItemStack onItemRightClick(ItemStack var1, World var2, EntityPlayer var3) {
      if (var3.canEat(this.alwaysEdible)) {
         var3.setItemInUse(var1, this.getMaxItemUseDuration(var1));
      }

      return var1;
   }

   public int getMaxItemUseDuration(ItemStack var1) {
      return 32;
   }
}
