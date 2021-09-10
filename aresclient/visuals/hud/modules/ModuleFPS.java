package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class ModuleFPS extends MoveableModule {
   public int getHeight() {
      return minecraft.fontRendererObj.FONT_HEIGHT;
   }

   public int getWidth() {
      FontRenderer var10000 = minecraft.fontRendererObj;
      StringBuilder var10001 = new StringBuilder("[§4FPS§f] ");
      Minecraft.getMinecraft();
      return var10000.getStringWidth(var10001.append(Minecraft.getDebugFPS()).toString());
   }

   public ModuleFPS(int var1, int var2) {
      super(var1, var2, true);
   }

   public void render() {
      FontRenderer var10000 = Minecraft.getMinecraft().fontRendererObj;
      StringBuilder var10001 = (new StringBuilder("[")).append(ConfigManager.settings.ModColor).append("FPS§f] ");
      Minecraft.getMinecraft();
      var10000.drawStringWithShadow(var10001.append(Minecraft.getDebugFPS()).toString(), (float)this.getX(), (float)this.getY(), Color.white.getRGB());
   }

   public String getName() {
      return "FPS";
   }
}
