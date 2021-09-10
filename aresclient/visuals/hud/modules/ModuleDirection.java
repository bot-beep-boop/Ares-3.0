package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

public class ModuleDirection extends MoveableModule {
   public static int yOffset;
   private static final int compassIndexDefault = 0;
   private static ScaledResolution scaledResolution;
   private static final String markerColorDefault = "c";
   public static boolean showInChat;
   private static final int yOffsetDefault = 2;
   public static boolean applyXOffsetToCenter;
   private static final boolean enabledDefault = true;
   public static String alignMode;
   public static int compassIndex;
   private static final boolean applyYOffsetToMiddleDefault = false;
   public static int xOffset;
   private static final int yOffsetBottominecraftenterDefault = 41;
   private static final String alignModeDefault = "topcenter";
   private static final boolean showInChatDefault = true;
   public static boolean applyYOffsetToMiddle;
   private static final boolean applyXOffsetToCenterDefault = false;
   private static final int xOffsetDefault = 2;
   public static String markerColor;
   public static boolean enabled;
   public static int yOffsetBottominecraftenter;

   static {
      scaledResolution = new ScaledResolution(minecraft);
      enabled = true;
      alignMode = "topcenter";
      markerColor = "c";
      compassIndex = 0;
      xOffset = 2;
      yOffset = 2;
      yOffsetBottominecraftenter = 41;
      applyXOffsetToCenter = false;
      applyYOffsetToMiddle = false;
      showInChat = true;
   }

   private static int getX(int var0) {
      return !alignMode.equalsIgnoreCase("topcenter") && !alignMode.equalsIgnoreCase("middlecenter") && !alignMode.equalsIgnoreCase("bottominecraftenter") ? (!alignMode.equalsIgnoreCase("topright") && !alignMode.equalsIgnoreCase("middleright") && !alignMode.equalsIgnoreCase("bottomright") ? xOffset : scaledResolution.getScaledWidth() - var0 - xOffset) : scaledResolution.getScaledWidth() / 2 - var0 / 2 + (applyXOffsetToCenter ? xOffset : 0);
   }

   public String getName() {
      return "Direction HUD";
   }

   public void render() {
      int var1 = MathHelper.floor_double((double)(minecraft.thePlayer.rotationYaw * 256.0F / 360.0F) + 0.5D) & 255;
      int var2 = this.getY();
      int var3 = this.getX();
      minecraft.getTextureManager().bindTexture(new ResourceLocation("Ares/direction/Colors/" + ConfigManager.settings.ModColor + ".png"));
      if (var1 < 128) {
         Gui.drawTexturedModalRect(var3, var2, var1, compassIndex * 24, 65, 12);
      } else {
         Gui.drawTexturedModalRect(var3, var2, var1 - 128, compassIndex * 24 + 12, 65, 12);
      }

      minecraft.fontRendererObj.drawString(ConfigManager.settings.ModColor + "|", var3 + 32, var2 + 1, 16777215);
      minecraft.fontRendererObj.drawString(ConfigManager.settings.ModColor + "|", var3 + 32, var2 + 4, 16777215);
   }

   private static int getY(int var0, int var1) {
      return !alignMode.equalsIgnoreCase("middleleft") && !alignMode.equalsIgnoreCase("middlecenter") && !alignMode.equalsIgnoreCase("middleright") ? (!alignMode.equalsIgnoreCase("bottomleft") && !alignMode.equalsIgnoreCase("bottomright") ? (alignMode.equalsIgnoreCase("bottominecraftenter") ? scaledResolution.getScaledHeight() - var0 * var1 - yOffsetBottominecraftenter : yOffset) : scaledResolution.getScaledHeight() - var0 * var1 - yOffset) : scaledResolution.getScaledHeight() / 2 - var0 * var1 / 2 + (applyYOffsetToMiddle ? yOffset : 0);
   }

   public int getWidth() {
      return 66;
   }

   public ModuleDirection(int var1, int var2) {
      super(var1, var2, true);
   }

   public int getHeight() {
      return 14;
   }
}
