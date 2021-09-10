package net.java.games.input;

import java.io.IOException;

class LinuxComponent extends AbstractComponent {
   private final LinuxEventComponent component;

   public final LinuxEventComponent getComponent() {
      return this.component;
   }

   public final boolean isAnalog() {
      return this.component.isAnalog();
   }

   public LinuxComponent(LinuxEventComponent var1) {
      super(var1.getIdentifier().getName(), var1.getIdentifier());
      this.component = var1;
   }

   public final float getDeadZone() {
      return this.component.getDeadZone();
   }

   float convertValue(float var1, LinuxAxisDescriptor var2) {
      return this.getComponent().convertValue(var1);
   }

   public final boolean isRelative() {
      return this.component.isRelative();
   }

   protected float poll() throws IOException {
      return this.convertValue(LinuxControllers.poll(this.component), this.component.getDescriptor());
   }
}
