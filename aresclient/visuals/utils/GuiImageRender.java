package com.aresclient.visuals.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;

public class GuiImageRender {
   private static Minecraft mc = Minecraft.getMinecraft();

   public static void drawBackgroundPicture(int var0, int var1, String var2) {
      ScaledResolution var3 = new ScaledResolution(mc);
      ResourceLocation var4 = new ResourceLocation(var2);
      mc.getTextureManager().bindTexture(var4);
      Gui.drawModalRectWithCustomSizedTexture(0, 0, 0.0F, 0.0F, var3.getScaledWidth(), var3.getScaledHeight(), (float)var3.getScaledWidth(), (float)var3.getScaledHeight());
      Gui.drawRect(0, 0, var0, var1, 1073741824);
   }

   public static void drawPicture(int var0, int var1, int var2, int var3, String var4) {
      ResourceLocation var5 = new ResourceLocation(var4);
      mc.getTextureManager().bindTexture(var5);
      Gui.drawModalRectWithCustomSizedTexture(var0, var1, 0.0F, 0.0F, var2, var3, (float)var2, (float)var3);
   }
}
