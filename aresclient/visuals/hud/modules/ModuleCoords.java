package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ModuleCoords extends MoveableModule {
   public int getHeight() {
      return 30;
   }

   public int getWidth() {
      return minecraft.fontRendererObj.getStringWidth("[§4X§f] " + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0D) / 1000L);
   }

   public void render() {
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "X§f] " + Math.round(Minecraft.getMinecraft().thePlayer.posX * 1000.0D) / 1000L, (float)this.getX(), (float)this.getY(), Color.white.getRGB());
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "Y§f] " + Math.round(Minecraft.getMinecraft().thePlayer.posY * 1000.0D) / 1000L, (float)this.getX(), (float)(this.getY() + 10), Color.white.getRGB());
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "Z§f] " + Math.round(Minecraft.getMinecraft().thePlayer.posZ * 1000.0D) / 1000L, (float)this.getX(), (float)(this.getY() + 20), Color.white.getRGB());
   }

   public ModuleCoords(int var1, int var2) {
      super(var1, var2, true);
   }

   public String getName() {
      return "Coords";
   }
}
