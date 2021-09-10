package net.java.games.input;

import java.io.IOException;

final class DIMouse extends Mouse {
   private final IDirectInputDevice device;

   protected final void setDeviceEventQueueSize(int var1) throws IOException {
      this.device.setBufferSize(var1);
   }

   public final void pollDevice() throws IOException {
      this.device.pollAll();
   }

   protected final boolean getNextDeviceEvent(Event var1) throws IOException {
      return DIControllers.getNextDeviceEvent(var1, this.device);
   }

   protected DIMouse(IDirectInputDevice var1, Component[] var2, Controller[] var3, Rumbler[] var4) {
      super(var1.getProductName(), var2, var3, var4);
      this.device = var1;
   }
}
