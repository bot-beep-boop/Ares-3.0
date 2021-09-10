package com.aresclient.visuals.utils;

import com.aresclient.utils.config.ConfigManager;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.settings.KeyBinding;
import org.lwjgl.opengl.GL11;

public class Keystrokes {
   private Keystrokes.KeystrokesMode mode;

   public static void drawRoundedRect(int var0, int var1, int var2, int var3, float var4, int var5) {
      boolean var6 = true;
      float var7 = 5.0F;
      float var8 = (float)(var5 >> 24 & 255) / 255.0F;
      float var9 = (float)(var5 >> 16 & 255) / 255.0F;
      float var10 = (float)(var5 >> 8 & 255) / 255.0F;
      float var11 = (float)(var5 & 255) / 255.0F;
      GL11.glDisable(2884);
      GL11.glDisable(3553);
      GL11.glEnable(3042);
      GL11.glBlendFunc(770, 771);
      OpenGlHelper.glBlendFunc(770, 771, 1, 0);
      GL11.glColor4f(var9, var10, var11, var8);
      GL11.glBegin(5);
      GL11.glVertex2f((float)var0 + var4, (float)var1);
      GL11.glVertex2f((float)var0 + var4, (float)var3);
      GL11.glVertex2f((float)var2 - var4, (float)var1);
      GL11.glVertex2f((float)var2 - var4, (float)var3);
      GL11.glEnd();
      GL11.glBegin(5);
      GL11.glVertex2f((float)var0, (float)var1 + var4);
      GL11.glVertex2f((float)var0 + var4, (float)var1 + var4);
      GL11.glVertex2f((float)var0, (float)var3 - var4);
      GL11.glVertex2f((float)var0 + var4, (float)var3 - var4);
      GL11.glEnd();
      GL11.glBegin(5);
      GL11.glVertex2f((float)var2, (float)var1 + var4);
      GL11.glVertex2f((float)var2 - var4, (float)var1 + var4);
      GL11.glVertex2f((float)var2, (float)var3 - var4);
      GL11.glVertex2f((float)var2 - var4, (float)var3 - var4);
      GL11.glEnd();
      GL11.glBegin(6);
      float var12 = (float)var2 - var4;
      float var13 = (float)var1 + var4;
      GL11.glVertex2f(var12, var13);

      int var14;
      float var15;
      for(var14 = 0; var14 <= 18; ++var14) {
         var15 = (float)var14 * 5.0F;
         GL11.glVertex2f((float)((double)var12 + (double)var4 * Math.cos(Math.toRadians((double)var15))), (float)((double)var13 - (double)var4 * Math.sin(Math.toRadians((double)var15))));
      }

      GL11.glEnd();
      GL11.glBegin(6);
      var12 = (float)var0 + var4;
      var13 = (float)var1 + var4;
      GL11.glVertex2f(var12, var13);

      for(var14 = 0; var14 <= 18; ++var14) {
         var15 = (float)var14 * 5.0F;
         GL11.glVertex2f((float)((double)var12 - (double)var4 * Math.cos(Math.toRadians((double)var15))), (float)((double)var13 - (double)var4 * Math.sin(Math.toRadians((double)var15))));
      }

      GL11.glEnd();
      GL11.glBegin(6);
      var12 = (float)var0 + var4;
      var13 = (float)var3 - var4;
      GL11.glVertex2f(var12, var13);

      for(var14 = 0; var14 <= 18; ++var14) {
         var15 = (float)var14 * 5.0F;
         GL11.glVertex2f((float)((double)var12 - (double)var4 * Math.cos(Math.toRadians((double)var15))), (float)((double)var13 + (double)var4 * Math.sin(Math.toRadians((double)var15))));
      }

      GL11.glEnd();
      GL11.glBegin(6);
      var12 = (float)var2 - var4;
      var13 = (float)var3 - var4;
      GL11.glVertex2f(var12, var13);

      for(var14 = 0; var14 <= 18; ++var14) {
         var15 = (float)var14 * 5.0F;
         GL11.glVertex2f((float)((double)var12 + (double)var4 * Math.cos(Math.toRadians((double)var15))), (float)((double)var13 + (double)var4 * Math.sin(Math.toRadians((double)var15))));
      }

      GL11.glEnd();
      GL11.glEnable(3553);
      GL11.glEnable(2884);
      GL11.glDisable(3042);
   }

