package net.optifine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.SimpleTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.optifine.util.PropertiesOrdered;

public class EmissiveTextures {
   private static String suffixEmissive = null;
   private static boolean renderEmissive = false;
   private static boolean active = false;
   private static String suffixEmissivePng = null;
   private static boolean render = false;
   private static final String SUFFIX_PNG = ".png";
   private static float lightMapY;
   private static float lightMapX;
   private static boolean hasEmissive = false;
   private static final ResourceLocation LOCATION_EMPTY = new ResourceLocation("mcpatcher/ctm/default/empty.png");

   private static void dbg(String var0) {
      Config.dbg("EmissiveTextures: " + var0);
   }

   public static String getSuffixEmissive() {
      return suffixEmissive;
   }

   public static boolean isEmissive(ResourceLocation var0) {
      return suffixEmissivePng == null ? false : var0.getResourcePath().endsWith(suffixEmissivePng);
   }

   public static void update() {
      active = false;
      suffixEmissive = null;
      suffixEmissivePng = null;
      if (Config.isEmissiveTextures()) {
         try {
            String var0 = "optifine/emissive.properties";
            ResourceLocation var1 = new ResourceLocation(var0);
            InputStream var2 = Config.getResourceStream(var1);
            if (var2 == null) {
               return;
            }

            dbg("Loading " + var0);
            PropertiesOrdered var3 = new PropertiesOrdered();
            var3.load(var2);
            var2.close();
            suffixEmissive = var3.getProperty("suffix.emissive");
            if (suffixEmissive != null) {
               suffixEmissivePng = suffixEmissive + ".png";
            }

            active = suffixEmissive != null;
         } catch (FileNotFoundException var4) {
            return;
         } catch (IOException var5) {
            var5.printStackTrace();
         }
      }

   }

   public static void beginRenderEmissive() {
      lightMapX = OpenGlHelper.lastBrightnessX;
      lightMapY = OpenGlHelper.lastBrightnessY;
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 240.0F, lightMapY);
      renderEmissive = true;
   }

   public static void endRender() {
      render = false;
      hasEmissive = false;
   }

   private static void warn(String var0) {
      Config.warn("EmissiveTextures: " + var0);
   }

   public static boolean isActive() {
      return active;
   }

   public static void loadTexture(ResourceLocation var0, SimpleTexture var1) {
      if (var0 != null && var1 != null) {
         var1.isEmissive = false;
         var1.locationEmissive = null;
         if (suffixEmissivePng != null) {
            String var2 = var0.getResourcePath();
            if (var2.endsWith(".png")) {
               if (var2.endsWith(suffixEmissivePng)) {
                  var1.isEmissive = true;
               } else {
                  String var3 = var2.substring(0, var2.length() - ".png".length()) + suffixEmissivePng;
                  ResourceLocation var4 = new ResourceLocation(var0.getResourceDomain(), var3);
                  if (Config.hasResource(var4)) {
                     var1.locationEmissive = var4;
                  }
               }
            }
         }
      }

   }

   public static void endRenderEmissive() {
      renderEmissive = false;
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, lightMapX, lightMapY);
   }

   public static ITextureObject getEmissiveTexture(ITextureObject var0, Map<ResourceLocation, ITextureObject> var1) {
      if (!render) {
         return var0;
      } else if (!(var0 instanceof SimpleTexture)) {
         return var0;
      } else {
         SimpleTexture var2 = (SimpleTexture)var0;
         ResourceLocation var3 = var2.locationEmissive;
         if (!renderEmissive) {
            if (var3 != null) {
               hasEmissive = true;
            }

            return var0;
         } else {
            if (var3 == null) {
               var3 = LOCATION_EMPTY;
            }

            Object var4 = (ITextureObject)var1.get(var3);
            if (var4 == null) {
               var4 = new SimpleTexture(var3);
               TextureManager var5 = Config.getTextureManager();
               var5.loadTexture(var3, (ITextureObject)var4);
            }

            return (ITextureObject)var4;
         }
      }
   }

   public static void beginRender() {
      render = true;
      hasEmissive = false;
   }

   public static boolean hasEmissive() {
      return hasEmissive;
   }
}
