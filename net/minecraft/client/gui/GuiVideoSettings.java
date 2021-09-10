package net.minecraft.client.gui;

import java.io.IOException;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.src.Config;
import net.optifine.Lang;
import net.optifine.gui.GuiAnimationSettingsOF;
import net.optifine.gui.GuiDetailSettingsOF;
import net.optifine.gui.GuiOptionButtonOF;
import net.optifine.gui.GuiOptionSliderOF;
import net.optifine.gui.GuiOtherSettingsOF;
import net.optifine.gui.GuiPerformanceSettingsOF;
import net.optifine.gui.GuiQualitySettingsOF;
import net.optifine.gui.GuiScreenOF;
import net.optifine.gui.TooltipManager;
import net.optifine.gui.TooltipProviderOptions;
import net.optifine.shaders.gui.GuiShaders;

public class GuiVideoSettings extends GuiScreenOF {
   protected String screenTitle = "Video Settings";
   private static GameSettings.Options[] videoOptions;
   private GameSettings guiGameSettings;
   private GuiScreen parentGuiScreen;
   private TooltipManager tooltipManager = new TooltipManager(this, new TooltipProviderOptions());

   protected void actionPerformedRightClick(GuiButton var1) {
      if (var1.id == GameSettings.Options.GUI_SCALE.ordinal()) {
         this.actionPerformed(var1, -1);
      }

   }

   public static String getGuiChatText(GuiChat var0) {
      return var0.inputField.getText();
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      this.actionPerformed(var1, 1);
   }

   public static void drawGradientRect(GuiScreen var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      var0.drawGradientRect(var1, var2, var3, var4, var5, var6);
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.fontRendererObj, this.screenTitle, width / 2, 15, 16777215);
      String var4 = Config.getVersion();
      String var5 = "HD_U";
      if (var5.equals("HD")) {
         var4 = "OptiFine HD L5";
      }

      if (var5.equals("HD_U")) {
         var4 = "OptiFine HD L5 Ultra";
      }

      if (var5.equals("L")) {
         var4 = "OptiFine L5 Light";
      }

