package net.optifine.shaders.uniform;

import net.optifine.expr.ExpressionType;
import net.optifine.expr.IExpression;
import net.optifine.expr.IExpressionBool;
import net.optifine.expr.IExpressionFloat;
import net.optifine.expr.IExpressionFloatArray;

public enum UniformType {
   VEC4,
   VEC2,
   BOOL;

   private static final UniformType[] ENUM$VALUES = new UniformType[]{BOOL, INT, FLOAT, VEC2, VEC3, VEC4};
   FLOAT,
   INT;

   private static int[] $SWITCH_TABLE$net$optifine$shaders$uniform$UniformType;
   VEC3;

   private void updateUniformFloat3(IExpressionFloatArray var1, ShaderUniform3f var2) {
      float[] var3 = var1.eval();
      if (var3.length != 3) {
         throw new RuntimeException("Value length is not 3, length: " + var3.length);
      } else {
         var2.setValue(var3[0], var3[1], var3[2]);
      }
   }

   private void updateUniformFloat(IExpressionFloat var1, ShaderUniform1f var2) {
      float var3 = var1.eval();
      var2.setValue(var3);
   }

   public ShaderUniformBase makeShaderUniform(String var1) {
      switch($SWITCH_TABLE$net$optifine$shaders$uniform$UniformType()[this.ordinal()]) {
      case 1:
         return new ShaderUniform1i(var1);
      case 2:
         return new ShaderUniform1i(var1);
      case 3:
         return new ShaderUniform1f(var1);
      case 4:
         return new ShaderUniform2f(var1);
      case 5:
         return new ShaderUniform3f(var1);
      case 6:
         return new ShaderUniform4f(var1);
      default:
         throw new RuntimeException("Unknown uniform type: " + this);
      }
   }

   public void updateUniform(IExpression var1, ShaderUniformBase var2) {
      switch($SWITCH_TABLE$net$optifine$shaders$uniform$UniformType()[this.ordinal()]) {
      case 1:
         this.updateUniformBool((IExpressionBool)var1, (ShaderUniform1i)var2);
         return;
      case 2:
         this.updateUniformInt((IExpressionFloat)var1, (ShaderUniform1i)var2);
         return;
      case 3:
         this.updateUniformFloat((IExpressionFloat)var1, (ShaderUniform1f)var2);
         return;
      case 4:
         this.updateUniformFloat2((IExpressionFloatArray)var1, (ShaderUniform2f)var2);
         return;
      case 5:
         this.updateUniformFloat3((IExpressionFloatArray)var1, (ShaderUniform3f)var2);
         return;
      case 6:
         this.updateUniformFloat4((IExpressionFloatArray)var1, (ShaderUniform4f)var2);
         return;
      default:
         throw new RuntimeException("Unknown uniform type: " + this);
      }
   }

   public static UniformType parse(String var0) {
      UniformType[] var1 = values();

      for(int var2 = 0; var2 < var1.length; ++var2) {
         UniformType var3 = var1[var2];
         if (var3.name().toLowerCase().equals(var0)) {
            return var3;
         }
      }

      return null;
   }

   private void updateUniformFloat2(IExpressionFloatArray var1, ShaderUniform2f var2) {
      float[] var3 = var1.eval();
      if (var3.length != 2) {
         throw new RuntimeException("Value length is not 2, length: " + var3.length);
      } else {
         var2.setValue(var3[0], var3[1]);
      }
   }

   private void updateUniformBool(IExpressionBool var1, ShaderUniform1i var2) {
      boolean var3 = var1.eval();
      int var4 = var3 ? 1 : 0;
      var2.setValue(var4);
   }

   private void updateUniformInt(IExpressionFloat var1, ShaderUniform1i var2) {
      int var3 = (int)var1.eval();
      var2.setValue(var3);
   }

   static int[] $SWITCH_TABLE$net$optifine$shaders$uniform$UniformType() {
      int[] var10000 = $SWITCH_TABLE$net$optifine$shaders$uniform$UniformType;
      if (var10000 != null) {
         return var10000;
      } else {
         int[] var0 = new int[values().length];

         try {
            var0[BOOL.ordinal()] = 1;
         } catch (NoSuchFieldError var6) {
         }

         try {
            var0[FLOAT.ordinal()] = 3;
         } catch (NoSuchFieldError var5) {
         }

         try {
            var0[INT.ordinal()] = 2;
         } catch (NoSuchFieldError var4) {
         }

         try {
            var0[VEC2.ordinal()] = 4;
         } catch (NoSuchFieldError var3) {
         }

         try {
            var0[VEC3.ordinal()] = 5;
         } catch (NoSuchFieldError var2) {
         }

         try {
            var0[VEC4.ordinal()] = 6;
         } catch (NoSuchFieldError var1) {
         }

         $SWITCH_TABLE$net$optifine$shaders$uniform$UniformType = var0;
         return var0;
      }
   }

   private void updateUniformFloat4(IExpressionFloatArray var1, ShaderUniform4f var2) {
      float[] var3 = var1.eval();
      if (var3.length != 4) {
         throw new RuntimeException("Value length is not 4, length: " + var3.length);
      } else {
         var2.setValue(var3[0], var3[1], var3[2], var3[3]);
      }
   }

   public boolean matchesExpressionType(ExpressionType var1) {
      switch($SWITCH_TABLE$net$optifine$shaders$uniform$UniformType()[this.ordinal()]) {
      case 1:
         if (var1 == ExpressionType.BOOL) {
            return true;
         }

         return false;
      case 2:
         if (var1 == ExpressionType.FLOAT) {
            return true;
         }

         return false;
      case 3:
         if (var1 == ExpressionType.FLOAT) {
            return true;
         }

         return false;
      case 4:
      case 5:
      case 6:
         if (var1 == ExpressionType.FLOAT_ARRAY) {
            return true;
         }

         return false;
      default:
         throw new RuntimeException("Unknown uniform type: " + this);
      }
   }
}
