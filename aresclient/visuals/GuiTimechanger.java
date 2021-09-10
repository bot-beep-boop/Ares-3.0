package com.aresclient.visuals;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.utils.AnimatedButton;
import com.aresclient.visuals.utils.ImageButton;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class GuiTimechanger extends GuiScreen {
   public static int Icon14 = 1;
   private float oldMouseX;
   public static int Icon5 = 1;
   public static int Icon13 = 1;
   public static int Icon2 = 2;
   public static int Icon15 = 1;
   public static int Icon6 = 1;
   public static int Icon7 = 1;
   public static int Icon10 = 1;
   private float oldMouseY;
   public static int Icon1 = 2;
   public static int Icon8 = 1;
   public static int Icon16 = 1;
   public static int prevFramerate = 0;
   public static int Icon12 = 1;
   public static int Icon3 = 1;
   public static int Icon9 = 1;
   public static int Icon4 = 1;
   public static int Icon11 = 1;

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
      this.buttonList.add(new ImageButton(8, width / 2 - var3 * 2, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Time/Timechanger" + ConfigManager.settings.Timechanger + ".png")));
      this.buttonList.add(new ImageButton(9, width / 2 - var3, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Time/Day.png")));
      this.buttonList.add(new ImageButton(10, width / 2, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Time/Sunset.png")));
      this.buttonList.add(new ImageButton(11, width / 2 + var3, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/Toggles/Time/Night.png")));
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
         if (ConfigManager.settings.Timechanger) {
            ConfigManager.settings.Timechanger = false;
         } else {
            ConfigManager.settings.Timechanger = true;
         }

         this.updatebuttons();
      }

      if (var1.id == 9) {
         ConfigManager.settings.Time = 8000;
         this.updatebuttons();
      }

      if (var1.id == 10) {
         ConfigManager.settings.Time = 23800;
         this.updatebuttons();
      }

      if (var1.id == 11) {
         ConfigManager.settings.Time = 18000;
         this.updatebuttons();
      }

      if (var1.id == 12) {
         if (Icon5 == 1) {
            Icon5 = 2;
         } else {
            Icon5 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 13) {
         if (Icon6 == 1) {
            Icon6 = 2;
         } else {
            Icon6 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 14) {
         if (Icon7 == 1) {
            Icon7 = 2;
         } else {
            Icon7 = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 15) {
         if (Icon8 == 1) {
            Icon8 = 2;
         } else {
            Icon8 = 1;
         }

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
