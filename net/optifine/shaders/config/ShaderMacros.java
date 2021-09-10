package net.optifine.shaders.config;

import net.minecraft.src.Config;
import net.minecraft.util.Util;
import net.optifine.shaders.Shaders;

public class ShaderMacros {
   public static final String MC_NORMAL_MAP = "MC_NORMAL_MAP";
   public static final String MC_OS_LINUX = "MC_OS_LINUX";
   private static int[] $SWITCH_TABLE$net$minecraft$util$Util$EnumOS;
   public static final String MC_GL_RENDERER_INTEL = "MC_GL_RENDERER_INTEL";
   public static final String MC_RENDER_QUALITY = "MC_RENDER_QUALITY";
   public static final String MC_OS_WINDOWS = "MC_OS_WINDOWS";
   public static final String MC_GL_VENDOR_NVIDIA = "MC_GL_VENDOR_NVIDIA";
   private static String PREFIX_MACRO = "MC_";
   public static final String MC_HAND_DEPTH = "MC_HAND_DEPTH";
   private static ShaderMacro[] extensionMacros;
   public static final String MC_SHADOW_QUALITY = "MC_SHADOW_QUALITY";
   public static final String MC_SPECULAR_MAP = "MC_SPECULAR_MAP";
   public static final String MC_GL_VENDOR_INTEL = "MC_GL_VENDOR_INTEL";
   public static final String MC_GL_RENDERER_GALLIUM = "MC_GL_RENDERER_GALLIUM";
   public static final String MC_GL_VERSION = "MC_GL_VERSION";
   public static final String MC_GL_RENDERER_OTHER = "MC_GL_RENDERER_OTHER";
   public static final String MC_VERSION = "MC_VERSION";
   public static final String MC_OLD_HAND_LIGHT = "MC_OLD_HAND_LIGHT";
   public static final String MC_GL_RENDERER_MESA = "MC_GL_RENDERER_MESA";
   public static final String MC_OS_OTHER = "MC_OS_OTHER";
   public static final String MC_GL_VENDOR_ATI = "MC_GL_VENDOR_ATI";
   public static final String MC_GL_RENDERER_QUADRO = "MC_GL_RENDERER_QUADRO";
   public static final String MC_GLSL_VERSION = "MC_GLSL_VERSION";
   public static final String MC_FXAA_LEVEL = "MC_FXAA_LEVEL";
   public static final String MC_GL_RENDERER_GEFORCE = "MC_GL_RENDERER_GEFORCE";
   public static final String MC_OLD_LIGHTING = "MC_OLD_LIGHTING";
   public static final String MC_OS_MAC = "MC_OS_MAC";
   public static final String MC_GL_RENDERER_RADEON = "MC_GL_RENDERER_RADEON";
   public static final String MC_GL_VENDOR_OTHER = "MC_GL_VENDOR_OTHER";
   public static final String MC_GL_VENDOR_XORG = "MC_GL_VENDOR_XORG";

   private static void addMacroLine(StringBuilder var0, String var1) {
      var0.append("#define ");
      var0.append(var1);
      var0.append("\n");
   }

   private static void addMacroLine(StringBuilder var0, String var1, float var2) {
      var0.append("#define ");
      var0.append(var1);
      var0.append(" ");
      var0.append(var2);
      var0.append("\n");
   }

   public static String getOptionMacroLines() {
      StringBuilder var0 = new StringBuilder();
      if (Shaders.configAntialiasingLevel > 0) {
         addMacroLine(var0, "MC_FXAA_LEVEL", Shaders.configAntialiasingLevel);
      }

      if (Shaders.configNormalMap) {
         addMacroLine(var0, "MC_NORMAL_MAP");
      }

      if (Shaders.configSpecularMap) {
         addMacroLine(var0, "MC_SPECULAR_MAP");
      }

      addMacroLine(var0, "MC_RENDER_QUALITY", Shaders.configRenderResMul);
      addMacroLine(var0, "MC_SHADOW_QUALITY", Shaders.configShadowResMul);
      addMacroLine(var0, "MC_HAND_DEPTH", Shaders.configHandDepthMul);
      if (Shaders.isOldHandLight()) {
         addMacroLine(var0, "MC_OLD_HAND_LIGHT");
      }

      if (Shaders.isOldLighting()) {
         addMacroLine(var0, "MC_OLD_LIGHTING");
      }

      return var0.toString();
   }

