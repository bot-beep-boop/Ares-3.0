package net.minecraft.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.IntBuffer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureUtil;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.event.ClickEvent;
import net.minecraft.src.Config;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

public class ScreenShotHelper {
   private static final Logger logger = LogManager.getLogger();
   private static IntBuffer pixelBuffer;
   private static int[] pixelValues;
   private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss");

   private static void updateFramebufferSize() {
      Minecraft var0 = Minecraft.getMinecraft();
      var0.getFramebuffer().createBindFramebuffer(var0.displayWidth, var0.displayHeight);
      if (var0.entityRenderer != null) {
         var0.entityRenderer.updateShaderGroupSize(var0.displayWidth, var0.displayHeight);
      }

   }

   private static void resize(int var0, int var1) {
      Minecraft var2 = Minecraft.getMinecraft();
      var2.displayWidth = Math.max(1, var0);
      var2.displayHeight = Math.max(1, var1);
      if (var2.currentScreen != null) {
         ScaledResolution var3 = new ScaledResolution(var2);
         var2.currentScreen.onResize(var2, var3.getScaledWidth(), var3.getScaledHeight());
      }

      updateFramebufferSize();
   }

   public static IChatComponent saveScreenshot(File var0, String var1, int var2, int var3, Framebuffer var4) {
      try {
         File var5 = new File(var0, "screenshots");
         var5.mkdir();
         Minecraft var6 = Minecraft.getMinecraft();
         int var7 = Config.getGameSettings().guiScale;
         ScaledResolution var8 = new ScaledResolution(var6);
         int var9 = var8.getScaleFactor();
         int var10 = Config.getScreenshotSize();
         boolean var11 = OpenGlHelper.isFramebufferEnabled() && var10 > 1;
         if (var11) {
            Config.getGameSettings().guiScale = var9 * var10;
            resize(var2 * var10, var3 * var10);
            GlStateManager.pushMatrix();
            GlStateManager.clear(16640);
            var6.getFramebuffer().bindFramebuffer(true);
            var6.entityRenderer.updateCameraAndRender(Config.renderPartialTicks, System.nanoTime());
         }

         if (OpenGlHelper.isFramebufferEnabled()) {
            var2 = var4.framebufferTextureWidth;
            var3 = var4.framebufferTextureHeight;
         }

         int var12 = var2 * var3;
         if (pixelBuffer == null || pixelBuffer.capacity() < var12) {
            pixelBuffer = BufferUtils.createIntBuffer(var12);
            pixelValues = new int[var12];
         }

         GL11.glPixelStorei(3333, 1);
         GL11.glPixelStorei(3317, 1);
         pixelBuffer.clear();
         if (OpenGlHelper.isFramebufferEnabled()) {
            GlStateManager.bindTexture(var4.framebufferTexture);
            GL11.glGetTexImage(3553, 0, 32993, 33639, pixelBuffer);
         } else {
            GL11.glReadPixels(0, 0, var2, var3, 32993, 33639, pixelBuffer);
         }

         pixelBuffer.get(pixelValues);
         TextureUtil.processPixelValues(pixelValues, var2, var3);
         BufferedImage var13 = null;
         if (OpenGlHelper.isFramebufferEnabled()) {
            var13 = new BufferedImage(var4.framebufferWidth, var4.framebufferHeight, 1);
            int var14 = var4.framebufferTextureHeight - var4.framebufferHeight;

            for(int var15 = var14; var15 < var4.framebufferTextureHeight; ++var15) {
               for(int var16 = 0; var16 < var4.framebufferWidth; ++var16) {
                  var13.setRGB(var16, var15 - var14, pixelValues[var15 * var4.framebufferTextureWidth + var16]);
               }
            }
         } else {
            var13 = new BufferedImage(var2, var3, 1);
            var13.setRGB(0, 0, var2, var3, pixelValues, 0, var2);
         }

         if (var11) {
            var6.getFramebuffer().unbindFramebuffer();
            GlStateManager.popMatrix();
            Config.getGameSettings().guiScale = var7;
            resize(var2, var3);
         }

         File var18;
         if (var1 == null) {
            var18 = getTimestampedPNGFileForDirectory(var5);
         } else {
            var18 = new File(var5, var1);
         }

         var18 = var18.getCanonicalFile();
         ImageIO.write(var13, "png", var18);
         ChatComponentText var19 = new ChatComponentText(var18.getName());
         var19.getChatStyle().setChatClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, var18.getAbsolutePath()));
         var19.getChatStyle().setUnderlined(true);
         return new ChatComponentTranslation("screenshot.success", new Object[]{var19});
      } catch (Exception var17) {
         logger.warn("Couldn't save screenshot", var17);
         return new ChatComponentTranslation("screenshot.failure", new Object[]{var17.getMessage()});
      }
   }

   public static IChatComponent saveScreenshot(File var0, int var1, int var2, Framebuffer var3) {
      return saveScreenshot(var0, (String)null, var1, var2, var3);
   }

   private static File getTimestampedPNGFileForDirectory(File var0) {
      String var1 = dateFormat.format(new Date()).toString();
      int var2 = 1;

      while(true) {
         File var3 = new File(var0, var1 + (var2 == 1 ? "" : "_" + var2) + ".png");
         if (!var3.exists()) {
            return var3;
         }

         ++var2;
      }
   }
}
