package net.java.games.input;

import java.io.IOException;

final class DIAbstractController extends AbstractController {
   private final IDirectInputDevice device;
   private final Controller.Type type;

   public final void pollDevice() throws IOException {
      this.device.pollAll();
   }

   protected final void setDeviceEventQueueSize(int var1) throws IOException {
      this.device.setBufferSize(var1);
   }

   protected DIAbstractController(IDirectInputDevice var1, Component[] var2, Controller[] var3, Rumbler[] var4, Controller.Type var5) {
      super(var1.getProductName(), var2, var3, var4);
      this.device = var1;
      this.type = var5;
   }

   public final Controller.Type getType() {
      return this.type;
   }

   protected final boolean getNextDeviceEvent(Event var1) throws IOException {
      return DIControllers.getNextDeviceEvent(var1, this.device);
   }
}
