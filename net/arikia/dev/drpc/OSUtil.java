package net.arikia.dev.drpc;

public final class OSUtil {
   public String getOS() {
      return System.getProperty("os.name").toLowerCase();
   }

   public boolean isMac() {
      return this.getOS().toLowerCase().startsWith("mac");
   }

   public boolean isWindows() {
      return this.getOS().toLowerCase().startsWith("win");
   }
}
