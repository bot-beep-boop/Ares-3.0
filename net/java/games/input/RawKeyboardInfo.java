package net.java.games.input;

import java.io.IOException;

class RawKeyboardInfo extends RawDeviceInfo {
   private final int num_indicators;
   private final int sub_type;
   private final int type;
   private final RawDevice device;
   private final int keyboard_mode;
   private final int num_function_keys;
   private final int num_keys_total;

   public final long getHandle() {
      return this.device.getHandle();
   }

   public RawKeyboardInfo(RawDevice var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      this.device = var1;
      this.type = var2;
      this.sub_type = var3;
      this.keyboard_mode = var4;
      this.num_function_keys = var5;
      this.num_indicators = var6;
      this.num_keys_total = var7;
   }

   public final int getUsagePage() {
      return 1;
   }

   public final Controller createControllerFromDevice(RawDevice var1, SetupAPIDevice var2) throws IOException {
      return new RawKeyboard(var2.getName(), var1, new Controller[0], new Rumbler[0]);
   }

   public final int getUsage() {
      return 6;
   }
}
