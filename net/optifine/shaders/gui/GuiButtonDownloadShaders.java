package net.optifine.shaders.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonDownloadShaders extends GuiButton {
   public GuiButtonDownloadShaders(int var1, int var2, int var3) {
      super(var1, var2, var3, 22, 20, "");
   }

   public void drawButton(Minecraft var1, int var2, int var3) {
      if (this.visible) {
         super.drawButton(var1, var2, var3);
         ResourceLocation var4 = new ResourceLocation("optifine/textures/icons.png");
         var1.getTextureManager().bindTexture(var4);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         drawTexturedModalRect(this.xPosition + 3, this.yPosition + 2, 0, 0, 16, 16);
      }

   }
}
