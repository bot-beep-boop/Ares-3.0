package net.minecraft.launchwrapper;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.security.CodeSigner;
import java.security.CodeSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.jar.Attributes.Name;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;

public class LaunchClassLoader extends URLClassLoader {
   private static final Manifest EMPTY = new Manifest();
   private Set<String> classLoaderExceptions = new HashSet();
   private Map<String, byte[]> resourceCache = new ConcurrentHashMap(1000);
   private List<URL> sources;
   private Set<String> invalidClasses = new HashSet(1000);
   private static final boolean DEBUG_FINER;
   private Map<String, Class<?>> cachedClasses = new ConcurrentHashMap();
   private static File tempFolder;
   private static final boolean DEBUG_SAVE;
   private final ThreadLocal<byte[]> loadBuffer = new ThreadLocal();
   private List<IClassTransformer> transformers = new ArrayList(2);
   private ClassLoader parent = this.getClass().getClassLoader();
   private static final boolean DEBUG = Boolean.parseBoolean(System.getProperty("legacy.debugClassLoading", "false"));
   private IClassNameTransformer renameTransformer;
   private Set<String> negativeResourceCache = Collections.newSetFromMap(new ConcurrentHashMap());
   private Set<String> transformerExceptions = new HashSet();
   private static final String[] RESERVED_NAMES = new String[]{"CON", "PRN", "AUX", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};
   private Map<Package, Manifest> packageManifests = new ConcurrentHashMap();
   public static final int BUFFER_SIZE = 4096;

   static {
      DEBUG_FINER = DEBUG && Boolean.parseBoolean(System.getProperty("legacy.debugClassLoadingFiner", "false"));
      DEBUG_SAVE = DEBUG && Boolean.parseBoolean(System.getProperty("legacy.debugClassLoadingSave", "false"));
      tempFolder = null;
   }

   public Class<?> findClass(String var1) throws ClassNotFoundException {
      if (this.invalidClasses.contains(var1)) {
         throw new ClassNotFoundException(var1);
      } else {
         Iterator var3 = this.classLoaderExceptions.iterator();

         String var2;
         while(var3.hasNext()) {
            var2 = (String)var3.next();
            if (var1.startsWith(var2)) {
               return this.parent.loadClass(var1);
            }
         }

         if (this.cachedClasses.containsKey(var1)) {
            return (Class)this.cachedClasses.get(var1);
         } else {
            var3 = this.transformerExceptions.iterator();

            while(var3.hasNext()) {
               var2 = (String)var3.next();
               if (var1.startsWith(var2)) {
                  try {
                     Class var4 = super.findClass(var1);
                     this.cachedClasses.put(var1, var4);
                     return var4;
                  } catch (ClassNotFoundException var14) {
                     this.invalidClasses.add(var1);
                     throw var14;
                  }
               }
            }

            try {
               var2 = this.transformName(var1);
               if (this.cachedClasses.containsKey(var2)) {
                  return (Class)this.cachedClasses.get(var2);
               } else {
                  String var16 = this.untransformName(var1);
                  int var17 = var16.lastIndexOf(46);
                  String var5 = var17 == -1 ? "" : var16.substring(0, var17);
                  String var6 = var16.replace('.', '/').concat(".class");
                  URLConnection var7 = this.findCodeSourceConnectionFor(var6);
                  CodeSigner[] var8 = null;
                  if (var17 > -1 && !var16.startsWith("net.minecraft.")) {
                     if (var7 instanceof JarURLConnection) {
                        JarURLConnection var9 = (JarURLConnection)var7;
                        JarFile var10 = var9.getJarFile();
                        if (var10 != null && var10.getManifest() != null) {
                           Manifest var11 = var10.getManifest();
                           JarEntry var12 = var10.getJarEntry(var6);
                           Package var13 = this.getPackage(var5);
                           this.getClassBytes(var16);
                           var8 = var12.getCodeSigners();
                           if (var13 == null) {
                              var13 = this.definePackage(var5, var11, var9.getJarFileURL());
                              this.packageManifests.put(var13, var11);
                           } else if (var13.isSealed() && !var13.isSealed(var9.getJarFileURL())) {
                              LogWrapper.severe("The jar file %s is trying to seal already secured path %s", var10.getName(), var5);
                           } else if (this.isSealed(var5, var11)) {
                              LogWrapper.severe("The jar file %s has a security seal for path %s, but that path is defined and not secure", var10.getName(), var5);
                           }
                        }
                     } else {
                        Package var18 = this.getPackage(var5);
                        if (var18 == null) {
                           var18 = this.definePackage(var5, (String)null, (String)null, (String)null, (String)null, (String)null, (String)null, (URL)null);
                           this.packageManifests.put(var18, EMPTY);
                        } else if (var18.isSealed()) {
                           LogWrapper.severe("The URL %s is defining elements for sealed path %s", var7.getURL(), var5);
                        }
                     }
                  }

                  byte[] var19 = this.runTransformers(var16, var2, this.getClassBytes(var16));
                  if (DEBUG_SAVE) {
                     this.saveTransformedClass(var19, var2);
                  }

                  CodeSource var20 = var7 == null ? null : new CodeSource(var7.getURL(), var8);
                  Class var21 = this.defineClass(var2, var19, 0, var19.length, var20);
                  this.cachedClasses.put(var2, var21);
                  return var21;
               }
            } catch (Throwable var15) {
               this.invalidClasses.add(var1);
               if (DEBUG) {
                  LogWrapper.log(Level.TRACE, var15, "Exception encountered attempting classloading of %s", var1);
                  LogManager.getLogger("LaunchWrapper").log(Level.ERROR, "Exception encountered attempting classloading of %s", var15);
               }

               throw new ClassNotFoundException(var1, var15);
            }
         }
      }
   }

