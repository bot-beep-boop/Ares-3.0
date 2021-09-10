package com.aresclient.visuals.hud.ui;

import com.aresclient.Ares;
import com.aresclient.utils.UIUtils;
import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import com.aresclient.visuals.utils.ImageButton;
import java.awt.Color;
import java.io.IOException;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class GuiHud extends GuiScreen {
   private int lastX;
   private int lastY;
   private Optional<MoveableModule> selectedModule;
   ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
   int i = -25;

   public GuiHud() {
      Iterator var2 = Ares.getHudConfig().moveableModules.iterator();

      while(var2.hasNext()) {
         MoveableModule var1 = (MoveableModule)var2.next();
         this.checkIfOutOfScreen(var1);
         var1.load();
      }

   }

   public void drawScreen(int var1, int var2, float var3) {
      int var4 = GuiScreen.height - GuiScreen.height / 4;
      this.drawVerticalLine(GuiScreen.width / 2, -1, GuiScreen.height - 30 - this.i, Color.white.getRGB());
      this.drawHorizontalLine(0, GuiScreen.width, GuiScreen.height / 2, Color.white.getRGB());
      if (var2 >= var4 && this.i < 0) {
         ++this.i;
      } else if (var2 <= var4 && this.i > -25) {
         --this.i;
      }

      int var5 = GuiScreen.height / 12;
      UIUtils.drawRoundedRect(GuiScreen.width / 2 - GuiScreen.width / 6 - var5, GuiScreen.height - 30 - this.i, GuiScreen.width / 2 + GuiScreen.width / 6 + var5, GuiScreen.height - 1 - this.i, (float)(9.0D / (double)this.sr.getScaleFactor()), (new Color(200, 200, 200, 150)).getRGB());
      int var6 = GuiScreen.width / 2;
      int var7 = GuiScreen.height;
      this.buttonList.clear();
      this.buttonList.add(new ImageButton(8, GuiScreen.width / 2 - var5 * 4, GuiScreen.height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/Yellow.png")));
      this.buttonList.add(new ImageButton(7, GuiScreen.width / 2 - var5 * 3, GuiScreen.height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/Green.png")));
      this.buttonList.add(new ImageButton(6, GuiScreen.width / 2 - var5 * 2, GuiScreen.height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/Red.png")));
      this.buttonList.add(new ImageButton(5, GuiScreen.width / 2 - var5 * 1, GuiScreen.height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/Magenta.png")));
      this.buttonList.add(new ImageButton(4, GuiScreen.width / 2 - var5 * 0, GuiScreen.height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/Blue.png")));
      this.buttonList.add(new ImageButton(3, GuiScreen.width / 2 + var5 * 1, GuiScreen.height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/Turquise.png")));
      this.buttonList.add(new ImageButton(2, GuiScreen.width / 2 + var5 * 2, GuiScreen.height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/Grey.png")));
      this.buttonList.add(new ImageButton(1, GuiScreen.width / 2 + var5 * 3, GuiScreen.height - var5 - var5 / 4 - this.i, var5, var5, new ResourceLocation("Ares/Icons/ColorPicker/White.png")));

      MoveableModule var8;
      for(Iterator var9 = Ares.getHudConfig().moveableModules.iterator(); var9.hasNext(); var8.onMove(var1, var2, this.lastX, this.lastY)) {
         var8 = (MoveableModule)var9.next();
         if (var8.position.visible) {
            this.drawHollowRect(var8.getX() - 2, var8.getY() - 2, var8.getWidth() + 1, var8.getHeight() + 1, Color.white.getRGB());
            Gui.drawRect(var8.getX() - 2, var8.getY() - 2, var8.getX() + var8.getWidth(), var8.getY() + var8.getHeight(), (new Color(200, 200, 200, 150)).getRGB());
         } else {
            Gui.drawRect(var8.getX() - 2, var8.getY() - 2, var8.getX() + var8.getWidth(), var8.getY() + var8.getHeight(), (new Color(200, 10, 10, 50)).getRGB());
            this.drawHollowRect(var8.getX() - 2, var8.getY() - 2, var8.getWidth() + 1, var8.getHeight() + 1, (new Color(200, 10, 10, 50)).getRGB());
         }

         if (var8.isRenderDummy()) {
            var8.renderDummy();
         } else {
            var8.render();
         }
      }

      this.lastX = var1;
      this.lastY = var2;
      super.drawScreen(var1, var2, var3);
   }

   private void checkIfOutOfScreen(MoveableModule var1) {
      if (var1.getX() == 0) {
         var1.position.setX(1);
         var1.position.setY(var1.getY());
      }

      if (var1.getY() == 0) {
         var1.position.setX(var1.getX());
         var1.position.setY(1);
      }

   }

   private void drawHollowRect(int var1, int var2, int var3, int var4, int var5) {
      this.drawHorizontalLine(var1, var1 + var3, var2, var5);
      this.drawHorizontalLine(var1, var1 + var3, var2 + var4, var5);
      this.drawVerticalLine(var1, var2 + var4, var2, var5);
      this.drawVerticalLine(var1 + var3, var2 + var4, var2, var5);
   }

   protected void mouseClicked(int var1, int var2, int var3) throws IOException {
      super.mouseClicked(var1, var2, var3);
      this.loadMouseOver(var1, var2);
      if (this.selectedModule != null && this.selectedModule.isPresent()) {
         ((MoveableModule)this.selectedModule.get()).onClick(var1, var2, var3);
      }

   }

   private void loadMouseOver(int var1, int var2) {
      this.selectedModule = Ares.getHudConfig().moveableModules.stream().filter(new GuiHud.MouseOverFinder(this, var1, var2)).findFirst();
   }

   protected void actionPerformed(GuiButton var1) {
      if (var1.id == 1) {
         ConfigManager.settings.ModColor = "§f";
      }

      if (var1.id == 2) {
         ConfigManager.settings.ModColor = "§8";
      }

      if (var1.id == 3) {
         ConfigManager.settings.ModColor = "§b";
      }

      if (var1.id == 4) {
         ConfigManager.settings.ModColor = "§9";
      }

      if (var1.id == 5) {
         ConfigManager.settings.ModColor = "§d";
      }

      if (var1.id == 6) {
         ConfigManager.settings.ModColor = "§c";
      }

      if (var1.id == 7) {
         ConfigManager.settings.ModColor = "§a";
      }

      if (var1.id == 8) {
         ConfigManager.settings.ModColor = "§e";
      }

   }

   public void initGui() {
      Minecraft.getMinecraft().entityRenderer.loadShader(new ResourceLocation("shaders/post/blur.json"));
      this.buttonList.clear();
   }

   public void onGuiClosed() {
      if (this.mc.thePlayer != null) {
         Minecraft.getMinecraft().entityRenderer.loadEntityShader((Entity)null);
         super.onGuiClosed();
      }

   }

   protected void mouseReleased(int var1, int var2, int var3) {
      super.mouseReleased(var1, var2, var3);
      Iterator var5 = Ares.getHudConfig().moveableModules.iterator();

      while(var5.hasNext()) {
         MoveableModule var4 = (MoveableModule)var5.next();
         var4.onRelease();
         var4.save(var4.position);
      }

   }

   private class MouseOverFinder implements Predicate<MoveableModule> {
      private int mouseX;
      private int mouseY;
      final GuiHud this$0;

      public MouseOverFinder(GuiHud var1, int var2, int var3) {
         this.this$0 = var1;
         this.mouseX = var2;
         this.mouseY = var3;
      }

      public boolean test(MoveableModule var1) {
         int var2 = var1.getX();
         int var3 = var1.getY();
         return this.mouseX >= var2 && this.mouseX <= var2 + var1.getWidth() && this.mouseY >= var3 && this.mouseY <= var3 + var1.getHeight();
      }

      public boolean test(Object var1) {
         return this.test((MoveableModule)var1);
      }
   }
}
