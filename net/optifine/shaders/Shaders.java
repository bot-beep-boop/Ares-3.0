package net.optifine.shaders;

import com.google.common.base.Charsets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.src.Config;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.optifine.CustomBlockLayers;
import net.optifine.CustomColors;
import net.optifine.GlErrors;
import net.optifine.Lang;
import net.optifine.config.ConnectedParser;
import net.optifine.expr.IExpressionBool;
import net.optifine.reflect.Reflector;
import net.optifine.render.GlAlphaState;
import net.optifine.render.GlBlendState;
import net.optifine.shaders.config.EnumShaderOption;
import net.optifine.shaders.config.MacroProcessor;
import net.optifine.shaders.config.MacroState;
import net.optifine.shaders.config.PropertyDefaultFastFancyOff;
import net.optifine.shaders.config.PropertyDefaultTrueFalse;
import net.optifine.shaders.config.RenderScale;
import net.optifine.shaders.config.ScreenShaderOptions;
import net.optifine.shaders.config.ShaderLine;
import net.optifine.shaders.config.ShaderOption;
import net.optifine.shaders.config.ShaderOptionProfile;
import net.optifine.shaders.config.ShaderOptionRest;
import net.optifine.shaders.config.ShaderPackParser;
import net.optifine.shaders.config.ShaderParser;
import net.optifine.shaders.config.ShaderProfile;
import net.optifine.shaders.uniform.CustomUniforms;
import net.optifine.shaders.uniform.ShaderUniform1f;
import net.optifine.shaders.uniform.ShaderUniform1i;
import net.optifine.shaders.uniform.ShaderUniform2i;
import net.optifine.shaders.uniform.ShaderUniform3f;
import net.optifine.shaders.uniform.ShaderUniform4f;
import net.optifine.shaders.uniform.ShaderUniform4i;
import net.optifine.shaders.uniform.ShaderUniformM4;
import net.optifine.shaders.uniform.ShaderUniforms;
import net.optifine.shaders.uniform.Smoother;
import net.optifine.texture.InternalFormat;
import net.optifine.texture.PixelFormat;
import net.optifine.texture.PixelType;
import net.optifine.texture.TextureType;
import net.optifine.util.EntityUtils;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.StrUtils;
import net.optifine.util.TimedEvent;
import org.apache.commons.io.IOUtils;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBGeometryShader4;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector4f;

public class Shaders {
   public static float blockLightLevel06;
   static int isEyeInWater = 0;
   static float shadowMapFOV;
   public static ShaderUniform1i uniform_colortex4;
   public static String glRendererString;
   public static ShaderUniformM4 uniform_shadowProjectionInverse;
   public static PropertyDefaultTrueFalse shaderPackUnderwaterOverlay;
   public static ShaderUniformM4 uniform_gbufferPreviousProjection;
   private static ShaderOption[] shaderPackOptions;
   public static final Program ProgramTexturedLit;
   private static Map<String, String> shaderPackResources;
   private static String noiseTexturePath;
   static final FlipTextures dfbColorTexturesFlip;
   static final FloatBuffer shadowProjectionInverse;
   public static ShaderUniform1f uniform_blindness;
   private static int renderDisplayHeight = 0;
   public static final Program ProgramArmorGlint;
   private static int[] $SWITCH_TABLE$net$optifine$shaders$config$EnumShaderOption;
   public static ShaderUniform3f uniform_cameraPosition;
   public static boolean isSleeping;
   public static ShaderUniform1i uniform_colortex0;
   public static String glVendorString;
   static float skyColorG;
   public static final String[] texMinFilDesc;
   public static ShaderUniform1f uniform_eyeAltitude;
   static final IntBuffer dfbColorTextures;
   static float rainStrength = 0.0F;
   public static ShaderUniform1i uniform_heldBlockLightValue;
   public static ShaderUniform4i uniform_blendFunc;
   static long diffWorldTime = 0L;
   public static final Program ProgramFinal;
   public static final Program ProgramShadowCutout;
   public static ShaderUniform1i uniform_instanceId;
   public static ShaderUniform3f uniform_sunPosition;
   public static ShaderUniform1f uniform_frameTimeCounter;
   static int spShadowMapWidth;
   static float[] moonPosModelView = new float[]{0.0F, -100.0F, 0.0F, 0.0F};
   public static ShaderUniform1i uniform_shadowcolor;
   static final FloatBuffer shadowModelViewInverse;
   static double cameraPositionY;
   public static ShaderUniform1i uniform_tex;
   private static boolean hasGeometryShaders = false;
   static final float[] faProjection;
   public static int configTexMagFilB;
   public static final Program ProgramSkyBasic;
   public static final Program[] ProgramsAll;
   static final IntBuffer sfbColorTextures;
   public static float wetnessHalfLife = 600.0F;
   public static final Program ProgramShadowSolid;
   static int spShadowMapHeight;
   public static final Program ProgramShadow;
   static boolean usewetness = false;
   public static PropertyDefaultTrueFalse shaderPackSun;
   public static ShaderUniform1i uniform_gnormal;
   static int shadowMapWidth;
   private static final int STAGE_DEFERRED = 2;
   public static final Program ProgramNone;
   private static ICustomTexture[] customTexturesComposite;
   public static int configTexMinFilB;
   static long lastWorldTime = 0L;
   public static final Program ProgramComposite;
   public static boolean[] shadowFilterNearest;
   public static boolean itemToRenderOffTranslucent = false;
   private static Set<String> shaderPackOptionSliders;
   public static final Program ProgramTerrainCutout;
   private static final String[] formatNames;
   static double cameraPositionZ;
   static float centerDepthSmoothHalflife = 1.0F;
   static final int[] colorTextureImageUnit;
   private static final String[] STAGE_NAMES;
   static final FloatBuffer previousProjection;
   public static boolean isShaderPackInitialized = false;
   static final FloatBuffer projection;
   private static final int bigBufferSize;
   static float frameTime = 0.0F;
   public static float sunPathRotation;
   private static int[] gbuffersFormat;
   static final IntBuffer drawBuffersNone;
   static double previousCameraPositionZ;
   static final float[] faShadowProjectionInverse;
   static float centerDepth = 0.0F;
   public static ShaderUniform1i uniform_terrainIconSize;
   public static float blockLightLevel05;
   public static final Program ProgramEntitiesGlowing;
   public static final Program ProgramHandWater;
   public static final Program ProgramDamagedBlock;
   public static final Program ProgramSpiderEyes;
   static float blindness = 0.0F;
   public static ShaderUniformM4 uniform_shadowProjection;
   public static ShaderUniform1i uniform_texture;
   static int preShadowPassThirdPersonView;
   private static Programs programs;
   public static boolean hasGlGenMipmap = false;
   public static final Program ProgramClouds;
   static final int MaxColorBuffers = 8;
   static int usedDepthBuffers;
   public static ShaderUniform1f uniform_aspectRatio;
   static final IntBuffer sfbDrawBuffers;
   public static final Program ProgramWater;
   public static boolean isShadowPass = false;
   public static ShaderUniform1i uniform_heldItemId2;
   static int usedShadowDepthBuffers;
   static float[] shadowLightPosition = new float[4];
   public static ShaderUniform3f uniform_fogColor;
   public static final int ProgramCount;
   static IntBuffer activeDrawBuffers;
   public static ShaderUniform1i uniform_normals;
   public static int[] entityData;
   public static float configRenderResMul;
   public static float aoLevel;
   static final IntBuffer sfbDepthTextures;
   public static ShaderUniform2i uniform_terrainTextureSize;
   public static ShaderUniform3f uniform_shadowLightPosition;
   static final float[] faShadowModelViewInverse;
   static int usedColorBuffers;
   static int shadowPassCounter;
   public static ShaderUniform1f uniform_sunAngle;
   public static boolean[] shadowColorFilterNearest;
   public static PropertyDefaultTrueFalse shaderPackMoon;
   public static float fogDensity;
   public static final boolean saveFinalShaders;
   static final float[] faModelView;
   public static boolean shouldSkipDefaultShadow;
   static final int MaxShadowColorBuffers = 8;
   static final FloatBuffer shadowModelView;
   public static final Program ProgramWeather;
   public static int configTexMinFilN;
   public static ShaderUniform1f uniform_near;
   public static final int texMagFilRange = 2;
   static float eyeBrightnessFadeY = 0.0F;
   public static ShaderUniform1f uniform_rainStrength;
   static ShaderProfile[] shaderPackProfiles;
   static long lastSystemTime = 0L;
   public static ShaderUniform1f uniform_centerDepthSmooth;
   public static ShaderUniform1i uniform_colortex2;
   static float skyColorR;
   static final IntBuffer dfbDrawBuffers;
   private static boolean hasDeferredPrograms;
   public static float eyeBrightnessHalflife = 10.0F;
   public static final String OPTIONS_FILE_NAME = "optionsshaders.txt";
   static final IntBuffer drawBuffersColorAtt0;
   static float celestialAngle = 0.0F;
   public static int atlasSizeX = 0;
   public static ShaderUniform1i uniform_worldDay;
   static float shadowMapHalfPlane;
   public static boolean isInitializedOnce = false;
   static float[] upPosModelView = new float[]{0.0F, 100.0F, 0.0F, 0.0F};
   static float wetness = 0.0F;
   static final FloatBuffer tempMatrixDirectBuffer;
   public static ShaderUniform2i uniform_eyeBrightnessSmooth;
   static int dfb;
   private static final int STAGE_COMPOSITE = 1;
   static int superSamplingLevel = 1;
   static float shadowDistanceRenderMul;
   public static final Program[] ProgramsComposite;
   public static PropertyDefaultTrueFalse shaderPackShadowTranslucent;
   public static PropertyDefaultFastFancyOff shaderPackClouds;
   private static final int STAGE_GBUFFERS = 0;
   public static ShaderUniform1f uniform_fogDensity;
   static float eyePosY = 0.0F;
   public static boolean isCompositeRendered = false;
   static Minecraft mc;
   static final FloatBuffer modelViewInverse;
   static boolean fogEnabled = true;
   private static boolean skipRenderHandMain;
   public static ITextureObject defaultTexture;
   static float[] shadowLightPositionVector = new float[4];
   public static final Program ProgramTerrainCutoutMip;
   public static int renderWidth = 0;
   static int usedDrawBuffers;
   static final float[] faShadowProjection;
   public static ShaderUniform1i uniform_gaux2;
   public static PropertyDefaultTrueFalse shaderPackBeaconBeamDepth;
   private static float[] tempMat = new float[16];
   private static ICustomTexture[] customTexturesGbuffers;
   private static boolean isHandRenderedMain;
   static final float[] faModelViewInverse;
   static float clearColorG;
   static Map<String, IExpressionBool> shaderPackProgramConditions;
   public static int configTexMagFilS;
   public static int midTexCoordAttrib = 11;
   public static int atlasSizeY = 0;
   static float eyeBrightnessFadeX = 0.0F;
   public static ShaderUniform4f uniform_entityColor;
   static double previousCameraPositionX;
   static boolean lightmapEnabled = false;
   static final float[] faShadowModelView;
   public static ShaderUniformM4 uniform_gbufferModelViewInverse;
   public static boolean isRenderingDfb = false;
   public static float blockLightLevel08;
   public static final Program ProgramDeferredPre;
   public static final Program ProgramSkyTextured;
   public static PropertyDefaultTrueFalse shaderPackOldHandLight;
   public static int entityAttrib = 10;
   public static ShaderUniform1i uniform_gaux3;
   public static String glVersionString;
   private static int[] $SWITCH_TABLE$net$minecraft$util$EnumWorldBlockLayer;
   static final FloatBuffer shadowProjection;
   public static boolean[] shadowHardwareFilteringEnabled;
   public static float shadowIntervalSize;
   private static final boolean enableShadersDebug = true;
   static float shadowAngle = 0.0F;
   public static int renderHeight = 0;
   public static ShaderUniform1i uniform_fogMode;
   public static PropertyDefaultTrueFalse shaderPackBackFaceSolid;
   static boolean centerDepthSmoothEnabled = false;
   public static ShaderUniform1i uniform_frameCounter;
   static float[] sunPosModelView = new float[]{0.0F, 100.0F, 0.0F, 0.0F};
   public static boolean useEntityAttrib = false;
   private static ICustomTexture[] customTexturesDeferred;
   public static float fogColorB;
   public static ShaderUniform1i uniform_hideGUI;
   public static ShaderUniform1i uniform_depthtex2;
   public static ShaderUniformM4 uniform_gbufferModelView;
   static int usedColorAttachs;
   private static final ByteBuffer bigBuffer;
   public static ShaderUniform2i uniform_eyeBrightness;
   static Map<Block, Integer> mapBlockToEntityData;
   public static int fogMode;
   static float[] upPosition = new float[4];
   static long systemTime = 0L;
   private static int[] $SWITCH_TABLE$net$optifine$texture$TextureType;
   static int eyeBrightness = 0;
   public static Vector4f[] gbuffersClearColor;
   public static final String SHADER_PACK_NAME_DEFAULT = "(internal)";
   private static World currentWorld;
   public static int configAntialiasingLevel;
   static float centerDepthSmooth = 0.0F;
   public static ContextCapabilities capabilities;
   public static ShaderUniform1i uniform_composite;
   public static ShaderUniformM4 uniform_gbufferPreviousModelView;
   public static ShaderUniform1i uniform_moonPhase;
   public static boolean[] gbuffersClear;
   public static float drynessHalfLife = 200.0F;
   public static int configTexMinFilS;
   private static ICustomTexture noiseTexture;
   public static final Program ProgramEntities;
   private static int progMaxVerticesOut = 3;
   public static ShaderUniform1f uniform_viewHeight;
   private static int[] $SWITCH_TABLE$net$optifine$shaders$ProgramStage;
   public static ShaderUniform1i uniform_gdepth;
   public static ShaderUniform1i uniform_depthtex0;
   public static boolean useMidTexCoordAttrib = false;
   private static int noiseTextureResolution;
   public static final Program ProgramCompositePre;
   public static ShaderUniform1i uniform_blockEntityId;
   public static ShaderUniform3f uniform_skyColor;
   public static final Program ProgramTerrain;
   public static ShaderUniform1i uniform_isEyeInWater;
   public static final String SHADER_PACK_NAME_NONE = "OFF";
   public static PropertyDefaultTrueFalse shaderPackSeparateAo;
   private static IShaderPack shaderPack;
   private static int renderDisplayWidth = 0;
   public static ShaderUniform1i uniform_gaux1;
   public static ShaderUniform1f uniform_shadowAngle;
   public static PropertyDefaultTrueFalse shaderPackDynamicHandLight;
   public static boolean isEntitiesGlowing = false;
   public static ShaderUniformM4 uniform_shadowModelViewInverse;
   static float[] moonPosition = new float[4];
   public static float configHandDepthMul;
   public static ShaderUniform2i uniform_atlasSize;
   public static PropertyDefaultTrueFalse shaderPackOldLighting;
   public static Properties shadersConfig;
   public static ShaderUniform1i uniform_gdepthtex;
   public static ShaderUniform3f uniform_moonPosition;
   public static boolean configSpecularMap;
   public static ShaderUniform3f uniform_previousCameraPosition;
   public static boolean configShadowClipFrustrum;
   public static Program activeProgram;
   public static final Program ProgramItem;
   public static PropertyDefaultTrueFalse shaderPackBackFaceCutoutMipped;
   static float skyColorB;
   static final FloatBuffer previousModelView;
   public static ShaderUniform1i uniform_shadowtex0;
   private static CustomUniforms customUniforms;
   static float clearColorR;
   public static int[] terrainTextureSize;
   public static ShaderUniform1i uniform_gaux4;
   public static final Program ProgramTextured;
   public static Properties loadedShaders;
   public static ShaderUniform1i uniform_shadowcolor0;
   static int cameraOffsetZ;
   static Map<String, ScreenShaderOptions> shaderPackGuiScreens;
   public static final Program ProgramBlock;
   public static boolean configTweakBlockDamage;
   public static ShaderUniform3f uniform_upPosition;
   public static final String PATH_SHADERS_PROPERTIES = "/shaders/shaders.properties";
   public static ShaderUniform1i uniform_gcolor;
   public static boolean[] shadowColorMipmapEnabled;
   public static PropertyDefaultTrueFalse shaderPackBackFaceCutout;
   public static float fogColorR;
   public static ShaderUniform1i uniform_depthtex1;
   static int cameraOffsetX;
   public static ShaderUniform1i uniform_noisetex;
   private static boolean progArbGeometryShader4 = false;
   static float nightVision = 0.0F;
   static EntityRenderer entityRenderer;
   private static boolean skipRenderHandOff;
   public static boolean configNormalMap;
   static boolean shadowMapIsOrtho;
   public static int entityDataIndex;
   public static final int texMinFilRange = 3;
   public static ShaderUniform1f uniform_frameTime;
   public static ShaderUniform1f uniform_viewWidth;
   static double cameraPositionX;
   static int usedShadowColorBuffers;
   public static ShaderUniform1i uniform_worldTime;
   public static ShaderUniform1i uniform_shadowtex1;
   private static final int[] formatIds;
   public static boolean progUseMidTexCoordAttrib = false;
   static int systemTimeInt32 = 0;
   static File configFile;
   static final FloatBuffer modelView;
   private static ProgramStack programStackLeash;
   public static int configTexMagFilN;
   private static final Pattern patternLoadEntityDataMap;
   public static ShaderUniform1i uniform_colortex1;
   public static String currentShaderName;
   private static ShaderUniforms shaderUniforms = new ShaderUniforms();
   public static final Program ProgramHand;
   public static PropertyDefaultTrueFalse shaderPackBackFaceTranslucent;
   public static final Program ProgramTerrainSolid;
   public static ShaderUniform1i uniform_colortex5;
   public static ShaderUniform1i uniform_shadowcolor1;
   public static boolean progUseEntityAttrib = false;
   private static boolean isRenderingFirstPersonHand;
   static double previousCameraPositionY;
   public static ShaderUniformM4 uniform_shadowModelView;
   public static final Program ProgramBeaconBeam;
   public static ShaderUniform1f uniform_screenBrightness;
   static final int MaxDrawBuffers = 8;
   public static boolean itemToRenderMainTranslucent = false;
   static float clearColorB;
   static int moonPhase = 0;
   static final int MaxDepthBuffers = 3;
   public static final Program ProgramBasic;
   public static ShaderUniform1f uniform_far;
   static float[] sunPosition = new float[4];
   public static ShaderUniform1f uniform_nightVision;
   public static ShaderUniform1f uniform_wetness;
   static long diffSystemTime = 0L;
   public static float fogColorG;
   public static boolean renderItemKeepDepthMask = false;
   private static boolean noiseTextureEnabled;
   public static PropertyDefaultTrueFalse shaderPackVignette;
   public static boolean isRenderingWorld = false;
   public static float configShadowResMul;
   public static ShaderUniform1i uniform_heldBlockLightValue2;
   public static ShaderUniform1i uniform_watershadow;
   public static ShaderUniformM4 uniform_gbufferProjectionInverse;
   public static ShaderUniform1i uniform_colortex6;
   private static boolean isHandRenderedOff;
   static boolean waterShadowEnabled;
   public static int activeProgramID;
   public static ShaderUniform1i uniform_colortex3;
   static final int MaxShadowDepthBuffers = 2;
   public static int terrainIconSize;
   static final FloatBuffer projectionInverse;
   public static boolean needResizeShadow;
   public static boolean useTangentAttrib = false;
   public static PropertyDefaultTrueFalse configOldLighting;
   static long worldTime = 0L;
   public static final String[] texMagFilDesc;
   public static ShaderUniformM4 uniform_gbufferProjection;
   public static int countResetDisplayLists = 0;
   static int shadowMapHeight;
   public static PropertyDefaultTrueFalse shaderPackRainDepth;
   public static ShaderUniform1i uniform_lightmap;
   static int sfb;
   static int frameCounter = 0;
   public static boolean shaderPackLoaded;
   public static PropertyDefaultTrueFalse configOldHandLight;
   public static final int[] texMinFilValue;
   private static int activeCompositeMipmapSetting;
   static int shadowPassInterval;
   static float frameTimeCounter = 0.0F;
   public static final Program[] ProgramsDeferred;
   public static final boolean enableShadersOption = true;
   static final float[] faProjectionInverse;
   public static final String SHADER_PACKS_DIR_NAME = "shaderpacks";
   public static ShaderUniform1i uniform_colortex7;
   public static PropertyDefaultTrueFalse shaderPackFrustumCulling;
   public static boolean configCloudShadow;
   public static ShaderUniform1i uniform_shadow;
   public static ShaderUniform1i uniform_heldItemId;
   static final IntBuffer dfbDepthTextures;
   public static final int[] texMagFilValue;
   static final FloatBuffer tempDirectFloatBuffer;
   public static ShaderUniform1i uniform_entityId;
   public static final Program ProgramDeferred;
   public static int tangentAttrib = 12;
   public static ShaderUniform1i uniform_specular;
   private static List<Integer> shaderPackDimensions;
   static float sunAngle = 0.0F;
   public static boolean[] shadowMipmapEnabled;
   public static boolean isRenderingSky = false;
   public static final File shaderPacksDir;
   public static float shadowAngleInterval;
   public static boolean progUseTangentAttrib = false;

   public static void setItemToRenderMain(ItemStack var0) {
      itemToRenderMainTranslucent = isTranslucentBlock(var0);
   }

   public static void uninit() {
      if (isShaderPackInitialized) {
         checkGLError("Shaders.uninit pre");

         for(int var0 = 0; var0 < ProgramsAll.length; ++var0) {
            Program var1 = ProgramsAll[var0];
            if (var1.getRef() != 0) {
               ARBShaderObjects.glDeleteObjectARB(var1.getRef());
               checkGLError("del programRef");
            }

            var1.setRef(0);
            var1.setId(0);
            var1.setDrawBufSettings((String)null);
            var1.setDrawBuffers((IntBuffer)null);
            var1.setCompositeMipmapSetting(0);
         }

         hasDeferredPrograms = false;
         if (dfb != 0) {
            EXTFramebufferObject.glDeleteFramebuffersEXT(dfb);
            dfb = 0;
            checkGLError("del dfb");
         }

         if (sfb != 0) {
            EXTFramebufferObject.glDeleteFramebuffersEXT(sfb);
            sfb = 0;
            checkGLError("del sfb");
         }

         if (dfbDepthTextures != null) {
            GlStateManager.deleteTextures(dfbDepthTextures);
            fillIntBufferZero(dfbDepthTextures);
            checkGLError("del dfbDepthTextures");
         }

         if (dfbColorTextures != null) {
            GlStateManager.deleteTextures(dfbColorTextures);
            fillIntBufferZero(dfbColorTextures);
            checkGLError("del dfbTextures");
         }

         if (sfbDepthTextures != null) {
            GlStateManager.deleteTextures(sfbDepthTextures);
            fillIntBufferZero(sfbDepthTextures);
            checkGLError("del shadow depth");
         }

         if (sfbColorTextures != null) {
            GlStateManager.deleteTextures(sfbColorTextures);
            fillIntBufferZero(sfbColorTextures);
            checkGLError("del shadow color");
         }

         if (dfbDrawBuffers != null) {
            fillIntBufferZero(dfbDrawBuffers);
         }

         if (noiseTexture != null) {
            noiseTexture.deleteTexture();
            noiseTexture = null;
         }

         SMCLog.info("Uninit");
         shadowPassInterval = 0;
         shouldSkipDefaultShadow = false;
         isShaderPackInitialized = false;
         checkGLError("Shaders.uninit");
      }

   }

   public static void preCelestialRotate() {
      GL11.glRotatef(sunPathRotation * 1.0F, 0.0F, 0.0F, 1.0F);
      checkGLError("preCelestialRotate");
   }

   public static void scheduleResize() {
      renderDisplayHeight = 0;
   }

   private static int getPixelFormat(int var0) {
      switch(var0) {
      case 33333:
      case 33334:
      case 33339:
      case 33340:
      case 36208:
      case 36209:
      case 36226:
      case 36227:
         return 36251;
      default:
         return 32993;
      }
   }

