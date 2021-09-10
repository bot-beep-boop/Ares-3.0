package net.java.games.input;

import java.io.IOException;

final class DIKeyboard extends Keyboard {
   private final IDirectInputDevice device;

   protected final void setDeviceEventQueueSize(int var1) throws IOException {
      this.device.setBufferSize(var1);
   }

   protected final boolean getNextDeviceEvent(Event var1) throws IOException {
      return DIControllers.getNextDeviceEvent(var1, this.device);
   }

   public final void pollDevice() throws IOException {
      this.device.pollAll();
   }

   protected DIKeyboard(IDirectInputDevice var1, Component[] var2, Controller[] var3, Rumbler[] var4) {
      super(var1.getProductName(), var2, var3, var4);
      this.device = var1;
   }
}
