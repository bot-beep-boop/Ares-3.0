package com.aresclient.utils.notification;

import com.aresclient.utils.GuiImages;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;

public class Notification {
   private String title;
   private long end;
   private long fadeOut;
   private String messsage;
   private long fadedIn;
   private long start;
   private NotificationType type;
   ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());

   private long getTime() {
      return System.currentTimeMillis() - this.start;
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

   public void show() {
      this.start = System.currentTimeMillis();
   }

   public Notification(NotificationType var1, String var2, String var3, int var4) {
      this.type = var1;
      this.title = var2;
      this.messsage = var3;
      this.fadedIn = (long)(200 * var4);
      this.fadeOut = this.fadedIn + (long)(500 * var4);
      this.end = this.fadeOut + this.fadedIn;
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

   public boolean isShown() {
      return this.getTime() <= this.end;
   }

   public void render() {
      double var1 = 0.0D;
      byte var3 = 120;
      byte var4 = 30;
      long var5 = this.getTime();
      String var7 = "Tipp";
      if (var5 < this.fadedIn) {
         var1 = Math.tanh((double)var5 / (double)this.fadedIn * 3.0D) * (double)var3;
      } else if (var5 > this.fadeOut) {
         var1 = Math.tanh(3.0D - (double)(var5 - this.fadeOut) / (double)(this.end - this.fadeOut) * 3.0D) * (double)var3;
      } else {
         var1 = (double)var3;
      }

      Color var8 = new Color(30, 30, 30, 220);
      if (this.type == NotificationType.INFO) {
         new Color(0, 26, 169);
         var7 = "Tipp";
      } else if (this.type == NotificationType.WARNING) {
         new Color(204, 193, 0);
         var7 = "Warning";
      } else {
         new Color(204, 0, 18);
         int var10 = Math.max(0, Math.min(255, (int)(Math.sin((double)var5 / 100.0D) * 255.0D / 2.0D + 127.5D)));
         var8 = new Color(var10, 0, 0, 220);
      }

      FontRenderer var11 = Minecraft.getMinecraft().fontRendererObj;
      this.drawRoundedRect((int)((double)GuiScreen.width - var1), GuiScreen.height - var4, GuiScreen.width - 2, GuiScreen.height, 4, var8);
      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("ï¿½f", 1.0F, 1.0F, Color.white.getRGB());
      GuiImages.drawPicture((int)((double)GuiScreen.width - var1 + 5.0D), GuiScreen.height + 5 - var4, 20, 20, "Ares/Icons/Notifications/" + var7 + ".png");
      var11.drawString(this.title, (int)((double)GuiScreen.width - var1 + 30.0D), GuiScreen.height + 5 - var4, Color.white.getRGB());
      var11.drawString(this.messsage, (int)((double)GuiScreen.width - var1 + 30.0D), GuiScreen.height - 14, Color.white.getRGB());
   }
}
