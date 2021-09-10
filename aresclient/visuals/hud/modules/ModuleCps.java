package com.aresclient.visuals.hud.modules;

import com.aresclient.utils.config.ConfigManager;
import com.aresclient.visuals.hud.base.impl.MoveableModule;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Mouse;

public class ModuleCps extends MoveableModule {
   private boolean wasPressed;
   private boolean wasPressed2;
   private long lastPressed;
   private List<Long> clicks2 = new ArrayList();
   private long lastPressed2;
   private List<Long> clicks = new ArrayList();

   public String getName() {
      return "Cps";
   }

   private static boolean lambda$1(long var0, Long var2) {
      return var2 + 1000L < var0;
   }

   public ModuleCps(int var1, int var2) {
      super(var1, var2, true);
   }

   private int getCPS() {
      long var1 = System.currentTimeMillis();
      this.clicks.removeIf(ModuleCps::lambda$0);
      long var3 = System.currentTimeMillis();
      this.clicks2.removeIf(ModuleCps::lambda$1);
      return this.clicks.size() + this.clicks2.size();
   }

   private static boolean lambda$0(long var0, Long var2) {
      return var2 + 1000L < var0;
   }

   public int getWidth() {
      return Minecraft.getMinecraft().fontRendererObj.getStringWidth("[" + ConfigManager.settings.ModColor + "CPS§f] " + this.getCPS());
   }

   public void render() {
      boolean var1 = Mouse.isButtonDown(0);
      boolean var2 = Mouse.isButtonDown(1);
      if (var1 != this.wasPressed) {
         this.lastPressed = System.currentTimeMillis() + 10L;
         this.wasPressed = var1;
         if (var1) {
            this.clicks.add(this.lastPressed);
         }
      }

      if (var2 != this.wasPressed2) {
         this.lastPressed2 = System.currentTimeMillis() + 10L;
         this.wasPressed2 = var2;
         if (var2) {
            this.clicks2.add(this.lastPressed2);
         }
      }

      Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow("[" + ConfigManager.settings.ModColor + "CPS§f] " + this.getCPS(), (float)this.getX(), (float)this.getY(), Color.white.getRGB());
   }

   public int getHeight() {
      return minecraft.fontRendererObj.FONT_HEIGHT;
   }
}