   public void draw(int var1, int var2) {
      this.mode = Keystrokes.KeystrokesMode.WASD;
      GL11.glPushMatrix();
      Keystrokes.Key[] var6;
      int var5 = (var6 = this.mode.getKeys()).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         Keystrokes.Key var3 = var6[var4];
         int var7 = this.getFontRenderer().getStringWidth(var3.getName());
         Gui.drawRect(var1 + var3.getX(), var2 + var3.getY(), var1 + var3.getX() + var3.getWidth(), var2 + var3.getY() + var3.getHeight(), var3.isDown() ? (new Color(255, 255, 255, 102)).getRGB() : (new Color(0, 0, 0, 150)).getRGB());
         this.getFontRenderer().drawString(var3.isDown() ? ConfigManager.settings.ModColor + var3.getName() : var3.getName(), var1 + var3.getX() + var3.getWidth() / 2 - var7 / 2, var2 + var3.getY() + var3.getHeight() / 2 - 4, Color.WHITE.getRGB());
         this.getFontRenderer().drawString("§f", var1 + var3.getX() + var3.getWidth() / 2 - var7 / 2, var2 + var3.getY() + var3.getHeight() / 2 + 4, -1);
      }

      GL11.glPopMatrix();
   }

   public Keystrokes() {
      this.mode = Keystrokes.KeystrokesMode.WASD;
   }

   public void setMode(Keystrokes.KeystrokesMode var1) {
      this.mode = var1;
   }

   public FontRenderer getFontRenderer() {
      return Minecraft.getMinecraft().fontRendererObj;
   }

   private static class Key {
      private static final Keystrokes.Key D;
      private final String name;
      private static final Keystrokes.Key RMB;
      private static final Keystrokes.Key W;
      private static final Keystrokes.Key S;
      private final int width;
      private final KeyBinding keyBind;
      private final int x;
      private final int y;
      private static final Keystrokes.Key LMB;
      private static final Keystrokes.Key A;
      private final boolean cps;
      private final int height;

      static {
         W = new Keystrokes.Key("W", Minecraft.getMinecraft().gameSettings.keyBindForward, 21, 1, 18, 18, false);
         A = new Keystrokes.Key("A", Minecraft.getMinecraft().gameSettings.keyBindLeft, 1, 21, 18, 18, false);
         S = new Keystrokes.Key("S", Minecraft.getMinecraft().gameSettings.keyBindBack, 21, 21, 18, 18, false);
         D = new Keystrokes.Key("D", Minecraft.getMinecraft().gameSettings.keyBindRight, 41, 21, 18, 18, false);
         LMB = new Keystrokes.Key("LMB", Minecraft.getMinecraft().gameSettings.keyBindAttack, 1, 41, 28, 18, true);
         RMB = new Keystrokes.Key("RMB", Minecraft.getMinecraft().gameSettings.keyBindUseItem, 31, 41, 28, 18, true);
      }

      public String getName() {
         return this.name;
      }

      static Keystrokes.Key access$0() {
         return W;
      }

      static Keystrokes.Key access$3() {
         return D;
      }

      static Keystrokes.Key access$2() {
         return S;
      }

      public boolean isDown() {
         return this.keyBind.isKeyDown();
      }

      public int getWidth() {
         return this.width;
      }

      static Keystrokes.Key access$1() {
         return A;
      }

      public int getY() {
         return this.y;
      }

      public Key(String var1, KeyBinding var2, int var3, int var4, int var5, int var6, boolean var7) {
         this.name = var1;
         this.keyBind = var2;
         this.x = var3;
         this.y = var4;
         this.width = var5;
         this.height = var6;
         this.cps = var7;
      }

      public int getHeight() {
         return this.height;
      }

      public int getX() {
         return this.x;
      }
   }

   public static enum KeystrokesMode {
      private int width = 0;
      WASD(new Keystrokes.Key[]{Keystrokes.Key.access$0(), Keystrokes.Key.access$1(), Keystrokes.Key.access$2(), Keystrokes.Key.access$3()});

      private final Keystrokes.Key[] keys;
      private static final Keystrokes.KeystrokesMode[] ENUM$VALUES = new Keystrokes.KeystrokesMode[]{WASD};
      private int height = 0;

      public int getHeight() {
         return this.height;
      }

      private KeystrokesMode(Keystrokes.Key... var3) {
         this.keys = var3;
         Keystrokes.Key[] var7;
         int var6 = (var7 = this.keys).length;

         for(int var5 = 0; var5 < var6; ++var5) {
            Keystrokes.Key var4 = var7[var5];
            this.width = Math.max(this.width, var4.getX() + var4.getWidth());
            this.height = Math.max(this.height, var4.getY() + var4.getHeight());
         }

      }

      public Keystrokes.Key[] getKeys() {
         return this.keys;
      }

      public int getWidth() {
         return this.width;
      }
   }
}
