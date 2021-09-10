package com.aresclient.visuals;

import com.aresclient.visuals.utils.ImageButtonWithText;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class GuiColorpicker extends GuiScreen {
   public static int Icon14 = 1;
   public static int Icon1 = 1;
   public static int Icon5 = 1;
   public static int Icon16 = 1;
   public static Color ModColor = new Color(255, 100, 100, 50);
   public static int Icon13 = 1;
   private float oldMouseX;
   public static int Icon3 = 1;
   public static int Icon12 = 1;
   public static int Icon6 = 1;
   public static int Icon2 = 1;
   public static int Icon10 = 1;
   public static int Icon15 = 1;
   public static int Icon9 = 1;
   public static int Icon4 = 1;
   public static int Icon7 = 1;
   public static int prevFramerate = 0;
   public static int Icon8 = 1;
   int i = -30;
   public static int Icon11 = 1;
   private float oldMouseY;

   public static void drawEntityOnScreen(int var0, int var1, int var2, float var3, float var4, EntityLivingBase var5) {
      GlStateManager.enableColorMaterial();
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)var0, (float)var1, 50.0F);
      GlStateManager.scale((float)(-var2), (float)var2, (float)var2);
      GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
      float var6 = var5.renderYawOffset;
      float var7 = var5.rotationYaw;
      float var8 = var5.rotationPitch;
      float var9 = var5.prevRotationYawHead;
      float var10 = var5.rotationYawHead;
      GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
      RenderHelper.enableStandardItemLighting();
      GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-((float)Math.atan((double)(var4 / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
      var5.renderYawOffset = (float)Math.atan((double)(var3 / 40.0F)) * 20.0F;
      var5.rotationYaw = (float)Math.atan((double)(var3 / 40.0F)) * 40.0F;
      var5.rotationPitch = -((float)Math.atan((double)(var4 / 40.0F))) * 20.0F;
      var5.rotationYawHead = var5.rotationYaw;
      var5.prevRotationYawHead = var5.rotationYaw;
      GlStateManager.translate(0.0F, 0.0F, 0.0F);
      RenderManager var11 = Minecraft.getMinecraft().getRenderManager();
      var11.setPlayerViewY(180.0F);
      var11.setRenderShadow(false);
      var11.renderEntityWithPosYaw(var5, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F);
      var11.setRenderShadow(true);
      var5.renderYawOffset = var6;
      var5.rotationYaw = var7;
      var5.rotationPitch = var8;
      var5.prevRotationYawHead = var9;
      var5.rotationYawHead = var10;
      GlStateManager.popMatrix();
      RenderHelper.disableStandardItemLighting();
      GlStateManager.disableRescaleNormal();
      GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
      GlStateManager.disableTexture2D();
      GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
   }

   private void updatebuttons() {
      int var1 = height / 10;
      int var2 = var1 * 3 - var1 / 2;
      this.buttonList.clear();
      int var3 = height / 8;
      int var4 = var3 * 3 - var3 / 2;
      this.buttonList.add(new ImageButtonWithText(8, width / 2 - var3 * 2, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/ColorPicker/DarkGreen.png"), "DarkGreen", "Changes the color of your Modules"));
      this.buttonList.add(new ImageButtonWithText(9, width / 2 - var3, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/ColorPicker/LightGreen.png"), "LightGreen", "Changes the color of your Modules"));
      this.buttonList.add(new ImageButtonWithText(10, width / 2, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/ColorPicker/Purple.png"), "Purple", "Changes the color of your Modules"));
      this.buttonList.add(new ImageButtonWithText(11, width / 2 + var3, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/ColorPicker/Pink.png"), "Pink", "Changes the color of your Modules"));
      this.buttonList.add(new ImageButtonWithText(12, width / 2 - var3 * 2, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/ColorPicker/Orange.png"), "Orange", "Changes the color of your Modules"));
      this.buttonList.add(new ImageButtonWithText(13, width / 2 - var3, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/ColorPicker/LightOrange.png"), "LightOrange", "Changes the color of your Modules"));
      this.buttonList.add(new ImageButtonWithText(14, width / 2, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/ColorPicker/Red.png"), "Red", "Changes the color of your Modules"));
      this.buttonList.add(new ImageButtonWithText(15, width / 2 + var3, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/ColorPicker/Yellow.png"), "Yellow", "Changes the color of your Modules"));
   }

   public void initGui() {
      prevFramerate = this.mc.gameSettings.limitFramerate;
      this.mc.gameSettings.limitFramerate = 60;
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
      super.initGui();
      this.updatebuttons();
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         this.mc.gameSettings.limitFramerate = prevFramerate;
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.oldMouseX = (float)var1;
      this.oldMouseY = (float)var2;
      int var4 = width / 2 + width / 3;
      int var5 = height / 2 + height / 6;
      this.drawCenteredString(this.fontRendererObj, I18n.format("Current Color" + var2), width / 2, 20, ModColor.getRGB());
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 7) {
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
      }

      if (var1.id == 1) {
         this.mc.displayGuiScreen(new GuiColorpicker());
      }

      if (var1.id == 2) {
         this.mc.displayGuiScreen(new GuiCosmetics());
      }

      if (var1.id == 5) {
         this.mc.displayGuiScreen(new GuiMultiplayer(this));
      }

      if (var1.id == 6) {
         this.mc.displayGuiScreen(new GuiTimechanger());
      }

      if (var1.id == 8) {
         ModColor = new Color(30, 71, 41, 255);
         this.updatebuttons();
      }

      if (var1.id == 9) {
         ModColor = new Color(31, 237, 86, 255);
         this.updatebuttons();
      }

      if (var1.id == 10) {
         ModColor = new Color(96, 0, 191, 255);
         this.updatebuttons();
      }

      if (var1.id == 11) {
         ModColor = new Color(255, 0, 234, 255);
         this.updatebuttons();
      }

      if (var1.id == 12) {
         ModColor = new Color(255, 111, 0, 255);
         this.updatebuttons();
      }

      if (var1.id == 13) {
         ModColor = new Color(255, 162, 0, 255);
         this.updatebuttons();
      }

      if (var1.id == 14) {
         ModColor = new Color(255, 34, 0, 255);
         this.updatebuttons();
      }

      if (var1.id == 15) {
         ModColor = new Color(255, 221, 0, 255);
         this.updatebuttons();
      }

      if (var1.id == 16) {
         if (Icon9 == 1) {
            Icon9 = 2;
         } else {
            Icon9 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 17) {
         if (Icon10 == 1) {
            Icon10 = 2;
         } else {
            Icon10 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 18) {
         if (Icon11 == 1) {
            Icon11 = 2;
         } else {
            Icon11 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 19) {
         if (Icon12 == 1) {
            Icon12 = 2;
         } else {
            Icon12 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 20) {
         if (Icon13 == 1) {
            Icon13 = 2;
         } else {
            Icon13 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 21) {
         if (Icon14 == 1) {
            Icon14 = 2;
         } else {
            Icon14 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 22) {
         if (Icon15 == 1) {
            Icon15 = 2;
         } else {
            Icon15 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 23) {
         if (Icon16 == 1) {
            Icon16 = 2;
         } else {
            Icon16 = 1;
         }

         this.updatebuttons();
      }

   }
}
