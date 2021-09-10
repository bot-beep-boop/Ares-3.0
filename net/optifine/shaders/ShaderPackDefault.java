package net.optifine.shaders;

import java.io.InputStream;

public class ShaderPackDefault implements IShaderPack {
   public boolean hasDirectory(String var1) {
      return false;
   }

   public void close() {
   }

   public InputStream getResourceAsStream(String var1) {
      return ShaderPackDefault.class.getResourceAsStream(var1);
   }

   public String getName() {
      return "(internal)";
   }
}
