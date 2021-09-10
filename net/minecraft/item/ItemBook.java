package net.minecraft.item;

public class ItemBook extends Item {
   public boolean isItemTool(ItemStack var1) {
      return var1.stackSize == 1;
   }

   public int getItemEnchantability() {
      return 1;
   }
}
