package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import net.java.games.util.plugins.Plugin;

public final class OSXEnvironmentPlugin extends ControllerEnvironment implements Plugin {
   private static boolean supported = false;
   private final Controller[] controllers;

   static {
      String var0 = getPrivilegedProperty("os.name", "").trim();
      if (var0.equals("Mac OS X")) {
         supported = true;
         loadLibrary("jinput-osx");
      }

   }

   static void loadLibrary(String var0) {
      AccessController.doPrivileged(new PrivilegedAction(var0) {
         private final String val$lib_name;

         {
            this.val$lib_name = var1;
         }

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
               OSXEnvironmentPlugin.access$002(false);
            }

            return null;
         }
      });
   }

   private static final void addElements(OSXHIDQueue var0, List var1, List var2, boolean var3) throws IOException {
      Iterator var4 = var1.iterator();

      while(var4.hasNext()) {
         OSXHIDElement var5 = (OSXHIDElement)var4.next();
         Object var6 = var5.getIdentifier();
         if (var6 != null) {
            if (var3) {
               if (var6 == Component.Identifier.Button._0) {
                  var6 = Component.Identifier.Button.LEFT;
               } else if (var6 == Component.Identifier.Button._1) {
                  var6 = Component.Identifier.Button.RIGHT;
               } else if (var6 == Component.Identifier.Button._2) {
                  var6 = Component.Identifier.Button.MIDDLE;
               }
            }

            OSXComponent var7 = new OSXComponent((Component.Identifier)var6, var5);
            var2.add(var7);
            var0.addElement(var5, var7);
         }
      }

   }

   static String getPrivilegedProperty(String var0) {
      return (String)AccessController.doPrivileged(new PrivilegedAction(var0) {
         private final String val$property;

         public Object run() {
            return System.getProperty(this.val$property);
         }

         {
            this.val$property = var1;
         }
      });
   }

   private static final void createControllersFromDevice(OSXHIDDevice var0, List var1) throws IOException {
      UsagePair var2 = var0.getUsagePair();
      if (var2 != null) {
         List var3 = var0.getElements();
         if (var2.getUsagePage() != UsagePage.GENERIC_DESKTOP || var2.getUsage() != GenericDesktopUsage.MOUSE && var2.getUsage() != GenericDesktopUsage.POINTER) {
            if (var2.getUsagePage() == UsagePage.GENERIC_DESKTOP && (var2.getUsage() == GenericDesktopUsage.KEYBOARD || var2.getUsage() == GenericDesktopUsage.KEYPAD)) {
               Keyboard var5 = createKeyboardFromDevice(var0, var3);
               if (var5 != null) {
                  var1.add(var5);
               }
            } else {
               AbstractController var6;
               if (var2.getUsagePage() == UsagePage.GENERIC_DESKTOP && var2.getUsage() == GenericDesktopUsage.JOYSTICK) {
                  var6 = createControllerFromDevice(var0, var3, Controller.Type.STICK);
                  if (var6 != null) {
                     var1.add(var6);
                  }
               } else if (var2.getUsagePage() == UsagePage.GENERIC_DESKTOP && var2.getUsage() == GenericDesktopUsage.MULTI_AXIS_CONTROLLER) {
                  var6 = createControllerFromDevice(var0, var3, Controller.Type.STICK);
                  if (var6 != null) {
                     var1.add(var6);
                  }
               } else if (var2.getUsagePage() == UsagePage.GENERIC_DESKTOP && var2.getUsage() == GenericDesktopUsage.GAME_PAD) {
                  var6 = createControllerFromDevice(var0, var3, Controller.Type.GAMEPAD);
                  if (var6 != null) {
                     var1.add(var6);
                  }
               }
            }
         } else {
            Mouse var4 = createMouseFromDevice(var0, var3);
            if (var4 != null) {
               var1.add(var4);
            }
         }

      }
   }

   private static final Mouse createMouseFromDevice(OSXHIDDevice var0, List var1) throws IOException {
      ArrayList var2 = new ArrayList();
      OSXHIDQueue var3 = var0.createQueue(32);

      try {
         addElements(var3, var1, var2, true);
      } catch (IOException var6) {
         var3.release();
         throw var6;
      }

      Component[] var4 = new Component[var2.size()];
      var2.toArray(var4);
      OSXMouse var5 = new OSXMouse(var0, var3, var4, new Controller[0], new Rumbler[0]);
      if (var5.getPrimaryButton() != null && var5.getX() != null && var5.getY() != null) {
         return var5;
      } else {
         var3.release();
         return null;
      }
   }

   public OSXEnvironmentPlugin() {
      if (this.isSupported()) {
         this.controllers = enumerateControllers();
      } else {
         this.controllers = new Controller[0];
      }

   }

   private static final Controller[] enumerateControllers() {
      // $FF: Couldn't be decompiled
   }

   private static final AbstractController createControllerFromDevice(OSXHIDDevice var0, List var1, Controller.Type var2) throws IOException {
      ArrayList var3 = new ArrayList();
      OSXHIDQueue var4 = var0.createQueue(32);

      try {
         addElements(var4, var1, var3, false);
      } catch (IOException var7) {
         var4.release();
         throw var7;
      }

      Component[] var5 = new Component[var3.size()];
      var3.toArray(var5);
      OSXAbstractController var6 = new OSXAbstractController(var0, var4, var5, new Controller[0], new Rumbler[0], var2);
      return var6;
   }

   public final Controller[] getControllers() {
      return this.controllers;
   }

   static boolean access$002(boolean var0) {
      supported = var0;
      return var0;
   }

   static String getPrivilegedProperty(String var0, String var1) {
      return (String)AccessController.doPrivileged(new PrivilegedAction(var0, var1) {
         private final String val$default_value;
         private final String val$property;

         {
            this.val$property = var1;
            this.val$default_value = var2;
         }

         public Object run() {
            return System.getProperty(this.val$property, this.val$default_value);
         }
      });
   }

   private static final Keyboard createKeyboardFromDevice(OSXHIDDevice var0, List var1) throws IOException {
      ArrayList var2 = new ArrayList();
      OSXHIDQueue var3 = var0.createQueue(32);

      try {
         addElements(var3, var1, var2, false);
      } catch (IOException var6) {
         var3.release();
         throw var6;
      }

      Component[] var4 = new Component[var2.size()];
      var2.toArray(var4);
      OSXKeyboard var5 = new OSXKeyboard(var0, var3, var4, new Controller[0], new Rumbler[0]);
      return var5;
   }

   private static final boolean isMacOSXEqualsOrBetterThan(int var0, int var1) {
      String var2 = System.getProperty("os.version");
      StringTokenizer var3 = new StringTokenizer(var2, ".");

      int var4;
      int var5;
      try {
         String var6 = var3.nextToken();
         String var7 = var3.nextToken();
         var4 = Integer.parseInt(var6);
         var5 = Integer.parseInt(var7);
      } catch (Exception var8) {
         logln("Exception occurred while trying to determine OS version: " + var8);
         return false;
      }

      return var4 > var0 || var4 == var0 && var5 >= var1;
   }

   public boolean isSupported() {
      return supported;
   }
}
