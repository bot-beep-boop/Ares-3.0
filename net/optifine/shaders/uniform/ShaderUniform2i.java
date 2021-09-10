package net.optifine.shaders.uniform;

import org.lwjgl.opengl.ARBShaderObjects;

public class ShaderUniform2i extends ShaderUniformBase {
   private int[][] programValues;
   private static final int VALUE_UNKNOWN = Integer.MIN_VALUE;

   public void setValue(int var1, int var2) {
      int var3 = this.getProgram();
      int[] var4 = this.programValues[var3];
      if (var4[0] != var1 || var4[1] != var2) {
         var4[0] = var1;
         var4[1] = var2;
         int var5 = this.getLocation();
         if (var5 >= 0) {
            ARBShaderObjects.glUniform2iARB(var5, var1, var2);
            this.checkGLError();
         }
      }

   }

   protected void resetValue() {
      this.programValues = new int[][]{{Integer.MIN_VALUE, Integer.MIN_VALUE}};
   }

   public ShaderUniform2i(String var1) {
      super(var1);
      this.resetValue();
   }

   public int[] getValue() {
      int var1 = this.getProgram();
      int[] var2 = this.programValues[var1];
      return var2;
   }

   protected void onProgramSet(int var1) {
      if (var1 >= this.programValues.length) {
         int[][] var2 = this.programValues;
         int[][] var3 = new int[var1 + 10][];
         System.arraycopy(var2, 0, var3, 0, var2.length);
         this.programValues = var3;
      }

      if (this.programValues[var1] == null) {
         this.programValues[var1] = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
      }

   }
}
