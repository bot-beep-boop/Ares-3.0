package net.minecraft.util;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import org.apache.logging.log4j.Logger;

public class Util {
   public static Util.EnumOS getOSType() {
      String var0 = System.getProperty("os.name").toLowerCase();
      return var0.contains("win") ? Util.EnumOS.WINDOWS : (var0.contains("mac") ? Util.EnumOS.OSX : (var0.contains("solaris") ? Util.EnumOS.SOLARIS : (var0.contains("sunos") ? Util.EnumOS.SOLARIS : (var0.contains("linux") ? Util.EnumOS.LINUX : (var0.contains("unix") ? Util.EnumOS.LINUX : Util.EnumOS.UNKNOWN)))));
   }

   public static <V> V runTask(FutureTask<V> var0, Logger var1) {
      try {
         try {
            var0.run();
         } catch (NullPointerException var4) {
            var4.printStackTrace();
         }

         return var0.get();
      } catch (ExecutionException var5) {
         var1.fatal("Error executing task", var5);
         if (var5.getCause() instanceof OutOfMemoryError) {
            OutOfMemoryError var3 = (OutOfMemoryError)var5.getCause();
            throw var3;
         }
      } catch (InterruptedException var6) {
         var1.fatal("Error executing task", var6);
      }

      return null;
   }

   public static enum EnumOS {
      WINDOWS,
      LINUX,
      SOLARIS;

      private static final Util.EnumOS[] ENUM$VALUES = new Util.EnumOS[]{LINUX, SOLARIS, WINDOWS, OSX, UNKNOWN};
      UNKNOWN,
      OSX;
   }
}
