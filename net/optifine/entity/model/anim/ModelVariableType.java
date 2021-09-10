package net.optifine.entity.model.anim;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.src.Config;

public enum ModelVariableType {
   SCALE_Y("sy");

   private static int[] $SWITCH_TABLE$net$optifine$entity$model$anim$ModelVariableType;
   private String name;
   POS_Y("ty"),
   SCALE_X("sx"),
   ANGLE_Z("rz"),
   POS_Z("tz");

   public static ModelVariableType[] VALUES = values();
   POS_X("tx"),
   ANGLE_Y("ry"),
   OFFSET_X("ox"),
   OFFSET_Y("oy");

   private static final ModelVariableType[] ENUM$VALUES = new ModelVariableType[]{POS_X, POS_Y, POS_Z, ANGLE_X, ANGLE_Y, ANGLE_Z, OFFSET_X, OFFSET_Y, OFFSET_Z, SCALE_X, SCALE_Y, SCALE_Z};
   SCALE_Z("sz"),
   ANGLE_X("rx"),
   OFFSET_Z("oz");

   static int[] $SWITCH_TABLE$net$optifine$entity$model$anim$ModelVariableType() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$entity$model$anim$ModelVariableType;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[values().length];

         try {
            var0[ANGLE_X.ordinal()] = 4;
         } catch (NoSuchFieldError var12) {
         }

         try {
            var0[ANGLE_Y.ordinal()] = 5;
         } catch (NoSuchFieldError var11) {
         }

         try {
            var0[ANGLE_Z.ordinal()] = 6;
         } catch (NoSuchFieldError var10) {
         }

         try {
            var0[OFFSET_X.ordinal()] = 7;
         } catch (NoSuchFieldError var9) {
         }

         try {
            var0[OFFSET_Y.ordinal()] = 8;
         } catch (NoSuchFieldError var8) {
         }

         try {
            var0[OFFSET_Z.ordinal()] = 9;
         } catch (NoSuchFieldError var7) {
         }

         try {
            var0[POS_X.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[POS_Y.ordinal()] = 2;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[POS_Z.ordinal()] = 3;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[SCALE_X.ordinal()] = 10;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[SCALE_Y.ordinal()] = 11;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[SCALE_Z.ordinal()] = 12;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$entity$model$anim$ModelVariableType = var0;
         return var0;
      }
   }

   private ModelVariableType(String var3) {
      this.name = var3;
   }

   public void setFloat(ModelRenderer var1, float var2) {
      switch($SWITCH_TABLE$net$optifine$entity$model$anim$ModelVariableType()[this.ordinal()]) {
      case 1:
         var1.rotationPointX = var2;
         return;
      case 2:
         var1.rotationPointY = var2;
         return;
      case 3:
         var1.rotationPointZ = var2;
         return;
      case 4:
         var1.rotateAngleX = var2;
         return;
      case 5:
         var1.rotateAngleY = var2;
         return;
      case 6:
         var1.rotateAngleZ = var2;
         return;
      case 7:
         var1.offsetX = var2;
         return;
      case 8:
         var1.offsetY = var2;
         return;
      case 9:
         var1.offsetZ = var2;
         return;
      case 10:
         var1.scaleX = var2;
         return;
      case 11:
         var1.scaleY = var2;
         return;
      case 12:
         var1.scaleZ = var2;
         return;
      default:
         Config.warn("SetFloat not supported for: " + this);
      }
   }

   public float getFloat(ModelRenderer var1) {
      switch($SWITCH_TABLE$net$optifine$entity$model$anim$ModelVariableType()[this.ordinal()]) {
      case 1:
         return var1.rotationPointX;
      case 2:
         return var1.rotationPointY;
      case 3:
         return var1.rotationPointZ;
      case 4:
         return var1.rotateAngleX;
      case 5:
         return var1.rotateAngleY;
      case 6:
         return var1.rotateAngleZ;
      case 7:
         return var1.offsetX;
      case 8:
         return var1.offsetY;
      case 9:
         return var1.offsetZ;
      case 10:
         return var1.scaleX;
      case 11:
         return var1.scaleY;
      case 12:
         return var1.scaleZ;
      default:
         Config.warn("GetFloat not supported for: " + this);
         return 0.0F;
      }
   }

   public static ModelVariableType parse(String var0) {
      for(int var1 = 0; var1 < VALUES.length; ++var1) {
         ModelVariableType var2 = VALUES[var1];
         if (var2.getName().equals(var0)) {
            return var2;
         }
      }

      return null;
   }

   public String getName() {
      return this.name;
   }
}
