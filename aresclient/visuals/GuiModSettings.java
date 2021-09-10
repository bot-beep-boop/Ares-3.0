package com.aresclient.visuals;

import com.aresclient.utils.GuiImages;
import com.aresclient.utils.config.Config;
import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.utils.AnimatedButton;
import com.aresclient.visuals.utils.ImageButtonWithText;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class GuiModSettings extends GuiScreen {
   public static int Icon14 = 1;
   public static int Icon10 = 1;
   private float oldMouseY;
   public static int Icon4 = 1;
   private float oldMouseX;
   public static int Icon12 = 1;
   public static int Icon15 = 1;
   public static int Icon1 = 1;
   ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());
   public static int Icon11 = 1;
   public static int Icon13 = 1;
   public static int Icon9 = 1;
   int j;
   public static int Icon7 = 1;
   public static int Icon3 = 1;
   int i;
   public static int Icon2 = 1;
   public static int Icon16 = 1;
   public static int prevFramerate = 0;
   public static int Icon6 = 1;
   public static int Icon5 = 1;
   public static int Icon8 = 1;

   public void initGui() {
      prevFramerate = this.mc.gameSettings.limitFramerate;
      this.mc.gameSettings.limitFramerate = 60;
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
      super.initGui();
      this.updatebuttons();
   }

   private void updatebuttons() {
      int var1 = height / 10;
      int var2 = var1 * 3 - var1 / 2;
      this.buttonList.clear();
      this.buttonList.add(new AnimatedButton(1, 10, var2 - var1 * 1, var1, var1, "Ares/Icons/Animated/Settings/Settings ("));
      this.buttonList.add(new AnimatedButton(2, 10, var2, var1, var1, "Ares/Icons/Animated/Cosmetics/Cosmetics ("));
      this.buttonList.add(new AnimatedButton(3, 10, var2 + var1 * 1, var1, var1, "Ares/Icons/Animated/Mods/Mods ("));
      this.buttonList.add(new AnimatedButton(4, 10, var2 + var1 * 2, var1, var1, "Ares/Icons/Animated/Radio/Radio ("));
      this.buttonList.add(new AnimatedButton(5, 10, var2 + var1 * 3, var1, var1, "Ares/Icons/Animated/Multiplayer/Multiplayer ("));
      this.buttonList.add(new AnimatedButton(6, 10, var2 + var1 * 4, var1, var1, "Ares/Icons/Animated/Timechanger/Timechanger ("));
      this.buttonList.add(new AnimatedButton(7, 10, var2 + var1 * 5, var1, var1, "Ares/Icons/Animated/Exit/Exit ("));
      int var3 = height / 8;
      int var4 = var3 * 3 - var3 / 2;
      this.buttonList.add(new ImageButtonWithText(8, width / 2 - var3 * 2, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/Fullbright" + Icon1 + ".png"), "Fullbright", I18n.format("ares.mods.fullbright")));
      this.buttonList.add(new ImageButtonWithText(9, width / 2 - var3, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/Itemphisics" + ConfigManager.settings.Itemphisics + ".png"), "Itemphysics", I18n.format("ares.mods.itemphysics")));
      this.buttonList.add(new ImageButtonWithText(10, width / 2, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/Lefthand" + ConfigManager.settings.LeftHand + ".png"), "Lefthand", I18n.format("ares.mods.lefthand")));
      this.buttonList.add(new ImageButtonWithText(11, width / 2 + var3, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/Togglesprint" + ConfigManager.settings.Togglesprint + ".png"), "Togglesprint", I18n.format("ares.mods.togglesprint")));
      this.buttonList.add(new ImageButtonWithText(12, width / 2 - var3 * 2, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/ZoomAnimation" + ConfigManager.settings.ZoomAnimation + ".png"), "Zoom Animation", I18n.format("ares.mods.zoomanimation")));
      this.buttonList.add(new ImageButtonWithText(13, width / 2 - var3, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/HitDelayFix" + ConfigManager.settings.HitDelayFix + ".png"), "HitDelay Fix", I18n.format("ares.mods.hitdelayfix")));
      this.buttonList.add(new ImageButtonWithText(14, width / 2, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/OldAnimations" + ConfigManager.settings.useOldAnimations + ".png"), "OldAnimations", I18n.format("ares.mods.useoldanimations")));
      this.buttonList.add(new ImageButtonWithText(15, width / 2 + var3, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/ArrowTrail" + ConfigManager.settings.ArrowTrail + ".png"), "ArrowTrails", I18n.format("ares.mods.arrowtrail")));
      this.buttonList.add(new ImageButtonWithText(16, width / 2 - var3 * 2, var4 - var3 * -1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/TntTimer" + ConfigManager.settings.TntTimer + ".png"), "Tnt Timer", I18n.format("ares.mods.tnttimer")));
      this.buttonList.add(new ImageButtonWithText(17, width / 2 - var3, var4 - var3 * -1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/CustomCrosshair" + ConfigManager.settings.CustomCrosshair + ".png"), "Custom Crosshair", I18n.format("ares.mods.customcrosshair")));
      this.buttonList.add(new ImageButtonWithText(18, width / 2, var4 - var3 * -1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/BlockOverlay" + ConfigManager.settings.BlockOverlay + ".png"), "Custom SelectionBox", I18n.format("ares.mods.blockoverlay")));
      this.buttonList.add(new ImageButtonWithText(19, width / 2 + var3, var4 - var3 * -1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Mods/Particle" + ConfigManager.settings.Particle + ".png"), "More Particles", I18n.format("ares.mods.moreparticle")));
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 7) {
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
      }

      if (var1.id == 1) {
         this.mc.displayGuiScreen(new GuiAresSettings());
      }

      if (var1.id == 2) {
         this.mc.displayGuiScreen(new GuiCosmetics());
      }

      if (var1.id == 3) {
         this.mc.displayGuiScreen(new GuiModSettings());
      }

      if (var1.id == 5) {
         this.mc.displayGuiScreen(new GuiMultiplayer(this));
      }

      if (var1.id == 6) {
         this.mc.displayGuiScreen(new GuiTimechanger());
      }

      if (var1.id == 8) {
         if (Icon1 == 1) {
            Icon1 = 2;
            this.mc.gameSettings.gammaSetting = 100.0F;
         } else {
            Icon1 = 1;
            this.mc.gameSettings.gammaSetting = 0.0F;
         }

         this.updatebuttons();
      }

      if (var1.id == 9) {
         if (ConfigManager.settings.Itemphisics == 1) {
            ConfigManager.settings.Itemphisics = 2;
         } else {
            ConfigManager.settings.Itemphisics = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 10) {
         if (ConfigManager.settings.LeftHand == 1) {
            ConfigManager.settings.LeftHand = 2;
         } else {
            ConfigManager.settings.LeftHand = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 11) {
         if (ConfigManager.settings.Togglesprint == 1) {
            ConfigManager.settings.Togglesprint = 2;
         } else {
            ConfigManager.settings.Togglesprint = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 12) {
         if (ConfigManager.settings.ZoomAnimation == 1) {
            ConfigManager.settings.ZoomAnimation = 2;
         } else {
            ConfigManager.settings.ZoomAnimation = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 13) {
         if (ConfigManager.settings.HitDelayFix == 1) {
            ConfigManager.settings.HitDelayFix = 2;
         } else {
            ConfigManager.settings.HitDelayFix = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 14) {
         if (ConfigManager.settings.useOldAnimations) {
            ConfigManager.settings.useOldAnimations = false;
         } else {
            ConfigManager.settings.useOldAnimations = true;
         }

         this.updatebuttons();
      }

      if (var1.id == 15) {
         if (ConfigManager.settings.ArrowTrail < 4) {
            ++ConfigManager.settings.ArrowTrail;
         } else {
            ConfigManager.settings.ArrowTrail = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 16) {
         if (ConfigManager.settings.TntTimer == 1) {
            ConfigManager.settings.TntTimer = 2;
         } else {
            ConfigManager.settings.TntTimer = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 17) {
         if (ConfigManager.settings.CustomCrosshair < 7) {
            ++ConfigManager.settings.CustomCrosshair;
         } else {
            ConfigManager.settings.CustomCrosshair = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 18) {
         if (ConfigManager.settings.BlockOverlay == 1) {
            ConfigManager.settings.BlockOverlay = 2;
            Config.red = 0.9F;
            Config.green = 0.32F;
            Config.blue = 0.25F;
            Config.thickness = 4.0F;
         } else if (ConfigManager.settings.BlockOverlay == 2) {
            ConfigManager.settings.BlockOverlay = 3;
            Config.red = 0.0F;
            Config.green = 0.8F;
            Config.blue = 0.2F;
            Config.thickness = 4.0F;
         } else if (ConfigManager.settings.BlockOverlay == 3) {
            ConfigManager.settings.BlockOverlay = 4;
            Config.red = 0.0F;
            Config.green = 0.4F;
            Config.blue = 1.0F;
            Config.thickness = 4.0F;
         } else if (ConfigManager.settings.BlockOverlay == 4) {
            ConfigManager.settings.BlockOverlay = 5;
            Config.red = 7.0F;
            Config.green = 0.0F;
            Config.blue = 0.9F;
            Config.thickness = 4.0F;
         } else if (ConfigManager.settings.BlockOverlay == 5) {
            ConfigManager.settings.BlockOverlay = 6;
            Config.red = 0.92156F;
            Config.green = 0.5373F;
            Config.blue = 0.239F;
            Config.thickness = 4.0F;
         } else if (ConfigManager.settings.BlockOverlay == 6) {
            ConfigManager.settings.BlockOverlay = 1;
            Config.red = 0.0F;
            Config.green = 0.0F;
            Config.blue = 0.0F;
            Config.thickness = 2.0F;
         }

         this.updatebuttons();
      }

      if (var1.id == 19) {
         if (ConfigManager.settings.Particle == 1) {
            ConfigManager.settings.Particle = 2;
         } else {
            ConfigManager.settings.Particle = 1;
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

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         this.mc.gameSettings.limitFramerate = prevFramerate;
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

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

   public void drawScreen(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.oldMouseX = (float)var1;
      this.oldMouseY = (float)var2;
      int var4 = width / 2 + width / 3;
      int var5 = height / 2 + height / 6;
      byte var6 = -100;
      byte var7 = 10;
      drawEntityOnScreen(var6 + 51, var7 + 75, 30, (float)(var6 + 51) - this.oldMouseX, (float)(var7 + 75 - 50) - this.oldMouseY, this.mc.thePlayer);
      drawEntityOnScreen(var4, var5, 50, (float)var4 - this.oldMouseX, (float)var5 - this.oldMouseY - 75.0F, this.mc.thePlayer);
      if (ConfigManager.settings.CustomCrosshair != 1) {
         GuiImages.drawPictureWithTextureOffset(var6 / 2 - 7, var7 / 2 - 7 + var7 / 4, 0, 0, 16, 16, "Ares/Crosshairs/Crosshair" + ConfigManager.settings.CustomCrosshair + ".png");
      }

   }

   public GuiModSettings() {
      this.i = this.scaledresolution.getScaledWidth();
      this.j = this.scaledresolution.getScaledHeight();
   }
}
