package net.java.games.input;

import java.io.IOException;

final class OSXAbstractController extends AbstractController {
   private final OSXHIDQueue queue;
   private final Controller.Type type;
   private final Controller.PortType port;

   public final Controller.PortType getPortType() {
      return this.port;
   }

   public Controller.Type getType() {
      return this.type;
   }

   protected OSXAbstractController(OSXHIDDevice var1, OSXHIDQueue var2, Component[] var3, Controller[] var4, Rumbler[] var5, Controller.Type var6) {
      super(var1.getProductName(), var3, var4, var5);
      this.queue = var2;
      this.type = var6;
      this.port = var1.getPortType();
   }

   protected final void setDeviceEventQueueSize(int var1) throws IOException {
      this.queue.setQueueDepth(var1);
   }

   protected final boolean getNextDeviceEvent(Event var1) throws IOException {
      return OSXControllers.getNextDeviceEvent(var1, this.queue);
   }
}
