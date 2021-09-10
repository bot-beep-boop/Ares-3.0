package net.java.games.input;

import java.io.IOException;

final class LinuxJoystickButton extends AbstractComponent {
   private float value;

   public LinuxJoystickButton(Component.Identifier var1) {
      super(var1.getName(), var1);
   }

   public final boolean isRelative() {
      return false;
   }

   protected final float poll() throws IOException {
      return this.value;
   }

   final void setValue(float var1) {
      this.value = var1;
   }
}
