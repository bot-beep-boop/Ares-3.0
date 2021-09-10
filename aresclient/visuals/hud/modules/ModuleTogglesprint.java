package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ModuleTogglesprint extends MoveableModule {
   public void renderDummy() {
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("§f[" + ConfigManager.settings.ModColor + "Sprinting Toggled" + "§f]", (float)this.getX(), (float)this.getY(), Color.white.getRGB());
   }

   public void render() {
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(Minecraft.getMinecraft().thePlayer.movementInput.getDisplayText(), (float)this.getX(), (float)this.getY(), Color.white.getRGB());
   }

   public ModuleTogglesprint(int var1, int var2) {
      super(var1, var2, true);
   }

   public boolean isRenderDummy() {
      return true;
   }

   public String getName() {
      return "Togglesprint";
   }

   public int getWidth() {
      return minecraft.fontRendererObj.getStringWidth(this.isRenderDummy() ? "§f[" + ConfigManager.settings.ModColor + "Sprinting Toggled" + "§f]" : Minecraft.getMinecraft().thePlayer.movementInput.getDisplayText());
   }

   public int getHeight() {
      return minecraft.fontRendererObj.FONT_HEIGHT;
   }
}
