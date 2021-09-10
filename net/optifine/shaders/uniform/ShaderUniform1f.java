package net.optifine.shaders.uniform;

import org.lwjgl.opengl.ARBShaderObjects;

public class ShaderUniform1f extends ShaderUniformBase {
   private static final float VALUE_UNKNOWN = -3.4028235E38F;
   private float[] programValues;

   public float getValue() {
      int var1 = this.getProgram();
      float var2 = this.programValues[var1];
      return var2;
   }

   public ShaderUniform1f(String var1) {
      super(var1);
      this.resetValue();
   }

   protected void resetValue() {
      this.programValues = new float[]{-3.4028235E38F};
   }

   public void setValue(float var1) {
      int var2 = this.getProgram();
      float var3 = this.programValues[var2];
      if (var1 != var3) {
         this.programValues[var2] = var1;
         int var4 = this.getLocation();
         if (var4 >= 0) {
            ARBShaderObjects.glUniform1fARB(var4, var1);
            this.checkGLError();
         }
      }

   }

   protected void onProgramSet(int var1) {
      if (var1 >= this.programValues.length) {
         float[] var2 = this.programValues;
         float[] var3 = new float[var1 + 10];
         System.arraycopy(var2, 0, var3, 0, var2.length);

         for(int var4 = var2.length; var4 < var3.length; ++var4) {
            var3[var4] = -3.4028235E38F;
         }

         this.programValues = var3;
      }

   }
}
