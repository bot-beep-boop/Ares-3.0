package net.java.games.input;

final class SetupAPIDevice {
   private final String device_instance_id;
   private final String device_name;

   public SetupAPIDevice(String var1, String var2) {
      this.device_instance_id = var1;
      this.device_name = var2;
   }

   public final String getInstanceId() {
      return this.device_instance_id;
   }

   public final String getName() {
      return this.device_name;
   }
}
