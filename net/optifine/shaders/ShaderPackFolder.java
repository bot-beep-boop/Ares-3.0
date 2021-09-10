package net.optifine.shaders;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import net.optifine.util.StrUtils;

public class ShaderPackFolder implements IShaderPack {
   protected File packFile;

   public ShaderPackFolder(String var1, File var2) {
      this.packFile = var2;
   }

   public String getName() {
      return this.packFile.getName();
   }

   public InputStream getResourceAsStream(String var1) {
      try {
         String var2 = StrUtils.removePrefixSuffix(var1, "/", "/");
         File var3 = new File(this.packFile, var2);
         return !var3.exists() ? null : new BufferedInputStream(new FileInputStream(var3));
      } catch (Exception var4) {
         return null;
      }
   }

   public void close() {
   }

   public boolean hasDirectory(String var1) {
      File var2 = new File(this.packFile, var1.substring(1));
      return !var2.exists() ? false : var2.isDirectory();
   }
}
