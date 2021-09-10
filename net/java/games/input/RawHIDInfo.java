package net.java.games.input;

import java.io.IOException;

class RawHIDInfo extends RawDeviceInfo {
   private final int usage;
   private final int version;
   private final int vendor_id;
   private final int product_id;
   private final RawDevice device;
   private final int page;

   public final int getUsagePage() {
      return this.page;
   }

   public RawHIDInfo(RawDevice var1, int var2, int var3, int var4, int var5, int var6) {
      this.device = var1;
      this.vendor_id = var2;
      this.product_id = var3;
      this.version = var4;
      this.page = var5;
      this.usage = var6;
   }

   public final Controller createControllerFromDevice(RawDevice var1, SetupAPIDevice var2) throws IOException {
      return null;
   }

   public final int getUsage() {
      return this.usage;
   }

   public final long getHandle() {
      return this.device.getHandle();
   }
}
