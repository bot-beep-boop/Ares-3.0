package com.aresclient.visuals.hud.modules;

import com.aresclient.visuals.hud.base.impl.MoveableModule;
import com.aresclient.visuals.utils.GuiImageRender;
import java.awt.Color;
import net.minecraft.client.Minecraft;

public class ModuleWatermark extends MoveableModule {
   public ModuleWatermark(int var1, int var2) {
      super(var1, var2, true);
   }

   public void render() {
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("§f", (float)this.getX(), (float)this.getY(), Color.white.getRGB());
      GuiImageRender.drawPicture(this.getX(), this.getY(), 25, 25, "Ares/Icons/Logos/Light.png");
   }

   public String getName() {
      return "Watermark";
   }

   public int getWidth() {
      return 25;
   }

   public int getHeight() {
      return 25;
   }
}
