package net.java.games.input;

import java.io.IOException;

public class LinuxCombinedController extends AbstractController {
   private LinuxJoystickAbstractController joystickController;
   private LinuxAbstractController eventController;

   LinuxCombinedController(LinuxAbstractController var1, LinuxJoystickAbstractController var2) {
      super(var1.getName(), var2.getComponents(), var1.getControllers(), var1.getRumblers());
      this.eventController = var1;
      this.joystickController = var2;
   }

   public final Controller.PortType getPortType() {
      return this.eventController.getPortType();
   }

   public Controller.Type getType() {
      return this.eventController.getType();
   }

   public final void pollDevice() throws IOException {
      this.eventController.pollDevice();
      this.joystickController.pollDevice();
   }

   protected boolean getNextDeviceEvent(Event var1) throws IOException {
      return this.joystickController.getNextDeviceEvent(var1);
   }
}
