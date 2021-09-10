package net.optifine.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;

public class GuiDetailSettingsOF extends GuiScreen {
   private GuiScreen prevScreen;
   private TooltipManager tooltipManager = new TooltipManager(this, new TooltipProviderOptions());
   private GameSettings settings;
   protected String title;
   private static GameSettings.Options[] enumOptions;

   static {
      enumOptions = new GameSettings.Options[]{GameSettings.Options.CLOUDS, GameSettings.Options.CLOUD_HEIGHT, GameSettings.Options.TREES, GameSettings.Options.RAIN, GameSettings.Options.SKY, GameSettings.Options.STARS, GameSettings.Options.SUN_MOON, GameSettings.Options.SHOW_CAPES, GameSettings.Options.FOG_FANCY, GameSettings.Options.FOG_START, GameSettings.Options.TRANSLUCENT_BLOCKS, GameSettings.Options.HELD_ITEM_TOOLTIPS, GameSettings.Options.DROPPED_ITEMS, GameSettings.Options.ENTITY_SHADOWS, GameSettings.Options.VIGNETTE, GameSettings.Options.ALTERNATE_BLOCKS, GameSettings.Options.SWAMP_COLORS, GameSettings.Options.SMOOTH_BIOMES};
   }

   public void initGui() {
      this.title = I18n.format("of.options.detailsTitle");
      this.buttonList.clear();

      for(int var1 = 0; var1 < enumOptions.length; ++var1) {
         GameSettings.Options var2 = enumOptions[var1];
         int var3 = width / 2 - 155 + var1 % 2 * 160;
         int var4 = height / 6 + 21 * (var1 / 2) - 12;
         if (!var2.getEnumFloat()) {
            this.buttonList.add(new GuiOptionButtonOF(var2.returnEnumOrdinal(), var3, var4, var2, this.settings.getKeyBinding(var2)));
         } else {
            this.buttonList.add(new GuiOptionSliderOF(var2.returnEnumOrdinal(), var3, var4, var2));
         }
      }

      this.buttonList.add(new GuiButton(200, width / 2 - 100, height / 6 + 168 + 11, I18n.format("gui.done")));
   }

   protected void actionPerformed(GuiButton var1) {
      if (var1.enabled) {
         if (var1.id < 200 && var1 instanceof GuiOptionButton) {
            this.settings.setOptionValue(((GuiOptionButton)var1).returnEnumOptions(), 1);
            var1.displayString = this.settings.getKeyBinding(GameSettings.Options.getEnumOptions(var1.id));
         }

         if (var1.id == 200) {
            this.mc.gameSettings.saveOptions();
            this.mc.displayGuiScreen(this.prevScreen);
         }
      }

   }

   public GuiDetailSettingsOF(GuiScreen var1, GameSettings var2) {
      this.prevScreen = var1;
      this.settings = var2;
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.fontRendererObj, this.title, width / 2, 15, 16777215);
      super.drawScreen(var1, var2, var3);
      this.tooltipManager.drawTooltips(var1, var2, this.buttonList);
   }
}
