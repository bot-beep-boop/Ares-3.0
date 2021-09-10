package net.minecraft.launchwrapper;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import joptsimple.ArgumentAcceptingOptionSpec;
import joptsimple.NonOptionArgumentSpec;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import org.apache.logging.log4j.Level;

public class Launch {
   public static LaunchClassLoader classLoader;
   public static Map<String, Object> blackboard;
   public static File assetsDir;
   public static File minecraftHome;
   private static final String DEFAULT_TWEAK = "net.minecraft.launchwrapper.VanillaTweaker";

   public static void main(String[] var0) {
      (new Launch()).launch(var0);
   }

   private void launch(String[] var1) {
      OptionParser var2 = new OptionParser();
      var2.allowsUnrecognizedOptions();
      ArgumentAcceptingOptionSpec var3 = var2.accepts("version", "The version we launched with").withRequiredArg();
      ArgumentAcceptingOptionSpec var4 = var2.accepts("gameDir", "Alternative game directory").withRequiredArg().ofType(File.class);
      ArgumentAcceptingOptionSpec var5 = var2.accepts("assetsDir", "Assets directory").withRequiredArg().ofType(File.class);
      ArgumentAcceptingOptionSpec var6 = var2.accepts("tweakClass", "Tweak class(es) to load").withRequiredArg().defaultsTo("net.minecraft.launchwrapper.VanillaTweaker", new String[0]);
      NonOptionArgumentSpec var7 = var2.nonOptions();
      OptionSet var8 = var2.parse(var1);
      minecraftHome = (File)var8.valueOf(var4);
      assetsDir = (File)var8.valueOf(var5);
      String var9 = (String)var8.valueOf(var3);
      ArrayList var10 = new ArrayList(var8.valuesOf(var6));
      ArrayList var11 = new ArrayList();
      blackboard.put("TweakClasses", var10);
      blackboard.put("ArgumentList", var11);
      HashSet var12 = new HashSet();
      ArrayList var13 = new ArrayList();

      try {
         ArrayList var14 = new ArrayList(var10.size() + 1);
         blackboard.put("Tweaks", var14);
         ITweaker var15 = null;

         do {
            Iterator var16 = var10.iterator();

            while(var16.hasNext()) {
               String var17 = (String)var16.next();
               if (var12.contains(var17)) {
                  LogWrapper.log(Level.WARN, "Tweak class name %s has already been visited -- skipping", var17);
                  var16.remove();
               } else {
                  var12.add(var17);
                  LogWrapper.log(Level.INFO, "Loading tweak class name %s", var17);
                  classLoader.addClassLoaderExclusion(var17.substring(0, var17.lastIndexOf(46)));
                  ITweaker var18 = (ITweaker)Class.forName(var17, true, classLoader).newInstance();
                  var14.add(var18);
                  var16.remove();
                  if (var15 == null) {
                     LogWrapper.log(Level.INFO, "Using primary tweak class name %s", var17);
                     var15 = var18;
                  }
               }
            }

            var16 = var14.iterator();

            while(var16.hasNext()) {
               ITweaker var22 = (ITweaker)var16.next();
               LogWrapper.log(Level.INFO, "Calling tweak class %s", var22.getClass().getName());
               var22.acceptOptions(var8.valuesOf(var7), minecraftHome, assetsDir, var9);
               var22.injectIntoClassLoader(classLoader);
               var13.add(var22);
               var16.remove();
            }
         } while(!var10.isEmpty());

         Iterator var23 = var13.iterator();

         while(var23.hasNext()) {
            ITweaker var20 = (ITweaker)var23.next();
            var11.addAll(Arrays.asList(var20.getLaunchArguments()));
         }

         String var21 = var15.getLaunchTarget();
         Class var24 = Class.forName(var21, false, classLoader);
         Method var25 = var24.getMethod("main", String[].class);
         LogWrapper.info("Launching wrapped minecraft {%s}", var21);
         var25.invoke((Object)null, (Object)var11.toArray(new String[var11.size()]));
      } catch (Exception var19) {
         LogWrapper.log((Level)Level.ERROR, (Throwable)var19, "Unable to launch");
         System.exit(1);
      }

   }

   private Launch() {
      URLClassLoader var1 = (URLClassLoader)this.getClass().getClassLoader();
      classLoader = new LaunchClassLoader(var1.getURLs());
      blackboard = new HashMap();
      Thread.currentThread().setContextClassLoader(classLoader);
   }
}
