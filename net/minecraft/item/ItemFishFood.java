package net.minecraft.item;

import com.google.common.collect.Maps;
import java.util.List;
import java.util.Map;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemFishFood extends ItemFood {
   private final boolean cooked;

   public void getSubItems(Item var1, CreativeTabs var2, List<ItemStack> var3) {
      ItemFishFood.FishType[] var7;
      int var6 = (var7 = ItemFishFood.FishType.values()).length;

      for(int var5 = 0; var5 < var6; ++var5) {
         ItemFishFood.FishType var4 = var7[var5];
         if (!this.cooked || var4.canCook()) {
            var3.add(new ItemStack(this, 1, var4.getMetadata()));
         }
      }

   }

   public float getSaturationModifier(ItemStack var1) {
      ItemFishFood.FishType var2 = ItemFishFood.FishType.byItemStack(var1);
      return this.cooked && var2.canCook() ? var2.getCookedSaturationModifier() : var2.getUncookedSaturationModifier();
   }

   public int getHealAmount(ItemStack var1) {
      ItemFishFood.FishType var2 = ItemFishFood.FishType.byItemStack(var1);
      return this.cooked && var2.canCook() ? var2.getCookedHealAmount() : var2.getUncookedHealAmount();
   }

   public String getPotionEffect(ItemStack var1) {
      return ItemFishFood.FishType.byItemStack(var1) == ItemFishFood.FishType.PUFFERFISH ? "+0-1+2+3+13&4-4" : null;
   }

   public String getUnlocalizedName(ItemStack var1) {
      ItemFishFood.FishType var2 = ItemFishFood.FishType.byItemStack(var1);
      return this.getUnlocalizedName() + "." + var2.getUnlocalizedName() + "." + (this.cooked && var2.canCook() ? "cooked" : "raw");
   }

   public ItemFishFood(boolean var1) {
      super(0, 0.0F, false);
      this.cooked = var1;
   }

   protected void onFoodEaten(ItemStack var1, World var2, EntityPlayer var3) {
      ItemFishFood.FishType var4 = ItemFishFood.FishType.byItemStack(var1);
      if (var4 == ItemFishFood.FishType.PUFFERFISH) {
         var3.addPotionEffect(new PotionEffect(Potion.poison.id, 1200, 3));
         var3.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 2));
         var3.addPotionEffect(new PotionEffect(Potion.confusion.id, 300, 1));
      }

      super.onFoodEaten(var1, var2, var3);
   }

   public static enum FishType {
      private final String unlocalizedName;
      private final int meta;
      private static final ItemFishFood.FishType[] ENUM$VALUES = new ItemFishFood.FishType[]{COD, SALMON, CLOWNFISH, PUFFERFISH};
      private final int uncookedHealAmount;
      private final float uncookedSaturationModifier;
      private boolean cookable = false;
      private final int cookedHealAmount;
      PUFFERFISH(3, "pufferfish", 1, 0.1F),
      SALMON(1, "salmon", 2, 0.1F, 6, 0.8F),
      COD(0, "cod", 2, 0.1F, 5, 0.6F);

      private static final Map<Integer, ItemFishFood.FishType> META_LOOKUP = Maps.newHashMap();
      private final float cookedSaturationModifier;
      CLOWNFISH(2, "clownfish", 1, 0.1F);

      public boolean canCook() {
         return this.cookable;
      }

      static {
         ItemFishFood.FishType[] var3;
         int var2 = (var3 = values()).length;

         for(int var1 = 0; var1 < var2; ++var1) {
            ItemFishFood.FishType var0 = var3[var1];
            META_LOOKUP.put(var0.getMetadata(), var0);
         }

      }

      public static ItemFishFood.FishType byMetadata(int var0) {
         ItemFishFood.FishType var1 = (ItemFishFood.FishType)META_LOOKUP.get(var0);
         return var1 == null ? COD : var1;
      }

      public float getCookedSaturationModifier() {
         return this.cookedSaturationModifier;
      }

      public int getCookedHealAmount() {
         return this.cookedHealAmount;
      }

      public int getUncookedHealAmount() {
         return this.uncookedHealAmount;
      }

      public float getUncookedSaturationModifier() {
         return this.uncookedSaturationModifier;
      }

      public int getMetadata() {
         return this.meta;
      }

      private FishType(int var3, String var4, int var5, float var6) {
         this.meta = var3;
         this.unlocalizedName = var4;
         this.uncookedHealAmount = var5;
         this.uncookedSaturationModifier = var6;
         this.cookedHealAmount = 0;
         this.cookedSaturationModifier = 0.0F;
         this.cookable = false;
      }

      public String getUnlocalizedName() {
         return this.unlocalizedName;
      }

      public static ItemFishFood.FishType byItemStack(ItemStack var0) {
         return var0.getItem() instanceof ItemFishFood ? byMetadata(var0.getMetadata()) : COD;
      }

      private FishType(int var3, String var4, int var5, float var6, int var7, float var8) {
         this.meta = var3;
         this.unlocalizedName = var4;
         this.uncookedHealAmount = var5;
         this.uncookedSaturationModifier = var6;
         this.cookedHealAmount = var7;
         this.cookedSaturationModifier = var8;
         this.cookable = true;
      }
   }
}
