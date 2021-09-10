package net.java.games.util.plugins;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class PluginLoader extends URLClassLoader {
   boolean localDLLs = true;
   static Class class$net$java$games$util$plugins$Plugin;
   File parentDir;
   static final boolean DEBUG = false;

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   protected String findLibrary(String var1) {
      if (this.localDLLs) {
         String var2 = this.parentDir.getPath() + File.separator + System.mapLibraryName(var1);
         return var2;
      } else {
         return super.findLibrary(var1);
      }
   }

   public PluginLoader(File var1) throws MalformedURLException {
      super(new URL[]{var1.toURL()}, Thread.currentThread().getContextClassLoader());
      this.parentDir = var1.getParentFile();
      if (System.getProperty("net.java.games.util.plugins.nolocalnative") != null) {
         this.localDLLs = false;
      }

   }

   private boolean classImplementsPlugin(Class var1) {
      if (var1 == null) {
         return false;
      } else {
         Class[] var2 = var1.getInterfaces();

         int var3;
         for(var3 = 0; var3 < var2.length; ++var3) {
            if (var2[var3] == (class$net$java$games$util$plugins$Plugin == null ? (class$net$java$games$util$plugins$Plugin = class$("net.java.games.util.plugins.Plugin")) : class$net$java$games$util$plugins$Plugin)) {
               return true;
            }
         }

         for(var3 = 0; var3 < var2.length; ++var3) {
            if (this.classImplementsPlugin(var2[var3])) {
               return true;
            }
         }

         return this.classImplementsPlugin(var1.getSuperclass());
      }
   }

   public boolean attemptPluginDefine(Class var1) {
      return !var1.isInterface() && this.classImplementsPlugin(var1);
   }
}
