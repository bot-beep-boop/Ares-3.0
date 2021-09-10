package net.java.games.input;

import java.io.IOException;

final class DIComponent extends AbstractComponent {
   private final DIDeviceObject object;

   public final DIDeviceObject getDeviceObject() {
      return this.object;
   }

   protected final float poll() throws IOException {
      return DIControllers.poll(this, this.object);
   }

   public final boolean isAnalog() {
      return this.object.isAnalog();
   }

   public DIComponent(Component.Identifier var1, DIDeviceObject var2) {
      super(var2.getName(), var1);
      this.object = var2;
   }

   public final float getDeadZone() {
      return this.object.getDeadzone();
   }

   public final boolean isRelative() {
      return this.object.isRelative();
   }
}
