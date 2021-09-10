package net.minecraft.client.renderer;

import java.nio.ByteBuffer;
import java.util.List;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraft.src.Config;
import net.optifine.reflect.Reflector;
import net.optifine.shaders.SVertexBuilder;
import org.lwjgl.opengl.GL11;

public class WorldVertexBufferUploader {
   private static int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;

   public void draw(WorldRenderer var1) {
      if (var1.getVertexCount() > 0) {
         if (var1.getDrawMode() == 7 && Config.isQuadsToTriangles()) {
            var1.quadsToTriangles();
         }

         VertexFormat var2 = var1.getVertexFormat();
         int var3 = var2.getNextOffset();
         ByteBuffer var4 = var1.getByteBuffer();
         List var5 = var2.getElements();
         boolean var6 = Reflector.ForgeVertexFormatElementEnumUseage_preDraw.exists();
         boolean var7 = Reflector.ForgeVertexFormatElementEnumUseage_postDraw.exists();

         int var8;
         int var12;
         for(var8 = 0; var8 < var5.size(); ++var8) {
            VertexFormatElement var9 = (VertexFormatElement)var5.get(var8);
            VertexFormatElement.EnumUsage var10 = var9.getUsage();
            if (var6) {
               Reflector.callVoid(var10, Reflector.ForgeVertexFormatElementEnumUseage_preDraw, var2, var8, var3, var4);
            } else {
               int var11 = var9.getType().getGlConstant();
               var12 = var9.getIndex();
               var4.position(var2.getOffset(var8));
               switch($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[var10.ordinal()]) {
               case 1:
                  GL11.glVertexPointer(var9.getElementCount(), var11, var3, var4);
                  GL11.glEnableClientState(32884);
                  break;
               case 2:
                  GL11.glNormalPointer(var11, var3, var4);
                  GL11.glEnableClientState(32885);
                  break;
               case 3:
                  GL11.glColorPointer(var9.getElementCount(), var11, var3, var4);
                  GL11.glEnableClientState(32886);
                  break;
               case 4:
                  OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + var12);
                  GL11.glTexCoordPointer(var9.getElementCount(), var11, var3, var4);
                  GL11.glEnableClientState(32888);
                  OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
               }
            }
         }

         if (var1.isMultiTexture()) {
            var1.drawMultiTexture();
         } else if (Config.isShaders()) {
            SVertexBuilder.drawArrays(var1.getDrawMode(), 0, var1.getVertexCount(), var1);
         } else {
            GL11.glDrawArrays(var1.getDrawMode(), 0, var1.getVertexCount());
         }

         var8 = 0;

         for(int var13 = var5.size(); var8 < var13; ++var8) {
            VertexFormatElement var14 = (VertexFormatElement)var5.get(var8);
            VertexFormatElement.EnumUsage var15 = var14.getUsage();
            if (var7) {
               Reflector.callVoid(var15, Reflector.ForgeVertexFormatElementEnumUseage_postDraw, var2, var8, var3, var4);
            } else {
               var12 = var14.getIndex();
               switch($SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage()[var15.ordinal()]) {
               case 1:
                  GL11.glDisableClientState(32884);
                  break;
               case 2:
                  GL11.glDisableClientState(32885);
                  break;
               case 3:
                  GL11.glDisableClientState(32886);
                  GlStateManager.resetColor();
                  break;
               case 4:
                  OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit + var12);
                  GL11.glDisableClientState(32888);
                  OpenGlHelper.setClientActiveTexture(OpenGlHelper.defaultTexUnit);
               }
            }
         }
      }

      var1.reset();
   }

   static int[] $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[VertexFormatElement.EnumUsage.values().length];

         try {
            var0[VertexFormatElement.EnumUsage.BLEND_WEIGHT.ordinal()] = 6;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.COLOR.ordinal()] = 3;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.MATRIX.ordinal()] = 5;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.NORMAL.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.PADDING.ordinal()] = 7;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.POSITION.ordinal()] = 1;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[VertexFormatElement.EnumUsage.UV.ordinal()] = 4;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$client$renderer$vertex$VertexFormatElement$EnumUsage = var0;
         return var0;
      }
   }
}
