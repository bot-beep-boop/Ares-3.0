package net.minecraft.client.settings;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.gui.GuiNewChat;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.stream.TwitchStream;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EnumPlayerModelParts;
import net.minecraft.network.play.client.C15PacketClientSettings;
import net.minecraft.src.Config;
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.optifine.ClearWater;
import net.optifine.CustomColors;
import net.optifine.CustomGuis;
import net.optifine.CustomSky;
import net.optifine.DynamicLights;
import net.optifine.Lang;
import net.optifine.NaturalTextures;
import net.optifine.RandomEntities;
import net.optifine.reflect.Reflector;
import net.optifine.shaders.Shaders;
import net.optifine.util.KeyUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class GameSettings {
   private File optionsFileOF;
   public int ofMipmapType;
   public boolean ofCustomColors;
   public List<String> incompatibleResourcePacks = Lists.newArrayList();
   public boolean showDebugProfilerChart;
   public boolean entityShadows;
   public boolean ofAlternateBlocks;
   public boolean chatColours;
   private final Set<EnumPlayerModelParts> setModelParts;
   public int streamChatEnabled;
   public boolean ofAnimatedTextures;
   public static final int SMART = 4;
   public int thirdPersonView;
   public EnumDifficulty difficulty;
   private static final String[] CLOUDS_TYPES = new String[]{"options.off", "options.graphics.fast", "options.graphics.fancy"};
   public int ofAnimatedLava;
   public List<String> resourcePacks = Lists.newArrayList();
   private static final String[] STREAM_CHAT_MODES = new String[]{"options.stream.chat.enabled.streaming", "options.stream.chat.enabled.always", "options.stream.chat.enabled.never"};
   public boolean ofChunkUpdatesDynamic;
   public boolean ofAnimatedFlame;
   public boolean invertMouse;
   public static final int ANIM_ON = 0;
   public boolean ofCustomItems;
   public boolean viewBobbing = true;
   public KeyBinding keyBindInventory;
   public boolean ofAnimatedFire;
   public boolean smoothCamera;
   public boolean hideServerAddress;
   public int ofAnimatedWater;
   public float ofFogStart;
   public boolean useNativeTransport;
   private static final String[] STREAM_MIC_MODES = new String[]{"options.stream.mic_toggle.mute", "options.stream.mic_toggle.talk"};
   public boolean useVbo;
   private static final ParameterizedType typeListString = new ParameterizedType() {
      public Type getOwnerType() {
         return null;
      }

      public Type getRawType() {
         return List.class;
      }

      public Type[] getActualTypeArguments() {
         return new Type[]{String.class};
      }
   };
   public float chatScale;
   private static final String[] AMBIENT_OCCLUSIONS = new String[]{"options.ao.off", "options.ao.min", "options.ao.max"};
   public boolean fboEnable = true;
   public boolean ofSky;
   public KeyBinding keyBindStreamPauseUnpause;
   public KeyBinding keyBindDrop;
   public int streamChatUserFilter;
   public boolean enableVsync;
   public boolean ofOcclusionFancy;
   public boolean fullScreen;
   public int overrideWidth;
   public boolean streamSendMetadata;
   public KeyBinding keyBindJump;
   public int ofBetterGrass;
   public KeyBinding keyBindCommand;
   public boolean ofRainSplash;
   public KeyBinding keyBindLeft;
   public KeyBinding keyBindBack;
   public boolean chatLinksPrompt;
   public KeyBinding keyBindStreamStartStop;
   public int clouds = 2;
   public boolean ofPortalParticles;
   public boolean ofAnimatedSmoke;
   public int guiScale;
   public float chatHeightUnfocused;
   public KeyBinding keyBindStreamCommercials;
   public KeyBinding keyBindTogglePerspective;
   public boolean ofAnimatedPortal;
   public float streamGameVolume;
   public boolean snooperEnabled;
   public boolean ofCustomGuis;
   public boolean ofAnimatedTerrain;
   public int ambientOcclusion = 2;
   public boolean ofWaterParticles;
   public boolean ofNaturalTextures;
   public float fovSetting;
   public float ofAoLevel;
   public boolean ofWeather;
   public float streamKbps;
   public KeyBinding keyBindScreenshot;
   public boolean ofDynamicFov;
   public KeyBinding keyBindSprint;
   public boolean ofProfiler;
   public int ofScreenshotSize;
   public boolean ofShowFps;
   private File optionsFile;
   private static final String[] PARTICLES = new String[]{"options.particles.all", "options.particles.decreased", "options.particles.minimal"};
   public float ofCloudsHeight;
   public float chatWidth;
   public boolean advancedItemTooltips;
   public KeyBinding keyBindRight;
   private static final Gson gson = new Gson();
   public KeyBinding keyBindAresHud;
   public int ofTime;
   private static final String[] GUISCALES = new String[]{"options.guiScale.auto", "options.guiScale.small", "options.guiScale.normal", "options.guiScale.large"};
   public KeyBinding keyBindSmoothCamera;
   public String language;
   public KeyBinding ofKeyBindZoom;
   public boolean hideGUI;
   public int ofVignette;
   public boolean ofRenderRegions;
   public KeyBinding keyBindPlayerList;
   public boolean ofRandomEntities;
   public String ofFullscreenMode;
   public int streamCompression;
   public int ofAfLevel;
   private static final String[] STREAM_COMPRESSIONS = new String[]{"options.stream.compression.low", "options.stream.compression.medium", "options.stream.compression.high"};
   public boolean ofCustomSky;
   public int ofAaLevel;
   public int particleSetting;
   public boolean ofShowGlErrors;
   public int renderDistanceChunks = -1;
   public boolean touchscreen;
   public KeyBinding keyBindChat;
   public boolean ofSmartAnimations;
   public boolean reducedDebugInfo;
   public float chatOpacity;
   public float saturation;
   public boolean realmsNotifications;
   public boolean ofClearWater;
   public boolean ofAnimatedRedstone;
   public KeyBinding keyBindForward;
   private Map<SoundCategory, Float> mapSoundLevels;
   public boolean ofSmoothBiomes;
   public KeyBinding keyBindUseItem;
   public boolean forceUnicodeFont;
   public boolean ofFastMath;
   public int ofTrees;
   public boolean ofCustomFonts;
   public KeyBinding keyBindSneak;
   public int ofFogType;
   public static final int OFF = 3;
   public boolean chatLinks;
   private static final int[] OF_TREES_VALUES = new int[]{0, 1, 4, 2};
   public float streamFps;
   public boolean showLagometer;
   public KeyBinding keyBindPickBlock;
   public int ofRain;
   public int ofChunkUpdates;
   public KeyBinding keyBindStreamToggleMic;
   public boolean ofCustomEntityModels;
   public EntityPlayer.EnumChatVisibility chatVisibility;
   public boolean ofSmoothWorld;
   private static final String[] STREAM_CHAT_FILTER_MODES = new String[]{"options.stream.chat.userFilter.all", "options.stream.chat.userFilter.subs", "options.stream.chat.userFilter.mods"};
   public boolean ofDrippingWaterLava;
   public KeyBinding[] keyBindings;
   public float streamBytesPerPixel;
   public int ofAutoSaveTicks;
   public boolean fancyGraphics = true;
   private static int[] $SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options;
   public KeyBinding[] keyBindsHotbar;
   public KeyBinding keyBindFullscreen;
   public static final String DEFAULT_STR = "Default";
   public boolean showInventoryAchievementHint;
   protected Minecraft mc;
   public boolean ofSwampColors;
   public int ofClouds;
   public boolean ofEmissiveTextures;
   public KeyBinding keyBindAttack;
   public boolean ofLagometer;
   public String lastServer;
   public boolean ofFireworkParticles;
   public KeyBinding keyBindSpectatorOutlines;
   public int ofDroppedItems;
   public float mouseSensitivity = 0.5F;
   public boolean anaglyph;
   public boolean ofVoidParticles;
   private static final int[] OF_DYNAMIC_LIGHTS = new int[]{3, 1, 2};
   public String streamPreferredServer;
   public boolean ofBetterSnow;
   private static final String[] KEYS_DYNAMIC_LIGHTS = new String[]{"options.off", "options.graphics.fast", "options.graphics.fancy"};
   public boolean ofStars;
   public boolean ofLazyChunkLoading;
   public float chatHeightFocused;
   public int ofDynamicLights;
   public float streamMicVolume;
   public float gammaSetting;
   private static final Logger logger = LogManager.getLogger();
   public static final int DEFAULT = 0;
   public boolean pauseOnLostFocus;
   public int limitFramerate = 120;
   public static final int ANIM_GENERATED = 1;
   public static final int ANIM_OFF = 2;
   public boolean allowBlockAlternatives;
   public int ofConnectedTextures;
   public int overrideHeight;
   public boolean showDebugInfo;
   public boolean ofFastRender;
   public static final int FAST = 1;
   public static final int FANCY = 2;
   public boolean ofSunMoon;
   public int streamMicToggleBehavior;
   public boolean ofSmoothFps;
   public boolean heldItemTooltips;
   public boolean ofPotionParticles;
   public boolean ofAnimatedExplosion;
   public int ofTranslucentBlocks;
   public boolean debugCamEnable;
   public boolean ofShowCapes;
   public int mipmapLevels;

   public void loadOptions() {
      FileInputStream var1 = null;

      try {
         if (!this.optionsFile.exists()) {
            return;
         }

         BufferedReader var2 = new BufferedReader(new InputStreamReader(var1 = new FileInputStream(this.optionsFile)));
         String var3 = "";
         this.mapSoundLevels.clear();

         while((var3 = var2.readLine()) != null) {
            try {
               String[] var4 = var3.split(":");
               if (var4[0].equals("mouseSensitivity")) {
                  this.mouseSensitivity = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("fov")) {
                  this.fovSetting = this.parseFloat(var4[1]) * 40.0F + 70.0F;
               }

               if (var4[0].equals("gamma")) {
                  this.gammaSetting = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("saturation")) {
                  this.saturation = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("invertYMouse")) {
                  this.invertMouse = var4[1].equals("true");
               }

               if (var4[0].equals("renderDistance")) {
                  this.renderDistanceChunks = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("guiScale")) {
                  this.guiScale = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("particles")) {
                  this.particleSetting = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("bobView")) {
                  this.viewBobbing = var4[1].equals("true");
               }

               if (var4[0].equals("anaglyph3d")) {
                  this.anaglyph = var4[1].equals("true");
               }

               if (var4[0].equals("maxFps")) {
                  this.limitFramerate = Integer.parseInt(var4[1]);
                  if (this.enableVsync) {
                     this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
                  }

                  if (this.limitFramerate <= 0) {
                     this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
                  }
               }

               if (var4[0].equals("fboEnable")) {
                  this.fboEnable = var4[1].equals("true");
               }

               if (var4[0].equals("difficulty")) {
                  this.difficulty = EnumDifficulty.getDifficultyEnum(Integer.parseInt(var4[1]));
               }

               if (var4[0].equals("fancyGraphics")) {
                  this.fancyGraphics = var4[1].equals("true");
                  this.updateRenderClouds();
               }

               if (var4[0].equals("ao")) {
                  if (var4[1].equals("true")) {
                     this.ambientOcclusion = 2;
                  } else if (var4[1].equals("false")) {
                     this.ambientOcclusion = 0;
                  } else {
                     this.ambientOcclusion = Integer.parseInt(var4[1]);
                  }
               }

               if (var4[0].equals("renderClouds")) {
                  if (var4[1].equals("true")) {
                     this.clouds = 2;
                  } else if (var4[1].equals("false")) {
                     this.clouds = 0;
                  } else if (var4[1].equals("fast")) {
                     this.clouds = 1;
                  }
               }

               if (var4[0].equals("resourcePacks")) {
                  this.resourcePacks = (List)gson.fromJson(var3.substring(var3.indexOf(58) + 1), typeListString);
                  if (this.resourcePacks == null) {
                     this.resourcePacks = Lists.newArrayList();
                  }
               }

               if (var4[0].equals("incompatibleResourcePacks")) {
                  this.incompatibleResourcePacks = (List)gson.fromJson(var3.substring(var3.indexOf(58) + 1), typeListString);
                  if (this.incompatibleResourcePacks == null) {
                     this.incompatibleResourcePacks = Lists.newArrayList();
                  }
               }

               if (var4[0].equals("lastServer") && var4.length >= 2) {
                  this.lastServer = var3.substring(var3.indexOf(58) + 1);
               }

               if (var4[0].equals("lang") && var4.length >= 2) {
                  this.language = var4[1];
               }

               if (var4[0].equals("chatVisibility")) {
                  this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility(Integer.parseInt(var4[1]));
               }

               if (var4[0].equals("chatColors")) {
                  this.chatColours = var4[1].equals("true");
               }

               if (var4[0].equals("chatLinks")) {
                  this.chatLinks = var4[1].equals("true");
               }

               if (var4[0].equals("chatLinksPrompt")) {
                  this.chatLinksPrompt = var4[1].equals("true");
               }

               if (var4[0].equals("chatOpacity")) {
                  this.chatOpacity = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("snooperEnabled")) {
                  this.snooperEnabled = var4[1].equals("true");
               }

               if (var4[0].equals("fullscreen")) {
                  this.fullScreen = var4[1].equals("true");
               }

               if (var4[0].equals("enableVsync")) {
                  this.enableVsync = var4[1].equals("true");
                  if (this.enableVsync) {
                     this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
                  }

                  this.updateVSync();
               }

               if (var4[0].equals("useVbo")) {
                  this.useVbo = var4[1].equals("true");
               }

               if (var4[0].equals("hideServerAddress")) {
                  this.hideServerAddress = var4[1].equals("true");
               }

               if (var4[0].equals("advancedItemTooltips")) {
                  this.advancedItemTooltips = var4[1].equals("true");
               }

               if (var4[0].equals("pauseOnLostFocus")) {
                  this.pauseOnLostFocus = var4[1].equals("true");
               }

               if (var4[0].equals("touchscreen")) {
                  this.touchscreen = var4[1].equals("true");
               }

               if (var4[0].equals("overrideHeight")) {
                  this.overrideHeight = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("overrideWidth")) {
                  this.overrideWidth = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("heldItemTooltips")) {
                  this.heldItemTooltips = var4[1].equals("true");
               }

               if (var4[0].equals("chatHeightFocused")) {
                  this.chatHeightFocused = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("chatHeightUnfocused")) {
                  this.chatHeightUnfocused = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("chatScale")) {
                  this.chatScale = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("chatWidth")) {
                  this.chatWidth = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("showInventoryAchievementHint")) {
                  this.showInventoryAchievementHint = var4[1].equals("true");
               }

               if (var4[0].equals("mipmapLevels")) {
                  this.mipmapLevels = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("streamBytesPerPixel")) {
                  this.streamBytesPerPixel = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("streamMicVolume")) {
                  this.streamMicVolume = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("streamSystemVolume")) {
                  this.streamGameVolume = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("streamKbps")) {
                  this.streamKbps = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("streamFps")) {
                  this.streamFps = this.parseFloat(var4[1]);
               }

               if (var4[0].equals("streamCompression")) {
                  this.streamCompression = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("streamSendMetadata")) {
                  this.streamSendMetadata = var4[1].equals("true");
               }

               if (var4[0].equals("streamPreferredServer") && var4.length >= 2) {
                  this.streamPreferredServer = var3.substring(var3.indexOf(58) + 1);
               }

               if (var4[0].equals("streamChatEnabled")) {
                  this.streamChatEnabled = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("streamChatUserFilter")) {
                  this.streamChatUserFilter = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("streamMicToggleBehavior")) {
                  this.streamMicToggleBehavior = Integer.parseInt(var4[1]);
               }

               if (var4[0].equals("forceUnicodeFont")) {
                  this.forceUnicodeFont = var4[1].equals("true");
               }

               if (var4[0].equals("allowBlockAlternatives")) {
                  this.allowBlockAlternatives = var4[1].equals("true");
               }

               if (var4[0].equals("reducedDebugInfo")) {
                  this.reducedDebugInfo = var4[1].equals("true");
               }

               if (var4[0].equals("useNativeTransport")) {
                  this.useNativeTransport = var4[1].equals("true");
               }

               if (var4[0].equals("entityShadows")) {
                  this.entityShadows = var4[1].equals("true");
               }

               if (var4[0].equals("realmsNotifications")) {
                  this.realmsNotifications = var4[1].equals("true");
               }

               KeyBinding[] var8;
               int var7 = (var8 = this.keyBindings).length;

               int var6;
               for(var6 = 0; var6 < var7; ++var6) {
                  KeyBinding var5 = var8[var6];
                  if (var4[0].equals("key_" + var5.getKeyDescription())) {
                     var5.setKeyCode(Integer.parseInt(var4[1]));
                  }
               }

               SoundCategory[] var18;
               var7 = (var18 = SoundCategory.values()).length;

               for(var6 = 0; var6 < var7; ++var6) {
                  SoundCategory var16 = var18[var6];
                  if (var4[0].equals("soundCategory_" + var16.getCategoryName())) {
                     this.mapSoundLevels.put(var16, this.parseFloat(var4[1]));
                  }
               }

               EnumPlayerModelParts[] var19;
               var7 = (var19 = EnumPlayerModelParts.values()).length;

               for(var6 = 0; var6 < var7; ++var6) {
                  EnumPlayerModelParts var17 = var19[var6];
                  if (var4[0].equals("modelPart_" + var17.getPartName())) {
                     this.setModelPartEnabled(var17, var4[1].equals("true"));
                  }
               }
            } catch (Exception var13) {
               logger.warn("Skipping bad option: " + var3);
               var13.printStackTrace();
            }
         }

         KeyBinding.resetKeyBindingArrayAndHash();
         var2.close();
      } catch (Exception var14) {
         logger.error("Failed to load options", var14);
      } finally {
         IOUtils.closeQuietly(var1);
      }

      this.loadOfOptions();
   }

   public float getSoundLevel(SoundCategory var1) {
      return this.mapSoundLevels.containsKey(var1) ? (Float)this.mapSoundLevels.get(var1) : 1.0F;
   }

   private static String getTranslation(String[] var0, int var1) {
      if (var1 < 0 || var1 >= var0.length) {
         var1 = 0;
      }

      return I18n.format(var0[var1]);
   }

   public static boolean isKeyDown(KeyBinding var0) {
      return var0.getKeyCode() == 0 ? false : (var0.getKeyCode() < 0 ? Mouse.isButtonDown(var0.getKeyCode() + 100) : Keyboard.isKeyDown(var0.getKeyCode()));
   }

   public void resetSettings() {
      this.renderDistanceChunks = 8;
      this.viewBobbing = true;
      this.anaglyph = false;
      this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
      this.enableVsync = false;
      this.updateVSync();
      this.mipmapLevels = 4;
      this.fancyGraphics = true;
      this.ambientOcclusion = 2;
      this.clouds = 2;
      this.fovSetting = 70.0F;
      this.gammaSetting = 0.0F;
      this.guiScale = 0;
      this.particleSetting = 0;
      this.heldItemTooltips = true;
      this.useVbo = false;
      this.forceUnicodeFont = false;
      this.ofFogType = 1;
      this.ofFogStart = 0.8F;
      this.ofMipmapType = 0;
      this.ofOcclusionFancy = false;
      this.ofSmartAnimations = false;
      this.ofSmoothFps = false;
      Config.updateAvailableProcessors();
      this.ofSmoothWorld = Config.isSingleProcessor();
      this.ofLazyChunkLoading = false;
      this.ofRenderRegions = false;
      this.ofFastMath = false;
      this.ofFastRender = false;
      this.ofTranslucentBlocks = 0;
      this.ofDynamicFov = true;
      this.ofAlternateBlocks = true;
      this.ofDynamicLights = 3;
      this.ofScreenshotSize = 1;
      this.ofCustomEntityModels = true;
      this.ofCustomGuis = true;
      this.ofShowGlErrors = true;
      this.ofAoLevel = 1.0F;
      this.ofAaLevel = 0;
      this.ofAfLevel = 1;
      this.ofClouds = 0;
      this.ofCloudsHeight = 0.0F;
      this.ofTrees = 0;
      this.ofRain = 0;
      this.ofBetterGrass = 3;
      this.ofAutoSaveTicks = 4000;
      this.ofLagometer = false;
      this.ofShowFps = false;
      this.ofProfiler = false;
      this.ofWeather = true;
      this.ofSky = true;
      this.ofStars = true;
      this.ofSunMoon = true;
      this.ofVignette = 0;
      this.ofChunkUpdates = 1;
      this.ofChunkUpdatesDynamic = false;
      this.ofTime = 0;
      this.ofClearWater = false;
      this.ofBetterSnow = false;
      this.ofFullscreenMode = "Default";
      this.ofSwampColors = true;
      this.ofRandomEntities = true;
      this.ofSmoothBiomes = true;
      this.ofCustomFonts = true;
      this.ofCustomColors = true;
      this.ofCustomItems = true;
      this.ofCustomSky = true;
      this.ofShowCapes = true;
      this.ofConnectedTextures = 2;
      this.ofNaturalTextures = false;
      this.ofEmissiveTextures = true;
      this.ofAnimatedWater = 0;
      this.ofAnimatedLava = 0;
      this.ofAnimatedFire = true;
      this.ofAnimatedPortal = true;
      this.ofAnimatedRedstone = true;
      this.ofAnimatedExplosion = true;
      this.ofAnimatedFlame = true;
      this.ofAnimatedSmoke = true;
      this.ofVoidParticles = true;
      this.ofWaterParticles = true;
      this.ofRainSplash = true;
      this.ofPortalParticles = true;
      this.ofPotionParticles = true;
      this.ofFireworkParticles = true;
      this.ofDrippingWaterLava = true;
      this.ofAnimatedTerrain = true;
      this.ofAnimatedTextures = true;
      Shaders.setShaderPack("OFF");
      Shaders.configAntialiasingLevel = 0;
      Shaders.uninit();
      Shaders.storeConfig();
      this.updateWaterOpacity();
      this.mc.refreshResources();
      this.saveOptions();
   }

   public String getKeyBinding(GameSettings.Options var1) {
      String var2 = this.getKeyBindingOF(var1);
      if (var2 != null) {
         return var2;
      } else {
         String var3 = I18n.format(var1.getEnumString()) + ": ";
         if (var1.getEnumFloat()) {
            float var7 = this.getOptionFloatValue(var1);
            float var5 = var1.normalizeValue(var7);
            if (var1 == GameSettings.Options.MIPMAP_LEVELS && (double)var7 >= 4.0D) {
               return var3 + Lang.get("of.general.max");
            } else {
               return var1 == GameSettings.Options.SENSITIVITY ? (var5 == 0.0F ? var3 + I18n.format("options.sensitivity.min") : (var5 == 1.0F ? var3 + I18n.format("options.sensitivity.max") : var3 + (int)(var5 * 200.0F) + "%")) : (var1 == GameSettings.Options.FOV ? (var7 == 70.0F ? var3 + I18n.format("options.fov.min") : (var7 == 110.0F ? var3 + I18n.format("options.fov.max") : var3 + (int)var7)) : (var1 == GameSettings.Options.FRAMERATE_LIMIT ? (var7 == GameSettings.Options.access$2(var1) ? var3 + I18n.format("options.framerateLimit.max") : var3 + (int)var7 + " fps") : (var1 == GameSettings.Options.RENDER_CLOUDS ? (var7 == GameSettings.Options.access$3(var1) ? var3 + I18n.format("options.cloudHeight.min") : var3 + ((int)var7 + 128)) : (var1 == GameSettings.Options.GAMMA ? (var5 == 0.0F ? var3 + I18n.format("options.gamma.min") : (var5 == 1.0F ? var3 + I18n.format("options.gamma.max") : var3 + "+" + (int)(var5 * 100.0F) + "%")) : (var1 == GameSettings.Options.SATURATION ? var3 + (int)(var5 * 400.0F) + "%" : (var1 == GameSettings.Options.CHAT_OPACITY ? var3 + (int)(var5 * 90.0F + 10.0F) + "%" : (var1 == GameSettings.Options.CHAT_HEIGHT_UNFOCUSED ? var3 + GuiNewChat.calculateChatboxHeight(var5) + "px" : (var1 == GameSettings.Options.CHAT_HEIGHT_FOCUSED ? var3 + GuiNewChat.calculateChatboxHeight(var5) + "px" : (var1 == GameSettings.Options.CHAT_WIDTH ? var3 + GuiNewChat.calculateChatboxWidth(var5) + "px" : (var1 == GameSettings.Options.RENDER_DISTANCE ? var3 + (int)var7 + " chunks" : (var1 == GameSettings.Options.MIPMAP_LEVELS ? (var7 == 0.0F ? var3 + I18n.format("options.off") : var3 + (int)var7) : (var1 == GameSettings.Options.STREAM_FPS ? var3 + TwitchStream.formatStreamFps(var5) + " fps" : (var1 == GameSettings.Options.STREAM_KBPS ? var3 + TwitchStream.formatStreamKbps(var5) + " Kbps" : (var1 == GameSettings.Options.STREAM_BYTES_PER_PIXEL ? var3 + String.format("%.3f bpp", TwitchStream.formatStreamBps(var5)) : (var5 == 0.0F ? var3 + I18n.format("options.off") : var3 + (int)(var5 * 100.0F) + "%")))))))))))))));
            }
         } else if (var1.getEnumBoolean()) {
            boolean var6 = this.getOptionOrdinalValue(var1);
            return var6 ? var3 + I18n.format("options.on") : var3 + I18n.format("options.off");
         } else if (var1 == GameSettings.Options.GUI_SCALE) {
            return this.guiScale >= GUISCALES.length ? var3 + this.guiScale + "x" : var3 + getTranslation(GUISCALES, this.guiScale);
         } else if (var1 == GameSettings.Options.CHAT_VISIBILITY) {
            return var3 + I18n.format(this.chatVisibility.getResourceKey());
         } else if (var1 == GameSettings.Options.PARTICLES) {
            return var3 + getTranslation(PARTICLES, this.particleSetting);
         } else if (var1 == GameSettings.Options.AMBIENT_OCCLUSION) {
            return var3 + getTranslation(AMBIENT_OCCLUSIONS, this.ambientOcclusion);
         } else if (var1 == GameSettings.Options.STREAM_COMPRESSION) {
            return var3 + getTranslation(STREAM_COMPRESSIONS, this.streamCompression);
         } else if (var1 == GameSettings.Options.STREAM_CHAT_ENABLED) {
            return var3 + getTranslation(STREAM_CHAT_MODES, this.streamChatEnabled);
         } else if (var1 == GameSettings.Options.STREAM_CHAT_USER_FILTER) {
            return var3 + getTranslation(STREAM_CHAT_FILTER_MODES, this.streamChatUserFilter);
         } else if (var1 == GameSettings.Options.STREAM_MIC_TOGGLE_BEHAVIOR) {
            return var3 + getTranslation(STREAM_MIC_MODES, this.streamMicToggleBehavior);
         } else if (var1 == GameSettings.Options.RENDER_CLOUDS) {
            return var3 + getTranslation(CLOUDS_TYPES, this.clouds);
         } else if (var1 == GameSettings.Options.GRAPHICS) {
            if (this.fancyGraphics) {
               return var3 + I18n.format("options.graphics.fancy");
            } else {
               String var4 = "options.graphics.fast";
               return var3 + I18n.format("options.graphics.fast");
            }
         } else {
            return var3;
         }
      }
   }

   private void updateWaterOpacity() {
      if (Config.isIntegratedServerRunning()) {
         Config.waterOpacityChanged = true;
      }

      ClearWater.updateWaterOpacity(this, this.mc.theWorld);
   }

   private void setOptionValueOF(GameSettings.Options var1, int var2) {
      if (var1 == GameSettings.Options.FOG_FANCY) {
         switch(this.ofFogType) {
         case 1:
            this.ofFogType = 2;
            if (!Config.isFancyFogAvailable()) {
               this.ofFogType = 3;
            }
            break;
         case 2:
            this.ofFogType = 3;
            break;
         case 3:
            this.ofFogType = 1;
            break;
         default:
            this.ofFogType = 1;
         }
      }

      if (var1 == GameSettings.Options.FOG_START) {
         this.ofFogStart += 0.2F;
         if (this.ofFogStart > 0.81F) {
            this.ofFogStart = 0.2F;
         }
      }

      if (var1 == GameSettings.Options.SMOOTH_FPS) {
         this.ofSmoothFps = !this.ofSmoothFps;
      }

      if (var1 == GameSettings.Options.SMOOTH_WORLD) {
         this.ofSmoothWorld = !this.ofSmoothWorld;
         Config.updateThreadPriorities();
      }

      if (var1 == GameSettings.Options.CLOUDS) {
         ++this.ofClouds;
         if (this.ofClouds > 3) {
            this.ofClouds = 0;
         }

         this.updateRenderClouds();
         this.mc.renderGlobal.resetClouds();
      }

      if (var1 == GameSettings.Options.TREES) {
         this.ofTrees = nextValue(this.ofTrees, OF_TREES_VALUES);
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.DROPPED_ITEMS) {
         ++this.ofDroppedItems;
         if (this.ofDroppedItems > 2) {
            this.ofDroppedItems = 0;
         }
      }

      if (var1 == GameSettings.Options.RAIN) {
         ++this.ofRain;
         if (this.ofRain > 3) {
            this.ofRain = 0;
         }
      }

      if (var1 == GameSettings.Options.ANIMATED_WATER) {
         ++this.ofAnimatedWater;
         if (this.ofAnimatedWater == 1) {
            ++this.ofAnimatedWater;
         }

         if (this.ofAnimatedWater > 2) {
            this.ofAnimatedWater = 0;
         }
      }

      if (var1 == GameSettings.Options.ANIMATED_LAVA) {
         ++this.ofAnimatedLava;
         if (this.ofAnimatedLava == 1) {
            ++this.ofAnimatedLava;
         }

         if (this.ofAnimatedLava > 2) {
            this.ofAnimatedLava = 0;
         }
      }

      if (var1 == GameSettings.Options.ANIMATED_FIRE) {
         this.ofAnimatedFire = !this.ofAnimatedFire;
      }

      if (var1 == GameSettings.Options.ANIMATED_PORTAL) {
         this.ofAnimatedPortal = !this.ofAnimatedPortal;
      }

      if (var1 == GameSettings.Options.ANIMATED_REDSTONE) {
         this.ofAnimatedRedstone = !this.ofAnimatedRedstone;
      }

      if (var1 == GameSettings.Options.ANIMATED_EXPLOSION) {
         this.ofAnimatedExplosion = !this.ofAnimatedExplosion;
      }

      if (var1 == GameSettings.Options.ANIMATED_FLAME) {
         this.ofAnimatedFlame = !this.ofAnimatedFlame;
      }

      if (var1 == GameSettings.Options.ANIMATED_SMOKE) {
         this.ofAnimatedSmoke = !this.ofAnimatedSmoke;
      }

      if (var1 == GameSettings.Options.VOID_PARTICLES) {
         this.ofVoidParticles = !this.ofVoidParticles;
      }

      if (var1 == GameSettings.Options.WATER_PARTICLES) {
         this.ofWaterParticles = !this.ofWaterParticles;
      }

      if (var1 == GameSettings.Options.PORTAL_PARTICLES) {
         this.ofPortalParticles = !this.ofPortalParticles;
      }

      if (var1 == GameSettings.Options.POTION_PARTICLES) {
         this.ofPotionParticles = !this.ofPotionParticles;
      }

      if (var1 == GameSettings.Options.FIREWORK_PARTICLES) {
         this.ofFireworkParticles = !this.ofFireworkParticles;
      }

      if (var1 == GameSettings.Options.DRIPPING_WATER_LAVA) {
         this.ofDrippingWaterLava = !this.ofDrippingWaterLava;
      }

      if (var1 == GameSettings.Options.ANIMATED_TERRAIN) {
         this.ofAnimatedTerrain = !this.ofAnimatedTerrain;
      }

      if (var1 == GameSettings.Options.ANIMATED_TEXTURES) {
         this.ofAnimatedTextures = !this.ofAnimatedTextures;
      }

      if (var1 == GameSettings.Options.RAIN_SPLASH) {
         this.ofRainSplash = !this.ofRainSplash;
      }

      if (var1 == GameSettings.Options.LAGOMETER) {
         this.ofLagometer = !this.ofLagometer;
      }

      if (var1 == GameSettings.Options.SHOW_FPS) {
         this.ofShowFps = !this.ofShowFps;
      }

      if (var1 == GameSettings.Options.AUTOSAVE_TICKS) {
         short var3 = 900;
         this.ofAutoSaveTicks = Math.max(this.ofAutoSaveTicks / var3 * var3, var3);
         this.ofAutoSaveTicks *= 2;
         if (this.ofAutoSaveTicks > 32 * var3) {
            this.ofAutoSaveTicks = var3;
         }
      }

      if (var1 == GameSettings.Options.BETTER_GRASS) {
         ++this.ofBetterGrass;
         if (this.ofBetterGrass > 3) {
            this.ofBetterGrass = 1;
         }

         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.CONNECTED_TEXTURES) {
         ++this.ofConnectedTextures;
         if (this.ofConnectedTextures > 3) {
            this.ofConnectedTextures = 1;
         }

         if (this.ofConnectedTextures == 2) {
            this.mc.renderGlobal.loadRenderers();
         } else {
            this.mc.refreshResources();
         }
      }

      if (var1 == GameSettings.Options.WEATHER) {
         this.ofWeather = !this.ofWeather;
      }

      if (var1 == GameSettings.Options.SKY) {
         this.ofSky = !this.ofSky;
      }

      if (var1 == GameSettings.Options.STARS) {
         this.ofStars = !this.ofStars;
      }

      if (var1 == GameSettings.Options.SUN_MOON) {
         this.ofSunMoon = !this.ofSunMoon;
      }

      if (var1 == GameSettings.Options.VIGNETTE) {
         ++this.ofVignette;
         if (this.ofVignette > 2) {
            this.ofVignette = 0;
         }
      }

      if (var1 == GameSettings.Options.CHUNK_UPDATES) {
         ++this.ofChunkUpdates;
         if (this.ofChunkUpdates > 5) {
            this.ofChunkUpdates = 1;
         }
      }

      if (var1 == GameSettings.Options.CHUNK_UPDATES_DYNAMIC) {
         this.ofChunkUpdatesDynamic = !this.ofChunkUpdatesDynamic;
      }

      if (var1 == GameSettings.Options.TIME) {
         ++this.ofTime;
         if (this.ofTime > 2) {
            this.ofTime = 0;
         }
      }

      if (var1 == GameSettings.Options.CLEAR_WATER) {
         this.ofClearWater = !this.ofClearWater;
         this.updateWaterOpacity();
      }

      if (var1 == GameSettings.Options.PROFILER) {
         this.ofProfiler = !this.ofProfiler;
      }

      if (var1 == GameSettings.Options.BETTER_SNOW) {
         this.ofBetterSnow = !this.ofBetterSnow;
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.SWAMP_COLORS) {
         this.ofSwampColors = !this.ofSwampColors;
         CustomColors.updateUseDefaultGrassFoliageColors();
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.RANDOM_ENTITIES) {
         this.ofRandomEntities = !this.ofRandomEntities;
         RandomEntities.update();
      }

      if (var1 == GameSettings.Options.SMOOTH_BIOMES) {
         this.ofSmoothBiomes = !this.ofSmoothBiomes;
         CustomColors.updateUseDefaultGrassFoliageColors();
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.CUSTOM_FONTS) {
         this.ofCustomFonts = !this.ofCustomFonts;
         this.mc.fontRendererObj.onResourceManagerReload(Config.getResourceManager());
         this.mc.standardGalacticFontRenderer.onResourceManagerReload(Config.getResourceManager());
      }

      if (var1 == GameSettings.Options.CUSTOM_COLORS) {
         this.ofCustomColors = !this.ofCustomColors;
         CustomColors.update();
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.CUSTOM_ITEMS) {
         this.ofCustomItems = !this.ofCustomItems;
         this.mc.refreshResources();
      }

      if (var1 == GameSettings.Options.CUSTOM_SKY) {
         this.ofCustomSky = !this.ofCustomSky;
         CustomSky.update();
      }

      if (var1 == GameSettings.Options.SHOW_CAPES) {
         this.ofShowCapes = !this.ofShowCapes;
      }

      if (var1 == GameSettings.Options.NATURAL_TEXTURES) {
         this.ofNaturalTextures = !this.ofNaturalTextures;
         NaturalTextures.update();
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.EMISSIVE_TEXTURES) {
         this.ofEmissiveTextures = !this.ofEmissiveTextures;
         this.mc.refreshResources();
      }

      if (var1 == GameSettings.Options.FAST_MATH) {
         this.ofFastMath = !this.ofFastMath;
         MathHelper.fastMath = this.ofFastMath;
      }

      if (var1 == GameSettings.Options.FAST_RENDER) {
         if (!this.ofFastRender && Config.isShaders()) {
            Config.showGuiMessage(Lang.get("of.message.fr.shaders1"), Lang.get("of.message.fr.shaders2"));
            return;
         }

         this.ofFastRender = !this.ofFastRender;
         if (this.ofFastRender) {
            this.mc.entityRenderer.stopUseShader();
         }

         Config.updateFramebufferSize();
      }

      if (var1 == GameSettings.Options.TRANSLUCENT_BLOCKS) {
         if (this.ofTranslucentBlocks == 0) {
            this.ofTranslucentBlocks = 1;
         } else if (this.ofTranslucentBlocks == 1) {
            this.ofTranslucentBlocks = 2;
         } else if (this.ofTranslucentBlocks == 2) {
            this.ofTranslucentBlocks = 0;
         } else {
            this.ofTranslucentBlocks = 0;
         }

         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.LAZY_CHUNK_LOADING) {
         this.ofLazyChunkLoading = !this.ofLazyChunkLoading;
      }

      if (var1 == GameSettings.Options.RENDER_REGIONS) {
         this.ofRenderRegions = !this.ofRenderRegions;
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.SMART_ANIMATIONS) {
         this.ofSmartAnimations = !this.ofSmartAnimations;
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.DYNAMIC_FOV) {
         this.ofDynamicFov = !this.ofDynamicFov;
      }

      if (var1 == GameSettings.Options.ALTERNATE_BLOCKS) {
         this.ofAlternateBlocks = !this.ofAlternateBlocks;
         this.mc.refreshResources();
      }

      if (var1 == GameSettings.Options.DYNAMIC_LIGHTS) {
         this.ofDynamicLights = nextValue(this.ofDynamicLights, OF_DYNAMIC_LIGHTS);
         DynamicLights.removeLights(this.mc.renderGlobal);
      }

      if (var1 == GameSettings.Options.SCREENSHOT_SIZE) {
         ++this.ofScreenshotSize;
         if (this.ofScreenshotSize > 4) {
            this.ofScreenshotSize = 1;
         }

         if (!OpenGlHelper.isFramebufferEnabled()) {
            this.ofScreenshotSize = 1;
         }
      }

      if (var1 == GameSettings.Options.CUSTOM_ENTITY_MODELS) {
         this.ofCustomEntityModels = !this.ofCustomEntityModels;
         this.mc.refreshResources();
      }

      if (var1 == GameSettings.Options.CUSTOM_GUIS) {
         this.ofCustomGuis = !this.ofCustomGuis;
         CustomGuis.update();
      }

      if (var1 == GameSettings.Options.SHOW_GL_ERRORS) {
         this.ofShowGlErrors = !this.ofShowGlErrors;
      }

      if (var1 == GameSettings.Options.HELD_ITEM_TOOLTIPS) {
         this.heldItemTooltips = !this.heldItemTooltips;
      }

      if (var1 == GameSettings.Options.ADVANCED_TOOLTIPS) {
         this.advancedItemTooltips = !this.advancedItemTooltips;
      }

   }

   public void setOptionFloatValue(GameSettings.Options var1, float var2) {
      this.setOptionFloatValueOF(var1, var2);
      if (var1 == GameSettings.Options.SENSITIVITY) {
         this.mouseSensitivity = var2;
      }

      if (var1 == GameSettings.Options.FOV) {
         this.fovSetting = var2;
      }

      if (var1 == GameSettings.Options.GAMMA) {
         this.gammaSetting = var2;
      }

      if (var1 == GameSettings.Options.FRAMERATE_LIMIT) {
         this.limitFramerate = (int)var2;
         this.enableVsync = false;
         if (this.limitFramerate <= 0) {
            this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
            this.enableVsync = true;
         }

         this.updateVSync();
      }

      if (var1 == GameSettings.Options.CHAT_OPACITY) {
         this.chatOpacity = var2;
         this.mc.ingameGUI.getChatGUI().refreshChat();
      }

      if (var1 == GameSettings.Options.CHAT_HEIGHT_FOCUSED) {
         this.chatHeightFocused = var2;
         this.mc.ingameGUI.getChatGUI().refreshChat();
      }

      if (var1 == GameSettings.Options.CHAT_HEIGHT_UNFOCUSED) {
         this.chatHeightUnfocused = var2;
         this.mc.ingameGUI.getChatGUI().refreshChat();
      }

      if (var1 == GameSettings.Options.CHAT_WIDTH) {
         this.chatWidth = var2;
         this.mc.ingameGUI.getChatGUI().refreshChat();
      }

      if (var1 == GameSettings.Options.CHAT_SCALE) {
         this.chatScale = var2;
         this.mc.ingameGUI.getChatGUI().refreshChat();
      }

      if (var1 == GameSettings.Options.MIPMAP_LEVELS) {
         int var3 = this.mipmapLevels;
         this.mipmapLevels = (int)var2;
         if ((float)var3 != var2) {
            this.mc.getTextureMapBlocks().setMipmapLevels(this.mipmapLevels);
            this.mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
            this.mc.getTextureMapBlocks().setBlurMipmapDirect(false, this.mipmapLevels > 0);
            this.mc.scheduleResourcesRefresh();
         }
      }

      if (var1 == GameSettings.Options.BLOCK_ALTERNATIVES) {
         this.allowBlockAlternatives = !this.allowBlockAlternatives;
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.RENDER_DISTANCE) {
         this.renderDistanceChunks = (int)var2;
         this.mc.renderGlobal.setDisplayListEntitiesDirty();
      }

      if (var1 == GameSettings.Options.STREAM_BYTES_PER_PIXEL) {
         this.streamBytesPerPixel = var2;
      }

      if (var1 == GameSettings.Options.STREAM_VOLUME_MIC) {
         this.streamMicVolume = var2;
         this.mc.getTwitchStream().updateStreamVolume();
      }

      if (var1 == GameSettings.Options.STREAM_VOLUME_SYSTEM) {
         this.streamGameVolume = var2;
         this.mc.getTwitchStream().updateStreamVolume();
      }

      if (var1 == GameSettings.Options.STREAM_KBPS) {
         this.streamKbps = var2;
      }

      if (var1 == GameSettings.Options.STREAM_FPS) {
         this.streamFps = var2;
      }

   }

   public void updateVSync() {
      Display.setVSyncEnabled(this.enableVsync);
   }

   public void setAllAnimations(boolean var1) {
      int var2 = var1 ? 0 : 2;
      this.ofAnimatedWater = var2;
      this.ofAnimatedLava = var2;
      this.ofAnimatedFire = var1;
      this.ofAnimatedPortal = var1;
      this.ofAnimatedRedstone = var1;
      this.ofAnimatedExplosion = var1;
      this.ofAnimatedFlame = var1;
      this.ofAnimatedSmoke = var1;
      this.ofVoidParticles = var1;
      this.ofWaterParticles = var1;
      this.ofRainSplash = var1;
      this.ofPortalParticles = var1;
      this.ofPotionParticles = var1;
      this.ofFireworkParticles = var1;
      this.particleSetting = var1 ? 0 : 2;
      this.ofDrippingWaterLava = var1;
      this.ofAnimatedTerrain = var1;
      this.ofAnimatedTextures = var1;
   }

   public void setOptionValue(GameSettings.Options var1, int var2) {
      this.setOptionValueOF(var1, var2);
      if (var1 == GameSettings.Options.INVERT_MOUSE) {
         this.invertMouse = !this.invertMouse;
      }

      if (var1 == GameSettings.Options.GUI_SCALE) {
         this.guiScale += var2;
         if (GuiScreen.isShiftKeyDown()) {
            this.guiScale = 0;
         }

         DisplayMode var3 = Config.getLargestDisplayMode();
         int var4 = var3.getWidth() / 320;
         int var5 = var3.getHeight() / 240;
         int var6 = Math.min(var4, var5);
         if (this.guiScale < 0) {
            this.guiScale = var6 - 1;
         }

         if (this.mc.isUnicode() && this.guiScale % 2 != 0) {
            this.guiScale += var2;
         }

         if (this.guiScale < 0 || this.guiScale >= var6) {
            this.guiScale = 0;
         }
      }

      if (var1 == GameSettings.Options.PARTICLES) {
         this.particleSetting = (this.particleSetting + var2) % 3;
      }

      if (var1 == GameSettings.Options.VIEW_BOBBING) {
         this.viewBobbing = !this.viewBobbing;
      }

      if (var1 == GameSettings.Options.RENDER_CLOUDS) {
         this.clouds = (this.clouds + var2) % 3;
      }

      if (var1 == GameSettings.Options.FORCE_UNICODE_FONT) {
         this.forceUnicodeFont = !this.forceUnicodeFont;
         this.mc.fontRendererObj.setUnicodeFlag(this.mc.getLanguageManager().isCurrentLocaleUnicode() || this.forceUnicodeFont);
      }

      if (var1 == GameSettings.Options.FBO_ENABLE) {
         this.fboEnable = !this.fboEnable;
      }

      if (var1 == GameSettings.Options.ANAGLYPH) {
         if (!this.anaglyph && Config.isShaders()) {
            Config.showGuiMessage(Lang.get("of.message.an.shaders1"), Lang.get("of.message.an.shaders2"));
            return;
         }

         this.anaglyph = !this.anaglyph;
         this.mc.refreshResources();
      }

      if (var1 == GameSettings.Options.GRAPHICS) {
         this.fancyGraphics = !this.fancyGraphics;
         this.updateRenderClouds();
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.AMBIENT_OCCLUSION) {
         this.ambientOcclusion = (this.ambientOcclusion + var2) % 3;
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.CHAT_VISIBILITY) {
         this.chatVisibility = EntityPlayer.EnumChatVisibility.getEnumChatVisibility((this.chatVisibility.getChatVisibility() + var2) % 3);
      }

      if (var1 == GameSettings.Options.STREAM_COMPRESSION) {
         this.streamCompression = (this.streamCompression + var2) % 3;
      }

      if (var1 == GameSettings.Options.STREAM_SEND_METADATA) {
         this.streamSendMetadata = !this.streamSendMetadata;
      }

      if (var1 == GameSettings.Options.STREAM_CHAT_ENABLED) {
         this.streamChatEnabled = (this.streamChatEnabled + var2) % 3;
      }

      if (var1 == GameSettings.Options.STREAM_CHAT_USER_FILTER) {
         this.streamChatUserFilter = (this.streamChatUserFilter + var2) % 3;
      }

      if (var1 == GameSettings.Options.STREAM_MIC_TOGGLE_BEHAVIOR) {
         this.streamMicToggleBehavior = (this.streamMicToggleBehavior + var2) % 2;
      }

      if (var1 == GameSettings.Options.CHAT_COLOR) {
         this.chatColours = !this.chatColours;
      }

      if (var1 == GameSettings.Options.CHAT_LINKS) {
         this.chatLinks = !this.chatLinks;
      }

      if (var1 == GameSettings.Options.CHAT_LINKS_PROMPT) {
         this.chatLinksPrompt = !this.chatLinksPrompt;
      }

      if (var1 == GameSettings.Options.SNOOPER_ENABLED) {
         this.snooperEnabled = !this.snooperEnabled;
      }

      if (var1 == GameSettings.Options.TOUCHSCREEN) {
         this.touchscreen = !this.touchscreen;
      }

      if (var1 == GameSettings.Options.USE_FULLSCREEN) {
         this.fullScreen = !this.fullScreen;
         if (this.mc.isFullScreen() != this.fullScreen) {
            this.mc.toggleFullscreen();
         }
      }

      if (var1 == GameSettings.Options.ENABLE_VSYNC) {
         this.enableVsync = !this.enableVsync;
         Display.setVSyncEnabled(this.enableVsync);
      }

      if (var1 == GameSettings.Options.USE_VBO) {
         this.useVbo = !this.useVbo;
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.BLOCK_ALTERNATIVES) {
         this.allowBlockAlternatives = !this.allowBlockAlternatives;
         this.mc.renderGlobal.loadRenderers();
      }

      if (var1 == GameSettings.Options.REDUCED_DEBUG_INFO) {
         this.reducedDebugInfo = !this.reducedDebugInfo;
      }

      if (var1 == GameSettings.Options.ENTITY_SHADOWS) {
         this.entityShadows = !this.entityShadows;
      }

      if (var1 == GameSettings.Options.REALMS_NOTIFICATIONS) {
         this.realmsNotifications = !this.realmsNotifications;
      }

      this.saveOptions();
   }

   private float getOptionFloatValueOF(GameSettings.Options var1) {
      if (var1 == GameSettings.Options.CLOUD_HEIGHT) {
         return this.ofCloudsHeight;
      } else if (var1 == GameSettings.Options.AO_LEVEL) {
         return this.ofAoLevel;
      } else if (var1 == GameSettings.Options.AA_LEVEL) {
         return (float)this.ofAaLevel;
      } else if (var1 == GameSettings.Options.AF_LEVEL) {
         return (float)this.ofAfLevel;
      } else if (var1 == GameSettings.Options.MIPMAP_TYPE) {
         return (float)this.ofMipmapType;
      } else if (var1 != GameSettings.Options.FRAMERATE_LIMIT) {
         if (var1 == GameSettings.Options.FULLSCREEN_MODE) {
            if (this.ofFullscreenMode.equals("Default")) {
               return 0.0F;
            } else {
               List var2 = Arrays.asList(Config.getDisplayModeNames());
               int var3 = var2.indexOf(this.ofFullscreenMode);
               return var3 < 0 ? 0.0F : (float)(var3 + 1);
            }
         } else {
            return Float.MAX_VALUE;
         }
      } else {
         return (float)this.limitFramerate == GameSettings.Options.FRAMERATE_LIMIT.getValueMax() && this.enableVsync ? 0.0F : (float)this.limitFramerate;
      }
   }

   private static int nextValue(int var0, int[] var1) {
      int var2 = indexOf(var0, var1);
      if (var2 < 0) {
         return var1[0];
      } else {
         ++var2;
         if (var2 >= var1.length) {
            var2 = 0;
         }

         return var1[var2];
      }
   }

   public float getOptionFloatValue(GameSettings.Options var1) {
      float var2 = this.getOptionFloatValueOF(var1);
      if (var2 != Float.MAX_VALUE) {
         return var2;
      } else {
         return var1 == GameSettings.Options.FOV ? this.fovSetting : (var1 == GameSettings.Options.GAMMA ? this.gammaSetting : (var1 == GameSettings.Options.SATURATION ? this.saturation : (var1 == GameSettings.Options.SENSITIVITY ? this.mouseSensitivity : (var1 == GameSettings.Options.CHAT_OPACITY ? this.chatOpacity : (var1 == GameSettings.Options.CHAT_HEIGHT_FOCUSED ? this.chatHeightFocused : (var1 == GameSettings.Options.CHAT_HEIGHT_UNFOCUSED ? this.chatHeightUnfocused : (var1 == GameSettings.Options.CHAT_SCALE ? this.chatScale : (var1 == GameSettings.Options.CHAT_WIDTH ? this.chatWidth : (var1 == GameSettings.Options.FRAMERATE_LIMIT ? (float)this.limitFramerate : (var1 == GameSettings.Options.MIPMAP_LEVELS ? (float)this.mipmapLevels : (var1 == GameSettings.Options.RENDER_DISTANCE ? (float)this.renderDistanceChunks : (var1 == GameSettings.Options.STREAM_BYTES_PER_PIXEL ? this.streamBytesPerPixel : (var1 == GameSettings.Options.STREAM_VOLUME_MIC ? this.streamMicVolume : (var1 == GameSettings.Options.STREAM_VOLUME_SYSTEM ? this.streamGameVolume : (var1 == GameSettings.Options.STREAM_KBPS ? this.streamKbps : (var1 == GameSettings.Options.STREAM_FPS ? this.streamFps : 0.0F))))))))))))))));
      }
   }

   public void setOptionKeyBinding(KeyBinding var1, int var2) {
      var1.setKeyCode(var2);
      this.saveOptions();
   }

   private static int limit(int var0, int[] var1) {
      int var2 = indexOf(var0, var1);
      return var2 < 0 ? var1[0] : var0;
   }

   public GameSettings() {
      this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
      this.chatColours = true;
      this.chatLinks = true;
      this.chatLinksPrompt = true;
      this.chatOpacity = 1.0F;
      this.snooperEnabled = true;
      this.enableVsync = true;
      this.useVbo = false;
      this.allowBlockAlternatives = true;
      this.reducedDebugInfo = false;
      this.pauseOnLostFocus = true;
      this.setModelParts = Sets.newHashSet(EnumPlayerModelParts.values());
      this.heldItemTooltips = true;
      this.chatScale = 1.0F;
      this.chatWidth = 1.0F;
      this.chatHeightUnfocused = 0.44366196F;
      this.chatHeightFocused = 1.0F;
      this.showInventoryAchievementHint = true;
      this.mipmapLevels = 4;
      this.mapSoundLevels = Maps.newEnumMap(SoundCategory.class);
      this.streamBytesPerPixel = 0.5F;
      this.streamMicVolume = 1.0F;
      this.streamGameVolume = 1.0F;
      this.streamKbps = 0.5412844F;
      this.streamFps = 0.31690142F;
      this.streamCompression = 1;
      this.streamSendMetadata = true;
      this.streamPreferredServer = "";
      this.streamChatEnabled = 0;
      this.streamChatUserFilter = 0;
      this.streamMicToggleBehavior = 0;
      this.useNativeTransport = true;
      this.entityShadows = true;
      this.realmsNotifications = true;
      this.keyBindForward = new KeyBinding("key.forward", 17, "key.categories.movement");
      this.keyBindLeft = new KeyBinding("key.left", 30, "key.categories.movement");
      this.keyBindBack = new KeyBinding("key.back", 31, "key.categories.movement");
      this.keyBindRight = new KeyBinding("key.right", 32, "key.categories.movement");
      this.keyBindJump = new KeyBinding("key.jump", 57, "key.categories.movement");
      this.keyBindSneak = new KeyBinding("key.sneak", 42, "key.categories.movement");
      this.keyBindSprint = new KeyBinding("key.sprint", 29, "key.categories.movement");
      this.keyBindInventory = new KeyBinding("key.inventory", 18, "key.categories.inventory");
      this.keyBindUseItem = new KeyBinding("key.use", -99, "key.categories.gameplay");
      this.keyBindDrop = new KeyBinding("key.drop", 16, "key.categories.gameplay");
      this.keyBindAttack = new KeyBinding("key.attack", -100, "key.categories.gameplay");
      this.keyBindPickBlock = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
      this.keyBindChat = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
      this.keyBindPlayerList = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
      this.keyBindCommand = new KeyBinding("key.command", 53, "key.categories.multiplayer");
      this.keyBindScreenshot = new KeyBinding("key.screenshot", 60, "key.categories.misc");
      this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
      this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
      this.keyBindFullscreen = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
      this.keyBindSpectatorOutlines = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
      this.keyBindStreamStartStop = new KeyBinding("key.streamStartStop", 64, "key.categories.stream");
      this.keyBindStreamPauseUnpause = new KeyBinding("key.streamPauseUnpause", 65, "key.categories.stream");
      this.keyBindStreamCommercials = new KeyBinding("key.streamCommercial", 0, "key.categories.stream");
      this.keyBindStreamToggleMic = new KeyBinding("key.streamToggleMic", 0, "key.categories.stream");
      this.keyBindsHotbar = new KeyBinding[]{new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory")};
      this.keyBindAresHud = new KeyBinding("Opens the Hud", 54, "Ares");
      this.ofFogType = 1;
      this.ofFogStart = 0.8F;
      this.ofMipmapType = 0;
      this.ofOcclusionFancy = false;
      this.ofSmoothFps = false;
      this.ofSmoothWorld = Config.isSingleProcessor();
      this.ofLazyChunkLoading = Config.isSingleProcessor();
      this.ofRenderRegions = false;
      this.ofSmartAnimations = false;
      this.ofAoLevel = 1.0F;
      this.ofAaLevel = 0;
      this.ofAfLevel = 1;
      this.ofClouds = 0;
      this.ofCloudsHeight = 0.0F;
      this.ofTrees = 0;
      this.ofRain = 0;
      this.ofDroppedItems = 0;
      this.ofBetterGrass = 3;
      this.ofAutoSaveTicks = 4000;
      this.ofLagometer = false;
      this.ofProfiler = false;
      this.ofShowFps = false;
      this.ofWeather = true;
      this.ofSky = true;
      this.ofStars = true;
      this.ofSunMoon = true;
      this.ofVignette = 0;
      this.ofChunkUpdates = 1;
      this.ofChunkUpdatesDynamic = false;
      this.ofTime = 0;
      this.ofClearWater = false;
      this.ofBetterSnow = false;
      this.ofFullscreenMode = "Default";
      this.ofSwampColors = true;
      this.ofRandomEntities = true;
      this.ofSmoothBiomes = true;
      this.ofCustomFonts = true;
      this.ofCustomColors = true;
      this.ofCustomSky = true;
      this.ofShowCapes = true;
      this.ofConnectedTextures = 2;
      this.ofCustomItems = true;
      this.ofNaturalTextures = false;
      this.ofEmissiveTextures = true;
      this.ofFastMath = false;
      this.ofFastRender = false;
      this.ofTranslucentBlocks = 0;
      this.ofDynamicFov = true;
      this.ofAlternateBlocks = true;
      this.ofDynamicLights = 3;
      this.ofCustomEntityModels = true;
      this.ofCustomGuis = true;
      this.ofShowGlErrors = true;
      this.ofScreenshotSize = 1;
      this.ofAnimatedWater = 0;
      this.ofAnimatedLava = 0;
      this.ofAnimatedFire = true;
      this.ofAnimatedPortal = true;
      this.ofAnimatedRedstone = true;
      this.ofAnimatedExplosion = true;
      this.ofAnimatedFlame = true;
      this.ofAnimatedSmoke = true;
      this.ofVoidParticles = true;
      this.ofWaterParticles = true;
      this.ofRainSplash = true;
      this.ofPortalParticles = true;
      this.ofPotionParticles = true;
      this.ofFireworkParticles = true;
      this.ofDrippingWaterLava = true;
      this.ofAnimatedTerrain = true;
      this.ofAnimatedTextures = true;
      this.keyBindings = (KeyBinding[])ArrayUtils.addAll(new KeyBinding[]{this.keyBindAresHud, this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindSprint, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindStreamStartStop, this.keyBindStreamPauseUnpause, this.keyBindStreamCommercials, this.keyBindStreamToggleMic, this.keyBindFullscreen, this.keyBindSpectatorOutlines}, this.keyBindsHotbar);
      this.difficulty = EnumDifficulty.NORMAL;
      this.lastServer = "";
      this.fovSetting = 70.0F;
      this.language = "en_US";
      this.forceUnicodeFont = false;
   }

   public void setModelPartEnabled(EnumPlayerModelParts var1, boolean var2) {
      if (var2) {
         this.setModelParts.add(var1);
      } else {
         this.setModelParts.remove(var1);
      }

      this.sendSettingsToServer();
   }

   public void switchModelPartEnabled(EnumPlayerModelParts var1) {
      if (!this.getModelParts().contains(var1)) {
         this.setModelParts.add(var1);
      } else {
         this.setModelParts.remove(var1);
      }

      this.sendSettingsToServer();
   }

   private String getKeyBindingOF(GameSettings.Options var1) {
      String var2 = I18n.format(var1.getEnumString()) + ": ";
      if (var2 == null) {
         var2 = var1.getEnumString();
      }

      int var8;
      if (var1 == GameSettings.Options.RENDER_DISTANCE) {
         var8 = (int)this.getOptionFloatValue(var1);
         String var4 = I18n.format("options.renderDistance.tiny");
         byte var5 = 2;
         if (var8 >= 4) {
            var4 = I18n.format("options.renderDistance.short");
            var5 = 4;
         }

         if (var8 >= 8) {
            var4 = I18n.format("options.renderDistance.normal");
            var5 = 8;
         }

         if (var8 >= 16) {
            var4 = I18n.format("options.renderDistance.far");
            var5 = 16;
         }

         if (var8 >= 32) {
            var4 = Lang.get("of.options.renderDistance.extreme");
            var5 = 32;
         }

         if (var8 >= 48) {
            var4 = Lang.get("of.options.renderDistance.insane");
            var5 = 48;
         }

         if (var8 >= 64) {
            var4 = Lang.get("of.options.renderDistance.ludicrous");
            var5 = 64;
         }

         int var6 = this.renderDistanceChunks - var5;
         String var7 = var4;
         if (var6 > 0) {
            var7 = var4 + "+";
         }

         return var2 + var8 + " " + var7;
      } else if (var1 == GameSettings.Options.FOG_FANCY) {
         switch(this.ofFogType) {
         case 1:
            return var2 + Lang.getFast();
         case 2:
            return var2 + Lang.getFancy();
         case 3:
            return var2 + Lang.getOff();
         default:
            return var2 + Lang.getOff();
         }
      } else if (var1 == GameSettings.Options.FOG_START) {
         return var2 + this.ofFogStart;
      } else if (var1 == GameSettings.Options.MIPMAP_TYPE) {
         switch(this.ofMipmapType) {
         case 0:
            return var2 + Lang.get("of.options.mipmap.nearest");
         case 1:
            return var2 + Lang.get("of.options.mipmap.linear");
         case 2:
            return var2 + Lang.get("of.options.mipmap.bilinear");
         case 3:
            return var2 + Lang.get("of.options.mipmap.trilinear");
         default:
            return var2 + "of.options.mipmap.nearest";
         }
      } else if (var1 == GameSettings.Options.SMOOTH_FPS) {
         return this.ofSmoothFps ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.SMOOTH_WORLD) {
         return this.ofSmoothWorld ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.CLOUDS) {
         switch(this.ofClouds) {
         case 1:
            return var2 + Lang.getFast();
         case 2:
            return var2 + Lang.getFancy();
         case 3:
            return var2 + Lang.getOff();
         default:
            return var2 + Lang.getDefault();
         }
      } else if (var1 == GameSettings.Options.TREES) {
         switch(this.ofTrees) {
         case 1:
            return var2 + Lang.getFast();
         case 2:
            return var2 + Lang.getFancy();
         case 3:
         default:
            return var2 + Lang.getDefault();
         case 4:
            return var2 + Lang.get("of.general.smart");
         }
      } else if (var1 == GameSettings.Options.DROPPED_ITEMS) {
         switch(this.ofDroppedItems) {
         case 1:
            return var2 + Lang.getFast();
         case 2:
            return var2 + Lang.getFancy();
         default:
            return var2 + Lang.getDefault();
         }
      } else if (var1 == GameSettings.Options.RAIN) {
         switch(this.ofRain) {
         case 1:
            return var2 + Lang.getFast();
         case 2:
            return var2 + Lang.getFancy();
         case 3:
            return var2 + Lang.getOff();
         default:
            return var2 + Lang.getDefault();
         }
      } else if (var1 == GameSettings.Options.ANIMATED_WATER) {
         switch(this.ofAnimatedWater) {
         case 1:
            return var2 + Lang.get("of.options.animation.dynamic");
         case 2:
            return var2 + Lang.getOff();
         default:
            return var2 + Lang.getOn();
         }
      } else if (var1 == GameSettings.Options.ANIMATED_LAVA) {
         switch(this.ofAnimatedLava) {
         case 1:
            return var2 + Lang.get("of.options.animation.dynamic");
         case 2:
            return var2 + Lang.getOff();
         default:
            return var2 + Lang.getOn();
         }
      } else if (var1 == GameSettings.Options.ANIMATED_FIRE) {
         return this.ofAnimatedFire ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.ANIMATED_PORTAL) {
         return this.ofAnimatedPortal ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.ANIMATED_REDSTONE) {
         return this.ofAnimatedRedstone ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.ANIMATED_EXPLOSION) {
         return this.ofAnimatedExplosion ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.ANIMATED_FLAME) {
         return this.ofAnimatedFlame ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.ANIMATED_SMOKE) {
         return this.ofAnimatedSmoke ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.VOID_PARTICLES) {
         return this.ofVoidParticles ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.WATER_PARTICLES) {
         return this.ofWaterParticles ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.PORTAL_PARTICLES) {
         return this.ofPortalParticles ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.POTION_PARTICLES) {
         return this.ofPotionParticles ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.FIREWORK_PARTICLES) {
         return this.ofFireworkParticles ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.DRIPPING_WATER_LAVA) {
         return this.ofDrippingWaterLava ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.ANIMATED_TERRAIN) {
         return this.ofAnimatedTerrain ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.ANIMATED_TEXTURES) {
         return this.ofAnimatedTextures ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.RAIN_SPLASH) {
         return this.ofRainSplash ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.LAGOMETER) {
         return this.ofLagometer ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.SHOW_FPS) {
         return this.ofShowFps ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.AUTOSAVE_TICKS) {
         short var10 = 900;
         if (this.ofAutoSaveTicks <= var10) {
            return var2 + Lang.get("of.options.save.45s");
         } else if (this.ofAutoSaveTicks <= 2 * var10) {
            return var2 + Lang.get("of.options.save.90s");
         } else if (this.ofAutoSaveTicks <= 4 * var10) {
            return var2 + Lang.get("of.options.save.3min");
         } else if (this.ofAutoSaveTicks <= 8 * var10) {
            return var2 + Lang.get("of.options.save.6min");
         } else {
            return this.ofAutoSaveTicks <= 16 * var10 ? var2 + Lang.get("of.options.save.12min") : var2 + Lang.get("of.options.save.24min");
         }
      } else if (var1 == GameSettings.Options.BETTER_GRASS) {
         switch(this.ofBetterGrass) {
         case 1:
            return var2 + Lang.getFast();
         case 2:
            return var2 + Lang.getFancy();
         default:
            return var2 + Lang.getOff();
         }
      } else if (var1 == GameSettings.Options.CONNECTED_TEXTURES) {
         switch(this.ofConnectedTextures) {
         case 1:
            return var2 + Lang.getFast();
         case 2:
            return var2 + Lang.getFancy();
         default:
            return var2 + Lang.getOff();
         }
      } else if (var1 == GameSettings.Options.WEATHER) {
         return this.ofWeather ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.SKY) {
         return this.ofSky ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.STARS) {
         return this.ofStars ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.SUN_MOON) {
         return this.ofSunMoon ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.VIGNETTE) {
         switch(this.ofVignette) {
         case 1:
            return var2 + Lang.getFast();
         case 2:
            return var2 + Lang.getFancy();
         default:
            return var2 + Lang.getDefault();
         }
      } else if (var1 == GameSettings.Options.CHUNK_UPDATES) {
         return var2 + this.ofChunkUpdates;
      } else if (var1 == GameSettings.Options.CHUNK_UPDATES_DYNAMIC) {
         return this.ofChunkUpdatesDynamic ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.TIME) {
         if (this.ofTime == 1) {
            return var2 + Lang.get("of.options.time.dayOnly");
         } else {
            return this.ofTime == 2 ? var2 + Lang.get("of.options.time.nightOnly") : var2 + Lang.getDefault();
         }
      } else if (var1 == GameSettings.Options.CLEAR_WATER) {
         return this.ofClearWater ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.AA_LEVEL) {
         String var9 = "";
         if (this.ofAaLevel != Config.getAntialiasingLevel()) {
            var9 = " (" + Lang.get("of.general.restart") + ")";
         }

         return this.ofAaLevel == 0 ? var2 + Lang.getOff() + var9 : var2 + this.ofAaLevel + var9;
      } else if (var1 == GameSettings.Options.AF_LEVEL) {
         return this.ofAfLevel == 1 ? var2 + Lang.getOff() : var2 + this.ofAfLevel;
      } else if (var1 == GameSettings.Options.PROFILER) {
         return this.ofProfiler ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.BETTER_SNOW) {
         return this.ofBetterSnow ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.SWAMP_COLORS) {
         return this.ofSwampColors ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.RANDOM_ENTITIES) {
         return this.ofRandomEntities ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.SMOOTH_BIOMES) {
         return this.ofSmoothBiomes ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.CUSTOM_FONTS) {
         return this.ofCustomFonts ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.CUSTOM_COLORS) {
         return this.ofCustomColors ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.CUSTOM_SKY) {
         return this.ofCustomSky ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.SHOW_CAPES) {
         return this.ofShowCapes ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.CUSTOM_ITEMS) {
         return this.ofCustomItems ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.NATURAL_TEXTURES) {
         return this.ofNaturalTextures ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.EMISSIVE_TEXTURES) {
         return this.ofEmissiveTextures ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.FAST_MATH) {
         return this.ofFastMath ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.FAST_RENDER) {
         return this.ofFastRender ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.TRANSLUCENT_BLOCKS) {
         if (this.ofTranslucentBlocks == 1) {
            return var2 + Lang.getFast();
         } else {
            return this.ofTranslucentBlocks == 2 ? var2 + Lang.getFancy() : var2 + Lang.getDefault();
         }
      } else if (var1 == GameSettings.Options.LAZY_CHUNK_LOADING) {
         return this.ofLazyChunkLoading ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.RENDER_REGIONS) {
         return this.ofRenderRegions ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.SMART_ANIMATIONS) {
         return this.ofSmartAnimations ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.DYNAMIC_FOV) {
         return this.ofDynamicFov ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.ALTERNATE_BLOCKS) {
         return this.ofAlternateBlocks ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.DYNAMIC_LIGHTS) {
         var8 = indexOf(this.ofDynamicLights, OF_DYNAMIC_LIGHTS);
         return var2 + getTranslation(KEYS_DYNAMIC_LIGHTS, var8);
      } else if (var1 == GameSettings.Options.SCREENSHOT_SIZE) {
         return this.ofScreenshotSize <= 1 ? var2 + Lang.getDefault() : var2 + this.ofScreenshotSize + "x";
      } else if (var1 == GameSettings.Options.CUSTOM_ENTITY_MODELS) {
         return this.ofCustomEntityModels ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.CUSTOM_GUIS) {
         return this.ofCustomGuis ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.SHOW_GL_ERRORS) {
         return this.ofShowGlErrors ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.FULLSCREEN_MODE) {
         return this.ofFullscreenMode.equals("Default") ? var2 + Lang.getDefault() : var2 + this.ofFullscreenMode;
      } else if (var1 == GameSettings.Options.HELD_ITEM_TOOLTIPS) {
         return this.heldItemTooltips ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.ADVANCED_TOOLTIPS) {
         return this.advancedItemTooltips ? var2 + Lang.getOn() : var2 + Lang.getOff();
      } else if (var1 == GameSettings.Options.FRAMERATE_LIMIT) {
         float var3 = this.getOptionFloatValue(var1);
         if (var3 == 0.0F) {
            return var2 + Lang.get("of.options.framerateLimit.vsync");
         } else {
            return var3 == GameSettings.Options.access$2(var1) ? var2 + I18n.format("options.framerateLimit.max") : var2 + (int)var3 + " fps";
         }
      } else {
         return null;
      }
   }

   public boolean getOptionOrdinalValue(GameSettings.Options var1) {
      switch($SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options()[var1.ordinal()]) {
      case 1:
         return this.invertMouse;
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 9:
      case 11:
      case 12:
      case 13:
      case 14:
      case 15:
      case 16:
      case 19:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 32:
      case 33:
      case 34:
      case 35:
      case 36:
      case 37:
      case 39:
      case 40:
      case 41:
      default:
         return false;
      case 7:
         return this.viewBobbing;
      case 8:
         return this.anaglyph;
      case 10:
         return this.fboEnable;
      case 17:
         return this.chatColours;
      case 18:
         return this.chatLinks;
      case 20:
         return this.chatLinksPrompt;
      case 21:
         return this.snooperEnabled;
      case 22:
         return this.fullScreen;
      case 23:
         return this.enableVsync;
      case 24:
         return this.useVbo;
      case 25:
         return this.touchscreen;
      case 31:
         return this.forceUnicodeFont;
      case 38:
         return this.streamSendMetadata;
      case 42:
         return this.allowBlockAlternatives;
      case 43:
         return this.reducedDebugInfo;
      case 44:
         return this.entityShadows;
      case 45:
         return this.realmsNotifications;
      }
   }

   public int shouldRenderClouds() {
      return this.renderDistanceChunks >= 4 ? this.clouds : 0;
   }

   public void saveOptions() {
      if (Reflector.FMLClientHandler.exists()) {
         Object var1 = Reflector.call(Reflector.FMLClientHandler_instance);
         if (var1 != null && Reflector.callBoolean(var1, Reflector.FMLClientHandler_isLoading)) {
            return;
         }
      }

      try {
         PrintWriter var7 = new PrintWriter(new FileWriter(this.optionsFile));
         var7.println("invertYMouse:" + this.invertMouse);
         var7.println("mouseSensitivity:" + this.mouseSensitivity);
         var7.println("fov:" + (this.fovSetting - 70.0F) / 40.0F);
         var7.println("gamma:" + this.gammaSetting);
         var7.println("saturation:" + this.saturation);
         var7.println("renderDistance:" + this.renderDistanceChunks);
         var7.println("guiScale:" + this.guiScale);
         var7.println("particles:" + this.particleSetting);
         var7.println("bobView:" + this.viewBobbing);
         var7.println("anaglyph3d:" + this.anaglyph);
         var7.println("maxFps:" + this.limitFramerate);
         var7.println("fboEnable:" + this.fboEnable);
         var7.println("difficulty:" + this.difficulty.getDifficultyId());
         var7.println("fancyGraphics:" + this.fancyGraphics);
         var7.println("ao:" + this.ambientOcclusion);
         switch(this.clouds) {
         case 0:
            var7.println("renderClouds:false");
            break;
         case 1:
            var7.println("renderClouds:fast");
            break;
         case 2:
            var7.println("renderClouds:true");
         }

         var7.println("resourcePacks:" + gson.toJson(this.resourcePacks));
         var7.println("incompatibleResourcePacks:" + gson.toJson(this.incompatibleResourcePacks));
         var7.println("lastServer:" + this.lastServer);
         var7.println("lang:" + this.language);
         var7.println("chatVisibility:" + this.chatVisibility.getChatVisibility());
         var7.println("chatColors:" + this.chatColours);
         var7.println("chatLinks:" + this.chatLinks);
         var7.println("chatLinksPrompt:" + this.chatLinksPrompt);
         var7.println("chatOpacity:" + this.chatOpacity);
         var7.println("snooperEnabled:" + this.snooperEnabled);
         var7.println("fullscreen:" + this.fullScreen);
         var7.println("enableVsync:" + this.enableVsync);
         var7.println("useVbo:" + this.useVbo);
         var7.println("hideServerAddress:" + this.hideServerAddress);
         var7.println("advancedItemTooltips:" + this.advancedItemTooltips);
         var7.println("pauseOnLostFocus:" + this.pauseOnLostFocus);
         var7.println("touchscreen:" + this.touchscreen);
         var7.println("overrideWidth:" + this.overrideWidth);
         var7.println("overrideHeight:" + this.overrideHeight);
         var7.println("heldItemTooltips:" + this.heldItemTooltips);
         var7.println("chatHeightFocused:" + this.chatHeightFocused);
         var7.println("chatHeightUnfocused:" + this.chatHeightUnfocused);
         var7.println("chatScale:" + this.chatScale);
         var7.println("chatWidth:" + this.chatWidth);
         var7.println("showInventoryAchievementHint:" + this.showInventoryAchievementHint);
         var7.println("mipmapLevels:" + this.mipmapLevels);
         var7.println("streamBytesPerPixel:" + this.streamBytesPerPixel);
         var7.println("streamMicVolume:" + this.streamMicVolume);
         var7.println("streamSystemVolume:" + this.streamGameVolume);
         var7.println("streamKbps:" + this.streamKbps);
         var7.println("streamFps:" + this.streamFps);
         var7.println("streamCompression:" + this.streamCompression);
         var7.println("streamSendMetadata:" + this.streamSendMetadata);
         var7.println("streamPreferredServer:" + this.streamPreferredServer);
         var7.println("streamChatEnabled:" + this.streamChatEnabled);
         var7.println("streamChatUserFilter:" + this.streamChatUserFilter);
         var7.println("streamMicToggleBehavior:" + this.streamMicToggleBehavior);
         var7.println("forceUnicodeFont:" + this.forceUnicodeFont);
         var7.println("allowBlockAlternatives:" + this.allowBlockAlternatives);
         var7.println("reducedDebugInfo:" + this.reducedDebugInfo);
         var7.println("useNativeTransport:" + this.useNativeTransport);
         var7.println("entityShadows:" + this.entityShadows);
         var7.println("realmsNotifications:" + this.realmsNotifications);
         KeyBinding[] var5;
         int var4 = (var5 = this.keyBindings).length;

         int var3;
         for(var3 = 0; var3 < var4; ++var3) {
            KeyBinding var2 = var5[var3];
            var7.println("key_" + var2.getKeyDescription() + ":" + var2.getKeyCode());
         }

         SoundCategory[] var10;
         var4 = (var10 = SoundCategory.values()).length;

         for(var3 = 0; var3 < var4; ++var3) {
            SoundCategory var8 = var10[var3];
            var7.println("soundCategory_" + var8.getCategoryName() + ":" + this.getSoundLevel(var8));
         }

         EnumPlayerModelParts[] var11;
         var4 = (var11 = EnumPlayerModelParts.values()).length;

         for(var3 = 0; var3 < var4; ++var3) {
            EnumPlayerModelParts var9 = var11[var3];
            var7.println("modelPart_" + var9.getPartName() + ":" + this.setModelParts.contains(var9));
         }

         var7.close();
      } catch (Exception var6) {
         logger.error("Failed to save options", var6);
      }

      this.saveOfOptions();
      this.sendSettingsToServer();
   }

   private void setOptionFloatValueOF(GameSettings.Options var1, float var2) {
      if (var1 == GameSettings.Options.CLOUD_HEIGHT) {
         this.ofCloudsHeight = var2;
         this.mc.renderGlobal.resetClouds();
      }

      if (var1 == GameSettings.Options.AO_LEVEL) {
         this.ofAoLevel = var2;
         this.mc.renderGlobal.loadRenderers();
      }

      int var3;
      if (var1 == GameSettings.Options.AA_LEVEL) {
         var3 = (int)var2;
         if (var3 > 0 && Config.isShaders()) {
            Config.showGuiMessage(Lang.get("of.message.aa.shaders1"), Lang.get("of.message.aa.shaders2"));
            return;
         }

         int[] var4 = new int[]{0, 2, 4, 6, 8, 12, 16};
         this.ofAaLevel = 0;

         for(int var5 = 0; var5 < var4.length; ++var5) {
            if (var3 >= var4[var5]) {
               this.ofAaLevel = var4[var5];
            }
         }

         this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
      }

      if (var1 == GameSettings.Options.AF_LEVEL) {
         var3 = (int)var2;
         if (var3 > 1 && Config.isShaders()) {
            Config.showGuiMessage(Lang.get("of.message.af.shaders1"), Lang.get("of.message.af.shaders2"));
            return;
         }

         for(this.ofAfLevel = 1; this.ofAfLevel * 2 <= var3; this.ofAfLevel *= 2) {
         }

         this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
         this.mc.refreshResources();
      }

      if (var1 == GameSettings.Options.MIPMAP_TYPE) {
         var3 = (int)var2;
         this.ofMipmapType = Config.limit(var3, 0, 3);
         this.mc.refreshResources();
      }

      if (var1 == GameSettings.Options.FULLSCREEN_MODE) {
         var3 = (int)var2 - 1;
         String[] var6 = Config.getDisplayModeNames();
         if (var3 < 0 || var3 >= var6.length) {
            this.ofFullscreenMode = "Default";
            return;
         }

         this.ofFullscreenMode = var6[var3];
      }

   }

   public GameSettings(Minecraft var1, File var2) {
      this.chatVisibility = EntityPlayer.EnumChatVisibility.FULL;
      this.chatColours = true;
      this.chatLinks = true;
      this.chatLinksPrompt = true;
      this.chatOpacity = 1.0F;
      this.snooperEnabled = true;
      this.enableVsync = true;
      this.useVbo = false;
      this.allowBlockAlternatives = true;
      this.reducedDebugInfo = false;
      this.pauseOnLostFocus = true;
      this.setModelParts = Sets.newHashSet(EnumPlayerModelParts.values());
      this.heldItemTooltips = true;
      this.chatScale = 1.0F;
      this.chatWidth = 1.0F;
      this.chatHeightUnfocused = 0.44366196F;
      this.chatHeightFocused = 1.0F;
      this.showInventoryAchievementHint = true;
      this.mipmapLevels = 4;
      this.mapSoundLevels = Maps.newEnumMap(SoundCategory.class);
      this.streamBytesPerPixel = 0.5F;
      this.streamMicVolume = 1.0F;
      this.streamGameVolume = 1.0F;
      this.streamKbps = 0.5412844F;
      this.streamFps = 0.31690142F;
      this.streamCompression = 1;
      this.streamSendMetadata = true;
      this.streamPreferredServer = "";
      this.streamChatEnabled = 0;
      this.streamChatUserFilter = 0;
      this.streamMicToggleBehavior = 0;
      this.useNativeTransport = true;
      this.entityShadows = true;
      this.realmsNotifications = true;
      this.keyBindForward = new KeyBinding("key.forward", 17, "key.categories.movement");
      this.keyBindLeft = new KeyBinding("key.left", 30, "key.categories.movement");
      this.keyBindBack = new KeyBinding("key.back", 31, "key.categories.movement");
      this.keyBindRight = new KeyBinding("key.right", 32, "key.categories.movement");
      this.keyBindJump = new KeyBinding("key.jump", 57, "key.categories.movement");
      this.keyBindSneak = new KeyBinding("key.sneak", 42, "key.categories.movement");
      this.keyBindSprint = new KeyBinding("key.sprint", 29, "key.categories.movement");
      this.keyBindInventory = new KeyBinding("key.inventory", 18, "key.categories.inventory");
      this.keyBindUseItem = new KeyBinding("key.use", -99, "key.categories.gameplay");
      this.keyBindDrop = new KeyBinding("key.drop", 16, "key.categories.gameplay");
      this.keyBindAttack = new KeyBinding("key.attack", -100, "key.categories.gameplay");
      this.keyBindPickBlock = new KeyBinding("key.pickItem", -98, "key.categories.gameplay");
      this.keyBindChat = new KeyBinding("key.chat", 20, "key.categories.multiplayer");
      this.keyBindPlayerList = new KeyBinding("key.playerlist", 15, "key.categories.multiplayer");
      this.keyBindCommand = new KeyBinding("key.command", 53, "key.categories.multiplayer");
      this.keyBindScreenshot = new KeyBinding("key.screenshot", 60, "key.categories.misc");
      this.keyBindTogglePerspective = new KeyBinding("key.togglePerspective", 63, "key.categories.misc");
      this.keyBindSmoothCamera = new KeyBinding("key.smoothCamera", 0, "key.categories.misc");
      this.keyBindFullscreen = new KeyBinding("key.fullscreen", 87, "key.categories.misc");
      this.keyBindSpectatorOutlines = new KeyBinding("key.spectatorOutlines", 0, "key.categories.misc");
      this.keyBindStreamStartStop = new KeyBinding("key.streamStartStop", 64, "key.categories.stream");
      this.keyBindStreamPauseUnpause = new KeyBinding("key.streamPauseUnpause", 65, "key.categories.stream");
      this.keyBindStreamCommercials = new KeyBinding("key.streamCommercial", 0, "key.categories.stream");
      this.keyBindStreamToggleMic = new KeyBinding("key.streamToggleMic", 0, "key.categories.stream");
      this.keyBindsHotbar = new KeyBinding[]{new KeyBinding("key.hotbar.1", 2, "key.categories.inventory"), new KeyBinding("key.hotbar.2", 3, "key.categories.inventory"), new KeyBinding("key.hotbar.3", 4, "key.categories.inventory"), new KeyBinding("key.hotbar.4", 5, "key.categories.inventory"), new KeyBinding("key.hotbar.5", 6, "key.categories.inventory"), new KeyBinding("key.hotbar.6", 7, "key.categories.inventory"), new KeyBinding("key.hotbar.7", 8, "key.categories.inventory"), new KeyBinding("key.hotbar.8", 9, "key.categories.inventory"), new KeyBinding("key.hotbar.9", 10, "key.categories.inventory")};
      this.keyBindAresHud = new KeyBinding("Opens the Hud", 54, "Ares");
      this.ofFogType = 1;
      this.ofFogStart = 0.8F;
      this.ofMipmapType = 0;
      this.ofOcclusionFancy = false;
      this.ofSmoothFps = false;
      this.ofSmoothWorld = Config.isSingleProcessor();
      this.ofLazyChunkLoading = Config.isSingleProcessor();
      this.ofRenderRegions = false;
      this.ofSmartAnimations = false;
      this.ofAoLevel = 1.0F;
      this.ofAaLevel = 0;
      this.ofAfLevel = 1;
      this.ofClouds = 0;
      this.ofCloudsHeight = 0.0F;
      this.ofTrees = 0;
      this.ofRain = 0;
      this.ofDroppedItems = 0;
      this.ofBetterGrass = 3;
      this.ofAutoSaveTicks = 4000;
      this.ofLagometer = false;
      this.ofProfiler = false;
      this.ofShowFps = false;
      this.ofWeather = true;
      this.ofSky = true;
      this.ofStars = true;
      this.ofSunMoon = true;
      this.ofVignette = 0;
      this.ofChunkUpdates = 1;
      this.ofChunkUpdatesDynamic = false;
      this.ofTime = 0;
      this.ofClearWater = false;
      this.ofBetterSnow = false;
      this.ofFullscreenMode = "Default";
      this.ofSwampColors = true;
      this.ofRandomEntities = true;
      this.ofSmoothBiomes = true;
      this.ofCustomFonts = true;
      this.ofCustomColors = true;
      this.ofCustomSky = true;
      this.ofShowCapes = true;
      this.ofConnectedTextures = 2;
      this.ofCustomItems = true;
      this.ofNaturalTextures = false;
      this.ofEmissiveTextures = true;
      this.ofFastMath = false;
      this.ofFastRender = false;
      this.ofTranslucentBlocks = 0;
      this.ofDynamicFov = true;
      this.ofAlternateBlocks = true;
      this.ofDynamicLights = 3;
      this.ofCustomEntityModels = true;
      this.ofCustomGuis = true;
      this.ofShowGlErrors = true;
      this.ofScreenshotSize = 1;
      this.ofAnimatedWater = 0;
      this.ofAnimatedLava = 0;
      this.ofAnimatedFire = true;
      this.ofAnimatedPortal = true;
      this.ofAnimatedRedstone = true;
      this.ofAnimatedExplosion = true;
      this.ofAnimatedFlame = true;
      this.ofAnimatedSmoke = true;
      this.ofVoidParticles = true;
      this.ofWaterParticles = true;
      this.ofRainSplash = true;
      this.ofPortalParticles = true;
      this.ofPotionParticles = true;
      this.ofFireworkParticles = true;
      this.ofDrippingWaterLava = true;
      this.ofAnimatedTerrain = true;
      this.ofAnimatedTextures = true;
      this.keyBindings = (KeyBinding[])ArrayUtils.addAll(new KeyBinding[]{this.keyBindAresHud, this.keyBindAttack, this.keyBindUseItem, this.keyBindForward, this.keyBindLeft, this.keyBindBack, this.keyBindRight, this.keyBindJump, this.keyBindSneak, this.keyBindSprint, this.keyBindDrop, this.keyBindInventory, this.keyBindChat, this.keyBindPlayerList, this.keyBindPickBlock, this.keyBindCommand, this.keyBindScreenshot, this.keyBindTogglePerspective, this.keyBindSmoothCamera, this.keyBindStreamStartStop, this.keyBindStreamPauseUnpause, this.keyBindStreamCommercials, this.keyBindStreamToggleMic, this.keyBindFullscreen, this.keyBindSpectatorOutlines}, this.keyBindsHotbar);
      this.difficulty = EnumDifficulty.NORMAL;
      this.lastServer = "";
      this.fovSetting = 70.0F;
      this.language = "en_US";
      this.forceUnicodeFont = false;
      this.mc = var1;
      this.optionsFile = new File(var2, "options.txt");
      if (var1.isJava64bit() && Runtime.getRuntime().maxMemory() >= 1000000000L) {
         GameSettings.Options.RENDER_DISTANCE.setValueMax(32.0F);
         long var3 = 1000000L;
         if (Runtime.getRuntime().maxMemory() >= 1500L * var3) {
            GameSettings.Options.RENDER_DISTANCE.setValueMax(48.0F);
         }

         if (Runtime.getRuntime().maxMemory() >= 2500L * var3) {
            GameSettings.Options.RENDER_DISTANCE.setValueMax(64.0F);
         }
      } else {
         GameSettings.Options.RENDER_DISTANCE.setValueMax(16.0F);
      }

      this.renderDistanceChunks = var1.isJava64bit() ? 12 : 8;
      this.optionsFileOF = new File(var2, "optionsof.txt");
      this.limitFramerate = (int)GameSettings.Options.FRAMERATE_LIMIT.getValueMax();
      this.ofKeyBindZoom = new KeyBinding("of.key.zoom", 46, "key.categories.misc");
      this.keyBindings = (KeyBinding[])ArrayUtils.add(this.keyBindings, this.ofKeyBindZoom);
      KeyUtils.fixKeyConflicts(this.keyBindings, new KeyBinding[]{this.ofKeyBindZoom});
      this.renderDistanceChunks = 8;
      this.loadOptions();
      Config.initGameSettings(this);
   }

   static int[] $SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[GameSettings.Options.values().length];

         try {
            var0[GameSettings.Options.AA_LEVEL.ordinal()] = 96;
         } catch (NoSuchFieldError var117) {
         }

         try {
            var0[GameSettings.Options.ADVANCED_TOOLTIPS.ordinal()] = 112;
         } catch (NoSuchFieldError var116) {
         }

         try {
            var0[GameSettings.Options.AF_LEVEL.ordinal()] = 97;
         } catch (NoSuchFieldError var115) {
         }

         try {
            var0[GameSettings.Options.ALTERNATE_BLOCKS.ordinal()] = 110;
         } catch (NoSuchFieldError var114) {
         }

         try {
            var0[GameSettings.Options.AMBIENT_OCCLUSION.ordinal()] = 13;
         } catch (NoSuchFieldError var113) {
         }

         try {
            var0[GameSettings.Options.ANAGLYPH.ordinal()] = 8;
         } catch (NoSuchFieldError var112) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_EXPLOSION.ordinal()] = 64;
         } catch (NoSuchFieldError var111) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_FIRE.ordinal()] = 56;
         } catch (NoSuchFieldError var110) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_FLAME.ordinal()] = 65;
         } catch (NoSuchFieldError var109) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_LAVA.ordinal()] = 55;
         } catch (NoSuchFieldError var108) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_PORTAL.ordinal()] = 57;
         } catch (NoSuchFieldError var107) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_REDSTONE.ordinal()] = 63;
         } catch (NoSuchFieldError var106) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_SMOKE.ordinal()] = 66;
         } catch (NoSuchFieldError var105) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_TERRAIN.ordinal()] = 87;
         } catch (NoSuchFieldError var104) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_TEXTURES.ordinal()] = 98;
         } catch (NoSuchFieldError var103) {
         }

         try {
            var0[GameSettings.Options.ANIMATED_WATER.ordinal()] = 54;
         } catch (NoSuchFieldError var102) {
         }

         try {
            var0[GameSettings.Options.AO_LEVEL.ordinal()] = 58;
         } catch (NoSuchFieldError var101) {
         }

         try {
            var0[GameSettings.Options.AUTOSAVE_TICKS.ordinal()] = 61;
         } catch (NoSuchFieldError var100) {
         }

         try {
            var0[GameSettings.Options.BETTER_GRASS.ordinal()] = 62;
         } catch (NoSuchFieldError var99) {
         }

         try {
            var0[GameSettings.Options.BETTER_SNOW.ordinal()] = 85;
         } catch (NoSuchFieldError var98) {
         }

         try {
            var0[GameSettings.Options.BLOCK_ALTERNATIVES.ordinal()] = 42;
         } catch (NoSuchFieldError var97) {
         }

         try {
            var0[GameSettings.Options.CHAT_COLOR.ordinal()] = 17;
         } catch (NoSuchFieldError var96) {
         }

         try {
            var0[GameSettings.Options.CHAT_HEIGHT_FOCUSED.ordinal()] = 28;
         } catch (NoSuchFieldError var95) {
         }

         try {
            var0[GameSettings.Options.CHAT_HEIGHT_UNFOCUSED.ordinal()] = 29;
         } catch (NoSuchFieldError var94) {
         }

         try {
            var0[GameSettings.Options.CHAT_LINKS.ordinal()] = 18;
         } catch (NoSuchFieldError var93) {
         }

         try {
            var0[GameSettings.Options.CHAT_LINKS_PROMPT.ordinal()] = 20;
         } catch (NoSuchFieldError var92) {
         }

         try {
            var0[GameSettings.Options.CHAT_OPACITY.ordinal()] = 19;
         } catch (NoSuchFieldError var91) {
         }

         try {
            var0[GameSettings.Options.CHAT_SCALE.ordinal()] = 26;
         } catch (NoSuchFieldError var90) {
         }

         try {
            var0[GameSettings.Options.CHAT_VISIBILITY.ordinal()] = 16;
         } catch (NoSuchFieldError var89) {
         }

         try {
            var0[GameSettings.Options.CHAT_WIDTH.ordinal()] = 27;
         } catch (NoSuchFieldError var88) {
         }

         try {
            var0[GameSettings.Options.CHUNK_UPDATES.ordinal()] = 72;
         } catch (NoSuchFieldError var87) {
         }

         try {
            var0[GameSettings.Options.CHUNK_UPDATES_DYNAMIC.ordinal()] = 73;
         } catch (NoSuchFieldError var86) {
         }

         try {
            var0[GameSettings.Options.CLEAR_WATER.ordinal()] = 75;
         } catch (NoSuchFieldError var85) {
         }

         try {
            var0[GameSettings.Options.CLOUDS.ordinal()] = 50;
         } catch (NoSuchFieldError var84) {
         }

         try {
            var0[GameSettings.Options.CLOUD_HEIGHT.ordinal()] = 51;
         } catch (NoSuchFieldError var83) {
         }

         try {
            var0[GameSettings.Options.CONNECTED_TEXTURES.ordinal()] = 94;
         } catch (NoSuchFieldError var82) {
         }

         try {
            var0[GameSettings.Options.CUSTOM_COLORS.ordinal()] = 92;
         } catch (NoSuchFieldError var81) {
         }

         try {
            var0[GameSettings.Options.CUSTOM_ENTITY_MODELS.ordinal()] = 111;
         } catch (NoSuchFieldError var80) {
         }

         try {
            var0[GameSettings.Options.CUSTOM_FONTS.ordinal()] = 91;
         } catch (NoSuchFieldError var79) {
         }

         try {
            var0[GameSettings.Options.CUSTOM_GUIS.ordinal()] = 114;
         } catch (NoSuchFieldError var78) {
         }

         try {
            var0[GameSettings.Options.CUSTOM_ITEMS.ordinal()] = 95;
         } catch (NoSuchFieldError var77) {
         }

         try {
            var0[GameSettings.Options.CUSTOM_SKY.ordinal()] = 104;
         } catch (NoSuchFieldError var76) {
         }

         try {
            var0[GameSettings.Options.DRIPPING_WATER_LAVA.ordinal()] = 84;
         } catch (NoSuchFieldError var75) {
         }

         try {
            var0[GameSettings.Options.DROPPED_ITEMS.ordinal()] = 102;
         } catch (NoSuchFieldError var74) {
         }

         try {
            var0[GameSettings.Options.DYNAMIC_FOV.ordinal()] = 108;
         } catch (NoSuchFieldError var73) {
         }

         try {
            var0[GameSettings.Options.DYNAMIC_LIGHTS.ordinal()] = 109;
         } catch (NoSuchFieldError var72) {
         }

         try {
            var0[GameSettings.Options.EMISSIVE_TEXTURES.ordinal()] = 100;
         } catch (NoSuchFieldError var71) {
         }

         try {
            var0[GameSettings.Options.ENABLE_VSYNC.ordinal()] = 23;
         } catch (NoSuchFieldError var70) {
         }

         try {
            var0[GameSettings.Options.ENTITY_SHADOWS.ordinal()] = 44;
         } catch (NoSuchFieldError var69) {
         }

         try {
            var0[GameSettings.Options.FAST_MATH.ordinal()] = 105;
         } catch (NoSuchFieldError var68) {
         }

         try {
            var0[GameSettings.Options.FAST_RENDER.ordinal()] = 106;
         } catch (NoSuchFieldError var67) {
         }

         try {
            var0[GameSettings.Options.FBO_ENABLE.ordinal()] = 10;
         } catch (NoSuchFieldError var66) {
         }

         try {
            var0[GameSettings.Options.FIREWORK_PARTICLES.ordinal()] = 82;
         } catch (NoSuchFieldError var65) {
         }

         try {
            var0[GameSettings.Options.FOG_FANCY.ordinal()] = 46;
         } catch (NoSuchFieldError var64) {
         }

         try {
            var0[GameSettings.Options.FOG_START.ordinal()] = 47;
         } catch (NoSuchFieldError var63) {
         }

         try {
            var0[GameSettings.Options.FORCE_UNICODE_FONT.ordinal()] = 31;
         } catch (NoSuchFieldError var62) {
         }

         try {
            var0[GameSettings.Options.FOV.ordinal()] = 3;
         } catch (NoSuchFieldError var61) {
         }

         try {
            var0[GameSettings.Options.FRAMERATE_LIMIT.ordinal()] = 9;
         } catch (NoSuchFieldError var60) {
         }

         try {
            var0[GameSettings.Options.FULLSCREEN_MODE.ordinal()] = 86;
         } catch (NoSuchFieldError var59) {
         }

         try {
            var0[GameSettings.Options.GAMMA.ordinal()] = 4;
         } catch (NoSuchFieldError var58) {
         }

         try {
            var0[GameSettings.Options.GRAPHICS.ordinal()] = 12;
         } catch (NoSuchFieldError var57) {
         }

         try {
            var0[GameSettings.Options.GUI_SCALE.ordinal()] = 14;
         } catch (NoSuchFieldError var56) {
         }

         try {
            var0[GameSettings.Options.HELD_ITEM_TOOLTIPS.ordinal()] = 101;
         } catch (NoSuchFieldError var55) {
         }

         try {
            var0[GameSettings.Options.INVERT_MOUSE.ordinal()] = 1;
         } catch (NoSuchFieldError var54) {
         }

         try {
            var0[GameSettings.Options.LAGOMETER.ordinal()] = 59;
         } catch (NoSuchFieldError var53) {
         }

         try {
            var0[GameSettings.Options.LAZY_CHUNK_LOADING.ordinal()] = 103;
         } catch (NoSuchFieldError var52) {
         }

         try {
            var0[GameSettings.Options.MIPMAP_LEVELS.ordinal()] = 30;
         } catch (NoSuchFieldError var51) {
         }

         try {
            var0[GameSettings.Options.MIPMAP_TYPE.ordinal()] = 48;
         } catch (NoSuchFieldError var50) {
         }

         try {
            var0[GameSettings.Options.NATURAL_TEXTURES.ordinal()] = 99;
         } catch (NoSuchFieldError var49) {
         }

         try {
            var0[GameSettings.Options.PARTICLES.ordinal()] = 15;
         } catch (NoSuchFieldError var48) {
         }

         try {
            var0[GameSettings.Options.PORTAL_PARTICLES.ordinal()] = 80;
         } catch (NoSuchFieldError var47) {
         }

         try {
            var0[GameSettings.Options.POTION_PARTICLES.ordinal()] = 81;
         } catch (NoSuchFieldError var46) {
         }

         try {
            var0[GameSettings.Options.PROFILER.ordinal()] = 83;
         } catch (NoSuchFieldError var45) {
         }

         try {
            var0[GameSettings.Options.RAIN.ordinal()] = 53;
         } catch (NoSuchFieldError var44) {
         }

         try {
            var0[GameSettings.Options.RAIN_SPLASH.ordinal()] = 79;
         } catch (NoSuchFieldError var43) {
         }

         try {
            var0[GameSettings.Options.RANDOM_ENTITIES.ordinal()] = 89;
         } catch (NoSuchFieldError var42) {
         }

         try {
            var0[GameSettings.Options.REALMS_NOTIFICATIONS.ordinal()] = 45;
         } catch (NoSuchFieldError var41) {
         }

         try {
            var0[GameSettings.Options.REDUCED_DEBUG_INFO.ordinal()] = 43;
         } catch (NoSuchFieldError var40) {
         }

         try {
            var0[GameSettings.Options.RENDER_CLOUDS.ordinal()] = 11;
         } catch (NoSuchFieldError var39) {
         }

         try {
            var0[GameSettings.Options.RENDER_DISTANCE.ordinal()] = 6;
         } catch (NoSuchFieldError var38) {
         }

         try {
            var0[GameSettings.Options.RENDER_REGIONS.ordinal()] = 115;
         } catch (NoSuchFieldError var37) {
         }

         try {
            var0[GameSettings.Options.SATURATION.ordinal()] = 5;
         } catch (NoSuchFieldError var36) {
         }

         try {
            var0[GameSettings.Options.SCREENSHOT_SIZE.ordinal()] = 113;
         } catch (NoSuchFieldError var35) {
         }

         try {
            var0[GameSettings.Options.SENSITIVITY.ordinal()] = 2;
         } catch (NoSuchFieldError var34) {
         }

         try {
            var0[GameSettings.Options.SHOW_CAPES.ordinal()] = 93;
         } catch (NoSuchFieldError var33) {
         }

         try {
            var0[GameSettings.Options.SHOW_FPS.ordinal()] = 60;
         } catch (NoSuchFieldError var32) {
         }

         try {
            var0[GameSettings.Options.SHOW_GL_ERRORS.ordinal()] = 116;
         } catch (NoSuchFieldError var31) {
         }

         try {
            var0[GameSettings.Options.SKY.ordinal()] = 68;
         } catch (NoSuchFieldError var30) {
         }

         try {
            var0[GameSettings.Options.SMART_ANIMATIONS.ordinal()] = 117;
         } catch (NoSuchFieldError var29) {
         }

         try {
            var0[GameSettings.Options.SMOOTH_BIOMES.ordinal()] = 90;
         } catch (NoSuchFieldError var28) {
         }

         try {
            var0[GameSettings.Options.SMOOTH_FPS.ordinal()] = 49;
         } catch (NoSuchFieldError var27) {
         }

         try {
            var0[GameSettings.Options.SMOOTH_WORLD.ordinal()] = 76;
         } catch (NoSuchFieldError var26) {
         }

         try {
            var0[GameSettings.Options.SNOOPER_ENABLED.ordinal()] = 21;
         } catch (NoSuchFieldError var25) {
         }

         try {
            var0[GameSettings.Options.STARS.ordinal()] = 69;
         } catch (NoSuchFieldError var24) {
         }

         try {
            var0[GameSettings.Options.STREAM_BYTES_PER_PIXEL.ordinal()] = 32;
         } catch (NoSuchFieldError var23) {
         }

         try {
            var0[GameSettings.Options.STREAM_CHAT_ENABLED.ordinal()] = 39;
         } catch (NoSuchFieldError var22) {
         }

         try {
            var0[GameSettings.Options.STREAM_CHAT_USER_FILTER.ordinal()] = 40;
         } catch (NoSuchFieldError var21) {
         }

         try {
            var0[GameSettings.Options.STREAM_COMPRESSION.ordinal()] = 37;
         } catch (NoSuchFieldError var20) {
         }

         try {
            var0[GameSettings.Options.STREAM_FPS.ordinal()] = 36;
         } catch (NoSuchFieldError var19) {
         }

         try {
            var0[GameSettings.Options.STREAM_KBPS.ordinal()] = 35;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[GameSettings.Options.STREAM_MIC_TOGGLE_BEHAVIOR.ordinal()] = 41;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[GameSettings.Options.STREAM_SEND_METADATA.ordinal()] = 38;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[GameSettings.Options.STREAM_VOLUME_MIC.ordinal()] = 33;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[GameSettings.Options.STREAM_VOLUME_SYSTEM.ordinal()] = 34;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[GameSettings.Options.SUN_MOON.ordinal()] = 70;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[GameSettings.Options.SWAMP_COLORS.ordinal()] = 88;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[GameSettings.Options.TIME.ordinal()] = 74;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[GameSettings.Options.TOUCHSCREEN.ordinal()] = 25;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[GameSettings.Options.TRANSLUCENT_BLOCKS.ordinal()] = 107;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[GameSettings.Options.TREES.ordinal()] = 52;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[GameSettings.Options.USE_FULLSCREEN.ordinal()] = 22;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[GameSettings.Options.USE_VBO.ordinal()] = 24;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[GameSettings.Options.VIEW_BOBBING.ordinal()] = 7;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[GameSettings.Options.VIGNETTE.ordinal()] = 71;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[GameSettings.Options.VOID_PARTICLES.ordinal()] = 77;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[GameSettings.Options.WATER_PARTICLES.ordinal()] = 78;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[GameSettings.Options.WEATHER.ordinal()] = 67;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$client$settings$GameSettings$Options = var0;
         return var0;
      }
   }

   private static int indexOf(int var0, int[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         if (var1[var2] == var0) {
            return var2;
         }
      }

      return -1;
   }

   private float parseFloat(String var1) {
      return var1.equals("true") ? 1.0F : (var1.equals("false") ? 0.0F : Float.parseFloat(var1));
   }

   public void loadOfOptions() {
      try {
         File var1 = this.optionsFileOF;
         if (!var1.exists()) {
            var1 = this.optionsFile;
         }

         if (!var1.exists()) {
            return;
         }

         BufferedReader var2 = new BufferedReader(new InputStreamReader(new FileInputStream(var1), "UTF-8"));
         String var3 = "";

         while((var3 = var2.readLine()) != null) {
            try {
               String[] var4 = var3.split(":");
               if (var4[0].equals("ofRenderDistanceChunks") && var4.length >= 2) {
                  this.renderDistanceChunks = Integer.valueOf(var4[1]);
                  this.renderDistanceChunks = Config.limit(this.renderDistanceChunks, 2, 1024);
               }

               if (var4[0].equals("ofFogType") && var4.length >= 2) {
                  this.ofFogType = Integer.valueOf(var4[1]);
                  this.ofFogType = Config.limit(this.ofFogType, 1, 3);
               }

               if (var4[0].equals("ofFogStart") && var4.length >= 2) {
                  this.ofFogStart = Float.valueOf(var4[1]);
                  if (this.ofFogStart < 0.2F) {
                     this.ofFogStart = 0.2F;
                  }

                  if (this.ofFogStart > 0.81F) {
                     this.ofFogStart = 0.8F;
                  }
               }

               if (var4[0].equals("ofMipmapType") && var4.length >= 2) {
                  this.ofMipmapType = Integer.valueOf(var4[1]);
                  this.ofMipmapType = Config.limit(this.ofMipmapType, 0, 3);
               }

               if (var4[0].equals("ofOcclusionFancy") && var4.length >= 2) {
                  this.ofOcclusionFancy = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofSmoothFps") && var4.length >= 2) {
                  this.ofSmoothFps = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofSmoothWorld") && var4.length >= 2) {
                  this.ofSmoothWorld = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAoLevel") && var4.length >= 2) {
                  this.ofAoLevel = Float.valueOf(var4[1]);
                  this.ofAoLevel = Config.limit(this.ofAoLevel, 0.0F, 1.0F);
               }

               if (var4[0].equals("ofClouds") && var4.length >= 2) {
                  this.ofClouds = Integer.valueOf(var4[1]);
                  this.ofClouds = Config.limit(this.ofClouds, 0, 3);
                  this.updateRenderClouds();
               }

               if (var4[0].equals("ofCloudsHeight") && var4.length >= 2) {
                  this.ofCloudsHeight = Float.valueOf(var4[1]);
                  this.ofCloudsHeight = Config.limit(this.ofCloudsHeight, 0.0F, 1.0F);
               }

               if (var4[0].equals("ofTrees") && var4.length >= 2) {
                  this.ofTrees = Integer.valueOf(var4[1]);
                  this.ofTrees = limit(this.ofTrees, OF_TREES_VALUES);
               }

               if (var4[0].equals("ofDroppedItems") && var4.length >= 2) {
                  this.ofDroppedItems = Integer.valueOf(var4[1]);
                  this.ofDroppedItems = Config.limit(this.ofDroppedItems, 0, 2);
               }

               if (var4[0].equals("ofRain") && var4.length >= 2) {
                  this.ofRain = Integer.valueOf(var4[1]);
                  this.ofRain = Config.limit(this.ofRain, 0, 3);
               }

               if (var4[0].equals("ofAnimatedWater") && var4.length >= 2) {
                  this.ofAnimatedWater = Integer.valueOf(var4[1]);
                  this.ofAnimatedWater = Config.limit(this.ofAnimatedWater, 0, 2);
               }

               if (var4[0].equals("ofAnimatedLava") && var4.length >= 2) {
                  this.ofAnimatedLava = Integer.valueOf(var4[1]);
                  this.ofAnimatedLava = Config.limit(this.ofAnimatedLava, 0, 2);
               }

               if (var4[0].equals("ofAnimatedFire") && var4.length >= 2) {
                  this.ofAnimatedFire = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAnimatedPortal") && var4.length >= 2) {
                  this.ofAnimatedPortal = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAnimatedRedstone") && var4.length >= 2) {
                  this.ofAnimatedRedstone = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAnimatedExplosion") && var4.length >= 2) {
                  this.ofAnimatedExplosion = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAnimatedFlame") && var4.length >= 2) {
                  this.ofAnimatedFlame = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAnimatedSmoke") && var4.length >= 2) {
                  this.ofAnimatedSmoke = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofVoidParticles") && var4.length >= 2) {
                  this.ofVoidParticles = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofWaterParticles") && var4.length >= 2) {
                  this.ofWaterParticles = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofPortalParticles") && var4.length >= 2) {
                  this.ofPortalParticles = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofPotionParticles") && var4.length >= 2) {
                  this.ofPotionParticles = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofFireworkParticles") && var4.length >= 2) {
                  this.ofFireworkParticles = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofDrippingWaterLava") && var4.length >= 2) {
                  this.ofDrippingWaterLava = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAnimatedTerrain") && var4.length >= 2) {
                  this.ofAnimatedTerrain = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAnimatedTextures") && var4.length >= 2) {
                  this.ofAnimatedTextures = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofRainSplash") && var4.length >= 2) {
                  this.ofRainSplash = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofLagometer") && var4.length >= 2) {
                  this.ofLagometer = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofShowFps") && var4.length >= 2) {
                  this.ofShowFps = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAutoSaveTicks") && var4.length >= 2) {
                  this.ofAutoSaveTicks = Integer.valueOf(var4[1]);
                  this.ofAutoSaveTicks = Config.limit(this.ofAutoSaveTicks, 40, 40000);
               }

               if (var4[0].equals("ofBetterGrass") && var4.length >= 2) {
                  this.ofBetterGrass = Integer.valueOf(var4[1]);
                  this.ofBetterGrass = Config.limit(this.ofBetterGrass, 1, 3);
               }

               if (var4[0].equals("ofConnectedTextures") && var4.length >= 2) {
                  this.ofConnectedTextures = Integer.valueOf(var4[1]);
                  this.ofConnectedTextures = Config.limit(this.ofConnectedTextures, 1, 3);
               }

               if (var4[0].equals("ofWeather") && var4.length >= 2) {
                  this.ofWeather = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofSky") && var4.length >= 2) {
                  this.ofSky = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofStars") && var4.length >= 2) {
                  this.ofStars = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofSunMoon") && var4.length >= 2) {
                  this.ofSunMoon = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofVignette") && var4.length >= 2) {
                  this.ofVignette = Integer.valueOf(var4[1]);
                  this.ofVignette = Config.limit(this.ofVignette, 0, 2);
               }

               if (var4[0].equals("ofChunkUpdates") && var4.length >= 2) {
                  this.ofChunkUpdates = Integer.valueOf(var4[1]);
                  this.ofChunkUpdates = Config.limit(this.ofChunkUpdates, 1, 5);
               }

               if (var4[0].equals("ofChunkUpdatesDynamic") && var4.length >= 2) {
                  this.ofChunkUpdatesDynamic = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofTime") && var4.length >= 2) {
                  this.ofTime = Integer.valueOf(var4[1]);
                  this.ofTime = Config.limit(this.ofTime, 0, 2);
               }

               if (var4[0].equals("ofClearWater") && var4.length >= 2) {
                  this.ofClearWater = Boolean.valueOf(var4[1]);
                  this.updateWaterOpacity();
               }

               if (var4[0].equals("ofAaLevel") && var4.length >= 2) {
                  this.ofAaLevel = Integer.valueOf(var4[1]);
                  this.ofAaLevel = Config.limit(this.ofAaLevel, 0, 16);
               }

               if (var4[0].equals("ofAfLevel") && var4.length >= 2) {
                  this.ofAfLevel = Integer.valueOf(var4[1]);
                  this.ofAfLevel = Config.limit(this.ofAfLevel, 1, 16);
               }

               if (var4[0].equals("ofProfiler") && var4.length >= 2) {
                  this.ofProfiler = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofBetterSnow") && var4.length >= 2) {
                  this.ofBetterSnow = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofSwampColors") && var4.length >= 2) {
                  this.ofSwampColors = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofRandomEntities") && var4.length >= 2) {
                  this.ofRandomEntities = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofSmoothBiomes") && var4.length >= 2) {
                  this.ofSmoothBiomes = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofCustomFonts") && var4.length >= 2) {
                  this.ofCustomFonts = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofCustomColors") && var4.length >= 2) {
                  this.ofCustomColors = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofCustomItems") && var4.length >= 2) {
                  this.ofCustomItems = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofCustomSky") && var4.length >= 2) {
                  this.ofCustomSky = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofShowCapes") && var4.length >= 2) {
                  this.ofShowCapes = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofNaturalTextures") && var4.length >= 2) {
                  this.ofNaturalTextures = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofEmissiveTextures") && var4.length >= 2) {
                  this.ofEmissiveTextures = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofLazyChunkLoading") && var4.length >= 2) {
                  this.ofLazyChunkLoading = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofRenderRegions") && var4.length >= 2) {
                  this.ofRenderRegions = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofSmartAnimations") && var4.length >= 2) {
                  this.ofSmartAnimations = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofDynamicFov") && var4.length >= 2) {
                  this.ofDynamicFov = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofAlternateBlocks") && var4.length >= 2) {
                  this.ofAlternateBlocks = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofDynamicLights") && var4.length >= 2) {
                  this.ofDynamicLights = Integer.valueOf(var4[1]);
                  this.ofDynamicLights = limit(this.ofDynamicLights, OF_DYNAMIC_LIGHTS);
               }

               if (var4[0].equals("ofScreenshotSize") && var4.length >= 2) {
                  this.ofScreenshotSize = Integer.valueOf(var4[1]);
                  this.ofScreenshotSize = Config.limit(this.ofScreenshotSize, 1, 4);
               }

               if (var4[0].equals("ofCustomEntityModels") && var4.length >= 2) {
                  this.ofCustomEntityModels = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofCustomGuis") && var4.length >= 2) {
                  this.ofCustomGuis = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofShowGlErrors") && var4.length >= 2) {
                  this.ofShowGlErrors = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofFullscreenMode") && var4.length >= 2) {
                  this.ofFullscreenMode = var4[1];
               }

               if (var4[0].equals("ofFastMath") && var4.length >= 2) {
                  this.ofFastMath = Boolean.valueOf(var4[1]);
                  MathHelper.fastMath = this.ofFastMath;
               }

               if (var4[0].equals("ofFastRender") && var4.length >= 2) {
                  this.ofFastRender = Boolean.valueOf(var4[1]);
               }

               if (var4[0].equals("ofTranslucentBlocks") && var4.length >= 2) {
                  this.ofTranslucentBlocks = Integer.valueOf(var4[1]);
                  this.ofTranslucentBlocks = Config.limit(this.ofTranslucentBlocks, 0, 2);
               }

               if (var4[0].equals("key_" + this.ofKeyBindZoom.getKeyDescription())) {
                  this.ofKeyBindZoom.setKeyCode(Integer.parseInt(var4[1]));
               }
            } catch (Exception var5) {
               Config.dbg("Skipping bad option: " + var3);
               var5.printStackTrace();
            }
         }

         KeyUtils.fixKeyConflicts(this.keyBindings, new KeyBinding[]{this.ofKeyBindZoom});
         KeyBinding.resetKeyBindingArrayAndHash();
         var2.close();
      } catch (Exception var6) {
         Config.warn("Failed to load options");
         var6.printStackTrace();
      }

   }

   public Set<EnumPlayerModelParts> getModelParts() {
      return ImmutableSet.copyOf(this.setModelParts);
   }

   public static String getKeyDisplayString(int var0) {
      return var0 < 0 ? I18n.format("key.mouseButton", var0 + 101) : (var0 < 256 ? Keyboard.getKeyName(var0) : String.format("%c", (char)(var0 - 256)).toUpperCase());
   }

   public void saveOfOptions() {
      try {
         PrintWriter var1 = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.optionsFileOF), "UTF-8"));
         var1.println("ofFogType:" + this.ofFogType);
         var1.println("ofFogStart:" + this.ofFogStart);
         var1.println("ofMipmapType:" + this.ofMipmapType);
         var1.println("ofOcclusionFancy:" + this.ofOcclusionFancy);
         var1.println("ofSmoothFps:" + this.ofSmoothFps);
         var1.println("ofSmoothWorld:" + this.ofSmoothWorld);
         var1.println("ofAoLevel:" + this.ofAoLevel);
         var1.println("ofClouds:" + this.ofClouds);
         var1.println("ofCloudsHeight:" + this.ofCloudsHeight);
         var1.println("ofTrees:" + this.ofTrees);
         var1.println("ofDroppedItems:" + this.ofDroppedItems);
         var1.println("ofRain:" + this.ofRain);
         var1.println("ofAnimatedWater:" + this.ofAnimatedWater);
         var1.println("ofAnimatedLava:" + this.ofAnimatedLava);
         var1.println("ofAnimatedFire:" + this.ofAnimatedFire);
         var1.println("ofAnimatedPortal:" + this.ofAnimatedPortal);
         var1.println("ofAnimatedRedstone:" + this.ofAnimatedRedstone);
         var1.println("ofAnimatedExplosion:" + this.ofAnimatedExplosion);
         var1.println("ofAnimatedFlame:" + this.ofAnimatedFlame);
         var1.println("ofAnimatedSmoke:" + this.ofAnimatedSmoke);
         var1.println("ofVoidParticles:" + this.ofVoidParticles);
         var1.println("ofWaterParticles:" + this.ofWaterParticles);
         var1.println("ofPortalParticles:" + this.ofPortalParticles);
         var1.println("ofPotionParticles:" + this.ofPotionParticles);
         var1.println("ofFireworkParticles:" + this.ofFireworkParticles);
         var1.println("ofDrippingWaterLava:" + this.ofDrippingWaterLava);
         var1.println("ofAnimatedTerrain:" + this.ofAnimatedTerrain);
         var1.println("ofAnimatedTextures:" + this.ofAnimatedTextures);
         var1.println("ofRainSplash:" + this.ofRainSplash);
         var1.println("ofLagometer:" + this.ofLagometer);
         var1.println("ofShowFps:" + this.ofShowFps);
         var1.println("ofAutoSaveTicks:" + this.ofAutoSaveTicks);
         var1.println("ofBetterGrass:" + this.ofBetterGrass);
         var1.println("ofConnectedTextures:" + this.ofConnectedTextures);
         var1.println("ofWeather:" + this.ofWeather);
         var1.println("ofSky:" + this.ofSky);
         var1.println("ofStars:" + this.ofStars);
         var1.println("ofSunMoon:" + this.ofSunMoon);
         var1.println("ofVignette:" + this.ofVignette);
         var1.println("ofChunkUpdates:" + this.ofChunkUpdates);
         var1.println("ofChunkUpdatesDynamic:" + this.ofChunkUpdatesDynamic);
         var1.println("ofTime:" + this.ofTime);
         var1.println("ofClearWater:" + this.ofClearWater);
         var1.println("ofAaLevel:" + this.ofAaLevel);
         var1.println("ofAfLevel:" + this.ofAfLevel);
         var1.println("ofProfiler:" + this.ofProfiler);
         var1.println("ofBetterSnow:" + this.ofBetterSnow);
         var1.println("ofSwampColors:" + this.ofSwampColors);
         var1.println("ofRandomEntities:" + this.ofRandomEntities);
         var1.println("ofSmoothBiomes:" + this.ofSmoothBiomes);
         var1.println("ofCustomFonts:" + this.ofCustomFonts);
         var1.println("ofCustomColors:" + this.ofCustomColors);
         var1.println("ofCustomItems:" + this.ofCustomItems);
         var1.println("ofCustomSky:" + this.ofCustomSky);
         var1.println("ofShowCapes:" + this.ofShowCapes);
         var1.println("ofNaturalTextures:" + this.ofNaturalTextures);
         var1.println("ofEmissiveTextures:" + this.ofEmissiveTextures);
         var1.println("ofLazyChunkLoading:" + this.ofLazyChunkLoading);
         var1.println("ofRenderRegions:" + this.ofRenderRegions);
         var1.println("ofSmartAnimations:" + this.ofSmartAnimations);
         var1.println("ofDynamicFov:" + this.ofDynamicFov);
         var1.println("ofAlternateBlocks:" + this.ofAlternateBlocks);
         var1.println("ofDynamicLights:" + this.ofDynamicLights);
         var1.println("ofScreenshotSize:" + this.ofScreenshotSize);
         var1.println("ofCustomEntityModels:" + this.ofCustomEntityModels);
         var1.println("ofCustomGuis:" + this.ofCustomGuis);
         var1.println("ofShowGlErrors:" + this.ofShowGlErrors);
         var1.println("ofFullscreenMode:" + this.ofFullscreenMode);
         var1.println("ofFastMath:" + this.ofFastMath);
         var1.println("ofFastRender:" + this.ofFastRender);
         var1.println("ofTranslucentBlocks:" + this.ofTranslucentBlocks);
         var1.println("key_" + this.ofKeyBindZoom.getKeyDescription() + ":" + this.ofKeyBindZoom.getKeyCode());
         var1.close();
      } catch (Exception var2) {
         Config.warn("Failed to save options");
         var2.printStackTrace();
      }

   }

   public void setSoundLevel(SoundCategory var1, float var2) {
      this.mc.getSoundHandler().setSoundLevel(var1, var2);
      this.mapSoundLevels.put(var1, var2);
   }

   private void updateRenderClouds() {
      switch(this.ofClouds) {
      case 1:
         this.clouds = 1;
         break;
      case 2:
         this.clouds = 2;
         break;
      case 3:
         this.clouds = 0;
         break;
      default:
         if (this.fancyGraphics) {
            this.clouds = 2;
         } else {
            this.clouds = 1;
         }
      }

   }

   public void sendSettingsToServer() {
      if (this.mc.thePlayer != null) {
         int var1 = 0;

         EnumPlayerModelParts var2;
         for(Iterator var3 = this.setModelParts.iterator(); var3.hasNext(); var1 |= var2.getPartMask()) {
            var2 = (EnumPlayerModelParts)var3.next();
         }

         this.mc.thePlayer.sendQueue.addToSendQueue(new C15PacketClientSettings(this.language, this.renderDistanceChunks, this.chatVisibility, this.chatColours, var1));
      }

   }

   public boolean isUsingNativeTransport() {
      return this.useNativeTransport;
   }

   public static enum Options {
      STREAM_SEND_METADATA("options.stream.sendMetadata", false, true),
      DRIPPING_WATER_LAVA("of.options.DRIPPING_WATER_LAVA", false, false),
      STREAM_COMPRESSION("options.stream.compression", false, false),
      DYNAMIC_FOV("of.options.DYNAMIC_FOV", false, false),
      ANIMATED_TERRAIN("of.options.ANIMATED_TERRAIN", false, false),
      AMBIENT_OCCLUSION("options.ao", false, false),
      FIREWORK_PARTICLES("of.options.FIREWORK_PARTICLES", false, false),
      SATURATION("options.saturation", true, false),
      VIGNETTE("of.options.VIGNETTE", false, false),
      TOUCHSCREEN("options.touchscreen", false, true),
      STREAM_FPS("options.stream.fps", true, false),
      SMOOTH_FPS("of.options.SMOOTH_FPS", false, false),
      SCREENSHOT_SIZE("of.options.SCREENSHOT_SIZE", false, false),
      CHAT_HEIGHT_FOCUSED("options.chat.height.focused", true, false),
      ANIMATED_LAVA("of.options.ANIMATED_LAVA", false, false),
      RANDOM_ENTITIES("of.options.RANDOM_ENTITIES", false, false),
      REALMS_NOTIFICATIONS("options.realmsNotifications", false, true),
      CHAT_COLOR("options.chat.color", false, true),
      USE_VBO("options.vbo", false, true),
      ANIMATED_WATER("of.options.ANIMATED_WATER", false, false),
      WATER_PARTICLES("of.options.WATER_PARTICLES", false, false),
      BETTER_SNOW("of.options.BETTER_SNOW", false, false),
      PORTAL_PARTICLES("of.options.PORTAL_PARTICLES", false, false),
      TRANSLUCENT_BLOCKS("of.options.TRANSLUCENT_BLOCKS", false, false),
      LAGOMETER("of.options.LAGOMETER", false, false),
      INVERT_MOUSE("options.invertMouse", false, true),
      FRAMERATE_LIMIT("options.framerateLimit", true, false, 0.0F, 260.0F, 5.0F),
      STARS("of.options.STARS", false, false),
      GRAPHICS("options.graphics", false, false),
      FBO_ENABLE("options.fboEnable", false, true),
      ANIMATED_TEXTURES("of.options.ANIMATED_TEXTURES", false, false);

      private static final GameSettings.Options[] ENUM$VALUES = new GameSettings.Options[]{INVERT_MOUSE, SENSITIVITY, FOV, GAMMA, SATURATION, RENDER_DISTANCE, VIEW_BOBBING, ANAGLYPH, FRAMERATE_LIMIT, FBO_ENABLE, RENDER_CLOUDS, GRAPHICS, AMBIENT_OCCLUSION, GUI_SCALE, PARTICLES, CHAT_VISIBILITY, CHAT_COLOR, CHAT_LINKS, CHAT_OPACITY, CHAT_LINKS_PROMPT, SNOOPER_ENABLED, USE_FULLSCREEN, ENABLE_VSYNC, USE_VBO, TOUCHSCREEN, CHAT_SCALE, CHAT_WIDTH, CHAT_HEIGHT_FOCUSED, CHAT_HEIGHT_UNFOCUSED, MIPMAP_LEVELS, FORCE_UNICODE_FONT, STREAM_BYTES_PER_PIXEL, STREAM_VOLUME_MIC, STREAM_VOLUME_SYSTEM, STREAM_KBPS, STREAM_FPS, STREAM_COMPRESSION, STREAM_SEND_METADATA, STREAM_CHAT_ENABLED, STREAM_CHAT_USER_FILTER, STREAM_MIC_TOGGLE_BEHAVIOR, BLOCK_ALTERNATIVES, REDUCED_DEBUG_INFO, ENTITY_SHADOWS, REALMS_NOTIFICATIONS, FOG_FANCY, FOG_START, MIPMAP_TYPE, SMOOTH_FPS, CLOUDS, CLOUD_HEIGHT, TREES, RAIN, ANIMATED_WATER, ANIMATED_LAVA, ANIMATED_FIRE, ANIMATED_PORTAL, AO_LEVEL, LAGOMETER, SHOW_FPS, AUTOSAVE_TICKS, BETTER_GRASS, ANIMATED_REDSTONE, ANIMATED_EXPLOSION, ANIMATED_FLAME, ANIMATED_SMOKE, WEATHER, SKY, STARS, SUN_MOON, VIGNETTE, CHUNK_UPDATES, CHUNK_UPDATES_DYNAMIC, TIME, CLEAR_WATER, SMOOTH_WORLD, VOID_PARTICLES, WATER_PARTICLES, RAIN_SPLASH, PORTAL_PARTICLES, POTION_PARTICLES, FIREWORK_PARTICLES, PROFILER, DRIPPING_WATER_LAVA, BETTER_SNOW, FULLSCREEN_MODE, ANIMATED_TERRAIN, SWAMP_COLORS, RANDOM_ENTITIES, SMOOTH_BIOMES, CUSTOM_FONTS, CUSTOM_COLORS, SHOW_CAPES, CONNECTED_TEXTURES, CUSTOM_ITEMS, AA_LEVEL, AF_LEVEL, ANIMATED_TEXTURES, NATURAL_TEXTURES, EMISSIVE_TEXTURES, HELD_ITEM_TOOLTIPS, DROPPED_ITEMS, LAZY_CHUNK_LOADING, CUSTOM_SKY, FAST_MATH, FAST_RENDER, TRANSLUCENT_BLOCKS, DYNAMIC_FOV, DYNAMIC_LIGHTS, ALTERNATE_BLOCKS, CUSTOM_ENTITY_MODELS, ADVANCED_TOOLTIPS, SCREENSHOT_SIZE, CUSTOM_GUIS, RENDER_REGIONS, SHOW_GL_ERRORS, SMART_ANIMATIONS};
      DYNAMIC_LIGHTS("of.options.DYNAMIC_LIGHTS", false, false),
      SHOW_CAPES("of.options.SHOW_CAPES", false, false),
      FOG_START("of.options.FOG_START", false, false),
      TIME("of.options.TIME", false, false),
      CONNECTED_TEXTURES("of.options.CONNECTED_TEXTURES", false, false),
      HELD_ITEM_TOOLTIPS("of.options.HELD_ITEM_TOOLTIPS", false, false),
      DROPPED_ITEMS("of.options.DROPPED_ITEMS", false, false),
      STREAM_CHAT_USER_FILTER("options.stream.chat.userFilter", false, false),
      RENDER_REGIONS("of.options.RENDER_REGIONS", false, false),
      VOID_PARTICLES("of.options.VOID_PARTICLES", false, false),
      LAZY_CHUNK_LOADING("of.options.LAZY_CHUNK_LOADING", false, false),
      CHAT_LINKS_PROMPT("options.chat.links.prompt", false, true),
      AO_LEVEL("of.options.AO_LEVEL", true, false),
      CHAT_WIDTH("options.chat.width", true, false),
      TREES("of.options.TREES", false, false),
      CLOUDS("of.options.CLOUDS", false, false),
      CHAT_HEIGHT_UNFOCUSED("options.chat.height.unfocused", true, false),
      BETTER_GRASS("of.options.BETTER_GRASS", false, false),
      SMART_ANIMATIONS("of.options.SMART_ANIMATIONS", false, false);

      private final boolean enumFloat;
      FAST_MATH("of.options.FAST_MATH", false, false),
      SUN_MOON("of.options.SUN_MOON", false, false),
      STREAM_VOLUME_MIC("options.stream.micVolumne", true, false),
      RAIN("of.options.RAIN", false, false),
      ANIMATED_REDSTONE("of.options.ANIMATED_REDSTONE", false, false),
      AA_LEVEL("of.options.AA_LEVEL", true, false, 0.0F, 16.0F, 1.0F),
      STREAM_BYTES_PER_PIXEL("options.stream.bytesPerPixel", true, false),
      AUTOSAVE_TICKS("of.options.AUTOSAVE_TICKS", false, false),
      ANIMATED_PORTAL("of.options.ANIMATED_PORTAL", false, false),
      ANIMATED_FIRE("of.options.ANIMATED_FIRE", false, false),
      VIEW_BOBBING("options.viewBobbing", false, true),
      FULLSCREEN_MODE("of.options.FULLSCREEN_MODE", true, false, 0.0F, (float)Config.getDisplayModes().length, 1.0F),
      SHOW_GL_ERRORS("of.options.SHOW_GL_ERRORS", false, false),
      RAIN_SPLASH("of.options.RAIN_SPLASH", false, false);

      private float valueMax;
      GAMMA("options.gamma", true, false),
      CUSTOM_GUIS("of.options.CUSTOM_GUIS", false, false),
      CHAT_LINKS("options.chat.links", false, true),
      ANIMATED_SMOKE("of.options.ANIMATED_SMOKE", false, false),
      STREAM_KBPS("options.stream.kbps", true, false),
      CLOUD_HEIGHT("of.options.CLOUD_HEIGHT", true, false),
      ANAGLYPH("options.anaglyph", false, true),
      CHUNK_UPDATES("of.options.CHUNK_UPDATES", false, false),
      RENDER_CLOUDS("options.renderClouds", false, false),
      FOV("options.fov", true, false, 30.0F, 110.0F, 1.0F),
      ANIMATED_EXPLOSION("of.options.ANIMATED_EXPLOSION", false, false);

      private final String enumString;
      CLEAR_WATER("of.options.CLEAR_WATER", false, false),
      BLOCK_ALTERNATIVES("options.blockAlternatives", false, true),
      MIPMAP_TYPE("of.options.MIPMAP_TYPE", true, false, 0.0F, 3.0F, 1.0F),
      CUSTOM_ITEMS("of.options.CUSTOM_ITEMS", false, false),
      SENSITIVITY("options.sensitivity", true, false),
      REDUCED_DEBUG_INFO("options.reducedDebugInfo", false, true),
      STREAM_CHAT_ENABLED("options.stream.chat.enabled", false, false),
      ADVANCED_TOOLTIPS("of.options.ADVANCED_TOOLTIPS", false, false),
      WEATHER("of.options.WEATHER", false, false);

      private final boolean enumBoolean;
      CHAT_OPACITY("options.chat.opacity", true, false),
      ANIMATED_FLAME("of.options.ANIMATED_FLAME", false, false),
      ENABLE_VSYNC("options.vsync", false, true),
      FAST_RENDER("of.options.FAST_RENDER", false, false),
      MIPMAP_LEVELS("options.mipmapLevels", true, false, 0.0F, 4.0F, 1.0F),
      CHUNK_UPDATES_DYNAMIC("of.options.CHUNK_UPDATES_DYNAMIC", false, false),
      CUSTOM_ENTITY_MODELS("of.options.CUSTOM_ENTITY_MODELS", false, false),
      ALTERNATE_BLOCKS("of.options.ALTERNATE_BLOCKS", false, false);

      private float valueMin;
      private final float valueStep;
      FORCE_UNICODE_FONT("options.forceUnicodeFont", false, true),
      CUSTOM_COLORS("of.options.CUSTOM_COLORS", false, false),
      NATURAL_TEXTURES("of.options.NATURAL_TEXTURES", false, false),
      SNOOPER_ENABLED("options.snooper", false, true),
      SHOW_FPS("of.options.SHOW_FPS", false, false),
      STREAM_MIC_TOGGLE_BEHAVIOR("options.stream.micToggleBehavior", false, false),
      CHAT_SCALE("options.chat.scale", true, false),
      CUSTOM_SKY("of.options.CUSTOM_SKY", false, false),
      POTION_PARTICLES("of.options.POTION_PARTICLES", false, false),
      STREAM_VOLUME_SYSTEM("options.stream.systemVolume", true, false),
      SMOOTH_BIOMES("of.options.SMOOTH_BIOMES", false, false),
      FOG_FANCY("of.options.FOG_FANCY", false, false),
      GUI_SCALE("options.guiScale", false, false),
      SMOOTH_WORLD("of.options.SMOOTH_WORLD", false, false),
      PARTICLES("options.particles", false, false),
      EMISSIVE_TEXTURES("of.options.EMISSIVE_TEXTURES", false, false),
      AF_LEVEL("of.options.AF_LEVEL", true, false, 1.0F, 16.0F, 1.0F),
      CUSTOM_FONTS("of.options.CUSTOM_FONTS", false, false),
      PROFILER("of.options.PROFILER", false, false),
      RENDER_DISTANCE("options.renderDistance", true, false, 2.0F, 16.0F, 1.0F),
      SKY("of.options.SKY", false, false),
      CHAT_VISIBILITY("options.chat.visibility", false, false),
      SWAMP_COLORS("of.options.SWAMP_COLORS", false, false),
      USE_FULLSCREEN("options.fullscreen", false, true),
      ENTITY_SHADOWS("options.entityShadows", false, true);

      public boolean getEnumFloat() {
         return this.enumFloat;
      }

      public float snapToStepClamp(float var1) {
         var1 = this.snapToStep(var1);
         return MathHelper.clamp_float(var1, this.valueMin, this.valueMax);
      }

      public static GameSettings.Options getEnumOptions(int var0) {
         GameSettings.Options[] var4;
         int var3 = (var4 = values()).length;

         for(int var2 = 0; var2 < var3; ++var2) {
            GameSettings.Options var1 = var4[var2];
            if (var1.returnEnumOrdinal() == var0) {
               return var1;
            }
         }

         return null;
      }

      protected float snapToStep(float var1) {
         if (this.valueStep > 0.0F) {
            var1 = this.valueStep * (float)Math.round(var1 / this.valueStep);
         }

         return var1;
      }

      private Options(String var3, boolean var4, boolean var5) {
         this(var3, var4, var5, 0.0F, 1.0F, 0.0F);
      }

      public float getValueMax() {
         return this.valueMax;
      }

      public String getEnumString() {
         return this.enumString;
      }

      static float access$2(GameSettings.Options var0) {
         return var0.valueMax;
      }

      private Options(String var3, boolean var4, boolean var5, float var6, float var7, float var8) {
         this.enumString = var3;
         this.enumFloat = var4;
         this.enumBoolean = var5;
         this.valueMin = var6;
         this.valueMax = var7;
         this.valueStep = var8;
      }

      public void setValueMax(float var1) {
         this.valueMax = var1;
      }

      public float denormalizeValue(float var1) {
         return this.snapToStepClamp(this.valueMin + (this.valueMax - this.valueMin) * MathHelper.clamp_float(var1, 0.0F, 1.0F));
      }

      public int returnEnumOrdinal() {
         return this.ordinal();
      }

      public float normalizeValue(float var1) {
         return MathHelper.clamp_float((this.snapToStepClamp(var1) - this.valueMin) / (this.valueMax - this.valueMin), 0.0F, 1.0F);
      }

      public boolean getEnumBoolean() {
         return this.enumBoolean;
      }

      static float access$3(GameSettings.Options var0) {
         return var0.valueMin;
      }
   }
}
