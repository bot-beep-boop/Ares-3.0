package net.minecraft.launchwrapper;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogWrapper {
   private Logger myLog;
   private static boolean configured;
   public static LogWrapper log = new LogWrapper();

   public static void finest(String var0, Object... var1) {
      log(Level.TRACE, var0, var1);
   }

   public static void log(Level var0, String var1, Object... var2) {
      if (!configured) {
         configureLogging();
      }

      log.myLog.log(var0, String.format(var1, var2));
   }

   public static void makeLog(String var0) {
      LogManager.getLogger(var0);
   }

   public static void log(Level var0, Throwable var1, String var2, Object... var3) {
      if (!configured) {
         configureLogging();
      }

      log.myLog.log(var0, String.format(var2, var3), var1);
   }

   public static void log(String var0, Level var1, Throwable var2, String var3, Object... var4) {
      makeLog(var0);
      LogManager.getLogger(var0).log(var1, String.format(var3, var4), var2);
   }

   public static void severe(String var0, Object... var1) {
      log(Level.ERROR, var0, var1);
   }

   public static void info(String var0, Object... var1) {
      log(Level.INFO, var0, var1);
   }

   public static void finer(String var0, Object... var1) {
      log(Level.TRACE, var0, var1);
   }

   public static void retarget(Logger var0) {
      log.myLog = var0;
   }

   public static void warning(String var0, Object... var1) {
      log(Level.WARN, var0, var1);
   }

   public static void log(String var0, Level var1, String var2, Object... var3) {
      makeLog(var0);
      LogManager.getLogger(var0).log(var1, String.format(var2, var3));
   }

   private static void configureLogging() {
      log.myLog = LogManager.getLogger("LaunchWrapper");
      configured = true;
   }

   public static void fine(String var0, Object... var1) {
      log(Level.DEBUG, var0, var1);
   }
}
