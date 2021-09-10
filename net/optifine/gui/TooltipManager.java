package net.optifine.gui;

import java.awt.Rectangle;
import java.util.Arrays;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

public class TooltipManager {
   private long mouseStillTime = 0L;
   private int lastMouseX = 0;
   private GuiScreen guiScreen;
   private TooltipProvider tooltipProvider;
   private int lastMouseY = 0;

   private void drawRectBorder(int var1, int var2, int var3, int var4, int var5) {
      Gui.drawRect(var1, var2 - 1, var3, var2, var5);
      Gui.drawRect(var1, var4, var3, var4 + 1, var5);
      Gui.drawRect(var1 - 1, var2, var1, var4, var5);
      Gui.drawRect(var3, var2, var3 + 1, var4, var5);
   }

   public void drawTooltips(int var1, int var2, List var3) {
      if (Math.abs(var1 - this.lastMouseX) <= 5 && Math.abs(var2 - this.lastMouseY) <= 5) {
         short var4 = 700;
         if (System.currentTimeMillis() >= this.mouseStillTime + (long)var4) {
            GuiButton var5 = GuiScreenOF.getSelectedButton(var1, var2, var3);
            if (var5 != null) {
               Rectangle var6 = this.tooltipProvider.getTooltipBounds(this.guiScreen, var1, var2);
               String[] var7 = this.tooltipProvider.getTooltipLines(var5, var6.width);
               if (var7 != null) {
                  if (var7.length > 8) {
                     var7 = (String[])Arrays.copyOf(var7, 8);
                     var7[var7.length - 1] = var7[var7.length - 1] + " ...";
                  }

                  int var8;
                  if (this.tooltipProvider.isRenderBorder()) {
                     var8 = -528449408;
                     this.drawRectBorder(var6.x, var6.y, var6.x + var6.width, var6.y + var6.height, var8);
                  }

                  Gui.drawRect(var6.x, var6.y, var6.x + var6.width, var6.y + var6.height, -536870912);

                  for(var8 = 0; var8 < var7.length; ++var8) {
                     String var9 = var7[var8];
                     int var10 = 14540253;
                     if (var9.endsWith("!")) {
                        var10 = 16719904;
                     }

                     FontRenderer var11 = Minecraft.getMinecraft().fontRendererObj;
                     var11.drawStringWithShadow(var9, (float)(var6.x + 5), (float)(var6.y + 5 + var8 * 11), var10);
                  }
               }
            }
         }
      } else {
         this.lastMouseX = var1;
         this.lastMouseY = var2;
         this.mouseStillTime = System.currentTimeMillis();
      }

   }

   public TooltipManager(GuiScreen var1, TooltipProvider var2) {
      this.guiScreen = var1;
      this.tooltipProvider = var2;
   }
}
