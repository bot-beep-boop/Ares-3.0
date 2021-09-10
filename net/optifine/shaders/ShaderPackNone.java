package net.optifine.shaders;

import java.io.InputStream;

public class ShaderPackNone implements IShaderPack {
   public boolean hasDirectory(String var1) {
      return false;
   }

   public InputStream getResourceAsStream(String var1) {
      return null;
   }

   public String getName() {
      return "OFF";
   }

   public void close() {
   }
}
