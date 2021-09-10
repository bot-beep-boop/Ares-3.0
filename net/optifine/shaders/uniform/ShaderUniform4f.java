package net.optifine.shaders.uniform;

import org.lwjgl.opengl.ARBShaderObjects;

public class ShaderUniform4f extends ShaderUniformBase {
   private float[][] programValues;
   private static final float VALUE_UNKNOWN = -3.4028235E38F;

   public float[] getValue() {
      int var1 = this.getProgram();
      float[] var2 = this.programValues[var1];
      return var2;
   }

   protected void onProgramSet(int var1) {
      if (var1 >= this.programValues.length) {
         float[][] var2 = this.programValues;
         float[][] var3 = new float[var1 + 10][];
         System.arraycopy(var2, 0, var3, 0, var2.length);
         this.programValues = var3;
      }

      if (this.programValues[var1] == null) {
         this.programValues[var1] = new float[]{-3.4028235E38F, -3.4028235E38F, -3.4028235E38F, -3.4028235E38F};
      }

   }

   public void setValue(float var1, float var2, float var3, float var4) {
      int var5 = this.getProgram();
      float[] var6 = this.programValues[var5];
      if (var6[0] != var1 || var6[1] != var2 || var6[2] != var3 || var6[3] != var4) {
         var6[0] = var1;
         var6[1] = var2;
         var6[2] = var3;
         var6[3] = var4;
         int var7 = this.getLocation();
         if (var7 >= 0) {
            ARBShaderObjects.glUniform4fARB(var7, var1, var2, var3, var4);
            this.checkGLError();
         }
      }

   }

   protected void resetValue() {
      this.programValues = new float[][]{{-3.4028235E38F, -3.4028235E38F, -3.4028235E38F, -3.4028235E38F}};
   }

   public ShaderUniform4f(String var1) {
      super(var1);
      this.resetValue();
   }
}
