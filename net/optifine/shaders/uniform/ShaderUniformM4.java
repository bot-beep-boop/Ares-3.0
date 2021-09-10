package net.optifine.shaders.uniform;

import java.nio.FloatBuffer;
import org.lwjgl.opengl.ARBShaderObjects;

public class ShaderUniformM4 extends ShaderUniformBase {
   private FloatBuffer matrix;
   private boolean transpose;

   protected void resetValue() {
      this.matrix = null;
   }

   protected void onProgramSet(int var1) {
   }

   public float getValue(int var1, int var2) {
      if (this.matrix == null) {
         return 0.0F;
      } else {
         int var3 = this.transpose ? var2 * 4 + var1 : var1 * 4 + var2;
         float var4 = this.matrix.get(var3);
         return var4;
      }
   }

   public void setValue(boolean var1, FloatBuffer var2) {
      this.transpose = var1;
      this.matrix = var2;
      int var3 = this.getLocation();
      if (var3 >= 0) {
         ARBShaderObjects.glUniformMatrix4ARB(var3, var1, var2);
         this.checkGLError();
      }

   }

   public ShaderUniformM4(String var1) {
      super(var1);
   }
}
