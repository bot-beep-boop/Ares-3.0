package net.java.games.input;

import java.io.IOException;

final class OSXMouse extends Mouse {
   private final OSXHIDQueue queue;
   private final Controller.PortType port;

   protected final void setDeviceEventQueueSize(int var1) throws IOException {
      this.queue.setQueueDepth(var1);
   }

   protected final boolean getNextDeviceEvent(Event var1) throws IOException {
      return OSXControllers.getNextDeviceEvent(var1, this.queue);
   }

   public final Controller.PortType getPortType() {
      return this.port;
   }

   protected OSXMouse(OSXHIDDevice var1, OSXHIDQueue var2, Component[] var3, Controller[] var4, Rumbler[] var5) {
      super(var1.getProductName(), var3, var4, var5);
      this.queue = var2;
      this.port = var1.getPortType();
   }
}
