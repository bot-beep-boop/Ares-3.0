package com.aresclient.visuals.utils.items;

import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class DropDownMenu extends GuiButton {
   public boolean active = false;
   public String selected = null;
   public DropDownMenu$List dropDownMenu$List;

   public DropDownMenu(int var1, int var2, int var3, DropDownMenu$List var4) {
      super(var1, var2, var3, var4.getHeader());
      this.dropDownMenu$List = var4;
   }

   public void mouseReleased(int var1, int var2) {
      int var3 = Minecraft.getMinecraft().fontRendererObj.getStringWidth(this.dropDownMenu$List.getHeader()) + 2;
      if (var1 > this.xPosition && var1 < this.xPosition + var3 + 10 && var2 < this.yPosition + var3 / 2 + 1) {
         this.active = !this.active;
      }

   }

   private void drawArc(int var1, int var2, int var3, int var4, int var5, Color var6) {
      GL11.glPushMatrix();
      GL11.glEnable(3042);
      GL11.glDisable(3553);
      GL11.glBlendFunc(770, 771);
      GL11.glColor4f((float)var6.getRed() / 255.0F, (float)var6.getGreen() / 255.0F, (float)var6.getBlue() / 255.0F, (float)var6.getAlpha() / 255.0F);
      WorldRenderer var7 = Tessellator.getInstance().getWorldRenderer();
      var7.begin(6, DefaultVertexFormats.POSITION);
      var7.pos((double)var1, (double)var2, 0.0D).endVertex();

      for(int var8 = (int)((double)var4 / 360.0D * 100.0D); var8 <= (int)((double)var5 / 360.0D * 100.0D); ++var8) {
         double var9 = 6.283185307179586D * (double)var8 / 100.0D + Math.toRadians(180.0D);
         var7.pos((double)var1 + Math.sin(var9) * (double)var3, (double)var2 + Math.cos(var9) * (double)var3, 0.0D).endVertex();
      }

      Tessellator.getInstance().draw();
      GL11.glEnable(3553);
      GL11.glDisable(3042);
      GL11.glPopMatrix();
   }

   public void drawButton(Minecraft var1, int var2, int var3) {
      if (this.enabled && this.visible) {
         ResourceLocation var4 = new ResourceLocation("Ares/Icons/dropdown/dropdown.png");
         byte var5 = 12;
         int var6 = var1.fontRendererObj.getStringWidth(this.dropDownMenu$List.getHeader()) + 2;
         drawRect(this.xPosition - 1, this.yPosition - 1, this.xPosition + var6 + 1 + var5, this.yPosition + var6 / 2 + 1, -6250336);
         drawRect(this.xPosition, this.yPosition, this.xPosition + var6 + var5, this.yPosition + var6 / 2, -16777216);
         this.drawString(var1.fontRendererObj, this.dropDownMenu$List.getHeader(), this.xPosition + 1, this.yPosition + 3, Color.white.getRGB());
         drawTexture(var4, (float)(this.xPosition + var6), (float)(this.yPosition + 4), 10.0F, 6.0F);
         if (this.active) {
            for(int var7 = 0; var7 < this.dropDownMenu$List.getItems().size(); ++var7) {
               String var8 = (String)this.dropDownMenu$List.getItems().get(var7);
               this.drawString(var1.fontRendererObj, var8, this.xPosition + 1, this.yPosition + 20 + var7 * 18, Color.white.getRGB());
            }
         }
      }

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

   private void drawRoundedRect(int var1, int var2, int var3, int var4, int var5, Color var6) {
      Gui.drawRect(var1, var2 + var5, var1 + var5, var2 + var4 - var5, var6.getRGB());
      Gui.drawRect(var1 + var5, var2, var1 + var3 - var5, var2 + var4, var6.getRGB());
      Gui.drawRect(var1 + var3 - var5, var2 + var5, var1 + var3, var2 + var4 - var5, var6.getRGB());
      this.drawArc(var1 + var5, var2 + var5, var5, 0, 90, var6);
      this.drawArc(var1 + var3 - var5, var2 + var5, var5, 270, 360, var6);
      this.drawArc(var1 + var3 - var5, var2 + var4 - var5, var5, 180, 270, var6);
      this.drawArc(var1 + var5, var2 + var4 - var5, var5, 90, 180, var6);
   }
}
