package net.minecraft.client.gui;

import java.io.IOException;
import java.util.Random;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.storage.ISaveFormat;
import net.minecraft.world.storage.WorldInfo;
import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;

public class GuiCreateWorld extends GuiScreen {
   private static final String[] disallowedFilenames = new String[]{"CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};
   private GuiButton btnGameMode;
   private String saveDirName;
   private boolean hardCoreMode;
   private boolean allowCheatsWasSetByUser;
   private GuiScreen parentScreen;
   private GuiTextField worldNameField;
   private GuiButton btnMapType;
   private boolean inMoreWorldOptionsDisplay;
   private String worldName;
   private boolean bonusChestEnabled;
   private String gameMode = "survival";
   private boolean allowCheats;
   private int selectedIndex;
   private GuiButton btnMapFeatures;
   private GuiButton btnCustomizeType;
   private String gameModeDesc1;
   private String savedGameMode;
   private GuiButton btnBonusItems;
   private GuiButton btnAllowCommands;
   private boolean generateStructuresEnabled = true;
   private GuiTextField worldSeedField;
   private String gameModeDesc2;
   private String worldSeed;
   public String chunkProviderSettingsJson = "";
   private GuiButton btnMoreOptions;
   private boolean alreadyGenerated;

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      super.mouseClicked(var1, var2, var3);
      if (this.inMoreWorldOptionsDisplay) {
         this.worldSeedField.mouseClicked(var1, var2, var3);
      } else {
         this.worldNameField.mouseClicked(var1, var2, var3);
      }

   }

   public static String getUncollidingSaveDirName(ISaveFormat var0, String var1) {
      var1 = var1.replaceAll("[\\./\"]", "_");
      String[] var5;
      int var4 = (var5 = disallowedFilenames).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         String var2 = var5[var3];
         if (var1.equalsIgnoreCase(var2)) {
            var1 = "_" + var1 + "_";
         }
      }

      while(var0.getWorldInfo(var1) != null) {
         var1 = var1 + "-";
      }

