package net.minecraft.entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryMerchant;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IChatComponent;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;

public class NpcMerchant implements IMerchant {
   private MerchantRecipeList recipeList;
   private InventoryMerchant theMerchantInventory;
   private IChatComponent field_175548_d;
   private EntityPlayer customer;

   public EntityPlayer getCustomer() {
      return this.customer;
   }

   public void setCustomer(EntityPlayer var1) {
   }

   public void useRecipe(MerchantRecipe var1) {
      var1.incrementToolUses();
   }

   public NpcMerchant(EntityPlayer var1, IChatComponent var2) {
      this.customer = var1;
      this.field_175548_d = var2;
      this.theMerchantInventory = new InventoryMerchant(var1, this);
   }

   public void setRecipes(MerchantRecipeList var1) {
      this.recipeList = var1;
   }

   public IChatComponent getDisplayName() {
      return (IChatComponent)(this.field_175548_d != null ? this.field_175548_d : new ChatComponentTranslation("entity.Villager.name", new Object[0]));
   }

   public void verifySellingItem(ItemStack var1) {
   }

   public MerchantRecipeList getRecipes(EntityPlayer var1) {
      return this.recipeList;
   }
}
