package net.minecraft.realms;

import java.lang.reflect.Constructor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiScreenRealmsProxy;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RealmsBridge extends RealmsScreen {
   private GuiScreen previousScreen;
   private static final Logger LOGGER = LogManager.getLogger();

   public void init() {
      Minecraft.getMinecraft().displayGuiScreen(this.previousScreen);
   }

   public GuiScreenRealmsProxy getNotificationScreen(GuiScreen var1) {
      try {
         this.previousScreen = var1;
         Class var2 = Class.forName("com.mojang.realmsclient.gui.screens.RealmsNotificationsScreen");
         Constructor var3 = var2.getDeclaredConstructor(RealmsScreen.class);
         var3.setAccessible(true);
         Object var4 = var3.newInstance(this);
         return ((RealmsScreen)var4).getProxy();
      } catch (Exception var5) {
         LOGGER.error("Realms module missing", var5);
         return null;
      }
   }

   public void switchToRealms(GuiScreen var1) {
      this.previousScreen = var1;

      try {
         Class var2 = Class.forName("com.mojang.realmsclient.RealmsMainScreen");
         Constructor var3 = var2.getDeclaredConstructor(RealmsScreen.class);
         var3.setAccessible(true);
         Object var4 = var3.newInstance(this);
         Minecraft.getMinecraft().displayGuiScreen(((RealmsScreen)var4).getProxy());
      } catch (Exception var5) {
         LOGGER.error("Realms module missing", var5);
      }

   }
}
