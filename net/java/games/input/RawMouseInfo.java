package net.java.games.input;

import java.io.IOException;

class RawMouseInfo extends RawDeviceInfo {
   private final int num_buttons;
   private final int sample_rate;
   private final int id;
   private final RawDevice device;

   public final long getHandle() {
      return this.device.getHandle();
   }

   public final int getUsage() {
      return 2;
   }

   public final Controller createControllerFromDevice(RawDevice var1, SetupAPIDevice var2) throws IOException {
      if (this.num_buttons == 0) {
         return null;
      } else {
         Component[] var3 = new Component[3 + this.num_buttons];
         byte var4 = 0;
         int var7 = var4 + 1;
         var3[var4] = new RawMouse.Axis(var1, Component.Identifier.Axis.X);
         var3[var7++] = new RawMouse.Axis(var1, Component.Identifier.Axis.Y);
         var3[var7++] = new RawMouse.Axis(var1, Component.Identifier.Axis.Z);

         for(int var5 = 0; var5 < this.num_buttons; ++var5) {
            Component.Identifier.Button var6 = DIIdentifierMap.mapMouseButtonIdentifier(DIIdentifierMap.getButtonIdentifier(var5));
            var3[var7++] = new RawMouse.Button(var1, var6, var5);
         }

         RawMouse var8 = new RawMouse(var2.getName(), var1, var3, new Controller[0], new Rumbler[0]);
         return var8;
      }
   }

   public final int getUsagePage() {
      return 1;
   }

   public RawMouseInfo(RawDevice var1, int var2, int var3, int var4) {
      this.device = var1;
      this.id = var2;
      this.num_buttons = var3;
      this.sample_rate = var4;
   }
}
