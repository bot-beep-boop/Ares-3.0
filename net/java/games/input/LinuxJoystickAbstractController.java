package net.java.games.input;

import java.io.IOException;

final class LinuxJoystickAbstractController extends AbstractController {
   private final LinuxJoystickDevice device;

   protected final void setDeviceEventQueueSize(int var1) throws IOException {
      this.device.setBufferSize(var1);
   }

   public Controller.Type getType() {
      return Controller.Type.STICK;
   }

   public final void pollDevice() throws IOException {
      this.device.poll();
   }

   protected LinuxJoystickAbstractController(LinuxJoystickDevice var1, Component[] var2, Controller[] var3, Rumbler[] var4) {
      super(var1.getName(), var2, var3, var4);
      this.device = var1;
   }

   protected final boolean getNextDeviceEvent(Event var1) throws IOException {
      return this.device.getNextEvent(var1);
   }
}
