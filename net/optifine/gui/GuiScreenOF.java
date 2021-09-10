package net.optifine.gui;

import java.io.IOException;
import java.util.List;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiVideoSettings;

public class GuiScreenOF extends GuiScreen {
   protected void actionPerformedRightClick(GuiButton var1) throws IOException {
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      super.mouseClicked(var1, var2, var3);
      if (var3 == 1) {
         GuiButton var4 = getSelectedButton(var1, var2, this.buttonList);
         if (var4 != null && var4.enabled) {
            var4.playPressSound(this.mc.getSoundHandler());
            this.actionPerformedRightClick(var4);
         }
      }

   }

   public static GuiButton getSelectedButton(int var0, int var1, List<GuiButton> var2) {
      for(int var3 = 0; var3 < var2.size(); ++var3) {
         GuiButton var4 = (GuiButton)var2.get(var3);
         if (var4.visible) {
            int var5 = GuiVideoSettings.getButtonWidth(var4);
            int var6 = GuiVideoSettings.getButtonHeight(var4);
            if (var0 >= var4.xPosition && var1 >= var4.yPosition && var0 < var4.xPosition + var5 && var1 < var4.yPosition + var6) {
               return var4;
            }
         }
      }

      return null;
   }
}
