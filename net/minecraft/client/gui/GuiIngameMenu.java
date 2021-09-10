package net.minecraft.client.gui;

import com.aresclient.Ares;
import com.aresclient.discordrpc.DiscordApp;
import com.aresclient.utils.config.ConfigManager;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.minecraft.client.gui.achievement.GuiAchievements;
import net.minecraft.client.gui.achievement.GuiStats;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.realms.RealmsBridge;

public class GuiIngameMenu extends GuiScreen {
   private int field_146444_f;
   private int field_146445_a;

   public void updateScreen() {
      super.updateScreen();
      ++this.field_146444_f;
   }

   public void drawScreen(int var1, int var2, float var3) {
      this.drawDefaultBackground();
      this.drawCenteredString(this.fontRendererObj, I18n.format(this.getTime()), width / 2, 40, 16777215);
      if (ConfigManager.settings.Timer == 2) {
         this.drawCenteredString(this.fontRendererObj, I18n.format("Playtime: " + Ares.stopwatch.toString()), width / 2, 55, 16777215);
      }

      super.drawScreen(var1, var2, var3);
   }

   public void initGui() {
      DiscordApp.update(this.mc.isIntegratedServerRunning() ? "Singeplayer" : this.mc.getCurrentServerData().serverIP, "Ingame Menu", true);
      this.field_146445_a = 0;
      this.buttonList.clear();
      byte var1 = -16;
      boolean var2 = true;
      this.buttonList.add(new GuiButton(1, width / 2 - 100, height / 4 + 120 + var1, I18n.format("menu.returnToMenu")));
      if (!this.mc.isIntegratedServerRunning()) {
         ((GuiButton)this.buttonList.get(0)).displayString = I18n.format("menu.disconnect");
      }

      this.buttonList.add(new GuiButton(4, width / 2 - 100, height / 4 + 24 + var1, I18n.format("menu.returnToGame")));
      this.buttonList.add(new GuiButton(0, width / 2 - 100, height / 4 + 96 + var1, 98, 20, I18n.format("menu.options")));
      this.buttonList.add(new GuiButton(12, width / 2 - 100, height / 4 + 72 + var1, I18n.format("ares.gui.menu")));
      GuiButton var3;
      this.buttonList.add(var3 = new GuiButton(7, width / 2 + 2, height / 4 + 96 + var1, 98, 20, I18n.format("menu.shareToLan")));
      this.buttonList.add(new GuiButton(5, width / 2 - 100, height / 4 + 48 + var1, 98, 20, I18n.format("gui.achievements")));
      this.buttonList.add(new GuiButton(6, width / 2 + 2, height / 4 + 48 + var1, 98, 20, I18n.format("gui.stats")));
      var3.enabled = this.mc.isSingleplayer() && !this.mc.getIntegratedServer().getPublic();
   }

   private String getTime() {
      DateTimeFormatter var1 = DateTimeFormatter.ofPattern("h:mm a");
      LocalDateTime var2 = LocalDateTime.now();
      return var1.format(var2);
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      switch(var1.id) {
      case 0:
         this.mc.displayGuiScreen(new GuiOptions(this, this.mc.gameSettings));
         break;
      case 1:
         boolean var2 = this.mc.isIntegratedServerRunning();
         boolean var3 = this.mc.isConnectedToRealms();
         var1.enabled = false;
         this.mc.theWorld.sendQuittingDisconnectingPacket();
         this.mc.loadWorld((WorldClient)null);
         if (var2) {
            this.mc.displayGuiScreen(new GuiMainMenu());
         } else if (var3) {
            RealmsBridge var4 = new RealmsBridge();
            var4.switchToRealms(new GuiMainMenu());
         } else {
            this.mc.displayGuiScreen(new GuiMultiplayer(new GuiMainMenu()));
         }
      case 2:
      case 3:
      case 8:
      case 9:
      case 10:
      case 11:
      default:
         break;
      case 4:
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
         break;
      case 5:
         this.mc.displayGuiScreen(new GuiAchievements(this, this.mc.thePlayer.getStatFileWriter()));
         break;
      case 6:
         this.mc.displayGuiScreen(new GuiStats(this, this.mc.thePlayer.getStatFileWriter()));
         break;
      case 7:
         this.mc.displayGuiScreen(new GuiShareToLan(this));
         break;
      case 12:
         this.mc.displayGuiScreen(new com.aresclient.visuals.GuiIngameMenu());
      }

   }
}
