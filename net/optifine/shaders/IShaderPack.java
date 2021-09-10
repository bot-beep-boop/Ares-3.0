package net.optifine.shaders;

import java.io.InputStream;

public interface IShaderPack {
   void close();

   boolean hasDirectory(String var1);

   String getName();

   InputStream getResourceAsStream(String var1);
}
