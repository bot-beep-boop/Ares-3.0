package net.optifine.shaders.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;
import net.optifine.shaders.config.ShaderOption;

public class GuiSliderShaderOption extends GuiButtonShaderOption {
   public boolean dragging;
   private ShaderOption shaderOption = null;
   private float sliderValue = 1.0F;

   public boolean mousePressed(Minecraft var1, int var2, int var3) {
      if (super.mousePressed(var1, var2, var3)) {
         this.sliderValue = (float)(var2 - (this.xPosition + 4)) / (float)(this.width - 8);
         this.sliderValue = MathHelper.clamp_float(this.sliderValue, 0.0F, 1.0F);
         this.shaderOption.setIndexNormalized(this.sliderValue);
         this.displayString = GuiShaderOptions.getButtonText(this.shaderOption, this.width);
         this.dragging = true;
         return true;
      } else {
         return false;
      }
   }

   protected int getHoverState(boolean var1) {
      return 0;
   }

   public boolean isSwitchable() {
      return false;
   }

   public void mouseReleased(int var1, int var2) {
      this.dragging = false;
   }

   public GuiSliderShaderOption(int var1, int var2, int var3, int var4, int var5, ShaderOption var6, String var7) {
      super(var1, var2, var3, var4, var5, var6, var7);
      this.shaderOption = var6;
      this.sliderValue = var6.getIndexNormalized();
      this.displayString = GuiShaderOptions.getButtonText(var6, this.width);
   }

   protected void mouseDragged(Minecraft var1, int var2, int var3) {
      if (this.visible) {
         if (this.dragging && !GuiScreen.isShiftKeyDown()) {
            this.sliderValue = (float)(var2 - (this.xPosition + 4)) / (float)(this.width - 8);
            this.sliderValue = MathHelper.clamp_float(this.sliderValue, 0.0F, 1.0F);
            this.shaderOption.setIndexNormalized(this.sliderValue);
            this.sliderValue = this.shaderOption.getIndexNormalized();
            this.displayString = GuiShaderOptions.getButtonText(this.shaderOption, this.width);
         }

         var1.getTextureManager().bindTexture(buttonTextures);
         GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
         drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)), this.yPosition, 0, 66, 4, 20);
         drawTexturedModalRect(this.xPosition + (int)(this.sliderValue * (float)(this.width - 8)) + 4, this.yPosition, 196, 66, 4, 20);
      }

   }

   public void valueChanged() {
      this.sliderValue = this.shaderOption.getIndexNormalized();
   }
}
