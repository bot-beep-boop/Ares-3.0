package com.aresclient.visuals;

import com.aresclient.visuals.utils.AnimatedButton;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class GuiIngameMenu extends GuiScreen {
   public static int prevFramerate = 0;
   int j = 1;
   private long nextUpdate = System.currentTimeMillis() + 3000L;
   int i = 0;

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

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

      if (var1.id == 6) {
         this.mc.displayGuiScreen(new GuiTimechanger());
      }

   }

   public void initGui() {
      super.initGui();
      int var1 = height / 10;
      int var2 = var1 * 3 - var1 / 2;
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
      this.buttonList.clear();
      this.buttonList.add(new AnimatedButton(1, 10 + this.i, var2 - var1 * 1, var1, var1, "Ares/Icons/Animated/Settings/Settings ("));
      this.buttonList.add(new AnimatedButton(2, 10 + this.i, var2, var1, var1, "Ares/Icons/Animated/Cosmetics/Cosmetics ("));
      this.buttonList.add(new AnimatedButton(3, 10 + this.i, var2 + var1 * 1, var1, var1, "Ares/Icons/Animated/Mods/Mods ("));
      this.buttonList.add(new AnimatedButton(4, 10 + this.i, var2 + var1 * 2, var1, var1, "Ares/Icons/Animated/Radio/Radio ("));
      this.buttonList.add(new AnimatedButton(5, 10 + this.i, var2 + var1 * 3, var1, var1, "Ares/Icons/Animated/Multiplayer/Multiplayer ("));
      this.buttonList.add(new AnimatedButton(6, 10 + this.i, var2 + var1 * 4, var1, var1, "Ares/Icons/Animated/Timechanger/Timechanger ("));
      this.buttonList.add(new AnimatedButton(7, 10 + this.i, var2 + var1 * 5, var1, var1, "Ares/Icons/Animated/Exit/Exit ("));
   }

   public void drawScreen(int var1, int var2, float var3) {
      super.drawScreen(var1, var2, var3);
   }

   private String getTime() {
      DateTimeFormatter var1 = DateTimeFormatter.ofPattern("h:mm a");
      LocalDateTime var2 = LocalDateTime.now();
      return var1.format(var2);
   }
}
