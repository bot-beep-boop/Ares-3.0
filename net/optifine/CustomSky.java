package net.optifine;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.src.Config;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.optifine.render.Blender;
import net.optifine.util.PropertiesOrdered;
import net.optifine.util.TextureUtils;

public class CustomSky {
   private static CustomSkyLayer[][] worldSkyLayers = null;

   public static void renderSky(World var0, TextureManager var1, float var2) {
      if (worldSkyLayers != null) {
         int var3 = var0.provider.getDimensionId();
         if (var3 >= 0 && var3 < worldSkyLayers.length) {
            CustomSkyLayer[] var4 = worldSkyLayers[var3];
            if (var4 != null) {
               long var5 = var0.getWorldTime();
               int var7 = (int)(var5 % 24000L);
               float var8 = var0.getCelestialAngle(var2);
               float var9 = var0.getRainStrength(var2);
               float var10 = var0.getThunderStrength(var2);
               if (var9 > 0.0F) {
                  var10 /= var9;
               }

               for(int var11 = 0; var11 < var4.length; ++var11) {
                  CustomSkyLayer var12 = var4[var11];
                  if (var12.isActive(var0, var7)) {
                     var12.render(var0, var7, var8, var9, var10);
                  }
               }

               float var13 = 1.0F - var9;
               Blender.clearBlend(var13);
            }
         }
      }

   }

   public static void update() {
      reset();
      if (Config.isCustomSky()) {
         worldSkyLayers = readCustomSkies();
      }

   }

   public static void reset() {
      worldSkyLayers = null;
   }

   public static boolean hasSkyLayers(World var0) {
      if (worldSkyLayers == null) {
         return false;
      } else {
         int var1 = var0.provider.getDimensionId();
         if (var1 >= 0 && var1 < worldSkyLayers.length) {
            CustomSkyLayer[] var2 = worldSkyLayers[var1];
            if (var2 == null) {
               return false;
            } else {
               return var2.length > 0;
            }
         } else {
            return false;
         }
      }
   }

   private static CustomSkyLayer[][] readCustomSkies() {
      CustomSkyLayer[][] var0 = new CustomSkyLayer[10][0];
      String var1 = "mcpatcher/sky/world";
      int var2 = -1;

      int var3;
      for(var3 = 0; var3 < var0.length; ++var3) {
         String var4 = var1 + var3 + "/sky";
         ArrayList var5 = new ArrayList();

         for(int var6 = 1; var6 < 1000; ++var6) {
            String var7 = var4 + var6 + ".properties";

            try {
               ResourceLocation var8 = new ResourceLocation(var7);
               InputStream var9 = Config.getResourceStream(var8);
               if (var9 == null) {
                  break;
               }

               PropertiesOrdered var10 = new PropertiesOrdered();
               var10.load(var9);
               var9.close();
               Config.dbg("CustomSky properties: " + var7);
               String var11 = var4 + var6 + ".png";
               CustomSkyLayer var12 = new CustomSkyLayer(var10, var11);
               if (var12.isValid(var7)) {
                  ResourceLocation var13 = new ResourceLocation(var12.source);
                  ITextureObject var14 = TextureUtils.getTexture(var13);
                  if (var14 == null) {
                     Config.log("CustomSky: Texture not found: " + var13);
                  } else {
                     var12.textureId = var14.getGlTextureId();
                     var5.add(var12);
                     var9.close();
                  }
               }
            } catch (FileNotFoundException var15) {
               break;
            } catch (IOException var16) {
               var16.printStackTrace();
            }
         }

         if (var5.size() > 0) {
            CustomSkyLayer[] var19 = (CustomSkyLayer[])var5.toArray(new CustomSkyLayer[var5.size()]);
            var0[var3] = var19;
            var2 = var3;
         }
      }

      if (var2 < 0) {
         return null;
      } else {
         var3 = var2 + 1;
         CustomSkyLayer[][] var17 = new CustomSkyLayer[var3][0];

         for(int var18 = 0; var18 < var17.length; ++var18) {
            var17[var18] = var0[var18];
         }

         return var17;
      }
   }
}