   public List<URL> getSources() {
      return this.sources;
   }

   private byte[] readFully(InputStream var1) {
      try {
         byte[] var2 = this.getOrCreateBuffer();
         int var4 = 0;

         int var3;
         byte[] var5;
         while((var3 = var1.read(var2, var4, var2.length - var4)) != -1) {
            var4 += var3;
            if (var4 >= var2.length - 1) {
               var5 = new byte[var2.length + 4096];
               System.arraycopy(var2, 0, var5, 0, var2.length);
               var2 = var5;
            }
         }

         var5 = new byte[var4];
         System.arraycopy(var2, 0, var5, 0, var4);
         return var5;
      } catch (Throwable var6) {
         LogWrapper.log(Level.WARN, var6, "Problem loading class");
         return new byte[0];
      }
   }

   private String untransformName(String var1) {
      return this.renameTransformer != null ? this.renameTransformer.unmapClassName(var1) : var1;
   }

   private byte[] getOrCreateBuffer() {
      byte[] var1 = (byte[])this.loadBuffer.get();
      if (var1 == null) {
         this.loadBuffer.set(new byte[4096]);
         var1 = (byte[])this.loadBuffer.get();
      }

      return var1;
   }

   public void clearNegativeEntries(Set<String> var1) {
      this.negativeResourceCache.removeAll(var1);
   }

   private static void closeSilently(Closeable var0) {
      if (var0 != null) {
         try {
            var0.close();
         } catch (IOException var2) {
         }
      }

   }

   public void addURL(URL var1) {
      super.addURL(var1);
      this.sources.add(var1);
   }

   public void addClassLoaderExclusion(String var1) {
      this.classLoaderExceptions.add(var1);
   }

   public byte[] getClassBytes(String var1) throws IOException {
      if (this.negativeResourceCache.contains(var1)) {
         return null;
      } else if (this.resourceCache.containsKey(var1)) {
         return (byte[])this.resourceCache.get(var1);
      } else {
         if (var1.indexOf(46) == -1) {
            String[] var5;
            int var4 = (var5 = RESERVED_NAMES).length;

            for(int var3 = 0; var3 < var4; ++var3) {
               String var2 = var5[var3];
               if (var1.toUpperCase(Locale.ENGLISH).startsWith(var2)) {
                  byte[] var6 = this.getClassBytes("_" + var1);
                  if (var6 != null) {
                     this.resourceCache.put(var1, var6);
                     return var6;
                  }
               }
            }
         }

         InputStream var10 = null;

         byte[] var7;
         try {
            String var11 = var1.replace('.', '/').concat(".class");
            URL var12 = this.findResource(var11);
            if (var12 == null) {
               if (DEBUG) {
                  LogWrapper.finest("Failed to find class resource %s", var11);
               }

               this.negativeResourceCache.add(var1);
               return null;
            }

            var10 = var12.openStream();
            if (DEBUG) {
               LogWrapper.finest("Loading class %s from resource %s", var1, var12.toString());
            }

            byte[] var13 = this.readFully(var10);
            this.resourceCache.put(var1, var13);
            var7 = var13;
         } finally {
            closeSilently(var10);
         }

         return var7;
      }
   }

   private boolean isSealed(String var1, Manifest var2) {
      Attributes var3 = var2.getAttributes(var1);
      String var4 = null;
      if (var3 != null) {
         var4 = var3.getValue(Name.SEALED);
      }

      if (var4 == null) {
         var3 = var2.getMainAttributes();
         if (var3 != null) {
            var4 = var3.getValue(Name.SEALED);
         }
      }

      return "true".equalsIgnoreCase(var4);
   }

