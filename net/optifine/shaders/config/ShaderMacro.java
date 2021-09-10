package net.optifine.shaders.config;

public class ShaderMacro {
   private String name;
   private String value;

   public String getSourceLine() {
      return "#define " + this.name + " " + this.value;
   }

   public ShaderMacro(String var1, String var2) {
      this.name = var1;
      this.value = var2;
   }

   public String toString() {
      return this.getSourceLine();
   }

   public String getValue() {
      return this.value;
   }

   public String getName() {
      return this.name;
   }
}
