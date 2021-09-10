package net.java.games.input;

public class LinuxJoystickPOV extends LinuxJoystickAxis {
   private LinuxJoystickAxis hatX;
   private LinuxJoystickAxis hatY;

   protected void updateValue() {
      float var1 = this.hatX.getPollData();
      float var2 = this.hatY.getPollData();
      this.resetHasPolled();
      if (var1 == -1.0F && var2 == -1.0F) {
         this.setValue(0.125F);
      } else if (var1 == -1.0F && var2 == 0.0F) {
         this.setValue(1.0F);
      } else if (var1 == -1.0F && var2 == 1.0F) {
         this.setValue(0.875F);
      } else if (var1 == 0.0F && var2 == -1.0F) {
         this.setValue(0.25F);
      } else if (var1 == 0.0F && var2 == 0.0F) {
         this.setValue(0.0F);
      } else if (var1 == 0.0F && var2 == 1.0F) {
         this.setValue(0.75F);
      } else if (var1 == 1.0F && var2 == -1.0F) {
         this.setValue(0.375F);
      } else if (var1 == 1.0F && var2 == 0.0F) {
         this.setValue(0.5F);
      } else if (var1 == 1.0F && var2 == 1.0F) {
         this.setValue(0.625F);
      } else {
         LinuxEnvironmentPlugin.logln("Unknown values x = " + var1 + " | y = " + var2);
         this.setValue(0.0F);
      }

   }

   LinuxJoystickPOV(Component.Identifier.Axis var1, LinuxJoystickAxis var2, LinuxJoystickAxis var3) {
      super(var1, false);
      this.hatX = var2;
      this.hatY = var3;
   }

   protected LinuxJoystickAxis getXAxis() {
      return this.hatX;
   }

   protected LinuxJoystickAxis getYAxis() {
      return this.hatY;
   }
}
