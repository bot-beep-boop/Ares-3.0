package net.java.games.input;

import java.io.IOException;

class LinuxJoystickAxis extends AbstractComponent {
   private boolean analog;
   private float value;

   public LinuxJoystickAxis(Component.Identifier.Axis var1, boolean var2) {
      super(var1.getName(), var1);
      this.analog = var2;
   }

   final void setValue(float var1) {
      this.value = var1;
      this.resetHasPolled();
   }

   public LinuxJoystickAxis(Component.Identifier.Axis var1) {
      this(var1, true);
   }

   public final boolean isAnalog() {
      return this.analog;
   }

   protected final float poll() throws IOException {
      return this.value;
   }

   public final boolean isRelative() {
      return false;
   }
}
