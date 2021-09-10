package net.optifine.gui;

import java.awt.Rectangle;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.optifine.shaders.config.EnumShaderOption;
import net.optifine.shaders.gui.GuiButtonDownloadShaders;
import net.optifine.shaders.gui.GuiButtonEnumShaderOption;

public class TooltipProviderEnumShaderOptions implements TooltipProvider {
   public Rectangle getTooltipBounds(GuiScreen var1, int var2, int var3) {
      int var4 = GuiScreen.width - 450;
      int var5 = 35;
      if (var4 < 10) {
         var4 = 10;
      }

      if (var3 <= var5 + 94) {
         var5 += 100;
      }

      int var6 = var4 + 150 + 150;
      int var7 = var5 + 84 + 10;
      return new Rectangle(var4, var5, var6 - var4, var7 - var5);
   }

   public String[] getTooltipLines(GuiButton var1, int var2) {
      if (var1 instanceof GuiButtonDownloadShaders) {
         return TooltipProviderOptions.getTooltipLines("of.options.shaders.DOWNLOAD");
      } else if (!(var1 instanceof GuiButtonEnumShaderOption)) {
         return null;
      } else {
         GuiButtonEnumShaderOption var3 = (GuiButtonEnumShaderOption)var1;
         EnumShaderOption var4 = var3.getEnumShaderOption();
         String[] var5 = this.getTooltipLines(var4);
         return var5;
      }
   }

   private String[] getTooltipLines(EnumShaderOption var1) {
      return TooltipProviderOptions.getTooltipLines(var1.getResourceKey());
   }

   public boolean isRenderBorder() {
      return true;
   }
}
