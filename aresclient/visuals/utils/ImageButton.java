package com.aresclient.visuals.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ImageButton extends GuiButton {
   public ResourceLocation image;
   private int ani = 0;

   public ImageButton(int var1, int var2, int var3, int var4, int var5, ResourceLocation var6) {
      super(var1, var2, var3, var4, var5, "");
      this.image = var6;
   }

   public void setImage(ResourceLocation var1) {
      this.image = var1;
   }

   public static void drawTexture(ResourceLocation var0, float var1, float var2, float var3, float var4) {
      GL11.glPushMatrix();
      float var5 = var3 / 2.0F;
      GL11.glEnable(3042);
      GL11.glEnable(3553);
      GL11.glEnable(2848);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      Minecraft.getMinecraft().getTextureManager().bindTexture(var0);
      GL11.glBegin(7);
      GL11.glTexCoord2d((double)(0.0F / var5), (double)(0.0F / var5));
      GL11.glVertex2d((double)var1, (double)var2);
      GL11.glTexCoord2d((double)(0.0F / var5), (double)((0.0F + var5) / var5));
      GL11.glVertex2d((double)var1, (double)(var2 + var4));
      GL11.glTexCoord2d((double)((0.0F + var5) / var5), (double)((0.0F + var5) / var5));
      GL11.glVertex2d((double)(var1 + var3), (double)(var2 + var4));
      GL11.glTexCoord2d((double)((0.0F + var5) / var5), (double)(0.0F / var5));
      GL11.glVertex2d((double)(var1 + var3), (double)var2);
      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glDisable(2848);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public void drawButton(Minecraft var1, int var2, int var3) {
      this.hovered = var2 >= this.xPosition && var3 >= this.yPosition && var2 < this.xPosition + this.width && var3 < this.yPosition + this.height;
      if (this.hovered) {
         if (this.ani < 2) {
            ++this.ani;
         }
      } else if (this.ani > 0) {
         --this.ani;
      }

      drawTexture(this.image, (float)(this.xPosition - this.ani), (float)(this.yPosition - this.ani), (float)(this.width + this.ani * 2), (float)(this.height + this.ani * 2));
   }
}
