package net.minecraft.src;

import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import net.minecraft.client.LoadingScreenRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.DefaultResourcePack;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.IResource;
import net.minecraft.client.resources.IResourceManager;
import net.minecraft.client.resources.IResourcePack;
import net.minecraft.client.resources.ResourcePackRepository;
import net.minecraft.client.resources.model.ModelManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.optifine.DynamicLights;
import net.optifine.GlErrors;
import net.optifine.VersionCheckThread;
import net.optifine.config.GlVersion;
import net.optifine.gui.GuiMessage;
import net.optifine.reflect.Reflector;
import net.optifine.reflect.ReflectorForge;
import net.optifine.shaders.Shaders;
import net.optifine.util.DisplayModeComparator;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.TextureUtils;
import net.optifine.util.TimedEvent;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.opengl.PixelFormat;

public class Config {
   private static int antialiasingLevel = 0;
   private static int availableProcessors = 0;
   private static String mcDebugLast = null;
   public static String openGlVendor = null;
   private static int fpsMinLast = 0;
   public static final String MC_VERSION = "1.8.9";
   private static Thread minecraftThread = null;
   private static boolean notify64BitJava = false;
   public static float renderPartialTicks;
   private static boolean fullscreenModeChecked = false;
   public static boolean zoomMode = false;
   public static final boolean logDetail = System.getProperty("log.detail", "false").equals("true");
   private static GameSettings gameSettings = null;
   public static GlVersion glslVersion = null;
   private static Minecraft minecraft = Minecraft.getMinecraft();
   private static boolean desktopModeChecked = false;
   private static DefaultResourcePack defaultResourcePackLazy = null;
   public static String openGlVersion = null;
   private static DisplayMode desktopDisplayMode = null;
   private static String newRelease = null;
   private static DisplayMode[] displayModes = null;
   public static final String OF_EDITION = "HD_U";
   private static String build = null;
   private static int texturePackClouds = 0;
   public static final String OF_NAME = "OptiFine";
   public static boolean fancyFogAvailable = false;
   public static GlVersion glVersion = null;
   public static String[] openGlExtensions = null;
   public static int minecraftVersionInt = -1;
   public static final String VERSION = "OptiFine_1.8.9_HD_U_L5";
   public static boolean waterOpacityChanged = false;
   public static boolean occlusionAvailable = false;
   public static final Float DEF_ALPHA_FUNC_LEVEL = 0.1F;
   private static final Logger LOGGER = LogManager.getLogger();
   public static String openGlRenderer = null;
   private static boolean initialized = false;
   public static final String OF_RELEASE = "L5";

   public static GlVersion parseGlVersion(String var0, GlVersion var1) {
      try {
         if (var0 == null) {
            return var1;
         } else {
            Pattern var2 = Pattern.compile("([0-9]+)\\.([0-9]+)(\\.([0-9]+))?(.+)?");
            Matcher var3 = var2.matcher(var0);
            if (!var3.matches()) {
               return var1;
            } else {
               int var4 = Integer.parseInt(var3.group(1));
               int var5 = Integer.parseInt(var3.group(2));
               int var6 = var3.group(4) != null ? Integer.parseInt(var3.group(4)) : 0;
               String var7 = var3.group(5);
               return new GlVersion(var4, var5, var6, var7);
            }
         }
      } catch (Exception var8) {
         var8.printStackTrace();
         return var1;
      }
   }

   public static float getAmbientOcclusionLevel() {
      return isShaders() && Shaders.aoLevel >= 0.0F ? Shaders.aoLevel : gameSettings.ofAoLevel;
   }

   public static boolean isNotify64BitJava() {
      return notify64BitJava;
   }

   public static float getFogStart() {
      return gameSettings.ofFogStart;
   }

   public static boolean isAlternateBlocks() {
      return gameSettings.ofAlternateBlocks;
   }

   public static int getAnisotropicFilterLevel() {
      return gameSettings.ofAfLevel;
   }

   public static String arrayToString(Object[] var0) {
      return arrayToString(var0, ", ");
   }

   public static String[] getDisplayModeNames() {
      DisplayMode[] var0 = getDisplayModes();
      String[] var1 = new String[var0.length];

      for(int var2 = 0; var2 < var0.length; ++var2) {
         DisplayMode var3 = var0[var2];
         String var4 = var3.getWidth() + "x" + var3.getHeight();
         var1[var2] = var4;
      }

      return var1;
   }

   public static boolean isSmoothBiomes() {
      return gameSettings.ofSmoothBiomes;
   }

   public static boolean between(int var0, int var1, int var2) {
      return var0 >= var1 && var0 <= var2;
   }

   public static String arrayToString(Object[] var0, String var1) {
      if (var0 == null) {
         return "";
      } else {
         StringBuffer var2 = new StringBuffer(var0.length * 5);

         for(int var3 = 0; var3 < var0.length; ++var3) {
            Object var4 = var0[var3];
            if (var3 > 0) {
               var2.append(var1);
            }

            var2.append(String.valueOf(var4));
         }

         return var2.toString();
      }
   }

   private static DisplayMode[] getDisplayModes(DisplayMode[] var0, Dimension var1) {
      ArrayList var2 = new ArrayList();

      for(int var3 = 0; var3 < var0.length; ++var3) {
         DisplayMode var4 = var0[var3];
         if ((double)var4.getWidth() == var1.getWidth() && (double)var4.getHeight() == var1.getHeight()) {
            var2.add(var4);
         }
      }

      DisplayMode[] var5 = (DisplayMode[])var2.toArray(new DisplayMode[var2.size()]);
      return var5;
   }

