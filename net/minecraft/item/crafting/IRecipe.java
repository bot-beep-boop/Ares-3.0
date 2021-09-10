package net.minecraft.item.crafting;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public interface IRecipe {
   ItemStack getCraftingResult(InventoryCrafting var1);

   int getRecipeSize();

   boolean matches(InventoryCrafting var1, World var2);

   ItemStack[] getRemainingItems(InventoryCrafting var1);

   ItemStack getRecipeOutput();
}
