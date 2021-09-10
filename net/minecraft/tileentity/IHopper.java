package net.minecraft.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

public interface IHopper extends IInventory {
   double getZPos();

   double getXPos();

   double getYPos();

   World getWorld();
}
