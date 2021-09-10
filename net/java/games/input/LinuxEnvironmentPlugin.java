package net.java.games.input;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import net.java.games.util.plugins.Plugin;

public final class LinuxEnvironmentPlugin extends ControllerEnvironment implements Plugin {
   private static final String LIBNAME = "jinput-linux";
   private static final String POSTFIX64BIT = "64";
   private final List devices = new ArrayList();
   private final Controller[] controllers;
   private static boolean supported = false;
   private static final LinuxDeviceThread device_thread = new LinuxDeviceThread();

   private static final Component[] createComponents(List var0, LinuxEventDevice var1) {
      LinuxEventComponent[][] var2 = new LinuxEventComponent[4][2];
      ArrayList var3 = new ArrayList();

      int var4;
      LinuxEventComponent var5;
      for(var4 = 0; var4 < var0.size(); ++var4) {
         var5 = (LinuxEventComponent)var0.get(var4);
         Component.Identifier var6 = var5.getIdentifier();
         if (var6 == Component.Identifier.Axis.POV) {
            int var7 = var5.getDescriptor().getCode();
            switch(var7) {
            case 16:
               var2[0][0] = var5;
               break;
            case 17:
               var2[0][1] = var5;
               break;
            case 18:
               var2[1][0] = var5;
               break;
            case 19:
               var2[1][1] = var5;
               break;
            case 20:
               var2[2][0] = var5;
               break;
            case 21:
               var2[2][1] = var5;
               break;
            case 22:
               var2[3][0] = var5;
               break;
            case 23:
               var2[3][1] = var5;
               break;
            default:
               logln("Unknown POV instance: " + var7);
            }
         } else if (var6 != null) {
            LinuxComponent var10 = new LinuxComponent(var5);
            var3.add(var10);
            var1.registerComponent(var5.getDescriptor(), var10);
         }
      }

      for(var4 = 0; var4 < var2.length; ++var4) {
         var5 = var2[var4][0];
         LinuxEventComponent var9 = var2[var4][1];
         if (var5 != null && var9 != null) {
            LinuxPOV var11 = new LinuxPOV(var5, var9);
            var3.add(var11);
            var1.registerComponent(var5.getDescriptor(), var11);
            var1.registerComponent(var9.getDescriptor(), var11);
         }
      }

      Component[] var8 = new Component[var3.size()];
      var3.toArray(var8);
      return var8;
   }

   private static String getAbsolutePathPrivileged(File var0) {
      return (String)AccessController.doPrivileged(new PrivilegedAction(var0) {
         private final File val$file;

         {
            this.val$file = var1;
         }

         public Object run() {
            return this.val$file.getAbsolutePath();
         }
      });
   }

