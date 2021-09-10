package net.minecraft.client.gui;

import com.aresclient.utils.UIUtils;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.util.ResourceLocation;

public class GuiButton extends Gui {
   protected static final ResourceLocation buttonTextures2 = new ResourceLocation("textures/gui/icons.png");
   protected int height;
   private int animation;
   public boolean enabled;
   public boolean visible;
   private int color;
   ScaledResolution sr;
   protected boolean hovered;
   public int xPosition;
   private int color2;
   public int yPosition;
   public String displayString;
   public int id;
   protected static final ResourceLocation buttonTextures = new ResourceLocation("textures/gui/widgets.png");
   protected int width;

   protected int getHoverState(boolean var1) {
      byte var2 = 1;
      if (!this.enabled) {
         var2 = 0;
      } else if (var1) {
         var2 = 2;
      }

      return var2;
   }

   public void mouseReleased(int var1, int var2) {
   }

   public boolean isMouseOver() {
      return this.hovered;
   }

   public void setWidth(int var1) {
      this.width = var1;
   }

   public void drawButtonForegroundLayer(int var1, int var2) {
   }

   public GuiButton(int var1, int var2, int var3, int var4, int var5, String var6) {
      this.width = 200;
      this.height = 20;
      this.enabled = true;
      this.visible = true;
      this.color = 170;
      this.color2 = 170;
      this.sr = new ScaledResolution(Minecraft.getMinecraft());
      this.animation = 0;
      this.id = var1;
      this.xPosition = var2;
      this.yPosition = var3;
      this.width = var4;
      this.height = var5;
      this.displayString = var6;
   }

   public void playPressSound(SoundHandler var1) {
      var1.playSound(PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0F));
   }

   public GuiButton(int var1, int var2, int var3, String var4) {
      this(var1, var2, var3, 200, 20, var4);
   }

   public boolean mousePressed(Minecraft var1, int var2, int var3) {
      return this.enabled && this.visible && var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + this.width && var3 < this.yPosition + this.height;
   }

   protected void mouseDragged(Minecraft var1, int var2, int var3) {
   }

   public int getButtonWidth() {
      return this.width;
   }

   public void drawButton(Minecraft var1, int var2, int var3) {
      float var4;
      if (this.enabled) {
         if (this.visible) {
            this.hovered = var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + this.width && var3 < this.yPosition + this.height;
            this.mouseDragged(var1, var2, var3);
            if (this.hovered) {
               if (this.color < 255) {
                  this.color += 5;
               }

               if ((double)this.animation < (double)this.width / 2.0D) {
                  this.animation = (int)AnimationUtils.animate((double)this.width / 3.0D, (double)this.animation, 0.10000000149011612D);
               }
            } else {
               if (this.color > 170) {
                  this.color -= 5;
               }

               if ((double)this.animation > 0.0D) {
                  this.animation = (int)AnimationUtils.animate(0.0D, (double)this.animation, 0.10000000149011612D);
               }
            }

            UIUtils.drawRoundedRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, (float)(9.0D / (double)this.sr.getScaleFactor()), (new Color(100, 100, 100, 50)).getRGB());
            var4 = (float)(this.hovered ? (new Color(this.color2, 255, this.color2, 255)).getRGB() : (new Color(255, 255, 255, 255)).getRGB());
            drawRect(this.xPosition + this.width / 2 - this.animation, this.yPosition + this.height - 3 + 3, this.xPosition + this.width / 2 + this.animation, this.yPosition + this.height - 4 + 3, (int)var4);
            this.drawCenteredString(var1.fontRendererObj, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, (int)var4);
         }
      } else if (this.visible) {
         this.hovered = var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + this.width && var3 < this.yPosition + this.height;
         this.mouseDragged(var1, var2, var3);
         UIUtils.drawRoundedRect(this.xPosition, this.yPosition, this.xPosition + this.width, this.yPosition + this.height, (float)(9.0D / (double)this.sr.getScaleFactor()), (new Color(100, 100, 100, 50)).getRGB());
         var4 = (float)Color.gray.getRGB();
         drawRect(this.xPosition + this.width / 2 - this.animation, this.yPosition + this.height - 3 + 3, this.xPosition + this.width / 2 + this.animation, this.yPosition + this.height - 4 + 3, (int)var4);
         this.drawCenteredString(var1.fontRendererObj, this.displayString, this.xPosition + this.width / 2, this.yPosition + (this.height - 8) / 2, (int)var4);
      }

   }
}
