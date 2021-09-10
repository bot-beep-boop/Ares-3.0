package net.java.games.input;

import java.io.IOException;

final class LinuxMouse extends Mouse {
   private final LinuxEventDevice device;
   private final Controller.PortType port;

   public final Controller.PortType getPortType() {
      return this.port;
   }

   protected LinuxMouse(LinuxEventDevice var1, Component[] var2, Controller[] var3, Rumbler[] var4) throws IOException {
      super(var1.getName(), var2, var3, var4);
      this.device = var1;
      this.port = var1.getPortType();
   }

   public final void pollDevice() throws IOException {
      this.device.pollKeyStates();
   }

   protected final boolean getNextDeviceEvent(Event var1) throws IOException {
      return LinuxControllers.getNextDeviceEvent(var1, this.device);
   }
}
