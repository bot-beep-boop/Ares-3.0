package net.java.games.input;

import java.io.File;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.util.plugins.Plugin;

public final class DirectInputEnvironmentPlugin extends ControllerEnvironment implements Plugin {
   private final Controller[] controllers;
   private final List active_devices = new ArrayList();
   private static boolean supported = false;
   private final DummyWindow window;

   private final Component[] createComponents(IDirectInputDevice var1, boolean var2) {
      List var3 = var1.getObjects();
      ArrayList var4 = new ArrayList();

      for(int var5 = 0; var5 < var3.size(); ++var5) {
         DIDeviceObject var6 = (DIDeviceObject)var3.get(var5);
         Object var7 = var6.getIdentifier();
         if (var7 != null) {
            if (var2 && var7 instanceof Component.Identifier.Button) {
               var7 = DIIdentifierMap.mapMouseButtonIdentifier((Component.Identifier.Button)var7);
            }

            DIComponent var8 = new DIComponent((Component.Identifier)var7, var6);
            var4.add(var8);
            var1.registerComponent(var6, var8);
         }
      }

      Component[] var9 = new Component[var4.size()];
      var4.toArray(var9);
      return var9;
   }

   private final AbstractController createControllerFromDevice(IDirectInputDevice var1, Controller.Type var2) {
      Component[] var3 = this.createComponents(var1, false);
      DIAbstractController var4 = new DIAbstractController(var1, var3, new Controller[0], var1.getRumblers(), var2);
      return var4;
   }

   static {
      String var0 = getPrivilegedProperty("os.name", "").trim();
      if (var0.startsWith("Windows")) {
         supported = true;
         if ("x86".equals(getPrivilegedProperty("os.arch"))) {
            loadLibrary("jinput-dx8");
         } else {
            loadLibrary("jinput-dx8_64");
         }
      }

   }

   private final Controller[] enumControllers(DummyWindow var1) throws IOException {
      ArrayList var2 = new ArrayList();
      IDirectInput var3 = new IDirectInput(var1);

      try {
         List var4 = var3.getDevices();

         for(int var5 = 0; var5 < var4.size(); ++var5) {
            IDirectInputDevice var6 = (IDirectInputDevice)var4.get(var5);
            Controller var7 = this.createControllerFromDevice(var6);
            if (var7 != null) {
               var2.add(var7);
               this.active_devices.add(var6);
            } else {
               var6.release();
            }
         }
      } finally {
         var3.release();
      }

      Controller[] var11 = new Controller[var2.size()];
      var2.toArray(var11);
      return var11;
   }

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

   static List access$200(DirectInputEnvironmentPlugin var0) {
      return var0.active_devices;
   }

   public DirectInputEnvironmentPlugin() {
      DummyWindow var1 = null;
      Controller[] var2 = new Controller[0];
      if (this.isSupported()) {
         try {
            var1 = new DummyWindow();

            try {
               var2 = this.enumControllers(var1);
            } catch (IOException var4) {
               var1.destroy();
               throw var4;
            }
         } catch (IOException var5) {
            logln("Failed to enumerate devices: " + var5.getMessage());
         }

         this.window = var1;
         this.controllers = var2;
         AccessController.doPrivileged(new PrivilegedAction(this) {
            private final DirectInputEnvironmentPlugin this$0;

            public final Object run() {
               Runtime.getRuntime().addShutdownHook(this.this$0.new ShutdownHook(this.this$0));
               return null;
            }

            {
               this.this$0 = var1;
            }
         });
      } else {
         this.window = null;
         this.controllers = var2;
      }

   }

   private final Controller createControllerFromDevice(IDirectInputDevice var1) {
      switch(var1.getType()) {
      case 18:
         return this.createMouseFromDevice(var1);
      case 19:
         return this.createKeyboardFromDevice(var1);
      case 20:
      case 23:
      case 24:
         return this.createControllerFromDevice(var1, Controller.Type.STICK);
      case 21:
         return this.createControllerFromDevice(var1, Controller.Type.GAMEPAD);
      case 22:
         return this.createControllerFromDevice(var1, Controller.Type.WHEEL);
      default:
         return this.createControllerFromDevice(var1, Controller.Type.UNKNOWN);
      }
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
               DirectInputEnvironmentPlugin.access$002(false);
            }

            return null;
         }

         {
            this.val$lib_name = var1;
         }
      });
   }

   public boolean isSupported() {
      return supported;
   }

   static String getPrivilegedProperty(String var0, String var1) {
      return (String)AccessController.doPrivileged(new PrivilegedAction(var0, var1) {
         private final String val$default_value;
         private final String val$property;

         public Object run() {
            return System.getProperty(this.val$property, this.val$default_value);
         }

         {
            this.val$property = var1;
            this.val$default_value = var2;
         }
      });
   }

   private final Keyboard createKeyboardFromDevice(IDirectInputDevice var1) {
      Component[] var2 = this.createComponents(var1, false);
      return new DIKeyboard(var1, var2, new Controller[0], var1.getRumblers());
   }

   public final Controller[] getControllers() {
      return this.controllers;
   }

   static boolean access$002(boolean var0) {
      supported = var0;
      return var0;
   }

   private final Mouse createMouseFromDevice(IDirectInputDevice var1) {
      Component[] var2 = this.createComponents(var1, true);
      DIMouse var3 = new DIMouse(var1, var2, new Controller[0], var1.getRumblers());
      return var3.getX() != null && var3.getY() != null && var3.getPrimaryButton() != null ? var3 : null;
   }

   private final class ShutdownHook extends Thread {
      private final DirectInputEnvironmentPlugin this$0;

      public final void run() {
         for(int var1 = 0; var1 < DirectInputEnvironmentPlugin.access$200(this.this$0).size(); ++var1) {
            IDirectInputDevice var2 = (IDirectInputDevice)DirectInputEnvironmentPlugin.access$200(this.this$0).get(var1);
            var2.release();
         }

      }

      ShutdownHook(DirectInputEnvironmentPlugin var1, Object var2) {
         this(var1);
      }

      private ShutdownHook(DirectInputEnvironmentPlugin var1) {
         this.this$0 = var1;
      }
   }
}
