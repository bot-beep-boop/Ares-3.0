package net.optifine.shaders.config;

public class ScreenShaderOptions {
   private String name;
   private ShaderOption[] shaderOptions;
   private int columns;

   public String getName() {
      return this.name;
   }

   public ScreenShaderOptions(String var1, ShaderOption[] var2, int var3) {
      this.name = var1;
      this.shaderOptions = var2;
      this.columns = var3;
   }

   public ShaderOption[] getShaderOptions() {
      return this.shaderOptions;
   }

   public int getColumns() {
      return this.columns;
   }
}
