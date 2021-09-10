package net.java.games.input;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import net.java.games.util.plugins.Plugins;

class DefaultControllerEnvironment extends ControllerEnvironment {
   private ArrayList controllers;
   private Collection loadedPlugins = new ArrayList();
   static Class class$net$java$games$input$DefaultControllerEnvironment;
   private static Logger log;
   static Class class$net$java$games$input$ControllerEnvironment;
   static String libPath;

   static Class class$(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var2) {
         throw (new NoClassDefFoundError()).initCause(var2);
      }
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

   private void scanControllers() {
      String var1 = getPrivilegedProperty("jinput.controllerPluginPath");
      if (var1 == null) {
         var1 = "controller";
      }

      this.scanControllersAt(getPrivilegedProperty("java.home") + File.separator + "lib" + File.separator + var1);
      this.scanControllersAt(getPrivilegedProperty("user.dir") + File.separator + var1);
   }

   private void addControllers(Controller[] var1) {
      for(int var2 = 0; var2 < var1.length; ++var2) {
         this.controllers.add(var1[var2]);
      }

   }

   static {
      log = Logger.getLogger((class$net$java$games$input$DefaultControllerEnvironment == null ? (class$net$java$games$input$DefaultControllerEnvironment = class$("net.java.games.input.DefaultControllerEnvironment")) : class$net$java$games$input$DefaultControllerEnvironment).getName());
   }

   public boolean isSupported() {
      return true;
   }

   private void scanControllersAt(String var1) {
      File var2 = new File(var1);
      if (var2.exists()) {
         try {
            Plugins var3 = new Plugins(var2);
            Class[] var4 = var3.getExtends(class$net$java$games$input$ControllerEnvironment == null ? (class$net$java$games$input$ControllerEnvironment = class$("net.java.games.input.ControllerEnvironment")) : class$net$java$games$input$ControllerEnvironment);

            for(int var5 = 0; var5 < var4.length; ++var5) {
               try {
                  ControllerEnvironment.logln("ControllerEnvironment " + var4[var5].getName() + " loaded by " + var4[var5].getClassLoader());
                  ControllerEnvironment var6 = (ControllerEnvironment)var4[var5].newInstance();
                  if (var6.isSupported()) {
                     this.addControllers(var6.getControllers());
                     this.loadedPlugins.add(var6.getClass().getName());
                  } else {
                     logln(var4[var5].getName() + " is not supported");
                  }
               } catch (Throwable var7) {
                  var7.printStackTrace();
               }
            }
         } catch (Exception var8) {
            var8.printStackTrace();
         }

      }
   }

   static void access$000(DefaultControllerEnvironment var0) {
      var0.scanControllers();
   }

   static void loadLibrary(String var0) {
      AccessController.doPrivileged(new PrivilegedAction(var0) {
         private final String val$lib_name;

         public final Object run() {
            String var1 = System.getProperty("net.java.games.input.librarypath");
            if (var1 != null) {
               System.load(var1 + File.separator + System.mapLibraryName(this.val$lib_name));
            } else {
               System.loadLibrary(this.val$lib_name);
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

         public Object run() {
            return System.getProperty(this.val$property);
         }

         {
            this.val$property = var1;
         }
      });
   }

   public Controller[] getControllers() {
      if (this.controllers == null) {
         this.controllers = new ArrayList();
         AccessController.doPrivileged(new PrivilegedAction(this) {
            private final DefaultControllerEnvironment this$0;

            public Object run() {
               DefaultControllerEnvironment.access$000(this.this$0);
               return null;
            }

            {
               this.this$0 = var1;
            }
         });
         String var1 = getPrivilegedProperty("jinput.plugins", "") + " " + getPrivilegedProperty("net.java.games.input.plugins", "");
         if (!getPrivilegedProperty("jinput.useDefaultPlugin", "true").toLowerCase().trim().equals("false") && !getPrivilegedProperty("net.java.games.input.useDefaultPlugin", "true").toLowerCase().trim().equals("false")) {
            String var2 = getPrivilegedProperty("os.name", "").trim();
            if (var2.equals("Linux")) {
               var1 = var1 + " net.java.games.input.LinuxEnvironmentPlugin";
            } else if (var2.equals("Mac OS X")) {
               var1 = var1 + " net.java.games.input.OSXEnvironmentPlugin";
            } else if (!var2.equals("Windows XP") && !var2.equals("Windows Vista") && !var2.equals("Windows 7")) {
               if (!var2.equals("Windows 98") && !var2.equals("Windows 2000")) {
                  if (var2.startsWith("Windows")) {
                     log.warning("Found unknown Windows version: " + var2);
                     log.info("Attempting to use default windows plug-in.");
                     var1 = var1 + " net.java.games.input.DirectAndRawInputEnvironmentPlugin";
                  } else {
                     log.info("Trying to use default plugin, OS name " + var2 + " not recognised");
                  }
               } else {
                  var1 = var1 + " net.java.games.input.DirectInputEnvironmentPlugin";
               }
            } else {
               var1 = var1 + " net.java.games.input.DirectAndRawInputEnvironmentPlugin";
            }
         }

         StringTokenizer var7 = new StringTokenizer(var1, " \t\n\r\f,;:");

         while(var7.hasMoreTokens()) {
            String var3 = var7.nextToken();

            try {
               if (!this.loadedPlugins.contains(var3)) {
                  log.info("Loading: " + var3);
                  Class var4 = Class.forName(var3);
                  ControllerEnvironment var5 = (ControllerEnvironment)var4.newInstance();
                  if (var5.isSupported()) {
                     this.addControllers(var5.getControllers());
                     this.loadedPlugins.add(var5.getClass().getName());
                  } else {
                     logln(var4.getName() + " is not supported");
                  }
               }
            } catch (Throwable var6) {
               var6.printStackTrace();
            }
         }
      }

      Controller[] var9 = new Controller[this.controllers.size()];
      Iterator var8 = this.controllers.iterator();

      for(int var10 = 0; var8.hasNext(); ++var10) {
         var9[var10] = (Controller)var8.next();
      }

      return var9;
   }

   public DefaultControllerEnvironment() {
   }
}