   public List<IClassTransformer> getTransformers() {
      return Collections.unmodifiableList(this.transformers);
   }

   private void saveTransformedClass(byte[] var1, String var2) {
      if (tempFolder != null) {
         File var3 = new File(tempFolder, var2.replace('.', File.separatorChar) + ".class");
         File var4 = var3.getParentFile();
         if (!var4.exists()) {
            var4.mkdirs();
         }

         if (var3.exists()) {
            var3.delete();
         }

         try {
            LogWrapper.fine("Saving transformed class \"%s\" to \"%s\"", var2, var3.getAbsolutePath().replace('\\', '/'));
            FileOutputStream var5 = new FileOutputStream(var3);
            var5.write(var1);
            var5.close();
         } catch (IOException var6) {
            LogWrapper.log((Level)Level.WARN, (Throwable)var6, "Could not save transformed class \"%s\"", var2);
         }

      }
   }

   public LaunchClassLoader(URL[] var1) {
      super(var1, (ClassLoader)null);
      this.sources = new ArrayList(Arrays.asList(var1));
      this.addClassLoaderExclusion("java.");
      this.addClassLoaderExclusion("sun.");
      this.addClassLoaderExclusion("org.lwjgl.");
      this.addClassLoaderExclusion("org.apache.logging.");
      this.addClassLoaderExclusion("net.minecraft.launchwrapper.");
      this.addTransformerExclusion("javax.");
      this.addTransformerExclusion("argo.");
      this.addTransformerExclusion("org.objectweb.asm.");
      this.addTransformerExclusion("com.google.common.");
      this.addTransformerExclusion("org.bouncycastle.");
      this.addTransformerExclusion("net.minecraft.launchwrapper.injector.");
      if (DEBUG_SAVE) {
         int var2 = 1;

         for(tempFolder = new File(Launch.minecraftHome, "CLASSLOADER_TEMP"); tempFolder.exists() && var2 <= 10; tempFolder = new File(Launch.minecraftHome, "CLASSLOADER_TEMP" + var2++)) {
         }

         if (tempFolder.exists()) {
            LogWrapper.info("DEBUG_SAVE enabled, but 10 temp directories already exist, clean them and try again.");
            tempFolder = null;
         } else {
            LogWrapper.info("DEBUG_SAVE Enabled, saving all classes to \"%s\"", tempFolder.getAbsolutePath().replace('\\', '/'));
            tempFolder.mkdirs();
         }
      }

   }

   private URLConnection findCodeSourceConnectionFor(String var1) {
      URL var2 = this.findResource(var1);
      if (var2 != null) {
         try {
            return var2.openConnection();
         } catch (IOException var4) {
            throw new RuntimeException(var4);
         }
      } else {
         return null;
      }
   }

   private byte[] runTransformers(String var1, String var2, byte[] var3) {
      IClassTransformer var4;
      Iterator var5;
      if (DEBUG_FINER) {
         LogWrapper.finest("Beginning transform of {%s (%s)} Start Length: %d", var1, var2, var3 == null ? 0 : var3.length);
         var5 = this.transformers.iterator();

         while(var5.hasNext()) {
            var4 = (IClassTransformer)var5.next();
            String var6 = var4.getClass().getName();
            LogWrapper.finest("Before Transformer {%s (%s)} %s: %d", var1, var2, var6, var3 == null ? 0 : var3.length);
            var3 = var4.transform(var1, var2, var3);
            LogWrapper.finest("After  Transformer {%s (%s)} %s: %d", var1, var2, var6, var3 == null ? 0 : var3.length);
         }

         LogWrapper.finest("Ending transform of {%s (%s)} Start Length: %d", var1, var2, var3 == null ? 0 : var3.length);
      } else {
         for(var5 = this.transformers.iterator(); var5.hasNext(); var3 = var4.transform(var1, var2, var3)) {
            var4 = (IClassTransformer)var5.next();
         }
      }

      return var3;
   }

   public void registerTransformer(String var1) {
      try {
         IClassTransformer var2 = (IClassTransformer)this.loadClass(var1).newInstance();
         this.transformers.add(var2);
         if (var2 instanceof IClassNameTransformer && this.renameTransformer == null) {
            this.renameTransformer = (IClassNameTransformer)var2;
         }
      } catch (Exception var3) {
         LogWrapper.log((Level)Level.ERROR, (Throwable)var3, "A critical problem occurred registering the ASM transformer class %s", var1);
      }

   }

   private String transformName(String var1) {
      return this.renameTransformer != null ? this.renameTransformer.remapClassName(var1) : var1;
   }

   public void addTransformerExclusion(String var1) {
      this.transformerExceptions.add(var1);
   }
}
