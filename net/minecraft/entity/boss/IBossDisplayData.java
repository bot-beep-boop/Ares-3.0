package net.minecraft.entity.boss;

import net.minecraft.util.IChatComponent;

public interface IBossDisplayData {
   IChatComponent getDisplayName();

   float getMaxHealth();

   float getHealth();
}
