package net.minecraft.client.renderer.block.model;

import java.util.Arrays;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;

public class BreakingFour extends BakedQuad {
   private static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
   private final TextureAtlasSprite texture;

   public BreakingFour(BakedQuad var1, TextureAtlasSprite var2) {
      super(Arrays.copyOf(var1.getVertexData(), var1.getVertexData().length), var1.tintIndex, FaceBakery.getFacingFromVertexData(var1.getVertexData()));
      this.texture = var2;
      this.remapQuad();
      this.fixVertexData();
   }

   private void remapQuad() {
      for(int var1 = 0; var1 < 4; ++var1) {
         this.remapVert(var1);
      }

   }

   private void remapVert(int var1) {
      int var2 = this.vertexData.length / 4;
      int var3 = var2 * var1;
      float var4 = Float.intBitsToFloat(this.vertexData[var3]);
      float var5 = Float.intBitsToFloat(this.vertexData[var3 + 1]);
      float var6 = Float.intBitsToFloat(this.vertexData[var3 + 2]);
      float var7 = 0.0F;
      float var8 = 0.0F;
      switch($SWITCH_TABLE$net$minecraft$util$EnumFacing()[this.face.ordinal()]) {
      case 1:
         var7 = var4 * 16.0F;
         var8 = (1.0F - var6) * 16.0F;
         break;
      case 2:
         var7 = var4 * 16.0F;
         var8 = var6 * 16.0F;
         break;
      case 3:
         var7 = (1.0F - var4) * 16.0F;
         var8 = (1.0F - var5) * 16.0F;
         break;
      case 4:
         var7 = var4 * 16.0F;
         var8 = (1.0F - var5) * 16.0F;
         break;
      case 5:
         var7 = var6 * 16.0F;
         var8 = (1.0F - var5) * 16.0F;
         break;
      case 6:
         var7 = (1.0F - var6) * 16.0F;
         var8 = (1.0F - var5) * 16.0F;
      }

      this.vertexData[var3 + 4] = Float.floatToRawIntBits(this.texture.getInterpolatedU((double)var7));
      this.vertexData[var3 + 4 + 1] = Float.floatToRawIntBits(this.texture.getInterpolatedV((double)var8));
   }

   static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing() {
      int[] var10000 = $SWITCH_TABLE$net$minecraft$util$EnumFacing;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[EnumFacing.values().length];

         try {
            var0[EnumFacing.DOWN.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[EnumFacing.EAST.ordinal()] = 6;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[EnumFacing.NORTH.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[EnumFacing.SOUTH.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[EnumFacing.UP.ordinal()] = 2;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[EnumFacing.WEST.ordinal()] = 5;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$minecraft$util$EnumFacing = var0;
         return var0;
      }
   }
}
