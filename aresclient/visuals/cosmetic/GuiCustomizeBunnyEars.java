package com.aresclient.visuals.cosmetic;

import com.aresclient.utils.UIUtils;
import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.GuiCosmetics;
import com.aresclient.visuals.utils.ImageButton;
import java.awt.Color;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class GuiCustomizeBunnyEars extends GuiScreen {
   int i = 0;
   private float oldMouseY;
   ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
   private float oldMouseX;

   public void initGui() {
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
      super.initGui();
      this.updatebuttons();
   }

   private void updatebuttons() {
      int var1 = height / 10;
      int var2 = var1 * 3 - var1 / 2;
      this.buttonList.add(new ImageButton(1, 10, var2 - var1 * 1, var1, var1, new ResourceLocation("Ares/cosmetic/BunnyEars/button1.png")));
      this.buttonList.add(new ImageButton(2, 10, var2, var1, var1, new ResourceLocation("Ares/cosmetic/BunnyEars/button2.png")));
      this.buttonList.add(new ImageButton(3, 10, var2 + var1 * 1, var1, var1, new ResourceLocation("Ares/cosmetic/BunnyEars/button3.png")));
      this.buttonList.add(new ImageButton(7, 10, var2 + var1 * 2, var1, var1, new ResourceLocation("Ares/cosmetic/BunnyEars/button7.png")));
      this.buttonList.add(new ImageButton(4, 20 + var1, var2 - var1 * 1, var1, var1, new ResourceLocation("Ares/cosmetic/BunnyEars/button4.png")));
      this.buttonList.add(new ImageButton(5, 20 + var1, var2, var1, var1, new ResourceLocation("Ares/cosmetic/BunnyEars/button5.png")));
      this.buttonList.add(new ImageButton(6, 20 + var1, var2 + var1 * 1, var1, var1, new ResourceLocation("Ares/cosmetic/BunnyEars/button6.png")));
      int var3 = width / 2 + width / 3 - var1 / 2;
      int var4 = height / 2 + height / 6 + var1 / 2;
      this.buttonList.add(new ImageButton(24, var3, var4, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Exit.png")));
      int var5 = height / 8;
      int var6 = var5 * 3 - var5 / 2;
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      int var4 = height - height / 4;
      if (var2 >= var4 && this.i < 0) {
         ++this.i;
      } else if (var2 <= var4 && this.i > -25) {
         --this.i;
      }

      int var5 = height / 12;
      UIUtils.drawRoundedRect(width / 2 - width / 6 - var5, height - 30 - this.i, width / 2 + width / 6 + var5, height - 1 - this.i, (float)(9.0D / (double)this.sr.getScaleFactor()), (new Color(200, 200, 200, 150)).getRGB());
      int var6 = width / 2;
      int var7 = height;
      this.buttonList.clear();
      this.buttonList.add(new ImageButton(14, width / 2 - var5 * 4, height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/cosmetic/buttons/Bandana.png")));
      this.buttonList.add(new ImageButton(15, width / 2 - var5 * 3, height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/cosmetic/buttons/Blaze.png")));
      this.buttonList.add(new ImageButton(16, width / 2 - var5 * 2, height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/cosmetic/buttons/BunnyEars.png")));
      this.buttonList.add(new ImageButton(17, width / 2 - var5 * 1, height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/cosmetic/buttons/Halo.png")));
      this.buttonList.add(new ImageButton(18, width / 2 - var5 * 0, height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/cosmetic/buttons/Wings.png")));
      this.buttonList.add(new ImageButton(3, width / 2 + var5 * 1, height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/cosmetic/buttons/witchhat.png")));
      this.buttonList.add(new ImageButton(2, width / 2 + var5 * 2, height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/White.png")));
      this.buttonList.add(new ImageButton(1, width / 2 + var5 * 3, height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/White.png")));
      this.updatebuttons();
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      this.oldMouseX = (float)var1;
      this.oldMouseY = (float)var2;
      int var8 = width / 2;
      int var9 = height / 2 + height / 6 + height / 6 - 20;
      byte var10 = -100;
      byte var11 = 10;
      drawEntityOnScreen(var10 + 51, var11 + 75, 30, (float)(var10 + 51) - this.oldMouseX, (float)(var11 + 75 - 50) - this.oldMouseY, this.mc.thePlayer);
      drawEntityOnScreen(var8, var9, 75, (float)(width / 2 - var1), (float)(height / 2 - var2 - 60), this.mc.thePlayer);
      super.drawScreen(var1, var2, var3);
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 24) {
         this.mc.displayGuiScreen(new GuiCosmetics());
      }

      if (var1.id == 1) {
         ConfigManager.settings.BunnyEarsTexture = 1;
      }

      if (var1.id == 2) {
         ConfigManager.settings.BunnyEarsTexture = 2;
      }

      if (var1.id == 3) {
         ConfigManager.settings.BunnyEarsTexture = 3;
      }

      if (var1.id == 4) {
         ConfigManager.settings.BunnyEarsTexture = 4;
      }

      if (var1.id == 5) {
         ConfigManager.settings.BunnyEarsTexture = 5;
      }

      if (var1.id == 6) {
         ConfigManager.settings.BunnyEarsTexture = 6;
      }

      if (var1.id == 7) {
         ConfigManager.settings.BunnyEarsTexture = 7;
      }

      if (var1.id == 14) {
         this.mc.displayGuiScreen(new GuiCustomizeBandana());
      }

      if (var1.id == 15) {
         this.mc.displayGuiScreen(new GuiCustomizeBlaze());
      }

      int var10000 = var1.id;
      if (var1.id == 17) {
         this.mc.displayGuiScreen(new GuiCustomizeHalo());
      }

      if (var1.id == 18) {
         this.mc.displayGuiScreen(new GuiCustomizeWings());
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
}
