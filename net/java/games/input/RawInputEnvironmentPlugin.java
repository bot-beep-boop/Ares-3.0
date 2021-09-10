package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.util.plugins.Plugin;

public final class RawInputEnvironmentPlugin extends ControllerEnvironment implements Plugin {
   private static boolean supported = false;
   private final Controller[] controllers;

   private static final void createControllersFromDevices(RawInputEventQueue var0, List var1, List var2, List var3) throws IOException {
      ArrayList var4 = new ArrayList();

      for(int var5 = 0; var5 < var2.size(); ++var5) {
         RawDevice var6 = (RawDevice)var2.get(var5);
         SetupAPIDevice var7 = lookupSetupAPIDevice(var6.getName(), var3);
         if (var7 != null) {
            RawDeviceInfo var8 = var6.getInfo();
            Controller var9 = var8.createControllerFromDevice(var6, var7);
            if (var9 != null) {
               var1.add(var9);
               var4.add(var6);
            }
         }
      }

      var0.start(var4);
   }

   private final Controller[] enumControllers(RawInputEventQueue var1) throws IOException {
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      enumerateDevices(var1, var3);
      List var4 = enumSetupAPIDevices();
      createControllersFromDevices(var1, var2, var3, var4);
      Controller[] var5 = new Controller[var2.size()];
      var2.toArray(var5);
      return var5;
   }

   static boolean access$002(boolean var0) {
      supported = var0;
      return var0;
   }

   private static final native byte[] getKeyboardClassGUID();

   private static final native byte[] getMouseClassGUID();

   private static final SetupAPIDevice lookupSetupAPIDevice(String var0, List var1) {
      var0 = var0.replaceAll("#", "\\\\").toUpperCase();

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         SetupAPIDevice var3 = (SetupAPIDevice)var1.get(var2);
         if (var0.indexOf(var3.getInstanceId().toUpperCase()) != -1) {
            return var3;
         }
      }

      return null;
   }

   static void loadLibrary(String var0) {
      AccessController.doPrivileged(new PrivilegedAction(var0) {
         private final String val$lib_name;

         public final Object run() {
            try {
               String var1 = System.getProperty("net.java.games.input.librarypath");
               if (var1 != null) {
                  System.load(var1 + File.separator + System.mapLibraryName(this.val$lib_name));
               } else {
                  System.loadLibrary(this.val$lib_name);
               }
            } catch (UnsatisfiedLinkError var2) {
               var2.printStackTrace();
               RawInputEnvironmentPlugin.access$002(false);
            }

            return null;
         }

         {
            this.val$lib_name = var1;
         }
      });
   }

   static String getPrivilegedProperty(String var0, String var1) {
      return (String)AccessController.doPrivileged(new PrivilegedAction(var0, var1) {
         private final String val$property;
         private final String val$default_value;

         public Object run() {
            return System.getProperty(this.val$property, this.val$default_value);
         }

         {
            this.val$property = var1;
            this.val$default_value = var2;
         }
      });
   }

   public RawInputEnvironmentPlugin() {
      Controller[] var2 = new Controller[0];
      if (this.isSupported()) {
         try {
            RawInputEventQueue var1 = new RawInputEventQueue();
            var2 = this.enumControllers(var1);
         } catch (IOException var4) {
            logln("Failed to enumerate devices: " + var4.getMessage());
         }
      }

      this.controllers = var2;
   }

   public boolean isSupported() {
      return supported;
   }

   private static final native void enumerateDevices(RawInputEventQueue var0, List var1) throws IOException;

   static String getPrivilegedProperty(String var0) {
      return (String)AccessController.doPrivileged(new PrivilegedAction(var0) {
         private final String val$property;

         {
            this.val$property = var1;
         }

         public Object run() {
            return System.getProperty(this.val$property);
         }
      });
   }

   private static final List enumSetupAPIDevices() throws IOException {
      ArrayList var0 = new ArrayList();
      nEnumSetupAPIDevices(getKeyboardClassGUID(), var0);
      nEnumSetupAPIDevices(getMouseClassGUID(), var0);
      return var0;
   }

   private static final native void nEnumSetupAPIDevices(byte[] var0, List var1) throws IOException;

   public final Controller[] getControllers() {
      return this.controllers;
   }

   static {
      String var0 = getPrivilegedProperty("os.name", "").trim();
      if (var0.startsWith("Windows")) {
         supported = true;
         if ("x86".equals(getPrivilegedProperty("os.arch"))) {
            loadLibrary("jinput-raw");
         } else {
            loadLibrary("jinput-raw_64");
         }
      }

   }
}
