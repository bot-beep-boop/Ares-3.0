package net.optifine.shaders.uniform;

import java.util.Arrays;
import net.optifine.shaders.Shaders;
import org.lwjgl.opengl.ARBShaderObjects;

public abstract class ShaderUniformBase {
   private static final int LOCATION_UNDEFINED = -1;
   private static final int LOCATION_UNKNOWN = Integer.MIN_VALUE;
   private int program = 0;
   private String name;
   private int[] locations = new int[]{-1};

   public int getLocation() {
      if (this.program <= 0) {
         return -1;
      } else {
         int var1 = this.locations[this.program];
         if (var1 == Integer.MIN_VALUE) {
            var1 = ARBShaderObjects.glGetUniformLocationARB(this.program, this.name);
            this.locations[this.program] = var1;
         }

         return var1;
      }
   }

   protected void checkGLError() {
      if (Shaders.checkGLError(this.name) != 0) {
         this.disable();
      }

   }

   public boolean isDefined() {
      return this.getLocation() >= 0;
   }

   public String toString() {
      return this.name;
   }

   public void reset() {
      this.program = 0;
      this.locations = new int[]{-1};
      this.resetValue();
   }

   public int getProgram() {
      return this.program;
   }

   public void disable() {
      this.locations[this.program] = -1;
   }

   protected abstract void resetValue();

   public ShaderUniformBase(String var1) {
      this.name = var1;
   }

   private void expandLocations() {
      if (this.program >= this.locations.length) {
         int[] var1 = new int[this.program * 2];
         Arrays.fill(var1, Integer.MIN_VALUE);
         System.arraycopy(this.locations, 0, var1, 0, this.locations.length);
         this.locations = var1;
      }

   }

   protected abstract void onProgramSet(int var1);

   public void setProgram(int var1) {
      if (this.program != var1) {
         this.program = var1;
         this.expandLocations();
         this.onProgramSet(var1);
      }

   }

   public String getName() {
      return this.name;
   }
}
