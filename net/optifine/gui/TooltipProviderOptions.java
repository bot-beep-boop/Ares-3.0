package net.optifine.gui;

import java.awt.Rectangle;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.settings.GameSettings;
import net.optifine.Lang;

public class TooltipProviderOptions implements TooltipProvider {
   public static String[] getTooltipLines(String var0) {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < 10; ++var2) {
         String var3 = var0 + ".tooltip." + (var2 + 1);
         String var4 = Lang.get(var3, (String)null);
         if (var4 == null) {
            break;
         }

         var1.add(var4);
      }

      if (var1.size() <= 0) {
         return null;
      } else {
         String[] var5 = (String[])var1.toArray(new String[var1.size()]);
         return var5;
      }
   }

   public boolean isRenderBorder() {
      return false;
   }

   public String[] getTooltipLines(GuiButton var1, int var2) {
      if (!(var1 instanceof IOptionControl)) {
         return null;
      } else {
         IOptionControl var3 = (IOptionControl)var1;
         GameSettings.Options var4 = var3.getOption();
         String[] var5 = getTooltipLines(var4.getEnumString());
         return var5;
      }
   }

   public Rectangle getTooltipBounds(GuiScreen var1, int var2, int var3) {
      int var4 = GuiScreen.width / 2 - 150;
      int var5 = GuiScreen.height / 6 - 7;
      if (var3 <= var5 + 98) {
         var5 += 105;
      }

      int var6 = var4 + 150 + 150;
      int var7 = var5 + 84 + 10;
      return new Rectangle(var4, var5, var6 - var4, var7 - var5);
   }
}