   private static void loadShaderPackProperties() {
      shaderPackClouds.resetValue();
      shaderPackOldHandLight.resetValue();
      shaderPackDynamicHandLight.resetValue();
      shaderPackOldLighting.resetValue();
      shaderPackShadowTranslucent.resetValue();
      shaderPackUnderwaterOverlay.resetValue();
      shaderPackSun.resetValue();
      shaderPackMoon.resetValue();
      shaderPackVignette.resetValue();
      shaderPackBackFaceSolid.resetValue();
      shaderPackBackFaceCutout.resetValue();
      shaderPackBackFaceCutoutMipped.resetValue();
      shaderPackBackFaceTranslucent.resetValue();
      shaderPackRainDepth.resetValue();
      shaderPackBeaconBeamDepth.resetValue();
      shaderPackSeparateAo.resetValue();
      shaderPackFrustumCulling.resetValue();
      BlockAliases.reset();
      ItemAliases.reset();
      EntityAliases.reset();
      customUniforms = null;

      for(int var0 = 0; var0 < ProgramsAll.length; ++var0) {
         Program var1 = ProgramsAll[var0];
         var1.resetProperties();
      }

      if (shaderPack != null) {
         BlockAliases.update(shaderPack);
         ItemAliases.update(shaderPack);
         EntityAliases.update(shaderPack);
         String var4 = "/shaders/shaders.properties";

         try {
            InputStream var5 = shaderPack.getResourceAsStream(var4);
            if (var5 == null) {
               return;
            }

            var5 = MacroProcessor.process(var5, var4);
            PropertiesOrdered var2 = new PropertiesOrdered();
            var2.load(var5);
            var5.close();
            shaderPackClouds.loadFrom(var2);
            shaderPackOldHandLight.loadFrom(var2);
            shaderPackDynamicHandLight.loadFrom(var2);
            shaderPackOldLighting.loadFrom(var2);
            shaderPackShadowTranslucent.loadFrom(var2);
            shaderPackUnderwaterOverlay.loadFrom(var2);
            shaderPackSun.loadFrom(var2);
            shaderPackVignette.loadFrom(var2);
            shaderPackMoon.loadFrom(var2);
            shaderPackBackFaceSolid.loadFrom(var2);
            shaderPackBackFaceCutout.loadFrom(var2);
            shaderPackBackFaceCutoutMipped.loadFrom(var2);
            shaderPackBackFaceTranslucent.loadFrom(var2);
            shaderPackRainDepth.loadFrom(var2);
            shaderPackBeaconBeamDepth.loadFrom(var2);
            shaderPackSeparateAo.loadFrom(var2);
            shaderPackFrustumCulling.loadFrom(var2);
            shaderPackOptionSliders = ShaderPackParser.parseOptionSliders(var2, shaderPackOptions);
            shaderPackProfiles = ShaderPackParser.parseProfiles(var2, shaderPackOptions);
            shaderPackGuiScreens = ShaderPackParser.parseGuiScreens(var2, shaderPackProfiles, shaderPackOptions);
            shaderPackProgramConditions = ShaderPackParser.parseProgramConditions(var2, shaderPackOptions);
            customTexturesGbuffers = loadCustomTextures(var2, 0);
            customTexturesComposite = loadCustomTextures(var2, 1);
            customTexturesDeferred = loadCustomTextures(var2, 2);
            noiseTexturePath = var2.getProperty("texture.noise");
            if (noiseTexturePath != null) {
               noiseTextureEnabled = true;
            }

            customUniforms = ShaderPackParser.parseCustomUniforms(var2);
            ShaderPackParser.parseAlphaStates(var2);
            ShaderPackParser.parseBlendStates(var2);
            ShaderPackParser.parseRenderScales(var2);
            ShaderPackParser.parseBuffersFlip(var2);
         } catch (IOException var3) {
            Config.warn("[Shaders] Error reading: " + var4);
         }
      }

   }

   public static void beginRender(Minecraft var0, float var1, long var2) {
      checkGLError("pre beginRender");
      checkWorldChanged(mc.theWorld);
      mc = var0;
      mc.mcProfiler.startSection("init");
      entityRenderer = mc.entityRenderer;
      if (!isShaderPackInitialized) {
         try {
            init();
         } catch (IllegalStateException var11) {
            if (Config.normalize(var11.getMessage()).equals("Function is not supported")) {
               printChatAndLogError("[Shaders] Error: " + var11.getMessage());
               var11.printStackTrace();
               setShaderPack("OFF");
               return;
            }
         }
      }

      if (mc.displayWidth != renderDisplayWidth || mc.displayHeight != renderDisplayHeight) {
         resize();
      }

      if (needResizeShadow) {
         resizeShadow();
      }

      worldTime = mc.theWorld.getWorldTime();
      diffWorldTime = (worldTime - lastWorldTime) % 24000L;
      if (diffWorldTime < 0L) {
         diffWorldTime += 24000L;
      }

      lastWorldTime = worldTime;
      moonPhase = mc.theWorld.getMoonPhase();
      ++frameCounter;
      if (frameCounter >= 720720) {
         frameCounter = 0;
      }

      systemTime = System.currentTimeMillis();
      if (lastSystemTime == 0L) {
         lastSystemTime = systemTime;
      }

      diffSystemTime = systemTime - lastSystemTime;
      lastSystemTime = systemTime;
      frameTime = (float)diffSystemTime / 1000.0F;
      frameTimeCounter += frameTime;
      frameTimeCounter %= 3600.0F;
      rainStrength = var0.theWorld.getRainStrength(var1);
      float var4 = (float)diffSystemTime * 0.01F;
      float var5 = (float)Math.exp(Math.log(0.5D) * (double)var4 / (double)(wetness < rainStrength ? drynessHalfLife : wetnessHalfLife));
      wetness = wetness * var5 + rainStrength * (1.0F - var5);
      Entity var6 = mc.getRenderViewEntity();
      if (var6 != null) {
         isSleeping = var6 instanceof EntityLivingBase && ((EntityLivingBase)var6).isPlayerSleeping();
         eyePosY = (float)var6.posY * var1 + (float)var6.lastTickPosY * (1.0F - var1);
         eyeBrightness = var6.getBrightnessForRender(var1);
         var5 = (float)diffSystemTime * 0.01F;
         float var7 = (float)Math.exp(Math.log(0.5D) * (double)var5 / (double)eyeBrightnessHalflife);
         eyeBrightnessFadeX = eyeBrightnessFadeX * var7 + (float)(eyeBrightness & '\uffff') * (1.0F - var7);
         eyeBrightnessFadeY = eyeBrightnessFadeY * var7 + (float)(eyeBrightness >> 16) * (1.0F - var7);
         Block var8 = ActiveRenderInfo.getBlockAtEntityViewpoint(mc.theWorld, var6, var1);
         Material var9 = var8.getMaterial();
         if (var9 == Material.water) {
            isEyeInWater = 1;
         } else if (var9 == Material.lava) {
            isEyeInWater = 2;
         } else {
            isEyeInWater = 0;
         }

         if (mc.thePlayer != null) {
            nightVision = 0.0F;
            if (mc.thePlayer.isPotionActive(Potion.nightVision)) {
               nightVision = Config.getMinecraft().entityRenderer.getNightVisionBrightness(mc.thePlayer, var1);
            }

            blindness = 0.0F;
            if (mc.thePlayer.isPotionActive(Potion.blindness)) {
               int var10 = mc.thePlayer.getActivePotionEffect(Potion.blindness).getDuration();
               blindness = Config.limit((float)var10 / 20.0F, 0.0F, 1.0F);
            }
         }

         Vec3 var13 = mc.theWorld.getSkyColor(var6, var1);
         var13 = CustomColors.getWorldSkyColor(var13, currentWorld, var6, var1);
         skyColorR = (float)var13.xCoord;
         skyColorG = (float)var13.yCoord;
         skyColorB = (float)var13.zCoord;
      }

      isRenderingWorld = true;
      isCompositeRendered = false;
      isShadowPass = false;
      isHandRenderedMain = false;
      isHandRenderedOff = false;
      skipRenderHandMain = false;
      skipRenderHandOff = false;
      bindGbuffersTextures();
      previousCameraPositionX = cameraPositionX;
      previousCameraPositionY = cameraPositionY;
      previousCameraPositionZ = cameraPositionZ;
      previousProjection.position(0);
      projection.position(0);
      previousProjection.put(projection);
      previousProjection.position(0);
      projection.position(0);
      previousModelView.position(0);
      modelView.position(0);
      previousModelView.put(modelView);
      previousModelView.position(0);
      modelView.position(0);
      checkGLError("beginRender");
      ShadersRender.renderShadowMap(entityRenderer, 0, var1, var2);
      mc.mcProfiler.endSection();
      EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);

      for(int var12 = 0; var12 < usedColorBuffers; ++var12) {
         EXTFramebufferObject.glFramebufferTexture2DEXT(36160, '賠' + var12, 3553, dfbColorTexturesFlip.getA(var12), 0);
      }