   public static boolean equalsOne(Object var0, Object[] var1) {
      if (var1 == null) {
         return false;
      } else {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            Object var3 = var1[var2];
            if (equals(var0, var3)) {
               return true;
            }
         }

         return false;
      }
   }

   public static boolean isShowCapes() {
      return gameSettings.ofShowCapes;
   }

   public static boolean isMoonTexture() {
      if (!isSunMoonEnabled()) {
         return false;
      } else {
         return !isShaders() || Shaders.isMoon();
      }
   }

   public static boolean isTimeDayOnly() {
      return gameSettings.ofTime == 1;
   }

   public static boolean isFireworkParticles() {
      return gameSettings.ofFireworkParticles;
   }

   public static boolean isSkyEnabled() {
      return gameSettings.ofSky;
   }

   public static RenderGlobal getRenderGlobal() {
      return minecraft.renderGlobal;
   }

   public static boolean isLazyChunkLoading() {
      return gameSettings.ofLazyChunkLoading;
   }

   public static boolean isDrippingWaterLava() {
      return gameSettings.ofDrippingWaterLava;
   }

   public static IResource getResource(ResourceLocation var0) throws IOException {
      return minecraft.getResourceManager().getResource(var0);
   }

   public static void checkDisplayMode() {
      try {
         if (minecraft.isFullScreen()) {
            if (fullscreenModeChecked) {
               return;
            }

            fullscreenModeChecked = true;
            desktopModeChecked = false;
            DisplayMode var0 = Display.getDisplayMode();
            Dimension var1 = getFullscreenDimension();
            if (var1 == null) {
               return;
            }

            if (var0.getWidth() == var1.width && var0.getHeight() == var1.height) {
               return;
            }

            DisplayMode var2 = getDisplayMode(var1);
            if (var2 == null) {
               return;
            }

            Display.setDisplayMode(var2);
            minecraft.displayWidth = Display.getDisplayMode().getWidth();
            minecraft.displayHeight = Display.getDisplayMode().getHeight();
            if (minecraft.displayWidth <= 0) {
               minecraft.displayWidth = 1;
            }

            if (minecraft.displayHeight <= 0) {
               minecraft.displayHeight = 1;
            }

            if (minecraft.currentScreen != null) {
               ScaledResolution var3 = new ScaledResolution(minecraft);
               int var4 = var3.getScaledWidth();
               int var5 = var3.getScaledHeight();
               minecraft.currentScreen.setWorldAndResolution(minecraft, var4, var5);
            }

            updateFramebufferSize();
            Display.setFullscreen(true);
            minecraft.gameSettings.updateVSync();
            GlStateManager.enableTexture2D();
         } else {
            if (desktopModeChecked) {
               return;
            }

            desktopModeChecked = true;
            fullscreenModeChecked = false;
            minecraft.gameSettings.updateVSync();
            Display.update();
            GlStateManager.enableTexture2D();
            Display.setResizable(false);
            Display.setResizable(true);
         }
      } catch (Exception var6) {
         var6.printStackTrace();
         gameSettings.ofFullscreenMode = "Default";
         gameSettings.saveOfOptions();
      }

   }

   public static String readInputStream(InputStream var0, String var1) throws IOException {
      InputStreamReader var2 = new InputStreamReader(var0, var1);
      BufferedReader var3 = new BufferedReader(var2);
      StringBuffer var4 = new StringBuffer();

      while(true) {
         String var5 = var3.readLine();
         if (var5 == null) {
            return var4.toString();
         }

         var4.append(var5);
         var4.append("\n");
      }
   }

   public static String getResourcePackNames() {
      if (minecraft.getResourcePackRepository() == null) {
         return "";
      } else {
         IResourcePack[] var0 = getResourcePacks();
         if (var0.length <= 0) {
            return getDefaultResourcePack().getPackName();
         } else {
            String[] var1 = new String[var0.length];

            for(int var2 = 0; var2 < var0.length; ++var2) {
               var1[var2] = var0[var2].getPackName();
            }

            String var3 = arrayToString((Object[])var1);
            return var3;
         }
      }
   }

   public static void error(String var0) {
      LOGGER.error("[OptiFine] " + var0);
   }

   public static boolean isSwampColors() {
      return gameSettings.ofSwampColors;
   }

   public static boolean isWeatherEnabled() {
      return gameSettings.ofWeather;
   }

   public static boolean isAnisotropicFiltering() {
      return getAnisotropicFilterLevel() > 1;
   }

   public static String getVersion() {
      return "OptiFine_1.8.9_HD_U_L5";
   }

   public static boolean isGeneratedLava() {
      return gameSettings.ofAnimatedLava == 1;
   }

   public static boolean isAnimatedPortal() {
      return gameSettings.ofAnimatedPortal;
   }

   public static Object[] removeObjectFromArray(Object[] var0, Object var1) {
      ArrayList var2 = new ArrayList(Arrays.asList(var0));
      var2.remove(var1);
      Object[] var3 = collectionToArray(var2, var0.getClass().getComponentType());
      return var3;
   }

   public static boolean isConnectedTexturesFancy() {
      return gameSettings.ofConnectedTextures == 2;
   }

   public static Object[] collectionToArray(Collection var0, Class var1) {
      if (var0 == null) {
         return null;
      } else if (var1 == null) {
         return null;
      } else if (var1.isPrimitive()) {
         throw new IllegalArgumentException("Can not make arrays with primitive elements (int, double), element class: " + var1);
      } else {
         Object[] var2 = (Object[])Array.newInstance(var1, var0.size());
         return var0.toArray(var2);
      }
   }

   public static boolean isAnimatedLava() {
      return gameSettings.ofAnimatedLava != 2;
   }

   public static boolean hasResource(ResourceLocation var0) {
      if (var0 == null) {
         return false;
      } else {
         IResourcePack var1 = getDefiningResourcePack(var0);
         return var1 != null;
      }
   }

   public static DisplayMode getDesktopDisplayMode() {
      return desktopDisplayMode;
   }

   public static String getOpenGlVersionString() {
      GlVersion var0 = getGlVersion();
      String var1 = var0.getMajor() + "." + var0.getMinor() + "." + var0.getRelease();
      return var1;
   }

   public static Object[] addObjectsToArray(Object[] var0, Object[] var1) {
      if (var0 == null) {
         throw new NullPointerException("The given array is NULL");
      } else if (var1.length == 0) {
         return var0;
      } else {
         int var2 = var0.length;
         int var3 = var2 + var1.length;
         Object[] var4 = (Object[])Array.newInstance(var0.getClass().getComponentType(), var3);
         System.arraycopy(var0, 0, var4, 0, var2);
         System.arraycopy(var1, 0, var4, var2, var1.length);
         return var4;
      }
   }

   public static String listToString(List var0, String var1) {
      if (var0 == null) {
         return "";
      } else {
         StringBuffer var2 = new StringBuffer(var0.size() * 5);

         for(int var3 = 0; var3 < var0.size(); ++var3) {
            Object var4 = var0.get(var3);
            if (var3 > 0) {
               var2.append(var1);
            }

            var2.append(String.valueOf(var4));
         }

         return var2.toString();
      }
   }

   public static boolean isAnimatedTextures() {
      return gameSettings.ofAnimatedTextures;
   }

   public static boolean isCloudsOff() {
      if (gameSettings.ofClouds != 0) {
         return gameSettings.ofClouds == 3;
      } else if (isShaders() && !Shaders.shaderPackClouds.isDefault()) {
         return Shaders.shaderPackClouds.isOff();
      } else if (texturePackClouds != 0) {
         return texturePackClouds == 3;
      } else {
         return false;
      }
   }

   public static boolean isCustomEntityModels() {
      return gameSettings.ofCustomEntityModels;
   }

   public static DisplayMode[] getDisplayModes() {
      if (displayModes == null) {
         try {
            DisplayMode[] var0 = Display.getAvailableDisplayModes();
            Set var1 = getDisplayModeDimensions(var0);
            ArrayList var2 = new ArrayList();
            Iterator var4 = var1.iterator();

            while(var4.hasNext()) {
               Dimension var3 = (Dimension)var4.next();
               DisplayMode[] var5 = getDisplayModes(var0, var3);
               DisplayMode var6 = getDisplayMode(var5, desktopDisplayMode);
               if (var6 != null) {
                  var2.add(var6);
               }
            }

            DisplayMode[] var8 = (DisplayMode[])var2.toArray(new DisplayMode[var2.size()]);
            Arrays.sort(var8, new DisplayModeComparator());
            return var8;
         } catch (Exception var7) {
            var7.printStackTrace();
            displayModes = new DisplayMode[]{desktopDisplayMode};
         }
      }

      return displayModes;
   }

   public static int getChunkViewDistance() {
      if (gameSettings == null) {
         return 10;
      } else {
         int var0 = gameSettings.renderDistanceChunks;
         return var0;
      }
   }

   public static void updateAvailableProcessors() {
      availableProcessors = Runtime.getRuntime().availableProcessors();
   }

   public static String readFile(File var0) throws IOException {
      FileInputStream var1 = new FileInputStream(var0);
      return readInputStream(var1, "ASCII");
   }

   public static boolean isDynamicLights() {
      return gameSettings.ofDynamicLights != 3;
   }

   public static boolean isAntialiasing() {
      return getAntialiasingLevel() > 0;
   }

   public static DynamicTexture getMojangLogoTexture(DynamicTexture var0) {
      try {
         ResourceLocation var1 = new ResourceLocation("textures/gui/title/mojang.png");
         InputStream var2 = getResourceStream(var1);
         if (var2 == null) {
            return var0;
         } else {
            BufferedImage var3 = ImageIO.read(var2);
            if (var3 == null) {
               return var0;
            } else {
               DynamicTexture var4 = new DynamicTexture(var3);
               return var4;
            }
         }
      } catch (Exception var5) {
         warn(var5.getClass().getName() + ": " + var5.getMessage());
         return var0;
      }
   }

   public static boolean isPortalParticles() {
      return gameSettings.ofPortalParticles;
   }

   public static boolean isFastRender() {
      return gameSettings.ofFastRender;
   }

   public static boolean isTimeNightOnly() {
      return gameSettings.ofTime == 2;
   }

   public static Minecraft getMinecraft() {
      return minecraft;
   }

   public static boolean isNaturalTextures() {
      return gameSettings.ofNaturalTextures;
   }

   public static boolean isAnimatedFlame() {
      return gameSettings.ofAnimatedFlame;
   }

   public static boolean isTreesFancy() {
      if (gameSettings.ofTrees == 0) {
         return gameSettings.fancyGraphics;
      } else {
         return gameSettings.ofTrees != 1;
      }
   }

   public static boolean isSunTexture() {
      if (!isSunMoonEnabled()) {
         return false;
      } else {
         return !isShaders() || Shaders.isSun();
      }
   }

   public static boolean isRandomEntities() {
      return gameSettings.ofRandomEntities;
   }

   public static GlVersion getGlslVersion() {
      if (glslVersion == null) {
         String var0 = GL11.glGetString(35724);
         glslVersion = parseGlVersion(var0, (GlVersion)null);
         if (glslVersion == null) {
            glslVersion = new GlVersion(1, 10);
         }
      }

      return glslVersion;
   }

   public static String[] getOpenGlExtensions() {
      if (openGlExtensions == null) {
         openGlExtensions = detectOpenGlExtensions();
      }

      return openGlExtensions;
   }

   public static boolean isAnimatedWater() {
      return gameSettings.ofAnimatedWater != 2;
   }

   public static boolean isShowGlErrors() {
      return gameSettings.ofShowGlErrors;
   }

   private Config() {
   }

   public static boolean isAnimatedExplosion() {
      return gameSettings.ofAnimatedExplosion;
   }

   public static float limitTo1(float var0) {
      if (var0 < 0.0F) {
         return 0.0F;
      } else {
         return var0 > 1.0F ? 1.0F : var0;
      }
   }

   public static void checkInitialized() {
      if (!initialized && Display.isCreated()) {
         initialized = true;
         checkOpenGlCaps();
         startVersionCheckThread();
      }

   }

   public static boolean isDynamicUpdates() {
      return gameSettings.ofChunkUpdatesDynamic;
   }

   public static boolean isSameOne(Object var0, Object[] var1) {
      if (var1 == null) {
         return false;
      } else {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            Object var3 = var1[var2];
            if (var0 == var3) {
               return true;
            }
         }

         return false;
      }
   }

   public static boolean isMultiTexture() {
      if (getAnisotropicFilterLevel() > 1) {
         return true;
      } else {
         return getAntialiasingLevel() > 0;
      }
   }

   public static int parseInt(String var0, int var1) {
      try {
         if (var0 == null) {
            return var1;
         } else {
            var0 = var0.trim();
            return Integer.parseInt(var0);
         }
      } catch (NumberFormatException var3) {
         return var1;
      }
   }

   public static TextureManager getTextureManager() {
      return minecraft.getTextureManager();
   }

   public static boolean parseBoolean(String var0, boolean var1) {
      try {
         if (var0 == null) {
            return var1;
         } else {
            var0 = var0.trim();
            return Boolean.parseBoolean(var0);
         }
      } catch (NumberFormatException var3) {
         return var1;
      }
   }

   public static double limit(double var0, double var2, double var4) {
      if (var0 < var2) {
         return var2;
      } else {
         return var0 > var4 ? var4 : var0;
      }
   }

   public static String arrayToString(float[] var0, String var1) {
      if (var0 == null) {
         return "";
      } else {
         StringBuffer var2 = new StringBuffer(var0.length * 5);

         for(int var3 = 0; var3 < var0.length; ++var3) {
            float var4 = var0[var3];
            if (var3 > 0) {
               var2.append(var1);
            }

            var2.append(String.valueOf(var4));
         }

         return var2.toString();
      }
   }

   public static boolean isAnimatedTerrain() {
      return gameSettings.ofAnimatedTerrain;
   }

   public static DisplayMode getDisplayMode(Dimension var0) throws LWJGLException {
      DisplayMode[] var1 = getDisplayModes();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         DisplayMode var3 = var1[var2];
         if (var3.getWidth() == var0.width && var3.getHeight() == var0.height) {
            return var3;
         }
      }

      return desktopDisplayMode;
   }

   public static int[] addIntToArray(int[] var0, int var1) {
      return addIntsToArray(var0, new int[]{var1});
   }

   public static DefaultResourcePack getDefaultResourcePack() {
      if (defaultResourcePackLazy == null) {
         Minecraft var0 = Minecraft.getMinecraft();
         defaultResourcePackLazy = (DefaultResourcePack)Reflector.getFieldValue(var0, Reflector.Minecraft_defaultResourcePack);
         if (defaultResourcePackLazy == null) {
            ResourcePackRepository var1 = var0.getResourcePackRepository();
            if (var1 != null) {
               defaultResourcePackLazy = (DefaultResourcePack)var1.rprDefaultResourcePack;
            }
         }
      }

      return defaultResourcePackLazy;
   }

   public static void log(String var0) {
      dbg(var0);
   }

   public static boolean isCustomItems() {
      return gameSettings.ofCustomItems;
   }

   public static DisplayMode getLargestDisplayMode() {
      DisplayMode[] var0 = getDisplayModes();
      if (var0 != null && var0.length >= 1) {
         DisplayMode var1 = var0[var0.length - 1];
         if (desktopDisplayMode.getWidth() > var1.getWidth()) {
            return desktopDisplayMode;
         } else {
            return desktopDisplayMode.getWidth() == var1.getWidth() && desktopDisplayMode.getHeight() > var1.getHeight() ? desktopDisplayMode : var1;
         }
      } else {
         return desktopDisplayMode;
      }
   }

   public static boolean isCustomColors() {
      return gameSettings.ofCustomColors;
   }

   public static void checkGlError(String var0) {
      int var1 = GlStateManager.glGetError();
      if (var1 != 0 && GlErrors.isEnabled(var1)) {
         String var2 = getGlErrorString(var1);
         String var3 = String.format("OpenGL error: %s (%s), at: %s", var1, var2, var0);
         error(var3);
         if (isShowGlErrors() && TimedEvent.isActive("ShowGlError", 10000L)) {
            String var4 = I18n.format("of.message.openglError", var1, var2);
            minecraft.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(var4));
         }
      }

   }

   public static IResourceManager getResourceManager() {
      return minecraft.getResourceManager();
   }

   public static boolean between(float var0, float var1, float var2) {
      return var0 >= var1 && var0 <= var2;
   }

   public static boolean isBetterSnow() {
      return gameSettings.ofBetterSnow;
   }

   public static String arrayToString(float[] var0) {
      return arrayToString(var0, ", ");
   }

   public static boolean isFancyFogAvailable() {
      return fancyFogAvailable;
   }

   public static InputStream getResourceStream(IResourceManager var0, ResourceLocation var1) throws IOException {
      IResource var2 = var0.getResource(var1);
      return var2 == null ? null : var2.getInputStream();
   }

   public static int getRandom(BlockPos var0, int var1) {
      int var2 = intHash(var1 + 37);
      var2 = intHash(var2 + var0.getX());
      var2 = intHash(var2 + var0.getZ());
      var2 = intHash(var2 + var0.getY());
      return var2;
   }

   public static int getMipmapLevels() {
      return gameSettings.mipmapLevels;
   }

   public static boolean isDynamicFov() {
      return gameSettings.ofDynamicFov;
   }

   public static Dimension getFullscreenDimension() {
      if (desktopDisplayMode == null) {
         return null;
      } else if (gameSettings == null) {
         return new Dimension(desktopDisplayMode.getWidth(), desktopDisplayMode.getHeight());
      } else {
         String var0 = gameSettings.ofFullscreenMode;
         if (var0.equals("Default")) {
            return new Dimension(desktopDisplayMode.getWidth(), desktopDisplayMode.getHeight());
         } else {
            String[] var1 = tokenize(var0, " x");
            return var1.length < 2 ? new Dimension(desktopDisplayMode.getWidth(), desktopDisplayMode.getHeight()) : new Dimension(parseInt(var1[0], -1), parseInt(var1[1], -1));
         }
      }
   }

   private static void startVersionCheckThread() {
      VersionCheckThread var0 = new VersionCheckThread();
      var0.start();
   }

   public static void checkDisplaySettings() {
      int var0 = getAntialiasingLevel();
      if (var0 > 0) {
         DisplayMode var1 = Display.getDisplayMode();
         dbg("FSAA Samples: " + var0);

         try {
            Display.destroy();
            Display.setDisplayMode(var1);
            Display.create((new PixelFormat()).withDepthBits(24).withSamples(var0));
            Display.setResizable(false);
            Display.setResizable(true);
         } catch (LWJGLException var15) {
            warn("Error setting FSAA: " + var0 + "x");
            var15.printStackTrace();

            try {
               Display.setDisplayMode(var1);
               Display.create((new PixelFormat()).withDepthBits(24));
               Display.setResizable(false);
               Display.setResizable(true);
            } catch (LWJGLException var14) {
               var14.printStackTrace();

               try {
                  Display.setDisplayMode(var1);
                  Display.create();
                  Display.setResizable(false);
                  Display.setResizable(true);
               } catch (LWJGLException var13) {
                  var13.printStackTrace();
               }
            }
         }

         if (!Minecraft.isRunningOnMac && getDefaultResourcePack() != null) {
            InputStream var2 = null;
            InputStream var3 = null;

            try {
               var2 = getDefaultResourcePack().getInputStreamAssets(new ResourceLocation("icons/icon_16x16.png"));
               var3 = getDefaultResourcePack().getInputStreamAssets(new ResourceLocation("icons/icon_32x32.png"));
               if (var2 != null && var3 != null) {
                  Display.setIcon(new ByteBuffer[]{readIconImage(var2), readIconImage(var3)});
               }
            } catch (IOException var11) {
               warn("Error setting window icon: " + var11.getClass().getName() + ": " + var11.getMessage());
            } finally {
               IOUtils.closeQuietly(var2);
               IOUtils.closeQuietly(var3);
            }
         }
      }

   }

   private static void checkOpenGlCaps() {
      log("");
      log(getVersion());
      log("Build: " + getBuild());
      log("OS: " + System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version"));
      log("Java: " + System.getProperty("java.version") + ", " + System.getProperty("java.vendor"));
      log("VM: " + System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor"));
      log("LWJGL: " + Sys.getVersion());
      openGlVersion = GL11.glGetString(7938);
      openGlRenderer = GL11.glGetString(7937);
      openGlVendor = GL11.glGetString(7936);
      log("OpenGL: " + openGlRenderer + ", version " + openGlVersion + ", " + openGlVendor);
      log("OpenGL Version: " + getOpenGlVersionString());
      if (!GLContext.getCapabilities().OpenGL12) {
         log("OpenGL Mipmap levels: Not available (GL12.GL_TEXTURE_MAX_LEVEL)");
      }

      fancyFogAvailable = GLContext.getCapabilities().GL_NV_fog_distance;
      if (!fancyFogAvailable) {
         log("OpenGL Fancy fog: Not available (GL_NV_fog_distance)");
      }

      occlusionAvailable = GLContext.getCapabilities().GL_ARB_occlusion_query;
      if (!occlusionAvailable) {
         log("OpenGL Occlussion culling: Not available (GL_ARB_occlusion_query)");
      }

      int var0 = TextureUtils.getGLMaximumTextureSize();
      dbg("Maximum texture size: " + var0 + "x" + var0);
   }

   public static boolean isMinecraftThread() {
      return Thread.currentThread() == minecraftThread;
   }

   public static void dbg(String var0) {
      LOGGER.info("[OptiFine] " + var0);
   }

   public static IResourcePack getDefiningResourcePack(ResourceLocation var0) {
      ResourcePackRepository var1 = minecraft.getResourcePackRepository();
      IResourcePack var2 = var1.getResourcePackInstance();
      if (var2 != null && var2.resourceExists(var0)) {
         return var2;
      } else {
         List var3 = var1.repositoryEntries;

         for(int var4 = var3.size() - 1; var4 >= 0; --var4) {
            ResourcePackRepository.Entry var5 = (ResourcePackRepository.Entry)var3.get(var4);
            IResourcePack var6 = var5.getResourcePack();
            if (var6.resourceExists(var0)) {
               return var6;
            }
         }

         return getDefaultResourcePack().resourceExists(var0) ? getDefaultResourcePack() : null;
      }
   }

   public static String[] readLines(File var0) throws IOException {
      FileInputStream var1 = new FileInputStream(var0);
      return readLines((InputStream)var1);
   }

   public static IResourcePack[] getResourcePacks() {
      ResourcePackRepository var0 = minecraft.getResourcePackRepository();
      List var1 = var0.getRepositoryEntries();
      ArrayList var2 = new ArrayList();
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         Object var3 = var4.next();
         ResourcePackRepository.Entry var5 = (ResourcePackRepository.Entry)var3;
         var2.add(var5.getResourcePack());
      }

      if (var0.getResourcePackInstance() != null) {
         var2.add(var0.getResourcePackInstance());
      }

      IResourcePack[] var6 = (IResourcePack[])var2.toArray(new IResourcePack[var2.size()]);
      return var6;
   }

   public static int getMipmapType() {
      switch(gameSettings.ofMipmapType) {
      case 0:
         return 9986;
      case 1:
         return 9986;
      case 2:
         if (isMultiTexture()) {
            return 9985;
         }

         return 9986;
      case 3:
         if (isMultiTexture()) {
            return 9987;
         }

         return 9986;
      default:
         return 9986;
      }
   }

   public static String arrayToString(boolean[] var0, String var1) {
      if (var0 == null) {
         return "";
      } else {
         StringBuffer var2 = new StringBuffer(var0.length * 5);

         for(int var3 = 0; var3 < var0.length; ++var3) {
            boolean var4 = var0[var3];
            if (var3 > 0) {
               var2.append(var1);
            }

            var2.append(String.valueOf(var4));
         }

         return var2.toString();
      }
   }

   public static boolean isBetterGrass() {
      return gameSettings.ofBetterGrass != 3;
   }

   public static TextureMap getTextureMap() {
      return getMinecraft().getTextureMapBlocks();
   }

   public static void warn(String var0) {
      LOGGER.warn("[OptiFine] " + var0);
   }

   private static ByteBuffer readIconImage(InputStream var0) throws IOException {
      BufferedImage var1 = ImageIO.read(var0);
      int[] var2 = var1.getRGB(0, 0, var1.getWidth(), var1.getHeight(), (int[])null, 0, var1.getWidth());
      ByteBuffer var3 = ByteBuffer.allocate(4 * var2.length);
      int[] var7 = var2;
      int var6 = var2.length;

      for(int var5 = 0; var5 < var6; ++var5) {
         int var4 = var7[var5];
         var3.putInt(var4 << 8 | var4 >> 24 & 255);
      }

      var3.flip();
      return var3;
   }

   public static boolean hasResource(IResourceManager var0, ResourceLocation var1) {
      try {
         IResource var2 = var0.getResource(var1);
         return var2 != null;
      } catch (IOException var3) {
         return false;
      }
   }

   private static String[] detectOpenGlExtensions() {
      try {
         GlVersion var0 = getGlVersion();
         if (var0.getMajor() >= 3) {
            int var1 = GL11.glGetInteger(33309);
            if (var1 > 0) {
               String[] var2 = new String[var1];

               for(int var3 = 0; var3 < var1; ++var3) {
                  var2[var3] = GL30.glGetStringi(7939, var3);
               }

               return var2;
            }
         }
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      try {
         String var6 = GL11.glGetString(7939);
         String[] var7 = var6.split(" ");
         return var7;
      } catch (Exception var4) {
         var4.printStackTrace();
         return new String[0];
      }
   }

   public static boolean isCloudsFancy() {
      if (gameSettings.ofClouds != 0) {
         return gameSettings.ofClouds == 2;
      } else if (isShaders() && !Shaders.shaderPackClouds.isDefault()) {
         return Shaders.shaderPackClouds.isFancy();
      } else if (texturePackClouds != 0) {
         return texturePackClouds == 2;
      } else {
         return gameSettings.fancyGraphics;
      }
   }

   public static boolean isCustomGuis() {
      return gameSettings.ofCustomGuis;
   }

   public static boolean isUseAlphaFunc() {
      float var0 = getAlphaFuncLevel();
      return var0 > DEF_ALPHA_FUNC_LEVEL + 1.0E-5F;
   }

   public static boolean isIntegratedServerRunning() {
      return minecraft.getIntegratedServer() == null ? false : minecraft.isIntegratedServerRunning();
   }

   public static void updateTexturePackClouds() {
      texturePackClouds = 0;
      IResourceManager var0 = getResourceManager();
      if (var0 != null) {
         try {
            InputStream var1 = var0.getResource(new ResourceLocation("mcpatcher/color.properties")).getInputStream();
            if (var1 == null) {
               return;
            }

            PropertiesOrdered var2 = new PropertiesOrdered();
            var2.load(var1);
            var1.close();
            String var3 = var2.getProperty("clouds");
            if (var3 == null) {
               return;
            }

            dbg("Texture pack clouds: " + var3);
            var3 = var3.toLowerCase();
            if (var3.equals("fast")) {
               texturePackClouds = 1;
            }

            if (var3.equals("fancy")) {
               texturePackClouds = 2;
            }

            if (var3.equals("off")) {
               texturePackClouds = 3;
            }
         } catch (Exception var4) {
         }
      }

   }

   public static boolean isVignetteEnabled() {
      if (isShaders() && !Shaders.isVignette()) {
         return false;
      } else if (gameSettings.ofVignette == 0) {
         return gameSettings.fancyGraphics;
      } else {
         return gameSettings.ofVignette == 2;
      }
   }

   public static int getBitsOs() {
      String var0 = System.getenv("ProgramFiles(X86)");
      return var0 != null ? 64 : 32;
   }

   public static boolean isEmissiveTextures() {
      return gameSettings.ofEmissiveTextures;
   }

   private static GlVersion getGlVersionLwjgl() {
      if (GLContext.getCapabilities().OpenGL44) {
         return new GlVersion(4, 4);
      } else if (GLContext.getCapabilities().OpenGL43) {
         return new GlVersion(4, 3);
      } else if (GLContext.getCapabilities().OpenGL42) {
         return new GlVersion(4, 2);
      } else if (GLContext.getCapabilities().OpenGL41) {
         return new GlVersion(4, 1);
      } else if (GLContext.getCapabilities().OpenGL40) {
         return new GlVersion(4, 0);
      } else if (GLContext.getCapabilities().OpenGL33) {
         return new GlVersion(3, 3);
      } else if (GLContext.getCapabilities().OpenGL32) {
         return new GlVersion(3, 2);
      } else if (GLContext.getCapabilities().OpenGL31) {
         return new GlVersion(3, 1);
      } else if (GLContext.getCapabilities().OpenGL30) {
         return new GlVersion(3, 0);
      } else if (GLContext.getCapabilities().OpenGL21) {
         return new GlVersion(2, 1);
      } else if (GLContext.getCapabilities().OpenGL20) {
         return new GlVersion(2, 0);
      } else if (GLContext.getCapabilities().OpenGL15) {
         return new GlVersion(1, 5);
      } else if (GLContext.getCapabilities().OpenGL14) {
         return new GlVersion(1, 4);
      } else if (GLContext.getCapabilities().OpenGL13) {
         return new GlVersion(1, 3);
      } else if (GLContext.getCapabilities().OpenGL12) {
         return new GlVersion(1, 2);
      } else {
         return GLContext.getCapabilities().OpenGL11 ? new GlVersion(1, 1) : new GlVersion(1, 0);
      }
   }

   public static boolean openWebLink(URI var0) {
      try {
         Desktop.getDesktop().browse(var0);
         return true;
      } catch (Exception var2) {
         warn("Error opening link: " + var0);
         warn(var2.getClass().getName() + ": " + var2.getMessage());
         return false;
      }
   }

   public static void initDisplay() {
      antialiasingLevel = gameSettings.ofAaLevel;
      checkDisplaySettings();
      checkDisplayMode();
      minecraftThread = Thread.currentThread();
      updateThreadPriorities();
      Shaders.startup(Minecraft.getMinecraft());
   }

   public static void updateFramebufferSize() {
      minecraft.getFramebuffer().createBindFramebuffer(minecraft.displayWidth, minecraft.displayHeight);
      if (minecraft.entityRenderer != null) {
         minecraft.entityRenderer.updateShaderGroupSize(minecraft.displayWidth, minecraft.displayHeight);
      }

      minecraft.loadingScreen = new LoadingScreenRenderer(minecraft);
   }

   public static boolean isCustomSky() {
      return gameSettings.ofCustomSky;
   }

   public static boolean isTreesSmart() {
      return gameSettings.ofTrees == 4;
   }

   public static boolean isSmoothWorld() {
      return gameSettings.ofSmoothWorld;
   }

   public static Object[] addObjectToArray(Object[] var0, Object var1) {
      if (var0 == null) {
         throw new NullPointerException("The given array is NULL");
      } else {
         int var2 = var0.length;
         int var3 = var2 + 1;
         Object[] var4 = (Object[])Array.newInstance(var0.getClass().getComponentType(), var3);
         System.arraycopy(var0, 0, var4, 0, var2);
         var4[var2] = var1;
         return var4;
      }
   }

   public static int getMinecraftVersionInt() {
      if (minecraftVersionInt < 0) {
         String[] var0 = tokenize("1.8.9", ".");
         int var1 = 0;
         if (var0.length > 0) {
            var1 += 10000 * parseInt(var0[0], 0);
         }

         if (var0.length > 1) {
            var1 += 100 * parseInt(var0[1], 0);
         }

         if (var0.length > 2) {
            var1 += 1 * parseInt(var0[2], 0);
         }

         minecraftVersionInt = var1;
      }

      return minecraftVersionInt;
   }

   public static boolean isAntialiasingConfigured() {
      return getGameSettings().ofAaLevel > 0;
   }

   public static boolean isFogFancy() {
      if (!isFancyFogAvailable()) {
         return false;
      } else {
         return gameSettings.ofFogType == 2;
      }
   }

   public static void writeFile(File var0, String var1) throws IOException {
      FileOutputStream var2 = new FileOutputStream(var0);
      byte[] var3 = var1.getBytes("ASCII");
      var2.write(var3);
      var2.close();
   }

   public static float getAlphaFuncLevel() {
      return DEF_ALPHA_FUNC_LEVEL;
   }

   public static String getVersionDebug() {
      StringBuffer var0 = new StringBuffer(32);
      if (isDynamicLights()) {
         var0.append("DL: ");
         var0.append(String.valueOf(DynamicLights.getCount()));
         var0.append(", ");
      }

      var0.append("OptiFine_1.8.9_HD_U_L5");
      String var1 = Shaders.getShaderPackName();
      if (var1 != null) {
         var0.append(", ");
         var0.append(var1);
      }

      return var0.toString();
   }

   public static boolean isWaterParticles() {
      return gameSettings.ofWaterParticles;
   }

   public static boolean isTimeDefault() {
      return gameSettings.ofTime == 0;
   }

   public static void setNewRelease(String var0) {
      newRelease = var0;
   }

   public static int getScreenshotSize() {
      return gameSettings.ofScreenshotSize;
   }

   public static InputStream getResourceStream(ResourceLocation var0) throws IOException {
      return getResourceStream(minecraft.getResourceManager(), var0);
   }

   public static String getNewRelease() {
      return newRelease;
   }

   public static boolean isSmoothFps() {
      return gameSettings.ofSmoothFps;
   }

   private static DisplayMode getDisplayMode(DisplayMode[] var0, DisplayMode var1) {
      if (var1 != null) {
         for(int var2 = 0; var2 < var0.length; ++var2) {
            DisplayMode var3 = var0[var2];
            if (var3.getBitsPerPixel() == var1.getBitsPerPixel() && var3.getFrequency() == var1.getFrequency()) {
               return var3;
            }
         }
      }

      if (var0.length <= 0) {
         return null;
      } else {
         Arrays.sort(var0, new DisplayModeComparator());
         return var0[var0.length - 1];
      }
   }

   private static String getUpdates(String var0) {
      int var1 = var0.indexOf(40);
      if (var1 < 0) {
         return "";
      } else {
         int var2 = var0.indexOf(32, var1);
         return var2 < 0 ? "" : var0.substring(var1 + 1, var2);
      }
   }

   public static boolean isAnimatedFire() {
      return gameSettings.ofAnimatedFire;
   }

   public static int getAntialiasingLevel() {
      return antialiasingLevel;
   }

   public static String[] readLines(InputStream var0) throws IOException {
      ArrayList var1 = new ArrayList();
      InputStreamReader var2 = new InputStreamReader(var0, "ASCII");
      BufferedReader var3 = new BufferedReader(var2);

      while(true) {
         String var4 = var3.readLine();
         if (var4 == null) {
            String[] var5 = (String[])var1.toArray(new String[var1.size()]);
            return var5;
         }

         var1.add(var4);
      }
   }

   public static float limit(float var0, float var1, float var2) {
      if (var0 < var1) {
         return var1;
      } else {
         return var0 > var2 ? var2 : var0;
      }
   }

   public static boolean isRainOff() {
      return gameSettings.ofRain == 3;
   }

   public static boolean isDroppedItemsFancy() {
      if (gameSettings.ofDroppedItems == 0) {
         return gameSettings.fancyGraphics;
      } else {
         return gameSettings.ofDroppedItems == 2;
      }
   }

   public static boolean isFogFast() {
      return gameSettings.ofFogType == 1;
   }

   public static boolean isFogOff() {
      return gameSettings.ofFogType == 3;
   }

   public static boolean isTranslucentBlocksFancy() {
      if (gameSettings.ofTranslucentBlocks == 0) {
         return gameSettings.fancyGraphics;
      } else {
         return gameSettings.ofTranslucentBlocks == 2;
      }
   }

   public static boolean isRainFancy() {
      if (gameSettings.ofRain == 0) {
         return gameSettings.fancyGraphics;
      } else {
         return gameSettings.ofRain == 2;
      }
   }

   public static boolean isBetterGrassFancy() {
      return gameSettings.ofBetterGrass == 2;
   }

   public static boolean equalsOne(int var0, int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] == var0) {
            return true;
         }
      }

      return false;
   }

   public static boolean isGeneratedWater() {
      return gameSettings.ofAnimatedWater == 1;
   }

   public static void drawFps() {
      int var0 = Minecraft.getDebugFPS();
      String var1 = getUpdates(minecraft.debug);
      int var2 = minecraft.renderGlobal.getCountActiveRenderers();
      int var3 = minecraft.renderGlobal.getCountEntitiesRendered();
      int var4 = minecraft.renderGlobal.getCountTileEntitiesRendered();
      String var5 = var0 + "/" + getFpsMin() + " fps, C: " + var2 + ", E: " + var3 + "+" + var4 + ", U: " + var1;
      minecraft.fontRendererObj.drawString(var5, 2, 2, -2039584);
   }

   public static boolean isCustomFonts() {
      return gameSettings.ofCustomFonts;
   }

   public static void sleep(long var0) {
      try {
         Thread.sleep(var0);
      } catch (InterruptedException var3) {
         var3.printStackTrace();
      }

   }

   public static String listToString(List var0) {
      return listToString(var0, ", ");
   }

   public static String arrayToString(int[] var0, String var1) {
      if (var0 == null) {
         return "";
      } else {
         StringBuffer var2 = new StringBuffer(var0.length * 5);

         for(int var3 = 0; var3 < var0.length; ++var3) {
            int var4 = var0[var3];
            if (var3 > 0) {
               var2.append(var1);
            }

            var2.append(String.valueOf(var4));
         }

         return var2.toString();
      }
   }

   public static boolean isSingleProcessor() {
      return getAvailableProcessors() <= 1;
   }

   public static boolean isQuadsToTriangles() {
      if (!isShaders()) {
         return false;
      } else {
         return !Shaders.canRenderQuads();
      }
   }

   public static int getFpsMin() {
      if (minecraft.debug == mcDebugLast) {
         return fpsMinLast;
      } else {
         mcDebugLast = minecraft.debug;
         FrameTimer var0 = minecraft.getFrameTimer();
         long[] var1 = var0.getFrames();
         int var2 = var0.getIndex();
         int var3 = var0.getLastIndex();
         if (var2 == var3) {
            return fpsMinLast;
         } else {
            int var4 = Minecraft.getDebugFPS();
            if (var4 <= 0) {
               var4 = 1;
            }

            long var5 = (long)(1.0D / (double)var4 * 1.0E9D);
            long var7 = var5;
            long var9 = 0L;

            for(int var11 = MathHelper.normalizeAngle(var2 - 1, var1.length); var11 != var3 && (double)var9 < 1.0E9D; var11 = MathHelper.normalizeAngle(var11 - 1, var1.length)) {
               long var12 = var1[var11];
               if (var12 > var7) {
                  var7 = var12;
               }

               var9 += var12;
            }

            double var14 = (double)var7 / 1.0E9D;
            fpsMinLast = (int)(1.0D / var14);
            return fpsMinLast;
         }
      }
   }

   public static String readInputStream(InputStream var0) throws IOException {
      return readInputStream(var0, "ASCII");
   }

   public static int getAvailableProcessors() {
      return availableProcessors;
   }

   public static String arrayToString(int[] var0) {
      return arrayToString(var0, ", ");
   }

   public static int getBitsJre() {
      String[] var0 = new String[]{"sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch"};

      for(int var1 = 0; var1 < var0.length; ++var1) {
         String var2 = var0[var1];
         String var3 = System.getProperty(var2);
         if (var3 != null && var3.contains("64")) {
            return 64;
         }
      }

      return 32;
   }

   public static boolean isSunMoonEnabled() {
      return gameSettings.ofSunMoon;
   }

   public static int[] addIntsToArray(int[] var0, int[] var1) {
      if (var0 != null && var1 != null) {
         int var2 = var0.length;
         int var3 = var2 + var1.length;
         int[] var4 = new int[var3];
         System.arraycopy(var0, 0, var4, 0, var2);

         for(int var5 = 0; var5 < var1.length; ++var5) {
            var4[var5 + var2] = var1[var5];
         }

         return var4;
      } else {
         throw new NullPointerException("The given array is NULL");
      }
   }

   public static boolean equals(Object var0, Object var1) {
      if (var0 == var1) {
         return true;
      } else {
         return var0 == null ? false : var0.equals(var1);
      }
   }

   public static void setNotify64BitJava(boolean var0) {
      notify64BitJava = var0;
   }

   public static boolean isAnimatedRedstone() {
      return gameSettings.ofAnimatedRedstone;
   }

   private static void setThreadPriority(String var0, int var1) {
      try {
         ThreadGroup var2 = Thread.currentThread().getThreadGroup();
         if (var2 == null) {
            return;
         }

         int var3 = (var2.activeCount() + 10) * 2;
         Thread[] var4 = new Thread[var3];
         var2.enumerate(var4, false);

         for(int var5 = 0; var5 < var4.length; ++var5) {
            Thread var6 = var4[var5];
            if (var6 != null && var6.getName().startsWith(var0)) {
               var6.setPriority(var1);
            }
         }
      } catch (Throwable var7) {
         warn(var7.getClass().getName() + ": " + var7.getMessage());
      }

   }

   private static String[] splitRelease(String var0) {
      if (var0 != null && var0.length() > 0) {
         Pattern var1 = Pattern.compile("([A-Z])([0-9]+)(.*)");
         Matcher var2 = var1.matcher(var0);
         if (!var2.matches()) {
            return new String[]{"", "", ""};
         } else {
            String var3 = normalize(var2.group(1));
            String var4 = normalize(var2.group(2));
            String var5 = normalize(var2.group(3));
            return new String[]{var3, var4, var5};
         }
      } else {
         return new String[]{"", "", ""};
      }
   }

   public static void initGameSettings(GameSettings var0) {
      if (gameSettings == null) {
         gameSettings = var0;
         desktopDisplayMode = Display.getDesktopDisplayMode();
         updateAvailableProcessors();
         ReflectorForge.putLaunchBlackboard("optifine.ForgeSplashCompatible", Boolean.TRUE);
      }

   }

   public static boolean isDynamicLightsFast() {
      return gameSettings.ofDynamicLights == 1;
   }

   public static boolean isAnimatedSmoke() {
      return gameSettings.ofAnimatedSmoke;
   }

   public static IntBuffer createDirectIntBuffer(int var0) {
      return GLAllocation.createDirectByteBuffer(var0 << 2).asIntBuffer();
   }

   public static Object[] addObjectToArray(Object[] var0, Object var1, int var2) {
      ArrayList var3 = new ArrayList(Arrays.asList(var0));
      var3.add(var2, var1);
      Object[] var4 = (Object[])Array.newInstance(var0.getClass().getComponentType(), var3.size());
      return var3.toArray(var4);
   }

   public static byte[] readAll(InputStream var0) throws IOException {
      ByteArrayOutputStream var1 = new ByteArrayOutputStream();
      byte[] var2 = new byte[1024];

      while(true) {
         int var3 = var0.read(var2);
         if (var3 < 0) {
            var0.close();
            byte[] var4 = var1.toByteArray();
            return var4;
         }

         var1.write(var2, 0, var3);
      }
   }

   public static boolean isMipmaps() {
      return gameSettings.mipmapLevels > 0;
   }

   public static int intHash(int var0) {
      var0 = var0 ^ 61 ^ var0 >> 16;
      var0 += var0 << 3;
      var0 ^= var0 >> 4;
      var0 *= 668265261;
      var0 ^= var0 >> 15;
      return var0;
   }

   public static boolean isStarsEnabled() {
      return gameSettings.ofStars;
   }

   public static boolean isPotionParticles() {
      return gameSettings.ofPotionParticles;
   }

   public static int getUpdatesPerFrame() {
      return gameSettings.ofChunkUpdates;
   }

   public static boolean isConnectedTextures() {
      return gameSettings.ofConnectedTextures != 3;
   }

   private static Set<Dimension> getDisplayModeDimensions(DisplayMode[] var0) {
      HashSet var1 = new HashSet();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         DisplayMode var3 = var0[var2];
         Dimension var4 = new Dimension(var3.getWidth(), var3.getHeight());
         var1.add(var4);
      }

      return var1;
   }

   public static boolean isVbo() {
      return OpenGlHelper.useVbo();
   }

   public static boolean isFogOn() {
      return gameSettings.ofFogType != 3;
   }

   public static String getGlErrorString(int var0) {
      switch(var0) {
      case 0:
         return "No error";
      case 1280:
         return "Invalid enum";
      case 1281:
         return "Invalid value";
      case 1282:
         return "Invalid operation";
      case 1283:
         return "Stack overflow";
      case 1284:
         return "Stack underflow";
      case 1285:
         return "Out of memory";
      case 1286:
         return "Invalid framebuffer operation";
      default:
         return "Unknown";
      }
   }

   public static boolean isTrue(Boolean var0) {
      return var0 != null && var0;
   }

   public static int[] toPrimitive(Integer[] var0) {
      if (var0 == null) {
         return null;
      } else if (var0.length == 0) {
         return new int[0];
      } else {
         int[] var1 = new int[var0.length];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            var1[var2] = var0[var2];
         }

         return var1;
      }
   }

   public static boolean isDynamicHandLight() {
      if (!isDynamicLights()) {
         return false;
      } else {
         return isShaders() ? Shaders.isDynamicHandLight() : true;
      }
   }

   public static String[] tokenize(String var0, String var1) {
      StringTokenizer var2 = new StringTokenizer(var0, var1);
      ArrayList var3 = new ArrayList();

      while(var2.hasMoreTokens()) {
         String var4 = var2.nextToken();
         var3.add(var4);
      }

      String[] var5 = (String[])var3.toArray(new String[var3.size()]);
      return var5;
   }

   public static boolean isCullFacesLeaves() {
      if (gameSettings.ofTrees == 0) {
         return !gameSettings.fancyGraphics;
      } else {
         return gameSettings.ofTrees == 4;
      }
   }

   public static boolean isFromDefaultResourcePack(ResourceLocation var0) {
      IResourcePack var1 = getDefiningResourcePack(var0);
      return var1 == getDefaultResourcePack();
   }

   public static boolean isVoidParticles() {
      return gameSettings.ofVoidParticles;
   }

   public static void updateThreadPriorities() {
      updateAvailableProcessors();
      boolean var0 = true;
      if (isSingleProcessor()) {
         if (isSmoothWorld()) {
            minecraftThread.setPriority(10);
            setThreadPriority("Server thread", 1);
         } else {
            minecraftThread.setPriority(5);
            setThreadPriority("Server thread", 5);
         }
      } else {
         minecraftThread.setPriority(10);
         setThreadPriority("Server thread", 5);
      }

   }

   public static void detail(String var0) {
      if (logDetail) {
         LOGGER.info("[OptiFine] " + var0);
      }

   }

   public static GlVersion getGlVersion() {
      if (glVersion == null) {
         String var0 = GL11.glGetString(7938);
         glVersion = parseGlVersion(var0, (GlVersion)null);
         if (glVersion == null) {
            glVersion = getGlVersionLwjgl();
         }

         if (glVersion == null) {
            glVersion = new GlVersion(1, 0);
         }
      }

      return glVersion;
   }

   public static boolean isConnectedModels() {
      return false;
   }

   public static boolean isShaders() {
      return Shaders.shaderPackLoaded;
   }

   public static void showGuiMessage(String var0, String var1) {
      GuiMessage var2 = new GuiMessage(minecraft.currentScreen, var0, var1);
      minecraft.displayGuiScreen(var2);
   }

   public static boolean isClearWater() {
      return gameSettings.ofClearWater;
   }

   public static Boolean parseBoolean(String var0, Boolean var1) {
      try {
         if (var0 == null) {
            return var1;
         } else {
            var0 = var0.trim().toLowerCase();
            if (var0.equals("true")) {
               return Boolean.TRUE;
            } else {
               return var0.equals("false") ? Boolean.FALSE : var1;
            }
         }
      } catch (NumberFormatException var3) {
         return var1;
      }
   }

   public static boolean isOcclusionAvailable() {
      return occlusionAvailable;
   }

   public static ModelManager getModelManager() {
      return minecraft.getRenderItem().modelManager;
   }

   public static String getBuild() {
      if (build == null) {
         try {
            InputStream var0 = Config.class.getResourceAsStream("/buildof.txt");
            if (var0 == null) {
               return null;
            }

            build = readLines(var0)[0];
         } catch (Exception var1) {
            warn(var1.getClass().getName() + ": " + var1.getMessage());
            build = "";
         }
      }

      return build;
   }

   public static String normalize(String var0) {
      return var0 == null ? "" : var0;
   }

   public static float parseFloat(String var0, float var1) {
      try {
         if (var0 == null) {
            return var1;
         } else {
            var0 = var0.trim();
            return Float.parseFloat(var0);
         }
      } catch (NumberFormatException var3) {
         return var1;
      }
   }

   public static int limit(int var0, int var1, int var2) {
      if (var0 < var1) {
         return var1;
      } else {
         return var0 > var2 ? var2 : var0;
      }
   }

   public static int compareRelease(String var0, String var1) {
      String[] var2 = splitRelease(var0);
      String[] var3 = splitRelease(var1);
      String var4 = var2[0];
      String var5 = var3[0];
      if (!var4.equals(var5)) {
         return var4.compareTo(var5);
      } else {
         int var6 = parseInt(var2[1], -1);
         int var7 = parseInt(var3[1], -1);
         if (var6 != var7) {
            return var6 - var7;
         } else {
            String var8 = var2[2];
            String var9 = var3[2];
            if (!var8.equals(var9)) {
               if (var8.isEmpty()) {
                  return 1;
               }

               if (var9.isEmpty()) {
                  return -1;
               }
            }

            return var8.compareTo(var9);
         }
      }
   }

   public static boolean isRainSplash() {
      return gameSettings.ofRainSplash;
   }

   public static boolean isRenderRegions() {
      return gameSettings.ofRenderRegions;
   }

   public static GameSettings getGameSettings() {
      return gameSettings;
   }
}
