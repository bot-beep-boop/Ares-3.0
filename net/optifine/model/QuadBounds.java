package net.optifine.model;

import net.minecraft.util.EnumFacing;

public class QuadBounds {
   private float maxX = -3.4028235E38F;
   private float minY = Float.MAX_VALUE;
   private static int[] $SWITCH_TABLE$net$minecraft$util$EnumFacing;
   private float maxZ = -3.4028235E38F;
   private float minZ = Float.MAX_VALUE;
   private float maxY = -3.4028235E38F;
   private float minX = Float.MAX_VALUE;

   public float getMaxY() {
      return this.maxY;
   }

   public float getMinZ() {
      return this.minZ;
   }

   public boolean isFaceQuad(EnumFacing var1) {
      float var2;
      float var3;
      float var4;
      switch($SWITCH_TABLE$net$minecraft$util$EnumFacing()[var1.ordinal()]) {
      case 1:
         var2 = this.getMinY();
         var3 = this.getMaxY();
         var4 = 0.0F;
         break;
      case 2:
         var2 = this.getMinY();
         var3 = this.getMaxY();
         var4 = 1.0F;
         break;
      case 3:
         var2 = this.getMinZ();
         var3 = this.getMaxZ();
         var4 = 0.0F;
         break;
      case 4:
         var2 = this.getMinZ();
         var3 = this.getMaxZ();
         var4 = 1.0F;
         break;
      case 5:
         var2 = this.getMinX();
         var3 = this.getMaxX();
         var4 = 0.0F;
         break;
      case 6:
         var2 = this.getMinX();
         var3 = this.getMaxX();
         var4 = 1.0F;
         break;
      default:
         return false;
      }

      return var2 == var4 && var3 == var4;
   }

   public float getMinX() {
      return this.minX;
   }

   public float getMaxZ() {
      return this.maxZ;
   }

   public boolean isFullQuad(EnumFacing var1) {
      float var2;
      float var3;
      float var4;
      float var5;
      switch($SWITCH_TABLE$net$minecraft$util$EnumFacing()[var1.ordinal()]) {
      case 1:
      case 2:
         var2 = this.getMinX();
         var3 = this.getMaxX();
         var4 = this.getMinZ();
         var5 = this.getMaxZ();
         break;
      case 3:
      case 4:
         var2 = this.getMinX();
         var3 = this.getMaxX();
         var4 = this.getMinY();
         var5 = this.getMaxY();
         break;
      case 5:
      case 6:
         var2 = this.getMinY();
         var3 = this.getMaxY();
         var4 = this.getMinZ();
         var5 = this.getMaxZ();
         break;
      default:
         return false;
      }

      return var2 == 0.0F && var3 == 1.0F && var4 == 0.0F && var5 == 1.0F;
   }

   public float getMaxX() {
      return this.maxX;
   }

   public QuadBounds(int[] var1) {
      int var2 = var1.length / 4;

      for(int var3 = 0; var3 < 4; ++var3) {
         int var4 = var3 * var2;
         float var5 = Float.intBitsToFloat(var1[var4]);
         float var6 = Float.intBitsToFloat(var1[var4 + 1]);
         float var7 = Float.intBitsToFloat(var1[var4 + 2]);
         if (this.minX > var5) {
            this.minX = var5;
         }

         if (this.minY > var6) {
            this.minY = var6;
         }

         if (this.minZ > var7) {
            this.minZ = var7;
         }

         if (this.maxX < var5) {
            this.maxX = var5;
         }

         if (this.maxY < var6) {
            this.maxY = var6;
         }

         if (this.maxZ < var7) {
            this.maxZ = var7;
         }
      }

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

   public float getMinY() {
      return this.minY;
   }
}