      return var1;
   }

   private void showMoreWorldOptions(boolean var1) {
      this.inMoreWorldOptionsDisplay = var1;
      if (WorldType.worldTypes[this.selectedIndex] == WorldType.DEBUG_WORLD) {
         this.btnGameMode.visible = !this.inMoreWorldOptionsDisplay;
         this.btnGameMode.enabled = false;
         if (this.savedGameMode == null) {
            this.savedGameMode = this.gameMode;
         }

         this.gameMode = "spectator";
         this.btnMapFeatures.visible = false;
         this.btnBonusItems.visible = false;
         this.btnMapType.visible = this.inMoreWorldOptionsDisplay;
         this.btnAllowCommands.visible = false;
         this.btnCustomizeType.visible = false;
      } else {
         this.btnGameMode.visible = !this.inMoreWorldOptionsDisplay;
         this.btnGameMode.enabled = true;
         if (this.savedGameMode != null) {
            this.gameMode = this.savedGameMode;
            this.savedGameMode = null;
         }

         this.btnMapFeatures.visible = this.inMoreWorldOptionsDisplay && WorldType.worldTypes[this.selectedIndex] != WorldType.CUSTOMIZED;
         this.btnBonusItems.visible = this.inMoreWorldOptionsDisplay;
         this.btnMapType.visible = this.inMoreWorldOptionsDisplay;
         this.btnAllowCommands.visible = this.inMoreWorldOptionsDisplay;
         this.btnCustomizeType.visible = this.inMoreWorldOptionsDisplay && (WorldType.worldTypes[this.selectedIndex] == WorldType.FLAT || WorldType.worldTypes[this.selectedIndex] == WorldType.CUSTOMIZED);
      }

      this.updateDisplayState();
      if (this.inMoreWorldOptionsDisplay) {
         this.btnMoreOptions.displayString = I18n.format("gui.done");
      } else {
         this.btnMoreOptions.displayString = I18n.format("selectWorld.moreWorldOptions");
      }

   }

   private void toggleMoreWorldOptions() {
      this.showMoreWorldOptions(!this.inMoreWorldOptionsDisplay);
   }

   private void updateDisplayState() {
      this.btnGameMode.displayString = I18n.format("selectWorld.gameMode") + ": " + I18n.format("selectWorld.gameMode." + this.gameMode);
      this.gameModeDesc1 = I18n.format("selectWorld.gameMode." + this.gameMode + ".line1");
      this.gameModeDesc2 = I18n.format("selectWorld.gameMode." + this.gameMode + ".line2");
      this.btnMapFeatures.displayString = I18n.format("selectWorld.mapFeatures") + " ";
      if (this.generateStructuresEnabled) {
         this.btnMapFeatures.displayString = this.btnMapFeatures.displayString + I18n.format("options.on");
      } else {
         this.btnMapFeatures.displayString = this.btnMapFeatures.displayString + I18n.format("options.off");
      }

      this.btnBonusItems.displayString = I18n.format("selectWorld.bonusItems") + " ";
      if (this.bonusChestEnabled && !this.hardCoreMode) {
         this.btnBonusItems.displayString = this.btnBonusItems.displayString + I18n.format("options.on");
      } else {
         this.btnBonusItems.displayString = this.btnBonusItems.displayString + I18n.format("options.off");
      }

      this.btnMapType.displayString = I18n.format("selectWorld.mapType") + " " + I18n.format(WorldType.worldTypes[this.selectedIndex].getTranslateName());
      this.btnAllowCommands.displayString = I18n.format("selectWorld.allowCommands") + " ";
      if (this.allowCheats && !this.hardCoreMode) {
         this.btnAllowCommands.displayString = this.btnAllowCommands.displayString + I18n.format("options.on");
      } else {
         this.btnAllowCommands.displayString = this.btnAllowCommands.displayString + I18n.format("options.off");
      }

   }

   public void initGui() {
      Keyboard.enableRepeatEvents(true);
      this.buttonList.clear();
      this.buttonList.add(new GuiButton(0, width / 2 - 155, height - 28, 150, 20, I18n.format("selectWorld.create")));
      this.buttonList.add(new GuiButton(1, width / 2 + 5, height - 28, 150, 20, I18n.format("gui.cancel")));
      this.buttonList.add(this.btnGameMode = new GuiButton(2, width / 2 - 75, 115, 150, 20, I18n.format("selectWorld.gameMode")));
      this.buttonList.add(this.btnMoreOptions = new GuiButton(3, width / 2 - 75, 187, 150, 20, I18n.format("selectWorld.moreWorldOptions")));
      this.buttonList.add(this.btnMapFeatures = new GuiButton(4, width / 2 - 155, 100, 150, 20, I18n.format("selectWorld.mapFeatures")));
      this.btnMapFeatures.visible = false;
      this.buttonList.add(this.btnBonusItems = new GuiButton(7, width / 2 + 5, 151, 150, 20, I18n.format("selectWorld.bonusItems")));
      this.btnBonusItems.visible = false;
      this.buttonList.add(this.btnMapType = new GuiButton(5, width / 2 + 5, 100, 150, 20, I18n.format("selectWorld.mapType")));
      this.btnMapType.visible = false;
      this.buttonList.add(this.btnAllowCommands = new GuiButton(6, width / 2 - 155, 151, 150, 20, I18n.format("selectWorld.allowCommands")));
      this.btnAllowCommands.visible = false;
      this.buttonList.add(this.btnCustomizeType = new GuiButton(8, width / 2 + 5, 120, 150, 20, I18n.format("selectWorld.customizeType")));
      this.btnCustomizeType.visible = false;
      this.worldNameField = new GuiTextField(9, this.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.worldNameField.setFocused(true);
      this.worldNameField.setText(this.worldName);
      this.worldSeedField = new GuiTextField(10, this.fontRendererObj, width / 2 - 100, 60, 200, 20);
      this.worldSeedField.setText(this.worldSeed);
      this.showMoreWorldOptions(this.inMoreWorldOptionsDisplay);
      this.calcSaveDirName();
      this.updateDisplayState();
   }

   public void recreateFromExistingWorld(WorldInfo var1) {
      this.worldName = I18n.format("selectWorld.newWorld.copyOf", var1.getWorldName());
      this.worldSeed = String.valueOf(var1.getSeed());
      this.selectedIndex = var1.getTerrainType().getWorldTypeID();
      this.chunkProviderSettingsJson = var1.getGeneratorOptions();
      this.generateStructuresEnabled = var1.isMapFeaturesEnabled();
      this.allowCheats = var1.areCommandsAllowed();
      if (var1.isHardcoreModeEnabled()) {
         this.gameMode = "hardcore";
      } else if (var1.getGameType().isSurvivalOrAdventure()) {
         this.gameMode = "survival";
      } else if (var1.getGameType().isCreative()) {
         this.gameMode = "creative";
      }

   }

   public void updateScreen() {
      this.worldNameField.updateCursorCounter();
      this.worldSeedField.updateCursorCounter();
   }

   public void onGuiClosed() {
      Keyboard.enableRepeatEvents(false);
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.fontRendererObj, I18n.format("selectWorld.create"), width / 2, 20, -1);
      if (this.inMoreWorldOptionsDisplay) {
         this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterSeed"), width / 2 - 100, 47, -6250336);
         this.drawString(this.fontRendererObj, I18n.format("selectWorld.seedInfo"), width / 2 - 100, 85, -6250336);
         if (this.btnMapFeatures.visible) {
            this.drawString(this.fontRendererObj, I18n.format("selectWorld.mapFeatures.info"), width / 2 - 150, 122, -6250336);
         }

         if (this.btnAllowCommands.visible) {
            this.drawString(this.fontRendererObj, I18n.format("selectWorld.allowCommands.info"), width / 2 - 150, 172, -6250336);
         }

         this.worldSeedField.drawTextBox();
         if (WorldType.worldTypes[this.selectedIndex].showWorldInfoNotice()) {
            this.fontRendererObj.drawSplitString(I18n.format(WorldType.worldTypes[this.selectedIndex].getTranslatedInfo()), this.btnMapType.xPosition + 2, this.btnMapType.yPosition + 22, this.btnMapType.getButtonWidth(), 10526880);
         }
      } else {
         this.drawString(this.fontRendererObj, I18n.format("selectWorld.enterName"), width / 2 - 100, 47, -6250336);
         this.drawString(this.fontRendererObj, I18n.format("selectWorld.resultFolder") + " " + this.saveDirName, width / 2 - 100, 85, -6250336);
         this.worldNameField.drawTextBox();
         this.drawString(this.fontRendererObj, this.gameModeDesc1, width / 2 - 100, 137, -6250336);
         this.drawString(this.fontRendererObj, this.gameModeDesc2, width / 2 - 100, 149, -6250336);
      }

      super.drawScreen(var1, var2, var3);
   }

   public GuiCreateWorld(GuiScreen var1) {
      this.parentScreen = var1;
      this.worldSeed = "";
      this.worldName = I18n.format("selectWorld.newWorld");
   }

   private boolean canSelectCurWorldType() {
      WorldType var1 = WorldType.worldTypes[this.selectedIndex];
      if (var1 != null && var1.getCanBeCreated()) {
         return var1 == WorldType.DEBUG_WORLD ? isShiftKeyDown() : true;
      } else {
         return false;
      }
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.enabled) {
         if (var1.id == 1) {
            this.mc.displayGuiScreen(this.parentScreen);
         } else if (var1.id == 0) {
            this.mc.displayGuiScreen((GuiScreen)null);
            if (this.alreadyGenerated) {
               return;
            }

            this.alreadyGenerated = true;
            long var2 = (new Random()).nextLong();
            String var4 = this.worldSeedField.getText();
            if (!StringUtils.isEmpty(var4)) {
               try {
                  long var5 = Long.parseLong(var4);
                  if (var5 != 0L) {
                     var2 = var5;
                  }
               } catch (NumberFormatException var7) {
                  var2 = (long)var4.hashCode();
               }
            }

            WorldSettings.GameType var8 = WorldSettings.GameType.getByName(this.gameMode);
            WorldSettings var6 = new WorldSettings(var2, var8, this.generateStructuresEnabled, this.hardCoreMode, WorldType.worldTypes[this.selectedIndex]);
            var6.setWorldName(this.chunkProviderSettingsJson);
            if (this.bonusChestEnabled && !this.hardCoreMode) {
               var6.enableBonusChest();
            }

            if (this.allowCheats && !this.hardCoreMode) {
               var6.enableCommands();
            }

            this.mc.launchIntegratedServer(this.saveDirName, this.worldNameField.getText().trim(), var6);
         } else if (var1.id == 3) {
            this.toggleMoreWorldOptions();
         } else if (var1.id == 2) {
            if (this.gameMode.equals("survival")) {
               if (!this.allowCheatsWasSetByUser) {
                  this.allowCheats = false;
               }

               this.hardCoreMode = false;
               this.gameMode = "hardcore";
               this.hardCoreMode = true;
               this.btnAllowCommands.enabled = false;
               this.btnBonusItems.enabled = false;
               this.updateDisplayState();
            } else if (this.gameMode.equals("hardcore")) {
               if (!this.allowCheatsWasSetByUser) {
                  this.allowCheats = true;
               }

               this.hardCoreMode = false;
               this.gameMode = "creative";
               this.updateDisplayState();
               this.hardCoreMode = false;
               this.btnAllowCommands.enabled = true;
               this.btnBonusItems.enabled = true;
            } else {
               if (!this.allowCheatsWasSetByUser) {
                  this.allowCheats = false;
               }

               this.gameMode = "survival";
               this.updateDisplayState();
               this.btnAllowCommands.enabled = true;
               this.btnBonusItems.enabled = true;
               this.hardCoreMode = false;
            }

            this.updateDisplayState();
         } else if (var1.id == 4) {
            this.generateStructuresEnabled = !this.generateStructuresEnabled;
            this.updateDisplayState();
         } else if (var1.id == 7) {
            this.bonusChestEnabled = !this.bonusChestEnabled;
            this.updateDisplayState();
         } else if (var1.id == 5) {
            ++this.selectedIndex;
            if (this.selectedIndex >= WorldType.worldTypes.length) {
               this.selectedIndex = 0;
            }

            while(!this.canSelectCurWorldType()) {
               ++this.selectedIndex;
               if (this.selectedIndex >= WorldType.worldTypes.length) {
                  this.selectedIndex = 0;
               }
            }

            this.chunkProviderSettingsJson = "";
            this.updateDisplayState();
            this.showMoreWorldOptions(this.inMoreWorldOptionsDisplay);
         } else if (var1.id == 6) {
            this.allowCheatsWasSetByUser = true;
            this.allowCheats = !this.allowCheats;
            this.updateDisplayState();
         } else if (var1.id == 8) {
            if (WorldType.worldTypes[this.selectedIndex] == WorldType.FLAT) {
               this.mc.displayGuiScreen(new GuiCreateFlatWorld(this, this.chunkProviderSettingsJson));
            } else {
               this.mc.displayGuiScreen(new GuiCustomizeWorldScreen(this, this.chunkProviderSettingsJson));
            }
         }
      }

   }

   protected void keyTyped(char var1, int var2) throws IOException {
      if (this.worldNameField.isFocused() && !this.inMoreWorldOptionsDisplay) {
         this.worldNameField.textboxKeyTyped(var1, var2);
         this.worldName = this.worldNameField.getText();
      } else if (this.worldSeedField.isFocused() && this.inMoreWorldOptionsDisplay) {
         this.worldSeedField.textboxKeyTyped(var1, var2);
         this.worldSeed = this.worldSeedField.getText();
      }

      if (var2 == 28 || var2 == 156) {
         this.actionPerformed((GuiButton)this.buttonList.get(0));
      }

      ((GuiButton)this.buttonList.get(0)).enabled = this.worldNameField.getText().length() > 0;
      this.calcSaveDirName();
   }

   private void calcSaveDirName() {
      this.saveDirName = this.worldNameField.getText().trim();
      char[] var4;
      int var3 = (var4 = ChatAllowedCharacters.allowedCharactersArray).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         char var1 = var4[var2];
         this.saveDirName = this.saveDirName.replace(var1, '_');
      }

      if (StringUtils.isEmpty(this.saveDirName)) {
         this.saveDirName = "World";
      }

      this.saveDirName = getUncollidingSaveDirName(this.mc.getSaveLoader(), this.saveDirName);
   }
}
