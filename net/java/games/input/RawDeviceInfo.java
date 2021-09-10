package net.java.games.input;

import java.io.IOException;

abstract class RawDeviceInfo {
   public abstract int getUsage();

   public abstract long getHandle();

   public abstract int getUsagePage();

   public abstract Controller createControllerFromDevice(RawDevice var1, SetupAPIDevice var2) throws IOException;

   public final boolean equals(Object var1) {
      if (!(var1 instanceof RawDeviceInfo)) {
         return false;
      } else {
         RawDeviceInfo var2 = (RawDeviceInfo)var1;
         return var2.getUsage() == this.getUsage() && var2.getUsagePage() == this.getUsagePage();
      }
   }

   public final int hashCode() {
      return this.getUsage() ^ this.getUsagePage();
   }
}
