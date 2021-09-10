package com.aresclient;

import com.aresclient.discordrpc.DiscordApp;
import com.aresclient.utils.Data;
import com.aresclient.utils.config.ConfigManager;
import com.aresclient.utils.update.Updater;
import com.aresclient.visuals.hud.base.FileManager;
import com.aresclient.visuals.hud.base.HUDConfig;
import com.aresclient.visuals.hud.ui.GuiHud;
import com.aresclient.visuals.utils.font.FontRenderer;
import com.google.common.base.Stopwatch;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class Ares {
   private static Data data = new Data();
   public static FontRenderer fontrenderer;
   public static int ClientColor = (new Color(170, 255, 170)).getRGB();
   private static HUDConfig hudConfig;
   public static Stopwatch stopwatch;

   public static void stopMinecraft() {
      DiscordApp.close();

      try {
         ConfigManager.save();
      } catch (IOException var1) {
         var1.printStackTrace();
      }

      stopwatch.stop();
   }

   public static Data getData() {
      return data;
   }

   public static void startMinecraft() {
      Updater.checkUpdate();
      DiscordApp.init();
      hudConfig = new HUDConfig();
      fontrenderer = new FontRenderer(new ResourceLocation("Ares/Font/Roboto.ttf"), 20.0F);
      ConfigManager.loadProperties(true);
      stopwatch = Stopwatch.createStarted();
      FileManager.init();
   }

   public static void runTick() {
      if (Minecraft.getMinecraft().gameSettings.keyBindAresHud.isPressed()) {
         Minecraft.getMinecraft().displayGuiScreen(new GuiHud());
      }

   }

   public static HUDConfig getHudConfig() {
      return hudConfig;
   }
}