   static void loadLibrary(String var0) {
      AccessController.doPrivileged(new PrivilegedAction(var0) {
         private final String val$lib_name;

         public final Object run() {
            String var1 = System.getProperty("net.java.games.input.librarypath");

            try {
               if (var1 != null) {
                  System.load(var1 + File.separator + System.mapLibraryName(this.val$lib_name));
               } else {
                  System.loadLibrary(this.val$lib_name);
               }
            } catch (UnsatisfiedLinkError var3) {
               ControllerEnvironment.logln("Failed to load library: " + var3.getMessage());
               var3.printStackTrace();
               LinuxEnvironmentPlugin.access$002(false);
            }

            return null;
         }

         {
            this.val$lib_name = var1;
         }
      });
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

   static {
      String var0 = getPrivilegedProperty("os.name", "").trim();
      if (var0.equals("Linux")) {
         supported = true;
         if ("i386".equals(getPrivilegedProperty("os.arch"))) {
            loadLibrary("jinput-linux");
         } else {
            loadLibrary("jinput-linux64");
         }
      }

   }

   private static final Controller createJoystickFromDevice(LinuxEventDevice var0, Component[] var1, Controller.Type var2) throws IOException {
      LinuxAbstractController var3 = new LinuxAbstractController(var0, var1, new Controller[0], var0.getRumblers(), var2);
      return var3;
   }

   public LinuxEnvironmentPlugin() {
      if (this.isSupported()) {
         this.controllers = this.enumerateControllers();
         logln("Linux plugin claims to have found " + this.controllers.length + " controllers");
         AccessController.doPrivileged(new PrivilegedAction(this) {
            private final LinuxEnvironmentPlugin this$0;

            {
               this.this$0 = var1;
            }

            public final Object run() {
               Runtime.getRuntime().addShutdownHook(this.this$0.new ShutdownHook(this.this$0));
               return null;
            }
         });
      } else {
         this.controllers = new Controller[0];
      }

   }

   public final Controller[] getControllers() {
      return this.controllers;
   }

   private final Controller[] enumerateControllers() {
      ArrayList var1 = new ArrayList();
      ArrayList var2 = new ArrayList();
      ArrayList var3 = new ArrayList();
      this.enumerateEventControllers(var2);
      this.enumerateJoystickControllers(var3);

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         for(int var5 = 0; var5 < var3.size(); ++var5) {
            Controller var6 = (Controller)var2.get(var4);
            Controller var7 = (Controller)var3.get(var5);
            if (var6.getName().equals(var7.getName())) {
               Component[] var8 = var6.getComponents();
               Component[] var9 = var7.getComponents();
               if (var8.length == var9.length) {
                  boolean var10 = false;

                  for(int var11 = 0; var11 < var8.length; ++var11) {
                     if (var8[var11].getIdentifier() != var9[var11].getIdentifier()) {
                        var10 = true;
                     }
                  }

                  if (!var10) {
                     var1.add(new LinuxCombinedController((LinuxAbstractController)var2.remove(var4), (LinuxJoystickAbstractController)var3.remove(var5)));
                     --var4;
                     --var5;
                     break;
                  }
               }
            }
         }
      }

      var1.addAll(var2);
      var1.addAll(var3);
      Controller[] var12 = new Controller[var1.size()];
      var1.toArray(var12);
      return var12;
   }

   private static final Keyboard createKeyboardFromDevice(LinuxEventDevice var0, Component[] var1) throws IOException {
      LinuxKeyboard var2 = new LinuxKeyboard(var0, var1, new Controller[0], var0.getRumblers());
      return var2;
   }

   private static final Controller createControllerFromDevice(LinuxEventDevice var0) throws IOException {
      List var1 = var0.getComponents();
      Component[] var2 = createComponents(var1, var0);
      Controller.Type var3 = var0.getType();
      if (var3 == Controller.Type.MOUSE) {
         return createMouseFromDevice(var0, var2);
      } else if (var3 == Controller.Type.KEYBOARD) {
         return createKeyboardFromDevice(var0, var2);
      } else {
         return var3 != Controller.Type.STICK && var3 != Controller.Type.GAMEPAD ? null : createJoystickFromDevice(var0, var2, var3);
      }
   }

   private final void enumerateEventControllers(List var1) {
      File var2 = new File("/dev/input");
      File[] var3 = listFilesPrivileged(var2, new FilenameFilter(this) {
         private final LinuxEnvironmentPlugin this$0;

         public final boolean accept(File var1, String var2) {
            return var2.startsWith("event");
         }

         {
            this.this$0 = var1;
         }
      });
      if (var3 != null) {
         for(int var4 = 0; var4 < var3.length; ++var4) {
            File var5 = var3[var4];

            try {
               String var6 = getAbsolutePathPrivileged(var5);
               LinuxEventDevice var7 = new LinuxEventDevice(var6);

               try {
                  Controller var8 = createControllerFromDevice(var7);
                  if (var8 != null) {
                     var1.add(var8);
                     this.devices.add(var7);
                  } else {
                     var7.close();
                  }
               } catch (IOException var9) {
                  logln("Failed to create Controller: " + var9.getMessage());
                  var7.close();
               }
            } catch (IOException var10) {
               logln("Failed to open device (" + var5 + "): " + var10.getMessage());
            }
         }

      }
   }

