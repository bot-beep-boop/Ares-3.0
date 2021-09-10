package net.java.games.input;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

class PluginClassLoader extends ClassLoader {
   private static final FileFilter JAR_FILTER;
   private static String pluginDirectory;
   static final boolean $assertionsDisabled;
   static Class class$net$java$games$input$PluginClassLoader;

   public PluginClassLoader() {
      super(Thread.currentThread().getContextClassLoader());
   }

   private byte[] loadClassFromDirectory(String var1) throws IOException, ClassNotFoundException {
      StringTokenizer var2 = new StringTokenizer(var1, ".");
      StringBuffer var3 = new StringBuffer(pluginDirectory);

      while(var2.hasMoreTokens()) {
         var3.append(File.separator);
         var3.append(var2.nextToken());
      }

      var3.append(".class");
      File var4 = new File(var3.toString());
      if (!var4.exists()) {
         throw new ClassNotFoundException(var1);
      } else {
         FileInputStream var5 = new FileInputStream(var4);
         if (!$assertionsDisabled && var4.length() > 2147483647L) {
            throw new AssertionError();
         } else {
            int var6 = (int)var4.length();
            byte[] var7 = new byte[var6];
            int var8 = var5.read(var7);
            if (!$assertionsDisabled && var6 != var8) {
               throw new AssertionError();
            } else {
               return var7;
            }
         }
      }
   }

   protected Class findClass(String var1) throws ClassNotFoundException {
      byte[] var2 = this.loadClassData(var1);
      return this.defineClass(var1, var2, 0, var2.length);
   }

   private byte[] loadClassData(String var1) throws ClassNotFoundException {
      if (pluginDirectory == null) {
         pluginDirectory = DefaultControllerEnvironment.libPath + File.separator + "controller";
      }

      try {
         return this.loadClassFromDirectory(var1);
      } catch (Exception var5) {
         try {
            return this.loadClassFromJAR(var1);
         } catch (IOException var4) {
            throw new ClassNotFoundException(var1, var4);
         }
      }
   }

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
   }

   static {
      $assertionsDisabled = !(class$net$java$games$input$PluginClassLoader == null ? (class$net$java$games$input$PluginClassLoader = class$("net.java.games.input.PluginClassLoader")) : class$net$java$games$input$PluginClassLoader).desiredAssertionStatus();
      JAR_FILTER = new PluginClassLoader.JarFileFilter();
   }

   private byte[] loadClassFromJAR(String var1) throws IOException, ClassNotFoundException {
      File var2 = new File(pluginDirectory);
      File[] var3 = var2.listFiles(JAR_FILTER);
      if (var3 == null) {
         throw new ClassNotFoundException("Could not find class " + var1);
      } else {
         for(int var4 = 0; var4 < var3.length; ++var4) {
            JarFile var5 = new JarFile(var3[var4]);
            JarEntry var6 = var5.getJarEntry(var1 + ".class");
            if (var6 != null) {
               InputStream var7 = var5.getInputStream(var6);
               if (!$assertionsDisabled && var6.getSize() > 2147483647L) {
                  throw new AssertionError();
               }

               int var8 = (int)var6.getSize();
               if (!$assertionsDisabled && var8 < 0) {
                  throw new AssertionError();
               }

               byte[] var9 = new byte[var8];
               int var10 = var7.read(var9);
               if (!$assertionsDisabled && var8 != var10) {
                  throw new AssertionError();
               }

               return var9;
            }
         }

         throw new FileNotFoundException(var1);
      }
   }

   private static class JarFileFilter implements FileFilter {
      JarFileFilter(Object var1) {
         this();
      }

      private JarFileFilter() {
      }

      public boolean accept(File var1) {
         return var1.getName().toUpperCase().endsWith(".JAR");
      }
   }
}