   public static String getPrefixMacro() {
      return PREFIX_MACRO;
   }

   public static String getRenderer() {
      String var0 = Config.openGlRenderer;
      if (var0 == null) {
         return "MC_GL_RENDERER_OTHER";
      } else {
         var0 = var0.toLowerCase();
         if (var0.startsWith("amd")) {
            return "MC_GL_RENDERER_RADEON";
         } else if (var0.startsWith("ati")) {
            return "MC_GL_RENDERER_RADEON";
         } else if (var0.startsWith("radeon")) {
            return "MC_GL_RENDERER_RADEON";
         } else if (var0.startsWith("gallium")) {
            return "MC_GL_RENDERER_GALLIUM";
         } else if (var0.startsWith("intel")) {
            return "MC_GL_RENDERER_INTEL";
         } else if (var0.startsWith("geforce")) {
            return "MC_GL_RENDERER_GEFORCE";
         } else if (var0.startsWith("nvidia")) {
            return "MC_GL_RENDERER_GEFORCE";
         } else if (var0.startsWith("quadro")) {
            return "MC_GL_RENDERER_QUADRO";
         } else if (var0.startsWith("nvs")) {
            return "MC_GL_RENDERER_QUADRO";
         } else {
            return var0.startsWith("mesa") ? "MC_GL_RENDERER_MESA" : "MC_GL_RENDERER_OTHER";
         }
      }
   }

   public static String getFixedMacroLines() {
      StringBuilder var0 = new StringBuilder();
      addMacroLine(var0, "MC_VERSION", Config.getMinecraftVersionInt());
      addMacroLine(var0, "MC_GL_VERSION " + Config.getGlVersion().toInt());
      addMacroLine(var0, "MC_GLSL_VERSION " + Config.getGlslVersion().toInt());
      addMacroLine(var0, getOs());
      addMacroLine(var0, getVendor());
      addMacroLine(var0, getRenderer());
      return var0.toString();
   }

   private static void addMacroLine(StringBuilder var0, String var1, int var2) {
      var0.append("#define ");
      var0.append(var1);
      var0.append(" ");
      var0.append(var2);
      var0.append("\n");
   }

   public static String getOs() {
      Util.EnumOS var0 = Util.getOSType();
      switch($SWITCH_TABLE$net$minecraft$util$Util$EnumOS()[var0.ordinal()]) {
      case 1:
         return "MC_OS_LINUX";
      case 2:
      default:
         return "MC_OS_OTHER";
      case 3:
         return "MC_OS_WINDOWS";
      case 4:
         return "MC_OS_MAC";
      }
   }

   public static String getVendor() {
      String var0 = Config.openGlVendor;
      if (var0 == null) {
         return "MC_GL_VENDOR_OTHER";
      } else {
         var0 = var0.toLowerCase();
         if (var0.startsWith("ati")) {
            return "MC_GL_VENDOR_ATI";
         } else if (var0.startsWith("intel")) {
            return "MC_GL_VENDOR_INTEL";
         } else if (var0.startsWith("nvidia")) {
            return "MC_GL_VENDOR_NVIDIA";
         } else {
            return var0.startsWith("x.org") ? "MC_GL_VENDOR_XORG" : "MC_GL_VENDOR_OTHER";
         }
      }
   }

   public static ShaderMacro[] getExtensions() {
      if (extensionMacros == null) {
         String[] var0 = Config.getOpenGlExtensions();
         ShaderMacro[] var1 = new ShaderMacro[var0.length];

         for(int var2 = 0; var2 < var0.length; ++var2) {
            var1[var2] = new ShaderMacro(PREFIX_MACRO + var0[var2], "");
         }

         extensionMacros = var1;
      }

      return extensionMacros;
   }

   static int[] $SWITCH_TABLE$net$minecraft$util$Util$EnumOS() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$util$Util$EnumOS;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[Util.EnumOS.values().length];

         try {
            var0[Util.EnumOS.LINUX.ordinal()] = 1;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[Util.EnumOS.OSX.ordinal()] = 4;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[Util.EnumOS.SOLARIS.ordinal()] = 2;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[Util.EnumOS.UNKNOWN.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[Util.EnumOS.WINDOWS.ordinal()] = 3;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$util$Util$EnumOS = var0;
         return var0;
      }
   }
}
