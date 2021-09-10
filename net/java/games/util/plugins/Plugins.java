package net.java.games.util.plugins;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Plugins {
   static final boolean DEBUG = true;
   List pluginList = new ArrayList();

   private boolean classExtends(Class var1, Class var2) {
      if (var1 == null) {
         return false;
      } else {
         return var1 == var2 ? true : this.classExtends(var1.getSuperclass(), var2);
      }
   }

   public Class[] get() {
      Class[] var1 = new Class[this.pluginList.size()];
      return (Class[])((Class[])this.pluginList.toArray(var1));
   }

   private boolean classImplementsAny(Class var1, Set var2) {
      if (var1 == null) {
         return false;
      } else {
         Class[] var3 = var1.getInterfaces();

         int var4;
         for(var4 = 0; var4 < var3.length; ++var4) {
            if (var2.contains(var3[var4])) {
               return true;
            }
         }

         for(var4 = 0; var4 < var3.length; ++var4) {
            if (this.classImplementsAny(var3[var4], var2)) {
               return true;
            }
         }

         return this.classImplementsAny(var1.getSuperclass(), var2);
      }
   }

   private void processJar(File var1) {
      try {
         System.out.println("Scanning jar: " + var1.getName());
         PluginLoader var2 = new PluginLoader(var1);
         JarFile var3 = new JarFile(var1);
         Enumeration var4 = var3.entries();

         while(var4.hasMoreElements()) {
            JarEntry var5 = (JarEntry)var4.nextElement();
            System.out.println("Examining file : " + var5.getName());
            if (var5.getName().endsWith("Plugin.class")) {
               System.out.println("Found candidate class: " + var5.getName());
               String var6 = var5.getName();
               var6 = var6.substring(0, var6.length() - 6);
               var6 = var6.replace('/', '.');
               Class var7 = var2.loadClass(var6);
               if (var2.attemptPluginDefine(var7)) {
                  System.out.println("Adding class to plugins:" + var7.getName());
                  this.pluginList.add(var7);
               }
            }
         }
      } catch (Exception var8) {
         var8.printStackTrace();
      }

   }

   private boolean classImplementsAll(Class var1, Set var2) {
      if (var1 == null) {
         return false;
      } else {
         Class[] var3 = var1.getInterfaces();

         int var4;
         for(var4 = 0; var4 < var3.length; ++var4) {
            if (var2.contains(var3[var4])) {
               var2.remove(var3[var4]);
               if (var2.size() == 0) {
                  return true;
               }
            }
         }

         for(var4 = 0; var4 < var3.length; ++var4) {
            if (this.classImplementsAll(var3[var4], var2)) {
               return true;
            }
         }

         return this.classImplementsAll(var1.getSuperclass(), var2);
      }
   }

   public Class[] getImplementsAll(Class[] var1) {
      ArrayList var2 = new ArrayList(this.pluginList.size());
      HashSet var3 = new HashSet();

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var3.add(var1[var4]);
      }

      Iterator var7 = this.pluginList.iterator();

      while(var7.hasNext()) {
         Class var5 = (Class)var7.next();
         if (this.classImplementsAll(var5, var3)) {
            var2.add(var5);
         }
      }

      Class[] var6 = new Class[var2.size()];
      return (Class[])((Class[])var2.toArray(var6));
   }

   private void scanPlugins(File var1) throws IOException {
      File[] var2 = var1.listFiles();
      if (var2 == null) {
         throw new FileNotFoundException("Plugin directory " + var1.getName() + " not found.");
      } else {
         for(int var3 = 0; var3 < var2.length; ++var3) {
            File var4 = var2[var3];
            if (var4.getName().endsWith(".jar")) {
               this.processJar(var4);
            } else if (var4.isDirectory()) {
               this.scanPlugins(var4);
            }
         }

      }
   }

   public Class[] getImplementsAny(Class[] var1) {
      ArrayList var2 = new ArrayList(this.pluginList.size());
      HashSet var3 = new HashSet();

      for(int var4 = 0; var4 < var1.length; ++var4) {
         var3.add(var1[var4]);
      }

      Iterator var7 = this.pluginList.iterator();

      while(var7.hasNext()) {
         Class var5 = (Class)var7.next();
         if (this.classImplementsAny(var5, var3)) {
            var2.add(var5);
         }
      }

      Class[] var6 = new Class[var2.size()];
      return (Class[])((Class[])var2.toArray(var6));
   }

   public Plugins(File var1) throws IOException {
      this.scanPlugins(var1);
   }

   public Class[] getExtends(Class var1) {
      ArrayList var2 = new ArrayList(this.pluginList.size());
      Iterator var3 = this.pluginList.iterator();

      while(var3.hasNext()) {
         Class var4 = (Class)var3.next();
         if (this.classExtends(var4, var1)) {
            var2.add(var4);
         }
      }

      Class[] var5 = new Class[var2.size()];
      return (Class[])((Class[])var2.toArray(var5));
   }
}
