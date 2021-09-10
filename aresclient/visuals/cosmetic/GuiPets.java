package com.aresclient.visuals.cosmetic;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.utils.notification.Notification;
import com.aresclient.utils.notification.NotificationManager;
import com.aresclient.utils.notification.NotificationType;
import com.aresclient.visuals.GuiCosmetics;
import com.aresclient.visuals.utils.ImageButton;
import com.aresclient.visuals.utils.ImageButtonWithText;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class GuiPets extends GuiScreen {
   private float oldMouseY;
   private float oldMouseX;

   public void drawScreen(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.oldMouseX = (float)var1;
      this.oldMouseY = (float)var2;
      int var4 = width / 2;
      int var5 = height / 2 + height / 6 + height / 6 - 20;
      byte var6 = -100;
      byte var7 = 10;
      drawEntityOnScreen(var6 + 51, var7 + 75, 30, (float)(var6 + 51) - this.oldMouseX, (float)(var7 + 75 - 50) - this.oldMouseY, this.mc.thePlayer);
      drawEntityOnScreen(var4, var5, 75, (float)var4 - this.oldMouseX, (float)var5 - this.oldMouseY - 75.0F, this.mc.thePlayer);
   }

   public void initGui() {
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
      super.initGui();
      this.updatebuttons();
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 25) {
         if (ConfigManager.settings.Shoulder == 1) {
            ConfigManager.settings.Shoulder = 2;
         } else {
            ConfigManager.settings.Shoulder = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 26) {
         if (ConfigManager.settings.SkinType == 1) {
            ConfigManager.settings.SkinType = 2;
         } else {
            ConfigManager.settings.SkinType = 1;
         }

         this.updatebuttons();
      }

      if (var1.id == 24) {
         this.mc.displayGuiScreen(new GuiCosmetics());
      }

      if (var1.id == 27) {
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
      }

      if (var1.id == 1) {
         DeactivateAllPets();
         ConfigManager.settings.BatPet = 2;
      }

      if (var1.id == 2) {
         DeactivateAllPets();
         ConfigManager.settings.BlazePet = 2;
      }

      if (var1.id == 3) {
         DeactivateAllPets();
         ConfigManager.settings.GhastPet = 2;
      }

      if (var1.id == 4) {
         DeactivateAllPets();
         ConfigManager.settings.SlimePet = 2;
         NotificationManager.show(new Notification(NotificationType.INFO, "Coming Soon", "Not available yet", 3));
      }

      if (var1.id == 5) {
         DeactivateAllPets();
         ConfigManager.settings.SquidPet = 2;
      }

      if (var1.id == 6) {
         DeactivateAllPets();
         ConfigManager.settings.WitherPet = 2;
      }

      if (var1.id == 7) {
         DeactivateAllPets();
         ConfigManager.settings.NoPet = 2;
      }

      this.updatebuttons();
   }

   public static void DeactivateAllPets() {
      ConfigManager.settings.BatPet = 1;
      ConfigManager.settings.BlazePet = 1;
      ConfigManager.settings.GhastPet = 1;
      ConfigManager.settings.SlimePet = 1;
      ConfigManager.settings.SquidPet = 1;
      ConfigManager.settings.WitherPet = 1;
      ConfigManager.settings.NoPet = 1;
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

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

   private void updatebuttons() {
      int var1 = height / 10;
      int var2 = var1 * 3 - var1 / 2;
      this.buttonList.clear();
      this.buttonList.add(new ImageButton(1, 10, var2 - var1 * 1, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Pets/Bat" + ConfigManager.settings.BatPet + ".png")));
      this.buttonList.add(new ImageButton(2, 10, var2, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Pets/Blaze" + ConfigManager.settings.BlazePet + ".png")));
      this.buttonList.add(new ImageButton(3, 10, var2 + var1 * 1, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Pets/Ghast" + ConfigManager.settings.GhastPet + ".png")));
      this.buttonList.add(new ImageButton(7, 10, var2 + var1 * 2, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Pets/None" + ConfigManager.settings.NoPet + ".png")));
      this.buttonList.add(new ImageButton(4, 20 + var1, var2 - var1 * 1, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Pets/Slime" + ConfigManager.settings.SlimePet + ".png")));
      this.buttonList.add(new ImageButton(5, 20 + var1, var2, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Pets/Squid" + ConfigManager.settings.SquidPet + ".png")));
      this.buttonList.add(new ImageButton(6, 20 + var1, var2 + var1 * 1, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Pets/Wither" + ConfigManager.settings.WitherPet + ".png")));
      int var3 = width / 2 + width / 3 - var1 / 2;
      int var4 = height / 2 + height / 6 + var1 / 2;
      this.buttonList.add(new ImageButtonWithText(25, var3 - var1 - 5, var4, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Pets/shoulder" + ConfigManager.settings.Shoulder + ".png"), "Change Pet Position", ""));
      this.buttonList.add(new ImageButton(24, var3, var4, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Exit.png")));
      int var5 = height / 8;
      int var6 = var5 * 3 - var5 / 2;
   }
}
