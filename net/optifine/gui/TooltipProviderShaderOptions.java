package net.optifine.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.src.Config;
import net.optifine.Lang;
import net.optifine.shaders.config.ShaderOption;
import net.optifine.shaders.gui.GuiButtonShaderOption;
import net.optifine.util.StrUtils;

public class TooltipProviderShaderOptions extends TooltipProviderOptions {
   private String[] splitDescription(String var1) {
      if (var1.length() <= 0) {
         return new String[0];
      } else {
         var1 = StrUtils.removePrefix(var1, "//");
         String[] var2 = var1.split("\\. ");

         for(int var3 = 0; var3 < var2.length; ++var3) {
            var2[var3] = "- " + var2[var3].trim();
            var2[var3] = StrUtils.removeSuffix(var2[var3], ".");
         }

         return var2;
      }
   }

   private String[] makeTooltipLines(int var1, List<String> var2) {
      FontRenderer var3 = Config.getMinecraft().fontRendererObj;
      ArrayList var4 = new ArrayList();

      for(int var5 = 0; var5 < var2.size(); ++var5) {
         String var6 = (String)var2.get(var5);
         if (var6 != null && var6.length() > 0) {
            Iterator var8 = var3.listFormattedStringToWidth(var6, var1).iterator();

            while(var8.hasNext()) {
               String var7 = (String)var8.next();
               var4.add(var7);
            }
         }
      }

      String[] var9 = (String[])var4.toArray(new String[var4.size()]);
      return var9;
   }

   private String[] makeTooltipLines(ShaderOption var1, int var2) {
      String var3 = var1.getNameText();
      String var4 = Config.normalize(var1.getDescriptionText()).trim();
      String[] var5 = this.splitDescription(var4);
      GameSettings var6 = Config.getGameSettings();
      String var7 = null;
      if (!var3.equals(var1.getName()) && var6.advancedItemTooltips) {
         var7 = "§8" + Lang.get("of.general.id") + ": " + var1.getName();
      }

      String var8 = null;
      if (var1.getPaths() != null && var6.advancedItemTooltips) {
         var8 = "§8" + Lang.get("of.general.from") + ": " + Config.arrayToString((Object[])var1.getPaths());
      }

      String var9 = null;
      if (var1.getValueDefault() != null && var6.advancedItemTooltips) {
         String var10 = var1.isEnabled() ? var1.getValueText(var1.getValueDefault()) : Lang.get("of.general.ambiguous");
         var9 = "§8" + Lang.getDefault() + ": " + var10;
      }

      ArrayList var12 = new ArrayList();
      var12.add(var3);
      var12.addAll(Arrays.asList(var5));
      if (var7 != null) {
         var12.add(var7);
      }

      if (var8 != null) {
         var12.add(var8);
      }

      if (var9 != null) {
         var12.add(var9);
      }

      String[] var11 = this.makeTooltipLines(var2, var12);
      return var11;
   }

   public String[] getTooltipLines(GuiButton var1, int var2) {
      if (!(var1 instanceof GuiButtonShaderOption)) {
         return null;
      } else {
         GuiButtonShaderOption var3 = (GuiButtonShaderOption)var1;
         ShaderOption var4 = var3.getShaderOption();
         String[] var5 = this.makeTooltipLines(var4, var2);
         return var5;
      }
   }
}
