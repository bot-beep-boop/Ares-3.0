package com.aresclient.utils;

import net.minecraft.client.renderer.OpenGlHelper;
import org.lwjgl.opengl.GL11;

public class UIUtils {
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
}
