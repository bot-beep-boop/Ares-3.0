package com.aresclient.visuals;

import com.aresclient.utils.config.ConfigManager;
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

public class GuiCustomize extends GuiScreen {
   public static int Icon10;
   public static int Icon9;
   public static int Icon4;
   public static int Icon5;
   public static int Icon12;
   public static int Icon11;
   private float oldMouseX;
   public static int Icon6;
   public static int Icon1;
   public static int Icon8;
   public static int Icon13;
   public static int Icon2;
   public static int Icon16;
   public static int Icon3;
   public static int Icon7;
   private float oldMouseY;
   public static int Icon14;
   public static int Icon15;

   static {
      Icon1 = ConfigManager.settings.Wings;
      Icon2 = ConfigManager.settings.Bandana;
      Icon3 = ConfigManager.settings.Halo;
      Icon4 = ConfigManager.settings.WitchHat;
      Icon5 = 1;
      Icon6 = 1;
      Icon7 = 1;
      Icon8 = 1;
      Icon9 = 1;
      Icon10 = 1;
      Icon11 = 1;
      Icon12 = 1;
      Icon13 = 1;
      Icon14 = 1;
      Icon15 = 1;
      Icon16 = 1;
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
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
      int var4 = width / 2;
      int var5 = height / 2 + height / 6 + height / 6;
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

   private void updatebuttons() {
      int var1 = height / 10;
      int var2 = var1 * 3 - var1 / 2;
      this.buttonList.clear();
      int var3 = width / 2 + width / 3 - var1 / 2;
      int var4 = height / 2 + height / 6 + var1 / 2;
      this.buttonList.add(new ImageButton(24, var3, var4, var1, var1, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Exit.png")));
      int var5 = height / 8;
      int var6 = var5 * 3 - var5 / 2;
      if (ConfigManager.settings.Halo == 2) {
         this.buttonList.add(new ImageButton(8, width / 2 - var5 * 3, var6 - var5 * 1, var5, var5, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Right.png")));
         this.buttonList.add(new ImageButton(9, width / 2 + var5 * 2, var6 - var5 * 1, var5, var5, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Left.png")));
      }

      if (ConfigManager.settings.WitchHat == 2) {
         this.buttonList.add(new ImageButton(10, width / 2 - var5 * 3, var6 - var5 * 0, var5, var5, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Right.png")));
         this.buttonList.add(new ImageButton(11, width / 2 + var5 * 2, var6 - var5 * 0, var5, var5, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Left.png")));
      }

      if (ConfigManager.settings.Bandana == 2) {
         this.buttonList.add(new ImageButton(12, width / 2 - var5 * 3, var6 - var5 * -1, var5, var5, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Right.png")));
         this.buttonList.add(new ImageButton(13, width / 2 + var5 * 2, var6 - var5 * -1, var5, var5, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Left.png")));
      }

      if (ConfigManager.settings.Wings == 2) {
         this.buttonList.add(new ImageButton(14, width / 2 - var5 * 3, var6 - var5 * -2, var5, var5, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Right.png")));
         this.buttonList.add(new ImageButton(15, width / 2 + var5 * 2, var6 - var5 * -2, var5, var5, new ResourceLocation("Ares/Icons/Toggles/Cosmetics/Left.png")));
      }

   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 24) {
         this.mc.displayGuiScreen(new GuiCosmetics());
      }

      if (var1.id == 7) {
         this.mc.displayGuiScreen((GuiScreen)null);
         this.mc.setIngameFocus();
      }

      if (var1.id == 1) {
         this.mc.displayGuiScreen(new GuiCustomize());
      }

      if (var1.id == 2) {
         this.mc.displayGuiScreen(new GuiCustomize());
      }

      if (var1.id == 5) {
         this.mc.displayGuiScreen(new GuiMultiplayer(this));
      }

      if (var1.id == 6) {
         this.mc.displayGuiScreen(new GuiTimechanger());
      }

      if (var1.id == 8) {
         if (ConfigManager.settings.HaloTexture <= 4) {
            ++ConfigManager.settings.HaloTexture;
         } else {
            ConfigManager.settings.HaloTexture = 1;
         }
      }

      if (var1.id == 9) {
         if (ConfigManager.settings.HaloTexture >= 2) {
            --ConfigManager.settings.HaloTexture;
         } else {
            ConfigManager.settings.HaloTexture = 5;
         }
      }

      if (var1.id == 10) {
         if (ConfigManager.settings.WitchHatTexture <= 4) {
            ++ConfigManager.settings.WitchHatTexture;
         } else {
            ConfigManager.settings.WitchHatTexture = 1;
         }
      }

      if (var1.id == 11) {
         if (ConfigManager.settings.WitchHatTexture >= 2) {
            --ConfigManager.settings.WitchHatTexture;
         } else {
            ConfigManager.settings.WitchHatTexture = 5;
         }
      }

      if (var1.id == 12) {
         if (ConfigManager.settings.BandanaTexture <= 4) {
            ++ConfigManager.settings.BandanaTexture;
         } else {
            ConfigManager.settings.BandanaTexture = 1;
         }
      }

      if (var1.id == 13) {
         if (ConfigManager.settings.BandanaTexture >= 2) {
            --ConfigManager.settings.BandanaTexture;
         } else {
            ConfigManager.settings.BandanaTexture = 5;
         }
      }

      if (var1.id == 14) {
         if (ConfigManager.settings.WingsTexture <= 4) {
            ++ConfigManager.settings.WingsTexture;
         } else {
            ConfigManager.settings.WingsTexture = 1;
         }
      }

      if (var1.id == 15) {
         if (ConfigManager.settings.WingsTexture >= 2) {
            --ConfigManager.settings.WingsTexture;
         } else {
            ConfigManager.settings.WingsTexture = 5;
         }
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
