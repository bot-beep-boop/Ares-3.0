package net.java.games.input;

import java.io.IOException;

final class LinuxAbstractController extends AbstractController {
   private final Controller.PortType port;
   private final Controller.Type type;
   private final LinuxEventDevice device;

   protected final boolean getNextDeviceEvent(Event var1) throws IOException {
      return LinuxControllers.getNextDeviceEvent(var1, this.device);
   }

   public Controller.Type getType() {
      return this.type;
   }

   public final void pollDevice() throws IOException {
      this.device.pollKeyStates();
   }

   public final Controller.PortType getPortType() {
      return this.port;
   }

   protected LinuxAbstractController(LinuxEventDevice var1, Component[] var2, Controller[] var3, Rumbler[] var4, Controller.Type var5) throws IOException {
      super(var1.getName(), var2, var3, var4);
      this.device = var1;
      this.port = var1.getPortType();
      this.type = var5;
   }
}