      checkGLError("end beginRender");
   }

   public static float getShadowRenderDistance() {
      return shadowDistanceRenderMul < 0.0F ? -1.0F : shadowMapHalfPlane * shadowDistanceRenderMul;
   }

   public static void resetDisplayLists() {
      SMCLog.info("Reset model renderers");
      ++countResetDisplayLists;
      SMCLog.info("Reset world renderers");
      mc.renderGlobal.loadRenderers();
   }

   public static void setFogMode(int var0) {
      fogMode = var0;
      if (fogEnabled) {
         setProgramUniform1i(uniform_fogMode, var0);
      }

   }

   public static boolean isOldLighting() {
      if (!configOldLighting.isDefault()) {
         return configOldLighting.isTrue();
      } else {
         return !shaderPackOldLighting.isDefault() ? shaderPackOldLighting.isTrue() : true;
      }
   }

   private static ByteBuffer nextByteBuffer(int var0) {
      ByteBuffer var1 = bigBuffer;
      int var2 = var1.limit();
      var1.position(var2).limit(var2 + var0);
      return var1.slice();
   }

   private static void preDrawComposite() {
      RenderScale var0 = activeProgram.getRenderScale();
      if (var0 != null) {
         int var1 = (int)((float)renderWidth * var0.getOffsetX());
         int var2 = (int)((float)renderHeight * var0.getOffsetY());
         int var3 = (int)((float)renderWidth * var0.getScale());
         int var4 = (int)((float)renderHeight * var0.getScale());
         GL11.glViewport(var1, var2, var3, var4);
      }

   }

   public static void enableTexture2D() {
      if (isRenderingSky) {
         useProgram(ProgramSkyTextured);
      } else if (activeProgram == ProgramBasic) {
         useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
      }

   }

   public static ShaderOption getShaderOption(String var0) {
      return ShaderUtils.getShaderOption(var0, shaderPackOptions);
   }

   public static void sglEnableFog(int var0) {
      GL11.glEnable(var0);
      enableFog();
   }

   public static void endEntitiesGlowing() {
      if (isRenderingWorld) {
         isEntitiesGlowing = false;
      }

   }

   public static int setEntityData1(int var0) {
      entityData[entityDataIndex * 2] = entityData[entityDataIndex * 2] & '\uffff' | var0 << 16;
      return var0;
   }

   public static boolean isItemToRenderOffTranslucent() {
      return itemToRenderOffTranslucent;
   }

   private static boolean checkBufferFlip(Program var0) {
      boolean var1 = false;
      Boolean[] var2 = var0.getBuffersFlip();

      for(int var3 = 0; var3 < usedColorBuffers; ++var3) {
         if (Config.isTrue(var2[var3])) {
            dfbColorTexturesFlip.flip(var3);
            var1 = true;
         }
      }

      return var1;
   }

   public static void pushEntity(Block var0) {
      ++entityDataIndex;
      int var1 = var0.getRenderType();
      entityData[entityDataIndex * 2] = Block.blockRegistry.getIDForObject(var0) & '\uffff' | var1 << 16;
      entityData[entityDataIndex * 2 + 1] = 0;
   }

   private static String getErrorInfo(int var0, String var1) {
      StringBuilder var2 = new StringBuilder();
      String var5;
      if (var0 == 1286) {
         int var3 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
         String var4 = getFramebufferStatusText(var3);
         var5 = ", fbStatus: " + var3 + " (" + var4 + ")";
         var2.append(var5);
      }

      String var6 = activeProgram.getName();
      if (var6.isEmpty()) {
         var6 = "none";
      }

      var2.append(", program: " + var6);
      Program var7 = getProgramById(activeProgramID);
      if (var7 != activeProgram) {
         var5 = var7.getName();
         if (var5.isEmpty()) {
            var5 = "none";
         }

         var2.append(" (" + var5 + ")");
      }

      if (var1.equals("setDrawBuffers")) {
         var2.append(", drawBuffers: " + activeProgram.getDrawBufSettings());
      }

      return var2.toString();
   }

   private static ShaderOption[] loadShaderPackOptions() {
      try {
         String[] var0 = programs.getProgramNames();
         ShaderOption[] var1 = ShaderPackParser.parseShaderPackOptions(shaderPack, var0, shaderPackDimensions);
         Properties var2 = loadOptionProperties(shaderPack);

         for(int var3 = 0; var3 < var1.length; ++var3) {
            ShaderOption var4 = var1[var3];
            String var5 = var2.getProperty(var4.getName());
            if (var5 != null) {
               var4.resetValue();
               if (!var4.setValue(var5)) {
                  Config.warn("[Shaders] Invalid value, option: " + var4.getName() + ", value: " + var5);
               }
            }
         }

         return var1;
      } catch (IOException var6) {
         Config.warn("[Shaders] Error reading configuration for " + shaderPack.getName());
         var6.printStackTrace();
         return null;
      }
   }

   public static void beginWeather() {
      if (!isShadowPass) {
         if (usedDepthBuffers >= 3) {
            GlStateManager.setActiveTexture(33996);
            GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, renderWidth, renderHeight);
            GlStateManager.setActiveTexture(33984);
         }

         GlStateManager.enableDepth();
         GlStateManager.enableBlend();
         GlStateManager.blendFunc(770, 771);
         GlStateManager.enableAlpha();
         useProgram(ProgramWeather);
      }

   }

   public static void renderDeferred() {
      if (!isShadowPass) {
         boolean var0 = checkBufferFlip(ProgramDeferredPre);
         if (hasDeferredPrograms) {
            checkGLError("pre-render Deferred");
            renderComposites(ProgramsDeferred, false);
            var0 = true;
         }

         if (var0) {
            bindGbuffersTextures();

            for(int var1 = 0; var1 < usedColorBuffers; ++var1) {
               EXTFramebufferObject.glFramebufferTexture2DEXT(36160, '賠' + var1, 3553, dfbColorTexturesFlip.getA(var1), 0);
            }

            if (ProgramWater.getDrawBuffers() != null) {
               setDrawBuffers(ProgramWater.getDrawBuffers());
            } else {
               setDrawBuffers(dfbDrawBuffers);
            }

            GlStateManager.setActiveTexture(33984);
            mc.getTextureManager().bindTexture(TextureMap.locationBlocksTexture);
         }
      }

   }

   public static boolean canRenderQuads() {
      return hasGeometryShaders ? capabilities.GL_NV_geometry_shader4 : true;
   }

   private static void loadShaderPackResources() {
      shaderPackResources = new HashMap();
      if (shaderPackLoaded) {
         ArrayList var0 = new ArrayList();
         String var1 = "/shaders/lang/";
         String var2 = "en_US";
         String var3 = ".lang";
         var0.add(var1 + var2 + var3);
         if (!Config.getGameSettings().language.equals(var2)) {
            var0.add(var1 + Config.getGameSettings().language + var3);
         }

         try {
            Iterator var5 = var0.iterator();

            while(true) {
               InputStream var6;
               do {
                  if (!var5.hasNext()) {
                     return;
                  }

                  String var4 = (String)var5.next();
                  var6 = shaderPack.getResourceAsStream(var4);
               } while(var6 == null);

               PropertiesOrdered var7 = new PropertiesOrdered();
               Lang.loadLocaleData(var6, var7);
               var6.close();
               Iterator var9 = var7.keySet().iterator();

               while(var9.hasNext()) {
                  Object var8 = var9.next();
                  String var10 = (String)var8;
                  String var11 = var7.getProperty(var10);
                  shaderPackResources.put(var10, var11);
               }
            }
         } catch (IOException var12) {
            var12.printStackTrace();
         }
      }

   }

   public static void init() {
      boolean var0;
      if (!isInitializedOnce) {
         isInitializedOnce = true;
         var0 = true;
      } else {
         var0 = false;
      }

      if (!isShaderPackInitialized) {
         checkGLError("Shaders.init pre");
         if (getShaderPackName() != null) {
         }

         if (!capabilities.OpenGL20) {
            printChatAndLogError("No OpenGL 2.0");
         }

         if (!capabilities.GL_EXT_framebuffer_object) {
            printChatAndLogError("No EXT_framebuffer_object");
         }

         dfbDrawBuffers.position(0).limit(8);
         dfbColorTextures.position(0).limit(16);
         dfbDepthTextures.position(0).limit(3);
         sfbDrawBuffers.position(0).limit(8);
         sfbDepthTextures.position(0).limit(2);
         sfbColorTextures.position(0).limit(8);
         usedColorBuffers = 4;
         usedDepthBuffers = 1;
         usedShadowColorBuffers = 0;
         usedShadowDepthBuffers = 0;
         usedColorAttachs = 1;
         usedDrawBuffers = 1;
         Arrays.fill(gbuffersFormat, 6408);
         Arrays.fill(gbuffersClear, true);
         Arrays.fill(gbuffersClearColor, (Object)null);
         Arrays.fill(shadowHardwareFilteringEnabled, false);
         Arrays.fill(shadowMipmapEnabled, false);
         Arrays.fill(shadowFilterNearest, false);
         Arrays.fill(shadowColorMipmapEnabled, false);
         Arrays.fill(shadowColorFilterNearest, false);
         centerDepthSmoothEnabled = false;
         noiseTextureEnabled = false;
         sunPathRotation = 0.0F;
         shadowIntervalSize = 2.0F;
         shadowMapWidth = 1024;
         shadowMapHeight = 1024;
         spShadowMapWidth = 1024;
         spShadowMapHeight = 1024;
         shadowMapFOV = 90.0F;
         shadowMapHalfPlane = 160.0F;
         shadowMapIsOrtho = true;
         shadowDistanceRenderMul = -1.0F;
         aoLevel = -1.0F;
         useEntityAttrib = false;
         useMidTexCoordAttrib = false;
         useTangentAttrib = false;
         waterShadowEnabled = false;
         hasGeometryShaders = false;
         updateBlockLightLevel();
         Smoother.resetValues();
         shaderUniforms.reset();
         if (customUniforms != null) {
            customUniforms.reset();
         }

         ShaderProfile var1 = ShaderUtils.detectProfile(shaderPackProfiles, shaderPackOptions, false);
         String var2 = "";
         int var3;
         if (currentWorld != null) {
            var3 = currentWorld.provider.getDimensionId();
            if (shaderPackDimensions.contains(var3)) {
               var2 = "world" + var3 + "/";
            }
         }

         for(var3 = 0; var3 < ProgramsAll.length; ++var3) {
            Program var4 = ProgramsAll[var3];
            var4.resetId();
            var4.resetConfiguration();
            if (var4.getProgramStage() != ProgramStage.NONE) {
               String var5 = var4.getName();
               String var6 = var2 + var5;
               boolean var7 = true;
               if (shaderPackProgramConditions.containsKey(var6)) {
                  var7 = var7 && ((IExpressionBool)shaderPackProgramConditions.get(var6)).eval();
               }

               if (var1 != null) {
                  var7 = var7 && !var1.isProgramDisabled(var6);
               }

               if (!var7) {
                  SMCLog.info("Program disabled: " + var6);
                  var5 = "<disabled>";
                  var6 = var2 + var5;
               }

               String var8 = "/shaders/" + var6;
               String var9 = var8 + ".vsh";
               String var10 = var8 + ".gsh";
               String var11 = var8 + ".fsh";
               setupProgram(var4, var9, var10, var11);
               int var12 = var4.getId();
               if (var12 > 0) {
                  SMCLog.info("Program loaded: " + var6);
               }

               initDrawBuffers(var4);
               updateToggleBuffers(var4);
            }
         }

         hasDeferredPrograms = false;

         for(var3 = 0; var3 < ProgramsDeferred.length; ++var3) {
            if (ProgramsDeferred[var3].getId() != 0) {
               hasDeferredPrograms = true;
               break;
            }
         }

         usedColorAttachs = usedColorBuffers;
         shadowPassInterval = usedShadowDepthBuffers > 0 ? 1 : 0;
         shouldSkipDefaultShadow = usedShadowDepthBuffers > 0;
         SMCLog.info("usedColorBuffers: " + usedColorBuffers);
         SMCLog.info("usedDepthBuffers: " + usedDepthBuffers);
         SMCLog.info("usedShadowColorBuffers: " + usedShadowColorBuffers);
         SMCLog.info("usedShadowDepthBuffers: " + usedShadowDepthBuffers);
         SMCLog.info("usedColorAttachs: " + usedColorAttachs);
         SMCLog.info("usedDrawBuffers: " + usedDrawBuffers);
         dfbDrawBuffers.position(0).limit(usedDrawBuffers);
         dfbColorTextures.position(0).limit(usedColorBuffers * 2);
         dfbColorTexturesFlip.reset();

         for(var3 = 0; var3 < usedDrawBuffers; ++var3) {
            dfbDrawBuffers.put(var3, '賠' + var3);
         }

         var3 = GL11.glGetInteger(34852);
         if (usedDrawBuffers > var3) {
            printChatAndLogError("[Shaders] Error: Not enough draw buffers, needed: " + usedDrawBuffers + ", available: " + var3);
         }

         sfbDrawBuffers.position(0).limit(usedShadowColorBuffers);

         int var13;
         for(var13 = 0; var13 < usedShadowColorBuffers; ++var13) {
            sfbDrawBuffers.put(var13, '賠' + var13);
         }

         for(var13 = 0; var13 < ProgramsAll.length; ++var13) {
            Program var14 = ProgramsAll[var13];

            Program var15;
            for(var15 = var14; var15.getId() == 0 && var15.getProgramBackup() != var15; var15 = var15.getProgramBackup()) {
            }

            if (var15 != var14 && var14 != ProgramShadow) {
               var14.copyFrom(var15);
            }
         }

         resize();
         resizeShadow();
         if (noiseTextureEnabled) {
            setupNoiseTexture();
         }

         if (defaultTexture == null) {
            defaultTexture = ShadersTex.createDefaultTexture();
         }

         GlStateManager.pushMatrix();
         GlStateManager.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
         preCelestialRotate();
         postCelestialRotate();
         GlStateManager.popMatrix();
         isShaderPackInitialized = true;
         loadEntityDataMap();
         resetDisplayLists();
         if (!var0) {
         }

         checkGLError("Shaders.init");
      }

   }

   private static int createVertShader(Program var0, String var1) {
      int var2 = ARBShaderObjects.glCreateShaderObjectARB(35633);
      if (var2 == 0) {
         return 0;
      } else {
         StringBuilder var3 = new StringBuilder(131072);
         BufferedReader var4 = null;

         try {
            var4 = new BufferedReader(getShaderReader(var1));
         } catch (Exception var10) {
            ARBShaderObjects.glDeleteObjectARB(var2);
            return 0;
         }

         ShaderOption[] var5 = getChangedOptions(shaderPackOptions);
         ArrayList var6 = new ArrayList();
         if (var4 != null) {
            try {
               var4 = ShaderPackParser.resolveIncludes(var4, var1, shaderPack, 0, var6, 0);
               MacroState var7 = new MacroState();

               while(true) {
                  String var8 = var4.readLine();
                  if (var8 == null) {
                     var4.close();
                     break;
                  }

                  var8 = applyOptions(var8, var5);
                  var3.append(var8).append('\n');
                  if (var7.processLine(var8)) {
                     ShaderLine var9 = ShaderParser.parseLine(var8);
                     if (var9 != null) {
                        if (var9.isAttribute("mc_Entity")) {
                           useEntityAttrib = true;
                           progUseEntityAttrib = true;
                        } else if (var9.isAttribute("mc_midTexCoord")) {
                           useMidTexCoordAttrib = true;
                           progUseMidTexCoordAttrib = true;
                        } else if (var9.isAttribute("at_tangent")) {
                           useTangentAttrib = true;
                           progUseTangentAttrib = true;
                        }

                        if (var9.isConstInt("countInstances")) {
                           var0.setCountInstances(var9.getValueInt());
                           SMCLog.info("countInstances: " + var0.getCountInstances());
                        }
                     }
                  }
               }
            } catch (Exception var11) {
               SMCLog.severe("Couldn't read " + var1 + "!");
               var11.printStackTrace();
               ARBShaderObjects.glDeleteObjectARB(var2);
               return 0;
            }
         }

         if (saveFinalShaders) {
            saveShader(var1, var3.toString());
         }

         ARBShaderObjects.glShaderSourceARB(var2, var3);
         ARBShaderObjects.glCompileShaderARB(var2);
         if (GL20.glGetShaderi(var2, 35713) != 1) {
            SMCLog.severe("Error compiling vertex shader: " + var1);
         }

         printShaderLogInfo(var2, var1, var6);
         return var2;
      }
   }

   public static boolean isShaderPackOptionSlider(String var0) {
      return shaderPackOptionSliders == null ? false : shaderPackOptionSliders.contains(var0);
   }

   public static void updateBlockLightLevel() {
      if (isOldLighting()) {
         blockLightLevel05 = 0.5F;
         blockLightLevel06 = 0.6F;
         blockLightLevel08 = 0.8F;
      } else {
         blockLightLevel05 = 1.0F;
         blockLightLevel06 = 1.0F;
         blockLightLevel08 = 1.0F;
      }

   }

   private Shaders() {
   }

   public static void setClearColor(float var0, float var1, float var2, float var3) {
      GlStateManager.clearColor(var0, var1, var2, var3);
      clearColorR = var0;
      clearColorG = var1;
      clearColorB = var2;
   }

   private static void setProgramUniform1f(ShaderUniform1f var0, float var1) {
      var0.setValue(var1);
   }

   public static IntBuffer nextIntBuffer(int var0) {
      ByteBuffer var1 = bigBuffer;
      int var2 = var1.limit();
      var1.position(var2).limit(var2 + var0 * 4);
      return var1.asIntBuffer();
   }

   private static void drawCompositeQuad() {
      if (!canRenderQuads()) {
         GL11.glBegin(5);
         GL11.glTexCoord2f(0.0F, 0.0F);
         GL11.glVertex3f(0.0F, 0.0F, 0.0F);
         GL11.glTexCoord2f(1.0F, 0.0F);
         GL11.glVertex3f(1.0F, 0.0F, 0.0F);
         GL11.glTexCoord2f(0.0F, 1.0F);
         GL11.glVertex3f(0.0F, 1.0F, 0.0F);
         GL11.glTexCoord2f(1.0F, 1.0F);
         GL11.glVertex3f(1.0F, 1.0F, 0.0F);
         GL11.glEnd();
      } else {
         GL11.glBegin(7);
         GL11.glTexCoord2f(0.0F, 0.0F);
         GL11.glVertex3f(0.0F, 0.0F, 0.0F);
         GL11.glTexCoord2f(1.0F, 0.0F);
         GL11.glVertex3f(1.0F, 0.0F, 0.0F);
         GL11.glTexCoord2f(1.0F, 1.0F);
         GL11.glVertex3f(1.0F, 1.0F, 0.0F);
         GL11.glTexCoord2f(0.0F, 1.0F);
         GL11.glVertex3f(0.0F, 1.0F, 0.0F);
         GL11.glEnd();
      }

   }

   public static boolean isDynamicHandLight() {
      return !shaderPackDynamicHandLight.isDefault() ? shaderPackDynamicHandLight.isTrue() : true;
   }

   private static int getDimensionId(World var0) {
      return var0 == null ? Integer.MIN_VALUE : var0.provider.getDimensionId();
   }

   private static int getTextureIndex(int var0, String var1) {
      if (var0 == 0) {
         label260: {
            if (var1.equals("texture")) {
               return 0;
            }

            if (var1.equals("lightmap")) {
               return 1;
            }

            if (var1.equals("normals")) {
               return 2;
            }

            if (var1.equals("specular")) {
               return 3;
            }

            if (!var1.equals("shadowtex0") && !var1.equals("watershadow")) {
               if (var1.equals("shadow")) {
                  return waterShadowEnabled ? 5 : 4;
               }

               if (var1.equals("shadowtex1")) {
                  return 5;
               }

               if (var1.equals("depthtex0")) {
                  return 6;
               }

               if (var1.equals("gaux1")) {
                  return 7;
               }

               if (var1.equals("gaux2")) {
                  return 8;
               }

               if (var1.equals("gaux3")) {
                  return 9;
               }

               if (var1.equals("gaux4")) {
                  return 10;
               }

               if (var1.equals("depthtex1")) {
                  return 12;
               }

               if (!var1.equals("shadowcolor0") && !var1.equals("shadowcolor")) {
                  if (var1.equals("shadowcolor1")) {
                     return 14;
                  }

                  if (var1.equals("noisetex")) {
                     return 15;
                  }
                  break label260;
               }

               return 13;
            }

            return 4;
         }
      }

      if (var0 == 1 || var0 == 2) {
         if (var1.equals("colortex0") || var1.equals("colortex0")) {
            return 0;
         }

         if (var1.equals("colortex1") || var1.equals("gdepth")) {
            return 1;
         }

         if (var1.equals("colortex2") || var1.equals("gnormal")) {
            return 2;
         }

         if (var1.equals("colortex3") || var1.equals("composite")) {
            return 3;
         }

         if (var1.equals("shadowtex0") || var1.equals("watershadow")) {
            return 4;
         }

         if (var1.equals("shadow")) {
            return waterShadowEnabled ? 5 : 4;
         }

         if (var1.equals("shadowtex1")) {
            return 5;
         }

         if (var1.equals("depthtex0") || var1.equals("gdepthtex")) {
            return 6;
         }

         if (var1.equals("colortex4") || var1.equals("gaux1")) {
            return 7;
         }

         if (var1.equals("colortex5") || var1.equals("gaux2")) {
            return 8;
         }

         if (var1.equals("colortex6") || var1.equals("gaux3")) {
            return 9;
         }

         if (var1.equals("colortex7") || var1.equals("gaux4")) {
            return 10;
         }

         if (var1.equals("depthtex1")) {
            return 11;
         }

         if (var1.equals("depthtex2")) {
            return 12;
         }

         if (var1.equals("shadowcolor0") || var1.equals("shadowcolor")) {
            return 13;
         }

         if (var1.equals("shadowcolor1")) {
            return 14;
         }

         if (var1.equals("noisetex")) {
            return 15;
         }
      }

      return -1;
   }

   public static String getEnumShaderOption(EnumShaderOption var0) {
      switch($SWITCH_TABLE$net$optifine$shaders$config$EnumShaderOption()[var0.ordinal()]) {
      case 1:
         return Integer.toString(configAntialiasingLevel);
      case 2:
         return Boolean.toString(configNormalMap);
      case 3:
         return Boolean.toString(configSpecularMap);
      case 4:
         return Float.toString(configRenderResMul);
      case 5:
         return Float.toString(configShadowResMul);
      case 6:
         return Float.toString(configHandDepthMul);
      case 7:
         return Boolean.toString(configCloudShadow);
      case 8:
         return configOldHandLight.getPropertyValue();
      case 9:
         return configOldLighting.getPropertyValue();
      case 10:
         return currentShaderName;
      case 11:
         return Boolean.toString(configTweakBlockDamage);
      case 12:
         return Boolean.toString(configShadowClipFrustrum);
      case 13:
         return Integer.toString(configTexMinFilB);
      case 14:
         return Integer.toString(configTexMinFilN);
      case 15:
         return Integer.toString(configTexMinFilS);
      case 16:
         return Integer.toString(configTexMagFilB);
      case 17:
         return Integer.toString(configTexMagFilB);
      case 18:
         return Integer.toString(configTexMagFilB);
      default:
         throw new IllegalArgumentException("Unknown option: " + var0);
      }
   }

   private static boolean isTranslucentBlock(ItemStack var0) {
      if (var0 == null) {
         return false;
      } else {
         Item var1 = var0.getItem();
         if (var1 == null) {
            return false;
         } else if (!(var1 instanceof ItemBlock)) {
            return false;
         } else {
            ItemBlock var2 = (ItemBlock)var1;
            Block var3 = var2.getBlock();
            if (var3 == null) {
               return false;
            } else {
               EnumWorldBlockLayer var4 = var3.getBlockLayer();
               return var4 == EnumWorldBlockLayer.TRANSLUCENT;
            }
         }
      }
   }

   public static ShaderOption[] getShaderPackOptions() {
      return shaderPackOptions;
   }

   public static boolean isHandRenderedMain() {
      return isHandRenderedMain;
   }

   public static void sglEnableT2D(int var0) {
      GL11.glEnable(var0);
      enableTexture2D();
   }

   private static int createFragShader(Program var0, String var1) {
      int var2 = ARBShaderObjects.glCreateShaderObjectARB(35632);
      if (var2 == 0) {
         return 0;
      } else {
         StringBuilder var3 = new StringBuilder(131072);
         BufferedReader var4 = null;

         try {
            var4 = new BufferedReader(getShaderReader(var1));
         } catch (Exception var14) {
            ARBShaderObjects.glDeleteObjectARB(var2);
            return 0;
         }

         ShaderOption[] var5 = getChangedOptions(shaderPackOptions);
         ArrayList var6 = new ArrayList();
         if (var4 != null) {
            try {
               var4 = ShaderPackParser.resolveIncludes(var4, var1, shaderPack, 0, var6, 0);
               MacroState var7 = new MacroState();

               label433:
               while(true) {
                  while(true) {
                     while(true) {
                        ShaderLine var9;
                        do {
                           String var8;
                           do {
                              var8 = var4.readLine();
                              if (var8 == null) {
                                 var4.close();
                                 break label433;
                              }

                              var8 = applyOptions(var8, var5);
                              var3.append(var8).append('\n');
                           } while(!var7.processLine(var8));

                           var9 = ShaderParser.parseLine(var8);
                        } while(var9 == null);

                        String var10;
                        int var11;
                        if (var9.isUniform()) {
                           var10 = var9.getName();
                           if ((var11 = ShaderParser.getShadowDepthIndex(var10)) >= 0) {
                              usedShadowDepthBuffers = Math.max(usedShadowDepthBuffers, var11 + 1);
                           } else if ((var11 = ShaderParser.getShadowColorIndex(var10)) >= 0) {
                              usedShadowColorBuffers = Math.max(usedShadowColorBuffers, var11 + 1);
                           } else if ((var11 = ShaderParser.getDepthIndex(var10)) >= 0) {
                              usedDepthBuffers = Math.max(usedDepthBuffers, var11 + 1);
                           } else if (var10.equals("gdepth") && gbuffersFormat[1] == 6408) {
                              gbuffersFormat[1] = 34836;
                           } else if ((var11 = ShaderParser.getColorIndex(var10)) >= 0) {
                              usedColorBuffers = Math.max(usedColorBuffers, var11 + 1);
                           } else if (var10.equals("centerDepthSmooth")) {
                              centerDepthSmoothEnabled = true;
                           }
                        } else if (!var9.isConstInt("shadowMapResolution") && !var9.isProperty("SHADOWRES")) {
                           if (!var9.isConstFloat("shadowMapFov") && !var9.isProperty("SHADOWFOV")) {
                              if (!var9.isConstFloat("shadowDistance") && !var9.isProperty("SHADOWHPL")) {
                                 if (var9.isConstFloat("shadowDistanceRenderMul")) {
                                    shadowDistanceRenderMul = var9.getValueFloat();
                                    SMCLog.info("Shadow distance render mul: " + shadowDistanceRenderMul);
                                 } else if (var9.isConstFloat("shadowIntervalSize")) {
                                    shadowIntervalSize = var9.getValueFloat();
                                    SMCLog.info("Shadow map interval size: " + shadowIntervalSize);
                                 } else if (var9.isConstBool("generateShadowMipmap", true)) {
                                    Arrays.fill(shadowMipmapEnabled, true);
                                    SMCLog.info("Generate shadow mipmap");
                                 } else if (var9.isConstBool("generateShadowColorMipmap", true)) {
                                    Arrays.fill(shadowColorMipmapEnabled, true);
                                    SMCLog.info("Generate shadow color mipmap");
                                 } else if (var9.isConstBool("shadowHardwareFiltering", true)) {
                                    Arrays.fill(shadowHardwareFilteringEnabled, true);
                                    SMCLog.info("Hardware shadow filtering enabled.");
                                 } else if (var9.isConstBool("shadowHardwareFiltering0", true)) {
                                    shadowHardwareFilteringEnabled[0] = true;
                                    SMCLog.info("shadowHardwareFiltering0");
                                 } else if (var9.isConstBool("shadowHardwareFiltering1", true)) {
                                    shadowHardwareFilteringEnabled[1] = true;
                                    SMCLog.info("shadowHardwareFiltering1");
                                 } else if (var9.isConstBool("shadowtex0Mipmap", "shadowtexMipmap", true)) {
                                    shadowMipmapEnabled[0] = true;
                                    SMCLog.info("shadowtex0Mipmap");
                                 } else if (var9.isConstBool("shadowtex1Mipmap", true)) {
                                    shadowMipmapEnabled[1] = true;
                                    SMCLog.info("shadowtex1Mipmap");
                                 } else if (var9.isConstBool("shadowcolor0Mipmap", "shadowColor0Mipmap", true)) {
                                    shadowColorMipmapEnabled[0] = true;
                                    SMCLog.info("shadowcolor0Mipmap");
                                 } else if (var9.isConstBool("shadowcolor1Mipmap", "shadowColor1Mipmap", true)) {
                                    shadowColorMipmapEnabled[1] = true;
                                    SMCLog.info("shadowcolor1Mipmap");
                                 } else if (var9.isConstBool("shadowtex0Nearest", "shadowtexNearest", "shadow0MinMagNearest", true)) {
                                    shadowFilterNearest[0] = true;
                                    SMCLog.info("shadowtex0Nearest");
                                 } else if (var9.isConstBool("shadowtex1Nearest", "shadow1MinMagNearest", true)) {
                                    shadowFilterNearest[1] = true;
                                    SMCLog.info("shadowtex1Nearest");
                                 } else if (var9.isConstBool("shadowcolor0Nearest", "shadowColor0Nearest", "shadowColor0MinMagNearest", true)) {
                                    shadowColorFilterNearest[0] = true;
                                    SMCLog.info("shadowcolor0Nearest");
                                 } else if (var9.isConstBool("shadowcolor1Nearest", "shadowColor1Nearest", "shadowColor1MinMagNearest", true)) {
                                    shadowColorFilterNearest[1] = true;
                                    SMCLog.info("shadowcolor1Nearest");
                                 } else if (!var9.isConstFloat("wetnessHalflife") && !var9.isProperty("WETNESSHL")) {
                                    if (!var9.isConstFloat("drynessHalflife") && !var9.isProperty("DRYNESSHL")) {
                                       if (var9.isConstFloat("eyeBrightnessHalflife")) {
                                          eyeBrightnessHalflife = var9.getValueFloat();
                                          SMCLog.info("Eye brightness halflife: " + eyeBrightnessHalflife);
                                       } else if (var9.isConstFloat("centerDepthHalflife")) {
                                          centerDepthSmoothHalflife = var9.getValueFloat();
                                          SMCLog.info("Center depth halflife: " + centerDepthSmoothHalflife);
                                       } else if (var9.isConstFloat("sunPathRotation")) {
                                          sunPathRotation = var9.getValueFloat();
                                          SMCLog.info("Sun path rotation: " + sunPathRotation);
                                       } else if (var9.isConstFloat("ambientOcclusionLevel")) {
                                          aoLevel = Config.limit(var9.getValueFloat(), 0.0F, 1.0F);
                                          SMCLog.info("AO Level: " + aoLevel);
                                       } else if (var9.isConstInt("superSamplingLevel")) {
                                          int var16 = var9.getValueInt();
                                          if (var16 > 1) {
                                             SMCLog.info("Super sampling level: " + var16 + "x");
                                             superSamplingLevel = var16;
                                          } else {
                                             superSamplingLevel = 1;
                                          }
                                       } else if (var9.isConstInt("noiseTextureResolution")) {
                                          noiseTextureResolution = var9.getValueInt();
                                          noiseTextureEnabled = true;
                                          SMCLog.info("Noise texture enabled");
                                          SMCLog.info("Noise texture resolution: " + noiseTextureResolution);
                                       } else {
                                          int var12;
                                          if (var9.isConstIntSuffix("Format")) {
                                             var10 = StrUtils.removeSuffix(var9.getName(), "Format");
                                             String var17 = var9.getValue();
                                             var12 = getBufferIndexFromString(var10);
                                             int var13 = getTextureFormatFromString(var17);
                                             if (var12 >= 0 && var13 != 0) {
                                                gbuffersFormat[var12] = var13;
                                                SMCLog.info("%s format: %s", var10, var17);
                                             }
                                          } else if (var9.isConstBoolSuffix("Clear", false)) {
                                             if (ShaderParser.isComposite(var1) || ShaderParser.isDeferred(var1)) {
                                                var10 = StrUtils.removeSuffix(var9.getName(), "Clear");
                                                var11 = getBufferIndexFromString(var10);
                                                if (var11 >= 0) {
                                                   gbuffersClear[var11] = false;
                                                   SMCLog.info("%s clear disabled", var10);
                                                }
                                             }
                                          } else if (var9.isConstVec4Suffix("ClearColor")) {
                                             if (ShaderParser.isComposite(var1) || ShaderParser.isDeferred(var1)) {
                                                var10 = StrUtils.removeSuffix(var9.getName(), "ClearColor");
                                                var11 = getBufferIndexFromString(var10);
                                                if (var11 >= 0) {
                                                   Vector4f var18 = var9.getValueVec4();
                                                   if (var18 != null) {
                                                      gbuffersClearColor[var11] = var18;
                                                      SMCLog.info("%s clear color: %s %s %s %s", var10, var18.getX(), var18.getY(), var18.getZ(), var18.getW());
                                                   } else {
                                                      SMCLog.warning("Invalid color value: " + var9.getValue());
                                                   }
                                                }
                                             }
                                          } else if (var9.isProperty("GAUX4FORMAT", "RGBA32F")) {
                                             gbuffersFormat[7] = 34836;
                                             SMCLog.info("gaux4 format : RGB32AF");
                                          } else if (var9.isProperty("GAUX4FORMAT", "RGB32F")) {
                                             gbuffersFormat[7] = 34837;
                                             SMCLog.info("gaux4 format : RGB32F");
                                          } else if (var9.isProperty("GAUX4FORMAT", "RGB16")) {
                                             gbuffersFormat[7] = 32852;
                                             SMCLog.info("gaux4 format : RGB16");
                                          } else if (var9.isConstBoolSuffix("MipmapEnabled", true)) {
                                             if (ShaderParser.isComposite(var1) || ShaderParser.isDeferred(var1) || ShaderParser.isFinal(var1)) {
                                                var10 = StrUtils.removeSuffix(var9.getName(), "MipmapEnabled");
                                                var11 = getBufferIndexFromString(var10);
                                                if (var11 >= 0) {
                                                   var12 = var0.getCompositeMipmapSetting();
                                                   var12 |= 1 << var11;
                                                   var0.setCompositeMipmapSetting(var12);
                                                   SMCLog.info("%s mipmap enabled", var10);
                                                }
                                             }
                                          } else if (var9.isProperty("DRAWBUFFERS")) {
                                             var10 = var9.getValue();
                                             if (ShaderParser.isValidDrawBuffers(var10)) {
                                                var0.setDrawBufSettings(var10);
                                             } else {
                                                SMCLog.warning("Invalid draw buffers: " + var10);
                                             }
                                          }
                                       }
                                    } else {
                                       drynessHalfLife = var9.getValueFloat();
                                       SMCLog.info("Dryness halflife: " + drynessHalfLife);
                                    }
                                 } else {
                                    wetnessHalfLife = var9.getValueFloat();
                                    SMCLog.info("Wetness halflife: " + wetnessHalfLife);
                                 }
                              } else {
                                 shadowMapHalfPlane = var9.getValueFloat();
                                 shadowMapIsOrtho = true;
                                 SMCLog.info("Shadow map distance: " + shadowMapHalfPlane);
                              }
                           } else {
                              shadowMapFOV = var9.getValueFloat();
                              shadowMapIsOrtho = false;
                              SMCLog.info("Shadow map field of view: " + shadowMapFOV);
                           }
                        } else {
                           spShadowMapWidth = spShadowMapHeight = var9.getValueInt();
                           shadowMapWidth = shadowMapHeight = Math.round((float)spShadowMapWidth * configShadowResMul);
                           SMCLog.info("Shadow map resolution: " + spShadowMapWidth);
                        }
                     }
                  }
               }
            } catch (Exception var15) {
               SMCLog.severe("Couldn't read " + var1 + "!");
               var15.printStackTrace();
               ARBShaderObjects.glDeleteObjectARB(var2);
               return 0;
            }
         }

         if (saveFinalShaders) {
            saveShader(var1, var3.toString());
         }

         ARBShaderObjects.glShaderSourceARB(var2, var3);
         ARBShaderObjects.glCompileShaderARB(var2);
         if (GL20.glGetShaderi(var2, 35713) != 1) {
            SMCLog.severe("Error compiling fragment shader: " + var1);
         }

         printShaderLogInfo(var2, var1, var6);
         return var2;
      }
   }

   public static void postCelestialRotate() {
      FloatBuffer var0 = tempMatrixDirectBuffer;
      var0.clear();
      GL11.glGetFloat(2982, var0);
      var0.get(tempMat, 0, 16);
      SMath.multiplyMat4xVec4(sunPosition, tempMat, sunPosModelView);
      SMath.multiplyMat4xVec4(moonPosition, tempMat, moonPosModelView);
      System.arraycopy(shadowAngle == sunAngle ? sunPosition : moonPosition, 0, shadowLightPosition, 0, 3);
      setProgramUniform3f(uniform_sunPosition, sunPosition[0], sunPosition[1], sunPosition[2]);
      setProgramUniform3f(uniform_moonPosition, moonPosition[0], moonPosition[1], moonPosition[2]);
      setProgramUniform3f(uniform_shadowLightPosition, shadowLightPosition[0], shadowLightPosition[1], shadowLightPosition[2]);
      if (customUniforms != null) {
         customUniforms.update();
      }

      checkGLError("postCelestialRotate");
   }

   public static void nextBlockEntity(TileEntity var0) {
      if (isRenderingWorld) {
         checkGLError("nextBlockEntity");
         useProgram(ProgramBlock);
         setBlockEntityId(var0);
      }

   }

   public static void mcProfilerEndSection() {
      mc.mcProfiler.endSection();
   }

   private static ShaderOption[] getShaderOptionsRest(Map<String, ScreenShaderOptions> var0, ShaderOption[] var1) {
      HashSet var2 = new HashSet();
      Iterator var4 = var0.keySet().iterator();

      while(var4.hasNext()) {
         String var3 = (String)var4.next();
         ScreenShaderOptions var5 = (ScreenShaderOptions)var0.get(var3);
         ShaderOption[] var6 = var5.getShaderOptions();

         for(int var7 = 0; var7 < var6.length; ++var7) {
            ShaderOption var8 = var6[var7];
            if (var8 != null) {
               var2.add(var8.getName());
            }
         }
      }

      ArrayList var9 = new ArrayList();

      for(int var10 = 0; var10 < var1.length; ++var10) {
         ShaderOption var12 = var1[var10];
         if (var12.isVisible()) {
            String var13 = var12.getName();
            if (!var2.contains(var13)) {
               var9.add(var12);
            }
         }
      }

      ShaderOption[] var11 = (ShaderOption[])var9.toArray(new ShaderOption[var9.size()]);
      return var11;
   }

   private static void setupShadowFrameBuffer() {
      if (usedShadowDepthBuffers != 0) {
         if (sfb != 0) {
            EXTFramebufferObject.glDeleteFramebuffersEXT(sfb);
            GlStateManager.deleteTextures(sfbDepthTextures);
            GlStateManager.deleteTextures(sfbColorTextures);
         }

         sfb = EXTFramebufferObject.glGenFramebuffersEXT();
         EXTFramebufferObject.glBindFramebufferEXT(36160, sfb);
         GL11.glDrawBuffer(0);
         GL11.glReadBuffer(0);
         GL11.glGenTextures((IntBuffer)sfbDepthTextures.clear().limit(usedShadowDepthBuffers));
         GL11.glGenTextures((IntBuffer)sfbColorTextures.clear().limit(usedShadowColorBuffers));
         sfbDepthTextures.position(0);
         sfbColorTextures.position(0);

         int var0;
         int var1;
         for(var0 = 0; var0 < usedShadowDepthBuffers; ++var0) {
            GlStateManager.bindTexture(sfbDepthTextures.get(var0));
            GL11.glTexParameterf(3553, 10242, 33071.0F);
            GL11.glTexParameterf(3553, 10243, 33071.0F);
            var1 = shadowFilterNearest[var0] ? 9728 : 9729;
            GL11.glTexParameteri(3553, 10241, var1);
            GL11.glTexParameteri(3553, 10240, var1);
            if (shadowHardwareFilteringEnabled[var0]) {
               GL11.glTexParameteri(3553, 34892, 34894);
            }

            GL11.glTexImage2D(3553, 0, 6402, shadowMapWidth, shadowMapHeight, 0, 6402, 5126, (FloatBuffer)null);
         }

         EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, sfbDepthTextures.get(0), 0);
         checkGLError("FT sd");

         for(var0 = 0; var0 < usedShadowColorBuffers; ++var0) {
            GlStateManager.bindTexture(sfbColorTextures.get(var0));
            GL11.glTexParameterf(3553, 10242, 33071.0F);
            GL11.glTexParameterf(3553, 10243, 33071.0F);
            var1 = shadowColorFilterNearest[var0] ? 9728 : 9729;
            GL11.glTexParameteri(3553, 10241, var1);
            GL11.glTexParameteri(3553, 10240, var1);
            GL11.glTexImage2D(3553, 0, 6408, shadowMapWidth, shadowMapHeight, 0, 32993, 33639, (ByteBuffer)null);
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, '賠' + var0, 3553, sfbColorTextures.get(var0), 0);
            checkGLError("FT sc");
         }

         GlStateManager.bindTexture(0);
         if (usedShadowColorBuffers > 0) {
            GL20.glDrawBuffers(sfbDrawBuffers);
         }

         var0 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
         if (var0 != 36053) {
            printChatAndLogError("[Shaders] Error: Failed creating shadow framebuffer! (Status " + var0 + ")");
         } else {
            SMCLog.info("Shadow framebuffer created.");
         }
      }

   }

   private static String getFramebufferStatusText(int var0) {
      switch(var0) {
      case 33305:
         return "Undefined";
      case 36053:
         return "Complete";
      case 36054:
         return "Incomplete attachment";
      case 36055:
         return "Incomplete missing attachment";
      case 36059:
         return "Incomplete draw buffer";
      case 36060:
         return "Incomplete read buffer";
      case 36061:
         return "Unsupported";
      case 36182:
         return "Incomplete multisample";
      case 36264:
         return "Incomplete layer targets";
      default:
         return "Unknown";
      }
   }

   public static boolean isVignette() {
      return !shaderPackVignette.isFalse();
   }

   public static void endLeash() {
      useProgram(programStackLeash.pop());
   }

   public static void setHandsRendered(boolean var0, boolean var1) {
      isHandRenderedMain = var0;
      isHandRenderedOff = var1;
   }

   public static void clearRenderBuffer() {
      if (isShadowPass) {
         checkGLError("shadow clear pre");
         EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, sfbDepthTextures.get(0), 0);
         GL11.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
         GL20.glDrawBuffers(ProgramShadow.getDrawBuffers());
         checkFramebufferStatus("shadow clear");
         GL11.glClear(16640);
         checkGLError("shadow clear");
      } else {
         checkGLError("clear pre");
         Vector4f var0;
         if (gbuffersClear[0]) {
            var0 = gbuffersClearColor[0];
            if (var0 != null) {
               GL11.glClearColor(var0.getX(), var0.getY(), var0.getZ(), var0.getW());
            }

            if (dfbColorTexturesFlip.isChanged(0)) {
               EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064, 3553, dfbColorTexturesFlip.getB(0), 0);
               GL20.glDrawBuffers(36064);
               GL11.glClear(16384);
               EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36064, 3553, dfbColorTexturesFlip.getA(0), 0);
            }

            GL20.glDrawBuffers(36064);
            GL11.glClear(16384);
         }

         if (gbuffersClear[1]) {
            GL11.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
            var0 = gbuffersClearColor[1];
            if (var0 != null) {
               GL11.glClearColor(var0.getX(), var0.getY(), var0.getZ(), var0.getW());
            }

            if (dfbColorTexturesFlip.isChanged(1)) {
               EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36065, 3553, dfbColorTexturesFlip.getB(1), 0);
               GL20.glDrawBuffers(36065);
               GL11.glClear(16384);
               EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36065, 3553, dfbColorTexturesFlip.getA(1), 0);
            }

            GL20.glDrawBuffers(36065);
            GL11.glClear(16384);
         }

         for(int var2 = 2; var2 < usedColorBuffers; ++var2) {
            if (gbuffersClear[var2]) {
               GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
               Vector4f var1 = gbuffersClearColor[var2];
               if (var1 != null) {
                  GL11.glClearColor(var1.getX(), var1.getY(), var1.getZ(), var1.getW());
               }

               if (dfbColorTexturesFlip.isChanged(var2)) {
                  EXTFramebufferObject.glFramebufferTexture2DEXT(36160, '賠' + var2, 3553, dfbColorTexturesFlip.getB(var2), 0);
                  GL20.glDrawBuffers('賠' + var2);
                  GL11.glClear(16384);
                  EXTFramebufferObject.glFramebufferTexture2DEXT(36160, '賠' + var2, 3553, dfbColorTexturesFlip.getA(var2), 0);
               }

               GL20.glDrawBuffers('賠' + var2);
               GL11.glClear(16384);
            }
         }

         setDrawBuffers(dfbDrawBuffers);
         checkFramebufferStatus("clear");
         checkGLError("clear");
      }

   }

   private static void setCameraOffset(Entity var0) {
      if (var0 == null) {
         cameraOffsetX = 0;
         cameraOffsetZ = 0;
      } else {
         cameraOffsetX = (int)var0.posX / 1000 * 1000;
         cameraOffsetZ = (int)var0.posZ / 1000 * 1000;
      }

   }

   public static void renderCompositeFinal() {
      if (!isShadowPass) {
         checkBufferFlip(ProgramCompositePre);
         checkGLError("pre-render CompositeFinal");
         renderComposites(ProgramsComposite, true);
      }

   }

   private static void updateAlphaBlend(Program var0, Program var1) {
      if (var0.getAlphaState() != null) {
         GlStateManager.unlockAlpha();
      }

      if (var0.getBlendState() != null) {
         GlStateManager.unlockBlend();
      }

      GlAlphaState var2 = var1.getAlphaState();
      if (var2 != null) {
         GlStateManager.lockAlpha(var2);
      }

      GlBlendState var3 = var1.getBlendState();
      if (var3 != null) {
         GlStateManager.lockBlend(var3);
      }

   }

   public static void enableLightmap() {
      lightmapEnabled = true;
      if (activeProgram == ProgramTextured) {
         useProgram(ProgramTexturedLit);
      }

   }

   public static String translate(String var0, String var1) {
      String var2 = (String)shaderPackResources.get(var0);
      return var2 == null ? var1 : var2;
   }

   public static void beginLeash() {
      programStackLeash.push(activeProgram);
      useProgram(ProgramBasic);
   }

   public static void sglDisableFog(int var0) {
      GL11.glDisable(var0);
      disableFog();
   }

   private static void bindGbuffersTextures() {
      if (usedShadowDepthBuffers >= 1) {
         GlStateManager.setActiveTexture(33988);
         GlStateManager.bindTexture(sfbDepthTextures.get(0));
         if (usedShadowDepthBuffers >= 2) {
            GlStateManager.setActiveTexture(33989);
            GlStateManager.bindTexture(sfbDepthTextures.get(1));
         }
      }

      GlStateManager.setActiveTexture(33984);

      int var0;
      for(var0 = 0; var0 < usedColorBuffers; ++var0) {
         GlStateManager.bindTexture(dfbColorTexturesFlip.getA(var0));
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glTexParameteri(3553, 10241, 9729);
         GlStateManager.bindTexture(dfbColorTexturesFlip.getB(var0));
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glTexParameteri(3553, 10241, 9729);
      }

      GlStateManager.bindTexture(0);

      for(var0 = 0; var0 < 4 && 4 + var0 < usedColorBuffers; ++var0) {
         GlStateManager.setActiveTexture('蓇' + var0);
         GlStateManager.bindTexture(dfbColorTexturesFlip.getA(4 + var0));
      }

      GlStateManager.setActiveTexture(33990);
      GlStateManager.bindTexture(dfbDepthTextures.get(0));
      if (usedDepthBuffers >= 2) {
         GlStateManager.setActiveTexture(33995);
         GlStateManager.bindTexture(dfbDepthTextures.get(1));
         if (usedDepthBuffers >= 3) {
            GlStateManager.setActiveTexture(33996);
            GlStateManager.bindTexture(dfbDepthTextures.get(2));
         }
      }

      for(var0 = 0; var0 < usedShadowColorBuffers; ++var0) {
         GlStateManager.setActiveTexture('蓍' + var0);
         GlStateManager.bindTexture(sfbColorTextures.get(var0));
      }

      if (noiseTextureEnabled) {
         GlStateManager.setActiveTexture('蓀' + noiseTexture.getTextureUnit());
         GlStateManager.bindTexture(noiseTexture.getTextureId());
      }

      bindCustomTextures(customTexturesGbuffers);
      GlStateManager.setActiveTexture(33984);
   }

   public static void beginLitParticles() {
      useProgram(ProgramTexturedLit);
   }

   private static int getBlockEntityId(TileEntity var0) {
      if (var0 == null) {
         return -1;
      } else {
         Block var1 = var0.getBlockType();
         if (var1 == null) {
            return 0;
         } else {
            int var2 = Block.getIdFromBlock(var1);
            int var3 = var0.getBlockMetadata();
            int var4 = BlockAliases.getBlockAliasId(var2, var3);
            if (var4 >= 0) {
               var2 = var4;
            }

            return var2;
         }
      }
   }

   public static void disableTexture2D() {
      if (isRenderingSky) {
         useProgram(ProgramSkyBasic);
      } else if (activeProgram == ProgramTextured || activeProgram == ProgramTexturedLit) {
         useProgram(ProgramBasic);
      }

   }

   private static void resizeShadow() {
      needResizeShadow = false;
      shadowMapWidth = Math.round((float)spShadowMapWidth * configShadowResMul);
      shadowMapHeight = Math.round((float)spShadowMapHeight * configShadowResMul);
      setupShadowFrameBuffer();
   }

   public static void useProgram(Program var0) {
      checkGLError("pre-useProgram");
      if (isShadowPass) {
         var0 = ProgramShadow;
      } else if (isEntitiesGlowing) {
         var0 = ProgramEntitiesGlowing;
      }

      if (activeProgram != var0) {
         updateAlphaBlend(activeProgram, var0);
         activeProgram = var0;
         int var1 = var0.getId();
         activeProgramID = var1;
         ARBShaderObjects.glUseProgramObjectARB(var1);
         if (checkGLError("useProgram") != 0) {
            var0.setId(0);
            var1 = var0.getId();
            activeProgramID = var1;
            ARBShaderObjects.glUseProgramObjectARB(var1);
         }

         shaderUniforms.setProgram(var1);
         if (customUniforms != null) {
            customUniforms.setProgram(var1);
         }

         if (var1 != 0) {
            IntBuffer var2 = var0.getDrawBuffers();
            if (isRenderingDfb) {
               setDrawBuffers(var2);
            }

            activeCompositeMipmapSetting = var0.getCompositeMipmapSetting();
            switch($SWITCH_TABLE$net$optifine$shaders$ProgramStage()[var0.getProgramStage().ordinal()]) {
            case 2:
               setProgramUniform1i(uniform_tex, 0);
               setProgramUniform1i(uniform_texture, 0);
               setProgramUniform1i(uniform_lightmap, 1);
               setProgramUniform1i(uniform_normals, 2);
               setProgramUniform1i(uniform_specular, 3);
               setProgramUniform1i(uniform_shadow, waterShadowEnabled ? 5 : 4);
               setProgramUniform1i(uniform_watershadow, 4);
               setProgramUniform1i(uniform_shadowtex0, 4);
               setProgramUniform1i(uniform_shadowtex1, 5);
               if (customTexturesGbuffers != null) {
                  setProgramUniform1i(uniform_gaux1, 7);
                  setProgramUniform1i(uniform_gaux2, 8);
                  setProgramUniform1i(uniform_gaux3, 9);
                  setProgramUniform1i(uniform_gaux4, 10);
               }

               setProgramUniform1i(uniform_shadowcolor, 13);
               setProgramUniform1i(uniform_shadowcolor0, 13);
               setProgramUniform1i(uniform_shadowcolor1, 14);
               setProgramUniform1i(uniform_noisetex, 15);
               break;
            case 3:
               setProgramUniform1i(uniform_texture, 0);
               setProgramUniform1i(uniform_lightmap, 1);
               setProgramUniform1i(uniform_normals, 2);
               setProgramUniform1i(uniform_specular, 3);
               setProgramUniform1i(uniform_shadow, waterShadowEnabled ? 5 : 4);
               setProgramUniform1i(uniform_watershadow, 4);
               setProgramUniform1i(uniform_shadowtex0, 4);
               setProgramUniform1i(uniform_shadowtex1, 5);
               setProgramUniform1i(uniform_depthtex0, 6);
               if (customTexturesGbuffers != null || hasDeferredPrograms) {
                  setProgramUniform1i(uniform_gaux1, 7);
                  setProgramUniform1i(uniform_gaux2, 8);
                  setProgramUniform1i(uniform_gaux3, 9);
                  setProgramUniform1i(uniform_gaux4, 10);
               }

               setProgramUniform1i(uniform_depthtex1, 11);
               setProgramUniform1i(uniform_shadowcolor, 13);
               setProgramUniform1i(uniform_shadowcolor0, 13);
               setProgramUniform1i(uniform_shadowcolor1, 14);
               setProgramUniform1i(uniform_noisetex, 15);
               break;
            case 4:
            case 5:
               setProgramUniform1i(uniform_gcolor, 0);
               setProgramUniform1i(uniform_gdepth, 1);
               setProgramUniform1i(uniform_gnormal, 2);
               setProgramUniform1i(uniform_composite, 3);
               setProgramUniform1i(uniform_gaux1, 7);
               setProgramUniform1i(uniform_gaux2, 8);
               setProgramUniform1i(uniform_gaux3, 9);
               setProgramUniform1i(uniform_gaux4, 10);
               setProgramUniform1i(uniform_colortex0, 0);
               setProgramUniform1i(uniform_colortex1, 1);
               setProgramUniform1i(uniform_colortex2, 2);
               setProgramUniform1i(uniform_colortex3, 3);
               setProgramUniform1i(uniform_colortex4, 7);
               setProgramUniform1i(uniform_colortex5, 8);
               setProgramUniform1i(uniform_colortex6, 9);
               setProgramUniform1i(uniform_colortex7, 10);
               setProgramUniform1i(uniform_shadow, waterShadowEnabled ? 5 : 4);
               setProgramUniform1i(uniform_watershadow, 4);
               setProgramUniform1i(uniform_shadowtex0, 4);
               setProgramUniform1i(uniform_shadowtex1, 5);
               setProgramUniform1i(uniform_gdepthtex, 6);
               setProgramUniform1i(uniform_depthtex0, 6);
               setProgramUniform1i(uniform_depthtex1, 11);
               setProgramUniform1i(uniform_depthtex2, 12);
               setProgramUniform1i(uniform_shadowcolor, 13);
               setProgramUniform1i(uniform_shadowcolor0, 13);
               setProgramUniform1i(uniform_shadowcolor1, 14);
               setProgramUniform1i(uniform_noisetex, 15);
            }

            ItemStack var3 = mc.thePlayer != null ? mc.thePlayer.getHeldItem() : null;
            Item var4 = var3 != null ? var3.getItem() : null;
            int var5 = -1;
            Block var6 = null;
            if (var4 != null) {
               var5 = Item.itemRegistry.getIDForObject(var4);
               var6 = (Block)Block.blockRegistry.getObjectById(var5);
               var5 = ItemAliases.getItemAliasId(var5);
            }

            int var7 = var6 != null ? var6.getLightValue() : 0;
            setProgramUniform1i(uniform_heldItemId, var5);
            setProgramUniform1i(uniform_heldBlockLightValue, var7);
            setProgramUniform1i(uniform_fogMode, fogEnabled ? fogMode : 0);
            setProgramUniform1f(uniform_fogDensity, fogEnabled ? fogDensity : 0.0F);
            setProgramUniform3f(uniform_fogColor, fogColorR, fogColorG, fogColorB);
            setProgramUniform3f(uniform_skyColor, skyColorR, skyColorG, skyColorB);
            setProgramUniform1i(uniform_worldTime, (int)(worldTime % 24000L));
            setProgramUniform1i(uniform_worldDay, (int)(worldTime / 24000L));
            setProgramUniform1i(uniform_moonPhase, moonPhase);
            setProgramUniform1i(uniform_frameCounter, frameCounter);
            setProgramUniform1f(uniform_frameTime, frameTime);
            setProgramUniform1f(uniform_frameTimeCounter, frameTimeCounter);
            setProgramUniform1f(uniform_sunAngle, sunAngle);
            setProgramUniform1f(uniform_shadowAngle, shadowAngle);
            setProgramUniform1f(uniform_rainStrength, rainStrength);
            setProgramUniform1f(uniform_aspectRatio, (float)renderWidth / (float)renderHeight);
            setProgramUniform1f(uniform_viewWidth, (float)renderWidth);
            setProgramUniform1f(uniform_viewHeight, (float)renderHeight);
            setProgramUniform1f(uniform_near, 0.05F);
            setProgramUniform1f(uniform_far, (float)(mc.gameSettings.renderDistanceChunks * 16));
            setProgramUniform3f(uniform_sunPosition, sunPosition[0], sunPosition[1], sunPosition[2]);
            setProgramUniform3f(uniform_moonPosition, moonPosition[0], moonPosition[1], moonPosition[2]);
            setProgramUniform3f(uniform_shadowLightPosition, shadowLightPosition[0], shadowLightPosition[1], shadowLightPosition[2]);
            setProgramUniform3f(uniform_upPosition, upPosition[0], upPosition[1], upPosition[2]);
            setProgramUniform3f(uniform_previousCameraPosition, (float)previousCameraPositionX, (float)previousCameraPositionY, (float)previousCameraPositionZ);
            setProgramUniform3f(uniform_cameraPosition, (float)cameraPositionX, (float)cameraPositionY, (float)cameraPositionZ);
            setProgramUniformMatrix4ARB(uniform_gbufferModelView, false, modelView);
            setProgramUniformMatrix4ARB(uniform_gbufferModelViewInverse, false, modelViewInverse);
            setProgramUniformMatrix4ARB(uniform_gbufferPreviousProjection, false, previousProjection);
            setProgramUniformMatrix4ARB(uniform_gbufferProjection, false, projection);
            setProgramUniformMatrix4ARB(uniform_gbufferProjectionInverse, false, projectionInverse);
            setProgramUniformMatrix4ARB(uniform_gbufferPreviousModelView, false, previousModelView);
            if (usedShadowDepthBuffers > 0) {
               setProgramUniformMatrix4ARB(uniform_shadowProjection, false, shadowProjection);
               setProgramUniformMatrix4ARB(uniform_shadowProjectionInverse, false, shadowProjectionInverse);
               setProgramUniformMatrix4ARB(uniform_shadowModelView, false, shadowModelView);
               setProgramUniformMatrix4ARB(uniform_shadowModelViewInverse, false, shadowModelViewInverse);
            }

            setProgramUniform1f(uniform_wetness, wetness);
            setProgramUniform1f(uniform_eyeAltitude, eyePosY);
            setProgramUniform2i(uniform_eyeBrightness, eyeBrightness & '\uffff', eyeBrightness >> 16);
            setProgramUniform2i(uniform_eyeBrightnessSmooth, Math.round(eyeBrightnessFadeX), Math.round(eyeBrightnessFadeY));
            setProgramUniform2i(uniform_terrainTextureSize, terrainTextureSize[0], terrainTextureSize[1]);
            setProgramUniform1i(uniform_terrainIconSize, terrainIconSize);
            setProgramUniform1i(uniform_isEyeInWater, isEyeInWater);
            setProgramUniform1f(uniform_nightVision, nightVision);
            setProgramUniform1f(uniform_blindness, blindness);
            setProgramUniform1f(uniform_screenBrightness, mc.gameSettings.gammaSetting);
            setProgramUniform1i(uniform_hideGUI, mc.gameSettings.hideGUI ? 1 : 0);
            setProgramUniform1f(uniform_centerDepthSmooth, centerDepthSmooth);
            setProgramUniform2i(uniform_atlasSize, atlasSizeX, atlasSizeY);
            if (customUniforms != null) {
               customUniforms.update();
            }

            checkGLError("end useProgram");
         }
      }

   }

   public static boolean isCustomUniforms() {
      return customUniforms != null;
   }

   public static void endBeacon() {
      if (isRenderingWorld) {
         useProgram(ProgramBlock);
      }

   }

   public static void setShaderPack(String var0) {
      currentShaderName = var0;
      shadersConfig.setProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), var0);
      loadShaderPack();
   }

   public static Program getProgram(String var0) {
      return programs.getProgram(var0);
   }

   public static void beginParticles() {
      useProgram(ProgramTextured);
   }

   public static void saveShaderPackOptions() {
      saveShaderPackOptions(shaderPackOptions, shaderPack);
   }

   public static void endParticles() {
      useProgram(ProgramTexturedLit);
   }

   static int[] $SWITCH_TABLE$net$optifine$shaders$config$EnumShaderOption() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$shaders$config$EnumShaderOption;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[EnumShaderOption.values().length];

         try {
            var0[EnumShaderOption.ANTIALIASING.ordinal()] = 1;
         } catch (NoSuchFieldError var18) {
         }

         try {
            var0[EnumShaderOption.CLOUD_SHADOW.ordinal()] = 7;
         } catch (NoSuchFieldError var17) {
         }

         try {
            var0[EnumShaderOption.HAND_DEPTH_MUL.ordinal()] = 6;
         } catch (NoSuchFieldError var16) {
         }

         try {
            var0[EnumShaderOption.NORMAL_MAP.ordinal()] = 2;
         } catch (NoSuchFieldError var15) {
         }

         try {
            var0[EnumShaderOption.OLD_HAND_LIGHT.ordinal()] = 8;
         } catch (NoSuchFieldError var14) {
         }

         try {
            var0[EnumShaderOption.OLD_LIGHTING.ordinal()] = 9;
         } catch (NoSuchFieldError var13) {
         }

         try {
            var0[EnumShaderOption.RENDER_RES_MUL.ordinal()] = 4;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[EnumShaderOption.SHADER_PACK.ordinal()] = 10;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[EnumShaderOption.SHADOW_CLIP_FRUSTRUM.ordinal()] = 12;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[EnumShaderOption.SHADOW_RES_MUL.ordinal()] = 5;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[EnumShaderOption.SPECULAR_MAP.ordinal()] = 3;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[EnumShaderOption.TEX_MAG_FIL_B.ordinal()] = 16;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[EnumShaderOption.TEX_MAG_FIL_N.ordinal()] = 17;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[EnumShaderOption.TEX_MAG_FIL_S.ordinal()] = 18;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[EnumShaderOption.TEX_MIN_FIL_B.ordinal()] = 13;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[EnumShaderOption.TEX_MIN_FIL_N.ordinal()] = 14;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[EnumShaderOption.TEX_MIN_FIL_S.ordinal()] = 15;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[EnumShaderOption.TWEAK_BLOCK_DAMAGE.ordinal()] = 11;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$shaders$config$EnumShaderOption = var0;
         return var0;
      }
   }

   static int[] $SWITCH_TABLE$net$optifine$shaders$ProgramStage() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$shaders$ProgramStage;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[ProgramStage.values().length];

         try {
            var0[ProgramStage.COMPOSITE.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[ProgramStage.DEFERRED.ordinal()] = 4;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[ProgramStage.GBUFFERS.ordinal()] = 3;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[ProgramStage.NONE.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[ProgramStage.SHADOW.ordinal()] = 2;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$shaders$ProgramStage = var0;
         return var0;
      }
   }

   public static BlockPos getCameraPosition() {
      return new BlockPos(cameraPositionX, cameraPositionY, cameraPositionZ);
   }

   public static void endClouds() {
      disableFog();
      popEntity();
      useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
   }

   public static void endSky() {
      isRenderingSky = false;
      setDrawBuffers(dfbDrawBuffers);
      useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
      popEntity();
   }

   private static void renderComposites(Program[] var0, boolean var1) {
      if (!isShadowPass) {
         GL11.glPushMatrix();
         GL11.glLoadIdentity();
         GL11.glMatrixMode(5889);
         GL11.glPushMatrix();
         GL11.glLoadIdentity();
         GL11.glOrtho(0.0D, 1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
         GlStateManager.enableTexture2D();
         GlStateManager.disableAlpha();
         GlStateManager.disableBlend();
         GlStateManager.enableDepth();
         GlStateManager.depthFunc(519);
         GlStateManager.depthMask(false);
         GlStateManager.disableLighting();
         if (usedShadowDepthBuffers >= 1) {
            GlStateManager.setActiveTexture(33988);
            GlStateManager.bindTexture(sfbDepthTextures.get(0));
            if (usedShadowDepthBuffers >= 2) {
               GlStateManager.setActiveTexture(33989);
               GlStateManager.bindTexture(sfbDepthTextures.get(1));
            }
         }

         int var2;
         for(var2 = 0; var2 < usedColorBuffers; ++var2) {
            GlStateManager.setActiveTexture('蓀' + colorTextureImageUnit[var2]);
            GlStateManager.bindTexture(dfbColorTexturesFlip.getA(var2));
         }

         GlStateManager.setActiveTexture(33990);
         GlStateManager.bindTexture(dfbDepthTextures.get(0));
         if (usedDepthBuffers >= 2) {
            GlStateManager.setActiveTexture(33995);
            GlStateManager.bindTexture(dfbDepthTextures.get(1));
            if (usedDepthBuffers >= 3) {
               GlStateManager.setActiveTexture(33996);
               GlStateManager.bindTexture(dfbDepthTextures.get(2));
            }
         }

         for(var2 = 0; var2 < usedShadowColorBuffers; ++var2) {
            GlStateManager.setActiveTexture('蓍' + var2);
            GlStateManager.bindTexture(sfbColorTextures.get(var2));
         }

         if (noiseTextureEnabled) {
            GlStateManager.setActiveTexture('蓀' + noiseTexture.getTextureUnit());
            GlStateManager.bindTexture(noiseTexture.getTextureId());
         }

         if (var1) {
            bindCustomTextures(customTexturesComposite);
         } else {
            bindCustomTextures(customTexturesDeferred);
         }

         GlStateManager.setActiveTexture(33984);

         for(var2 = 0; var2 < usedColorBuffers; ++var2) {
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, '賠' + var2, 3553, dfbColorTexturesFlip.getB(var2), 0);
         }

         EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, dfbDepthTextures.get(0), 0);
         GL20.glDrawBuffers(dfbDrawBuffers);
         checkGLError("pre-composite");

         for(var2 = 0; var2 < var0.length; ++var2) {
            Program var3 = var0[var2];
            if (var3.getId() != 0) {
               useProgram(var3);
               checkGLError(var3.getName());
               if (activeCompositeMipmapSetting != 0) {
                  genCompositeMipmap();
               }

               preDrawComposite();
               drawComposite();
               postDrawComposite();

               for(int var4 = 0; var4 < usedColorBuffers; ++var4) {
                  if (var3.getToggleColorTextures()[var4]) {
                     dfbColorTexturesFlip.flip(var4);
                     GlStateManager.setActiveTexture('蓀' + colorTextureImageUnit[var4]);
                     GlStateManager.bindTexture(dfbColorTexturesFlip.getA(var4));
                     EXTFramebufferObject.glFramebufferTexture2DEXT(36160, '賠' + var4, 3553, dfbColorTexturesFlip.getB(var4), 0);
                  }
               }

               GlStateManager.setActiveTexture(33984);
            }
         }

         checkGLError("composite");
         if (var1) {
            renderFinal();
            isCompositeRendered = true;
         }

         GlStateManager.enableLighting();
         GlStateManager.enableTexture2D();
         GlStateManager.enableAlpha();
         GlStateManager.enableBlend();
         GlStateManager.depthFunc(515);
         GlStateManager.depthMask(true);
         GL11.glPopMatrix();
         GL11.glMatrixMode(5888);
         GL11.glPopMatrix();
         useProgram(ProgramNone);
      }

   }

   public static void scheduleResizeShadow() {
      needResizeShadow = true;
   }

   public static boolean isRenderBackFace(EnumWorldBlockLayer var0) {
      switch($SWITCH_TABLE$net$minecraft$util$EnumWorldBlockLayer()[var0.ordinal()]) {
      case 1:
         return shaderPackBackFaceSolid.isTrue();
      case 2:
         return shaderPackBackFaceCutoutMipped.isTrue();
      case 3:
         return shaderPackBackFaceCutout.isTrue();
      case 4:
         return shaderPackBackFaceTranslucent.isTrue();
      default:
         return false;
      }
   }

   public static void drawComposite() {
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      drawCompositeQuad();
      int var0 = activeProgram.getCountInstances();
      if (var0 > 1) {
         for(int var1 = 1; var1 < var0; ++var1) {
            uniform_instanceId.setValue(var1);
            drawCompositeQuad();
         }

         uniform_instanceId.setValue(0);
      }

   }

   public static void pushEntity(int var0, int var1) {
      ++entityDataIndex;
      entityData[entityDataIndex * 2] = var0 & '\uffff' | var1 << 16;
      entityData[entityDataIndex * 2 + 1] = 0;
   }

   public static void endFPOverlay() {
   }

   public static boolean isSeparateAo() {
      return shaderPackSeparateAo.isTrue();
   }

   private static void setProgramUniformMatrix4ARB(ShaderUniformM4 var0, boolean var1, FloatBuffer var2) {
      var0.setValue(var1, var2);
   }

   public static boolean isFrustumCulling() {
      return !shaderPackFrustumCulling.isFalse();
   }

   public static void sglDisableT2D(int var0) {
      GL11.glDisable(var0);
      disableTexture2D();
   }

   private static void setEnumShaderOption(EnumShaderOption var0, String var1) {
      if (var1 == null) {
         var1 = var0.getValueDefault();
      }

      switch($SWITCH_TABLE$net$optifine$shaders$config$EnumShaderOption()[var0.ordinal()]) {
      case 1:
         configAntialiasingLevel = Config.parseInt(var1, 0);
         break;
      case 2:
         configNormalMap = Config.parseBoolean(var1, true);
         break;
      case 3:
         configSpecularMap = Config.parseBoolean(var1, true);
         break;
      case 4:
         configRenderResMul = Config.parseFloat(var1, 1.0F);
         break;
      case 5:
         configShadowResMul = Config.parseFloat(var1, 1.0F);
         break;
      case 6:
         configHandDepthMul = Config.parseFloat(var1, 0.125F);
         break;
      case 7:
         configCloudShadow = Config.parseBoolean(var1, true);
         break;
      case 8:
         configOldHandLight.setPropertyValue(var1);
         break;
      case 9:
         configOldLighting.setPropertyValue(var1);
         break;
      case 10:
         currentShaderName = var1;
         break;
      case 11:
         configTweakBlockDamage = Config.parseBoolean(var1, true);
         break;
      case 12:
         configShadowClipFrustrum = Config.parseBoolean(var1, true);
         break;
      case 13:
         configTexMinFilB = Config.parseInt(var1, 0);
         break;
      case 14:
         configTexMinFilN = Config.parseInt(var1, 0);
         break;
      case 15:
         configTexMinFilS = Config.parseInt(var1, 0);
         break;
      case 16:
         configTexMagFilB = Config.parseInt(var1, 0);
         break;
      case 17:
         configTexMagFilB = Config.parseInt(var1, 0);
         break;
      case 18:
         configTexMagFilB = Config.parseInt(var1, 0);
         break;
      default:
         throw new IllegalArgumentException("Unknown option: " + var0);
      }

   }

   private static void clearDirectory(File var0) {
      if (var0.exists() && var0.isDirectory()) {
         File[] var1 = var0.listFiles();
         if (var1 != null) {
            for(int var2 = 0; var2 < var1.length; ++var2) {
               File var3 = var1[var2];
               if (var3.isDirectory()) {
                  clearDirectory(var3);
               }

               var3.delete();
            }
         }
      }

   }

   public static World getCurrentWorld() {
      return currentWorld;
   }

   private static void updateToggleBuffers(Program var0) {
      boolean[] var1 = var0.getToggleColorTextures();
      Boolean[] var2 = var0.getBuffersFlip();

      for(int var3 = 0; var3 < var2.length; ++var3) {
         Boolean var4 = var2[var3];
         if (var4 != null) {
            var1[var3] = var4;
         }
      }

   }

   private static ICustomTexture loadCustomTextureRaw(int var0, String var1) {
      ConnectedParser var2 = new ConnectedParser("Shaders");
      String[] var3 = Config.tokenize(var1, " ");
      ArrayDeque var4 = new ArrayDeque(Arrays.asList(var3));
      String var5 = (String)var4.poll();
      TextureType var6 = (TextureType)var2.parseEnum((String)var4.poll(), TextureType.values(), "texture type");
      if (var6 == null) {
         SMCLog.warning("Invalid raw texture type: " + var1);
         return null;
      } else {
         InternalFormat var7 = (InternalFormat)var2.parseEnum((String)var4.poll(), InternalFormat.values(), "internal format");
         if (var7 == null) {
            SMCLog.warning("Invalid raw texture internal format: " + var1);
            return null;
         } else {
            boolean var8 = false;
            int var9 = 0;
            int var10 = 0;
            int var13;
            switch($SWITCH_TABLE$net$optifine$texture$TextureType()[var6.ordinal()]) {
            case 1:
               var13 = var2.parseInt((String)var4.poll(), -1);
               break;
            case 2:
               var13 = var2.parseInt((String)var4.poll(), -1);
               var9 = var2.parseInt((String)var4.poll(), -1);
               break;
            case 3:
               var13 = var2.parseInt((String)var4.poll(), -1);
               var9 = var2.parseInt((String)var4.poll(), -1);
               var10 = var2.parseInt((String)var4.poll(), -1);
               break;
            case 4:
               var13 = var2.parseInt((String)var4.poll(), -1);
               var9 = var2.parseInt((String)var4.poll(), -1);
               break;
            default:
               SMCLog.warning("Invalid raw texture type: " + var6);
               return null;
            }

            if (var13 >= 0 && var9 >= 0 && var10 >= 0) {
               PixelFormat var11 = (PixelFormat)var2.parseEnum((String)var4.poll(), PixelFormat.values(), "pixel format");
               if (var11 == null) {
                  SMCLog.warning("Invalid raw texture pixel format: " + var1);
                  return null;
               } else {
                  PixelType var12 = (PixelType)var2.parseEnum((String)var4.poll(), PixelType.values(), "pixel type");
                  if (var12 == null) {
                     SMCLog.warning("Invalid raw texture pixel type: " + var1);
                     return null;
                  } else if (!var4.isEmpty()) {
                     SMCLog.warning("Invalid raw texture, too many parameters: " + var1);
                     return null;
                  } else {
                     return loadCustomTextureRaw(var0, var1, var5, var6, var7, var13, var9, var10, var11, var12);
                  }
               }
            } else {
               SMCLog.warning("Invalid raw texture size: " + var1);
               return null;
            }
         }
      }
   }

   public static void printIntBuffer(String var0, IntBuffer var1) {
      StringBuilder var2 = new StringBuilder(128);
      var2.append(var0).append(" [pos ").append(var1.position()).append(" lim ").append(var1.limit()).append(" cap ").append(var1.capacity()).append(" :");
      int var3 = var1.limit();

      for(int var4 = 0; var4 < var3; ++var4) {
         var2.append(" ").append(var1.get(var4));
      }

      var2.append("]");
      SMCLog.info(var2.toString());
   }

   private static void loadEntityDataMap() {
      mapBlockToEntityData = new IdentityHashMap(300);
      if (mapBlockToEntityData.isEmpty()) {
         Iterator var1 = Block.blockRegistry.getKeys().iterator();

         while(var1.hasNext()) {
            ResourceLocation var0 = (ResourceLocation)var1.next();
            Block var2 = (Block)Block.blockRegistry.getObject(var0);
            int var3 = Block.blockRegistry.getIDForObject(var2);
            mapBlockToEntityData.put(var2, var3);
         }
      }

      BufferedReader var10 = null;

      try {
         var10 = new BufferedReader(new InputStreamReader(shaderPack.getResourceAsStream("/mc_Entity_x.txt")));
      } catch (Exception var8) {
      }

      if (var10 != null) {
         String var11;
         try {
            while((var11 = var10.readLine()) != null) {
               Matcher var12 = patternLoadEntityDataMap.matcher(var11);
               if (var12.matches()) {
                  String var13 = var12.group(1);
                  String var4 = var12.group(2);
                  int var5 = Integer.parseInt(var4);
                  Block var6 = Block.getBlockFromName(var13);
                  if (var6 != null) {
                     mapBlockToEntityData.put(var6, var5);
                  } else {
                     SMCLog.warning("Unknown block name %s", var13);
                  }
               } else {
                  SMCLog.warning("unmatched %s\n", var11);
               }
            }
         } catch (Exception var9) {
            SMCLog.warning("Error parsing mc_Entity_x.txt");
         }
      }

      if (var10 != null) {
         try {
            var10.close();
         } catch (Exception var7) {
         }
      }

   }

   public static void beginFPOverlay() {
      GlStateManager.disableLighting();
      GlStateManager.disableBlend();
   }

   public static boolean isOldHandLight() {
      if (!configOldHandLight.isDefault()) {
         return configOldHandLight.isTrue();
      } else {
         return !shaderPackOldHandLight.isDefault() ? shaderPackOldHandLight.isTrue() : true;
      }
   }

   public static String getShaderPackName() {
      if (shaderPack == null) {
         return null;
      } else {
         return shaderPack instanceof ShaderPackNone ? null : shaderPack.getName();
      }
   }

   public static void genCompositeMipmap() {
      if (hasGlGenMipmap) {
         for(int var0 = 0; var0 < usedColorBuffers; ++var0) {
            if ((activeCompositeMipmapSetting & 1 << var0) != 0) {
               GlStateManager.setActiveTexture('蓀' + colorTextureImageUnit[var0]);
               GL11.glTexParameteri(3553, 10241, 9987);
               GL30.glGenerateMipmap(3553);
            }
         }

         GlStateManager.setActiveTexture(33984);
      }

   }

   public static boolean isSkipRenderHand() {
      return skipRenderHandMain;
   }

   private static int getTextureFormatFromString(String var0) {
      var0 = var0.trim();

      for(int var1 = 0; var1 < formatNames.length; ++var1) {
         String var2 = formatNames[var1];
         if (var0.equals(var2)) {
            return formatIds[var1];
         }
      }

      return 0;
   }

   public static void setViewport(int var0, int var1, int var2, int var3) {
      GlStateManager.colorMask(true, true, true, true);
      if (isShadowPass) {
         GL11.glViewport(0, 0, shadowMapWidth, shadowMapHeight);
      } else {
         GL11.glViewport(0, 0, renderWidth, renderHeight);
         EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);
         isRenderingDfb = true;
         GlStateManager.enableCull();
         GlStateManager.enableDepth();
         setDrawBuffers(drawBuffersNone);
         useProgram(ProgramTextured);
         checkGLError("beginRenderPass");
      }

   }

   public static void setBlockEntityId(TileEntity var0) {
      if (uniform_blockEntityId.isDefined()) {
         int var1 = getBlockEntityId(var0);
         uniform_blockEntityId.setValue(var1);
      }

   }

   public static void nextEntity(Entity var0) {
      if (isRenderingWorld) {
         useProgram(ProgramEntities);
         setEntityId(var0);
      }

   }

   private static ICustomTexture loadCustomTextureLocation(int var0, String var1) {
      String var2 = var1.trim();
      byte var3 = 0;
      if (var2.startsWith("minecraft:textures/")) {
         var2 = StrUtils.addSuffixCheck(var2, ".png");
         if (var2.endsWith("_n.png")) {
            var2 = StrUtils.replaceSuffix(var2, "_n.png", ".png");
            var3 = 1;
         } else if (var2.endsWith("_s.png")) {
            var2 = StrUtils.replaceSuffix(var2, "_s.png", ".png");
            var3 = 2;
         }
      }

      ResourceLocation var4 = new ResourceLocation(var2);
      CustomTextureLocation var5 = new CustomTextureLocation(var0, var4, var3);
      return var5;
   }

   public static void setEntityId(Entity var0) {
      if (uniform_entityId.isDefined()) {
         int var1 = EntityUtils.getEntityIdByClass(var0);
         int var2 = EntityAliases.getEntityAliasId(var1);
         if (var2 >= 0) {
            var1 = var2;
         }

         uniform_entityId.setValue(var1);
      }

   }

   private static void saveOptionProperties(IShaderPack var0, Properties var1) throws IOException {
      String var2 = "shaderpacks/" + var0.getName() + ".txt";
      File var3 = new File(Minecraft.getMinecraft().mcDataDir, var2);
      if (var1.isEmpty()) {
         var3.delete();
      } else {
         FileOutputStream var4 = new FileOutputStream(var3);
         var1.store(var4, (String)null);
         var4.flush();
         var4.close();
      }

   }

   public static void endRender() {
      if (isShadowPass) {
         checkGLError("shadow endRender");
      } else {
         if (!isCompositeRendered) {
            renderCompositeFinal();
         }

         isRenderingWorld = false;
         GlStateManager.colorMask(true, true, true, true);
         useProgram(ProgramNone);
         RenderHelper.disableStandardItemLighting();
         checkGLError("endRender end");
      }

   }

   private static void renderFinal() {
      isRenderingDfb = false;
      mc.getFramebuffer().bindFramebuffer(true);
      OpenGlHelper.glFramebufferTexture2D(OpenGlHelper.GL_FRAMEBUFFER, OpenGlHelper.GL_COLOR_ATTACHMENT0, 3553, mc.getFramebuffer().framebufferTexture, 0);
      GL11.glViewport(0, 0, mc.displayWidth, mc.displayHeight);
      if (EntityRenderer.anaglyphEnable) {
         boolean var0 = EntityRenderer.anaglyphField != 0;
         GlStateManager.colorMask(var0, !var0, !var0, true);
      }

      GlStateManager.depthMask(true);
      GL11.glClearColor(clearColorR, clearColorG, clearColorB, 1.0F);
      GL11.glClear(16640);
      GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
      GlStateManager.enableTexture2D();
      GlStateManager.disableAlpha();
      GlStateManager.disableBlend();
      GlStateManager.enableDepth();
      GlStateManager.depthFunc(519);
      GlStateManager.depthMask(false);
      checkGLError("pre-final");
      useProgram(ProgramFinal);
      checkGLError("final");
      if (activeCompositeMipmapSetting != 0) {
         genCompositeMipmap();
      }

      drawComposite();
      checkGLError("renderCompositeFinal");
   }

   private static void setupNoiseTexture() {
      if (noiseTexture == null && noiseTexturePath != null) {
         noiseTexture = loadCustomTexture(15, noiseTexturePath);
      }

      if (noiseTexture == null) {
         noiseTexture = new HFNoiseTexture(noiseTextureResolution, noiseTextureResolution);
      }

   }

   public static void startup(Minecraft var0) {
      checkShadersModInstalled();
      mc = var0;
      mc = Minecraft.getMinecraft();
      capabilities = GLContext.getCapabilities();
      glVersionString = GL11.glGetString(7938);
      glVendorString = GL11.glGetString(7936);
      glRendererString = GL11.glGetString(7937);
      SMCLog.info("OpenGL Version: " + glVersionString);
      SMCLog.info("Vendor:  " + glVendorString);
      SMCLog.info("Renderer: " + glRendererString);
      SMCLog.info("Capabilities: " + (capabilities.OpenGL20 ? " 2.0 " : " - ") + (capabilities.OpenGL21 ? " 2.1 " : " - ") + (capabilities.OpenGL30 ? " 3.0 " : " - ") + (capabilities.OpenGL32 ? " 3.2 " : " - ") + (capabilities.OpenGL40 ? " 4.0 " : " - "));
      SMCLog.info("GL_MAX_DRAW_BUFFERS: " + GL11.glGetInteger(34852));
      SMCLog.info("GL_MAX_COLOR_ATTACHMENTS_EXT: " + GL11.glGetInteger(36063));
      SMCLog.info("GL_MAX_TEXTURE_IMAGE_UNITS: " + GL11.glGetInteger(34930));
      hasGlGenMipmap = capabilities.OpenGL30;
      loadConfig();
   }

   public static void checkShadersModInstalled() {
      try {
         Class var0 = Class.forName("shadersmod.transform.SMCClassTransformer");
      } catch (Throwable var1) {
         return;
      }

      throw new RuntimeException("Shaders Mod detected. Please remove it, OptiFine has built-in support for shaders.");
   }

   public static void setRenderingFirstPersonHand(boolean var0) {
      isRenderingFirstPersonHand = var0;
   }

   private static void printChatAndLogError(String var0) {
      SMCLog.severe(var0);
      mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(var0));
   }

   public static void beginHand(boolean var0) {
      GL11.glMatrixMode(5888);
      GL11.glPushMatrix();
      GL11.glMatrixMode(5889);
      GL11.glPushMatrix();
      GL11.glMatrixMode(5888);
      if (var0) {
         useProgram(ProgramHandWater);
      } else {
         useProgram(ProgramHand);
      }

      checkGLError("beginHand");
      checkFramebufferStatus("beginHand");
   }

   private static void printChat(String var0) {
      mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText(var0));
   }

   private static void setProgramUniform2i(ShaderUniform2i var0, int var1, int var2) {
      var0.setValue(var1, var2);
   }

   public static int checkFramebufferStatus(String var0) {
      int var1 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
      if (var1 != 36053) {
         System.err.format("FramebufferStatus 0x%04X at %s\n", var1, var0);
      }

      return var1;
   }

   public static void preSkyList() {
      setUpPosition();
      GL11.glColor3f(fogColorR, fogColorG, fogColorB);
      drawHorizon();
      GL11.glColor3f(skyColorR, skyColorG, skyColorB);
   }

   private static void deleteCustomTextures(ICustomTexture[] var0) {
      if (var0 != null) {
         for(int var1 = 0; var1 < var0.length; ++var1) {
            ICustomTexture var2 = var0[var1];
            var2.deleteTexture();
         }
      }

   }

   public static void setEntityColor(float var0, float var1, float var2, float var3) {
      if (isRenderingWorld && !isShadowPass) {
         uniform_entityColor.setValue(var0, var1, var2, var3);
      }

   }

   public static void glDisableWrapper(int var0) {
      GL11.glDisable(var0);
      if (var0 == 3553) {
         disableTexture2D();
      } else if (var0 == 2912) {
         disableFog();
      }

   }

   private static IntBuffer[] nextIntBufferArray(int var0, int var1) {
      IntBuffer[] var2 = new IntBuffer[var0];

      for(int var3 = 0; var3 < var0; ++var3) {
         var2[var3] = nextIntBuffer(var1);
      }

      return var2;
   }

   public static boolean isBeaconBeamDepth() {
      return shaderPackBeaconBeamDepth.isTrue();
   }

   public static void loadShaderPack() {
      boolean var0 = shaderPackLoaded;
      boolean var1 = isOldLighting();
      if (mc.renderGlobal != null) {
         mc.renderGlobal.pauseChunkUpdates();
      }

      shaderPackLoaded = false;
      if (shaderPack != null) {
         shaderPack.close();
         shaderPack = null;
         shaderPackResources.clear();
         shaderPackDimensions.clear();
         shaderPackOptions = null;
         shaderPackOptionSliders = null;
         shaderPackProfiles = null;
         shaderPackGuiScreens = null;
         shaderPackProgramConditions.clear();
         shaderPackClouds.resetValue();
         shaderPackOldHandLight.resetValue();
         shaderPackDynamicHandLight.resetValue();
         shaderPackOldLighting.resetValue();
         resetCustomTextures();
         noiseTexturePath = null;
      }

      boolean var2 = false;
      if (Config.isAntialiasing()) {
         SMCLog.info("Shaders can not be loaded, Antialiasing is enabled: " + Config.getAntialiasingLevel() + "x");
         var2 = true;
      }

      if (Config.isAnisotropicFiltering()) {
         SMCLog.info("Shaders can not be loaded, Anisotropic Filtering is enabled: " + Config.getAnisotropicFilterLevel() + "x");
         var2 = true;
      }

      if (Config.isFastRender()) {
         SMCLog.info("Shaders can not be loaded, Fast Render is enabled.");
         var2 = true;
      }

      String var3 = shadersConfig.getProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), "(internal)");
      if (!var2) {
         shaderPack = getShaderPack(var3);
         shaderPackLoaded = shaderPack != null;
      }

      if (shaderPackLoaded) {
         SMCLog.info("Loaded shaderpack: " + getShaderPackName());
      } else {
         SMCLog.info("No shaderpack loaded.");
         shaderPack = new ShaderPackNone();
      }

      if (saveFinalShaders) {
         clearDirectory(new File(shaderPacksDir, "debug"));
      }

      loadShaderPackResources();
      loadShaderPackDimensions();
      shaderPackOptions = loadShaderPackOptions();
      loadShaderPackProperties();
      boolean var4 = shaderPackLoaded ^ var0;
      boolean var5 = isOldLighting() ^ var1;
      if (var4 || var5) {
         DefaultVertexFormats.updateVertexFormats();
         if (Reflector.LightUtil.exists()) {
            Reflector.LightUtil_itemConsumer.setValue((Object)null);
            Reflector.LightUtil_tessellator.setValue((Object)null);
         }

         updateBlockLightLevel();
      }

      if (mc.getResourcePackRepository() != null) {
         CustomBlockLayers.update();
      }

      if (mc.renderGlobal != null) {
         mc.renderGlobal.resumeChunkUpdates();
      }

      if ((var4 || var5) && mc.getResourceManager() != null) {
         mc.scheduleResourcesRefresh();
      }

   }

   public static void endLivingDamage() {
      if (isRenderingWorld && !isShadowPass) {
         setDrawBuffers(ProgramEntities.getDrawBuffers());
      }

   }

   public static void pushEntity(int var0) {
      ++entityDataIndex;
      entityData[entityDataIndex * 2] = var0 & '\uffff';
      entityData[entityDataIndex * 2 + 1] = 0;
   }

   public static boolean shouldRenderClouds(GameSettings var0) {
      if (!shaderPackLoaded) {
         return true;
      } else {
         checkGLError("shouldRenderClouds");
         return isShadowPass ? configCloudShadow : var0.clouds > 0;
      }
   }

   public static void disableFog() {
      fogEnabled = false;
      setProgramUniform1i(uniform_fogMode, 0);
   }

   private static Program getProgramById(int var0) {
      for(int var1 = 0; var1 < ProgramsAll.length; ++var1) {
         Program var2 = ProgramsAll[var1];
         if (var2.getId() == var0) {
            return var2;
         }
      }

      return ProgramNone;
   }

   public static void saveShader(String var0, String var1) {
      try {
         File var2 = new File(shaderPacksDir, "debug/" + var0);
         var2.getParentFile().mkdirs();
         Config.writeFile(var2, var1);
      } catch (IOException var3) {
         Config.warn("Error saving: " + var0);
         var3.printStackTrace();
      }

   }

   private static void resize() {
      renderDisplayWidth = mc.displayWidth;
      renderDisplayHeight = mc.displayHeight;
      renderWidth = Math.round((float)renderDisplayWidth * configRenderResMul);
      renderHeight = Math.round((float)renderDisplayHeight * configRenderResMul);
      setupFrameBuffer();
   }

   public static InputStream getShaderPackResourceStream(String var0) {
      return shaderPack == null ? null : shaderPack.getResourceAsStream(var0);
   }

   public static ArrayList listOfShaders() {
      ArrayList var0 = new ArrayList();
      var0.add("OFF");
      var0.add("(internal)");
      int var1 = var0.size();

      try {
         if (!shaderPacksDir.exists()) {
            shaderPacksDir.mkdir();
         }

         File[] var2 = shaderPacksDir.listFiles();

         for(int var3 = 0; var3 < var2.length; ++var3) {
            File var4 = var2[var3];
            String var5 = var4.getName();
            if (var4.isDirectory()) {
               if (!var5.equals("debug")) {
                  File var6 = new File(var4, "shaders");
                  if (var6.exists() && var6.isDirectory()) {
                     var0.add(var5);
                  }
               }
            } else if (var4.isFile() && var5.toLowerCase().endsWith(".zip")) {
               var0.add(var5);
            }
         }
      } catch (Exception var7) {
      }

      List var8 = var0.subList(var1, var0.size());
      Collections.sort(var8, String.CASE_INSENSITIVE_ORDER);
      return var0;
   }

   static int[] $SWITCH_TABLE$net$optifine$texture$TextureType() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$texture$TextureType;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[TextureType.values().length];

         try {
            var0[TextureType.TEXTURE_1D.ordinal()] = 1;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[TextureType.TEXTURE_2D.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[TextureType.TEXTURE_3D.ordinal()] = 3;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[TextureType.TEXTURE_RECTANGLE.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$texture$TextureType = var0;
         return var0;
      }
   }

   public static int setEntityData2(int var0) {
      entityData[entityDataIndex * 2 + 1] = entityData[entityDataIndex * 2 + 1] & -65536 | var0 & '\uffff';
      return var0;
   }

   public static void setSkyColor(Vec3 var0) {
      skyColorR = (float)var0.xCoord;
      skyColorG = (float)var0.yCoord;
      skyColorB = (float)var0.zCoord;
      setProgramUniform3f(uniform_skyColor, skyColorR, skyColorG, skyColorB);
   }

   private static void updateCameraOffset(Entity var0) {
      double var1 = Math.abs(cameraPositionX - previousCameraPositionX);
      double var3 = Math.abs(cameraPositionZ - previousCameraPositionZ);
      double var5 = Math.abs(cameraPositionX);
      double var7 = Math.abs(cameraPositionZ);
      if (var1 > 1000.0D || var3 > 1000.0D || var5 > 1000000.0D || var7 > 1000000.0D) {
         setCameraOffset(var0);
      }

   }

   public static void readCenterDepth() {
      if (!isShadowPass && centerDepthSmoothEnabled) {
         tempDirectFloatBuffer.clear();
         GL11.glReadPixels(renderWidth / 2, renderHeight / 2, 1, 1, 6402, 5126, tempDirectFloatBuffer);
         centerDepth = tempDirectFloatBuffer.get(0);
         float var0 = (float)diffSystemTime * 0.01F;
         float var1 = (float)Math.exp(Math.log(0.5D) * (double)var0 / (double)centerDepthSmoothHalflife);
         centerDepthSmooth = centerDepthSmooth * var1 + centerDepth * (1.0F - var1);
      }

   }

   public static void endHand() {
      checkGLError("pre endHand");
      checkFramebufferStatus("pre endHand");
      GL11.glMatrixMode(5889);
      GL11.glPopMatrix();
      GL11.glMatrixMode(5888);
      GL11.glPopMatrix();
      GlStateManager.blendFunc(770, 771);
      checkGLError("endHand");
   }

   private static ICustomTexture loadCustomTexture(int var0, String var1) {
      if (var1 == null) {
         return null;
      } else {
         var1 = var1.trim();
         if (var1.indexOf(58) >= 0) {
            return loadCustomTextureLocation(var0, var1);
         } else {
            return var1.indexOf(32) >= 0 ? loadCustomTextureRaw(var0, var1) : loadCustomTextureShaders(var0, var1);
         }
      }
   }

   public static void checkWorldChanged(World var0) {
      if (currentWorld != var0) {
         World var1 = currentWorld;
         currentWorld = var0;
         setCameraOffset(mc.getRenderViewEntity());
         int var2 = getDimensionId(var1);
         int var3 = getDimensionId(var0);
         if (var3 != var2) {
            boolean var4 = shaderPackDimensions.contains(var2);
            boolean var5 = shaderPackDimensions.contains(var3);
            if (var4 || var5) {
               uninit();
            }
         }

         Smoother.resetValues();
      }

   }

   public static void beginSpiderEyes() {
      if (isRenderingWorld && ProgramSpiderEyes.getId() != ProgramNone.getId()) {
         useProgram(ProgramSpiderEyes);
         GlStateManager.enableAlpha();
         GlStateManager.alphaFunc(516, 0.0F);
         GlStateManager.blendFunc(770, 771);
      }

   }

   public static void beginRenderPass(int var0, float var1, long var2) {
      if (!isShadowPass) {
         EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);
         GL11.glViewport(0, 0, renderWidth, renderHeight);
         activeDrawBuffers = null;
         ShadersTex.bindNSTextures(defaultTexture.getMultiTexID());
         useProgram(ProgramTextured);
         checkGLError("end beginRenderPass");
      }

   }

   public static boolean isRenderingFirstPersonHand() {
      return isRenderingFirstPersonHand;
   }

   public static void enableFog() {
      fogEnabled = true;
      setProgramUniform1i(uniform_fogMode, fogMode);
      setProgramUniform1f(uniform_fogDensity, fogDensity);
   }

   public static ShaderOption[] getChangedOptions(ShaderOption[] var0) {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         ShaderOption var3 = var0[var2];
         if (var3.isEnabled() && var3.isChanged()) {
            var1.add(var3);
         }
      }

      ShaderOption[] var4 = (ShaderOption[])var1.toArray(new ShaderOption[var1.size()]);
      return var4;
   }

   private static void setupProgram(Program var0, String var1, String var2, String var3) {
      checkGLError("pre setupProgram");
      int var4 = ARBShaderObjects.glCreateProgramObjectARB();
      checkGLError("create");
      if (var4 != 0) {
         progUseEntityAttrib = false;
         progUseMidTexCoordAttrib = false;
         progUseTangentAttrib = false;
         int var5 = createVertShader(var0, var1);
         int var6 = createGeomShader(var0, var2);
         int var7 = createFragShader(var0, var3);
         checkGLError("create");
         boolean var10;
         if (var5 == 0 && var6 == 0 && var7 == 0) {
            ARBShaderObjects.glDeleteObjectARB(var4);
            var10 = false;
            var0.resetId();
         } else {
            if (var5 != 0) {
               ARBShaderObjects.glAttachObjectARB(var4, var5);
               checkGLError("attach");
            }

            if (var6 != 0) {
               ARBShaderObjects.glAttachObjectARB(var4, var6);
               checkGLError("attach");
               if (progArbGeometryShader4) {
                  ARBGeometryShader4.glProgramParameteriARB(var4, 36315, 4);
                  ARBGeometryShader4.glProgramParameteriARB(var4, 36316, 5);
                  ARBGeometryShader4.glProgramParameteriARB(var4, 36314, progMaxVerticesOut);
                  checkGLError("arbGeometryShader4");
               }

               hasGeometryShaders = true;
            }

            if (var7 != 0) {
               ARBShaderObjects.glAttachObjectARB(var4, var7);
               checkGLError("attach");
            }

            if (progUseEntityAttrib) {
               ARBVertexShader.glBindAttribLocationARB(var4, entityAttrib, "mc_Entity");
               checkGLError("mc_Entity");
            }

            if (progUseMidTexCoordAttrib) {
               ARBVertexShader.glBindAttribLocationARB(var4, midTexCoordAttrib, "mc_midTexCoord");
               checkGLError("mc_midTexCoord");
            }

            if (progUseTangentAttrib) {
               ARBVertexShader.glBindAttribLocationARB(var4, tangentAttrib, "at_tangent");
               checkGLError("at_tangent");
            }

            ARBShaderObjects.glLinkProgramARB(var4);
            if (GL20.glGetProgrami(var4, 35714) != 1) {
               SMCLog.severe("Error linking program: " + var4 + " (" + var0.getName() + ")");
            }

            printLogInfo(var4, var0.getName());
            if (var5 != 0) {
               ARBShaderObjects.glDetachObjectARB(var4, var5);
               ARBShaderObjects.glDeleteObjectARB(var5);
            }

            if (var6 != 0) {
               ARBShaderObjects.glDetachObjectARB(var4, var6);
               ARBShaderObjects.glDeleteObjectARB(var6);
            }

            if (var7 != 0) {
               ARBShaderObjects.glDetachObjectARB(var4, var7);
               ARBShaderObjects.glDeleteObjectARB(var7);
            }

            var0.setId(var4);
            var0.setRef(var4);
            useProgram(var0);
            ARBShaderObjects.glValidateProgramARB(var4);
            useProgram(ProgramNone);
            printLogInfo(var4, var0.getName());
            int var8 = GL20.glGetProgrami(var4, 35715);
            if (var8 != 1) {
               String var9 = "\"";
               printChatAndLogError("[Shaders] Error: Invalid program " + var9 + var0.getName() + var9);
               ARBShaderObjects.glDeleteObjectARB(var4);
               var10 = false;
               var0.resetId();
            }
         }
      }

   }

   private static ICustomTexture loadCustomTextureRaw(int var0, String var1, String var2, TextureType var3, InternalFormat var4, int var5, int var6, int var7, PixelFormat var8, PixelType var9) {
      try {
         String var10 = "shaders/" + StrUtils.removePrefix(var2, "/");
         InputStream var11 = shaderPack.getResourceAsStream(var10);
         if (var11 == null) {
            SMCLog.warning("Raw texture not found: " + var2);
            return null;
         } else {
            byte[] var12 = Config.readAll(var11);
            IOUtils.closeQuietly(var11);
            ByteBuffer var13 = GLAllocation.createDirectByteBuffer(var12.length);
            var13.put(var12);
            var13.flip();
            CustomTextureRaw var14 = new CustomTextureRaw(var3, var4, var5, var6, var7, var8, var9, var13, var0);
            return var14;
         }
      } catch (IOException var15) {
         SMCLog.warning("Error loading raw texture: " + var2);
         SMCLog.warning(var15.getClass().getName() + ": " + var15.getMessage());
         return null;
      }
   }

   public static boolean isProgramPath(String var0) {
      if (var0 == null) {
         return false;
      } else if (var0.length() <= 0) {
         return false;
      } else {
         int var1 = var0.lastIndexOf("/");
         if (var1 >= 0) {
            var0 = var0.substring(var1 + 1);
         }

         Program var2 = getProgram(var0);
         return var2 != null;
      }
   }

   private static Properties loadOptionProperties(IShaderPack var0) throws IOException {
      PropertiesOrdered var1 = new PropertiesOrdered();
      String var2 = "shaderpacks/" + var0.getName() + ".txt";
      File var3 = new File(Minecraft.getMinecraft().mcDataDir, var2);
      if (var3.exists() && var3.isFile() && var3.canRead()) {
         FileInputStream var4 = new FileInputStream(var3);
         var1.load(var4);
         var4.close();
         return var1;
      } else {
         return var1;
      }
   }

   public static void sglFogi(int var0, int var1) {
      GL11.glFogi(var0, var1);
      if (var0 == 2917) {
         fogMode = var1;
         if (fogEnabled) {
            setProgramUniform1i(uniform_fogMode, fogMode);
         }
      }

   }

   public static void resourcesReloaded() {
      loadShaderPackResources();
      if (shaderPackLoaded) {
         BlockAliases.resourcesReloaded();
         ItemAliases.resourcesReloaded();
         EntityAliases.resourcesReloaded();
      }

   }

   public static void setFogColor(float var0, float var1, float var2) {
      fogColorR = var0;
      fogColorG = var1;
      fogColorB = var2;
      setProgramUniform3f(uniform_fogColor, fogColorR, fogColorG, fogColorB);
   }

   private static void saveShaderPackOptions(ShaderOption[] var0, IShaderPack var1) {
      PropertiesOrdered var2 = new PropertiesOrdered();
      if (shaderPackOptions != null) {
         for(int var3 = 0; var3 < var0.length; ++var3) {
            ShaderOption var4 = var0[var3];
            if (var4.isChanged() && var4.isEnabled()) {
               var2.setProperty(var4.getName(), var4.getValue());
            }
         }
      }

      try {
         saveOptionProperties(var1, var2);
      } catch (IOException var5) {
         Config.warn("[Shaders] Error saving configuration for " + shaderPack.getName());
         var5.printStackTrace();
      }

   }

   public static boolean isHandRenderedOff() {
      return isHandRenderedOff;
   }

   public static void setSkipRenderHands(boolean var0, boolean var1) {
      skipRenderHandMain = var0;
      skipRenderHandOff = var1;
   }

   public static void setFogDensity(float var0) {
      fogDensity = var0;
      if (fogEnabled) {
         setProgramUniform1f(uniform_fogDensity, var0);
      }

   }

   public static void disableLightmap() {
      lightmapEnabled = false;
      if (activeProgram == ProgramTexturedLit) {
         useProgram(ProgramTextured);
      }

   }

   public static boolean isSun() {
      return !shaderPackSun.isFalse();
   }

   public static int getShaderPackColumns(String var0, int var1) {
      String var2 = var0 != null ? "screen." + var0 : "screen";
      if (shaderPackGuiScreens == null) {
         return var1;
      } else {
         ScreenShaderOptions var3 = (ScreenShaderOptions)shaderPackGuiScreens.get(var2);
         return var3 == null ? var1 : var3.getColumns();
      }
   }

   private static void resetCustomTextures() {
      deleteCustomTextures(customTexturesGbuffers);
      deleteCustomTextures(customTexturesComposite);
      deleteCustomTextures(customTexturesDeferred);
      customTexturesGbuffers = null;
      customTexturesComposite = null;
      customTexturesDeferred = null;
   }

   private static boolean printLogInfo(int var0, String var1) {
      IntBuffer var2 = BufferUtils.createIntBuffer(1);
      ARBShaderObjects.glGetObjectParameterARB(var0, 35716, var2);
      int var3 = var2.get();
      if (var3 > 1) {
         ByteBuffer var4 = BufferUtils.createByteBuffer(var3);
         var2.flip();
         ARBShaderObjects.glGetInfoLogARB(var0, var2, var4);
         byte[] var5 = new byte[var3];
         var4.get(var5);
         if (var5[var3 - 1] == 0) {
            var5[var3 - 1] = 10;
         }

         String var6 = new String(var5, Charsets.US_ASCII);
         var6 = StrUtils.trim(var6, " \n\r\t");
         SMCLog.info("Info log: " + var1 + "\n" + var6);
         return false;
      } else {
         return true;
      }
   }

   public static void setItemToRenderOff(ItemStack var0) {
      itemToRenderOffTranslucent = isTranslucentBlock(var0);
   }

   public static void endWater() {
      if (isRenderingWorld) {
         if (isShadowPass) {
         }

         useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
      }

   }

   public static boolean isRenderShadowTranslucent() {
      return !shaderPackShadowTranslucent.isFalse();
   }

   public static void beginLivingDamage() {
      if (isRenderingWorld) {
         ShadersTex.bindTexture(defaultTexture);
         if (!isShadowPass) {
            setDrawBuffers(drawBuffersColorAtt0);
         }
      }

   }

   public static void beginEntities() {
      if (isRenderingWorld) {
         useProgram(ProgramEntities);
      }

   }

   public static void endUpdateChunks() {
      checkGLError("endUpdateChunks1");
      checkFramebufferStatus("endUpdateChunks1");
      if (!isShadowPass) {
         useProgram(ProgramTerrain);
      }

      checkGLError("endUpdateChunks2");
      checkFramebufferStatus("endUpdateChunks2");
   }

   private static Reader getShaderReader(String var0) {
      return new InputStreamReader(shaderPack.getResourceAsStream(var0));
   }

   private static ICustomTexture loadCustomTextureShaders(int var0, String var1) {
      var1 = var1.trim();
      if (var1.indexOf(46) < 0) {
         var1 = var1 + ".png";
      }

      try {
         String var2 = "shaders/" + StrUtils.removePrefix(var1, "/");
         InputStream var3 = shaderPack.getResourceAsStream(var2);
         if (var3 == null) {
            SMCLog.warning("Texture not found: " + var1);
            return null;
         } else {
            IOUtils.closeQuietly(var3);
            SimpleShaderTexture var4 = new SimpleShaderTexture(var2);
            var4.loadTexture(mc.getResourceManager());
            CustomTexture var5 = new CustomTexture(var0, var2, var4);
            return var5;
         }
      } catch (IOException var6) {
         SMCLog.warning("Error loading texture: " + var1);
         SMCLog.warning(var6.getClass().getName() + ": " + var6.getMessage());
         return null;
      }
   }

   public static void setDrawBuffers(IntBuffer var0) {
      if (var0 == null) {
         var0 = drawBuffersNone;
      }

      if (activeDrawBuffers != var0) {
         activeDrawBuffers = var0;
         GL20.glDrawBuffers(var0);
         checkGLError("setDrawBuffers");
      }

   }

   private static ShaderOption[] getVisibleOptions(ShaderOption[] var0) {
      ArrayList var1 = new ArrayList();

      for(int var2 = 0; var2 < var0.length; ++var2) {
         ShaderOption var3 = var0[var2];
         if (var3.isVisible()) {
            var1.add(var3);
         }
      }

      ShaderOption[] var4 = (ShaderOption[])var1.toArray(new ShaderOption[var1.size()]);
      return var4;
   }

   private static void initDrawBuffers(Program var0) {
      int var1 = GL11.glGetInteger(34852);
      Arrays.fill(var0.getToggleColorTextures(), false);
      if (var0 == ProgramFinal) {
         var0.setDrawBuffers((IntBuffer)null);
      } else if (var0.getId() == 0) {
         if (var0 == ProgramShadow) {
            var0.setDrawBuffers(drawBuffersNone);
         } else {
            var0.setDrawBuffers(drawBuffersColorAtt0);
         }
      } else {
         String var2 = var0.getDrawBufSettings();
         if (var2 == null) {
            if (var0 != ProgramShadow && var0 != ProgramShadowSolid && var0 != ProgramShadowCutout) {
               var0.setDrawBuffers(dfbDrawBuffers);
               usedDrawBuffers = usedColorBuffers;
               Arrays.fill(var0.getToggleColorTextures(), 0, usedColorBuffers, true);
            } else {
               var0.setDrawBuffers(sfbDrawBuffers);
            }
         } else {
            IntBuffer var3 = var0.getDrawBuffersBuffer();
            int var4 = var2.length();
            usedDrawBuffers = Math.max(usedDrawBuffers, var4);
            var4 = Math.min(var4, var1);
            var0.setDrawBuffers(var3);
            var3.limit(var4);

            for(int var5 = 0; var5 < var4; ++var5) {
               int var6 = getDrawBuffer(var0, var2, var5);
               var3.put(var5, var6);
            }
         }
      }

   }

   public static void setCamera(float var0) {
      Entity var1 = mc.getRenderViewEntity();
      double var2 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * (double)var0;
      double var4 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * (double)var0;
      double var6 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * (double)var0;
      updateCameraOffset(var1);
      cameraPositionX = var2 - (double)cameraOffsetX;
      cameraPositionY = var4;
      cameraPositionZ = var6 - (double)cameraOffsetZ;
      GL11.glGetFloat(2983, (FloatBuffer)projection.position(0));
      SMath.invertMat4FBFA((FloatBuffer)projectionInverse.position(0), (FloatBuffer)projection.position(0), faProjectionInverse, faProjection);
      projection.position(0);
      projectionInverse.position(0);
      GL11.glGetFloat(2982, (FloatBuffer)modelView.position(0));
      SMath.invertMat4FBFA((FloatBuffer)modelViewInverse.position(0), (FloatBuffer)modelView.position(0), faModelViewInverse, faModelView);
      modelView.position(0);
      modelViewInverse.position(0);
      checkGLError("setCamera");
   }

   private static int createGeomShader(Program var0, String var1) {
      int var2 = ARBShaderObjects.glCreateShaderObjectARB(36313);
      if (var2 == 0) {
         return 0;
      } else {
         StringBuilder var3 = new StringBuilder(131072);
         BufferedReader var4 = null;

         try {
            var4 = new BufferedReader(getShaderReader(var1));
         } catch (Exception var11) {
            ARBShaderObjects.glDeleteObjectARB(var2);
            return 0;
         }

         ShaderOption[] var5 = getChangedOptions(shaderPackOptions);
         ArrayList var6 = new ArrayList();
         progArbGeometryShader4 = false;
         progMaxVerticesOut = 3;
         if (var4 != null) {
            try {
               var4 = ShaderPackParser.resolveIncludes(var4, var1, shaderPack, 0, var6, 0);
               MacroState var7 = new MacroState();

               label93:
               while(true) {
                  ShaderLine var9;
                  do {
                     String var8;
                     do {
                        var8 = var4.readLine();
                        if (var8 == null) {
                           var4.close();
                           break label93;
                        }

                        var8 = applyOptions(var8, var5);
                        var3.append(var8).append('\n');
                     } while(!var7.processLine(var8));

                     var9 = ShaderParser.parseLine(var8);
                  } while(var9 == null);

                  if (var9.isExtension("GL_ARB_geometry_shader4")) {
                     String var10 = Config.normalize(var9.getValue());
                     if (var10.equals("enable") || var10.equals("require") || var10.equals("warn")) {
                        progArbGeometryShader4 = true;
                     }
                  }

                  if (var9.isConstInt("maxVerticesOut")) {
                     progMaxVerticesOut = var9.getValueInt();
                  }
               }
            } catch (Exception var12) {
               SMCLog.severe("Couldn't read " + var1 + "!");
               var12.printStackTrace();
               ARBShaderObjects.glDeleteObjectARB(var2);
               return 0;
            }
         }

         if (saveFinalShaders) {
            saveShader(var1, var3.toString());
         }

         ARBShaderObjects.glShaderSourceARB(var2, var3);
         ARBShaderObjects.glCompileShaderARB(var2);
         if (GL20.glGetShaderi(var2, 35713) != 1) {
            SMCLog.severe("Error compiling geometry shader: " + var1);
         }

         printShaderLogInfo(var2, var1, var6);
         return var2;
      }
   }

   public static void drawHorizon() {
      WorldRenderer var0 = Tessellator.getInstance().getWorldRenderer();
      float var1 = (float)(mc.gameSettings.renderDistanceChunks * 16);
      double var2 = (double)var1 * 0.9238D;
      double var4 = (double)var1 * 0.3826D;
      double var6 = -var4;
      double var8 = -var2;
      double var10 = 16.0D;
      double var12 = -cameraPositionY;
      var0.begin(7, DefaultVertexFormats.POSITION);
      var0.pos(var6, var12, var8).endVertex();
      var0.pos(var6, var10, var8).endVertex();
      var0.pos(var8, var10, var6).endVertex();
      var0.pos(var8, var12, var6).endVertex();
      var0.pos(var8, var12, var6).endVertex();
      var0.pos(var8, var10, var6).endVertex();
      var0.pos(var8, var10, var4).endVertex();
      var0.pos(var8, var12, var4).endVertex();
      var0.pos(var8, var12, var4).endVertex();
      var0.pos(var8, var10, var4).endVertex();
      var0.pos(var6, var10, var2).endVertex();
      var0.pos(var6, var12, var2).endVertex();
      var0.pos(var6, var12, var2).endVertex();
      var0.pos(var6, var10, var2).endVertex();
      var0.pos(var4, var10, var2).endVertex();
      var0.pos(var4, var12, var2).endVertex();
      var0.pos(var4, var12, var2).endVertex();
      var0.pos(var4, var10, var2).endVertex();
      var0.pos(var2, var10, var4).endVertex();
      var0.pos(var2, var12, var4).endVertex();
      var0.pos(var2, var12, var4).endVertex();
      var0.pos(var2, var10, var4).endVertex();
      var0.pos(var2, var10, var6).endVertex();
      var0.pos(var2, var12, var6).endVertex();
      var0.pos(var2, var12, var6).endVertex();
      var0.pos(var2, var10, var6).endVertex();
      var0.pos(var4, var10, var8).endVertex();
      var0.pos(var4, var12, var8).endVertex();
      var0.pos(var4, var12, var8).endVertex();
      var0.pos(var4, var10, var8).endVertex();
      var0.pos(var6, var10, var8).endVertex();
      var0.pos(var6, var12, var8).endVertex();
      Tessellator.getInstance().draw();
   }

   private static String applyOptions(String var0, ShaderOption[] var1) {
      if (var1 != null && var1.length > 0) {
         for(int var2 = 0; var2 < var1.length; ++var2) {
            ShaderOption var3 = var1[var2];
            if (var3.matchesLine(var0)) {
               var0 = var3.getSourceLine();
               break;
            }
         }

         return var0;
      } else {
         return var0;
      }
   }

   public static boolean isRainDepth() {
      return shaderPackRainDepth.isTrue();
   }

   public static ShaderOption[] getShaderPackOptions(String var0) {
      ShaderOption[] var1 = (ShaderOption[])shaderPackOptions.clone();
      if (shaderPackGuiScreens == null) {
         if (shaderPackProfiles != null) {
            ShaderOptionProfile var9 = new ShaderOptionProfile(shaderPackProfiles, var1);
            var1 = (ShaderOption[])Config.addObjectToArray(var1, var9, 0);
         }

         var1 = getVisibleOptions(var1);
         return var1;
      } else {
         String var2 = var0 != null ? "screen." + var0 : "screen";
         ScreenShaderOptions var3 = (ScreenShaderOptions)shaderPackGuiScreens.get(var2);
         if (var3 == null) {
            return new ShaderOption[0];
         } else {
            ShaderOption[] var4 = var3.getShaderOptions();
            ArrayList var5 = new ArrayList();

            for(int var6 = 0; var6 < var4.length; ++var6) {
               ShaderOption var7 = var4[var6];
               if (var7 == null) {
                  var5.add((Object)null);
               } else if (var7 instanceof ShaderOptionRest) {
                  ShaderOption[] var8 = getShaderOptionsRest(shaderPackGuiScreens, var1);
                  var5.addAll(Arrays.asList(var8));
               } else {
                  var5.add(var7);
               }
            }

            ShaderOption[] var10 = (ShaderOption[])var5.toArray(new ShaderOption[var5.size()]);
            return var10;
         }
      }
   }

   public static IShaderPack getShaderPack(String var0) {
      if (var0 == null) {
         return null;
      } else {
         var0 = var0.trim();
         if (!var0.isEmpty() && !var0.equals("OFF")) {
            if (var0.equals("(internal)")) {
               return new ShaderPackDefault();
            } else {
               try {
                  File var1 = new File(shaderPacksDir, var0);
                  if (var1.isDirectory()) {
                     return new ShaderPackFolder(var0, var1);
                  } else {
                     return var1.isFile() && var0.toLowerCase().endsWith(".zip") ? new ShaderPackZip(var0, var1) : null;
                  }
               } catch (Exception var2) {
                  var2.printStackTrace();
                  return null;
               }
            }
         } else {
            return null;
         }
      }
   }

   public static void endSpiderEyes() {
      if (isRenderingWorld && ProgramSpiderEyes.getId() != ProgramNone.getId()) {
         useProgram(ProgramEntities);
         GlStateManager.disableAlpha();
      }

   }

   public static boolean isUnderwaterOverlay() {
      return !shaderPackUnderwaterOverlay.isFalse();
   }

   public static int getBufferIndexFromString(String var0) {
      if (!var0.equals("colortex0") && !var0.equals("gcolor")) {
         if (!var0.equals("colortex1") && !var0.equals("gdepth")) {
            if (!var0.equals("colortex2") && !var0.equals("gnormal")) {
               if (!var0.equals("colortex3") && !var0.equals("composite")) {
                  if (!var0.equals("colortex4") && !var0.equals("gaux1")) {
                     if (!var0.equals("colortex5") && !var0.equals("gaux2")) {
                        if (!var0.equals("colortex6") && !var0.equals("gaux3")) {
                           return !var0.equals("colortex7") && !var0.equals("gaux4") ? -1 : 7;
                        } else {
                           return 6;
                        }
                     } else {
                        return 5;
                     }
                  } else {
                     return 4;
                  }
               } else {
                  return 3;
               }
            } else {
               return 2;
            }
         } else {
            return 1;
         }
      } else {
         return 0;
      }
   }

   public static void loadConfig() {
      SMCLog.info("Load shaders configuration.");

      try {
         if (!shaderPacksDir.exists()) {
            shaderPacksDir.mkdir();
         }
      } catch (Exception var8) {
         SMCLog.severe("Failed to open the shaderpacks directory: " + shaderPacksDir);
      }

      shadersConfig = new PropertiesOrdered();
      shadersConfig.setProperty(EnumShaderOption.SHADER_PACK.getPropertyKey(), "");
      if (configFile.exists()) {
         try {
            FileReader var0 = new FileReader(configFile);
            shadersConfig.load(var0);
            var0.close();
         } catch (Exception var7) {
         }
      }

      if (!configFile.exists()) {
         try {
            storeConfig();
         } catch (Exception var6) {
         }
      }

      EnumShaderOption[] var9 = EnumShaderOption.values();

      for(int var1 = 0; var1 < var9.length; ++var1) {
         EnumShaderOption var2 = var9[var1];
         String var3 = var2.getPropertyKey();
         String var4 = var2.getValueDefault();
         String var5 = shadersConfig.getProperty(var3, var4);
         setEnumShaderOption(var2, var5);
      }

      loadShaderPack();
   }

   public static void beginSky() {
      isRenderingSky = true;
      fogEnabled = true;
      setDrawBuffers(dfbDrawBuffers);
      useProgram(ProgramSkyTextured);
      pushEntity(-2, 0);
   }

   public static void nextAntialiasingLevel() {
      configAntialiasingLevel += 2;
      configAntialiasingLevel = configAntialiasingLevel / 2 * 2;
      if (configAntialiasingLevel > 4) {
         configAntialiasingLevel = 0;
      }

      configAntialiasingLevel = Config.limit(configAntialiasingLevel, 0, 4);
   }

   public static void setUpPosition() {
      FloatBuffer var0 = tempMatrixDirectBuffer;
      var0.clear();
      GL11.glGetFloat(2982, var0);
      var0.get(tempMat, 0, 16);
      SMath.multiplyMat4xVec4(upPosition, tempMat, upPosModelView);
      setProgramUniform3f(uniform_upPosition, upPosition[0], upPosition[1], upPosition[2]);
      if (customUniforms != null) {
         customUniforms.update();
      }

   }

   public static void endEntities() {
      if (isRenderingWorld) {
         setEntityId((Entity)null);
         useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
      }

   }

   public static void endBlockEntities() {
      if (isRenderingWorld) {
         checkGLError("endBlockEntities");
         setBlockEntityId((TileEntity)null);
         useProgram(lightmapEnabled ? ProgramTexturedLit : ProgramTextured);
         ShadersTex.bindNSTextures(defaultTexture.getMultiTexID());
      }

   }

   public static int getEntityData2() {
      return entityData[entityDataIndex * 2 + 1];
   }

   public static void beginUpdateChunks() {
      checkGLError("beginUpdateChunks1");
      checkFramebufferStatus("beginUpdateChunks1");
      if (!isShadowPass) {
         useProgram(ProgramTerrain);
      }

      checkGLError("beginUpdateChunks2");
      checkFramebufferStatus("beginUpdateChunks2");
   }

   public static void beginBlockEntities() {
      if (isRenderingWorld) {
         checkGLError("beginBlockEntities");
         useProgram(ProgramBlock);
      }

   }

   public static void beginWater() {
      if (isRenderingWorld) {
         if (!isShadowPass) {
            renderDeferred();
            useProgram(ProgramWater);
            GlStateManager.enableBlend();
            GlStateManager.depthMask(true);
         } else {
            GlStateManager.depthMask(true);
         }
      }

   }

   public static int getEntityData() {
      return entityData[entityDataIndex * 2];
   }

   private static ICustomTexture[] loadCustomTextures(Properties var0, int var1) {
      String var2 = "texture." + STAGE_NAMES[var1] + ".";
      Set var3 = var0.keySet();
      ArrayList var4 = new ArrayList();
      Iterator var6 = var3.iterator();

      while(var6.hasNext()) {
         Object var5 = var6.next();
         String var7 = (String)var5;
         if (var7.startsWith(var2)) {
            String var8 = StrUtils.removePrefix(var7, var2);
            var8 = StrUtils.removeSuffix(var8, new String[]{".0", ".1", ".2", ".3", ".4", ".5", ".6", ".7", ".8", ".9"});
            String var9 = var0.getProperty(var7).trim();
            int var10 = getTextureIndex(var1, var8);
            if (var10 < 0) {
               SMCLog.warning("Invalid texture name: " + var7);
            } else {
               ICustomTexture var11 = loadCustomTexture(var10, var9);
               if (var11 != null) {
                  SMCLog.info("Custom texture: " + var7 + " = " + var9);
                  var4.add(var11);
               }
            }
         }
      }

      if (var4.size() <= 0) {
         return null;
      } else {
         ICustomTexture[] var12 = (ICustomTexture[])var4.toArray(new ICustomTexture[var4.size()]);
         return var12;
      }
   }

   static int[] $SWITCH_TABLE$net$minecraft$util$EnumWorldBlockLayer() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$util$EnumWorldBlockLayer;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[EnumWorldBlockLayer.values().length];

         try {
            var0[EnumWorldBlockLayer.CUTOUT.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[EnumWorldBlockLayer.CUTOUT_MIPPED.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[EnumWorldBlockLayer.SOLID.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[EnumWorldBlockLayer.TRANSLUCENT.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$util$EnumWorldBlockLayer = var0;
         return var0;
      }
   }

   public static boolean isItemToRenderMainTranslucent() {
      return itemToRenderMainTranslucent;
   }

   private static FloatBuffer nextFloatBuffer(int var0) {
      ByteBuffer var1 = bigBuffer;
      int var2 = var1.limit();
      var1.position(var2).limit(var2 + var0 * 4);
      return var1.asFloatBuffer();
   }

   public static boolean isBothHandsRendered() {
      return isHandRenderedMain && isHandRenderedOff;
   }

   private static void postDrawComposite() {
      RenderScale var0 = activeProgram.getRenderScale();
      if (var0 != null) {
         GL11.glViewport(0, 0, renderWidth, renderHeight);
      }

   }

   private static void setProgramUniform1i(ShaderUniform1i var0, int var1) {
      var0.setValue(var1);
   }

   private static void setupFrameBuffer() {
      if (dfb != 0) {
         EXTFramebufferObject.glDeleteFramebuffersEXT(dfb);
         GlStateManager.deleteTextures(dfbDepthTextures);
         GlStateManager.deleteTextures(dfbColorTextures);
      }

      dfb = EXTFramebufferObject.glGenFramebuffersEXT();
      GL11.glGenTextures((IntBuffer)dfbDepthTextures.clear().limit(usedDepthBuffers));
      GL11.glGenTextures((IntBuffer)dfbColorTextures.clear().limit(16));
      dfbDepthTextures.position(0);
      dfbColorTextures.position(0);
      EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);
      GL20.glDrawBuffers(0);
      GL11.glReadBuffer(0);

      int var0;
      for(var0 = 0; var0 < usedDepthBuffers; ++var0) {
         GlStateManager.bindTexture(dfbDepthTextures.get(var0));
         GL11.glTexParameteri(3553, 10242, 33071);
         GL11.glTexParameteri(3553, 10243, 33071);
         GL11.glTexParameteri(3553, 10241, 9728);
         GL11.glTexParameteri(3553, 10240, 9728);
         GL11.glTexParameteri(3553, 34891, 6409);
         GL11.glTexImage2D(3553, 0, 6402, renderWidth, renderHeight, 0, 6402, 5126, (FloatBuffer)null);
      }

      EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, dfbDepthTextures.get(0), 0);
      GL20.glDrawBuffers(dfbDrawBuffers);
      GL11.glReadBuffer(0);
      checkGLError("FT d");

      for(var0 = 0; var0 < usedColorBuffers; ++var0) {
         GlStateManager.bindTexture(dfbColorTexturesFlip.getA(var0));
         GL11.glTexParameteri(3553, 10242, 33071);
         GL11.glTexParameteri(3553, 10243, 33071);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glTexImage2D(3553, 0, gbuffersFormat[var0], renderWidth, renderHeight, 0, getPixelFormat(gbuffersFormat[var0]), 33639, (ByteBuffer)null);
         EXTFramebufferObject.glFramebufferTexture2DEXT(36160, '賠' + var0, 3553, dfbColorTexturesFlip.getA(var0), 0);
         checkGLError("FT c");
      }

      for(var0 = 0; var0 < usedColorBuffers; ++var0) {
         GlStateManager.bindTexture(dfbColorTexturesFlip.getB(var0));
         GL11.glTexParameteri(3553, 10242, 33071);
         GL11.glTexParameteri(3553, 10243, 33071);
         GL11.glTexParameteri(3553, 10241, 9729);
         GL11.glTexParameteri(3553, 10240, 9729);
         GL11.glTexImage2D(3553, 0, gbuffersFormat[var0], renderWidth, renderHeight, 0, getPixelFormat(gbuffersFormat[var0]), 33639, (ByteBuffer)null);
         checkGLError("FT ca");
      }

      var0 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
      if (var0 == 36058) {
         printChatAndLogError("[Shaders] Error: Failed framebuffer incomplete formats");

         for(int var1 = 0; var1 < usedColorBuffers; ++var1) {
            GlStateManager.bindTexture(dfbColorTexturesFlip.getA(var1));
            GL11.glTexImage2D(3553, 0, 6408, renderWidth, renderHeight, 0, 32993, 33639, (ByteBuffer)null);
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, '賠' + var1, 3553, dfbColorTexturesFlip.getA(var1), 0);
            checkGLError("FT c");
         }

         var0 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);
         if (var0 == 36053) {
            SMCLog.info("complete");
         }
      }

      GlStateManager.bindTexture(0);
      if (var0 != 36053) {
         printChatAndLogError("[Shaders] Error: Failed creating framebuffer! (Status " + var0 + ")");
      } else {
         SMCLog.info("Framebuffer created.");
      }

   }

   public static void applyHandDepth() {
      if ((double)configHandDepthMul != 1.0D) {
         GL11.glScaled(1.0D, 1.0D, (double)configHandDepthMul);
      }

   }

   public static void beginClouds() {
      fogEnabled = true;
      pushEntity(-3, 0);
      useProgram(ProgramClouds);
   }

   public static void popEntity() {
      entityData[entityDataIndex * 2] = 0;
      entityData[entityDataIndex * 2 + 1] = 0;
      --entityDataIndex;
   }

   private static void loadShaderPackDimensions() {
      shaderPackDimensions.clear();

      for(int var0 = -128; var0 <= 128; ++var0) {
         String var1 = "/shaders/world" + var0;
         if (shaderPack.hasDirectory(var1)) {
            shaderPackDimensions.add(var0);
         }
      }

      if (shaderPackDimensions.size() > 0) {
         Integer[] var2 = (Integer[])shaderPackDimensions.toArray(new Integer[shaderPackDimensions.size()]);
         Config.dbg("[Shaders] Worlds: " + Config.arrayToString((Object[])var2));
      }

   }

   private static IntBuffer fillIntBufferZero(IntBuffer var0) {
      int var1 = var0.limit();

      for(int var2 = var0.position(); var2 < var1; ++var2) {
         var0.put(var2, 0);
      }

      return var0;
   }

   public static void endWeather() {
      GlStateManager.disableBlend();
      useProgram(ProgramTexturedLit);
   }

   public static int checkGLError(String var0) {
      int var1 = GlStateManager.glGetError();
      if (var1 != 0 && GlErrors.isEnabled(var1)) {
         String var2 = Config.getGlErrorString(var1);
         String var3 = getErrorInfo(var1, var0);
         String var4 = String.format("OpenGL error: %s (%s)%s, at: %s", var1, var2, var3, var0);
         SMCLog.severe(var4);
         if (Config.isShowGlErrors() && TimedEvent.isActive("ShowGlErrorShaders", 10000L)) {
            String var5 = I18n.format("of.message.openglError", var1, var2);
            printChat(var5);
         }
      }

      return var1;
   }

   public static boolean isRenderBothHands() {
      return !skipRenderHandMain && !skipRenderHandOff;
   }

   public static void storeConfig() {
      SMCLog.info("Save shaders configuration.");
      if (shadersConfig == null) {
         shadersConfig = new PropertiesOrdered();
      }

      EnumShaderOption[] var0 = EnumShaderOption.values();

      for(int var1 = 0; var1 < var0.length; ++var1) {
         EnumShaderOption var2 = var0[var1];
         String var3 = var2.getPropertyKey();
         String var4 = getEnumShaderOption(var2);
         shadersConfig.setProperty(var3, var4);
      }

      try {
         FileWriter var6 = new FileWriter(configFile);
         shadersConfig.store(var6, (String)null);
         var6.close();
      } catch (Exception var5) {
         SMCLog.severe("Error saving configuration: " + var5.getClass().getName() + ": " + var5.getMessage());
      }

   }

   public static void preWater() {
      if (usedDepthBuffers >= 2) {
         GlStateManager.setActiveTexture(33995);
         checkGLError("pre copy depth");
         GL11.glCopyTexSubImage2D(3553, 0, 0, 0, 0, 0, renderWidth, renderHeight);
         checkGLError("copy depth");
         GlStateManager.setActiveTexture(33984);
      }

      ShadersTex.bindNSTextures(defaultTexture.getMultiTexID());
   }

   static {
      uniform_entityColor = shaderUniforms.make4f("entityColor");
      uniform_entityId = shaderUniforms.make1i("entityId");
      uniform_blockEntityId = shaderUniforms.make1i("blockEntityId");
      uniform_texture = shaderUniforms.make1i("texture");
      uniform_lightmap = shaderUniforms.make1i("lightmap");
      uniform_normals = shaderUniforms.make1i("normals");
      uniform_specular = shaderUniforms.make1i("specular");
      uniform_shadow = shaderUniforms.make1i("shadow");
      uniform_watershadow = shaderUniforms.make1i("watershadow");
      uniform_shadowtex0 = shaderUniforms.make1i("shadowtex0");
      uniform_shadowtex1 = shaderUniforms.make1i("shadowtex1");
      uniform_depthtex0 = shaderUniforms.make1i("depthtex0");
      uniform_depthtex1 = shaderUniforms.make1i("depthtex1");
      uniform_shadowcolor = shaderUniforms.make1i("shadowcolor");
      uniform_shadowcolor0 = shaderUniforms.make1i("shadowcolor0");
      uniform_shadowcolor1 = shaderUniforms.make1i("shadowcolor1");
      uniform_noisetex = shaderUniforms.make1i("noisetex");
      uniform_gcolor = shaderUniforms.make1i("gcolor");
      uniform_gdepth = shaderUniforms.make1i("gdepth");
      uniform_gnormal = shaderUniforms.make1i("gnormal");
      uniform_composite = shaderUniforms.make1i("composite");
      uniform_gaux1 = shaderUniforms.make1i("gaux1");
      uniform_gaux2 = shaderUniforms.make1i("gaux2");
      uniform_gaux3 = shaderUniforms.make1i("gaux3");
      uniform_gaux4 = shaderUniforms.make1i("gaux4");
      uniform_colortex0 = shaderUniforms.make1i("colortex0");
      uniform_colortex1 = shaderUniforms.make1i("colortex1");
      uniform_colortex2 = shaderUniforms.make1i("colortex2");
      uniform_colortex3 = shaderUniforms.make1i("colortex3");
      uniform_colortex4 = shaderUniforms.make1i("colortex4");
      uniform_colortex5 = shaderUniforms.make1i("colortex5");
      uniform_colortex6 = shaderUniforms.make1i("colortex6");
      uniform_colortex7 = shaderUniforms.make1i("colortex7");
      uniform_gdepthtex = shaderUniforms.make1i("gdepthtex");
      uniform_depthtex2 = shaderUniforms.make1i("depthtex2");
      uniform_tex = shaderUniforms.make1i("tex");
      uniform_heldItemId = shaderUniforms.make1i("heldItemId");
      uniform_heldBlockLightValue = shaderUniforms.make1i("heldBlockLightValue");
      uniform_heldItemId2 = shaderUniforms.make1i("heldItemId2");
      uniform_heldBlockLightValue2 = shaderUniforms.make1i("heldBlockLightValue2");
      uniform_fogMode = shaderUniforms.make1i("fogMode");
      uniform_fogDensity = shaderUniforms.make1f("fogDensity");
      uniform_fogColor = shaderUniforms.make3f("fogColor");
      uniform_skyColor = shaderUniforms.make3f("skyColor");
      uniform_worldTime = shaderUniforms.make1i("worldTime");
      uniform_worldDay = shaderUniforms.make1i("worldDay");
      uniform_moonPhase = shaderUniforms.make1i("moonPhase");
      uniform_frameCounter = shaderUniforms.make1i("frameCounter");
      uniform_frameTime = shaderUniforms.make1f("frameTime");
      uniform_frameTimeCounter = shaderUniforms.make1f("frameTimeCounter");
      uniform_sunAngle = shaderUniforms.make1f("sunAngle");
      uniform_shadowAngle = shaderUniforms.make1f("shadowAngle");
      uniform_rainStrength = shaderUniforms.make1f("rainStrength");
      uniform_aspectRatio = shaderUniforms.make1f("aspectRatio");
      uniform_viewWidth = shaderUniforms.make1f("viewWidth");
      uniform_viewHeight = shaderUniforms.make1f("viewHeight");
      uniform_near = shaderUniforms.make1f("near");
      uniform_far = shaderUniforms.make1f("far");
      uniform_sunPosition = shaderUniforms.make3f("sunPosition");
      uniform_moonPosition = shaderUniforms.make3f("moonPosition");
      uniform_shadowLightPosition = shaderUniforms.make3f("shadowLightPosition");
      uniform_upPosition = shaderUniforms.make3f("upPosition");
      uniform_previousCameraPosition = shaderUniforms.make3f("previousCameraPosition");
      uniform_cameraPosition = shaderUniforms.make3f("cameraPosition");
      uniform_gbufferModelView = shaderUniforms.makeM4("gbufferModelView");
      uniform_gbufferModelViewInverse = shaderUniforms.makeM4("gbufferModelViewInverse");
      uniform_gbufferPreviousProjection = shaderUniforms.makeM4("gbufferPreviousProjection");
      uniform_gbufferProjection = shaderUniforms.makeM4("gbufferProjection");
      uniform_gbufferProjectionInverse = shaderUniforms.makeM4("gbufferProjectionInverse");
      uniform_gbufferPreviousModelView = shaderUniforms.makeM4("gbufferPreviousModelView");
      uniform_shadowProjection = shaderUniforms.makeM4("shadowProjection");
      uniform_shadowProjectionInverse = shaderUniforms.makeM4("shadowProjectionInverse");
      uniform_shadowModelView = shaderUniforms.makeM4("shadowModelView");
      uniform_shadowModelViewInverse = shaderUniforms.makeM4("shadowModelViewInverse");
      uniform_wetness = shaderUniforms.make1f("wetness");
      uniform_eyeAltitude = shaderUniforms.make1f("eyeAltitude");
      uniform_eyeBrightness = shaderUniforms.make2i("eyeBrightness");
      uniform_eyeBrightnessSmooth = shaderUniforms.make2i("eyeBrightnessSmooth");
      uniform_terrainTextureSize = shaderUniforms.make2i("terrainTextureSize");
      uniform_terrainIconSize = shaderUniforms.make1i("terrainIconSize");
      uniform_isEyeInWater = shaderUniforms.make1i("isEyeInWater");
      uniform_nightVision = shaderUniforms.make1f("nightVision");
      uniform_blindness = shaderUniforms.make1f("blindness");
      uniform_screenBrightness = shaderUniforms.make1f("screenBrightness");
      uniform_hideGUI = shaderUniforms.make1i("hideGUI");
      uniform_centerDepthSmooth = shaderUniforms.make1f("centerDepthSmooth");
      uniform_atlasSize = shaderUniforms.make2i("atlasSize");
      uniform_blendFunc = shaderUniforms.make4i("blendFunc");
      uniform_instanceId = shaderUniforms.make1i("instanceId");
      shadowPassInterval = 0;
      needResizeShadow = false;
      shadowMapWidth = 1024;
      shadowMapHeight = 1024;
      spShadowMapWidth = 1024;
      spShadowMapHeight = 1024;
      shadowMapFOV = 90.0F;
      shadowMapHalfPlane = 160.0F;
      shadowMapIsOrtho = true;
      shadowDistanceRenderMul = -1.0F;
      shadowPassCounter = 0;
      shouldSkipDefaultShadow = false;
      waterShadowEnabled = false;
      usedColorBuffers = 0;
      usedDepthBuffers = 0;
      usedShadowColorBuffers = 0;
      usedShadowDepthBuffers = 0;
      usedColorAttachs = 0;
      usedDrawBuffers = 0;
      dfb = 0;
      sfb = 0;
      gbuffersFormat = new int[8];
      gbuffersClear = new boolean[8];
      gbuffersClearColor = new Vector4f[8];
      programs = new Programs();
      ProgramNone = programs.getProgramNone();
      ProgramShadow = programs.makeShadow("shadow", ProgramNone);
      ProgramShadowSolid = programs.makeShadow("shadow_solid", ProgramShadow);
      ProgramShadowCutout = programs.makeShadow("shadow_cutout", ProgramShadow);
      ProgramBasic = programs.makeGbuffers("gbuffers_basic", ProgramNone);
      ProgramTextured = programs.makeGbuffers("gbuffers_textured", ProgramBasic);
      ProgramTexturedLit = programs.makeGbuffers("gbuffers_textured_lit", ProgramTextured);
      ProgramSkyBasic = programs.makeGbuffers("gbuffers_skybasic", ProgramBasic);
      ProgramSkyTextured = programs.makeGbuffers("gbuffers_skytextured", ProgramTextured);
      ProgramClouds = programs.makeGbuffers("gbuffers_clouds", ProgramTextured);
      ProgramTerrain = programs.makeGbuffers("gbuffers_terrain", ProgramTexturedLit);
      ProgramTerrainSolid = programs.makeGbuffers("gbuffers_terrain_solid", ProgramTerrain);
      ProgramTerrainCutoutMip = programs.makeGbuffers("gbuffers_terrain_cutout_mip", ProgramTerrain);
      ProgramTerrainCutout = programs.makeGbuffers("gbuffers_terrain_cutout", ProgramTerrain);
      ProgramDamagedBlock = programs.makeGbuffers("gbuffers_damagedblock", ProgramTerrain);
      ProgramBlock = programs.makeGbuffers("gbuffers_block", ProgramTerrain);
      ProgramBeaconBeam = programs.makeGbuffers("gbuffers_beaconbeam", ProgramTextured);
      ProgramItem = programs.makeGbuffers("gbuffers_item", ProgramTexturedLit);
      ProgramEntities = programs.makeGbuffers("gbuffers_entities", ProgramTexturedLit);
      ProgramEntitiesGlowing = programs.makeGbuffers("gbuffers_entities_glowing", ProgramEntities);
      ProgramArmorGlint = programs.makeGbuffers("gbuffers_armor_glint", ProgramTextured);
      ProgramSpiderEyes = programs.makeGbuffers("gbuffers_spidereyes", ProgramTextured);
      ProgramHand = programs.makeGbuffers("gbuffers_hand", ProgramTexturedLit);
      ProgramWeather = programs.makeGbuffers("gbuffers_weather", ProgramTexturedLit);
      ProgramDeferredPre = programs.makeVirtual("deferred_pre");
      ProgramsDeferred = programs.makeDeferreds("deferred", 16);
      ProgramDeferred = ProgramsDeferred[0];
      ProgramWater = programs.makeGbuffers("gbuffers_water", ProgramTerrain);
      ProgramHandWater = programs.makeGbuffers("gbuffers_hand_water", ProgramHand);
      ProgramCompositePre = programs.makeVirtual("composite_pre");
      ProgramsComposite = programs.makeComposites("composite", 16);
      ProgramComposite = ProgramsComposite[0];
      ProgramFinal = programs.makeComposite("final");
      ProgramCount = programs.getCount();
      ProgramsAll = programs.getPrograms();
      activeProgram = ProgramNone;
      activeProgramID = 0;
      programStackLeash = new ProgramStack();
      hasDeferredPrograms = false;
      activeDrawBuffers = null;
      activeCompositeMipmapSetting = 0;
      loadedShaders = null;
      shadersConfig = null;
      defaultTexture = null;
      shadowHardwareFilteringEnabled = new boolean[2];
      shadowMipmapEnabled = new boolean[2];
      shadowFilterNearest = new boolean[2];
      shadowColorMipmapEnabled = new boolean[8];
      shadowColorFilterNearest = new boolean[8];
      configTweakBlockDamage = false;
      configCloudShadow = false;
      configHandDepthMul = 0.125F;
      configRenderResMul = 1.0F;
      configShadowResMul = 1.0F;
      configTexMinFilB = 0;
      configTexMinFilN = 0;
      configTexMinFilS = 0;
      configTexMagFilB = 0;
      configTexMagFilN = 0;
      configTexMagFilS = 0;
      configShadowClipFrustrum = true;
      configNormalMap = true;
      configSpecularMap = true;
      configOldLighting = new PropertyDefaultTrueFalse("oldLighting", "Classic Lighting", 0);
      configOldHandLight = new PropertyDefaultTrueFalse("oldHandLight", "Old Hand Light", 0);
      configAntialiasingLevel = 0;
      texMinFilDesc = new String[]{"Nearest", "Nearest-Nearest", "Nearest-Linear"};
      texMagFilDesc = new String[]{"Nearest", "Linear"};
      texMinFilValue = new int[]{9728, 9984, 9986};
      texMagFilValue = new int[]{9728, 9729};
      shaderPack = null;
      shaderPackLoaded = false;
      shaderPacksDir = new File(Minecraft.getMinecraft().mcDataDir, "shaderpacks");
      configFile = new File(Minecraft.getMinecraft().mcDataDir, "optionsshaders.txt");
      shaderPackOptions = null;
      shaderPackOptionSliders = null;
      shaderPackProfiles = null;
      shaderPackGuiScreens = null;
      shaderPackProgramConditions = new HashMap();
      shaderPackClouds = new PropertyDefaultFastFancyOff("clouds", "Clouds", 0);
      shaderPackOldLighting = new PropertyDefaultTrueFalse("oldLighting", "Classic Lighting", 0);
      shaderPackOldHandLight = new PropertyDefaultTrueFalse("oldHandLight", "Old Hand Light", 0);
      shaderPackDynamicHandLight = new PropertyDefaultTrueFalse("dynamicHandLight", "Dynamic Hand Light", 0);
      shaderPackShadowTranslucent = new PropertyDefaultTrueFalse("shadowTranslucent", "Shadow Translucent", 0);
      shaderPackUnderwaterOverlay = new PropertyDefaultTrueFalse("underwaterOverlay", "Underwater Overlay", 0);
      shaderPackSun = new PropertyDefaultTrueFalse("sun", "Sun", 0);
      shaderPackMoon = new PropertyDefaultTrueFalse("moon", "Moon", 0);
      shaderPackVignette = new PropertyDefaultTrueFalse("vignette", "Vignette", 0);
      shaderPackBackFaceSolid = new PropertyDefaultTrueFalse("backFace.solid", "Back-face Solid", 0);
      shaderPackBackFaceCutout = new PropertyDefaultTrueFalse("backFace.cutout", "Back-face Cutout", 0);
      shaderPackBackFaceCutoutMipped = new PropertyDefaultTrueFalse("backFace.cutoutMipped", "Back-face Cutout Mipped", 0);
      shaderPackBackFaceTranslucent = new PropertyDefaultTrueFalse("backFace.translucent", "Back-face Translucent", 0);
      shaderPackRainDepth = new PropertyDefaultTrueFalse("rain.depth", "Rain Depth", 0);
      shaderPackBeaconBeamDepth = new PropertyDefaultTrueFalse("beacon.beam.depth", "Rain Depth", 0);
      shaderPackSeparateAo = new PropertyDefaultTrueFalse("separateAo", "Separate AO", 0);
      shaderPackFrustumCulling = new PropertyDefaultTrueFalse("frustum.culling", "Frustum Culling", 0);
      shaderPackResources = new HashMap();
      currentWorld = null;
      shaderPackDimensions = new ArrayList();
      customTexturesGbuffers = null;
      customTexturesComposite = null;
      customTexturesDeferred = null;
      noiseTexturePath = null;
      customUniforms = null;
      STAGE_NAMES = new String[]{"gbuffers", "composite", "deferred"};
      saveFinalShaders = System.getProperty("shaders.debug.save", "false").equals("true");
      blockLightLevel05 = 0.5F;
      blockLightLevel06 = 0.6F;
      blockLightLevel08 = 0.8F;
      aoLevel = -1.0F;
      sunPathRotation = 0.0F;
      shadowAngleInterval = 0.0F;
      fogMode = 0;
      fogDensity = 0.0F;
      shadowIntervalSize = 2.0F;
      terrainIconSize = 16;
      terrainTextureSize = new int[2];
      noiseTextureEnabled = false;
      noiseTextureResolution = 256;
      colorTextureImageUnit = new int[]{0, 1, 2, 3, 7, 8, 9, 10};
      bigBufferSize = (285 + 8 * ProgramCount) * 4;
      bigBuffer = (ByteBuffer)BufferUtils.createByteBuffer(bigBufferSize).limit(0);
      faProjection = new float[16];
      faProjectionInverse = new float[16];
      faModelView = new float[16];
      faModelViewInverse = new float[16];
      faShadowProjection = new float[16];
      faShadowProjectionInverse = new float[16];
      faShadowModelView = new float[16];
      faShadowModelViewInverse = new float[16];
      projection = nextFloatBuffer(16);
      projectionInverse = nextFloatBuffer(16);
      modelView = nextFloatBuffer(16);
      modelViewInverse = nextFloatBuffer(16);
      shadowProjection = nextFloatBuffer(16);
      shadowProjectionInverse = nextFloatBuffer(16);
      shadowModelView = nextFloatBuffer(16);
      shadowModelViewInverse = nextFloatBuffer(16);
      previousProjection = nextFloatBuffer(16);
      previousModelView = nextFloatBuffer(16);
      tempMatrixDirectBuffer = nextFloatBuffer(16);
      tempDirectFloatBuffer = nextFloatBuffer(16);
      dfbColorTextures = nextIntBuffer(16);
      dfbDepthTextures = nextIntBuffer(3);
      sfbColorTextures = nextIntBuffer(8);
      sfbDepthTextures = nextIntBuffer(2);
      dfbDrawBuffers = nextIntBuffer(8);
      sfbDrawBuffers = nextIntBuffer(8);
      drawBuffersNone = (IntBuffer)nextIntBuffer(8).limit(0);
      drawBuffersColorAtt0 = (IntBuffer)nextIntBuffer(8).put(36064).position(0).limit(1);
      dfbColorTexturesFlip = new FlipTextures(dfbColorTextures, 8);
      formatNames = new String[]{"R8", "RG8", "RGB8", "RGBA8", "R8_SNORM", "RG8_SNORM", "RGB8_SNORM", "RGBA8_SNORM", "R16", "RG16", "RGB16", "RGBA16", "R16_SNORM", "RG16_SNORM", "RGB16_SNORM", "RGBA16_SNORM", "R16F", "RG16F", "RGB16F", "RGBA16F", "R32F", "RG32F", "RGB32F", "RGBA32F", "R32I", "RG32I", "RGB32I", "RGBA32I", "R32UI", "RG32UI", "RGB32UI", "RGBA32UI", "R3_G3_B2", "RGB5_A1", "RGB10_A2", "R11F_G11F_B10F", "RGB9_E5"};
      formatIds = new int[]{33321, 33323, 32849, 32856, 36756, 36757, 36758, 36759, 33322, 33324, 32852, 32859, 36760, 36761, 36762, 36763, 33325, 33327, 34843, 34842, 33326, 33328, 34837, 34836, 33333, 33339, 36227, 36226, 33334, 33340, 36209, 36208, 10768, 32855, 32857, 35898, 35901};
      patternLoadEntityDataMap = Pattern.compile("\\s*([\\w:]+)\\s*=\\s*([-]?\\d+)\\s*");
      entityData = new int[32];
      entityDataIndex = 0;
   }

   public static void beginBeacon() {
      if (isRenderingWorld) {
         useProgram(ProgramBeaconBeam);
      }

   }

   public static void beginEntitiesGlowing() {
      if (isRenderingWorld) {
         isEntitiesGlowing = true;
      }

   }

   public static void setCameraShadow(float var0) {
      Entity var1 = mc.getRenderViewEntity();
      double var2 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * (double)var0;
      double var4 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * (double)var0;
      double var6 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * (double)var0;
      updateCameraOffset(var1);
      cameraPositionX = var2 - (double)cameraOffsetX;
      cameraPositionY = var4;
      cameraPositionZ = var6 - (double)cameraOffsetZ;
      GL11.glGetFloat(2983, (FloatBuffer)projection.position(0));
      SMath.invertMat4FBFA((FloatBuffer)projectionInverse.position(0), (FloatBuffer)projection.position(0), faProjectionInverse, faProjection);
      projection.position(0);
      projectionInverse.position(0);
      GL11.glGetFloat(2982, (FloatBuffer)modelView.position(0));
      SMath.invertMat4FBFA((FloatBuffer)modelViewInverse.position(0), (FloatBuffer)modelView.position(0), faModelViewInverse, faModelView);
      modelView.position(0);
      modelViewInverse.position(0);
      GL11.glViewport(0, 0, shadowMapWidth, shadowMapHeight);
      GL11.glMatrixMode(5889);
      GL11.glLoadIdentity();
      if (shadowMapIsOrtho) {
         GL11.glOrtho((double)(-shadowMapHalfPlane), (double)shadowMapHalfPlane, (double)(-shadowMapHalfPlane), (double)shadowMapHalfPlane, 0.05000000074505806D, 256.0D);
      } else {
         GLU.gluPerspective(shadowMapFOV, (float)shadowMapWidth / (float)shadowMapHeight, 0.05F, 256.0F);
      }

      GL11.glMatrixMode(5888);
      GL11.glLoadIdentity();
      GL11.glTranslatef(0.0F, 0.0F, -100.0F);
      GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
      celestialAngle = mc.theWorld.getCelestialAngle(var0);
      sunAngle = celestialAngle < 0.75F ? celestialAngle + 0.25F : celestialAngle - 0.75F;
      float var8 = celestialAngle * -360.0F;
      float var9 = shadowAngleInterval > 0.0F ? var8 % shadowAngleInterval - shadowAngleInterval * 0.5F : 0.0F;
      if ((double)sunAngle <= 0.5D) {
         GL11.glRotatef(var8 - var9, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(sunPathRotation, 1.0F, 0.0F, 0.0F);
         shadowAngle = sunAngle;
      } else {
         GL11.glRotatef(var8 + 180.0F - var9, 0.0F, 0.0F, 1.0F);
         GL11.glRotatef(sunPathRotation, 1.0F, 0.0F, 0.0F);
         shadowAngle = sunAngle - 0.5F;
      }

      float var10;
      float var11;
      if (shadowMapIsOrtho) {
         var10 = shadowIntervalSize;
         var11 = var10 / 2.0F;
         GL11.glTranslatef((float)var2 % var10 - var11, (float)var4 % var10 - var11, (float)var6 % var10 - var11);
      }

      var10 = sunAngle * 6.2831855F;
      var11 = (float)Math.cos((double)var10);
      float var12 = (float)Math.sin((double)var10);
      float var13 = sunPathRotation * 6.2831855F;
      float var14 = var11;
      float var15 = var12 * (float)Math.cos((double)var13);
      float var16 = var12 * (float)Math.sin((double)var13);
      if ((double)sunAngle > 0.5D) {
         var14 = -var11;
         var15 = -var15;
         var16 = -var16;
      }

      shadowLightPositionVector[0] = var14;
      shadowLightPositionVector[1] = var15;
      shadowLightPositionVector[2] = var16;
      shadowLightPositionVector[3] = 0.0F;
      GL11.glGetFloat(2983, (FloatBuffer)shadowProjection.position(0));
      SMath.invertMat4FBFA((FloatBuffer)shadowProjectionInverse.position(0), (FloatBuffer)shadowProjection.position(0), faShadowProjectionInverse, faShadowProjection);
      shadowProjection.position(0);
      shadowProjectionInverse.position(0);
      GL11.glGetFloat(2982, (FloatBuffer)shadowModelView.position(0));
      SMath.invertMat4FBFA((FloatBuffer)shadowModelViewInverse.position(0), (FloatBuffer)shadowModelView.position(0), faShadowModelViewInverse, faShadowModelView);
      shadowModelView.position(0);
      shadowModelViewInverse.position(0);
      setProgramUniformMatrix4ARB(uniform_gbufferProjection, false, projection);
      setProgramUniformMatrix4ARB(uniform_gbufferProjectionInverse, false, projectionInverse);
      setProgramUniformMatrix4ARB(uniform_gbufferPreviousProjection, false, previousProjection);
      setProgramUniformMatrix4ARB(uniform_gbufferModelView, false, modelView);
      setProgramUniformMatrix4ARB(uniform_gbufferModelViewInverse, false, modelViewInverse);
      setProgramUniformMatrix4ARB(uniform_gbufferPreviousModelView, false, previousModelView);
      setProgramUniformMatrix4ARB(uniform_shadowProjection, false, shadowProjection);
      setProgramUniformMatrix4ARB(uniform_shadowProjectionInverse, false, shadowProjectionInverse);
      setProgramUniformMatrix4ARB(uniform_shadowModelView, false, shadowModelView);
      setProgramUniformMatrix4ARB(uniform_shadowModelViewInverse, false, shadowModelViewInverse);
      mc.gameSettings.thirdPersonView = 1;
      checkGLError("setCamera");
   }

   public static IShaderPack getShaderPack() {
      return shaderPack;
   }

   private static void bindCustomTextures(ICustomTexture[] var0) {
      if (var0 != null) {
         for(int var1 = 0; var1 < var0.length; ++var1) {
            ICustomTexture var2 = var0[var1];
            GlStateManager.setActiveTexture('蓀' + var2.getTextureUnit());
            int var3 = var2.getTextureId();
            int var4 = var2.getTarget();
            if (var4 == 3553) {
               GlStateManager.bindTexture(var3);
            } else {
               GL11.glBindTexture(var4, var3);
            }
         }
      }

   }

   public static void glEnableWrapper(int var0) {
      GL11.glEnable(var0);
      if (var0 == 3553) {
         enableTexture2D();
      } else if (var0 == 2912) {
         enableFog();
      }

   }

   private static void setProgramUniform3f(ShaderUniform3f var0, float var1, float var2, float var3) {
      var0.setValue(var1, var2, var3);
   }

   public static boolean isMoon() {
      return !shaderPackMoon.isFalse();
   }

   private static int getDrawBuffer(Program var0, String var1, int var2) {
      int var3 = 0;
      if (var2 >= var1.length()) {
         return var3;
      } else {
         int var4 = var1.charAt(var2) - 48;
         if (var0 == ProgramShadow) {
            if (var4 >= 0 && var4 <= 1) {
               var3 = var4 + '賠';
               usedShadowColorBuffers = Math.max(usedShadowColorBuffers, var4);
            }

            return var3;
         } else {
            if (var4 >= 0 && var4 <= 7) {
               var0.getToggleColorTextures()[var4] = true;
               var3 = var4 + '賠';
               usedColorAttachs = Math.max(usedColorAttachs, var4);
               usedColorBuffers = Math.max(usedColorBuffers, var4);
            }

            return var3;
         }
      }
   }

   private static boolean printShaderLogInfo(int var0, String var1, List<String> var2) {
      IntBuffer var3 = BufferUtils.createIntBuffer(1);
      int var4 = GL20.glGetShaderi(var0, 35716);
      if (var4 <= 1) {
         return true;
      } else {
         for(int var5 = 0; var5 < var2.size(); ++var5) {
            String var6 = (String)var2.get(var5);
            SMCLog.info("File: " + (var5 + 1) + " = " + var6);
         }

         String var7 = GL20.glGetShaderInfoLog(var0, var4);
         var7 = StrUtils.trim(var7, " \n\r\t");
         SMCLog.info("Shader info log: " + var1 + "\n" + var7);
         return false;
      }
   }
}
