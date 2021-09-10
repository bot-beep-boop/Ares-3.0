package com.aresclient.visuals;

import com.aresclient.visuals.utils.ImageButtonWithText;
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

public class GuiQuickSearch extends GuiScreen {
   private float oldMouseX;
   int i;
   int j;
   public static int prevFramerate = 0;
   private float oldMouseY;
   ScaledResolution scaledresolution = new ScaledResolution(Minecraft.getMinecraft());

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
   }

   private void updatebuttons() {
      int var1 = height / 10;
      int var2 = var1 * 3 - var1 / 2;
      this.buttonList.clear();
      int var3 = height / 8;
      int var4 = var3 * 3 - var3 / 2;
      this.buttonList.add(new ImageButtonWithText(8, width / 2 - var3 * 2, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/QuickSearch/bw8x1.png"), "Bedwars 8x1", "QuickJoin Bedwars 8x1"));
      this.buttonList.add(new ImageButtonWithText(9, width / 2 - var3, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/QuickSearch/bw8x2.png"), "Bedwars 8x2", "QuickJoin Bedwars 8x2"));
      this.buttonList.add(new ImageButtonWithText(10, width / 2, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/QuickSearch/bw4x3.png"), "Bedwars 4x3", "QuickJoin Bedwars 4x3"));
      this.buttonList.add(new ImageButtonWithText(11, width / 2 + var3, var4 - var3 * 1, var3, var3, new ResourceLocation("Ares/Icons/QuickSearch/bw4x4.png"), "Bedwars 4x4", "QuickJoin Bedwars 4x4"));
      this.buttonList.add(new ImageButtonWithText(12, width / 2 - var3 * 2, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/QuickSearch/SwSoloNormal.png"), "Skywars Solo Normal", "QuickJoin Skywars Solo Normal"));
      this.buttonList.add(new ImageButtonWithText(13, width / 2 - var3, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/QuickSearch/SwSoloInsane.png"), "Skywars Solo Insane", "QuickJoin Skywars Solo Insane"));
      this.buttonList.add(new ImageButtonWithText(14, width / 2, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/QuickSearch/SwTeamsNormal.png"), "Skywars Teams Normal", "QuickJoin Skywars Teams Normal"));
      this.buttonList.add(new ImageButtonWithText(15, width / 2 + var3, var4 - var3 * 0, var3, var3, new ResourceLocation("Ares/Icons/QuickSearch/SwTeamsInsane.png"), "Skywars Teams Insane", "QuickJoin Skywars Teams Insane"));
   }

   public void initGui() {
      prevFramerate = this.mc.gameSettings.limitFramerate;
      this.mc.gameSettings.limitFramerate = 60;
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
      super.initGui();
      this.updatebuttons();
   }

   protected void actionPerformed(GuiButton var1) throws IOException {
      if (var1.id == 8) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/play bedwars_eight_one");
      }

      if (var1.id == 9) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/play bedwars_eight_two");
      }

      if (var1.id == 10) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/play bedwars_four_three");
      }

      if (var1.id == 11) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/play bedwars_four_four");
      }

      if (var1.id == 12) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/play solo_normal");
      }

      if (var1.id == 13) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/play solo_insane");
      }

      if (var1.id == 14) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/play teams_normal");
      }

      if (var1.id == 15) {
         Minecraft.getMinecraft().thePlayer.sendChatMessage("/play teams_insane");
      }

   }

   public GuiQuickSearch() {
      this.i = this.scaledresolution.getScaledWidth();
      this.j = this.scaledresolution.getScaledHeight();
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
