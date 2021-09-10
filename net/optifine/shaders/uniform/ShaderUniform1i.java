package net.optifine.shaders.uniform;

import org.lwjgl.opengl.ARBShaderObjects;

public class ShaderUniform1i extends ShaderUniformBase {
   private int[] programValues;
   private static final int VALUE_UNKNOWN = Integer.MIN_VALUE;

   public void setValue(int var1) {
      int var2 = this.getProgram();
      int var3 = this.programValues[var2];
      if (var1 != var3) {
         this.programValues[var2] = var1;
         int var4 = this.getLocation();
         if (var4 >= 0) {
            ARBShaderObjects.glUniform1iARB(var4, var1);
            this.checkGLError();
         }
      }

   }

   protected void resetValue() {
      this.programValues = new int[]{Integer.MIN_VALUE};
   }

   public ShaderUniform1i(String var1) {
      super(var1);
      this.resetValue();
   }

   public int getValue() {
      int var1 = this.getProgram();
      int var2 = this.programValues[var1];
      return var2;
   }

   protected void onProgramSet(int var1) {
      if (var1 >= this.programValues.length) {
         int[] var2 = this.programValues;
         int[] var3 = new int[var1 + 10];
         System.arraycopy(var2, 0, var3, 0, var2.length);

         for(int var4 = var2.length; var4 < var3.length; ++var4) {
            var3[var4] = Integer.MIN_VALUE;
         }

         this.programValues = var3;
      }

   }
}