   private final void enumerateJoystickControllers(List var1) {
      File[] var2 = enumerateJoystickDeviceFiles("/dev/input");
      if (var2 == null || var2.length == 0) {
         var2 = enumerateJoystickDeviceFiles("/dev");
         if (var2 == null) {
            return;
         }
      }

      for(int var3 = 0; var3 < var2.length; ++var3) {
         File var4 = var2[var3];

         try {
            String var5 = getAbsolutePathPrivileged(var4);
            LinuxJoystickDevice var6 = new LinuxJoystickDevice(var5);
            Controller var7 = createJoystickFromJoystickDevice(var6);
            if (var7 != null) {
               var1.add(var7);
               this.devices.add(var6);
            } else {
               var6.close();
            }
         } catch (IOException var8) {
            logln("Failed to open device (" + var4 + "): " + var8.getMessage());
         }
      }

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

   public boolean isSupported() {
      return supported;
   }

   static List access$200(LinuxEnvironmentPlugin var0) {
      return var0.devices;
   }

   private static final Controller createJoystickFromJoystickDevice(LinuxJoystickDevice var0) {
      ArrayList var1 = new ArrayList();
      byte[] var2 = var0.getAxisMap();
      char[] var3 = var0.getButtonMap();
      LinuxJoystickAxis[] var4 = new LinuxJoystickAxis[6];

      int var5;
      for(var5 = 0; var5 < var0.getNumButtons(); ++var5) {
         Component.Identifier var6 = LinuxNativeTypesMap.getButtonID(var3[var5]);
         if (var6 != null) {
            LinuxJoystickButton var7 = new LinuxJoystickButton(var6);
            var0.registerButton(var5, var7);
            var1.add(var7);
         }
      }

      for(var5 = 0; var5 < var0.getNumAxes(); ++var5) {
         Component.Identifier.Axis var8 = (Component.Identifier.Axis)LinuxNativeTypesMap.getAbsAxisID(var2[var5]);
         LinuxJoystickAxis var9 = new LinuxJoystickAxis(var8);
         var0.registerAxis(var5, var9);
         if (var2[var5] == 16) {
            var4[0] = var9;
         } else {
            LinuxJoystickPOV var10;
            if (var2[var5] == 17) {
               var4[1] = var9;
               var10 = new LinuxJoystickPOV(Component.Identifier.Axis.POV, var4[0], var4[1]);
               var0.registerPOV((LinuxJoystickPOV)var10);
               var1.add(var10);
            } else if (var2[var5] == 18) {
               var4[2] = var9;
            } else if (var2[var5] == 19) {
               var4[3] = var9;
               var10 = new LinuxJoystickPOV(Component.Identifier.Axis.POV, var4[2], var4[3]);
               var0.registerPOV((LinuxJoystickPOV)var10);
               var1.add(var10);
            } else if (var2[var5] == 20) {
               var4[4] = var9;
            } else if (var2[var5] == 21) {
               var4[5] = var9;
               var10 = new LinuxJoystickPOV(Component.Identifier.Axis.POV, var4[4], var4[5]);
               var0.registerPOV((LinuxJoystickPOV)var10);
               var1.add(var10);
            } else {
               var1.add(var9);
            }
         }
      }

      return new LinuxJoystickAbstractController(var0, (Component[])((Component[])var1.toArray(new Component[0])), new Controller[0], new Rumbler[0]);
   }

   private static final Mouse createMouseFromDevice(LinuxEventDevice var0, Component[] var1) throws IOException {
      LinuxMouse var2 = new LinuxMouse(var0, var1, new Controller[0], var0.getRumblers());
      return var2.getX() != null && var2.getY() != null && var2.getPrimaryButton() != null ? var2 : null;
   }

   private static final File[] enumerateJoystickDeviceFiles(String var0) {
      File var1 = new File(var0);
      return listFilesPrivileged(var1, new FilenameFilter() {
         public final boolean accept(File var1, String var2) {
            return var2.startsWith("js");
         }
      });
   }

   private static File[] listFilesPrivileged(File var0, FilenameFilter var1) {
      return (File[])((File[])AccessController.doPrivileged(new PrivilegedAction(var0, var1) {
         private final File val$dir;
         private final FilenameFilter val$filter;

         public Object run() {
            File[] var1 = this.val$dir.listFiles(this.val$filter);
            Arrays.sort(var1, new Comparator(this) {
               private final <undefinedtype> this$0;

               {
                  this.this$0 = var1;
               }

               public int compare(Object var1, Object var2) {
                  return ((File)var1).getName().compareTo(((File)var2).getName());
               }
            });
            return var1;
         }

         {
            this.val$dir = var1;
            this.val$filter = var2;
         }
      }));
   }

   static boolean access$002(boolean var0) {
      supported = var0;
      return var0;
   }

   private static final Component.Identifier.Button getButtonIdentifier(int var0) {
      switch(var0) {
      case 0:
         return Component.Identifier.Button._0;
      case 1:
         return Component.Identifier.Button._1;
      case 2:
         return Component.Identifier.Button._2;
      case 3:
         return Component.Identifier.Button._3;
      case 4:
         return Component.Identifier.Button._4;
      case 5:
         return Component.Identifier.Button._5;
      case 6:
         return Component.Identifier.Button._6;
      case 7:
         return Component.Identifier.Button._7;
      case 8:
         return Component.Identifier.Button._8;
      case 9:
         return Component.Identifier.Button._9;
      case 10:
         return Component.Identifier.Button._10;
      case 11:
         return Component.Identifier.Button._11;
      case 12:
         return Component.Identifier.Button._12;
      case 13:
         return Component.Identifier.Button._13;
      case 14:
         return Component.Identifier.Button._14;
      case 15:
         return Component.Identifier.Button._15;
      case 16:
         return Component.Identifier.Button._16;
      case 17:
         return Component.Identifier.Button._17;
      case 18:
         return Component.Identifier.Button._18;
      case 19:
         return Component.Identifier.Button._19;
      case 20:
         return Component.Identifier.Button._20;
      case 21:
         return Component.Identifier.Button._21;
      case 22:
         return Component.Identifier.Button._22;
      case 23:
         return Component.Identifier.Button._23;
      case 24:
         return Component.Identifier.Button._24;
      case 25:
         return Component.Identifier.Button._25;
      case 26:
         return Component.Identifier.Button._26;
      case 27:
         return Component.Identifier.Button._27;
      case 28:
         return Component.Identifier.Button._28;
      case 29:
         return Component.Identifier.Button._29;
      case 30:
         return Component.Identifier.Button._30;
      case 31:
         return Component.Identifier.Button._31;
      default:
         return null;
      }
   }

   public static final Object execute(LinuxDeviceTask var0) throws IOException {
      return device_thread.execute(var0);
   }

   private final class ShutdownHook extends Thread {
      private final LinuxEnvironmentPlugin this$0;

      public final void run() {
         for(int var1 = 0; var1 < LinuxEnvironmentPlugin.access$200(this.this$0).size(); ++var1) {
            try {
               LinuxDevice var2 = (LinuxDevice)LinuxEnvironmentPlugin.access$200(this.this$0).get(var1);
               var2.close();
            } catch (IOException var3) {
               ControllerEnvironment.logln("Failed to close device: " + var3.getMessage());
            }
         }

      }

      private ShutdownHook(LinuxEnvironmentPlugin var1) {
         this.this$0 = var1;
      }

      ShutdownHook(LinuxEnvironmentPlugin var1, Object var2) {
         this(var1);
      }
   }
}
