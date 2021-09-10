package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class ModuleArrowcount extends MoveableModule {
   public ModuleArrowcount(int var1, int var2) {
      super(var1, var2, true);
   }

   private int getRemainingArrows() {
      int var1 = 0;
      ItemStack[] var5;
      int var4 = (var5 = Minecraft.getMinecraft().thePlayer.inventory.mainInventory).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         ItemStack var2 = var5[var3];
         if (var2 != null && var2.getItem().equals(Items.arrow)) {
            var1 += var2.stackSize;
         }
      }

      return var1;
   }

   public void render() {
      if (this.getRemainingArrows() < 1) {
         minecraft.fontRendererObj.drawStringWithShadow(String.valueOf(this.getRemainingArrows()), (float)(this.getX() + 8), (float)(this.getY() + 15), Color.WHITE.getRGB());
      } else {
         minecraft.fontRendererObj.drawStringWithShadow(String.valueOf(this.getRemainingArrows()), (float)(this.getX() + 8), (float)(this.getY() + 15), Color.WHITE.getRGB());
      }

      Minecraft.getMinecraft().getRenderItem().renderItemIntoGUI(new ItemStack(Items.arrow), this.getX() + 3, this.getY() - 1);
   }

   public int getHeight() {
      return 30;
   }

   public String getName() {
      return "ArrowCount";
   }

   public int getWidth() {
      return 25;
   }
}
