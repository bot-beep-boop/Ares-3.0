package net.java.games.input;

import java.io.IOException;

final class LinuxPOV extends LinuxComponent {
   private final LinuxEventComponent component_y;
   private float last_y;
   private final LinuxEventComponent component_x;
   private float last_x;

   protected final float poll() throws IOException {
      this.last_x = LinuxControllers.poll(this.component_x);
      this.last_y = LinuxControllers.poll(this.component_y);
      return this.convertValue(0.0F, (LinuxAxisDescriptor)null);
   }

   public float convertValue(float var1, LinuxAxisDescriptor var2) {
      if (var2 == this.component_x.getDescriptor()) {
         this.last_x = var1;
      }

      if (var2 == this.component_y.getDescriptor()) {
         this.last_y = var1;
      }

      if (this.last_x == -1.0F && this.last_y == -1.0F) {
         return 0.125F;
      } else if (this.last_x == -1.0F && this.last_y == 0.0F) {
         return 1.0F;
      } else if (this.last_x == -1.0F && this.last_y == 1.0F) {
         return 0.875F;
      } else if (this.last_x == 0.0F && this.last_y == -1.0F) {
         return 0.25F;
      } else if (this.last_x == 0.0F && this.last_y == 0.0F) {
         return 0.0F;
      } else if (this.last_x == 0.0F && this.last_y == 1.0F) {
         return 0.75F;
      } else if (this.last_x == 1.0F && this.last_y == -1.0F) {
         return 0.375F;
      } else if (this.last_x == 1.0F && this.last_y == 0.0F) {
         return 0.5F;
      } else if (this.last_x == 1.0F && this.last_y == 1.0F) {
         return 0.625F;
      } else {
         LinuxEnvironmentPlugin.logln("Unknown values x = " + this.last_x + " | y = " + this.last_y);
         return 0.0F;
      }
   }

   public LinuxPOV(LinuxEventComponent var1, LinuxEventComponent var2) {
      super(var1);
      this.component_x = var1;
      this.component_y = var2;
   }
}
