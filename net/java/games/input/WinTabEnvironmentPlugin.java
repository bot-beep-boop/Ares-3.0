package net.java.games.input;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.List;
import net.java.games.util.plugins.Plugin;

public class WinTabEnvironmentPlugin extends ControllerEnvironment implements Plugin {
   private final WinTabContext winTabContext;
   private final Controller[] controllers;
   private final List active_devices = new ArrayList();
   private static boolean supported = false;

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

   public Controller[] getControllers() {
      return this.controllers;
   }

   static WinTabContext access$300(WinTabEnvironmentPlugin var0) {
      return var0.winTabContext;
   }

   public WinTabEnvironmentPlugin() {
      if (this.isSupported()) {
         DummyWindow var1 = null;
         WinTabContext var2 = null;
         Controller[] var3 = new Controller[0];

         try {
            var1 = new DummyWindow();
            var2 = new WinTabContext(var1);

            try {
               var2.open();
               var3 = var2.getControllers();
            } catch (Exception var5) {
               var1.destroy();
               throw var5;
            }
         } catch (Exception var6) {
            logln("Failed to enumerate devices: " + var6.getMessage());
            var6.printStackTrace();
         }

         this.controllers = var3;
         this.winTabContext = var2;
         AccessController.doPrivileged(new PrivilegedAction(this) {
            private final WinTabEnvironmentPlugin this$0;

            {
               this.this$0 = var1;
            }

            public final Object run() {
               Runtime.getRuntime().addShutdownHook(this.this$0.new ShutdownHook(this.this$0));
               return null;
            }
         });
      } else {
         this.winTabContext = null;
         this.controllers = new Controller[0];
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

   static boolean access$002(boolean var0) {
      supported = var0;
      return var0;
   }

   static List access$200(WinTabEnvironmentPlugin var0) {
      return var0.active_devices;
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
               WinTabEnvironmentPlugin.access$002(false);
            }

            return null;
         }

         {
            this.val$lib_name = var1;
         }
      });
   }

   static {
      String var0 = getPrivilegedProperty("os.name", "").trim();
      if (var0.startsWith("Windows")) {
         supported = true;
         loadLibrary("jinput-wintab");
      }

   }

   public boolean isSupported() {
      return supported;
   }

   private final class ShutdownHook extends Thread {
      private final WinTabEnvironmentPlugin this$0;

      public final void run() {
         for(int var1 = 0; var1 < WinTabEnvironmentPlugin.access$200(this.this$0).size(); ++var1) {
         }

         WinTabEnvironmentPlugin.access$300(this.this$0).close();
      }

      ShutdownHook(WinTabEnvironmentPlugin var1, Object var2) {
         this(var1);
      }

      private ShutdownHook(WinTabEnvironmentPlugin var1) {
         this.this$0 = var1;
      }
   }
}