      this.drawString(this.fontRendererObj, var4, 2, height - 10, 8421504);
      String var6 = "Minecraft 1.8.9";
      int var7 = this.fontRendererObj.getStringWidth(var6);
      this.drawString(this.fontRendererObj, var6, width - var7 - 2, height - 10, 8421504);
      super.drawScreen(var1, var2, var3);
      this.tooltipManager.drawTooltips(var1, var2, this.buttonList);
   }

   public static int getButtonHeight(GuiButton var0) {
      return var0.height;
   }

   public static int getButtonWidth(GuiButton var0) {
      return var0.width;
   }

   private void actionPerformed(GuiButton var1, int var2) {
      if (var1.enabled) {
         int var3 = this.guiGameSettings.guiScale;
         if (var1.id < 200 && var1 instanceof GuiOptionButton) {
            this.guiGameSettings.setOptionValue(((GuiOptionButton)var1).returnEnumOptions(), var2);
            var1.displayString = this.guiGameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(var1.id));
         }

         if (var1.id == 200) {
            this.mc.gameSettings.saveOptions();
            this.mc.displayGuiScreen(this.parentGuiScreen);
         }

         if (this.guiGameSettings.guiScale != var3) {
            ScaledResolution var4 = new ScaledResolution(this.mc);
            int var5 = var4.getScaledWidth();
            int var6 = var4.getScaledHeight();
            this.setWorldAndResolution(this.mc, var5, var6);
         }

         if (var1.id == 201) {
            this.mc.gameSettings.saveOptions();
            GuiDetailSettingsOF var7 = new GuiDetailSettingsOF(this, this.guiGameSettings);
            this.mc.displayGuiScreen(var7);
         }

         if (var1.id == 202) {
            this.mc.gameSettings.saveOptions();
            GuiQualitySettingsOF var8 = new GuiQualitySettingsOF(this, this.guiGameSettings);
            this.mc.displayGuiScreen(var8);
         }

         if (var1.id == 211) {
            this.mc.gameSettings.saveOptions();
            GuiAnimationSettingsOF var9 = new GuiAnimationSettingsOF(this, this.guiGameSettings);
            this.mc.displayGuiScreen(var9);
         }

         if (var1.id == 212) {
            this.mc.gameSettings.saveOptions();
            GuiPerformanceSettingsOF var10 = new GuiPerformanceSettingsOF(this, this.guiGameSettings);
            this.mc.displayGuiScreen(var10);
         }

         if (var1.id == 222) {
            this.mc.gameSettings.saveOptions();
            GuiOtherSettingsOF var11 = new GuiOtherSettingsOF(this, this.guiGameSettings);
            this.mc.displayGuiScreen(var11);
         }

         if (var1.id == 231) {
            if (Config.isAntialiasing() || Config.isAntialiasingConfigured()) {
               Config.showGuiMessage(Lang.get("of.message.shaders.aa1"), Lang.get("of.message.shaders.aa2"));
               return;
            }

            if (Config.isAnisotropicFiltering()) {
               Config.showGuiMessage(Lang.get("of.message.shaders.af1"), Lang.get("of.message.shaders.af2"));
               return;
            }

            if (Config.isFastRender()) {
               Config.showGuiMessage(Lang.get("of.message.shaders.fr1"), Lang.get("of.message.shaders.fr2"));
               return;
            }

            if (Config.getGameSettings().anaglyph) {
               Config.showGuiMessage(Lang.get("of.message.shaders.an1"), Lang.get("of.message.shaders.an2"));
               return;
            }

            this.mc.gameSettings.saveOptions();
            GuiShaders var12 = new GuiShaders(this, this.guiGameSettings);
            this.mc.displayGuiScreen(var12);
         }
      }

   }

   public void initGui() {
      this.screenTitle = I18n.format("options.videoTitle");
      this.buttonList.clear();

      int var1;
      for(var1 = 0; var1 < videoOptions.length; ++var1) {
         GameSettings.Options var2 = videoOptions[var1];
         if (var2 != null) {
            int var3 = width / 2 - 155 + var1 % 2 * 160;
            int var4 = height / 6 + 21 * (var1 / 2) - 12;
            if (var2.getEnumFloat()) {
               this.buttonList.add(new GuiOptionSliderOF(var2.returnEnumOrdinal(), var3, var4, var2));
            } else {
               this.buttonList.add(new GuiOptionButtonOF(var2.returnEnumOrdinal(), var3, var4, var2, this.guiGameSettings.getKeyBinding(var2)));
            }
         }
      }

      var1 = height / 6 + 21 * (videoOptions.length / 2) - 12;
      boolean var5 = false;
      int var6 = width / 2 - 155;
      this.buttonList.add(new GuiOptionButton(231, var6, var1, Lang.get("of.options.shaders")));
      var6 = width / 2 - 155 + 160;
      this.buttonList.add(new GuiOptionButton(202, var6, var1, Lang.get("of.options.quality")));
      var1 += 21;
      var6 = width / 2 - 155;
      this.buttonList.add(new GuiOptionButton(201, var6, var1, Lang.get("of.options.details")));
      var6 = width / 2 - 155 + 160;
      this.buttonList.add(new GuiOptionButton(212, var6, var1, Lang.get("of.options.performance")));
      var1 += 21;
      var6 = width / 2 - 155;
      this.buttonList.add(new GuiOptionButton(211, var6, var1, Lang.get("of.options.animations")));
      var6 = width / 2 - 155 + 160;
      this.buttonList.add(new GuiOptionButton(222, var6, var1, Lang.get("of.options.other")));
      var1 += 21;
      this.buttonList.add(new GuiButton(200, width / 2 - 100, height / 6 + 168 + 11, I18n.format("gui.done")));
   }

   static {
      videoOptions = new GameSettings.Options[]{GameSettings.Options.GRAPHICS, GameSettings.Options.RENDER_DISTANCE, GameSettings.Options.AMBIENT_OCCLUSION, GameSettings.Options.FRAMERATE_LIMIT, GameSettings.Options.AO_LEVEL, GameSettings.Options.VIEW_BOBBING, GameSettings.Options.GUI_SCALE, GameSettings.Options.USE_VBO, GameSettings.Options.GAMMA, GameSettings.Options.BLOCK_ALTERNATIVES, GameSettings.Options.DYNAMIC_LIGHTS, GameSettings.Options.DYNAMIC_FOV};
   }

   public GuiVideoSettings(GuiScreen var1, GameSettings var2) {
      this.parentGuiScreen = var1;
      this.guiGameSettings = var2;
   }
}
